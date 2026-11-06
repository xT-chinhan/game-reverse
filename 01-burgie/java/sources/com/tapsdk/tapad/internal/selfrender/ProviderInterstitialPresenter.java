package com.tapsdk.tapad.internal.selfrender;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.tapsdk.tapad.b;
import com.tapsdk.tapad.c;
import com.tapsdk.tapad.constants.ErrorCodeEnum;
import com.tapsdk.tapad.internal.AndroidInterstitialFallback;
import com.tapsdk.tapad.internal.IoniaPlaybackSource;
import com.tapsdk.tapad.internal.WasmCoreModuleLoader;
import com.tapsdk.tapad.internal.runtime.DirichletRuntime;
import com.tapsdk.tapad.internal.runtime.ShowHostFacts;
import com.tapsdk.tapad.internal.runtime.WasmAdInstance;
import com.tapsdk.tapad.internal.runtime.WasmModule;
import com.tapsdk.tapad.internal.runtime.WasmRuntimeController;
import com.tapsdk.tapad.internal.runtime.plugin.AdCallbackListener;
import com.tapsdk.tapad.internal.runtime.plugin.ProviderAttributionSlots;
import com.tapsdk.tapad.internal.runtime.plugin.ProviderInteractionViews;
import com.tapsdk.tapad.internal.runtime.plugin.stub.FullscreenProviderHost;
import com.umeng.analytics.pro.cc;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ProviderInterstitialPresenter implements AdCallbackListener, FullscreenProviderHost, ProviderEventSink, IoniaPlaybackSource {
    private static final String FN_EVENT = "ad_provider_interstitial_event_instance";
    private static final String FN_LOAD = "ad_load_normalized_interstitial_instance";
    private static final String FN_PRESENT = "ad_present_interstitial_instance_v2";
    private static final String FN_RENDER = "ad_render_interstitial";
    private static final int MAX_BINDING_EVENTS = 64;
    private static final String TAG = "ProviderInterstitialPresenter";
    private final WeakReference<Activity> activityRef;
    private boolean binding;
    private boolean codebitShowReported;
    private final Context context;
    private boolean fallbackActive;
    private AndroidInterstitialFallback.Session fallbackSession;
    private final ProviderInterstitialSession.HostEvents hostEvents;
    private final SelfRenderIntentAdapter intentAdapter;
    private View latestClickView;
    private View primaryActionView;
    private final ProviderInterstitialSession session;
    private boolean shown;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final AtomicBoolean disposed = new AtomicBoolean(false);
    private final AtomicBoolean providerReleased = new AtomicBoolean(false);
    private final ArrayDeque<ProviderEvent> bindingEvents = new ArrayDeque<>();
    private WeakReference<WasmAdInstance> instanceRef = new WeakReference<>(null);
    private List<View> providerClickCandidates = Collections.EMPTY_LIST;
    private ProviderInteractionViews providerInteractionViews = new ProviderInteractionViews(null, null, null);

    private ProviderInterstitialPresenter(Activity activity, ProviderInterstitialSession providerInterstitialSession, ProviderInterstitialSession.HostEvents hostEvents) {
        this.context = activity != null ? activity.getApplicationContext() : null;
        this.activityRef = new WeakReference<>(activity);
        this.session = providerInterstitialSession;
        this.hostEvents = hostEvents;
        this.intentAdapter = new SelfRenderIntentAdapter(this, false);
    }

    private void closeAfterCoreFailure(final String str) {
        this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.selfrender.ProviderInterstitialPresenter$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m346lambda$closeAfterCoreFailure$7$comtapsdktapadinternalselfrenderProviderInterstitialPresenter(str);
            }
        });
    }

    private void disposeCore() {
        WasmAdInstance wasmAdInstance = this.instanceRef.get();
        this.instanceRef = new WeakReference<>(null);
        if (wasmAdInstance != null) {
            wasmAdInstance.dispose();
        }
    }

    private boolean enqueueProviderEvent(ProviderEvent providerEvent) {
        if (!this.binding) {
            send(providerEvent);
            return true;
        }
        if (this.bindingEvents.size() < 64) {
            this.bindingEvents.addLast(providerEvent);
            return true;
        }
        this.bindingEvents.clear();
        this.binding = false;
        send(ProviderEvent.failed(13, -2, "Interstitial provider event overflow"));
        return false;
    }

    private void failBeforeShow(final String str) {
        this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.selfrender.ProviderInterstitialPresenter$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m347lambda$failBeforeShow$8$comtapsdktapadinternalselfrenderProviderInterstitialPresenter(str);
            }
        });
    }

    private static View firstEffectivelyVisibleView(List<View> list) {
        if (list == null) {
            return null;
        }
        View view = null;
        for (View view2 : list) {
            if (view2 != null) {
                if (view == null) {
                    view = view2;
                }
                View view3 = view2;
                while (view3 != null) {
                    if (view3.getVisibility() == 0) {
                        Object parent = view3.getParent();
                        view3 = parent instanceof View ? (View) parent : null;
                    }
                }
                return view2;
            }
        }
        return view;
    }

    private static List<View> immutableViews(List<View> list) {
        return (list == null || list.isEmpty()) ? Collections.EMPTY_LIST : Collections.unmodifiableList(new ArrayList(list));
    }

    private WasmAdInstance instance() {
        WasmAdInstance wasmAdInstance = this.instanceRef.get();
        if (wasmAdInstance == null || wasmAdInstance.isDisposed()) {
            return null;
        }
        return wasmAdInstance;
    }

    private static boolean isUsable(Activity activity) {
        return (activity == null || activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }

    private static JSONObject json(String str) {
        try {
            if (str == null) {
                str = "{}";
            }
            return new JSONObject(str);
        } catch (Exception e) {
            return new JSONObject();
        }
    }

    private JSONObject loadMeta() {
        return this.session.interstitialLoadFacts().toJson();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: performProviderMotionAction, reason: merged with bridge method [inline-methods] */
    public void m348lambda$onCallback$5$comtapsdktapadinternalselfrenderProviderInterstitialPresenter(final int i) {
        this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.selfrender.ProviderInterstitialPresenter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m349lambda$performProviderMotionAction$9$comtapsdktapadinternalselfrenderProviderInterstitialPresenter(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void prepare(final DirichletRuntime dirichletRuntime, final WasmModule wasmModule) {
        if (this.disposed.get()) {
            return;
        }
        String[] strArr = {FN_LOAD, FN_EVENT, FN_PRESENT, FN_RENDER};
        for (int i = 0; i < 4; i++) {
            String str = strArr[i];
            if (!wasmModule.hasFunction(str)) {
                startFixedFallback(c.a("Core Interstitial provider export is unavailable: ", str));
                return;
            }
        }
        if (dirichletRuntime.runOnRuntimeQueue(new Runnable() { // from class: com.tapsdk.tapad.internal.selfrender.ProviderInterstitialPresenter$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m350lambda$prepare$0$comtapsdktapadinternalselfrenderProviderInterstitialPresenter(dirichletRuntime, wasmModule);
            }
        })) {
            return;
        }
        startFixedFallback("Core runtime queue is unavailable");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: prepareOnRuntime, reason: merged with bridge method [inline-methods] */
    public void m350lambda$prepare$0$comtapsdktapadinternalselfrenderProviderInterstitialPresenter(final DirichletRuntime dirichletRuntime, WasmModule wasmModule) {
        try {
            WeakReference<WasmAdInstance> weakReferenceCreate = WasmAdInstance.create(wasmModule, new DirichletRuntime.NativeCallback() { // from class: com.tapsdk.tapad.internal.selfrender.ProviderInterstitialPresenter$$ExternalSyntheticLambda9
                @Override // com.tapsdk.tapad.internal.runtime.DirichletRuntime.NativeCallback
                public final void onCallback(String str, String str2) {
                    this.f$0.m136lambda$onCallback$2$comtapsdktapadinternalWasmNativeFeedPresenter(str, str2);
                }
            });
            final WasmAdInstance wasmAdInstance = weakReferenceCreate.get();
            if (wasmAdInstance != null && !this.disposed.get()) {
                this.instanceRef = weakReferenceCreate;
                dirichletRuntime.registerAdSurface(wasmAdInstance.instanceId(), wasmModule, this, this);
                int iCallIntSync = wasmModule.callIntSync(FN_LOAD, Integer.valueOf(wasmAdInstance.instanceId()), this.session.normalizedInterstitialCreative(), loadMeta().toString());
                if (iCallIntSync != 1) {
                    startFixedFallback("Core rejected normalized Interstitial: " + iCallIntSync);
                    return;
                } else {
                    this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.selfrender.ProviderInterstitialPresenter$$ExternalSyntheticLambda10
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.m351lambda$prepareOnRuntime$1$comtapsdktapadinternalselfrenderProviderInterstitialPresenter(dirichletRuntime, wasmAdInstance);
                        }
                    });
                    return;
                }
            }
            if (wasmAdInstance != null) {
                wasmAdInstance.dispose();
            }
            startFixedFallback("Core Interstitial instance could not be created");
        } catch (Throwable th) {
            startFixedFallback("Core Interstitial preparation failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: present, reason: merged with bridge method [inline-methods] */
    public void m351lambda$prepareOnRuntime$1$comtapsdktapadinternalselfrenderProviderInterstitialPresenter(DirichletRuntime dirichletRuntime, WasmAdInstance wasmAdInstance) {
        Activity activity = this.activityRef.get();
        if (this.disposed.get() || wasmAdInstance.isDisposed() || !isUsable(activity)) {
            failBeforeShow("Interstitial Activity ended before present");
            return;
        }
        try {
            dirichletRuntime.registerAdSurface(wasmAdInstance.instanceId(), wasmAdInstance.module(), this, this, activity);
            reportCodebitShowOnce(activity);
            wasmAdInstance.module().callInt(FN_PRESENT, new WasmModule.IntCallback() { // from class: com.tapsdk.tapad.internal.selfrender.ProviderInterstitialPresenter$$ExternalSyntheticLambda8
                @Override // com.tapsdk.tapad.internal.runtime.WasmModule.IntCallback
                public final void onResult(int i) {
                    this.f$0.m352lambda$present$2$comtapsdktapadinternalselfrenderProviderInterstitialPresenter(i);
                }
            }, Integer.valueOf(wasmAdInstance.instanceId()), Integer.valueOf(ShowHostFacts.forFullscreen(activity, false)));
        } catch (Throwable th) {
            startFixedFallback("Provider Interstitial presentation could not start");
        }
    }

    private void releaseProvider() {
        if (this.providerReleased.compareAndSet(false, true)) {
            this.intentAdapter.release();
            this.session.releaseInterstitialProvider();
        }
    }

    private void reportCodebitShowOnce(Activity activity) {
        if (this.codebitShowReported) {
            return;
        }
        this.codebitShowReported = true;
        this.hostEvents.onPresentationStarted(activity);
    }

    private void send(ProviderEvent providerEvent) {
        WasmAdInstance wasmAdInstanceInstance = instance();
        if (wasmAdInstanceInstance == null || providerEvent == null) {
            return;
        }
        wasmAdInstanceInstance.module().callInt(FN_EVENT, new WasmModule.IntCallback() { // from class: com.tapsdk.tapad.internal.selfrender.ProviderInterstitialPresenter$$ExternalSyntheticLambda5
            @Override // com.tapsdk.tapad.internal.runtime.WasmModule.IntCallback
            public final void onResult(int i) {
                this.f$0.m353lambda$send$4$comtapsdktapadinternalselfrenderProviderInterstitialPresenter(i);
            }
        }, Integer.valueOf(wasmAdInstanceInstance.instanceId()), providerEvent.toJson());
    }

    public static ProviderInterstitialPresenter show(Activity activity, ProviderInterstitialSession providerInterstitialSession, ProviderInterstitialSession.HostEvents hostEvents) {
        ProviderInterstitialPresenter providerInterstitialPresenter = new ProviderInterstitialPresenter(activity, providerInterstitialSession, hostEvents);
        providerInterstitialPresenter.start();
        return providerInterstitialPresenter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.selfrender.ProviderInterstitialPresenter$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.start();
                }
            });
            return;
        }
        Activity activity = this.activityRef.get();
        if (this.context == null || this.session == null || this.hostEvents == null || !isUsable(activity)) {
            failBeforeShow("Interstitial launch Activity is unavailable");
            return;
        }
        if (!WasmRuntimeController.getInstance().ensureRewardCoreInitialized(this.context)) {
            startFixedFallback("Core runtime is unavailable");
            return;
        }
        final DirichletRuntime dirichletRuntime = DirichletRuntime.getInstance();
        if (dirichletRuntime.isReady()) {
            WasmCoreModuleLoader.load(dirichletRuntime, new WasmCoreModuleLoader.Callback() { // from class: com.tapsdk.tapad.internal.selfrender.ProviderInterstitialPresenter.1
                @Override // com.tapsdk.tapad.internal.WasmCoreModuleLoader.Callback
                public void onError(Exception exc) {
                    ProviderInterstitialPresenter.this.startFixedFallback("Signed Core bundle could not be loaded");
                }

                @Override // com.tapsdk.tapad.internal.WasmCoreModuleLoader.Callback
                public void onLoaded(WasmModule wasmModule) {
                    ProviderInterstitialPresenter.this.prepare(dirichletRuntime, wasmModule);
                }
            });
        } else {
            startFixedFallback("Core runtime is unavailable");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startFixedFallback(final String str) {
        this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.selfrender.ProviderInterstitialPresenter$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m354lambda$startFixedFallback$6$comtapsdktapadinternalselfrenderProviderInterstitialPresenter(str);
            }
        });
    }

    @Override // com.tapsdk.tapad.internal.selfrender.ProviderEventSink
    /* JADX INFO: renamed from: accept, reason: merged with bridge method [inline-methods] */
    public void m345lambda$accept$3$comtapsdktapadinternalselfrenderProviderInterstitialPresenter(final ProviderEvent providerEvent) {
        if (providerEvent == null || this.disposed.get()) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.selfrender.ProviderInterstitialPresenter$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m345lambda$accept$3$comtapsdktapadinternalselfrenderProviderInterstitialPresenter(providerEvent);
                }
            });
            return;
        }
        View view = providerEvent.sourceView;
        if (view != null) {
            this.latestClickView = view;
        }
        if (providerEvent.kind != 4) {
            enqueueProviderEvent(providerEvent);
            return;
        }
        int iResolve = ProviderClickCallbacks.resolve(view, this.providerInteractionViews, 6200, 6201);
        int iOnProviderClickObserved = this.intentAdapter.onProviderClickObserved(iResolve);
        if (enqueueProviderEvent(ProviderEvent.clicked(providerEvent.sourceView, 0))) {
            if ((iResolve <= 0 || enqueueProviderEvent(ProviderEvent.simple(26, iResolve))) && iOnProviderClickObserved > 0) {
                enqueueProviderEvent(ProviderEvent.simple(25, iOnProviderClickObserved));
            }
        }
    }

    @Override // com.tapsdk.tapad.internal.runtime.plugin.stub.FullscreenProviderHost
    public void bindFullscreenSurface(Activity activity, FrameLayout frameLayout, ViewGroup viewGroup, View view, List<View> list, ProviderAttributionSlots providerAttributionSlots) {
        bindFullscreenSurface(activity, frameLayout, viewGroup, view, new ProviderInteractionViews(null, list, null), providerAttributionSlots);
    }

    @Override // com.tapsdk.tapad.internal.runtime.plugin.stub.FullscreenProviderHost
    public FrameLayout createFullscreenRoot(Activity activity) {
        return this.session.createInterstitialRoot(activity);
    }

    public void dispose() {
        if (this.disposed.compareAndSet(false, true)) {
            this.bindingEvents.clear();
            AndroidInterstitialFallback.Session session = this.fallbackSession;
            this.fallbackSession = null;
            if (session != null) {
                session.release();
            }
            disposeCore();
            releaseProvider();
        }
    }

    @Override // com.tapsdk.tapad.internal.IoniaPlaybackSource
    public String ioniaTriggerCorrelationId() {
        ProviderInterstitialSession providerInterstitialSession = this.session;
        ProviderInterstitialSession.LoadFacts loadFactsInterstitialLoadFacts = providerInterstitialSession == null ? null : providerInterstitialSession.interstitialLoadFacts();
        return loadFactsInterstitialLoadFacts == null ? "" : loadFactsInterstitialLoadFacts.requestId();
    }

    @Override // com.tapsdk.tapad.internal.IoniaPlaybackSource
    public String ioniaWindowKey() {
        ProviderInterstitialSession providerInterstitialSession = this.session;
        ProviderInterstitialSession.LoadFacts loadFactsInterstitialLoadFacts = providerInterstitialSession == null ? null : providerInterstitialSession.interstitialLoadFacts();
        return (loadFactsInterstitialLoadFacts == null || TextUtils.isEmpty(ioniaTriggerCorrelationId())) ? "" : loadFactsInterstitialLoadFacts.trackId();
    }

    /* JADX INFO: renamed from: lambda$closeAfterCoreFailure$7$com-tapsdk-tapad-internal-selfrender-ProviderInterstitialPresenter, reason: not valid java name */
    /* synthetic */ void m346lambda$closeAfterCoreFailure$7$comtapsdktapadinternalselfrenderProviderInterstitialPresenter(String str) {
        if (this.disposed.get()) {
            return;
        }
        try {
            this.hostEvents.onClose();
        } finally {
            dispose();
        }
    }

    /* JADX INFO: renamed from: lambda$failBeforeShow$8$com-tapsdk-tapad-internal-selfrender-ProviderInterstitialPresenter, reason: not valid java name */
    /* synthetic */ void m347lambda$failBeforeShow$8$comtapsdktapadinternalselfrenderProviderInterstitialPresenter(String str) {
        if (this.disposed.get()) {
            return;
        }
        this.hostEvents.onRenderFailure(null, ErrorCodeEnum.LOAD_FAILED.getCode(), str);
        dispose();
    }

    /* JADX INFO: renamed from: lambda$performProviderMotionAction$9$com-tapsdk-tapad-internal-selfrender-ProviderInterstitialPresenter, reason: not valid java name */
    /* synthetic */ void m349lambda$performProviderMotionAction$9$comtapsdktapadinternalselfrenderProviderInterstitialPresenter(int i) {
        if (this.disposed.get()) {
            return;
        }
        ProviderMotionAction.performShake(i, this.primaryActionView, this.providerClickCandidates);
    }

    /* JADX INFO: renamed from: lambda$present$2$com-tapsdk-tapad-internal-selfrender-ProviderInterstitialPresenter, reason: not valid java name */
    /* synthetic */ void m352lambda$present$2$comtapsdktapadinternalselfrenderProviderInterstitialPresenter(int i) {
        if (ShowHostFacts.isAdmissionRejection(i) && !this.shown && !this.disposed.get()) {
            failBeforeShow(b.a("Core rejected Interstitial presentation: ", i));
        } else {
            if (i > 0 || this.shown || this.disposed.get()) {
                return;
            }
            startFixedFallback(b.a("Core Interstitial attach failed: ", i));
        }
    }

    /* JADX INFO: renamed from: lambda$send$4$com-tapsdk-tapad-internal-selfrender-ProviderInterstitialPresenter, reason: not valid java name */
    /* synthetic */ void m353lambda$send$4$comtapsdktapadinternalselfrenderProviderInterstitialPresenter(int i) {
        if (i < 0) {
            this.disposed.get();
        }
    }

    /* JADX INFO: renamed from: lambda$startFixedFallback$6$com-tapsdk-tapad-internal-selfrender-ProviderInterstitialPresenter, reason: not valid java name */
    /* synthetic */ void m354lambda$startFixedFallback$6$comtapsdktapadinternalselfrenderProviderInterstitialPresenter(String str) {
        if (this.disposed.get() || this.fallbackActive || this.shown) {
            return;
        }
        Activity activity = this.activityRef.get();
        if (!isUsable(activity)) {
            failBeforeShow(str);
            return;
        }
        disposeCore();
        releaseProvider();
        this.fallbackActive = true;
        this.shown = true;
        reportCodebitShowOnce(activity);
        try {
            this.fallbackSession = AndroidInterstitialFallback.show(activity, new AndroidInterstitialFallback.Listener() { // from class: com.tapsdk.tapad.internal.selfrender.ProviderInterstitialPresenter.2
                @Override // com.tapsdk.tapad.internal.AndroidInterstitialFallback.Listener
                public void onClose() {
                    ProviderInterstitialPresenter.this.fallbackActive = false;
                    try {
                        ProviderInterstitialPresenter.this.hostEvents.onClose();
                    } finally {
                        ProviderInterstitialPresenter.this.dispose();
                    }
                }

                @Override // com.tapsdk.tapad.internal.AndroidInterstitialFallback.Listener
                public void onShow() {
                    ProviderInterstitialPresenter.this.hostEvents.onShow(null);
                }

                @Override // com.tapsdk.tapad.internal.AndroidInterstitialFallback.Listener
                public void onValidShow() {
                }
            });
        } catch (RuntimeException e) {
            this.fallbackActive = false;
            closeAfterCoreFailure("Fixed Interstitial shell could not be attached");
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.tapsdk.tapad.internal.runtime.plugin.AdCallbackListener
    /* JADX INFO: renamed from: onCallback */
    public void m136lambda$onCallback$2$comtapsdktapadinternalWasmNativeFeedPresenter(String str, String str2) {
        if (!this.disposed.get() || "onProviderInterstitialRelease".equals(str)) {
            if ("onProviderInterstitialRelease".equals(str)) {
                releaseProvider();
                return;
            }
            if ("onProviderInterstitialClickRequest".equals(str)) {
                JSONObject jSONObjectJson = json(str2);
                final int iOptInt = jSONObjectJson.optInt("trigger", 0);
                if (iOptInt > 0) {
                    this.intentAdapter.m384lambda$onProviderMotionRequest$3$comtapsdktapadinternalselfrenderSelfRenderIntentAdapter(jSONObjectJson.optInt("interaction_id", 0), new Runnable() { // from class: com.tapsdk.tapad.internal.selfrender.ProviderInterstitialPresenter$$ExternalSyntheticLambda6
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.m348lambda$onCallback$5$comtapsdktapadinternalselfrenderProviderInterstitialPresenter(iOptInt);
                        }
                    });
                    return;
                } else {
                    this.intentAdapter.m382lambda$onProviderClickRequest$1$comtapsdktapadinternalselfrenderSelfRenderIntentAdapter(jSONObjectJson.optInt("interaction_id", 0), jSONObjectJson.optInt("source_type", 0), this.primaryActionView, this.providerClickCandidates);
                    return;
                }
            }
            JSONObject jSONObjectJson2 = json(str2);
            byte b = 3;
            if ("onFallbackTerminal".equals(str)) {
                int iOptInt2 = jSONObjectJson2.optInt("outcome", 2);
                if (iOptInt2 == 1 || iOptInt2 == 3 || this.shown) {
                    closeAfterCoreFailure(jSONObjectJson2.optString("detail", "Core fallback closed"));
                    return;
                } else {
                    startFixedFallback(jSONObjectJson2.optString("detail", "Core fallback failed"));
                    return;
                }
            }
            if ("onCoreRuntimeFatal".equals(str) || "onFallbackTakeoverStarted".equals(str)) {
                return;
            }
            str.getClass();
            switch (str.hashCode()) {
                case -1621262140:
                    b = !str.equals("onProviderVideoPauseRequest") ? (byte) -1 : (byte) 0;
                    break;
                case -1349867671:
                    b = !str.equals("onError") ? (byte) -1 : (byte) 1;
                    break;
                case -689813959:
                    b = !str.equals("onVideoPrepared") ? (byte) -1 : (byte) 2;
                    break;
                case -599792911:
                    if (!str.equals("onProviderDownloadComplete")) {
                        b = -1;
                    }
                    break;
                case -498896949:
                    b = !str.equals("onProviderVideoMuteRequest") ? (byte) -1 : (byte) 4;
                    break;
                case -9706699:
                    b = !str.equals("onVideoComplete") ? (byte) -1 : (byte) 5;
                    break;
                case 157935686:
                    b = !str.equals("onAdClick") ? (byte) -1 : (byte) 6;
                    break;
                case 157941942:
                    b = !str.equals("onAdClose") ? (byte) -1 : (byte) 7;
                    break;
                case 859192426:
                    b = !str.equals("onProviderInstalled") ? (byte) -1 : (byte) 8;
                    break;
                case 975399039:
                    b = !str.equals("onAdShow") ? (byte) -1 : (byte) 9;
                    break;
                case 1107704656:
                    b = !str.equals("onProviderDownloadError") ? (byte) -1 : (byte) 10;
                    break;
                case 1117359934:
                    b = !str.equals("onProviderDownloadPause") ? (byte) -1 : (byte) 11;
                    break;
                case 1120677290:
                    b = !str.equals("onProviderDownloadStart") ? (byte) -1 : (byte) 12;
                    break;
                case 1302043440:
                    b = !str.equals("onVideoPlay") ? (byte) -1 : cc.k;
                    break;
                case 1479592233:
                    b = !str.equals("onVideoResume") ? (byte) -1 : cc.l;
                    break;
                case 1560324599:
                    b = !str.equals("onProviderVideoResumeRequest") ? (byte) -1 : cc.m;
                    break;
                case 1698677132:
                    b = !str.equals("onVideoError") ? (byte) -1 : cc.n;
                    break;
                case 1708332410:
                    b = !str.equals("onVideoPause") ? (byte) -1 : (byte) 17;
                    break;
                default:
                    b = -1;
                    break;
            }
            switch (b) {
                case 0:
                    this.intentAdapter.m385lambda$onProviderVideoPauseRequest$4$comtapsdktapadinternalselfrenderSelfRenderIntentAdapter(jSONObjectJson2.optBoolean("allow_focus_probe", true));
                    return;
                case 1:
                case 16:
                    if (this.shown) {
                        closeAfterCoreFailure(jSONObjectJson2.optString("message", "Core Interstitial error"));
                        return;
                    } else {
                        startFixedFallback(jSONObjectJson2.optString("message", "Core Interstitial error"));
                        return;
                    }
                case 2:
                    this.hostEvents.onVideoPrepared();
                    return;
                case 3:
                    this.hostEvents.onDownloadComplete(jSONObjectJson2.optLong("app_size"), jSONObjectJson2.optLong("total_bytes"), jSONObjectJson2.optString(NativeUnifiedADAppInfoImpl.Keys.APP_NAME), jSONObjectJson2.optString("file_name"));
                    return;
                case 4:
                    this.session.setInterstitialVideoMuted(jSONObjectJson2.optBoolean("muted", false));
                    return;
                case 5:
                    this.hostEvents.onVideoComplete(jSONObjectJson2.optLong("argument", 0L));
                    return;
                case 6:
                    this.hostEvents.onClick(this.latestClickView);
                    return;
                case 7:
                    try {
                        this.hostEvents.onClose();
                        return;
                    } finally {
                        dispose();
                    }
                case 8:
                    this.hostEvents.onInstalled(jSONObjectJson2.optLong("app_size"), jSONObjectJson2.optString(NativeUnifiedADAppInfoImpl.Keys.APP_NAME), jSONObjectJson2.optString("file_name"));
                    return;
                case 9:
                    this.shown = true;
                    this.hostEvents.onShow(this.latestClickView);
                    return;
                case 10:
                    this.hostEvents.onDownloadFailure(jSONObjectJson2.optLong("app_size"), jSONObjectJson2.optLong("total_bytes"), jSONObjectJson2.optLong("current_bytes"), jSONObjectJson2.optString(NativeUnifiedADAppInfoImpl.Keys.APP_NAME), jSONObjectJson2.optString("file_name"), jSONObjectJson2.optInt("argument", -1), jSONObjectJson2.optString("message"));
                    return;
                case 11:
                    this.hostEvents.onDownloadPause(jSONObjectJson2.optLong("app_size"), jSONObjectJson2.optLong("total_bytes"), jSONObjectJson2.optLong("current_bytes"), jSONObjectJson2.optString(NativeUnifiedADAppInfoImpl.Keys.APP_NAME), jSONObjectJson2.optString("file_name"));
                    return;
                case 12:
                    this.hostEvents.onDownloadStart(jSONObjectJson2.optLong("app_size"), jSONObjectJson2.optString(NativeUnifiedADAppInfoImpl.Keys.APP_NAME), jSONObjectJson2.optString("file_name"));
                    return;
                case 13:
                    this.hostEvents.onVideoStart();
                    return;
                case 14:
                    this.hostEvents.onVideoResume();
                    return;
                case 15:
                    this.intentAdapter.onProviderVideoResumeRequest();
                    return;
                case 17:
                    this.hostEvents.onVideoPause();
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.tapsdk.tapad.internal.runtime.plugin.stub.FullscreenProviderHost
    public void onFullscreenCoreUnavailable() {
        if (this.shown) {
            closeAfterCoreFailure("Core became unavailable after Interstitial show");
        } else {
            startFixedFallback("Core became unavailable before Interstitial show");
        }
    }

    @Override // com.tapsdk.tapad.internal.runtime.plugin.stub.FullscreenProviderHost
    public void onFullscreenSurfaceBindFailed(String str) {
        send(ProviderEvent.failed(2, -1, str));
    }

    @Override // com.tapsdk.tapad.internal.runtime.plugin.stub.FullscreenProviderHost
    public String providerSurfaceFormat() {
        return MediationConstant.RIT_TYPE_INTERSTITIAL;
    }

    @Override // com.tapsdk.tapad.internal.runtime.plugin.stub.FullscreenProviderHost
    public boolean updateFullscreenActionViews(List<View> list) {
        return updateFullscreenInteractionViews(new ProviderInteractionViews(null, list, null));
    }

    @Override // com.tapsdk.tapad.internal.runtime.plugin.stub.FullscreenProviderHost
    public boolean updateFullscreenInteractionViews(ProviderInteractionViews providerInteractionViews) {
        if (this.disposed.get() || Looper.myLooper() != Looper.getMainLooper()) {
            return false;
        }
        if (providerInteractionViews == null) {
            providerInteractionViews = new ProviderInteractionViews(null, null, null);
        }
        boolean zUpdateInterstitialInteractionViews = this.session.updateInterstitialInteractionViews(providerInteractionViews.getClickViews(), providerInteractionViews.getCreativeViews(), providerInteractionViews.getDirectDownloadViews());
        if (zUpdateInterstitialInteractionViews) {
            this.providerInteractionViews = providerInteractionViews;
            this.providerClickCandidates = providerInteractionViews.allViews();
            View viewFirstEffectivelyVisibleView = firstEffectivelyVisibleView(providerInteractionViews.getCreativeViews());
            if (viewFirstEffectivelyVisibleView != null) {
                this.primaryActionView = viewFirstEffectivelyVisibleView;
            }
        }
        return zUpdateInterstitialInteractionViews;
    }

    @Override // com.tapsdk.tapad.internal.runtime.plugin.stub.FullscreenProviderHost
    public void bindFullscreenSurface(Activity activity, FrameLayout frameLayout, ViewGroup viewGroup, View view, ProviderInteractionViews providerInteractionViews, ProviderAttributionSlots providerAttributionSlots) {
        this.binding = true;
        try {
            this.intentAdapter.m381lambda$bind$0$comtapsdktapadinternalselfrenderSelfRenderIntentAdapter(activity, frameLayout);
            this.primaryActionView = view;
            if (providerInteractionViews == null) {
                providerInteractionViews = new ProviderInteractionViews(null, null, null);
            }
            this.providerInteractionViews = providerInteractionViews;
            List<View> listAllViews = providerInteractionViews.allViews();
            this.providerClickCandidates = listAllViews;
            this.latestClickView = listAllViews.isEmpty() ? viewGroup : this.providerClickCandidates.get(0);
            this.session.bindInterstitial(activity, frameLayout, viewGroup, this.providerInteractionViews, providerAttributionSlots, this);
            send(ProviderEvent.simple(1));
            this.binding = false;
            while (!this.bindingEvents.isEmpty() && !this.disposed.get()) {
                send(this.bindingEvents.removeFirst());
            }
        } catch (Throwable th) {
            this.binding = false;
            this.bindingEvents.clear();
            send(ProviderEvent.failed(2, -1, th.getMessage()));
            throw th;
        }
    }
}
