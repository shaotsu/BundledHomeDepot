package com.muhammadkunjo.bundled.DS;

public class User {

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNumofBundles() {
        return numofBundles;
    }

    public void setNumofBundles(int numofBundles) {
        this.numofBundles = numofBundles;
    }

    private String email;
    private String username;
    private String password;
    private int numofBundles;

    public User(){
    }
    public User(String _email, String _username, String _password, int _numofBundles){
        this.email = _email;
        this.username = _username;
        this.password = _password;
        this.numofBundles = _numofBundles;
    }
    public User(String _email, String _username, String _password){
        _email = email;
        _username = username;
        _password = password;
    }
}
