package com.byazt.it;

import android.text.TextUtils;
import com.byazt.jp.tj;
import com.byazt.mh.l;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 879, 19})
public class n {
    public static void n() {
        try {
            if (com.byazt.rb.qg.qg() && tj.n()) {
                qg();
            }
        } catch (Throwable unused) {
        }
    }

    private static synchronized void qg() {
        if (com.byazt.qt.qg.getContext() == null) {
            return;
        }
        com.byazt.ir.s.n().l();
    }

    private static int s(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return 0;
        }
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (TextUtils.isEmpty(str2)) {
            return 1;
        }
        if (str.startsWith("v") || str.startsWith("V")) {
            str = str.substring(1);
        }
        if (str2.startsWith("v") || str2.startsWith("V")) {
            str2 = str2.substring(1);
        }
        String[] strArrSplit = str.split("\\.");
        String[] strArrSplit2 = str2.split("\\.");
        int iMin = Math.min(strArrSplit.length, strArrSplit2.length);
        for (int i = 0; i < iMin; i++) {
            if (strArrSplit[i].length() != strArrSplit2[i].length()) {
                return strArrSplit[i].length() > strArrSplit2[i].length() ? 1 : -1;
            }
            int iCompareTo = strArrSplit[i].compareTo(strArrSplit2[i]);
            if (iCompareTo != 0) {
                return iCompareTo;
            }
        }
        if (strArrSplit.length == strArrSplit2.length) {
            return 0;
        }
        return strArrSplit.length > strArrSplit2.length ? 1 : -1;
    }

    public static boolean n(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (str.equals("baidu") || str.equals(MediationConstant.ADN_PANGLE)) {
            return true;
        }
        str.hashCode();
        switch (str) {
            case "sigmob":
                if (s(str2, "4.25.82") != 0) {
                    com.byazt.rb.qg.q("TTMediationSDK_InitChecker", "sigmob版本不符合, 要求版本等于4.25.82，当前是" + str2);
                    return false;
                }
                com.byazt.rb.qg.n("TTMediationSDK_InitChecker", "sigmob版本正常, 要求版本等于4.25.82，当前是" + str2);
                break;
                break;
            case "xiaomi":
                if (s(str2, "5.3.3.8") != 0) {
                    com.byazt.rb.qg.q("TTMediationSDK_InitChecker", "xiaomi版本不符合, 要求版本等于5.3.3.8，当前是" + str2);
                    return false;
                }
                com.byazt.rb.qg.n("TTMediationSDK_InitChecker", "xiaomi版本正常, 要求版本等于5.3.3.8，当前是" + str2);
                break;
                break;
            case "ks":
                if (s(str2, "5.7.20.1") != 0) {
                    com.byazt.rb.qg.q("TTMediationSDK_InitChecker", "快手版本不符合, 要求版本等于5.7.20.1，当前是" + str2);
                    return false;
                }
                com.byazt.rb.qg.n("TTMediationSDK_InitChecker", "快手版本正常, 要求版本等于5.7.20.1，当前是" + str2);
                break;
                break;
            case "gdt":
                if (s(str2, "4.701.1571") != 0) {
                    com.byazt.rb.qg.q("TTMediationSDK_InitChecker", "gdt版本不符合，要求等于4.701.1571，当前是" + str2);
                    return false;
                }
                com.byazt.rb.qg.n("TTMediationSDK_InitChecker", "gdt版本正常，要求等于4.701.1571，当前是" + str2);
                break;
                break;
            default:
                return false;
        }
        return true;
    }

    public static boolean qg(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (str.equals(MediationConstant.ADN_PANGLE)) {
            return true;
        }
        str.hashCode();
        switch (str) {
            case "sigmob":
                if (q("4.25.82", str2)) {
                    n("sigmobAdapter", "4.25.82", str2);
                    break;
                } else {
                    qg("sigmobAdapter", "4.25.82", str2);
                    return false;
                }
                break;
            case "xiaomi":
                if (q("5.3.3.8", str2)) {
                    n("xiaomiAdapter", "5.3.3.8", str2);
                    break;
                } else {
                    qg("xiaomiAdapter", "5.3.3.8", str2);
                    return false;
                }
                break;
            case "ks":
                if (l.s(MediationConstant.ADN_KS) != null) {
                    return false;
                }
                if (q("5.7.20.1", str2)) {
                    n("ksAdapter", "5.7.20.1", str2);
                } else {
                    qg("ksAdapter", "5.7.20.1", str2);
                    return false;
                }
                break;
                break;
            case "gdt":
                if (l.s(MediationConstant.ADN_GDT) != null) {
                    return false;
                }
                if (q("4.701.1571", str2)) {
                    n("gdtAdapter", "4.701.1571", str2);
                } else {
                    qg("gdtAdapter", "4.701.1571", str2);
                    return false;
                }
                break;
                break;
            case "baidu":
                if (q("9.4603", str2)) {
                    n("baiduAdapter", "9.4603", str2);
                    break;
                } else {
                    qg("baiduAdapter", "9.4603", str2);
                    return false;
                }
                break;
            default:
                return false;
        }
        return true;
    }

    private static void n(String str, String str2, String str3) {
        com.byazt.rb.qg.n("TTMediationSDK_InitChecker", str + "接入版本正常, 要求版为：" + str2 + "，当前版本为：" + str3);
    }

    private static void qg(String str, String str2, String str3) {
        com.byazt.rb.qg.q("TTMediationSDK_InitChecker", str + "接入版本不符合, 要求版为：" + str2 + ".x，当前版本为：" + str3);
    }

    private static boolean q(String str, String str2) {
        if (str == null || str2 == null || str.length() == 0 || str2.length() == 0 || str.length() > str2.length()) {
            return false;
        }
        if (str.startsWith("v") || str.startsWith("V")) {
            str = str.substring(1);
        }
        if (str2.startsWith("v") || str2.startsWith("V")) {
            str2 = str2.substring(1);
        }
        String[] strArrSplit = str.split("\\.");
        String[] strArrSplit2 = str2.split("\\.");
        for (int i = 0; i < strArrSplit.length; i++) {
            if (strArrSplit[i].length() == strArrSplit[i].length() && strArrSplit[i].compareTo(strArrSplit2[i]) != 0) {
                return false;
            }
        }
        return true;
    }
}
