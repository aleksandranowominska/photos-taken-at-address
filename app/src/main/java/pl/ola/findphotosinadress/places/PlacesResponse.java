
package pl.ola.findphotosinadress.places;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlacesResponse {

    @SerializedName("html_attributions")
    @Expose
    public List<Object> htmlAttributions = null;
    @SerializedName("next_page_token")
    @Expose
    public String nextPageToken;
    @SerializedName("results")
    @Expose
    public List<Place> results = null;
    @SerializedName("status")
    @Expose
    public String status;

}
