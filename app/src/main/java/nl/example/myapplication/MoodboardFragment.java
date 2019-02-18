package nl.example.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MoodboardFragment extends Fragment {
    private static final String GOAL_ID = "GOAL_ID";
    private final int REQUEST_CODE_FOR_PERMISSIONS = 1001;
    private static int RESULT_LOAD_IMG = 1;
    private static int RESULT_LOAD_IMG2 = 2;
    private static int RESULT_LOAD_IMG3 = 3;
    private static int RESULT_LOAD_IMG4 = 4;
    private static int RESULT_LOAD_IMG5 = 5;
    private static int RESULT_LOAD_IMG6 = 6;
    private static int RESULT_LOAD_IMG7 = 7;
    private static int RESULT_LOAD_IMG8 = 8;
    private static int RESULT_LOAD_IMG9 = 9;

    MoodBoardDatabaseHelper moodBoardDatabaseHelper;

    ImageView moodBoardImage, moodBoardImage2, moodBoardImage3, moodBoardImage4, moodBoardImage5,
            moodBoardImage6, moodBoardImage7, moodBoardImage8, moodBoardImage9;

    private ArrayList<String> urls;

    MainModel mainModel;
    List<Long> mGetGoalIds;
    public Long mgoalId;


    public MoodboardFragment() {
        // Required empty public constructor
    }


    public static MoodboardFragment newInstance(Long goalId) {
        MoodboardFragment fragment = new MoodboardFragment();
        Bundle args = new Bundle();
        args.putLong(GOAL_ID, goalId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mgoalId = getArguments().getLong(GOAL_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_moodboard, container, false);

        mainModel = new MainModel();
        mainModel.initialize(this.getContext());
        mGetGoalIds = mainModel.getGoalIds();

        urls = new ArrayList<>();

        moodBoardImage = view.findViewById(R.id.moodBoardImageView);
        moodBoardImage2 = view.findViewById(R.id.moodBoardImageView2);
        moodBoardImage3 = view.findViewById(R.id.moodBoardImageView3);
        moodBoardImage4 = view.findViewById(R.id.moodBoardImageView4);
        moodBoardImage5 = view.findViewById(R.id.moodBoardImageView5);
        moodBoardImage6 = view.findViewById(R.id.moodBoardImageView6);
        moodBoardImage7 = view.findViewById(R.id.moodBoardImageView7);
        moodBoardImage8 = view.findViewById(R.id.moodBoardImageView8);
        moodBoardImage9 = view.findViewById(R.id.moodBoardImageView9);

        moodBoardDatabaseHelper = new MoodBoardDatabaseHelper(getContext());

        ImageButton nextToMainBtn = view.findViewById(R.id.nextBtn);
        nextToMainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveImages();
                Toast.makeText(getContext(), "DataSaved", Toast.LENGTH_LONG).show();
                MyGoalListFragment nextFrag = new MyGoalListFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content, nextFrag, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

        moodBoardImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(Intent.createChooser(i, "Select Picture"), RESULT_LOAD_IMG);
            }
        });

        moodBoardImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(Intent.createChooser(i, "Select Picture"), RESULT_LOAD_IMG2);
            }
        });

        moodBoardImage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(Intent.createChooser(i, "Select Picture"), RESULT_LOAD_IMG3);
            }
        });

        moodBoardImage4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(Intent.createChooser(i, "Select Picture"), RESULT_LOAD_IMG4);
            }
        });

        moodBoardImage5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(Intent.createChooser(i, "Select Picture"), RESULT_LOAD_IMG5);
            }
        });

        moodBoardImage6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(Intent.createChooser(i, "Select Picture"), RESULT_LOAD_IMG6);
            }
        });

        moodBoardImage7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(Intent.createChooser(i, "Select Picture"), RESULT_LOAD_IMG7);
            }
        });

        moodBoardImage8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(Intent.createChooser(i, "Select Picture"), RESULT_LOAD_IMG8);
            }
        });

        moodBoardImage9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(Intent.createChooser(i, "Select Picture"), RESULT_LOAD_IMG9);
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED &&
                    ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_FOR_PERMISSIONS);
            }
        }
        return view;
    }

    private void saveImages() {
        moodBoardDatabaseHelper = new MoodBoardDatabaseHelper(getContext());
        for (int image = 0; image < urls.size(); image++) {
            moodBoardDatabaseHelper.insertDestinationURL(urls.get(image), mgoalId);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMG) {
            Uri selectedImage = data.getData();
            urls.add(String.valueOf(selectedImage));
            moodBoardImage.setImageURI(selectedImage);

        } else if (requestCode == RESULT_LOAD_IMG2) {
            Uri selectedImage = data.getData();
            urls.add(String.valueOf(selectedImage));
            moodBoardImage2.setImageURI(selectedImage);

        } else if (requestCode == RESULT_LOAD_IMG3) {
            Uri selectedImage3 = data.getData();
            urls.add(String.valueOf(selectedImage3));
            moodBoardImage3.setImageURI(selectedImage3);

        } else if (requestCode == RESULT_LOAD_IMG4) {
            Uri selectedImage3 = data.getData();
            urls.add(String.valueOf(selectedImage3));
            moodBoardImage4.setImageURI(selectedImage3);

        } else if (requestCode == RESULT_LOAD_IMG5) {
            Uri selectedImage3 = data.getData();
            urls.add(String.valueOf(selectedImage3));
            moodBoardImage5.setImageURI(selectedImage3);

        } else if (requestCode == RESULT_LOAD_IMG6) {
            Uri selectedImage3 = data.getData();
            urls.add(String.valueOf(selectedImage3));
            moodBoardImage6.setImageURI(selectedImage3);

        } else if (requestCode == RESULT_LOAD_IMG7) {
            Uri selectedImage3 = data.getData();
            urls.add(String.valueOf(selectedImage3));
            moodBoardImage7.setImageURI(selectedImage3);

        } else if (requestCode == RESULT_LOAD_IMG8) {
            Uri selectedImage3 = data.getData();
            urls.add(String.valueOf(selectedImage3));
            moodBoardImage8.setImageURI(selectedImage3);

        } else if (requestCode == RESULT_LOAD_IMG9) {
            Uri selectedImage3 = data.getData();
            urls.add(String.valueOf(selectedImage3));
            moodBoardImage9.setImageURI(selectedImage3);

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_FOR_PERMISSIONS) {
        }
    }

}
