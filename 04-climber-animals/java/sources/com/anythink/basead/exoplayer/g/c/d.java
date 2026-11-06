package com.anythink.basead.exoplayer.g.c;

import android.os.Parcel;
import android.os.Parcelable;
import com.anythink.basead.exoplayer.k.ac;
import com.anythink.basead.exoplayer.k.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class d extends b {
    public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator<d>() { // from class: com.anythink.basead.exoplayer.g.c.d.1
        private static d a(Parcel parcel) {
            return new d(parcel, (byte) 0);
        }

        private static d[] a(int i) {
            return new d[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ d[] newArray(int i) {
            return new d[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ d createFromParcel(Parcel parcel) {
            return new d(parcel, (byte) 0);
        }
    };
    public final long a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final long f;
    public final long g;
    public final List<a> h;
    public final boolean i;
    public final long j;
    public final int k;
    public final int l;
    public final int m;

    /* synthetic */ d(Parcel parcel, byte b) {
        this(parcel);
    }

    private d(long j, boolean z, boolean z2, boolean z3, boolean z4, long j2, long j3, List<a> list, boolean z5, long j4, int i, int i2, int i3) {
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

    private d(Parcel parcel) {
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
            arrayList.add(a.a(parcel));
        }
        this.h = Collections.unmodifiableList(arrayList);
        this.i = parcel.readByte() == 1;
        this.j = parcel.readLong();
        this.k = parcel.readInt();
        this.l = parcel.readInt();
        this.m = parcel.readInt();
    }

    static d a(s sVar, long j, ac acVar) {
        List list;
        boolean z;
        boolean z2;
        long j2;
        boolean z3;
        long j3;
        int iE;
        int iD;
        int iD2;
        boolean z4;
        boolean z5;
        long jH;
        long jH2 = sVar.h();
        boolean z6 = (sVar.d() & 128) != 0;
        List listEmptyList = Collections.emptyList();
        if (z6) {
            list = listEmptyList;
            z = false;
            z2 = false;
            j2 = -9223372036854775807L;
            z3 = false;
            j3 = -9223372036854775807L;
            iE = 0;
            iD = 0;
            iD2 = 0;
            z4 = false;
        } else {
            int iD3 = sVar.d();
            boolean z7 = (iD3 & 128) != 0;
            boolean z8 = (iD3 & 64) != 0;
            boolean z9 = (iD3 & 32) != 0;
            boolean z10 = (iD3 & 16) != 0;
            long jA = (!z8 || z10) ? -9223372036854775807L : g.a(sVar, j);
            if (!z8) {
                int iD4 = sVar.d();
                ArrayList arrayList = new ArrayList(iD4);
                for (int i = 0; i < iD4; i++) {
                    int iD5 = sVar.d();
                    long jA2 = !z10 ? g.a(sVar, j) : -9223372036854775807L;
                    arrayList.add(new a(iD5, jA2, acVar.a(jA2), (byte) 0));
                }
                listEmptyList = arrayList;
            }
            if (z9) {
                long jD = sVar.d();
                boolean z11 = (128 & jD) != 0;
                jH = ((((jD & 1) << 32) | sVar.h()) * 1000) / 90;
                z5 = z11;
            } else {
                z5 = false;
                jH = -9223372036854775807L;
            }
            iE = sVar.e();
            z4 = z8;
            iD = sVar.d();
            iD2 = sVar.d();
            list = listEmptyList;
            long j4 = jA;
            z3 = z5;
            j3 = jH;
            z2 = z10;
            z = z7;
            j2 = j4;
        }
        return new d(jH2, z6, z, z4, z2, j2, acVar.a(j2), list, z3, j3, iE, iD, iD2);
    }

    public static final class a {
        public final int a;
        public final long b;
        public final long c;

        /* synthetic */ a(int i, long j, long j2, byte b) {
            this(i, j, j2);
        }

        private a(int i, long j, long j2) {
            this.a = i;
            this.b = j;
            this.c = j2;
        }

        private void b(Parcel parcel) {
            parcel.writeInt(this.a);
            parcel.writeLong(this.b);
            parcel.writeLong(this.c);
        }

        public static a a(Parcel parcel) {
            return new a(parcel.readInt(), parcel.readLong(), parcel.readLong());
        }
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
            a aVar = this.h.get(i2);
            parcel.writeInt(aVar.a);
            parcel.writeLong(aVar.b);
            parcel.writeLong(aVar.c);
        }
        parcel.writeByte(this.i ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.j);
        parcel.writeInt(this.k);
        parcel.writeInt(this.l);
        parcel.writeInt(this.m);
    }
}
