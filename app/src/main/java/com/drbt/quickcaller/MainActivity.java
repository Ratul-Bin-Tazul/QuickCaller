package com.drbt.quickcaller;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static int count = 0;
    public static final int id = 0;
    public static Long[] number = new Long[32];
    public static final String[] name = new String[32];

    EditText callerName;
    EditText callerNumber;
    RelativeLayout relativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent call = new Intent(Intent.ACTION_CALL);
        switch (id) {
            case 1:




                call.setData(Uri.parse("tel:"+number[id]));
                startActivity(call);
            case 2:
                call.setData(Uri.parse("tel:" + number[id]));
                startActivity(call);
            case 3:
                call.setData(Uri.parse("tel:" + number[id]));
                startActivity(call);


        }


        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

        callerName = (EditText)findViewById(R.id.name);
        callerNumber = (EditText)findViewById(R.id.number);


        relativeLayout = (RelativeLayout)findViewById(R.id.layout);

        Button btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        name[count] = callerName.getText().toString();
                        number[count] = Long.parseLong(callerNumber.getText().toString());

                        //addShortcut(count);

                        ShortcutIcon(name[count],count);

                        callerName.setText("");
                        callerNumber.setText("");

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            callerName.setShowSoftInputOnFocus(false);

                            callerNumber.setShowSoftInputOnFocus(false);
                        }



                        count++;
                    }
                }
        );
    }




/*    public void addShortcut(int i) {
        //Adding shortcut for MainActivity
        //on Home screen
        Intent shortcutIntent = new Intent(getApplicationContext(),
                MainActivity.class);

        shortcutIntent.setAction(Intent.ACTION_MAIN);

        Intent addIntent = new Intent();
        addIntent
                .putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, "HelloWorldShortcut"+i);
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE,
                Intent.ShortcutIconResource.fromContext(getApplicationContext(),
                        R.mipmap.ic_launcher));

        addIntent
                .setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        addIntent.putExtra("duplicate", false);  //may it's already there so don't duplicate
        getApplicationContext().sendBroadcast(addIntent);
    }
*/

    private void ShortcutIcon(String s,int i){

        Intent shortcutIntent = new Intent(this, caller1.class);
        //Intent shortcutIntent = new Intent(Intent.ACTION_CALL);
        //shortcutIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //shortcutIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //shortcutIntent.setAction("tel:"+"627676583");


        Intent addIntent = new Intent();
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, s);
        addIntent.putExtra("id",count);
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, Intent.ShortcutIconResource.fromContext(getApplicationContext(), R.mipmap.ic_launcher));
        addIntent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        //addIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, new Intent(Intent.ACTION_CALL));
        getApplicationContext().sendBroadcast(addIntent);


        Toast.makeText(this, "Shortcut Created", Toast.LENGTH_SHORT).show();
        //dumb();
    }

    public void dumb() {

        Bundle f = getIntent().getExtras();


        if(f==null)
            return;
        int g = f.getInt("id");
        Toast.makeText(this, "" + g, Toast.LENGTH_LONG).show();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}

