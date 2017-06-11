package comwow2778.naver.blog.everyonestudy;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class htmldata extends AppCompatActivity {
    WebView webView;
    EditText et1;
    TextView tv1;
    int index = 0;
    int seconds = 0;
    ProgressDialog dialog;
    myTask task;
    LinearLayout memo;
    int time = 0;
    String username = "";
    SQLiteDatabase db;
    DBHelper dbHelper;
    int prevtime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_htmldata);
        webView = (WebView)findViewById(R.id.webview);
        memo = (LinearLayout)findViewById(R.id.memo);
        tv1 = (TextView)findViewById(R.id.tv1);
        et1 = (EditText)findViewById(R.id.memoet);
        Intent intent = getIntent();
        index = intent.getIntExtra("index",0);
        username = intent.getStringExtra("name");

        dbHelper = new DBHelper(this,"esdb",null,1);
        db = dbHelper.getWritableDatabase();
        db = dbHelper.getReadableDatabase();
        String sql = "Select * from user where name='"+username+"';";
        Cursor user = db.rawQuery(sql,null);
        user.moveToNext();
        prevtime = Integer.valueOf(user.getString(1));

        WebSettings set = webView.getSettings();
        dialog = new ProgressDialog(this);
        task = new myTask();
        task.execute(0);
        File memo = new File(getFilesDir().getPath() + "memo");
        File time = new File(getFilesDir().getPath() + "time");
        memo.mkdir();
        time.mkdir();

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

        set.setJavaScriptCanOpenWindowsAutomatically(true);
        set.setJavaScriptEnabled(true);
        if(index == 0) {
            webView.loadUrl("https://ko.khanacademy.org/computing/computer-programming/html-css/intro-to-html/v/making-webpages-intro");
            db.execSQL("Update html set chapter1='1'where name='"+username+"';");
        }
        else if(index == 1) {
            webView.loadUrl("https://ko.khanacademy.org/computing/computer-programming/html-css/intro-to-css/p/css-basics");
            db.execSQL("Update html set chapter2='1'where name='"+username+"';");
        }
        else if(index == 2) {
            webView.loadUrl("https://ko.khanacademy.org/computing/computer-programming/html-css/html-tags-continued/p/html-links");
            db.execSQL("Update html set chapter3='1'where name='"+username+"';");
        }
        else if(index == 3) {
            webView.loadUrl("https://ko.khanacademy.org/computing/computer-programming/html-css/css-text-properties/v/css-zen-garden");
            db.execSQL("Update html set chapter4='1'where name='"+username+"';");
        }
        else if(index == 4) {
            webView.loadUrl("https://ko.khanacademy.org/computing/computer-programming/html-css/web-development-tools/a/developing-webpages-outside-of-khan-academy");
            db.execSQL("Update html set chapter5='1'where name='"+username+"';");
        }
        else if(index == 5) {
            webView.loadUrl("https://ko.khanacademy.org/computing/computer-programming/html-css/css-layout-properties/p/css-grouping-elements");
            db.execSQL("Update html set chapter6='1'where name='"+username+"';");
        }
        else if(index == 6) {
            webView.loadUrl("https://ko.khanacademy.org/computing/computer-programming/html-css/more-css-selectors/p/using-multiple-css-classes");
            db.execSQL("Update html set chapter7='1'where name='"+username+"';");
        }
        else if(index == 7) {
            webView.loadUrl("https://ko.khanacademy.org/computing/computer-programming/html-css/more-ways-to-embed-css/p/using-inline-css-styles");
            db.execSQL("Update html set chapter8='1'where name='"+username+"';");
        }
        else if(index == 8) {
            webView.loadUrl("https://ko.khanacademy.org/computing/computer-programming/html-css/html-css-further-learning/a/webpage-design");
            db.execSQL("Update html set chapter9='1'where name='"+username+"';");
        }
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


    class myTask extends AsyncTask<Integer,Integer,Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            seconds = 0;
            tv1.setText("학습시간 " + seconds + "초");
        }


        @Override
        protected Void doInBackground(Integer... params) {
            while(isCancelled()==false){
                seconds++;
                try {
                    Thread.sleep(1000);
                    publishProgress(seconds);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            cancel(true);
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            tv1.setText("학습시간 " + values[0] +"초");

        }
        @Override
        protected void onCancelled() {
            super.onCancelled();
        }


        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

    }

    public void onClick(View v){
        if(v.getId()==R.id.studybt){
            task.cancel(true);
            int totaltime = seconds+prevtime;
            String time = Integer.toString(totaltime);
            db.execSQL("Update user set time='"+time+"'where name='"+username+"';");
            Toast.makeText(this, "학습시간 저장완료", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(htmldata.this,html.class);
            intent.putExtra("index",username);
            startActivity(intent);
            finish();
        }
        else{
            writeFile(getFilesDir().getPath() + "memo/" + "memo.txt");
            Toast.makeText(this, "메모 저장완료", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,1,0,"메모장 보이기");
        menu.add(0,2,0,"메모장 숨기기");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==1){
            memo.setVisibility(View.VISIBLE);
        }
        else if(item.getItemId() ==2){
            memo.setVisibility(View.GONE);
        }
        return super.onOptionsItemSelected(item);
    }

    void writetimeFile(String path) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path, false));
            bw.write(seconds+time);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void writeFile(String path) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path, true));
            bw.write(et1.getText().toString());
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void timereadFile(String path) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            time = br.read();
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
