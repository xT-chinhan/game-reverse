package com.byazt.xfv;

import android.os.Parcel;
import android.os.Parcelable;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_IGNORE_BACKGROUND_RENDERSTALL, 13})
public class hw implements Parcelable {
    public static final Parcelable.Creator<hw> CREATOR = new Parcelable.Creator<hw>() { // from class: com.byazt.xfv.hw.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public hw createFromParcel(Parcel parcel) {
            return new hw(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public hw[] newArray(int i) {
            return new hw[i];
        }
    };
    public String c;
    public String hn;
    public int hw;
    public int pr;
    public String uc;
    public int x;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public hw() {
        this.hn = "";
        this.c = "";
        this.uc = "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.pr);
        parcel.writeInt(this.hw);
        parcel.writeString(this.hn);
        parcel.writeString(this.c);
        parcel.writeString(this.uc);
        parcel.writeInt(this.x);
    }

    public hw(Parcel parcel) {
        this.hn = "";
        this.c = "";
        this.uc = "";
        this.pr = parcel.readInt();
        this.hw = parcel.readInt();
        this.hn = parcel.readString();
        this.c = parcel.readString();
        this.uc = parcel.readString();
        this.x = parcel.readInt();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        hw hwVar = (hw) obj;
        if (this.pr != hwVar.pr || this.hw != hwVar.hw) {
            return false;
        }
        String str = this.hn;
        if (str != null) {
            return str.equals(hwVar.hn);
        }
        if (hwVar.hn == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = ((this.pr * 31) + this.hw) * 31;
        String str = this.hn;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "";
    }
}
