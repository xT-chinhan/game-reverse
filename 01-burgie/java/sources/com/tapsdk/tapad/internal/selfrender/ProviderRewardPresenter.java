package com.tapsdk.tapad.internal.selfrender;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.mg.PluginConstants;
import com.mar.sdk.IAction;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.tapsdk.tapad.b;
import com.tapsdk.tapad.constants.ErrorCodeEnum;
import com.tapsdk.tapad.internal.IoniaPlaybackSource;
import com.tapsdk.tapad.internal.runtime.CoreMediationTelemetryBridge;
import com.tapsdk.tapad.internal.runtime.CoreModuleSelector;
import com.tapsdk.tapad.internal.runtime.DirichletRuntime;
import com.tapsdk.tapad.internal.runtime.ShowHostFacts;
import com.tapsdk.tapad.internal.runtime.WasmAdInstance;
import com.tapsdk.tapad.internal.runtime.WasmModule;
import com.tapsdk.tapad.internal.runtime.WasmRuntimeController;
import com.tapsdk.tapad.internal.runtime.plugin.AdCallbackListener;
import com.tapsdk.tapad.internal.runtime.plugin.ProviderAttributionSlots;
import com.tapsdk.tapad.internal.runtime.plugin.ProviderInteractionViews;
import com.tapsdk.tapad.internal.runtime.plugin.stub.RewardProviderHost;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import com.umeng.analytics.pro.cc;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ProviderRewardPresenter implements AdCallbackListener, RewardProviderHost, ProviderEventSink, IoniaPlaybackSource {
    private static final String CORE_MEDIATION_STATUS_CALLBACK = "onCoreMediationStatusEvent";
    private static final String FN_EVENT = "ad_provider_reward_event_instance";
    private static final String FN_LOAD = "ad_load_normalized_reward_instance";
    private static final String FN_PRESENT = "ad_present_instance_v2";
    private static final int MAX_BINDING_EVENTS = 64;
    private static final String TAG = "ProviderRewardPresenter";
    private boolean binding;
    private final Context context;
    private final ProviderRewardSession.HostEvents hostEvents;
    private final SelfRenderIntentAdapter intentAdapter;
    private View latestClickView;
    private final WeakReference<Activity> launchActivity;
    private final ProviderRewardLoadFacts loadFacts;
    private View primaryActionView;
    private final ProviderRewardSession session;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final AtomicBoolean providerReleased = new AtomicBoolean(false);
    private final AtomicBoolean disposed = new AtomicBoolean(false);
    private final ArrayDeque<ProviderEvent> bindingEvents = new ArrayDeque<>();
    private WeakReference<WasmAdInstance> instanceRef = new WeakReference<>(null);
    private List<View> providerClickCandidates = Collections.EMPTY_LIST;
    private ProviderInteractionViews providerInteractionViews = new ProviderInteractionViews(null, null, null);

    private ProviderRewardPresenter(Activity activity, ProviderRewardSession providerRewardSession, ProviderRewardSession.HostEvents hostEvents, ProviderRewardLoadFacts providerRewardLoadFacts) {
        this.context = activity != null ? activity.getApplicationContext() : null;
        this.launchActivity = new WeakReference<>(activity);
        this.session = providerRewardSession;
        this.hostEvents = hostEvents;
        this.loadFacts = providerRewardLoadFacts;
        this.intentAdapter = new SelfRenderIntentAdapter(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void failBeforePresent(final String str) {
        this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.selfrender.ProviderRewardPresenter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m355lambda$failBeforePresent$4$comtapsdktapadinternalselfrenderProviderRewardPresenter(str);
            }
        });
    }

    private void finishFallback(JSONObject jSONObject) {
        if (this.disposed.get()) {
            return;
        }
        int iOptInt = jSONObject != null ? jSONObject.optInt("outcome", 2) : 2;
        try {
            if (iOptInt == 1 || iOptInt == 3) {
                this.hostEvents.onClose();
            } else {
                this.hostEvents.onVideoFailure(ErrorCodeEnum.LOAD_FAILED.getCode(), jSONObject != null ? jSONObject.optString("detail", "Reward fallback failed") : "Reward fallback failed");
            }
            dispose();
        } catch (Throwable th) {
            dispose();
            throw th;
        }
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
        return this.loadFacts.toJson();
    }

    private void loadWasm(final DirichletRuntime dirichletRuntime) {
        dirichletRuntime.loadModuleFromBundle("core", CoreModuleSelector.WASM_ENTRY, "core", new DirichletRuntime.ModuleLoadCallback() { // from class: com.tapsdk.tapad.internal.selfrender.ProviderRewardPresenter.1
            @Override // com.tapsdk.tapad.internal.runtime.DirichletRuntime.ModuleLoadCallback
            public void onError(Exception exc) {
                ProviderRewardPresenter.this.failBeforePresent("Signed Core bundle could not be loaded");
            }

            @Override // com.tapsdk.tapad.internal.runtime.DirichletRuntime.ModuleLoadCallback
            public void onSuccess(WasmModule wasmModule) {
                ProviderRewardPresenter.this.prepare(dirichletRuntime, wasmModule);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void prepare(final DirichletRuntime dirichletRuntime, final WasmModule wasmModule) {
        if (this.disposed.get()) {
            return;
        }
        if (!wasmModule.hasFunction(FN_LOAD) || !wasmModule.hasFunction(FN_EVENT) || !wasmModule.hasFunction(FN_PRESENT)) {
            failBeforePresent("Core Reward provider exports are unavailable");
        } else {
            if (dirichletRuntime.runOnRuntimeQueue(new Runnable() { // from class: com.tapsdk.tapad.internal.selfrender.ProviderRewardPresenter$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m356lambda$prepare$0$comtapsdktapadinternalselfrenderProviderRewardPresenter(dirichletRuntime, wasmModule);
                }
            })) {
                return;
            }
            failBeforePresent("Core runtime queue is unavailable");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: prepareOnRuntime, reason: merged with bridge method [inline-methods] */
    public void m356lambda$prepare$0$comtapsdktapadinternalselfrenderProviderRewardPresenter(final DirichletRuntime dirichletRuntime, WasmModule wasmModule) {
        try {
            WeakReference<WasmAdInstance> weakReferenceCreate = WasmAdInstance.create(wasmModule, new DirichletRuntime.NativeCallback() { // from class: com.tapsdk.tapad.internal.selfrender.ProviderRewardPresenter$$ExternalSyntheticLambda4
                @Override // com.tapsdk.tapad.internal.runtime.DirichletRuntime.NativeCallback
                public final void onCallback(String str, String str2) {
                    this.f$0.m136lambda$onCallback$2$comtapsdktapadinternalWasmNativeFeedPresenter(str, str2);
                }
            });
            final WasmAdInstance wasmAdInstance = weakReferenceCreate.get();
            if (wasmAdInstance != null && !this.disposed.get()) {
                this.instanceRef = weakReferenceCreate;
                dirichletRuntime.registerAdSurface(wasmAdInstance.instanceId(), wasmModule, this, this);
                int iCallIntSync = wasmModule.callIntSync(FN_LOAD, Integer.valueOf(wasmAdInstance.instanceId()), this.session.normalizedRewardCreative(), loadMeta().toString());
                if (iCallIntSync != 1) {
                    failBeforePresent("Core rejected normalized Reward: " + iCallIntSync);
                    return;
                } else {
                    this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.selfrender.ProviderRewardPresenter$$ExternalSyntheticLambda5
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.m357lambda$prepareOnRuntime$1$comtapsdktapadinternalselfrenderProviderRewardPresenter(dirichletRuntime, wasmAdInstance);
                        }
                    });
                    return;
                }
            }
            if (wasmAdInstance != null) {
                wasmAdInstance.dispose();
            }
            failBeforePresent("Core Reward instance could not be created");
        } catch (Throwable th) {
            failBeforePresent("Core Reward preparation failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: present, reason: merged with bridge method [inline-methods] */
    public void m357lambda$prepareOnRuntime$1$comtapsdktapadinternalselfrenderProviderRewardPresenter(DirichletRuntime dirichletRuntime, WasmAdInstance wasmAdInstance) {
        final Activity activity = this.launchActivity.get();
        if (this.disposed.get() || wasmAdInstance.isDisposed() || !isUsable(activity)) {
            failBeforePresent("Reward launch Activity ended before present");
            return;
        }
        try {
            dirichletRuntime.registerAdSurface(wasmAdInstance.instanceId(), wasmAdInstance.module(), this, this, activity);
            wasmAdInstance.module().callInt(FN_PRESENT, new WasmModule.IntCallback() { // from class: com.tapsdk.tapad.internal.selfrender.ProviderRewardPresenter$$ExternalSyntheticLambda1
                @Override // com.tapsdk.tapad.internal.runtime.WasmModule.IntCallback
                public final void onResult(int i) {
                    this.f$0.m358lambda$present$2$comtapsdktapadinternalselfrenderProviderRewardPresenter(activity, i);
                }
            }, Integer.valueOf(wasmAdInstance.instanceId()), Integer.valueOf(ShowHostFacts.forFullscreen(activity, false)));
        } catch (Throwable th) {
            failBeforePresent("Reward presentation could not start");
        }
    }

    private void releaseProvider() {
        ProviderRewardSession providerRewardSession;
        if (!this.providerReleased.compareAndSet(false, true) || (providerRewardSession = this.session) == null) {
            return;
        }
        providerRewardSession.releaseRewardProvider();
    }

    private void send(ProviderEvent providerEvent) {
        WasmAdInstance wasmAdInstanceInstance = instance();
        if (wasmAdInstanceInstance == null || providerEvent == null) {
            return;
        }
        wasmAdInstanceInstance.module().callInt(FN_EVENT, new WasmModule.IntCallback() { // from class: com.tapsdk.tapad.internal.selfrender.ProviderRewardPresenter$$ExternalSyntheticLambda6
            @Override // com.tapsdk.tapad.internal.runtime.WasmModule.IntCallback
            public final void onResult(int i) {
                this.f$0.m359lambda$send$3$comtapsdktapadinternalselfrenderProviderRewardPresenter(i);
            }
        }, Integer.valueOf(wasmAdInstanceInstance.instanceId()), providerEvent.toJson());
    }

    public static ProviderRewardPresenter show(Activity activity, ProviderRewardSession providerRewardSession, ProviderRewardSession.HostEvents hostEvents, ProviderRewardLoadFacts providerRewardLoadFacts) {
        ProviderRewardPresenter providerRewardPresenter = new ProviderRewardPresenter(activity, providerRewardSession, hostEvents, providerRewardLoadFacts);
        providerRewardPresenter.start();
        return providerRewardPresenter;
    }

    @Override // com.tapsdk.tapad.internal.selfrender.ProviderEventSink
    /* JADX INFO: renamed from: accept */
    public void m345lambda$accept$3$comtapsdktapadinternalselfrenderProviderInterstitialPresenter(ProviderEvent providerEvent) {
        ProviderEvent providerEventSimple;
        if (providerEvent == null || this.disposed.get()) {
            return;
        }
        ProviderEvent providerEvent2 = null;
        if (providerEvent.kind == 4) {
            int iResolve = ProviderClickCallbacks.resolve(providerEvent.sourceView, this.providerInteractionViews, 214, 201);
            int iOnProviderClickObserved = this.intentAdapter.onProviderClickObserved(iResolve);
            boolean zIsCompleteTemplateAction = ProviderClickCallbacks.isCompleteTemplateAction(iResolve);
            providerEvent = ProviderEvent.clicked(providerEvent.sourceView, zIsCompleteTemplateAction ? 0 : iResolve);
            ProviderEvent providerEventSimple2 = zIsCompleteTemplateAction ? ProviderEvent.simple(26, iResolve) : null;
            if (iOnProviderClickObserved > 0) {
                providerEvent2 = providerEventSimple2;
                providerEventSimple = ProviderEvent.simple(25, iOnProviderClickObserved);
            } else {
                providerEvent2 = providerEventSimple2;
                providerEventSimple = null;
            }
        } else {
            providerEventSimple = null;
        }
        View view = providerEvent.sourceView;
        if (view != null) {
            this.latestClickView = view;
        }
        if (!this.binding) {
            send(providerEvent);
            if (providerEvent2 != null) {
                send(providerEvent2);
            }
            if (providerEventSimple != null) {
                send(providerEventSimple);
                return;
            }
            return;
        }
        if (this.bindingEvents.size() >= 64) {
            this.bindingEvents.clear();
            this.binding = false;
            send(ProviderEvent.failed(13, -2, "Reward provider event queue overflow"));
            return;
        }
        this.bindingEvents.addLast(providerEvent);
        if (providerEvent2 != null) {
            if (this.bindingEvents.size() >= 64) {
                this.bindingEvents.clear();
                this.binding = false;
                send(ProviderEvent.failed(13, -2, "Reward provider event queue overflow"));
                return;
            }
            this.bindingEvents.addLast(providerEvent2);
        }
        if (providerEventSimple != null) {
            if (this.bindingEvents.size() < 64) {
                this.bindingEvents.addLast(providerEventSimple);
                return;
            }
            this.bindingEvents.clear();
            this.binding = false;
            send(ProviderEvent.failed(13, -2, "Reward provider event queue overflow"));
        }
    }

    @Override // com.tapsdk.tapad.internal.runtime.plugin.stub.FullscreenProviderHost
    public void bindFullscreenSurface(Activity activity, FrameLayout frameLayout, ViewGroup viewGroup, View view, ProviderInteractionViews providerInteractionViews, ProviderAttributionSlots providerAttributionSlots) {
        bindRewardSurface(activity, frameLayout, viewGroup, view, providerInteractionViews, providerAttributionSlots);
    }

    @Override // com.tapsdk.tapad.internal.runtime.plugin.stub.RewardProviderHost
    public void bindRewardSurface(Activity activity, FrameLayout frameLayout, ViewGroup viewGroup, View view, List<View> list, ProviderAttributionSlots providerAttributionSlots) {
        bindRewardSurface(activity, frameLayout, viewGroup, view, new ProviderInteractionViews(null, list, null), providerAttributionSlots);
    }

    @Override // com.tapsdk.tapad.internal.runtime.plugin.stub.RewardProviderHost
    public FrameLayout createRewardRoot(Activity activity) {
        return this.session.createRewardRoot(activity);
    }

    public void dispose() {
        if (this.disposed.compareAndSet(false, true)) {
            this.intentAdapter.release();
            this.bindingEvents.clear();
            WasmAdInstance wasmAdInstance = this.instanceRef.get();
            this.instanceRef = new WeakReference<>(null);
            if (wasmAdInstance != null) {
                wasmAdInstance.dispose();
            }
            releaseProvider();
        }
    }

    @Override // com.tapsdk.tapad.internal.IoniaPlaybackSource
    public String ioniaTriggerCorrelationId() {
        ProviderRewardLoadFacts providerRewardLoadFacts = this.loadFacts;
        return providerRewardLoadFacts == null ? "" : providerRewardLoadFacts.requestId();
    }

    @Override // com.tapsdk.tapad.internal.IoniaPlaybackSource
    public String ioniaWindowKey() {
        return (this.loadFacts == null || TextUtils.isEmpty(ioniaTriggerCorrelationId())) ? "" : this.loadFacts.trackId();
    }

    /* JADX INFO: renamed from: lambda$failBeforePresent$4$com-tapsdk-tapad-internal-selfrender-ProviderRewardPresenter, reason: not valid java name */
    /* synthetic */ void m355lambda$failBeforePresent$4$comtapsdktapadinternalselfrenderProviderRewardPresenter(String str) {
        if (!this.disposed.get()) {
            this.hostEvents.onVideoFailure(ErrorCodeEnum.LOAD_FAILED.getCode(), str);
        }
        dispose();
    }

    /* JADX INFO: renamed from: lambda$present$2$com-tapsdk-tapad-internal-selfrender-ProviderRewardPresenter, reason: not valid java name */
    /* synthetic */ void m358lambda$present$2$comtapsdktapadinternalselfrenderProviderRewardPresenter(Activity activity, int i) {
        if (i > 0) {
            this.hostEvents.onPresentationStarted(activity);
        } else {
            if (this.disposed.get()) {
                return;
            }
            failBeforePresent(b.a("Core rejected Reward presentation: ", i));
        }
    }

    /* JADX INFO: renamed from: lambda$send$3$com-tapsdk-tapad-internal-selfrender-ProviderRewardPresenter, reason: not valid java name */
    /* synthetic */ void m359lambda$send$3$comtapsdktapadinternalselfrenderProviderRewardPresenter(int i) {
        if (i < 0) {
            this.disposed.get();
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.tapsdk.tapad.internal.runtime.plugin.AdCallbackListener
    /* JADX INFO: renamed from: onCallback */
    public void m136lambda$onCallback$2$comtapsdktapadinternalWasmNativeFeedPresenter(String str, String str2) {
        byte b;
        if (!this.disposed.get() || "onProviderRelease".equals(str)) {
            if ("onProviderRelease".equals(str)) {
                this.intentAdapter.release();
                releaseProvider();
                return;
            }
            JSONObject jSONObjectJson = json(str2);
            if ("onFallbackTerminal".equals(str)) {
                finishFallback(jSONObjectJson);
                return;
            }
            if ("onProviderClickRequest".equals(str)) {
                this.intentAdapter.m382lambda$onProviderClickRequest$1$comtapsdktapadinternalselfrenderSelfRenderIntentAdapter(jSONObjectJson.optInt("interaction_id", 0), jSONObjectJson.optInt("source_type", Integer.MIN_VALUE), this.primaryActionView, this.providerClickCandidates);
                return;
            }
            if (CORE_MEDIATION_STATUS_CALLBACK.equals(str)) {
                CoreMediationTelemetryBridge.report(jSONObjectJson);
                return;
            }
            str.getClass();
            switch (str.hashCode()) {
                case -1667543221:
                    b = !str.equals("onProviderVideoPause") ? (byte) -1 : (byte) 0;
                    break;
                case -1664225865:
                    b = !str.equals("onProviderVideoStart") ? (byte) -1 : (byte) 1;
                    break;
                case -1621262140:
                    b = !str.equals("onProviderVideoPauseRequest") ? (byte) -1 : (byte) 2;
                    break;
                case -1349867671:
                    b = !str.equals("onError") ? (byte) -1 : (byte) 3;
                    break;
                case -599792911:
                    b = !str.equals("onProviderDownloadComplete") ? (byte) -1 : (byte) 4;
                    break;
                case -513478649:
                    b = !str.equals("onRewardVerify") ? (byte) -1 : (byte) 5;
                    break;
                case -498896949:
                    b = !str.equals("onProviderVideoMuteRequest") ? (byte) -1 : (byte) 6;
                    break;
                case -446533944:
                    b = !str.equals("onProviderVideoPrepared") ? (byte) -1 : (byte) 7;
                    break;
                case -93337224:
                    b = !str.equals("onProviderVideoResume") ? (byte) -1 : (byte) 8;
                    break;
                case -9706699:
                    b = !str.equals("onVideoComplete") ? (byte) -1 : (byte) 9;
                    break;
                case 157935686:
                    b = !str.equals("onAdClick") ? (byte) -1 : (byte) 10;
                    break;
                case 157941942:
                    b = !str.equals("onAdClose") ? (byte) -1 : (byte) 11;
                    break;
                case 859192426:
                    b = !str.equals("onProviderInstalled") ? (byte) -1 : (byte) 12;
                    break;
                case 975399039:
                    b = !str.equals("onAdShow") ? (byte) -1 : cc.k;
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
                case 1560324599:
                    b = !str.equals("onProviderVideoResumeRequest") ? (byte) -1 : (byte) 17;
                    break;
                case 1698677132:
                    b = !str.equals("onVideoError") ? (byte) -1 : (byte) 18;
                    break;
                default:
                    b = -1;
                    break;
            }
            switch (b) {
                case 0:
                    this.hostEvents.onVideoPause();
                    return;
                case 1:
                    this.hostEvents.onVideoStart();
                    return;
                case 2:
                    this.intentAdapter.onProviderVideoPauseRequest();
                    return;
                case 3:
                    try {
                        this.hostEvents.onVideoFailure(jSONObjectJson.optInt(PluginConstants.KEY_ERROR_CODE, ErrorCodeEnum.LOAD_FAILED.getCode()), jSONObjectJson.optString("message", "Core Reward error"));
                        return;
                    } finally {
                        dispose();
                    }
                case 4:
                    this.hostEvents.onDownloadComplete(jSONObjectJson.optLong("app_size"), jSONObjectJson.optLong("total_bytes"), jSONObjectJson.optString(NativeUnifiedADAppInfoImpl.Keys.APP_NAME), jSONObjectJson.optString("file_name"));
                    return;
                case 5:
                    Object objOpt = jSONObjectJson.opt(TrackAction.SUCCESS);
                    Object objOpt2 = jSONObjectJson.opt(IAction.BuyKey.CostAmount);
                    Object objOpt3 = jSONObjectJson.opt(Common.System.NAME);
                    Object objOpt4 = jSONObjectJson.opt(PluginConstants.KEY_ERROR_CODE);
                    Object objOpt5 = jSONObjectJson.opt("message");
                    Object objOpt6 = jSONObjectJson.opt("reward_source");
                    if ((objOpt instanceof Boolean) && (objOpt2 instanceof Number) && (objOpt3 instanceof String) && (objOpt4 instanceof Number) && (objOpt5 instanceof String) && (objOpt6 instanceof String)) {
                        long jLongValue = ((Number) objOpt2).longValue();
                        long jLongValue2 = ((Number) objOpt4).longValue();
                        if (jLongValue < -2147483648L || jLongValue > 2147483647L || jLongValue2 < -2147483648L || jLongValue2 > 2147483647L) {
                            return;
                        }
                        this.hostEvents.onRewardVerified(((Boolean) objOpt).booleanValue(), (int) jLongValue, (String) objOpt3, (int) jLongValue2, (String) objOpt5, (String) objOpt6);
                        return;
                    }
                    return;
                case 6:
                    this.session.setRewardVideoMuted(jSONObjectJson.optBoolean("muted", false));
                    return;
                case 7:
                    this.hostEvents.onVideoPrepared();
                    return;
                case 8:
                    this.hostEvents.onVideoResume();
                    return;
                case 9:
                    this.hostEvents.onVideoComplete(jSONObjectJson.optLong("duration_ms", 0L));
                    return;
                case 10:
                    this.hostEvents.onClick(this.latestClickView);
                    return;
                case 11:
                    try {
                        this.hostEvents.onClose();
                        return;
                    } finally {
                        dispose();
                    }
                case 12:
                    this.hostEvents.onInstalled(jSONObjectJson.optLong("app_size"), jSONObjectJson.optString(NativeUnifiedADAppInfoImpl.Keys.APP_NAME), jSONObjectJson.optString("file_name"));
                    return;
                case 13:
                    this.hostEvents.onShow(this.latestClickView);
                    return;
                case 14:
                    this.hostEvents.onDownloadFailure(jSONObjectJson.optLong("app_size"), jSONObjectJson.optLong("total_bytes"), jSONObjectJson.optLong("current_bytes"), jSONObjectJson.optString(NativeUnifiedADAppInfoImpl.Keys.APP_NAME), jSONObjectJson.optString("file_name"), jSONObjectJson.optInt("argument", -1), jSONObjectJson.optString("message"));
                    return;
                case 15:
                    this.hostEvents.onDownloadPause(jSONObjectJson.optLong("app_size"), jSONObjectJson.optLong("total_bytes"), jSONObjectJson.optLong("current_bytes"), jSONObjectJson.optString(NativeUnifiedADAppInfoImpl.Keys.APP_NAME), jSONObjectJson.optString("file_name"));
                    return;
                case 16:
                    this.hostEvents.onDownloadStart(jSONObjectJson.optLong("app_size"), jSONObjectJson.optString(NativeUnifiedADAppInfoImpl.Keys.APP_NAME), jSONObjectJson.optString("file_name"));
                    return;
                case 17:
                    this.intentAdapter.onProviderVideoResumeRequest();
                    return;
                case 18:
                    this.hostEvents.onVideoFailure(jSONObjectJson.optInt(PluginConstants.KEY_ERROR_CODE, -1), jSONObjectJson.optString("message", ""));
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.tapsdk.tapad.internal.runtime.plugin.stub.RewardProviderHost
    public void onRewardCoreUnavailable() {
        releaseProvider();
        dispose();
    }

    @Override // com.tapsdk.tapad.internal.runtime.plugin.stub.RewardProviderHost
    public void onRewardSurfaceBindFailed(String str) {
        send(ProviderEvent.failed(2, -1, str));
    }

    public void start() {
        Activity activity = this.launchActivity.get();
        if (this.context == null || this.session == null || this.hostEvents == null || this.loadFacts == null || !isUsable(activity)) {
            failBeforePresent("Reward launch Activity is unavailable");
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.selfrender.ProviderRewardPresenter$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.start();
                }
            });
            return;
        }
        if (!WasmRuntimeController.getInstance().ensureRewardCoreInitialized(this.context)) {
            failBeforePresent("Core runtime is unavailable");
            return;
        }
        DirichletRuntime dirichletRuntime = DirichletRuntime.getInstance();
        if (dirichletRuntime.isReady()) {
            loadWasm(dirichletRuntime);
        } else {
            failBeforePresent("Core runtime is unavailable");
        }
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
        boolean zUpdateRewardInteractionViews = this.session.updateRewardInteractionViews(providerInteractionViews.getClickViews(), providerInteractionViews.getCreativeViews(), providerInteractionViews.getDirectDownloadViews());
        if (zUpdateRewardInteractionViews) {
            this.providerInteractionViews = providerInteractionViews;
            this.providerClickCandidates = providerInteractionViews.allViews();
            View viewFirstEffectivelyVisibleView = firstEffectivelyVisibleView(providerInteractionViews.getCreativeViews());
            if (viewFirstEffectivelyVisibleView != null) {
                this.primaryActionView = viewFirstEffectivelyVisibleView;
            }
        }
        return zUpdateRewardInteractionViews;
    }

    private void bindRewardSurface(Activity activity, FrameLayout frameLayout, ViewGroup viewGroup, View view, ProviderInteractionViews providerInteractionViews, ProviderAttributionSlots providerAttributionSlots) {
        this.binding = true;
        try {
            this.intentAdapter.bind(activity);
            this.primaryActionView = view;
            if (providerInteractionViews == null) {
                providerInteractionViews = new ProviderInteractionViews(null, null, null);
            }
            this.providerInteractionViews = providerInteractionViews;
            List<View> listAllViews = providerInteractionViews.allViews();
            this.providerClickCandidates = listAllViews;
            this.latestClickView = listAllViews.isEmpty() ? viewGroup : this.providerClickCandidates.get(0);
            this.session.bindReward(activity, frameLayout, viewGroup, this.providerInteractionViews, providerAttributionSlots, this);
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
