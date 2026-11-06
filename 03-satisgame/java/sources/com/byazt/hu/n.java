package com.byazt.hu;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.byazt.yw.tj;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 793, 19})
public class n {
    public static volatile n n;
    public com.byazt.hq.qg qg;
    public SQLiteDatabase s;

    private n() {
    }

    public static n n() {
        if (n == null) {
            synchronized (n.class) {
                if (n == null) {
                    n = new n();
                }
            }
        }
        return n;
    }

    public void n(Context context) {
        try {
            this.s = new qg(context).getWritableDatabase();
        } catch (Throwable th) {
            tj.qg(th);
        }
        this.qg = new com.byazt.hq.qg();
    }

    public synchronized void n(com.byazt.da.n nVar) {
        com.byazt.hq.qg qgVar = this.qg;
        if (qgVar != null) {
            qgVar.insert(this.s, nVar);
        }
    }

    public synchronized boolean n(String str) {
        com.byazt.hq.qg qgVar = this.qg;
        if (qgVar == null) {
            return false;
        }
        return qgVar.n(this.s, str);
    }
}
