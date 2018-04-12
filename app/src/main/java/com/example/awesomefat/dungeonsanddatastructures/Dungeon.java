package com.example.awesomefat.dungeonsanddatastructures;

import java.util.LinkedList;

public class Dungeon
{
    private Room startRoom;
    private LinkedList<Room> roomCollection;
    private String name;

    public Dungeon(String name)
    {
        this.name = name;
        this.startRoom = null;
        this.roomCollection = new LinkedList<Room>();
    }

    public Dungeon(String name, Room startRoom)
    {
        this(name);
        this.startRoom = startRoom;
        this.roomCollection.add(this.startRoom);
    }

    public void addRoom(Room r)
    {
        this.roomCollection.add(r);
    }

    public void addPlayer(Player p)
    {
        this.startRoom.addPlayer(p);
    }
}