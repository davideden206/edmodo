package android.course.edmodo_203898309_305186108;

import android.course.edmodo_203898309_305186108.Fclasses.FregmentClasses;
import android.course.edmodo_203898309_305186108.Fclasses.UserPrfile;
import android.course.edmodo_203898309_305186108.Fmessages.MessagesFragment;
import android.course.edmodo_203898309_305186108.More.MoreFragment;
import android.course.edmodo_203898309_305186108.Notification.NotificationsFragment;
import android.course.edmodo_203898309_305186108.whatsDue.WhatsDueFragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;


public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView mMainNav;

    private FrameLayout mMainFrame;
    private MenuItem item;
    private FregmentClasses classesFregment;
    private WhatsDueFragment whatsDueFragment;
    private MessagesFragment messagesFragment;
    private NotificationsFragment notificationsFragment;
    private MoreFragment moreFragment;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


    mMainFrame = (FrameLayout) findViewById(R.id.main_frame);
    mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);
         item = (MenuItem) findViewById(R.id.plusButton);


    classesFregment = new FregmentClasses();
    whatsDueFragment = new WhatsDueFragment();
    messagesFragment = new MessagesFragment();
    notificationsFragment = new NotificationsFragment();
    moreFragment = new MoreFragment();

       //getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_TITLE);

        setFregment(classesFregment);




    mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch(menuItem.getItemId()){
                case R.id.classesid:
                    getSupportActionBar().setTitle(R.string.classes);
                    getSupportActionBar().setDisplayShowCustomEnabled(false);
                    setFregment(classesFregment);
                    return true;

                case R.id.whats_Dueid:
                    getSupportActionBar().setDisplayShowCustomEnabled(false);
                    getSupportActionBar().setTitle(R.string.what_s_due);
                    setFregment(whatsDueFragment);
                    return true;

                case R.id.Messages:
                    getSupportActionBar().setDisplayShowCustomEnabled(true);
                    getSupportActionBar().setTitle(R.string.messages);
                    getSupportActionBar().setCustomView(R.layout.toolbar);
                    setFregment(messagesFragment);
                    return true;

                case R.id.Notification:
                    getSupportActionBar().setDisplayShowCustomEnabled(false);
                    getSupportActionBar().setTitle(R.string.notification);
                    setFregment(notificationsFragment);
                    return true;

                case R.id.More:
                    getSupportActionBar().setDisplayShowCustomEnabled(false);
                    getSupportActionBar().setTitle(R.string.more);
                    setFregment(moreFragment);
                    return true;

                default :
                    return false;
            }
        }
    });




}

    private void setFregment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);

    }


}
