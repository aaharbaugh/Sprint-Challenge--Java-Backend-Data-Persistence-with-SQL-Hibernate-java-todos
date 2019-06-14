package com.lambdaschool.todo;

import com.lambdaschool.todo.models.Role;
import com.lambdaschool.todo.models.ToDo;
import com.lambdaschool.todo.models.User;
import com.lambdaschool.todo.models.UserRoles;
import com.lambdaschool.todo.repository.RoleRepository;
import com.lambdaschool.todo.repository.ToDoRepository;
import com.lambdaschool.todo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
@Component
public class SeedData implements CommandLineRunner {
    RoleRepository rolerepos;
    UserRepository userrepos;
    ToDoRepository todorepos;

    public SeedData(RoleRepository rolerepos, UserRepository userrepos, ToDoRepository todorepos) {
        this.rolerepos = rolerepos;
        this.userrepos = userrepos;
        this.todorepos = todorepos;
    }

    @Override
    public void run(String[] args) throws Exception {
        Role r1 = new Role("admin");
        Role r2 = new Role("user");

        ArrayList<UserRoles> admins = new ArrayList<>();
        admins.add(new UserRoles(new User(), r1));
        admins.add(new UserRoles(new User(), r2));

        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));

        rolerepos.save(r1);
        rolerepos.save(r2);

        User u1 = new User("barnbarn", "ILuvM4th!", users);
        User u2 = new User("admin", "password", admins);

        // the date and time string should get coverted to a datetime Java data type. This is done in the constructor!
        u1.getToDos().add(new ToDo("Finish java-orders-swagger", false,  u1));
        u1.getToDos().add(new ToDo("Feed the turtles", false, u1));
        u1.getToDos().add(new ToDo("Complete the sprint challenge", false, u1));

        u2.getToDos().add(new ToDo("Walk the dogs", false, u2));
        u2.getToDos().add(new ToDo("provide feedback to my instructor", false, u2));

        userrepos.save(u1);
        userrepos.save(u2);
    }
}
