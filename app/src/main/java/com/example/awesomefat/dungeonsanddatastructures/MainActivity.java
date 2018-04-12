package com.example.awesomefat.dungeonsanddatastructures;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity
{
    private TextView nameTV;
    private TextView descriptionTV;
    private ViewGroup alsoHereViewGroup;
    private Button northButton;
    private Button southButton;
    private Button westButton;
    private Button eastButton;

    private Player p;
    private Dungeon csDept;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.nameTV = (TextView)this.findViewById(R.id.nameTV);
        this.descriptionTV = (TextView)this.findViewById(R.id.descriptionTV);
        this.alsoHereViewGroup = (ViewGroup)this.findViewById(R.id.alsoHereViewGroup);
        this.northButton = (Button)this.findViewById(R.id.northButton);
        this.southButton = (Button)this.findViewById(R.id.southButton);
        this.eastButton = (Button)this.findViewById(R.id.eastButton);
        this.westButton = (Button)this.findViewById(R.id.westButton);


        p = new Player("Mike");
        this.buildDungeon();
        this.csDept.addPlayer(p);
        this.fillInterface(p.getCurrentRoom());
    }

    //buttons are already only visible if an exit is available to take
    public void northButtonPressed(View v)
    {
        this.fillInterface(p.getCurrentRoom.takeExit("north"));
    }

    public void southButtonPressed(View v)
    {
        this.fillInterface(p.getCurrentRoom.takeExit("south"));
    }

    public void eastButtonPressed(View v)
    {
        this.fillInterface(p.getCurrentRoom.takeExit("east"));
    }

    public void westButtonPressed(View v)
    {
        this.fillInterface(p.getCurrentRoom.takeExit("west"));
    }

    private void buildDungeon()
    {
        Room s120 = new Room("S120", "S120 Classroom");
        Room csHallway = new Room("CS Hallway", "The CS Hallway");
        this.csDept = new Dungeon("CS Department", csHallway);

        //Linking rooms through exits
        Exit s120_csHallway = new Exit(s120, csHallway);
        s120.addExit("north", s120_csHallway);
        csHallway.addExit("south", s120_csHallway);
    }

    private void fillInterface(Room r)
    {
        //fill interface for S120
        this.nameTV.setText(r.getName());
        this.descriptionTV.setText(r.getDescription());

        //fill the also here view group
        this.alsoHereViewGroup.removeAllViews();
        TextView playersLabel = new TextView(this);
        playersLabel.setText("Players:");
        playersLabel.setTypeface(null, Typeface.BOLD);
        this.alsoHereViewGroup.addView(playersLabel);
        TextView temp;
        for(Player player : r.getPlayers())
        {
            temp = new TextView(this);
            temp.setText("     " + player.getName());
            this.alsoHereViewGroup.addView(temp);
        }

        TextView npcLabel = new TextView(this);
        npcLabel.setText("NPCs:");
        npcLabel.setTypeface(null, Typeface.BOLD);
        this.alsoHereViewGroup.addView(npcLabel);
        for(NPC npc : r.getNpcs())
        {
            temp = new TextView(this);
            temp.setText("     " + npc.getName());
            this.alsoHereViewGroup.addView(temp);
        }

        this.northButton.setVisibility(View.INVISIBLE);
        this.southButton.setVisibility(View.INVISIBLE);
        this.eastButton.setVisibility(View.INVISIBLE);
        this.westButton.setVisibility(View.INVISIBLE);

        //hide the appropriate buttons:
        if(r.getExits().containsKey("north"))
        {
            this.northButton.setVisibility(View.VISIBLE);
        }
        if(r.getExits().containsKey("south"))
        {
            this.southButton.setVisibility(View.VISIBLE);
        }
        if(r.getExits().containsKey("east"))
        {
            this.eastButton.setVisibility(View.VISIBLE);
        }
        if(r.getExits().containsKey("west"))
        {
            this.westButton.setVisibility(View.VISIBLE);
        }
    }
}