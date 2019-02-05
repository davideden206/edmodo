package android.course.edmodo_203898309_305186108;

import android.content.Context;
import android.content.Intent;
import android.course.edmodo_203898309_305186108.Fclasses.LatestActivityFragment;
import android.course.edmodo_203898309_305186108.Fclasses.MyClassesFragment;
import android.course.edmodo_203898309_305186108.Fclasses.UserPrfile;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FinalPostAdapter extends RecyclerView.Adapter<FinalPostAdapter.ContactViewHolder>{
    private AlertDialog dialog;
    private View Mview;
    private AlertDialog.Builder alertBilder;
    private List<ObjFinalPost> objFinalPosts;
    Context context;

    public FinalPostAdapter(FragmentActivity activity, List<ObjFinalPost> contactList) {
        this.objFinalPosts = contactList;
        this.context = activity;
    }


    @Override
    public int getItemCount() {
        return objFinalPosts.size();
    }

    @Override
    public void onBindViewHolder(ContactViewHolder contactViewHolder, int position) {

        ObjFinalPost fp= objFinalPosts.get(position);
        contactViewHolder.setData(fp);

    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.card_view_post, viewGroup, false);

        return new ContactViewHolder(itemView);
    }

    public  class ContactViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageP;
        private TextView name;
        private TextView textPost;
        private UserPrfile up = null;
        private Button btnDelete;
        private Button btnEdit;
        private Button saveBtn,cancelBtn;
        private EditText editTxtePost;
        private ObjFinalPost fp = null;


        public ContactViewHolder(View v) {
            super(v);
            imageP = (ImageView) v.findViewById(R.id.imageP);
            name = (TextView)v.findViewById(R.id.Pname);
            textPost = (TextView)v.findViewById(R.id.textPost);
            btnDelete = (Button)v.findViewById(R.id.btnDelete);
            btnEdit = (Button)v.findViewById(R.id.btnEdit);

            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MyEdmodoDBManager.getInstance().openDataBase(context);
                    MyEdmodoDBManager.getInstance().deletePost(ContactViewHolder.this.fp.getId());


                    FinalPostAdapter.this.notifyDataSetChanged();
                    context.getApplicationContext();
                }
            });

            btnEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MyEdmodoDBManager.getInstance().openDataBase(context);
                    alertBilder = new AlertDialog.Builder(context);
                    LayoutInflater inflater = LayoutInflater.from(context);
                    Mview = inflater.inflate(R.layout.alert_dialog_edit_post,null);
                    saveBtn = Mview.findViewById(R.id.saveBtn);
                    cancelBtn = Mview.findViewById(R.id.cancelBtn);
                    editTxtePost = Mview.findViewById(R.id.editTxtePost);

                    alertBilder.setView(Mview);
                    dialog = alertBilder.create();
                    dialog.show();

                    saveBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String s = editTxtePost.getText().toString();
                            ObjPost objPost =MyEdmodoDBManager.getInstance().redPostById(ContactViewHolder.this.fp.getId());
                            objPost.setTextPost(s);
                            MyEdmodoDBManager.getInstance().updatePost(objPost);
                            dialog.cancel();

                        }
                    });
                }
            });
        }

        public void setData(ObjFinalPost up){
            this.fp = up;
            this.up = up.getUserPrfile();
            imageP.setImageBitmap(up.getUserPrfile().getId_ImageProfile());
            name.setText(up.getUserPrfile().getName());
            textPost.setText(up.getTextPost());
        }
    }
}
