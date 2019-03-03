package nl.example.myapplication;


import android.support.annotation.NonNull;

import com.cleveroad.slidingtutorial.Direction;
import com.cleveroad.slidingtutorial.PageFragment;
import com.cleveroad.slidingtutorial.TransformItem;

public class ThirdCustomPageFragment extends PageFragment {

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_page_third;
    }

    @NonNull
    @Override
    protected TransformItem[] getTransformItems() {
        return new TransformItem[]{
                TransformItem.create(R.id.tutorialPageTree, Direction.RIGHT_TO_LEFT, 0.02f),
                TransformItem.create(R.id.tutorialPageTree2, Direction.LEFT_TO_RIGHT, 0.02f),
                TransformItem.create(R.id.tutorialPageTree3, Direction.RIGHT_TO_LEFT, 0.02f),
                TransformItem.create(R.id.tutorialPageTree4, Direction.LEFT_TO_RIGHT, 0.01f),
//                TransformItem.create(R.id.ivFifthImage, Direction.LEFT_TO_RIGHT, 0.03f),
//                TransformItem.create(R.id.ivSixthImage, Direction.LEFT_TO_RIGHT, 0.09f),
//                TransformItem.create(R.id.ivSeventhImage, Direction.LEFT_TO_RIGHT, 0.14f),
        };
    }
}