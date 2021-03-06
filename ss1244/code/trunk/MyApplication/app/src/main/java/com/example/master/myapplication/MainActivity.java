package com.example.master.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private TheBoard theBoard;

     private intelligence intelligence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         theBoard = (TheBoard) findViewById(R.id.board);
          intelligence = new intelligence();
         theBoard.setIntelligence(intelligence);
        theBoard.setMainActivity(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

     getMenuInflater().inflate(R.menu.main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == R.id.action_new_game) {
            newGame();
        }

        return super.onOptionsItemSelected(item);
    }

    public void gameEnded(char c) {
        String msg = (c == 'T') ? "Game Over. draw" : "gameover. " + c + " win";

        new AlertDialog.Builder(this).setTitle("Tic Tac Toe").setMessage(msg).setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {

                    newGame();
                    }
                }).show();
    }

    private void newGame() {
        intelligence.reset();

           theBoard.invalidate();
    }


}