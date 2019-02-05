package android.course.edmodo_203898309_305186108.Notification;

import android.content.Context;
import android.course.edmodo_203898309_305186108.Fclasses.ObjMyClasses;
import android.course.edmodo_203898309_305186108.Fclasses.UserPrfile;
import android.course.edmodo_203898309_305186108.FinalPostAdapter;
import android.course.edmodo_203898309_305186108.MyEdmodoDBManager;
import android.course.edmodo_203898309_305186108.R;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ContactViewHolder> {
    private List<ObjNotification> listObjNot;
    private Context context;

    public NotificationAdapter(FragmentActivity activity, List<ObjNotification> listObjNot) {
        this.listObjNot = listObjNot;
        context = activity;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.row_notification, viewGroup, false);
        return new ContactViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder contactViewHolder, int i) {
        ObjNotification on = this.listObjNot.get(i);
        contactViewHolder.setData(on);
    }

    @Override
    public int getItemCount() {
        return listObjNot.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        private ImageView imagep;
        private TextView nameu;
        private TextView how;
        private TextView what;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            imagep = (ImageView)itemView.findViewById(R.id.imageP);
            nameu = (TextView)itemView.findViewById(R.id.NameUser);
            how = (TextView)itemView.findViewById(R.id.hownot);
            what = (TextView)itemView.findViewById(R.id.whtenot);

        }

        public void setData(ObjNotification on) {
            MyEdmodoDBManager.getInstance().openDataBase(context);
            UserPrfile userPrfile = MyEdmodoDBManager.getInstance().readuser(on.getIdProfile());
            ObjMyClasses objMyClasses = MyEdmodoDBManager.getInstance().getClass(on.getIdClass());
            imagep.setImageBitmap(on.getImageProfile());
            nameu.setText(userPrfile.getName());
            how.setText(objMyClasses.getName());
            //what.setText();
        }
    }
}
