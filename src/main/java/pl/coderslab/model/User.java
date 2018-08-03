package pl.coderslab.model;

import pl.coderslab.utils.BCrypt;

public class User {

    private int id;
    private String username;
    private String email;
    private String password;

    public User(String username, String email, String password) {
        setUsername(username);
        setEmail(email);
        setPassword(password);
    }

    public User(int id, String username, String email, String password) {
        setId(id);
        setUsername(username);
        setEmail(email);
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }

}
