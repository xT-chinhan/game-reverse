package com.tapsdk.tapad.internal.runtime;

import android.content.Context;
import com.tapsdk.tapad.internal.AppContextHolder;
import com.tapsdk.tapad.internal.config.AdnPlatformStateStore;
import com.tapsdk.tapad.internal.runtime.bundle.BundleId;
import com.tapsdk.tapad.internal.runtime.bundle.BundleManifest;
import com.tapsdk.tapad.internal.runtime.bundle.BundleRegistry;
import com.tapsdk.tapad.internal.runtime.bundle.BundleSlotFiles;
import com.tapsdk.tapad.internal.runtime.bundle.BundleUpdater;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class WasmRuntimeController {
    private static final String TAG = "WasmRuntimeController";
    private static volatile WasmRuntimeController sInstance;
    private final BundleUpdateStarter mBundleUpdateStarter;
    private boolean mCachedManifestUpdateStarted;
    private volatile boolean mCoreRuntimeStarted;
    private volatile Set<String> mForceEmbeddedBundleIds;
    private volatile RuntimeDelivery mMediationRuntimeDelivery;
    private volatile boolean mMediationRuntimeDeliveryObserved;
    private volatile Set<String> mRecoveryBaselineBundleIds;
    private boolean mRecoverySessionEvaluated;
    private final RecoverySessionEvaluator mRecoverySessionEvaluator;
    private boolean mRecoverySessionRequired;
    private final Object mRuntimeDeliveryLock;

    public interface BundleUpdateStarter {
        void maybeUpdate(Context context, List<BundleManifest> list, Set<String> set);
    }

    public interface RecoverySessionEvaluator {
        boolean shouldRecover(Context context);
    }

    public static final class RuntimeDelivery {
        final List<BundleManifest> bundles;
        final boolean bundlesPresent;
        final boolean enabled;
        final Set<String> forceEmbeddedBundleIds;
        final boolean known;

        public RuntimeDelivery(boolean z, boolean z2, List<BundleManifest> list, Set<String> set, boolean z3) {
            this.known = z;
            this.enabled = z2;
            this.bundles = list == null ? Collections.EMPTY_LIST : list;
            this.forceEmbeddedBundleIds = set == null ? Collections.EMPTY_SET : set;
            this.bundlesPresent = z3;
        }

        public static RuntimeDelivery embeddedOnly() {
            return new RuntimeDelivery(true, false, Collections.EMPTY_LIST, Collections.EMPTY_SET, false);
        }

        public static RuntimeDelivery parse(JSONObject jSONObject) {
            if (jSONObject == null || !jSONObject.has("enabled")) {
                return unknown();
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("bundles");
            List<BundleManifest> list = BundleManifest.parse(jSONArrayOptJSONArray == null ? "[]" : jSONArrayOptJSONArray.toString());
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("force_embedded_bundle_ids");
            if (jSONArrayOptJSONArray2 != null) {
                for (int i = 0; i < jSONArrayOptJSONArray2.length(); i++) {
                    String strTrim = jSONArrayOptJSONArray2.optString(i, "").trim();
                    if (BundleId.isValid(strTrim)) {
                        linkedHashSet.add(strTrim);
                    }
                }
            }
            return new RuntimeDelivery(true, jSONObject.optBoolean("enabled", false), list, linkedHashSet.isEmpty() ? Collections.EMPTY_SET : Collections.unmodifiableSet(linkedHashSet), jSONObject.optBoolean("bundles_present", false));
        }

        public static RuntimeDelivery unknown() {
            return new RuntimeDelivery(false, false, Collections.EMPTY_LIST, Collections.EMPTY_SET, false);
        }

        public JSONObject toJson() {
            if (!this.known) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray();
                for (BundleManifest bundleManifest : this.bundles) {
                    jSONArray.put(new JSONObject().put("id", bundleManifest.id).put(BreakpointSQLiteKey.URL, bundleManifest.url).put("bundle_version_code", bundleManifest.bundleVersionCode).put("sha256", bundleManifest.sha256).put("size_bytes", bundleManifest.sizeBytes).put("min_sdk_version_code", bundleManifest.minSdkVersionCode).put("max_sdk_version_code", bundleManifest.maxSdkVersionCode).put("host_compatibility_id", bundleManifest.hostCompatibilityId));
                }
                JSONArray jSONArray2 = new JSONArray();
                Iterator<String> it = this.forceEmbeddedBundleIds.iterator();
                while (it.hasNext()) {
                    jSONArray2.put(it.next());
                }
                return new JSONObject().put("enabled", this.enabled).put("bundles_present", this.bundlesPresent).put("bundles", jSONArray).put("force_embedded_bundle_ids", jSONArray2);
            } catch (Throwable th) {
                return null;
            }
        }
    }

    private WasmRuntimeController() {
        this(new BundleUpdateStarter() { // from class: com.tapsdk.tapad.internal.runtime.WasmRuntimeController$$ExternalSyntheticLambda0
            @Override // com.tapsdk.tapad.internal.runtime.WasmRuntimeController.BundleUpdateStarter
            public final void maybeUpdate(Context context, List list, Set set) {
                WasmRuntimeController.lambda$new$0(context, list, set);
            }
        });
    }

    private static Context applicationContext(Context context) {
        if (context == null) {
            context = AppContextHolder.get();
        }
        if (context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    private static void discardForcedCachedBundles(Context context, Set<String> set) {
        if (context == null || set == null || set.isEmpty()) {
            return;
        }
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            new BundleManager(context, it.next()).discardCacheAndStaged();
        }
    }

    private static Set<String> effectiveForceEmbedded(RuntimeDelivery runtimeDelivery) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (runtimeDelivery != null) {
            linkedHashSet.addAll(runtimeDelivery.forceEmbeddedBundleIds);
        }
        if (runtimeDelivery != null && runtimeDelivery.known && !runtimeDelivery.enabled) {
            linkedHashSet.add("core");
        }
        return linkedHashSet.isEmpty() ? Collections.EMPTY_SET : Collections.unmodifiableSet(linkedHashSet);
    }

    private void ensurePlatformStateInitialized(Context context) {
        Context contextApplicationContext = applicationContext(context);
        if (contextApplicationContext != null) {
            AdnPlatformStateStore.get().init(contextApplicationContext);
        }
    }

    public static WasmRuntimeController getInstance() {
        if (sInstance == null) {
            synchronized (WasmRuntimeController.class) {
                if (sInstance == null) {
                    sInstance = new WasmRuntimeController();
                }
            }
        }
        return sInstance;
    }

    private void kickoffBundleUpdate(Context context, RuntimeDelivery runtimeDelivery, Set<String> set) {
        if (context == null || runtimeDelivery == null) {
            return;
        }
        discardForcedCachedBundles(context, set);
        if (!runtimeDelivery.bundlesPresent || runtimeDelivery.bundles.isEmpty()) {
            return;
        }
        this.mBundleUpdateStarter.maybeUpdate(context, runtimeDelivery.bundles, set);
    }

    static /* synthetic */ void lambda$new$0(Context context, List list, Set set) {
        BundleUpdater bundleUpdater = BundleUpdater.get(context);
        final DirichletRuntime dirichletRuntime = DirichletRuntime.getInstance();
        Objects.requireNonNull(dirichletRuntime);
        bundleUpdater.maybeUpdate(list, set, new BundleUpdater.BundleActivator() { // from class: com.tapsdk.tapad.internal.runtime.WasmRuntimeController$$ExternalSyntheticLambda1
            @Override // com.tapsdk.tapad.internal.runtime.bundle.BundleUpdater.BundleActivator
            public final BundleUpdater.ActivationResult activate(BundleManifest bundleManifest) {
                return dirichletRuntime.activateDownloadedBundle(bundleManifest);
            }
        }, null);
    }

    private static void recordFreshDeliveryCheck(Context context) {
        Context contextApplicationContext = applicationContext(context);
        if (contextApplicationContext != null) {
            BundleRegistry.get(contextApplicationContext).recordDeliveryCheckSuccessful("core");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean shouldRecoverDelivery(Context context) {
        BundleRegistry bundleRegistry = BundleRegistry.get(context);
        BundleSlotFiles bundleSlotFiles = new BundleSlotFiles(context, "core");
        return bundleRegistry.beginSessionAndShouldRecoverDelivery("core", (bundleRegistry.getCurrentBundleVersionCode("core") > 0 && bundleSlotFiles.current().isFile()) || (bundleRegistry.getPreviousBundleVersionCode("core") > 0 && bundleSlotFiles.previous().isFile()));
    }

    public static boolean usesAdnRuntimeDelivery(int i) {
        return i == 1;
    }

    public static boolean usesMediationRuntimeDelivery(int i) {
        return i == 2;
    }

    public void applyRuntimeDelivery(Context context, RuntimeDelivery runtimeDelivery) {
        if (runtimeDelivery == null) {
            runtimeDelivery = RuntimeDelivery.unknown();
        }
        Context contextApplicationContext = applicationContext(context);
        Set<String> setEffectiveForceEmbedded = effectiveForceEmbedded(runtimeDelivery);
        this.mForceEmbeddedBundleIds = setEffectiveForceEmbedded;
        if (contextApplicationContext == null) {
            return;
        }
        try {
            if (this.mCoreRuntimeStarted) {
                DirichletRuntime.getInstance().setForceEmbeddedBundleIds(setEffectiveForceEmbedded);
                DirichletRuntime.getInstance().setRecoveryBaselineBundleIds(this.mRecoveryBaselineBundleIds);
            }
            if (runtimeDelivery.known) {
                if (runtimeDelivery.enabled) {
                    kickoffBundleUpdate(contextApplicationContext, runtimeDelivery, setEffectiveForceEmbedded);
                } else {
                    discardForcedCachedBundles(contextApplicationContext, setEffectiveForceEmbedded);
                }
            }
        } catch (Throwable th) {
        }
    }

    public boolean ensureAdCoreInitialized(Context context) {
        return ensureRewardCoreInitialized(context);
    }

    public boolean ensureInitializedForDebugSmoke(Context context) {
        return false;
    }

    public boolean ensureRewardCoreInitialized(Context context) {
        ensurePlatformStateInitialized(context);
        DirichletRuntime dirichletRuntime = DirichletRuntime.getInstance();
        if (this.mCoreRuntimeStarted && dirichletRuntime.isReady()) {
            dirichletRuntime.setForceEmbeddedBundleIds(this.mForceEmbeddedBundleIds);
            dirichletRuntime.setRecoveryBaselineBundleIds(this.mRecoveryBaselineBundleIds);
            return true;
        }
        Context contextApplicationContext = applicationContext(context);
        if (contextApplicationContext == null) {
            return false;
        }
        RuntimeDelivery runtimeDeliveryResolveRuntimeDelivery = resolveRuntimeDelivery(contextApplicationContext);
        Set<String> setEffectiveForceEmbedded = effectiveForceEmbedded(runtimeDeliveryResolveRuntimeDelivery);
        this.mForceEmbeddedBundleIds = setEffectiveForceEmbedded;
        this.mRecoveryBaselineBundleIds = (!evaluateRecoverySessionOnce(contextApplicationContext) || setEffectiveForceEmbedded.contains("core")) ? Collections.EMPTY_SET : Collections.singleton("core");
        if (runtimeDeliveryResolveRuntimeDelivery.known && !runtimeDeliveryResolveRuntimeDelivery.enabled) {
            discardForcedCachedBundles(contextApplicationContext, setEffectiveForceEmbedded);
        }
        try {
            dirichletRuntime.setForceEmbeddedBundleIds(setEffectiveForceEmbedded);
            dirichletRuntime.setRecoveryBaselineBundleIds(this.mRecoveryBaselineBundleIds);
            dirichletRuntime.init(contextApplicationContext);
            this.mCoreRuntimeStarted = dirichletRuntime.isReady();
            boolean z = this.mCoreRuntimeStarted;
            if (runtimeDeliveryResolveRuntimeDelivery.known && runtimeDeliveryResolveRuntimeDelivery.enabled) {
                kickoffCachedManifestUpdateOnce(contextApplicationContext, runtimeDeliveryResolveRuntimeDelivery, setEffectiveForceEmbedded);
            }
            return z;
        } catch (Throwable th) {
            if (runtimeDeliveryResolveRuntimeDelivery.known && runtimeDeliveryResolveRuntimeDelivery.enabled) {
                kickoffCachedManifestUpdateOnce(contextApplicationContext, runtimeDeliveryResolveRuntimeDelivery, setEffectiveForceEmbedded);
            }
            return false;
        }
    }

    public boolean evaluateRecoverySessionOnce(Context context) {
        synchronized (this) {
            if (this.mRecoverySessionEvaluated) {
                return this.mRecoverySessionRequired;
            }
            try {
                this.mRecoverySessionRequired = this.mRecoverySessionEvaluator.shouldRecover(context);
            } catch (Throwable th) {
                this.mRecoverySessionRequired = false;
            }
            this.mRecoverySessionEvaluated = true;
            return this.mRecoverySessionRequired;
        }
    }

    public void kickoffCachedManifestUpdateOnce(Context context, RuntimeDelivery runtimeDelivery, Set<String> set) {
        synchronized (this) {
            if (this.mCachedManifestUpdateStarted) {
                return;
            }
            this.mCachedManifestUpdateStarted = true;
            try {
                kickoffBundleUpdate(context, runtimeDelivery, set);
            } catch (Throwable th) {
                synchronized (this) {
                    this.mCachedManifestUpdateStarted = false;
                }
            }
        }
    }

    public void refreshFromAdnPlatformEffects(Context context) {
        if (usesAdnRuntimeDelivery(2)) {
            synchronized (this.mRuntimeDeliveryLock) {
                recordFreshDeliveryCheck(context);
                applyRuntimeDelivery(context, resolveRuntimeDelivery(applicationContext(context)));
            }
        }
    }

    public void refreshFromMediationPlatformEffects(Context context, JSONObject jSONObject, boolean z) {
        if (jSONObject == null || !usesMediationRuntimeDelivery(2)) {
            return;
        }
        synchronized (this.mRuntimeDeliveryLock) {
            RuntimeDelivery runtimeDelivery = RuntimeDelivery.parse(jSONObject);
            if (runtimeDelivery.known) {
                this.mMediationRuntimeDelivery = runtimeDelivery;
                this.mMediationRuntimeDeliveryObserved = true;
                JSONObject json = runtimeDelivery.toJson();
                if (json != null) {
                    RuntimeDeliveryStore.write(context, json);
                }
                if (z) {
                    recordFreshDeliveryCheck(context);
                }
                applyRuntimeDelivery(context, this.mMediationRuntimeDelivery);
            }
        }
    }

    public RuntimeDelivery resolveRuntimeDelivery(Context context) {
        if (!usesMediationRuntimeDelivery(2)) {
            return usesAdnRuntimeDelivery(2) ? RuntimeDelivery.parse(AdnPlatformStateStore.get().runtimeDelivery()) : RuntimeDelivery.unknown();
        }
        if (this.mMediationRuntimeDeliveryObserved) {
            return this.mMediationRuntimeDelivery;
        }
        RuntimeDelivery runtimeDelivery = RuntimeDelivery.parse(RuntimeDeliveryStore.read(context));
        return runtimeDelivery.known ? runtimeDelivery : RuntimeDelivery.unknown();
    }

    public WasmRuntimeController(BundleUpdateStarter bundleUpdateStarter) {
        this(bundleUpdateStarter, new RecoverySessionEvaluator() { // from class: com.tapsdk.tapad.internal.runtime.WasmRuntimeController$$ExternalSyntheticLambda2
            @Override // com.tapsdk.tapad.internal.runtime.WasmRuntimeController.RecoverySessionEvaluator
            public final boolean shouldRecover(Context context) {
                return WasmRuntimeController.shouldRecoverDelivery(context);
            }
        });
    }

    public WasmRuntimeController(BundleUpdateStarter bundleUpdateStarter, RecoverySessionEvaluator recoverySessionEvaluator) {
        this.mForceEmbeddedBundleIds = Collections.singleton("core");
        this.mRecoveryBaselineBundleIds = Collections.EMPTY_SET;
        this.mMediationRuntimeDelivery = RuntimeDelivery.unknown();
        this.mRuntimeDeliveryLock = new Object();
        this.mBundleUpdateStarter = bundleUpdateStarter;
        this.mRecoverySessionEvaluator = recoverySessionEvaluator;
    }
}
