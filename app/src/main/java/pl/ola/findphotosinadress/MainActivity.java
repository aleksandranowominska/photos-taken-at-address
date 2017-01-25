package pl.ola.findphotosinadress;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pl.ola.findphotosinadress.api.GoogleMapService;
import pl.ola.findphotosinadress.location.LocationData;
import pl.ola.findphotosinadress.places.Place;
import pl.ola.findphotosinadress.places.PlacesResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public static final String GOOGLE_API_KEY = "AIzaSyCBr4aFGcFWaq3AxX8FMu0BdwDh1UrxWmg";
    //AIzaSyC3IPPF-eb4E0LhktsNWP0umgw9L9lbINY

    EditText enterAdressText;
    Button searchButton;
    ListView imagesListView;

    public static List<Place> foundPlaces;

    GoogleMapService googleMapService = GoogleMapService.retrofit.create(GoogleMapService.class);
    PhotosAdapter photosAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagesListView = (ListView) findViewById(R.id.listView);
        View headerView = LayoutInflater.from(this).inflate(R.layout.header, imagesListView, false);
        imagesListView.addHeaderView(headerView);
        photosAdapter = new PhotosAdapter(this);
        imagesListView.setAdapter(photosAdapter);

        foundPlaces = new ArrayList<Place>();

        enterAdressText = (EditText) findViewById(R.id.enterAdress);
        searchButton = (Button) findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredAdress = enterAdressText.getText().toString();

                googleMapService.geocodeAddress(enteredAdress,GOOGLE_API_KEY).enqueue(new Callback<LocationData>() {
                    @Override
                    public void onResponse(Call<LocationData> call, Response<LocationData> response) {
                        LocationData locationData = response.body();
                        loadPhotos(locationData.results.get(0).geometry.location.lat, locationData.results.get(0).geometry.location.lng);

                        enterAdressText.setText(response.body().results.get(0).formattedAddress);
                    }

                    @Override
                    public void onFailure(Call<LocationData> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Something is wrong: " + t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

            }
        });

    }

    public void loadPhotos(Double lat, Double lng){
        googleMapService.nearbySearch(GOOGLE_API_KEY, lat+","+lng, 500).enqueue(new Callback<PlacesResponse>() {
            @Override
            public void onResponse(Call<PlacesResponse> call, Response<PlacesResponse> response) {
//                Toast.makeText(MainActivity.this, "OK " + response.body().results.size(), Toast.LENGTH_LONG).show();
                foundPlaces = response.body().results;
                photosAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<PlacesResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something is wrong: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

}
