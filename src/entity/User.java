package entity;

import java.util.List;

public class User {
    private String name;
    private List<String> feriends;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getFeriends() {
        return feriends;
    }

    public void setFeriends(List<String> feriends) {
        this.feriends = feriends;
    }

    public User(String name, List<String> feriends) {
        this.name = name;
        this.feriends = feriends;
    }
}
