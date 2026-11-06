package com.bytedance.sdk.openadsdk.mediation.ad;

import com.byazt.vzx.pr;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@pr(pr = {0, 78, 79, 80, 81, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TOTAL_CACHED_LEN, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_TOTAL_CACHED_LEN})
public abstract class MediationSplashRequestInfo implements IMediationSplashRequestInfo {
    private String hn;
    private String hw;
    private String pr;
    private String x;

    public MediationSplashRequestInfo(String str, String str2, String str3, String str4) {
        this.pr = str;
        this.hw = str2;
        this.hn = str3;
        this.x = str4;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo
    public String getAdnName() {
        return this.pr;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo
    public String getAdnSlotId() {
        return this.hw;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo
    public String getAppId() {
        return this.hn;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo
    public String getAppkey() {
        return this.x;
    }
}
