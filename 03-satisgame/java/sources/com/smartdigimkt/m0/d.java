package com.smartdigimkt.m0;

import android.os.Parcel;
import android.os.Parcelable;
import com.smartdigimkt.z0.u;
import java.util.Arrays;
import java.util.Comparator;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Comparator, Parcelable {
    public static final Parcelable.Creator<d> CREATOR = new a();
    public final c[] a;
    public int b;
    public final String c;
    public final int d;

    public d(String str, c... cVarArr) {
        this.c = str;
        Arrays.sort(cVarArr, this);
        this.a = cVarArr;
        this.d = cVarArr.length;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        c cVar = (c) obj;
        c cVar2 = (c) obj2;
        UUID uuid = com.smartdigimkt.i0.b.b;
        if (uuid.equals(cVar.b)) {
            return uuid.equals(cVar2.b) ? 0 : 1;
        }
        return cVar.b.compareTo(cVar2.b);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return u.a(this.c, dVar.c) && Arrays.equals(this.a, dVar.a);
    }

    public final int hashCode() {
        if (this.b == 0) {
            String str = this.c;
            this.b = ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.a);
        }
        return this.b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.c);
        parcel.writeTypedArray(this.a, 0);
    }

    public d(Parcel parcel) {
        this.c = parcel.readString();
        c[] cVarArr = (c[]) parcel.createTypedArray(c.CREATOR);
        this.a = cVarArr;
        this.d = cVarArr.length;
    }
}
