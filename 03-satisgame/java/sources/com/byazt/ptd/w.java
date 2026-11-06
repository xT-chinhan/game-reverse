package com.byazt.ptd;

import android.os.Bundle;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 996, 13})
public class w extends n {
    public static final Map<String, RemoteCallbackList<com.byazt.nf.w>> n = Collections.synchronizedMap(new HashMap());
    public static volatile w qg;

    public static w qg() {
        if (qg == null) {
            synchronized (w.class) {
                if (qg == null) {
                    qg = new w();
                }
            }
        }
        return qg;
    }

    @Override // com.byazt.ptd.n, com.byazt.nf.l
    public void n(String str, com.byazt.nf.w wVar) throws RemoteException {
        RemoteCallbackList<com.byazt.nf.w> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(wVar);
        n.put(str, remoteCallbackList);
    }

    @Override // com.byazt.ptd.n, com.byazt.nf.l
    public Bundle s(String str, String str2, Bundle bundle) throws RemoteException {
        return q(str, str2, bundle);
    }

    private synchronized Bundle q(String str, String str2, Bundle bundle) {
        Bundle bundle2;
        RemoteCallbackList<com.byazt.nf.w> remoteCallbackListRemove;
        bundle2 = new Bundle();
        try {
            Map<String, RemoteCallbackList<com.byazt.nf.w>> map = n;
            if (map != null) {
                if ("recycleRes".equals(str2)) {
                    remoteCallbackListRemove = map.remove(str);
                } else {
                    remoteCallbackListRemove = map.get(str);
                }
                if (remoteCallbackListRemove != null) {
                    int iBeginBroadcast = remoteCallbackListRemove.beginBroadcast();
                    for (int i = 0; i < iBeginBroadcast; i++) {
                        try {
                            com.byazt.nf.w wVar = (com.byazt.nf.w) remoteCallbackListRemove.getBroadcastItem(i);
                            if (wVar != null && "getPlayAgainCondition".equals(str2)) {
                                bundle2 = wVar.n(bundle.getInt("callback_extra_key_next_play_again_count"));
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    remoteCallbackListRemove.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remoteCallbackListRemove.kill();
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        return bundle2;
    }
}
