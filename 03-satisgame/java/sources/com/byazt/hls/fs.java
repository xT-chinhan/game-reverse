package com.byazt.hls;

import android.os.Handler;
import com.byazt.vf.cp;
import com.byazt.vf.wo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1598, 101})
public class fs {
    public static volatile fs qg;
    public long n = 3000;

    public static fs n() {
        if (qg == null) {
            synchronized (fs.class) {
                if (qg == null) {
                    qg = new fs();
                }
            }
        }
        return qg;
    }

    private fs() {
    }

    public Handler qg() {
        return ((wo) com.byazt.qp.q.n("thread_service")).q();
    }

    public long n(cp cpVar) {
        long jQg = qg(cpVar);
        if (jQg <= 0) {
            return 3000L;
        }
        return jQg;
    }

    public long qg(cp cpVar) {
        JSONObject jSONObjectUm;
        if (cpVar == null || (jSONObjectUm = cpVar.um()) == null) {
            return 3000L;
        }
        return jSONObjectUm.optLong("insert_interval", 3000L);
    }
}
