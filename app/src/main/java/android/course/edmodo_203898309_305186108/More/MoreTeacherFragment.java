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
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoreTeacherFragment extends Fragment {
    private Button btnProfile;
    private UserPrfile userPrfile;
    private ImageView imageP;
    private TextView nameP;
    private TextView typeP;

    public MoreTeacherFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_more_teacher, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        MyEdmodoDBManager.getInstance().openDataBase(getContext());
        btnProfile = (Button)getActivity().findViewById(R.id.mor_my_profile);

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),UserProfileActivity.class);
                startActivity(i);
            }
        });

        imageP = (ImageView)getActivity().findViewById(R.id.imagTecher);
        nameP = (TextView)getActivity().findViewById(R.id.nameTecher);
        typeP = (TextView)getActivity().findViewById(R.id.typrTecher);


        switch (MainActivity.idUser){
            case 4:
                userPrfile =  MyEdmodoDBManager.getInstance().readuser(4);
                break;
            case 5:
                userPrfile =  MyEdmodoDBManager.getInstance().readuser(5);
                break;
            case 6:
                userPrfile =  MyEdmodoDBManager.getInstance().readuser(6);
                break;
        }

        imageP.setImageBitmap(userPrfile.getId_ImageProfile());
        nameP.setText(userPrfile.getName());
        typeP.setText(userPrfile.getType());
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.search, menu);
    }
}
