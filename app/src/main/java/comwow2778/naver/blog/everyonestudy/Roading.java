package comwow2778.naver.blog.everyonestudy;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Roading extends AppCompatActivity {
    EditText et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roading);
        et1 = (EditText)findViewById(R.id.editText);
    }

    public void onClick(View v){
        if(et1.getText().toString().equals("")){
            Toast.makeText(this,"이름을 입력하세요",Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(Roading.this, MainActivity.class);
            intent.putExtra("index", et1.getText().toString());
            startActivity(intent);
            finish();
        }
    }

}
