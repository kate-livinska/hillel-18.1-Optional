package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1, "A", "a@email.com");
        User user2 = new User(2, "B", "b@email.com");
        User user3 = new User(3, "C", "c@email.com");
        User user4 = new User(4, "D", "d@email.com");
        User user5 = new User(5, "E", "e@email.com");

        List<User> userList = new ArrayList<User>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);

        UserRepository repository = new UserRepository(userList);

        Optional<User> userWithId4 = repository.findUserById(4);
        if(userWithId4.isPresent()) {
            User user = userWithId4.get();
            System.out.println(user.toString());
        }

        Optional<User> userWithEmail = repository.findUserByEmail("c@email.com");
        if(userWithEmail.isPresent()) {
            User user = userWithEmail.get();
            System.out.println(user.toString());
        }

        Optional<List<User>> allUsers = repository.findAllUsers();
        if(allUsers.isPresent()) {
            List<User> users = allUsers.get();
            System.out.println(users.size());
        }
    }
}
