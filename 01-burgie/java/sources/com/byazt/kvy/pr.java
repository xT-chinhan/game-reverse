package com.byazt.kvy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.byazt.wf.vk;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1921, 37})
public class pr {
    public static volatile pr pr;
    public SQLiteDatabase hn;
    public com.byazt.dn.hw hw;

    private pr() {
    }

    public static pr pr() {
        if (pr == null) {
            synchronized (pr.class) {
                if (pr == null) {
                    pr = new pr();
                }
            }
        }
        return pr;
    }

    public void pr(Context context) {
        try {
            this.hn = new hw(context).getWritableDatabase();
        } catch (Throwable th) {
            vk.hw(th);
        }
        this.hw = new com.byazt.dn.hw();
    }

    public synchronized void pr(com.byazt.yf.pr prVar) {
        com.byazt.dn.hw hwVar = this.hw;
        if (hwVar != null) {
            hwVar.insert(this.hn, prVar);
        }
    }

    public synchronized boolean pr(String str) {
        com.byazt.dn.hw hwVar = this.hw;
        if (hwVar != null) {
            return hwVar.pr(this.hn, str);
        }
        return false;
    }
}
