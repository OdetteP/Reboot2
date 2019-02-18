package nl.example.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * to handle interaction events.
 * Use the {@link AddGoalMainPageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddGoalMainPageFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String mgoalId = "mgoalId";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
//    private Long mgoalId;
    private String mParam2;

   // private OnFragmentInteractionListener mListener;

    ImageButton addNewGoalBtn;
    MainModel mainModel;
    List<Long> mGetGoalIds;



    public AddGoalMainPageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment AddGoalMainPageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddGoalMainPageFragment newInstance(Long goalIds) {
        AddGoalMainPageFragment fragment = new AddGoalMainPageFragment();
        Bundle args = new Bundle();
//        args.putLong(mgoalId, goalIds);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
//            mgoalId = getArguments().getLong(mgoalId);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_add_goal_main_page, container, false);

        mainModel = new MainModel();
        mainModel.initialize(this.getContext());
        mGetGoalIds = mainModel.getGoalIds();

        addNewGoalBtn = view.findViewById(R.id.add_new_goal_btn);
        addNewGoalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    AddGoalFragment nextFrag = new AddGoalFragment();
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content, nextFrag, "findThisFragment")
                            .addToBackStack(null)
                            .commit();

            }
        });
    return view;
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
      //  mListener = null;
    }

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
