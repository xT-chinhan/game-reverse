package com.byazt.ptd;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 996, 8})
public class s extends n {
    public static HashMap<String, RemoteCallbackList<com.byazt.nf.qg>> n = new HashMap<>();
    public static volatile s qg;

    public static s qg() {
        if (qg == null) {
            synchronized (s.class) {
                if (qg == null) {
                    qg = new s();
                }
            }
        }
        return qg;
    }

    @Override // com.byazt.ptd.n, com.byazt.nf.l
    public void n(String str, com.byazt.nf.qg qgVar) throws RemoteException {
        if (qgVar == null) {
            return;
        }
        RemoteCallbackList<com.byazt.nf.qg> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(qgVar);
        n.put(str, remoteCallbackList);
    }

    @Override // com.byazt.ptd.n, com.byazt.nf.l
    public void n(String str, int i) throws RemoteException {
        RemoteCallbackList<com.byazt.nf.qg> remoteCallbackListRemove = n.remove(str);
        if (remoteCallbackListRemove == null) {
            return;
        }
        int iBeginBroadcast = remoteCallbackListRemove.beginBroadcast();
        for (int i2 = 0; i2 < iBeginBroadcast; i2++) {
            com.byazt.nf.qg qgVar = (com.byazt.nf.qg) remoteCallbackListRemove.getBroadcastItem(i2);
            if (qgVar != null) {
                if (i == 1) {
                    qgVar.n();
                } else if (i == 2) {
                    qgVar.qg();
                } else if (i == 3) {
                    qgVar.s();
                } else {
                    qgVar.s();
                }
            }
        }
        remoteCallbackListRemove.finishBroadcast();
        remoteCallbackListRemove.kill();
    }
}
