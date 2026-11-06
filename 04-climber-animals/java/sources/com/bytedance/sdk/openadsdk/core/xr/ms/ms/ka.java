package com.bytedance.sdk.openadsdk.core.xr.ms.ms;

import android.text.TextUtils;
import com.anythink.core.common.e.g;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.nw.f;
import com.bytedance.sdk.openadsdk.core.nw.h;
import com.bytedance.sdk.openadsdk.core.nw.hi;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.nw;
import com.bytedance.sdk.openadsdk.core.nw.xn;
import com.bytedance.sdk.openadsdk.core.t.u;
import com.bytedance.sdk.openadsdk.core.ul;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ka {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private c f3770ms;
    private hi xr;

    public ka(c cVar, hi hiVar) {
        this.f3770ms = cVar;
        this.xr = hiVar;
    }

    public boolean ms() {
        com.bytedance.sdk.openadsdk.ao.xr.ms.ms msVar;
        lm lmVarXr = this.f3770ms.xr();
        if (lmVarXr == null) {
            return false;
        }
        String strDa = lmVarXr.da();
        String strZm = lmVarXr.zm();
        nw nwVarMh = lmVarXr.mh();
        if (TextUtils.isEmpty(strDa) || TextUtils.isEmpty(strZm) || nwVarMh == null || nwVarMh.d() != 1 || (msVar = (com.bytedance.sdk.openadsdk.ao.xr.ms.ms) i.ms(strDa, com.bytedance.sdk.openadsdk.ao.xr.ms.ms.class)) == null) {
            return false;
        }
        HashMap map = new HashMap();
        map.put("is_button", Boolean.FALSE);
        msVar.ms(100, map);
        com.bytedance.sdk.openadsdk.core.hi.ah.xr.xr.ms(map, Boolean.FALSE, lmVarXr.eu(), lmVarXr.cz());
        Object obj = map.get("convert_result");
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return true;
    }

    public boolean ms(Map<String, Object> map, boolean z, String str, boolean z2, boolean z3, boolean z4) {
        if (this.f3770ms == null) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            int iU = this.f3770ms.u();
            Object obj = map.get("key_open_video_detail_page_direct");
            boolean zMs = ms(z, str, true, obj != null && ((Boolean) obj).booleanValue(), jSONObject);
            try {
                jSONObject.putOpt("open_plp", Integer.valueOf(iU));
                jSONObject.putOpt("should_download", Boolean.valueOf(z4));
                jSONObject.putOpt("can_send_click", Boolean.valueOf(z2));
            } catch (Exception unused) {
            }
            lm lmVarXr = this.f3770ms.xr();
            if (lmVarXr != null) {
                try {
                    jSONObject.putOpt("live_interaction_type", Integer.valueOf(lmVarXr.ku()));
                    jSONObject.putOpt("req_id", lmVarXr.eu());
                    jSONObject.putOpt("web_meta", Boolean.valueOf(lmVarXr.ms()));
                } catch (Exception unused2) {
                }
            }
            if (lmVarXr != null && z2) {
                h hVarTc = lmVarXr.tc();
                if (!z3 || zMs || hVarTc == null || hVarTc.ka() != 2) {
                    map.put("convert_res", Boolean.valueOf(zMs));
                    return true;
                }
            }
            return false;
        } finally {
            u.ms().ms("open_detail_page", "native", 0, jSONObject);
        }
    }

    boolean ms(boolean z, String str, boolean z2, boolean z3, JSONObject jSONObject) {
        boolean zMs = ms();
        sl.ms("do", "int:".concat(String.valueOf(zMs)));
        if (zMs) {
            try {
                jSONObject.putOpt("intercept", Boolean.TRUE);
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        ul.ms(z2);
        return ul.ms(this.f3770ms, str, z, z3, jSONObject);
    }

    public void ms(lm lmVar, Map<String, Object> map) {
        f fVarDm;
        if (lmVar == null || !xn.ms(lmVar) || (fVarDm = lmVar.dm()) == null) {
            return;
        }
        String strAh = fVarDm.ah();
        String strD = fVarDm.d();
        int iXr = xn.xr(lmVar);
        long jKa = fVarDm.ka();
        if (jKa > TTAdConstant.LIVE_REWARD_TIME.longValue()) {
            jKa -= TTAdConstant.LIVE_REWARD_TIME.longValue();
        }
        try {
            if (!TextUtils.isEmpty(strAh)) {
                JSONObject jSONObject = new JSONObject(strAh);
                if (jKa <= 0 || iXr == 1) {
                    jSONObject.put("ad_slot_type", -1);
                    fVarDm.ah(jSONObject.toString());
                }
            }
            if (!TextUtils.isEmpty(strD)) {
                JSONObject jSONObject2 = new JSONObject(strD);
                if (jKa <= 0) {
                    jKa = 0;
                }
                jSONObject2.put("count_down_time", jKa / 1000);
                jSONObject2.put(g.a.g, com.bytedance.sdk.openadsdk.core.jw.f.ch());
                jSONObject2.put("act_name", com.bytedance.sdk.openadsdk.core.jw.f.sl(com.bytedance.sdk.openadsdk.core.jw.f.ch()));
                fVarDm.d(jSONObject2.toString());
            }
            map.put("is_reward_live", Boolean.TRUE);
        } catch (Exception e) {
            sl.ms(e);
        }
    }
}
