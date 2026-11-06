package com.bytedance.sdk.openadsdk.core.multipro.aidl.ms;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.core.zb;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static HashMap<String, RemoteCallbackList<zb>> f2889ms = new HashMap<>();
    private static volatile ah xr;

    public static ah xr() {
        if (xr == null) {
            synchronized (ah.class) {
                if (xr == null) {
                    xr = new ah();
                }
            }
        }
        return xr;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.ms.ms, com.bytedance.sdk.openadsdk.core.ao
    public void ms(String str, zb zbVar) throws RemoteException {
        if (zbVar == null) {
            return;
        }
        RemoteCallbackList<zb> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(zbVar);
        f2889ms.put(str, remoteCallbackList);
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.ms.ms, com.bytedance.sdk.openadsdk.core.ao
    public void ms(String str, int i) throws RemoteException {
        RemoteCallbackList<zb> remoteCallbackListRemove = f2889ms.remove(str);
        if (remoteCallbackListRemove == null) {
            return;
        }
        int iBeginBroadcast = remoteCallbackListRemove.beginBroadcast();
        for (int i2 = 0; i2 < iBeginBroadcast; i2++) {
            zb zbVar = (zb) remoteCallbackListRemove.getBroadcastItem(i2);
            if (zbVar != null) {
                if (i == 1) {
                    zbVar.ms();
                } else if (i == 2) {
                    zbVar.xr();
                } else if (i == 3) {
                    zbVar.ah();
                } else {
                    zbVar.ah();
                }
            }
        }
        remoteCallbackListRemove.finishBroadcast();
        remoteCallbackListRemove.kill();
    }
}
