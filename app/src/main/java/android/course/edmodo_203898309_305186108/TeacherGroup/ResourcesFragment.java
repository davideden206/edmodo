package android.course.edmodo_203898309_305186108.TeacherGroup;


import android.app.AlertDialog;
import android.app.Fragment;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.course.edmodo_203898309_305186108.AlertDialogLinkActivity;
import android.course.edmodo_203898309_305186108.Fclasses.MyClassesFragment;
import android.course.edmodo_203898309_305186108.MyEdmodoDBManager;
import android.course.edmodo_203898309_305186108.R;
import android.course.edmodo_203898309_305186108.gruops.ObjResource;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ActionMenuView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ResourcesFragment extends Fragment {
    RecyclerView lvRec;
    ImageView mImageView;
    FloatingActionButton floatingActionButtonItem1;
    FloatingActionButton floatingActionButtonItem2;
    FloatingActionButton floatingActionButtonItem3;
    private static final int REQUEST_IMAGE_CAPTURE=1;
    private static final int PICK_IMAGE = 2;
    ResourceAdapter resourceAdapter;
    Context context;
    Bundle savedInstanceState1;
    List<ObjResource> listObjResource;
    public ResourcesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context=inflater.getContext();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_resources, container, false);
    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        MyEdmodoDBManager.getInstance().openDataBase(getActivity());
        mImageView = (ImageView)getActivity().findViewById(R.id.imagefromCamera);
        lvRec = (RecyclerView) getActivity().findViewById(R.id.lvResources);
        LinearLayoutManager li = new LinearLayoutManager(getActivity());
        li.setOrientation(LinearLayoutManager.VERTICAL);
        lvRec.setLayoutManager(li);
        listObjResource = MyEdmodoDBManager.getInstance().allResourceInClass(MyClassesFragment.classid);
        resourceAdapter = new ResourceAdapter(listObjResource);
        savedInstanceState1 = savedInstanceState;


        lvRec.setAdapter(resourceAdapter);
        floatingActionButtonItem1 = (FloatingActionButton)getActivity().findViewById(R.id.item1);
        floatingActionButtonItem2 = (FloatingActionButton)getActivity().findViewById(R.id.item2);
        floatingActionButtonItem3 = (FloatingActionButton)getActivity().findViewById(R.id.item3);

        floatingActionButtonItem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
            }
        });
        floatingActionButtonItem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);

                startActivityForResult(intent, PICK_IMAGE);

            }
        });

        floatingActionButtonItem3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),AlertDialogLinkActivity.class);
                startActivity(i);

            }
        });

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == getActivity().RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            //mImageView.setImageBitmap(imageBitmap);
            ObjResource objResource = new ObjResource();
            objResource.setImage(imageBitmap);
            objResource.setClassesId(MyClassesFragment.classid);
            MyEdmodoDBManager.getInstance().addResource(objResource);

        }
        else if(requestCode== PICK_IMAGE){
            Uri imageUri = data.getData();
            Bitmap imageBitmap2 = null;
            try {
                imageBitmap2 = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(),imageUri);
            } catch (IOException e) {
                e.printStackTrace();
            }
            ObjResource objResource = new ObjResource();
            objResource.setImage(imageBitmap2);
            objResource.setClassesId(MyClassesFragment.classid);
            MyEdmodoDBManager.getInstance().addResource(objResource);

        }
    }

    @Override
    public void onResume() {
        MyEdmodoDBManager.getInstance().openDataBase(getActivity());

        onActivityCreated(savedInstanceState1);
        super.onResume();

    }


}