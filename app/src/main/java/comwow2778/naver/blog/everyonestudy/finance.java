package comwow2778.naver.blog.everyonestudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class finance extends AppCompatActivity {
    ListView L1;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance);
        setTitle("상경계열");

        L1 = (ListView)findViewById(R.id.listview);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        L1.setAdapter(adapter);

        adapter.add("경제학(추가예정)");
        adapter.add("경영학(추가예정)");
        adapter.add("무역학(추가예정)");

        L1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}
