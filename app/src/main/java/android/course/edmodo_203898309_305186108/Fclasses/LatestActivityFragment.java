package android.course.edmodo_203898309_305186108.Fclasses;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.course.edmodo_203898309_305186108.FinalPostAdapter;
import android.course.edmodo_203898309_305186108.MainActivity;
import android.course.edmodo_203898309_305186108.MyEdmodoDBManager;
import android.course.edmodo_203898309_305186108.ObjFinalPost;
import android.course.edmodo_203898309_305186108.ObjPost;
import android.course.edmodo_203898309_305186108.R;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Toast;


import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class LatestActivityFragment extends Fragment {
    public  RecyclerView recyclerView;
    public  List<ObjFinalPost> objFinalPosts;
    public  FinalPostAdapter finalPostAdapter;
    private FloatingActionMenu floatingActionMenu;
    private ArrayList<ObjMyClasses> myClass;
    private ArrayList<ObjPost> allPostInClass;
    private ArrayList<ObjPost> allPostInAllClasses;
    private Button btn;
    private Bundle savedInstanceState1;
    Activity activity;

    public LatestActivityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_latest_activity, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
         recyclerView = (RecyclerView)getActivity().findViewById(R.id.recV);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        MyEdmodoDBManager.getInstance().openDataBase(getContext());
        objFinalPosts = new ArrayList<ObjFinalPost>();
        allPostInAllClasses = new ArrayList<ObjPost>();
        savedInstanceState1 = savedInstanceState;
        finalPostAdapter =new FinalPostAdapter(getActivity(),objFinalPosts);
        floatingActionMenu = (FloatingActionMenu) getActivity().findViewById(R.id.btnPlus);


        allfrindsinClasses();

        recyclerView.setAdapter(finalPostAdapter);


        if(MainActivity.idUser>3){
            setHasOptionsMenu(true);
        }



        floatingActionMenu.setOnMenuButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),NewPostActivity.class);
                startActivity(intent);

            }
        });
    }

    @Override
    public void onResume() {
        MyEdmodoDBManager.getInstance().openDataBase(getActivity());
        allfrindsinClasses();
        finalPostAdapter =new FinalPostAdapter(getActivity(),objFinalPosts);
        recyclerView.setAdapter(finalPostAdapter);
        finalPostAdapter.notifyDataSetChanged();
        super.onResume();

    }
    @Override
    public void onPause() {
        MyEdmodoDBManager.getInstance().closeDataBase();
        super.onPause();
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.search, menu);
    }


public void allfrindsinClasses(){
    List<ObjFinalPost> objFinalPosts2 = new ArrayList<>();
    myClass = MyEdmodoDBManager.getInstance().allClassInProfile(MainActivity.idUser);
    for(ObjMyClasses classs:myClass){
        allPostInClass = MyEdmodoDBManager.getInstance().displayPostByClass(classs.getId());
        for (ObjPost post : allPostInClass) {
            allPostInAllClasses.add(post);
            UserPrfile userPrfile =  MyEdmodoDBManager.getInstance().readuser(post.getProfileId());

            objFinalPosts2.add(new ObjFinalPost(post.getId(),userPrfile,post.getTextPost()));
        }
    }
    objFinalPosts = objFinalPosts2;
}


}
