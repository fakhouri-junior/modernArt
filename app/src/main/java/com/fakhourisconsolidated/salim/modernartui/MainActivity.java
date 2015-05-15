package com.fakhourisconsolidated.salim.modernartui;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;


public class MainActivity extends Activity implements OnSeekBarChangeListener {


    SeekBar seekBar;
    View topleftView;
    View leftbottomView;
    View toprightView;
    View rightmiddleView;
    View rightbottomView;
    int red,green,blue;
    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // reference the views
        topleftView = (View) findViewById(R.id.topleftView);
        leftbottomView = (View) findViewById(R.id.leftbottomView);
        toprightView = (View) findViewById(R.id.toprightView);
        rightmiddleView = (View) findViewById(R.id.rightmiddleView);
        rightbottomView = (View) findViewById(R.id.rightbottomView);

        // reference the seekbar
        seekBar = (SeekBar) findViewById(R.id.seekbar);

        seekBar.setOnSeekBarChangeListener(this);
    }

    private void UpdateBackground(){
        red = seekBar.getProgress();
        green = seekBar.getProgress();
        blue = seekBar.getProgress();

        topleftView.setBackgroundColor(0xFFCC0000 +  green*0x100 + blue);

        leftbottomView.setBackgroundColor(0xFF0033CC + red*0x10000  + green*0x100);

        toprightView.setBackgroundColor(0xFFFFFFFF);

        rightmiddleView.setBackgroundColor(0xFF6600CC + red*0x10000 + green*0x100);

        rightbottomView.setBackgroundColor(0xFF0066FF + red*0x10000 + green*0x100);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.more_info) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        UpdateBackground();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        red = seekBar.getProgress();

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
    public void showDialog ( MenuItem item ) {

        new MoreInformationDialog().show( getFragmentManager(), TAG );
    }
}
