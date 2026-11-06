package com.byazt.cl;

import android.text.TextUtils;
import com.byazt.ivn.w;
import com.byazt.lk.l;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1321, 19})
public final class n {
    public static volatile long n = 0;
    public static volatile boolean q = false;
    public static volatile long qg;
    public static volatile JSONObject s;

    private n() {
    }

    public static void n() {
        if (!com.byazt.vyf.s.cy().cp()) {
            n |= 1;
        }
        if (!com.byazt.vyf.s.cy().q()) {
            n |= 2;
        }
        if (com.byazt.vyf.s.cy().hd().s()) {
            return;
        }
        n |= 4;
    }

    public static void n(JSONObject jSONObject) {
        s = jSONObject;
        if (jSONObject.optBoolean("pglam_getwvid_enable", true)) {
            return;
        }
        qg |= 8;
    }

    public static JSONObject qg() {
        if (s != null) {
            return s;
        }
        String strQg = l.qg(com.byazt.vgx.s.q(), w.l()).qg("pglam", "");
        if (!TextUtils.isEmpty(strQg)) {
            try {
                JSONObject jSONObject = new JSONObject(strQg);
                s = jSONObject;
                return jSONObject;
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public static long s() {
        if (!q) {
            synchronized (n.class) {
                n();
                q = true;
            }
        }
        if (s == null) {
            synchronized (n.class) {
                JSONObject jSONObjectQg = qg();
                s = jSONObjectQg;
                if (jSONObjectQg != null) {
                    n(s);
                }
            }
        }
        return n | qg;
    }
}
