package com.byazt.ww;

import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.byazt.jp.cp;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SAVED_HOST_TIME, 19})
public class n extends qg {
    public com.byazt.ws.n n;
    public cp qg;

    @Override // com.byazt.ww.qg
    public String s() {
        return "";
    }

    public n(com.byazt.ws.n nVar) {
        this.n = nVar;
    }

    public n(cp cpVar) {
        this.qg = cpVar;
    }

    @Override // com.byazt.ww.qg
    public Map<String, Object> n() {
        HashMap map = new HashMap();
        map.put("app_id", l());
        map.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.APP_KEY, w());
        map.put("app_name", com.byazt.qt.n.d().um());
        if ("baidu".equals(qg())) {
            map.put("baidu_https", Boolean.valueOf(com.byazt.qt.n.d().t()));
            if (!TextUtils.isEmpty(com.byazt.qt.n.d().w())) {
                map.put("baidu_wx_app_id", com.byazt.qt.n.d().w());
            }
            Map<String, Object> mapM = com.byazt.qt.n.d().m();
            if (mapM != null) {
                map.put(MediationConstant.GM_EXTRA_KEY_CLOSE_SHAKE, mapM.get(MediationConstant.GM_EXTRA_KEY_CLOSE_SHAKE));
            }
        }
        return map;
    }

    @Override // com.byazt.ww.qg
    public String qg() {
        com.byazt.ws.n nVar = this.n;
        if (nVar != null) {
            return nVar.n();
        }
        cp cpVar = this.qg;
        return cpVar != null ? cpVar.l() : "";
    }

    private String l() {
        com.byazt.ws.n nVar = this.n;
        if (nVar != null) {
            return nVar.qg();
        }
        cp cpVar = this.qg;
        return cpVar != null ? cpVar.s() : "";
    }

    private String w() {
        com.byazt.ws.n nVar = this.n;
        if (nVar != null) {
            return nVar.s();
        }
        cp cpVar = this.qg;
        return cpVar != null ? cpVar.q() : "";
    }
}
