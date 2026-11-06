package com.byazt.gc;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 884, 19})
public class n implements Parcelable {
    public static final Parcelable.Creator<n> CREATOR = new Parcelable.Creator<n>() { // from class: com.byazt.gc.n.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public n createFromParcel(Parcel parcel) {
            return new n(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public n[] newArray(int i) {
            return new n[i];
        }
    };
    public final IBinder n;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public n(Parcel parcel) {
        this.n = parcel.readStrongBinder();
    }

    public n(IBinder iBinder) {
        this.n = iBinder;
    }

    public IBinder n() {
        return this.n;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.n);
    }
}
