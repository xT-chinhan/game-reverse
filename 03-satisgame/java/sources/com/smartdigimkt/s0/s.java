package com.smartdigimkt.s0;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class s extends o {
    public static final Parcelable.Creator<s> CREATOR = new r();
    public final String b;
    public final byte[] c;

    public s(String str, byte[] bArr) {
        super("PRIV");
        this.b = str;
        this.c = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || s.class != obj.getClass()) {
            return false;
        }
        s sVar = (s) obj;
        return com.smartdigimkt.z0.u.a(this.b, sVar.b) && Arrays.equals(this.c, sVar.c);
    }

    public final int hashCode() {
        String str = this.b;
        return Arrays.hashCode(this.c) + (((str != null ? str.hashCode() : 0) + 527) * 31);
    }

    @Override // com.smartdigimkt.s0.o
    public final String toString() {
        return this.a + ": owner=" + this.b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeByteArray(this.c);
    }

    public s(Parcel parcel) {
        super("PRIV");
        this.b = parcel.readString();
        this.c = parcel.createByteArray();
    }
}
