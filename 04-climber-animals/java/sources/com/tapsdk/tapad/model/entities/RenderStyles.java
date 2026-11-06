package com.tapsdk.tapad.model.entities;

import android.os.Parcel;
import android.os.Parcelable;
import com.anythink.network.tap.TapATInitManager;

/* JADX INFO: loaded from: classes3.dex */
public class RenderStyles implements Parcelable {
    public static final Parcelable.Creator<RenderStyles> CREATOR = new a();
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    static class a implements Parcelable.Creator<RenderStyles> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public RenderStyles createFromParcel(Parcel parcel) {
            return new RenderStyles(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public RenderStyles[] newArray(int i) {
            return new RenderStyles[i];
        }
    }

    public RenderStyles() {
        this.a = -1;
        this.b = -1;
        this.c = -1;
        this.d = -1;
    }

    protected RenderStyles(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
    }

    public RenderStyles(TapAdResp.z zVar) {
        int iIntValue = ((Integer) com.tapsdk.tapad.internal.j.a.b().a("install_style", Integer.class, -1)).intValue();
        int iIntValue2 = ((Integer) com.tapsdk.tapad.internal.j.a.b().a("ad_space_style", Integer.class, -1)).intValue();
        int iIntValue3 = ((Integer) com.tapsdk.tapad.internal.j.a.b().a(TapATInitManager.ORIENTATION_KEY, Integer.class, -1)).intValue();
        this.a = zVar.h0();
        this.b = iIntValue == -1 ? zVar.H2() : iIntValue;
        if (iIntValue2 != -1) {
            this.c = iIntValue2;
        } else {
            this.c = zVar.o1();
        }
        if (iIntValue3 != -1) {
            this.d = iIntValue3;
        } else {
            this.d = zVar.F0();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
    }
}
