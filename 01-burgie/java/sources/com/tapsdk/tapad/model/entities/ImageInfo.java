package com.tapsdk.tapad.model.entities;

import android.os.Parcel;
import android.os.Parcelable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ImageInfo implements Parcelable {
    public static final Parcelable.Creator<ImageInfo> CREATOR = new Parcelable.Creator<ImageInfo>() { // from class: com.tapsdk.tapad.model.entities.ImageInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImageInfo createFromParcel(Parcel parcel) {
            return new ImageInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImageInfo[] newArray(int i) {
            return new ImageInfo[i];
        }
    };
    public int height;
    public String imageUrl;
    public int width;

    public ImageInfo(JSONObject jSONObject) {
        this.imageUrl = jSONObject.optString("image_url");
        this.width = jSONObject.optInt("width");
        this.height = jSONObject.optInt("height");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ImageInfo{imageUrl='" + this.imageUrl + "', width=" + this.width + ", height=" + this.height + AbstractJsonLexerKt.END_OBJ;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.imageUrl);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
    }

    public ImageInfo() {
    }

    public ImageInfo(Parcel parcel) {
        this.imageUrl = parcel.readString();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
    }
}
