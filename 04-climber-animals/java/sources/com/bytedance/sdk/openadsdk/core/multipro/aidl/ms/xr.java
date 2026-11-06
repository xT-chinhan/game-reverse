package com.bytedance.sdk.openadsdk.core.multipro.aidl.ms;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.y;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static Map<String, RemoteCallbackList<y>> f2893ms = Collections.synchronizedMap(new HashMap());
    private static volatile xr xr;

    public static xr xr() {
        if (xr == null) {
            synchronized (xr.class) {
                if (xr == null) {
                    xr = new xr();
                }
            }
        }
        return xr;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.ms.ms, com.bytedance.sdk.openadsdk.core.ao
    public void ms(String str, y yVar) throws RemoteException {
        RemoteCallbackList<y> remoteCallbackList = f2893ms.get(str);
        if (remoteCallbackList == null) {
            remoteCallbackList = new RemoteCallbackList<>();
        }
        remoteCallbackList.register(yVar);
        f2893ms.put(str, remoteCallbackList);
        sl.d("DMLibManager", "aidl registerTTAppDownloadListener, materialMd5:".concat(String.valueOf(str)));
        sl.d("DMLibManager", "aidl registerTTAppDownloadListener, mListenerMap size:" + f2893ms.size());
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.ms.ms, com.bytedance.sdk.openadsdk.core.ao
    public void xr(String str, y yVar) throws RemoteException {
        Map<String, RemoteCallbackList<y>> map = f2893ms;
        if (map == null) {
            sl.d("DMLibManager", "aidl unregisterTTAppDownloadListener mListenerMap = null, materialMd5:".concat(String.valueOf(str)));
            return;
        }
        RemoteCallbackList<y> remoteCallbackListRemove = map.remove(str);
        if (remoteCallbackListRemove == null) {
            sl.d("DMLibManager", "aidl unregisterTTAppDownloadListener cbs = null, materialMd5:".concat(String.valueOf(str)));
            return;
        }
        ms(remoteCallbackListRemove);
        sl.d("DMLibManager", "aidl unregisterTTAppDownloadListener, materialMd5:".concat(String.valueOf(str)));
        sl.d("DMLibManager", "aidl unregisterTTAppDownloadListener, mListenerMap size:" + f2893ms.size());
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.ms.ms, com.bytedance.sdk.openadsdk.core.ao
    public void ms(String str, String str2, long j, long j2, String str3, String str4) throws RemoteException {
        xr(str, str2, j, j2, str3, str4);
    }

    private synchronized void xr(String str, String str2, long j, long j2, String str3, String str4) {
        try {
            if (f2893ms == null) {
                return;
            }
            if ("recycleRes".equals(str2)) {
                ms(f2893ms.remove(str));
                sl.d("DMLibManager", "aidl executeMultiProcessAppDownloadCallBack recycle res, materialMd5:".concat(String.valueOf(str)));
                sl.d("DMLibManager", "aidl executeMultiProcessAppDownloadCallBack recycle res, mListenerMap sizee:" + f2893ms.size());
                return;
            }
            RemoteCallbackList<y> remoteCallbackList = f2893ms.get(str);
            if (remoteCallbackList != null) {
                int iBeginBroadcast = remoteCallbackList.beginBroadcast();
                for (int i = 0; i < iBeginBroadcast; i++) {
                    try {
                        y yVar = (y) remoteCallbackList.getBroadcastItem(i);
                        if (yVar != null) {
                            if ("onIdle".equals(str2)) {
                                yVar.ms();
                            } else if ("onDownloadActive".equals(str2)) {
                                yVar.ms(j, j2, str3, str4);
                            } else if ("onDownloadPaused".equals(str2)) {
                                yVar.xr(j, j2, str3, str4);
                            } else if ("onDownloadFailed".equals(str2)) {
                                yVar.ah(j, j2, str3, str4);
                            } else if ("onDownloadFinished".equals(str2)) {
                                try {
                                    yVar.ms(j, str3, str4);
                                } catch (Throwable th) {
                                    th = th;
                                    sl.ah("MultiProcess", "AppDownloadListenerManagerImpl MultiProcess1: " + str2 + " throws Exception :", th);
                                }
                            } else if ("onInstalled".equals(str2)) {
                                yVar.ms(str3, str4);
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                remoteCallbackList.finishBroadcast();
            }
        } catch (Throwable th3) {
            sl.ah("MultiProcess", "AppDownloadListenerManagerImpl MultiProcess2: " + str2 + " throws Exception :", th3);
        }
    }

    private void ms(RemoteCallbackList<y> remoteCallbackList) {
        if (remoteCallbackList != null) {
            try {
                int iBeginBroadcast = remoteCallbackList.beginBroadcast();
                for (int i = 0; i < iBeginBroadcast; i++) {
                    try {
                        y yVar = (y) remoteCallbackList.getBroadcastItem(i);
                        if (yVar != null) {
                            ((com.bytedance.sdk.openadsdk.core.multipro.aidl.xr.c) yVar).ah();
                        }
                    } catch (Throwable th) {
                        sl.ah("MultiProcess", "recycleRes1 throw Exception : ", th);
                    }
                }
                remoteCallbackList.finishBroadcast();
                remoteCallbackList.kill();
            } catch (Throwable th2) {
                sl.ah("MultiProcess", "recycleRes2 throw Exception : ", th2);
            }
        }
    }
}
