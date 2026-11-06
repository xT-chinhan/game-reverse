package com.smartdigimkt.t0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c implements com.smartdigimkt.q0.b {
    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "SCTE-35 splice command: type=".concat(getClass().getSimpleName());
    }
}
