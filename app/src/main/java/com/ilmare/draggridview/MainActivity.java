package com.ilmare.draggridview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.ilmare.draggridview.view.DragGridView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    DragGridView dragGridView;
    private List<HashMap<String, Object>> dataSourceList = new ArrayList<HashMap<String, Object>>();

    public static String[] IMAGES = new String[] {
            "http://img7.9158.com/200709/01/11/53/200709018758949.jpg",
            "http://img4.imgtn.bdimg.com/it/u=2019970444,20888940&fm=21&gp=0.jpg",
            "http://photo.scol.com.cn/hdp/img/attachement/jpg/site2/20140422/00219b7b064914c05a234b.jpg",
            "http://gtb.baidu.com/HttpService/get?p=dHlwZT1pbWFnZS9qcGVnJm49dmlzJnQ9YWRpbWcmYz10YjppZyZyPTM2MzI4MTA4MCw0MjcwMDE0NjkAVX8",
            "http://b.hiphotos.baidu.com/image/h%3D200/sign=f834f5c652fbb2fb2b2b5f127f4b2043/ac345982b2b7d0a2ad2ef906ccef76094a369a42.jpg",
            "http://img2.imgtn.bdimg.com/it/u=504974996,2399327700&fm=21&gp=0.jpg"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        dragGridView = (DragGridView) findViewById(R.id.dragGridView);


        for (int i = 0; i < 50; i++) {
            int index = new Random().nextInt(IMAGES.length);
            HashMap<String, Object> itemHashMap = new HashMap<String, Object>();
            itemHashMap.put("item_image",IMAGES[index]);
            itemHashMap.put("item_text", "image" + Integer.toString(i));
            dataSourceList.add(itemHashMap);
        }


        DragAdapter mDragAdapter = new DragAdapter(this, dataSourceList);

        dragGridView.setAdapter(mDragAdapter);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
