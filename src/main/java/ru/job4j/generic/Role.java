package ru.job4j.generic;

public class Role extends Base {

    private final String roles;

    public Role(String id, String name) {
        super(id);
        this.roles = name;
    }

    public String getRoles() {
        return roles;
    }
}
