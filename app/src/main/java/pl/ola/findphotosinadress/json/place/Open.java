
package pl.ola.findphotosinadress.json.place;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Open {

    @SerializedName("day")
    @Expose
    public Integer day;
    @SerializedName("time")
    @Expose
    public String time;

}
