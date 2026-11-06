package com.byazt.ptd;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 996, 5})
public class q extends n {
    public static HashMap<String, RemoteCallbackList<com.byazt.nf.s>> n = new HashMap<>();
    public static volatile q qg;

    public static q qg() {
        if (qg == null) {
            synchronized (q.class) {
                if (qg == null) {
                    qg = new q();
                }
            }
        }
        return qg;
    }

    @Override // com.byazt.ptd.n, com.byazt.nf.l
    public void n(String str, com.byazt.nf.s sVar) throws RemoteException {
        if (sVar == null) {
            return;
        }
        RemoteCallbackList<com.byazt.nf.s> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(sVar);
        n.put(str, remoteCallbackList);
    }

    @Override // com.byazt.ptd.n, com.byazt.nf.l
    public void n(String str, String str2) throws RemoteException {
        RemoteCallbackList<com.byazt.nf.s> remoteCallbackListRemove = n.remove(str);
        if (remoteCallbackListRemove == null) {
            return;
        }
        int iBeginBroadcast = remoteCallbackListRemove.beginBroadcast();
        for (int i = 0; i < iBeginBroadcast; i++) {
            com.byazt.nf.s sVar = (com.byazt.nf.s) remoteCallbackListRemove.getBroadcastItem(i);
            if (sVar != null) {
                if (str2 == null) {
                    sVar.n();
                } else {
                    sVar.n(str2);
                }
            }
        }
        remoteCallbackListRemove.finishBroadcast();
        remoteCallbackListRemove.kill();
    }
}
