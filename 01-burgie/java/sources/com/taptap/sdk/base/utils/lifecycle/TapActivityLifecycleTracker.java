package com.taptap.sdk.base.utils.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.byazt.ol.TTDownloadField;
import com.umeng.analytics.pro.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.joor.Reflect;

/* JADX INFO: compiled from: TapActivityLifecycleTracker.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0014H\u0002¢\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u0017H\u0002J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u0017H\u0002J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0002J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0002J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0002J\n\u0010\u001c\u001a\u0004\u0018\u00010\fH\u0007J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020\u0011J\u000e\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\tJ\u0010\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\fH\u0002J\u000e\u0010&\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\tJ\u001a\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010(*\u00020\u0001H\u0002J\u000e\u0010)\u001a\u0004\u0018\u00010\f*\u00020\u0001H\u0002J\f\u0010*\u001a\u00020\u0011*\u00020\u0001H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/taptap/sdk/base/utils/lifecycle/TapActivityLifecycleTracker;", "", "()V", "DEFAULT_CALLBACKS", "Landroid/app/Application$ActivityLifecycleCallbacks;", "TAG", "", "activityLifecycleCallbacks", "", "Lcom/taptap/sdk/base/utils/lifecycle/TapActivityLifecycleCallbacks;", "activityList", "Ljava/util/LinkedList;", "Landroid/app/Activity;", "configCount", "", "foregroundCount", "isBackground", "", "isInitialized", "collectActivityLifecycleCallbacks", "", "()[Lcom/taptap/sdk/base/utils/lifecycle/TapActivityLifecycleCallbacks;", "getActivitiesByReflect", "", "getActivityList", "getActivityThread", "getActivityThreadInActivityThreadStaticField", "getActivityThreadInActivityThreadStaticMethod", "getTopActivity", "initialize", "", d.R, "Landroid/content/Context;", "isAppForeground", "registerActivityLifecycleCallbacks", "callback", "setTopActivity", TTDownloadField.TT_ACTIVITY, "unregisterActivityLifecycleCallbacks", "getActivitiesField", "", "getActivityField", "getActivityPausedField", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapActivityLifecycleTracker {
    private static final String TAG = "ActivityLifecycle";
    private static int configCount;
    private static int foregroundCount;
    private static boolean isBackground;
    private static boolean isInitialized;
    public static final TapActivityLifecycleTracker INSTANCE = new TapActivityLifecycleTracker();
    private static final List<TapActivityLifecycleCallbacks> activityLifecycleCallbacks = new ArrayList();
    private static final LinkedList<Activity> activityList = new LinkedList<>();
    private static final Application.ActivityLifecycleCallbacks DEFAULT_CALLBACKS = new Application.ActivityLifecycleCallbacks() { // from class: com.taptap.sdk.base.utils.lifecycle.TapActivityLifecycleTracker$DEFAULT_CALLBACKS$1
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Log.d("ActivityLifecycle", "onActivityCreated [" + activity.getClass().getName() + AbstractJsonLexerKt.END_LIST);
            TapActivityLifecycleTracker.INSTANCE.setTopActivity(activity);
            TapActivityLifecycleCallbacks[] tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks = TapActivityLifecycleTracker.INSTANCE.collectActivityLifecycleCallbacks();
            if (tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks == null) {
                return;
            }
            for (TapActivityLifecycleCallbacks tapActivityLifecycleCallbacks : tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks) {
                tapActivityLifecycleCallbacks.onActivityCreated(activity, savedInstanceState);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Log.d("ActivityLifecycle", "onActivityStarted [" + activity.getClass().getName() + AbstractJsonLexerKt.END_LIST);
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
            if (tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks == null) {
                return;
            }
            for (TapActivityLifecycleCallbacks tapActivityLifecycleCallbacks : tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks) {
                tapActivityLifecycleCallbacks.onActivityStarted(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Log.d("ActivityLifecycle", "onActivityResumed [" + activity.getClass().getName() + AbstractJsonLexerKt.END_LIST);
            TapActivityLifecycleTracker.INSTANCE.setTopActivity(activity);
            if (TapActivityLifecycleTracker.isBackground) {
                Log.d("ActivityLifecycle", "App onForeground");
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
            if (tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks2 == null) {
                return;
            }
            for (TapActivityLifecycleCallbacks tapActivityLifecycleCallbacks2 : tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks2) {
                tapActivityLifecycleCallbacks2.onActivityResumed(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Log.d("ActivityLifecycle", "onActivityPaused [" + activity.getClass().getName() + AbstractJsonLexerKt.END_LIST);
            TapActivityLifecycleCallbacks[] tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks = TapActivityLifecycleTracker.INSTANCE.collectActivityLifecycleCallbacks();
            if (tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks == null) {
                return;
            }
            for (TapActivityLifecycleCallbacks tapActivityLifecycleCallbacks : tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks) {
                tapActivityLifecycleCallbacks.onActivityPaused(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Log.d("ActivityLifecycle", "onActivityStopped [" + activity.getClass().getName() + AbstractJsonLexerKt.END_LIST);
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
            if (tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks2 == null) {
                return;
            }
            for (TapActivityLifecycleCallbacks tapActivityLifecycleCallbacks2 : tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks2) {
                tapActivityLifecycleCallbacks2.onActivityStopped(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(outState, "outState");
            TapActivityLifecycleCallbacks[] tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks = TapActivityLifecycleTracker.INSTANCE.collectActivityLifecycleCallbacks();
            if (tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks == null) {
                return;
            }
            for (TapActivityLifecycleCallbacks tapActivityLifecycleCallbacks : tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks) {
                tapActivityLifecycleCallbacks.onActivitySaveInstanceState(activity, outState);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            TapActivityLifecycleTracker.activityList.remove(activity);
            TapActivityLifecycleCallbacks[] tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks = TapActivityLifecycleTracker.INSTANCE.collectActivityLifecycleCallbacks();
            if (tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks == null) {
                return;
            }
            for (TapActivityLifecycleCallbacks tapActivityLifecycleCallbacks : tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks) {
                tapActivityLifecycleCallbacks.onActivityDestroyed(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(Activity activity, Bundle savedInstanceState) {
            TapActivityLifecycleCallbacks[] tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks;
            Intrinsics.checkNotNullParameter(activity, "activity");
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
            if (Build.VERSION.SDK_INT < 29 || (tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks = TapActivityLifecycleTracker.INSTANCE.collectActivityLifecycleCallbacks()) == null) {
                return;
            }
            for (TapActivityLifecycleCallbacks tapActivityLifecycleCallbacks : tapActivityLifecycleCallbacksArrCollectActivityLifecycleCallbacks) {
                tapActivityLifecycleCallbacks.onActivityPostDestroyed(activity);
            }
        }
    };

    private TapActivityLifecycleTracker() {
    }

    public final void initialize(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        synchronized (this) {
            if (isInitialized) {
                Log.d(TAG, "TapActivityLifecycleTracker already initialized, skipping.");
                return;
            }
            isInitialized = true;
            Log.d(TAG, "Initializing TapActivityLifecycleTracker");
            Application application = context instanceof Application ? (Application) context : null;
            if (application != null) {
                application.registerActivityLifecycleCallbacks(DEFAULT_CALLBACKS);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final boolean isAppForeground() {
        return !isBackground;
    }

    public final void registerActivityLifecycleCallbacks(TapActivityLifecycleCallbacks callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        List<TapActivityLifecycleCallbacks> list = activityLifecycleCallbacks;
        synchronized (list) {
            if (!list.contains(callback)) {
                list.add(callback);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void unregisterActivityLifecycleCallbacks(TapActivityLifecycleCallbacks callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        List<TapActivityLifecycleCallbacks> list = activityLifecycleCallbacks;
        synchronized (list) {
            list.remove(callback);
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTopActivity(Activity activity) {
        LinkedList<Activity> linkedList = activityList;
        if (linkedList.contains(activity)) {
            if (!linkedList.getFirst().equals(activity)) {
                linkedList.remove(activity);
                linkedList.addFirst(activity);
                return;
            }
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
        LinkedList list = new LinkedList();
        Activity activity = null;
        try {
            Object activityThread = getActivityThread();
            if (activityThread == null) {
                return list;
            }
            Map<Object, Object> activitiesField = getActivitiesField(activityThread);
            if (activitiesField == null) {
                return list;
            }
            Iterator<Map.Entry<Object, Object>> it = activitiesField.entrySet().iterator();
            while (it.hasNext()) {
                Object activityRecord = it.next().getValue();
                TapActivityLifecycleTracker tapActivityLifecycleTracker = INSTANCE;
                Activity activity2 = tapActivityLifecycleTracker.getActivityField(activityRecord);
                if (activity == null) {
                    boolean paused = tapActivityLifecycleTracker.getActivityPausedField(activityRecord);
                    if (!paused) {
                        activity = activity2;
                    } else if (activity2 != null) {
                        list.addFirst(activity2);
                    }
                } else if (activity2 != null) {
                    list.addFirst(activity2);
                }
            }
            if (activity != null) {
                Activity it2 = activity;
                list.addFirst(it2);
            }
            return list;
        } catch (Exception e) {
            Log.d(TAG, "getActivitiesByReflect", e);
        }
    }

    private final Object getActivityThread() {
        Object activityThread = getActivityThreadInActivityThreadStaticField();
        if (activityThread != null) {
            return activityThread;
        }
        return getActivityThreadInActivityThreadStaticMethod();
    }

    private final Map<Object, Object> getActivitiesField(Object $this$getActivitiesField) {
        return (Map) Reflect.on($this$getActivitiesField).field("mActivities").get();
    }

    private final Activity getActivityField(Object $this$getActivityField) {
        return (Activity) Reflect.on($this$getActivityField).field(TTDownloadField.TT_ACTIVITY).get();
    }

    private final boolean getActivityPausedField(Object $this$getActivityPausedField) {
        Object obj = Reflect.on($this$getActivityPausedField).field("paused").get();
        Intrinsics.checkNotNullExpressionValue(obj, "on(this)\n            .fi…used\")\n            .get()");
        return ((Boolean) obj).booleanValue();
    }

    private final Object getActivityThreadInActivityThreadStaticField() {
        try {
            return Reflect.onClass("android.app.ActivityThread").field("sCurrentActivityThread").get();
        } catch (Exception e) {
            Log.d(TAG, "getActivityThreadInActivityThreadStaticField: ", e);
            return null;
        }
    }

    private final Object getActivityThreadInActivityThreadStaticMethod() {
        try {
            return Reflect.onClass("android.app.ActivityThread").call("currentActivityThread").get();
        } catch (Exception e) {
            Log.d(TAG, "getActivityThreadInActivityThreadStaticMethod: ", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TapActivityLifecycleCallbacks[] collectActivityLifecycleCallbacks() {
        Object callbacks = null;
        Collection collection = activityLifecycleCallbacks;
        synchronized (collection) {
            if (!collection.isEmpty()) {
                Collection $this$toTypedArray$iv = collection;
                callbacks = $this$toTypedArray$iv.toArray(new TapActivityLifecycleCallbacks[0]);
            }
            Unit unit = Unit.INSTANCE;
        }
        return (TapActivityLifecycleCallbacks[]) callbacks;
    }
}
