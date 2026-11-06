package com.smartdigimkt.x0;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.smartdigimkt.v0.k0;
import com.smartdigimkt.z0.u;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Parcelable {
    public final SparseArray a;
    public final SparseBooleanArray b;
    public final String c;
    public final String d;
    public final boolean e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final boolean j;
    public final int k;
    public final int l;
    public final boolean m;
    public final boolean n;
    public final boolean o;
    public final boolean p;
    public final boolean q;
    public final int r;
    public static final d s = new d();
    public static final Parcelable.Creator<d> CREATOR = new c();

    public d() {
        SparseArray sparseArray = new SparseArray();
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        this.a = sparseArray;
        this.b = sparseBooleanArray;
        this.c = u.b(null);
        this.d = u.b(null);
        this.e = false;
        this.f = 0;
        this.n = false;
        this.o = false;
        this.p = true;
        this.g = Integer.MAX_VALUE;
        this.h = Integer.MAX_VALUE;
        this.i = Integer.MAX_VALUE;
        this.j = true;
        this.q = true;
        this.k = Integer.MAX_VALUE;
        this.l = Integer.MAX_VALUE;
        this.m = true;
        this.r = 0;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (this.e == dVar.e && this.f == dVar.f && this.n == dVar.n && this.o == dVar.o && this.p == dVar.p && this.g == dVar.g && this.h == dVar.h && this.j == dVar.j && this.q == dVar.q && this.m == dVar.m && this.k == dVar.k && this.l == dVar.l && this.i == dVar.i && this.r == dVar.r && TextUtils.equals(this.c, dVar.c) && TextUtils.equals(this.d, dVar.d)) {
            SparseBooleanArray sparseBooleanArray = this.b;
            SparseBooleanArray sparseBooleanArray2 = dVar.b;
            int size = sparseBooleanArray.size();
            if (sparseBooleanArray2.size() == size) {
                for (int i = 0; i < size; i++) {
                    if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i)) >= 0) {
                    }
                }
                SparseArray sparseArray = this.a;
                SparseArray sparseArray2 = dVar.a;
                int size2 = sparseArray.size();
                if (sparseArray2.size() == size2) {
                    for (int i2 = 0; i2 < size2; i2++) {
                        int iIndexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i2));
                        if (iIndexOfKey >= 0) {
                            Map map = (Map) sparseArray.valueAt(i2);
                            Map map2 = (Map) sparseArray2.valueAt(iIndexOfKey);
                            if (map2.size() == map.size()) {
                                for (Map.Entry entry : map.entrySet()) {
                                    k0 k0Var = (k0) entry.getKey();
                                    if (!map2.containsKey(k0Var) || !u.a(entry.getValue(), map2.get(k0Var))) {
                                    }
                                }
                            }
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = (((((((((((((((((((((((((((this.e ? 1 : 0) * 31) + this.f) * 31) + (this.n ? 1 : 0)) * 31) + (this.o ? 1 : 0)) * 31) + (this.p ? 1 : 0)) * 31) + this.g) * 31) + this.h) * 31) + (this.j ? 1 : 0)) * 31) + (this.q ? 1 : 0)) * 31) + (this.m ? 1 : 0)) * 31) + this.k) * 31) + this.l) * 31) + this.i) * 31) + this.r) * 31;
        String str = this.c;
        int iHashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.d;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        SparseArray sparseArray = this.a;
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            int iKeyAt = sparseArray.keyAt(i2);
            Map map = (Map) sparseArray.valueAt(i2);
            int size2 = map.size();
            parcel.writeInt(iKeyAt);
            parcel.writeInt(size2);
            for (Map.Entry entry : map.entrySet()) {
                parcel.writeParcelable((Parcelable) entry.getKey(), 0);
                parcel.writeParcelable((Parcelable) entry.getValue(), 0);
            }
        }
        parcel.writeSparseBooleanArray(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.e ? 1 : 0);
        parcel.writeInt(this.f);
        parcel.writeInt(this.n ? 1 : 0);
        parcel.writeInt(this.o ? 1 : 0);
        parcel.writeInt(this.p ? 1 : 0);
        parcel.writeInt(this.g);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
        parcel.writeInt(this.j ? 1 : 0);
        parcel.writeInt(this.q ? 1 : 0);
        parcel.writeInt(this.k);
        parcel.writeInt(this.l);
        parcel.writeInt(this.m ? 1 : 0);
        parcel.writeInt(this.r);
    }

    public d(Parcel parcel) {
        int i = parcel.readInt();
        SparseArray sparseArray = new SparseArray(i);
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = parcel.readInt();
            int i4 = parcel.readInt();
            HashMap map = new HashMap(i4);
            for (int i5 = 0; i5 < i4; i5++) {
                map.put((k0) parcel.readParcelable(k0.class.getClassLoader()), (f) parcel.readParcelable(f.class.getClassLoader()));
            }
            sparseArray.put(i3, map);
        }
        this.a = sparseArray;
        this.b = parcel.readSparseBooleanArray();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readInt() != 0;
        this.f = parcel.readInt();
        this.n = parcel.readInt() != 0;
        this.o = parcel.readInt() != 0;
        this.p = parcel.readInt() != 0;
        this.g = parcel.readInt();
        this.h = parcel.readInt();
        this.i = parcel.readInt();
        this.j = parcel.readInt() != 0;
        this.q = parcel.readInt() != 0;
        this.k = parcel.readInt();
        this.l = parcel.readInt();
        this.m = parcel.readInt() != 0;
        this.r = parcel.readInt();
    }
}
