package com.tapsdk.tapad.internal.selfrender;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import com.byazt.ol.TTDownloadField;
import com.tapsdk.tapad.b;
import com.tapsdk.tapad.internal.runtime.plugin.SurfaceWindowFocus;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class SelfRenderIntentAdapter implements Application.ActivityLifecycleCallbacks {
    private static final long INTERACTION_ARM_TIMEOUT_MS = 5000;
    private static final int PAUSE_PROBE_SIZE_PX = 1;
    private static final int PROVIDER_CALLBACK_INTERACTION_ID_MAX = 2000000000;
    private static final int PROVIDER_CALLBACK_INTERACTION_ID_MIN = 1000000000;
    private static final String TAG = "SelfRenderIntentAdapter";
    private int activeInteractionId;
    private final ProviderEventSink eventSink;
    private boolean hostPaused;
    private final ViewTreeObserver.OnWindowFocusChangeListener interactionFocusListener;
    private WeakReference<View> interactionFocusView;
    private InteractionState interactionState;
    private final Handler mainHandler;
    private boolean mediaPauseRequested;
    private int nextProviderCallbackInteractionId;
    private boolean pauseProbeAllowed;
    private Dialog pauseProbeWindow;
    private Application registeredApplication;
    private boolean released;
    private WeakReference<Activity> rewardActivity;
    private final boolean rewardFormat;
    private SurfaceWindowFocus surfaceWindowFocus;

    public enum InteractionState {
        IDLE,
        ARMED,
        AWAY
    }

    public interface MotionAction {
        boolean perform();
    }

    public SelfRenderIntentAdapter(ProviderEventSink providerEventSink) {
        this(providerEventSink, true);
    }

    private void armInteraction(final int i, String str) {
        this.activeInteractionId = i;
        this.interactionState = InteractionState.ARMED;
        this.mainHandler.postDelayed(new Runnable() { // from class: com.tapsdk.tapad.internal.selfrender.SelfRenderIntentAdapter$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m380lambda$armInteraction$5$comtapsdktapadinternalselfrenderSelfRenderIntentAdapter(i);
            }
        }, 5000L);
    }

    private void clearInteraction(int i) {
        if (i <= 0 || this.activeInteractionId == i) {
            this.interactionState = InteractionState.IDLE;
            this.activeInteractionId = 0;
        }
    }

    private void completeInteractionReturn(String str) {
        if (this.interactionState != InteractionState.AWAY) {
            return;
        }
        int i = this.activeInteractionId;
        clearInteraction(i);
        ProviderEventSink providerEventSink = this.eventSink;
        if (providerEventSink == null || i <= 0) {
            return;
        }
        providerEventSink.accept(ProviderEvent.interactionReturned(i));
    }

    private void dismissPauseProbeWindowOnMain() {
        Dialog dialog = this.pauseProbeWindow;
        this.pauseProbeWindow = null;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        try {
            dialog.dismiss();
        } catch (IllegalArgumentException e) {
        }
        Activity activity = this.rewardActivity.get();
        if (this.released || !isUsable(activity)) {
            return;
        }
        observeInteractionFocus(activity.getWindow().getDecorView());
    }

    private void emitClickRequestFailed(int i, int i2, String str) {
        ProviderEventSink providerEventSink = this.eventSink;
        if (providerEventSink == null || this.released) {
            return;
        }
        providerEventSink.accept(ProviderEvent.clickRequestFailed(i, i2, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: expireUnopenedInteraction, reason: merged with bridge method [inline-methods] */
    public void m380lambda$armInteraction$5$comtapsdktapadinternalselfrenderSelfRenderIntentAdapter(int i) {
        if (this.activeInteractionId == i && this.interactionState == InteractionState.ARMED) {
            clearInteraction(i);
            ProviderEventSink providerEventSink = this.eventSink;
            if (providerEventSink == null || this.released) {
                return;
            }
            providerEventSink.accept(ProviderEvent.interactionNotStarted(i));
        }
    }

    private boolean isBoundActivity(Activity activity) {
        return activity != null && activity == this.rewardActivity.get();
    }

    private static boolean isUsable(Activity activity) {
        return (activity == null || activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }

    private void markInteractionAway(String str) {
        int i;
        ProviderEventSink providerEventSink;
        if (this.interactionState != InteractionState.ARMED || (i = this.activeInteractionId) <= 0) {
            return;
        }
        this.interactionState = InteractionState.AWAY;
        if (this.rewardFormat || (providerEventSink = this.eventSink) == null) {
            return;
        }
        providerEventSink.accept(ProviderEvent.simple(28, i));
    }

    private void observeInteractionFocus(View view) {
        if (view == null || this.interactionFocusView.get() == view) {
            return;
        }
        stopObservingInteractionFocus();
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnWindowFocusChangeListener(this.interactionFocusListener);
            this.interactionFocusView = new WeakReference<>(view);
        }
    }

    private void registerLifecycleCallbacks(Application application) {
        Application application2 = this.registeredApplication;
        if (application2 == application) {
            return;
        }
        if (application2 != null) {
            application2.unregisterActivityLifecycleCallbacks(this);
        }
        this.registeredApplication = application;
        application.registerActivityLifecycleCallbacks(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPauseProbeWindowOnMain() {
        SurfaceWindowFocus surfaceWindowFocus;
        if (!this.released && this.mediaPauseRequested && this.pauseProbeAllowed) {
            Dialog dialog = this.pauseProbeWindow;
            if (dialog == null || !dialog.isShowing()) {
                Activity activity = this.rewardActivity.get();
                if (isUsable(activity)) {
                    if (this.rewardFormat || !(this.hostPaused || (surfaceWindowFocus = this.surfaceWindowFocus) == null || !surfaceWindowFocus.hasFocus())) {
                        View view = new View(activity);
                        view.setBackgroundColor(0);
                        final Dialog dialog2 = new Dialog(activity);
                        dialog2.requestWindowFeature(1);
                        dialog2.setCancelable(false);
                        dialog2.setCanceledOnTouchOutside(false);
                        dialog2.setContentView(view, new ViewGroup.LayoutParams(1, 1));
                        Window window = dialog2.getWindow();
                        if (window == null) {
                            return;
                        }
                        window.setBackgroundDrawable(new ColorDrawable(0));
                        window.getDecorView().setPadding(0, 0, 0, 0);
                        window.clearFlags(2);
                        window.addFlags(32);
                        window.setWindowAnimations(0);
                        final SurfaceWindowFocus surfaceWindowFocus2 = this.surfaceWindowFocus;
                        final View decorView = window.getDecorView();
                        if (surfaceWindowFocus2 != null) {
                            surfaceWindowFocus2.addWindow(decorView);
                        }
                        dialog2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tapsdk.tapad.internal.selfrender.SelfRenderIntentAdapter$$ExternalSyntheticLambda1
                            @Override // android.content.DialogInterface.OnDismissListener
                            public final void onDismiss(DialogInterface dialogInterface) {
                                this.f$0.m386lambda$showPauseProbeWindowOnMain$6$comtapsdktapadinternalselfrenderSelfRenderIntentAdapter(surfaceWindowFocus2, decorView, dialog2, dialogInterface);
                            }
                        });
                        try {
                            this.pauseProbeWindow = dialog2;
                            dialog2.show();
                            WindowManager.LayoutParams attributes = window.getAttributes();
                            attributes.width = 1;
                            attributes.height = 1;
                            attributes.gravity = 81;
                            attributes.x = 0;
                            attributes.y = 0;
                            attributes.dimAmount = 0.0f;
                            window.setAttributes(attributes);
                            observeInteractionFocus(window.getDecorView());
                        } catch (WindowManager.BadTokenException e) {
                            if (surfaceWindowFocus2 != null) {
                                surfaceWindowFocus2.removeWindow(decorView);
                            }
                            this.pauseProbeWindow = null;
                        }
                    }
                }
            }
        }
    }

    private void stopObservingInteractionFocus() {
        View view = this.interactionFocusView.get();
        this.interactionFocusView = new WeakReference<>(null);
        if (view == null) {
            return;
        }
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnWindowFocusChangeListener(this.interactionFocusListener);
        }
    }

    public void bind(Activity activity) {
        m381lambda$bind$0$comtapsdktapadinternalselfrenderSelfRenderIntentAdapter(activity, null);
    }

    /* JADX INFO: renamed from: lambda$onProviderMotionRequest$2$com-tapsdk-tapad-internal-selfrender-SelfRenderIntentAdapter, reason: not valid java name */
    /* synthetic */ void m383lambda$onProviderMotionRequest$2$comtapsdktapadinternalselfrenderSelfRenderIntentAdapter(MotionAction motionAction, int i, int i2) {
        if (motionAction.perform()) {
            return;
        }
        if (i > 0) {
            clearInteraction(i);
        }
        emitClickRequestFailed(i, i2, "Provider motion click bridge is unavailable");
    }

    /* JADX INFO: renamed from: lambda$showPauseProbeWindowOnMain$6$com-tapsdk-tapad-internal-selfrender-SelfRenderIntentAdapter, reason: not valid java name */
    /* synthetic */ void m386lambda$showPauseProbeWindowOnMain$6$comtapsdktapadinternalselfrenderSelfRenderIntentAdapter(SurfaceWindowFocus surfaceWindowFocus, View view, Dialog dialog, DialogInterface dialogInterface) {
        if (surfaceWindowFocus != null) {
            surfaceWindowFocus.removeWindow(view);
        }
        if (this.pauseProbeWindow == dialog) {
            this.pauseProbeWindow = null;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (isBoundActivity(activity)) {
            this.rewardActivity = new WeakReference<>(null);
            clearInteraction(this.activeInteractionId);
            stopObservingInteractionFocus();
            dismissPauseProbeWindowOnMain();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (this.released || !isBoundActivity(activity)) {
            return;
        }
        this.hostPaused = true;
        markInteractionAway(TTDownloadField.TT_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (this.released || !isBoundActivity(activity)) {
            return;
        }
        this.hostPaused = false;
        completeInteractionReturn(TTDownloadField.TT_ACTIVITY);
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

    public void onInteractionWindowFocusChanged(boolean z) {
        if (this.released) {
            return;
        }
        if (!z) {
            markInteractionAway("window");
            return;
        }
        completeInteractionReturn("window");
        if (this.rewardFormat || !this.mediaPauseRequested) {
            return;
        }
        this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.selfrender.SelfRenderIntentAdapter$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.showPauseProbeWindowOnMain();
            }
        });
    }

    public int onProviderClickObserved(int i) {
        int i2;
        if (Looper.myLooper() != Looper.getMainLooper() || this.released) {
            return 0;
        }
        if (this.rewardFormat) {
            if (!ProviderClickCallbacks.isCompleteTemplateAction(i)) {
                return 0;
            }
        } else if (i <= 0) {
            return 0;
        }
        if (!isUsable(this.rewardActivity.get())) {
            return 0;
        }
        if (this.interactionState == InteractionState.ARMED && (i2 = this.activeInteractionId) > 0) {
            return i2;
        }
        int i3 = this.nextProviderCallbackInteractionId;
        int i4 = i3 >= PROVIDER_CALLBACK_INTERACTION_ID_MAX ? 1000000000 : i3 + 1;
        this.nextProviderCallbackInteractionId = i4;
        armInteraction(i4, b.a("provider_callback:", i));
        return this.nextProviderCallbackInteractionId;
    }

    /* JADX INFO: renamed from: onProviderClickRequest, reason: merged with bridge method [inline-methods] */
    public void m382lambda$onProviderClickRequest$1$comtapsdktapadinternalselfrenderSelfRenderIntentAdapter(final int i, final int i2, final View view, final List<View> list) {
        ProviderEventSink providerEventSink;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.selfrender.SelfRenderIntentAdapter$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m382lambda$onProviderClickRequest$1$comtapsdktapadinternalselfrenderSelfRenderIntentAdapter(i, i2, view, list);
                }
            });
            return;
        }
        if (this.released) {
            return;
        }
        if (!isUsable(this.rewardActivity.get())) {
            emitClickRequestFailed(i, i2, "Reward provider action surface is unavailable");
            return;
        }
        if (i > 0) {
            armInteraction(i, "core_intent");
        }
        if (!ProviderMotionAction.performRewardIntent(i2, view, list)) {
            if (i > 0) {
                clearInteraction(i);
            }
            emitClickRequestFailed(i, i2, "Reward provider click bridge is unavailable");
        } else {
            if (i <= 0 || (providerEventSink = this.eventSink) == null) {
                return;
            }
            providerEventSink.accept(ProviderEvent.simple(25, i));
        }
    }

    public void onProviderMotionRequest(final int i, final int i2, final MotionAction motionAction) {
        m384lambda$onProviderMotionRequest$3$comtapsdktapadinternalselfrenderSelfRenderIntentAdapter(i, new Runnable() { // from class: com.tapsdk.tapad.internal.selfrender.SelfRenderIntentAdapter$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m383lambda$onProviderMotionRequest$2$comtapsdktapadinternalselfrenderSelfRenderIntentAdapter(motionAction, i, i2);
            }
        });
    }

    public void onProviderVideoPauseRequest() {
        m385lambda$onProviderVideoPauseRequest$4$comtapsdktapadinternalselfrenderSelfRenderIntentAdapter(true);
    }

    public void onProviderVideoResumeRequest() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.selfrender.SelfRenderIntentAdapter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.onProviderVideoResumeRequest();
                }
            });
        } else {
            this.mediaPauseRequested = false;
            dismissPauseProbeWindowOnMain();
        }
    }

    public void release() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.selfrender.SelfRenderIntentAdapter$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.release();
                }
            });
            return;
        }
        if (this.released) {
            return;
        }
        this.released = true;
        this.mediaPauseRequested = false;
        clearInteraction(this.activeInteractionId);
        stopObservingInteractionFocus();
        dismissPauseProbeWindowOnMain();
        this.surfaceWindowFocus = null;
        this.rewardActivity = new WeakReference<>(null);
        Application application = this.registeredApplication;
        if (application != null) {
            application.unregisterActivityLifecycleCallbacks(this);
            this.registeredApplication = null;
        }
    }

    public SelfRenderIntentAdapter(ProviderEventSink providerEventSink, boolean z) {
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.rewardActivity = new WeakReference<>(null);
        this.interactionFocusView = new WeakReference<>(null);
        this.interactionState = InteractionState.IDLE;
        this.nextProviderCallbackInteractionId = 1000000000;
        this.pauseProbeAllowed = true;
        this.interactionFocusListener = new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.tapsdk.tapad.internal.selfrender.SelfRenderIntentAdapter$$ExternalSyntheticLambda2
            @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
            public final void onWindowFocusChanged(boolean z2) {
                this.f$0.onInteractionWindowFocusChanged(z2);
            }
        };
        this.eventSink = providerEventSink;
        this.rewardFormat = z;
    }

    /* JADX INFO: renamed from: bind, reason: merged with bridge method [inline-methods] */
    public void m381lambda$bind$0$comtapsdktapadinternalselfrenderSelfRenderIntentAdapter(final Activity activity, final View view) {
        Dialog dialog;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.selfrender.SelfRenderIntentAdapter$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m381lambda$bind$0$comtapsdktapadinternalselfrenderSelfRenderIntentAdapter(activity, view);
                }
            });
            return;
        }
        if (this.released || !isUsable(activity)) {
            return;
        }
        Activity activity2 = this.rewardActivity.get();
        SurfaceWindowFocus surfaceWindowFocusFind = this.rewardFormat ? null : SurfaceWindowFocus.find(view);
        if (activity2 != activity || this.surfaceWindowFocus != surfaceWindowFocusFind) {
            dismissPauseProbeWindowOnMain();
        }
        this.rewardActivity = new WeakReference<>(activity);
        registerLifecycleCallbacks(activity.getApplication());
        if (activity2 != activity) {
            this.hostPaused = false;
        }
        this.surfaceWindowFocus = surfaceWindowFocusFind;
        observeInteractionFocus((this.rewardFormat || (dialog = this.pauseProbeWindow) == null || !dialog.isShowing()) ? activity.getWindow().getDecorView() : this.pauseProbeWindow.getWindow().getDecorView());
        if (this.mediaPauseRequested) {
            showPauseProbeWindowOnMain();
        }
    }

    /* JADX INFO: renamed from: onProviderMotionRequest, reason: merged with bridge method [inline-methods] */
    public void m384lambda$onProviderMotionRequest$3$comtapsdktapadinternalselfrenderSelfRenderIntentAdapter(final int i, final Runnable runnable) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.selfrender.SelfRenderIntentAdapter$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m384lambda$onProviderMotionRequest$3$comtapsdktapadinternalselfrenderSelfRenderIntentAdapter(i, runnable);
                }
            });
            return;
        }
        if (this.released) {
            return;
        }
        if (!isUsable(this.rewardActivity.get())) {
            emitClickRequestFailed(i, 2, "Provider action surface is unavailable");
            return;
        }
        if (i > 0) {
            armInteraction(i, "core_motion");
        }
        runnable.run();
    }

    /* JADX INFO: renamed from: onProviderVideoPauseRequest, reason: merged with bridge method [inline-methods] */
    public void m385lambda$onProviderVideoPauseRequest$4$comtapsdktapadinternalselfrenderSelfRenderIntentAdapter(final boolean z) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.selfrender.SelfRenderIntentAdapter$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m385lambda$onProviderVideoPauseRequest$4$comtapsdktapadinternalselfrenderSelfRenderIntentAdapter(z);
                }
            });
        } else {
            if (this.released) {
                return;
            }
            this.mediaPauseRequested = true;
            this.pauseProbeAllowed = z;
            showPauseProbeWindowOnMain();
        }
    }
}
