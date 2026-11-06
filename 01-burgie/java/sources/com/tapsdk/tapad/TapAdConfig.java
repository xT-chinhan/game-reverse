package com.tapsdk.tapad;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes2.dex */
public final class TapAdConfig {
    public final String aggregationChannel;
    public final String data;
    public final String gameChannel;
    public final TapAdCustomController mCustomController;
    public final boolean mIsDebug;
    public final long mMediaId;
    public final String mMediaKey;
    public final String mMediaName;
    public final String mMediaVersion;
    public final String mTapClientId;
    public final boolean shakeEnabled;
    public final Bitmap splashLogoBitmap;

    public static final class AggregationChannel {
        public static final String DIRICHLET = "dirichlet";
        public static final String TOBID = "tobid";
        public static final String TOPON = "topon";
        public static final String TRADPLUS = "tradplus";

        private AggregationChannel() {
        }
    }

    public static final class Builder {
        private String gameChannel;
        private TapAdCustomController mCustomController;
        private boolean mIsDebug;
        private long mMediaId;
        private String mMediaKey;
        private String mMediaName;
        private String mMediaVersion;
        private String mTapClientId;
        private Bitmap splashLogoBitmap;
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

        public Builder withSplashLogoBitmap(Bitmap bitmap) {
            this.splashLogoBitmap = bitmap;
            return this;
        }

        public Builder withTapClientId(String str) {
            this.mTapClientId = str;
            return this;
        }
    }

    private TapAdConfig(Builder builder) {
        this.mMediaId = builder.mMediaId;
        this.mMediaName = builder.mMediaName;
        this.mMediaKey = builder.mMediaKey;
        this.mIsDebug = builder.mIsDebug;
        this.mMediaVersion = builder.mMediaVersion;
        this.mTapClientId = builder.mTapClientId;
        if (builder.mCustomController != null) {
            this.mCustomController = builder.mCustomController;
        } else {
            this.mCustomController = new TapAdCustomController() { // from class: com.tapsdk.tapad.TapAdConfig.1
            };
        }
        this.gameChannel = builder.gameChannel;
        this.aggregationChannel = builder.aggregationChannel;
        this.data = builder.data;
        this.shakeEnabled = builder.shakeEnabled;
        this.splashLogoBitmap = builder.splashLogoBitmap;
    }
}
