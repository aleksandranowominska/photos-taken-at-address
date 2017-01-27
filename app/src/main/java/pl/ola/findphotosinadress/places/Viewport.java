
package pl.ola.findphotosinadress.places;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Viewport implements Parcelable{

    @SerializedName("northeast")
    @Expose
    public Northeast northeast;
    @SerializedName("southwest")
    @Expose
    public Southwest southwest;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.northeast, flags);
        dest.writeParcelable(this.southwest, flags);
    }

    public Viewport() {
    }

    protected Viewport(Parcel in) {
        this.northeast = in.readParcelable(Northeast.class.getClassLoader());
        this.southwest = in.readParcelable(Southwest.class.getClassLoader());
    }

    public static final Creator<Viewport> CREATOR = new Creator<Viewport>() {
        @Override
        public Viewport createFromParcel(Parcel source) {
            return new Viewport(source);
        }

        @Override
        public Viewport[] newArray(int size) {
            return new Viewport[size];
        }
    };
}
