package com.tapsdk.tapad.group.ads;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.mg.PluginConstants;
import com.bytedance.android.live.base.api.push.ILivePush;
import com.mar.sdk.IAction;
import com.tapsdk.tapad.group.adapter.AdapterAdEventSink;
import com.tapsdk.tapad.group.adapter.AdapterHostedRewardSession;
import com.tapsdk.tapad.group.adapter.AdapterNativeFullscreenBinding;
import com.tapsdk.tapad.group.adapter.AdapterNativeRewardSession;
import com.tapsdk.tapad.group.adapter.AdapterRewardSession;
import com.tapsdk.tapad.internal.runtime.MediationControlBridge;
import com.tapsdk.tapad.internal.runtime.MediationRuntimeCoreBridge;
import com.tapsdk.tapad.internal.runtime.plugin.ProviderAttributionSlots;
import com.tapsdk.tapad.internal.runtime.plugin.ProviderInteractionViews;
import com.tapsdk.tapad.internal.selfrender.ProviderEventSink;
import com.tapsdk.tapad.internal.selfrender.ProviderRewardLoadFacts;
import com.tapsdk.tapad.internal.selfrender.ProviderRewardPresenter;
import com.tapsdk.tapad.internal.selfrender.ProviderRewardSession;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class MediationRewardSession extends AdapterAdCandidate<AdapterRewardSession> implements ProviderExitGuardPresenter.OrderedHostEvents {
    private static final long IONIA_PROVIDER_CLOSE_GRACE_MS = 500;
    private final NativeCoreSession coreSession;
    private ProviderExitGuardPresenter exitGuardPresenter;
    private final AdapterHostedRewardSession hostedSession;
    private DirichletRewardVideoAd.RewardAdInteractionListener interactionListener;
    private final AdapterNativeRewardSession nativeSession;
    private ProviderRewardPresenter providerPresenter;
    private final RewardHost rewardHost;

    public static final class AndroidRewardHost implements RewardHost {
        private final Handler main;

        private AndroidRewardHost() {
            this.main = new Handler(Looper.getMainLooper());
        }

        @Override // com.tapsdk.tapad.group.ads.MediationRewardSession.RewardHost
        public boolean claimShow(MediationRewardSession mediationRewardSession, Activity activity) {
            return MediationShowAdmissionBridge.claimFullscreen(mediationRewardSession, 1, activity, mediationRewardSession.isValid());
        }

        @Override // com.tapsdk.tapad.group.ads.MediationRewardSession.RewardHost
        public void postDelayed(Runnable runnable, long j) {
            this.main.postDelayed(runnable, j);
        }

        @Override // com.tapsdk.tapad.group.ads.MediationRewardSession.RewardHost
        public ProviderExitGuardPresenter prepareExitGuard(Activity activity, ProviderRewardLoadFacts providerRewardLoadFacts, ProviderExitGuardPresenter.OrderedHostEvents orderedHostEvents) {
            return ProviderExitGuardPresenter.prepare(activity, providerRewardLoadFacts, orderedHostEvents);
        }

        @Override // com.tapsdk.tapad.group.ads.MediationRewardSession.RewardHost
        public void resolve(JSONObject jSONObject, MediationRuntimeCoreBridge.RewardCallbackCommandReceiver rewardCallbackCommandReceiver) {
            MediationRuntimeCoreBridge.resolveRewardCallback(jSONObject, rewardCallbackCommandReceiver);
        }

        @Override // com.tapsdk.tapad.group.ads.MediationRewardSession.RewardHost
        public void runOnMain(Runnable runnable) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
            } else {
                this.main.post(runnable);
            }
        }
    }

    public interface RewardHost {
        boolean claimShow(MediationRewardSession mediationRewardSession, Activity activity);

        void postDelayed(Runnable runnable, long j);

        ProviderExitGuardPresenter prepareExitGuard(Activity activity, ProviderRewardLoadFacts providerRewardLoadFacts, ProviderExitGuardPresenter.OrderedHostEvents orderedHostEvents);

        void resolve(JSONObject jSONObject, MediationRuntimeCoreBridge.RewardCallbackCommandReceiver rewardCallbackCommandReceiver);

        void runOnMain(Runnable runnable);
    }

    public MediationRewardSession(AdapterRewardSession adapterRewardSession) {
        this(adapterRewardSession, new AndroidRewardHost());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyCallbackCommand(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("payload")) == null) {
            return;
        }
        String strOptString = jSONObject.optString(Common.System.NAME, "");
        strOptString.getClass();
        switch (strOptString) {
            case "awaitExitGuardClose":
                scheduleCoreFact(jSONObjectOptJSONObject, "delay_ms", "exit_guard_timeout");
                break;
            case "disposeRewardResources":
                if (!jSONObjectOptJSONObject.optBoolean("preserve_exit_guard", false)) {
                    disposeExitGuard();
                }
                if (!jSONObjectOptJSONObject.optBoolean("preserve_callbacks", false) && !jSONObjectOptJSONObject.optBoolean("preserve_exit_guard", false)) {
                    cleanupTerminalSession();
                    break;
                } else {
                    scheduleCoreFact(jSONObjectOptJSONObject, "retention_ms", "destroy_timeout");
                    break;
                }
                break;
            case "awaitRewardClose":
                scheduleCoreFact(jSONObjectOptJSONObject, "delay_ms", "close_timeout");
                break;
            case "disposeRewardExitGuard":
                disposeExitGuard();
                break;
            case "rewardCallbackBatch":
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("commands");
                if (jSONArrayOptJSONArray != null) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        applyCallbackCommand(jSONArrayOptJSONArray.optJSONObject(i));
                    }
                    break;
                }
                break;
            case "onRewardVerify":
                applyRewardCommand(jSONObject);
                break;
            case "evaluateProviderClose":
                evaluateProviderClose();
                break;
            case "onAdClose":
                dispatchCloseEffects();
                final DirichletRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.interactionListener;
                if (rewardAdInteractionListener != null) {
                    deliverBusinessCallback(new Runnable() { // from class: com.tapsdk.tapad.group.ads.MediationRewardSession$$ExternalSyntheticLambda4
                        @Override // java.lang.Runnable
                        public final void run() {
                            rewardAdInteractionListener.onAdClose();
                        }
                    });
                }
                if (!jSONObjectOptJSONObject.optBoolean("preserve_exit_guard", false)) {
                    disposeExitGuard();
                    break;
                }
                break;
            case "disposeRewardSession":
                cleanupTerminalSession();
                break;
        }
    }

    private void applyRewardCommand(JSONObject jSONObject) {
        if (isCommand(jSONObject, "onRewardVerify")) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("payload");
            Object objOpt = jSONObjectOptJSONObject == null ? null : jSONObjectOptJSONObject.opt(TrackAction.SUCCESS);
            Object objOpt2 = jSONObjectOptJSONObject == null ? null : jSONObjectOptJSONObject.opt(IAction.BuyKey.CostAmount);
            Object objOpt3 = jSONObjectOptJSONObject == null ? null : jSONObjectOptJSONObject.opt(Common.System.NAME);
            Object objOpt4 = jSONObjectOptJSONObject == null ? null : jSONObjectOptJSONObject.opt(PluginConstants.KEY_ERROR_CODE);
            Object objOpt5 = jSONObjectOptJSONObject == null ? null : jSONObjectOptJSONObject.opt("message");
            Object objOpt6 = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.opt("reward_source") : null;
            Object objOpt7 = jSONObject.opt("submit_reward_verification");
            if ((objOpt instanceof Boolean) && (objOpt2 instanceof Number) && (objOpt3 instanceof String) && (objOpt4 instanceof Number) && (objOpt5 instanceof String) && (objOpt6 instanceof String)) {
                if (objOpt7 instanceof Boolean) {
                    long jLongValue = ((Number) objOpt2).longValue();
                    long jLongValue2 = ((Number) objOpt4).longValue();
                    if (jLongValue < -2147483648L || jLongValue > 2147483647L || jLongValue2 < -2147483648L) {
                        return;
                    }
                    if (jLongValue2 > 2147483647L) {
                        return;
                    }
                    final boolean zBooleanValue = ((Boolean) objOpt).booleanValue();
                    final int i = (int) jLongValue;
                    final String str = (String) objOpt3;
                    final int i2 = (int) jLongValue2;
                    final String str2 = (String) objOpt5;
                    effects().onRewardVerify(this, zBooleanValue, i, str, i2, str2, (String) objOpt6);
                    if (((Boolean) objOpt7).booleanValue()) {
                        MediationControlBridge.submitRewardVerification(getTrackId());
                    }
                    final DirichletRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.interactionListener;
                    if (rewardAdInteractionListener != null) {
                        deliverBusinessCallback(new Runnable() { // from class: com.tapsdk.tapad.group.ads.MediationRewardSession$$ExternalSyntheticLambda1
                            @Override // java.lang.Runnable
                            public final void run() {
                                rewardAdInteractionListener.onRewardVerify(zBooleanValue, i, str, i2, str2);
                            }
                        });
                    }
                }
            }
        }
    }

    private ProviderRewardLoadFacts buildRewardLoadFacts() {
        return new ProviderRewardLoadFacts(getRequestId(), getTrackId());
    }

    private JSONObject callbackFact(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("track_id", safe(getTrackId()));
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, safe(str));
            return jSONObject;
        } catch (Throwable th) {
            return jSONObject;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cleanupTerminalSession() {
        this.interactionListener = null;
        finishSessionDestroy();
    }

    private static void deliverBusinessCallback(Runnable runnable) {
        try {
            runnable.run();
        } catch (Throwable th) {
        }
    }

    private void disposeExitGuard() {
        ProviderExitGuardPresenter providerExitGuardPresenter = this.exitGuardPresenter;
        this.exitGuardPresenter = null;
        if (providerExitGuardPresenter != null) {
            providerExitGuardPresenter.dispose();
        }
    }

    private void evaluateProviderClose() {
        Runnable runnable = new Runnable() { // from class: com.tapsdk.tapad.group.ads.MediationRewardSession$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.resolveFinalClose();
            }
        };
        ProviderExitGuardPresenter providerExitGuardPresenter = this.exitGuardPresenter;
        if (providerExitGuardPresenter != null) {
            providerExitGuardPresenter.onProviderClosed(runnable);
        } else {
            runnable.run();
        }
    }

    private static boolean isCommand(JSONObject jSONObject, String str) {
        return (jSONObject == null || !str.equals(jSONObject.optString(Common.System.NAME, "")) || jSONObject.optJSONObject("payload") == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] normalizedRewardCreative() {
        return MediationRuntimeCoreBridge.normalizeProviderCreative("reward", resolveCreativeId(), requireNativeSession(), 0L);
    }

    private void onOriginalProviderShown() {
        ProviderExitGuardPresenter providerExitGuardPresenter = this.exitGuardPresenter;
        if (providerExitGuardPresenter != null) {
            providerExitGuardPresenter.onProviderShown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onProviderCloseOnMain() {
        if (this.hostedSession == null) {
            resolveFinalClose();
            return;
        }
        IoniaProviderTouchObserver.get().end(this);
        scheduleIoniaWindowEnd(IONIA_PROVIDER_CLOSE_GRACE_MS);
        resolveCallback(callbackFact("provider_close"), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AdapterNativeRewardSession requireNativeSession() {
        AdapterNativeRewardSession adapterNativeRewardSession = this.nativeSession;
        if (adapterNativeRewardSession != null) {
            return adapterNativeRewardSession;
        }
        throw new IllegalStateException("Reward session is not Core-hosted");
    }

    private void resolveCallback(JSONObject jSONObject, final Runnable runnable) {
        this.rewardHost.resolve(jSONObject, new MediationRuntimeCoreBridge.RewardCallbackCommandReceiver() { // from class: com.tapsdk.tapad.group.ads.MediationRewardSession.1
            @Override // com.tapsdk.tapad.internal.runtime.MediationRuntimeCoreBridge.RewardCallbackCommandReceiver
            public void onCommand(JSONObject jSONObject2) {
                try {
                    MediationRewardSession.this.applyCallbackCommand(jSONObject2);
                } finally {
                    Runnable runnable2 = runnable;
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }
            }

            @Override // com.tapsdk.tapad.internal.runtime.MediationRuntimeCoreBridge.RewardCallbackCommandReceiver
            public void onError(int i) {
                try {
                    MediationRewardSession.this.cleanupTerminalSession();
                } finally {
                    Runnable runnable2 = runnable;
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }
            }
        });
    }

    private String resolveCreativeId() {
        Object obj = getDirichletExtraInfo().get("track_id");
        String strSafe = obj instanceof String ? (String) obj : "";
        if (strSafe.isEmpty()) {
            strSafe = safe(getTrackId());
        }
        if (strSafe.isEmpty()) {
            strSafe = safe(getRequestId());
        }
        return strSafe.isEmpty() ? "reward-" + Integer.toHexString(System.identityHashCode(this)) : strSafe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resolveFinalClose() {
        resolveCallback(callbackFact(ILivePush.ClickType.CLOSE), null);
    }

    private void resolveSimpleCallback(String str, final String str2, final Runnable runnable) {
        this.rewardHost.resolve(callbackFact(str), new MediationRuntimeCoreBridge.RewardCallbackCommandReceiver() { // from class: com.tapsdk.tapad.group.ads.MediationRewardSession$$ExternalSyntheticLambda7
            @Override // com.tapsdk.tapad.internal.runtime.MediationRuntimeCoreBridge.RewardCallbackCommandReceiver
            public final void onCommand(JSONObject jSONObject) {
                this.f$0.m66lambda$resolveSimpleCallback$4$comtapsdktapadgroupadsMediationRewardSession(str2, runnable, jSONObject);
            }
        });
    }

    private static String safe(String str) {
        return str == null ? "" : str;
    }

    private void scheduleCoreFact(JSONObject jSONObject, String str, final String str2) {
        Object objOpt = jSONObject.opt(str);
        Object objOpt2 = jSONObject.opt("token");
        if ((objOpt instanceof Number) && (objOpt2 instanceof Number)) {
            long jLongValue = ((Number) objOpt).longValue();
            final long jLongValue2 = ((Number) objOpt2).longValue();
            if (jLongValue < 0 || jLongValue2 <= 0) {
                return;
            }
            this.rewardHost.postDelayed(new Runnable() { // from class: com.tapsdk.tapad.group.ads.MediationRewardSession$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m67lambda$scheduleCoreFact$1$comtapsdktapadgroupadsMediationRewardSession(str2, jLongValue2);
                }
            }, jLongValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: showOnMain, reason: merged with bridge method [inline-methods] */
    public void m68lambda$showRewardVideoAd$0$comtapsdktapadgroupadsMediationRewardSession(Activity activity) {
        if (isCandidateDestroyed() || !this.rewardHost.claimShow(this, activity)) {
            return;
        }
        JSONObject jSONObjectCallbackFact = callbackFact(TrackAction.START);
        try {
            jSONObjectCallbackFact.put("callback_contract", "reward_settlement_v1");
            jSONObjectCallbackFact.put("presentation", this.hostedSession != null ? "provider_hosted" : "core_hosted");
            resolveCallback(jSONObjectCallbackFact, null);
            ProviderRewardLoadFacts providerRewardLoadFactsBuildRewardLoadFacts = buildRewardLoadFacts();
            if (this.hostedSession != null) {
                this.exitGuardPresenter = this.rewardHost.prepareExitGuard(activity, providerRewardLoadFactsBuildRewardLoadFacts, this);
            }
            effects().spaceShow(this, activity);
            if (this.nativeSession != null) {
                this.providerPresenter = ProviderRewardPresenter.show(activity, this.coreSession, this, providerRewardLoadFactsBuildRewardLoadFacts);
            } else {
                effects().codebitShow(this, activity);
                this.hostedSession.show(activity);
            }
        } catch (Exception e) {
            cleanupTerminalSession();
        }
    }

    @Override // com.tapsdk.tapad.group.ads.AdapterAdCandidate
    public void dispatchDestroyOnMain(Runnable runnable) {
        this.rewardHost.runOnMain(runnable);
    }

    /* JADX INFO: renamed from: lambda$onClick$3$com-tapsdk-tapad-group-ads-MediationRewardSession, reason: not valid java name */
    /* synthetic */ void m64lambda$onClick$3$comtapsdktapadgroupadsMediationRewardSession(View view, JSONObject jSONObject) {
        if (isCandidateDestroyed()) {
            return;
        }
        if (isCommand(jSONObject, "recordIoniaClickMarker")) {
            markIoniaDeclaredClick(1);
            return;
        }
        if (isCommand(jSONObject, "onAdClick")) {
            super.onClick(view);
            final DirichletRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.interactionListener;
            if (rewardAdInteractionListener != null) {
                deliverBusinessCallback(new Runnable() { // from class: com.tapsdk.tapad.group.ads.MediationRewardSession$$ExternalSyntheticLambda9
                    @Override // java.lang.Runnable
                    public final void run() {
                        rewardAdInteractionListener.onAdClick();
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: lambda$onShow$2$com-tapsdk-tapad-group-ads-MediationRewardSession, reason: not valid java name */
    /* synthetic */ void m65lambda$onShow$2$comtapsdktapadgroupadsMediationRewardSession(View view) {
        super.onShow(view);
        onOriginalProviderShown();
        final DirichletRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.interactionListener;
        if (rewardAdInteractionListener != null) {
            deliverBusinessCallback(new Runnable() { // from class: com.tapsdk.tapad.group.ads.MediationRewardSession$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    rewardAdInteractionListener.onAdShow();
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$resolveSimpleCallback$4$com-tapsdk-tapad-group-ads-MediationRewardSession, reason: not valid java name */
    /* synthetic */ void m66lambda$resolveSimpleCallback$4$comtapsdktapadgroupadsMediationRewardSession(String str, Runnable runnable, JSONObject jSONObject) {
        if (isCandidateDestroyed() || !isCommand(jSONObject, str)) {
            return;
        }
        runnable.run();
    }

    /* JADX INFO: renamed from: lambda$scheduleCoreFact$1$com-tapsdk-tapad-group-ads-MediationRewardSession, reason: not valid java name */
    /* synthetic */ void m67lambda$scheduleCoreFact$1$comtapsdktapadgroupadsMediationRewardSession(String str, long j) {
        JSONObject jSONObjectCallbackFact = callbackFact(str);
        try {
            jSONObjectCallbackFact.put("token", j);
            resolveCallback(jSONObjectCallbackFact, null);
        } catch (Exception e) {
        }
    }

    @Override // com.tapsdk.tapad.group.ads.AdapterAdCandidate
    public void onBeforeSessionDestroy() {
        this.coreSession.clearProviderEventSink();
        disposeExitGuard();
        ProviderRewardPresenter providerRewardPresenter = this.providerPresenter;
        this.providerPresenter = null;
        if (providerRewardPresenter != null) {
            providerRewardPresenter.dispose();
        }
    }

    @Override // com.tapsdk.tapad.group.ads.AdapterAdCandidate, com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onClick(final View view) {
        ProviderExitGuardPresenter providerExitGuardPresenter = this.exitGuardPresenter;
        if (providerExitGuardPresenter != null) {
            providerExitGuardPresenter.onProviderClicked();
        }
        this.rewardHost.resolve(callbackFact("click"), new MediationRuntimeCoreBridge.RewardCallbackCommandReceiver() { // from class: com.tapsdk.tapad.group.ads.MediationRewardSession$$ExternalSyntheticLambda8
            @Override // com.tapsdk.tapad.internal.runtime.MediationRuntimeCoreBridge.RewardCallbackCommandReceiver
            public final void onCommand(JSONObject jSONObject) {
                this.f$0.m64lambda$onClick$3$comtapsdktapadgroupadsMediationRewardSession(view, jSONObject);
            }
        });
    }

    @Override // com.tapsdk.tapad.group.ads.AdapterAdCandidate, com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onClose() {
        this.rewardHost.runOnMain(new Runnable() { // from class: com.tapsdk.tapad.group.ads.MediationRewardSession$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.onProviderCloseOnMain();
            }
        });
    }

    @Override // com.tapsdk.tapad.group.ads.AdapterAdCandidate, com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onCreativeClick(View view) {
        onClick(view);
    }

    @Override // com.tapsdk.tapad.group.ads.ProviderExitGuardPresenter.OrderedHostEvents
    public void onExitGuardClosed() {
        resolveCallback(callbackFact("exit_guard_closed"), null);
    }

    @Override // com.tapsdk.tapad.internal.selfrender.ProviderRewardSession.HostEvents
    public void onPresentationStarted(Activity activity) {
        effects().codebitShow(this, activity);
    }

    @Override // com.tapsdk.tapad.internal.selfrender.ProviderRewardSession.HostEvents
    public void onRewardVerified(boolean z, int i, String str, int i2, String str2, String str3) {
        onRewardVerified(z, i, str, i2, str2, str3, null);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onRewardVerify(boolean z, int i, String str, int i2, String str2) {
        onRewardVerified(z, i, str, i2, str2, "");
    }

    @Override // com.tapsdk.tapad.group.ads.AdapterAdCandidate
    public void onSessionDestroyRequested() {
        resolveCallback(callbackFact("destroy"), null);
    }

    @Override // com.tapsdk.tapad.group.ads.AdapterAdCandidate, com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onShow(final View view) {
        if (this.hostedSession != null) {
            beginIoniaWindow();
        }
        resolveSimpleCallback("show", "onAdShow", new Runnable() { // from class: com.tapsdk.tapad.group.ads.MediationRewardSession$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m65lambda$onShow$2$comtapsdktapadgroupadsMediationRewardSession(view);
            }
        });
    }

    public void setRewardAdInteractionListener(DirichletRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.interactionListener = rewardAdInteractionListener;
    }

    public void showRewardVideoAd(final Activity activity) {
        this.rewardHost.runOnMain(new Runnable() { // from class: com.tapsdk.tapad.group.ads.MediationRewardSession$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m68lambda$showRewardVideoAd$0$comtapsdktapadgroupadsMediationRewardSession(activity);
            }
        });
    }

    @Override // com.tapsdk.tapad.group.ads.AdapterAdCandidate
    public boolean usesProviderFullscreenSurface() {
        return this.hostedSession != null;
    }

    public MediationRewardSession(AdapterRewardSession adapterRewardSession, RewardHost rewardHost) {
        AdapterAdEventSink adapterAdEventSink;
        super(adapterRewardSession);
        NativeCoreSession nativeCoreSession = new NativeCoreSession();
        this.coreSession = nativeCoreSession;
        this.rewardHost = rewardHost;
        AdapterHostedRewardSession adapterHostedRewardSession = adapterRewardSession instanceof AdapterHostedRewardSession ? (AdapterHostedRewardSession) adapterRewardSession : null;
        this.hostedSession = adapterHostedRewardSession;
        AdapterNativeRewardSession adapterNativeRewardSession = adapterRewardSession instanceof AdapterNativeRewardSession ? (AdapterNativeRewardSession) adapterRewardSession : null;
        this.nativeSession = adapterNativeRewardSession;
        if ((adapterHostedRewardSession == null) == (adapterNativeRewardSession == null)) {
            throw new IllegalArgumentException("Reward session must expose exactly one presentation capability");
        }
        AdapterRewardSession session = getSession();
        if (adapterNativeRewardSession == null) {
            adapterAdEventSink = nativeCoreSession;
            adapterAdEventSink = this;
        }
        adapterAdEventSink = nativeCoreSession;
        session.setEventSink(adapterAdEventSink);
    }

    @Override // com.tapsdk.tapad.group.ads.ProviderExitGuardPresenter.OrderedHostEvents
    public void onRewardVerified(boolean z, int i, String str, int i2, String str2, String str3, Runnable runnable) {
        try {
            resolveCallback(callbackFact("reward").put(TrackAction.SUCCESS, z).put(IAction.BuyKey.CostAmount, i).put(Common.System.NAME, safe(str)).put(PluginConstants.KEY_ERROR_CODE, i2).put("message", safe(str2)).put("reward_source", safe(str3)), runnable);
        } catch (Throwable th) {
            if (runnable != null) {
                this.rewardHost.runOnMain(runnable);
            }
        }
    }

    public final class NativeCoreSession extends NativeProviderEventRelay implements ProviderRewardSession {
        private AdapterNativeFullscreenBinding surfaceBinding;

        private NativeCoreSession() {
        }

        @Override // com.tapsdk.tapad.internal.selfrender.ProviderRewardSession
        public void bindReward(Activity activity, FrameLayout frameLayout, ViewGroup viewGroup, List<View> list, ProviderAttributionSlots providerAttributionSlots, ProviderEventSink providerEventSink) {
            bindProviderEventSink(providerEventSink);
            AdapterNativeFullscreenBinding adapterNativeFullscreenBinding = this.surfaceBinding;
            if (adapterNativeFullscreenBinding != null) {
                adapterNativeFullscreenBinding.release();
            }
            this.surfaceBinding = AdapterNativeFullscreenBinding.withDynamicAttributionSlots(frameLayout, viewGroup, list, providerAttributionSlots);
            MediationRewardSession.this.requireNativeSession().bind(activity, this.surfaceBinding);
        }

        @Override // com.tapsdk.tapad.group.ads.NativeProviderEventRelay
        public boolean canRelayProviderEvent() {
            return !MediationRewardSession.this.isProviderSessionReleased();
        }

        @Override // com.tapsdk.tapad.internal.selfrender.ProviderRewardSession
        public FrameLayout createRewardRoot(Activity activity) {
            return MediationRewardSession.this.requireNativeSession().createActivityRoot(activity);
        }

        @Override // com.tapsdk.tapad.internal.selfrender.ProviderRewardSession
        public byte[] normalizedRewardCreative() {
            return MediationRewardSession.this.normalizedRewardCreative();
        }

        @Override // com.tapsdk.tapad.group.ads.NativeProviderEventRelay
        public void onProviderViewAcquired(View view) {
            MediationRewardSession.this.onViewAcquired(view);
        }

        @Override // com.tapsdk.tapad.internal.selfrender.ProviderRewardSession
        public void releaseRewardProvider() {
            clearProviderEventSink();
            AdapterNativeFullscreenBinding adapterNativeFullscreenBinding = this.surfaceBinding;
            if (adapterNativeFullscreenBinding != null) {
                adapterNativeFullscreenBinding.release();
                this.surfaceBinding = null;
            }
            MediationRewardSession.this.getSession().setEventSink(null);
            MediationRewardSession.this.getSession().destroy();
        }

        @Override // com.tapsdk.tapad.internal.selfrender.ProviderRewardSession
        public void setRewardVideoMuted(boolean z) {
            AdapterNativeRewardSession adapterNativeRewardSessionRequireNativeSession = MediationRewardSession.this.requireNativeSession();
            if (adapterNativeRewardSessionRequireNativeSession.supportsVideoMuteControl()) {
                adapterNativeRewardSessionRequireNativeSession.setVideoMuted(z);
            }
        }

        @Override // com.tapsdk.tapad.internal.selfrender.ProviderRewardSession
        public boolean updateRewardCreativeViews(List<View> list) {
            return MediationRewardSession.this.requireNativeSession().updateFullscreenCreativeViews(list);
        }

        @Override // com.tapsdk.tapad.internal.selfrender.ProviderRewardSession
        public boolean updateRewardInteractionViews(List<View> list, List<View> list2, List<View> list3) {
            return MediationRewardSession.this.requireNativeSession().updateFullscreenInteractionViews(list, list2, list3);
        }

        @Override // com.tapsdk.tapad.internal.selfrender.ProviderRewardSession
        public void bindReward(Activity activity, FrameLayout frameLayout, ViewGroup viewGroup, ProviderInteractionViews providerInteractionViews, ProviderAttributionSlots providerAttributionSlots, ProviderEventSink providerEventSink) {
            bindProviderEventSink(providerEventSink);
            AdapterNativeFullscreenBinding adapterNativeFullscreenBinding = this.surfaceBinding;
            if (adapterNativeFullscreenBinding != null) {
                adapterNativeFullscreenBinding.release();
            }
            if (providerInteractionViews == null) {
                providerInteractionViews = new ProviderInteractionViews(null, null, null);
            }
            this.surfaceBinding = AdapterNativeFullscreenBinding.withDynamicAttributionSlots(frameLayout, viewGroup, providerInteractionViews.getClickViews(), providerInteractionViews.getCreativeViews(), providerInteractionViews.getDirectDownloadViews(), providerAttributionSlots);
            MediationRewardSession.this.requireNativeSession().bind(activity, this.surfaceBinding);
        }
    }
}
