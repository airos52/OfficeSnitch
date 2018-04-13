package com.example.home.officesnitch;

import android.content.Context;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

/**
 * Created by Home on 4/5/18.
 */

public class CrimeLab {

    private static CrimeLab sCrimeLab;
    private ArrayList<Crime> mCrimes;

    //contructor
    private CrimeLab(Context context){
        mCrimes = new ArrayList<Crime>();

        // BEGIN FUN DUMB THING
        ArrayList<String> dumbVerbs = new ArrayList<>();
        dumbVerbs.add("Belched ");
        dumbVerbs.add("Spat at ");
        dumbVerbs.add("Threw ");
        dumbVerbs.add("Hit ");
        dumbVerbs.add("Stole ");
        dumbVerbs.add("Punched ");
        dumbVerbs.add("Killed ");
        dumbVerbs.add("Made Lewd Gestures at ");

        ArrayList<String> dumbNouns = new ArrayList<>();
        dumbNouns.add("Corn Nuts");
        dumbNouns.add("Sally\'s Kid");
        dumbNouns.add("Lunch");
        dumbNouns.add("Wallet");
        dumbNouns.add("Red Swingline Stapler");
        dumbNouns.add("The Boss");
        dumbNouns.add("Phone");
        dumbNouns.add("The Happy Squirrel\'s");

        for (int i=0; 1<100; i++){
            Crime noob = new Crime();
            Random rando = new Random();
            noob.setSeverity(rando.nextInt(4));
            noob.setTitle(dumbVerbs.get(rando.nextInt(dumbVerbs.size()))+
                dumbNouns.get(rando.nextInt(dumbNouns.size())));
            noob.setSolved(rando.nextBoolean());
            mCrimes.add(noob);
        }

        // END FUN DUMB THING
    }

    public static CrimeLab get(Context context){
        if (sCrimeLab == null){
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    public ArrayList<Crime> getCrimes(){
        return mCrimes;
    }

    public Crime getCrime(UUID id){
        for (Crime c : mCrimes){
            if(c.getID().equals(id)){
                return c;
            }
        }
        return null;
    }

}
