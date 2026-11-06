package com.tapsdk.tapad.group;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public final class DirichletAdRequest implements Parcelable {
    public static final Parcelable.Creator<DirichletAdRequest> CREATOR = new Parcelable.Creator<DirichletAdRequest>() { // from class: com.tapsdk.tapad.group.DirichletAdRequest.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DirichletAdRequest createFromParcel(Parcel parcel) {
            return new DirichletAdRequest(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DirichletAdRequest[] newArray(int i) {
            return new DirichletAdRequest[i];
        }
    };
    public final int expressImageAcceptedHeight;
    public final int expressImageAcceptedWidth;
    public final int expressViewAcceptedHeight;
    public final int expressViewAcceptedWidth;
    public final String extra1;
    public final long minaId;
    public final String query;
    public final int rewardAmount;
    public final String rewardName;
    public final int slideInternal;
    public final long spaceId;
    public final String userId;

    public static final class Builder {
        private String extra1;
        private long minaId;
        private String query;
        private int rewardAmount;
        private String rewardName;
        private long spaceId;
        private String userId;
        private int expressViewAcceptedWidth = -1;
        private int expressViewAcceptedHeight = -1;
        private int expressImageAcceptedWidth = -1;
        private int expressImageAcceptedHeight = -1;
        private int slideInternal = 30;

        public DirichletAdRequest build() {
            return new DirichletAdRequest(this);
        }

        public Builder withExpressImageAcceptedSize(int i, int i2) {
            this.expressImageAcceptedWidth = i;
            this.expressImageAcceptedHeight = i2;
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

        public Builder withSlideInternal(int i) {
            this.slideInternal = i;
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

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.spaceId);
        parcel.writeString(this.extra1);
        parcel.writeString(this.userId);
        parcel.writeString(this.rewardName);
        parcel.writeInt(this.rewardAmount);
        parcel.writeString(this.query);
        parcel.writeInt(this.expressViewAcceptedWidth);
        parcel.writeInt(this.expressViewAcceptedHeight);
        parcel.writeInt(this.expressImageAcceptedWidth);
        parcel.writeInt(this.expressImageAcceptedHeight);
        parcel.writeLong(this.minaId);
        parcel.writeInt(this.slideInternal);
    }

    private DirichletAdRequest(Builder builder) {
        this.spaceId = builder.spaceId;
        this.extra1 = builder.extra1;
        this.userId = builder.userId;
        this.rewardName = builder.rewardName;
        this.rewardAmount = builder.rewardAmount;
        this.query = builder.query;
        this.expressViewAcceptedWidth = builder.expressViewAcceptedWidth;
        this.expressViewAcceptedHeight = builder.expressViewAcceptedHeight;
        this.expressImageAcceptedWidth = builder.expressImageAcceptedWidth;
        this.expressImageAcceptedHeight = builder.expressImageAcceptedHeight;
        this.minaId = builder.minaId;
        this.slideInternal = builder.slideInternal;
    }

    private DirichletAdRequest(Parcel parcel) {
        this.spaceId = parcel.readLong();
        this.extra1 = parcel.readString();
        this.userId = parcel.readString();
        this.rewardName = parcel.readString();
        this.rewardAmount = parcel.readInt();
        this.query = parcel.readString();
        this.expressViewAcceptedWidth = parcel.readInt();
        this.expressViewAcceptedHeight = parcel.readInt();
        this.expressImageAcceptedWidth = parcel.readInt();
        this.expressImageAcceptedHeight = parcel.readInt();
        this.minaId = parcel.readLong();
        this.slideInternal = parcel.readInt();
    }
}
