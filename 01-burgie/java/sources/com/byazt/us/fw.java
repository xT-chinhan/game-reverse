package com.byazt.us;

import android.os.Bundle;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.byazt.ca.ho;
import com.byazt.hg.hs;
import com.byazt.sd.nt;
import com.byazt.wt.ls;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 434, 62})
public class fw extends pr {
    public static volatile fw hw;
    public static Map<String, RemoteCallbackList<nt>> pr = Collections.synchronizedMap(new HashMap());

    public static fw hw() {
        if (hw == null) {
            synchronized (fw.class) {
                if (hw == null) {
                    hw = new fw();
                }
            }
        }
        return hw;
    }

    @Override // com.byazt.us.pr, com.byazt.sd.g
    public synchronized void pr(String str, nt ntVar) throws RemoteException {
        RemoteCallbackList<nt> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(ntVar);
        pr.put(str, remoteCallbackList);
    }

    @Override // com.byazt.us.pr, com.byazt.sd.g
    public void pr(String str, String str2, Bundle bundle) throws RemoteException {
        x(str, str2, bundle);
    }

    private synchronized void x(String str, String str2, Bundle bundle) {
        RemoteCallbackList<nt> remoteCallbackListRemove;
        RemoteCallbackList<nt> remoteCallbackListRemove2;
        try {
            if (pr != null) {
                if ("recycleRes".equals(str2)) {
                    remoteCallbackListRemove = pr.remove(str);
                    remoteCallbackListRemove2 = pr.remove(hs.pr(str));
                } else {
                    remoteCallbackListRemove = pr.get(str);
                    remoteCallbackListRemove2 = null;
                }
                if (remoteCallbackListRemove != null) {
                    int iBeginBroadcast = remoteCallbackListRemove.beginBroadcast();
                    for (int i = 0; i < iBeginBroadcast; i++) {
                        try {
                            nt ntVar = (nt) remoteCallbackListRemove.getBroadcastItem(i);
                            if (ntVar != null) {
                                if ("onAdShow".equals(str2)) {
                                    ntVar.pr(bundle);
                                } else if ("onAdClose".equals(str2)) {
                                    ntVar.hn(bundle);
                                } else if ("onVideoComplete".equals(str2)) {
                                    ntVar.hw();
                                } else if ("onVideoError".equals(str2)) {
                                    ntVar.hn();
                                } else if ("onAdVideoBarClick".equals(str2)) {
                                    ntVar.hw(bundle);
                                } else if ("onRewardVerify".equals(str2)) {
                                    pr(ntVar, bundle);
                                } else if ("onRewardArrived".equals(str2)) {
                                    hw(ntVar, bundle);
                                } else if ("onSkippedVideo".equals(str2)) {
                                    ntVar.x();
                                } else if ("recycleRes".equals(str2)) {
                                    ntVar.pr();
                                }
                            }
                        } catch (Throwable th) {
                            ho.pr("MultiProcess", "reward1 '" + str2 + "'  throws Exception :", th);
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
                            nt ntVar2 = (nt) remoteCallbackListRemove2.getBroadcastItem(i2);
                            if (ntVar2 != null && "recycleRes".equals(str2)) {
                                ntVar2.pr();
                            }
                        } catch (Throwable th2) {
                        }
                    }
                    remoteCallbackListRemove2.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remoteCallbackListRemove2.kill();
                    }
                }
            }
        } catch (Throwable th3) {
            ho.pr("MultiProcess", "reward2 '" + str2 + "'  throws Exception :", th3);
        }
    }

    private void pr(nt ntVar, Bundle bundle) throws RemoteException {
        boolean z = bundle.getBoolean("callback_extra_key_reward_valid");
        int i = bundle.getInt("callback_extra_key_reward_amount");
        String string = bundle.getString("callback_extra_key_reward_name");
        int i2 = bundle.getInt("callback_extra_key_error_code");
        String string2 = bundle.getString("callback_extra_key_error_msg");
        ntVar.pr(z, i, string != null ? string : "", i2, string2 != null ? string2 : "");
    }

    private void hw(nt ntVar, Bundle bundle) throws RemoteException {
        boolean z = bundle.getBoolean("callback_extra_key_reward_valid");
        int i = bundle.getInt("callback_extra_key_reward_type");
        ntVar.pr(z, i, ls.pr(i, bundle));
    }
}
