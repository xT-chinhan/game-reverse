package com.tapsdk.tapad.internal.runtime.bundle;

import android.content.Context;
import android.text.TextUtils;
import com.tapsdk.tapad.a;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class BundleRegistry {
    static final long DELIVERY_RECOVERY_AFTER_GENERATIONS = 3;
    static final long DELIVERY_RECOVERY_AFTER_MS = 604800000;
    static final long FAILED_RETRY_TTL_MS = 86400000;
    private static final String KEY_SESSION_GENERATION = "host.session_generation";
    private static final String SUFFIX_ACTIVATION_ATTEMPT = ".activation_attempt";
    private static final String SUFFIX_ACTIVE = ".active_version";
    private static final String SUFFIX_CURRENT = ".current_version";
    private static final String SUFFIX_DELIVERY_SUCCESS_AT = ".delivery_success_at";
    private static final String SUFFIX_DELIVERY_SUCCESS_GENERATION = ".delivery_success_generation";
    private static final String SUFFIX_EXTERNAL_ACTIVATED_AT = ".external_activated_at";
    private static final String SUFFIX_EXTERNAL_ACTIVATED_GENERATION = ".external_activated_generation";
    private static final String SUFFIX_FAILED = ".failed_versions";
    private static final String SUFFIX_FAILED_AT = ".failed_at.";
    private static final String SUFFIX_FLOOR = ".floor";
    private static final String SUFFIX_PREVIOUS = ".previous_version";
    private static final String SUFFIX_PROMOTION = ".promotion_version";
    private static final String SUFFIX_PROMOTION_OLD_CURRENT = ".promotion_old_current";
    private static final String SUFFIX_STAGED = ".staged_version";
    private static final String TAG = "BundleRegistry";
    private final Clock clock;
    private final BundleRegistryStore store;

    public interface Clock {
        long nowMillis();
    }

    private BundleRegistry(Context context) {
        this(context, new Clock() { // from class: com.tapsdk.tapad.internal.runtime.bundle.BundleRegistry$$ExternalSyntheticLambda21
            @Override // com.tapsdk.tapad.internal.runtime.bundle.BundleRegistry.Clock
            public final long nowMillis() {
                return System.currentTimeMillis();
            }
        });
    }

    private static long activationAttempt(BundleRegistryStore.State state, String str) {
        return state.getLong(a.a(str, SUFFIX_ACTIVATION_ATTEMPT), 0L);
    }

    private static long active(BundleRegistryStore.State state, String str) {
        long j = state.getLong(a.a(str, SUFFIX_ACTIVE), 0L);
        if (j > 0) {
            return j;
        }
        long jCurrent = current(state, str);
        return jCurrent > 0 ? jCurrent : floor(state, str);
    }

    public static void clearForTests(Context context) {
        new BundleRegistryStore(context).clearForTests();
    }

    private static long current(BundleRegistryStore.State state, String str) {
        return state.getLong(a.a(str, SUFFIX_CURRENT), 0L);
    }

    private static String failedAtKey(String str, long j) {
        return str + SUFFIX_FAILED_AT + j;
    }

    private static long floor(BundleRegistryStore.State state, String str) {
        return state.getLong(a.a(str, SUFFIX_FLOOR), 0L);
    }

    public static BundleRegistry get(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        return new BundleRegistry(context);
    }

    static /* synthetic */ Boolean lambda$beginActivationAttempt$10(String str, long j, BundleRegistryStore.State state) {
        state.putLong(a.a(str, SUFFIX_ACTIVATION_ATTEMPT), j);
        state.remove(a.a(str, SUFFIX_PROMOTION));
        state.remove(a.a(str, SUFFIX_PROMOTION_OLD_CURRENT));
        return Boolean.TRUE;
    }

    static /* synthetic */ Boolean lambda$beginPromotion$11(String str, long j, long j2, BundleRegistryStore.State state) {
        if (activationAttempt(state, str) != j) {
            return Boolean.FALSE;
        }
        state.putLong(a.a(str, SUFFIX_PROMOTION), j);
        state.putLong(a.a(str, SUFFIX_PROMOTION_OLD_CURRENT), Math.max(0L, j2));
        return Boolean.TRUE;
    }

    static /* synthetic */ Object lambda$clearActivationAttempt$16(String str, BundleRegistryStore.State state) {
        state.remove(a.a(str, SUFFIX_ACTIVATION_ATTEMPT));
        state.remove(a.a(str, SUFFIX_PROMOTION));
        state.remove(a.a(str, SUFFIX_PROMOTION_OLD_CURRENT));
        return null;
    }

    static /* synthetic */ Object lambda$clearExternalSlots$17(String str, BundleRegistryStore.State state) {
        state.remove(a.a(str, SUFFIX_ACTIVE));
        state.remove(a.a(str, SUFFIX_CURRENT));
        state.remove(a.a(str, SUFFIX_PREVIOUS));
        state.remove(a.a(str, SUFFIX_STAGED));
        state.remove(a.a(str, SUFFIX_ACTIVATION_ATTEMPT));
        state.remove(a.a(str, SUFFIX_PROMOTION));
        state.remove(a.a(str, SUFFIX_PROMOTION_OLD_CURRENT));
        state.remove(a.a(str, SUFFIX_EXTERNAL_ACTIVATED_GENERATION));
        state.remove(a.a(str, SUFFIX_EXTERNAL_ACTIVATED_AT));
        state.remove(a.a(str, SUFFIX_DELIVERY_SUCCESS_GENERATION));
        state.remove(a.a(str, SUFFIX_DELIVERY_SUCCESS_AT));
        return null;
    }

    static /* synthetic */ Object lambda$clearStaged$9(String str, BundleRegistryStore.State state) {
        state.remove(a.a(str, SUFFIX_STAGED));
        return null;
    }

    static /* synthetic */ Object lambda$recordLegacyCurrent$15(String str, long j, BundleRegistryStore.State state) {
        state.putLong(a.a(str, SUFFIX_CURRENT), j);
        state.putLong(a.a(str, SUFFIX_ACTIVE), j);
        if (j <= floor(state, str)) {
            return null;
        }
        state.putLong(a.a(str, SUFFIX_FLOOR), j);
        return null;
    }

    static /* synthetic */ Object lambda$recordSelected$14(String str, long j, BundleRegistryStore.State state) {
        state.putLong(a.a(str, SUFFIX_ACTIVE), j);
        return null;
    }

    static /* synthetic */ Object lambda$recordStaged$8(String str, long j, BundleRegistryStore.State state) {
        if (j <= Math.max(Math.max(current(state, str), staged(state, str)), floor(state, str))) {
            return null;
        }
        state.putLong(a.a(str, SUFFIX_STAGED), j);
        return null;
    }

    private static Set<String> loadFailed(BundleRegistryStore.State state, String str) {
        return new HashSet(state.getStringSet(a.a(str, SUFFIX_FAILED)));
    }

    private static long previous(BundleRegistryStore.State state, String str) {
        return state.getLong(a.a(str, SUFFIX_PREVIOUS), 0L);
    }

    private static long promotion(BundleRegistryStore.State state, String str) {
        return state.getLong(a.a(str, SUFFIX_PROMOTION), 0L);
    }

    private static long promotionOldCurrent(BundleRegistryStore.State state, String str) {
        return state.getLong(a.a(str, SUFFIX_PROMOTION_OLD_CURRENT), 0L);
    }

    private static void safeWarn(String str) {
    }

    private static long staged(BundleRegistryStore.State state, String str) {
        return state.getLong(a.a(str, SUFFIX_STAGED), 0L);
    }

    public boolean abortPromotionToCurrent(final String str, final long j, final long j2) {
        if (j <= 0 || j2 <= 0) {
            return false;
        }
        return ((Boolean) this.store.update(new BundleRegistryStore.Operation() { // from class: com.tapsdk.tapad.internal.runtime.bundle.BundleRegistry$$ExternalSyntheticLambda17
            @Override // com.tapsdk.tapad.internal.runtime.bundle.BundleRegistryStore.Operation
            public final Object run(BundleRegistryStore.State state) {
                return this.f$0.m259lambda$abortPromotionToCurrent$13$comtapsdktapadinternalruntimebundleBundleRegistry(str, j, j2, state);
            }
        }, Boolean.FALSE)).booleanValue();
    }

    public boolean beginActivationAttempt(final String str, final long j) {
        if (j <= 0) {
            return false;
        }
        return ((Boolean) this.store.update(new BundleRegistryStore.Operation() { // from class: com.tapsdk.tapad.internal.runtime.bundle.BundleRegistry$$ExternalSyntheticLambda19
            @Override // com.tapsdk.tapad.internal.runtime.bundle.BundleRegistryStore.Operation
            public final Object run(BundleRegistryStore.State state) {
                return BundleRegistry.lambda$beginActivationAttempt$10(str, j, state);
            }
        }, Boolean.FALSE)).booleanValue();
    }

    public boolean beginPromotion(final String str, final long j, final long j2) {
        if (j <= 0) {
            return false;
        }
        return ((Boolean) this.store.update(new BundleRegistryStore.Operation() { // from class: com.tapsdk.tapad.internal.runtime.bundle.BundleRegistry$$ExternalSyntheticLambda3
            @Override // com.tapsdk.tapad.internal.runtime.bundle.BundleRegistryStore.Operation
            public final Object run(BundleRegistryStore.State state) {
                return BundleRegistry.lambda$beginPromotion$11(str, j, j2, state);
            }
        }, Boolean.FALSE)).booleanValue();
    }

    public boolean beginSessionAndShouldRecoverDelivery(final String str, final boolean z) {
        return ((Boolean) this.store.update(new BundleRegistryStore.Operation() { // from class: com.tapsdk.tapad.internal.runtime.bundle.BundleRegistry$$ExternalSyntheticLambda2
            @Override // com.tapsdk.tapad.internal.runtime.bundle.BundleRegistryStore.Operation
            public final Object run(BundleRegistryStore.State state) {
                return this.f$0.m260lambda$beginSessionAndShouldRecoverDelivery$18$comtapsdktapadinternalruntimebundleBundleRegistry(z, str, state);
            }
        }, Boolean.FALSE)).booleanValue();
    }

    public void clearActivationAttempt(final String str) {
        this.store.update(new BundleRegistryStore.Operation() { // from class: com.tapsdk.tapad.internal.runtime.bundle.BundleRegistry$$ExternalSyntheticLambda14
            @Override // com.tapsdk.tapad.internal.runtime.bundle.BundleRegistryStore.Operation
            public final Object run(BundleRegistryStore.State state) {
                return BundleRegistry.lambda$clearActivationAttempt$16(str, state);
            }
        }, null);
    }

    public void clearExternalSlots(final String str) {
        this.store.update(new BundleRegistryStore.Operation() { // from class: com.tapsdk.tapad.internal.runtime.bundle.BundleRegistry$$ExternalSyntheticLambda13
            @Override // com.tapsdk.tapad.internal.runtime.bundle.BundleRegistryStore.Operation
            public final Object run(BundleRegistryStore.State state) {
                return BundleRegistry.lambda$clearExternalSlots$17(str, state);
            }
        }, null);
    }

    public void clearStaged(final String str) {
        this.store.update(new BundleRegistryStore.Operation() { // from class: com.tapsdk.tapad.internal.runtime.bundle.BundleRegistry$$ExternalSyntheticLambda15
            @Override // com.tapsdk.tapad.internal.runtime.bundle.BundleRegistryStore.Operation
            public final Object run(BundleRegistryStore.State state) {
                return BundleRegistry.lambda$clearStaged$9(str, state);
            }
        }, null);
    }

    public boolean completePromotion(final String str, final long j, final long j2) {
        if (j <= 0) {
            return false;
        }
        return ((Boolean) this.store.update(new BundleRegistryStore.Operation() { // from class: com.tapsdk.tapad.internal.runtime.bundle.BundleRegistry$$ExternalSyntheticLambda8
            @Override // com.tapsdk.tapad.internal.runtime.bundle.BundleRegistryStore.Operation
            public final Object run(BundleRegistryStore.State state) {
                return this.f$0.m261lambda$completePromotion$12$comtapsdktapadinternalruntimebundleBundleRegistry(str, j, j2, state);
            }
        }, Boolean.FALSE)).booleanValue();
    }

    public long getActivationAttemptVersion(final String str) {
        return ((Long) this.store.read(new BundleRegistryStore.Operation() { // from class: com.tapsdk.tapad.internal.runtime.bundle.BundleRegistry$$ExternalSyntheticLambda24
            @Override // com.tapsdk.tapad.internal.runtime.bundle.BundleRegistryStore.Operation
            public final Object run(BundleRegistryStore.State state) {
                return Long.valueOf(BundleRegistry.activationAttempt(state, str));
            }
        }, 0L)).longValue();
    }

    public long getActiveBundleVersionCode(final String str) {
        return ((Long) this.store.read(new BundleRegistryStore.Operation() { // from class: com.tapsdk.tapad.internal.runtime.bundle.BundleRegistry$$ExternalSyntheticLambda6
            @Override // com.tapsdk.tapad.internal.runtime.bundle.BundleRegistryStore.Operation
            public final Object run(BundleRegistryStore.State state) {
                return Long.valueOf(BundleRegistry.active(state, str));
            }
        }, 0L)).longValue();
    }

    public long getCurrentBundleVersionCode(final String str) {
        return ((Long) this.store.read(new BundleRegistryStore.Operation() { // from class: com.tapsdk.tapad.internal.runtime.bundle.BundleRegistry$$ExternalSyntheticLambda11
            @Override // com.tapsdk.tapad.internal.runtime.bundle.BundleRegistryStore.Operation
            public final Object run(BundleRegistryStore.State state) {
                return Long.valueOf(BundleRegistry.current(state, str));
            }
        }, 0L)).longValue();
    }

    public String getDownloadSkipReason(final BundleManifest bundleManifest) {
        if (bundleManifest == null) {
            return "invalid_manifest";
        }
        return TextUtils.isEmpty(bundleManifest.url) ? "missing_url" : (String) this.store.update(new BundleRegistryStore.Operation() { // from class: com.tapsdk.tapad.internal.runtime.bundle.BundleRegistry$$ExternalSyntheticLambda23
            @Override // com.tapsdk.tapad.internal.runtime.bundle.BundleRegistryStore.Operation
            public final Object run(BundleRegistryStore.State state) {
                return this.f$0.m262lambda$getDownloadSkipReason$22$comtapsdktapadinternalruntimebundleBundleRegistry(bundleManifest, state);
            }
        }, "registry_unavailable");
    }

    public long getFloor(final String str) {
        return ((Long) this.store.read(new BundleRegistryStore.Operation() { // from class: com.tapsdk.tapad.internal.runtime.bundle.BundleRegistry$$ExternalSyntheticLambda10
            @Override // com.tapsdk.tapad.internal.runtime.bundle.BundleRegistryStore.Operation
            public final Object run(BundleRegistryStore.State state) {
                return Long.valueOf(BundleRegistry.floor(state, str));
            }
        }, 0L)).longValue();
    }

    public long getPreviousBundleVersionCode(final String str) {
        return ((Long) this.store.read(new BundleRegistryStore.Operation() { // from class: com.tapsdk.tapad.internal.runtime.bundle.BundleRegistry$$ExternalSyntheticLambda5
            @Override // com.tapsdk.tapad.internal.runtime.bundle.BundleRegistryStore.Operation
            public final Object run(BundleRegistryStore.State state) {
                return Long.valueOf(BundleRegistry.previous(state, str));
            }
        }, 0L)).longValue();
    }

    public long getPromotionOldCurrentVersion(final String str) {
        return ((Long) this.store.read(new BundleRegistryStore.Operation() { // from class: com.tapsdk.tapad.internal.runtime.bundle.BundleRegistry$$ExternalSyntheticLambda7
            @Override // com.tapsdk.tapad.internal.runtime.bundle.BundleRegistryStore.Operation
            public final Object run(BundleRegistryStore.State state) {
                return Long.valueOf(BundleRegistry.promotionOldCurrent(state, str));
            }
        }, 0L)).longValue();
    }

    public long getPromotionVersion(final String str) {
        return ((Long) this.store.read(new BundleRegistryStore.Operation() { // from class: com.tapsdk.tapad.internal.runtime.bundle.BundleRegistry$$ExternalSyntheticLambda1
            @Override // com.tapsdk.tapad.internal.runtime.bundle.BundleRegistryStore.Operation
            public final Object run(BundleRegistryStore.State state) {
                return Long.valueOf(BundleRegistry.promotion(state, str));
            }
        }, 0L)).longValue();
    }

    public long getStagedBundleVersionCode(final String str) {
        return ((Long) this.store.read(new BundleRegistryStore.Operation() { // from class: com.tapsdk.tapad.internal.runtime.bundle.BundleRegistry$$ExternalSyntheticLambda9
            @Override // com.tapsdk.tapad.internal.runtime.bundle.BundleRegistryStore.Operation
            public final Object run(BundleRegistryStore.State state) {
                return Long.valueOf(BundleRegistry.staged(state, str));
            }
        }, 0L)).longValue();
    }

    public boolean isFailed(final String str, final long j) {
        if (j <= 0) {
            return false;
        }
        return ((Boolean) this.store.update(new BundleRegistryStore.Operation() { // from class: com.tapsdk.tapad.internal.runtime.bundle.BundleRegistry$$ExternalSyntheticLambda18
            @Override // com.tapsdk.tapad.internal.runtime.bundle.BundleRegistryStore.Operation
            public final Object run(BundleRegistryStore.State state) {
                return this.f$0.m263lambda$isFailed$20$comtapsdktapadinternalruntimebundleBundleRegistry(str, j, state);
            }
        }, Boolean.FALSE)).booleanValue();
    }

    /* JADX INFO: renamed from: lambda$abortPromotionToCurrent$13$com-tapsdk-tapad-internal-runtime-bundle-BundleRegistry, reason: not valid java name */
    /* synthetic */ Boolean m259lambda$abortPromotionToCurrent$13$comtapsdktapadinternalruntimebundleBundleRegistry(String str, long j, long j2, BundleRegistryStore.State state) {
        Set<String> setLoadFailed = loadFailed(state, str);
        setLoadFailed.add(Long.toString(j));
        state.putStringSet(str + SUFFIX_FAILED, setLoadFailed);
        state.putLong(failedAtKey(str, j), this.clock.nowMillis());
        state.putLong(a.a(str, SUFFIX_CURRENT), j2);
        state.putLong(a.a(str, SUFFIX_ACTIVE), j2);
        state.remove(a.a(str, SUFFIX_PREVIOUS));
        state.remove(a.a(str, SUFFIX_STAGED));
        state.remove(a.a(str, SUFFIX_ACTIVATION_ATTEMPT));
        state.remove(a.a(str, SUFFIX_PROMOTION));
        state.remove(a.a(str, SUFFIX_PROMOTION_OLD_CURRENT));
        return Boolean.TRUE;
    }

    /* JADX INFO: renamed from: lambda$beginSessionAndShouldRecoverDelivery$18$com-tapsdk-tapad-internal-runtime-bundle-BundleRegistry, reason: not valid java name */
    /* synthetic */ Boolean m260lambda$beginSessionAndShouldRecoverDelivery$18$comtapsdktapadinternalruntimebundleBundleRegistry(boolean z, String str, BundleRegistryStore.State state) {
        String str2;
        String str3;
        long jSessionGeneration = sessionGeneration(state) + 1;
        state.putLong(KEY_SESSION_GENERATION, jSessionGeneration);
        if (!z) {
            return Boolean.FALSE;
        }
        long j = state.getLong(a.a(str, SUFFIX_EXTERNAL_ACTIVATED_GENERATION), 0L);
        long j2 = state.getLong(a.a(str, SUFFIX_EXTERNAL_ACTIVATED_AT), 0L);
        long jNowMillis = this.clock.nowMillis();
        if (j > 0) {
            str2 = SUFFIX_EXTERNAL_ACTIVATED_GENERATION;
            str3 = SUFFIX_EXTERNAL_ACTIVATED_AT;
            if (j2 > 0 && jNowMillis >= j2) {
                long j3 = state.getLong(a.a(str, SUFFIX_DELIVERY_SUCCESS_GENERATION), 0L);
                long j4 = state.getLong(a.a(str, SUFFIX_DELIVERY_SUCCESS_AT), 0L);
                if (j3 >= j) {
                    j = j3;
                }
                if (j3 >= j && j4 > 0) {
                    j2 = j4;
                }
                return Boolean.valueOf(jSessionGeneration - j >= 3 && jNowMillis >= j2 && jNowMillis - j2 >= DELIVERY_RECOVERY_AFTER_MS);
            }
        } else {
            str2 = SUFFIX_EXTERNAL_ACTIVATED_GENERATION;
            str3 = SUFFIX_EXTERNAL_ACTIVATED_AT;
        }
        state.putLong(a.a(str, str2), jSessionGeneration);
        state.putLong(a.a(str, str3), jNowMillis);
        state.remove(a.a(str, SUFFIX_DELIVERY_SUCCESS_GENERATION));
        state.remove(a.a(str, SUFFIX_DELIVERY_SUCCESS_AT));
        return Boolean.FALSE;
    }

    /* JADX INFO: renamed from: lambda$completePromotion$12$com-tapsdk-tapad-internal-runtime-bundle-BundleRegistry, reason: not valid java name */
    /* synthetic */ Boolean m261lambda$completePromotion$12$comtapsdktapadinternalruntimebundleBundleRegistry(String str, long j, long j2, BundleRegistryStore.State state) {
        state.putLong(a.a(str, SUFFIX_CURRENT), j);
        state.putLong(a.a(str, SUFFIX_ACTIVE), j);
        state.remove(a.a(str, SUFFIX_ACTIVATION_ATTEMPT));
        state.remove(a.a(str, SUFFIX_PROMOTION));
        state.remove(a.a(str, SUFFIX_PROMOTION_OLD_CURRENT));
        if (j2 > 0) {
            state.putLong(a.a(str, SUFFIX_PREVIOUS), j2);
        } else if (previous(state, str) <= 0) {
            state.remove(a.a(str, SUFFIX_PREVIOUS));
        }
        if (staged(state, str) <= j) {
            state.remove(a.a(str, SUFFIX_STAGED));
        }
        if (j > floor(state, str)) {
            state.putLong(a.a(str, SUFFIX_FLOOR), j);
        }
        state.putLong(a.a(str, SUFFIX_EXTERNAL_ACTIVATED_GENERATION), sessionGeneration(state));
        state.putLong(a.a(str, SUFFIX_EXTERNAL_ACTIVATED_AT), this.clock.nowMillis());
        state.remove(a.a(str, SUFFIX_DELIVERY_SUCCESS_GENERATION));
        state.remove(a.a(str, SUFFIX_DELIVERY_SUCCESS_AT));
        return Boolean.TRUE;
    }

    /* JADX INFO: renamed from: lambda$getDownloadSkipReason$22$com-tapsdk-tapad-internal-runtime-bundle-BundleRegistry, reason: not valid java name */
    /* synthetic */ String m262lambda$getDownloadSkipReason$22$comtapsdktapadinternalruntimebundleBundleRegistry(BundleManifest bundleManifest, BundleRegistryStore.State state) {
        long j = bundleManifest.bundleVersionCode;
        if (j <= Math.max(Math.max(current(state, bundleManifest.id), staged(state, bundleManifest.id)), floor(state, bundleManifest.id))) {
            return "not_newer";
        }
        if (!isFailed(state, bundleManifest.id, j, this.clock.nowMillis())) {
            return null;
        }
        safeWarn("skip " + bundleManifest.id + " v" + j + ": previously failed");
        return "recent_failed";
    }

    /* JADX INFO: renamed from: lambda$isFailed$20$com-tapsdk-tapad-internal-runtime-bundle-BundleRegistry, reason: not valid java name */
    /* synthetic */ Boolean m263lambda$isFailed$20$comtapsdktapadinternalruntimebundleBundleRegistry(String str, long j, BundleRegistryStore.State state) {
        return Boolean.valueOf(isFailed(state, str, j, this.clock.nowMillis()));
    }

    /* JADX INFO: renamed from: lambda$recordDeliveryCheckSuccessful$19$com-tapsdk-tapad-internal-runtime-bundle-BundleRegistry, reason: not valid java name */
    /* synthetic */ Object m264lambda$recordDeliveryCheckSuccessful$19$comtapsdktapadinternalruntimebundleBundleRegistry(String str, BundleRegistryStore.State state) {
        state.putLong(a.a(str, SUFFIX_DELIVERY_SUCCESS_GENERATION), sessionGeneration(state));
        state.putLong(a.a(str, SUFFIX_DELIVERY_SUCCESS_AT), this.clock.nowMillis());
        return null;
    }

    /* JADX INFO: renamed from: lambda$recordFailed$21$com-tapsdk-tapad-internal-runtime-bundle-BundleRegistry, reason: not valid java name */
    /* synthetic */ Object m265lambda$recordFailed$21$comtapsdktapadinternalruntimebundleBundleRegistry(String str, long j, BundleRegistryStore.State state) {
        Set<String> setLoadFailed = loadFailed(state, str);
        setLoadFailed.add(Long.toString(j));
        state.putStringSet(str + SUFFIX_FAILED, setLoadFailed);
        state.putLong(failedAtKey(str, j), this.clock.nowMillis());
        if (j == staged(state, str)) {
            state.remove(a.a(str, SUFFIX_STAGED));
        }
        if (j != activationAttempt(state, str) && j != promotion(state, str)) {
            return null;
        }
        state.remove(a.a(str, SUFFIX_ACTIVATION_ATTEMPT));
        state.remove(a.a(str, SUFFIX_PROMOTION));
        state.remove(a.a(str, SUFFIX_PROMOTION_OLD_CURRENT));
        return null;
    }

    public void recordDeliveryCheckSuccessful(final String str) {
        this.store.update(new BundleRegistryStore.Operation() { // from class: com.tapsdk.tapad.internal.runtime.bundle.BundleRegistry$$ExternalSyntheticLambda4
            @Override // com.tapsdk.tapad.internal.runtime.bundle.BundleRegistryStore.Operation
            public final Object run(BundleRegistryStore.State state) {
                return this.f$0.m264lambda$recordDeliveryCheckSuccessful$19$comtapsdktapadinternalruntimebundleBundleRegistry(str, state);
            }
        }, null);
    }

    public void recordFailed(final String str, final long j) {
        if (j <= 0) {
            return;
        }
        this.store.update(new BundleRegistryStore.Operation() { // from class: com.tapsdk.tapad.internal.runtime.bundle.BundleRegistry$$ExternalSyntheticLambda0
            @Override // com.tapsdk.tapad.internal.runtime.bundle.BundleRegistryStore.Operation
            public final Object run(BundleRegistryStore.State state) {
                return this.f$0.m265lambda$recordFailed$21$comtapsdktapadinternalruntimebundleBundleRegistry(str, j, state);
            }
        }, null);
    }

    public void recordLegacyCurrent(final String str, final long j) {
        if (j <= 0) {
            return;
        }
        this.store.update(new BundleRegistryStore.Operation() { // from class: com.tapsdk.tapad.internal.runtime.bundle.BundleRegistry$$ExternalSyntheticLambda22
            @Override // com.tapsdk.tapad.internal.runtime.bundle.BundleRegistryStore.Operation
            public final Object run(BundleRegistryStore.State state) {
                return BundleRegistry.lambda$recordLegacyCurrent$15(str, j, state);
            }
        }, null);
    }

    public void recordSelected(final String str, final long j) {
        if (j <= 0) {
            return;
        }
        this.store.update(new BundleRegistryStore.Operation() { // from class: com.tapsdk.tapad.internal.runtime.bundle.BundleRegistry$$ExternalSyntheticLambda16
            @Override // com.tapsdk.tapad.internal.runtime.bundle.BundleRegistryStore.Operation
            public final Object run(BundleRegistryStore.State state) {
                return BundleRegistry.lambda$recordSelected$14(str, j, state);
            }
        }, null);
    }

    public void recordStaged(final String str, final long j) {
        this.store.update(new BundleRegistryStore.Operation() { // from class: com.tapsdk.tapad.internal.runtime.bundle.BundleRegistry$$ExternalSyntheticLambda20
            @Override // com.tapsdk.tapad.internal.runtime.bundle.BundleRegistryStore.Operation
            public final Object run(BundleRegistryStore.State state) {
                return BundleRegistry.lambda$recordStaged$8(str, j, state);
            }
        }, null);
    }

    public void recordVerified(String str, long j) {
        recordLegacyCurrent(str, j);
    }

    public long sessionGeneration() {
        return ((Long) this.store.read(new BundleRegistryStore.Operation() { // from class: com.tapsdk.tapad.internal.runtime.bundle.BundleRegistry$$ExternalSyntheticLambda12
            @Override // com.tapsdk.tapad.internal.runtime.bundle.BundleRegistryStore.Operation
            public final Object run(BundleRegistryStore.State state) {
                return Long.valueOf(BundleRegistry.sessionGeneration(state));
            }
        }, 0L)).longValue();
    }

    public boolean shouldDownload(BundleManifest bundleManifest) {
        return getDownloadSkipReason(bundleManifest) == null;
    }

    public BundleRegistry(Context context, Clock clock) {
        this.store = new BundleRegistryStore(context);
        this.clock = clock;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long sessionGeneration(BundleRegistryStore.State state) {
        return state.getLong(KEY_SESSION_GENERATION, 0L);
    }

    private static boolean isFailed(BundleRegistryStore.State state, String str, long j, long j2) {
        String string = Long.toString(j);
        Set<String> setLoadFailed = loadFailed(state, str);
        if (!setLoadFailed.contains(string)) {
            return false;
        }
        String strFailedAtKey = failedAtKey(str, j);
        long j3 = state.getLong(strFailedAtKey, 0L);
        if (j3 > 0 && j2 >= j3 && j2 - j3 < 86400000) {
            return true;
        }
        setLoadFailed.remove(string);
        state.remove(strFailedAtKey);
        if (setLoadFailed.isEmpty()) {
            state.remove(a.a(str, SUFFIX_FAILED));
        } else {
            state.putStringSet(a.a(str, SUFFIX_FAILED), setLoadFailed);
        }
        return false;
    }
}
