package nl.example.myapplication;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class TutorialActivity extends Activity implements View.OnClickListener {


    public static void start(Context context) {
        context.startActivity(new Intent(context, TutorialActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        findViewById(R.id.bRetry).setOnClickListener(this);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        Boolean hasSeenTutorial = preferences.getBoolean("HasSeenTutorial", false);
        if (!hasSeenTutorial){
            replaceTutorialFragment();
        } else {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bRetry:
                replaceTutorialFragment();
                break;
        }
    }

    public void replaceTutorialFragment() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.container2, CustomTutorialFragment.newInstance())
                .commit();
    }
}
