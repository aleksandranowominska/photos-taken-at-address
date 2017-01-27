
package pl.ola.findphotosinadress.places;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Southwest implements Parcelable {

    @SerializedName("lat")
    @Expose
    public Double lat;
    @SerializedName("lng")
    @Expose
    public Double lng;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.lat);
        dest.writeValue(this.lng);
    }

    public Southwest() {
    }

    protected Southwest(Parcel in) {
        this.lat = (Double) in.readValue(Double.class.getClassLoader());
        this.lng = (Double) in.readValue(Double.class.getClassLoader());
    }

    public static final Creator<Southwest> CREATOR = new Creator<Southwest>() {
        @Override
        public Southwest createFromParcel(Parcel source) {
            return new Southwest(source);
        }

        @Override
        public Southwest[] newArray(int size) {
            return new Southwest[size];
        }
    };
}
