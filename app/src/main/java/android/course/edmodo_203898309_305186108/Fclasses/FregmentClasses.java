package android.course.edmodo_203898309_305186108.Fclasses;

import android.course.edmodo_203898309_305186108.R;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;


public class FregmentClasses extends Fragment {
    private BottomNavigationView classesNav;
    private LatestActivityFragment latestActivityFragment;
    private MyClassesFragment myClassesFragment;
    private FrameLayout classFrame;
    public FregmentClasses() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setFregmentClasses(latestActivityFragment);
        classesNav = (BottomNavigationView) this.getView().findViewById(R.id.classes_nav);
        classesNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.la:
                        setFregmentClasses(latestActivityFragment);
                        return true;
                    case R.id.mc:
                        setFregmentClasses(myClassesFragment);
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.classes,container,false);
        latestActivityFragment = new LatestActivityFragment();
        myClassesFragment = new MyClassesFragment();
        classFrame = (FrameLayout)view.findViewById(R.id.fram_classes);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.classes, container, false);
    }

    public void setFregmentClasses(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fram_classes, fragment);
        fragmentTransaction.commit();
    }

}
