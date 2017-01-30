
package pl.ola.findphotosinadress.json.place;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("address_components")
    @Expose
    public List<AddressComponent> addressComponents = null;
    @SerializedName("adr_address")
    @Expose
    public String adrAddress;
    @SerializedName("formatted_address")
    @Expose
    public String formattedAddress;
    @SerializedName("formatted_phone_number")
    @Expose
    public String formattedPhoneNumber;
    @SerializedName("geometry")
    @Expose
    public Geometry geometry;
    @SerializedName("icon")
    @Expose
    public String icon;
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("international_phone_number")
    @Expose
    public String internationalPhoneNumber;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("opening_hours")
    @Expose
    public OpeningHours openingHours;
    @SerializedName("photos")
    @Expose
    public List<Photo> photos = null;
    @SerializedName("place_id")
    @Expose
    public String placeId;
    @SerializedName("rating")
    @Expose
    public Double rating;
    @SerializedName("reference")
    @Expose
    public String reference;
    @SerializedName("reviews")
    @Expose
    public List<Review> reviews = null;
    @SerializedName("scope")
    @Expose
    public String scope;
    @SerializedName("types")
    @Expose
    public List<String> types = null;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("utc_offset")
    @Expose
    public Integer utcOffset;
    @SerializedName("vicinity")
    @Expose
    public String vicinity;
    @SerializedName("website")
    @Expose
    public String website;

}
