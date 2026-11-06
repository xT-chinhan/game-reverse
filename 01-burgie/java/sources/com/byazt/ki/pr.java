package com.byazt.ki;

import com.umeng.analytics.pro.an;
import com.umeng.analytics.pro.cc;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1163, 37})
public final class pr {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static String pr(String str) {
        if (str == null) {
            return null;
        }
        byte b = -1;
        switch (str.hashCode()) {
            case -1901805651:
                if (str.equals("invisible")) {
                    b = 11;
                }
                break;
            case -1608145821:
                if (str.equals("touchStart")) {
                    b = 3;
                }
                break;
            case -1332194002:
                if (str.equals("background")) {
                    b = 9;
                }
                break;
            case -1276222986:
                if (str.equals("Lottie://state")) {
                    b = cc.k;
                }
                break;
            case -819563236:
                if (str.equals("touchEnd")) {
                    b = 4;
                }
                break;
            case 114595:
                if (str.equals("tap")) {
                    b = 0;
                }
                break;
            case 109399814:
                if (str.equals("shake")) {
                    b = 5;
                }
                break;
            case 109526449:
                if (str.equals("slide")) {
                    b = 1;
                }
                break;
            case 110364485:
                if (str.equals("timer")) {
                    b = 7;
                }
                break;
            case 110778151:
                if (str.equals("twist")) {
                    b = 6;
                }
                break;
            case 348725127:
                if (str.equals("longTap")) {
                    b = 2;
                }
                break;
            case 466743410:
                if (str.equals("visible")) {
                    b = 10;
                }
                break;
            case 1033717296:
                if (str.equals("animateState")) {
                    b = 12;
                }
                break;
            case 1984457027:
                if (str.equals("foreground")) {
                    b = 8;
                }
                break;
        }
        switch (b) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
                return "gesture";
            case 5:
            case 6:
                return an.ac;
            case 7:
                return "timer";
            case 8:
            case 9:
                return "appLifecycle";
            case 10:
            case 11:
                return "pageVisibility";
            case 12:
            case 13:
                return "animation";
            default:
                return null;
        }
    }
}
