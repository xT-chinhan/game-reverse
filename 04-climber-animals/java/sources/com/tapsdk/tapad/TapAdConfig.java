package com.tapsdk.tapad;

/* JADX INFO: loaded from: classes3.dex */
public class TapAdConfig {
    public final String aggregationChannel;
    public String data;
    public final String gameChannel;
    public final TapAdCustomController mCustomController;
    public final boolean mIsDebug;
    public final long mMediaId;
    public final String mMediaKey;
    public final String mMediaName;
    public final String mMediaVersion;
    public final String mTapClientId;
    public boolean shakeEnabled;

    public static class Builder {
        private String gameChannel;
        private TapAdCustomController mCustomController;
        private boolean mIsDebug;
        private long mMediaId;
        private String mMediaKey;
        private String mMediaName;
        private String mMediaVersion;
        public String mTapClientId;
        private String aggregationChannel = "";
        private String data = "";
        private boolean shakeEnabled = true;

        public TapAdConfig build() {
            return new TapAdConfig(this);
        }

        public Builder enableDebug(boolean z) {
            this.mIsDebug = z;
            return this;
        }

        public Builder shakeEnabled(boolean z) {
            this.shakeEnabled = z;
            return this;
        }

        public Builder withAggregationChannel(String str) {
            this.aggregationChannel = str;
            return this;
        }

        public Builder withCustomController(TapAdCustomController tapAdCustomController) {
            this.mCustomController = tapAdCustomController;
            return this;
        }

        public Builder withData(String str) {
            this.data = str;
            return this;
        }

        public Builder withGameChannel(String str) {
            this.gameChannel = str;
            return this;
        }

        public Builder withMediaId(long j) {
            this.mMediaId = j;
            return this;
        }

        public Builder withMediaKey(String str) {
            this.mMediaKey = str;
            return this;
        }

        public Builder withMediaName(String str) {
            this.mMediaName = str;
            return this;
        }

        public Builder withMediaVersion(String str) {
            this.mMediaVersion = str;
            return this;
        }

        public Builder withTapClientId(String str) {
            this.mTapClientId = str;
            return this;
        }
    }

    public static class a {
        public static final String a = "tradplus";
        public static final String b = "topon";
        public static final String c = "tobid";
    }

    public TapAdConfig(Builder builder) {
        this.mMediaId = builder.mMediaId;
        this.mMediaName = builder.mMediaName;
        this.mMediaKey = builder.mMediaKey;
        this.mIsDebug = builder.mIsDebug;
        this.mMediaVersion = builder.mMediaVersion;
        this.mTapClientId = builder.mTapClientId;
        this.mCustomController = builder.mCustomController;
        this.gameChannel = builder.gameChannel;
        this.aggregationChannel = builder.aggregationChannel;
        this.data = builder.data;
        this.shakeEnabled = builder.shakeEnabled;
    }
}
