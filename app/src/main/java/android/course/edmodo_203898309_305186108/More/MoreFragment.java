package android.course.edmodo_203898309_305186108.More;


import android.content.Intent;
import android.course.edmodo_203898309_305186108.Fclasses.UserPrfile;
import android.course.edmodo_203898309_305186108.MainActivity;
import android.course.edmodo_203898309_305186108.MyEdmodoDBManager;
import android.course.edmodo_203898309_305186108.R;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoreFragment extends Fragment {
    private Button btnProfile;
    UserPrfile userPrfile;
    ImageView imageP;
    TextView nameP;
    TextView typeP;
    public MoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_more, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btnProfile = (Button)getActivity().findViewById(R.id.mor_my_profile);
        MyEdmodoDBManager.getInstance().openDataBase(getContext());
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),UserProfileActivity.class);
                startActivity(i);
            }
        });
         imageP = (ImageView)getActivity().findViewById(R.id.MoreImageP);
         nameP = (TextView)getActivity().findViewById(R.id.MoreNameP);
         typeP = (TextView)getActivity().findViewById(R.id.MoreTypeP);

        switch (MainActivity.idUser){
            case 1:
                userPrfile =  MyEdmodoDBManager.getInstance().readuser(1);
                break;
            case 2:
                userPrfile =  MyEdmodoDBManager.getInstance().readuser(2);
                break;
            case 3:
                userPrfile =  MyEdmodoDBManager.getInstance().readuser(3);
                break;
        }

        imageP.setImageBitmap(userPrfile.getId_ImageProfile());
        nameP.setText(userPrfile.getName());
        typeP.setText(userPrfile.getType());

    }
}
