package com.planetweblogics.fragment

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import com.planetweblogics.R

class HomeFragment : Fragment() {

    private lateinit var view:View
    private lateinit var webView: WebView
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view= inflater.inflate(R.layout.fragment_home, container, false)
        webView=view.findViewById(R.id.home_webView)
        webviewSetup(webView)
        return view
    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun webviewSetup(webView: WebView) {
        webView.webViewClient= WebViewClient()

        webView.apply {
            settings.javaScriptEnabled=true
            settings.safeBrowsingEnabled=true
            loadUrl("https://planetlogics.in/")
        }
    }
}