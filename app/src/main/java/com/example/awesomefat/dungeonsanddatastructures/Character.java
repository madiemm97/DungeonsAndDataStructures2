package com.example.awesomefat.dungeonsanddatastructures;

public abstract class Character
{
    protected String name;
    protected Room currentRoom;

    public Character(String name)
    {
        this.name = name;
        this.currentRoom = null;
    }

    public void display()
    {
        System.out.println(this.name);
    }

    public String getName() {
        return name;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}