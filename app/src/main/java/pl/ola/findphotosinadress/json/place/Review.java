
package pl.ola.findphotosinadress.json.place;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Review {

    @SerializedName("aspects")
    @Expose
    public List<Aspect> aspects = null;
    @SerializedName("author_name")
    @Expose
    public String authorName;
    @SerializedName("author_url")
    @Expose
    public String authorUrl;
    @SerializedName("language")
    @Expose
    public String language;
    @SerializedName("profile_photo_url")
    @Expose
    public String profilePhotoUrl;
    @SerializedName("rating")
    @Expose
    public Integer rating;
    @SerializedName("relative_time_description")
    @Expose
    public String relativeTimeDescription;
    @SerializedName("text")
    @Expose
    public String text;
    @SerializedName("time")
    @Expose
    public Integer time;

}
