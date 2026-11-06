package com.smartdigimkt.s0;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends o {
    public static final Parcelable.Creator<f> CREATOR = new e();
    public final String b;
    public final int c;
    public final int d;
    public final long e;
    public final long f;
    public final o[] g;

    public f(String str, int i, int i2, long j, long j2, o[] oVarArr) {
        super("CHAP");
        this.b = str;
        this.c = i;
        this.d = i2;
        this.e = j;
        this.f = j2;
        this.g = oVarArr;
    }

    @Override // com.smartdigimkt.s0.o, android.os.Parcelable
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
        return this.c == fVar.c && this.d == fVar.d && this.e == fVar.e && this.f == fVar.f && com.smartdigimkt.z0.u.a(this.b, fVar.b) && Arrays.equals(this.g, fVar.g);
    }

    public final int hashCode() {
        int i = (((((((this.c + 527) * 31) + this.d) * 31) + ((int) this.e)) * 31) + ((int) this.f)) * 31;
        String str = this.b;
        return i + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeLong(this.e);
        parcel.writeLong(this.f);
        parcel.writeInt(this.g.length);
        for (o oVar : this.g) {
            parcel.writeParcelable(oVar, 0);
        }
    }

    public f(Parcel parcel) {
        super("CHAP");
        this.b = parcel.readString();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = parcel.readLong();
        this.f = parcel.readLong();
        int i = parcel.readInt();
        this.g = new o[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.g[i2] = (o) parcel.readParcelable(o.class.getClassLoader());
        }
    }
}
