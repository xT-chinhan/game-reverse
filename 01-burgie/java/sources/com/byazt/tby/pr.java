package com.byazt.tby;

import android.text.TextUtils;
import com.byazt.dd.fw;
import com.bytedance.android.live.base.api.push.ILivePush;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.mar.sdk.MARCode;
import com.taptap.sdk.db.constant.Common;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 225, 37})
public abstract class pr {
    public static final HashSet<String> pr = new HashSet<>(Arrays.asList("convert", com.byazt.pfl.hw.AD_TAG_DISLIKE, "openAppPermission", "openAppPolicy", "openPrivacy", "openAppFunction", ILivePush.ClickType.CLOSE, "skip", "videoControl", "pauseVideo", "resumeVideo", "muteVideo", "preventEvent"));
    public String c;
    public String fw;
    public com.byazt.ik.hn hn;
    public fw.pr hw;
    public Map<String, Object> uc;
    public String x;
    public String zo;

    public abstract void pr();

    public pr(com.byazt.ik.hn hnVar, String str, fw.pr prVar) {
        this.hn = hnVar;
        this.hw = prVar;
        this.fw = str;
        c();
    }

    private void c() {
        fw.pr prVar = this.hw;
        if (prVar == null) {
            return;
        }
        this.x = prVar.pr();
        this.c = this.hw.hw();
        Map<String, Object> mapHn = this.hw.hn();
        this.uc = mapHn;
        if (mapHn != null && !mapHn.isEmpty() && this.uc.containsKey("emitCustomEvent") && (this.uc.get("emitCustomEvent") instanceof String)) {
            this.zo = (String) this.uc.get("emitCustomEvent");
        }
    }

    public void hw() {
        hn();
    }

    public void hn() {
        if (x()) {
            fw.pr prVar = new fw.pr();
            prVar.pr(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM);
            prVar.hw("emit");
            HashMap map = new HashMap();
            map.put(Common.System.NAME, this.zo);
            prVar.pr(map);
            new hw(this.hn, this.c, prVar).pr();
        }
    }

    public boolean x() {
        return !TextUtils.isEmpty(this.zo);
    }

    /* JADX INFO: renamed from: com.byazt.tby.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 225, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    public static class C0193pr {
        public static pr pr(com.byazt.ik.hn hnVar, String str, fw.pr prVar) {
            if (prVar == null) {
                return null;
            }
            com.byazt.dd.hw hwVarPr = com.byazt.dd.x.pr(prVar.hw());
            if (hwVarPr == null && (TextUtils.isEmpty(prVar.pr()) || !TextUtils.equals(prVar.pr(), "global"))) {
                hwVarPr = com.byazt.dd.x.pr(prVar.c());
            }
            if (hwVarPr == null) {
                return new hn(hnVar, str, prVar);
            }
            pr prVarPr = hwVarPr.pr(hnVar, str, prVar);
            if (prVarPr == null) {
                return new hn(hnVar, str, prVar);
            }
            return prVarPr;
        }
    }
}
