
package pl.ola.findphotosinadress.places;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Place implements Parcelable {

    @SerializedName("geometry")
    @Expose
    public Geometry geometry;
    @SerializedName("icon")
    @Expose
    public String icon;
    @SerializedName("id")
    @Expose
    public String id;
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
    @SerializedName("scope")
    @Expose
    public String scope;
    @SerializedName("types")
    @Expose
    public List<String> types = null;
    @SerializedName("vicinity")
    @Expose
    public String vicinity;
    @SerializedName("price_level")
    @Expose
    public Integer priceLevel;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.geometry, flags);
        dest.writeString(this.icon);
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeParcelable(this.openingHours, flags);
        dest.writeList(this.photos);
        dest.writeString(this.placeId);
        dest.writeValue(this.rating);
        dest.writeString(this.reference);
        dest.writeString(this.scope);
        dest.writeStringList(this.types);
        dest.writeString(this.vicinity);
        dest.writeValue(this.priceLevel);
    }

    public Place() {
    }

    protected Place(Parcel in) {
        this.geometry = in.readParcelable(Geometry.class.getClassLoader());
        this.icon = in.readString();
        this.id = in.readString();
        this.name = in.readString();
        this.openingHours = in.readParcelable(OpeningHours.class.getClassLoader());
        this.photos = new ArrayList<Photo>();
        in.readList(this.photos, Photo.class.getClassLoader());
        this.placeId = in.readString();
        this.rating = (Double) in.readValue(Double.class.getClassLoader());
        this.reference = in.readString();
        this.scope = in.readString();
        this.types = in.createStringArrayList();
        this.vicinity = in.readString();
        this.priceLevel = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Creator<Place> CREATOR = new Creator<Place>() {
        @Override
        public Place createFromParcel(Parcel source) {
            return new Place(source);
        }

        @Override
        public Place[] newArray(int size) {
            return new Place[size];
        }
    };
}
