
package pl.ola.findphotosinadress.json.place;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OpeningHours {

    @SerializedName("open_now")
    @Expose
    public Boolean openNow;
    @SerializedName("periods")
    @Expose
    public List<Period> periods = null;
    @SerializedName("weekday_text")
    @Expose
    public List<String> weekdayText = null;

}
