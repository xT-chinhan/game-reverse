package com.anythink.core.api;

import android.content.Context;
import com.anythink.core.api.bridge.NetworkAgentEventManager;
import com.anythink.core.common.d.s;
import com.anythink.core.common.u.b.c;
import com.anythink.core.common.u.b.d;
import com.anythink.core.common.u.b.e;
import com.anythink.core.common.u.p;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class ATInitMediation {
    public static final String KEY_LOCAL = "anythink_local";
    protected String devBundleName;

    public List getActivityStatus() {
        return null;
    }

    public abstract int getAdapterBridgeVersion();

    public String getAdapterVersion() {
        return "";
    }

    public List getMetaValutStatus() {
        return null;
    }

    public String getNetworkName() {
        return "";
    }

    public String getNetworkSDKClass() {
        return "";
    }

    public String getNetworkVersion() {
        return "";
    }

    public List getPermissionStatus() {
        return null;
    }

    public Map<String, Boolean> getPluginClassStatus() {
        return null;
    }

    public List getProviderStatus() {
        return null;
    }

    public List getResourceStatus() {
        return null;
    }

    public List getServiceStatus() {
        return null;
    }

    public abstract void initSDK(Context context, Map<String, Object> map, MediationInitCallback mediationInitCallback);

    public boolean needCheckAdapterVersion() {
        return true;
    }

    public boolean setUserDataConsent(Context context, boolean z, boolean z2) {
        return false;
    }

    protected final void runOnThreadPool(Runnable runnable) {
        c.a().a(new d(e.ah, runnable), false);
    }

    protected final void runOnMainThread(Runnable runnable) {
        s.b();
        s.b(runnable);
    }

    protected final void checkToSaveInitData(String str, Map<String, Object> map, String... strArr) {
        s.b().a(str, map, strArr);
    }

    public static String getStringFromMap(Map<String, Object> map, String str) {
        return getStringFromMap(map, str, "");
    }

    public static String getStringFromMap(Map<String, Object> map, String str, String str2) {
        return (String) p.a(map, str, str2);
    }

    public static int getIntFromMap(Map<String, Object> map, String str) {
        return getIntFromMap(map, str, 0);
    }

    public static int getIntFromMap(Map<String, Object> map, String str, int i) {
        return ((Integer) p.a(map, str, Integer.valueOf(i))).intValue();
    }

    public static long getLongFromMap(Map<String, Object> map, String str) {
        return getLongFromMap(map, str, 0L);
    }

    public static long getLongFromMap(Map<String, Object> map, String str, long j) {
        return ((Long) p.a(map, str, Long.valueOf(j))).longValue();
    }

    public static double getDoubleFromMap(Map<String, Object> map, String str) {
        return getDoubleFromMap(map, str, 0.0d);
    }

    public static double getDoubleFromMap(Map<String, Object> map, String str, double d) {
        return ((Double) p.a(map, str, Double.valueOf(d))).doubleValue();
    }

    public static boolean getBooleanFromMap(Map<String, Object> map, String str) {
        return getBooleanFromMap(map, str, false);
    }

    public static boolean getBooleanFromMap(Map<String, Object> map, String str, boolean z) {
        return ((Boolean) p.a(map, str, Boolean.valueOf(z))).booleanValue();
    }

    public String getBundleName() {
        return s.b().U();
    }

    public void setDevBundleName(String str) {
        this.devBundleName = str;
    }

    public String getDevBundleName() {
        return this.devBundleName;
    }

    public String getUserId() {
        Map<String, Object> mapM = s.b().m();
        return mapM != null ? getStringFromMap(mapM, "user_id") : "";
    }

    protected final void sendNetworkEvent(final int i, final int i2, final Map<String, Object> map) {
        c.a().g(new d(e.ai, new Runnable() { // from class: com.anythink.core.api.ATInitMediation.1
            @Override // java.lang.Runnable
            public final void run() {
                NetworkAgentEventManager.handNetworkAgentEvent(i, i2, map);
            }
        }));
    }
}
