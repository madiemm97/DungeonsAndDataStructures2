package com.example.awesomefat.dungeonsanddatastructures;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by awesomefat on 3/29/18.
 */

public class Room
{
    //public LinkedList<Player> players;
    //public LinkedList<NPC> npcs;
    public Map<String, Exit> exits;
    public String description;
    public String name;

    public Room() { }

    public Room(String name, String description)
    {
        this.name = name;
        this.description = description;
        //this.players = new LinkedList<Player>();
        //this.npcs = new LinkedList<NPC>();
        this.exits = new HashMap<String, Exit>();
    }

//
//    public LinkedList<Player> getPlayers() {
//        return players;
//    }
//
//    public LinkedList<NPC> getNpcs() {
//        return npcs;
//    }
//
//    public Hashtable<String, Exit> getExits() {
//        return exits;
//    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    //Exit Management
    synchronized  public void addExit(String direction, Exit e)
    {
        this.exits.put(direction, e);
    }

//    public boolean takeExit(String direction)
//    {
//        Exit temp = this.exits.get(direction);
//        if(temp != null)
//        {
//            return temp.takeExit(this.players.getFirst());
//        }
//        else
//        {
//            return false;
//        }
//    }

    //Player management
    synchronized private void players_PerformAction(String action, Object[] params)
    {
        if(action.equals("addPlayer"))
        {
            Player temp = (Player)params[0];
            //this.players.add(temp);
            temp.setCurrentRoom(this);
        }
        else if(action.equals("removePlayer"))
        {
            Player temp = (Player)params[0];
//            if(this.players.remove(temp))
//            {
//                temp.setCurrentRoom(null);
//            }
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
            //this.npcs.add(temp);
            temp.setCurrentRoom(this);
        }
        else if(action.equals("removeNPC"))
        {
            NPC temp = (NPC)params[0];
//            if(this.npcs.remove(temp))
//            {
//                temp.setCurrentRoom(null);
//            }
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