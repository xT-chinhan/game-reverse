package com.byazt.ptd;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.byazt.nf.fs;
import com.byazt.pmn.DownloadListenerTask;
import com.byazt.tk.k;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 996, 26})
public class qg extends n {
    public static Map<String, RemoteCallbackList<fs>> n = Collections.synchronizedMap(new HashMap());
    public static volatile qg qg;

    public static qg qg() {
        if (qg == null) {
            synchronized (qg.class) {
                if (qg == null) {
                    qg = new qg();
                }
            }
        }
        return qg;
    }

    @Override // com.byazt.ptd.n, com.byazt.nf.l
    public void n(String str, fs fsVar) throws RemoteException {
        RemoteCallbackList<fs> remoteCallbackList = n.get(str);
        if (remoteCallbackList == null) {
            remoteCallbackList = new RemoteCallbackList<>();
        }
        remoteCallbackList.register(fsVar);
        n.put(str, remoteCallbackList);
        k.qg("DMLibManager", "aidl registerTTAppDownloadListener, materialMd5:".concat(String.valueOf(str)));
        k.qg("DMLibManager", "aidl registerTTAppDownloadListener, mListenerMap size:" + n.size());
    }

    @Override // com.byazt.ptd.n, com.byazt.nf.l
    public void qg(String str, fs fsVar) throws RemoteException {
        Map<String, RemoteCallbackList<fs>> map = n;
        if (map == null) {
            k.qg("DMLibManager", "aidl unregisterTTAppDownloadListener mListenerMap = null, materialMd5:".concat(String.valueOf(str)));
            return;
        }
        RemoteCallbackList<fs> remoteCallbackListRemove = map.remove(str);
        if (remoteCallbackListRemove == null) {
            k.qg("DMLibManager", "aidl unregisterTTAppDownloadListener cbs = null, materialMd5:".concat(String.valueOf(str)));
            return;
        }
        n(remoteCallbackListRemove);
        k.qg("DMLibManager", "aidl unregisterTTAppDownloadListener, materialMd5:".concat(String.valueOf(str)));
        k.qg("DMLibManager", "aidl unregisterTTAppDownloadListener, mListenerMap size:" + n.size());
    }

    @Override // com.byazt.ptd.n, com.byazt.nf.l
    public void n(String str, String str2, long j, long j2, String str3, String str4) throws RemoteException {
        qg(str, str2, j, j2, str3, str4);
    }

    private synchronized void qg(String str, String str2, long j, long j2, String str3, String str4) {
        try {
            if (n == null) {
                return;
            }
            if ("recycleRes".equals(str2)) {
                n(n.remove(str));
                k.qg("DMLibManager", "aidl executeMultiProcessAppDownloadCallBack recycle res, materialMd5:".concat(String.valueOf(str)));
                k.qg("DMLibManager", "aidl executeMultiProcessAppDownloadCallBack recycle res, mListenerMap sizee:" + n.size());
                return;
            }
            RemoteCallbackList<fs> remoteCallbackList = n.get(str);
            if (remoteCallbackList != null) {
                int iBeginBroadcast = remoteCallbackList.beginBroadcast();
                for (int i = 0; i < iBeginBroadcast; i++) {
                    try {
                        fs fsVar = (fs) remoteCallbackList.getBroadcastItem(i);
                        if (fsVar != null) {
                            if (DownloadListenerTask.ON_IDLE.equals(str2)) {
                                fsVar.n();
                            } else if (DownloadListenerTask.ON_DOWNLOAD_ACTIVE.equals(str2)) {
                                fsVar.n(j, j2, str3, str4);
                            } else if (DownloadListenerTask.ON_DOWNLOAD_PAUSED.equals(str2)) {
                                fsVar.qg(j, j2, str3, str4);
                            } else if (DownloadListenerTask.ON_DOWNLOAD_FAILED.equals(str2)) {
                                fsVar.s(j, j2, str3, str4);
                            } else if (DownloadListenerTask.ON_DOWNLOAD_FINISHED.equals(str2)) {
                                try {
                                    fsVar.n(j, str3, str4);
                                } catch (Throwable th) {
                                    th = th;
                                    k.n("MultiProcess", "AppDownloadListenerManagerImpl MultiProcess1: " + str2 + " throws Exception :", th);
                                }
                            } else if (DownloadListenerTask.ON_INSTALLED.equals(str2)) {
                                fsVar.n(str3, str4);
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                remoteCallbackList.finishBroadcast();
            }
        } catch (Throwable th3) {
            k.n("MultiProcess", "AppDownloadListenerManagerImpl MultiProcess2: " + str2 + " throws Exception :", th3);
        }
    }

    private void n(RemoteCallbackList<fs> remoteCallbackList) {
        if (remoteCallbackList != null) {
            try {
                int iBeginBroadcast = remoteCallbackList.beginBroadcast();
                for (int i = 0; i < iBeginBroadcast; i++) {
                    try {
                        fs fsVar = (fs) remoteCallbackList.getBroadcastItem(i);
                        if (fsVar != null) {
                            ((com.byazt.ca.w) fsVar).s();
                        }
                    } catch (Throwable th) {
                        k.n("MultiProcess", "recycleRes1 throw Exception : ", th);
                    }
                }
                remoteCallbackList.finishBroadcast();
                remoteCallbackList.kill();
            } catch (Throwable th2) {
                k.n("MultiProcess", "recycleRes2 throw Exception : ", th2);
            }
        }
    }
}
