package com.smartdigimkt.q0;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new a();
    public final b[] a;

    public c(b... bVarArr) {
        this.a = bVarArr;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.a, ((c) obj).a);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.a);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a.length);
        for (b bVar : this.a) {
            parcel.writeParcelable(bVar, 0);
        }
    }

    public c(ArrayList arrayList) {
        b[] bVarArr = new b[arrayList.size()];
        this.a = bVarArr;
        arrayList.toArray(bVarArr);
    }

    public c(Parcel parcel) {
        this.a = new b[parcel.readInt()];
        int i = 0;
        while (true) {
            b[] bVarArr = this.a;
            if (i >= bVarArr.length) {
                return;
            }
            bVarArr[i] = (b) parcel.readParcelable(b.class.getClassLoader());
            i++;
        }
    }
}
