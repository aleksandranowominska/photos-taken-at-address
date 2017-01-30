package pl.ola.findphotosinadress;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pl.ola.findphotosinadress.api.GoogleMapService;
import pl.ola.findphotosinadress.json.place.Photo;
import pl.ola.findphotosinadress.json.place.PlaceDetails;
import pl.ola.findphotosinadress.json.places.Place;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlaceDetailsActivity extends AppCompatActivity {
    public static final String EXTRA_PLACES = "EXTRA_PLACES";

    TextView placeName;
    TextView placeRating;
    TextView placeType;
    GridView placeImagesGridView;
    Place singlePlace;

    List<Photo> placeDetailsMorePhotos = new ArrayList<>();

    GoogleMapService googleMapService = GoogleMapService.retrofit.create(GoogleMapService.class);
    PhotoDetailsGridAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);

        singlePlace = getIntent().getParcelableExtra(EXTRA_PLACES);

        placeName = (TextView) findViewById(R.id.placeName);
        placeRating = (TextView) findViewById(R.id.placeRating);
        placeType = (TextView) findViewById(R.id.placeType);
        placeImagesGridView = (GridView) findViewById(R.id.placePictures);

        placeName.setText(singlePlace.name);
        if (singlePlace.rating != null) {
            placeRating.setText("Rating: " + singlePlace.rating);
        } else {
            placeRating.setText("");
        }

        String placeTypes = TextUtils.join("\n", singlePlace.types);
        placeType.setText(placeTypes);

        adapter = new PhotoDetailsGridAdapter(this, placeDetailsMorePhotos);
        placeImagesGridView.setAdapter(adapter);

        googleMapService.getPlaceDetails(MainActivity.GOOGLE_API_KEY, singlePlace.placeId).enqueue(new Callback<PlaceDetails>() {
            @Override
            public void onResponse(Call<PlaceDetails> call, Response<PlaceDetails> response) {
                if (response.body() != null && response.body().result != null && response.body().result.photos != null) {
                    placeDetailsMorePhotos.clear();
                    placeDetailsMorePhotos.addAll(response.body().result.photos);
                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onFailure(Call<PlaceDetails> call, Throwable t) {
                Toast.makeText(PlaceDetailsActivity.this, "Something is wrong: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


    }
}
