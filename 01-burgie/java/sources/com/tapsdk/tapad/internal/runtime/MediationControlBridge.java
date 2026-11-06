package com.tapsdk.tapad.internal.runtime;

import android.content.Context;
import com.byazt.mg.PluginConstants;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.tapsdk.tapad.constants.Constants;
import com.tapsdk.tapad.group.AdNetworkType;
import com.tapsdk.tapad.group.AdType;
import com.tapsdk.tapad.group.DirichletAdConfig;
import com.tapsdk.tapad.group.DirichletAdCustomController;
import com.tapsdk.tapad.group.DirichletAdRequest;
import com.tapsdk.tapad.group.adapter.AdapterInitConfigFactory;
import com.tapsdk.tapad.group.config.AdNetworkCapabilityDetector;
import com.tapsdk.tapad.internal.AppContextHolder;
import com.tapsdk.tapad.internal.WasmCoreModuleLoader;
import com.tapsdk.tapad.internal.platform.AndroidEnvironmentHost;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class MediationControlBridge {
    private static final String CALLBACK_CONTROL = "onMediationRuntimeResult";
    private static final String CALLBACK_REPORT = "onMediationReport";
    private static final DirichletRuntime.NativeCallback CONTROL_CALLBACK;
    private static final long CONTROL_CALLBACK_TIMEOUT_MS = 45000;
    private static final ScheduledThreadPoolExecutor CONTROL_WATCHDOG;
    private static final int ERR_EXPORT_MISSING = -9663;
    private static final int ERR_INVALID_COMMAND = -9665;
    private static final int ERR_INVALID_INPUT = -9661;
    private static final int ERR_QUEUE_UNAVAILABLE = -9664;
    private static final int ERR_RUNTIME_UNAVAILABLE = -9662;
    private static final String EXPORT_INITIALIZE_ORIGIN = "mediation_runtime_initialize_origin_v1";
    private static final String EXPORT_PREPARE_LOAD = "mediation_runtime_prepare_load_v1";
    private static final String EXPORT_REPORT = "mediation_control_report_v1";
    private static final int MAX_PREFETCH_ASSET_BYTES = 262144;
    private static final int MAX_PREFETCH_SPACE_IDS = 1024;
    static final int OP_CANDIDATE_FACT = 6;
    static final int OP_FILL_REQUEST = 5;
    static final int OP_REWARD_VERIFY_REQUEST = 9;
    private static final String PREFETCH_CONFIG_ASSET = "dirichlet_ad_sdk_config.json";
    private static final int REPORT_OP_ADAPTER_REGISTRY_OBSERVATION = 10;
    private static final AtomicInteger NEXT_REQUEST_TOKEN = new AtomicInteger(1);
    private static final Map<Integer, Pending> PENDING = new ConcurrentHashMap();

    /* JADX INFO: renamed from: com.tapsdk.tapad.internal.runtime.MediationControlBridge$1, reason: invalid class name */
    public class AnonymousClass1 implements WasmCoreModuleLoader.Callback {
        final /* synthetic */ DirichletAdConfig val$config;
        final /* synthetic */ JSONObject val$facts;
        final /* synthetic */ long val$originId;
        final /* synthetic */ String val$protocolContext;
        final /* synthetic */ int val$requestToken;
        final /* synthetic */ DirichletRuntime val$runtime;

        public AnonymousClass1(DirichletRuntime dirichletRuntime, long j, DirichletAdConfig dirichletAdConfig, String str, JSONObject jSONObject, int i) {
            this.val$runtime = dirichletRuntime;
            this.val$originId = j;
            this.val$config = dirichletAdConfig;
            this.val$protocolContext = str;
            this.val$facts = jSONObject;
            this.val$requestToken = i;
        }

        @Override // com.tapsdk.tapad.internal.WasmCoreModuleLoader.Callback
        public void onError(Exception exc) {
            MediationControlBridge.failPending(this.val$requestToken, MediationControlBridge.ERR_RUNTIME_UNAVAILABLE, "module_load", exc);
        }

        @Override // com.tapsdk.tapad.internal.WasmCoreModuleLoader.Callback
        public void onLoaded(final WasmModule wasmModule) {
            DirichletRuntime dirichletRuntime = this.val$runtime;
            final long j = this.val$originId;
            final DirichletAdConfig dirichletAdConfig = this.val$config;
            final String str = this.val$protocolContext;
            final JSONObject jSONObject = this.val$facts;
            final int i = this.val$requestToken;
            if (dirichletRuntime.runOnRuntimeQueue(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.MediationControlBridge$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MediationControlBridge.startOriginInitialization(wasmModule, j, dirichletAdConfig, str, jSONObject, i);
                }
            })) {
                return;
            }
            MediationControlBridge.failPending(this.val$requestToken, MediationControlBridge.ERR_QUEUE_UNAVAILABLE, "runtime_queue_unavailable", null);
        }
    }

    /* JADX INFO: renamed from: com.tapsdk.tapad.internal.runtime.MediationControlBridge$2, reason: invalid class name */
    public class AnonymousClass2 implements WasmCoreModuleLoader.Callback {
        final /* synthetic */ JSONObject val$facts;
        final /* synthetic */ int val$requestToken;
        final /* synthetic */ DirichletRuntime val$runtime;

        public AnonymousClass2(DirichletRuntime dirichletRuntime, JSONObject jSONObject, int i) {
            this.val$runtime = dirichletRuntime;
            this.val$facts = jSONObject;
            this.val$requestToken = i;
        }

        @Override // com.tapsdk.tapad.internal.WasmCoreModuleLoader.Callback
        public void onError(Exception exc) {
            MediationControlBridge.failPending(this.val$requestToken, MediationControlBridge.ERR_RUNTIME_UNAVAILABLE, "module_load", exc);
        }

        @Override // com.tapsdk.tapad.internal.WasmCoreModuleLoader.Callback
        public void onLoaded(final WasmModule wasmModule) {
            DirichletRuntime dirichletRuntime = this.val$runtime;
            final JSONObject jSONObject = this.val$facts;
            final int i = this.val$requestToken;
            if (dirichletRuntime.runOnRuntimeQueue(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.MediationControlBridge$2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MediationControlBridge.startLoadPreparation(wasmModule, jSONObject, i);
                }
            })) {
                return;
            }
            MediationControlBridge.failPending(this.val$requestToken, MediationControlBridge.ERR_QUEUE_UNAVAILABLE, "runtime_queue_unavailable", null);
        }
    }

    public interface Callback {
        void onError(int i, String str, Throwable th);

        default void onError(JSONObject jSONObject, int i, String str, Throwable th) {
            onError(i, str, th);
        }

        void onReady(JSONObject jSONObject);
    }

    public enum Operation {
        ORIGIN,
        LOAD
    }

    public static final class Pending {
        final Callback callback;
        final Operation operation;
        volatile ScheduledFuture<?> watchdog;

        public Pending(Operation operation, Callback callback) {
            this.operation = operation;
            this.callback = callback;
        }

        public void cancelWatchdog() {
            ScheduledFuture<?> scheduledFuture = this.watchdog;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
        }
    }

    static {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new ThreadFactory() { // from class: com.tapsdk.tapad.internal.runtime.MediationControlBridge$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return MediationControlBridge.lambda$static$0(runnable);
            }
        });
        CONTROL_WATCHDOG = scheduledThreadPoolExecutor;
        CONTROL_CALLBACK = new DirichletRuntime.NativeCallback() { // from class: com.tapsdk.tapad.internal.runtime.MediationControlBridge$$ExternalSyntheticLambda4
            @Override // com.tapsdk.tapad.internal.runtime.DirichletRuntime.NativeCallback
            public final void onCallback(String str, String str2) {
                MediationControlBridge.handleCoreCallback(str, str2);
            }
        };
        scheduledThreadPoolExecutor.setRemoveOnCancelPolicy(true);
    }

    private MediationControlBridge() {
    }

    private static String adapterVersion(AdNetworkType adNetworkType, Map<AdNetworkType, AdNetworkCapabilityDetector.Capability> map) {
        AdNetworkCapabilityDetector.Capability capability = map.get(adNetworkType);
        return capability == null ? "" : safe(capability.getAdapterVersion());
    }

    private static void applyReportEffects(String str) {
        try {
            if (str == null) {
                str = "";
            }
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("schema_version", 0) == 1 && "shared_rust".equals(jSONObject.optString("owner")) && "report_effects".equals(jSONObject.optString("kind"))) {
                MediationPlatformEffects.apply(AppContextHolder.appContext, jSONObject.optJSONObject("effects"));
            }
        } catch (Throwable th) {
        }
    }

    private static String collectInitialProtocolContext(Context context, DirichletAdConfig dirichletAdConfig) {
        DirichletAdCustomController dirichletAdCustomController = dirichletAdConfig.mCustomController;
        boolean z = dirichletAdCustomController != null && dirichletAdCustomController.isCanUsePhoneState();
        boolean z2 = dirichletAdCustomController != null && dirichletAdCustomController.isCanUseAndroidId();
        JSONObject jSONObjectCollectInitialization = AndroidDeviceFacts.collectInitialization(context, z2, z);
        return new JSONObject().put("game_channel", safe(dirichletAdConfig.gameChannel)).put("media_global_settings", PublisherSettingsBridge.snapshot()).put("sdk_platform_facts", new JSONObject().put("is_can_use_phone_state", z).put("is_can_use_wifi_state", dirichletAdCustomController != null && dirichletAdCustomController.isCanUseWifiState()).put("is_can_use_write_external", dirichletAdCustomController != null && dirichletAdCustomController.isCanUseWriteExternal()).put("is_can_get_install_list", dirichletAdCustomController != null && dirichletAdCustomController.alist()).put("is_debug", dirichletAdConfig.mIsDebug).put("is_can_use_android_id", z2).put("is_can_use_location", dirichletAdCustomController != null && dirichletAdCustomController.isCanUseLocation()).put("enable_shake", dirichletAdConfig.shakeEnabled).put("base_data", safe(dirichletAdConfig.data))).put("android_facts", jSONObjectCollectInitialization).put("response_facts", new JSONObject().put("adn_did", jSONObjectCollectInitialization.optString("adn_did", "")).put("event_time_ms", System.currentTimeMillis())).toString();
    }

    private static JSONObject collectOriginFacts(Context context, long j) throws JSONException {
        Map<AdNetworkType, AdNetworkCapabilityDetector.Capability> mapDetectAll = AdNetworkCapabilityDetector.detectAll();
        JSONObject jSONObjectCollectSdkInfo = collectSdkInfo(mapDetectAll);
        ArrayList arrayList = new ArrayList(mapDetectAll.values());
        Collections.sort(arrayList, new Comparator<AdNetworkCapabilityDetector.Capability>() { // from class: com.tapsdk.tapad.internal.runtime.MediationControlBridge.3
            @Override // java.util.Comparator
            public int compare(AdNetworkCapabilityDetector.Capability capability, AdNetworkCapabilityDetector.Capability capability2) {
                return Integer.compare(capability.getNetworkType().getValue(), capability2.getNetworkType().getValue());
            }
        });
        JSONArray jSONArray = new JSONArray();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            AdNetworkCapabilityDetector.Capability capability = (AdNetworkCapabilityDetector.Capability) obj;
            AdNetworkType networkType = capability.getNetworkType();
            if (networkType != null && networkType != AdNetworkType.AD_UNKOWN) {
                jSONArray.put(new JSONObject().put("network_type", networkType.getValue()).put("adapter_present", capability.isAdapterPresent()).put("sdk_present", capability.isSdkPresent()).put("adapter_version", capability.getAdapterVersion()).put("sdk_version", capability.getActualPartnerVersion()).put("available", capability.isAvailable()).put("unavailable_reason", capability.isAvailable() ? "" : safe(capability.getUnavailableReason())));
            }
        }
        return new JSONObject().put("sdk_info", jSONObjectCollectSdkInfo).put("ad_network_capabilities", new JSONObject().put("schema_version", 1).put("networks", jSONArray)).put("preload_space_ids", readPreloadSpaceIds(context, j));
    }

    private static JSONObject collectSdkInfo(Map<AdNetworkType, AdNetworkCapabilityDetector.Capability> map) throws JSONException {
        JSONObject jSONObjectPut = new JSONObject().put("sdk_version_code", 50300001).put("sdk_version_name", safe("5.3.0.1"));
        AdNetworkType adNetworkType = AdNetworkType.AD_TT;
        JSONObject jSONObjectPut2 = jSONObjectPut.put("csj_sdk_version", providerVersion(adNetworkType, map)).put("csj_sdk_adapter_version", adapterVersion(adNetworkType, map));
        AdNetworkType adNetworkType2 = AdNetworkType.AD_GDT;
        JSONObject jSONObjectPut3 = jSONObjectPut2.put("gdt_sdk_version", providerVersion(adNetworkType2, map)).put("gdt_sdk_adapter_version", adapterVersion(adNetworkType2, map));
        AdNetworkType adNetworkType3 = AdNetworkType.AD_IQY;
        JSONObject jSONObjectPut4 = jSONObjectPut3.put("iqy_sdk_version", providerVersion(adNetworkType3, map)).put("iqy_sdk_adapter_version", adapterVersion(adNetworkType3, map));
        AdNetworkType adNetworkType4 = AdNetworkType.AD_BD;
        return jSONObjectPut4.put("bd_sdk_version", providerVersion(adNetworkType4, map)).put("bd_sdk_adapter_version", adapterVersion(adNetworkType4, map));
    }

    private static void fail(Callback callback, int i, String str, Throwable th) {
        if (callback != null) {
            callback.onError(i, str, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void failPending(int i, int i2, String str, Throwable th) {
        Pending pendingRemovePending = removePending(i);
        fail(pendingRemovePending == null ? null : pendingRemovePending.callback, i2, str, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleCoreCallback(String str, String str2) {
        if (CALLBACK_REPORT.equals(str)) {
            applyReportEffects(str2);
            return;
        }
        if (!CALLBACK_CONTROL.equals(str)) {
            return;
        }
        int i = 0;
        JSONObject jSONObject = null;
        try {
            if (str2 == null) {
                str2 = "";
            }
            JSONObject jSONObject2 = new JSONObject(str2);
            try {
                i = jSONObject2.getInt("request_token");
                if (i <= 0 || jSONObject2.getInt("schema_version") != 1 || !"shared_rust".equals(jSONObject2.getString("owner"))) {
                    throw new IllegalArgumentException("unsupported control command");
                }
                Pending pendingRemovePending = removePending(i);
                if (pendingRemovePending == null) {
                    return;
                }
                Callback callback = pendingRemovePending.callback;
                try {
                    MediationPlatformEffects.apply(AppContextHolder.appContext, jSONObject2.optJSONObject("effects"));
                    if (!"ready".equals(jSONObject2.optString("outcome"))) {
                        callback.onError(jSONObject2, jSONObject2.optInt(PluginConstants.KEY_ERROR_CODE, ERR_INVALID_COMMAND), jSONObject2.optString(MediationConstant.KEY_REASON, "core_failure"), null);
                        return;
                    }
                    if (pendingRemovePending.operation == Operation.ORIGIN) {
                        if (jSONObject2.optJSONArray("adapter_commands") == null) {
                            throw new IllegalArgumentException("missing adapter commands");
                        }
                    } else if (jSONObject2.optString(Constants.Bidding.REQUEST_ID, "").isEmpty() || jSONObject2.optJSONObject("load") == null || jSONObject2.optJSONArray("routes") == null) {
                        throw new IllegalArgumentException("missing load commands");
                    }
                    callback.onReady(jSONObject2);
                } catch (Throwable th) {
                    callback.onError(ERR_INVALID_COMMAND, "invalid_control_command", th);
                }
            } catch (Throwable th2) {
                th = th2;
                jSONObject = jSONObject2;
                rejectInvalidControlCommand(jSONObject, i, th);
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static void initializeOrigin(Context context, long j, DirichletAdConfig dirichletAdConfig, Callback callback) {
        if (context == null || j <= 0 || dirichletAdConfig == null || callback == null) {
            fail(callback, ERR_INVALID_INPUT, "invalid_input", null);
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            applicationContext = context;
        }
        try {
            AndroidPrivacyPolicy.applyMediationCollectionPolicy(null);
            AdapterInitConfigFactory.bindPrivacyController(dirichletAdConfig.mCustomController);
            JSONObject jSONObjectCollectOriginFacts = collectOriginFacts(applicationContext, dirichletAdConfig.mMediaId);
            String strCollectInitialProtocolContext = collectInitialProtocolContext(applicationContext, dirichletAdConfig);
            if (strCollectInitialProtocolContext.isEmpty()) {
                throw new IllegalStateException("missing protocol context");
            }
            if (!WasmRuntimeController.getInstance().ensureAdCoreInitialized(applicationContext)) {
                fail(callback, ERR_RUNTIME_UNAVAILABLE, "runtime_unavailable", null);
                return;
            }
            DirichletRuntime dirichletRuntime = DirichletRuntime.getInstance();
            int iNextRequestToken = nextRequestToken();
            if (putPending(iNextRequestToken, Operation.ORIGIN, callback)) {
                DirichletRuntime.NativeCallback nativeCallback = CONTROL_CALLBACK;
                dirichletRuntime.registerControlCallback(CALLBACK_CONTROL, nativeCallback);
                dirichletRuntime.registerControlCallback(CALLBACK_REPORT, nativeCallback);
                WasmCoreModuleLoader.loadAuction(dirichletRuntime, new AnonymousClass1(dirichletRuntime, j, dirichletAdConfig, strCollectInitialProtocolContext, jSONObjectCollectOriginFacts, iNextRequestToken));
            }
        } catch (Throwable th) {
            fail(callback, ERR_INVALID_INPUT, "platform_facts", th);
        }
    }

    static /* synthetic */ Thread lambda$static$0(Runnable runnable) {
        Thread thread = new Thread(runnable, "TapAd-MediationControlWatchdog");
        thread.setDaemon(true);
        return thread;
    }

    static /* synthetic */ void lambda$submitFillSummaryAndRelease$1(String str) {
        try {
            submitReport(5, new JSONObject().put(Constants.Bidding.REQUEST_ID, str));
            MediationRuntimeCoreBridge.releaseLoadPlan(str);
        } catch (Throwable th) {
            MediationRuntimeCoreBridge.releaseLoadPlan(str);
        }
    }

    private static int nextRequestToken() {
        while (true) {
            AtomicInteger atomicInteger = NEXT_REQUEST_TOKEN;
            int andIncrement = atomicInteger.getAndIncrement();
            if (andIncrement > 0) {
                return andIncrement;
            }
            atomicInteger.compareAndSet(andIncrement + 1, 1);
        }
    }

    public static JSONArray parsePreloadSpaceIds(String str, long j) {
        JSONArray jSONArrayOptJSONArray;
        JSONArray jSONArray = new JSONArray();
        if (str != null && !str.isEmpty() && j > 0 && (jSONArrayOptJSONArray = new JSONObject(str).optJSONArray("media_config")) != null) {
            String strValueOf = String.valueOf(j);
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && strValueOf.equals(String.valueOf(jSONObjectOptJSONObject.opt("media_id")))) {
                    JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("space_id_list");
                    if (jSONArrayOptJSONArray2 == null) {
                        break;
                    }
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length() && linkedHashSet.size() < 1024; i2++) {
                        Object objOpt = jSONArrayOptJSONArray2.opt(i2);
                        if (objOpt != null && objOpt != JSONObject.NULL) {
                            try {
                                long j2 = Long.parseLong(String.valueOf(objOpt));
                                if (j2 > 0) {
                                    linkedHashSet.add(Long.valueOf(j2));
                                }
                            } catch (NumberFormatException e) {
                            }
                        }
                    }
                    Iterator it = linkedHashSet.iterator();
                    while (it.hasNext()) {
                        jSONArray.put((Long) it.next());
                    }
                    break;
                }
            }
        }
        return jSONArray;
    }

    public static void prepareLoad(Context context, DirichletAdRequest dirichletAdRequest, AdType adType, long j, List<Integer> list, Callback callback) {
        if (context == null || dirichletAdRequest == null || dirichletAdRequest.spaceId <= 0 || adType == null || j <= 0 || callback == null) {
            fail(callback, ERR_INVALID_INPUT, "invalid_input", null);
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        try {
            JSONObject jSONObjectPut = new JSONObject().put(Constants.Bidding.SPACE_ID, dirichletAdRequest.spaceId).put("mina_id", dirichletAdRequest.minaId).put("ad_format", adType.name()).put("adapter_registry_epoch", j).put("request_facts", new JSONObject().put("query", safe(dirichletAdRequest.query)).put("reward_user_id", safe(dirichletAdRequest.userId)).put("reward_extra", safe(dirichletAdRequest.extra1)).put("reward_name", safe(dirichletAdRequest.rewardName)).put("reward_amount", dirichletAdRequest.rewardAmount).put("accepted_width", dirichletAdRequest.expressViewAcceptedWidth).put("accepted_height", dirichletAdRequest.expressViewAcceptedHeight)).put("ready_networks", readyNetworks(list)).put("publisher_settings", PublisherSettingsBridge.snapshot()).put("android_identifiers", AndroidEnvironmentHost.collectAdRequestIdentifiers(context)).put("event_time_ms", System.currentTimeMillis());
            if (!WasmRuntimeController.getInstance().ensureAdCoreInitialized(context)) {
                fail(callback, ERR_RUNTIME_UNAVAILABLE, "runtime_unavailable", null);
                return;
            }
            DirichletRuntime dirichletRuntime = DirichletRuntime.getInstance();
            int iNextRequestToken = nextRequestToken();
            if (putPending(iNextRequestToken, Operation.LOAD, callback)) {
                dirichletRuntime.registerControlCallback(CALLBACK_CONTROL, CONTROL_CALLBACK);
                WasmCoreModuleLoader.loadAuction(dirichletRuntime, new AnonymousClass2(dirichletRuntime, jSONObjectPut, iNextRequestToken));
            }
        } catch (Throwable th) {
            fail(callback, ERR_INVALID_INPUT, "platform_facts", th);
        }
    }

    private static String providerVersion(AdNetworkType adNetworkType, Map<AdNetworkType, AdNetworkCapabilityDetector.Capability> map) {
        AdNetworkCapabilityDetector.Capability capability = map.get(adNetworkType);
        return capability == null ? "" : safe(capability.getActualPartnerVersion());
    }

    private static boolean putPending(final int i, Operation operation, Callback callback) {
        Pending pending = new Pending(operation, callback);
        Map<Integer, Pending> map = PENDING;
        map.put(Integer.valueOf(i), pending);
        try {
            ScheduledFuture<?> scheduledFutureSchedule = CONTROL_WATCHDOG.schedule(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.MediationControlBridge$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    MediationControlBridge.failPending(i, MediationControlBridge.ERR_RUNTIME_UNAVAILABLE, "core_callback_timeout", null);
                }
            }, 45000L, TimeUnit.MILLISECONDS);
            pending.watchdog = scheduledFutureSchedule;
            if (map.get(Integer.valueOf(i)) == pending) {
                return true;
            }
            scheduledFutureSchedule.cancel(false);
            return true;
        } catch (Throwable th) {
            failPending(i, ERR_QUEUE_UNAVAILABLE, "control_watchdog_unavailable", th);
            return false;
        }
    }

    private static JSONArray readPreloadSpaceIds(Context context, long j) {
        JSONArray preloadSpaceIds;
        if (context == null || j <= 0) {
            return new JSONArray();
        }
        try {
            InputStream inputStreamOpen = context.getAssets().open(PREFETCH_CONFIG_ASSET);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[4096];
                    int i = 0;
                    while (true) {
                        int i2 = inputStreamOpen.read(bArr);
                        if (i2 == -1) {
                            preloadSpaceIds = parsePreloadSpaceIds(new String(byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8), j);
                            byteArrayOutputStream.close();
                            break;
                        }
                        i += i2;
                        if (i > 262144) {
                            preloadSpaceIds = new JSONArray();
                            byteArrayOutputStream.close();
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, i2);
                    }
                    inputStreamOpen.close();
                    return preloadSpaceIds;
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                }
                throw th3;
            }
        } catch (Throwable th5) {
            return new JSONArray();
        }
    }

    private static JSONArray readyNetworks(List<Integer> list) {
        int iIntValue;
        JSONArray jSONArray = new JSONArray();
        boolean[] zArr = new boolean[6];
        if (list != null) {
            for (Integer num : list) {
                if (num != null && (iIntValue = num.intValue()) > 0 && iIntValue < 6 && !zArr[iIntValue]) {
                    zArr[iIntValue] = true;
                    jSONArray.put(iIntValue);
                }
            }
        }
        return jSONArray;
    }

    private static void rejectInvalidControlCommand(JSONObject jSONObject, int i, Throwable th) {
        int i2 = 0;
        if (i <= 0 && jSONObject != null) {
            i = jSONObject.optInt("request_token", 0);
        }
        if (i > 0) {
            failPending(i, ERR_INVALID_COMMAND, "invalid_control_command", th);
            return;
        }
        ArrayList arrayList = new ArrayList(PENDING.keySet());
        int size = arrayList.size();
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            Pending pendingRemovePending = removePending(((Integer) obj).intValue());
            if (pendingRemovePending != null) {
                fail(pendingRemovePending.callback, ERR_INVALID_COMMAND, "invalid_control_command", th);
            }
        }
    }

    private static Pending removePending(int i) {
        Pending pendingRemove = PENDING.remove(Integer.valueOf(i));
        if (pendingRemove != null) {
            pendingRemove.cancelWatchdog();
        }
        return pendingRemove;
    }

    private static String safe(String str) {
        return str == null ? "" : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void startLoadPreparation(WasmModule wasmModule, JSONObject jSONObject, int i) {
        if (PENDING.containsKey(Integer.valueOf(i))) {
            if (wasmModule == null || !wasmModule.hasFunction(EXPORT_PREPARE_LOAD)) {
                failPending(i, ERR_EXPORT_MISSING, "missing_export", null);
                return;
            }
            try {
                int iCallIntSync = wasmModule.callIntSync(EXPORT_PREPARE_LOAD, jSONObject.toString(), Integer.valueOf(i));
                if (iCallIntSync <= 0) {
                    failPending(i, iCallIntSync, "core_rejected", null);
                }
            } catch (Throwable th) {
                failPending(i, ERR_RUNTIME_UNAVAILABLE, "core_invoke", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void startOriginInitialization(WasmModule wasmModule, long j, DirichletAdConfig dirichletAdConfig, String str, JSONObject jSONObject, int i) {
        if (PENDING.containsKey(Integer.valueOf(i))) {
            if (wasmModule == null || !wasmModule.hasFunction(EXPORT_INITIALIZE_ORIGIN)) {
                failPending(i, ERR_EXPORT_MISSING, "missing_export", null);
                return;
            }
            try {
                int iCallIntSync = wasmModule.callIntSync(EXPORT_INITIALIZE_ORIGIN, Long.valueOf(j), Long.valueOf(dirichletAdConfig.mMediaId), safe(dirichletAdConfig.mMediaKey), str, jSONObject.toString(), Integer.valueOf(i));
                if (iCallIntSync <= 0) {
                    failPending(i, iCallIntSync, "core_rejected", null);
                }
            } catch (Throwable th) {
                failPending(i, ERR_RUNTIME_UNAVAILABLE, "core_invoke", th);
            }
        }
    }

    public static void submitAdapterRegistryObservation(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            submitReportAsync(10, new JSONObject(jSONObject.toString()).put("event_time_ms", System.currentTimeMillis()));
        } catch (Throwable th) {
        }
    }

    public static void submitCandidateFact(int i, Map<String, Object> map) {
        if (i <= 0) {
            return;
        }
        try {
            JSONObject jSONObjectPut = new JSONObject().put("fact_code", i).put("event_time_ms", System.currentTimeMillis());
            if (map == null) {
                map = Collections.EMPTY_MAP;
            }
            submitReportAsync(6, jSONObjectPut.put("fields", new JSONObject(map)));
        } catch (Throwable th) {
        }
    }

    public static void submitFillSummaryAndRelease(final String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        DirichletRuntime dirichletRuntime = DirichletRuntime.getInstance();
        Runnable runnable = new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.MediationControlBridge$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MediationControlBridge.lambda$submitFillSummaryAndRelease$1(str);
            }
        };
        if (dirichletRuntime.isOnRuntimeQueue()) {
            runnable.run();
        } else {
            if (dirichletRuntime.runOnRuntimeQueue(runnable)) {
                return;
            }
            MediationRuntimeCoreBridge.releaseLoadPlan(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int submitReport(int i, JSONObject jSONObject) {
        if (jSONObject == null) {
            return ERR_INVALID_INPUT;
        }
        if (i != 5 && i != 6 && i != 9 && i != 10) {
            return ERR_INVALID_INPUT;
        }
        if (AppContextHolder.appContext == null) {
            return ERR_RUNTIME_UNAVAILABLE;
        }
        try {
            DirichletRuntime dirichletRuntime = DirichletRuntime.getInstance();
            WasmModule module = dirichletRuntime.getModule("core");
            if (module != null && !module.isUnloaded()) {
                if (!module.hasFunction(EXPORT_REPORT)) {
                    return ERR_EXPORT_MISSING;
                }
                dirichletRuntime.registerControlCallback(CALLBACK_REPORT, CONTROL_CALLBACK);
                return module.callIntSync(EXPORT_REPORT, Integer.valueOf(i), jSONObject.toString());
            }
            return ERR_RUNTIME_UNAVAILABLE;
        } catch (Throwable th) {
            return ERR_RUNTIME_UNAVAILABLE;
        }
    }

    private static void submitReportAsync(final int i, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            final JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
            DirichletRuntime dirichletRuntime = DirichletRuntime.getInstance();
            Runnable runnable = new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.MediationControlBridge$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    MediationControlBridge.submitReport(i, jSONObject2);
                }
            };
            if (dirichletRuntime.isOnRuntimeQueue()) {
                runnable.run();
            } else {
                dirichletRuntime.runOnRuntimeQueue(runnable);
            }
        } catch (Throwable th) {
        }
    }

    public static void submitRewardVerification(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (str == null) {
                str = "";
            }
            submitReportAsync(9, jSONObject.put("track_id", str));
        } catch (Throwable th) {
        }
    }
}
