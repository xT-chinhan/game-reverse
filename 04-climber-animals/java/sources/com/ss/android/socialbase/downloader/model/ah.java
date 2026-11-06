package com.ss.android.socialbase.downloader.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public class ah implements Parcelable, Comparable {
    public static final Parcelable.Creator<ah> CREATOR = new Parcelable.Creator<ah>() { // from class: com.ss.android.socialbase.downloader.model.ah.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
        public ah createFromParcel(Parcel parcel) {
            return new ah(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
        public ah[] newArray(int i) {
            return new ah[i];
        }
    };

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final String f4711ms;
    private final String xr;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ah(String str, String str2) {
        this.f4711ms = str;
        this.xr = str2;
    }

    protected ah(Parcel parcel) {
        this.f4711ms = parcel.readString();
        this.xr = parcel.readString();
    }

    public String ms() {
        return this.f4711ms;
    }

    public String xr() {
        return this.xr;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4711ms);
        parcel.writeString(this.xr);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (!(obj instanceof ah)) {
            return 1;
        }
        ah ahVar = (ah) obj;
        if (TextUtils.equals(this.f4711ms, ahVar.ms())) {
            return 0;
        }
        String str = this.f4711ms;
        if (str == null) {
            return -1;
        }
        int iCompareTo = str.compareTo(ahVar.ms());
        if (iCompareTo > 0) {
            return 1;
        }
        return iCompareTo < 0 ? -1 : 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ah ahVar = (ah) obj;
            if (TextUtils.equals(this.f4711ms, ahVar.f4711ms) && TextUtils.equals(this.xr, ahVar.xr)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f4711ms;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.xr;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "HttpHeader{name='" + this.f4711ms + "', value='" + this.xr + "'}";
    }
}
