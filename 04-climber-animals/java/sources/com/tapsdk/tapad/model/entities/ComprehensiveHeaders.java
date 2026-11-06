package com.tapsdk.tapad.model.entities;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ComprehensiveHeaders implements Parcelable {
    public static final Parcelable.Creator<ComprehensiveHeaders> CREATOR = new a();
    List<DynamicHeader> a = new ArrayList();
    List<DynamicHeader> b = new ArrayList();
    List<DynamicHeader> c = new ArrayList();
    List<DynamicHeader> d = new ArrayList();
    List<DynamicHeader> e = new ArrayList();
    List<DynamicHeader> f = new ArrayList();
    List<DynamicHeader> g = new ArrayList();
    List<DynamicHeader> h = new ArrayList();
    List<DynamicHeader> i = new ArrayList();

    static class a implements Parcelable.Creator<ComprehensiveHeaders> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ComprehensiveHeaders createFromParcel(Parcel parcel) {
            return new ComprehensiveHeaders(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ComprehensiveHeaders[] newArray(int i) {
            return new ComprehensiveHeaders[i];
        }
    }

    public ComprehensiveHeaders(Parcel parcel) {
        parcel.readTypedList(this.a, DynamicHeader.CREATOR);
        parcel.readTypedList(this.b, DynamicHeader.CREATOR);
        parcel.readTypedList(this.c, DynamicHeader.CREATOR);
        parcel.readTypedList(this.d, DynamicHeader.CREATOR);
        parcel.readTypedList(this.e, DynamicHeader.CREATOR);
        parcel.readTypedList(this.f, DynamicHeader.CREATOR);
        parcel.readTypedList(this.g, DynamicHeader.CREATOR);
        parcel.readTypedList(this.h, DynamicHeader.CREATOR);
        parcel.readTypedList(this.i, DynamicHeader.CREATOR);
    }

    public ComprehensiveHeaders(TapAdResp.l lVar) {
        this.a.addAll(a(lVar.p5()));
        this.b.addAll(a(lVar.p4()));
        this.c.addAll(a(lVar.W0()));
        this.d.addAll(a(lVar.K2()));
        this.e.addAll(a(lVar.Z4()));
        this.f.addAll(a(lVar.H1()));
        this.g.addAll(a(lVar.r1()));
        this.h.addAll(a(lVar.I2()));
        this.i.addAll(a(lVar.j4()));
    }

    private List<DynamicHeader> a(List<TapAdResp.n> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(new DynamicHeader(list.get(i)));
            }
        }
        return arrayList;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.a);
        parcel.writeTypedList(this.b);
        parcel.writeTypedList(this.c);
        parcel.writeTypedList(this.d);
        parcel.writeTypedList(this.e);
        parcel.writeTypedList(this.f);
        parcel.writeTypedList(this.g);
        parcel.writeTypedList(this.h);
        parcel.writeTypedList(this.i);
    }
}
