package com.byazt.us;

import android.os.Bundle;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.byazt.sd.ho;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 434, 5})
public class uc extends pr {
    public static volatile uc hw;
    public static final Map<String, RemoteCallbackList<ho>> pr = Collections.synchronizedMap(new HashMap());

    public static uc hw() {
        if (hw == null) {
            synchronized (uc.class) {
                if (hw == null) {
                    hw = new uc();
                }
            }
        }
        return hw;
    }

    @Override // com.byazt.us.pr, com.byazt.sd.g
    public void pr(String str, ho hoVar) throws RemoteException {
        RemoteCallbackList<ho> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(hoVar);
        pr.put(str, remoteCallbackList);
    }

    @Override // com.byazt.us.pr, com.byazt.sd.g
    public Bundle hn(String str, String str2, Bundle bundle) throws RemoteException {
        return x(str, str2, bundle);
    }

    private synchronized Bundle x(String str, String str2, Bundle bundle) {
        Bundle bundle2;
        RemoteCallbackList<ho> remoteCallbackListRemove;
        bundle2 = new Bundle();
        try {
            Map<String, RemoteCallbackList<ho>> map = pr;
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
                            ho hoVar = (ho) remoteCallbackListRemove.getBroadcastItem(i);
                            if (hoVar != null && "getPlayAgainCondition".equals(str2)) {
                                bundle2 = hoVar.pr(bundle.getInt("callback_extra_key_next_play_again_count"));
                            }
                        } catch (Throwable th) {
                        }
                    }
                    remoteCallbackListRemove.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remoteCallbackListRemove.kill();
                    }
                }
            }
        } catch (Throwable th2) {
        }
        return bundle2;
    }
}
