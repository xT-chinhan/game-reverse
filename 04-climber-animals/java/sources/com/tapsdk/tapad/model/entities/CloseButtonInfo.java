package com.tapsdk.tapad.model.entities;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class CloseButtonInfo implements Parcelable {
    public static final Parcelable.Creator<CloseButtonInfo> CREATOR = new a();
    public final int a;

    static class a implements Parcelable.Creator<CloseButtonInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CloseButtonInfo createFromParcel(Parcel parcel) {
            return new CloseButtonInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CloseButtonInfo[] newArray(int i) {
            return new CloseButtonInfo[i];
        }
    }

    public CloseButtonInfo(int i) {
        this.a = i;
    }

    protected CloseButtonInfo(Parcel parcel) {
        this.a = parcel.readInt();
    }

    public CloseButtonInfo(TapAdResp.j jVar) {
        this.a = jVar.l0();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
    }
}
