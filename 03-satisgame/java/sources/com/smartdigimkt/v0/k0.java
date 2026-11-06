package com.smartdigimkt.v0;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class k0 implements Parcelable {
    public final int a;
    public final i0[] b;
    public int c;
    public static final k0 d = new k0(new i0[0]);
    public static final Parcelable.Creator<k0> CREATOR = new j0();

    public k0(i0... i0VarArr) {
        this.b = i0VarArr;
        this.a = i0VarArr.length;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k0.class != obj.getClass()) {
            return false;
        }
        k0 k0Var = (k0) obj;
        return this.a == k0Var.a && Arrays.equals(this.b, k0Var.b);
    }

    public final int hashCode() {
        if (this.c == 0) {
            this.c = Arrays.hashCode(this.b);
        }
        return this.c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        for (int i2 = 0; i2 < this.a; i2++) {
            parcel.writeParcelable(this.b[i2], 0);
        }
    }

    public k0(Parcel parcel) {
        int i = parcel.readInt();
        this.a = i;
        this.b = new i0[i];
        for (int i2 = 0; i2 < this.a; i2++) {
            this.b[i2] = (i0) parcel.readParcelable(i0.class.getClassLoader());
        }
    }
}
