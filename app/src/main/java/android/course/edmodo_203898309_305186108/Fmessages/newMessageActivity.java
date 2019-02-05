package android.course.edmodo_203898309_305186108.Fmessages;
import android.content.Intent;
import android.course.edmodo_203898309_305186108.Fclasses.ObjMyClasses;
import android.course.edmodo_203898309_305186108.Fclasses.UserPrfile;
import android.course.edmodo_203898309_305186108.MainActivity;
import android.course.edmodo_203898309_305186108.MyEdmodoDBManager;
import android.course.edmodo_203898309_305186108.R;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class newMessageActivity extends AppCompatActivity {
    private ListView list;
    private ListUserAdapter adapter;
    Intent intent;
    ArrayList<ObjMyClasses> myClass;
    ArrayList<UserPrfile> dataofoneclass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_message);
        MyEdmodoDBManager.getInstance().openDataBase(this);
        Map map = new HashMap();
         myClass = MyEdmodoDBManager.getInstance().allClassInProfile(MainActivity.idUser);
        List<UserPrfile> listUsers = new ArrayList<UserPrfile>();
        for(ObjMyClasses classs:myClass){
             dataofoneclass = MyEdmodoDBManager.getInstance().frindsInClass(classs.getId());
            for (UserPrfile userPrfile : dataofoneclass) {
                map.put(userPrfile.getId(),userPrfile);
            }
        }
        map.remove(MainActivity.idUser);
        listUsers.addAll(map.values());


       // listUsers.add(new ListUsers("eden",R.drawable.ic_profile_gray));

        list = (ListView)findViewById(R.id.listRowOfUsers);
        adapter = new ListUserAdapter(this, listUsers);

        list.setAdapter(adapter);






        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setTitle(R.string.new_message);



         intent  = new Intent(newMessageActivity.this,WriteMassegeActivity.class);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                UserPrfile selecteduser = adapter.getItem(position);
                intent.putExtra("idto",String.valueOf(selecteduser.getId()));
                intent.putExtra("nameU",selecteduser.getName());
                    startActivity(intent);

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

}
