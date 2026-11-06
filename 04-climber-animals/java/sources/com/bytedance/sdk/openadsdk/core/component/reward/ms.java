package com.bytedance.sdk.openadsdk.core.component.reward;

import android.os.Bundle;
import android.os.RemoteException;
import com.bytedance.sdk.component.ch.ch;
import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.ao;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.ms.ab;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.xr.d;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.xr.ka;
import com.bytedance.sdk.openadsdk.core.re;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected static HashMap<Integer, ao> f2217ms = new HashMap<>();
    private static final ExecutorService xr = com.bytedance.sdk.component.ch.ah.ms(new ch("RewardFullCallback"));

    public static void ms(final int i, final String str, final String str2, final Bundle bundle) {
        xr.execute(new ny("executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.ms.1
            @Override // java.lang.Runnable
            public void run() {
                ao aoVarMs = ms.f2217ms.get(Integer.valueOf(i));
                if (aoVarMs == null) {
                    aoVarMs = com.bytedance.sdk.openadsdk.core.multipro.aidl.ms.ms.ms(com.bytedance.sdk.openadsdk.core.multipro.aidl.ms.ms(re.getContext()).ms(i));
                    ms.f2217ms.put(Integer.valueOf(i), aoVarMs);
                }
                if (aoVarMs == null) {
                    return;
                }
                try {
                    int i2 = i;
                    if (i2 == 0) {
                        aoVarMs.ms(str, str2, bundle);
                    } else if (i2 == 1) {
                        aoVarMs.ms(str, str2);
                    } else {
                        if (i2 != 5) {
                            return;
                        }
                        aoVarMs.xr(str, str2, bundle);
                    }
                } catch (RemoteException e) {
                    sl.ms(e);
                }
            }
        });
    }

    public static void ms(final String str, final com.bytedance.sdk.openadsdk.yu.ms.xr.ms.ms msVar) {
        xr.execute(new ny("registerMultiProcessListener") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.ms.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.multipro.aidl.ms msVarMs = com.bytedance.sdk.openadsdk.core.multipro.aidl.ms.ms(re.getContext());
                if (msVar != null) {
                    ka kaVar = new ka(msVar);
                    ao aoVarMs = ab.ms(msVarMs.ms(0));
                    if (aoVarMs != null) {
                        try {
                            aoVarMs.ms(str, kaVar);
                        } catch (RemoteException e) {
                            sl.ms(e);
                        }
                    }
                }
            }
        });
    }

    public static void ms(final String str, final com.bytedance.sdk.openadsdk.yu.ms.xr.ms.xr xrVar) {
        xr.execute(new ny("registerMultiProcessListener") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.ms.3
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.multipro.aidl.ms msVarMs = com.bytedance.sdk.openadsdk.core.multipro.aidl.ms.ms(re.getContext());
                if (xrVar != null) {
                    d dVar = new d(xrVar);
                    ao aoVarMs = ab.ms(msVarMs.ms(5));
                    if (aoVarMs != null) {
                        try {
                            aoVarMs.ms(str, dVar);
                        } catch (RemoteException e) {
                            sl.ms(e);
                        }
                    }
                }
            }
        });
    }

    public static void ms(final String str, final com.bytedance.sdk.openadsdk.re.ms.xr.ms.ms msVar) {
        xr.execute(new ny("registerMultiProcessListener") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.ms.4
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.multipro.aidl.ms msVarMs = com.bytedance.sdk.openadsdk.core.multipro.aidl.ms.ms(re.getContext());
                if (msVar != null) {
                    com.bytedance.sdk.openadsdk.core.multipro.aidl.xr.ah ahVar = new com.bytedance.sdk.openadsdk.core.multipro.aidl.xr.ah(msVar);
                    ao aoVarMs = com.bytedance.sdk.openadsdk.core.multipro.aidl.ms.ka.ms(msVarMs.ms(1));
                    if (aoVarMs != null) {
                        try {
                            aoVarMs.ms(str, ahVar);
                        } catch (RemoteException e) {
                            sl.ms(e);
                        }
                    }
                }
            }
        });
    }
}
