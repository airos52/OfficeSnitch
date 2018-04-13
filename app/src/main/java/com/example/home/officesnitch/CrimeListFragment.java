package com.example.home.officesnitch;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Home on 4/5/18.
 */

public class CrimeListFragment extends Fragment {

    private RecyclerView mCrimeRecyclerView;
    private CrimeAdapter mAdapter;
    private ImageView mSolvedImageView;

    //BEGIN View Holder Class

    public class CrimeHolder extends RecyclerView.ViewHolder
                                implements View.OnClickListener{
        //creating constructor within the class
        public TextView mTitleTextView;
        private TextView mDateTextView;


//        private CheckBox mSolvedCheckBox;
        private Crime mCrime;

        public CrimeHolder(View itemView){
            super(itemView);
            mTitleTextView = (TextView) itemView.findViewById(R.id.list_item_crime_title_text_view);
            mDateTextView = (TextView) itemView.findViewById(R.id.list_item_crime_date_text_view);
            mSolvedImageView = (ImageView) itemView.findViewById(R.id.crime_solved);
//            mSolvedCheckBox = (CheckBox) itemView.findViewById(R.id.list_item_crime_solved_check_box);
            itemView.setOnClickListener(this);
        }

        public void bindCrime(Crime c){
            mCrime = c;
            mTitleTextView.setText(mCrime.getTitle());
            mDateTextView.setText(mCrime.getDate().toString());
            mSolvedImageView.setVisibility(mCrime.isSolved() ? View.VISIBLE : View.INVISIBLE);

//            mSolvedCheckBox.setChecked(mCrime.isSolved());
   //  IDEA I WAS WORKING ON       mTitleTextView.setTextColor(mCrime.getSeverity());
        }
        @Override
        public void onClick(View view){
            Intent intent = CrimeActivity.newIntent(getActivity(), mCrime.getID());
            startActivity(intent);
        }
    }
    //End View Holder Class

    //BEGIN ADAPTER CLASS
    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder>{
        private List<Crime> mCrimes;

        public CrimeAdapter(List<Crime> crimes){
            mCrimes = crimes;
        }

        @Override
        public int getItemCount() {
            return mCrimes.size();
        }

        @Override
        public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View v = inflater.inflate(R.layout.list_item_crime,parent,false);
            return new CrimeHolder(v);
        }

        @Override
        public void onBindViewHolder(CrimeHolder holder, int position) {
            Crime c = mCrimes.get(position);
  //      UPDATED CODE TO MAKE HOLDER GET BINDCRIME    holder.mTitleTextView.setText(c.getTitle());
            holder.bindCrime(c);
        }
    }

    //END ADAPTER CLASS

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crime_list, container, false);
        mCrimeRecyclerView = view.findViewById(R.id.crime_recycler_view);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    private void updateUI(){
        CrimeLab lab = CrimeLab.get(getActivity());

        if (mAdapter == null){
            mAdapter = new CrimeAdapter(lab.getCrimes());
            mCrimeRecyclerView.setAdapter(mAdapter);
        }
        else {
            mAdapter.notifyDataSetChanged();
        }
    }

}
