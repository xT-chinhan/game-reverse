package com.byazt.us;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.byazt.sd.k;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 434, 121})
public class x extends pr {
    public static volatile x hw;
    public static HashMap<String, RemoteCallbackList<k>> pr = new HashMap<>();

    public static x hw() {
        if (hw == null) {
            synchronized (x.class) {
                if (hw == null) {
                    hw = new x();
                }
            }
        }
        return hw;
    }

    @Override // com.byazt.us.pr, com.byazt.sd.g
    public void pr(String str, k kVar) throws RemoteException {
        if (kVar == null) {
            return;
        }
        RemoteCallbackList<k> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(kVar);
        pr.put(str, remoteCallbackList);
    }

    @Override // com.byazt.us.pr, com.byazt.sd.g
    public void pr(String str, String str2) throws RemoteException {
        RemoteCallbackList<k> remoteCallbackListRemove = pr.remove(str);
        if (remoteCallbackListRemove == null) {
            return;
        }
        int iBeginBroadcast = remoteCallbackListRemove.beginBroadcast();
        for (int i = 0; i < iBeginBroadcast; i++) {
            k kVar = (k) remoteCallbackListRemove.getBroadcastItem(i);
            if (kVar != null) {
                if (str2 == null) {
                    kVar.pr();
                } else {
                    kVar.pr(str2);
                }
            }
        }
        remoteCallbackListRemove.finishBroadcast();
        remoteCallbackListRemove.kill();
    }
}
