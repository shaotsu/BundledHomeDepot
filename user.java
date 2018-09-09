public class user
{
    private String userID;
    private String email;
    private String username;
    private String password;
    private int numBundles;

    public user(String userID, String email, String username, String password, int numBundles) {
        this.userID = userID;
        this.email = email;
        this.username = username;
        this.password = password;
        this.numBundles = numBundles;
    }

    public user()
    {
        this.userID = "";
        this.email = "";
        this.username = "";
        this.password = "";
        this.numBundles = 0;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

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

    public int getNumBundles() {
        return numBundles;
    }

    public void setNumBundles(int numBundles) {
        this.numBundles = numBundles;
    }

    @Override
    public String toString() {
        return "user{" +
                "userID='" + userID + '\n'' +
                ", email='" + email + '\n'' +
                ", username='" + username + '\n'' +
                ", password='" + password + '\n'' +
                ", numBundles=" + numBundles +
                '}';
    }
}