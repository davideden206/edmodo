package android.course.edmodo_203898309_305186108.Fmessages;

import android.app.Activity;
import android.content.Context;
import android.course.edmodo_203898309_305186108.Fclasses.UserPrfile;
import android.course.edmodo_203898309_305186108.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListUserAdapter extends ArrayAdapter<UserPrfile> {
    private List<UserPrfile> dataList;
    private Activity context = null;

    public ListUserAdapter( Context context, List<UserPrfile> dataList) {
        super(context,R.layout.row_user, dataList);
        this.dataList = dataList;
        this.context = (Activity)context;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public UserPrfile getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.row_user, null,false);

        TextView name = (TextView) rowView.findViewById(R.id.NameUser);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.PicUser);

        UserPrfile listUsers = dataList.get(position);
        name.setText(listUsers.getName());
        imageView.setImageBitmap(listUsers.getId_ImageProfile());
        return rowView;

    };

}
