
package pl.ola.findphotosinadress.places;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlacesResponse implements Parcelable {

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.htmlAttributions);
        dest.writeString(this.nextPageToken);
        dest.writeTypedList(this.results);
        dest.writeString(this.status);
    }

    public PlacesResponse() {
    }

    protected PlacesResponse(Parcel in) {
        this.htmlAttributions = new ArrayList<Object>();
        in.readList(this.htmlAttributions, Object.class.getClassLoader());
        this.nextPageToken = in.readString();
        this.results = in.createTypedArrayList(Place.CREATOR);
        this.status = in.readString();
    }

    public static final Parcelable.Creator<PlacesResponse> CREATOR = new Parcelable.Creator<PlacesResponse>() {
        @Override
        public PlacesResponse createFromParcel(Parcel source) {
            return new PlacesResponse(source);
        }

        @Override
        public PlacesResponse[] newArray(int size) {
            return new PlacesResponse[size];
        }
    };
}
