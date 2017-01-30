
package pl.ola.findphotosinadress.json.place;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Aspect {

    @SerializedName("rating")
    @Expose
    public Integer rating;
    @SerializedName("type")
    @Expose
    public String type;

}
