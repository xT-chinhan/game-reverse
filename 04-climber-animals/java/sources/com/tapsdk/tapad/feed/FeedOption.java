package com.tapsdk.tapad.feed;

/* JADX INFO: loaded from: classes3.dex */
public class FeedOption {
    protected int expressHeight;
    protected int expressWidth;
    protected VideoOption videoOption;

    public static class Builder {
        private int expressWidth = -1;
        private int expressHeight = -2;
        private VideoOption videoOption = new VideoOption.Builder().build();

        public FeedOption build() {
            FeedOption feedOption = new FeedOption();
            feedOption.expressWidth = this.expressWidth;
            feedOption.expressHeight = this.expressHeight;
            feedOption.videoOption = this.videoOption;
            return feedOption;
        }

        public Builder expressHeight(int i) {
            this.expressHeight = i;
            return this;
        }

        public Builder expressWidth(int i) {
            this.expressWidth = i;
            return this;
        }

        public Builder videoOption(VideoOption videoOption) {
            this.videoOption = videoOption;
            return this;
        }
    }

    private FeedOption() {
        this.expressWidth = -1;
        this.expressHeight = -2;
        this.videoOption = new VideoOption.Builder().build();
    }
}
