package com.example.home.officesnitch;

import android.support.v4.app.Fragment;

/**
 * Created by Home on 4/5/18.
 */

public class CrimeListActivity extends SingleFragmentActivity{
    @Override
    protected Fragment createFragment(){
        return new CrimeListFragment();
    }


}
