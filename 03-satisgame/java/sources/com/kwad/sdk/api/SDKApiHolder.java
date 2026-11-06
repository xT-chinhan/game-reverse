package com.kwad.sdk.api;

import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.loader.ApiLogger;
import com.kwad.sdk.api.util.ApiExecutorUtils;
import com.kwad.sdk.api.util.ApiSafeRunnable;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class SDKApiHolder {
    private static final String TAG = "SDKApiHolder";
    private static List<Throwable> mThrowableList;
    private static IKsAdSDK sSDK;
    public static Set<String> sThrowClassNotFoundSet;

    public static void holdSDK(IKsAdSDK iKsAdSDK) {
        sSDK = iKsAdSDK;
        initThrowClassNotFoundSet();
    }

    public static IKsAdSDK getSDK() {
        return sSDK;
    }

    public static boolean disableDynamic() {
        Boolean bool = (Boolean) doAction(ApiDMAction.enableDynamic, new Object[0]);
        return (bool == null || bool.booleanValue()) ? false : true;
    }

    public static int getAutoRevertTime() {
        Integer num = (Integer) doAction(ApiDMAction.getAutoRevertTime, new Object[0]);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public static void initThrowClassNotFoundSet() {
        try {
            sThrowClassNotFoundSet = (Set) doAction(ApiDMAction.getThrowClassNotFoundSet, new Object[0]);
        } catch (Throwable unused) {
            sThrowClassNotFoundSet = null;
        }
    }

    public static <T> T doAction(String str, Object... objArr) {
        try {
            T t = (T) sSDK.dM(str, objArr);
            if (t != null) {
                return t;
            }
            return null;
        } catch (Throwable th) {
            ApiLogger.handleException(th);
            return null;
        }
    }

    public static String getUpdateUrl(String str) {
        return (String) doAction(ApiDMAction.TRANSFORM_API_HOST, str);
    }

    public static void report(Throwable th) {
        try {
            if (sSDK != null && KsAdSDK.haseInit()) {
                sSDK.re(th);
            } else {
                addThrowableToCache(th);
            }
        } catch (Throwable unused) {
        }
    }

    private static void addThrowableToCache(Throwable th) {
        try {
            if (mThrowableList == null) {
                mThrowableList = new CopyOnWriteArrayList();
            }
            mThrowableList.add(th);
        } catch (Throwable unused) {
        }
    }

    public static void reportCacheThrowable() {
        try {
            ApiExecutorUtils.submit(new ApiSafeRunnable() { // from class: com.kwad.sdk.api.SDKApiHolder.1
                @Override // com.kwad.sdk.api.util.ApiSafeRunnable
                public void doTask() {
                    try {
                        if (SDKApiHolder.mThrowableList == null) {
                            return;
                        }
                        for (Throwable th : SDKApiHolder.mThrowableList) {
                            if (SDKApiHolder.sSDK != null && KsAdSDK.haseInit()) {
                                SDKApiHolder.sSDK.re(th);
                            }
                        }
                        SDKApiHolder.mThrowableList.clear();
                        List unused = SDKApiHolder.mThrowableList = null;
                    } catch (Throwable unused2) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }
}
