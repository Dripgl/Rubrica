package Model;

import com.opencsv.bean.CsvBindByPosition;

public class User implements EntityWrapper {

    @CsvBindByPosition(position = 0)
    private String username;

    @CsvBindByPosition( position = 1)
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(){

    }

    @Override
    public String toString(){
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername(){ return username; }

    public void setUsername(String username) {this.username = username; }

    public String getPassword(){ return password; }

    public void setPassword(String password) {this.password = password; }
}
