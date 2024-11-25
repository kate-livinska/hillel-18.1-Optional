package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private List<User> usersList = new ArrayList<>();

    public UserRepository(List<User> usersList) {
        this.usersList = usersList;
    }

    public Optional<User> findUserById(int id) {
        return usersList.stream()
                .filter(u -> u.getId() == id)
                .findFirst();
    }

    public Optional<User> findUserByEmail(String email) {
        return usersList.stream()
                .filter(u -> u.getEmail() == email)
                .findFirst();
    }

    public Optional<List<User>> findAllUsers() {
        return Optional.of(usersList);
    }
}
