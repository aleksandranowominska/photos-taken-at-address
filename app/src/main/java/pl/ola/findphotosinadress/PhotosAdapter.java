package pl.ola.findphotosinadress;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import pl.ola.findphotosinadress.places.Photo;
import pl.ola.findphotosinadress.places.Place;

/**
 * Created by Aleksandra Kusiak on 24.01.2017.
 */

public class PhotosAdapter extends BaseAdapter {
    Context mContext;
    String apiURL = "https://maps.googleapis.com/maps/api/place/photo?maxwidth=400";


    public PhotosAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int getCount() {
        if (MainActivity.foundPlaces != null) {
            return MainActivity.foundPlaces.size();
        } else {
            return 0;
        }
    }

    @Override
    public Object getItem(int row) {
        return null;
    }

    @Override
    public long getItemId(int row) {
        return 0;
    }

    @Override
    public View getView(int row, View view, ViewGroup viewGroup) {
        if (view == null)
            view = LayoutInflater.from(mContext).inflate(R.layout.image_cell, viewGroup, false);
        Place place = MainActivity.foundPlaces.get(row);
        if((place != null && place.photos!=null)) {
            String fullURL = apiURL + "&photoreference=" + place.photos.get(0).photoReference + "&key=AIzaSyCBr4aFGcFWaq3AxX8FMu0BdwDh1UrxWmg";
            ImageView downloadedImage = (ImageView) view.findViewById(R.id.downloadedImage);
            Picasso.with(mContext).load(fullURL).into(downloadedImage);
        }
        return view;
    }
}
