package com.smartdigimkt.x0;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements Parcelable {
    public static final Parcelable.Creator<f> CREATOR = new e();
    public final int a;
    public final int[] b;
    public final int c;

    public f(Parcel parcel) {
        this.a = parcel.readInt();
        int i = parcel.readByte();
        this.c = i;
        int[] iArr = new int[i];
        this.b = iArr;
        parcel.readIntArray(iArr);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        return this.a == fVar.a && Arrays.equals(this.b, fVar.b);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.b) + (this.a * 31);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b.length);
        parcel.writeIntArray(this.b);
    }
}
