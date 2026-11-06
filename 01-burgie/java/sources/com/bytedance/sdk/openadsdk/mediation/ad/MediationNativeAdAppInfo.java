package com.bytedance.sdk.openadsdk.mediation.ad;

import com.byazt.vzx.pr;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@pr(pr = {0, 78, 79, 80, 81, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TOTAL_CACHED_LEN, 1785})
public class MediationNativeAdAppInfo {
    private Map<String, Object> aj;
    private Map<String, String> c;
    private String fw;
    private long hn;
    private String hw;
    private String pr;
    private String uc;
    private String vk;
    private String x;
    private String zo;

    public String getAppName() {
        return this.pr;
    }

    public void setAppName(String str) {
        this.pr = str;
    }

    public String getAuthorName() {
        return this.hw;
    }

    public void setAuthorName(String str) {
        this.hw = str;
    }

    public long getPackageSizeBytes() {
        return this.hn;
    }

    public void setPackageSizeBytes(long j) {
        this.hn = j;
    }

    public String getPermissionsUrl() {
        return this.x;
    }

    public void setPermissionsUrl(String str) {
        this.x = str;
    }

    public Map<String, String> getPermissionsMap() {
        return this.c;
    }

    public void setPermissionsMap(Map<String, String> map) {
        this.c = map;
    }

    public String getPrivacyAgreement() {
        return this.uc;
    }

    public void setPrivacyAgreement(String str) {
        this.uc = str;
    }

    public String getVersionName() {
        return this.fw;
    }

    public void setVersionName(String str) {
        this.fw = str;
    }

    public String getFunctionDescUrl() {
        return this.zo;
    }

    public void setFunctionDescUrl(String str) {
        this.zo = str;
    }

    public Map<String, Object> getAppInfoExtra() {
        return this.aj;
    }

    public void setAppInfoExtra(Map<String, Object> map) {
        this.aj = map;
    }

    public String getRegUrl() {
        return this.vk;
    }

    public void setRegUrl(String str) {
        this.vk = str;
    }
}
