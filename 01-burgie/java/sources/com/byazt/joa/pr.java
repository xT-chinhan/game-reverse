package com.byazt.joa;

import android.os.Bundle;
import android.os.RemoteException;
import com.byazt.ku.c;
import com.byazt.ku.x;
import com.byazt.sd.a;
import com.byazt.sd.g;
import com.byazt.xlm.fw;
import com.byazt.xlm.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_STREAM_SESSION_ID, 37})
public class pr {
    public static HashMap<Integer, g> pr = new HashMap<>();
    public static final ExecutorService hw = com.byazt.xlm.hw.pr(new zo("RewardFullCallback"));

    public static void pr(final int i, final String str, final String str2, final Bundle bundle) {
        hw.execute(new fw("executeMultiProcessCallback") { // from class: com.byazt.joa.pr.1
            @Override // java.lang.Runnable
            public void run() {
                g gVarPr = pr.pr.get(Integer.valueOf(i));
                if (gVarPr == null) {
                    gVarPr = com.byazt.us.pr.pr(com.byazt.gt.pr.pr(a.getContext()).pr(i));
                    pr.pr.put(Integer.valueOf(i), gVarPr);
                }
                if (gVarPr == null) {
                }
                try {
                    switch (i) {
                        case 0:
                            gVarPr.pr(str, str2, bundle);
                            break;
                        case 1:
                            gVarPr.hw(str, str2, bundle);
                            break;
                        case 5:
                            gVarPr.hn(str, str2, bundle);
                            break;
                        default:
                            break;
                    }
                } catch (RemoteException e) {
                }
            }
        });
    }

    public static void pr(final String str, final com.byazt.yg.pr prVar) {
        hw.execute(new fw("registerMultiProcessListener") { // from class: com.byazt.joa.pr.2
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.gt.pr prVarPr = com.byazt.gt.pr.pr(a.getContext());
                if (prVar != null) {
                    c cVar = new c(prVar);
                    g gVarPr = com.byazt.us.fw.pr(prVarPr.pr(0));
                    if (gVarPr != null) {
                        try {
                            gVarPr.pr(str, cVar);
                        } catch (RemoteException e) {
                        }
                    }
                }
            }
        });
    }

    public static void pr(final String str, final com.byazt.yg.hw hwVar) {
        hw.execute(new fw("registerMultiProcessListener") { // from class: com.byazt.joa.pr.3
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.gt.pr prVarPr = com.byazt.gt.pr.pr(a.getContext());
                if (hwVar != null) {
                    x xVar = new x(hwVar);
                    g gVarPr = com.byazt.us.fw.pr(prVarPr.pr(5));
                    if (gVarPr != null) {
                        try {
                            gVarPr.pr(str, xVar);
                        } catch (RemoteException e) {
                        }
                    }
                }
            }
        });
    }

    public static void pr(final String str, final com.byazt.rf.pr prVar) {
        hw.execute(new fw("registerMultiProcessListener") { // from class: com.byazt.joa.pr.4
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.gt.pr prVarPr = com.byazt.gt.pr.pr(a.getContext());
                if (prVar != null) {
                    com.byazt.ku.hn hnVar = new com.byazt.ku.hn(prVar);
                    g gVarPr = com.byazt.us.c.pr(prVarPr.pr(1));
                    if (gVarPr != null) {
                        try {
                            gVarPr.pr(str, hnVar);
                        } catch (RemoteException e) {
                        }
                    }
                }
            }
        });
    }
}
