package com.tapsdk.tapad.model.entities;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class LogoInfo implements Parcelable {
    public static final Parcelable.Creator<LogoInfo> CREATOR = new a();
    public final ImageInfo logoImage;
    public final int logoStatus;
    public final String logoTitle;

    static class a implements Parcelable.Creator<LogoInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public LogoInfo createFromParcel(Parcel parcel) {
            return new LogoInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public LogoInfo[] newArray(int i) {
            return new LogoInfo[i];
        }
    }

    protected LogoInfo(Parcel parcel) {
        this.logoTitle = parcel.readString();
        this.logoStatus = parcel.readInt();
        this.logoImage = (ImageInfo) parcel.readParcelable(ImageInfo.class.getClassLoader());
    }

    public LogoInfo(TapAdResp.v vVar) {
        this.logoImage = new ImageInfo(vVar.E1());
        this.logoStatus = vVar.n2();
        this.logoTitle = vVar.F2();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.logoTitle);
        parcel.writeInt(this.logoStatus);
        parcel.writeParcelable(this.logoImage, i);
    }
}
