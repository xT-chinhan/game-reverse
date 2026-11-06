package com.byazt.cqf;

import android.os.Parcel;
import android.os.Parcelable;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_POSITION_UPDATE_INTERVAL, 37})
public abstract class pr implements Parcelable {
    public final Parcelable hw;
    public static final pr pr = new pr() { // from class: com.byazt.cqf.pr.1
    };
    public static final Parcelable.Creator<pr> CREATOR = new Parcelable.ClassLoaderCreator<pr>() { // from class: com.byazt.cqf.pr.2
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public pr createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public pr createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) != null) {
                throw new IllegalStateException("superState must be null");
            }
            return pr.pr;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public pr[] newArray(int i) {
            return new pr[i];
        }
    };

    private pr() {
        this.hw = null;
    }

    public pr(Parcelable parcelable) {
        if (parcelable == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        this.hw = parcelable == pr ? null : parcelable;
    }

    public pr(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.hw = parcelable == null ? pr : parcelable;
    }

    public final Parcelable pr() {
        return this.hw;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.hw, i);
    }
}
