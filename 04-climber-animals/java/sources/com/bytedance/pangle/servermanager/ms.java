package com.bytedance.pangle.servermanager;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements Parcelable {
    public static final Parcelable.Creator<ms> CREATOR = new Parcelable.Creator<ms>() { // from class: com.bytedance.pangle.servermanager.ms.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
        public ms createFromParcel(Parcel parcel) {
            return new ms(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
        public ms[] newArray(int i) {
            return new ms[i];
        }
    };

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final IBinder f682ms;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    ms(Parcel parcel) {
        this.f682ms = parcel.readStrongBinder();
    }

    ms(IBinder iBinder) {
        this.f682ms = iBinder;
    }

    public IBinder ms() {
        return this.f682ms;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.f682ms);
    }
}
