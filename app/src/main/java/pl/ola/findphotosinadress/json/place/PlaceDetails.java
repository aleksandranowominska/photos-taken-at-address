
package pl.ola.findphotosinadress.json.place;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlaceDetails {

    @SerializedName("html_attributions")
    @Expose
    public List<Object> htmlAttributions = null;
    @SerializedName("result")
    @Expose
    public Result result;
    @SerializedName("status")
    @Expose
    public String status;

}
