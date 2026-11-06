package com.tapsdk.tapad.model.entities;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class UninstalledAdInfo implements Parcelable {
    public static final Parcelable.Creator<UninstalledAdInfo> CREATOR = new a();
    public final AdInfo adInfo;
    public final String downloadFilePath;

    static class a implements Parcelable.Creator<UninstalledAdInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public UninstalledAdInfo createFromParcel(Parcel parcel) {
            return new UninstalledAdInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public UninstalledAdInfo[] newArray(int i) {
            return new UninstalledAdInfo[i];
        }
    }

    protected UninstalledAdInfo(Parcel parcel) {
        this.adInfo = (AdInfo) parcel.readParcelable(UninstalledAdInfo.class.getClassLoader());
        this.downloadFilePath = parcel.readString();
    }

    public UninstalledAdInfo(AdInfo adInfo, String str) {
        this.adInfo = adInfo;
        this.downloadFilePath = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "UninstalledAdInfo{adInfo=" + this.adInfo + ", downloadFilePath='" + this.downloadFilePath + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.adInfo, i);
        parcel.writeString(this.downloadFilePath);
    }
}
