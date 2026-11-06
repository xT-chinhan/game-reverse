package com.tapsdk.tapad.lib_tapadadapter;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.tapsdk.tapad.TapAdConfig;
import com.tapsdk.tapad.TapAdManager;
import com.tapsdk.tapad.TapAdNative;
import com.tapsdk.tapad.TapAdSdk;
import com.tapsdk.tapad.group.adapter.AdapterInitCallback;
import com.tapsdk.tapad.group.adapter.AdapterInitConfig;
import com.tapsdk.tapad.group.adapter.AdapterInitializer;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class TapTapADNManagerHolder implements AdapterInitializer {
    public static WeakHashMap<Context, TapAdNative> tapAdNativeMap = new WeakHashMap<>();
    private static volatile boolean activityCleanupRegistered = false;

    public static String dirichletActualPartnerVersion() {
        return "5.3.0.1";
    }

    public static int dirichletAdapterVersionRule() {
        return 1;
    }

    public static int dirichletCapabilityMask() {
        return 63;
    }

    public static int dirichletPartnerVersionRule() {
        return 1;
    }

    public static String dirichletPinnedPartnerVersion() {
        return "5.3.0.1";
    }

    public static boolean dirichletPlatformSupported() {
        return true;
    }

    private static void disposeAdNative(TapAdNative tapAdNative) {
        if (tapAdNative == null) {
            return;
        }
        try {
            tapAdNative.dispose();
        } catch (Throwable th) {
        }
    }

    private static void ensureActivityCleanupRegistered(Context context) {
        if (activityCleanupRegistered || context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext instanceof Application) {
            synchronized (TapTapADNManagerHolder.class) {
                if (activityCleanupRegistered) {
                    return;
                }
                ((Application) applicationContext).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.tapsdk.tapad.lib_tapadadapter.TapTapADNManagerHolder.1
                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityCreated(Activity activity, Bundle bundle) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityDestroyed(Activity activity) {
                        TapTapADNManagerHolder.releaseAdNative(activity);
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPaused(Activity activity) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityResumed(Activity activity) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStarted(Activity activity) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStopped(Activity activity) {
                    }
                });
                activityCleanupRegistered = true;
            }
        }
    }

    public static TapAdNative getOrCreateAdNative(Context context) {
        TapAdNative tapAdNativeCreateAdNative;
        if (context == null) {
            return null;
        }
        ensureActivityCleanupRegistered(context);
        synchronized (tapAdNativeMap) {
            releaseDestroyedActivitiesLocked();
            tapAdNativeCreateAdNative = tapAdNativeMap.get(context);
            if (tapAdNativeCreateAdNative == null) {
                tapAdNativeCreateAdNative = TapAdManager.get().createAdNative(context);
                tapAdNativeMap.put(context, tapAdNativeCreateAdNative);
            }
        }
        return tapAdNativeCreateAdNative;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void releaseAdNative(Context context) {
        TapAdNative tapAdNativeRemove;
        if (context == null) {
            return;
        }
        synchronized (tapAdNativeMap) {
            tapAdNativeRemove = tapAdNativeMap.remove(context);
        }
        disposeAdNative(tapAdNativeRemove);
    }

    private static void releaseDestroyedActivitiesLocked() {
        Iterator<Map.Entry<Context, TapAdNative>> it = tapAdNativeMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Context, TapAdNative> next = it.next();
            Context key = next.getKey();
            if ((key instanceof Activity) && ((Activity) key).isDestroyed()) {
                TapAdNative value = next.getValue();
                it.remove();
                disposeAdNative(value);
            }
        }
    }

    public static void requestPermissionIfNecessary(Context context) {
        TapAdManager.get().requestPermissionIfNecessary(context, true);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterInitializer
    public void initialize(Context context, AdapterInitConfig adapterInitConfig, AdapterInitCallback adapterInitCallback) {
        ensureActivityCleanupRegistered(context);
        TapAdSdk.init(context, new TapAdConfig.Builder().withMediaId(Long.parseLong(adapterInitConfig.getMediaId())).withMediaName(adapterInitConfig.getMediaName()).withMediaKey(adapterInitConfig.getMediaKey()).enableDebug(adapterInitConfig.isDebug()).withMediaVersion("1").withGameChannel("").withTapClientId(adapterInitConfig.getTapClientId()).withCustomController(adapterInitConfig.getRawPrivacyController()).withAggregationChannel(TapAdConfig.AggregationChannel.DIRICHLET).withData(adapterInitConfig.getData()).shakeEnabled(adapterInitConfig.isEnableShake()).build());
        adapterInitCallback.onSuccess();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterInitializer
    public void updateGlobalSettings(AdapterInitConfig adapterInitConfig, String str, String str2) {
        TapAdSdk.putMediaGlobalSettings(str, str2);
    }
}
