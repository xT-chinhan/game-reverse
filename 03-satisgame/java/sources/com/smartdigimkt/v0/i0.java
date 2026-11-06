package com.smartdigimkt.v0;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class i0 implements Parcelable {
    public static final Parcelable.Creator<i0> CREATOR = new h0();
    public final int a;
    public final com.smartdigimkt.i0.s[] b;
    public int c;

    public i0(com.smartdigimkt.i0.s... sVarArr) {
        if (sVarArr.length <= 0) {
            throw new IllegalStateException();
        }
        this.b = sVarArr;
        this.a = sVarArr.length;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i0.class != obj.getClass()) {
            return false;
        }
        i0 i0Var = (i0) obj;
        return this.a == i0Var.a && Arrays.equals(this.b, i0Var.b);
    }

    public final int hashCode() {
        if (this.c == 0) {
            this.c = Arrays.hashCode(this.b) + 527;
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

    public i0(Parcel parcel) {
        int i = parcel.readInt();
        this.a = i;
        this.b = new com.smartdigimkt.i0.s[i];
        for (int i2 = 0; i2 < this.a; i2++) {
            this.b[i2] = (com.smartdigimkt.i0.s) parcel.readParcelable(com.smartdigimkt.i0.s.class.getClassLoader());
        }
    }
}
