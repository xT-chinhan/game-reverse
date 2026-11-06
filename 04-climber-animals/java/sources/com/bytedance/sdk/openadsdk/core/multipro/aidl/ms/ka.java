package com.bytedance.sdk.openadsdk.core.multipro.aidl.ms;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.ub;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ka extends ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static Map<String, RemoteCallbackList<ub>> f2892ms = Collections.synchronizedMap(new HashMap());
    private static volatile ka xr;

    public static ka xr() {
        if (xr == null) {
            synchronized (ka.class) {
                if (xr == null) {
                    xr = new ka();
                }
            }
        }
        return xr;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.ms.ms, com.bytedance.sdk.openadsdk.core.ao
    public synchronized void ms(String str, ub ubVar) throws RemoteException {
        RemoteCallbackList<ub> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(ubVar);
        f2892ms.put(str, remoteCallbackList);
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.ms.ms, com.bytedance.sdk.openadsdk.core.ao
    public void ms(String str, String str2) throws RemoteException {
        ah(str, str2);
    }

    private synchronized void ah(String str, String str2) {
        RemoteCallbackList<ub> remoteCallbackListRemove;
        try {
            if (f2892ms != null) {
                if ("recycleRes".equals(str2)) {
                    remoteCallbackListRemove = f2892ms.remove(str);
                } else {
                    remoteCallbackListRemove = f2892ms.get(str);
                }
                if (remoteCallbackListRemove != null) {
                    int iBeginBroadcast = remoteCallbackListRemove.beginBroadcast();
                    for (int i = 0; i < iBeginBroadcast; i++) {
                        try {
                            ub ubVar = (ub) remoteCallbackListRemove.getBroadcastItem(i);
                            if (ubVar != null) {
                                if ("onAdShow".equals(str2)) {
                                    ubVar.xr();
                                } else if ("onAdClose".equals(str2)) {
                                    ubVar.d();
                                } else if ("onVideoComplete".equals(str2)) {
                                    ubVar.ka();
                                } else if ("onSkippedVideo".equals(str2)) {
                                    ubVar.c();
                                } else if ("onAdVideoBarClick".equals(str2)) {
                                    ubVar.ah();
                                } else if ("recycleRes".equals(str2)) {
                                    ubVar.ms();
                                }
                            }
                        } catch (Throwable th) {
                            sl.ah("MultiProcess", "fullScreen2 method " + str2 + " throws Exception :", th);
                        }
                    }
                    remoteCallbackListRemove.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remoteCallbackListRemove.kill();
                    }
                }
            }
        } catch (Throwable th2) {
            sl.ah("MultiProcess", "fullScreen1 method " + str2 + " throws Exception :", th2);
        }
    }
}
