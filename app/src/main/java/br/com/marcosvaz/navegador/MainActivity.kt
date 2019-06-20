package br.com.marcosvaz.navegador

import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        meuNavegador.settings.javaScriptEnabled = true
        meuNavegador.settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
        meuNavegador.settings.javaScriptCanOpenWindowsAutomatically = true
        meuNavegador.webViewClient = object : WebViewClient(){
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                val status = 0
                pbCarregando.visibility = View.VISIBLE

            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                pbCarregando.visibility = View.INVISIBLE

            }
        }

        meuNavegador.setWebChromeClient(WebChromeClient()){
            fun onProgreesChanged()
        }
        meuNavegador.loadUrl("https://www.google.com.br/")

        btnVoltar.setOnClickListener{
            if(meuNavegador.canGoBack()){
                meuNavegador.goBack()
            }
        }
        btnAvancar.setOnClickListener {
            if (meuNavegador.canGoForward()){
                meuNavegador.goForward()
            }
        }
        btnHome.setOnClickListener {

                meuNavegador.loadUrl("https://www.google.com.br/")

        }
        btnRefresh.setOnClickListener {
            meuNavegador.reload()
            pbCarregando.visibility = View.INVISIBLE
        }
        val progresso = pbCarregando.progress

        /*if (progresso == null){
            val btn = findViewById<ImageButton>(R.id.btnRefresh)
            btnRefresh.setOnClickListener {

            }*/

    }



}
