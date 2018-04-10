package com.example.awesomefat.dungeonsanddatastructures;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedList;

/**
 * Created by awesomefat on 3/29/18.
 */

public class Room
{
    private LinkedList<Player> players;
    private LinkedList<NPC> npcs;
    private Hashtable<String, Exit> exits;
    private String description;
    private String name;

    public Room(String name, String description)
    {
        this.name = name;
        this.description = description;
        this.players = new LinkedList<Player>();
        this.npcs = new LinkedList<NPC>();
        this.exits = new Hashtable<String, Exit>();
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public LinkedList<NPC> getNpcs() {
        return npcs;
    }

    public void display()
    {
        System.out.println("Room Name: " + this.name);
        System.out.println("Description\n" + this.description);
        System.out.println("Also Here:");
        System.out.println("Players");
        for(Player p : this.players)
        {
            p.display();
        }

        System.out.println("NPCs");
        for(NPC n : this.npcs)
        {
            n.display();
        }

        System.out.println("Obvious Exits:");
        /*
        Enumeration<String> keys = this.exits.keys();
        while(keys.hasMoreElements())
        {
            System.out.println(keys.nextElement());
        }
        */

        System.out.println("Obvious Exits:");
        for(String keyName : this.exits.keySet())
        {
            System.out.println(keyName);
        }
    }

    //Exit Management
    synchronized  public void addExit(String direction, Exit e)
    {
        this.exits.put(direction, e);
    }

    public boolean takeExit(String direction)
    {
        Exit temp = this.exits.get(direction);
        if(temp != null)
        {
            return temp.takeExit(this.players.getFirst());
        }
        else
        {
            return false;
        }
    }

    //Player management
    synchronized private void players_PerformAction(String action, Object[] params)
    {
        if(action.equals("addPlayer"))
        {
            Player temp = (Player)params[0];
            this.players.add(temp);
            temp.setCurrentRoom(this);
        }
        else if(action.equals("removePlayer"))
        {
            Player temp = (Player)params[0];
            if(this.players.remove(temp))
            {
                temp.setCurrentRoom(null);
            }
        }
    }

    public void addPlayer(Player p)
    {
        Object[] params = {p};
        this.players_PerformAction("addPlayer", params);
    }

    public void removePlayer(Player p)
    {
        Object[] params = {p};
        this.players_PerformAction("removePlayer", params);
    }

    //NPC management
    synchronized private void npcs_PerformAction(String action, Object[] params)
    {
        if(action.equals("addNPC"))
        {
            NPC temp = (NPC)params[0];
            this.npcs.add(temp);
            temp.setCurrentRoom(this);
        }
        else if(action.equals("removeNPC"))
        {
            NPC temp = (NPC)params[0];
            if(this.npcs.remove(temp))
            {
                temp.setCurrentRoom(null);
            }
        }
    }

    public void addNPC(NPC n)
    {
        Object[] params = {n};
        this.npcs_PerformAction("addNPC", params);
    }

    public void removeNPC(NPC n)
    {
        Object[] params = {n};
        this.npcs_PerformAction("removeNPC", params);
    }
}


