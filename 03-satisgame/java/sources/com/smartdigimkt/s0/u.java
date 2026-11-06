package com.smartdigimkt.s0;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public final class u extends o {
    public static final Parcelable.Creator<u> CREATOR = new t();
    public final String b;
    public final String c;

    public u(String str, String str2, String str3) {
        super(str);
        this.b = str2;
        this.c = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || u.class != obj.getClass()) {
            return false;
        }
        u uVar = (u) obj;
        return this.a.equals(uVar.a) && com.smartdigimkt.z0.u.a(this.b, uVar.b) && com.smartdigimkt.z0.u.a(this.c, uVar.c);
    }

    public final int hashCode() {
        int iHashCode = (this.a.hashCode() + 527) * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.c;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // com.smartdigimkt.s0.o
    public final String toString() {
        return this.a + ": value=" + this.c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }

    public u(Parcel parcel) {
        super(parcel.readString());
        this.b = parcel.readString();
        this.c = parcel.readString();
    }
}
