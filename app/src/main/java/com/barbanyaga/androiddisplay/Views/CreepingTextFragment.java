package com.barbanyaga.androiddisplay.Views;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

    private String text = "Город Новочеркасск расположен на возвышенности, окружённой поймами степной реки Аксай и впадающей в неё реки Тузлов. В основании возвышенности лежат песчаники, сланцы, плотный известняк — ракушечник, в который на протяжении сотен лет попадала вода, образуя подземные скрытые пустоты.Река Тузлов разделяет город на две части. Восточнее расположен район посёлка Донской. Территория Новочеркасска граничит с Октябрьским и Аксайским сельскими районами.Преимуществом географического положения города является близость к крупнейшим промышленным и торговым центрам региона: Ростова-на-Дону расположен в 40 км, Шахты — в 36 км, Аксай — в 30 км, Новошахтинск — в 47 км, Батайск — в 53 км.Общая площадь городских земель составляет 13412,1 га.";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_creeping_text, container, false);

        TextView textView = (TextView) view.findViewById(R.id.creeping_text_view);
        textView.setText(text);
        textView.setSelected(true);

        return view;
    }
}
