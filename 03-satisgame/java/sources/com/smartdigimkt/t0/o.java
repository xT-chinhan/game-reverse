package com.smartdigimkt.t0;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public final class o extends c {
    public static final Parcelable.Creator<o> CREATOR = new n();
    public final long a;
    public final long b;

    public o(int i, long j, long j2) {
        this.a = j;
        this.b = j2;
    }

    public static long a(com.smartdigimkt.z0.m mVar, long j) {
        long jE = mVar.e();
        if ((128 & jE) != 0) {
            return 8589934591L & ((((jE & 1) << 32) | mVar.f()) + j);
        }
        return -9223372036854775807L;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.a);
        parcel.writeLong(this.b);
    }

    public o(long j, long j2) {
        this.a = j;
        this.b = j2;
    }
}
