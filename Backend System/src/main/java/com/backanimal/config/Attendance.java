package com.backanimal.config;

public class Attendance
{
    private enum InOrOut {
        in, out
    };
    private String name;
    private String position;
    private InOrOut inorout;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public InOrOut getInorout() {
        return inorout;
    }

    public void setInorout(InOrOut inorout) {
        this.inorout = inorout;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", inorout=" + inorout +
                '}';
    }
}
