package nl.example.myapplication;

import android.support.annotation.NonNull;

import com.cleveroad.slidingtutorial.Direction;
import com.cleveroad.slidingtutorial.PageFragment;
import com.cleveroad.slidingtutorial.TransformItem;

public class SecondCustomPageFragment extends PageFragment {

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_page_second;
    }

    @NonNull
    @Override
    protected TransformItem[] getTransformItems() {
        return new TransformItem[]{
                TransformItem.create(R.id.tutorialPageTwo1, Direction.RIGHT_TO_LEFT, 0.02f),
                TransformItem.create(R.id.tutorialPageTwo2, Direction.LEFT_TO_RIGHT, 0.06f),
//                TransformItem.create(R.id.tutorialPageTwo3, Direction.RIGHT_TO_LEFT, 0.08f),
//                TransformItem.create(R.id.tutorialPageTwo4, Direction.LEFT_TO_RIGHT, 0.1f),
                TransformItem.create(R.id.tutorialPageTwo5, Direction.LEFT_TO_RIGHT, 0.03f),
                TransformItem.create(R.id.tutorialPageTwo6, Direction.LEFT_TO_RIGHT, 0.09f),
                TransformItem.create(R.id.tutorialPageTwo7, Direction.LEFT_TO_RIGHT, 0.04f),
                TransformItem.create(R.id.tutorialPageTwo8, Direction.LEFT_TO_RIGHT, 0.07f)
        };
    }
}