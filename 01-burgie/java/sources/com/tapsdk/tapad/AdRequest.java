package com.tapsdk.tapad;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public final class AdRequest implements Parcelable {
    public static final Parcelable.Creator<AdRequest> CREATOR = new Parcelable.Creator<AdRequest>() { // from class: com.tapsdk.tapad.AdRequest.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AdRequest createFromParcel(Parcel parcel) {
            return new AdRequest(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AdRequest[] newArray(int i) {
            return new AdRequest[i];
        }
    };
    public final int changeAdTimes;
    public final int expressViewAcceptedHeight;
    public final int expressViewAcceptedWidth;
    public final String extra1;
    public final boolean fromChangeAd;
    public final long minaId;
    public final String query;
    public final String requestId;
    public final int rewardAmount;
    public final String rewardName;
    public final long spaceId;
    public final String userId;

    public static final class Builder {
        private String extra1;
        private String query;
        private int rewardAmount;
        private String rewardName;
        private long spaceId;
        private String userId;
        private int expressViewAcceptedWidth = -1;
        private int expressViewAcceptedHeight = -1;
        private boolean fromChangeAd = false;
        private int changeAdTimes = 0;
        private long minaId = 0;

        public AdRequest build() {
            return new AdRequest(this);
        }

        public Builder withChangeAdTimes(int i) {
            this.changeAdTimes = i;
            return this;
        }

        public Builder withExpressViewAcceptedSize(int i, int i2) {
            this.expressViewAcceptedWidth = i;
            this.expressViewAcceptedHeight = i2;
            return this;
        }

        public Builder withExtra1(String str) {
            this.extra1 = str;
            return this;
        }

        public Builder withFromChangeAd(boolean z) {
            this.fromChangeAd = z;
            return this;
        }

        public Builder withMinaId(long j) {
            this.minaId = j;
            return this;
        }

        public Builder withQuery(String str) {
            this.query = str;
            return this;
        }

        public Builder withRewardAmount(int i) {
            this.rewardAmount = i;
            return this;
        }

        public Builder withRewardName(String str) {
            this.rewardName = str;
            return this;
        }

        public Builder withSpaceId(long j) {
            this.spaceId = j;
            return this;
        }

        public Builder withUserId(String str) {
            this.userId = str;
            return this;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final AdRequest snapshotForLoadAttempt() {
        return new AdRequest(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.requestId);
        parcel.writeLong(this.spaceId);
        parcel.writeString(this.extra1);
        parcel.writeString(this.userId);
        parcel.writeString(this.rewardName);
        parcel.writeInt(this.rewardAmount);
        parcel.writeString(this.query);
        parcel.writeInt(this.expressViewAcceptedWidth);
        parcel.writeInt(this.expressViewAcceptedHeight);
        parcel.writeByte(this.fromChangeAd ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.changeAdTimes);
        parcel.writeLong(this.minaId);
    }

    private AdRequest(Builder builder) {
        this.requestId = UUID.randomUUID().toString();
        this.spaceId = builder.spaceId;
        this.extra1 = builder.extra1;
        this.userId = builder.userId;
        this.rewardName = builder.rewardName;
        this.rewardAmount = builder.rewardAmount;
        this.query = builder.query;
        this.expressViewAcceptedWidth = builder.expressViewAcceptedWidth;
        this.expressViewAcceptedHeight = builder.expressViewAcceptedHeight;
        this.fromChangeAd = builder.fromChangeAd;
        this.changeAdTimes = builder.changeAdTimes;
        this.minaId = builder.minaId;
    }

    private AdRequest(AdRequest adRequest) {
        this.requestId = UUID.randomUUID().toString();
        this.spaceId = adRequest.spaceId;
        this.extra1 = adRequest.extra1;
        this.userId = adRequest.userId;
        this.rewardName = adRequest.rewardName;
        this.rewardAmount = adRequest.rewardAmount;
        this.query = adRequest.query;
        this.expressViewAcceptedWidth = adRequest.expressViewAcceptedWidth;
        this.expressViewAcceptedHeight = adRequest.expressViewAcceptedHeight;
        this.fromChangeAd = adRequest.fromChangeAd;
        this.changeAdTimes = adRequest.changeAdTimes;
        this.minaId = adRequest.minaId;
    }

    private AdRequest(Parcel parcel) {
        this.requestId = parcel.readString();
        this.spaceId = parcel.readLong();
        this.extra1 = parcel.readString();
        this.userId = parcel.readString();
        this.rewardName = parcel.readString();
        this.rewardAmount = parcel.readInt();
        this.query = parcel.readString();
        this.expressViewAcceptedWidth = parcel.readInt();
        this.expressViewAcceptedHeight = parcel.readInt();
        this.fromChangeAd = parcel.readByte() == 1;
        this.changeAdTimes = parcel.readInt();
        this.minaId = parcel.readLong();
    }
}
