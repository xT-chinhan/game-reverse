package com.smartdigimkt.z3;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:63:0x00cf  */
    /* JADX WARN: Failed to clean up code after switch over string restore
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r2v2 int, still in use, count: 6, list:
      (r2v2 int) from 0x000d: IF  (r2v2 int) != (46730192 int)  -> B:6:0x000f A[HIDDEN]
      (r2v2 int) from 0x0012: IF  (r2v2 int) != (48577204 int)  -> B:8:0x0014 A[HIDDEN]
      (r2v2 int) from 0x0017: IF  (r2v2 int) != (47653683 int)  -> B:10:0x0019 A[HIDDEN]
      (r2v2 int) from 0x001c: IF  (r2v2 int) != (47653684 int)  -> B:12:0x001e A[HIDDEN]
      (r2v2 int) from 0x0021: IF  (r2v2 int) != (54118330 int)  -> B:14:0x0023 A[HIDDEN]
      (r2v2 int) from 0x0026: IF  (r2v2 int) != (54118331 int)  -> B:16:0x0028 A[HIDDEN]
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
    public static a a(String str, String str2) {
        byte b;
        if (TextUtils.isEmpty(str2)) {
            if (iHashCode != 46730192) {
                if (iHashCode != 48577204) {
                    if (iHashCode != 47653683) {
                        if (iHashCode != 47653684) {
                            if (iHashCode != 54118330) {
                                if (iHashCode != 54118331) {
                                    switch (str) {
                                        case "10001":
                                            b = 0;
                                            break;
                                        case "10002":
                                            b = 1;
                                            break;
                                        case "10003":
                                            b = 2;
                                            break;
                                        case "10004":
                                            b = 3;
                                            break;
                                        case "10005":
                                            b = 4;
                                            break;
                                        case "10006":
                                            b = 5;
                                            break;
                                        case "10007":
                                            b = 6;
                                            break;
                                        case "10008":
                                            b = 7;
                                            break;
                                        case "10009":
                                            b = 8;
                                            break;
                                        default:
                                            b = -1;
                                            break;
                                    }
                                } else if (str.equals("90002")) {
                                    b = 10;
                                } else {
                                    b = -1;
                                }
                            } else if (str.equals("90001")) {
                                b = 11;
                            } else {
                                b = -1;
                            }
                        } else if (str.equals("20002")) {
                            b = 12;
                        } else {
                            b = -1;
                        }
                    } else if (str.equals(com.anythink.core.common.inner.b.b.d)) {
                        b = 13;
                    } else {
                        b = -1;
                    }
                } else if (str.equals(com.anythink.core.common.inner.b.b.i)) {
                    b = 14;
                } else {
                    b = -1;
                }
            } else if (str.equals("10010")) {
                b = 9;
            } else {
                b = -1;
            }
            switch (b) {
                case 0:
                    str2 = "Parameter error.";
                    break;
                case 1:
                    str2 = "SDK is not initialized.";
                    break;
                case 2:
                    str2 = "AppId or AppKey is empty.";
                    break;
                case 3:
                    str2 = "Ad slot is loading, please wait.";
                    break;
                case 4:
                    str2 = "Ad slot loading timeout.";
                    break;
                case 5:
                    str2 = "Ad slot strategy loading failed.";
                    break;
                case 6:
                    str2 = "Bid request timeout.";
                    break;
                case 7:
                    str2 = "Bid request failed.";
                    break;
                case 8:
                    str2 = "Mediation SDK request failed.";
                    break;
                case 9:
                    str2 = "Ad request failed.";
                    break;
                case 10:
                    str2 = "Possible network issue on device. Please check your network.";
                    break;
                case 11:
                    str2 = "Service status error.";
                    break;
                case 12:
                    str2 = "Failed to display ad.";
                    break;
                case 13:
                    str2 = "Ad is loaded but not ready.";
                    break;
                default:
                    str2 = "Unknown error.";
                    break;
            }
        }
        return new a(str, str2);
    }
}
