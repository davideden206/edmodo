package android.course.edmodo_203898309_305186108.More;


import android.course.edmodo_203898309_305186108.Fclasses.ObjMyClasses;
import android.course.edmodo_203898309_305186108.Fclasses.UserPrfile;
import android.course.edmodo_203898309_305186108.Fclasses.UserProfileTeacherAdapter;
import android.course.edmodo_203898309_305186108.MainActivity;
import android.course.edmodo_203898309_305186108.MyEdmodoDBManager;
import android.course.edmodo_203898309_305186108.R;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserProfileActivity extends AppCompatActivity {
    UserPrfile userPrfile;
    GridView gridView;
    ArrayList<UserPrfile> data = null;
    UserProfileTeacherAdapter userProfileTeacherAdapter;
    ArrayList<ObjMyClasses> myClass;
    ArrayList<UserPrfile> dataofoneclass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        MyEdmodoDBManager.getInstance().openDataBase(this);
         gridView = (GridView)findViewById(R.id.gridview);
        ImageView imageP = (ImageView)findViewById(R.id.imageP);
        TextView nameP = (TextView)findViewById(R.id.TVnameP);
        TextView typeP = (TextView)findViewById(R.id.typeP);
        data = new ArrayList<>();
        Bitmap img = BitmapFactory.decodeResource(getResources(), R.drawable.ic_profile_gray);


        // set data list for all frinds in class
        myClass = MyEdmodoDBManager.getInstance().allClassInProfile(MainActivity.idUser);
        Map map = new HashMap();
        for(ObjMyClasses classes : myClass){
            dataofoneclass = MyEdmodoDBManager.getInstance().frindsInClass(classes.getId());
            for (UserPrfile userPrfile : dataofoneclass){
                map.put(userPrfile.getId(),userPrfile);
            }
        }
        map.remove(MainActivity.idUser);
        data.addAll(map.values());



        userProfileTeacherAdapter = new UserProfileTeacherAdapter(this, data);
        gridView.setAdapter(userProfileTeacherAdapter);




        switch (MainActivity.idUser){
            case 1:
                userPrfile =  MyEdmodoDBManager.getInstance().readuser(1);
                break;
            case 2:
                userPrfile =  MyEdmodoDBManager.getInstance().readuser(2);
                break;
            case 3:
                userPrfile =  MyEdmodoDBManager.getInstance().readuser(3);
                break;
            case 4:
                userPrfile =  MyEdmodoDBManager.getInstance().readuser(4);
                break;
            case 5:
                userPrfile =  MyEdmodoDBManager.getInstance().readuser(5);
                break;
            case 6:
                userPrfile =  MyEdmodoDBManager.getInstance().readuser(6);
                break;
        }




       imageP.setImageBitmap(userPrfile.getId_ImageProfile());

       nameP.setText(userPrfile.getName());
       typeP.setText(userPrfile.getType());
        getSupportActionBar().setTitle(userPrfile.getName());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onResume() {
        MyEdmodoDBManager.getInstance().openDataBase(this);
        super.onResume();

    }

    @Override
    public void onPause() {
        MyEdmodoDBManager.getInstance().closeDataBase();
        super.onPause();
    }
}
