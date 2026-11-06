package com.byazt.sh;

import android.content.Context;
import com.byazt.va.qg;
import com.byazt.va.s;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1695, 19})
public abstract class n {
    public final List<Future<com.byazt.ahu.n>> n = new ArrayList();
    public final qg q;
    public final Context qg;
    public final com.byazt.kn.n s;

    public abstract List<String> n();

    public boolean n(JSONObject jSONObject) {
        return false;
    }

    public n(Context context, qg qgVar, com.byazt.kn.n nVar) {
        this.q = qgVar;
        this.s = nVar;
        this.qg = context;
    }

    public void n(com.byazt.va.n nVar, Long l) {
        this.n.add(com.byazt.dp.n.n(new s(nVar, l)));
    }

    /* JADX WARN: Code duplicated, block: B:20:0x004d  */
    /* JADX WARN: Code duplicated, block: B:38:0x0072 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x0008 A[SYNTHETIC] */
    public void n(Map<String, JSONObject> map, long j) {
        byte b;
        com.byazt.va.n nVar;
        com.byazt.va.n nVar2;
        for (Map.Entry<String, JSONObject> entry : map.entrySet()) {
            String key = entry.getKey();
            try {
                if (n().contains(entry.getKey())) {
                    int iHashCode = key.hashCode();
                    if (iHashCode != 3073450) {
                        if (iHashCode == 3073698 && key.equals("d_i0")) {
                            b = 1;
                        } else {
                            b = -1;
                        }
                    } else if (key.equals("d_a0")) {
                        b = 0;
                    } else {
                        b = -1;
                    }
                    if (b != 0) {
                        if (b != 1) {
                            nVar2 = null;
                        } else {
                            nVar = new com.byazt.tm.qg(this.qg, entry.getValue());
                        }
                        if (nVar2 != null) {
                            n(nVar2, Long.valueOf(j));
                        }
                    } else {
                        nVar = new com.byazt.tm.n(this.qg, entry.getValue());
                    }
                    nVar2 = nVar;
                    if (nVar2 != null) {
                        n(nVar2, Long.valueOf(j));
                    }
                }
            } catch (Exception e) {
                com.byazt.nt.n.q("__kite", "error " + e.getMessage());
            }
        }
    }
}
