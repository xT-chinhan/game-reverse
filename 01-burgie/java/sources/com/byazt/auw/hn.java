package com.byazt.auw;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_NOTIFY_SEI_IMMEDIATELY_BEFORE_FIRSTFRAME, 20})
public class hn implements Parcelable, Comparable {
    public static final Parcelable.Creator<hn> CREATOR = new Parcelable.Creator<hn>() { // from class: com.byazt.auw.hn.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public hn createFromParcel(Parcel parcel) {
            return new hn(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public hn[] newArray(int i) {
            return new hn[i];
        }
    };
    public final String hw;
    public final String pr;

    public hn(String str, String str2) {
        this.pr = str;
        this.hw = str2;
    }

    public hn(Parcel parcel) {
        this.pr = parcel.readString();
        this.hw = parcel.readString();
    }

    public String pr() {
        return this.pr;
    }

    public String hw() {
        return this.hw;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.pr);
        parcel.writeString(this.hw);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (!(obj instanceof hn)) {
            return 1;
        }
        hn hnVar = (hn) obj;
        if (TextUtils.equals(this.pr, hnVar.pr())) {
            return 0;
        }
        String str = this.pr;
        if (str == null) {
            return -1;
        }
        int iCompareTo = str.compareTo(hnVar.pr());
        if (iCompareTo > 0) {
            return 1;
        }
        return iCompareTo < 0 ? -1 : 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        hn hnVar = (hn) obj;
        if (TextUtils.equals(this.pr, hnVar.pr) && TextUtils.equals(this.hw, hnVar.hw)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.pr;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.hw;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "HttpHeader{name='" + this.pr + "', value='" + this.hw + '\'' + AbstractJsonLexerKt.END_OBJ;
    }
}
