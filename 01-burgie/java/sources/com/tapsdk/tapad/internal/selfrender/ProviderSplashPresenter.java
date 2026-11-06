package com.tapsdk.tapad.internal.selfrender;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.tapsdk.tapad.b;
import com.tapsdk.tapad.c;
import com.tapsdk.tapad.constants.ErrorCodeEnum;
import com.tapsdk.tapad.internal.AdType;
import com.tapsdk.tapad.internal.AndroidSplashFallback;
import com.tapsdk.tapad.internal.WasmCoreModuleLoader;
import com.tapsdk.tapad.internal.runtime.DirichletRuntime;
import com.tapsdk.tapad.internal.runtime.ShowHostFacts;
import com.tapsdk.tapad.internal.runtime.WasmAdInstance;
import com.tapsdk.tapad.internal.runtime.WasmModule;
import com.tapsdk.tapad.internal.runtime.WasmRuntimeController;
import com.tapsdk.tapad.internal.runtime.plugin.AdCallbackListener;
import com.tapsdk.tapad.internal.runtime.plugin.ProviderAttributionSlots;
import com.tapsdk.tapad.internal.runtime.plugin.ProviderInteractionViews;
import com.tapsdk.tapad.internal.runtime.plugin.stub.InlineAdSurfaceHost;
import com.tapsdk.tapad.internal.runtime.plugin.stub.SplashProviderHost;
import com.umeng.analytics.pro.cc;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ProviderSplashPresenter implements AdCallbackListener, SplashProviderHost, ProviderEventSink {
    private static final String FN_EVENT = "ad_provider_splash_event_instance";
    private static final String FN_LOAD = "ad_load_normalized_splash_instance";
    private static final String FN_PRESENT = "ad_present_splash_instance_v2";
    private static final String FN_RENDER = "ad_render_splash";
    private static final int MAX_BINDING_EVENTS = 64;
    private static final String TAG = "ProviderSplashPresenter";
    private final WeakReference<Activity> activityRef;
    private boolean binding;
    private final WeakReference<ViewGroup> containerRef;
    private final Context context;
    private boolean fallbackActive;
    private final String fallbackImageUrl;
    private AndroidSplashFallback.Session fallbackSession;
    private final ProviderSplashSession.HostEvents hostEvents;
    private final SelfRenderIntentAdapter intentAdapter;
    private View latestClickView;
    private final ProviderSplashSession.LoadFacts loadFacts;
    private boolean rendered;
    private FrameLayout root;
    private final ProviderSplashSession session;
    private boolean shown;
    private boolean surfaceBound;
    private boolean timeOver;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final AtomicBoolean disposed = new AtomicBoolean(false);
    private final AtomicBoolean providerReleased = new AtomicBoolean(false);
    private final ArrayDeque<ProviderEvent> bindingEvents = new ArrayDeque<>();
    private WeakReference<WasmAdInstance> instanceRef = new WeakReference<>(null);
    private int hostToken = -1;
    private ProviderInteractionViews providerInteractionViews = new ProviderInteractionViews(null, null, null);

    private ProviderSplashPresenter(ViewGroup viewGroup, Activity activity, ProviderSplashSession providerSplashSession, ProviderSplashSession.HostEvents hostEvents, ProviderSplashSession.LoadFacts loadFacts, String str) {
        this.containerRef = new WeakReference<>(viewGroup);
        this.activityRef = new WeakReference<>(activity);
        this.context = activity != null ? activity.getApplicationContext() : null;
        this.session = providerSplashSession;
        this.hostEvents = hostEvents;
        this.intentAdapter = new SelfRenderIntentAdapter(this, false);
        this.loadFacts = loadFacts;
        this.fallbackImageUrl = safe(str);
    }

    private void disposeCoreOnly() {
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
        send(ProviderEvent.failed(13, -2, "Splash provider event queue overflow"));
        return false;
    }

    private void ensureFallbackRoot() {
        ViewGroup viewGroup;
        if (this.root == null && (viewGroup = this.containerRef.get()) != null) {
            FrameLayout frameLayoutCreateSplashRoot = this.session.createSplashRoot(viewGroup.getContext());
            this.root = frameLayoutCreateSplashRoot;
            if (frameLayoutCreateSplashRoot != null) {
                viewGroup.removeAllViews();
                viewGroup.addView(this.root, new ViewGroup.LayoutParams(-1, -1));
                Activity activity = this.activityRef.get();
                if (isUsable(activity)) {
                    this.hostEvents.onPresentationStarted(activity);
                }
            }
        }
    }

    private void failWithoutSurface(String str) {
        if (this.disposed.get()) {
            return;
        }
        this.hostEvents.onRenderFailure(this.root, ErrorCodeEnum.LOAD_FAILED.getCode(), str);
        this.hostEvents.onClose();
        dispose();
    }

    private static View firstNonNull(View view, View view2) {
        return view == null ? view2 : view;
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
        return this.loadFacts.toJson();
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
                m366lambda$startFallback$6$comtapsdktapadinternalselfrenderProviderSplashPresenter(c.a("Core Splash provider export is unavailable: ", str));
                return;
            }
        }
        if (dirichletRuntime.runOnRuntimeQueue(new Runnable() { // from class: com.tapsdk.tapad.internal.selfrender.ProviderSplashPresenter$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m362lambda$prepare$0$comtapsdktapadinternalselfrenderProviderSplashPresenter(dirichletRuntime, wasmModule);
            }
        })) {
            return;
        }
        m366lambda$startFallback$6$comtapsdktapadinternalselfrenderProviderSplashPresenter("Core runtime queue is unavailable");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: prepareOnRuntime, reason: merged with bridge method [inline-methods] */
    public void m362lambda$prepare$0$comtapsdktapadinternalselfrenderProviderSplashPresenter(final DirichletRuntime dirichletRuntime, WasmModule wasmModule) {
        try {
            WeakReference<WasmAdInstance> weakReferenceCreate = WasmAdInstance.create(wasmModule, new DirichletRuntime.NativeCallback() { // from class: com.tapsdk.tapad.internal.selfrender.ProviderSplashPresenter$$ExternalSyntheticLambda3
                @Override // com.tapsdk.tapad.internal.runtime.DirichletRuntime.NativeCallback
                public final void onCallback(String str, String str2) {
                    this.f$0.m136lambda$onCallback$2$comtapsdktapadinternalWasmNativeFeedPresenter(str, str2);
                }
            });
            final WasmAdInstance wasmAdInstance = weakReferenceCreate.get();
            if (wasmAdInstance != null && !this.disposed.get()) {
                this.instanceRef = weakReferenceCreate;
                dirichletRuntime.registerAdSurface(wasmAdInstance.instanceId(), wasmModule, this, this);
                int iCallIntSync = wasmModule.callIntSync(FN_LOAD, Integer.valueOf(wasmAdInstance.instanceId()), this.session.normalizedSplashCreative(), loadMeta().toString());
                if (iCallIntSync != 1) {
                    m366lambda$startFallback$6$comtapsdktapadinternalselfrenderProviderSplashPresenter("Core rejected normalized Splash: " + iCallIntSync);
                    return;
                } else {
                    this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.selfrender.ProviderSplashPresenter$$ExternalSyntheticLambda4
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.m363lambda$prepareOnRuntime$1$comtapsdktapadinternalselfrenderProviderSplashPresenter(dirichletRuntime, wasmAdInstance);
                        }
                    });
                    return;
                }
            }
            if (wasmAdInstance != null) {
                wasmAdInstance.dispose();
            }
            m366lambda$startFallback$6$comtapsdktapadinternalselfrenderProviderSplashPresenter("Core Splash instance could not be created");
        } catch (Throwable th) {
            m366lambda$startFallback$6$comtapsdktapadinternalselfrenderProviderSplashPresenter("Core Splash preparation failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: present, reason: merged with bridge method [inline-methods] */
    public void m363lambda$prepareOnRuntime$1$comtapsdktapadinternalselfrenderProviderSplashPresenter(DirichletRuntime dirichletRuntime, WasmAdInstance wasmAdInstance) {
        if (this.disposed.get() || wasmAdInstance.isDisposed()) {
            return;
        }
        ViewGroup viewGroup = this.containerRef.get();
        Activity activity = this.activityRef.get();
        if (viewGroup == null || !isUsable(activity)) {
            m366lambda$startFallback$6$comtapsdktapadinternalselfrenderProviderSplashPresenter("Splash container ended before present");
            return;
        }
        try {
            FrameLayout frameLayoutCreateSplashRoot = this.session.createSplashRoot(viewGroup.getContext());
            this.root = frameLayoutCreateSplashRoot;
            if (frameLayoutCreateSplashRoot == null) {
                throw new IllegalStateException("Provider Splash root is null");
            }
            viewGroup.removeAllViews();
            viewGroup.addView(this.root, new ViewGroup.LayoutParams(-1, -1));
            this.hostEvents.onPresentationStarted(activity);
            dirichletRuntime.registerAdSurface(wasmAdInstance.instanceId(), wasmAdInstance.module(), this, this, activity);
            int iRegister = InlineAdSurfaceHost.register(this.root, AdType.SplashAd);
            this.hostToken = iRegister;
            if (iRegister <= 0) {
                throw new IllegalStateException("Inline Splash host registration failed");
            }
            wasmAdInstance.module().callInt(FN_PRESENT, new WasmModule.IntCallback() { // from class: com.tapsdk.tapad.internal.selfrender.ProviderSplashPresenter$$ExternalSyntheticLambda5
                @Override // com.tapsdk.tapad.internal.runtime.WasmModule.IntCallback
                public final void onResult(int i) {
                    this.f$0.m364lambda$present$2$comtapsdktapadinternalselfrenderProviderSplashPresenter(i);
                }
            }, Integer.valueOf(wasmAdInstance.instanceId()), Integer.valueOf(this.hostToken), Integer.valueOf(ShowHostFacts.forInline(this.root)));
        } catch (Throwable th) {
            m366lambda$startFallback$6$comtapsdktapadinternalselfrenderProviderSplashPresenter("Provider Splash presentation could not start");
        }
    }

    private void releaseProvider() {
        if (this.providerReleased.compareAndSet(false, true)) {
            this.intentAdapter.release();
            this.session.releaseSplashProvider();
        }
    }

    private static Activity resolveActivity(View view) {
        Context baseContext;
        Context context = view == null ? null : view.getContext();
        while (context != null) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            if (!(context instanceof ContextWrapper) || (baseContext = ((ContextWrapper) context).getBaseContext()) == context) {
                return null;
            }
            context = baseContext;
        }
        return null;
    }

    private static String safe(String str) {
        return str == null ? "" : str;
    }

    private void send(ProviderEvent providerEvent) {
        WasmAdInstance wasmAdInstanceInstance = instance();
        if (wasmAdInstanceInstance == null || providerEvent == null) {
            return;
        }
        wasmAdInstanceInstance.module().callInt(FN_EVENT, new WasmModule.IntCallback() { // from class: com.tapsdk.tapad.internal.selfrender.ProviderSplashPresenter$$ExternalSyntheticLambda8
            @Override // com.tapsdk.tapad.internal.runtime.WasmModule.IntCallback
            public final void onResult(int i) {
                this.f$0.m365lambda$send$4$comtapsdktapadinternalselfrenderProviderSplashPresenter(i);
            }
        }, Integer.valueOf(wasmAdInstanceInstance.instanceId()), providerEvent.toJson());
    }

    public static ProviderSplashPresenter show(ViewGroup viewGroup, ProviderSplashSession providerSplashSession, ProviderSplashSession.HostEvents hostEvents, ProviderSplashSession.LoadFacts loadFacts, String str) {
        ProviderSplashPresenter providerSplashPresenter = new ProviderSplashPresenter(viewGroup, resolveActivity(viewGroup), providerSplashSession, hostEvents, loadFacts, str);
        providerSplashPresenter.start();
        return providerSplashPresenter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.selfrender.ProviderSplashPresenter$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.start();
                }
            });
            return;
        }
        if (this.disposed.get()) {
            return;
        }
        if (this.context == null || this.session == null || this.hostEvents == null || this.loadFacts == null || this.containerRef.get() == null || !isUsable(this.activityRef.get())) {
            failWithoutSurface("Splash container Activity is unavailable");
            return;
        }
        if (!WasmRuntimeController.getInstance().ensureAdCoreInitialized(this.context)) {
            m366lambda$startFallback$6$comtapsdktapadinternalselfrenderProviderSplashPresenter("Core runtime is unavailable");
            return;
        }
        final DirichletRuntime dirichletRuntime = DirichletRuntime.getInstance();
        if (dirichletRuntime.isReady()) {
            WasmCoreModuleLoader.load(dirichletRuntime, new WasmCoreModuleLoader.Callback() { // from class: com.tapsdk.tapad.internal.selfrender.ProviderSplashPresenter.1
                @Override // com.tapsdk.tapad.internal.WasmCoreModuleLoader.Callback
                public void onError(Exception exc) {
                    ProviderSplashPresenter.this.m366lambda$startFallback$6$comtapsdktapadinternalselfrenderProviderSplashPresenter("Signed Core bundle could not be loaded");
                }

                @Override // com.tapsdk.tapad.internal.WasmCoreModuleLoader.Callback
                public void onLoaded(WasmModule wasmModule) {
                    ProviderSplashPresenter.this.prepare(dirichletRuntime, wasmModule);
                }
            });
        } else {
            m366lambda$startFallback$6$comtapsdktapadinternalselfrenderProviderSplashPresenter("Core runtime is unavailable");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: startFallback, reason: merged with bridge method [inline-methods] */
    public void m366lambda$startFallback$6$comtapsdktapadinternalselfrenderProviderSplashPresenter(final String str) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.selfrender.ProviderSplashPresenter$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m366lambda$startFallback$6$comtapsdktapadinternalselfrenderProviderSplashPresenter(str);
                }
            });
            return;
        }
        if (this.disposed.get() || this.fallbackActive) {
            return;
        }
        this.fallbackActive = true;
        int i = this.hostToken;
        if (i > 0) {
            FrameLayout frameLayoutTakeOverForFallback = InlineAdSurfaceHost.takeOverForFallback(i);
            if (frameLayoutTakeOverForFallback != null) {
                this.root = frameLayoutTakeOverForFallback;
            }
            this.hostToken = -1;
        }
        ensureFallbackRoot();
        disposeCoreOnly();
        FrameLayout frameLayout = this.root;
        if (frameLayout == null) {
            failWithoutSurface(str);
        } else {
            this.fallbackSession = AndroidSplashFallback.show(frameLayout, this.fallbackImageUrl, new AndroidSplashFallback.Listener() { // from class: com.tapsdk.tapad.internal.selfrender.ProviderSplashPresenter.2
                @Override // com.tapsdk.tapad.internal.AndroidSplashFallback.Listener
                public void onFinished(boolean z) {
                    if (z) {
                        ProviderSplashPresenter.this.hostEvents.onSplashSkipped();
                        ProviderSplashPresenter.this.hostEvents.onClose();
                    } else {
                        ProviderSplashPresenter.this.timeOver = true;
                        ProviderSplashPresenter.this.hostEvents.onSplashTimeOver();
                    }
                    ProviderSplashPresenter.this.dispose();
                }

                @Override // com.tapsdk.tapad.internal.AndroidSplashFallback.Listener
                public void onShow(long j) {
                    if (!ProviderSplashPresenter.this.rendered) {
                        ProviderSplashPresenter.this.rendered = true;
                        ProviderSplashPresenter.this.hostEvents.onSplashBound(ProviderSplashPresenter.this.root, j);
                    }
                    if (ProviderSplashPresenter.this.shown) {
                        return;
                    }
                    ProviderSplashPresenter.this.shown = true;
                    ProviderSplashPresenter.this.hostEvents.onShow(ProviderSplashPresenter.this.root);
                }

                @Override // com.tapsdk.tapad.internal.AndroidSplashFallback.Listener
                public void onValidShow() {
                }
            });
        }
    }

    @Override // com.tapsdk.tapad.internal.selfrender.ProviderEventSink
    /* JADX INFO: renamed from: accept, reason: merged with bridge method [inline-methods] */
    public void m360lambda$accept$3$comtapsdktapadinternalselfrenderProviderSplashPresenter(final ProviderEvent providerEvent) {
        if (providerEvent == null || this.disposed.get() || this.fallbackActive) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.selfrender.ProviderSplashPresenter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m360lambda$accept$3$comtapsdktapadinternalselfrenderProviderSplashPresenter(providerEvent);
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
        int iResolve = ProviderClickCallbacks.resolve(view, this.providerInteractionViews, 6100, 6108);
        int iOnProviderClickObserved = this.intentAdapter.onProviderClickObserved(iResolve);
        if (enqueueProviderEvent(ProviderEvent.clicked(providerEvent.sourceView, 0))) {
            if ((iResolve <= 0 || enqueueProviderEvent(ProviderEvent.simple(26, iResolve))) && iOnProviderClickObserved > 0) {
                enqueueProviderEvent(ProviderEvent.simple(25, iOnProviderClickObserved));
            }
        }
    }

    @Override // com.tapsdk.tapad.internal.runtime.plugin.stub.SplashProviderHost
    public void bindSplashSurface(Context context, FrameLayout frameLayout, View view, List<View> list, ProviderAttributionSlots providerAttributionSlots) {
        bindSplashSurface(context, frameLayout, view, new ProviderInteractionViews(list, list, null), providerAttributionSlots);
    }

    @Override // com.tapsdk.tapad.internal.runtime.plugin.stub.SplashProviderHost
    public FrameLayout createSplashRoot(Context context) {
        return this.session.createSplashRoot(context);
    }

    public void dispose() {
        if (this.disposed.compareAndSet(false, true)) {
            this.bindingEvents.clear();
            AndroidSplashFallback.Session session = this.fallbackSession;
            this.fallbackSession = null;
            if (session != null) {
                session.release();
            }
            int i = this.hostToken;
            if (i > 0) {
                InlineAdSurfaceHost.release(i);
                this.hostToken = -1;
            }
            disposeCoreOnly();
            releaseProvider();
            FrameLayout frameLayout = this.root;
            if (frameLayout != null && (frameLayout.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.root.getParent()).removeView(this.root);
            }
            FrameLayout frameLayout2 = this.root;
            if (frameLayout2 != null) {
                frameLayout2.removeAllViews();
            }
            this.root = null;
        }
    }

    /* JADX INFO: renamed from: lambda$onCallback$5$com-tapsdk-tapad-internal-selfrender-ProviderSplashPresenter, reason: not valid java name */
    /* synthetic */ boolean m361lambda$onCallback$5$comtapsdktapadinternalselfrenderProviderSplashPresenter(int i) {
        return this.session.performSplashMotionAction(this.latestClickView, i, this.providerInteractionViews.allViews());
    }

    /* JADX INFO: renamed from: lambda$present$2$com-tapsdk-tapad-internal-selfrender-ProviderSplashPresenter, reason: not valid java name */
    /* synthetic */ void m364lambda$present$2$comtapsdktapadinternalselfrenderProviderSplashPresenter(int i) {
        if (ShowHostFacts.isAdmissionRejection(i) && !this.disposed.get()) {
            failWithoutSurface(b.a("Core rejected Splash presentation: ", i));
        } else {
            if (i > 0 || this.disposed.get()) {
                return;
            }
            m366lambda$startFallback$6$comtapsdktapadinternalselfrenderProviderSplashPresenter(b.a("Core Splash attach failed: ", i));
        }
    }

    /* JADX INFO: renamed from: lambda$send$4$com-tapsdk-tapad-internal-selfrender-ProviderSplashPresenter, reason: not valid java name */
    /* synthetic */ void m365lambda$send$4$comtapsdktapadinternalselfrenderProviderSplashPresenter(int i) {
        if (i < 0) {
            this.disposed.get();
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.tapsdk.tapad.internal.runtime.plugin.AdCallbackListener
    /* JADX INFO: renamed from: onCallback */
    public void m136lambda$onCallback$2$comtapsdktapadinternalWasmNativeFeedPresenter(String str, String str2) {
        byte b;
        if ("onProviderSplashRelease".equals(str)) {
            releaseProvider();
            return;
        }
        if (this.disposed.get()) {
            return;
        }
        if ("onProviderSplashClickRequest".equals(str)) {
            JSONObject jSONObjectJson = json(str2);
            final int iOptInt = jSONObjectJson.optInt("trigger", 0);
            if (iOptInt > 0) {
                this.intentAdapter.onProviderMotionRequest(jSONObjectJson.optInt("interaction_id", 0), jSONObjectJson.optInt("source_type", 0), new SelfRenderIntentAdapter.MotionAction() { // from class: com.tapsdk.tapad.internal.selfrender.ProviderSplashPresenter$$ExternalSyntheticLambda6
                    @Override // com.tapsdk.tapad.internal.selfrender.SelfRenderIntentAdapter.MotionAction
                    public final boolean perform() {
                        return this.f$0.m361lambda$onCallback$5$comtapsdktapadinternalselfrenderProviderSplashPresenter(iOptInt);
                    }
                });
                return;
            } else {
                this.intentAdapter.m382lambda$onProviderClickRequest$1$comtapsdktapadinternalselfrenderSelfRenderIntentAdapter(jSONObjectJson.optInt("interaction_id", 0), jSONObjectJson.optInt("source_type", 0), this.latestClickView, this.providerInteractionViews.allViews());
                return;
            }
        }
        JSONObject jSONObjectJson2 = json(str2);
        str.getClass();
        switch (str.hashCode()) {
            case -1621262140:
                b = !str.equals("onProviderVideoPauseRequest") ? (byte) -1 : (byte) 0;
                break;
            case -1349867671:
                b = !str.equals("onError") ? (byte) -1 : (byte) 1;
                break;
            case -911027773:
                b = !str.equals("onAdTimeOver") ? (byte) -1 : (byte) 2;
                break;
            case -692224505:
                b = !str.equals("onSplashRenderSuccess") ? (byte) -1 : (byte) 3;
                break;
            case -689813959:
                b = !str.equals("onVideoPrepared") ? (byte) -1 : (byte) 4;
                break;
            case -599792911:
                b = !str.equals("onProviderDownloadComplete") ? (byte) -1 : (byte) 5;
                break;
            case -498896949:
                b = !str.equals("onProviderVideoMuteRequest") ? (byte) -1 : (byte) 6;
                break;
            case -9706699:
                b = !str.equals("onVideoComplete") ? (byte) -1 : (byte) 7;
                break;
            case 157935686:
                b = !str.equals("onAdClick") ? (byte) -1 : (byte) 8;
                break;
            case 157941942:
                b = !str.equals("onAdClose") ? (byte) -1 : (byte) 9;
                break;
            case 231071050:
                b = !str.equals("onCoreRuntimeFatal") ? (byte) -1 : (byte) 10;
                break;
            case 859192426:
                b = !str.equals("onProviderInstalled") ? (byte) -1 : (byte) 11;
                break;
            case 975399039:
                b = !str.equals("onAdShow") ? (byte) -1 : (byte) 12;
                break;
            case 975401729:
                b = !str.equals("onAdSkip") ? (byte) -1 : cc.k;
                break;
            case 1107704656:
                b = !str.equals("onProviderDownloadError") ? (byte) -1 : cc.l;
                break;
            case 1117359934:
                b = !str.equals("onProviderDownloadPause") ? (byte) -1 : cc.m;
                break;
            case 1120677290:
                b = !str.equals("onProviderDownloadStart") ? (byte) -1 : cc.n;
                break;
            case 1302043440:
                b = !str.equals("onVideoPlay") ? (byte) -1 : (byte) 17;
                break;
            case 1479592233:
                b = !str.equals("onVideoResume") ? (byte) -1 : (byte) 18;
                break;
            case 1560324599:
                b = !str.equals("onProviderVideoResumeRequest") ? (byte) -1 : (byte) 19;
                break;
            case 1708332410:
                b = !str.equals("onVideoPause") ? (byte) -1 : (byte) 20;
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
            case 10:
                m366lambda$startFallback$6$comtapsdktapadinternalselfrenderProviderSplashPresenter(jSONObjectJson2.optString("message", str));
                return;
            case 2:
                this.timeOver = true;
                this.hostEvents.onSplashTimeOver();
                return;
            case 3:
                if (this.rendered) {
                    return;
                }
                this.rendered = true;
                this.hostEvents.onSplashBound(this.root, jSONObjectJson2.optLong("countdown_ms", 0L));
                return;
            case 4:
                this.hostEvents.onVideoPrepared();
                return;
            case 5:
                this.hostEvents.onDownloadComplete(jSONObjectJson2.optLong("app_size"), jSONObjectJson2.optLong("total_bytes"), jSONObjectJson2.optString(NativeUnifiedADAppInfoImpl.Keys.APP_NAME), jSONObjectJson2.optString("file_name"));
                return;
            case 6:
                this.session.setSplashVideoMuted(jSONObjectJson2.optBoolean("muted", false));
                return;
            case 7:
                this.hostEvents.onVideoComplete(jSONObjectJson2.optLong("argument", 0L));
                return;
            case 8:
                this.hostEvents.onClick(firstNonNull(this.latestClickView, this.root));
                return;
            case 9:
                try {
                    if (!this.timeOver) {
                        this.hostEvents.onClose();
                        break;
                    }
                    return;
                } finally {
                    dispose();
                }
            case 11:
                this.hostEvents.onInstalled(jSONObjectJson2.optLong("app_size"), jSONObjectJson2.optString(NativeUnifiedADAppInfoImpl.Keys.APP_NAME), jSONObjectJson2.optString("file_name"));
                return;
            case 12:
                if (this.shown) {
                    return;
                }
                this.shown = true;
                this.hostEvents.onShow(firstNonNull(this.latestClickView, this.root));
                return;
            case 13:
                this.hostEvents.onSplashSkipped();
                return;
            case 14:
                this.hostEvents.onDownloadFailure(jSONObjectJson2.optLong("app_size"), jSONObjectJson2.optLong("total_bytes"), jSONObjectJson2.optLong("current_bytes"), jSONObjectJson2.optString(NativeUnifiedADAppInfoImpl.Keys.APP_NAME), jSONObjectJson2.optString("file_name"), jSONObjectJson2.optInt("argument", -1), jSONObjectJson2.optString("message"));
                return;
            case 15:
                this.hostEvents.onDownloadPause(jSONObjectJson2.optLong("app_size"), jSONObjectJson2.optLong("total_bytes"), jSONObjectJson2.optLong("current_bytes"), jSONObjectJson2.optString(NativeUnifiedADAppInfoImpl.Keys.APP_NAME), jSONObjectJson2.optString("file_name"));
                return;
            case 16:
                this.hostEvents.onDownloadStart(jSONObjectJson2.optLong("app_size"), jSONObjectJson2.optString(NativeUnifiedADAppInfoImpl.Keys.APP_NAME), jSONObjectJson2.optString("file_name"));
                return;
            case 17:
                this.hostEvents.onVideoStart();
                return;
            case 18:
                this.hostEvents.onVideoResume();
                return;
            case 19:
                this.intentAdapter.onProviderVideoResumeRequest();
                return;
            case 20:
                this.hostEvents.onVideoPause();
                return;
            default:
                return;
        }
    }

    @Override // com.tapsdk.tapad.internal.runtime.plugin.stub.SplashProviderHost
    public void onSplashCoreUnavailable() {
        m366lambda$startFallback$6$comtapsdktapadinternalselfrenderProviderSplashPresenter("Core Splash runtime became unavailable");
    }

    @Override // com.tapsdk.tapad.internal.runtime.plugin.stub.SplashProviderHost
    public void onSplashSurfaceBindFailed(String str) {
        send(ProviderEvent.failed(2, -1, str));
    }

    @Override // com.tapsdk.tapad.internal.runtime.plugin.stub.SplashProviderHost
    public boolean updateSplashInteractionViews(ProviderInteractionViews providerInteractionViews) {
        if (providerInteractionViews == null) {
            providerInteractionViews = new ProviderInteractionViews(null, null, null);
        }
        boolean zUpdateSplashInteractionViews = this.session.updateSplashInteractionViews(providerInteractionViews.getClickViews(), providerInteractionViews.getCreativeViews(), providerInteractionViews.getDirectDownloadViews());
        if (zUpdateSplashInteractionViews) {
            this.providerInteractionViews = providerInteractionViews;
        }
        return zUpdateSplashInteractionViews;
    }

    @Override // com.tapsdk.tapad.internal.runtime.plugin.stub.SplashProviderHost
    public void bindSplashSurface(Context context, FrameLayout frameLayout, View view, ProviderInteractionViews providerInteractionViews, ProviderAttributionSlots providerAttributionSlots) {
        Activity activity = this.activityRef.get();
        if (!isUsable(activity)) {
            throw new IllegalStateException("Splash Activity is unavailable during bind");
        }
        this.binding = true;
        try {
            this.intentAdapter.m381lambda$bind$0$comtapsdktapadinternalselfrenderSelfRenderIntentAdapter(activity, frameLayout);
            this.latestClickView = view;
            ProviderInteractionViews providerInteractionViews2 = providerInteractionViews == null ? new ProviderInteractionViews(null, null, null) : providerInteractionViews;
            this.providerInteractionViews = providerInteractionViews2;
            this.session.bindSplash(activity, frameLayout, view, providerInteractionViews2, providerAttributionSlots, this);
            if (!this.surfaceBound) {
                this.surfaceBound = true;
                send(ProviderEvent.simple(1));
            }
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
