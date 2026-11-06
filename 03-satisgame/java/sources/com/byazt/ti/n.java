package com.byazt.ti;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.ju.q;
import com.byazt.rb.s;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1281, 19})
public class n {
    public final Map<String, com.byazt.sbw.n> n = new ConcurrentHashMap();

    public Map<String, com.byazt.sbw.n> n() {
        return this.n;
    }

    public void n(String str, com.byazt.sbw.n nVar) {
        this.n.put(str, nVar);
    }

    public com.byazt.sbw.n n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.n.get(str);
    }

    public String n(Context context, Map<String, Object> map, String str) {
        s.n(context);
        com.byazt.sbw.n nVarN = n(str);
        if (nVarN != null) {
            return nVarN.n(null, null);
        }
        q qVarQg = qg(str);
        if (qVarQg == null) {
            return null;
        }
        return qVarQg.n(context, map);
    }

    public Map<String, Object> qg(Context context, Map<String, Object> map, String str) {
        s.n(context);
        com.byazt.sbw.n nVarN = n(str);
        if (nVarN != null) {
            HashMap map2 = new HashMap();
            map2.put("buyerId", nVarN.n(context, map));
            map2.put("sdkInfo", nVarN.qg(context, map));
            return map2;
        }
        q qVarQg = qg(str);
        if (qVarQg == null) {
            return null;
        }
        return qVarQg.qg(context, map);
    }

    public q qg(String str) {
        return com.byazt.ya.qg.n().n(str);
    }
}
