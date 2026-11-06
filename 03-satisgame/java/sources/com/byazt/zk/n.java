package com.byazt.zk;

import android.content.Context;
import android.content.IntentFilter;
import com.byazt.gc.AbsServerManager;
import com.byazt.tk.k;
import com.byazt.vgx.w;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2285, 19})
public class n {
    public static volatile n n;
    public String qg = "";

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

    public void registerReceiver(Context context) {
        MiniAppBroadcastReceiver miniAppBroadcastReceiver = new MiniAppBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter("com.byted.pma.PMA_DATA");
        intentFilter.addDataScheme(AbsServerManager.PACKAGE_QUERY_BINDER);
        intentFilter.addDataAuthority(context.getPackageName(), null);
        try {
            w.n(context, miniAppBroadcastReceiver, intentFilter, w.t(), null, 4);
        } catch (Throwable th) {
            k.qg("MiniAppManager", "register BroadcastReceiver : " + th.getMessage());
        }
    }

    public String qg() {
        return this.qg;
    }

    public void n(String str) {
        this.qg = str;
    }
}
