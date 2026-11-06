package com.anythink.network.toutiao;

import com.anythink.core.api.ATCustomVideo;
import com.bytedance.sdk.openadsdk.TTFeedAd;

/* JADX INFO: loaded from: classes.dex */
public class TTATCustomVideo implements ATCustomVideo {
    TTFeedAd.CustomizeVideo a;

    public TTATCustomVideo(TTFeedAd.CustomizeVideo customizeVideo) {
        this.a = customizeVideo;
    }

    @Override // com.anythink.core.api.ATCustomVideo
    public String getVideoUrl() {
        TTFeedAd.CustomizeVideo customizeVideo = this.a;
        if (customizeVideo != null) {
            return customizeVideo.getVideoUrl();
        }
        return null;
    }

    @Override // com.anythink.core.api.ATCustomVideo
    public void reportVideoStart() {
        TTFeedAd.CustomizeVideo customizeVideo = this.a;
        if (customizeVideo != null) {
            customizeVideo.reportVideoStart();
        }
    }

    @Override // com.anythink.core.api.ATCustomVideo
    public void reportVideoPause(long j) {
        TTFeedAd.CustomizeVideo customizeVideo = this.a;
        if (customizeVideo != null) {
            customizeVideo.reportVideoPause(j);
        }
    }

    @Override // com.anythink.core.api.ATCustomVideo
    public void reportVideoContinue(long j) {
        TTFeedAd.CustomizeVideo customizeVideo = this.a;
        if (customizeVideo != null) {
            customizeVideo.reportVideoContinue(j);
        }
    }

    @Override // com.anythink.core.api.ATCustomVideo
    public void reportVideoFinish() {
        TTFeedAd.CustomizeVideo customizeVideo = this.a;
        if (customizeVideo != null) {
            customizeVideo.reportVideoFinish();
        }
    }

    @Override // com.anythink.core.api.ATCustomVideo
    public void reportVideoBreak(long j) {
        TTFeedAd.CustomizeVideo customizeVideo = this.a;
        if (customizeVideo != null) {
            customizeVideo.reportVideoBreak(j);
        }
    }

    @Override // com.anythink.core.api.ATCustomVideo
    public void reportVideoAutoStart() {
        TTFeedAd.CustomizeVideo customizeVideo = this.a;
        if (customizeVideo != null) {
            customizeVideo.reportVideoAutoStart();
        }
    }

    @Override // com.anythink.core.api.ATCustomVideo
    public void reportVideoStartError(int i, int i2) {
        TTFeedAd.CustomizeVideo customizeVideo = this.a;
        if (customizeVideo != null) {
            customizeVideo.reportVideoStartError(i, i2);
        }
    }

    @Override // com.anythink.core.api.ATCustomVideo
    public void reportVideoError(long j, int i, int i2) {
        TTFeedAd.CustomizeVideo customizeVideo = this.a;
        if (customizeVideo != null) {
            customizeVideo.reportVideoError(j, i, i2);
        }
    }
}
