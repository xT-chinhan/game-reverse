package com.smartdigimkt.i0;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: loaded from: classes3.dex */
public final class s implements Parcelable {
    public static final Parcelable.Creator<s> CREATOR = new r();
    public int A;
    public final String a;
    public final int b;
    public final String c;
    public final com.smartdigimkt.q0.c d;
    public final String e;
    public final String f;
    public final int g;
    public final List h;
    public final com.smartdigimkt.m0.d i;
    public final long j;
    public final int k;
    public final int l;
    public final float m;
    public final int n;
    public final float o;
    public final int p;
    public final byte[] q;
    public final com.smartdigimkt.a1.b r;
    public final int s;
    public final int t;
    public final int u;
    public final int v;
    public final int w;
    public final int x;
    public final String y;
    public final int z;

    public s(String str, String str2, String str3, String str4, int i, int i2, int i3, int i4, float f, int i5, float f2, byte[] bArr, int i6, com.smartdigimkt.a1.b bVar, int i7, int i8, int i9, int i10, int i11, int i12, String str5, int i13, long j, List list, com.smartdigimkt.m0.d dVar, com.smartdigimkt.q0.c cVar) {
        this.a = str;
        this.e = str2;
        this.f = str3;
        this.c = str4;
        this.b = i;
        this.g = i2;
        this.k = i3;
        this.l = i4;
        this.m = f;
        int i14 = i5;
        this.n = i14 == -1 ? 0 : i14;
        this.o = f2 == -1.0f ? 1.0f : f2;
        this.q = bArr;
        this.p = i6;
        this.r = bVar;
        this.s = i7;
        this.t = i8;
        this.u = i9;
        int i15 = i10;
        this.v = i15 == -1 ? 0 : i15;
        this.w = i11 != -1 ? i11 : 0;
        this.x = i12;
        this.y = str5;
        this.z = i13;
        this.j = j;
        this.h = list == null ? Collections.emptyList() : list;
        this.i = dVar;
        this.d = cVar;
    }

    public static s a(String str, String str2, int i, int i2, int i3, List list, com.smartdigimkt.m0.d dVar, String str3) {
        return new s(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i, i2, i3, -1, -1, 0, str3, -1, LongCompanionObject.MAX_VALUE, list, dVar, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || s.class != obj.getClass()) {
            return false;
        }
        s sVar = (s) obj;
        if (this.b == sVar.b && this.g == sVar.g && this.k == sVar.k && this.l == sVar.l && this.m == sVar.m && this.n == sVar.n && this.o == sVar.o && this.p == sVar.p && this.s == sVar.s && this.t == sVar.t && this.u == sVar.u && this.v == sVar.v && this.w == sVar.w && this.j == sVar.j && this.x == sVar.x && com.smartdigimkt.z0.u.a(this.a, sVar.a) && com.smartdigimkt.z0.u.a(this.y, sVar.y) && this.z == sVar.z && com.smartdigimkt.z0.u.a(this.e, sVar.e) && com.smartdigimkt.z0.u.a(this.f, sVar.f) && com.smartdigimkt.z0.u.a(this.c, sVar.c) && com.smartdigimkt.z0.u.a(this.i, sVar.i) && com.smartdigimkt.z0.u.a(this.d, sVar.d) && com.smartdigimkt.z0.u.a(this.r, sVar.r) && Arrays.equals(this.q, sVar.q) && this.h.size() == sVar.h.size()) {
            for (int i = 0; i < this.h.size(); i++) {
                if (Arrays.equals((byte[]) this.h.get(i), (byte[]) sVar.h.get(i))) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        if (this.A == 0) {
            String str = this.a;
            int iHashCode = ((str == null ? 0 : str.hashCode()) + 527) * 31;
            String str2 = this.e;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.c;
            int iHashCode4 = (((((((((((iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.b) * 31) + this.k) * 31) + this.l) * 31) + this.s) * 31) + this.t) * 31;
            String str5 = this.y;
            int iHashCode5 = (((iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.z) * 31;
            com.smartdigimkt.m0.d dVar = this.i;
            int iHashCode6 = (iHashCode5 + (dVar == null ? 0 : dVar.hashCode())) * 31;
            com.smartdigimkt.q0.c cVar = this.d;
            this.A = iHashCode6 + (cVar != null ? Arrays.hashCode(cVar.a) : 0);
        }
        return this.A;
    }

    public final String toString() {
        return com.smartdigimkt.c0.j.a(new StringBuilder("Format(").append(this.a).append(", ").append(this.e).append(", ").append(this.f).append(", ").append(this.b).append(", ").append(this.y).append(", [").append(this.k).append(", ").append(this.l).append(", ").append(this.m).append("], [").append(this.s).append(", "), this.t, "])");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.c);
        parcel.writeInt(this.b);
        parcel.writeInt(this.g);
        parcel.writeInt(this.k);
        parcel.writeInt(this.l);
        parcel.writeFloat(this.m);
        parcel.writeInt(this.n);
        parcel.writeFloat(this.o);
        int i2 = this.q != null ? 1 : 0;
        int i3 = com.smartdigimkt.z0.u.a;
        parcel.writeInt(i2);
        byte[] bArr = this.q;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
        parcel.writeInt(this.p);
        parcel.writeParcelable(this.r, i);
        parcel.writeInt(this.s);
        parcel.writeInt(this.t);
        parcel.writeInt(this.u);
        parcel.writeInt(this.v);
        parcel.writeInt(this.w);
        parcel.writeInt(this.x);
        parcel.writeString(this.y);
        parcel.writeInt(this.z);
        parcel.writeLong(this.j);
        int size = this.h.size();
        parcel.writeInt(size);
        for (int i4 = 0; i4 < size; i4++) {
            parcel.writeByteArray((byte[]) this.h.get(i4));
        }
        parcel.writeParcelable(this.i, 0);
        parcel.writeParcelable(this.d, 0);
    }

    public s(Parcel parcel) {
        this.a = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.c = parcel.readString();
        this.b = parcel.readInt();
        this.g = parcel.readInt();
        this.k = parcel.readInt();
        this.l = parcel.readInt();
        this.m = parcel.readFloat();
        this.n = parcel.readInt();
        this.o = parcel.readFloat();
        int i = com.smartdigimkt.z0.u.a;
        this.q = parcel.readInt() != 0 ? parcel.createByteArray() : null;
        this.p = parcel.readInt();
        this.r = (com.smartdigimkt.a1.b) parcel.readParcelable(com.smartdigimkt.a1.b.class.getClassLoader());
        this.s = parcel.readInt();
        this.t = parcel.readInt();
        this.u = parcel.readInt();
        this.v = parcel.readInt();
        this.w = parcel.readInt();
        this.x = parcel.readInt();
        this.y = parcel.readString();
        this.z = parcel.readInt();
        this.j = parcel.readLong();
        int i2 = parcel.readInt();
        this.h = new ArrayList(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            this.h.add(parcel.createByteArray());
        }
        this.i = (com.smartdigimkt.m0.d) parcel.readParcelable(com.smartdigimkt.m0.d.class.getClassLoader());
        this.d = (com.smartdigimkt.q0.c) parcel.readParcelable(com.smartdigimkt.q0.c.class.getClassLoader());
    }
}
