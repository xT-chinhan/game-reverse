package com.byazt.wm;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_NO_AV_SYNC, 8})
public class s implements Parcelable, Comparable {
    public static final Parcelable.Creator<s> CREATOR = new Parcelable.Creator<s>() { // from class: com.byazt.wm.s.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public s createFromParcel(Parcel parcel) {
            return new s(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public s[] newArray(int i) {
            return new s[i];
        }
    };
    public final String n;
    public final String qg;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public s(String str, String str2) {
        this.n = str;
        this.qg = str2;
    }

    public s(Parcel parcel) {
        this.n = parcel.readString();
        this.qg = parcel.readString();
    }

    public String n() {
        return this.n;
    }

    public String qg() {
        return this.qg;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.n);
        parcel.writeString(this.qg);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (!(obj instanceof s)) {
            return 1;
        }
        s sVar = (s) obj;
        if (TextUtils.equals(this.n, sVar.n())) {
            return 0;
        }
        String str = this.n;
        if (str == null) {
            return -1;
        }
        int iCompareTo = str.compareTo(sVar.n());
        if (iCompareTo > 0) {
            return 1;
        }
        return iCompareTo < 0 ? -1 : 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            s sVar = (s) obj;
            if (TextUtils.equals(this.n, sVar.n) && TextUtils.equals(this.qg, sVar.qg)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.n;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.qg;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "HttpHeader{name='" + this.n + "', value='" + this.qg + "'}";
    }
}
