package com.barbanyaga.androiddisplay.Views;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.barbanyaga.androiddisplay.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HtmlTextFragment extends Fragment {

    //private String htmlText = "<html><head><link rel='stylesheet' type='text/css' href='http://www.robotsidekick.com/test.css?rev=0' /></head><body><h1>Hello World</h1></body></html>";
    private String htmlText = "";



    public HtmlTextFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_html_text, container, false);

        WebView webView = (WebView)view.findViewById(R.id.WebViewContent);
        //webView.loadData(htmlText, "text/html", Xml.Encoding.UTF_8.toString());

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setSupportZoom(true);
        webView.loadUrl("http://m.lenta.ru/");

        return view;
    }


}
