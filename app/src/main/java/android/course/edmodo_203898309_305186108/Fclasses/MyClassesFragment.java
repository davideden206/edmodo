package android.course.edmodo_203898309_305186108.Fclasses;


import android.content.Context;
import android.content.Intent;
import android.course.edmodo_203898309_305186108.ArchivedActivity;
import android.course.edmodo_203898309_305186108.MainActivity;
import android.course.edmodo_203898309_305186108.MyEdmodoDBManager;
import android.course.edmodo_203898309_305186108.R;
import android.course.edmodo_203898309_305186108.TeacherGroup.TeachergropesActiviti;
import android.course.edmodo_203898309_305186108.gruops.gropesActiviti;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyClassesFragment extends Fragment {
    private static ListView list;
    private AlertDialog dialog;
    private View Mview;
    private AlertDialog.Builder alertBilder;
    private static objMyClassesAdapter adapter;
    private FloatingActionButton btnplus;
    private Button btnArchived;
    public static int classid;
    static Context context;
    private static List<android.course.edmodo_203898309_305186108.Fclasses.ObjMyClasses> ObjMyClasses;
    public MyClassesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_classes, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        MyEdmodoDBManager.getInstance().openDataBase(getContext());
        btnArchived = (Button)getActivity().findViewById(R.id.btnArchived);
        ObjMyClasses = MyEdmodoDBManager.getInstance().allClassInProfile(MainActivity.idUser);

        list = (ListView) getActivity().findViewById(R.id.lvClasses);
        context = getContext();
        adapter = new objMyClassesAdapter(getActivity(), ObjMyClasses);

        btnplus = (FloatingActionButton) getActivity().findViewById(R.id.btnPlus);

        if(MainActivity.idUser==1||MainActivity.idUser==2
                ||MainActivity.idUser==3){
            btnplus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                     alertBilder = new AlertDialog.Builder(getActivity());
                     Mview = getLayoutInflater().inflate(R.layout.alert_dialog_code_group,null);
                    final EditText codeGroup = (EditText)Mview.findViewById(R.id.TValertCode);
                    Button buttonAdd = (Button)Mview.findViewById(R.id.btnAlertCode);


                    buttonAdd.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int code = Integer.parseInt(codeGroup.getText().toString());
                            ObjMyClasses objMyClasses = MyEdmodoDBManager.getInstance().getClass(code);
                            if(objMyClasses!=null){
                                MyEdmodoDBManager.getInstance().addProfileInClasses(MainActivity.idUser,code);
                                ObjMyClasses = MyEdmodoDBManager.getInstance().allClassInProfile(MainActivity.idUser);
                                adapter = new objMyClassesAdapter(getActivity(), ObjMyClasses);
                                list.setAdapter(adapter);
                                adapter.notifyDataSetChanged();
                            }else{
                            Toast.makeText(getActivity(), "the class not exists", Toast.LENGTH_SHORT).show();
                        }

                            dialog.cancel();
                        }
                    });
                    alertBilder.setView(Mview);
                    dialog = alertBilder.create();
                    dialog.show();


                }
            });

            list.setAdapter(adapter);
        }
        if(MainActivity.idUser==4||MainActivity.idUser==5
                ||MainActivity.idUser==6){

            btnplus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getActivity() ,AddClassActivity.class);
                    startActivity(i);
                }
            });

            list.setAdapter(adapter);
        }

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ObjMyClasses classObj =(ObjMyClasses)parent.getItemAtPosition(position);
                String className = classObj.getName();
                 classid = classObj.getId();

                if(MainActivity.idUser==1||MainActivity.idUser==2
                        ||MainActivity.idUser==3){

                    Intent i = new Intent(getActivity() ,gropesActiviti.class);
                    i.putExtra("nameClass",className );
                    startActivity(i);
                }else{
                    Intent  i = new Intent(getActivity() ,TeachergropesActiviti.class);
                    i.putExtra("nameClass",className );
                    startActivity(i);

                }



            }
        });





        btnArchived.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ArchivedActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        MyEdmodoDBManager.getInstance().openDataBase(getActivity());
        updateClass();
        super.onResume();

    }

    @Override
    public void onPause() {
        MyEdmodoDBManager.getInstance().closeDataBase();
        super.onPause();
    }

    public void setList(ListView list) {
        this.list = list;
    }

    public objMyClassesAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(objMyClassesAdapter adapter) {
        this.adapter = adapter;
    }
    public ListView getList() {
        return list;
    }

public static void updateClass(){
    ObjMyClasses = MyEdmodoDBManager.getInstance().allClassInProfile(MainActivity.idUser);
    adapter = new objMyClassesAdapter(context, ObjMyClasses);
    list.setAdapter(adapter);
    adapter.notifyDataSetChanged();
}

}