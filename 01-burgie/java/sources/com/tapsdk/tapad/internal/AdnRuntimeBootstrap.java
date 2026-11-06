package com.tapsdk.tapad.internal;

import android.content.Context;
import android.text.TextUtils;
import com.tapsdk.tapad.TapAdConfig;
import com.tapsdk.tapad.internal.config.AdnPlatformStateStore;
import com.tapsdk.tapad.internal.ionia.IoniaIdentityManager;
import com.tapsdk.tapad.internal.observability.AdnTelemetryHost;
import com.tapsdk.tapad.internal.platform.AndroidEnvironmentHost;
import com.tapsdk.tapad.internal.runtime.CoreAdnTelemetryBridge;
import com.tapsdk.tapad.internal.runtime.DirichletRuntime;
import com.tapsdk.tapad.internal.runtime.PublisherSettingsBridge;
import com.tapsdk.tapad.internal.runtime.WasmModule;
import com.tapsdk.tapad.internal.runtime.WasmRuntimeController;
import com.tapsdk.tapad.internal.utils.AdnDeviceManager;
import com.tapsdk.tapad.internal.utils.AsyncExecutor;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class AdnRuntimeBootstrap {
    private static final String CALLBACK_EFFECTS = "onAdnPlatformEffects";
    private static final String EXPORT_BOOTSTRAP = "adn_runtime_bootstrap_v1";
    private static final AdnRuntimeBootstrap INSTANCE = new AdnRuntimeBootstrap();
    private static final int MAX_EFFECTS_BYTES = 1048576;
    private static final int MAX_LIST_ITEMS = 512;
    private static final int MAX_STRING_BYTES = 16384;
    private static final int SCHEMA_VERSION = 1;
    private static final String TAG = "AdnRuntimeBootstrap";
    private volatile TapAdConfig bootstrapConfig;
    private boolean publisherInstalled;
    private volatile long publisherMediaId;
    private final AtomicBoolean bootstrapInFlight = new AtomicBoolean();
    private final AtomicBoolean effectsApplied = new AtomicBoolean();
    private final Object publisherInstallLock = new Object();
    private final DirichletRuntime.NativeCallback coreCallback = new DirichletRuntime.NativeCallback() { // from class: com.tapsdk.tapad.internal.AdnRuntimeBootstrap$$ExternalSyntheticLambda0
        @Override // com.tapsdk.tapad.internal.runtime.DirichletRuntime.NativeCallback
        public final void onCallback(String str, String str2) {
            this.f$0.handleCoreCallback(str, str2);
        }
    };

    /* JADX INFO: renamed from: com.tapsdk.tapad.internal.AdnRuntimeBootstrap$1, reason: invalid class name */
    public class AnonymousClass1 implements WasmCoreModuleLoader.Callback {
        final /* synthetic */ Context val$context;
        final /* synthetic */ DirichletRuntime val$runtime;

        public AnonymousClass1(DirichletRuntime dirichletRuntime, Context context) {
            this.val$runtime = dirichletRuntime;
            this.val$context = context;
        }

        /* JADX INFO: renamed from: lambda$onLoaded$0$com-tapsdk-tapad-internal-AdnRuntimeBootstrap$1, reason: not valid java name */
        /* synthetic */ void m100lambda$onLoaded$0$comtapsdktapadinternalAdnRuntimeBootstrap$1(Context context, DirichletRuntime dirichletRuntime, WasmModule wasmModule) {
            AdnRuntimeBootstrap.this.invokeBootstrap(context, dirichletRuntime, wasmModule);
        }

        @Override // com.tapsdk.tapad.internal.WasmCoreModuleLoader.Callback
        public void onError(Exception exc) {
            AdnRuntimeBootstrap.this.finishFailure("module_load", exc);
        }

        @Override // com.tapsdk.tapad.internal.WasmCoreModuleLoader.Callback
        public void onLoaded(final WasmModule wasmModule) {
            final DirichletRuntime dirichletRuntime = this.val$runtime;
            final Context context = this.val$context;
            if (dirichletRuntime.runOnRuntimeQueue(new Runnable() { // from class: com.tapsdk.tapad.internal.AdnRuntimeBootstrap$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m100lambda$onLoaded$0$comtapsdktapadinternalAdnRuntimeBootstrap$1(context, dirichletRuntime, wasmModule);
                }
            })) {
                return;
            }
            AdnRuntimeBootstrap.this.finishFailure("runtime_queue", null);
        }
    }

    public static final class AndroidEffects {
        final String adnDid;
        final int countlyBatchSize;
        final List<String> countlyBlackEvents;
        final List<String> countlyEvents;
        final String countlyServer;
        final JSONObject runtimePlatformState;
        final boolean runtimePlatformStatePresent;
        final JSONArray telemetryEvents;

        private AndroidEffects(String str, String str2, List<String> list, List<String> list2, int i, boolean z, JSONObject jSONObject, JSONArray jSONArray) {
            this.adnDid = str;
            this.countlyServer = str2;
            this.countlyEvents = list;
            this.countlyBlackEvents = list2;
            this.countlyBatchSize = i;
            this.runtimePlatformStatePresent = z;
            this.runtimePlatformState = jSONObject;
            this.telemetryEvents = jSONArray;
        }

        private static String boundedString(String str) throws JSONException {
            if (str == null) {
                str = "";
            }
            if (str.getBytes(StandardCharsets.UTF_8).length <= 16384) {
                return str;
            }
            throw new JSONException("platform effect string exceeds bound");
        }

        public static AndroidEffects parse(String str) {
            return parse(parseEnvelope(str));
        }

        public static JSONObject parseEnvelope(String str) throws JSONException {
            if (str == null || str.getBytes(StandardCharsets.UTF_8).length > 1048576) {
                throw new JSONException("platform effects exceed bound");
            }
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("schema_version", 0) == 1) {
                return jSONObject;
            }
            throw new JSONException("unsupported platform effects schema");
        }

        private static List<String> stringList(JSONArray jSONArray) throws JSONException {
            if (jSONArray == null || jSONArray.length() == 0) {
                return Collections.EMPTY_LIST;
            }
            if (jSONArray.length() > 512) {
                throw new JSONException("platform effect list exceeds bound");
            }
            ArrayList arrayList = new ArrayList(jSONArray.length());
            for (int i = 0; i < jSONArray.length(); i++) {
                Object obj = jSONArray.get(i);
                if (!(obj instanceof String)) {
                    throw new JSONException("platform effect list value is not a string");
                }
                String strBoundedString = boundedString(((String) obj).trim());
                if (!strBoundedString.isEmpty()) {
                    arrayList.add(strBoundedString);
                }
            }
            return arrayList.isEmpty() ? Collections.EMPTY_LIST : Collections.unmodifiableList(arrayList);
        }

        public static AndroidEffects parse(JSONObject jSONObject) throws JSONException {
            if (!"ready".equals(jSONObject.optString("outcome", ""))) {
                throw new JSONException("platform effects are not ready");
            }
            int iOptInt = jSONObject.optInt("countly_count", 1);
            if (iOptInt < 1 || iOptInt > 1000) {
                throw new JSONException("invalid telemetry batch size");
            }
            boolean zOptBoolean = jSONObject.optBoolean("runtime_platform_state_present", false);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("runtime_platform_state");
            if (zOptBoolean && jSONObjectOptJSONObject == null) {
                throw new JSONException("missing runtime platform state");
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("telemetry_events");
            JSONArray jSONArray = jSONArrayOptJSONArray == null ? new JSONArray() : jSONArrayOptJSONArray;
            if (jSONArray.length() <= 512) {
                return new AndroidEffects(boundedString(jSONObject.optString("adn_did", "")), boundedString(jSONObject.optString("countly_server", "")), stringList(jSONObject.optJSONArray("countly_events")), stringList(jSONObject.optJSONArray("countly_black_events")), iOptInt, zOptBoolean, jSONObjectOptJSONObject == null ? new JSONObject() : jSONObjectOptJSONObject, jSONArray);
            }
            throw new JSONException("too many telemetry events");
        }
    }

    private AdnRuntimeBootstrap() {
    }

    private void applyEffects(AndroidEffects androidEffects) {
        Context context = AppContextHolder.get();
        if (androidEffects.runtimePlatformStatePresent) {
            AdnPlatformStateStore.get().apply(androidEffects.runtimePlatformState);
            refreshPlatformStateConsumers(context);
        }
        refreshIoniaAfterGlobalConfig(context);
        CoreAdnTelemetryBridge.reportEvents(androidEffects.telemetryEvents.toString());
        if (context != null && !TextUtils.isEmpty(androidEffects.adnDid)) {
            AdnDeviceManager.getInstance(context).saveAdnDid(androidEffects.adnDid);
        }
        applyTelemetryConfiguration(androidEffects);
    }

    private void applyTelemetryConfiguration(AndroidEffects androidEffects) {
        try {
            AdnTelemetryHost.applyCoreConfiguration(androidEffects.countlyServer, androidEffects.countlyEvents, androidEffects.countlyBlackEvents, androidEffects.countlyBatchSize);
        } catch (Throwable th) {
        }
    }

    private void finishBootstrap() {
        unregisterCoreCallback(DirichletRuntime.getInstance());
        this.bootstrapInFlight.set(false);
        synchronized (this.publisherInstallLock) {
            if (this.publisherInstalled) {
                this.bootstrapConfig = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishFailure(String str, Throwable th) {
        finishBootstrap();
    }

    public static AdnRuntimeBootstrap getInstance() {
        return INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCoreCallback(String str, String str2) {
        if (CALLBACK_EFFECTS.equals(str)) {
            try {
                JSONObject envelope = AndroidEffects.parseEnvelope(str2);
                if (!"ready".equals(envelope.optString("outcome", ""))) {
                    markPublisherRetryable();
                    finishFailure("core", null);
                } else {
                    applyEffects(AndroidEffects.parse(envelope));
                    this.effectsApplied.set(true);
                    finishBootstrap();
                }
            } catch (Throwable th) {
                markPublisherRetryable();
                finishFailure("invalid_effects", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeBootstrap(Context context, DirichletRuntime dirichletRuntime, WasmModule wasmModule) {
        try {
            if (ensurePublisherInstalled(context, dirichletRuntime, wasmModule)) {
                return;
            }
            finishFailure("missing_export", null);
        } catch (Throwable th) {
            finishFailure("invoke", th);
        }
    }

    private void markPublisherRetryable() {
        synchronized (this.publisherInstallLock) {
            this.publisherInstalled = false;
        }
    }

    private void refreshIoniaAfterGlobalConfig(Context context) {
        try {
            IoniaIdentityManager.getInstance().onGlobalConfigReady(context, this.publisherMediaId);
            IoniaIdentityManager.getInstance().applySignalProfile(AdnPlatformStateStore.get().frameworkProfile());
        } catch (Throwable th) {
        }
    }

    private void refreshPlatformStateConsumers(Context context) {
        try {
            WasmRuntimeController.getInstance().refreshFromAdnPlatformEffects(context);
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: startCore, reason: merged with bridge method [inline-methods] */
    public void m99lambda$start$0$comtapsdktapadinternalAdnRuntimeBootstrap(Context context) {
        try {
            if (!WasmRuntimeController.getInstance().ensureAdCoreInitialized(context)) {
                finishFailure("runtime_unavailable", null);
            } else {
                DirichletRuntime dirichletRuntime = DirichletRuntime.getInstance();
                WasmCoreModuleLoader.load(dirichletRuntime, new AnonymousClass1(dirichletRuntime, context));
            }
        } catch (Throwable th) {
            finishFailure("runtime_init", th);
        }
    }

    private void unregisterCoreCallback(DirichletRuntime dirichletRuntime) {
        try {
            dirichletRuntime.unregisterControlCallback(CALLBACK_EFFECTS, this.coreCallback);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0067 A[Catch: all -> 0x0071, TRY_ENTER, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x0008, B:11:0x000f, B:16:0x001b, B:18:0x0021, B:29:0x004a, B:35:0x0059, B:48:0x0067, B:50:0x006b, B:52:0x006d, B:54:0x006f), top: B:60:0x0003 }] */
    public boolean ensurePublisherInstalled(Context context, DirichletRuntime dirichletRuntime, WasmModule wasmModule) {
        synchronized (this.publisherInstallLock) {
            boolean z = true;
            if (this.publisherInstalled) {
                return true;
            }
            if (dirichletRuntime != null && wasmModule != null && wasmModule.hasFunction(EXPORT_BOOTSTRAP)) {
                Context applicationContext = context != null ? context.getApplicationContext() : null;
                TapAdConfig tapAdConfig = this.bootstrapConfig;
                if (applicationContext == null || tapAdConfig == null) {
                    return false;
                }
                try {
                    try {
                        try {
                            synchronized (PublisherSettingsBridge.class) {
                                try {
                                    JSONObject jSONObjectCreateBootstrapPayload = WasmAdnCoreEnvironment.createBootstrapPayload(applicationContext, tapAdConfig);
                                    dirichletRuntime.registerControlCallback(CALLBACK_EFFECTS, this.coreCallback);
                                    if (wasmModule.callIntSync(EXPORT_BOOTSTRAP, jSONObjectCreateBootstrapPayload.toString()) != 1) {
                                        unregisterCoreCallback(dirichletRuntime);
                                        return false;
                                    }
                                    this.publisherInstalled = true;
                                    if (this.effectsApplied.get()) {
                                        this.bootstrapConfig = null;
                                    }
                                    return true;
                                } catch (Throwable th) {
                                    th = th;
                                    throw th;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Throwable th3) {
                        z = false;
                        if (z) {
                            unregisterCoreCallback(dirichletRuntime);
                        }
                        return false;
                    }
                } catch (Throwable th4) {
                    if (z) {
                        unregisterCoreCallback(dirichletRuntime);
                    }
                    return false;
                }
            }
            return false;
        }
    }

    public void prepare(Context context, TapAdConfig tapAdConfig) {
        if ((context != null ? context.getApplicationContext() : null) == null || tapAdConfig == null) {
            return;
        }
        synchronized (this.publisherInstallLock) {
            if (this.publisherInstalled) {
                return;
            }
            AndroidEnvironmentHost.bindAdnController(tapAdConfig.mCustomController);
            this.bootstrapConfig = tapAdConfig;
            this.publisherMediaId = tapAdConfig.mMediaId;
        }
    }

    public void start(Context context, TapAdConfig tapAdConfig) {
        final Context applicationContext = context != null ? context.getApplicationContext() : AppContextHolder.get();
        if (applicationContext == null || tapAdConfig == null) {
            return;
        }
        prepare(applicationContext, tapAdConfig);
        if (this.bootstrapInFlight.compareAndSet(false, true)) {
            if (this.effectsApplied.get()) {
                this.bootstrapInFlight.set(false);
                return;
            }
            AdnPlatformStateStore.get().init(applicationContext);
            if (AsyncExecutor.tryExecuteIO(new Runnable() { // from class: com.tapsdk.tapad.internal.AdnRuntimeBootstrap$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m99lambda$start$0$comtapsdktapadinternalAdnRuntimeBootstrap(applicationContext);
                }
            })) {
                return;
            }
            finishFailure("io_executor", null);
        }
    }
}
