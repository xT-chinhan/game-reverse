package com.ss.android.downloadlib.ms.ms;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class xr implements Parcelable {
    public static final Parcelable.Creator<xr> CREATOR = new Parcelable.Creator<xr>() { // from class: com.ss.android.downloadlib.ms.ms.xr.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
        public xr createFromParcel(Parcel parcel) {
            return new xr(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
        public xr[] newArray(int i) {
            return new xr[i];
        }
    };
    public String ah;
    public String c;
    public int d;
    public String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public int f4515ms;
    public int xr;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "";
    }

    public xr() {
        this.ah = "";
        this.ka = "";
        this.c = "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f4515ms);
        parcel.writeInt(this.xr);
        parcel.writeString(this.ah);
        parcel.writeString(this.ka);
        parcel.writeString(this.c);
        parcel.writeInt(this.d);
    }

    protected xr(Parcel parcel) {
        this.ah = "";
        this.ka = "";
        this.c = "";
        this.f4515ms = parcel.readInt();
        this.xr = parcel.readInt();
        this.ah = parcel.readString();
        this.ka = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readInt();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            xr xrVar = (xr) obj;
            if (this.f4515ms == xrVar.f4515ms && this.xr == xrVar.xr) {
                String str = this.ah;
                if (str != null) {
                    return str.equals(xrVar.ah);
                }
                if (xrVar.ah == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i = ((this.f4515ms * 31) + this.xr) * 31;
        String str = this.ah;
        return i + (str != null ? str.hashCode() : 0);
    }
}
