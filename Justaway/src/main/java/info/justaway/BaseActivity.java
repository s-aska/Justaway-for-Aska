package info.justaway;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;

public class BaseActivity extends Activity {

    public void addFragment(Fragment fragment) {
        getFragmentManager().beginTransaction()
                .add(R.id.container, fragment)
                .addToBackStack(null)
                .commit();
    }

    public void pushFragment(Fragment fragment) {
        getFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit();
    }

    public void popFragment() {
        getFragmentManager().popBackStack();
    }

    public boolean popToTop() {
        FragmentManager manager = getFragmentManager();
        if (manager.getBackStackEntryCount() > 1) {
            manager.popBackStack(
                    manager.getBackStackEntryAt(1).getId(),
                    FragmentManager.POP_BACK_STACK_INCLUSIVE);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 1) {
            popFragment();
        } else {
            finish();
        }
    }
}
