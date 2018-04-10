package com.example.awesomefat.dungeonsanddatastructures;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    private TextView nametv;
    private TextView descriptionTV;
    private TextView charactersTVs;

    private Button northButton;
    private Button southButton;
    private Button eastButton;
    private Button westButton;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.northButton = (Button)this.findViewById(R.id.northButton);
        this.southButton = (Button)this.findViewById(R.id.southButton);
        this.eastButton = (Button)this.findViewById(R.id.eastButton);
        this.westButton = (Button)this.findViewById(R.id.eastButton);
        this.nametv = this.findViewById(R.id.nametv);
        this.descriptionTV = this.findViewById(R.id.descriptionTV);
        this.charactersTVs = this.findViewById(R.id.charactersTVs);

        this.buildDungeon();
    }

    private void buildDungeon()
    {
        Player p = new Player("Mike");
        Room s120 = new Room("S120", "S120 Classroom");

        this.nametv = nametv.setText((TextView)s120.getName());
        this.descriptionTV = descriptionTV.setText(s120.getDescription());
        this.charactersTVs = charactersTVs.setText(s120.getNpcs());

        Room csHallway = new Room("CS Hallway", "The CS Hallway");
        Exit s120_csHallway = new Exit(s120, csHallway);

        s120.addPlayer(p);

        s120.addExit("north", s120_csHallway);
        //this.northButton
        csHallway.addExit("south", s120_csHallway);
        s120.takeExit("north");
        s120.takeExit("west");
        csHallway.takeExit("south");
        s120.displayRooms();


    }
}
