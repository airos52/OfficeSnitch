package com.example.home.officesnitch;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

public class CrimeActivity extends SingleFragmentActivity {

    private static final String EXTRA_CRIME_ID = "com.salazar.android.officesnitch.crime_id";

    public static Intent newIntent(Context context, UUID crimeID)
    {
        Intent intent = new Intent(context, CrimeActivity.class);
        intent.putExtra(EXTRA_CRIME_ID, crimeID);
        return intent;
    }


    @Override
    protected Fragment createFragment()
    {
        UUID id = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);
        return CrimeFragment.newInstance(id);
    }

}