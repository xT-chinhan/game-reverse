package com.byazt.xb;

import com.anythink.core.common.m.a.m;
import com.byazt.hoz.q;
import com.byazt.qit.x;
import com.byazt.tk.rv;
import com.byazt.wl.l;
import com.taptap.sdk.login.internal.handlers.web.WebLoginFragment;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, m.h, 19})
public class n {
    public final int n;

    public int q() {
        return 2;
    }

    public n(int i) {
        this.n = i;
    }

    public n(int i, boolean z) {
        this.n = i;
        rv.n().postDelayed(new Runnable() { // from class: com.byazt.xb.n.1
            @Override // java.lang.Runnable
            public void run() {
                n.this.w();
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        com.byazt.ag.qg.n(new x("csj-plugin-check") { // from class: com.byazt.xb.n.2
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.qg() == 5) {
                    com.byazt.hoz.qg.n();
                }
            }
        });
    }

    public int n(int i) {
        int i2 = this.n >> i;
        int i3 = i2 & 7;
        if (i3 == 0) {
            return q();
        }
        return ((i2 & 8) >> 3) == 1 ? -i3 : i3;
    }

    public int n() {
        return n(0);
    }

    public int qg() {
        return n(4);
    }

    public int s() {
        return n(8);
    }

    public int n(String str) {
        if ("com.byted.live.lite".equals(str)) {
            if (!q.n() && com.byazt.nf.rv.qg().xf()) {
                return qg();
            }
            return 4;
        }
        if ("com.byted.csj.ext".equals(str)) {
            return s();
        }
        if ("com.byted.pangle".equals(str)) {
            return n();
        }
        return q();
    }

    public void l() {
        JSONObject jSONObjectOs = com.byazt.nf.rv.qg().os();
        if (jSONObjectOs == null) {
            return;
        }
        try {
            n(jSONObjectOs, "com.byted.live.lite", 4, true);
            n(jSONObjectOs, "com.byted.csj.ext", 8, true);
            n(jSONObjectOs, "com.byted.mixed", 0, true);
            n(jSONObjectOs, "com.byted.pangle", 0, false);
        } catch (Throwable unused) {
        }
    }

    private void n(JSONObject jSONObject, String str, int i, boolean z) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(str);
        if (jSONObjectOptJSONObject == null) {
            return;
        }
        int iOptInt = jSONObjectOptJSONObject.optInt(WebLoginFragment.QUERY_KEY_ID, 2);
        int iOptInt2 = jSONObjectOptJSONObject.optInt("plugin_v", 0);
        if (iOptInt == 5) {
            int iQg = l.qg(str);
            int iS = l.s(str);
            int iW = l.w(str);
            String strOptString = jSONObjectOptJSONObject.optString("api_rule", "=");
            String strOptString2 = jSONObjectOptJSONObject.optString("plugin_rule", "=");
            if (n(iQg, jSONObjectOptJSONObject.optInt("api_v", 0), strOptString)) {
                if ((z || iS > iW) && n(iS, iOptInt2, strOptString2)) {
                    l.n(str, 0);
                }
                List<Integer> listL = l.l(str);
                if (listL != null) {
                    for (Integer num : listL) {
                        if (num.intValue() != iS && n(num.intValue(), iOptInt2, strOptString2)) {
                            l.n(str, num.intValue());
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (iOptInt == -1 && n(i) == 5 && l.s(str) > l.w(str)) {
            l.n(str, iOptInt2);
        }
    }

    private boolean n(int i, int i2, String str) {
        str.hashCode();
        switch (str) {
            case "<":
                return i < i2;
            case "=":
            case "==":
                return i == i2;
            case ">":
                return i > i2;
            case "<=":
                return i <= i2;
            case ">=":
                return i >= i2;
            default:
                return false;
        }
    }

    public String toString() {
        return String.valueOf(this.n);
    }
}
