package com.taptap.sdk.kit.internal.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.taptap.sdk.kit.internal.TapLogger;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: TapActivityLifecycleTracker.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000fH\u0002¢\u0006\u0002\u0010\u0010J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012H\u0002J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012H\u0002J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0002J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0002J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0002J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0007J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\nJ\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u000e\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\rJ\u0010\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u0005H\u0002J\u000e\u0010$\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\rR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/taptap/sdk/kit/internal/utils/TapActivityLifecycleTracker;", "", "()V", "activityList", "Ljava/util/LinkedList;", "Landroid/app/Activity;", "configCount", "", "foregroundCount", "isBackground", "", "mActivityLifecycleCallbacks", "", "Lcom/taptap/sdk/kit/internal/utils/TapActivityLifecycleCallbacks;", "collectActivityLifecycleCallbacks", "", "()[Lcom/taptap/sdk/kit/internal/utils/TapActivityLifecycleCallbacks;", "getActivitiesByReflect", "", "getActivityList", "getActivityThread", "getActivityThreadInActivityThreadStaticField", "getActivityThreadInActivityThreadStaticMethod", "getTopActivity", "init", "", "context", "Landroid/content/Context;", "isAppForeground", "log", NotificationCompat.CATEGORY_MESSAGE, "", "registerActivityLifecycleCallbacks", "callback", "setTopActivity", "activity", "unregisterActivityLifecycleCallbacks", "tap-kit_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapActivityLifecycleTracker {
    private static int configCount;
    private static int foregroundCount;
    private static boolean isBackground;
    public static final TapActivityLifecycleTracker INSTANCE = new TapActivityLifecycleTracker();
    private static final List<TapActivityLifecycleCallbacks> mActivityLifecycleCallbacks = new ArrayList();
    private static final LinkedList<Activity> activityList = new LinkedList<>();

    /* JADX INFO: Access modifiers changed from: private */
    public final void log(String msg) {
    }

    private TapActivityLifecycleTracker() {
    }

    public final boolean isAppForeground() {
        return !isBackground;
    }

    @JvmStatic
    public static final Activity getTopActivity() {
        for (Activity activity : INSTANCE.getActivityList()) {
            if (TapActivityUtils.INSTANCE.isActivityAlive(activity)) {
                return activity;
            }
        }
        return null;
    }

    public final void registerActivityLifecycleCallbacks(TapActivityLifecycleCallbacks callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        List<TapActivityLifecycleCallbacks> list = mActivityLifecycleCallbacks;
        synchronized (list) {
            if (!list.contains(callback)) {
                list.add(callback);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void unregisterActivityLifecycleCallbacks(TapActivityLifecycleCallbacks callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        List<TapActivityLifecycleCallbacks> list = mActivityLifecycleCallbacks;
        synchronized (list) {
            list.remove(callback);
        }
    }

    public final void init(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Application application = context instanceof Application ? (Application) context : null;
        if (application != null) {
            application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.taptap.sdk.kit.internal.utils.TapActivityLifecycleTracker.init.1
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    TapActivityLifecycleTracker.INSTANCE.log("onActivityCreated [" + activity.getClass().getName() + AbstractJsonLexerKt.END_LIST);
                    TapActivityLifecycleTracker.INSTANCE.setTopActivity(activity);
                    TapActivityLifecycleCallbacks[] tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks = TapActivityLifecycleTracker.INSTANCE.collectActivityLifecycleCallbacks();
                    if (tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks != null) {
                        for (TapActivityLifecycleCallbacks tapActivityLifecycleCallbacks : tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks) {
                            tapActivityLifecycleCallbacks.onActivityCreated(activity, savedInstanceState);
                        }
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    TapActivityLifecycleTracker.INSTANCE.log("onActivityStarted [" + activity.getClass().getName() + AbstractJsonLexerKt.END_LIST);
                    if (!TapActivityLifecycleTracker.isBackground) {
                        TapActivityLifecycleTracker.INSTANCE.setTopActivity(activity);
                    }
                    if (TapActivityLifecycleTracker.configCount < 0) {
                        TapActivityLifecycleTracker tapActivityLifecycleTracker = TapActivityLifecycleTracker.INSTANCE;
                        TapActivityLifecycleTracker.configCount++;
                        int unused = TapActivityLifecycleTracker.configCount;
                    } else {
                        TapActivityLifecycleTracker tapActivityLifecycleTracker2 = TapActivityLifecycleTracker.INSTANCE;
                        TapActivityLifecycleTracker.foregroundCount++;
                        int unused2 = TapActivityLifecycleTracker.foregroundCount;
                    }
                    TapActivityLifecycleCallbacks[] tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks = TapActivityLifecycleTracker.INSTANCE.collectActivityLifecycleCallbacks();
                    if (tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks != null) {
                        for (TapActivityLifecycleCallbacks tapActivityLifecycleCallbacks : tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks) {
                            tapActivityLifecycleCallbacks.onActivityStarted(activity);
                        }
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    TapActivityLifecycleTracker.INSTANCE.log("onActivityResumed [" + activity.getClass().getName() + AbstractJsonLexerKt.END_LIST);
                    TapActivityLifecycleTracker.INSTANCE.setTopActivity(activity);
                    if (TapActivityLifecycleTracker.isBackground) {
                        TapLogger.logv("TapActivityLifecycleTracker", "App onForeground");
                        TapActivityLifecycleTracker tapActivityLifecycleTracker = TapActivityLifecycleTracker.INSTANCE;
                        TapActivityLifecycleTracker.isBackground = false;
                        TapActivityLifecycleCallbacks[] tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks = TapActivityLifecycleTracker.INSTANCE.collectActivityLifecycleCallbacks();
                        if (tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks != null) {
                            for (TapActivityLifecycleCallbacks tapActivityLifecycleCallbacks : tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks) {
                                tapActivityLifecycleCallbacks.onForeground(activity);
                            }
                        }
                    }
                    TapActivityLifecycleCallbacks[] tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks2 = TapActivityLifecycleTracker.INSTANCE.collectActivityLifecycleCallbacks();
                    if (tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks2 != null) {
                        for (TapActivityLifecycleCallbacks tapActivityLifecycleCallbacks2 : tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks2) {
                            tapActivityLifecycleCallbacks2.onActivityResumed(activity);
                        }
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    TapActivityLifecycleTracker.INSTANCE.log("onActivityPaused [" + activity.getClass().getName() + AbstractJsonLexerKt.END_LIST);
                    TapActivityLifecycleCallbacks[] tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks = TapActivityLifecycleTracker.INSTANCE.collectActivityLifecycleCallbacks();
                    if (tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks != null) {
                        for (TapActivityLifecycleCallbacks tapActivityLifecycleCallbacks : tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks) {
                            tapActivityLifecycleCallbacks.onActivityPaused(activity);
                        }
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    TapActivityLifecycleTracker.INSTANCE.log("onActivityStopped [" + activity.getClass().getName() + AbstractJsonLexerKt.END_LIST);
                    if (activity.isChangingConfigurations()) {
                        TapActivityLifecycleTracker tapActivityLifecycleTracker = TapActivityLifecycleTracker.INSTANCE;
                        TapActivityLifecycleTracker.configCount--;
                        int unused = TapActivityLifecycleTracker.configCount;
                    } else {
                        TapActivityLifecycleTracker tapActivityLifecycleTracker2 = TapActivityLifecycleTracker.INSTANCE;
                        TapActivityLifecycleTracker.foregroundCount--;
                        int unused2 = TapActivityLifecycleTracker.foregroundCount;
                        if (TapActivityLifecycleTracker.foregroundCount <= 0) {
                            TapActivityLifecycleTracker tapActivityLifecycleTracker3 = TapActivityLifecycleTracker.INSTANCE;
                            TapActivityLifecycleTracker.isBackground = true;
                            TapActivityLifecycleCallbacks[] tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks = TapActivityLifecycleTracker.INSTANCE.collectActivityLifecycleCallbacks();
                            if (tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks != null) {
                                for (TapActivityLifecycleCallbacks tapActivityLifecycleCallbacks : tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks) {
                                    tapActivityLifecycleCallbacks.onBackground(activity);
                                }
                            }
                        }
                    }
                    TapActivityLifecycleCallbacks[] tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks2 = TapActivityLifecycleTracker.INSTANCE.collectActivityLifecycleCallbacks();
                    if (tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks2 != null) {
                        for (TapActivityLifecycleCallbacks tapActivityLifecycleCallbacks2 : tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks2) {
                            tapActivityLifecycleCallbacks2.onActivityStopped(activity);
                        }
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    Intrinsics.checkNotNullParameter(outState, "outState");
                    TapActivityLifecycleCallbacks[] tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks = TapActivityLifecycleTracker.INSTANCE.collectActivityLifecycleCallbacks();
                    if (tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks != null) {
                        for (TapActivityLifecycleCallbacks tapActivityLifecycleCallbacks : tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks) {
                            tapActivityLifecycleCallbacks.onActivitySaveInstanceState(activity, outState);
                        }
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    TapActivityLifecycleTracker.activityList.remove(activity);
                    TapActivityLifecycleCallbacks[] tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks = TapActivityLifecycleTracker.INSTANCE.collectActivityLifecycleCallbacks();
                    if (tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks != null) {
                        for (TapActivityLifecycleCallbacks tapActivityLifecycleCallbacks : tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks) {
                            tapActivityLifecycleCallbacks.onActivityDestroyed(activity);
                        }
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPreCreated(Activity activity, Bundle savedInstanceState) {
                    TapActivityLifecycleCallbacks[] tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks;
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    super.onActivityPreCreated(activity, savedInstanceState);
                    if (Build.VERSION.SDK_INT < 29 || (tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks = TapActivityLifecycleTracker.INSTANCE.collectActivityLifecycleCallbacks()) == null) {
                        return;
                    }
                    for (TapActivityLifecycleCallbacks tapActivityLifecycleCallbacks : tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks) {
                        tapActivityLifecycleCallbacks.onActivityPreCreated(activity, savedInstanceState);
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPostCreated(Activity activity, Bundle savedInstanceState) {
                    TapActivityLifecycleCallbacks[] tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks;
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    super.onActivityPostCreated(activity, savedInstanceState);
                    if (Build.VERSION.SDK_INT < 29 || (tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks = TapActivityLifecycleTracker.INSTANCE.collectActivityLifecycleCallbacks()) == null) {
                        return;
                    }
                    for (TapActivityLifecycleCallbacks tapActivityLifecycleCallbacks : tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks) {
                        tapActivityLifecycleCallbacks.onActivityPostCreated(activity, savedInstanceState);
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPreStarted(Activity activity) {
                    TapActivityLifecycleCallbacks[] tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks;
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    super.onActivityPreStarted(activity);
                    if (Build.VERSION.SDK_INT < 29 || (tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks = TapActivityLifecycleTracker.INSTANCE.collectActivityLifecycleCallbacks()) == null) {
                        return;
                    }
                    for (TapActivityLifecycleCallbacks tapActivityLifecycleCallbacks : tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks) {
                        tapActivityLifecycleCallbacks.onActivityPreStarted(activity);
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPostStarted(Activity activity) {
                    TapActivityLifecycleCallbacks[] tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks;
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    super.onActivityPostStarted(activity);
                    if (Build.VERSION.SDK_INT < 29 || (tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks = TapActivityLifecycleTracker.INSTANCE.collectActivityLifecycleCallbacks()) == null) {
                        return;
                    }
                    for (TapActivityLifecycleCallbacks tapActivityLifecycleCallbacks : tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks) {
                        tapActivityLifecycleCallbacks.onActivityPostStarted(activity);
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPreResumed(Activity activity) {
                    TapActivityLifecycleCallbacks[] tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks;
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    super.onActivityPreResumed(activity);
                    if (Build.VERSION.SDK_INT < 29 || (tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks = TapActivityLifecycleTracker.INSTANCE.collectActivityLifecycleCallbacks()) == null) {
                        return;
                    }
                    for (TapActivityLifecycleCallbacks tapActivityLifecycleCallbacks : tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks) {
                        tapActivityLifecycleCallbacks.onActivityPreResumed(activity);
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPostResumed(Activity activity) {
                    TapActivityLifecycleCallbacks[] tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks;
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    super.onActivityPostResumed(activity);
                    if (Build.VERSION.SDK_INT < 29 || (tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks = TapActivityLifecycleTracker.INSTANCE.collectActivityLifecycleCallbacks()) == null) {
                        return;
                    }
                    for (TapActivityLifecycleCallbacks tapActivityLifecycleCallbacks : tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks) {
                        tapActivityLifecycleCallbacks.onActivityPostResumed(activity);
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPrePaused(Activity activity) {
                    TapActivityLifecycleCallbacks[] tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks;
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    super.onActivityPrePaused(activity);
                    if (Build.VERSION.SDK_INT < 29 || (tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks = TapActivityLifecycleTracker.INSTANCE.collectActivityLifecycleCallbacks()) == null) {
                        return;
                    }
                    for (TapActivityLifecycleCallbacks tapActivityLifecycleCallbacks : tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks) {
                        tapActivityLifecycleCallbacks.onActivityPrePaused(activity);
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPostPaused(Activity activity) {
                    TapActivityLifecycleCallbacks[] tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks;
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    super.onActivityPostPaused(activity);
                    if (Build.VERSION.SDK_INT < 29 || (tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks = TapActivityLifecycleTracker.INSTANCE.collectActivityLifecycleCallbacks()) == null) {
                        return;
                    }
                    for (TapActivityLifecycleCallbacks tapActivityLifecycleCallbacks : tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks) {
                        tapActivityLifecycleCallbacks.onActivityPostPaused(activity);
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPreStopped(Activity activity) {
                    TapActivityLifecycleCallbacks[] tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks;
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    super.onActivityPreStopped(activity);
                    if (Build.VERSION.SDK_INT < 29 || (tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks = TapActivityLifecycleTracker.INSTANCE.collectActivityLifecycleCallbacks()) == null) {
                        return;
                    }
                    for (TapActivityLifecycleCallbacks tapActivityLifecycleCallbacks : tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks) {
                        tapActivityLifecycleCallbacks.onActivityPreStopped(activity);
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPostStopped(Activity activity) {
                    TapActivityLifecycleCallbacks[] tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks;
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    super.onActivityPostStopped(activity);
                    if (Build.VERSION.SDK_INT < 29 || (tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks = TapActivityLifecycleTracker.INSTANCE.collectActivityLifecycleCallbacks()) == null) {
                        return;
                    }
                    for (TapActivityLifecycleCallbacks tapActivityLifecycleCallbacks : tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks) {
                        tapActivityLifecycleCallbacks.onActivityPostStopped(activity);
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPreSaveInstanceState(Activity activity, Bundle outState) {
                    TapActivityLifecycleCallbacks[] tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks;
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    Intrinsics.checkNotNullParameter(outState, "outState");
                    super.onActivityPreSaveInstanceState(activity, outState);
                    if (Build.VERSION.SDK_INT < 29 || (tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks = TapActivityLifecycleTracker.INSTANCE.collectActivityLifecycleCallbacks()) == null) {
                        return;
                    }
                    for (TapActivityLifecycleCallbacks tapActivityLifecycleCallbacks : tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks) {
                        tapActivityLifecycleCallbacks.onActivityPreSaveInstanceState(activity, outState);
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPostSaveInstanceState(Activity activity, Bundle outState) {
                    TapActivityLifecycleCallbacks[] tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks;
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    Intrinsics.checkNotNullParameter(outState, "outState");
                    super.onActivityPostSaveInstanceState(activity, outState);
                    if (Build.VERSION.SDK_INT < 29 || (tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks = TapActivityLifecycleTracker.INSTANCE.collectActivityLifecycleCallbacks()) == null) {
                        return;
                    }
                    for (TapActivityLifecycleCallbacks tapActivityLifecycleCallbacks : tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks) {
                        tapActivityLifecycleCallbacks.onActivityPostSaveInstanceState(activity, outState);
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPreDestroyed(Activity activity) {
                    TapActivityLifecycleCallbacks[] tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks;
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    super.onActivityPreDestroyed(activity);
                    if (Build.VERSION.SDK_INT < 29 || (tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks = TapActivityLifecycleTracker.INSTANCE.collectActivityLifecycleCallbacks()) == null) {
                        return;
                    }
                    for (TapActivityLifecycleCallbacks tapActivityLifecycleCallbacks : tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks) {
                        tapActivityLifecycleCallbacks.onActivityPreDestroyed(activity);
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPostDestroyed(Activity activity) {
                    TapActivityLifecycleCallbacks[] tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks;
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    super.onActivityPostDestroyed(activity);
                    if (Build.VERSION.SDK_INT < 29 || (tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks = TapActivityLifecycleTracker.INSTANCE.collectActivityLifecycleCallbacks()) == null) {
                        return;
                    }
                    for (TapActivityLifecycleCallbacks tapActivityLifecycleCallbacks : tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks) {
                        tapActivityLifecycleCallbacks.onActivityPostDestroyed(activity);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTopActivity(Activity activity) {
        LinkedList<Activity> linkedList = activityList;
        if (linkedList.contains(activity)) {
            if (linkedList.getFirst().equals(activity)) {
                return;
            }
            linkedList.remove(activity);
            linkedList.addFirst(activity);
            return;
        }
        linkedList.addFirst(activity);
    }

    private final List<Activity> getActivityList() {
        LinkedList<Activity> linkedList = activityList;
        if (!linkedList.isEmpty()) {
            return new LinkedList(linkedList);
        }
        linkedList.addAll(getActivitiesByReflect());
        return new LinkedList(linkedList);
    }

    private final List<Activity> getActivitiesByReflect() {
        LinkedList linkedList = new LinkedList();
        Activity activity = null;
        try {
            Object activityThread = getActivityThread();
            if (activityThread == null) {
                return linkedList;
            }
            Field declaredField = activityThread.getClass().getDeclaredField("mActivities");
            Intrinsics.checkNotNullExpressionValue(declaredField, "activityThread.javaClass…laredField(\"mActivities\")");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(activityThread);
            Map map = obj instanceof Map ? (Map) obj : null;
            if (map == null) {
                return linkedList;
            }
            Activity activity2 = null;
            for (Object obj2 : map.values()) {
                try {
                    Class<?> cls = obj2.getClass();
                    Field declaredField2 = cls.getDeclaredField("activity");
                    Intrinsics.checkNotNullExpressionValue(declaredField2, "activityClientRecordClas…DeclaredField(\"activity\")");
                    declaredField2.setAccessible(true);
                    Object obj3 = declaredField2.get(obj2);
                    Activity activity3 = obj3 instanceof Activity ? (Activity) obj3 : null;
                    if (activity2 == null) {
                        Field declaredField3 = cls.getDeclaredField("paused");
                        Intrinsics.checkNotNullExpressionValue(declaredField3, "activityClientRecordClas…etDeclaredField(\"paused\")");
                        declaredField3.setAccessible(true);
                        if (declaredField3.getBoolean(obj2)) {
                            linkedList.addFirst(activity3);
                        } else {
                            activity2 = activity3;
                        }
                    } else {
                        linkedList.addFirst(activity3);
                    }
                } catch (Exception e) {
                    e = e;
                    activity = activity2;
                    TapLogger.logd("TapActivityLifecycleTracker", "getActivitiesByReflect", e);
                    activity2 = activity;
                }
            }
            if (activity2 != null) {
                linkedList.addFirst(activity2);
            }
            return linkedList;
        } catch (Exception e2) {
            e = e2;
        }
    }

    private final Object getActivityThread() {
        Object activityThreadInActivityThreadStaticField = getActivityThreadInActivityThreadStaticField();
        return activityThreadInActivityThreadStaticField != null ? activityThreadInActivityThreadStaticField : getActivityThreadInActivityThreadStaticMethod();
    }

    private final Object getActivityThreadInActivityThreadStaticField() {
        try {
            Field declaredField = Class.forName("android.app.ActivityThread").getDeclaredField("sCurrentActivityThread");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception e) {
            TapLogger.logd("TapActivityLifecycleTracker", "getActivityThreadInActivityThreadStaticField: ", e);
            return null;
        }
    }

    private final Object getActivityThreadInActivityThreadStaticMethod() {
        try {
            return Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e) {
            TapLogger.logd("TapActivityLifecycleTracker", "getActivityThreadInActivityThreadStaticMethod: ", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TapActivityLifecycleCallbacks[] collectActivityLifecycleCallbacks() {
        Object[] array;
        List<TapActivityLifecycleCallbacks> list = mActivityLifecycleCallbacks;
        synchronized (list) {
            array = list.size() > 0 ? list.toArray(new TapActivityLifecycleCallbacks[0]) : null;
            Unit unit = Unit.INSTANCE;
        }
        return (TapActivityLifecycleCallbacks[]) array;
    }
}
