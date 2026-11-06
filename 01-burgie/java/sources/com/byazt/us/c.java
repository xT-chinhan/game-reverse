package com.byazt.us;

import android.os.Bundle;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.byazt.ca.ho;
import com.byazt.sd.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 434, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c extends pr {
    public static volatile c hw;
    public static Map<String, RemoteCallbackList<m>> pr = Collections.synchronizedMap(new HashMap());

    public static c hw() {
        if (hw == null) {
            synchronized (c.class) {
                if (hw == null) {
                    hw = new c();
                }
            }
        }
        return hw;
    }

    @Override // com.byazt.us.pr, com.byazt.sd.g
    public synchronized void pr(String str, m mVar) throws RemoteException {
        RemoteCallbackList<m> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(mVar);
        pr.put(str, remoteCallbackList);
    }

    @Override // com.byazt.us.pr, com.byazt.sd.g
    public void hw(String str, String str2, Bundle bundle) throws RemoteException {
        x(str, str2, bundle);
    }

    private synchronized void x(String str, String str2, Bundle bundle) {
        RemoteCallbackList<m> remoteCallbackListRemove;
        try {
            if (pr != null) {
                if ("recycleRes".equals(str2)) {
                    remoteCallbackListRemove = pr.remove(str);
                } else {
                    remoteCallbackListRemove = pr.get(str);
                }
                if (remoteCallbackListRemove != null) {
                    int iBeginBroadcast = remoteCallbackListRemove.beginBroadcast();
                    for (int i = 0; i < iBeginBroadcast; i++) {
                        try {
                            m mVar = (m) remoteCallbackListRemove.getBroadcastItem(i);
                            if (mVar != null) {
                                if ("onAdShow".equals(str2)) {
                                    mVar.pr(bundle);
                                } else if ("onAdClose".equals(str2)) {
                                    mVar.hn(bundle);
                                } else if ("onVideoComplete".equals(str2)) {
                                    mVar.hw();
                                } else if ("onSkippedVideo".equals(str2)) {
                                    mVar.hn();
                                } else if ("onAdVideoBarClick".equals(str2)) {
                                    mVar.hw(bundle);
                                } else if ("recycleRes".equals(str2)) {
                                    mVar.pr();
                                }
                            }
                        } catch (Throwable th) {
                            ho.pr("MultiProcess", "fullScreen2 method " + str2 + " throws Exception :", th);
                        }
                    }
                    remoteCallbackListRemove.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remoteCallbackListRemove.kill();
                    }
                }
            }
        } catch (Throwable th2) {
            ho.pr("MultiProcess", "fullScreen1 method " + str2 + " throws Exception :", th2);
        }
    }
}
