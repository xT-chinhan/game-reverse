package com.byazt.ges;

import android.content.Context;
import com.byazt.nf.rv;
import com.byazt.tk.k;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1374, 5})
public class q {
    public static boolean n() {
        try {
            if (com.byazt.vyf.s.cy().wo()) {
                return true;
            }
            Context context = rv.getContext();
            if (context.getApplicationInfo() != null && (context.getApplicationInfo().flags & 2) != 0) {
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static void n(com.byazt.zq.n nVar) {
        try {
            if (!nVar.fs() || k.n()) {
                return;
            }
            System.currentTimeMillis();
            if (Boolean.parseBoolean(new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop debug.ttcsj.debugmode").getInputStream())).readLine())) {
                k.qg();
                com.byazt.nl.qg.n();
                com.byazt.lq.s.qg();
                com.byazt.gks.qg.n().n(true);
            }
        } catch (Exception unused) {
        }
    }
}
