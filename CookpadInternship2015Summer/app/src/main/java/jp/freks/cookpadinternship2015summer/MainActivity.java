package jp.freks.cookpadinternship2015summer;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

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

    class ImageAdapter extends ArrayAdapter<Image> {

        private LayoutInflater layoutInflater;

        public ImageAdapter(Context context) {
            super(context, 0);
            this.layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = layoutInflater.inflate(R.layout.listitem_image, parent, false);
            TextView titleText = (TextView)view.findViewById(R.id.title_text);
            TextView descriptionText = (TextView)view.findViewById(R.id.description_text);
            Image image = getItem(position);
            titleText.setText(image.getTitle());
            descriptionText.setText(image.getUrl());
            return view;
        }
    }
}

