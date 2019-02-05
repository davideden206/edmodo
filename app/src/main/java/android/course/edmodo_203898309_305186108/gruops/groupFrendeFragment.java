package android.course.edmodo_203898309_305186108.gruops;


import android.course.edmodo_203898309_305186108.Fclasses.MyClassesFragment;
import android.course.edmodo_203898309_305186108.Fclasses.UserPrfile;
import android.course.edmodo_203898309_305186108.MainActivity;
import android.course.edmodo_203898309_305186108.MyEdmodoDBManager;
import android.course.edmodo_203898309_305186108.R;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class groupFrendeFragment extends Fragment {
    ListView list;


    public groupFrendeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_group_frende, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        MyEdmodoDBManager.getInstance().openDataBase(getActivity());
        ArrayList<UserPrfile> allFrindInClass =  MyEdmodoDBManager.getInstance().frindsInClass(MyClassesFragment.classid);
        ArrayList<frands> datafrend = new ArrayList<frands>();
        ArrayList<UserPrfile> userPrfiles = new ArrayList<UserPrfile>();
        Map map = new HashMap();
        for(UserPrfile u : allFrindInClass){
            map.put(u.getId(),u);

        }
        map.remove(MainActivity.idUser);
        userPrfiles.addAll(map.values());
        for(UserPrfile u :userPrfiles){
            datafrend.add(new frands(u,null));
        }
        RecyclerView recyclerView = (RecyclerView)getActivity().findViewById(R.id.lvFrends);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        frendsAdapter ffrendsAdapter = new frendsAdapter(getActivity(),datafrend);
        recyclerView.setAdapter( ffrendsAdapter);

    }
}
