package zap.techmais.com.whatsappclone;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

import zap.techmais.com.whatsappclone.adapttab.TabAdapt;
import zap.techmais.com.whatsappclone.helper.ReferenciaDBFireBase;
import zap.techmais.com.whatsappclone.helper.SlidingTabLayout;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private  FirebaseAuth authMain;
    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar_id);
        slidingTabLayout = findViewById(R.id.stl_id);
        viewPager = findViewById(R.id.vp_id);

        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setSelectedIndicatorColors(ContextCompat.getColor(this,R.color.colorPrimaryDark));


        toolbar.setTitle("ZAPZAp");
     setSupportActionBar(toolbar);

        TabAdapt tabAdapt = new TabAdapt(getSupportFragmentManager());

        viewPager.setAdapter(tabAdapt);
        slidingTabLayout.setViewPager(viewPager);









    }//cleate



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return  true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.sair_id:
            deslogarUser();
            return true;


        default:
            return super.onOptionsItemSelected(item);


        }//switch


    }//itemSelect


    private void irLogar(){
        Intent intentLogar = new Intent(MainActivity.this, LoginActivity.class);

        startActivity(intentLogar);


    }


    public void deslogarUser(){
        authMain = ReferenciaDBFireBase.getFirebaseAuth();
        authMain.signOut();
        irLogar();
    }//deslogUSer






}//FP
