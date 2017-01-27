package pl.ola.findphotosinadress;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import pl.ola.findphotosinadress.R;
import pl.ola.findphotosinadress.places.Place;

public class PlaceDetails extends AppCompatActivity {
    public static final String EXTRA_PLACES = "EXTRA_PLACES";

    TextView placeName;
    TextView placeRating;
    TextView placeType;
    Place singlePlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);

        singlePlace = getIntent().getParcelableExtra(EXTRA_PLACES);

        placeName = (TextView) findViewById(R.id.placeName);
        placeRating = (TextView) findViewById(R.id.placeRating);
        placeType = (TextView) findViewById(R.id.placeType);

        placeName.setText(singlePlace.name);
        placeRating.setText(singlePlace.rating + "");

        String placeTypes = TextUtils.join("\n",singlePlace.types);
        placeType.setText(placeTypes);
    }
}
