package jp.freks.cookpadinternship2015summer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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
        adapter.add(new Image(0, "title0", "https://upload.wikimedia.org/wikipedia/commons/b/b3/Berlin-BaoBao1-Asio.jpg"));
        adapter.add(new Image(1, "title1", "http://ecx.images-amazon.com/images/I/41CJaWPsC4L._SL160_.jpg"));
        adapter.add(new Image(2, "title2", "https://upload.wikimedia.org/wikipedia/commons/b/b3/Berlin-BaoBao1-Asio.jpg"));
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Image image = adapter.getItem(position);
                Intent intent = ImageActivity.createIntent(MainActivity.this, image.getId());
                startActivity(intent);
            }
        });

        Toast.makeText(this, "onCreate called", Toast.LENGTH_SHORT).show();
    }

}

