package com.byazt.ivn;

import android.text.TextUtils;
import com.byazt.gct.pk;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 591, 8})
public class s {
    public final Map<String, Integer> n;

    private s() {
        this.n = new ConcurrentHashMap();
    }

    @com.byazt.cp.n(n = {0, 1, 591, 546})
    private static class n {
        public static final s n = new s();
    }

    public static s n() {
        return n.n;
    }

    private com.byazt.gwu.s qg() {
        return com.byazt.lk.l.qg(com.byazt.vyf.s.cy().ou(), "sp_meta_common_config", 1, com.byazt.p001if.n.qg());
    }

    public void n(pk pkVar) {
        JSONObject jSONObjectBt;
        if (pkVar == null || (jSONObjectBt = pkVar.bt()) == null) {
            return;
        }
        try {
            Iterator<String> itKeys = jSONObjectBt.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (!TextUtils.isEmpty(next)) {
                    qg(next, jSONObjectBt.optInt(next, -1));
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void qg(String str, int i) {
        Integer num = this.n.get(str);
        if (num == null || num.intValue() != i) {
            this.n.put(str, Integer.valueOf(i));
            try {
                qg().n(str, i);
            } catch (Throwable unused) {
            }
        }
    }

    public int n(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        Integer num = this.n.get(str);
        if (num != null) {
            return num.intValue();
        }
        try {
            i = qg().getInt(str, i);
        } catch (Throwable unused) {
        }
        this.n.put(str, Integer.valueOf(i));
        return i;
    }

    private int qg(int i) {
        if (i == 1) {
            return n("banner_c_s", -1);
        }
        if (i == 3 || i == 4) {
            return n("splash_c_s", -1);
        }
        if (i == 5) {
            return n("feed_c_s", -1);
        }
        if (i == 7) {
            return n("reward_c_s", -1);
        }
        if (i == 8) {
            return n("full_c_s", -1);
        }
        if (i != 9) {
            return -1;
        }
        return n("draw_c_s", -1);
    }

    public boolean n(int i) {
        return qg(i) == -1 || (qg(i) & 1) == 1;
    }
}
