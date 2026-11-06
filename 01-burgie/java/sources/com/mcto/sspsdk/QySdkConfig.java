package com.mcto.sspsdk;

/* JADX INFO: loaded from: classes2.dex */
public class QySdkConfig {
    private String appId;
    private String appName;
    private boolean debug;
    private boolean forceRequestHttps;
    private QyCustomMade mQyCustomMade;
    private String mainProcessName;

    public static final class Builder {
        private String appId;
        private String appName;
        private boolean debug;
        private QyCustomMade mQyCustomMade;
        private String mainProcessName;

        public Builder appId(String str) {
            this.appId = str;
            return this;
        }

        public Builder appName(String str) {
            this.appName = str;
            return this;
        }

        public QySdkConfig build() {
            return new QySdkConfig(this);
        }

        public Builder debug(boolean z) {
            this.debug = z;
            return this;
        }

        public Builder mainProcessName(String str) {
            this.mainProcessName = str;
            return this;
        }

        public Builder qyCustomMade(QyCustomMade qyCustomMade) {
            this.mQyCustomMade = qyCustomMade;
            return this;
        }

        private Builder() {
            this.mainProcessName = null;
        }
    }

    public static Builder newAdConfig() {
        return new Builder();
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getMainProcessName() {
        return this.mainProcessName;
    }

    public QyCustomMade getQyCustomMade() {
        return this.mQyCustomMade;
    }

    public boolean isDebug() {
        return this.debug;
    }

    public boolean isForceRequestHttps() {
        return this.forceRequestHttps;
    }

    public void setForceRequestHttps(boolean z) {
        this.forceRequestHttps = z;
    }

    private QySdkConfig(Builder builder) {
        this.forceRequestHttps = false;
        this.debug = builder.debug;
        this.appId = builder.appId;
        this.appName = builder.appName;
        this.mQyCustomMade = builder.mQyCustomMade;
        this.mainProcessName = builder.mainProcessName;
    }
}
