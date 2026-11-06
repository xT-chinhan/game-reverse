package com.byazt.ln;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.PointerIconCompat;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, PointerIconCompat.TYPE_ZOOM_IN, 19})
public abstract class n implements Parcelable {
    public final Parcelable qg;
    public static final n n = new n() { // from class: com.byazt.ln.n.1
    };
    public static final Parcelable.Creator<n> CREATOR = new Parcelable.ClassLoaderCreator<n>() { // from class: com.byazt.ln.n.2
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public n createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public n createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) != null) {
                throw new IllegalStateException("superState must be null");
            }
            return n.n;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public n[] newArray(int i) {
            return new n[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private n() {
        this.qg = null;
    }

    public n(Parcelable parcelable) {
        if (parcelable == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        this.qg = parcelable == n ? null : parcelable;
    }

    public n(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.qg = parcelable == null ? n : parcelable;
    }

    public final Parcelable n() {
        return this.qg;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.qg, i);
    }
}
