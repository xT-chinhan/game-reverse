package com.tapsdk.tapad.feed;

/* JADX INFO: loaded from: classes3.dex */
public class VideoOption {
    protected AutoPlayPolicy autoPlayPolicy;

    public enum AutoPlayPolicy {
        ALWAYS,
        WIFI
    }

    public static class Builder {
        private AutoPlayPolicy autoPlayPolicy = AutoPlayPolicy.ALWAYS;

        public Builder autoPlayPolicy(AutoPlayPolicy autoPlayPolicy) {
            this.autoPlayPolicy = autoPlayPolicy;
            return this;
        }

        public VideoOption build() {
            VideoOption videoOption = new VideoOption();
            videoOption.autoPlayPolicy = this.autoPlayPolicy;
            return videoOption;
        }
    }

    private VideoOption() {
        this.autoPlayPolicy = AutoPlayPolicy.ALWAYS;
    }
}
