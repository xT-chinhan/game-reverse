package com.byazt.eo;

import android.content.Context;
import com.byazt.nf.rv;
import com.byazt.qit.x;
import com.byazt.tk.k;
import com.byazt.tk.w;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1827, 19})
public class n {
    public static volatile boolean n = false;

    private static void n(Context context, qg qgVar) {
        if (qgVar != null && com.byazt.lq.qg.n == null && ((com.byazt.vf.l) com.byazt.qp.q.n("app_process")).n() && qgVar.q()) {
            String path = w.qg(context, false, null).getPath();
            String string = com.byazt.qyu.qg.n(context).toString();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("buffer_dir_path", path + "/aa");
                jSONObject.putOpt("log_dir_path", string + "/aa");
                jSONObject.putOpt("compress", Boolean.TRUE);
                jSONObject.putOpt("encrypt", Boolean.TRUE);
                jSONObject.putOpt("level", Integer.valueOf(qgVar.n()));
                jSONObject.putOpt("log_file_exp_days", Integer.valueOf(qgVar.qg()));
                jSONObject.putOpt("max_dir_size", Integer.valueOf(qgVar.s() * 1024 * 1024));
                jSONObject.putOpt("per_size", 2097152);
                jSONObject.putOpt("offload_main_write", Boolean.TRUE);
                if (s.n(context, jSONObject)) {
                    k.n(new l());
                    s.n(context, "3892", com.byazt.yu.n.n().qg());
                    s.n("mon.zijieapi.com");
                    n = true;
                    s.s();
                    return;
                }
                k.qg("ACL", "init failed");
            } catch (JSONException e) {
                k.qg("ACL", "init failed:" + e.getMessage());
            }
        }
    }

    public static void n(qg qgVar) {
        if (!n) {
            n(rv.getContext(), qgVar);
        } else if (qgVar == null || !qgVar.q()) {
            s.n();
        } else {
            s.n(qgVar.n());
            com.byazt.tk.rv.n().postDelayed(new Runnable() { // from class: com.byazt.eo.n.1
                @Override // java.lang.Runnable
                public void run() {
                    n.qg();
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg() {
        com.byazt.qit.l.qg(new x("fetch_lg_command") { // from class: com.byazt.eo.n.2
            @Override // java.lang.Runnable
            public void run() {
                s.qg();
            }
        });
    }

    public static void n(String str, String str2) {
        if (n) {
            s.n(str, str2);
        }
    }

    public static void qg(String str, String str2) {
        if (n) {
            s.qg(str, str2);
        }
    }

    public static void s(String str, String str2) {
        if (n) {
            s.s(str, str2);
        }
    }

    public static void n(String str, String str2, Throwable th) {
        if (n) {
            s.n(str, str2, th);
        }
    }

    public static void n(String str, Throwable th) {
        if (n) {
            s.n(str, th);
        }
    }
}
