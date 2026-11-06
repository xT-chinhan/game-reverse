package com.tapsdk.tapad.model.entities;

import android.os.Parcel;
import android.os.Parcelable;
import com.anythink.basead.c.b;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ImageInfo implements Parcelable {
    public static final Parcelable.Creator<ImageInfo> CREATOR = new a();
    public final int height;
    public final String imageUrl;
    public final int width;

    static class a implements Parcelable.Creator<ImageInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ImageInfo createFromParcel(Parcel parcel) {
            return new ImageInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ImageInfo[] newArray(int i) {
            return new ImageInfo[i];
        }
    }

    public ImageInfo() {
        this.imageUrl = "https://qn-static-tap.tapimg.com/MzQ3OTQxNTYxQDYzYzUxZjZkZjBkZDI.jpg?imageView2/0/w/1280/q/80/format/jpg/interlace/1/ignore-error/1";
        this.height = 1080;
        this.width = 1920;
    }

    protected ImageInfo(Parcel parcel) {
        this.imageUrl = parcel.readString();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
    }

    public ImageInfo(TapAdResp.p pVar) {
        this.imageUrl = pVar.C4();
        this.height = pVar.T1();
        this.width = pVar.I1();
    }

    public ImageInfo(JSONObject jSONObject) {
        this.imageUrl = jSONObject.optString(b.a.h);
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
}
