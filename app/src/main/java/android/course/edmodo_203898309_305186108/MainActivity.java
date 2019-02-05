package android.course.edmodo_203898309_305186108;

import android.content.Intent;
import android.course.edmodo_203898309_305186108.Fclasses.ObjMyClasses;
import android.course.edmodo_203898309_305186108.Fclasses.UserPrfile;
import android.course.edmodo_203898309_305186108.Fmessages.ObjMeesage;
import android.course.edmodo_203898309_305186108.gruops.ObjResource;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    public static String typeUser;
    public static int idUser;
    UserPrfile userPrfile1,userPrfile2,userPrfile3,userPrfile11,userPrfile22,userPrfile33;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyEdmodoDBManager.getInstance().openDataBase(this);
        UserPrfile uu = MyEdmodoDBManager.getInstance().readuser(1);
        if(uu==null) {

            Bitmap imgp1 = BitmapFactory.decodeResource(getResources(), R.drawable.images);
            Bitmap imgp2 = BitmapFactory.decodeResource(getResources(), R.drawable.images2);
            Bitmap imgp3 = BitmapFactory.decodeResource(getResources(), R.drawable.images3);
            Bitmap imgp4 = BitmapFactory.decodeResource(getResources(), R.drawable.aaaa);
            Bitmap imgp5 = BitmapFactory.decodeResource(getResources(), R.drawable.ssss);
            Bitmap imgp6 = BitmapFactory.decodeResource(getResources(), R.drawable.uuuu);


            userPrfile1 = new UserPrfile("student", "YISHAI", imgp1);
            userPrfile2 = new UserPrfile("student", "DAN", imgp2);
            userPrfile3 = new UserPrfile("student", "STUDENT", imgp3);
            userPrfile11 = new UserPrfile("teacher", "EDEN DAVID", imgp4);
            userPrfile22 = new UserPrfile("teacher", "YARON", imgp5);
            userPrfile33 = new UserPrfile("teacher", "TEACHER", imgp6);

            //add profiles

                MyEdmodoDBManager.getInstance().addProfile(userPrfile1);
                MyEdmodoDBManager.getInstance().addProfile(userPrfile2);
                MyEdmodoDBManager.getInstance().addProfile(userPrfile3);
                MyEdmodoDBManager.getInstance().addProfile(userPrfile11);
                MyEdmodoDBManager.getInstance().addProfile(userPrfile22);
                MyEdmodoDBManager.getInstance().addProfile(userPrfile33);

            //add classinProfile
            MyEdmodoDBManager.getInstance().createNewClasses("class 1", 4);
            MyEdmodoDBManager.getInstance().createNewClasses("class 2", 5);
            MyEdmodoDBManager.getInstance().createNewClasses("class 3", 6);

            //add profile student in class
            MyEdmodoDBManager.getInstance().addProfileInClasses(1, 1);
            MyEdmodoDBManager.getInstance().addProfileInClasses(2, 2);
            MyEdmodoDBManager.getInstance().addProfileInClasses(3, 3);
            MyEdmodoDBManager.getInstance().addProfileInClasses(1, 3);
            MyEdmodoDBManager.getInstance().addProfileInClasses(2, 2);
            MyEdmodoDBManager.getInstance().addProfileInClasses(3, 1);

            //add Post
            ObjPost o1 = new ObjPost(1,1,"שלום המורה");
            ObjPost o2 = new ObjPost(2,2,"שלום המורה");
            ObjPost o3 = new ObjPost(3,3,"שלום המורה");
            ObjPost o4 = new ObjPost(4,1,"שלום תלמידים");
            ObjPost o5 = new ObjPost(5,2,"שלום תלמידים");
            ObjPost o6 = new ObjPost(6,3,"שלום תלמידים");

            MyEdmodoDBManager.getInstance().addPost(o1);
            MyEdmodoDBManager.getInstance().addPost(o2);
            MyEdmodoDBManager.getInstance().addPost(o3);
            MyEdmodoDBManager.getInstance().addPost(o4);
            MyEdmodoDBManager.getInstance().addPost(o5);
            MyEdmodoDBManager.getInstance().addPost(o6);

            //add resuorce
            Bitmap img1 = BitmapFactory.decodeResource(getResources(), R.drawable.p);
            Bitmap img2 = BitmapFactory.decodeResource(getResources(), R.drawable.pp);
            Bitmap img3 = BitmapFactory.decodeResource(getResources(), R.drawable.ppp);

            ObjResource or1 = new ObjResource(null,img1,null,1);
            ObjResource or2 = new ObjResource(null,img2,null,2);
            ObjResource or3 = new ObjResource(null,img3,null,3);
            ObjResource or4 = new ObjResource(null,null,"www.google.co.il",1);
            ObjResource or5 = new ObjResource(null,null,"www.walla.co.il",2);
            ObjResource or6 = new ObjResource(null,null,"www.ynet.co.il",3);
            MyEdmodoDBManager.getInstance().addResource(or1);
            MyEdmodoDBManager.getInstance().addResource(or2);
            MyEdmodoDBManager.getInstance().addResource(or3);
            MyEdmodoDBManager.getInstance().addResource(or4);
            MyEdmodoDBManager.getInstance().addResource(or5);
            MyEdmodoDBManager.getInstance().addResource(or6);

            //add message
            MyEdmodoDBManager.getInstance().addMessage(new ObjMeesage("שלום המורה מה היו השיעורי בית?",null,1,4));
            MyEdmodoDBManager.getInstance().addMessage(new ObjMeesage("שלום המורה מה היו השיעורי בית?",null,2,5));
            MyEdmodoDBManager.getInstance().addMessage(new ObjMeesage("שלום המורה מה היו השיעורי בית?",null,3,6));
            MyEdmodoDBManager.getInstance().addMessage(new ObjMeesage("שלום תיכנס לאתר קורס",null,4,1));
            MyEdmodoDBManager.getInstance().addMessage(new ObjMeesage("שלום תשאל חבר",null,5,2));
            MyEdmodoDBManager.getInstance().addMessage(new ObjMeesage("שלום עמוד 4 חוברת",null,6,3));

        }
        }



    public void toStudent1(View view) {
        idUser=1;
        Intent intent = new Intent(MainActivity.this,HomeActivity.class);
        startActivity(intent);
    }
    public void toStudent2(View view) {
        idUser=2;
        Intent intent = new Intent(MainActivity.this,HomeActivity.class);
        startActivity(intent);
    }
    public void toStudent3(View view) {
        idUser=3;
        Intent intent = new Intent(MainActivity.this,HomeActivity.class);
        startActivity(intent);
    }

    public void toTechaer1(View view) {
        idUser=4;
        Intent intent = new Intent(MainActivity.this,HomeTeacherActivity.class);
        startActivity(intent);
    }
    public void toTechaer2(View view) {
        idUser=5;
        Intent intent = new Intent(MainActivity.this,HomeTeacherActivity.class);
        startActivity(intent);
    }
    public void toTechaer3(View view) {
        idUser=6;
        Intent intent = new Intent(MainActivity.this,HomeTeacherActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        MyEdmodoDBManager.getInstance().openDataBase(this);
        super.onResume();

    }

    @Override
    protected void onPause() {
        MyEdmodoDBManager.getInstance().closeDataBase();
        super.onPause();
    }
}
