package com.smartdigimkt.t0;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends c {
    public static final Parcelable.Creator<b> CREATOR = new a();
    public final long a;
    public final long b;
    public final byte[] c;

    public b(long j, byte[] bArr, long j2) {
        this.a = j2;
        this.b = j;
        this.c = bArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.a);
        parcel.writeLong(this.b);
        parcel.writeInt(this.c.length);
        parcel.writeByteArray(this.c);
    }

    public b(Parcel parcel) {
        this.a = parcel.readLong();
        this.b = parcel.readLong();
        byte[] bArr = new byte[parcel.readInt()];
        this.c = bArr;
        parcel.readByteArray(bArr);
    }
}
