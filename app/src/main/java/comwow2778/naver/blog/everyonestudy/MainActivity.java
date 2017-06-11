package comwow2778.naver.blog.everyonestudy;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView i1,i2,i3,i4,i5,i6,i7;
    String username = "";
    String time = "0";
    SQLiteDatabase db;
    String sql;
    String sql2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        username = intent.getStringExtra("index");

        i1 = (ImageView)findViewById(R.id.imageView1);
        i2 = (ImageView)findViewById(R.id.imageView2);
        i3 = (ImageView)findViewById(R.id.imageView3);
        i4 = (ImageView)findViewById(R.id.imageView4);
        i5 = (ImageView)findViewById(R.id.imageView5);
        i6 = (ImageView)findViewById(R.id.imageView6);
        i7 = (ImageView)findViewById(R.id.imageView7);
        DBHelper dbHelper;
        dbHelper = new DBHelper(this,"esdb",null,1);
        db = dbHelper.getWritableDatabase();
        sql = String.format("insert into user (name, time) values('%s','%s');", username,time);
        db.execSQL(sql);
        String sql3 =  "Create table if not exists html (" +
                "name text ,"+
                "chapter1 text," +
                "chapter2 text," +
                "chapter3 text," +
                "chapter4 text," +
                "chapter5 text," +
                "chapter6 text," +
                "chapter7 text," +
                "chapter8 text," +
                "chapter9 text);";
        db.execSQL(sql3);
        sql2 = String.format("insert into html (name, chapter1, chapter2, chapter3, chapter4, chapter5,chapter6,chapter7,chapter8,chapter9) values('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s');",username,"0","0","0","0","0","0","0","0","0");
        db.execSQL(sql2);

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,finance.class);
                intent.putExtra("index",username);
                startActivity(intent);
            }
        });

        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,language.class);
                intent.putExtra("index",username);
                startActivity(intent);
            }
        });


        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,engineer.class);
                intent.putExtra("index",username);
                startActivity(intent);
            }
        });


        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,basic.class);
                intent.putExtra("index",username);
                startActivity(intent);
            }
        });


        i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,community.class);
                intent.putExtra("index",username);
                startActivity(intent);
            }
        });


        i6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,internet.class);
                intent.putExtra("index",username);
                startActivity(intent);
            }
        });


        i7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,userspace.class);
                intent.putExtra("index",username);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,1,0,"로그아웃");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(MainActivity.this,Roading.class);
        intent.putExtra("index",username);
        startActivity(intent);
        finish();
        return super.onOptionsItemSelected(item);
    }




}
