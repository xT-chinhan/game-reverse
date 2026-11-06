package com.tapsdk.tapad.model.entities;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class WxMiniProgramInfo implements Parcelable {
    public static final Parcelable.Creator<WxMiniProgramInfo> CREATOR = new a();
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    static class a implements Parcelable.Creator<WxMiniProgramInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public WxMiniProgramInfo createFromParcel(Parcel parcel) {
            return new WxMiniProgramInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public WxMiniProgramInfo[] newArray(int i) {
            return new WxMiniProgramInfo[i];
        }
    }

    protected WxMiniProgramInfo(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
    }

    public WxMiniProgramInfo(TapAdResp.j0 j0Var) {
        this.a = j0Var.f0();
        this.b = j0Var.U1();
        this.c = j0Var.M3();
        this.d = j0Var.c();
    }

    public WxMiniProgramInfo(String str, String str2, String str3, String str4) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
    }
}
