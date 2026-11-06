package com.smartdigimkt.s0;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends o {
    public static final Parcelable.Creator<j> CREATOR = new i();
    public final String b;
    public final String c;
    public final String d;

    public j(String str, String str2, String str3) {
        super("COMM");
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j.class != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        return com.smartdigimkt.z0.u.a(this.c, jVar.c) && com.smartdigimkt.z0.u.a(this.b, jVar.b) && com.smartdigimkt.z0.u.a(this.d, jVar.d);
    }

    public final int hashCode() {
        String str = this.b;
        int iHashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
        String str2 = this.c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.d;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // com.smartdigimkt.s0.o
    public final String toString() {
        return this.a + ": language=" + this.b + ", description=" + this.c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.d);
    }

    public j(Parcel parcel) {
        super("COMM");
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
    }
}
