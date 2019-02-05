package android.course.edmodo_203898309_305186108.Fclasses;

import android.content.Context;
import android.course.edmodo_203898309_305186108.R;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class UserProfileTeacherAdapter extends BaseAdapter {
    private  Context mContext;
    private List<UserPrfile> userPrfiles;
    UserProfileAdapter.ContactViewHolder contactViewHolder;

    private ImageView imageP;
    private TextView name;
    private UserPrfile up = null;

    public UserProfileTeacherAdapter(Context context, List<UserPrfile> list) {
        this.mContext = context;
        this.userPrfiles = list;
    }

    // 2
    @Override
    public int getCount() {
        return userPrfiles.size();
    }

    // 3
    @Override
    public long getItemId(int position) {
        return 0;
    }

    // 4
    @Override
    public Object getItem(int position) {
        return null;
    }

    // 5
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.all_frends_in_class_row, null);
        }

        imageP = (ImageView) convertView.findViewById(R.id.imageoffrends);
        name = (TextView)convertView.findViewById(R.id.nameoffrends);
        name.setText(userPrfiles.get(position).getName());
        imageP.setImageBitmap(userPrfiles.get(position).getId_ImageProfile());

        return convertView;
    }

}

