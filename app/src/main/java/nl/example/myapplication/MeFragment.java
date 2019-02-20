package nl.example.myapplication;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;


public class MeFragment extends Fragment {
    private static int RESULT_LOAD_IMG = 0;
    private final int REQUEST_CODE_FOR_PERMISSIONS = 1001;
    MeDatabaseHelper mMeDatabaseHelper;
    private ArrayList<String> urls;

    public MeFragment() {

    }

    public static MeFragment newInstance(String param1, String param2) {
        MeFragment fragment = new MeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, container, false);

        mMeDatabaseHelper = new MeDatabaseHelper(getContext());

        Button addNewGoalButton = view.findViewById(R.id.add_goal_me_button);
        addNewGoalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddGoalMainPageFragment nextFrag = new AddGoalMainPageFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content, nextFrag, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

        ImageButton addNewPhoto = view.findViewById(R.id.add_own_photo);
        addNewPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                startActivityForResult(Intent.createChooser(i, "Select Picture"), RESULT_LOAD_IMG);
//                saveToSD();
            }

        });
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED &&
//                    ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE},
//                        REQUEST_CODE_FOR_PERMISSIONS);
//            }
//        }
        return view;
    }
//
//    public void saveToSD(Bitmap outputImage){
//        File storagePath = new File(Environment.getExternalStorageDirectory() + "/MyPhotos/");
//        storagePath.mkdirs();
//
//        File myImage = new File(storagePath, Long.toString(System.currentTimeMillis()) + ".jpg");
//
//        try {
//            FileOutputStream out = new FileOutputStream(myImage);
//            outputImage.compress(Bitmap.CompressFormat.JPEG, 80, out);
//            out.flush();
//            out.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void saveImage() {
//        mMeDatabaseHelper = new MeDatabaseHelper(getContext());
////            for (int image = 0; image < urls.size(); image++) {
//                mMeDatabaseHelper.insertDestinationURLForPhoto(urls.get(1));
//        }
//

//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == RESULT_LOAD_IMG) {
//            Uri selectedImage = data.getData();
//            urls.add(String.valueOf(selectedImage));
//            mMeDatabaseHelper.getImageUrlsForPhoto();
//
//        }
//    }
}
