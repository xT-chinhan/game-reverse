package com.tapsdk.tapad.group.ads;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.Window;
import com.tapsdk.tapad.internal.AppContextHolder;
import com.tapsdk.tapad.internal.ionia.IoniaIdentityManager;
import com.tapsdk.tapad.internal.platform.AndroidLifecycleHost;
import com.tapsdk.tapad.internal.utils.ActivityUtil;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class IoniaProviderTouchObserver {
    private static final IoniaProviderTouchObserver INSTANCE = new IoniaProviderTouchObserver();
    private static final long MAX_SESSION_MS = 900000;
    private static final String OWN_ACTIVITY_PREFIX = "com.tapsdk.tapad.";
    private static final String TAG = "IoniaProviderTouch";
    private final Handler main = new Handler(Looper.getMainLooper());
    private Session session;

    public static final class ObservingHandler implements InvocationHandler {
        private static final String DISPATCH_TOUCH_EVENT = "dispatchTouchEvent";
        private final Window.Callback delegate;
        private volatile Session session;

        public ObservingHandler(Window.Callback callback, Session session) {
            this.delegate = callback;
            this.session = session;
        }

        public void detach() {
            this.session = null;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            Session session;
            if (DISPATCH_TOUCH_EVENT.equals(method.getName()) && objArr != null && objArr.length == 1 && (objArr[0] instanceof MotionEvent) && (session = this.session) != null) {
                try {
                    session.onTouch((MotionEvent) objArr[0]);
                } catch (Throwable th) {
                    th.getMessage();
                }
            }
            try {
                return method.invoke(this.delegate, objArr);
            } catch (InvocationTargetException e) {
                Throwable cause = e.getCause();
                if (cause == null) {
                    throw e;
                }
                throw cause;
            }
        }
    }

    public final class Session implements Application.ActivityLifecycleCallbacks {
        private final Application application;
        private final String correlationId;
        private final DirichletAd owner;
        private boolean stopped;
        private final String windowKey;
        private final List<Wrapping> wrappings = new ArrayList(2);
        private final Runnable expiry = new Runnable() { // from class: com.tapsdk.tapad.group.ads.IoniaProviderTouchObserver$Session$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.onExpired();
            }
        };
        private final Activity baseline = AndroidLifecycleHost.getInstance().getCurrentActivity();

        public Session(Application application, DirichletAd dirichletAd, String str, String str2) {
            this.application = application;
            this.owner = dirichletAd;
            this.windowKey = str;
            this.correlationId = str2;
        }

        private Wrapping findWrapping(Activity activity) {
            for (Wrapping wrapping : this.wrappings) {
                if (wrapping.activity == activity) {
                    return wrapping;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onExpired() {
            if (IoniaProviderTouchObserver.this.session == this) {
                IoniaProviderTouchObserver.this.stopCurrent();
            } else {
                stop();
            }
        }

        private boolean shouldWrap(Activity activity) {
            return (this.stopped || activity == null || activity == this.baseline || ActivityUtil.isActivityNotAlive(activity) || activity.getClass().getName().startsWith(IoniaProviderTouchObserver.OWN_ACTIVITY_PREFIX) || activity.getWindow() == null || findWrapping(activity) != null) ? false : true;
        }

        private void unwrap(Activity activity) {
            Wrapping wrappingFindWrapping = findWrapping(activity);
            if (wrappingFindWrapping != null) {
                wrappingFindWrapping.detach();
                this.wrappings.remove(wrappingFindWrapping);
            }
        }

        private void wrap(Activity activity) {
            Wrapping wrappingAttach;
            if (shouldWrap(activity) && (wrappingAttach = Wrapping.attach(activity, this)) != null) {
                this.wrappings.add(wrappingAttach);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            unwrap(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            wrap(activity);
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

        public void onTouch(MotionEvent motionEvent) {
            if (this.stopped || motionEvent == null) {
                return;
            }
            IoniaIdentityManager.getInstance().recordAdPlaybackMotionEventAsync(this.windowKey, this.correlationId, motionEvent);
        }

        public boolean start() {
            try {
                this.application.registerActivityLifecycleCallbacks(this);
                IoniaProviderTouchObserver.this.main.postDelayed(this.expiry, 900000L);
                Activity currentActivity = AndroidLifecycleHost.getInstance().getCurrentActivity();
                if (currentActivity == null) {
                    return true;
                }
                wrap(currentActivity);
                return true;
            } catch (Throwable th) {
                th.getMessage();
                return false;
            }
        }

        public void stop() {
            if (this.stopped) {
                return;
            }
            this.stopped = true;
            IoniaProviderTouchObserver.this.main.removeCallbacks(this.expiry);
            try {
                this.application.unregisterActivityLifecycleCallbacks(this);
            } catch (Throwable th) {
            }
            for (int size = this.wrappings.size() - 1; size >= 0; size--) {
                this.wrappings.get(size).detach();
            }
            this.wrappings.clear();
        }
    }

    public static final class Wrapping {
        final Activity activity;
        final Window.Callback delegate;
        final ObservingHandler handler;
        final Window.Callback proxy;

        private Wrapping(Activity activity, Window.Callback callback, Window.Callback callback2, ObservingHandler observingHandler) {
            this.activity = activity;
            this.delegate = callback;
            this.proxy = callback2;
            this.handler = observingHandler;
        }

        public static Wrapping attach(Activity activity, Session session) {
            try {
                Window window = activity.getWindow();
                Window.Callback callback = window == null ? null : window.getCallback();
                if (callback != null && !Proxy.isProxyClass(callback.getClass())) {
                    ObservingHandler observingHandler = new ObservingHandler(callback, session);
                    Window.Callback callback2 = (Window.Callback) Proxy.newProxyInstance(Window.Callback.class.getClassLoader(), new Class[]{Window.Callback.class}, observingHandler);
                    window.setCallback(callback2);
                    return new Wrapping(activity, callback, callback2, observingHandler);
                }
                return null;
            } catch (Throwable th) {
                th.getMessage();
                return null;
            }
        }

        public void detach() {
            this.handler.detach();
            try {
                Window window = this.activity.getWindow();
                if (window != null && window.getCallback() == this.proxy) {
                    window.setCallback(this.delegate);
                }
            } catch (Throwable th) {
            }
        }
    }

    private IoniaProviderTouchObserver() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: beginOnMain, reason: merged with bridge method [inline-methods] */
    public void m44lambda$begin$0$comtapsdktapadgroupadsIoniaProviderTouchObserver(DirichletAd dirichletAd, String str, String str2) {
        if (IoniaIdentityManager.getInstance().isProviderTouchObservationEnabled()) {
            Session session = this.session;
            if (session != null) {
                if (session.owner == dirichletAd) {
                    return;
                } else {
                    stopCurrent();
                }
            }
            Context context = AppContextHolder.get();
            if (context instanceof Application) {
                Session session2 = new Session((Application) context, dirichletAd, str, str2);
                this.session = session2;
                if (session2.start()) {
                    return;
                }
                this.session = null;
            }
        }
    }

    public static IoniaProviderTouchObserver get() {
        return INSTANCE;
    }

    private void runOnMain(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.main.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopCurrent() {
        Session session = this.session;
        this.session = null;
        if (session != null) {
            session.stop();
        }
    }

    public void begin(final DirichletAd dirichletAd) {
        if (dirichletAd == null) {
            return;
        }
        final String trackId = dirichletAd.getTrackId();
        final String requestId = dirichletAd.getRequestId();
        if (TextUtils.isEmpty(trackId) || TextUtils.isEmpty(requestId)) {
            return;
        }
        runOnMain(new Runnable() { // from class: com.tapsdk.tapad.group.ads.IoniaProviderTouchObserver$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m44lambda$begin$0$comtapsdktapadgroupadsIoniaProviderTouchObserver(dirichletAd, trackId, requestId);
            }
        });
    }

    public void end(final DirichletAd dirichletAd) {
        if (dirichletAd == null) {
            return;
        }
        runOnMain(new Runnable() { // from class: com.tapsdk.tapad.group.ads.IoniaProviderTouchObserver$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m45lambda$end$1$comtapsdktapadgroupadsIoniaProviderTouchObserver(dirichletAd);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$end$1$com-tapsdk-tapad-group-ads-IoniaProviderTouchObserver, reason: not valid java name */
    /* synthetic */ void m45lambda$end$1$comtapsdktapadgroupadsIoniaProviderTouchObserver(DirichletAd dirichletAd) {
        Session session = this.session;
        if (session == null || session.owner != dirichletAd) {
            return;
        }
        stopCurrent();
    }
}
