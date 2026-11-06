package com.byazt.xv;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.dd.k;
import com.byazt.dd.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 793, 13})
public abstract class hw {
    public String aj;
    public Map<String, Object> c;
    public String fw;
    public com.byazt.dd.fw hn;
    public com.byazt.ik.hn hw;
    public k pr;
    public String uc;
    public Context vk;
    public com.byazt.dd.fw.pr x;
    public String zo;

    public abstract boolean pr(Object... objArr);

    public hw(Context context) {
        this.vk = context;
    }

    public void uc() {
        this.x = this.hn.pr();
        com.byazt.dd.fw fwVar = this.hn;
        if (fwVar == null) {
            return;
        }
        com.byazt.dd.fw.pr prVarPr = fwVar.pr();
        this.x = prVarPr;
        if (prVarPr == null) {
            return;
        }
        this.c = prVarPr.hn();
        this.uc = this.x.hw();
        this.fw = this.x.pr();
        this.zo = this.x.x();
        this.aj = this.x.c();
    }

    public String fw() {
        return this.uc;
    }

    public Map<String, Object> zo() {
        return this.c;
    }

    public String aj() {
        return this.zo;
    }

    public String vk() {
        return this.aj;
    }

    public void pr(com.byazt.ik.hn hnVar) {
        this.hw = hnVar;
    }

    public void pr(com.byazt.dd.fw fwVar) {
        this.hn = fwVar;
    }

    public com.byazt.dd.fw w() {
        return this.hn;
    }

    public void pr(k kVar) {
        this.pr = kVar;
    }

    @com.byazt.vzx.pr(pr = {0, 1, 793, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    public static class pr {
        public static hw pr(Context context, com.byazt.ik.hn hnVar, JSONObject jSONObject, JSONObject jSONObject2) {
            com.byazt.dd.fw fwVarPr;
            com.byazt.dd.fw.pr prVarPr;
            com.byazt.dd.zo zoVarPr;
            if (hnVar == null || jSONObject == null || (fwVarPr = com.byazt.dd.fw.pr(jSONObject, jSONObject2)) == null || (prVarPr = fwVarPr.pr()) == null) {
                return null;
            }
            String strPr = prVarPr.pr();
            if (TextUtils.equals(strPr, MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM)) {
                hn hnVar2 = new hn(context);
                hnVar2.pr(hnVar);
                hnVar2.pr(fwVarPr);
                hnVar2.uc();
                return hnVar2;
            }
            if (TextUtils.isEmpty(strPr) || TextUtils.equals(strPr, "global")) {
                zoVarPr = w.pr(prVarPr.hw());
            } else {
                zoVarPr = w.pr(prVarPr.c());
            }
            if (zoVarPr == null) {
                return null;
            }
            hw hwVarPr = zoVarPr.pr(context);
            hwVarPr.pr(hnVar);
            hwVarPr.pr(fwVarPr);
            hwVarPr.uc();
            return hwVarPr;
        }
    }
}
