package com.charlesdrews.usabilitytestinglab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
        implements ListFragment.OnZodiacSignSelectedListener {

    private boolean isTabScreen = false;
    private DetailFragment mDetailFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // this class - MainActivity - implements the OnZodiacSignSelectedListener interface
        // defined in ListFragment - so "this" can be set as the listener for the list fragment
        ListFragment listFragment = (ListFragment) getSupportFragmentManager().findFragmentById(R.id.list_fragment);
        listFragment.setListener(this);

        DetailFragment detailFragment = (DetailFragment)getSupportFragmentManager().findFragmentById(R.id.detail_fragment_container);


        //if layout has "mainactivity_xlarge" or "mainactivity_large" tags, we know a tablet layout was chosen
        if(findViewById(R.id.detail_fragment_container).getTag().equals("mainactivity_large") ||
                findViewById(R.id.detail_fragment_container).equals("mainactivity_xlarge")){
            isTabScreen = true;
        }
        else isTabScreen = false;

    }

    @Override
    public void onZodiacSignSelected(String zodiacSignSelected) {

        if(isTabScreen){
            DetailFragment tabletFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.detail_fragment_container);
            tabletFragment.updateWebView(zodiacSignSelected);
        }
        else {
            //if it's a phone do this
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.SIGN_KEY, zodiacSignSelected);
            startActivity(intent);
        }
        // depending on the screensize, launch the fragment in this activity or the detailactivity



        //TODO - if the detail fragment is loaded into MainActivity, update it rather than launching
        //TODO      the DetailActivity
    }
}
