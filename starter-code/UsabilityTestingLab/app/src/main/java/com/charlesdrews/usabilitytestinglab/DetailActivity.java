package com.charlesdrews.usabilitytestinglab;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {
    public static final String SIGN_KEY = "sign_key";

    private DetailFragment mDetailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String selectedSign = getIntent().getStringExtra(SIGN_KEY);

        if (selectedSign != null) {
            DetailFragment detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.detail_fragment);;
            detailFragment.updateWebView(selectedSign);

        }
    }
}
