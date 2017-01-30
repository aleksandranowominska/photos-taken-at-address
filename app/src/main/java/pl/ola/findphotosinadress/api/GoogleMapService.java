package pl.ola.findphotosinadress.api;

import pl.ola.findphotosinadress.json.location.LocationData;
import pl.ola.findphotosinadress.json.place.PlaceDetails;
import pl.ola.findphotosinadress.json.places.PlacesResponse;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Aleksandra Kusiak on 23.01.2017.
 */

public interface GoogleMapService {
    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://maps.googleapis.com/maps/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    @GET("geocode/json")
    Call<LocationData> geocodeAddress(@Query("address") String address, @Query("key") String key);

    @GET("place/nearbysearch/json")
    Call<PlacesResponse> nearbySearch(@Query("key") String key, @Query("location") String location, @Query("radius") Integer radius);

    @GET("place/details/json")
    Call<PlaceDetails> getPlaceDetails(@Query("key") String key, @Query("placeid") String placeID);

}
