package com.smartdigimkt.a1;

import android.os.Parcel;
import android.os.Parcelable;
import com.smartdigimkt.z0.u;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();
    public final int a;
    public final int b;
    public final int c;
    public final byte[] d;
    public int e;

    public b(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        int i = u.a;
        this.d = parcel.readInt() != 0 ? parcel.createByteArray() : null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.a == bVar.a && this.b == bVar.b && this.c == bVar.c && Arrays.equals(this.d, bVar.d);
    }

    public final int hashCode() {
        if (this.e == 0) {
            this.e = Arrays.hashCode(this.d) + ((((((this.a + 527) * 31) + this.b) * 31) + this.c) * 31);
        }
        return this.e;
    }

    public final String toString() {
        return "ColorInfo(" + this.a + ", " + this.b + ", " + this.c + ", " + (this.d != null) + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        int i2 = this.d != null ? 1 : 0;
        int i3 = u.a;
        parcel.writeInt(i2);
        byte[] bArr = this.d;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
    }
}
