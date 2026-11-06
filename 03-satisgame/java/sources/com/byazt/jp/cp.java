package com.byazt.jp;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPEN_TIME, 29})
public abstract class cp {
    public int n;
    public String q;
    public String qg;
    public String s;

    public int n() {
        return this.n;
    }

    public String qg() {
        return this.qg;
    }

    public String s() {
        return this.s;
    }

    public String q() {
        return this.q;
    }

    public String l() {
        switch (n()) {
            case 1:
                return MediationConstant.ADN_PANGLE;
            case 2:
            default:
                return "";
            case 3:
                return MediationConstant.ADN_GDT;
            case 4:
                return MediationConstant.ADN_MINTEGRAL;
            case 5:
                return MediationConstant.ADN_UNITY;
            case 6:
                return "baidu";
            case 7:
                return MediationConstant.ADN_KS;
            case 8:
                return MediationConstant.ADN_SIGMOB;
            case 9:
                return MediationConstant.ADN_KLEVIN;
            case 10:
                return MediationConstant.ADN_XIAOMI;
        }
    }
}
