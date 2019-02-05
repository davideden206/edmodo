package android.course.edmodo_203898309_305186108.gruops;

import android.course.edmodo_203898309_305186108.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ClassesSetingActivity extends AppCompatActivity {
    Button butBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes_seting);



    getSupportActionBar().setTitle(R.string.Class_settings);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
