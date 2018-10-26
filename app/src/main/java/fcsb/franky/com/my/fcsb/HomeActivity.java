package fcsb.franky.com.my.fcsb;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import utility.FragmentUtility;


public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FirebaseAuth auth;
    FirebaseUser user;

    CircleImageView profilePic;
    TextView displayName, emailText;

    View header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        toolbar.setTitle("FCSB");
        setSupportActionBar(toolbar);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView =  findViewById(R.id.nav_view);
        header = navigationView.getHeaderView(0);
        navigationView.setNavigationItemSelectedListener(this);

        if(user!=null){
            setUserProfile(user);
        }


        FragmentUtility.setFragment(this,R.id.home_fragment,new MainFragment());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
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

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

       Fragment fragment = null;

        switch (id) {

            case R.id.nav_home:
                fragment = new MainFragment();
                break;

            case R.id.nav_operating:
                fragment = new OperatingHourFragment();
                break;

            case R.id.nav_millage:
                fragment = new VehicleMillageFragment();
                break;

            case R.id.nav_sign_out:
                auth.signOut();
                startActivity(new Intent(this,LoginActivity.class));
                finish();
                break;

        }

        if(fragment!=null){
            FragmentUtility.setFragment(this,R.id.home_fragment,fragment);
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void setUserProfile(FirebaseUser user){

        profilePic = header.findViewById(R.id.icon_image);
        Picasso.get()
                .load(user.getPhotoUrl())
                .placeholder(R.drawable.ic_account_circle_black_156dp)
                .into(profilePic);

        displayName = header.findViewById(R.id.display_name);
        displayName.setText(user.getDisplayName());

        emailText = header.findViewById(R.id.email_text);
        emailText.setText(user.getEmail());
    }


}
