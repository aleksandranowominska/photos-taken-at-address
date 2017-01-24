package pl.ola.findphotosinadress;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import pl.ola.findphotosinadress.api.GoogleMapService;
import pl.ola.findphotosinadress.location.LocationData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText enterAdressText;
    Button searchButton;
    String enteredAdress = "";
    String googleURL ="https://maps.googleapis.com/maps/api/geocode/json?address=";
    String finalGoogleApiURL = "";
    public static final String GOOGLE_API_KEY = "AIzaSyCBr4aFGcFWaq3AxX8FMu0BdwDh1UrxWmg";
    public static final String BASE_URL = "https://maps.googleapis.com/maps/api/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enterAdressText = (EditText) findViewById(R.id.enterAdress);
        searchButton = (Button) findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enteredAdress = enterAdressText.getText().toString();

                GoogleMapService googleMapService = GoogleMapService.retrofit.create(GoogleMapService.class);
                Call<LocationData> call = googleMapService.geocodeAddress(enteredAdress, GOOGLE_API_KEY);

                call.enqueue(new Callback<LocationData>() {
                    @Override
                    public void onResponse(Call<LocationData> call, Response<LocationData> response) {
                        LocationData locationData = response.body();
//                        locationData.status;
//                        locationData.results.get(0).geometry.location.lat

                        enterAdressText.setText(response.body().results.get(0).formattedAddress);
                    }
                    @Override
                    public void onFailure(Call<LocationData> call, Throwable t) {
                        enterAdressText.setText("Something went wrong: " + t.getMessage());
                    }
                });
            }
        });




    }

}
