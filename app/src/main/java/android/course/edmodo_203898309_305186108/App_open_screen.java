package android.course.edmodo_203898309_305186108;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class App_open_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_open_screen);


        new Thread(new Runnable(){
            public void run(){
                try{
                    synchronized (this){
                        wait(1000);
                        Intent intent = new Intent(App_open_screen.this,MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                        finish();
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }}
        }).start();
    }


}
