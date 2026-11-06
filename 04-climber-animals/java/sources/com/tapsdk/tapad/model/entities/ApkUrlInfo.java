package com.tapsdk.tapad.model.entities;

import android.os.Parcel;
import android.os.Parcelable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ApkUrlInfo implements Parcelable {
    public static final Parcelable.Creator<ApkUrlInfo> CREATOR = new a();
    public final TapAdResp.ApkDownloadType apkDownloadType;
    public final long expire;
    public final String url;

    static class a implements Parcelable.Creator<ApkUrlInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ApkUrlInfo createFromParcel(Parcel parcel) {
            return new ApkUrlInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ApkUrlInfo[] newArray(int i) {
            return new ApkUrlInfo[i];
        }
    }

    protected ApkUrlInfo(Parcel parcel) {
        this.url = parcel.readString();
        this.expire = parcel.readLong();
        this.apkDownloadType = TapAdResp.ApkDownloadType.forNumber(parcel.readInt());
    }

    public ApkUrlInfo(TapAdResp.d dVar) {
        this.url = dVar.H0();
        this.expire = dVar.j2();
        this.apkDownloadType = dVar.m2() != TapAdResp.ApkDownloadType.UNRECOGNIZED ? dVar.m2() : TapAdResp.ApkDownloadType.ApkDownloadType_default;
    }

    public ApkUrlInfo(JSONObject jSONObject) {
        this.url = jSONObject.optString("url");
        this.expire = jSONObject.optLong("expire");
        this.apkDownloadType = TapAdResp.ApkDownloadType.ApkDownloadType_default;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ApkUrlInfo{url='" + this.url + "', expire=" + this.expire + ", apkDownloadType=" + this.apkDownloadType + AbstractJsonLexerKt.END_OBJ;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.url);
        parcel.writeLong(this.expire);
        parcel.writeInt(this.apkDownloadType.getNumber());
    }
}
