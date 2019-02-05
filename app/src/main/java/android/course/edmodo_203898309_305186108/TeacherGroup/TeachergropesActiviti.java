package android.course.edmodo_203898309_305186108.TeacherGroup;


import android.app.Fragment;
import android.content.Intent;
import android.course.edmodo_203898309_305186108.R;
import android.course.edmodo_203898309_305186108.gruops.SmallGroupesFragment;
import android.course.edmodo_203898309_305186108.gruops.groupFrendeFragment;
import android.course.edmodo_203898309_305186108.gruops.groupFeedFragment;
import android.course.edmodo_203898309_305186108.gruops.ClassesSetingActivity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TeachergropesActiviti extends AppCompatActivity {
    TextView tvNameClass;
    Button btuSetting;
    private BottomNavigationView groupNav;
    private android.course.edmodo_203898309_305186108.gruops.groupFeedFragment groupFeedFragment;
    private ResourcesFragment resourcesFragment;
    private groupFrendeFragment groupFrendeFragment;
    private SmallGroupesFragment smallGroupesFragment;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_gropes_activiti);

        tvNameClass = (TextView)findViewById(R.id.tvClassName);
        final Intent intent = getIntent();
        String className = intent.getStringExtra("nameClass");
        getSupportActionBar().setTitle(className);



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
                    case R.id.feed:
                        setFregmentClasses(groupFeedFragment);
                        return true;
                    case R.id.frends:
                        setFregmentClasses(groupFrendeFragment);
                        return true;
                    case R.id.m_Resources:
                        setFregmentClasses(resourcesFragment);
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
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }



}
