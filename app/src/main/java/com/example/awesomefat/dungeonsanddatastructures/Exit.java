package com.example.awesomefat.dungeonsanddatastructures;

/**
 * Created by awesomefat on 3/29/18.
 */

public class Exit
{
    private Room r1;
    private Room r2;

    public Exit(Room r1, Room r2)
    {
        this.r1 = r1;
        this.r2 = r2;
    }

    public boolean takeExit(Player p)
    {
        //make the player move to the room they are NOT currently in.
        if(p.getCurrentRoom() == this.r1)
        {
            this.r1.removePlayer(p);
            this.r2.addPlayer(p);
            return true;
        }
        else if(p.getCurrentRoom() == this.r2)
        {
            this.r2.removePlayer(p);
            this.r1.addPlayer(p);
            return true;
        }
        return false;
    }
}