package com.byazt.sq;

import android.content.Context;
import android.content.IntentFilter;
import com.byazt.ca.ho;
import com.byazt.ewn.AbsServerManager;
import com.byazt.wt.ls;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1607, 37})
public class pr {
    public static volatile pr pr;
    public String hw = "";

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

    public void registerReceiver(Context context) {
        MiniAppBroadcastReceiver miniAppBroadcastReceiver = new MiniAppBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter("com.byted.pma.PMA_DATA");
        intentFilter.addDataScheme(AbsServerManager.PACKAGE_QUERY_BINDER);
        intentFilter.addDataAuthority(context.getPackageName(), null);
        try {
            ls.pr(context, miniAppBroadcastReceiver, intentFilter, ls.iu(), null, 4);
        } catch (Throwable th) {
            ho.hw("MiniAppManager", "register BroadcastReceiver : " + th.getMessage());
        }
    }

    public String hw() {
        return this.hw;
    }

    public void pr(String str) {
        this.hw = str;
    }
}
