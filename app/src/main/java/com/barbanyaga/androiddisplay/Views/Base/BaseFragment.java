package com.barbanyaga.androiddisplay.Views.Base;

import android.app.Fragment;

import com.barbanyaga.androiddisplay.ContentPackManagment.DataModel.Playlist;

/**
 * Created by barbanyaga on 16.04.2015.
 */
public abstract class BaseFragment extends Fragment {
    protected Playlist playlist;

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    /**
     * Остановить проигрывание
     */
    public abstract void stop();
}
