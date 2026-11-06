package com.bytedance.adsdk.ugeno.viewpager;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms implements Parcelable {
    private final Parcelable xr;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final ms f402ms = new ms() { // from class: com.bytedance.adsdk.ugeno.viewpager.ms.1
    };
    public static final Parcelable.Creator<ms> CREATOR = new Parcelable.ClassLoaderCreator<ms>() { // from class: com.bytedance.adsdk.ugeno.viewpager.ms.2
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
        public ms createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
        public ms createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) != null) {
                throw new IllegalStateException("superState must be null");
            }
            return ms.f402ms;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
        public ms[] newArray(int i) {
            return new ms[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private ms() {
        this.xr = null;
    }

    protected ms(Parcelable parcelable) {
        if (parcelable == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        this.xr = parcelable == f402ms ? null : parcelable;
    }

    protected ms(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.xr = parcelable == null ? f402ms : parcelable;
    }

    public final Parcelable ms() {
        return this.xr;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.xr, i);
    }
}
