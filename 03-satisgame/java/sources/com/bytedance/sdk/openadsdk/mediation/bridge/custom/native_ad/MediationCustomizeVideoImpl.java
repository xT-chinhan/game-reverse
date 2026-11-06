package com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad;

import android.util.SparseArray;
import com.byazt.cp.n;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 55, 56, 57, 58, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FFMPEG_LOG_LEVEL, MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS, 1656, 1665})
public class MediationCustomizeVideoImpl extends com.byazt.ku.n implements IMediationCustomizeVideo {
    private TTFeedAd.CustomizeVideo n;

    @Override // com.byazt.ku.n
    public SparseArray<Object> get() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public String getVideoUrl() {
        return null;
    }

    public MediationCustomizeVideoImpl(TTFeedAd.CustomizeVideo customizeVideo) {
        this.n = customizeVideo;
    }

    @Override // com.byazt.ku.n
    public <T> T applyFunction(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 8165) {
            reportVideoStart();
            return null;
        }
        if (i == 8168) {
            reportVideoFinish();
            return null;
        }
        if (i == 8166) {
            reportVideoPause(valueSet.longValue(8074));
            return null;
        }
        if (i == 8167) {
            reportVideoContinue(valueSet.longValue(8074));
            return null;
        }
        if (i == 8169) {
            reportVideoBreak(valueSet.longValue(8074));
            return null;
        }
        if (i == 8170) {
            reportVideoAutoStart();
            return null;
        }
        if (i == 8171) {
            reportVideoStartError(valueSet.intValue(8014), valueSet.intValue(8075));
            return null;
        }
        if (i != 8172) {
            return null;
        }
        reportVideoError(valueSet.longValue(8074), valueSet.intValue(8014), valueSet.intValue(8075));
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoStart() {
        TTFeedAd.CustomizeVideo customizeVideo = this.n;
        if (customizeVideo != null) {
            customizeVideo.reportVideoStart();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoPause(long j) {
        TTFeedAd.CustomizeVideo customizeVideo = this.n;
        if (customizeVideo != null) {
            customizeVideo.reportVideoPause(j);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoContinue(long j) {
        TTFeedAd.CustomizeVideo customizeVideo = this.n;
        if (customizeVideo != null) {
            customizeVideo.reportVideoContinue(j);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoFinish() {
        TTFeedAd.CustomizeVideo customizeVideo = this.n;
        if (customizeVideo != null) {
            customizeVideo.reportVideoFinish();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoBreak(long j) {
        TTFeedAd.CustomizeVideo customizeVideo = this.n;
        if (customizeVideo != null) {
            customizeVideo.reportVideoBreak(j);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoAutoStart() {
        TTFeedAd.CustomizeVideo customizeVideo = this.n;
        if (customizeVideo != null) {
            customizeVideo.reportVideoAutoStart();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoStartError(int i, int i2) {
        TTFeedAd.CustomizeVideo customizeVideo = this.n;
        if (customizeVideo != null) {
            customizeVideo.reportVideoStartError(i, i2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoError(long j, int i, int i2) {
        TTFeedAd.CustomizeVideo customizeVideo = this.n;
        if (customizeVideo != null) {
            customizeVideo.reportVideoError(j, i, i2);
        }
    }
}
