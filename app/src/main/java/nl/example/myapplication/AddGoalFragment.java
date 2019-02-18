package nl.example.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AddGoalFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AddGoalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddGoalFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String GOAL_ID = "GOAL_ID";
    private static final String ARG_PARAM2 = "param2";

    GoalDatabaseHelper goalDatabaseHelper;
    ImageButton nextToBtn;
    EditText goalEditText, whereEditText, whenEditText, howEditText,moreEditText;
    MainModel mainModel;
    List<Long> mGetGoalIds;

    // TODO: Rename and change types of parameters
    public Long mgoalId;
    private String mParam2;

//    private OnFragmentInteractionListener mListener;

    public AddGoalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddGoalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddGoalFragment newInstance(Long goalId) {
        AddGoalFragment fragment = new AddGoalFragment();
        Bundle args = new Bundle();
        args.putLong(GOAL_ID, goalId);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mgoalId = getArguments().getLong(GOAL_ID);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_add_goal, container, false);

        goalDatabaseHelper = new GoalDatabaseHelper(this.getContext());

        goalEditText = view.findViewById(R.id.goalEditText);
        whereEditText = view.findViewById(R.id.whereEditText);
        whenEditText = view.findViewById(R.id.whenEditText);
        howEditText = view.findViewById(R.id.howEditText);
//        preciseEditText = findViewById(R.id.preciseEditText);
        moreEditText = view.findViewById(R.id.moreEditText);

        nextToBtn = view.findViewById(R.id.nextToBtn);
        nextToBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String goal = goalEditText.getText().toString();
                String mWhere = whereEditText.getText().toString();
                String mWhen = whenEditText.getText().toString();
                String how = howEditText.getText().toString();
//                String precise = preciseEditText.getText().toString();
                String more = moreEditText.getText().toString();

                long mgoalId = goalDatabaseHelper.insertData(goal, mWhere, mWhen, how, more);
                if (mgoalId > 0) {
                    Toast.makeText(getContext(), "DataSaved", Toast.LENGTH_LONG).show();
                    PositiveThoughtFragment nextFrag= new PositiveThoughtFragment().newInstance(mgoalId);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content, nextFrag, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
//
//                    Toast.makeText(GoalActivity.this, "DataSaved", Toast.LENGTH_LONG).show();
//                    Intent nextToIntent = new Intent(GoalActivity.this, PositiveThoughtsActivity.class);
//                    nextToIntent.putExtra("GOAL_ID", GOAL_ID);
//                    startActivity(nextToIntent);
                }
            }
        });


//        nextGoalBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AddGoalFragment nextFrag= new AddGoalFragment();
//                getActivity().getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.content, nextFrag, "findThisFragment")
//                        .addToBackStack(null)
//                        .commit();

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
