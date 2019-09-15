package com.androdude.RTOTEST;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class menuitems extends AppCompatActivity {


    private TextView givetest,practicetest,info;
    private Handler h = new Handler();
    private ListView listview;
    String images[] = {"examlogo","practicelogo","pdflogo","noimg"};
    String listItems[] = {"Test","Practice","Download Question Paper","More Apps"};
    String listItemsvalues[] = {"Time And Question Bound Same As RTO","Practice More To Pass The Test","Donwload PDF of The Question Paper","Check Our Other Apps"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuitems);

        listview = (ListView) findViewById(R.id.listView);
        myAdpter mAdapter = new myAdpter();
        listview.setAdapter(mAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (listItems[i]) {
                    case "Test": {
                        Intent intent = new Intent(getApplicationContext(), infoBeforeStart.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.slidein, R.anim.slideout);
                    }
                    break;
                    case "Practice": {
                        Intent intent = new Intent(getApplicationContext(), practice.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.slidein, R.anim.slideout);
                    }
                    break;
                    case "Download Question Paper": {
                        Toast.makeText(menuitems.this, "Comming Soon", Toast.LENGTH_SHORT).show();
                    }
                    break;
                    case "More Apps": {
                        Intent intent = new Intent(getApplicationContext(), moreApps.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.slidein, R.anim.slideout);
                    }
                    break;
                }
            }
        });

    }




    class myAdpter extends BaseAdapter
    {

        @Override
        public int getCount() {
            return listItems.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
           view = getLayoutInflater().inflate(R.layout.coustomadapterview,null);

           ImageView imgView = (ImageView)view.findViewById(R.id.imageView);
           TextView txtView = (TextView)view.findViewById(R.id.textView);
           TextView txtView1 = (TextView)view.findViewById(R.id.textView1);
           TextView txtView2 = (TextView)view.findViewById(R.id.textView2);

            String imagefile = images[i];
            int resId = getResources().getIdentifier(imagefile, "drawable", getPackageName());
            Drawable imag = getResources().getDrawable(resId);
            imgView.setImageDrawable(imag);

            txtView.setText(listItems[i]);
            txtView1.setText(listItemsvalues[i]);
            return view;
        }
    }

}
