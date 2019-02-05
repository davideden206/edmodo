package android.course.edmodo_203898309_305186108.Fmessages;

import android.content.DialogInterface;
import android.content.Intent;
import android.course.edmodo_203898309_305186108.MainActivity;
import android.course.edmodo_203898309_305186108.MyEdmodoDBManager;
import android.course.edmodo_203898309_305186108.R;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.sql.Date;

import java.util.ArrayList;

import java.util.List;

public class WriteMassegeActivity extends AppCompatActivity {
    ListView list;
    private EditText textMessage;
    ObjMessageAdapter objMessageAdapter;
    Bundle savedInstanceState1;
    List<ObjMeesage> listObjMessage;
    private View Mview;
     ObjMeesage objMeesage;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        savedInstanceState1= savedInstanceState;
        setContentView(R.layout.activity_write_massege);
        MyEdmodoDBManager.getInstance().openDataBase(this);
        Intent i = getIntent();
        TextView tv = (TextView)findViewById(R.id.nameUserToWriteMessage);
        final String idto = i.getStringExtra("idto");
        String nameU = i.getStringExtra("nameU");
        tv.setText(nameU);
         textMessage = (EditText)findViewById(R.id.textMessage);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.new_message);
         listObjMessage = MyEdmodoDBManager.getInstance().displayMeesageFromAndTo(MainActivity.idUser,Integer.parseInt(idto));
        list = (ListView)findViewById(R.id.listMessage);
        objMessageAdapter = new ObjMessageAdapter(this,listObjMessage);

        ImageView sand = (ImageView)findViewById(R.id.sandMessage);
        if(listObjMessage!=null){
            list.setAdapter(objMessageAdapter);
        }

        sand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date d = new Date(1,2,1);
                MyEdmodoDBManager.getInstance().addMessage(new ObjMeesage(textMessage.getText().toString(),d,MainActivity.idUser,Integer.parseInt(idto)));
                textMessage.setText("");
               // startActivity(getIntent());
                listObjMessage = MyEdmodoDBManager.getInstance().displayMeesageFromAndTo(MainActivity.idUser,Integer.parseInt(idto));
                objMessageAdapter = new ObjMessageAdapter(WriteMassegeActivity.this,listObjMessage);
                list.setAdapter(objMessageAdapter);
                objMessageAdapter.notifyDataSetChanged();
            }
        });
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 objMeesage = (ObjMeesage) parent.getItemAtPosition(position);
                showSimpleAlertDialog(view);


            }
        });



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

    public void showSimpleAlertDialog(View view) {
        // 1. Instantiate an AlertDialog.Builder with its constructor
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // 2. Chain together various setter methods to set the dialog characteristics
        builder. setTitle(R.string.Do_you_want_to_delete_this_messgae);
        // Add the buttons
        builder.setPositiveButton(R.string.Yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                MyEdmodoDBManager.getInstance().deleteMessage(objMeesage);
                startActivity(getIntent());
            }
        });
        builder.setNegativeButton(R.string.No, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(WriteMassegeActivity.this,"the massage not rmove",Toast.LENGTH_SHORT).show();
            }
        });


        AlertDialog dialog = builder.create();

        dialog.show();

    }

}
