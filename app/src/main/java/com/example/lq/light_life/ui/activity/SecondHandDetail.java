package com.example.lq.light_life.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lq.light_life.R;

public class SecondHandDetail extends AppCompatActivity {

    public static final String MESSAGE_NAME = "messsage_name";
    public static final String MESSAGE_IMAGE_ID = "messsage_image_id";
    public static final String MESSAGE_PNAME_TEXT= "messsage_pname_text";
    public static final String MESSAGE_PHONE_TEXT= "messsage_phone_text";
    public static final String MESSAGE_TNAME_TEXT = "messsage_tname_text";

    ImageView messageImageView;
    TextView messagePnameText ;
    TextView messagePhoneText;
    TextView messageTnameText;

    String messageName;
    String messagePname;
    String messagePhone;
    String messageTname;
    int messageImageId ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_hand_detail);
        Intent intent = getIntent();
        messageName =intent.getStringExtra(MESSAGE_NAME);
        messageImageId = intent.getIntExtra(MESSAGE_IMAGE_ID, 0);
        messagePname= intent.getStringExtra(MESSAGE_PNAME_TEXT);
        messagePhone= intent.getStringExtra(MESSAGE_PHONE_TEXT);
        messageTname= intent.getStringExtra(MESSAGE_TNAME_TEXT);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        messageImageView = (ImageView) findViewById(R.id.message_image_view);
        Glide.with(this).load(messageImageId).into(messageImageView);
        messagePnameText = (TextView) findViewById(R.id.message_pname_text);
        messagePhoneText = (TextView) findViewById(R.id.message_phone_text);
        messageTnameText = (TextView) findViewById(R.id.message_tname_text);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar !=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbar.setTitle(messageName);
        messagePnameText.setText(messagePname);
        messagePhoneText.setText(messagePhone);
        messageTnameText.setText(messageTname);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android .R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
