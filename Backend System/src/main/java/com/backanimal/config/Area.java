package com.backanimal.config;

public class Area {
    private String name;
    private String number;
    private String manager;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Area{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", manager='" + manager + '\'' +
                '}';
    }
}
