package com.smartdigimkt.r0;

import android.os.Parcel;
import android.os.Parcelable;
import com.smartdigimkt.z0.u;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements com.smartdigimkt.q0.b {
    public static final Parcelable.Creator<b> CREATOR = new a();
    public final String a;
    public final String b;
    public final long c;
    public final long d;
    public final long e;
    public final byte[] f;
    public int g;

    public b(String str, String str2, long j, long j2, byte[] bArr, long j3) {
        this.a = str;
        this.b = str2;
        this.c = j;
        this.e = j2;
        this.f = bArr;
        this.d = j3;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.d == bVar.d && this.c == bVar.c && this.e == bVar.e && u.a(this.a, bVar.a) && u.a(this.b, bVar.b) && Arrays.equals(this.f, bVar.f);
    }

    public final int hashCode() {
        if (this.g == 0) {
            String str = this.a;
            int iHashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
            String str2 = this.b;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            long j = this.d;
            int i = (iHashCode2 + ((int) (j ^ (j >>> 32)))) * 31;
            long j2 = this.c;
            int i2 = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            long j3 = this.e;
            this.g = Arrays.hashCode(this.f) + ((i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31);
        }
        return this.g;
    }

    public final String toString() {
        return "EMSG: scheme=" + this.a + ", id=" + this.e + ", value=" + this.b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeLong(this.d);
        parcel.writeLong(this.c);
        parcel.writeLong(this.e);
        parcel.writeByteArray(this.f);
    }

    public b(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.d = parcel.readLong();
        this.c = parcel.readLong();
        this.e = parcel.readLong();
        this.f = parcel.createByteArray();
    }
}
