package android.course.edmodo_203898309_305186108.whatsDue;


import android.course.edmodo_203898309_305186108.R;
import android.course.edmodo_203898309_305186108.whatsDue.FinishedFragment;
import android.course.edmodo_203898309_305186108.whatsDue.To_DoFragment;
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



/**
 * A simple {@link Fragment} subclass.
 */
public class WhatsDueFragment extends Fragment {
    private BottomNavigationView whatsDue_nav;
    private To_DoFragment to_doFragment;
    private FinishedFragment finishedFragment;

    public WhatsDueFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_whats_due, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        to_doFragment = new To_DoFragment();
        finishedFragment = new FinishedFragment();
        whatsDue_nav = (BottomNavigationView)getActivity().findViewById(R.id.whatsDue_nav);
        setFregment(to_doFragment);
        whatsDue_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.todo:
                        setFregment(to_doFragment);
                        return true;
                    case R.id.finis:
                        setFregment(finishedFragment);
                        return true;

                   default:
                       return false;
                }
            }
        });

    }

    public void setFregment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fram_whatsDue, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
