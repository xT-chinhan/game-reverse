package com.smartdigimkt.s0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class o implements com.smartdigimkt.q0.b {
    public final String a;

    public o(String str) {
        str.getClass();
        this.a = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.a;
    }
}
