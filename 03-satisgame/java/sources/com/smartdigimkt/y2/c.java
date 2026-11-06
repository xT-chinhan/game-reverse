package com.smartdigimkt.y2;

import android.content.Context;
import android.os.Build;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import com.smartdigimkt.r4.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c {
    public static a a(Context context) {
        TelephonyManager telephonyManager;
        SubscriptionManager subscriptionManager;
        List<SubscriptionInfo> activeSubscriptionInfoList;
        int subscriptionId;
        a aVar;
        TelephonyManager telephonyManagerCreateForSubscriptionId;
        a aVar2;
        if (context == null) {
            return a.c;
        }
        SubscriptionManager subscriptionManager2 = null;
        try {
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
        } catch (Throwable unused) {
            telephonyManager = null;
        }
        a aVarA = a(telephonyManager);
        if (aVarA.a()) {
            return aVarA;
        }
        boolean zD = k.d(context, com.anythink.china.b.c.a);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        try {
            int defaultDataSubscriptionId = SubscriptionManager.getDefaultDataSubscriptionId();
            if (defaultDataSubscriptionId > -1) {
                linkedHashSet.add(Integer.valueOf(defaultDataSubscriptionId));
            }
            int defaultSmsSubscriptionId = SubscriptionManager.getDefaultSmsSubscriptionId();
            if (defaultSmsSubscriptionId > -1) {
                linkedHashSet.add(Integer.valueOf(defaultSmsSubscriptionId));
            }
            int defaultVoiceSubscriptionId = SubscriptionManager.getDefaultVoiceSubscriptionId();
            if (defaultVoiceSubscriptionId > -1) {
                linkedHashSet.add(Integer.valueOf(defaultVoiceSubscriptionId));
            }
            int defaultSubscriptionId = SubscriptionManager.getDefaultSubscriptionId();
            if (defaultSubscriptionId > -1) {
                linkedHashSet.add(Integer.valueOf(defaultSubscriptionId));
            }
        } catch (Throwable unused2) {
        }
        if (zD) {
            try {
                subscriptionManager = (SubscriptionManager) context.getSystemService("telephony_subscription_service");
            } catch (Throwable unused3) {
                subscriptionManager = null;
            }
            if (subscriptionManager == null) {
                activeSubscriptionInfoList = null;
            } else {
                try {
                    activeSubscriptionInfoList = subscriptionManager.getActiveSubscriptionInfoList();
                } catch (Throwable unused4) {
                }
            }
            if (activeSubscriptionInfoList != null) {
                for (SubscriptionInfo subscriptionInfo : activeSubscriptionInfoList) {
                    if (subscriptionInfo != null && (subscriptionId = subscriptionInfo.getSubscriptionId()) > -1) {
                        linkedHashSet.add(Integer.valueOf(subscriptionId));
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList(linkedHashSet);
        if (telephonyManager != null) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    aVar = a.c;
                    break;
                }
                try {
                    telephonyManagerCreateForSubscriptionId = telephonyManager.createForSubscriptionId(((Integer) it.next()).intValue());
                } catch (Throwable unused5) {
                    telephonyManagerCreateForSubscriptionId = null;
                }
                a aVarA2 = a(telephonyManagerCreateForSubscriptionId);
                if (aVarA2.a()) {
                    aVar = aVarA2;
                    break;
                }
            }
        } else {
            aVar = a.c;
        }
        if (aVar.a()) {
            return aVar;
        }
        if (Build.VERSION.SDK_INT >= 29 && zD) {
            try {
                subscriptionManager2 = (SubscriptionManager) context.getSystemService("telephony_subscription_service");
            } catch (Throwable unused6) {
            }
            if (subscriptionManager2 != null) {
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        aVar2 = a.c;
                        break;
                    }
                    try {
                        SubscriptionInfo activeSubscriptionInfo = subscriptionManager2.getActiveSubscriptionInfo(((Integer) it2.next()).intValue());
                        if (activeSubscriptionInfo != null) {
                            a aVarA3 = d.a(activeSubscriptionInfo.getMccString(), activeSubscriptionInfo.getMncString());
                            if (aVarA3.a()) {
                                aVar2 = aVarA3;
                                break;
                            }
                        } else {
                            continue;
                        }
                    } catch (Throwable unused7) {
                    }
                }
            } else {
                aVar2 = a.c;
            }
            if (aVar2.a()) {
                return aVar2;
            }
        }
        return a.c;
    }

    public static a a(TelephonyManager telephonyManager) {
        if (telephonyManager == null) {
            return a.c;
        }
        a aVarB = a.c;
        try {
            aVarB = d.b(telephonyManager.getSimOperator());
        } catch (Throwable unused) {
        }
        if (aVarB.a()) {
            return aVarB;
        }
        try {
            return d.b(telephonyManager.getNetworkOperator());
        } catch (Throwable unused2) {
            return aVarB;
        }
    }
}
