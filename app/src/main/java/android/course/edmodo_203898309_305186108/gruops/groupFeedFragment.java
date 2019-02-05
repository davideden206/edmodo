package android.course.edmodo_203898309_305186108.gruops;


import android.app.Fragment;
import android.content.Intent;
import android.course.edmodo_203898309_305186108.Fclasses.MyClassesFragment;
import android.course.edmodo_203898309_305186108.Fclasses.NewPostActivity;
import android.course.edmodo_203898309_305186108.Fclasses.ObjMyClasses;
import android.course.edmodo_203898309_305186108.Fclasses.UserPrfile;
import android.course.edmodo_203898309_305186108.FinalPostAdapter;
import android.course.edmodo_203898309_305186108.MainActivity;
import android.course.edmodo_203898309_305186108.MyEdmodoDBManager;
import android.course.edmodo_203898309_305186108.ObjFinalPost;
import android.course.edmodo_203898309_305186108.ObjPost;
import android.course.edmodo_203898309_305186108.R;
import android.os.Build;
import android.os.Bundle;

import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;


/**
 * A simple {@link Fragment} subclass.
 */
public class groupFeedFragment extends Fragment {
    FinalPostAdapter finalPostAdapter;
    List<ObjFinalPost> objFinalPosts;
    ArrayList<ObjPost> objPosts;
    Bundle savedInstanceState1;
    private FloatingActionMenu floatingActionMenu;

    public groupFeedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_group_feed, container, false);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
        savedInstanceState1 = savedInstanceState;
        MyEdmodoDBManager.getInstance().openDataBase(getActivity());


        floatingActionMenu = (FloatingActionMenu) getActivity().findViewById(R.id.btnPlus1);

        floatingActionMenu.setOnMenuButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),NewPostActivity.class);
                startActivity(intent);

            }
        });
        RecyclerView recyclerView = (RecyclerView)getActivity().findViewById(R.id.recVPostInclass);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        objPosts = new ArrayList<ObjPost>();
        objFinalPosts = new ArrayList<ObjFinalPost>();
        finalPostAdapter =new FinalPostAdapter((FragmentActivity) getActivity(),objFinalPosts);
       objPosts = MyEdmodoDBManager.getInstance().displayPostByClass(MyClassesFragment.classid);
        for(ObjPost o :objPosts){
            UserPrfile userPrfile =  MyEdmodoDBManager.getInstance().readuser(o.getProfileId());
            objFinalPosts.add(new ObjFinalPost(o.getId(),userPrfile,o.getTextPost()));
        }

        recyclerView.setAdapter(finalPostAdapter);


        LinearLayout l = (LinearLayout)getActivity().findViewById(R.id.LLToPost);
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),NewPostActivity.class);
                startActivity(intent);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onResume() {
        MyEdmodoDBManager.getInstance().openDataBase(getActivity());
        onActivityCreated(savedInstanceState1);
        super.onResume();

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.exit_profile_from_class, menu);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.exitFromClass:
                if(MainActivity.idUser>3){
                   MyEdmodoDBManager.getInstance().deleteTecherProfileInClasses(MyClassesFragment.classid);
                }else{
                    MyEdmodoDBManager.getInstance().deleteProfileInClasses(MainActivity.idUser,MyClassesFragment.classid);
                }
                getActivity().finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
