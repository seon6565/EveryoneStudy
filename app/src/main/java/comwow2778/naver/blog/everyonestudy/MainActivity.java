package comwow2778.naver.blog.everyonestudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView i1,i2,i3,i4,i5,i6,i7;
    String username = "";

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

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,finance.class);
                startActivity(intent);
            }
        });

        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,language.class);
                startActivity(intent);
            }
        });


        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,engineer.class);
                startActivity(intent);
            }
        });


        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,basic.class);
                startActivity(intent);
            }
        });


        i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,community.class);
                startActivity(intent);
            }
        });


        i6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,internet.class);
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
}
