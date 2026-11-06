package com.smartdigimkt.m0;

import android.os.Parcel;
import android.os.Parcelable;
import com.smartdigimkt.z0.u;
import java.util.Arrays;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new b();
    public int a;
    public final UUID b;
    public final String c;
    public final String d;
    public final byte[] e;
    public final boolean f;

    public c(UUID uuid, byte[] bArr) {
        this.b = uuid;
        this.c = null;
        this.d = "video/mp4";
        this.e = bArr;
        this.f = false;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        c cVar = (c) obj;
        return u.a(this.c, cVar.c) && u.a(this.d, cVar.d) && u.a(this.b, cVar.b) && Arrays.equals(this.e, cVar.e);
    }

    public final int hashCode() {
        if (this.a == 0) {
            int iHashCode = this.b.hashCode() * 31;
            String str = this.c;
            this.a = Arrays.hashCode(this.e) + ((this.d.hashCode() + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31)) * 31);
        }
        return this.a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.b.getMostSignificantBits());
        parcel.writeLong(this.b.getLeastSignificantBits());
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeByteArray(this.e);
        parcel.writeByte(this.f ? (byte) 1 : (byte) 0);
    }

    public c(Parcel parcel) {
        this.b = new UUID(parcel.readLong(), parcel.readLong());
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.createByteArray();
        this.f = parcel.readByte() != 0;
    }
}
