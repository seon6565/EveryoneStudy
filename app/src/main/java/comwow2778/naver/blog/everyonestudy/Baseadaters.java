package comwow2778.naver.blog.everyonestudy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by seon on 2017-06-10.
 */

public class Baseadaters extends BaseAdapter {
    ArrayList<clear> data = new ArrayList<>();
    Context c;
    String clear = "0";
    public Baseadaters(ArrayList<clear> data, Context c){
        this.data = data;
        this.c = c;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(c);
        if(convertView ==null){
            convertView =inflater.inflate(R.layout.major, null);
        }
        TextView textView = (TextView)convertView.findViewById(R.id.checktext);
        ImageView image = (ImageView)convertView.findViewById(R.id.checkimg);
        if(position == 0){

        }
        else if(position == 1){

        }
        textView.setText(data.get(position).getName());
        clear = data.get(position).getClear(); // 데이터베이스에서 얻어오기

        if(clear.equals("1")){
            image.setVisibility(View.VISIBLE);
        }
        else{
            image.setVisibility(View.INVISIBLE);
        }

        return convertView;
    }

}