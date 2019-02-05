package android.course.edmodo_203898309_305186108.Fclasses;

import android.content.Intent;
import android.course.edmodo_203898309_305186108.MainActivity;
import android.course.edmodo_203898309_305186108.MyEdmodoDBManager;
import android.course.edmodo_203898309_305186108.ObjPost;
import android.course.edmodo_203898309_305186108.R;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class NewPostActivity extends AppCompatActivity {
    Spinner spinnerUser;
    Spinner spinnerClasses;
    EditText EDpost;
    ArrayList<ObjMyClasses> arrayObjMyClasses;
    int numClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyEdmodoDBManager.getInstance().openDataBase(this);
        setContentView(R.layout.activity_new_post);
        getSupportActionBar().setTitle(R.string.New_Post);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.baseline_send_black_18dp);
        EDpost = (EditText)findViewById(R.id.EDPost);
        arrayObjMyClasses = new ArrayList<ObjMyClasses>();
        spinnerUser = (Spinner)findViewById(R.id.SpinnerUser);
        spinnerClasses = (Spinner)findViewById(R.id.SpinnerClasses);
        addUserOnSpinner(spinnerUser);
        addClassesOnSpinner(spinnerClasses);
        long selectedItemId = spinnerClasses.getSelectedItemId();
        numClass = (int) selectedItemId;

    }

    public void addUserOnSpinner(Spinner spinner) {
        Map map = new HashMap();
        List<String> list = new ArrayList<String>();
        ArrayList<ObjMyClasses> myClass = MyEdmodoDBManager.getInstance().allClassInProfile(MainActivity.idUser);
        for(ObjMyClasses classs:myClass){
            ArrayList<UserPrfile> dataofoneclass = MyEdmodoDBManager.getInstance().frindsInClass(classs.getId());
            for (UserPrfile userPrfile : dataofoneclass) {
                map.put(userPrfile.getId(),userPrfile.getName());
            }

        }
        list.addAll(map.values());
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(dataAdapter);
    }

    public void addClassesOnSpinner(Spinner spinner) {

        List<String> list = new ArrayList<String>();
        ArrayList<ObjMyClasses> myClass = MyEdmodoDBManager.getInstance().allClassInProfile(MainActivity.idUser);
        for(ObjMyClasses classs:myClass){
            arrayObjMyClasses.add(classs);
                list.add(classs.getName());

            }

            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
            spinner.setAdapter(dataAdapter);
        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                long selectedItemId = spinnerClasses.getSelectedItemId();
                numClass = (int) selectedItemId;
                MyEdmodoDBManager.getInstance().addPost(new ObjPost(MainActivity.idUser,arrayObjMyClasses.get(numClass).getId(),EDpost.getText().toString()));

                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    }

