package comwow2778.naver.blog.everyonestudy;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class userspace extends AppCompatActivity {
    TextView name, time;
    EditText memo;
    String username = "";
    String seconds = "";
    String path = "";
    SQLiteDatabase db;
    DBHelper dbHelper;
    String sql;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userspace);
        Intent intent = getIntent();
        username = intent.getStringExtra("index");


        name = (TextView)findViewById(R.id.textname);
        time = (TextView)findViewById(R.id.texttime);
        memo = (EditText)findViewById(R.id.etmemo);
        path = getFilesDir().getPath() + "memo/" + "memo.txt";
        name.setText("유저 이름"+username);
        dbHelper = new DBHelper(this,"esdb",null,1);
        db = dbHelper.getReadableDatabase();
        sql = "Select * from user where name='"+username+"';";
        Cursor user = db.rawQuery(sql,null);
        user.moveToNext();
        seconds = user.getString(1);
        time.setText("학습 시간" +seconds +"초"); // db에서가져오기
        readFile(path);
    }

    public void onClick(View v){
        deleteExternalFile(path);
        writeFile(path);
    }

    void readFile(String path) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String readStr = "";
            String str;
            while ((str = br.readLine()) != null) {
                readStr += str + " ";
            }
            br.close();
            memo.setText(readStr);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void writeFile(String path) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path, true));
            bw.write(memo.getText().toString());
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void deleteExternalFile(String path) {
        File file = new File(path);
        file.delete();
    }
}
