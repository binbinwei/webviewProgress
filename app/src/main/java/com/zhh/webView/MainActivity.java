package com.zhh.webView;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends Activity {
	ProgressBar pb;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
	pb = (ProgressBar) findViewById(R.id.pb);
    pb.setMax(100);

    WebView webView = (WebView) findViewById(R.id.webview);
    webView.getSettings().setJavaScriptEnabled(true);
    webView.getSettings().setSupportZoom(true);
    webView.getSettings().setBuiltInZoomControls(true);
    webView.setWebChromeClient(new MyWebChromeClient() );
    webView.setWebViewClient(new MyWebViewClient() );
    webView.loadUrl("https://www.shandu.com");
}

private class MyWebChromeClient extends WebChromeClient {
    @Override
    public void onProgressChanged(WebView view, int newProgress) {
        pb.setProgress(newProgress);
        if(newProgress==100){
            pb.setVisibility(View.GONE);
        }
        super.onProgressChanged(view, newProgress);
    }

}
private class MyWebViewClient extends WebViewClient{
    @Override
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        super.onReceivedError(view, errorCode, description, failingUrl);
    }

}

}