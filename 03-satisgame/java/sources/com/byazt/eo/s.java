package com.byazt.eo;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1827, 8})
public class s {
    public static com.byazt.ek.n n;

    private static com.byazt.ek.n q() {
        if (n == null) {
            n = com.byazt.vzq.s.n().w();
        }
        return n;
    }

    public static void n(qg qgVar) {
        if (q() == null) {
            return;
        }
        n.n(qgVar);
    }

    public static void n() {
        com.byazt.ek.n nVarQ = q();
        if (nVarQ == null) {
            return;
        }
        nVarQ.n();
    }

    public static void n(int i) {
        com.byazt.ek.n nVarQ = q();
        if (nVarQ == null) {
            return;
        }
        nVarQ.n(i);
    }

    public static void n(String str, String str2) {
        com.byazt.ek.n nVarQ = q();
        if (nVarQ == null) {
            return;
        }
        nVarQ.qg(str, str2);
    }

    public static void qg(String str, String str2) {
        com.byazt.ek.n nVarQ = q();
        if (nVarQ == null) {
            return;
        }
        nVarQ.s(str, str2);
    }

    public static void s(String str, String str2) {
        com.byazt.ek.n nVarQ = q();
        if (nVarQ == null) {
            return;
        }
        nVarQ.l(str, str2);
    }

    public static void n(String str, String str2, Throwable th) {
        com.byazt.ek.n nVarQ = q();
        if (nVarQ == null) {
            return;
        }
        nVarQ.qg(str, str2, th);
    }

    public static void n(String str, Throwable th) {
        com.byazt.ek.n nVarQ = q();
        if (nVarQ == null) {
            return;
        }
        nVarQ.qg(str, th);
    }

    public static void qg() {
        com.byazt.ek.n nVarQ = q();
        if (nVarQ == null) {
            return;
        }
        nVarQ.s();
    }

    public static boolean n(Context context, JSONObject jSONObject) {
        com.byazt.ek.n nVarQ = q();
        if (nVarQ == null) {
            return false;
        }
        nVarQ.n(context, jSONObject);
        return true;
    }

    public static void n(Context context, String str, String str2) {
        com.byazt.ek.n nVarQ = q();
        if (nVarQ == null) {
            return;
        }
        nVarQ.n(context, str, str2);
    }

    public static void n(String str) {
        com.byazt.ek.n nVarQ = q();
        if (nVarQ == null) {
            return;
        }
        nVarQ.n(str);
    }

    public static void s() {
        com.byazt.ek.n nVarQ = q();
        if (nVarQ == null) {
            return;
        }
        nVarQ.qg();
    }
}
