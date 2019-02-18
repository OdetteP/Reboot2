package nl.example.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_my_goals:
                    MyGoalListFragment someFragment = new MyGoalListFragment();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.content, someFragment );
                    transaction.addToBackStack(null);
                    transaction.commit();
                    return true;
                case R.id.navigation_new_goal:
                    AddGoalMainPageFragment addGoalMainPageFragment = new AddGoalMainPageFragment();
                    FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                    transaction1.replace(R.id.content, addGoalMainPageFragment );
                    transaction1.addToBackStack(null);
                    transaction1.commit();
                    return true;
                case R.id.navigation_me:
                    MeFragment meFragment = new MeFragment();
                    FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
                    transaction2.replace(R.id.content, meFragment );
                    transaction2.addToBackStack(null);
                    transaction2.commit();
                    return true;
                case R.id.navigation_settings:
//                    SettingFragment settingFragment = new SettingFragment();
//                    FragmentTransaction transaction3 = getSupportFragmentManager().beginTransaction();
//                    transaction3.replace(R.id.content, settingFragment );
//                    transaction3.addToBackStack(null);
//                    transaction3.commit();
                    return true;
            }

            return true;
        }
    };

    private DrawerLayout mDrawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.content);


        notifications ();

    }




    private void notifications () {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "default");

        builder.setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setTicker("Hearty365")
                .setSmallIcon(R.drawable.next2)
                .setContentTitle("Maand update")
                .setContentText("Houd nu je maanden bij ")
                .setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_SOUND)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setCategory(NotificationCompat.CATEGORY_REMINDER)
                // Set the intent that will fire when the user taps the notification
                .setContentIntent(contentIntent)
                .setAutoCancel(true);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        preferences.getBoolean("notification", false);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(1, builder.build());

    }

}
