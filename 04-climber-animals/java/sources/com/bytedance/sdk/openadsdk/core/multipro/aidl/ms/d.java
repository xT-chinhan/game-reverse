package com.bytedance.sdk.openadsdk.core.multipro.aidl.ms;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.core.u;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class d extends ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static HashMap<String, RemoteCallbackList<u>> f2891ms = new HashMap<>();
    private static volatile d xr;

    public static d xr() {
        if (xr == null) {
            synchronized (d.class) {
                if (xr == null) {
                    xr = new d();
                }
            }
        }
        return xr;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.ms.ms, com.bytedance.sdk.openadsdk.core.ao
    public void ms(String str, u uVar) throws RemoteException {
        if (uVar == null) {
            return;
        }
        RemoteCallbackList<u> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(uVar);
        f2891ms.put(str, remoteCallbackList);
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.ms.ms, com.bytedance.sdk.openadsdk.core.ao
    public void xr(String str, String str2) throws RemoteException {
        RemoteCallbackList<u> remoteCallbackListRemove = f2891ms.remove(str);
        if (remoteCallbackListRemove == null) {
            return;
        }
        int iBeginBroadcast = remoteCallbackListRemove.beginBroadcast();
        for (int i = 0; i < iBeginBroadcast; i++) {
            u uVar = (u) remoteCallbackListRemove.getBroadcastItem(i);
            if (uVar != null) {
                if (str2 == null) {
                    uVar.ms();
                } else {
                    uVar.ms(str2);
                }
            }
        }
        remoteCallbackListRemove.finishBroadcast();
        remoteCallbackListRemove.kill();
    }
}
