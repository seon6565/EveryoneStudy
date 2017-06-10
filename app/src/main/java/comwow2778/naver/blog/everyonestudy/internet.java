package comwow2778.naver.blog.everyonestudy;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class internet extends AppCompatActivity {
    WebView webView;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet);
        webView = (WebView)findViewById(R.id.webview);
        WebSettings set = webView.getSettings();
        dialog = new ProgressDialog(this);

        webView.loadUrl("http://m.naver.com");
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                return super.onJsAlert(view, url, message, result);
            }
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if(newProgress >=100) dialog.dismiss();
                super.onProgressChanged(view, newProgress);
            }
        });

        set.setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                dialog.setMessage("Loading!");
                dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                dialog.show();
                super.onPageStarted(view, url, favicon);
            }
        });
    }
}
