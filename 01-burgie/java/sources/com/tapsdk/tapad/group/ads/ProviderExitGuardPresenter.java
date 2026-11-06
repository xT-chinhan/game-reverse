package com.tapsdk.tapad.group.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.byazt.mg.PluginConstants;
import com.mar.sdk.IAction;
import com.tapsdk.tapad.internal.runtime.CoreMediationTelemetryBridge;
import com.tapsdk.tapad.internal.runtime.CoreModuleSelector;
import com.tapsdk.tapad.internal.runtime.DirichletRuntime;
import com.tapsdk.tapad.internal.runtime.WasmAdInstance;
import com.tapsdk.tapad.internal.runtime.WasmModule;
import com.tapsdk.tapad.internal.runtime.WasmRuntimeController;
import com.tapsdk.tapad.internal.selfrender.ProviderRewardLoadFacts;
import com.tapsdk.tapad.internal.selfrender.ProviderRewardSession;
import com.tapsdk.tapad.internal.selfrender.RewardCapsuleHost;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class ProviderExitGuardPresenter implements RewardCapsuleHost.Callback, RewardCapsuleProcessBridge.OwnerCallback {
    private static final String CORE_MEDIATION_STATUS_CALLBACK = "onCoreMediationStatusEvent";
    private static final int EVENT_CLICKED = 4;
    private static final int EVENT_EXIT_GUARD_CLICKED = 19;
    private static final int EVENT_EXIT_GUARD_CLOSE_RESULT = 20;
    private static final int EVENT_EXIT_GUARD_HOST_ATTACHED = 21;
    private static final int EVENT_PROVIDER_CLOSED = 22;
    private static final int EVENT_SHOWN = 3;
    private static final String FN_EVENT = "ad_provider_reward_event_instance";
    private static final String FN_LOAD = "ad_load_provider_exit_guard_instance";
    private static final String TAG = "ProviderExitGuardPresenter";
    private boolean closeRequested;
    private final Context context;
    private boolean coreReady;
    private volatile boolean disposed;
    private final OrderedHostEvents hostEvents;
    private boolean hostStarted;
    private final WeakReference<Activity> launchActivity;
    private final ProviderRewardLoadFacts loadFacts;
    private Runnable providerCloseCompletion;
    private boolean providerCloseEvaluationPending;
    private boolean providerShown;
    private long providerShownAtMs;
    private boolean shownSent;
    private final String sessionId = Process.myPid() + "-" + UUID.randomUUID();
    private final Handler main = new Handler(Looper.getMainLooper());
    private final CallbackDeliveryQueue callbackDelivery = new CallbackDeliveryQueue();
    private int selectedHostPid = -1;
    private WeakReference<WasmAdInstance> instanceRef = new WeakReference<>(null);

    public static final class CallbackDeliveryQueue {
        private Delivery active;
        private boolean draining;
        private final ArrayDeque<Delivery> pending = new ArrayDeque<>();

        public interface Delivery {
            void deliver(Runnable runnable);
        }

        private void drain() {
            if (this.draining) {
                return;
            }
            this.draining = true;
            while (this.active == null && !this.pending.isEmpty()) {
                try {
                    Delivery deliveryRemoveFirst = this.pending.removeFirst();
                    this.active = deliveryRemoveFirst;
                    final boolean[] zArr = {false};
                    Runnable runnable = new Runnable() { // from class: com.tapsdk.tapad.group.ads.ProviderExitGuardPresenter$CallbackDeliveryQueue$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.m87lambda$drain$0$comtapsdktapadgroupadsProviderExitGuardPresenter$CallbackDeliveryQueue(zArr);
                        }
                    };
                    try {
                        deliveryRemoveFirst.deliver(runnable);
                    } catch (Error | RuntimeException e) {
                        runnable.run();
                        throw e;
                    }
                } catch (Throwable th) {
                    this.draining = false;
                    throw th;
                }
            }
            this.draining = false;
        }

        public void clearPending() {
            this.pending.clear();
        }

        public void enqueue(Delivery delivery) {
            this.pending.addLast(delivery);
            drain();
        }

        /* JADX INFO: renamed from: lambda$drain$0$com-tapsdk-tapad-group-ads-ProviderExitGuardPresenter$CallbackDeliveryQueue, reason: not valid java name */
        /* synthetic */ void m87lambda$drain$0$comtapsdktapadgroupadsProviderExitGuardPresenter$CallbackDeliveryQueue(boolean[] zArr) {
            if (zArr[0]) {
                return;
            }
            zArr[0] = true;
            this.active = null;
            drain();
        }
    }

    public interface OrderedHostEvents extends ProviderRewardSession.HostEvents {
        void onExitGuardClosed();

        void onRewardVerified(boolean z, int i, String str, int i2, String str2, String str3, Runnable runnable);
    }

    private ProviderExitGuardPresenter(Activity activity, ProviderRewardLoadFacts providerRewardLoadFacts, OrderedHostEvents orderedHostEvents) {
        this.context = activity != null ? activity.getApplicationContext() : null;
        this.launchActivity = new WeakReference<>(activity);
        this.loadFacts = providerRewardLoadFacts;
        this.hostEvents = orderedHostEvents;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void completeProviderCloseEvaluation() {
        if (this.providerCloseEvaluationPending) {
            this.providerCloseEvaluationPending = false;
            Runnable runnable = this.providerCloseCompletion;
            this.providerCloseCompletion = null;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disposeOnMain() {
        if (this.disposed) {
            return;
        }
        this.disposed = true;
        this.callbackDelivery.clearPending();
        this.providerCloseEvaluationPending = false;
        this.providerCloseCompletion = null;
        RewardCapsuleHost.getInstance().stop(this.context, this.sessionId);
        RewardCapsuleProcessBridge rewardCapsuleProcessBridge = RewardCapsuleProcessBridge.getInstance();
        rewardCapsuleProcessBridge.stopRemote(this.context, this.sessionId);
        rewardCapsuleProcessBridge.unregisterOwner(this.sessionId);
        WasmAdInstance wasmAdInstance = this.instanceRef.get();
        this.instanceRef = new WeakReference<>(null);
        if (wasmAdInstance != null) {
            wasmAdInstance.dispose();
        }
    }

    private void enqueueCompletion(final Runnable runnable) {
        if (runnable == null) {
            return;
        }
        m78lambda$onCallback$8$comtapsdktapadgroupadsProviderExitGuardPresenter(new Runnable() { // from class: com.tapsdk.tapad.group.ads.ProviderExitGuardPresenter$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m74lambda$enqueueCompletion$12$comtapsdktapadgroupadsProviderExitGuardPresenter(runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void failClosed(final String str) {
        m78lambda$onCallback$8$comtapsdktapadgroupadsProviderExitGuardPresenter(new Runnable() { // from class: com.tapsdk.tapad.group.ads.ProviderExitGuardPresenter$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m75lambda$failClosed$13$comtapsdktapadgroupadsProviderExitGuardPresenter(str);
            }
        });
    }

    private void handleCallback(String str, JSONObject jSONObject) {
        if (this.disposed) {
            return;
        }
        if (CORE_MEDIATION_STATUS_CALLBACK.equals(str)) {
            CoreMediationTelemetryBridge.report(jSONObject);
            return;
        }
        if ("onRewardFallbackCapsuleShow".equals(str)) {
            render(jSONObject);
            return;
        }
        if ("onRewardFallbackCapsuleUpdate".equals(str)) {
            render(jSONObject);
            return;
        }
        if ("onRewardFallbackCountdownComplete".equals(str)) {
            render(jSONObject);
            return;
        }
        if ("onRewardFallbackProviderCloseEvaluated".equals(str)) {
            completeProviderCloseEvaluation();
            return;
        }
        if (!"onAdClose".equals(str) || this.closeRequested) {
            return;
        }
        this.closeRequested = true;
        int i = this.selectedHostPid;
        if (i <= 0 || i == Process.myPid()) {
            RewardCapsuleHost.getInstance().close(this.context, this.sessionId);
        }
        int i2 = this.selectedHostPid;
        if (i2 <= 0 || i2 != Process.myPid()) {
            RewardCapsuleProcessBridge.getInstance().closeRemote(this.context, this.sessionId);
        }
    }

    private void handleCloseResult(JSONObject jSONObject, final boolean z, String str) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            jSONObject = jSONObject2;
        }
        try {
            jSONObject.put("kind", 20);
            jSONObject.put("argument", z ? 1 : 0);
            jSONObject.put("message", safe(str));
            sendEvent(jSONObject, new Runnable() { // from class: com.tapsdk.tapad.group.ads.ProviderExitGuardPresenter$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m76lambda$handleCloseResult$7$comtapsdktapadgroupadsProviderExitGuardPresenter(z);
                }
            });
        } catch (Exception e) {
            dispose();
        }
    }

    private void handleRewardCallback(JSONObject jSONObject, Runnable runnable) {
        try {
            Object objOpt = jSONObject.opt(TrackAction.SUCCESS);
            Object objOpt2 = jSONObject.opt(IAction.BuyKey.CostAmount);
            Object objOpt3 = jSONObject.opt(Common.System.NAME);
            Object objOpt4 = jSONObject.opt(PluginConstants.KEY_ERROR_CODE);
            Object objOpt5 = jSONObject.opt("message");
            Object objOpt6 = jSONObject.opt("reward_source");
            if (!(objOpt instanceof Boolean) || !(objOpt2 instanceof Number) || !(objOpt3 instanceof String) || !(objOpt4 instanceof Number) || !(objOpt5 instanceof String) || !(objOpt6 instanceof String)) {
                runnable.run();
                return;
            }
            long jLongValue = ((Number) objOpt2).longValue();
            long jLongValue2 = ((Number) objOpt4).longValue();
            if (jLongValue < -2147483648L || jLongValue > 2147483647L || jLongValue2 < -2147483648L || jLongValue2 > 2147483647L) {
                runnable.run();
                return;
            } else {
                try {
                    this.hostEvents.onRewardVerified(((Boolean) objOpt).booleanValue(), (int) jLongValue, (String) objOpt3, (int) jLongValue2, (String) objOpt5, (String) objOpt6, runnable);
                    return;
                } catch (Throwable th) {
                }
            }
        } catch (Throwable th2) {
        }
        runnable.run();
    }

    private static JSONObject hostFact(RewardCapsuleHost.HostEvent hostEvent) {
        JSONObject jSONObject = new JSONObject();
        if (hostEvent != null) {
            try {
                jSONObject.put("remote_pid", Math.max(0, hostEvent.processId));
                jSONObject.put("remote_process_name", safe(hostEvent.processName));
                jSONObject.put("remote_activity_name", safe(hostEvent.activityName));
                return jSONObject;
            } catch (Exception e) {
            }
        }
        return jSONObject;
    }

    private WasmAdInstance instance() {
        WasmAdInstance wasmAdInstance = this.instanceRef.get();
        if (wasmAdInstance == null || wasmAdInstance.isDisposed()) {
            return null;
        }
        return wasmAdInstance;
    }

    private boolean isSelectedHost(int i) {
        return !this.disposed && i > 0 && this.selectedHostPid == i;
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
        dirichletRuntime.loadModuleFromBundle("core", CoreModuleSelector.WASM_ENTRY, "core", new DirichletRuntime.ModuleLoadCallback() { // from class: com.tapsdk.tapad.group.ads.ProviderExitGuardPresenter.1
            @Override // com.tapsdk.tapad.internal.runtime.DirichletRuntime.ModuleLoadCallback
            public void onError(Exception exc) {
                ProviderExitGuardPresenter.this.failClosed("signed Core bundle could not be loaded");
            }

            @Override // com.tapsdk.tapad.internal.runtime.DirichletRuntime.ModuleLoadCallback
            public void onSuccess(WasmModule wasmModule) {
                ProviderExitGuardPresenter.this.prepare(dirichletRuntime, wasmModule);
            }
        });
    }

    private void maybeStartHost() {
        if (this.disposed || !this.coreReady || !this.providerShown || this.hostStarted) {
            return;
        }
        this.hostStarted = true;
        RewardCapsuleProcessBridge rewardCapsuleProcessBridge = RewardCapsuleProcessBridge.getInstance();
        rewardCapsuleProcessBridge.registerOwner(this.sessionId, this);
        if (!this.shownSent) {
            this.shownSent = true;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("kind", 3);
                jSONObject.put("monotonic_ms", Math.max(0L, this.providerShownAtMs));
                sendEvent(jSONObject, null);
            } catch (Exception e) {
                return;
            }
        }
        RewardCapsuleHost.getInstance().start(this.context, this.sessionId, this.launchActivity.get(), this);
        rewardCapsuleProcessBridge.startRemote(this.context, this.sessionId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCallback(final String str, final String str2) {
        if (this.disposed) {
            return;
        }
        m78lambda$onCallback$8$comtapsdktapadgroupadsProviderExitGuardPresenter(new Runnable() { // from class: com.tapsdk.tapad.group.ads.ProviderExitGuardPresenter$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m77lambda$onCallback$10$comtapsdktapadgroupadsProviderExitGuardPresenter(str2, str);
            }
        });
    }

    public static ProviderExitGuardPresenter prepare(Activity activity, ProviderRewardLoadFacts providerRewardLoadFacts, OrderedHostEvents orderedHostEvents) {
        ProviderExitGuardPresenter providerExitGuardPresenter = new ProviderExitGuardPresenter(activity, providerRewardLoadFacts, orderedHostEvents);
        providerExitGuardPresenter.start();
        return providerExitGuardPresenter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: prepareOnRuntime, reason: merged with bridge method [inline-methods] */
    public void m83lambda$prepare$4$comtapsdktapadgroupadsProviderExitGuardPresenter(WasmModule wasmModule) {
        try {
            WeakReference<WasmAdInstance> weakReferenceCreate = WasmAdInstance.create(wasmModule, new DirichletRuntime.NativeCallback() { // from class: com.tapsdk.tapad.group.ads.ProviderExitGuardPresenter$$ExternalSyntheticLambda4
                @Override // com.tapsdk.tapad.internal.runtime.DirichletRuntime.NativeCallback
                public final void onCallback(String str, String str2) {
                    this.f$0.onCallback(str, str2);
                }
            });
            WasmAdInstance wasmAdInstance = weakReferenceCreate.get();
            if (wasmAdInstance != null && !this.disposed) {
                this.instanceRef = weakReferenceCreate;
                if (this.disposed) {
                    wasmAdInstance.dispose();
                    this.instanceRef = new WeakReference<>(null);
                    return;
                }
                int iCallIntSync = wasmModule.callIntSync(FN_LOAD, Integer.valueOf(wasmAdInstance.instanceId()), loadMeta().toString());
                if (iCallIntSync == 0) {
                    dispose();
                    return;
                } else if (iCallIntSync != 1) {
                    failClosed("Core rejected exit-guard config: " + iCallIntSync);
                    return;
                } else {
                    this.main.post(new Runnable() { // from class: com.tapsdk.tapad.group.ads.ProviderExitGuardPresenter$$ExternalSyntheticLambda5
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.m84lambda$prepareOnRuntime$5$comtapsdktapadgroupadsProviderExitGuardPresenter();
                        }
                    });
                    return;
                }
            }
            if (wasmAdInstance != null) {
                wasmAdInstance.dispose();
            }
            failClosed("Core exit-guard instance could not be created");
        } catch (Throwable th) {
            failClosed("Core exit-guard preparation failed");
        }
    }

    private static JSONObject remoteHostFact(RewardCapsuleProcessBridge.RemoteEvent remoteEvent) {
        JSONObject jSONObject = new JSONObject();
        if (remoteEvent != null) {
            try {
                jSONObject.put("remote_pid", Math.max(0, remoteEvent.remotePid));
                jSONObject.put("remote_process_name", safe(remoteEvent.remoteProcessName));
                jSONObject.put("remote_activity_name", safe(remoteEvent.remoteActivityName));
                return jSONObject;
            } catch (Exception e) {
            }
        }
        return jSONObject;
    }

    private void render(JSONObject jSONObject) {
        int i = this.selectedHostPid;
        if (i <= 0 || i == Process.myPid()) {
            RewardCapsuleHost.getInstance().render(this.context, this.sessionId, jSONObject);
        }
        int i2 = this.selectedHostPid;
        if (i2 <= 0 || i2 != Process.myPid()) {
            RewardCapsuleProcessBridge.getInstance().renderRemote(this.context, this.sessionId, jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: runOnMain, reason: merged with bridge method [inline-methods] */
    public void m78lambda$onCallback$8$comtapsdktapadgroupadsProviderExitGuardPresenter(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.main.post(runnable);
        }
    }

    private static String safe(String str) {
        return str == null ? "" : str;
    }

    private boolean selectHost(int i) {
        if (this.disposed || i <= 0) {
            return false;
        }
        int i2 = this.selectedHostPid;
        if (i2 > 0) {
            return i2 == i;
        }
        this.selectedHostPid = i;
        RewardCapsuleProcessBridge.getInstance().selectHost(this.context, this.sessionId, i);
        if (i != Process.myPid()) {
            RewardCapsuleHost.getInstance().stop(this.context, this.sessionId);
        }
        return true;
    }

    private void sendEvent(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("kind", i);
            sendEvent(jSONObject, null);
        } catch (Exception e) {
        }
    }

    private void start() {
        if (this.context == null || this.loadFacts == null || this.hostEvents == null) {
            dispose();
        } else {
            m78lambda$onCallback$8$comtapsdktapadgroupadsProviderExitGuardPresenter(new Runnable() { // from class: com.tapsdk.tapad.group.ads.ProviderExitGuardPresenter$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m86lambda$start$3$comtapsdktapadgroupadsProviderExitGuardPresenter();
                }
            });
        }
    }

    public void dispose() {
        m78lambda$onCallback$8$comtapsdktapadgroupadsProviderExitGuardPresenter(new Runnable() { // from class: com.tapsdk.tapad.group.ads.ProviderExitGuardPresenter$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.disposeOnMain();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$enqueueCompletion$11$com-tapsdk-tapad-group-ads-ProviderExitGuardPresenter, reason: not valid java name */
    /* synthetic */ void m73lambda$enqueueCompletion$11$comtapsdktapadgroupadsProviderExitGuardPresenter(Runnable runnable, Runnable runnable2) {
        try {
            if (!this.disposed) {
                runnable.run();
            }
        } finally {
            runnable2.run();
        }
    }

    /* JADX INFO: renamed from: lambda$enqueueCompletion$12$com-tapsdk-tapad-group-ads-ProviderExitGuardPresenter, reason: not valid java name */
    /* synthetic */ void m74lambda$enqueueCompletion$12$comtapsdktapadgroupadsProviderExitGuardPresenter(final Runnable runnable) {
        this.callbackDelivery.enqueue(new CallbackDeliveryQueue.Delivery() { // from class: com.tapsdk.tapad.group.ads.ProviderExitGuardPresenter$$ExternalSyntheticLambda0
            @Override // com.tapsdk.tapad.group.ads.ProviderExitGuardPresenter.CallbackDeliveryQueue.Delivery
            public final void deliver(Runnable runnable2) {
                this.f$0.m73lambda$enqueueCompletion$11$comtapsdktapadgroupadsProviderExitGuardPresenter(runnable, runnable2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$failClosed$13$com-tapsdk-tapad-group-ads-ProviderExitGuardPresenter, reason: not valid java name */
    /* synthetic */ void m75lambda$failClosed$13$comtapsdktapadgroupadsProviderExitGuardPresenter(String str) {
        dispose();
    }

    /* JADX INFO: renamed from: lambda$handleCloseResult$7$com-tapsdk-tapad-group-ads-ProviderExitGuardPresenter, reason: not valid java name */
    /* synthetic */ void m76lambda$handleCloseResult$7$comtapsdktapadgroupadsProviderExitGuardPresenter(boolean z) {
        if (z) {
            this.hostEvents.onExitGuardClosed();
        } else {
            dispose();
        }
    }

    /* JADX INFO: renamed from: lambda$onCallback$10$com-tapsdk-tapad-group-ads-ProviderExitGuardPresenter, reason: not valid java name */
    /* synthetic */ void m77lambda$onCallback$10$comtapsdktapadgroupadsProviderExitGuardPresenter(final String str, final String str2) {
        this.callbackDelivery.enqueue(new CallbackDeliveryQueue.Delivery() { // from class: com.tapsdk.tapad.group.ads.ProviderExitGuardPresenter$$ExternalSyntheticLambda9
            @Override // com.tapsdk.tapad.group.ads.ProviderExitGuardPresenter.CallbackDeliveryQueue.Delivery
            public final void deliver(Runnable runnable) {
                this.f$0.m79lambda$onCallback$9$comtapsdktapadgroupadsProviderExitGuardPresenter(str, str2, runnable);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onCallback$9$com-tapsdk-tapad-group-ads-ProviderExitGuardPresenter, reason: not valid java name */
    /* synthetic */ void m79lambda$onCallback$9$comtapsdktapadgroupadsProviderExitGuardPresenter(String str, String str2, final Runnable runnable) {
        if (this.disposed) {
            runnable.run();
            return;
        }
        JSONObject jSONObjectJson = json(str);
        if ("onRewardVerify".equals(str2)) {
            handleRewardCallback(jSONObjectJson, new Runnable() { // from class: com.tapsdk.tapad.group.ads.ProviderExitGuardPresenter$$ExternalSyntheticLambda13
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m78lambda$onCallback$8$comtapsdktapadgroupadsProviderExitGuardPresenter(runnable);
                }
            });
            return;
        }
        try {
            handleCallback(str2, jSONObjectJson);
        } finally {
            runnable.run();
        }
    }

    /* JADX INFO: renamed from: lambda$onProviderClicked$1$com-tapsdk-tapad-group-ads-ProviderExitGuardPresenter, reason: not valid java name */
    /* synthetic */ void m80lambda$onProviderClicked$1$comtapsdktapadgroupadsProviderExitGuardPresenter() {
        if (this.disposed || !this.hostStarted) {
            return;
        }
        sendEvent(4);
    }

    /* JADX INFO: renamed from: lambda$onProviderClosed$2$com-tapsdk-tapad-group-ads-ProviderExitGuardPresenter, reason: not valid java name */
    /* synthetic */ void m81lambda$onProviderClosed$2$comtapsdktapadgroupadsProviderExitGuardPresenter(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (this.disposed || this.closeRequested || !this.coreReady || this.providerCloseEvaluationPending) {
            runnable.run();
            return;
        }
        this.providerCloseEvaluationPending = true;
        this.providerCloseCompletion = runnable;
        JSONObject jSONObjectHostFact = hostFact(null);
        try {
            jSONObjectHostFact.put("kind", 22);
            sendEvent(jSONObjectHostFact, new Runnable() { // from class: com.tapsdk.tapad.group.ads.ProviderExitGuardPresenter$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.completeProviderCloseEvaluation();
                }
            });
        } catch (Exception e) {
            completeProviderCloseEvaluation();
        }
    }

    /* JADX INFO: renamed from: lambda$onProviderShown$0$com-tapsdk-tapad-group-ads-ProviderExitGuardPresenter, reason: not valid java name */
    /* synthetic */ void m82lambda$onProviderShown$0$comtapsdktapadgroupadsProviderExitGuardPresenter() {
        this.providerShown = true;
        this.providerShownAtMs = SystemClock.elapsedRealtime();
        maybeStartHost();
    }

    /* JADX INFO: renamed from: lambda$prepareOnRuntime$5$com-tapsdk-tapad-group-ads-ProviderExitGuardPresenter, reason: not valid java name */
    /* synthetic */ void m84lambda$prepareOnRuntime$5$comtapsdktapadgroupadsProviderExitGuardPresenter() {
        if (this.disposed) {
            return;
        }
        this.coreReady = true;
        maybeStartHost();
    }

    /* JADX INFO: renamed from: lambda$sendEvent$6$com-tapsdk-tapad-group-ads-ProviderExitGuardPresenter, reason: not valid java name */
    /* synthetic */ void m85lambda$sendEvent$6$comtapsdktapadgroupadsProviderExitGuardPresenter(Runnable runnable, int i) {
        enqueueCompletion(runnable);
    }

    /* JADX INFO: renamed from: lambda$start$3$com-tapsdk-tapad-group-ads-ProviderExitGuardPresenter, reason: not valid java name */
    /* synthetic */ void m86lambda$start$3$comtapsdktapadgroupadsProviderExitGuardPresenter() {
        if (this.disposed || !WasmRuntimeController.getInstance().ensureRewardCoreInitialized(this.context)) {
            failClosed("signed Core runtime is unavailable");
            return;
        }
        DirichletRuntime dirichletRuntime = DirichletRuntime.getInstance();
        if (dirichletRuntime.isReady()) {
            loadWasm(dirichletRuntime);
        } else {
            failClosed("signed Core runtime is unavailable");
        }
    }

    @Override // com.tapsdk.tapad.internal.selfrender.RewardCapsuleHost.Callback
    public void onCloseResult(RewardCapsuleHost.HostEvent hostEvent, boolean z, String str) {
        if (isSelectedHost(Process.myPid())) {
            handleCloseResult(hostFact(hostEvent), z, str);
        }
    }

    @Override // com.tapsdk.tapad.internal.selfrender.RewardCapsuleHost.Callback
    public void onHostAttached(RewardCapsuleHost.HostEvent hostEvent) {
        if (selectHost(Process.myPid())) {
            JSONObject jSONObjectHostFact = hostFact(hostEvent);
            try {
                jSONObjectHostFact.put("kind", 21);
                sendEvent(jSONObjectHostFact, null);
            } catch (Exception e) {
            }
        }
    }

    @Override // com.tapsdk.tapad.internal.selfrender.RewardCapsuleHost.Callback
    public void onHostClick(RewardCapsuleHost.HostEvent hostEvent) {
        if (isSelectedHost(Process.myPid())) {
            sendEvent(19);
        }
    }

    @Override // com.tapsdk.tapad.internal.selfrender.RewardCapsuleHost.Callback
    public void onHostPaused(RewardCapsuleHost.HostEvent hostEvent) {
        WasmAdInstance wasmAdInstanceInstance;
        if (isSelectedHost(Process.myPid()) && (wasmAdInstanceInstance = instance()) != null) {
            DirichletRuntime.getInstance().triggerPause(wasmAdInstanceInstance.instanceId());
        }
    }

    @Override // com.tapsdk.tapad.internal.selfrender.RewardCapsuleHost.Callback
    public void onHostResumed(RewardCapsuleHost.HostEvent hostEvent) {
        WasmAdInstance wasmAdInstanceInstance;
        if (isSelectedHost(Process.myPid()) && (wasmAdInstanceInstance = instance()) != null) {
            DirichletRuntime.getInstance().triggerResume(wasmAdInstanceInstance.instanceId());
        }
    }

    public void onProviderClicked() {
        m78lambda$onCallback$8$comtapsdktapadgroupadsProviderExitGuardPresenter(new Runnable() { // from class: com.tapsdk.tapad.group.ads.ProviderExitGuardPresenter$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m80lambda$onProviderClicked$1$comtapsdktapadgroupadsProviderExitGuardPresenter();
            }
        });
    }

    public void onProviderClosed(final Runnable runnable) {
        m78lambda$onCallback$8$comtapsdktapadgroupadsProviderExitGuardPresenter(new Runnable() { // from class: com.tapsdk.tapad.group.ads.ProviderExitGuardPresenter$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m81lambda$onProviderClosed$2$comtapsdktapadgroupadsProviderExitGuardPresenter(runnable);
            }
        });
    }

    public void onProviderShown() {
        m78lambda$onCallback$8$comtapsdktapadgroupadsProviderExitGuardPresenter(new Runnable() { // from class: com.tapsdk.tapad.group.ads.ProviderExitGuardPresenter$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m82lambda$onProviderShown$0$comtapsdktapadgroupadsProviderExitGuardPresenter();
            }
        });
    }

    @Override // com.tapsdk.tapad.group.ads.RewardCapsuleProcessBridge.OwnerCallback
    public void onRemoteCloseResult(RewardCapsuleProcessBridge.RemoteEvent remoteEvent, boolean z, String str) {
        if (remoteEvent == null || !isSelectedHost(remoteEvent.remotePid)) {
            return;
        }
        handleCloseResult(remoteHostFact(remoteEvent), z, str);
    }

    @Override // com.tapsdk.tapad.group.ads.RewardCapsuleProcessBridge.OwnerCallback
    public void onRemoteHostAttached(RewardCapsuleProcessBridge.RemoteEvent remoteEvent) {
        if (remoteEvent == null || !selectHost(remoteEvent.remotePid)) {
            return;
        }
        JSONObject jSONObjectRemoteHostFact = remoteHostFact(remoteEvent);
        try {
            jSONObjectRemoteHostFact.put("kind", 21);
            sendEvent(jSONObjectRemoteHostFact, null);
        } catch (Exception e) {
        }
    }

    @Override // com.tapsdk.tapad.group.ads.RewardCapsuleProcessBridge.OwnerCallback
    public void onRemoteHostClick(RewardCapsuleProcessBridge.RemoteEvent remoteEvent) {
        if (remoteEvent == null || !isSelectedHost(remoteEvent.remotePid)) {
            return;
        }
        sendEvent(19);
    }

    @Override // com.tapsdk.tapad.group.ads.RewardCapsuleProcessBridge.OwnerCallback
    public void onRemoteHostPaused(RewardCapsuleProcessBridge.RemoteEvent remoteEvent) {
        WasmAdInstance wasmAdInstanceInstance;
        if (remoteEvent == null || !isSelectedHost(remoteEvent.remotePid) || (wasmAdInstanceInstance = instance()) == null) {
            return;
        }
        DirichletRuntime.getInstance().triggerPause(wasmAdInstanceInstance.instanceId());
    }

    @Override // com.tapsdk.tapad.group.ads.RewardCapsuleProcessBridge.OwnerCallback
    public void onRemoteHostResumed(RewardCapsuleProcessBridge.RemoteEvent remoteEvent) {
        WasmAdInstance wasmAdInstanceInstance;
        if (remoteEvent == null || !isSelectedHost(remoteEvent.remotePid) || (wasmAdInstanceInstance = instance()) == null) {
            return;
        }
        DirichletRuntime.getInstance().triggerResume(wasmAdInstanceInstance.instanceId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void prepare(DirichletRuntime dirichletRuntime, final WasmModule wasmModule) {
        if (!this.disposed && wasmModule.hasFunction(FN_LOAD) && wasmModule.hasFunction(FN_EVENT)) {
            if (dirichletRuntime.runOnRuntimeQueue(new Runnable() { // from class: com.tapsdk.tapad.group.ads.ProviderExitGuardPresenter$$ExternalSyntheticLambda15
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m83lambda$prepare$4$comtapsdktapadgroupadsProviderExitGuardPresenter(wasmModule);
                }
            })) {
                return;
            }
            failClosed("Core runtime queue is unavailable");
            return;
        }
        failClosed("provider exit-guard exports are unavailable");
    }

    private void sendEvent(JSONObject jSONObject, final Runnable runnable) {
        WasmAdInstance wasmAdInstanceInstance = instance();
        if (wasmAdInstanceInstance == null) {
            enqueueCompletion(runnable);
        } else {
            wasmAdInstanceInstance.module().callInt(FN_EVENT, new WasmModule.IntCallback() { // from class: com.tapsdk.tapad.group.ads.ProviderExitGuardPresenter$$ExternalSyntheticLambda14
                @Override // com.tapsdk.tapad.internal.runtime.WasmModule.IntCallback
                public final void onResult(int i) {
                    this.f$0.m85lambda$sendEvent$6$comtapsdktapadgroupadsProviderExitGuardPresenter(runnable, i);
                }
            }, Integer.valueOf(wasmAdInstanceInstance.instanceId()), jSONObject.toString());
        }
    }
}
