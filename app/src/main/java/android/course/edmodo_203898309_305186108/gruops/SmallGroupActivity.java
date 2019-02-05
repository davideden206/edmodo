package android.course.edmodo_203898309_305186108.gruops;

import android.app.Fragment;
import android.content.Intent;
import android.course.edmodo_203898309_305186108.R;
import android.course.edmodo_203898309_305186108.TeacherGroup.ResourcesFragment;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SmallGroupActivity extends AppCompatActivity {

    TextView tvNameClass;
    Button btuSetting;
    private BottomNavigationView groupNav;
    private groupFeedFragment groupFeedFragment;
    private ResourcesFragment resourcesFragment;
    private groupFrendeFragment groupFrendeFragment;
    private SmallGroupesFragment smallGroupesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_small_group);

        tvNameClass = (TextView)findViewById(R.id.tvClassName);
        final Intent intent = getIntent();
        String className = intent.getStringExtra("nameClass");
        tvNameClass.setText(className);

        btuSetting = (Button)findViewById(R.id.ButSet);


        btuSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SmallGroupActivity.this,ClassesSetingActivity.class );
                startActivity(i);
            }
        });

        groupNav = (BottomNavigationView) this.findViewById(R.id.main_group);

        groupFrendeFragment = new groupFrendeFragment();
        groupFeedFragment = new groupFeedFragment();
        resourcesFragment = new ResourcesFragment();
        smallGroupesFragment = new SmallGroupesFragment();

        setFregmentClasses(groupFeedFragment);

        groupNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {


            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.smalfeed:
                        setFregmentClasses(groupFeedFragment);
                        return true;
                    case R.id.smallfrends:
                        setFregmentClasses(groupFrendeFragment);
                        return true;
                    default:
                        return false;
                }
            }
        });
    }
    public void setFregmentClasses(Fragment fragment) {
        android.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.freg_groups, fragment);
        fragmentTransaction.commit();
    }



}
