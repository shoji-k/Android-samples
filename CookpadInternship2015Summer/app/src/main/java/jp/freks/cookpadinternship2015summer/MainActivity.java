package jp.freks.cookpadinternship2015summer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import jp.freks.cookpadinternship2015summer.model.Image;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    private ImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.image_list);
        adapter = new ImageAdapter(this);
        adapter.add(new Image(0, "title0", "http://www.xyz..."));
        adapter.add(new Image(1, "title1", "http://www.xyz..."));
        adapter.add(new Image(2, "title2", "http://www.xyz..."));
        listView.setAdapter(adapter);
    }
}

