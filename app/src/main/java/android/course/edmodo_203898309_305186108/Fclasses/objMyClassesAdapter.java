package android.course.edmodo_203898309_305186108.Fclasses;

import android.app.Activity;
import android.content.Context;
import android.course.edmodo_203898309_305186108.Fclasses.ObjMyClasses;
import android.course.edmodo_203898309_305186108.MainActivity;
import android.course.edmodo_203898309_305186108.MyEdmodoDBManager;
import android.course.edmodo_203898309_305186108.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class objMyClassesAdapter extends ArrayAdapter<ObjMyClasses> {

    private List<ObjMyClasses> dataList = null;
    private Activity context = null;

    public objMyClassesAdapter(Context context, List<ObjMyClasses> dataList) {
        super(context, R.layout.obj_my_classes_row, dataList);
        this.dataList = dataList;
        this.context = (Activity)context;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public ObjMyClasses getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.obj_my_classes_row, null,false);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.itemInfo);
        TextView extratext = (TextView) rowView.findViewById(R.id.extratext);
        TextView numFriendInClass = (TextView)rowView.findViewById(R.id.numFriendInClass);
        TextView idOfClass = (TextView)rowView.findViewById(R.id.idOfClass);
        ObjMyClasses objMyClasses = dataList.get(position);
        txtTitle.setText(objMyClasses.getName());
        idOfClass.setText(String.valueOf(objMyClasses.getId()));
        ArrayList<UserPrfile> usersProfileArray = MyEdmodoDBManager.getInstance().frindsInClass(objMyClasses.getId());
        Map map = new HashMap();
        for(UserPrfile u :usersProfileArray){
            map.put(u.getId(),u);
        }
        map.remove(MainActivity.idUser);
        numFriendInClass.setText(String.valueOf(map.size()));
        extratext.setText(context.getString(R.string.more_frinds_in_class));
        return rowView;

    };

}
