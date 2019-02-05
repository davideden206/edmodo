package android.course.edmodo_203898309_305186108.Fclasses;

import android.app.Activity;
import android.app.PendingIntent;
import android.course.edmodo_203898309_305186108.MainActivity;
import android.course.edmodo_203898309_305186108.MyEdmodoDBManager;
import android.course.edmodo_203898309_305186108.R;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;


import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class AddClassActivity extends AppCompatActivity {
    Button createclass;
    EditText nameclass;
    Activity ctx;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_class);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.createGroup);
        nameclass=this.findViewById(R.id.etnameclassadd);
        createclass = findViewById(R.id.createclass);
        ctx =this;
       MyEdmodoDBManager.getInstance().openDataBase(this);
        createclass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyEdmodoDBManager.getInstance().createNewClasses(nameclass.getText().toString(),MainActivity.idUser);
                MyClassesFragment.updateClass();
                finish();

            }
        });
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
