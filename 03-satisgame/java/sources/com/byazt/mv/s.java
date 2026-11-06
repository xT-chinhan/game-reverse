package com.byazt.mv;

import com.anythink.core.common.f.a;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 701, 8})
public class s {
    public static void n(com.byazt.sg.s sVar, com.byazt.qn.qg qgVar, Map<String, Object> map) {
        if (com.byazt.qt.qg.n().b()) {
            String strA = qgVar != null ? qgVar.a() : null;
            qg qgVarNf = com.byazt.qt.qg.n().nf();
            if (qgVarNf != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("lt_days", Integer.valueOf(qgVarNf.n()));
                    jSONObject.putOpt(a.C0017a.o, qgVarNf.s(strA));
                } catch (Exception e) {
                    com.byazt.rb.qg.q("AdLoadEventManager", "put 元素 异常：" + e.getMessage());
                }
                try {
                    jSONObject.putOpt("score", Float.valueOf(com.byazt.qt.n.d().n(strA)));
                } catch (Exception e2) {
                    com.byazt.rb.qg.q("AdLoadEventManager", "put 元素异常：" + e2.getMessage());
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.putOpt("dis_c", Integer.valueOf(n.qg(strA)));
                    jSONObject2.putOpt("ins_d", Integer.valueOf(n.l()));
                    jSONObject2.putOpt("act_d", Integer.valueOf(n.qg()));
                    jSONObject2.putOpt("act_times", Integer.valueOf(n.q()));
                    jSONObject.putOpt("active_target", jSONObject2);
                } catch (Exception e3) {
                    com.byazt.rb.qg.q("AdLoadEventManager", "put 元素异常：" + e3.getMessage());
                }
                if (qgVar != null && qgVar.an() != null) {
                    Map<String, Object> mapAn = qgVar.an();
                    if (mapAn.containsKey(MediationConstant.KEY_USE_POLICY)) {
                        try {
                            jSONObject.putOpt("user_enter", mapAn.get(MediationConstant.KEY_USE_POLICY));
                        } catch (Exception e4) {
                            com.byazt.rb.qg.q("AdLoadEventManager", "put 元素异常：" + e4.getMessage());
                        }
                    }
                }
                map.put("dynamic_policy", jSONObject);
            }
        }
    }
}
