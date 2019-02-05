package android.course.edmodo_203898309_305186108.Fmessages;

import android.app.Activity;
import android.content.Context;
import android.course.edmodo_203898309_305186108.Fclasses.UserPrfile;
import android.course.edmodo_203898309_305186108.MyEdmodoDBManager;
import android.course.edmodo_203898309_305186108.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ObjMessageAdapter extends ArrayAdapter<ObjMeesage> {
    private List<ObjMeesage> dataList;
    private Activity context = null;
    public ObjMessageAdapter(Context context,List<ObjMeesage> list) {
        super(context,R.layout.row_message, list);
        this.dataList = list;
        this.context = (Activity)context;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public ObjMeesage getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.row_message, null,false);

        TextView nameFrom = (TextView) rowView.findViewById(R.id.nameFrom);
        ImageView picFrom = (ImageView) rowView.findViewById(R.id.picFrom);
        TextView TextFrom = (TextView) rowView.findViewById(R.id.TextFrom);

        ObjMeesage objMeesage = dataList.get(position);
        UserPrfile userPrfile =MyEdmodoDBManager.getInstance().readuser(objMeesage.getIdProfileFrom());
        nameFrom.setText(userPrfile.getName());
        picFrom.setImageBitmap(userPrfile.getId_ImageProfile());
        TextFrom.setText(objMeesage.getTextMessage());
        return rowView;

    };
}
