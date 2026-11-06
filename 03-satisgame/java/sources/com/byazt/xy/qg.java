package com.byazt.xy;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 577, 26})
public class qg implements Parcelable {
    public static final Parcelable.Creator<qg> CREATOR = new Parcelable.Creator<qg>() { // from class: com.byazt.xy.qg.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public qg createFromParcel(Parcel parcel) {
            return new qg(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public qg[] newArray(int i) {
            return new qg[i];
        }
    };
    public String l;
    public int n;
    public int q;
    public int qg;
    public String s;
    public String w;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "";
    }

    public qg() {
        this.s = "";
        this.l = "";
        this.w = "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.n);
        parcel.writeInt(this.qg);
        parcel.writeString(this.s);
        parcel.writeString(this.l);
        parcel.writeString(this.w);
        parcel.writeInt(this.q);
    }

    public qg(Parcel parcel) {
        this.s = "";
        this.l = "";
        this.w = "";
        this.n = parcel.readInt();
        this.qg = parcel.readInt();
        this.s = parcel.readString();
        this.l = parcel.readString();
        this.w = parcel.readString();
        this.q = parcel.readInt();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            qg qgVar = (qg) obj;
            if (this.n == qgVar.n && this.qg == qgVar.qg) {
                String str = this.s;
                if (str != null) {
                    return str.equals(qgVar.s);
                }
                if (qgVar.s == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i = ((this.n * 31) + this.qg) * 31;
        String str = this.s;
        return i + (str != null ? str.hashCode() : 0);
    }
}
