package com.barbanyaga.androiddisplay.Views;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.barbanyaga.androiddisplay.ContentPackManagment.DataModel.PlaylistFile;
import com.barbanyaga.androiddisplay.R;
import com.barbanyaga.androiddisplay.Views.Base.BaseFragment;
import com.barbanyaga.androiddisplay.util.helpers.FileHelper;

import java.io.File;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CreepingTextFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CreepingTextFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreepingTextFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_creeping_text, container, false);

        TextView textView = (TextView) view.findViewById(R.id.creeping_text_view);

        PlaylistFile file = getPlaylist().getNextFile();

        if (file != null) {
            textView.setText(FileHelper.readTextFile(new File(file.getFilePath())));
            textView.setSelected(true);
        }

        return view;
    }
}
