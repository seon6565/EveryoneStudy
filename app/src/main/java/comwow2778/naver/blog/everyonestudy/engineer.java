package comwow2778.naver.blog.everyonestudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

public class engineer extends AppCompatActivity {
    ListView L1;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engineer);
        setTitle("공학계열");

        L1 = (ListView) findViewById(R.id.listview);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        L1.setAdapter(adapter);

        adapter.add("컴퓨터공학");
        adapter.add("전자공학(추가예정)");

        L1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Intent intent = new Intent(engineer.this,Computer.class);
                    startActivity(intent);

                }
            }
        });
    }
}
