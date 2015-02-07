package com.barbanyaga.androiddisplay.Views;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.barbanyaga.androiddisplay.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CreepingTextFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CreepingTextFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreepingTextFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_creeping_text, container, false);
    }
}
