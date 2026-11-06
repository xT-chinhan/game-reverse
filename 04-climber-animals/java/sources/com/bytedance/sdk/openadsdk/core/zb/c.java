package com.bytedance.sdk.openadsdk.core.zb;

import android.text.TextUtils;
import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.nw.h;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.ul;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile c f3854ms;

    public static c ms() {
        if (f3854ms == null) {
            synchronized (c.class) {
                if (f3854ms == null) {
                    f3854ms = new c();
                }
            }
        }
        return f3854ms;
    }

    private c() {
    }

    public void ms(final lm lmVar, final String str, final boolean z) {
        if (lmVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        new ab().ms(new ab.ms() { // from class: com.bytedance.sdk.openadsdk.core.zb.c.1
            private boolean c = false;

            @Override // com.bytedance.sdk.openadsdk.core.zb.ab.ms
            public void ms() {
                ms(false, "resume");
                if (!z) {
                    xr(str);
                }
                com.bytedance.sdk.openadsdk.core.xr.ms().ms("dpl_reject_by_dialog", true);
                ah.ms(lmVar, str, "dpl_popup", System.currentTimeMillis() - jCurrentTimeMillis);
            }

            @Override // com.bytedance.sdk.openadsdk.core.zb.ab.ms
            public void ms(String str2) {
                ms(false, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.zb.ab.ms
            public void ms(boolean z2) {
                this.c = z2;
                ms(z2, "stop");
                if (!this.c && !z) {
                    xr(str);
                }
                com.bytedance.sdk.openadsdk.core.xr.ms().ms("dpl_reject_by_dialog", false);
            }

            private void xr(String str2) {
                lm lmVar2 = lmVar;
                if (lmVar2 == null || this.c) {
                    return;
                }
                boolean zGz = lmVar2.gz();
                h hVarTc = lmVar.tc();
                if (hVarTc == null || hVarTc.ms()) {
                    return;
                }
                int iAh = hVarTc.ah();
                if (zGz) {
                    return;
                }
                if (iAh == 1 || iAh == 2) {
                    ul.ms(lmVar, str2);
                }
            }

            private void ms(final boolean z2, final String str2) {
                com.bytedance.sdk.component.ch.ab.ms(new ny("EventData") { // from class: com.bytedance.sdk.openadsdk.core.zb.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (z) {
                            ah.ah(lmVar, str, z2 ? "lp_dpl_success" : "lp_dpl_failed");
                            return;
                        }
                        String str3 = z2 ? "dpl_success" : "dpl_failed";
                        HashMap map = new HashMap();
                        boolean zMs = ch.ub().ms();
                        map.put("has_focus", Boolean.valueOf(ch.ub().ms(true)));
                        map.put("is_background", Boolean.valueOf(zMs));
                        map.put("life", str2);
                        map.put("total_duration", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                        ah.x(lmVar, str, str3, map);
                        if (lmVar != null) {
                            c.xr(lmVar, str);
                        }
                    }
                }, 5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xr(lm lmVar, String str) {
        if (lmVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.component.d.ms.xr xrVarMs = com.bytedance.sdk.openadsdk.core.xr.ms();
        xrVarMs.ms("save_jump_success_time", System.currentTimeMillis());
        JSONObject jSONObjectRm = lmVar.rm();
        if (jSONObjectRm == null) {
            return;
        }
        xrVarMs.ms("save_dpl_success_materialmeta", jSONObjectRm.toString());
        xrVarMs.ms("save_jump_success_ad_tag", str);
    }
}
