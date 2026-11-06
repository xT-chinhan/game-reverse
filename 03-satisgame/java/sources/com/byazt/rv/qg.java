package com.byazt.rv;

import android.os.Bundle;
import android.os.RemoteException;
import com.byazt.nf.rv;
import com.byazt.qit.fs;
import com.byazt.qit.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE, 26})
public class qg {
    public static HashMap<Integer, com.byazt.nf.l> n = new HashMap<>();
    public static final ExecutorService qg = com.byazt.qit.qg.n(new fs("RewardFullCallback"));

    public static void n(final int i, final String str, final String str2, final Bundle bundle) {
        qg.execute(new x("executeMultiProcessCallback") { // from class: com.byazt.rv.qg.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.nf.l lVarN = qg.n.get(Integer.valueOf(i));
                if (lVarN == null) {
                    lVarN = com.byazt.ptd.n.n(com.byazt.prx.n.n(rv.getContext()).n(i));
                    qg.n.put(Integer.valueOf(i), lVarN);
                }
                if (lVarN == null) {
                    return;
                }
                try {
                    int i2 = i;
                    if (i2 == 0) {
                        lVarN.n(str, str2, bundle);
                    } else if (i2 == 1) {
                        lVarN.qg(str, str2, bundle);
                    } else {
                        if (i2 != 5) {
                            return;
                        }
                        lVarN.s(str, str2, bundle);
                    }
                } catch (RemoteException unused) {
                }
            }
        });
    }

    public static void n(final String str, final com.byazt.tmn.n nVar) {
        qg.execute(new x("registerMultiProcessListener") { // from class: com.byazt.rv.qg.2
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.prx.n nVarN = com.byazt.prx.n.n(rv.getContext());
                if (nVar != null) {
                    com.byazt.ca.l lVar = new com.byazt.ca.l(nVar);
                    com.byazt.nf.l lVarN = com.byazt.ptd.x.n(nVarN.n(0));
                    if (lVarN != null) {
                        try {
                            lVarN.n(str, lVar);
                        } catch (RemoteException unused) {
                        }
                    }
                }
            }
        });
    }

    public static void n(final String str, final com.byazt.tmn.qg qgVar) {
        qg.execute(new x("registerMultiProcessListener") { // from class: com.byazt.rv.qg.3
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.prx.n nVarN = com.byazt.prx.n.n(rv.getContext());
                if (qgVar != null) {
                    com.byazt.ca.q qVar = new com.byazt.ca.q(qgVar);
                    com.byazt.nf.l lVarN = com.byazt.ptd.x.n(nVarN.n(5));
                    if (lVarN != null) {
                        try {
                            lVarN.n(str, qVar);
                        } catch (RemoteException unused) {
                        }
                    }
                }
            }
        });
    }

    public static void n(final String str, final com.byazt.rzx.n nVar) {
        qg.execute(new x("registerMultiProcessListener") { // from class: com.byazt.rv.qg.4
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.prx.n nVarN = com.byazt.prx.n.n(rv.getContext());
                if (nVar != null) {
                    com.byazt.ca.s sVar = new com.byazt.ca.s(nVar);
                    com.byazt.nf.l lVarN = com.byazt.ptd.l.n(nVarN.n(1));
                    if (lVarN != null) {
                        try {
                            lVarN.n(str, sVar);
                        } catch (RemoteException unused) {
                        }
                    }
                }
            }
        });
    }
}
