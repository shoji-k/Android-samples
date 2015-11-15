package jp.freks.cookpadinternship2015summer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import jp.freks.cookpadinternship2015summer.model.Image;

public class ImageAdapter extends ArrayAdapter<Image> {

    private LayoutInflater layoutInflater;

    public ImageAdapter(Context context) {
        super(context, 0);
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = layoutInflater.inflate(R.layout.listitem_image, parent, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        Image image = getItem(position);
        viewHolder.titleText.setText(image.getTitle());
        viewHolder.descriptionText.setText(image.getUrl());
        return view;
    }

    private static class ViewHolder {

        private ImageView thumbnailImage;
        private TextView titleText;
        private TextView descriptionText;

        public ViewHolder(View rootView) {
            this.thumbnailImage = (ImageView) rootView.findViewById(R.id.thumbnail_image);
            this.titleText = (TextView) rootView.findViewById(R.id.title_text);
            this.descriptionText = (TextView) rootView.findViewById(R.id.description_text);
        }
    }

}