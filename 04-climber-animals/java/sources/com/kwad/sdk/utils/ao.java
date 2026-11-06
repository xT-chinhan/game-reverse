package com.kwad.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.ServiceState;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.net.InetAddress;

/* JADX INFO: loaded from: classes3.dex */
public final class ao {
    private static int aZT;
    private static boolean aZU;

    public static NetworkInfo de(Context context) {
        ConnectivityManager connectivityManager;
        if (!SystemUtil.b(context, com.kuaishou.weapon.p0.g.b) || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return null;
        }
        try {
            return connectivityManager.getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isNetworkConnected(Context context) {
        try {
            NetworkInfo networkInfoDe = de(context);
            return networkInfoDe != null && networkInfoDe.isConnected();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isWifiConnected(Context context) {
        try {
            NetworkInfo networkInfoDe = de(context);
            return networkInfoDe != null && networkInfoDe.isConnected() && 1 == networkInfoDe.getType();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isMobileConnected(Context context) {
        try {
            NetworkInfo networkInfoDe = de(context);
            return networkInfoDe != null && networkInfoDe.isConnected() && networkInfoDe.getType() == 0;
        } catch (Exception unused) {
        }
    }

    public static int getActiveNetworkType(Context context) {
        try {
            NetworkInfo networkInfoDe = de(context);
            if (networkInfoDe == null) {
                return -1;
            }
            return networkInfoDe.getType();
        } catch (Exception unused) {
            return -1;
        }
    }

    public static int df(Context context) {
        if (context != null && SystemUtil.b(context, com.kuaishou.weapon.p0.g.b) && SystemUtil.b(context, "android.permission.READ_PHONE_STATE")) {
            try {
                NetworkInfo networkInfoDe = de(context);
                if (!(networkInfoDe != null && networkInfoDe.isConnected())) {
                    return 0;
                }
                if (1 == networkInfoDe.getType()) {
                    return 100;
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
                if (telephonyManager != null) {
                    int iN = n(context, telephonyManager.getNetworkType());
                    if (iN == 20) {
                        return 5;
                    }
                    switch (iN) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                        case 16:
                            return 2;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return 3;
                        case 13:
                            return 4;
                        default:
                            return 0;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:45:0x0099  */
    /* JADX WARN: Failed to clean up code after switch over string restore
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r11v2 int, still in use, count: 2, list:
      (r11v2 int) from 0x0031: IF  (r11v2 int) != (49679502 int)  -> B:12:0x0033 A[HIDDEN]
      (r11v2 int) from 0x0036: SWITCH (r11v2 int)
     case 49679475: goto B:27:0x0063
     case 49679476: goto B:24:0x0059
     case 49679477: goto B:21:0x004f
     case 49679478: goto B:18:0x0045
     case 49679479: goto B:15:0x003b
     default: goto B:14:0x0039 A[Catch: Exception -> 0x00d7, RegionRef:SW:13]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:226)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:215)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.replaceWithMergedSwitch(SwitchOverStringVisitor.java:355)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:111)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:72)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:140)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:47)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:66)
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static int d(Context context, String str, boolean z) {
        byte b;
        if (context == null || aZT > 0 || aZU) {
            return aZT;
        }
        try {
            if (!z) {
                String simOperator = ((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getSimOperator();
                if (iHashCode != 49679502) {
                    switch (simOperator) {
                        case "46000":
                            b = 0;
                            break;
                        case "46001":
                            b = 4;
                            break;
                        case "46002":
                            b = 1;
                            break;
                        case "46003":
                            b = 7;
                            break;
                        default:
                            switch (iHashCode) {
                                case 49679475:
                                    if (!simOperator.equals("46005")) {
                                        b = -1;
                                    } else {
                                        b = 8;
                                    }
                                    break;
                                case 49679476:
                                    if (!simOperator.equals("46006")) {
                                        b = -1;
                                    } else {
                                        b = 5;
                                    }
                                    break;
                                case 49679477:
                                    if (!simOperator.equals("46007")) {
                                        b = -1;
                                    } else {
                                        b = 2;
                                    }
                                    break;
                                case 49679478:
                                    if (!simOperator.equals("46008")) {
                                        b = -1;
                                    } else {
                                        b = 3;
                                    }
                                    break;
                                case 49679479:
                                    if (!simOperator.equals("46009")) {
                                        b = -1;
                                    } else {
                                        b = 6;
                                    }
                                    break;
                                default:
                                    b = -1;
                                    break;
                            }
                    }
                } else if (simOperator.equals("46011")) {
                    b = 9;
                } else {
                    b = -1;
                }
                switch (b) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                        aZT = 1;
                        break;
                    case 4:
                    case 5:
                    case 6:
                        aZT = 3;
                        break;
                    case 7:
                    case 8:
                    case 9:
                        aZT = 2;
                        break;
                    default:
                        aZT = 0;
                        break;
                }
            } else {
                aZT = 0;
            }
            if (aZT == 0 && !TextUtils.isEmpty(str)) {
                if (str.startsWith("46000") || str.startsWith("46002")) {
                    aZT = 1;
                } else if (str.startsWith("46001")) {
                    aZT = 3;
                } else if (str.startsWith("46003")) {
                    aZT = 2;
                }
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
        int i = aZT;
        aZU = i == 0;
        return i;
    }

    private static int n(Context context, int i) {
        ServiceState serviceState;
        if (!SystemUtil.b(context, com.kuaishou.weapon.p0.g.b)) {
            return i;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return i;
            }
            int subId = getSubId();
            if (subId == -1) {
                serviceState = telephonyManager.getServiceState();
            } else if (context.getApplicationInfo().targetSdkVersion >= 29 && Build.VERSION.SDK_INT >= 29) {
                serviceState = telephonyManager.getServiceState();
            } else {
                try {
                    serviceState = (ServiceState) z.callMethod(telephonyManager, "getServiceStateForSubscriber", Integer.valueOf(subId));
                } catch (Throwable unused) {
                    serviceState = telephonyManager.getServiceState();
                }
            }
            if (serviceState == null) {
                return i;
            }
            if (bb.Rk()) {
                Integer num = (Integer) z.a("com.huawei.android.telephony.ServiceStateEx", "getConfigRadioTechnology", serviceState);
                return num != null ? num.intValue() : i;
            }
            if (hb(serviceState.toString())) {
                return 20;
            }
            return i;
        } catch (Exception unused2) {
            return i;
        }
    }

    private static int getSubId() {
        return SubscriptionManager.getDefaultDataSubscriptionId();
    }

    private static boolean hb(String str) {
        return str.contains("nrState=NOT_RESTRICTED") || str.contains("nrState=CONNECTED");
    }

    public static boolean hc(String str) {
        return s(str, 3000);
    }

    private static boolean s(String str, int i) {
        try {
            return InetAddress.getByName(str).isReachable(3000);
        } catch (Throwable unused) {
            return false;
        }
    }
}
