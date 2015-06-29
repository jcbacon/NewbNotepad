package com.example.bacons.newbnotepad;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    ListView mainListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       //populateListView();
        registerClick();

        NoteItem note_data[] = new NoteItem[]
                {
                        new NoteItem(R.drawable.ic_action_edit, "Note 1"),
                        new NoteItem(R.drawable.ic_action_edit, "Note 2"),
                        new NoteItem(R.drawable.ic_action_edit, "Note 3"),
                        new NoteItem(R.drawable.ic_action_edit, "Note 4"),
                        new NoteItem(R.drawable.ic_action_edit, "Note 5")
                };

        NoteListAdapter adapter = new NoteListAdapter(this,
                R.layout.list_items_layout, note_data);


        mainListView = (ListView)findViewById(R.id.mainListView);

      //  View header = (View)getLayoutInflater().inflate(R.layout.listview_header_row, null);
       // mainListView.addHeaderView(header);

        mainListView.setAdapter(adapter);
    }







/*
    public void populateListView(){
        String [] myNotes = {"Note One","Note Two","Note Three"};
        mainListView = (ListView) findViewById(R.id.mainListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.list_items_layout, myNotes);
        mainListView.setAdapter(adapter);
        }
*/



    public void registerClick(){
        mainListView = (ListView) findViewById(R.id.mainListView);
        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener (){

            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                String test = "test";
                Toast.makeText(MainActivity.this, test, Toast.LENGTH_LONG).show();

            }
        });

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.menu_my, menu);
        //return true;

        // Inflate the menu; this adds items to the action bar if it is present
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actionbar, menu);
        return super.onCreateOptionsMenu(menu);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        Intent intent = new Intent(this,NewNoteActivity.class);
        startActivity(intent);


        return super.onOptionsItemSelected(item);
    }
}
