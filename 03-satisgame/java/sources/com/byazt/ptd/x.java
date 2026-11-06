package com.byazt.ptd;

import android.os.Bundle;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.byazt.gct.dh;
import com.byazt.tk.k;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 996, 21})
public class x extends n {
    public static Map<String, RemoteCallbackList<com.byazt.nf.x>> n = Collections.synchronizedMap(new HashMap());
    public static volatile x qg;

    public static x qg() {
        if (qg == null) {
            synchronized (x.class) {
                if (qg == null) {
                    qg = new x();
                }
            }
        }
        return qg;
    }

    @Override // com.byazt.ptd.n, com.byazt.nf.l
    public synchronized void n(String str, com.byazt.nf.x xVar) throws RemoteException {
        RemoteCallbackList<com.byazt.nf.x> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(xVar);
        n.put(str, remoteCallbackList);
    }

    @Override // com.byazt.ptd.n, com.byazt.nf.l
    public void n(String str, String str2, Bundle bundle) throws RemoteException {
        q(str, str2, bundle);
    }

    private synchronized void q(String str, String str2, Bundle bundle) {
        RemoteCallbackList<com.byazt.nf.x> remoteCallbackListRemove;
        RemoteCallbackList<com.byazt.nf.x> remoteCallbackListRemove2;
        try {
            if (n != null) {
                if ("recycleRes".equals(str2)) {
                    remoteCallbackListRemove = n.remove(str);
                    remoteCallbackListRemove2 = n.remove(dh.n(str));
                } else {
                    remoteCallbackListRemove = n.get(str);
                    remoteCallbackListRemove2 = null;
                }
                if (remoteCallbackListRemove != null) {
                    int iBeginBroadcast = remoteCallbackListRemove.beginBroadcast();
                    for (int i = 0; i < iBeginBroadcast; i++) {
                        try {
                            com.byazt.nf.x xVar = (com.byazt.nf.x) remoteCallbackListRemove.getBroadcastItem(i);
                            if (xVar != null) {
                                if ("onAdShow".equals(str2)) {
                                    xVar.n(bundle);
                                } else if ("onAdClose".equals(str2)) {
                                    xVar.s(bundle);
                                } else if ("onVideoComplete".equals(str2)) {
                                    xVar.qg();
                                } else if ("onVideoError".equals(str2)) {
                                    xVar.s();
                                } else if ("onAdVideoBarClick".equals(str2)) {
                                    xVar.qg(bundle);
                                } else if ("onRewardVerify".equals(str2)) {
                                    n(xVar, bundle);
                                } else if ("onRewardArrived".equals(str2)) {
                                    qg(xVar, bundle);
                                } else if ("onSkippedVideo".equals(str2)) {
                                    xVar.q();
                                } else if ("recycleRes".equals(str2)) {
                                    xVar.n();
                                }
                            }
                        } catch (Throwable th) {
                            k.n("MultiProcess", "reward1 '" + str2 + "'  throws Exception :", th);
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
                            com.byazt.nf.x xVar2 = (com.byazt.nf.x) remoteCallbackListRemove2.getBroadcastItem(i2);
                            if (xVar2 != null && "recycleRes".equals(str2)) {
                                xVar2.n();
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
            k.n("MultiProcess", "reward2 '" + str2 + "'  throws Exception :", th2);
        }
    }

    private void n(com.byazt.nf.x xVar, Bundle bundle) throws RemoteException {
        boolean z = bundle.getBoolean("callback_extra_key_reward_valid");
        int i = bundle.getInt("callback_extra_key_reward_amount");
        String string = bundle.getString("callback_extra_key_reward_name");
        int i2 = bundle.getInt("callback_extra_key_error_code");
        String string2 = bundle.getString("callback_extra_key_error_msg");
        xVar.n(z, i, string != null ? string : "", i2, string2 != null ? string2 : "");
    }

    private void qg(com.byazt.nf.x xVar, Bundle bundle) throws RemoteException {
        boolean z = bundle.getBoolean("callback_extra_key_reward_valid");
        int i = bundle.getInt("callback_extra_key_reward_type");
        xVar.n(z, i, com.byazt.vgx.w.n(i, bundle));
    }
}
