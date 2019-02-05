package android.course.edmodo_203898309_305186108.Fmessages;


import android.content.Intent;
import android.course.edmodo_203898309_305186108.Fclasses.LatestActivityFragment;
import android.course.edmodo_203898309_305186108.MyEdmodoDBManager;
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
import android.widget.Button;



/**
 * A simple {@link Fragment} subclass.
 */
public class emptyMessagesFragment extends Fragment {
    private Button MasGetStarted;
    BottomNavigationView bottomNavigationView;
    private BottomNavigationView navtoolbar;

    public emptyMessagesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_empty_messages, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        MasGetStarted = (Button)getActivity().findViewById(R.id.MasGetStarted);
        navtoolbar = (BottomNavigationView)getActivity().findViewById(R.id.navtoolbar);
        MasGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(getActivity(),newMessageActivity.class);
                startActivity(intent);

            }
        });

        navtoolbar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.plusButton:
                        Intent intent  = new Intent(getActivity(),newMessageActivity.class);
                        startActivity(intent);
                        return true;
                    default:
                        return false;
                }
            }
        });

    }

    @Override
    public void onResume() {
        MyEdmodoDBManager.getInstance().openDataBase(getActivity());
        super.onResume();


    }
    @Override
    public void onPause() {
        MyEdmodoDBManager.getInstance().closeDataBase();
        super.onPause();
    }

}
