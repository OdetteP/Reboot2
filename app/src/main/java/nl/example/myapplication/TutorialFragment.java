package nl.example.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cleveroad.slidingtutorial.Direction;
import com.cleveroad.slidingtutorial.PageOptions;
import com.cleveroad.slidingtutorial.TransformItem;
import com.cleveroad.slidingtutorial.TutorialPageOptionsProvider;


public class TutorialFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public TutorialFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static TutorialFragment newInstance(String param1, String param2) {
//        Bundle args = new Bundle();

//        TutorialFragment tutorialPageOptionsProvider = new TutorialFragment() {
//            @NonNull
//            @Override
//            public PageOptions provide(int position) {
//                @LayoutRes int pageLayoutResId;
//                TransformItem[] tutorialItems;
//                switch (position) {
//                    case 0: {
//                        pageLayoutResId = R.layout.fragment_page_first;
//                        tutorialItems = new TransformItem[]{
//                                TransformItem.create(R.id.ivFirstImage, Direction.LEFT_TO_RIGHT, 0.2f),
//                                TransformItem.create(R.id.ivEighthImage, Direction.RIGHT_TO_LEFT, 0.07f)
//                        };
//                        break;
//                    }
//                    case 1: {
//                        pageLayoutResId = R.layout.fragment_page_second;
//                        tutorialItems = new TransformItem[]{
//                                TransformItem.create(R.id.ivFirstImage, Direction.RIGHT_TO_LEFT, 0.2f),
//                                TransformItem.create(R.id.ivEighthImage, Direction.LEFT_TO_RIGHT, 0.07f)
//                        };
//                        break;
//                    }
//                    case 2: {
//                        pageLayoutResId = R.layout.fragment_page_third;
//                        tutorialItems = new TransformItem[]{
//                                TransformItem.create(R.id.ivFirstImage, Direction.RIGHT_TO_LEFT, 0.2f),
//                                TransformItem.create(R.id.ivSeventhImage, Direction.LEFT_TO_RIGHT, 0.14f)
//                        };
//                        break;
//                    }
//                    default: {
//                        throw new IllegalArgumentException("Unknown position: " + position);
//                    }
//                }
//
//                return PageOptions.create(pageLayoutResId, position, tutorialItems);
//            }
//        };


//
//
//        fragment.setArguments(args);
//        return fragment;
        return null;
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
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_tutorial, container, false);

//
//        final TutorialPageOptionsProvider tutorialPageOptionsProvider = new TutorialPageOptionsProvider() {
//            @NonNull
//            @Override
//            public PageOptions provide(int position) {
//                @LayoutRes int pageLayoutResId;
//                TransformItem[] tutorialItems;
//                switch (position) {
//                    case 0: {
//                        pageLayoutResId = R.layout.fragment_page_first;
//                        tutorialItems = new TransformItem[]{
//                                TransformItem.create(R.id.ivFirstImage, Direction.LEFT_TO_RIGHT, 0.2f),
//                        TransformItem.create(R.id.ivEighthImage, Direction.RIGHT_TO_LEFT, 0.07f)
//				};
//                        break;
//                    }
//                    case 1: {
//                        pageLayoutResId = R.layout.fragment_page_second;
//                        tutorialItems = new TransformItem[]{
//                                TransformItem.create(R.id.ivFirstImage, Direction.RIGHT_TO_LEFT, 0.2f),
//                        TransformItem.create(R.id.ivEighthImage, Direction.LEFT_TO_RIGHT, 0.07f)
//				};
//                        break;
//                    }
//                    case 2: {
//                        pageLayoutResId = R.layout.fragment_page_third;
//                        tutorialItems = new TransformItem[]{
//                                TransformItem.create(R.id.ivFirstImage, Direction.RIGHT_TO_LEFT, 0.2f),
//                        TransformItem.create(R.id.ivSeventhImage, Direction.LEFT_TO_RIGHT, 0.14f)
//				};
//                        break;
//                    }
//                    default: {
//                        throw new IllegalArgumentException("Unknown position: " + position);
//                    }
//                }
//
//                return PageOptions.create(pageLayoutResId, position, tutorialItems);
//            }
//        };



        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
