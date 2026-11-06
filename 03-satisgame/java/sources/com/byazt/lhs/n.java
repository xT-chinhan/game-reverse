package com.byazt.lhs;

import android.content.Context;
import com.byazt.nl.qg;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.api.model.AdnName;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1813, 19})
public class n {
    public static com.byazt.ej.n l = null;
    public static int n = 10;
    public static int q = 10;
    public static int qg = 10;
    public static int s = 10;

    public static void n(Context context) {
    }

    public static void n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            n = jSONObject.optInt(MediationConstant.RIT_TYPE_SPLASH, 10);
            qg = jSONObject.optInt("reward", 10);
            s = jSONObject.optInt("brand", 10);
            int iOptInt = jSONObject.optInt(AdnName.OTHER, 10);
            q = iOptInt;
            if (n < 0) {
                n = 10;
            }
            if (qg < 0) {
                qg = 10;
            }
            if (s < 0) {
                s = 10;
            }
            if (iOptInt < 0) {
                q = 10;
            }
            Object[] objArr = new Object[8];
            Integer.valueOf(n);
            Integer.valueOf(qg);
            Integer.valueOf(s);
            Integer.valueOf(q);
        } catch (Throwable th) {
            qg.n("MediaConfig", th.getMessage());
        }
    }

    public static void n(com.byazt.ej.n nVar) {
        l = nVar;
    }

    public static void n() {
        com.byazt.ej.n nVar = l;
        if (nVar != null) {
            nVar.l();
        }
    }

    public static int qg() {
        return n;
    }

    public static int s() {
        return qg;
    }

    public static int q() {
        return s;
    }

    public static int l() {
        return q;
    }
}
