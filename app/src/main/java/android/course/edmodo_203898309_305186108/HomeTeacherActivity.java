package android.course.edmodo_203898309_305186108;

import android.course.edmodo_203898309_305186108.Fclasses.LatestActivityFragment;
import android.course.edmodo_203898309_305186108.Fclasses.MyClassesFragment;
import android.course.edmodo_203898309_305186108.Fmessages.MessagesFragment;
import android.course.edmodo_203898309_305186108.More.MoreTeacherFragment;
import android.course.edmodo_203898309_305186108.Notification.NotificationsFragment;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class HomeTeacherActivity extends AppCompatActivity {
    private BottomNavigationView mTeacherMainNav;
    private MyClassesFragment myClassesFragment;
    private LatestActivityFragment latestActivityFragment;
    private MessagesFragment messagesFragment;
    private NotificationsFragment notificationsFragment;
    private MoreTeacherFragment moreTeacherFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_teacher);


        mTeacherMainNav = (BottomNavigationView)findViewById(R.id.main_navTecher);
        latestActivityFragment = new LatestActivityFragment();
        messagesFragment = new MessagesFragment();
        notificationsFragment = new NotificationsFragment();
        moreTeacherFragment = new MoreTeacherFragment();
        myClassesFragment = new MyClassesFragment();
        setFregment(latestActivityFragment);
        getSupportActionBar().setTitle(R.string.stream);

        mTeacherMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.stream:
                        getSupportActionBar().setTitle(R.string.stream);
                        getSupportActionBar().setDisplayShowCustomEnabled(false);
                        setFregment(latestActivityFragment);
                        return true;

                    case R.id.classesid:
                        getSupportActionBar().setDisplayShowCustomEnabled(false);
                        getSupportActionBar().setTitle(R.string.classes);
                        setFregment(myClassesFragment);
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
                        setFregment(moreTeacherFragment);
                        return true;

                    default :
                        return false;
                }
            }
        });

    }

    private void setFregment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frameTeacher, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);

    }


}
