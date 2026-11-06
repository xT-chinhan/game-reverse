package com.bytedance.sdk.openadsdk.core.multipro.aidl.ms;

import android.os.Bundle;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.core.h;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class c extends ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final Map<String, RemoteCallbackList<h>> f2890ms = Collections.synchronizedMap(new HashMap());
    private static volatile c xr;

    public static c xr() {
        if (xr == null) {
            synchronized (c.class) {
                if (xr == null) {
                    xr = new c();
                }
            }
        }
        return xr;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.ms.ms, com.bytedance.sdk.openadsdk.core.ao
    public void ms(String str, h hVar) throws RemoteException {
        RemoteCallbackList<h> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(hVar);
        f2890ms.put(str, remoteCallbackList);
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.ms.ms, com.bytedance.sdk.openadsdk.core.ao
    public Bundle xr(String str, String str2, Bundle bundle) throws RemoteException {
        return ah(str, str2, bundle);
    }

    private synchronized Bundle ah(String str, String str2, Bundle bundle) {
        Bundle bundle2;
        RemoteCallbackList<h> remoteCallbackListRemove;
        bundle2 = new Bundle();
        try {
            Map<String, RemoteCallbackList<h>> map = f2890ms;
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
                            h hVar = (h) remoteCallbackListRemove.getBroadcastItem(i);
                            if (hVar != null && "getPlayAgainCondition".equals(str2)) {
                                bundle2 = hVar.ms(bundle.getInt("callback_extra_key_next_play_again_count"));
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
