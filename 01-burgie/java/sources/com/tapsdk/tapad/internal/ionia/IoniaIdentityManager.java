package com.tapsdk.tapad.internal.ionia;

import android.content.Context;
import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import com.bytedance.android.live.base.api.push.ILivePush;
import com.tapsdk.tapad.internal.AppContextHolder;
import com.tapsdk.tapad.internal.config.AdnPlatformStateStore;
import com.tapsdk.tapad.internal.oaid.OaidHelper;
import com.tapsdk.tapad.internal.platform.AndroidEnvironmentHost;
import com.tapsdk.tapad.internal.runtime.AndroidPrivacyPolicy;
import com.tapsdk.tapad.internal.runtime.DirichletRuntime;
import com.tapsdk.tapad.internal.runtime.WasmModule;
import com.tapsdk.tapad.internal.utils.AdnDeviceManager;
import com.tapsdk.tapad.internal.utils.AsyncExecutor;
import com.tapsdk.tapad.internal.utils.FinstallIdManager;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.UByte;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class IoniaIdentityManager {
    private static final long ACTIVE_SURFACE_OVERDUE_MS = 30000;
    private static final long ACTIVE_SURFACE_OVERDUE_RETRY_MS = 5000;
    private static final long ACTIVE_SURFACE_RETRY_MS = 1000;
    private static final long BEHAVIOR_ENRICH_DEBOUNCE_MS = 2000;
    public static final int CLICK_KIND_PROVIDER_DECLARED = 1;
    public static final int CLICK_KIND_PROVIDER_DECLARED_CREATIVE = 2;
    private static final int CMD_APPLY_SIGNAL_PROFILE = 24;
    private static final int CMD_CONFIRM_AD_PLAYBACK_WINDOW = 22;
    private static final int CMD_CONFIRM_SENSOR_WINDOWS = 145;
    private static final int CMD_ENRICH = 17;
    private static final int CMD_LAST_MOTION_WINDOW_IDS = 25;
    private static final int CMD_LAST_SENSOR_WINDOW_IDS = 19;
    private static final int CMD_LAST_SIGNAL_PROFILE_STATUS = 26;
    private static final int CMD_PENDING_BEHAVIOR_COUNT = 18;
    private static final int CMD_RECORD_AD_CLICK_MARKER = 28;
    private static final int CMD_RESOLVE = 16;
    private static final int CMD_RESTRICT_AD_PLAYBACK_WINDOW = 31;
    private static final int CMD_SESSION_INIT = 1;
    private static final int CMD_SET_DEVICE_TOKEN = 3;
    private static final int CMD_SET_EID = 2;
    private static final int CMD_SET_SIGNAL_MASK = 27;
    private static final int CMD_START_AD_PLAYBACK_WINDOW = 30;
    private static final int CMD_STOP_AD_PLAYBACK_WINDOW = 21;
    private static final int ENRICH_REASON_COLD_START = 1;
    private static final int ENRICH_REASON_GET_ADS = 2;
    private static final IoniaIdentityManager INSTANCE = new IoniaIdentityManager();
    private static final long IO_EXECUTOR_RETRY_MS = 1000;
    private static final int MAX_BASELINE_GET_ADS_ENRICH_PER_PROCESS = 10;
    private static final int MAX_BEHAVIOR_GET_ADS_ENRICH_PER_PROCESS = 200;
    private static final int MAX_ENRICH_RETRY = 2;
    private static final int MAX_RESOLVE_RETRY = 3;
    private static final long MAX_SECURITY_RESPONSE_BYTES = 16777216;
    private static final int MAX_SIGNAL_PROFILES_PER_PROCESS = 5;
    private static final long MODULE_LOAD_TIMEOUT_MS = 8000;
    private static final String SP_KEY_LAST_PROFILE_HASH = "last_profile_hash";
    private static final String TAG = "IoniaIdentity";
    private volatile IoniaIdentityConfig activeConfig;
    private volatile WasmModule activeModule;
    private volatile boolean adRequestObserved;
    private volatile Long appliedSignalMask;
    private int baselineGetAdsEnrichUploadedCount;
    private int behaviorGetAdsEnrichUploadedCount;
    private volatile boolean coldStartLoadAccepted;
    private String deferredBaselineCorrelationId;
    private String deferredBehaviorAdId;
    private String deferredBehaviorCorrelationId;
    private String deferredStartupBaselineCorrelationId;
    private String deferredStartupBehaviorAdId;
    private String deferredStartupBehaviorCorrelationId;
    private volatile String deviceToken;
    private volatile String eid;
    private long enrichTriggerGeneration;
    private boolean getAdsEnrichInFlight;
    private volatile boolean globalConfigReady;
    private volatile Call inFlightCall;
    private volatile String lastAppliedProfileBase64;
    private IoniaIdentityConfig pendingConfig;
    private String pendingEnrichAdId;
    private boolean pendingEnrichBehaviorPriority;
    private String pendingEnrichCorrelationId;
    private boolean pendingEnrichOverdueLogged;
    private long pendingEnrichSinceElapsedMs;
    private volatile byte[] pendingExtraData;
    private volatile String pendingSignalProfileBase64;
    private volatile boolean remotelyDisabled;
    private ScheduledFuture<?> scheduledEnrichTrigger;
    private int signalProfileAppliedCount;
    private volatile boolean started;
    private volatile boolean starting;
    private final Object lock = new Object();
    private final Object playbackWindowLock = new Object();
    private final Set<String> pendingPlaybackWindows = new LinkedHashSet();
    private final Map<String, Long> activePlaybackWindows = new LinkedHashMap();
    private final AtomicBoolean playbackMotionBridgeFailureLogged = new AtomicBoolean();
    private final ExecutorService playbackExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.tapsdk.tapad.internal.ionia.IoniaIdentityManager$$ExternalSyntheticLambda4
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return IoniaIdentityManager.lambda$new$0(runnable);
        }
    });
    private final ScheduledExecutorService enrichTriggerExecutor = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() { // from class: com.tapsdk.tapad.internal.ionia.IoniaIdentityManager$$ExternalSyntheticLambda5
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return IoniaIdentityManager.lambda$new$1(runnable);
        }
    });
    private final Object enrichTriggerLock = new Object();
    private final AtomicBoolean coldStartEnrichAttempted = new AtomicBoolean();
    private final AtomicBoolean coldStartEnrichScheduled = new AtomicBoolean();
    private final AtomicBoolean resolveAttempted = new AtomicBoolean();
    private final AtomicBoolean resolveScheduled = new AtomicBoolean();
    private final AtomicLong installedAppsPrivacyGeneration = new AtomicLong();
    private final Object getAdsLimitLock = new Object();
    private final Object signalProfileLock = new Object();

    public interface ExecFn {
        byte[] exec(int i, byte[] bArr);
    }

    public enum GetAdsEnrichLane {
        COLD_START,
        BASELINE,
        BEHAVIOR
    }

    public static final class LoadedSecurityModule {
        final WasmModule module;
        final long pendingActivationVersion;

        public LoadedSecurityModule(WasmModule wasmModule, long j) {
            this.module = wasmModule;
            this.pendingActivationVersion = j;
        }

        public static LoadedSecurityModule of(WasmModule wasmModule, long j) {
            if (wasmModule == null) {
                return null;
            }
            return new LoadedSecurityModule(wasmModule, j);
        }
    }

    public enum SignalProfileStatus {
        OK(0),
        DECODE_ERROR(1),
        SCHEMA_MISMATCH(2),
        TTL_EXPIRED(3),
        AGE_CAP_EXCEEDED(4),
        TOO_MANY_PROBES(5),
        SIGNATURE_INVALID(6),
        OUTPUT_TOO_SMALL(7),
        REPLAY_CAP_EXCEEDED(8),
        PROBE_ISSUE(9),
        CLOCK_UNAVAILABLE(10),
        UNKNOWN(-1);

        final int code;

        SignalProfileStatus(int i) {
            this.code = i;
        }

        public static SignalProfileStatus fromCode(int i) {
            for (SignalProfileStatus signalProfileStatus : values()) {
                if (signalProfileStatus.code == i) {
                    return signalProfileStatus;
                }
            }
            return UNKNOWN;
        }
    }

    private IoniaIdentityManager() {
        AndroidPrivacyPolicy.addListener(new Runnable() { // from class: com.tapsdk.tapad.internal.ionia.IoniaIdentityManager$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.onPrivacyPolicyChanged();
            }
        });
    }

    private WasmModule activeModule() {
        WasmModule wasmModule = this.activeModule;
        if (wasmModule == null || wasmModule.isUnloaded()) {
            return null;
        }
        return wasmModule;
    }

    private boolean allowsBehaviorCollection() {
        return behaviorCollectionMask() != 0;
    }

    private boolean allowsInstalledApps(IoniaIdentityConfig ioniaIdentityConfig) {
        return (this.remotelyDisabled || ioniaIdentityConfig == null || !ioniaIdentityConfig.enabled || (ioniaIdentityConfig.signalMask & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) == 0 || !AndroidPrivacyPolicy.allowsInstalledApps()) ? false : true;
    }

    private boolean allowsMotionCollection() {
        return (behaviorCollectionMask() & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) != 0;
    }

    private void applyDisabled() {
        if (!this.started || this.remotelyDisabled) {
            return;
        }
        this.remotelyDisabled = true;
        this.installedAppsPrivacyGeneration.incrementAndGet();
        executePlaybackTask("disabled", new IoniaIdentityManager$$ExternalSyntheticLambda16(this));
    }

    private void applyPendingConfig(IoniaIdentityConfig ioniaIdentityConfig) {
        if (!ioniaIdentityConfig.enabled) {
            applyDisabled();
            return;
        }
        this.remotelyDisabled = false;
        Context context = AppContextHolder.get();
        if (context != null) {
            this.activeConfig = enrichConfig(context, ioniaIdentityConfig);
            this.installedAppsPrivacyGeneration.incrementAndGet();
        }
        executePlaybackTask("pending-privacy", new IoniaIdentityManager$$ExternalSyntheticLambda16(this));
        scheduleResolve();
        scheduleColdStartEnrich();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyPrivacyPolicy() {
        IoniaIdentityConfig ioniaIdentityConfig = this.activeConfig;
        restrictPlaybackWindows(behaviorCollectionMask());
        if (ioniaIdentityConfig != null) {
            refreshActiveSignalMask(this.remotelyDisabled ? 0L : ioniaIdentityConfig.signalMask);
        }
    }

    private void applySignalProfileSync(String str) {
        WasmModule wasmModule;
        if (!this.globalConfigReady || !this.adRequestObserved || this.starting || this.remotelyDisabled || str == null) {
            return;
        }
        String strTrim = str.trim();
        if (strTrim.isEmpty() || (wasmModule = this.activeModule) == null) {
            return;
        }
        synchronized (this.signalProfileLock) {
            if (strTrim.equals(this.lastAppliedProfileBase64)) {
                return;
            }
            if (this.signalProfileAppliedCount >= 5) {
                return;
            }
            try {
                try {
                    byte[] bArrCallSecurityExecSync = wasmModule.callSecurityExecSync(24, Base64.decode(strTrim, 2));
                    if (bArrCallSecurityExecSync == null || bArrCallSecurityExecSync.length == 0) {
                        Objects.toString(queryLastSignalProfileStatus(wasmModule));
                        return;
                    }
                    queryLastSignalProfileStatus(wasmModule);
                    SignalProfileStatus signalProfileStatus = SignalProfileStatus.OK;
                    synchronized (this.signalProfileLock) {
                        if (strTrim.equals(this.lastAppliedProfileBase64)) {
                            return;
                        }
                        if (this.signalProfileAppliedCount >= 5) {
                            return;
                        }
                        this.lastAppliedProfileBase64 = strTrim;
                        this.signalProfileAppliedCount++;
                        this.pendingExtraData = bArrCallSecurityExecSync;
                    }
                } catch (Throwable th) {
                    th.getMessage();
                }
            } catch (IllegalArgumentException e) {
                e.getMessage();
            }
        }
    }

    private void attemptColdStartEnrich(Context context) {
        WasmModule wasmModuleActiveModule;
        if (coldStartReady()) {
            IoniaIdentityConfig ioniaIdentityConfig = this.activeConfig;
            if (context == null || ioniaIdentityConfig == null || !ioniaIdentityConfig.enrichEnabled || TextUtils.isEmpty(this.eid) || (wasmModuleActiveModule = activeModule()) == null) {
                return;
            }
            IoniaIdentityConfig ioniaIdentityConfigEnrichConfig = enrichConfig(context, ioniaIdentityConfig);
            if (this.coldStartEnrichAttempted.compareAndSet(false, true)) {
                String strDoEnrich = doEnrich(wasmModuleActiveModule, ioniaIdentityConfigEnrichConfig);
                if (TextUtils.isEmpty(strDoEnrich)) {
                    return;
                }
                this.deviceToken = strDoEnrich;
                wasmModuleActiveModule.callSecurityExecSync(3, strDoEnrich.getBytes(StandardCharsets.UTF_8));
                confirmDeliveredWindows(wasmModuleActiveModule);
            }
        }
    }

    private WasmModule awaitModule(CountDownLatch countDownLatch, AtomicReference<WasmModule> atomicReference, AtomicReference<Throwable> atomicReference2, String str) {
        try {
            if (!countDownLatch.await(MODULE_LOAD_TIMEOUT_MS, TimeUnit.MILLISECONDS)) {
                return null;
            }
            Throwable th = atomicReference2.get();
            if (th != null) {
                th.getMessage();
            }
            return atomicReference.get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }
    }

    private long behaviorCollectionMask() {
        IoniaIdentityConfig ioniaIdentityConfig = this.activeConfig;
        if (this.globalConfigReady && this.adRequestObserved && !this.remotelyDisabled && ioniaIdentityConfig != null && ioniaIdentityConfig.enabled) {
            return IoniaIdentityConfig.collectionMask(ioniaIdentityConfig.signalMask, true) & 786432;
        }
        return 0L;
    }

    private static byte[] clickMarkerPayload(String str, int i) {
        return new Codec.Writer().writeStr(str).writeU32(i).finish();
    }

    public static byte[] clickMarkerPayloadForTest(String str, int i) {
        return clickMarkerPayload(str, i);
    }

    private boolean coldStartPrerequisitesReady() {
        IoniaIdentityConfig ioniaIdentityConfig = this.activeConfig;
        return (!this.globalConfigReady || !this.started || this.starting || this.remotelyDisabled || this.coldStartEnrichAttempted.get() || ioniaIdentityConfig == null || !ioniaIdentityConfig.enabled || !ioniaIdentityConfig.enrichEnabled || this.eid == null || this.eid.length() == 0 || this.activeModule == null) ? false : true;
    }

    private boolean coldStartReady() {
        return this.coldStartLoadAccepted && coldStartPrerequisitesReady();
    }

    private void confirmDeliveredWindows(WasmModule wasmModule) {
        Objects.requireNonNull(wasmModule);
        confirmDeliveredWindows(new IoniaIdentityManager$$ExternalSyntheticLambda0(wasmModule));
    }

    public static void confirmDeliveredWindowsForTest(ExecFn execFn) {
        confirmDeliveredWindows(execFn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchColdStartEnrich() {
        if (!coldStartReady()) {
            releaseColdStartSchedule();
        } else {
            if (AsyncExecutor.tryExecuteIO(new Runnable() { // from class: com.tapsdk.tapad.internal.ionia.IoniaIdentityManager$$ExternalSyntheticLambda28
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.runScheduledColdStartEnrich();
                }
            })) {
                return;
            }
            retryScheduledColdStartEnrich();
        }
    }

    private String doEnrich(WasmModule wasmModule, IoniaIdentityConfig ioniaIdentityConfig) {
        return doEnrichWithReason(wasmModule, ioniaIdentityConfig, 1, "", "");
    }

    private String doEnrichWithReason(WasmModule wasmModule, IoniaIdentityConfig ioniaIdentityConfig, int i, String str, String str2) {
        OkHttpClient okHttpClientNewHttpClient = newHttpClient();
        for (int i2 = 0; i2 < 2; i2++) {
            try {
                if (this.globalConfigReady && this.adRequestObserved && !this.starting && !this.remotelyDisabled) {
                    Objects.requireNonNull(wasmModule);
                    try {
                        if (refreshActiveSignalMask(new IoniaIdentityManager$$ExternalSyntheticLambda0(wasmModule), ioniaIdentityConfig.signalMask)) {
                            Request requestBuildSecurityHttpRequestSync = wasmModule.buildSecurityHttpRequestSync(17, withCurrentCachedOaid(ioniaIdentityConfig).toEnrichInput(i, i2 + 1, SystemClock.elapsedRealtime(), peekPendingExtraData(), str, System.currentTimeMillis(), str2), ioniaIdentityConfig.baseUrl, ioniaIdentityConfig.enrichPath, ioniaIdentityConfig.mediaId);
                            if (requestBuildSecurityHttpRequestSync != null) {
                                String strSendRequest = sendRequest(okHttpClientNewHttpClient, requestBuildSecurityHttpRequestSync, "enrich");
                                if (!TextUtils.isEmpty(strSendRequest)) {
                                    String strOptString = new JSONObject(strSendRequest).optString("device_token", "");
                                    if (!TextUtils.isEmpty(strOptString)) {
                                        consumePendingExtraData();
                                        return strOptString;
                                    }
                                    continue;
                                }
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        th.getMessage();
                    }
                }
                return "";
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return "";
    }

    private String doGetAdsEnrich(WasmModule wasmModule, IoniaIdentityConfig ioniaIdentityConfig, String str, String str2) {
        return doEnrichWithReason(wasmModule, ioniaIdentityConfig, 2, str, str2);
    }

    private String doResolve(WasmModule wasmModule, IoniaIdentityConfig ioniaIdentityConfig) {
        OkHttpClient okHttpClientNewHttpClient = newHttpClient();
        for (int i = 0; i < 3; i++) {
            try {
                if (this.globalConfigReady && this.adRequestObserved && !this.remotelyDisabled) {
                    Objects.requireNonNull(wasmModule);
                    if (refreshActiveSignalMask(new IoniaIdentityManager$$ExternalSyntheticLambda0(wasmModule), ioniaIdentityConfig.signalMask, false)) {
                        Request requestBuildSecurityHttpRequestSync = wasmModule.buildSecurityHttpRequestSync(16, withCurrentCachedOaid(ioniaIdentityConfig).toResolveJson().getBytes(StandardCharsets.UTF_8), ioniaIdentityConfig.baseUrl, ioniaIdentityConfig.resolvePath, ioniaIdentityConfig.mediaId);
                        if (requestBuildSecurityHttpRequestSync != null) {
                            String strSendRequest = sendRequest(okHttpClientNewHttpClient, requestBuildSecurityHttpRequestSync, "resolve");
                            if (!TextUtils.isEmpty(strSendRequest)) {
                                String strOptString = new JSONObject(strSendRequest).optString("eid", "");
                                if (!TextUtils.isEmpty(strOptString)) {
                                    return strOptString;
                                }
                            }
                        }
                    }
                }
                return "";
            } catch (Throwable th) {
                th.getMessage();
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drainPendingEnrich, reason: merged with bridge method [inline-methods] */
    public void m174lambda$schedulePendingEnrichLocked$13$comtapsdktapadinternalioniaIoniaIdentityManager(long j) {
        synchronized (this.enrichTriggerLock) {
            if (j == this.enrichTriggerGeneration && !TextUtils.isEmpty(this.pendingEnrichCorrelationId)) {
                this.scheduledEnrichTrigger = null;
                if (hasLiveRenderedSurface() && !this.pendingEnrichBehaviorPriority) {
                    long jMax = Math.max(0L, SystemClock.elapsedRealtime() - this.pendingEnrichSinceElapsedMs);
                    if (jMax >= ACTIVE_SURFACE_OVERDUE_MS && !this.pendingEnrichOverdueLogged) {
                        this.pendingEnrichOverdueLogged = true;
                    }
                    schedulePendingEnrichLocked(jMax >= ACTIVE_SURFACE_OVERDUE_MS ? 5000L : 1000L);
                    return;
                }
                String str = this.pendingEnrichCorrelationId;
                String str2 = this.pendingEnrichAdId;
                boolean z = this.pendingEnrichBehaviorPriority;
                this.pendingEnrichCorrelationId = null;
                this.pendingEnrichAdId = null;
                this.pendingEnrichBehaviorPriority = false;
                this.pendingEnrichSinceElapsedMs = 0L;
                this.pendingEnrichOverdueLogged = false;
                executeGetAdsEnrich(str, str2, z);
            }
        }
    }

    private void enrichAfterBehaviorWindow(String str, String str2) {
        scheduleGetAdsEnrich(str, str2, true, 0L);
    }

    private IoniaIdentityConfig enrichConfig(Context context, IoniaIdentityConfig ioniaIdentityConfig) {
        String oaid;
        String str;
        String finstallId;
        String adnDid = "";
        try {
            oaid = OaidHelper.getInstance().getOaid();
            try {
                str = !TextUtils.isEmpty(oaid) ? "ok" : "";
            } catch (Throwable th) {
                str = "";
            }
        } catch (Throwable th2) {
            oaid = "";
        }
        try {
            finstallId = FinstallIdManager.getInstance(context).getFinstallId();
        } catch (Throwable th3) {
            finstallId = "";
        }
        try {
            adnDid = AdnDeviceManager.getInstance(context).getAdnDid();
        } catch (Throwable th4) {
        }
        return ioniaIdentityConfig.withDeviceIds(oaid, str, finstallId, adnDid);
    }

    private void executeGetAdsEnrich(final String str, final String str2, final boolean z) {
        final IoniaIdentityConfig ioniaIdentityConfig;
        synchronized (this.lock) {
            if (this.starting) {
                if (z) {
                    this.deferredStartupBehaviorCorrelationId = str;
                    this.deferredStartupBehaviorAdId = str2;
                } else {
                    this.deferredStartupBaselineCorrelationId = str;
                }
                return;
            }
            if (this.remotelyDisabled || (ioniaIdentityConfig = this.activeConfig) == null || !ioniaIdentityConfig.enrichEnabled || TextUtils.isEmpty(this.eid) || AsyncExecutor.tryExecuteIO(new Runnable() { // from class: com.tapsdk.tapad.internal.ionia.IoniaIdentityManager$$ExternalSyntheticLambda13
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m161lambda$executeGetAdsEnrich$14$comtapsdktapadinternalioniaIoniaIdentityManager(z, str, str2, ioniaIdentityConfig);
                }
            })) {
                return;
            }
            scheduleGetAdsEnrich(str, str2, z, 1000L);
        }
    }

    private void executePlaybackTask(final String str, final Runnable runnable) {
        try {
            this.playbackExecutor.execute(new Runnable() { // from class: com.tapsdk.tapad.internal.ionia.IoniaIdentityManager$$ExternalSyntheticLambda25
                @Override // java.lang.Runnable
                public final void run() {
                    IoniaIdentityManager.lambda$executePlaybackTask$12(runnable, str);
                }
            });
        } catch (RejectedExecutionException e) {
            e.getMessage();
        }
    }

    private void finishGetAdsEnrich(GetAdsEnrichLane getAdsEnrichLane, boolean z) {
        int i;
        int i2;
        String str;
        String str2;
        String str3;
        synchronized (this.getAdsLimitLock) {
            if (z) {
                this.getAdsEnrichInFlight = false;
                str = this.deferredBehaviorCorrelationId;
                str2 = this.deferredBehaviorAdId;
                this.deferredBehaviorCorrelationId = null;
                this.deferredBehaviorAdId = null;
                str3 = this.deferredBaselineCorrelationId;
                this.deferredBaselineCorrelationId = null;
            } else {
                if (getAdsEnrichLane == GetAdsEnrichLane.BEHAVIOR && (i2 = this.behaviorGetAdsEnrichUploadedCount) > 0) {
                    this.behaviorGetAdsEnrichUploadedCount = i2 - 1;
                } else if (getAdsEnrichLane == GetAdsEnrichLane.BASELINE && (i = this.baselineGetAdsEnrichUploadedCount) > 0) {
                    this.baselineGetAdsEnrichUploadedCount = i - 1;
                }
                this.getAdsEnrichInFlight = false;
                str = this.deferredBehaviorCorrelationId;
                str2 = this.deferredBehaviorAdId;
                this.deferredBehaviorCorrelationId = null;
                this.deferredBehaviorAdId = null;
                str3 = this.deferredBaselineCorrelationId;
                this.deferredBaselineCorrelationId = null;
            }
            throw th;
        }
        scheduleColdStartEnrich();
        if (!TextUtils.isEmpty(str)) {
            enrichAfterBehaviorWindow(str, str2);
        } else {
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            scheduleGetAdsEnrich(str3, false);
        }
    }

    private void finishStartupAttempt(boolean z) {
        IoniaIdentityConfig ioniaIdentityConfig;
        String str;
        String str2;
        String str3;
        synchronized (this.lock) {
            this.started = z;
            this.starting = false;
            ioniaIdentityConfig = this.pendingConfig;
            this.pendingConfig = null;
            str = this.deferredStartupBaselineCorrelationId;
            str2 = this.deferredStartupBehaviorCorrelationId;
            str3 = this.deferredStartupBehaviorAdId;
            this.deferredStartupBaselineCorrelationId = null;
            this.deferredStartupBehaviorCorrelationId = null;
            this.deferredStartupBehaviorAdId = null;
        }
        if (ioniaIdentityConfig != null) {
            applyPendingConfig(ioniaIdentityConfig);
        }
        scheduleResolve();
        scheduleColdStartEnrich();
        if (!TextUtils.isEmpty(str2)) {
            scheduleGetAdsEnrich(str2, str3, true, 0L);
        } else {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            scheduleGetAdsEnrich(str, false);
        }
    }

    public static IoniaIdentityManager getInstance() {
        return INSTANCE;
    }

    private static boolean hasLiveRenderedSurface() {
        try {
            return DirichletRuntime.getInstance().surfaceSessions().hasLiveRenderedSurface();
        } catch (Throwable th) {
            return false;
        }
    }

    private GetAdsEnrichLane inspectAndReserveGetAdsEnrich(WasmModule wasmModule, boolean z, String str, String str2) {
        synchronized (this.getAdsLimitLock) {
            if (!this.getAdsEnrichInFlight) {
                Objects.requireNonNull(wasmModule);
                return tryReserveGetAdsEnrich(z || pendingBehaviorWindowCount(new IoniaIdentityManager$$ExternalSyntheticLambda0(wasmModule)) > 0, str, str2);
            }
            if (z && !TextUtils.isEmpty(str)) {
                this.deferredBehaviorCorrelationId = str;
                this.deferredBehaviorAdId = str2;
            } else if (!z) {
                this.deferredBaselineCorrelationId = str;
            }
            return null;
        }
    }

    static /* synthetic */ void lambda$awaitPlaybackForTest$24() {
    }

    static /* synthetic */ boolean lambda$collectInstalledApps$17() {
        return true;
    }

    static /* synthetic */ boolean lambda$collectInstalledAppsNow$20() {
        return true;
    }

    static /* synthetic */ void lambda$executePlaybackTask$12(Runnable runnable, String str) {
        try {
            runnable.run();
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    static /* synthetic */ Thread lambda$new$0(Runnable runnable) {
        return new Thread(runnable, "TapAd-IoniaPlayback");
    }

    static /* synthetic */ Thread lambda$new$1(Runnable runnable) {
        Thread thread = new Thread(runnable, "TapAd-IoniaEnrichTrigger");
        thread.setDaemon(true);
        return thread;
    }

    private LoadedSecurityModule loadModuleBlocking(DirichletRuntime dirichletRuntime, IoniaIdentityConfig ioniaIdentityConfig, IoniaSecurityStore ioniaSecurityStore, IoniaSecurityStore.Slot slot, DirichletRuntime.IoniaSecurityPackage ioniaSecurityPackage) {
        WasmModule module = dirichletRuntime.getModule(ioniaIdentityConfig.moduleName);
        if (module != null) {
            return LoadedSecurityModule.of(module, 0L);
        }
        if (slot == null || ioniaSecurityPackage == null) {
            if (ioniaSecurityStore.rollbackFloor() > 0) {
                return null;
            }
            return LoadedSecurityModule.of(loadModuleFromAsset(dirichletRuntime, ioniaIdentityConfig.assetPath, ioniaIdentityConfig.moduleName), 0L);
        }
        WasmModule wasmModuleLoadModuleFromBytes = loadModuleFromBytes(dirichletRuntime, ioniaSecurityPackage.wasm, ioniaIdentityConfig.moduleName, "ionia-update/" + slot.version);
        if (wasmModuleLoadModuleFromBytes != null) {
            return LoadedSecurityModule.of(wasmModuleLoadModuleFromBytes, slot.candidate ? slot.version : 0L);
        }
        long j = slot.version;
        if (!slot.candidate) {
            return null;
        }
        ioniaSecurityStore.rejectCandidate(j);
        IoniaSecurityStore.Slot slotCurrentForLoad = ioniaSecurityStore.currentForLoad();
        if (slotCurrentForLoad == null) {
            if (ioniaSecurityStore.rollbackFloor() > 0 || !dirichletRuntime.reinitializeSecurityHost(null)) {
                return null;
            }
            return LoadedSecurityModule.of(loadModuleFromAsset(dirichletRuntime, ioniaIdentityConfig.assetPath, ioniaIdentityConfig.moduleName), 0L);
        }
        DirichletRuntime.IoniaSecurityPackage ioniaSecurityPackageExtractIoniaSecurityPackage = dirichletRuntime.extractIoniaSecurityPackage(slotCurrentForLoad.bytes, ioniaSecurityStore.rollbackFloor());
        if (ioniaSecurityPackageExtractIoniaSecurityPackage != null && ioniaSecurityPackageExtractIoniaSecurityPackage.version == slotCurrentForLoad.version && dirichletRuntime.reinitializeSecurityHost(ioniaSecurityPackageExtractIoniaSecurityPackage.dex)) {
            return LoadedSecurityModule.of(loadModuleFromBytes(dirichletRuntime, ioniaSecurityPackageExtractIoniaSecurityPackage.wasm, ioniaIdentityConfig.moduleName, "ionia-current/" + slotCurrentForLoad.version), 0L);
        }
        return null;
    }

    private WasmModule loadModuleFromAsset(DirichletRuntime dirichletRuntime, String str, String str2) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final AtomicReference<WasmModule> atomicReference = new AtomicReference<>();
        final AtomicReference<Throwable> atomicReference2 = new AtomicReference<>();
        dirichletRuntime.loadSecurityModuleFromAsset(str, str2, new DirichletRuntime.ModuleLoadCallback() { // from class: com.tapsdk.tapad.internal.ionia.IoniaIdentityManager.1
            @Override // com.tapsdk.tapad.internal.runtime.DirichletRuntime.ModuleLoadCallback
            public void onError(Exception exc) {
                atomicReference2.set(exc);
                countDownLatch.countDown();
            }

            @Override // com.tapsdk.tapad.internal.runtime.DirichletRuntime.ModuleLoadCallback
            public void onSuccess(WasmModule wasmModule) {
                atomicReference.set(wasmModule);
                countDownLatch.countDown();
            }
        });
        return awaitModule(countDownLatch, atomicReference, atomicReference2, str);
    }

    private WasmModule loadModuleFromBytes(DirichletRuntime dirichletRuntime, byte[] bArr, String str, String str2) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final AtomicReference<WasmModule> atomicReference = new AtomicReference<>();
        final AtomicReference<Throwable> atomicReference2 = new AtomicReference<>();
        dirichletRuntime.loadSecurityModule(bArr, str, str2, new DirichletRuntime.ModuleLoadCallback() { // from class: com.tapsdk.tapad.internal.ionia.IoniaIdentityManager.2
            @Override // com.tapsdk.tapad.internal.runtime.DirichletRuntime.ModuleLoadCallback
            public void onError(Exception exc) {
                atomicReference2.set(exc);
                countDownLatch.countDown();
            }

            @Override // com.tapsdk.tapad.internal.runtime.DirichletRuntime.ModuleLoadCallback
            public void onSuccess(WasmModule wasmModule) {
                atomicReference.set(wasmModule);
                countDownLatch.countDown();
            }
        });
        return awaitModule(countDownLatch, atomicReference, atomicReference2, str2);
    }

    public static OkHttpClient newHttpClient() {
        OkHttpClient.Builder builderFollowSslRedirects = new OkHttpClient.Builder().retryOnConnectionFailure(false).followRedirects(false).followSslRedirects(false);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return builderFollowSslRedirects.connectTimeout(12L, timeUnit).readTimeout(25L, timeUnit).writeTimeout(25L, timeUnit).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPrivacyPolicyChanged() {
        this.installedAppsPrivacyGeneration.incrementAndGet();
        synchronized (this.playbackWindowLock) {
            if (this.activeModule == null && this.pendingPlaybackWindows.isEmpty() && this.activePlaybackWindows.isEmpty()) {
                return;
            }
            final boolean z = !AndroidPrivacyPolicy.allowsSensor();
            executePlaybackTask("privacy", new Runnable() { // from class: com.tapsdk.tapad.internal.ionia.IoniaIdentityManager$$ExternalSyntheticLambda27
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m166lambda$onPrivacyPolicyChanged$2$comtapsdktapadinternalioniaIoniaIdentityManager(z);
                }
            });
        }
    }

    private static int pendingBehaviorWindowCount(ExecFn execFn) {
        try {
            byte[] bArrExec = execFn.exec(18, new byte[0]);
            if (bArrExec != null && bArrExec.length != 0) {
                return Integer.parseInt(new String(bArrExec, StandardCharsets.UTF_8).trim());
            }
            return -1;
        } catch (Throwable th) {
            return -1;
        }
    }

    public static int pendingBehaviorWindowCountForTest(ExecFn execFn) {
        return pendingBehaviorWindowCount(execFn);
    }

    private static byte[] playbackWindowPayload(String str) {
        return (str == null || str.length() == 0) ? new byte[0] : str.getBytes(StandardCharsets.UTF_8);
    }

    public static byte[] playbackWindowPayloadForTest(String str) {
        return playbackWindowPayload(str);
    }

    private void publishActiveModuleAndReplayWindows(final WasmModule wasmModule) {
        synchronized (this.playbackWindowLock) {
            try {
                this.activeModule = wasmModule;
                if (!allowsBehaviorCollection()) {
                    revokePlaybackWindows();
                    return;
                }
                Iterator<String> it = this.pendingPlaybackWindows.iterator();
                while (it.hasNext()) {
                    try {
                        startPlaybackWindow(new ExecFn() { // from class: com.tapsdk.tapad.internal.ionia.IoniaIdentityManager$$ExternalSyntheticLambda1
                            @Override // com.tapsdk.tapad.internal.ionia.IoniaIdentityManager.ExecFn
                            public final byte[] exec(int i, byte[] bArr) {
                                return this.f$0.m168lambda$publishActiveModuleAndReplayWindows$23$comtapsdktapadinternalioniaIoniaIdentityManager(wasmModule, i, bArr);
                            }
                        }, it.next());
                    } catch (Throwable th) {
                        th.getMessage();
                    }
                }
                this.pendingPlaybackWindows.clear();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private SignalProfileStatus queryLastSignalProfileStatus(WasmModule wasmModule) {
        try {
            byte[] bArrCallSecurityExecSync = wasmModule.callSecurityExecSync(26, new byte[0]);
            if (bArrCallSecurityExecSync != null && bArrCallSecurityExecSync.length != 0) {
                return SignalProfileStatus.fromCode(bArrCallSecurityExecSync[0] & UByte.MAX_VALUE);
            }
            return SignalProfileStatus.UNKNOWN;
        } catch (Throwable th) {
            return SignalProfileStatus.UNKNOWN;
        }
    }

    public static String readPlaintextResponse(ResponseBody responseBody) throws IOException {
        if (responseBody == null) {
            return "";
        }
        if (responseBody.contentLength() > MAX_SECURITY_RESPONSE_BYTES) {
            throw new IOException("Ionia response exceeds size limit");
        }
        BufferedSource bufferedSourceSource = responseBody.source();
        if (bufferedSourceSource.request(16777217L)) {
            throw new IOException("Ionia response exceeds size limit");
        }
        return new String(bufferedSourceSource.readByteArray(), StandardCharsets.UTF_8);
    }

    private void refreshActiveSignalMask(long j) {
        WasmModule wasmModule = this.activeModule;
        if (wasmModule == null) {
            return;
        }
        refreshActiveSignalMask(new IoniaIdentityManager$$ExternalSyntheticLambda0(wasmModule), j);
    }

    private void refreshFromPlatformState(Context context, final long j) {
        final Context applicationContext = context != null ? context.getApplicationContext() : null;
        if (applicationContext == null) {
            return;
        }
        AdnPlatformStateStore adnPlatformStateStore = AdnPlatformStateStore.get();
        adnPlatformStateStore.init(applicationContext);
        final IoniaIdentityConfig ioniaIdentityConfigFromPlatformState = IoniaIdentityConfig.fromPlatformState(j, adnPlatformStateStore.ioniaState());
        IoniaSecurityUpdater.get(applicationContext).maybeUpdate(IoniaSecurityUpdate.fromPlatformState(adnPlatformStateStore.ioniaState()));
        synchronized (this.lock) {
            if (this.starting) {
                this.pendingConfig = ioniaIdentityConfigFromPlatformState;
                return;
            }
            boolean z = true;
            if (!ioniaIdentityConfigFromPlatformState.enabled || !this.started) {
                if (ioniaIdentityConfigFromPlatformState.enabled) {
                    this.starting = true;
                }
                z = false;
            }
            if (!ioniaIdentityConfigFromPlatformState.enabled) {
                applyDisabled();
                return;
            }
            this.remotelyDisabled = false;
            if (!z) {
                if (AsyncExecutor.tryExecuteIO(new Runnable() { // from class: com.tapsdk.tapad.internal.ionia.IoniaIdentityManager$$ExternalSyntheticLambda17
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m171lambda$refreshFromPlatformState$3$comtapsdktapadinternalioniaIoniaIdentityManager(applicationContext, ioniaIdentityConfigFromPlatformState);
                    }
                })) {
                    return;
                }
                finishStartupAttempt(false);
                this.enrichTriggerExecutor.schedule(new Runnable() { // from class: com.tapsdk.tapad.internal.ionia.IoniaIdentityManager$$ExternalSyntheticLambda18
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m172lambda$refreshFromPlatformState$4$comtapsdktapadinternalioniaIoniaIdentityManager(applicationContext, j);
                    }
                }, 1000L, TimeUnit.MILLISECONDS);
                return;
            }
            this.activeConfig = enrichConfig(applicationContext, ioniaIdentityConfigFromPlatformState);
            this.installedAppsPrivacyGeneration.incrementAndGet();
            executePlaybackTask("signal-mask", new IoniaIdentityManager$$ExternalSyntheticLambda16(this));
            scheduleResolve();
            scheduleColdStartEnrich();
        }
    }

    private void releaseColdStartSchedule() {
        this.coldStartEnrichScheduled.set(false);
        scheduleColdStartEnrich();
    }

    private boolean resolveReady() {
        IoniaIdentityConfig ioniaIdentityConfig = this.activeConfig;
        if (this.globalConfigReady && this.adRequestObserved && this.started && !this.starting && !this.remotelyDisabled && !this.resolveAttempted.get() && ioniaIdentityConfig != null && ioniaIdentityConfig.enabled && ioniaIdentityConfig.resolveEnabled) {
            return (this.eid == null || this.eid.length() == 0) && activeModule() != null;
        }
        return false;
    }

    private void restrictPlaybackWindows(long j) {
        synchronized (this.playbackWindowLock) {
            if (j == 0) {
                revokePlaybackWindows();
                return;
            }
            WasmModule wasmModuleActiveModule = activeModule();
            if (wasmModuleActiveModule == null) {
                return;
            }
            for (Map.Entry entry : new LinkedHashMap(this.activePlaybackWindows).entrySet()) {
                final long jLongValue = ((Long) entry.getValue()).longValue() & j;
                if (jLongValue != ((Long) entry.getValue()).longValue()) {
                    if (jLongValue == 0) {
                        try {
                            wasmModuleActiveModule.callSecurityExecSync(21, playbackWindowPayload((String) entry.getKey()));
                            this.activePlaybackWindows.remove(entry.getKey());
                        } catch (Throwable th) {
                            th.getMessage();
                        }
                    } else {
                        byte[] bArrCallGuardedSecurityExecSync = wasmModuleActiveModule.callGuardedSecurityExecSync(31, new Codec.Writer().writeU32(1).writeU64(jLongValue).writeStr((String) entry.getKey()).finish(), new WasmModule.SecurityExecPermission() { // from class: com.tapsdk.tapad.internal.ionia.IoniaIdentityManager$$ExternalSyntheticLambda8
                            @Override // com.tapsdk.tapad.internal.runtime.WasmModule.SecurityExecPermission
                            public final boolean isAllowed() {
                                return this.f$0.m173lambda$restrictPlaybackWindows$8$comtapsdktapadinternalioniaIoniaIdentityManager(jLongValue);
                            }
                        });
                        if (bArrCallGuardedSecurityExecSync == null || bArrCallGuardedSecurityExecSync.length == 0) {
                            wasmModuleActiveModule.callSecurityExecSync(21, playbackWindowPayload((String) entry.getKey()));
                            this.activePlaybackWindows.remove(entry.getKey());
                        } else {
                            this.activePlaybackWindows.put((String) entry.getKey(), Long.valueOf(jLongValue));
                        }
                    }
                }
            }
        }
    }

    private void retryScheduledColdStartEnrich() {
        this.enrichTriggerExecutor.schedule(new Runnable() { // from class: com.tapsdk.tapad.internal.ionia.IoniaIdentityManager$$ExternalSyntheticLambda29
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.dispatchColdStartEnrich();
            }
        }, 1000L, TimeUnit.MILLISECONDS);
    }

    private void revokePlaybackWindows() {
        synchronized (this.playbackWindowLock) {
            WasmModule wasmModuleActiveModule = activeModule();
            revokePlaybackWindows(wasmModuleActiveModule == null ? null : new IoniaIdentityManager$$ExternalSyntheticLambda0(wasmModuleActiveModule));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runScheduledColdStartEnrich() {
        if (!coldStartReady()) {
            releaseColdStartSchedule();
            return;
        }
        if (AppContextHolder.get() == null) {
            this.coldStartEnrichScheduled.set(false);
            return;
        }
        if (hasLiveRenderedSurface()) {
            retryScheduledColdStartEnrich();
            return;
        }
        synchronized (this.getAdsLimitLock) {
            if (this.getAdsEnrichInFlight) {
                retryScheduledColdStartEnrich();
                return;
            }
            this.getAdsEnrichInFlight = true;
            try {
                applySignalProfileSync(this.pendingSignalProfileBase64);
                attemptColdStartEnrich(AppContextHolder.get());
                this.coldStartEnrichScheduled.set(false);
                finishGetAdsEnrich(GetAdsEnrichLane.COLD_START, true);
            } catch (Throwable th) {
                try {
                    th.getMessage();
                } finally {
                    this.coldStartEnrichScheduled.set(false);
                    finishGetAdsEnrich(GetAdsEnrichLane.COLD_START, true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Bottom block not found for handler: all -> 0x006e */
    /* JADX WARN: Code duplicated, block: B:41:0x0077 A[DONT_GENERATE] */
    /* JADX INFO: renamed from: runScheduledResolve, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m175lambda$scheduleResolve$15$comtapsdktapadinternalioniaIoniaIdentityManager(android.content.Context r7) {
        /*
            r6 = this;
            r0 = 0
            r1 = 1
            java.lang.Object r2 = r6.lock     // Catch: java.lang.Throwable -> L70
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L70
            boolean r3 = r6.resolveReady()     // Catch: java.lang.Throwable -> L68
            if (r3 != 0) goto L15
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L68
            java.util.concurrent.atomic.AtomicBoolean r7 = r6.resolveScheduled
            r7.set(r0)
            r6.scheduleResolve()
            return
        L15:
            r6.starting = r1     // Catch: java.lang.Throwable -> L68
            java.util.concurrent.atomic.AtomicBoolean r3 = r6.resolveAttempted     // Catch: java.lang.Throwable -> L65
            r3.set(r1)     // Catch: java.lang.Throwable -> L65
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L65
            com.tapsdk.tapad.internal.runtime.WasmModule r2 = r6.activeModule()     // Catch: java.lang.Throwable -> L62
            if (r2 != 0) goto L30
            r6.finishStartupAttempt(r1)
            java.util.concurrent.atomic.AtomicBoolean r7 = r6.resolveScheduled
            r7.set(r0)
            r6.scheduleResolve()
            return
        L30:
            com.tapsdk.tapad.internal.ionia.IoniaIdentityConfig r3 = r6.activeConfig     // Catch: java.lang.Throwable -> L62
            com.tapsdk.tapad.internal.ionia.IoniaIdentityConfig r3 = r6.enrichConfig(r7, r3)     // Catch: java.lang.Throwable -> L62
            java.lang.String r3 = r6.doResolve(r2, r3)     // Catch: java.lang.Throwable -> L62
            if (r3 == 0) goto L55
            int r4 = r3.length()     // Catch: java.lang.Throwable -> L62
            if (r4 == 0) goto L55
            r4 = 2
            java.nio.charset.Charset r5 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.lang.Throwable -> L62
            byte[] r5 = r3.getBytes(r5)     // Catch: java.lang.Throwable -> L62
            r2.callSecurityExecSync(r4, r5)     // Catch: java.lang.Throwable -> L62
            com.tapsdk.tapad.internal.utils.AdnDeviceManager r7 = com.tapsdk.tapad.internal.utils.AdnDeviceManager.getInstance(r7)     // Catch: java.lang.Throwable -> L62
            r7.saveEid(r3)     // Catch: java.lang.Throwable -> L62
            r6.eid = r3     // Catch: java.lang.Throwable -> L62
        L55:
            r6.finishStartupAttempt(r1)
            java.util.concurrent.atomic.AtomicBoolean r7 = r6.resolveScheduled
            r7.set(r0)
            r6.scheduleResolve()
            return
        L62:
            r7 = move-exception
            r3 = r1
            goto L72
        L65:
            r7 = move-exception
            r3 = r1
            goto L6a
        L68:
            r7 = move-exception
            r3 = r0
        L6a:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L6e
            throw r7     // Catch: java.lang.Throwable -> L6c
        L6c:
            r7 = move-exception
            goto L72
        L6e:
            r7 = move-exception
            goto L6a
        L70:
            r7 = move-exception
            r3 = r0
        L72:
            r7.getMessage()     // Catch: java.lang.Throwable -> L83
            if (r3 == 0) goto L7a
            r6.finishStartupAttempt(r1)
        L7a:
            java.util.concurrent.atomic.AtomicBoolean r7 = r6.resolveScheduled
            r7.set(r0)
            r6.scheduleResolve()
            return
        L83:
            r7 = move-exception
            if (r3 == 0) goto L89
            r6.finishStartupAttempt(r1)
        L89:
            java.util.concurrent.atomic.AtomicBoolean r1 = r6.resolveScheduled
            r1.set(r0)
            r6.scheduleResolve()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapsdk.tapad.internal.ionia.IoniaIdentityManager.m175lambda$scheduleResolve$15$comtapsdktapadinternalioniaIoniaIdentityManager(android.content.Context):void");
    }

    private void scheduleColdStartEnrich() {
        if (coldStartReady() && this.coldStartEnrichScheduled.compareAndSet(false, true)) {
            dispatchColdStartEnrich();
        }
    }

    private void scheduleGetAdsEnrich(String str, boolean z) {
        scheduleGetAdsEnrich(str, "", z, 0L);
    }

    private void schedulePendingEnrichLocked(long j) {
        ScheduledFuture<?> scheduledFuture = this.scheduledEnrichTrigger;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        final long j2 = this.enrichTriggerGeneration + 1;
        this.enrichTriggerGeneration = j2;
        this.scheduledEnrichTrigger = this.enrichTriggerExecutor.schedule(new Runnable() { // from class: com.tapsdk.tapad.internal.ionia.IoniaIdentityManager$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m174lambda$schedulePendingEnrichLocked$13$comtapsdktapadinternalioniaIoniaIdentityManager(j2);
            }
        }, Math.max(0L, j), TimeUnit.MILLISECONDS);
    }

    private void scheduleResolve() {
        final Context context = AppContextHolder.get();
        if (context == null || !resolveReady() || !this.resolveScheduled.compareAndSet(false, true) || AsyncExecutor.tryExecuteIO(new Runnable() { // from class: com.tapsdk.tapad.internal.ionia.IoniaIdentityManager$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m175lambda$scheduleResolve$15$comtapsdktapadinternalioniaIoniaIdentityManager(context);
            }
        })) {
            return;
        }
        this.enrichTriggerExecutor.schedule(new Runnable() { // from class: com.tapsdk.tapad.internal.ionia.IoniaIdentityManager$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m176lambda$scheduleResolve$16$comtapsdktapadinternalioniaIoniaIdentityManager();
            }
        }, 1000L, TimeUnit.MILLISECONDS);
    }

    private String sendRequest(OkHttpClient okHttpClient, Request request, String str) {
        Call callNewCall = okHttpClient.newCall(request);
        this.inFlightCall = callNewCall;
        if (this.remotelyDisabled) {
            callNewCall.cancel();
        }
        try {
            Response responseExecute = callNewCall.execute();
            try {
                if (responseExecute.isSuccessful()) {
                    String plaintextResponse = readPlaintextResponse(responseExecute.body());
                    responseExecute.close();
                    if (this.inFlightCall == callNewCall) {
                        this.inFlightCall = null;
                    }
                    return plaintextResponse;
                }
                responseExecute.code();
                responseExecute.close();
                if (this.inFlightCall == callNewCall) {
                    this.inFlightCall = null;
                }
                return "";
            } catch (Throwable th) {
                if (responseExecute != null) {
                    try {
                        responseExecute.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            if (this.inFlightCall == callNewCall) {
                this.inFlightCall = null;
            }
            throw th3;
        }
    }

    private static boolean shouldSampleMotionAction(int i) {
        return i == 0 || i == 1 || i == 3 || i == 5 || i == 6;
    }

    public static boolean shouldSampleMotionActionForTest(int i) {
        return shouldSampleMotionAction(i);
    }

    private static byte[] signalMaskPayload(long j) {
        return ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(j).array();
    }

    public static byte[] signalMaskPayloadForTest(long j) {
        return signalMaskPayload(j);
    }

    /* JADX WARN: Code duplicated, block: B:74:0x0119  */
    private boolean startInternal(Context context, IoniaIdentityConfig ioniaIdentityConfig) {
        DirichletRuntime.IoniaSecurityPackage ioniaSecurityPackageExtractIoniaSecurityPackage;
        IoniaSecurityStore.Slot slot;
        DirichletRuntime.IoniaSecurityPackage ioniaSecurityPackage;
        LoadedSecurityModule loadedSecurityModuleLoadModuleBlocking;
        byte[] bArrCallSecurityExecSync;
        long j;
        DirichletRuntime dirichletRuntime = DirichletRuntime.getInstance();
        IoniaSecurityStore ioniaSecurityStore = new IoniaSecurityStore(context);
        IoniaSecurityStore.Slot slotSelectForLoad = ioniaSecurityStore.selectForLoad();
        if (slotSelectForLoad != null) {
            ioniaSecurityPackageExtractIoniaSecurityPackage = dirichletRuntime.extractIoniaSecurityPackage(slotSelectForLoad.bytes, ioniaSecurityStore.rollbackFloor());
            if ((ioniaSecurityPackageExtractIoniaSecurityPackage == null || ioniaSecurityPackageExtractIoniaSecurityPackage.version != slotSelectForLoad.version) && slotSelectForLoad.candidate) {
                ioniaSecurityStore.rejectCandidate(slotSelectForLoad.version);
                slotSelectForLoad = ioniaSecurityStore.currentForLoad();
                ioniaSecurityPackageExtractIoniaSecurityPackage = slotSelectForLoad == null ? null : dirichletRuntime.extractIoniaSecurityPackage(slotSelectForLoad.bytes, ioniaSecurityStore.rollbackFloor());
            }
            if (slotSelectForLoad != null && (ioniaSecurityPackageExtractIoniaSecurityPackage == null || ioniaSecurityPackageExtractIoniaSecurityPackage.version != slotSelectForLoad.version)) {
                return false;
            }
        } else {
            ioniaSecurityPackageExtractIoniaSecurityPackage = null;
        }
        if (ioniaSecurityPackageExtractIoniaSecurityPackage != null) {
            if (!dirichletRuntime.initRuntimeOnly(context, ioniaSecurityPackageExtractIoniaSecurityPackage.dex)) {
                if (slotSelectForLoad != null && slotSelectForLoad.candidate) {
                    ioniaSecurityStore.rejectCandidate(slotSelectForLoad.version);
                    IoniaSecurityStore.Slot slotCurrentForLoad = ioniaSecurityStore.currentForLoad();
                    DirichletRuntime.IoniaSecurityPackage ioniaSecurityPackageExtractIoniaSecurityPackage2 = slotCurrentForLoad == null ? null : dirichletRuntime.extractIoniaSecurityPackage(slotCurrentForLoad.bytes, ioniaSecurityStore.rollbackFloor());
                    if (ioniaSecurityPackageExtractIoniaSecurityPackage2 == null || ioniaSecurityPackageExtractIoniaSecurityPackage2.version != slotCurrentForLoad.version) {
                        if (ioniaSecurityStore.rollbackFloor() != 0 || !dirichletRuntime.reinitializeSecurityHost(null)) {
                            return false;
                        }
                        slot = null;
                        ioniaSecurityPackage = null;
                    } else {
                        if (!dirichletRuntime.reinitializeSecurityHost(ioniaSecurityPackageExtractIoniaSecurityPackage2.dex)) {
                            return false;
                        }
                        slot = slotCurrentForLoad;
                        ioniaSecurityPackage = ioniaSecurityPackageExtractIoniaSecurityPackage2;
                    }
                }
                return false;
            }
            if (dirichletRuntime.isInitialized() || !dirichletRuntime.isSecurityHostInitialized() || (loadedSecurityModuleLoadModuleBlocking = loadModuleBlocking(dirichletRuntime, ioniaIdentityConfig, ioniaSecurityStore, slot, ioniaSecurityPackage)) == null) {
                return false;
            }
            WasmModule wasmModule = loadedSecurityModuleLoadModuleBlocking.module;
            this.activeConfig = ioniaIdentityConfig;
            this.installedAppsPrivacyGeneration.incrementAndGet();
            bArrCallSecurityExecSync = wasmModule.callSecurityExecSync(1, ioniaIdentityConfig.toInitBytes());
            this.appliedSignalMask = null;
            if (bArrCallSecurityExecSync != null || bArrCallSecurityExecSync.length == 0) {
                j = loadedSecurityModuleLoadModuleBlocking.pendingActivationVersion;
                if (j > 0) {
                    ioniaSecurityStore.rejectCandidate(j);
                }
                return false;
            }
            long j2 = loadedSecurityModuleLoadModuleBlocking.pendingActivationVersion;
            if (j2 > 0) {
                ioniaSecurityStore.markActivated(j2);
            }
            publishActiveModuleAndReplayWindows(wasmModule);
            applySignalProfile(AdnPlatformStateStore.get().frameworkProfile());
            String eid = AdnDeviceManager.getInstance(context).getEid();
            if (!TextUtils.isEmpty(eid)) {
                this.eid = eid;
                wasmModule.callSecurityExecSync(2, eid.getBytes(StandardCharsets.UTF_8));
            }
            return true;
        }
        if (ioniaSecurityStore.rollbackFloor() > 0) {
            return false;
        }
        dirichletRuntime.initRuntimeOnly(context);
        slot = slotSelectForLoad;
        ioniaSecurityPackage = ioniaSecurityPackageExtractIoniaSecurityPackage;
        if (dirichletRuntime.isInitialized()) {
            return false;
        }
        WasmModule wasmModule2 = loadedSecurityModuleLoadModuleBlocking.module;
        this.activeConfig = ioniaIdentityConfig;
        this.installedAppsPrivacyGeneration.incrementAndGet();
        bArrCallSecurityExecSync = wasmModule2.callSecurityExecSync(1, ioniaIdentityConfig.toInitBytes());
        this.appliedSignalMask = null;
        if (bArrCallSecurityExecSync != null) {
        }
        j = loadedSecurityModuleLoadModuleBlocking.pendingActivationVersion;
        if (j > 0) {
            ioniaSecurityStore.rejectCandidate(j);
        }
        return false;
    }

    private void startPlaybackWindow(ExecFn execFn, String str) {
        byte[] bArrFinish;
        byte[] bArrExec;
        if (!allowsBehaviorCollection() || (bArrExec = execFn.exec(30, (bArrFinish = new Codec.Writer().writeU32(1).writeU64(behaviorCollectionMask()).writeStr(str).finish()))) == null || bArrExec.length == 0) {
            return;
        }
        long jLongValue = ByteBuffer.wrap(bArrFinish).order(ByteOrder.LITTLE_ENDIAN).getLong(4);
        Long l = this.activePlaybackWindows.get(str);
        Map<String, Long> map = this.activePlaybackWindows;
        if (l != null) {
            jLongValue &= l.longValue();
        }
        map.put(str, Long.valueOf(jLongValue));
    }

    private GetAdsEnrichLane tryReserveGetAdsEnrich(boolean z, String str, String str2) {
        synchronized (this.getAdsLimitLock) {
            if (this.getAdsEnrichInFlight) {
                if (z && !TextUtils.isEmpty(str)) {
                    this.deferredBehaviorCorrelationId = str;
                    this.deferredBehaviorAdId = str2;
                }
                return null;
            }
            if (z) {
                int i = this.behaviorGetAdsEnrichUploadedCount;
                if (i >= 200) {
                    return null;
                }
                this.behaviorGetAdsEnrichUploadedCount = i + 1;
                this.getAdsEnrichInFlight = true;
                return GetAdsEnrichLane.BEHAVIOR;
            }
            int i2 = this.baselineGetAdsEnrichUploadedCount;
            if (i2 >= 10) {
                return null;
            }
            this.baselineGetAdsEnrichUploadedCount = i2 + 1;
            this.getAdsEnrichInFlight = true;
            return GetAdsEnrichLane.BASELINE;
        }
    }

    private IoniaIdentityConfig withCurrentCachedOaid(IoniaIdentityConfig ioniaIdentityConfig) {
        String oaid = OaidHelper.getInstance().getOaid();
        return ioniaIdentityConfig.withDeviceIds(oaid, (oaid == null || oaid.isEmpty()) ? "" : "ok", ioniaIdentityConfig.installId, ioniaIdentityConfig.adnId);
    }

    public IoniaIdentityConfig activeConfigForTest() {
        return this.activeConfig;
    }

    public int activePlaybackWindowCountForTest() {
        int size;
        synchronized (this.playbackWindowLock) {
            size = this.activePlaybackWindows.size();
        }
        return size;
    }

    public Long appliedSignalMaskForTest() {
        return this.appliedSignalMask;
    }

    public void applySignalProfile(String str) {
        if (str == null || str.trim().isEmpty()) {
            return;
        }
        this.pendingSignalProfileBase64 = str.trim();
    }

    public void awaitPlaybackForTest() throws ExecutionException, InterruptedException, TimeoutException {
        this.playbackExecutor.submit(new Runnable() { // from class: com.tapsdk.tapad.internal.ionia.IoniaIdentityManager$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                IoniaIdentityManager.lambda$awaitPlaybackForTest$24();
            }
        }).get(5L, TimeUnit.SECONDS);
    }

    public void collectInstalledApps(IoniaInstalledApps.Callback callback) {
        collectInstalledApps(new WasmModule.SecurityExecPermission() { // from class: com.tapsdk.tapad.internal.ionia.IoniaIdentityManager$$ExternalSyntheticLambda19
            @Override // com.tapsdk.tapad.internal.runtime.WasmModule.SecurityExecPermission
            public final boolean isAllowed() {
                return IoniaIdentityManager.lambda$collectInstalledApps$17();
            }
        }, callback);
    }

    public IoniaInstalledApps.Result collectInstalledAppsNow(long j) {
        return collectInstalledAppsNow(j, new WasmModule.SecurityExecPermission() { // from class: com.tapsdk.tapad.internal.ionia.IoniaIdentityManager$$ExternalSyntheticLambda14
            @Override // com.tapsdk.tapad.internal.runtime.WasmModule.SecurityExecPermission
            public final boolean isAllowed() {
                return IoniaIdentityManager.lambda$collectInstalledAppsNow$20();
            }
        });
    }

    public byte[] consumePendingExtraData() {
        byte[] bArr;
        synchronized (this.signalProfileLock) {
            bArr = this.pendingExtraData;
            this.pendingExtraData = null;
        }
        return bArr;
    }

    public void enrichAfterGetAds(String str) {
        scheduleGetAdsEnrich(str, false);
    }

    public void finishBaselineGetAdsEnrichForTest(boolean z) {
        finishGetAdsEnrich(GetAdsEnrichLane.BASELINE, z);
    }

    public void finishBehaviorGetAdsEnrichForTest(boolean z) {
        finishGetAdsEnrich(GetAdsEnrichLane.BEHAVIOR, z);
    }

    public String getEid(Context context) {
        if (!TextUtils.isEmpty(this.eid)) {
            return this.eid;
        }
        if (context == null) {
            return "";
        }
        String eid = AdnDeviceManager.getInstance(context.getApplicationContext()).getEid();
        this.eid = eid;
        return eid;
    }

    public long installedAppsAccessVersion() {
        long j = this.installedAppsPrivacyGeneration.get();
        if (this.globalConfigReady && this.adRequestObserved && !this.starting && this.activeModule != null && allowsInstalledApps(this.activeConfig) && j == this.installedAppsPrivacyGeneration.get()) {
            return j + 1;
        }
        return 0L;
    }

    public boolean isProviderClickMarkerEnabled() {
        IoniaIdentityConfig ioniaIdentityConfig;
        return isProviderSensorWindowEnabled() && (ioniaIdentityConfig = this.activeConfig) != null && ioniaIdentityConfig.providerClickMarkerEnabled;
    }

    public boolean isProviderSensorWindowEnabled() {
        IoniaIdentityConfig ioniaIdentityConfig;
        return this.started && allowsBehaviorCollection() && (ioniaIdentityConfig = this.activeConfig) != null && ioniaIdentityConfig.enabled && ioniaIdentityConfig.providerSensorWindowEnabled;
    }

    public boolean isProviderTouchObservationEnabled() {
        IoniaIdentityConfig ioniaIdentityConfig;
        return this.started && allowsBehaviorCollection() && (ioniaIdentityConfig = this.activeConfig) != null && ioniaIdentityConfig.enabled && allowsMotionCollection() && ioniaIdentityConfig.providerSensorWindowEnabled && ioniaIdentityConfig.providerTouchEnabled;
    }

    /* JADX INFO: renamed from: lambda$collectInstalledApps$18$com-tapsdk-tapad-internal-ionia-IoniaIdentityManager, reason: not valid java name */
    /* synthetic */ void m158lambda$collectInstalledApps$18$comtapsdktapadinternalioniaIoniaIdentityManager(IoniaInstalledApps.Callback callback, WasmModule.SecurityExecPermission securityExecPermission, long j, IoniaInstalledApps.Result result) {
        if (!securityExecPermission.isAllowed() || j != this.installedAppsPrivacyGeneration.get() || !allowsInstalledApps(this.activeConfig)) {
            result = IoniaInstalledApps.empty(IoniaInstalledApps.Status.DENIED);
        }
        callback.onResult(result);
    }

    /* JADX INFO: renamed from: lambda$collectInstalledApps$19$com-tapsdk-tapad-internal-ionia-IoniaIdentityManager, reason: not valid java name */
    /* synthetic */ void m159lambda$collectInstalledApps$19$comtapsdktapadinternalioniaIoniaIdentityManager(final long j, final WasmModule.SecurityExecPermission securityExecPermission, final IoniaInstalledApps.Callback callback) {
        final IoniaInstalledApps.Result resultCollectInstalledAppsNow = collectInstalledAppsNow(j, securityExecPermission);
        Runnable runnable = new Runnable() { // from class: com.tapsdk.tapad.internal.ionia.IoniaIdentityManager$$ExternalSyntheticLambda20
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m158lambda$collectInstalledApps$18$comtapsdktapadinternalioniaIoniaIdentityManager(callback, securityExecPermission, j, resultCollectInstalledAppsNow);
            }
        };
        if (AsyncExecutor.tryExecuteIO(runnable)) {
            return;
        }
        runnable.run();
    }

    /* JADX INFO: renamed from: lambda$collectInstalledAppsNow$21$com-tapsdk-tapad-internal-ionia-IoniaIdentityManager, reason: not valid java name */
    /* synthetic */ boolean m160lambda$collectInstalledAppsNow$21$comtapsdktapadinternalioniaIoniaIdentityManager(WasmModule.SecurityExecPermission securityExecPermission, long j, IoniaIdentityConfig ioniaIdentityConfig) {
        return securityExecPermission.isAllowed() && j == this.installedAppsPrivacyGeneration.get() && ioniaIdentityConfig == this.activeConfig && allowsInstalledApps(ioniaIdentityConfig) && this.globalConfigReady && this.adRequestObserved && !this.starting;
    }

    /* JADX INFO: renamed from: lambda$executeGetAdsEnrich$14$com-tapsdk-tapad-internal-ionia-IoniaIdentityManager, reason: not valid java name */
    /* synthetic */ void m161lambda$executeGetAdsEnrich$14$comtapsdktapadinternalioniaIoniaIdentityManager(boolean z, String str, String str2, IoniaIdentityConfig ioniaIdentityConfig) {
        boolean z2 = false;
        try {
            if (hasLiveRenderedSurface() && !z) {
                scheduleGetAdsEnrich(str, str2, z, 0L);
                return;
            }
            WasmModule wasmModuleActiveModule = activeModule();
            if (wasmModuleActiveModule == null) {
                return;
            }
            GetAdsEnrichLane getAdsEnrichLaneInspectAndReserveGetAdsEnrich = inspectAndReserveGetAdsEnrich(wasmModuleActiveModule, z, str, str2);
            if (getAdsEnrichLaneInspectAndReserveGetAdsEnrich == null) {
                if (getAdsEnrichLaneInspectAndReserveGetAdsEnrich != null) {
                    finishGetAdsEnrich(getAdsEnrichLaneInspectAndReserveGetAdsEnrich, false);
                    return;
                }
                return;
            }
            Context context = AppContextHolder.get();
            if (context == null) {
                finishGetAdsEnrich(getAdsEnrichLaneInspectAndReserveGetAdsEnrich, false);
                return;
            }
            IoniaIdentityConfig ioniaIdentityConfigEnrichConfig = enrichConfig(context, ioniaIdentityConfig);
            applySignalProfileSync(this.pendingSignalProfileBase64);
            attemptColdStartEnrich(context);
            String strDoGetAdsEnrich = doGetAdsEnrich(wasmModuleActiveModule, ioniaIdentityConfigEnrichConfig, str, str2);
            if (!TextUtils.isEmpty(strDoGetAdsEnrich)) {
                this.deviceToken = strDoGetAdsEnrich;
                wasmModuleActiveModule.callSecurityExecSync(3, strDoGetAdsEnrich.getBytes(StandardCharsets.UTF_8));
                confirmDeliveredWindows(wasmModuleActiveModule);
                z2 = true;
            }
            finishGetAdsEnrich(getAdsEnrichLaneInspectAndReserveGetAdsEnrich, z2);
        } catch (Throwable th) {
            try {
                th.getMessage();
            } finally {
                if (0 != 0) {
                    finishGetAdsEnrich(null, false);
                }
            }
        }
    }

    /* JADX INFO: renamed from: lambda$onAdPlaybackShow$5$com-tapsdk-tapad-internal-ionia-IoniaIdentityManager, reason: not valid java name */
    /* synthetic */ boolean m163lambda$onAdPlaybackShow$5$comtapsdktapadinternalioniaIoniaIdentityManager(byte[] bArr) {
        return allowsBehaviorCollection() && new Codec.Reader(bArr).readU32() == 1 && ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getLong(4) == behaviorCollectionMask();
    }

    /* JADX INFO: renamed from: lambda$onAdPlaybackShow$6$com-tapsdk-tapad-internal-ionia-IoniaIdentityManager, reason: not valid java name */
    /* synthetic */ byte[] m164lambda$onAdPlaybackShow$6$comtapsdktapadinternalioniaIoniaIdentityManager(WasmModule wasmModule, int i, final byte[] bArr) {
        return wasmModule.callGuardedSecurityExecSync(i, bArr, new WasmModule.SecurityExecPermission() { // from class: com.tapsdk.tapad.internal.ionia.IoniaIdentityManager$$ExternalSyntheticLambda26
            @Override // com.tapsdk.tapad.internal.runtime.WasmModule.SecurityExecPermission
            public final boolean isAllowed() {
                return this.f$0.m163lambda$onAdPlaybackShow$5$comtapsdktapadinternalioniaIoniaIdentityManager(bArr);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onPrivacyPolicyChanged$2$com-tapsdk-tapad-internal-ionia-IoniaIdentityManager, reason: not valid java name */
    /* synthetic */ void m166lambda$onPrivacyPolicyChanged$2$comtapsdktapadinternalioniaIoniaIdentityManager(boolean z) {
        if (z) {
            restrictPlaybackWindows(behaviorCollectionMask() & (-262145));
        }
        applyPrivacyPolicy();
    }

    /* JADX INFO: renamed from: lambda$publishActiveModuleAndReplayWindows$22$com-tapsdk-tapad-internal-ionia-IoniaIdentityManager, reason: not valid java name */
    /* synthetic */ boolean m167lambda$publishActiveModuleAndReplayWindows$22$comtapsdktapadinternalioniaIoniaIdentityManager(byte[] bArr) {
        return allowsBehaviorCollection() && ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getLong(4) == behaviorCollectionMask();
    }

    /* JADX INFO: renamed from: lambda$publishActiveModuleAndReplayWindows$23$com-tapsdk-tapad-internal-ionia-IoniaIdentityManager, reason: not valid java name */
    /* synthetic */ byte[] m168lambda$publishActiveModuleAndReplayWindows$23$comtapsdktapadinternalioniaIoniaIdentityManager(WasmModule wasmModule, int i, final byte[] bArr) {
        return wasmModule.callGuardedSecurityExecSync(i, bArr, new WasmModule.SecurityExecPermission() { // from class: com.tapsdk.tapad.internal.ionia.IoniaIdentityManager$$ExternalSyntheticLambda22
            @Override // com.tapsdk.tapad.internal.runtime.WasmModule.SecurityExecPermission
            public final boolean isAllowed() {
                return this.f$0.m167lambda$publishActiveModuleAndReplayWindows$22$comtapsdktapadinternalioniaIoniaIdentityManager(bArr);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$recordAdPlaybackMotionEventAsync$11$com-tapsdk-tapad-internal-ionia-IoniaIdentityManager, reason: not valid java name */
    /* synthetic */ void m170lambda$recordAdPlaybackMotionEventAsync$11$comtapsdktapadinternalioniaIoniaIdentityManager(String str, String str2, MotionEvent motionEvent) {
        try {
            recordAdPlaybackMotionEvent(str, str2, motionEvent);
            motionEvent.recycle();
        } catch (Throwable th) {
            try {
                th.getMessage();
            } finally {
                motionEvent.recycle();
            }
        }
    }

    /* JADX INFO: renamed from: lambda$refreshFromPlatformState$3$com-tapsdk-tapad-internal-ionia-IoniaIdentityManager, reason: not valid java name */
    /* synthetic */ void m171lambda$refreshFromPlatformState$3$comtapsdktapadinternalioniaIoniaIdentityManager(Context context, IoniaIdentityConfig ioniaIdentityConfig) {
        try {
            finishStartupAttempt(startInternal(context, enrichConfig(context, ioniaIdentityConfig)));
        } catch (Throwable th) {
            finishStartupAttempt(false);
        }
    }

    /* JADX INFO: renamed from: lambda$refreshFromPlatformState$4$com-tapsdk-tapad-internal-ionia-IoniaIdentityManager, reason: not valid java name */
    /* synthetic */ void m172lambda$refreshFromPlatformState$4$comtapsdktapadinternalioniaIoniaIdentityManager(Context context, long j) {
        if (this.started || this.starting) {
            return;
        }
        refreshFromPlatformState(context, j);
    }

    /* JADX INFO: renamed from: lambda$restrictPlaybackWindows$8$com-tapsdk-tapad-internal-ionia-IoniaIdentityManager, reason: not valid java name */
    /* synthetic */ boolean m173lambda$restrictPlaybackWindows$8$comtapsdktapadinternalioniaIoniaIdentityManager(long j) {
        return (j & (~behaviorCollectionMask())) == 0;
    }

    /* JADX INFO: renamed from: lambda$scheduleResolve$16$com-tapsdk-tapad-internal-ionia-IoniaIdentityManager, reason: not valid java name */
    /* synthetic */ void m176lambda$scheduleResolve$16$comtapsdktapadinternalioniaIoniaIdentityManager() {
        this.resolveScheduled.set(false);
        scheduleResolve();
    }

    public void onAdLoadRequested() {
        boolean zColdStartPrerequisitesReady = coldStartPrerequisitesReady();
        try {
            AndroidEnvironmentHost.refreshAdRequestIdentifierCache(AppContextHolder.get());
        } catch (Throwable th) {
        }
        this.adRequestObserved = true;
        scheduleResolve();
        if (zColdStartPrerequisitesReady) {
            this.coldStartLoadAccepted = true;
            scheduleColdStartEnrich();
        }
    }

    /* JADX INFO: renamed from: onAdPlaybackClose, reason: merged with bridge method [inline-methods] */
    public void m162lambda$onAdPlaybackCloseAsync$9$comtapsdktapadinternalioniaIoniaIdentityManager(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.playbackWindowLock) {
            this.pendingPlaybackWindows.remove(str);
            if (!allowsBehaviorCollection()) {
                revokePlaybackWindows();
                return;
            }
            WasmModule wasmModuleActiveModule = activeModule();
            if (wasmModuleActiveModule == null) {
                return;
            }
            if (this.activePlaybackWindows.containsKey(str)) {
                wasmModuleActiveModule.callSecurityExecSync(21, playbackWindowPayload(str));
                this.activePlaybackWindows.remove(str);
                enrichAfterBehaviorWindow(str2, str);
            }
        }
    }

    public void onAdPlaybackCloseAsync(final String str, final String str2) {
        executePlaybackTask(ILivePush.ClickType.CLOSE, new Runnable() { // from class: com.tapsdk.tapad.internal.ionia.IoniaIdentityManager$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m162lambda$onAdPlaybackCloseAsync$9$comtapsdktapadinternalioniaIoniaIdentityManager(str, str2);
            }
        });
    }

    /* JADX INFO: renamed from: onAdPlaybackShow, reason: merged with bridge method [inline-methods] */
    public void m165lambda$onAdPlaybackShowAsync$7$comtapsdktapadinternalioniaIoniaIdentityManager(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.playbackWindowLock) {
            if (!allowsBehaviorCollection()) {
                revokePlaybackWindows();
                return;
            }
            final WasmModule wasmModuleActiveModule = activeModule();
            if (wasmModuleActiveModule == null) {
                this.pendingPlaybackWindows.add(str);
            } else {
                startPlaybackWindow(new ExecFn() { // from class: com.tapsdk.tapad.internal.ionia.IoniaIdentityManager$$ExternalSyntheticLambda23
                    @Override // com.tapsdk.tapad.internal.ionia.IoniaIdentityManager.ExecFn
                    public final byte[] exec(int i, byte[] bArr) {
                        return this.f$0.m164lambda$onAdPlaybackShow$6$comtapsdktapadinternalioniaIoniaIdentityManager(wasmModuleActiveModule, i, bArr);
                    }
                }, str);
            }
        }
    }

    public void onAdPlaybackShowAsync(final String str, final String str2) {
        executePlaybackTask("show", new Runnable() { // from class: com.tapsdk.tapad.internal.ionia.IoniaIdentityManager$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m165lambda$onAdPlaybackShowAsync$7$comtapsdktapadinternalioniaIoniaIdentityManager(str, str2);
            }
        });
    }

    public void onGlobalConfigReady(Context context, long j) {
        this.globalConfigReady = true;
        refreshFromPlatformState(context, j);
    }

    public void onSelfRenderedSurfaceClosed() {
        synchronized (this.enrichTriggerLock) {
            if (!TextUtils.isEmpty(this.pendingEnrichCorrelationId)) {
                schedulePendingEnrichLocked(0L);
            }
        }
    }

    public byte[] peekPendingExtraData() {
        return this.pendingExtraData;
    }

    /* JADX INFO: renamed from: recordAdClickMarker, reason: merged with bridge method [inline-methods] */
    public void m169lambda$recordAdClickMarkerAsync$10$comtapsdktapadinternalioniaIoniaIdentityManager(String str, String str2, int i) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || !isProviderClickMarkerEnabled()) {
            return;
        }
        synchronized (this.playbackWindowLock) {
            if (allowsBehaviorCollection() && this.activePlaybackWindows.containsKey(str)) {
                WasmModule wasmModuleActiveModule = activeModule();
                if (wasmModuleActiveModule == null) {
                    return;
                }
                wasmModuleActiveModule.callSecurityExecSync(28, clickMarkerPayload(str, i));
            }
        }
    }

    public void recordAdClickMarkerAsync(final String str, final String str2, final int i) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || !isProviderClickMarkerEnabled()) {
            return;
        }
        executePlaybackTask("click-marker", new Runnable() { // from class: com.tapsdk.tapad.internal.ionia.IoniaIdentityManager$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m169lambda$recordAdClickMarkerAsync$10$comtapsdktapadinternalioniaIoniaIdentityManager(str, str2, i);
            }
        });
    }

    public void recordAdPlaybackMotionEvent(String str, String str2, MotionEvent motionEvent) {
        if (!allowsMotionCollection()) {
            revokePlaybackWindows();
            return;
        }
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || motionEvent == null || !shouldSampleMotionAction(motionEvent.getActionMasked())) {
            return;
        }
        synchronized (this.playbackWindowLock) {
            if (allowsMotionCollection() && this.activePlaybackWindows.containsKey(str)) {
                WasmModule wasmModuleActiveModule = activeModule();
                if (wasmModuleActiveModule == null) {
                    return;
                }
                if (!wasmModuleActiveModule.recordSecurityMotionEvent(str, motionEvent)) {
                    this.playbackMotionBridgeFailureLogged.compareAndSet(false, true);
                }
            }
        }
    }

    public void recordAdPlaybackMotionEventAsync(final String str, final String str2, MotionEvent motionEvent) {
        if (!allowsMotionCollection() || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || motionEvent == null || !shouldSampleMotionAction(motionEvent.getActionMasked())) {
            return;
        }
        final MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        try {
            this.playbackExecutor.execute(new Runnable() { // from class: com.tapsdk.tapad.internal.ionia.IoniaIdentityManager$$ExternalSyntheticLambda21
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m170lambda$recordAdPlaybackMotionEventAsync$11$comtapsdktapadinternalioniaIoniaIdentityManager(str, str2, motionEventObtain);
                }
            });
        } catch (RejectedExecutionException e) {
            motionEventObtain.recycle();
            e.getMessage();
        }
    }

    public void refreshActiveSignalMaskForTest(ExecFn execFn, long j) {
        refreshActiveSignalMask(execFn, j);
    }

    public void resetGetAdsUploadCountForTest() {
        synchronized (this.getAdsLimitLock) {
            this.baselineGetAdsEnrichUploadedCount = 0;
            this.behaviorGetAdsEnrichUploadedCount = 0;
            this.getAdsEnrichInFlight = false;
            this.deferredBaselineCorrelationId = null;
            this.deferredBehaviorCorrelationId = null;
            this.deferredBehaviorAdId = null;
        }
    }

    public void resetPendingExtraDataForTest() {
        synchronized (this.signalProfileLock) {
            this.pendingExtraData = null;
            this.lastAppliedProfileBase64 = null;
            this.signalProfileAppliedCount = 0;
        }
    }

    public void revokePlaybackWindowsForTest(ExecFn execFn) {
        synchronized (this.playbackWindowLock) {
            revokePlaybackWindows(execFn);
        }
    }

    public void setActiveConfigForTest(IoniaIdentityConfig ioniaIdentityConfig) {
        this.activeConfig = ioniaIdentityConfig;
        this.installedAppsPrivacyGeneration.incrementAndGet();
        this.appliedSignalMask = null;
    }

    public void setActiveModuleForTest(WasmModule wasmModule) {
        this.adRequestObserved = false;
        this.coldStartLoadAccepted = false;
        this.globalConfigReady = false;
        this.coldStartEnrichAttempted.set(false);
        this.resolveAttempted.set(false);
        this.resolveScheduled.set(false);
        synchronized (this.playbackWindowLock) {
            this.activeModule = wasmModule;
            this.pendingPlaybackWindows.clear();
            this.activePlaybackWindows.clear();
        }
    }

    public void setPendingExtraDataForTest(byte[] bArr) {
        synchronized (this.signalProfileLock) {
            this.pendingExtraData = bArr;
        }
    }

    public void startPlaybackWindowForTest(ExecFn execFn, String str) {
        synchronized (this.playbackWindowLock) {
            startPlaybackWindow(execFn, str);
        }
    }

    public boolean tryReserveBaselineGetAdsEnrichForTest() {
        return tryReserveGetAdsEnrich(false, "baseline", "") != null;
    }

    public boolean tryReserveBehaviorGetAdsEnrichForTest(String str) {
        return tryReserveGetAdsEnrich(true, str, str) != null;
    }

    private static void confirmDeliveredWindows(ExecFn execFn) {
        byte[] bArrExec = execFn.exec(19, new byte[0]);
        if (bArrExec != null && bArrExec.length > 0) {
            execFn.exec(145, bArrExec);
        }
        byte[] bArrExec2 = execFn.exec(25, new byte[0]);
        if (bArrExec2 == null || bArrExec2.length <= 0) {
            return;
        }
        execFn.exec(22, bArrExec2);
    }

    private void scheduleGetAdsEnrich(String str, boolean z, long j) {
        scheduleGetAdsEnrich(str, "", z, j);
    }

    public void collectInstalledApps(final WasmModule.SecurityExecPermission securityExecPermission, final IoniaInstalledApps.Callback callback) {
        if (callback == null) {
            return;
        }
        final long j = this.installedAppsPrivacyGeneration.get();
        if (DirichletRuntime.getInstance().runOnRuntimeQueue(new Runnable() { // from class: com.tapsdk.tapad.internal.ionia.IoniaIdentityManager$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m159lambda$collectInstalledApps$19$comtapsdktapadinternalioniaIoniaIdentityManager(j, securityExecPermission, callback);
            }
        })) {
            return;
        }
        callback.onResult(IoniaInstalledApps.empty(IoniaInstalledApps.Status.UNAVAILABLE));
    }

    public IoniaInstalledApps.Result collectInstalledAppsNow(final long j, final WasmModule.SecurityExecPermission securityExecPermission) {
        IoniaInstalledApps.Result resultEmpty;
        final IoniaIdentityConfig ioniaIdentityConfig = this.activeConfig;
        if (!securityExecPermission.isAllowed() || j != this.installedAppsPrivacyGeneration.get() || !allowsInstalledApps(ioniaIdentityConfig)) {
            return IoniaInstalledApps.empty(IoniaInstalledApps.Status.DENIED);
        }
        WasmModule wasmModule = this.activeModule;
        if (!this.globalConfigReady || !this.adRequestObserved || this.starting || wasmModule == null) {
            return IoniaInstalledApps.empty(IoniaInstalledApps.Status.UNAVAILABLE);
        }
        try {
            resultEmpty = IoniaInstalledApps.decode(wasmModule.callGuardedSecurityExecSync(29, new Codec.Writer().writeU32(1).writeU64(PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE).finish(), new WasmModule.SecurityExecPermission() { // from class: com.tapsdk.tapad.internal.ionia.IoniaIdentityManager$$ExternalSyntheticLambda24
                @Override // com.tapsdk.tapad.internal.runtime.WasmModule.SecurityExecPermission
                public final boolean isAllowed() {
                    return this.f$0.m160lambda$collectInstalledAppsNow$21$comtapsdktapadinternalioniaIoniaIdentityManager(securityExecPermission, j, ioniaIdentityConfig);
                }
            }));
        } catch (Throwable th) {
            resultEmpty = IoniaInstalledApps.empty(IoniaInstalledApps.Status.UNAVAILABLE);
        }
        return (securityExecPermission.isAllowed() && j == this.installedAppsPrivacyGeneration.get() && ioniaIdentityConfig == this.activeConfig && allowsInstalledApps(ioniaIdentityConfig)) ? resultEmpty : IoniaInstalledApps.empty(IoniaInstalledApps.Status.DENIED);
    }

    private void scheduleGetAdsEnrich(String str, String str2, boolean z, long j) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        long jMax = Math.max(z ? BEHAVIOR_ENRICH_DEBOUNCE_MS : 0L, Math.max(0L, j));
        synchronized (this.enrichTriggerLock) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (TextUtils.isEmpty(this.pendingEnrichCorrelationId)) {
                this.pendingEnrichSinceElapsedMs = jElapsedRealtime;
                this.pendingEnrichOverdueLogged = false;
            }
            if (z || !this.pendingEnrichBehaviorPriority) {
                this.pendingEnrichCorrelationId = str;
                if (!z || str2 == null) {
                    str2 = "";
                }
                this.pendingEnrichAdId = str2;
            }
            this.pendingEnrichBehaviorPriority |= z;
            schedulePendingEnrichLocked(jMax);
        }
    }

    private void revokePlaybackWindows(ExecFn execFn) {
        this.pendingPlaybackWindows.clear();
        if (execFn == null) {
            return;
        }
        for (String str : new LinkedHashSet(this.activePlaybackWindows.keySet())) {
            try {
                execFn.exec(21, playbackWindowPayload(str));
                this.activePlaybackWindows.remove(str);
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }

    private boolean refreshActiveSignalMask(ExecFn execFn, long j) {
        return refreshActiveSignalMask(execFn, j, this.globalConfigReady && this.adRequestObserved);
    }

    private boolean refreshActiveSignalMask(ExecFn execFn, long j, boolean z) {
        long jCollectionMask = IoniaIdentityConfig.collectionMask(j, z);
        Long l = this.appliedSignalMask;
        if (l != null && l.longValue() == jCollectionMask) {
            return true;
        }
        try {
            byte[] bArrExec = execFn.exec(27, signalMaskPayload(jCollectionMask));
            if (bArrExec == null || bArrExec.length == 0) {
                return false;
            }
            this.appliedSignalMask = Long.valueOf(jCollectionMask);
            return true;
        } catch (Throwable th) {
            th.getMessage();
            return false;
        }
    }
}
