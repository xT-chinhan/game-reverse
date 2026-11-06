package com.tapsdk.tapad;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public class AdRequest implements Parcelable {
    public static final Parcelable.Creator<AdRequest> CREATOR = new a();
    public final int expressViewAcceptedHeight;
    public final int expressViewAcceptedWidth;
    public final String extra1;
    public final String query;
    public final String requestId;
    public final int rewardAmount;
    public final String rewardName;
    public final int spaceId;
    public final String userId;

    public static class Builder {
        private String extra1;
        public String query;
        private int rewardAmount;
        private String rewardName;
        private int spaceId;
        private String userId;
        private int expressViewAcceptedWidth = -1;
        private int expressViewAcceptedHeight = -1;

        public AdRequest build() {
            return new AdRequest(this, null);
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

        public Builder withSpaceId(int i) {
            this.spaceId = i;
            return this;
        }

        public Builder withUserId(String str) {
            this.userId = str;
            return this;
        }
    }

    static class a implements Parcelable.Creator<AdRequest> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdRequest createFromParcel(Parcel parcel) {
            return new AdRequest(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdRequest[] newArray(int i) {
            return new AdRequest[i];
        }
    }

    protected AdRequest(Parcel parcel) {
        this.requestId = parcel.readString();
        this.spaceId = parcel.readInt();
        this.extra1 = parcel.readString();
        this.userId = parcel.readString();
        this.rewardName = parcel.readString();
        this.rewardAmount = parcel.readInt();
        this.query = parcel.readString();
        this.expressViewAcceptedWidth = parcel.readInt();
        this.expressViewAcceptedHeight = parcel.readInt();
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
    }

    /* synthetic */ AdRequest(Builder builder, a aVar) {
        this(builder);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.requestId);
        parcel.writeInt(this.spaceId);
        parcel.writeString(this.extra1);
        parcel.writeString(this.userId);
        parcel.writeString(this.rewardName);
        parcel.writeInt(this.rewardAmount);
        parcel.writeString(this.query);
        parcel.writeInt(this.expressViewAcceptedWidth);
        parcel.writeInt(this.expressViewAcceptedHeight);
    }
}
