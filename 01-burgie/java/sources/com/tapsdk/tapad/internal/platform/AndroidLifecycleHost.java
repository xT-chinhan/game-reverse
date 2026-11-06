package com.tapsdk.tapad.internal.platform;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tapsdk.tapad.constants.Constants;
import com.tapsdk.tapad.internal.observability.AdnTelemetryHost;
import com.tapsdk.tapad.internal.runtime.AdnRuntimeCoreBridge;
import com.tapsdk.tapad.internal.runtime.CoreMediationTelemetryBridge;
import com.tapsdk.tapad.internal.runtime.DirichletRuntime;
import com.tapsdk.tapad.internal.utils.ActivityUtil;
import com.umeng.analytics.pro.d;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class AndroidLifecycleHost implements Application.ActivityLifecycleCallbacks {
    private static final long BACKGROUND_DELAY_MS = 700;
    private static final AndroidLifecycleHost INSTANCE = new AndroidLifecycleHost();
    private static final String TAG = "AndroidLifecycleHost";
    private Application application;
    private Runnable pendingBackground;
    private boolean screenOff;
    private BroadcastReceiver screenReceiver;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final AtomicBoolean initialized = new AtomicBoolean();
    private final AtomicBoolean foreground = new AtomicBoolean();
    private final List<AppStateListener> listeners = new CopyOnWriteArrayList();
    private final Set<Activity> startedActivities = Collections.newSetFromMap(new WeakHashMap());
    private volatile WeakReference<Activity> currentActivity = new WeakReference<>(null);

    public interface AppStateListener {
        void onAppBackground();

        void onAppForeground();
    }

    private AndroidLifecycleHost() {
    }

    private static String activityName(Activity activity) {
        return activity == null ? "unknown" : activity.getClass().getName();
    }

    private void cancelPendingBackground() {
        Runnable runnable = this.pendingBackground;
        if (runnable == null) {
            return;
        }
        this.mainHandler.removeCallbacks(runnable);
        this.pendingBackground = null;
    }

    private static void deliverCoreEvents(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        if (!CoreMediationTelemetryBridge.hasEnvelopeSink()) {
            AdnTelemetryHost.deliverCoreEvents(jSONArray);
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            CoreMediationTelemetryBridge.report(jSONArray.optJSONObject(i));
        }
    }

    public static AndroidLifecycleHost getInstance() {
        return INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: project, reason: merged with bridge method [inline-methods] */
    public JSONObject m195lambda$projectAsync$3$comtapsdktapadinternalplatformAndroidLifecycleHost(int i, JSONObject jSONObject) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Throwable th) {
                return null;
            }
        }
        jSONObject.put("fact_code", i);
        jSONObject.put("product_id", 2);
        AdnRuntimeCoreBridge.Result resultProjectPlatformLifecycle = AdnRuntimeCoreBridge.projectPlatformLifecycle(jSONObject);
        if (!resultProjectPlatformLifecycle.isSuccess()) {
            return null;
        }
        deliverCoreEvents(resultProjectPlatformLifecycle.output.optJSONArray(d.ar));
        return resultProjectPlatformLifecycle.output;
    }

    private void projectAsync(final int i, final JSONObject jSONObject) {
        DirichletRuntime.getInstance().runOnRuntimeQueue(new Runnable() { // from class: com.tapsdk.tapad.internal.platform.AndroidLifecycleHost$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m195lambda$projectAsync$3$comtapsdktapadinternalplatformAndroidLifecycleHost(i, jSONObject);
            }
        });
    }

    private void projectNavigationFact(int i, String str, String str2, String str3, boolean z, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.Bidding.REQUEST_ID, safe(str));
            jSONObject.put("track_id", safe(str2));
            jSONObject.put("landing_url", safe(str3));
            jSONObject.put("track_landing", z);
            jSONObject.put("duration_ms", Math.max(0L, j));
        } catch (Throwable th) {
        }
        projectAsync(i, jSONObject);
    }

    private void registerScreenReceiver(Context context) {
        this.screenReceiver = new BroadcastReceiver() { // from class: com.tapsdk.tapad.internal.platform.AndroidLifecycleHost.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                String action = intent == null ? null : intent.getAction();
                if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    AndroidLifecycleHost.this.screenOff = true;
                    AndroidLifecycleHost.this.updateForeground(false);
                } else if ("android.intent.action.SCREEN_ON".equals(action) || "android.intent.action.USER_PRESENT".equals(action)) {
                    AndroidLifecycleHost.this.screenOff = false;
                    if (AndroidLifecycleHost.this.startedActivities.isEmpty()) {
                        return;
                    }
                    AndroidLifecycleHost.this.updateForeground(true);
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                context.registerReceiver(this.screenReceiver, intentFilter, 4);
            } else {
                context.registerReceiver(this.screenReceiver, intentFilter);
            }
        } catch (Throwable th) {
            this.screenReceiver = null;
            th.getMessage();
        }
    }

    private static String safe(String str) {
        return str == null ? "" : str;
    }

    private void scheduleBackground() {
        cancelPendingBackground();
        Runnable runnable = new Runnable() { // from class: com.tapsdk.tapad.internal.platform.AndroidLifecycleHost$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m196lambda$scheduleBackground$2$comtapsdktapadinternalplatformAndroidLifecycleHost();
            }
        };
        this.pendingBackground = runnable;
        this.mainHandler.postDelayed(runnable, BACKGROUND_DELAY_MS);
    }

    private void unregisterScreenReceiver(Context context) {
        BroadcastReceiver broadcastReceiver = this.screenReceiver;
        this.screenReceiver = null;
        if (broadcastReceiver == null) {
            return;
        }
        try {
            context.unregisterReceiver(broadcastReceiver);
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateForeground(boolean z) {
        if (this.foreground.compareAndSet(!z, z)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("elapsed_realtime_ms", SystemClock.elapsedRealtime());
                jSONObject.put("event_time_ms", System.currentTimeMillis());
                jSONObject.put("screen_off", this.screenOff);
                jSONObject.put(com.tapsdk.tapad.group.constants.Constants.ACTIVITY_NAME_FIELD, activityName(getCurrentActivity()));
                Application application = this.application;
                jSONObject.put("package_name", application == null ? "" : application.getPackageName());
            } catch (Throwable th) {
            }
            projectAsync(z ? 2 : 3, jSONObject);
            for (AppStateListener appStateListener : this.listeners) {
                if (z) {
                    try {
                        appStateListener.onAppForeground();
                    } catch (Throwable th2) {
                        th2.getMessage();
                    }
                } else {
                    appStateListener.onAppBackground();
                }
            }
        }
    }

    public void addAppStateListener(AppStateListener appStateListener) {
        if (appStateListener == null || this.listeners.contains(appStateListener)) {
            return;
        }
        this.listeners.add(appStateListener);
    }

    public long beginDeepLinkJump(String str, String str2, String str3, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            Activity currentActivity = getCurrentActivity();
            jSONObject.put(Constants.Bidding.REQUEST_ID, safe(str));
            jSONObject.put("track_id", safe(str2));
            jSONObject.put("deeplink_url", safe(str3));
            jSONObject.put(com.tapsdk.tapad.group.constants.Constants.ACTIVITY_NAME_FIELD, activityName(currentActivity));
            jSONObject.put("track_landing", z);
        } catch (Throwable th) {
        }
        JSONObject jSONObjectM195lambda$projectAsync$3$comtapsdktapadinternalplatformAndroidLifecycleHost = m195lambda$projectAsync$3$comtapsdktapadinternalplatformAndroidLifecycleHost(4, jSONObject);
        if (jSONObjectM195lambda$projectAsync$3$comtapsdktapadinternalplatformAndroidLifecycleHost == null) {
            return 0L;
        }
        return jSONObjectM195lambda$projectAsync$3$comtapsdktapadinternalplatformAndroidLifecycleHost.optLong("token", 0L);
    }

    public void cancelDeepLinkJump(long j) {
        if (j <= 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("token", j);
        } catch (Throwable th) {
        }
        m195lambda$projectAsync$3$comtapsdktapadinternalplatformAndroidLifecycleHost(6, jSONObject);
    }

    public void confirmDeepLinkJump(long j) {
        if (j <= 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("token", j);
            jSONObject.put("event_time_ms", System.currentTimeMillis());
        } catch (Throwable th) {
        }
        m195lambda$projectAsync$3$comtapsdktapadinternalplatformAndroidLifecycleHost(5, jSONObject);
    }

    /* JADX INFO: renamed from: destroy, reason: merged with bridge method [inline-methods] */
    public void m193lambda$destroy$1$comtapsdktapadinternalplatformAndroidLifecycleHost(Context context) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            final Context applicationContext = context != null ? context.getApplicationContext() : null;
            this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.platform.AndroidLifecycleHost$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m193lambda$destroy$1$comtapsdktapadinternalplatformAndroidLifecycleHost(applicationContext);
                }
            });
            return;
        }
        if (this.initialized.compareAndSet(true, false)) {
            cancelPendingBackground();
            Application application = this.application;
            if (application != null) {
                application.unregisterActivityLifecycleCallbacks(this);
                unregisterScreenReceiver(this.application);
            }
            this.application = null;
            this.startedActivities.clear();
            this.currentActivity = new WeakReference<>(null);
            this.listeners.clear();
            this.foreground.set(false);
        }
    }

    public Activity getCurrentActivity() {
        Activity activity = this.currentActivity.get();
        if (ActivityUtil.isActivityAlive(activity)) {
            return activity;
        }
        Activity stackTopActivitySync = ActivityUtil.getStackTopActivitySync();
        if (!ActivityUtil.isActivityAlive(stackTopActivitySync)) {
            return null;
        }
        this.currentActivity = new WeakReference<>(stackTopActivitySync);
        return stackTopActivitySync;
    }

    /* JADX INFO: renamed from: init, reason: merged with bridge method [inline-methods] */
    public void m194lambda$init$0$comtapsdktapadinternalplatformAndroidLifecycleHost(Context context) {
        final Context applicationContext = context == null ? null : context.getApplicationContext();
        if (applicationContext != null && Looper.myLooper() != Looper.getMainLooper()) {
            this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.platform.AndroidLifecycleHost$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m194lambda$init$0$comtapsdktapadinternalplatformAndroidLifecycleHost(applicationContext);
                }
            });
            return;
        }
        if ((applicationContext instanceof Application) && this.initialized.compareAndSet(false, true)) {
            Application application = (Application) applicationContext;
            this.application = application;
            application.registerActivityLifecycleCallbacks(this);
            registerScreenReceiver(applicationContext);
            Activity stackTopActivitySync = ActivityUtil.getStackTopActivitySync();
            if (ActivityUtil.isActivityAlive(stackTopActivitySync)) {
                this.currentActivity = new WeakReference<>(stackTopActivitySync);
                this.startedActivities.add(stackTopActivitySync);
                updateForeground(true);
            }
        }
    }

    public boolean isAppInForeground() {
        return this.foreground.get();
    }

    /* JADX INFO: renamed from: lambda$scheduleBackground$2$com-tapsdk-tapad-internal-platform-AndroidLifecycleHost, reason: not valid java name */
    /* synthetic */ void m196lambda$scheduleBackground$2$comtapsdktapadinternalplatformAndroidLifecycleHost() {
        this.pendingBackground = null;
        if (this.startedActivities.isEmpty()) {
            updateForeground(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        projectAsync(1, null);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        this.startedActivities.remove(activity);
        if (this.currentActivity.get() == activity) {
            this.currentActivity = new WeakReference<>(null);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.currentActivity = new WeakReference<>(activity);
        cancelPendingBackground();
        projectAsync(1, null);
        updateForeground(true);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.screenOff = false;
        this.currentActivity = new WeakReference<>(activity);
        this.startedActivities.add(activity);
        cancelPendingBackground();
        updateForeground(true);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        this.startedActivities.remove(activity);
        if (this.startedActivities.isEmpty()) {
            scheduleBackground();
        }
    }

    public void recordLandingClosed(String str, String str2, String str3, boolean z, long j) {
        projectNavigationFact(8, str, str2, str3, z, j);
    }

    public void recordLandingLoaded(String str, String str2, String str3, boolean z, long j) {
        projectNavigationFact(7, str, str2, str3, z, j);
    }

    public void removeAppStateListener(AppStateListener appStateListener) {
        this.listeners.remove(appStateListener);
    }
}
