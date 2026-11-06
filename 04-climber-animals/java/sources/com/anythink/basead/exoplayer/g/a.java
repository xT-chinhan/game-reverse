package com.anythink.basead.exoplayer.g;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: com.anythink.basead.exoplayer.g.a.1
        private static a[] a() {
            return new a[0];
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ a[] newArray(int i) {
            return new a[0];
        }

        private static a a(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }
    };
    private final InterfaceC0027a[] a;

    /* JADX INFO: renamed from: com.anythink.basead.exoplayer.g.a$a, reason: collision with other inner class name */
    public interface InterfaceC0027a extends Parcelable {
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public a(InterfaceC0027a... interfaceC0027aArr) {
        this.a = interfaceC0027aArr;
    }

    public a(List<? extends InterfaceC0027a> list) {
        InterfaceC0027a[] interfaceC0027aArr = new InterfaceC0027a[list.size()];
        this.a = interfaceC0027aArr;
        list.toArray(interfaceC0027aArr);
    }

    a(Parcel parcel) {
        this.a = new InterfaceC0027a[parcel.readInt()];
        int i = 0;
        while (true) {
            InterfaceC0027a[] interfaceC0027aArr = this.a;
            if (i >= interfaceC0027aArr.length) {
                return;
            }
            interfaceC0027aArr[i] = (InterfaceC0027a) parcel.readParcelable(InterfaceC0027a.class.getClassLoader());
            i++;
        }
    }

    public final int a() {
        return this.a.length;
    }

    public final InterfaceC0027a a(int i) {
        return this.a[i];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.a, ((a) obj).a);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.a);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a.length);
        for (InterfaceC0027a interfaceC0027a : this.a) {
            parcel.writeParcelable(interfaceC0027a, 0);
        }
    }
}
