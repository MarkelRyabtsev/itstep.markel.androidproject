package com.example.markel.itstepandroidproject.Entities;

public class Tree {

    private String Name;
    private String Color;
    private Integer Height;

    public Tree(String name, String color, Integer height) {
        Name = name;
        Color = color;
        Height = height;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public Integer getHeight() {
        return Height;
    }

    public void setHeight(Integer height) {
        Height = height;
    }
}
