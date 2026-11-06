package com.tapsdk.tapad.group;

/* JADX INFO: loaded from: classes2.dex */
public final class DirichletAdConfig {
    public final String data;
    public final String gameChannel;
    public final DirichletAdCustomController mCustomController;
    public final boolean mIsDebug;
    public final long mMediaId;
    public final String mMediaKey;
    public final String mMediaName;
    public final String mTapClientId;
    public final boolean shakeEnabled;

    public static final class Builder {
        private long mMediaId = -1;
        private String mMediaName = "";
        private String mMediaKey = "";
        private boolean mIsDebug = false;
        private String mTapClientId = "";
        private DirichletAdCustomController mCustomController = new DirichletAdCustomController() { // from class: com.tapsdk.tapad.group.DirichletAdConfig.Builder.1
        };
        private String gameChannel = "";
        private String data = "";
        private boolean shakeEnabled = true;

        public DirichletAdConfig build() {
            return new DirichletAdConfig(this);
        }

        public Builder enableDebug(boolean z) {
            this.mIsDebug = z;
            return this;
        }

        public Builder shakeEnabled(boolean z) {
            this.shakeEnabled = z;
            return this;
        }

        public Builder withCustomController(DirichletAdCustomController dirichletAdCustomController) {
            if (dirichletAdCustomController != null) {
                this.mCustomController = dirichletAdCustomController;
            }
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

        public Builder withTapClientId(String str) {
            this.mTapClientId = str;
            return this;
        }
    }

    private DirichletAdConfig(Builder builder) {
        this.mMediaId = builder.mMediaId;
        this.mMediaName = builder.mMediaName;
        this.mMediaKey = builder.mMediaKey;
        this.mIsDebug = builder.mIsDebug;
        this.mTapClientId = builder.mTapClientId;
        this.mCustomController = builder.mCustomController;
        this.gameChannel = builder.gameChannel;
        this.data = builder.data;
        this.shakeEnabled = builder.shakeEnabled;
    }
}
