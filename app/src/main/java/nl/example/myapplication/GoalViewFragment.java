package nl.example.myapplication;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.lang.annotation.Target;
import java.util.List;


///**
// * A simple {@link Fragment} subclass.
// * Activities that contain this fragment must implement the
// * {@link GoalViewFragment.OnFragmentInteractionListener} interface
// * to handle interaction events.
// * Use the {@link GoalViewFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class GoalViewFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private static final String GOAL_ID = "mgoalId";
    private static final String COLUMN_ID = "COLUMN_ID";
    private static final String COLUMN_GOAL = "COLUMN_GOAL";
    private static final String COLUMN_WHERE = "COLUMN_WHERE";
    private static final String COLUMN_WHEN = "COLUMN_WHEN";
    private static final String COLUMN_HOW = "COLUMN_HOW";
    private static final String COLUMN_MORE = "COLUMN_MORE";
    private static final String POSITIVE_THOUGHT = "POSITIVE_THOUGHT";
    private static final String MOODBOARD = "MOODBOARD";


    // TODO: Rename and change types of parameters
    private Long mgoalId;
    private Long mCOLUMN_ID;
    private String mGoal;
    private String mWhere;
    private String mWhen;
    private String mHow;
    private String mMore;
    private String mPositiveThought;
    private String mMoodboard;

    MainModel mainModel;
    MoodBoardDatabaseHelper moodBoardDatabaseHelper;
    PositiveThoughtsDatabaseHelper positiveThoughtsDatabaseHelper;

    List<Long> mGetGoalIds;


    TextView positiveThoughtText, positive2ThoughtText, positive3ThoughtText, positive4ThoughtText, positive5ThoughtText ;
    TextView goalText, whereText, whenText, howText, moreText;

    ImageView moodBoardImage, moodBoardImage1, moodBoardImage2, moodBoardImage3, moodBoardImage4,
            moodBoardImage5, moodBoardImage6, moodBoardImage7, moodBoardImage8;

//    private OnFragmentInteractionListener mListener;

    public GoalViewFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static GoalViewFragment newInstance(Long goalId, Long COLUMN_IDs, String goal,
                                               String where, String when, String how,
                                               String more, String positiveThought, String moodboard) {
        GoalViewFragment fragment = new GoalViewFragment();
        Bundle args = new Bundle();
        args.putLong(GOAL_ID, goalId);
        args.putLong(COLUMN_ID, COLUMN_IDs);
        args.putString(COLUMN_GOAL, goal);
        args.putString(COLUMN_WHERE, where);
        args.putString(COLUMN_WHEN, when);
        args.putString(COLUMN_HOW, how);
        args.putString(COLUMN_MORE, more);
        args.putString(POSITIVE_THOUGHT, positiveThought);
        args.putString(MOODBOARD, moodboard);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            mgoalId = getArguments().getLong(GOAL_ID);
            mCOLUMN_ID = getArguments().getLong(COLUMN_ID);
            mGoal = getArguments().getString(COLUMN_GOAL);
            mWhere = getArguments().getString(COLUMN_WHERE);
            mWhen = getArguments().getString(COLUMN_WHEN);
            mHow = getArguments().getString(COLUMN_HOW);
            mMore = getArguments().getString(COLUMN_MORE);
            mPositiveThought = getArguments().getString(POSITIVE_THOUGHT);
            mMoodboard = getArguments().getString(MOODBOARD);

        }
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_goal_view, container, false);

        mainModel = new MainModel();
        mainModel.initialize(getContext());

        positiveThoughtsDatabaseHelper = new PositiveThoughtsDatabaseHelper(getContext());
        moodBoardDatabaseHelper = new MoodBoardDatabaseHelper(getContext());

        mGetGoalIds = mainModel.getGoalIds();

        goalText = view.findViewById(R.id.textViewGoal);
        whereText = view.findViewById(R.id.textViewWhere);
        whenText = view.findViewById(R.id.textViewWhen);
        howText = view.findViewById(R.id.textViewHow);
//        preciseText = findViewById(R.id.textViewPrecise);
        moreText = view.findViewById(R.id.textViewMore);


        goalText.setText(mGoal);
        whereText.setText(mWhere);
        whenText.setText(mWhen);
        howText.setText(mHow);
