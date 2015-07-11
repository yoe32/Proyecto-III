package com.dejiitaru.bitchnel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.dejiitaru.bitchnel.login.FacebookLogin;
import com.dejiitaru.bitchnel.login.GoogleLogin;
import com.dejiitaru.bitchnel.restaurant.RestaurantProfileActivity;

public class TesterActivity extends Activity implements View.OnClickListener
{
    private Button btnHome;
    private Button btnRestaurant;
    private Button btnFacebok;
    private Button btnGoolge;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tester);

        btnHome = (Button) findViewById(R.id.btn_home);
        btnRestaurant = (Button) findViewById(R.id.btn_restaurant);
        btnFacebok = (Button) findViewById(R.id.btn_facebook);
        btnGoolge = (Button) findViewById(R.id.btn_google);

        btnHome.setOnClickListener(this);
        btnRestaurant.setOnClickListener(this);
        btnFacebok.setOnClickListener(this);
        btnGoolge.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {

            case R.id.btn_home:
                Intent homeIntent = new Intent(TesterActivity.this,MainActivity.class);
                startActivity(homeIntent);
                break;

            case R.id.btn_restaurant:
                Intent restIntent = new Intent(TesterActivity.this,RestaurantProfileActivity.class);
                startActivity(restIntent);
                break;

            case R.id.btn_facebook:
                Intent facebookIntent = new Intent(TesterActivity.this,FacebookLogin.class);
                startActivity(facebookIntent);
                break;

            case R.id.btn_google:
                Intent googleIntent = new Intent(TesterActivity.this,GoogleLogin.class);
                startActivity(googleIntent);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tester, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
