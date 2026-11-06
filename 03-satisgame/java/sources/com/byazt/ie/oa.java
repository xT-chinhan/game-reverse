package com.byazt.ie;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.wrapper.PluginActivityWrapper;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT})
public class oa implements n {
    @Override // com.byazt.ie.n
    public void n(n.InterfaceC0201n interfaceC0201n) {
        com.byazt.zb.qg qgVarN = interfaceC0201n.n();
        com.byazt.qn.qg qgVarWm = qgVarN.wm();
        String strN = com.byazt.th.n.n(qgVarWm.v());
        if (!TextUtils.isEmpty(strN)) {
            qgVarWm.q(2);
            com.byazt.ws.qg qgVarN2 = com.byazt.th.n.n(qgVarN.cy(), strN);
            if (qgVarN2 != null) {
                qgVarN.n(qgVarN2);
                com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(qgVarN2) + "测试工具加载广告........rit_id:" + qgVarWm.a() + " ,slot_id:" + strN);
            } else {
                com.byazt.gp.s.n(qgVarN.wm(), (String) null, !qgVarN.h(), qgVarN.fi().n, 81012, (Map<String, Object>) null);
                qgVarN.n(new com.byazt.pu.n(81012, com.byazt.mj.n.n(81012)));
                return;
            }
        } else if (com.byazt.lq.s.n() && com.byazt.vyf.s.cy().lq()) {
            try {
                SharedPreferences sharedPreferencesN = n(com.byazt.qt.qg.getContext());
                if (sharedPreferencesN == null) {
                    interfaceC0201n.n(interfaceC0201n.n());
                    return;
                }
                String string = sharedPreferencesN.getString(qgVarWm.a(), "");
                if (!TextUtils.isEmpty(string)) {
                    JSONObject jSONObject = new JSONObject(string);
                    String strOptString = jSONObject.optString("sub_rit_id");
                    if (System.currentTimeMillis() - jSONObject.optLong("save_time") > 3600000) {
                        sharedPreferencesN.edit().remove(qgVarWm.a()).apply();
                        interfaceC0201n.n(interfaceC0201n.n());
                        return;
                    } else {
                        com.byazt.ws.qg qgVarN3 = com.byazt.th.n.n(qgVarN.cy(), strOptString);
                        if (qgVarN3 != null) {
                            qgVarN.n(qgVarN3);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        interfaceC0201n.n(interfaceC0201n.n());
    }

    private SharedPreferences n(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (context.getClass() == PluginActivityWrapper.class && ((PluginActivityWrapper) context).mOriginActivity != null) {
                return com.byazt.qyu.qg.qg(((PluginActivityWrapper) context).mOriginActivity, "tools_pre_view_name", 0);
            }
            if (context.getClass() == PluginApplicationWrapper.class && ((PluginApplicationWrapper) context).mOriginApplication != null) {
                return com.byazt.qyu.qg.qg(((PluginApplicationWrapper) context).mOriginApplication, "tools_pre_view_name", 0);
            }
            return com.byazt.qyu.qg.qg(context, "tools_pre_view_name", 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.byazt.ie.n
    public void qg(n.InterfaceC0201n interfaceC0201n) {
        interfaceC0201n.n((String) null);
    }
}
