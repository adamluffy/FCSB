package utility;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

public class FragmentUtility {

    public static void setFragment(FragmentActivity activity, int containerId, Fragment fragment){

        activity.getSupportFragmentManager().beginTransaction()
                .replace(containerId,fragment)
                .commit();
    }
}
