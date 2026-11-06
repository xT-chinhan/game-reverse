package com.tapsdk.tapad.group.ads.entities;

import android.os.Parcel;
import android.os.Parcelable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class ImageInfo implements Parcelable {
    public static final Parcelable.Creator<ImageInfo> CREATOR = new Parcelable.Creator<ImageInfo>() { // from class: com.tapsdk.tapad.group.ads.entities.ImageInfo.1
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

    public ImageInfo() {
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

    public ImageInfo(Parcel parcel) {
        this.imageUrl = parcel.readString();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
    }
}
