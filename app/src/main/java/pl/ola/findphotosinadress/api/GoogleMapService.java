package pl.ola.findphotosinadress.api;

import pl.ola.findphotosinadress.location.LocationData;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
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

}
