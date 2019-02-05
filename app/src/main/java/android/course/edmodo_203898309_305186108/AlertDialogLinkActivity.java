package android.course.edmodo_203898309_305186108;

import android.content.ClipData;
import android.content.Intent;
import android.course.edmodo_203898309_305186108.Fclasses.MyClassesFragment;
import android.course.edmodo_203898309_305186108.TeacherGroup.TeachergropesActiviti;
import android.course.edmodo_203898309_305186108.gruops.ObjResource;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class AlertDialogLinkActivity extends AppCompatActivity {
    EditText title , text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog_link);
        title = (EditText) findViewById(R.id.titleOfLink);
        text = (EditText) findViewById(R.id.theLink);
        MyEdmodoDBManager.getInstance().openDataBase(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.vbutton, menu);
        return true;
    }


    public void saveAndClose(MenuItem item) {
        ObjResource objResource = new ObjResource();
        objResource.setLink(title.getText().toString()+"\n"+text.getText().toString());
        objResource.setClassesId(MyClassesFragment.classid);
        MyEdmodoDBManager.getInstance().addResource(objResource);
        onBackPressed();
        //Intent i = new Intent(AlertDialogLinkActivity.this,TeachergropesActiviti.class);
        //startActivity(i);
    }
}
