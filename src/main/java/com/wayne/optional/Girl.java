package com.wayne.optional;

/**
 * @author wayne
 * @date 2023-02-16 21:18
 */
public class Girl {
    private String name;


    public Girl() {
    }

    public Girl(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                '}';
    }
}
