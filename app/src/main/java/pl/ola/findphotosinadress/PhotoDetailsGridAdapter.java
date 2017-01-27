package pl.ola.findphotosinadress;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import pl.ola.findphotosinadress.places.Photo;
import pl.ola.findphotosinadress.places.Place;

/**
 * Created by Aleksandra Kusiak on 24.01.2017.
 */
public class PhotoDetailsGridAdapter extends BaseAdapter {
    Context mContext;
    String apiURL = "https://maps.googleapis.com/maps/api/place/photo?maxwidth=400";
    List<Photo> photos;

    public PhotoDetailsGridAdapter(Context mContext, List<Photo> photos) {
        this.mContext = mContext;
        this.photos = photos;
    }


    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int getCount() {
        if (photos != null) {
            return photos.size();
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
            view = LayoutInflater.from(mContext).inflate(R.layout.grid_cell, viewGroup, false);


        Photo photo = photos.get(row);
        if(photo != null ) {
            String fullURL = apiURL + "&photoreference=" + photo.photoReference + "&key=AIzaSyCBr4aFGcFWaq3AxX8FMu0BdwDh1UrxWmg";
            ImageView downloadedImage = (ImageView) view.findViewById(R.id.downloadedImage);
            Picasso.with(mContext).load(fullURL).into(downloadedImage);
        }
        return view;
    }
}
