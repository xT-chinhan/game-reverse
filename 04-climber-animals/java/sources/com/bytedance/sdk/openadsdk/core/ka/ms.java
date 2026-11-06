package com.bytedance.sdk.openadsdk.core.ka;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.ah.c;
import com.bytedance.sdk.openadsdk.core.ka.d.d;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.op;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.t.u;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    public static boolean ms(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, lm lmVar, boolean z) {
        boolean z2;
        if (!re.xr().xr(xrVar.d())) {
            return true;
        }
        if (lmVar == null) {
            u.ms().xr(3);
            return false;
        }
        String strNw = xrVar.nw();
        long jRe = lmVar.re();
        String strP = lmVar.p();
        try {
            if (TextUtils.isEmpty(strNw)) {
                u.ms().xr(1);
                return false;
            }
            JSONObject jSONObjectMs = c.ms(new JSONObject(strNw), false, true);
            if (jSONObjectMs == null) {
                u.ms().xr(1);
                return false;
            }
            op.ms msVarMs = op.ms.ms(jSONObjectMs, xrVar, null);
            if (msVarMs.x == null) {
                u.ms().xr(1);
                return false;
            }
            msVarMs.x.ms(jSONObjectMs);
            List<lm> listXr = msVarMs.x.xr();
            if (listXr == null) {
                u.ms().xr(1);
                return false;
            }
            Iterator<lm> it = listXr.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                lm next = it.next();
                if (TextUtils.isEmpty(next.p())) {
                    u.ms().xr(2);
                    return false;
                }
                if (!next.g()) {
                    u.ms().xr(5);
                    return false;
                }
                if (TextUtils.equals(next.p(), strP)) {
                    lmVar.le(next.pt());
                    z2 = true;
                    break;
                }
            }
            if (!z2) {
                u.ms().xr(3);
                return false;
            }
            if (lmVar.f() + jRe >= System.currentTimeMillis()) {
                return true;
            }
            d.ms(z ? 7 : 8).ms(xrVar.d());
            u.ms().xr(4);
            return false;
        } catch (Exception e) {
            u.ms().xr(1000);
            sl.ms(e);
            return false;
        }
    }
}
