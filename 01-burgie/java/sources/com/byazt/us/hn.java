package com.byazt.us;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.byazt.sd.w;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 434, 20})
public class hn extends pr {
    public static volatile hn hw;
    public static HashMap<String, RemoteCallbackList<w>> pr = new HashMap<>();

    public static hn hw() {
        if (hw == null) {
            synchronized (hn.class) {
                if (hw == null) {
                    hw = new hn();
                }
            }
        }
        return hw;
    }

    @Override // com.byazt.us.pr, com.byazt.sd.g
    public void pr(String str, w wVar) throws RemoteException {
        if (wVar == null) {
            return;
        }
        RemoteCallbackList<w> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(wVar);
        pr.put(str, remoteCallbackList);
    }

    @Override // com.byazt.us.pr, com.byazt.sd.g
    public void pr(String str, int i) throws RemoteException {
        RemoteCallbackList<w> remoteCallbackListRemove = pr.remove(str);
        if (remoteCallbackListRemove == null) {
            return;
        }
        int iBeginBroadcast = remoteCallbackListRemove.beginBroadcast();
        for (int i2 = 0; i2 < iBeginBroadcast; i2++) {
            w wVar = (w) remoteCallbackListRemove.getBroadcastItem(i2);
            if (wVar != null) {
                switch (i) {
                    case 1:
                        wVar.pr();
                        break;
                    case 2:
                        wVar.hw();
                        break;
                    case 3:
                        wVar.hn();
                        break;
                    default:
                        wVar.hn();
                        break;
                }
            }
        }
        remoteCallbackListRemove.finishBroadcast();
        remoteCallbackListRemove.kill();
    }
}
