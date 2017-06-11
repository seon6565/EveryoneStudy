package comwow2778.naver.blog.everyonestudy;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class html extends AppCompatActivity {
    ListView L1;
    ArrayList<clear> cleararray = new ArrayList<>();
    Baseadaters  adapter;
    String username = "";
    SQLiteDatabase db;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html);
        setTitle("HTML");
        L1 = (ListView)findViewById(R.id.listview);

        Intent intent = getIntent();
        username = intent.getStringExtra("index");
        dbHelper = new DBHelper(this,"esdb",null,1);
        db = dbHelper.getWritableDatabase();
        db = dbHelper.getReadableDatabase();
        String sql = "Select * from html where name='"+username+"';";
        Cursor user = db.rawQuery(sql,null);
        user.moveToNext();

        cleararray.add(new clear("1강 HTML이란",user.getString(1)));
        cleararray.add(new clear("2강 CSS란",user.getString(2)));//
        cleararray.add(new clear("3강 HTML 태그 더 알아보기",user.getString(3)));
        cleararray.add(new clear("4강 CSS 텍스트 속성",user.getString(4)));
        cleararray.add(new clear("5강 웹 개발도구",user.getString(5)));
        cleararray.add(new clear("6강 CSS 레이아웃",user.getString(6)));
        cleararray.add(new clear("7강 CSS 선택자 더 알아보기",user.getString(7)));
        cleararray.add(new clear("8강 CSS를 포함 하는 다른 방법",user.getString(8)));
        cleararray.add(new clear("9강 더 학습하기",user.getString(9)));

        adapter = new Baseadaters(cleararray,this);
        L1.setAdapter(adapter);


        L1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Intent intent = new Intent(html.this,htmldata.class);
                    intent.putExtra("index",0);
                    intent.putExtra("name",username);
                    startActivity(intent);
                    finish();
                }

                else if(position == 1){
                    Intent intent = new Intent(html.this,htmldata.class);
                    intent.putExtra("index",1);
                    intent.putExtra("name",username);
                    startActivity(intent);
                    finish();
                }

                else if(position == 2){
                    Intent intent = new Intent(html.this,htmldata.class);
                    intent.putExtra("index",2);
                    intent.putExtra("name",username);
                    startActivity(intent);
                    finish();
                }

                else if(position == 3){
                    Intent intent = new Intent(html.this,htmldata.class);
                    intent.putExtra("index",3);
                    intent.putExtra("name",username);
                    startActivity(intent);
                    finish();
                }

                else if(position == 4){
                    Intent intent = new Intent(html.this,htmldata.class);
                    intent.putExtra("index",4);
                    intent.putExtra("name",username);
                    startActivity(intent);
                    finish();
                }

                else if(position == 5){
                    Intent intent = new Intent(html.this,htmldata.class);
                    intent.putExtra("index",5);
                    intent.putExtra("name",username);
                    startActivity(intent);
                    finish();
                }

                else if(position == 6){
                    Intent intent = new Intent(html.this,htmldata.class);
                    intent.putExtra("index",6);
                    intent.putExtra("name",username);
                    startActivity(intent);
                    finish();
                }
                else if(position == 7){
                    Intent intent = new Intent(html.this,htmldata.class);
                    intent.putExtra("index",7);
                    intent.putExtra("name",username);
                    startActivity(intent);
                    finish();
                }

                else if(position == 8){
                    Intent intent = new Intent(html.this,htmldata.class);
                    intent.putExtra("index",7);
                    intent.putExtra("name",username);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

}
