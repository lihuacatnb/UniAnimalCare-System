package com.backanimal.config;

public class Activity
{
    private String name;
    private String program;
    private String manager;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Acivity{" +
                "name='" + name + '\'' +
                ", program='" + program + '\'' +
                ", manager='" + manager + '\'' +
                '}';
    }
}
