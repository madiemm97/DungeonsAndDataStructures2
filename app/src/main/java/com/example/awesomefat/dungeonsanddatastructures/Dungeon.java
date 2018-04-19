package com.example.awesomefat.dungeonsanddatastructures;

import java.util.ArrayList;
import java.util.LinkedList;

public class Dungeon
{
    public Room startRoom;
    public String name;
    public ArrayList<Exit> exits;
    public ArrayList<Room> rooms;
    public Dungeon(){}

    public Dungeon(String name)
    {
        this.name = name;
        this.startRoom = null;
    }

    public Dungeon(String name, Room startRoom)
    {
        this(name);
        this.startRoom = startRoom;
        this.rooms = new ArrayList<Room>();
        this.exits = new ArrayList<Exit>();
        this.rooms.add(startRoom);
    }

    public void addExit(Exit e)
    {
        this.exits.add(e);
    }

    public void addRoom(Room r)
    {
        this.rooms.add(r);
    }

    public void addPlayer(Player p)
    {
        this.startRoom.addPlayer(p);
    }

    public ArrayList<Exit> getExits() {
        return exits;
    }


}