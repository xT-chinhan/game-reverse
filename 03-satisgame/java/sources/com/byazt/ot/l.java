package com.byazt.ot;

import android.content.Intent;
import com.byazt.tk.rv;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 50, 18})
public class l {
    public static volatile l n;
    public com.byazt.gwu.s qg;

    public static l n() {
        if (n == null) {
            synchronized (l.class) {
                if (n == null) {
                    n = new l();
                }
            }
        }
        return n;
    }

    public void n(Intent intent) {
        if (intent == null) {
            return;
        }
        final boolean z = (intent.getFlags() & 8388608) == 8388608;
        rv.n().post(new Runnable() { // from class: com.byazt.ot.l.1
            @Override // java.lang.Runnable
            public void run() {
                int i = 0;
                int iQg = l.this.qg().qg("all_activity_count", 0) + 1;
                if (z) {
                    int iQg2 = l.this.qg().qg("hide_activity_count", 0) + 1;
                    if (iQg2 >= 10) {
                        l.this.n(iQg);
                        iQg = 0;
                    } else {
                        i = iQg2;
                    }
                    l.this.qg().n("hide_activity_count", i);
                }
                l.this.qg().n("all_activity_count", iQg);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.gwu.s qg() {
        if (this.qg == null) {
            this.qg = com.byazt.lk.l.qg(com.byazt.vgx.s.q(), "hide_recent_activity_recorder", 0, null);
        }
        return this.qg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final int i) {
        com.byazt.eji.s.n().n("hide_activity_record", new com.byazt.rs.n() { // from class: com.byazt.ot.l.2
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("ac", i);
                return jSONObject2;
            }
        });
    }
}