//        preciseText.setText(intent.getStringExtra("COLUMN_PRECISE"));
        moreText.setText(mMore);

        moodBoardImage = view.findViewById(R.id.imageView2);
                moodBoardImage1 = view.findViewById(R.id.imageView3);
                moodBoardImage2 = view.findViewById(R.id.imageView4);
                moodBoardImage3 = view.findViewById(R.id.imageView5);
                moodBoardImage4 = view.findViewById(R.id.imageView6);
                moodBoardImage5 = view.findViewById(R.id.imageView7);
                moodBoardImage6 = view.findViewById(R.id.imageView8);
                moodBoardImage7 = view.findViewById(R.id.imageView9);
                moodBoardImage8 = view.findViewById(R.id.imageView10);

                List<String> imageUrls = moodBoardDatabaseHelper.getImageUrlsFor(mgoalId);

        if (imageUrls.size() > 0) {
        moodBoardImage.setImageURI(Uri.parse(imageUrls.get(0)));
        } if (imageUrls.size() > 1) {
        moodBoardImage1.setImageURI(Uri.parse(imageUrls.get(1)));
        }if (imageUrls.size() > 2) {
        moodBoardImage2.setImageURI(Uri.parse(imageUrls.get(2)));
        }if (imageUrls.size() > 3) {
        moodBoardImage3.setImageURI(Uri.parse(imageUrls.get(3)));
        }if (imageUrls.size() > 4) {
        moodBoardImage4.setImageURI(Uri.parse(imageUrls.get(4)));
        }if (imageUrls.size() > 5) {
        moodBoardImage5.setImageURI(Uri.parse(imageUrls.get(5)));
        }if (imageUrls.size() > 6) {
        moodBoardImage6.setImageURI(Uri.parse(imageUrls.get(6)));
        }if (imageUrls.size() > 7) {
        moodBoardImage7.setImageURI(Uri.parse(imageUrls.get(7)));
        }if (imageUrls.size() > 8) {
        moodBoardImage8.setImageURI(Uri.parse(imageUrls.get(8)));
        }



        positiveThoughtText = view.findViewById(R.id.textViewPositiveThought);
        positive2ThoughtText = view.findViewById(R.id.textViewPositiveThought2);
        positive3ThoughtText = view.findViewById(R.id.textViewPositiveThought3);
        positive4ThoughtText = view.findViewById(R.id.textViewPositiveThought4);
        positive5ThoughtText = view.findViewById(R.id.textViewPositiveThought5);


        List<String> positiveThoughts = positiveThoughtsDatabaseHelper.getPositiveThoughtsFor(mgoalId);

        if (positiveThoughts.size() > 0) {
            positiveThoughtText.setText(positiveThoughts.get(0));
        }if (positiveThoughts.size() > 1) {
            positive2ThoughtText.setText(positiveThoughts.get(1));
        }if (positiveThoughts.size() > 2) {
            positive3ThoughtText.setText(positiveThoughts.get(2));
        }if (positiveThoughts.size() > 3) {
            positive4ThoughtText.setText(positiveThoughts.get(3));
        }if (positiveThoughts.size() > 4) {
            positive5ThoughtText.setText(positiveThoughts.get(4));
        }


        return view;
    }





//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
}













//
//        moodBoardImage = view.findViewById(R.id.imageView2);
//                moodBoardImage1 = view.findViewById(R.id.imageView3);
//                moodBoardImage2 = view.findViewById(R.id.imageView4);
//                moodBoardImage3 = view.findViewById(R.id.imageView5);
//                moodBoardImage4 = view.findViewById(R.id.imageView6);
//                moodBoardImage5 = view.findViewById(R.id.imageView7);
//                moodBoardImage6 = view.findViewById(R.id.imageView8);
//                moodBoardImage7 = view.findViewById(R.id.imageView9);
//                moodBoardImage8 = view.findViewById(R.id.imageView10);
//
//                List<String> imageUrls = moodBoardDatabaseHelper.getImageUrlsFor(mgoalId);
//
//        if (imageUrls.size() > 0) {
//        moodBoardImage.setImageURI(Uri.parse(imageUrls.get(0)));
//        } if (imageUrls.size() > 1) {
//        moodBoardImage1.setImageURI(Uri.parse(imageUrls.get(1)));
//        }if (imageUrls.size() > 2) {
//        moodBoardImage2.setImageURI(Uri.parse(imageUrls.get(2)));
//        }if (imageUrls.size() > 3) {
//        moodBoardImage3.setImageURI(Uri.parse(imageUrls.get(3)));
//        }if (imageUrls.size() > 4) {
//        moodBoardImage4.setImageURI(Uri.parse(imageUrls.get(4)));
//        }if (imageUrls.size() > 5) {
//        moodBoardImage5.setImageURI(Uri.parse(imageUrls.get(5)));
//        }if (imageUrls.size() > 6) {
//        moodBoardImage6.setImageURI(Uri.parse(imageUrls.get(6)));
//        }if (imageUrls.size() > 7) {
//        moodBoardImage7.setImageURI(Uri.parse(imageUrls.get(7)));
//        }if (imageUrls.size() > 8) {
//        moodBoardImage8.setImageURI(Uri.parse(imageUrls.get(8)));
//        }