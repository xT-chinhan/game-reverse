package com.smartdigimkt.t0;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends c {
    public static final Parcelable.Creator<g> CREATOR = new e();
    public final long a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final long f;
    public final long g;
    public final List h;
    public final boolean i;
    public final long j;
    public final int k;
    public final int l;
    public final int m;

    public g(long j, boolean z, boolean z2, boolean z3, boolean z4, long j2, long j3, List list, boolean z5, long j4, int i, int i2, int i3) {
        this.a = j;
        this.b = z;
        this.c = z2;
        this.d = z3;
        this.e = z4;
        this.f = j2;
        this.g = j3;
        this.h = Collections.unmodifiableList(list);
        this.i = z5;
        this.j = j4;
        this.k = i;
        this.l = i2;
        this.m = i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.a);
        parcel.writeByte(this.b ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.e ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f);
        parcel.writeLong(this.g);
        int size = this.h.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            f fVar = (f) this.h.get(i2);
            parcel.writeInt(fVar.a);
            parcel.writeLong(fVar.b);
            parcel.writeLong(fVar.c);
        }
        parcel.writeByte(this.i ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.j);
        parcel.writeInt(this.k);
        parcel.writeInt(this.l);
        parcel.writeInt(this.m);
    }

    public g(Parcel parcel) {
        this.a = parcel.readLong();
        this.b = parcel.readByte() == 1;
        this.c = parcel.readByte() == 1;
        this.d = parcel.readByte() == 1;
        this.e = parcel.readByte() == 1;
        this.f = parcel.readLong();
        this.g = parcel.readLong();
        int i = parcel.readInt();
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(new f(parcel.readInt(), parcel.readLong(), parcel.readLong()));
        }
        this.h = Collections.unmodifiableList(arrayList);
        this.i = parcel.readByte() == 1;
        this.j = parcel.readLong();
        this.k = parcel.readInt();
        this.l = parcel.readInt();
        this.m = parcel.readInt();
    }
}
