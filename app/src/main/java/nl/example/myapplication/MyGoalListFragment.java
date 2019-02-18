package nl.example.myapplication;

import android.content.Context;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;
import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MyGoalListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MyGoalListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyGoalListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    ListView goalListView;
    MainModel mainModel;
    List<Long> mGetGoalIds;
    List<String> mGoals;
    public Long mgoalId;

    String[] mGetGoal;
    String[] mGetWhereWhenHow;
    String[] mGetWhen;
    String[] mGetHow;
    //    String[] mGetPrecise;
    String[] mGetMore;
    String [] mGetPositiveThought;
    String [] getImages;

    PositiveThoughtsDatabaseHelper positiveThoughtsDatabaseHelper;
    MoodBoardDatabaseHelper moodBoardDatabaseHelper;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

//    private OnFragmentInteractionListener mListener;

    public MyGoalListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyGoalListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyGoalListFragment newInstance(String param1, String param2) {
        MyGoalListFragment fragment = new MyGoalListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_goal_list, container, false);


        goalListView = view.findViewById(R.id.goalListView);


        positiveThoughtsDatabaseHelper = new PositiveThoughtsDatabaseHelper(this.getContext());
        moodBoardDatabaseHelper = new MoodBoardDatabaseHelper(this.getContext());
        mainModel = new MainModel();
        mainModel.initialize(this.getContext());
        mGetGoalIds = mainModel.getGoalIds();

        mGoals = mainModel.getGoals();

        mGetGoal = mainModel.getGoal();
        mGetWhereWhenHow = mainModel.getWhere();
        mGetWhen = mainModel.getWhen();
        mGetHow = mainModel.getHow();
//        mGetPrecise = mainModel.getPrecise();
        mGetMore = mainModel.getMore();

        mGetGoalIds = mainModel.getGoalIds();

        DatabaseAdapter databaseAdapter = new DatabaseAdapter();
        goalListView.setAdapter(databaseAdapter);


//        nextGoalBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AddGoalFragment nextFrag= new AddGoalFragment();
//                getActivity().getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.content, nextFrag, "findThisFragment")
//                        .addToBackStack(null)
//                        .commit();



//                Intent nextGoalIntent = new Intent(ListOfGoalsActivity.this, GoalActivity.class);
//                nextGoalIntent.putExtra("mgoalId", mgoalId);
//                startActivity(nextGoalIntent);
//            }
//        });

                goalListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//                Intent intent = getIntent();
//                intent.putExtra("mgoalId", mGetGoalIds.get(i));

                getImages = moodBoardDatabaseHelper.getImageUrlsFor(Long.valueOf(mGetGoalIds.get(i))).toArray(new String[0]);
                mGetPositiveThought = positiveThoughtsDatabaseHelper.getPositiveThoughtsFor(Long.valueOf(mGetGoalIds.get(i))).toArray(new String[0]);

                GoalViewFragment nextFrag= new GoalViewFragment().newInstance(mGetGoalIds.get(i),mGetGoalIds.get(i),
                        mGetGoal[i], mGetWhereWhenHow[i],mGetWhen[i],  mGetHow[i], mGetMore[i],mGetPositiveThought[i],  getImages[i]);

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content, nextFrag, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }

    public class DatabaseAdapter implements ListAdapter {

        @Override
        public boolean areAllItemsEnabled() {
            return true;
        }

        @Override
        public boolean isEnabled(int i) {
            return true;
        }

        @Override
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {

        }

        @Override
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

        }

        @Override
        public int getCount() {
            return mGoals.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            view = getLayoutInflater().inflate(R.layout.detail_listview_main, null);

            TextView goalTextView = view.findViewById(R.id.goalTextView);

            goalTextView.setText(String.valueOf(mGoals.get(i)));


            return view;
        }

        @Override
        public int getItemViewType(int i) {
            return 0;
        }

        @Override
        public int getViewTypeCount() {
            return 1;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }
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
//
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
