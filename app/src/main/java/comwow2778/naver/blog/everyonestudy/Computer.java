package comwow2778.naver.blog.everyonestudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Computer extends AppCompatActivity {
    ListView L1;
    ArrayAdapter<String> adapter;
    String username = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer);
        setTitle("컴퓨터공학");

        L1 = (ListView)findViewById(R.id.listview);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        L1.setAdapter(adapter);

        Intent intent = getIntent();
        username = intent.getStringExtra("index");

        adapter.add("JAVA(추가예정)");
        adapter.add("안드로이드 스튜디오(추가예정)");
        adapter.add("HTML/CSS");

        L1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 2){
                    Intent intent = new Intent(Computer.this,html.class);
                    intent.putExtra("index",username);
                    startActivity(intent);

                }
            }
        });
    }
}
