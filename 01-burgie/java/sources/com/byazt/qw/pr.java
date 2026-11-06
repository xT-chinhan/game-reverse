package com.byazt.qw;

import com.byazt.ca.aj;
import com.byazt.dz.hw;
import com.byazt.sd.a;
import com.byazt.xlm.fw;
import com.byazt.zp.m;
import com.byazt.zp.zo;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1969, 37})
public class pr {
    public final int pr;

    public pr(int i) {
        this.pr = i;
    }

    public pr(int i, boolean z) {
        this.pr = i;
        aj.pr().postDelayed(new Runnable() { // from class: com.byazt.qw.pr.1
            @Override // java.lang.Runnable
            public void run() {
                pr.this.uc();
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uc() {
        zo.pr(new fw("csj-plugin-check") { // from class: com.byazt.qw.pr.2
            @Override // java.lang.Runnable
            public void run() {
                if (pr.this.hw() == 5) {
                    hw.pr();
                }
            }
        });
    }

    public int pr(int i) {
        int i2 = this.pr >> i;
        int i3 = i2 & 7;
        if (i3 == 0) {
            return x();
        }
        return ((i2 & 8) >> 3) == 1 ? -i3 : i3;
    }

    public int pr() {
        return pr(0);
    }

    public int hw() {
        return pr(4);
    }

    public int hn() {
        return pr(8);
    }

    public int x() {
        return 2;
    }

    public int pr(String str) {
        if ("com.byted.live.lite".equals(str)) {
            if (a.hw().zz()) {
                return hw();
            }
            return 4;
        }
        if ("com.byted.csj.ext".equals(str)) {
            return hn();
        }
        if ("com.byted.pangle".equals(str)) {
            return pr();
        }
        return x();
    }

    public void c() {
        JSONObject jSONObjectQz = a.hw().qz();
        if (jSONObjectQz == null) {
            return;
        }
        try {
            pr(jSONObjectQz, "com.byted.live.lite", 4, true);
            pr(jSONObjectQz, "com.byted.csj.ext", 8, true);
            pr(jSONObjectQz, "com.byted.mixed", 0, true);
            pr(jSONObjectQz, "com.byted.pangle", 0, false);
        } catch (Throwable th) {
        }
    }

    private void pr(JSONObject jSONObject, String str, int i, boolean z) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(str);
        if (jSONObjectOptJSONObject == null) {
            return;
        }
        int iOptInt = jSONObjectOptJSONObject.optInt("state", 2);
        int iOptInt2 = jSONObjectOptJSONObject.optInt("plugin_v", 0);
        if (iOptInt != 5) {
            if (iOptInt == -1 && pr(i) == 5 && m.hn(str) > m.uc(str)) {
                m.pr(str, iOptInt2);
                return;
            }
            return;
        }
        int iHw = m.hw(str);
        int iHn = m.hn(str);
        int iUc = m.uc(str);
        String strOptString = jSONObjectOptJSONObject.optString("api_rule", "=");
        String strOptString2 = jSONObjectOptJSONObject.optString("plugin_rule", "=");
        if (pr(iHw, jSONObjectOptJSONObject.optInt("api_v", 0), strOptString)) {
            if ((z || iHn > iUc) && pr(iHn, iOptInt2, strOptString2)) {
                m.pr(str, 0);
            }
            List<Integer> listC = m.c(str);
            if (listC != null) {
                for (Integer num : listC) {
                    if (num.intValue() != iHn && pr(num.intValue(), iOptInt2, strOptString2)) {
                        m.pr(str, num.intValue());
                    }
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:23:0x0046  */
    private boolean pr(int i, int i2, String str) {
        switch (str) {
            case ">":
                return i > i2;
            case "<":
                return i < i2;
            case "=":
            case "==":
                return i == i2;
            case ">=":
                return i >= i2;
            case "<=":
                return i <= i2;
            default:
                return false;
        }
    }

    public String toString() {
        return String.valueOf(this.pr);
    }
}
