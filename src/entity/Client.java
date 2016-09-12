package entity;

import java.util.Date;

public class Client {
    private int Id;
    private String Sirname;
    private String Name;
    private String PatronymicName;
    private Date Birthday;
    private int AccountNumber;
    public Client(){}
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public String getSirname() {
        return Sirname;
    }
    public void setSirname(String sirname) {
        Sirname = sirname;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getPatronymicName() {
        return PatronymicName;
    }
    public void setPatronymicName(String patronymicName) {
        PatronymicName = patronymicName;
    }
    public Date getBirthday() {
        return Birthday;
    }
    public void setBirthday(Date birthday) {
        Birthday = birthday;
    }
    public int getAccountNumber() {
        return AccountNumber;
    }
    public void setAccountNumber(int accountNumber) {
        AccountNumber = accountNumber;
    }
}

