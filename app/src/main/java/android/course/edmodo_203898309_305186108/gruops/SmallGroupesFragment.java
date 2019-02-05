package android.course.edmodo_203898309_305186108.gruops;


import android.app.Fragment;
import android.content.Intent;
import android.course.edmodo_203898309_305186108.Fclasses.ObjMyClasses;
import android.course.edmodo_203898309_305186108.Fclasses.objMyClassesAdapter;
import android.course.edmodo_203898309_305186108.R;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SmallGroupesFragment extends Fragment {
    ListView lvSmallGroup;
    ArrayList<ObjMyClasses> listSmallGroups;
    objMyClassesAdapter adapter;


    public SmallGroupesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_small_groupes, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lvSmallGroup = (ListView) getActivity().findViewById(R.id.lvSmallGroups);
        listSmallGroups = new ArrayList<ObjMyClasses>();
        //listSmallGroups.add(new ObjMyClasses("gruop1",3));
        //listSmallGroups.add(new ObjMyClasses("gruop2",2));
       // listSmallGroups.add(new ObjMyClasses("gruop3",6));

        adapter = new objMyClassesAdapter(getActivity(), listSmallGroups);
        lvSmallGroup.setAdapter(adapter);

        lvSmallGroup.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(),SmallGroupActivity.class);
                ObjMyClasses GroupObj =(ObjMyClasses)parent.getItemAtPosition(position);
                String nameGroup = GroupObj.getName();
                intent.putExtra("groupName",nameGroup);
                startActivity(intent);
            }
        });


    }
}
