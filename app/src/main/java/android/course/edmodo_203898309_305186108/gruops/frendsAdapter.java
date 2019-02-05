package android.course.edmodo_203898309_305186108.gruops;

import android.app.Activity;
import android.content.Context;

import android.course.edmodo_203898309_305186108.R;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class frendsAdapter extends RecyclerView.Adapter<frendsAdapter.ContactViewHolder> {
    ContactViewHolder contactViewHolder;
    private List<frands> dataList = null;
    private Activity context = null;


    public frendsAdapter( Context context, List<frands> data) {
        this.dataList=data;
        this.context=(Activity)context;

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.frends_row, viewGroup, false);
        contactViewHolder = new frendsAdapter.ContactViewHolder(itemView);
        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder contactViewHolder, int position) {
        frands fr = dataList.get(position);
        contactViewHolder.setData(fr);
    }



    public  class ContactViewHolder extends RecyclerView.ViewHolder {

        private TextView textName;
        private TextView textType;
        private TextView textnicName;
        private  ImageView imagFrend;
        private frands fr = null;


        public ContactViewHolder(View v) {
            super(v);
             textName = (TextView) v.findViewById(R.id.tvNameFrends);
             textType = (TextView) v.findViewById(R.id.tvtypeFrends);
             textnicName = (TextView) v.findViewById(R.id.tvnicenameFrends);
             imagFrend = (ImageView) v.findViewById(R.id.ivfrends);



        }

        public void setData(frands fr){
            this.fr = fr;
            textName.setText(fr.getUserPrfile().getName());
            textnicName.setText(fr.getNicname());
            textType.setText(fr.getUserPrfile().getType());
            imagFrend.setImageBitmap(fr.getUserPrfile().getId_ImageProfile());

        }
    }
}
