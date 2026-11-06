package com.byazt.us;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.byazt.ca.ho;
import com.byazt.sd.yb;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 434, 13})
public class hw extends pr {
    public static volatile hw hw;
    public static Map<String, RemoteCallbackList<yb>> pr = Collections.synchronizedMap(new HashMap());

    public static hw hw() {
        if (hw == null) {
            synchronized (hw.class) {
                if (hw == null) {
                    hw = new hw();
                }
            }
        }
        return hw;
    }

    @Override // com.byazt.us.pr, com.byazt.sd.g
    public void pr(String str, yb ybVar) throws RemoteException {
        RemoteCallbackList<yb> remoteCallbackList = pr.get(str);
        if (remoteCallbackList == null) {
            remoteCallbackList = new RemoteCallbackList<>();
        }
        remoteCallbackList.register(ybVar);
        pr.put(str, remoteCallbackList);
        ho.hw("DMLibManager", "aidl registerTTAppDownloadListener, materialMd5:".concat(String.valueOf(str)));
        ho.hw("DMLibManager", "aidl registerTTAppDownloadListener, mListenerMap size:" + pr.size());
    }

    @Override // com.byazt.us.pr, com.byazt.sd.g
    public void hw(String str, yb ybVar) throws RemoteException {
        Map<String, RemoteCallbackList<yb>> map = pr;
        if (map == null) {
            ho.hw("DMLibManager", "aidl unregisterTTAppDownloadListener mListenerMap = null, materialMd5:".concat(String.valueOf(str)));
            return;
        }
        RemoteCallbackList<yb> remoteCallbackListRemove = map.remove(str);
        if (remoteCallbackListRemove == null) {
            ho.hw("DMLibManager", "aidl unregisterTTAppDownloadListener cbs = null, materialMd5:".concat(String.valueOf(str)));
            return;
        }
        pr(remoteCallbackListRemove);
        ho.hw("DMLibManager", "aidl unregisterTTAppDownloadListener, materialMd5:".concat(String.valueOf(str)));
        ho.hw("DMLibManager", "aidl unregisterTTAppDownloadListener, mListenerMap size:" + pr.size());
    }

    @Override // com.byazt.us.pr, com.byazt.sd.g
    public void pr(String str, String str2, long j, long j2, String str3, String str4) throws RemoteException {
        hw(str, str2, j, j2, str3, str4);
    }

    private synchronized void hw(String str, String str2, long j, long j2, String str3, String str4) {
        try {
            if (pr == null) {
                return;
            }
            if ("recycleRes".equals(str2)) {
                pr(pr.remove(str));
                ho.hw("DMLibManager", "aidl executeMultiProcessAppDownloadCallBack recycle res, materialMd5:".concat(String.valueOf(str)));
                ho.hw("DMLibManager", "aidl executeMultiProcessAppDownloadCallBack recycle res, mListenerMap sizee:" + pr.size());
                return;
            }
            RemoteCallbackList<yb> remoteCallbackList = pr.get(str);
            if (remoteCallbackList != null) {
                int iBeginBroadcast = remoteCallbackList.beginBroadcast();
                for (int i = 0; i < iBeginBroadcast; i++) {
                    try {
                        yb ybVar = (yb) remoteCallbackList.getBroadcastItem(i);
                        if (ybVar != null) {
                            if ("onIdle".equals(str2)) {
                                ybVar.pr();
                            } else if ("onDownloadActive".equals(str2)) {
                                ybVar.pr(j, j2, str3, str4);
                            } else if ("onDownloadPaused".equals(str2)) {
                                ybVar.hw(j, j2, str3, str4);
                            } else if ("onDownloadFailed".equals(str2)) {
                                ybVar.hn(j, j2, str3, str4);
                            } else if ("onDownloadFinished".equals(str2)) {
                                try {
                                    ybVar.pr(j, str3, str4);
                                } catch (Throwable th) {
                                    th = th;
                                    ho.pr("MultiProcess", "AppDownloadListenerManagerImpl MultiProcess1: " + str2 + " throws Exception :", th);
                                }
                            } else if ("onInstalled".equals(str2)) {
                                ybVar.pr(str3, str4);
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                remoteCallbackList.finishBroadcast();
            }
        } catch (Throwable th3) {
            ho.pr("MultiProcess", "AppDownloadListenerManagerImpl MultiProcess2: " + str2 + " throws Exception :", th3);
        }
    }

    private void pr(RemoteCallbackList<yb> remoteCallbackList) {
        if (remoteCallbackList != null) {
            try {
                int iBeginBroadcast = remoteCallbackList.beginBroadcast();
                for (int i = 0; i < iBeginBroadcast; i++) {
                    try {
                        yb ybVar = (yb) remoteCallbackList.getBroadcastItem(i);
                        if (ybVar != null) {
                            ((com.byazt.ku.uc) ybVar).hn();
                        }
                    } catch (Throwable th) {
                        ho.pr("MultiProcess", "recycleRes1 throw Exception : ", th);
                    }
                }
                remoteCallbackList.finishBroadcast();
                remoteCallbackList.kill();
            } catch (Throwable th2) {
                ho.pr("MultiProcess", "recycleRes2 throw Exception : ", th2);
            }
        }
    }
}
