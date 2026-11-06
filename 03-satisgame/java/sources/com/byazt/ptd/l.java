package com.byazt.ptd;

import android.os.Bundle;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.byazt.tk.k;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 996, 18})
public class l extends n {
    public static Map<String, RemoteCallbackList<com.byazt.nf.q>> n = Collections.synchronizedMap(new HashMap());
    public static volatile l qg;

    public static l qg() {
        if (qg == null) {
            synchronized (l.class) {
                if (qg == null) {
                    qg = new l();
                }
            }
        }
        return qg;
    }

    @Override // com.byazt.ptd.n, com.byazt.nf.l
    public synchronized void n(String str, com.byazt.nf.q qVar) throws RemoteException {
        RemoteCallbackList<com.byazt.nf.q> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(qVar);
        n.put(str, remoteCallbackList);
    }

    @Override // com.byazt.ptd.n, com.byazt.nf.l
    public void qg(String str, String str2, Bundle bundle) throws RemoteException {
        q(str, str2, bundle);
    }

    private synchronized void q(String str, String str2, Bundle bundle) {
        RemoteCallbackList<com.byazt.nf.q> remoteCallbackListRemove;
        try {
            if (n != null) {
                if ("recycleRes".equals(str2)) {
                    remoteCallbackListRemove = n.remove(str);
                } else {
                    remoteCallbackListRemove = n.get(str);
                }
                if (remoteCallbackListRemove != null) {
                    int iBeginBroadcast = remoteCallbackListRemove.beginBroadcast();
                    for (int i = 0; i < iBeginBroadcast; i++) {
                        try {
                            com.byazt.nf.q qVar = (com.byazt.nf.q) remoteCallbackListRemove.getBroadcastItem(i);
                            if (qVar != null) {
                                if ("onAdShow".equals(str2)) {
                                    qVar.n(bundle);
                                } else if ("onAdClose".equals(str2)) {
                                    qVar.s(bundle);
                                } else if ("onVideoComplete".equals(str2)) {
                                    qVar.qg();
                                } else if ("onSkippedVideo".equals(str2)) {
                                    qVar.s();
                                } else if ("onAdVideoBarClick".equals(str2)) {
                                    qVar.qg(bundle);
                                } else if ("recycleRes".equals(str2)) {
                                    qVar.n();
                                }
                            }
                        } catch (Throwable th) {
                            k.n("MultiProcess", "fullScreen2 method " + str2 + " throws Exception :", th);
                        }
                    }
                    remoteCallbackListRemove.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remoteCallbackListRemove.kill();
                    }
                }
            }
        } catch (Throwable th2) {
            k.n("MultiProcess", "fullScreen1 method " + str2 + " throws Exception :", th2);
        }
    }
}
