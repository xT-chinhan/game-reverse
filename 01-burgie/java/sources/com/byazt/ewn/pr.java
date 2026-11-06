package com.byazt.ewn;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 160, 37})
public class pr implements Parcelable {
    public static final Parcelable.Creator<pr> CREATOR = new Parcelable.Creator<pr>() { // from class: com.byazt.ewn.pr.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public pr createFromParcel(Parcel parcel) {
            return new pr(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public pr[] newArray(int i) {
            return new pr[i];
        }
    };
    public final IBinder pr;

    public pr(Parcel parcel) {
        this.pr = parcel.readStrongBinder();
    }

    public pr(IBinder iBinder) {
        this.pr = iBinder;
    }

    public IBinder pr() {
        return this.pr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.pr);
    }
}
