package com.aashishkumar.androidproject;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchProfileFragment extends Fragment {

    private OnSearchProfileFragmentInteractionListener mListener;

    public SearchProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_search_profile, container, false);
        Button addFriend = (Button) v.findViewById(R.id.button_add_searchprofile_frag);
        addFriend.setOnClickListener(view ->mListener.onAddToListClicked());
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();

        if (getArguments() != null) {
            String username = getArguments().getString("username");
            TextView tv = getActivity().findViewById(R.id.username_text_searchprofile_frag);
            tv.setText(username);

            String fname = getArguments().getString("fname");
            TextView tv1 = getActivity().findViewById(R.id.fname_text_searchprofile_frag);
            tv1.setText(fname);

            String lname = getArguments().getString("lname");
            TextView tv2 = getActivity().findViewById(R.id.lname_text_searchprofile_frag);
            tv2.setText(lname);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnSearchProfileFragmentInteractionListener) {
            mListener = (OnSearchProfileFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnSearchProfileFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnSearchProfileFragmentInteractionListener {
        void onAddToListClicked();
    }
}