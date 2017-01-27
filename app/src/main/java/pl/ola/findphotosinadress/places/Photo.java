
package pl.ola.findphotosinadress.places;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Photo implements Parcelable {

    @SerializedName("height")
    @Expose
    public Integer height;
    @SerializedName("html_attributions")
    @Expose
    public List<String> htmlAttributions = null;
    @SerializedName("photo_reference")
    @Expose
    public String photoReference;
    @SerializedName("width")
    @Expose
    public Integer width;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.height);
        dest.writeStringList(this.htmlAttributions);
        dest.writeString(this.photoReference);
        dest.writeValue(this.width);
    }

    public Photo() {
    }

    protected Photo(Parcel in) {
        this.height = (Integer) in.readValue(Integer.class.getClassLoader());
        this.htmlAttributions = in.createStringArrayList();
        this.photoReference = in.readString();
        this.width = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Parcelable.Creator<Photo> CREATOR = new Parcelable.Creator<Photo>() {
        @Override
        public Photo createFromParcel(Parcel source) {
            return new Photo(source);
        }

        @Override
        public Photo[] newArray(int size) {
            return new Photo[size];
        }
    };
}
