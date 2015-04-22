package com.barbanyaga.androiddisplay.Views;


import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.barbanyaga.androiddisplay.R;
import com.barbanyaga.androiddisplay.Views.Base.BaseFragment;

import java.net.URLEncoder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HtmlTextFragment extends BaseFragment {

    private String htmlText = "<html><head><link rel='stylesheet' type='text/css' href='http://www.robotsidekick.com/test.css?rev=0' /></head><body><h1>Hello World</h1></body></html>";
    //private String htmlText = "";


    public HtmlTextFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_html_text, container, false);

        WebView webView = (WebView) view.findViewById(R.id.WebViewContent);
        webView.setBackgroundColor(Color.TRANSPARENT);
        //htmlText = "<a href=\"http://www.accuweather.com/en/ru/novochyerkassk/290029/weather-forecast/290029\" class=\"aw-widget-legal\"></a><div id=\"awcc1425808917960\" class=\"aw-widget-current\"  data-locationkey=\"\" data-unit=\"c\" data-language=\"en-us\" data-useip=\"true\" data-uid=\"awcc1425808917960\"></div><script type=\"text/javascript\" src=\"http://oap.accuweather.com/launch.js\"></script>";
        htmlText = "<a href=\"http://rp5.ru/5483/ru\"><img border=0 width=100 height=100 src=\"http://rp5.ru/informer/100x100x2.php?f=21&id=5483&lang=ru&um=00000\"></a>";
        webView.loadData(htmlText, "text/html", Xml.Encoding.UTF_8.toString());

//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.getSettings().setBuiltInZoomControls(true);
//        webView.getSettings().setSupportZoom(true);
        //webView.loadUrl("http://m.lenta.ru/");


        return view;
    }

    @Override
    public void stop() {

    }

}
