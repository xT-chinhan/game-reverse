package com.byazt.tf;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.anythink.core.d.b.e;
import com.byazt.ci.l;
import com.byazt.gct.pk;
import com.byazt.gct.ta;
import com.byazt.nf.rv;
import com.byazt.tk.w;
import com.byazt.tk.x;
import java.io.File;
import java.io.FileFilter;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1662, 19})
public class n {
    public static volatile n n;
    public long q;
    public final Context qg;
    public final qg s;

    public static n n() {
        if (n == null) {
            synchronized (n.class) {
                if (n == null) {
                    n = new n(rv.getContext());
                }
            }
        }
        return n;
    }

    private n(Context context) {
        this.qg = context == null ? rv.getContext() : context.getApplicationContext();
        this.s = new qg();
    }

    public void qg() {
        File fileQ;
        File[] fileArrListFiles;
        l.n(7).n();
        l.n(8).n();
        if (("mounted".equals(com.byazt.xu.qg.n()) || !Environment.isExternalStorageRemovable()) && w.q(this.qg, false, null) != null) {
            fileQ = w.q(this.qg, false, null);
        } else {
            fileQ = w.qg(this.qg, false, null);
        }
        if (fileQ == null || !fileQ.exists() || !fileQ.isDirectory() || (fileArrListFiles = fileQ.listFiles(new FileFilter() { // from class: com.byazt.tf.n.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                if (file != null) {
                    return file.getName().contains("reward_video_cache");
                }
                return false;
            }
        })) == null || fileArrListFiles.length <= 0) {
            return;
        }
        for (File file : fileArrListFiles) {
            try {
                x.s(file);
            } catch (Throwable unused) {
            }
        }
    }

    public String n(boolean z, String str) {
        long jS = rv.qg().s(str);
        if (jS > 0 && System.currentTimeMillis() - this.q < jS) {
            return "1";
        }
        int i = z ? 7 : 8;
        pk pkVarQg = qg(z, str);
        if (pkVarQg == null) {
            return "0";
        }
        if (pkVarQg.ju() + pkVarQg.kc() < System.currentTimeMillis()) {
            l.n(i).n(str);
            return "1";
        }
        JSONObject jSONObjectN = n(pkVarQg);
        if (jSONObjectN == null) {
            return "0";
        }
        this.q = System.currentTimeMillis();
        return jSONObjectN.toString();
    }

    private JSONObject n(pk pkVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("req_id", pkVar.i());
            jSONObject.put("aid", Long.valueOf(pkVar.wm()));
            jSONObject.put("cid", Long.valueOf(pkVar.q()));
            jSONObject.put(e.a.h, pkVar.ry());
            jSONObject.put("material_key", pkVar.ha());
            jSONObject.put("s_send_ts", pkVar.ju());
            jSONObject.put("cache_time", pkVar.kc());
            jSONObject.put("ext", pkVar.z());
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public void n(com.byazt.zq.qg qgVar, String str) {
        this.s.n(str, qgVar);
    }

    public com.byazt.zq.qg n(pk pkVar, String str) {
        return this.s.n(pkVar == null ? null : pkVar.mk(), str);
    }

    public void qg(com.byazt.zq.qg qgVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        n(qgVar, str);
    }

    public synchronized pk qg(boolean z, String str) {
        pk pkVarN;
        try {
            if (z) {
                pkVarN = com.byazt.pj.x.n().n(str, 0);
            } else {
                pkVarN = com.byazt.pj.qg.n().n(str, 0);
            }
            if (pkVarN == null) {
                return null;
            }
            if (com.byazt.qq.qg.s(pkVarN)) {
                if (TextUtils.isEmpty(str) || !str.endsWith("again")) {
                    return pkVarN;
                }
                return null;
            }
            if (com.byazt.gks.n.n(pkVarN)) {
                return pkVarN;
            }
            if (ta.k(pkVarN) == null) {
                return null;
            }
            return pkVarN;
        } catch (Throwable th) {
            throw th;
        }
    }
}
