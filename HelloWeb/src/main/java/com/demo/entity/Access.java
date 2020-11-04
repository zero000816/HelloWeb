package com.demo.entity;

import java.util.Objects;

public class Access {
    int aid;
    String name;
    int level;
    int status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Access(int aid, String name, int level, int status) {
        this.aid = aid;
        this.name = name;
        this.level = level;
        this.status = status;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }



    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }


    public int getAidId() {
        return aid;
    }

    public void setId(int id) {
        this.aid = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Access access = (Access) o;
        return name.equals(access.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
