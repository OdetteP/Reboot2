package nl.example.myapplication;


import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;

import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.widget.Toast;

import java.util.Calendar;


public class SettingsFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener {

    private static final String NOTIFICATION = "NOTIFICATION";
    private static final String KEY_PREF_DAILY_NOTIFICATION = "KEY_PREF_DAILY_NOTIFICATION";
    SharedPreferences.OnSharedPreferenceChangeListener listener;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
//        Preference pref;

//        getPreferenceManager().setSharedPreferencesName("example_list");
//        getPreferenceManager().setSharedPreferencesName("NOTIFICATION");

        addPreferencesFromResource(R.xml.settings);

        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }




//        prefs.registerOnSharedPreferenceChangeListener(
//                new SharedPreferences.OnSharedPreferenceChangeListener() {
//                    public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {
//                        // Implementation
//                    }
//                });
//        onSharedPreferenceChanged(null, "");
//        findPreference("Text").setEnabled(false);

//        PreferenceManager.setDefaultValues(getActivity(),R.xml.settings, false);
//        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getContext());
//        Boolean dailyNotify = sharedPref.getBoolean(SettingsFragment.KEY_PREF_DAILY_NOTIFICATION, true);
//        PackageManager pm = getActivity().getPackageManager();
//        ComponentName receiver = new ComponentName(getActivity(), DeviceBootReceiver.class);
//        Intent alarmIntent = new Intent(getContext(), AlarmReceiver.class);
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(getContext(), 0, alarmIntent, 0);
//        AlarmManager manager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
//
//// if user enabled daily notifications
//        if (dailyNotify) {
//            //region Enable Daily Notifications
//            Calendar calendar = Calendar.getInstance();
//            calendar.setTimeInMillis(System.currentTimeMillis());
//            calendar.set(Calendar.HOUR_OF_DAY, sharedPref.getInt("dailyNotificationHour", 7));
//            calendar.set(Calendar.MINUTE, sharedPref.getInt("dailyNotificationMin", 15));
//            calendar.set(Calendar.SECOND, 1);
//            // if notification time is before selected time, send notification the next day
//            if (calendar.before(Calendar.getInstance())) {
//                calendar.add(Calendar.DATE, 1);
//            }
//            if (manager != null) {
//                manager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
//                        AlarmManager.INTERVAL_DAY, pendingIntent);
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                    manager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
//                }
//            }
//            //To enable Boot Receiver class
//            pm.setComponentEnabledSetting(receiver,
//                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
//                    PackageManager.DONT_KILL_APP);
//            //endregion
//        } else { //Disable Daily Notifications
//            if (PendingIntent.getBroadcast(getContext(), 0, alarmIntent, 0) != null && manager != null) {
//                manager.cancel(pendingIntent);
//                //Toast.makeText(this,"Notifications were disabled",Toast.LENGTH_SHORT).show();
//            }
//            pm.setComponentEnabledSetting(receiver,
//                    PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
//                    PackageManager.DONT_KILL_APP);
//        }


    @Override
    public void onCreatePreferences(Bundle bundle, String s) {

    }

    @Override
    public void onResume() {
        super.onResume();
        // Set up a listener whenever a key changes
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        // Set up a listener whenever a key changes
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

    private void setNotification(String when) {
                    if (when.equals("2")) {
                        Toast.makeText(getContext(), "Notificatie 2x per dag", Toast.LENGTH_SHORT).show();
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(Calendar.HOUR_OF_DAY, 7);
                        calendar.set(Calendar.MINUTE, 30);
                        calendar.set(Calendar.SECOND, 0);
                        Intent intent1 = new Intent(getActivity(), AlarmReceiver.class);
                        PendingIntent pendingIntent = PendingIntent.getBroadcast(getActivity(), 0, intent1, PendingIntent.FLAG_UPDATE_CURRENT);
                        AlarmManager am = (AlarmManager) getActivity().getSystemService(getActivity().ALARM_SERVICE);
                        am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_HALF_DAY, pendingIntent);

                    } else if (when.equals("1")) {
                        Toast.makeText(getContext(), "Noticifactie 1x per dag ", Toast.LENGTH_SHORT).show();
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(Calendar.HOUR_OF_DAY, 7);
                        calendar.set(Calendar.MINUTE, 30);
                        calendar.set(Calendar.SECOND, 0);
                        Intent intent1 = new Intent(getActivity(), AlarmReceiver.class);
                        PendingIntent pendingIntent = PendingIntent.getBroadcast(getActivity(), 0, intent1, PendingIntent.FLAG_UPDATE_CURRENT);
                        AlarmManager am = (AlarmManager) getActivity().getSystemService(getActivity().ALARM_SERVICE);
                        am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);

                    } else if (when.equals("0")) {
                        Toast.makeText(getContext(), "Notificatie 1x in de week ", Toast.LENGTH_SHORT).show();
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(Calendar.HOUR_OF_DAY, 7);
                        calendar.set(Calendar.MINUTE, 30);
                        calendar.set(Calendar.SECOND, 0);
                        Intent intent1 = new Intent(getActivity(), AlarmReceiver.class);
                        PendingIntent pendingIntent = PendingIntent.getBroadcast(getActivity(), 0, intent1, PendingIntent.FLAG_UPDATE_CURRENT);
                        AlarmManager am = (AlarmManager) getActivity().getSystemService(getActivity().ALARM_SERVICE);
                        am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY * 2, pendingIntent);

                    } else if (when.equals("-1")) {
                        Toast.makeText(getContext(), "Nooit", Toast.LENGTH_SHORT).show();
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(Calendar.HOUR_OF_DAY, 7);
                        calendar.set(Calendar.MINUTE, 30);
                        calendar.set(Calendar.SECOND, 0);
                        Intent intent1 = new Intent(getActivity(), AlarmReceiver.class);
                        PendingIntent pendingIntent = PendingIntent.getBroadcast(getActivity(), 0, intent1, PendingIntent.FLAG_UPDATE_CURRENT);
                        AlarmManager am = (AlarmManager) getActivity().getSystemService(getActivity().ALARM_SERVICE);
                        am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY * 2000, pendingIntent);
                    }

    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        String valueString = sharedPreferences.getString("example_list", "");
        setNotification(valueString);
    }
}

