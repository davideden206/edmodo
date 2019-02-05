package android.course.edmodo_203898309_305186108.gruops;

import android.app.Fragment;
import android.content.Intent;
import android.course.edmodo_203898309_305186108.R;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class gropesActiviti extends AppCompatActivity {
    TextView tvNameClass;
    Button btuSetting;
    private BottomNavigationView groupNav;
    private groupFeedFragment groupFeedFragment;
    private groupFrendeFragment groupFrendeFragment;
    private SmallGroupesFragment smallGroupesFragment;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gropes_activiti);
        tvNameClass = (TextView)findViewById(R.id.tvClassName);
        final Intent intent = getIntent();
        String className = intent.getStringExtra("nameClass");


        groupNav = (BottomNavigationView) this.findViewById(R.id.main_group);

        groupFrendeFragment = new groupFrendeFragment();
        groupFeedFragment = new groupFeedFragment();
        smallGroupesFragment = new SmallGroupesFragment();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setFregmentClasses(groupFeedFragment);

        groupNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {


            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.feed:
                        setFregmentClasses(groupFeedFragment);
                        return true;
                    case R.id.frends:
                        setFregmentClasses(groupFrendeFragment);
                        return true;

                    default:
                        return false;
                }
            }
        });

    getSupportActionBar().setTitle(className);





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.group_setting_menu, menu);
        return true;
    }

    public void setFregmentClasses(Fragment fragment) {
        android.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.freg_groups, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


    public void toClasses_seting(MenuItem item) {
        Intent i = new Intent(gropesActiviti.this,ClassesSetingActivity.class );
        startActivity(i);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
