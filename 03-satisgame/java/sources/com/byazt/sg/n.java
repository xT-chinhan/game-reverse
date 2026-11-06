package com.byazt.sg;

import android.text.TextUtils;
import com.anythink.core.common.d.i;
import com.byazt.ws.tj;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 27, 19})
public final class n {
    public static String n(int i) {
        if (i == 3) {
            return MediationConstant.ADN_GDT;
        }
        if (i == 1) {
            return MediationConstant.ADN_PANGLE;
        }
        if (i == 4) {
            return MediationConstant.ADN_MINTEGRAL;
        }
        if (i == 5) {
            return MediationConstant.ADN_UNITY;
        }
        if (i == 6) {
            return "baidu";
        }
        if (i == 7) {
            return MediationConstant.ADN_KS;
        }
        if (i == 8) {
            return MediationConstant.ADN_SIGMOB;
        }
        if (i == 9) {
            return MediationConstant.ADN_KLEVIN;
        }
        if (i == 10) {
            return MediationConstant.ADN_XIAOMI;
        }
        return i == -1 ? "custom" : "";
    }

    public static String n(int i, int i2) {
        switch (i) {
            case 1:
                return i.o.c;
            case 2:
                return i.o.d;
            case 3:
            case 4:
                return i.o.e;
            case 5:
                if (i2 == 4) {
                    return i.o.a;
                }
                if (i2 == 5) {
                    return "Draw";
                }
                return i2 == 3 ? i.o.c : i.o.a;
            case 6:
            default:
                return null;
            case 7:
                if (i2 == 6) {
                    return "RewardVideo";
                }
                if (i2 == 7) {
                    return "FullVideo";
                }
                return i2 == 8 ? i.o.d : "RewardVideo";
            case 8:
                return "FullVideo";
            case 9:
                return "Draw";
            case 10:
                if (i2 == 1) {
                    return i.o.d;
                }
                if (i2 == 2) {
                    return "FullVideo";
                }
                return null;
        }
    }

    public static String qg(int i) {
        switch (i) {
            case 1:
                return i.o.c;
            case 2:
                return i.o.d;
            case 3:
            case 4:
                return i.o.e;
            case 5:
                return i.o.a;
            case 6:
            default:
                return "UnKnow";
            case 7:
                return "RewardVideo";
            case 8:
                return "FullVideo";
            case 9:
                return "Draw";
            case 10:
                return "InterstitialFull";
        }
    }

    public static String n(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.equalsIgnoreCase(MediationConstant.ADN_GDT)) {
            return MediationConstant.ADN_GDT;
        }
        if (str.equalsIgnoreCase(MediationConstant.ADN_PANGLE)) {
            return MediationConstant.ADN_PANGLE;
        }
        if (str.equalsIgnoreCase(MediationConstant.ADN_MINTEGRAL)) {
            return MediationConstant.ADN_MINTEGRAL;
        }
        if (str.equalsIgnoreCase(MediationConstant.ADN_UNITY)) {
            return MediationConstant.ADN_UNITY;
        }
        if (str.equalsIgnoreCase("baidu")) {
            return "baidu";
        }
        if (str.equalsIgnoreCase(MediationConstant.ADN_KS)) {
            return MediationConstant.ADN_KS;
        }
        if (str.equalsIgnoreCase(MediationConstant.ADN_SIGMOB)) {
            return MediationConstant.ADN_SIGMOB;
        }
        if (str.equalsIgnoreCase(MediationConstant.ADN_KLEVIN)) {
            return MediationConstant.ADN_KLEVIN;
        }
        return str.equalsIgnoreCase(MediationConstant.ADN_XIAOMI) ? MediationConstant.ADN_XIAOMI : str;
    }

    public static int qg(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.startsWith(MediationConstant.ADN_GDT)) {
            return 3;
        }
        if (str.equalsIgnoreCase(MediationConstant.ADN_PANGLE)) {
            return 1;
        }
        if (str.equalsIgnoreCase(MediationConstant.ADN_MINTEGRAL)) {
            return 4;
        }
        if (str.equalsIgnoreCase(MediationConstant.ADN_UNITY)) {
            return 5;
        }
        if (str.equalsIgnoreCase("baidu")) {
            return 6;
        }
        if (str.equalsIgnoreCase(MediationConstant.ADN_KS)) {
            return 7;
        }
        if (str.equalsIgnoreCase(MediationConstant.ADN_SIGMOB)) {
            return 8;
        }
        if (str.equalsIgnoreCase(MediationConstant.ADN_KLEVIN)) {
            return 9;
        }
        return str.equalsIgnoreCase(MediationConstant.ADN_XIAOMI) ? 10 : -1;
    }

    public static String n(int i, int i2, tj tjVar) {
        switch (i) {
            case 1:
                return i.o.c;
            case 2:
                return i.o.d;
            case 3:
            case 4:
                return i.o.e;
            case 5:
                if (i2 != 4) {
                    if (i2 == 5) {
                        return "NativeDraw";
                    }
                    return i2 == 3 ? i.o.c : "Native-自渲染";
                }
                if (tjVar == null) {
                    return "Native-自渲染";
                }
                int iTj = tjVar.tj();
                if (TextUtils.equals(tjVar.hd(), "baidu") && (iTj == 1 || iTj == 2)) {
                    return "Native-自渲染";
                }
                return (iTj == 1 || iTj == 3) ? "Native-模板渲染" : "Native-自渲染";
            case 6:
            default:
                return null;
            case 7:
                if (i2 == 6) {
                    return "Reward_RewardVideo";
                }
                if (i2 == 7) {
                    return "Reward_FullVideo";
                }
                return i2 == 8 ? "Reward_Interstitial" : "Reward_RewardVideo";
            case 8:
                return "FullVideo";
            case 9:
                return "NativeDraw";
            case 10:
                if (i2 == 1) {
                    return "InterstitialFull—Interstitial";
                }
                if (i2 == 2) {
                    return "InterstitialFull—FullVideo";
                }
                return null;
        }
    }
}
