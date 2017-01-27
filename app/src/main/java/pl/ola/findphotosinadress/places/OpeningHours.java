
package pl.ola.findphotosinadress.places;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OpeningHours implements Parcelable {

    @SerializedName("open_now")
    @Expose
    public Boolean openNow;
    @SerializedName("weekday_text")
    @Expose
    public List<Object> weekdayText = null;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.openNow);
        dest.writeList(this.weekdayText);
    }

    public OpeningHours() {
    }

    protected OpeningHours(Parcel in) {
        this.openNow = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.weekdayText = new ArrayList<Object>();
        in.readList(this.weekdayText, Object.class.getClassLoader());
    }

    public static final Parcelable.Creator<OpeningHours> CREATOR = new Parcelable.Creator<OpeningHours>() {
        @Override
        public OpeningHours createFromParcel(Parcel source) {
            return new OpeningHours(source);
        }

        @Override
        public OpeningHours[] newArray(int size) {
            return new OpeningHours[size];
        }
    };
}
