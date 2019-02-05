package android.course.edmodo_203898309_305186108.Fclasses;

import android.course.edmodo_203898309_305186108.R;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class UserProfileAdapter extends RecyclerView.Adapter<UserProfileAdapter.ContactViewHolder>{

    private List<UserPrfile> userPrfiles;
    ContactViewHolder contactViewHolder;

    public UserProfileAdapter(FragmentActivity activity, List<UserPrfile> contactList) {
        this.userPrfiles = contactList;
    }


    @Override
    public int getItemCount() {
        return userPrfiles.size();
    }

    @Override
    public void onBindViewHolder(ContactViewHolder contactViewHolder, int position) {

        UserPrfile up = userPrfiles.get(position);
        contactViewHolder.setData(up);
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.card_view_post, viewGroup, false);
        contactViewHolder = new ContactViewHolder(itemView);
        return contactViewHolder;
    }

    public  class ContactViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageP;
        private TextView name;
        private TextView textPost;
        private UserPrfile up = null;


        public ContactViewHolder(View v) {
            super(v);
           imageP = (ImageView) v.findViewById(R.id.imageP);
           name = (TextView)v.findViewById(R.id.Pname);


        }

        public void setData(UserPrfile up){
            this.up = up;
            imageP.setImageBitmap(up.getId_ImageProfile());
            name.setText(up.getName());

        }
    }
}
