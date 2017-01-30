
package pl.ola.findphotosinadress.json.places;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Northeast implements Parcelable {

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

    public Northeast() {
    }

    protected Northeast(Parcel in) {
        this.lat = (Double) in.readValue(Double.class.getClassLoader());
        this.lng = (Double) in.readValue(Double.class.getClassLoader());
    }

    public static final Parcelable.Creator<Northeast> CREATOR = new Parcelable.Creator<Northeast>() {
        @Override
        public Northeast createFromParcel(Parcel source) {
            return new Northeast(source);
        }

        @Override
        public Northeast[] newArray(int size) {
            return new Northeast[size];
        }
    };
}
