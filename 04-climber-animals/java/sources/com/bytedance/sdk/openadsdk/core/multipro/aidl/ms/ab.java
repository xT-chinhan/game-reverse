package com.bytedance.sdk.openadsdk.core.multipro.aidl.ms;

import android.os.Bundle;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw.k;
import com.bytedance.sdk.openadsdk.core.qv;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ab extends ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static Map<String, RemoteCallbackList<qv>> f2888ms = Collections.synchronizedMap(new HashMap());
    private static volatile ab xr;

    public static ab xr() {
        if (xr == null) {
            synchronized (ab.class) {
                if (xr == null) {
                    xr = new ab();
                }
            }
        }
        return xr;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.ms.ms, com.bytedance.sdk.openadsdk.core.ao
    public synchronized void ms(String str, qv qvVar) throws RemoteException {
        RemoteCallbackList<qv> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(qvVar);
        f2888ms.put(str, remoteCallbackList);
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.ms.ms, com.bytedance.sdk.openadsdk.core.ao
    public void ms(String str, String str2, Bundle bundle) throws RemoteException {
        ah(str, str2, bundle);
    }

    private synchronized void ah(String str, String str2, Bundle bundle) {
        RemoteCallbackList<qv> remoteCallbackListRemove;
        RemoteCallbackList<qv> remoteCallbackListRemove2;
        try {
            if (f2888ms != null) {
                if ("recycleRes".equals(str2)) {
                    remoteCallbackListRemove = f2888ms.remove(str);
                    remoteCallbackListRemove2 = f2888ms.remove(k.ms(str));
                } else {
                    remoteCallbackListRemove = f2888ms.get(str);
                    remoteCallbackListRemove2 = null;
                }
                if (remoteCallbackListRemove != null) {
                    int iBeginBroadcast = remoteCallbackListRemove.beginBroadcast();
                    for (int i = 0; i < iBeginBroadcast; i++) {
                        try {
                            qv qvVar = (qv) remoteCallbackListRemove.getBroadcastItem(i);
                            if (qvVar != null) {
                                if ("onAdShow".equals(str2)) {
                                    qvVar.xr();
                                } else if ("onAdClose".equals(str2)) {
                                    qvVar.d();
                                } else if ("onVideoComplete".equals(str2)) {
                                    qvVar.ka();
                                } else if ("onVideoError".equals(str2)) {
                                    qvVar.c();
                                } else if ("onAdVideoBarClick".equals(str2)) {
                                    qvVar.ah();
                                } else if ("onRewardVerify".equals(str2)) {
                                    ms(qvVar, bundle);
                                } else if ("onRewardArrived".equals(str2)) {
                                    xr(qvVar, bundle);
                                } else if ("onSkippedVideo".equals(str2)) {
                                    qvVar.ab();
                                } else if ("recycleRes".equals(str2)) {
                                    qvVar.ms();
                                }
                            }
                        } catch (Throwable th) {
                            sl.ah("MultiProcess", "reward1 '" + str2 + "'  throws Exception :", th);
                        }
                    }
                    remoteCallbackListRemove.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remoteCallbackListRemove.kill();
                    }
                }
                if (remoteCallbackListRemove2 != null) {
                    int iBeginBroadcast2 = remoteCallbackListRemove2.beginBroadcast();
                    for (int i2 = 0; i2 < iBeginBroadcast2; i2++) {
                        try {
                            qv qvVar2 = (qv) remoteCallbackListRemove2.getBroadcastItem(i2);
                            if (qvVar2 != null && "recycleRes".equals(str2)) {
                                qvVar2.ms();
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    remoteCallbackListRemove2.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remoteCallbackListRemove2.kill();
                    }
                }
            }
        } catch (Throwable th2) {
            sl.ah("MultiProcess", "reward2 '" + str2 + "'  throws Exception :", th2);
        }
    }

    private void ms(qv qvVar, Bundle bundle) throws RemoteException {
        boolean z = bundle.getBoolean("callback_extra_key_reward_valid");
        int i = bundle.getInt("callback_extra_key_reward_amount");
        String string = bundle.getString("callback_extra_key_reward_name");
        int i2 = bundle.getInt("callback_extra_key_error_code");
        String string2 = bundle.getString("callback_extra_key_error_msg");
        qvVar.ms(z, i, string != null ? string : "", i2, string2 != null ? string2 : "");
    }

    private void xr(qv qvVar, Bundle bundle) throws RemoteException {
        boolean z = bundle.getBoolean("callback_extra_key_reward_valid");
        int i = bundle.getInt("callback_extra_key_reward_type");
        qvVar.ms(z, i, f.ms(i, bundle));
    }
}
