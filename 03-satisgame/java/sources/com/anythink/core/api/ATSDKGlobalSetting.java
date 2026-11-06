package com.anythink.core.api;

import android.content.Context;
import com.anythink.core.common.d.s;
import com.anythink.core.common.f;
import com.anythink.core.common.q;
import com.anythink.core.e.l;
import com.anythink.core.e.n;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ATSDKGlobalSetting {
    public static long mDelayInspectTime = 0;
    private static boolean mDenyApi_getRunningAppProcesses = false;
    public static long mInspectInterval;
    private static final List<String> sensorNetworkList = new CopyOnWriteArrayList();
    public static SHAKE_TYPE shakeControlType = SHAKE_TYPE.DEFAULT_NETWORK;
    public static boolean isHideNavAndStatusBar = false;
    public static boolean enableGetDeviceInfoInBg = false;
    public static Boolean isGlobalMute = null;

    public enum SHAKE_TYPE {
        DEFAULT_NETWORK,
        FORBID_ALL,
        ALLOW_ALL,
        ALLOW_NETWORK
    }

    public static void setDenyApi_getRunningAppProcesses(boolean z) {
        mDenyApi_getRunningAppProcesses = z;
    }

    public static boolean isDenyApi_getRunningAppProcesses() {
        return mDenyApi_getRunningAppProcesses;
    }

    public static void needTraminiInfo(Context context, boolean z) {
        q.a(context).a(z);
    }

    @Deprecated
    public static void clearCache(String str, int i) {
        n nVarA;
        l lVarF;
        s sVarB = s.b();
        try {
            if (sVarB.g() == null || (nVarA = n.a(sVarB.g())) == null || (lVarF = nVarA.f(str)) == null) {
                return;
            }
            f fVarA = f.a(sVarB.g(), str, String.valueOf(lVarF.ap()));
            if (fVarA != null) {
                fVarA.a(i);
            }
        } catch (Exception unused) {
        }
    }

    @Deprecated
    public static void clearCache(String str, List<ATAdInfo> list) {
        n nVarA;
        l lVarF;
        s sVarB = s.b();
        try {
            if (sVarB.g() == null || (nVarA = n.a(sVarB.g())) == null || (lVarF = nVarA.f(str)) == null) {
                return;
            }
            f fVarA = f.a(sVarB.g(), str, String.valueOf(lVarF.ap()));
            if (fVarA != null) {
                fVarA.a(list);
            }
        } catch (Exception unused) {
        }
    }

    public static ATCustomContentInfo customContentReviewResult(List<ATCustomContentInfo> list) {
        return com.anythink.core.common.u.q.a(list);
    }

    public static ATCustomContentResult customContentResultReviewByInfos(List<ATCustomContentInfo> list) {
        return com.anythink.core.common.u.q.b(list);
    }

    public static void setHideNavAndStatusBar(boolean z) {
        isHideNavAndStatusBar = z;
    }

    public static void setEnableGetDeviceInfoInBg(boolean z) {
        enableGetDeviceInfoInBg = z;
    }

    public static void setAdMuted(Boolean bool) {
        isGlobalMute = bool;
    }

    public static void setShakeControl(SHAKE_TYPE shake_type, List<String> list) {
        try {
            if (shakeControlType != shake_type) {
                s.b();
                s.a(String.valueOf(shake_type.ordinal()), list != null ? list.toString() : new ArrayList().toString());
            }
            shakeControlType = shake_type;
            if (shake_type == SHAKE_TYPE.ALLOW_NETWORK && list != null && !list.isEmpty()) {
                List<String> list2 = sensorNetworkList;
                list2.clear();
                list2.addAll(list);
            }
            s.b().a(isShakeEnabled(66));
        } catch (Throwable unused) {
        }
    }

    public static Boolean isShakeEnabled(int i) {
        SHAKE_TYPE shake_type = shakeControlType;
        if (shake_type == SHAKE_TYPE.ALLOW_ALL) {
            return Boolean.TRUE;
        }
        if (shake_type == SHAKE_TYPE.FORBID_ALL) {
            return Boolean.FALSE;
        }
        if (shake_type == SHAKE_TYPE.ALLOW_NETWORK) {
            return Boolean.valueOf(sensorNetworkList.contains(String.valueOf(i)));
        }
        return null;
    }
}
