package com.bytedance.sdk.openadsdk.core.of;

import com.bytedance.sdk.component.ch.ab;
import com.bytedance.sdk.component.ch.hi;
import com.bytedance.sdk.component.ch.ms.xr;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.re;
import com.qq.e.comm.constants.ErrorCode;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static volatile boolean f3195ms = true;
    private static boolean xr = false;

    public static void ms() {
        if (xr) {
            return;
        }
        xr = true;
        hi hiVar = hi.xr;
        hiVar.ms(11);
        hiVar.d(g.ms());
        hiVar.ah(true);
        hiVar.ms(true);
        hiVar.xr(true);
        hiVar.ms(new xr() { // from class: com.bytedance.sdk.openadsdk.core.of.ms.1
            @Override // com.bytedance.sdk.component.ch.ms.xr
            public String ms(String str) {
                if (str != null) {
                    return str.startsWith("csj") ? str : "csj_".concat(String.valueOf(str));
                }
                return "csj_uk";
            }
        });
    }

    public static void xr() {
        JSONObject jSONObjectS = re.xr().s();
        if (jSONObjectS == null) {
            return;
        }
        hi hiVar = hi.xr;
        int iOptInt = jSONObjectS.optInt("big_max_mum", 50);
        if (iOptInt > 0) {
            hiVar.d(iOptInt);
        }
        int iOptInt2 = jSONObjectS.optInt("core_count", 0);
        if (iOptInt2 > 0) {
            hiVar.ah(iOptInt2);
        }
        int iOptInt3 = jSONObjectS.optInt("big_keep_alive", 0);
        if (iOptInt3 > 0) {
            hiVar.ms(iOptInt3);
        }
        hiVar.ka(jSONObjectS.optBoolean("big_priority", false));
        hiVar.ah(jSONObjectS.optBoolean("catch_oom", true));
        hiVar.xr(jSONObjectS.optBoolean("forbid_autosize_oom", true));
        hiVar.c(jSONObjectS.optBoolean("enable_proxy", true));
        f3195ms = jSONObjectS.optBoolean("can_set_crash", true);
        ab.ms(jSONObjectS.optBoolean("autosize", true));
        hiVar.ny(jSONObjectS.optBoolean("report_task", false));
        hiVar.xr(jSONObjectS.optInt("wait_in_big", 50));
        hiVar.ah(jSONObjectS.optInt("wait_in_little", 2000));
        hiVar.d(jSONObjectS.optInt("run_cost", ErrorCode.UNKNOWN_ERROR));
    }
}
