package com.tapsdk.tapad.model.entities;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DynamicHeader implements Parcelable {
    public static final Parcelable.Creator<DynamicHeader> CREATOR = new a();
    public final String a;
    public List<String> b;
    public final int c;

    static class a implements Parcelable.Creator<DynamicHeader> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DynamicHeader createFromParcel(Parcel parcel) {
            return new DynamicHeader(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DynamicHeader[] newArray(int i) {
            return new DynamicHeader[i];
        }
    }

    protected DynamicHeader(Parcel parcel) {
        this.b = new ArrayList();
        this.a = parcel.readString();
        this.b = parcel.createStringArrayList();
        this.c = parcel.readInt();
    }

    public DynamicHeader(TapAdResp.n nVar) {
        this.b = new ArrayList();
        this.a = nVar.l();
        this.b.addAll(nVar.N1());
        this.c = nVar.j5();
    }

    public DynamicHeader(String str, List<String> list, int i) {
        new ArrayList();
        this.a = str;
        this.b = list;
        this.c = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "name:" + this.a + "\nvalue:" + this.b + "\nmode:" + this.c + "\n";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeStringList(this.b);
        parcel.writeInt(this.c);
    }
}
