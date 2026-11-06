package com.byazt.ss;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.android.live.base.api.push.ILivePush;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1334, 19})
public abstract class n {
    public static final HashSet<String> n = new HashSet<>(Arrays.asList("convert", com.byazt.wg.qg.AD_TAG_DISLIKE, "openAppPermission", "openAppPolicy", "openPrivacy", "openAppFunction", ILivePush.ClickType.CLOSE, "skip", "videoControl", "pauseVideo", "resumeVideo", "muteVideo", "preventEvent"));
    public String fs;
    public String l;
    public String q;
    public com.byazt.xz.x.n qg;
    public com.byazt.ih.s s;
    public Map<String, Object> w;
    public String x;

    public abstract void n();

    public n(com.byazt.ih.s sVar, String str, com.byazt.xz.x.n nVar) {
        this.s = sVar;
        this.qg = nVar;
        this.x = str;
        l();
    }

    private void l() {
        com.byazt.xz.x.n nVar = this.qg;
        if (nVar == null) {
            return;
        }
        this.q = nVar.n();
        this.l = this.qg.qg();
        Map<String, Object> mapS = this.qg.s();
        this.w = mapS;
        if (mapS == null || mapS.isEmpty() || !this.w.containsKey("emitCustomEvent") || !(this.w.get("emitCustomEvent") instanceof String)) {
            return;
        }
        this.fs = (String) this.w.get("emitCustomEvent");
    }

    public void qg() {
        s();
    }

    public void s() {
        if (q()) {
            com.byazt.xz.x.n nVar = new com.byazt.xz.x.n();
            nVar.n("custom");
            nVar.qg("emit");
            HashMap map = new HashMap();
            map.put(TapEventParamConstants.PARAM_NAME, this.fs);
            nVar.n(map);
            new qg(this.s, this.l, nVar).n();
        }
    }

    public boolean q() {
        return !TextUtils.isEmpty(this.fs);
    }

    /* JADX INFO: renamed from: com.byazt.ss.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 1334, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    public static class C0336n {
        public static n n(com.byazt.ih.s sVar, String str, com.byazt.xz.x.n nVar) {
            if (nVar == null) {
                return null;
            }
            com.byazt.xz.qg qgVarN = com.byazt.xz.q.n(nVar.qg());
            if (qgVarN == null && (TextUtils.isEmpty(nVar.n()) || !TextUtils.equals(nVar.n(), "global"))) {
                qgVarN = com.byazt.xz.q.n(nVar.w());
            }
            if (qgVarN == null) {
                return new l(sVar, str, nVar);
            }
            n nVarN = qgVarN.n(sVar, str, nVar);
            return nVarN == null ? new l(sVar, str, nVar) : nVarN;
        }
    }
}
