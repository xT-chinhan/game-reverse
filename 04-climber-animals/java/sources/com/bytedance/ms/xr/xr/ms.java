package com.bytedance.ms.xr.xr;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.ms.xr.x.ch;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile ms f599ms;
    private SQLiteDatabase ah;
    private com.bytedance.ms.xr.xr.xr.xr xr;

    private ms() {
    }

    public static ms ms() {
        if (f599ms == null) {
            synchronized (ms.class) {
                if (f599ms == null) {
                    f599ms = new ms();
                }
            }
        }
        return f599ms;
    }

    public void ms(Context context) {
        try {
            this.ah = new xr(context).getWritableDatabase();
        } catch (Throwable th) {
            ch.xr(th);
        }
        this.xr = new com.bytedance.ms.xr.xr.xr.xr();
    }

    public synchronized void ms(com.bytedance.ms.xr.xr.ms.ms msVar) {
        com.bytedance.ms.xr.xr.xr.xr xrVar = this.xr;
        if (xrVar != null) {
            xrVar.insert(this.ah, msVar);
        }
    }

    public synchronized boolean ms(String str) {
        com.bytedance.ms.xr.xr.xr.xr xrVar = this.xr;
        if (xrVar == null) {
            return false;
        }
        return xrVar.ms(this.ah, str);
    }
}
