package android.course.edmodo_203898309_305186108.TeacherGroup;

import android.content.Context;
import android.course.edmodo_203898309_305186108.R;
import android.course.edmodo_203898309_305186108.gruops.ObjResource;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ResourceAdapter extends RecyclerView.Adapter<ResourceAdapter.ContactViewHolder> {

    private List<ObjResource> objResourcesList;
    Context context;

    public ResourceAdapter( List<ObjResource> objResourcesList) {
        this.objResourcesList = objResourcesList;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View itemView = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.resources_row,viewGroup,false);

        return new ContactViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder contactViewHolder, int i) {
        ObjResource or = objResourcesList.get(i);
        contactViewHolder.setData(or);
    }

    @Override
    public int getItemCount() {
        return objResourcesList.size();
    }


    public class  ContactViewHolder extends RecyclerView.ViewHolder{
        private ImageView image;
        private TextView link;
        public ContactViewHolder(@NonNull View v) {
            super(v);
            image =(ImageView)v.findViewById(R.id.imagefromCamera);
            link = (TextView)v.findViewById(R.id.tvLinkResource);
        }

        public void setData(ObjResource or){
            image.setImageBitmap(or.getImage());
            link.setText(or.getLink());

        }
    }
}

