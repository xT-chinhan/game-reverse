package com.smartdigimkt.s0;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public final class q extends o {
    public static final Parcelable.Creator<q> CREATOR = new p();
    public final String b;
    public final String c;
    public final String d;

    public q(String str, String str2, String str3) {
        super("----");
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || q.class != obj.getClass()) {
            return false;
        }
        q qVar = (q) obj;
        return com.smartdigimkt.z0.u.a(this.c, qVar.c) && com.smartdigimkt.z0.u.a(this.b, qVar.b) && com.smartdigimkt.z0.u.a(this.d, qVar.d);
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
        return this.a + ": domain=" + this.b + ", description=" + this.c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.d);
    }

    public q(Parcel parcel) {
        super("----");
        String string = parcel.readString();
        string.getClass();
        this.b = string;
        String string2 = parcel.readString();
        string2.getClass();
        this.c = string2;
        String string3 = parcel.readString();
        string3.getClass();
        this.d = string3;
    }
}
