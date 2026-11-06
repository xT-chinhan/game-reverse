package com.smartdigimkt.t0;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends c {
    public static final Parcelable.Creator<m> CREATOR = new j();
    public final List a;

    public m(ArrayList arrayList) {
        this.a = Collections.unmodifiableList(arrayList);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int size = this.a.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            l lVar = (l) this.a.get(i2);
            parcel.writeLong(lVar.a);
            parcel.writeByte(lVar.b ? (byte) 1 : (byte) 0);
            parcel.writeByte(lVar.c ? (byte) 1 : (byte) 0);
            parcel.writeByte(lVar.d ? (byte) 1 : (byte) 0);
            int size2 = lVar.f.size();
            parcel.writeInt(size2);
            for (int i3 = 0; i3 < size2; i3++) {
                k kVar = (k) lVar.f.get(i3);
                parcel.writeInt(kVar.a);
                parcel.writeLong(kVar.b);
            }
            parcel.writeLong(lVar.e);
            parcel.writeByte(lVar.g ? (byte) 1 : (byte) 0);
            parcel.writeLong(lVar.h);
            parcel.writeInt(lVar.i);
            parcel.writeInt(lVar.j);
            parcel.writeInt(lVar.k);
        }
    }

    public m(Parcel parcel) {
        int i = parcel.readInt();
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(new l(parcel));
        }
        this.a = Collections.unmodifiableList(arrayList);
    }
}
