package pl.ola.findphotosinadress;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.GridView;
import android.widget.TextView;

import pl.ola.findphotosinadress.places.Place;

public class PlaceDetails extends AppCompatActivity {
    public static final String EXTRA_PLACES = "EXTRA_PLACES";

    TextView placeName;
    TextView placeRating;
    TextView placeType;
    GridView placeImagesGridView;
    Place singlePlace;

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
            placeRating.setText("Rating: " + singlePlace.rating + "");
        } else {
            placeRating.setText("");
        }

        String placeTypes = TextUtils.join("\n", singlePlace.types);
        placeType.setText(placeTypes);

        adapter = new PhotoDetailsGridAdapter(this, singlePlace.photos);
        placeImagesGridView.setAdapter(adapter);

    }
}
