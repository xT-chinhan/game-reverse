package com.tapsdk.tapad.internal.runtime;

import com.tapsdk.tapad.TapAdCustomController;
import com.tapsdk.tapad.group.ads.DirichletAd$$ExternalSyntheticBackportWithForwarding0;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class AndroidPrivacyPolicy {
    private static volatile TapAdCustomController controller;
    private static final AtomicReference<PolicyState> state = new AtomicReference<>(new PolicyState(false, CollectionPolicy.DEFAULT));
    private static final CopyOnWriteArrayList<Runnable> listeners = new CopyOnWriteArrayList<>();
    private static final AtomicLong oaidGeneration = new AtomicLong();

    public static final class CollectionPolicy {
        static final CollectionPolicy DEFAULT = new CollectionPolicy(null);
        final boolean androidId;
        final boolean bssid;
        final boolean installedApps;
        final long intervalMs;
        final boolean location;
        final boolean oaid;
        final boolean sensor;
        final boolean ssid;

        public CollectionPolicy(JSONObject jSONObject) {
            this.bssid = enabled(jSONObject, "collect_bssid");
            this.ssid = enabled(jSONObject, "collect_ssid");
            this.installedApps = enabled(jSONObject, "collect_installed_apps");
            this.sensor = enabled(jSONObject, "collect_sensor");
            this.location = enabled(jSONObject, "collect_location");
            this.androidId = enabled(jSONObject, "collect_android_id");
            this.oaid = enabled(jSONObject, "collect_oaid");
            Object objOpt = jSONObject == null ? null : jSONObject.opt("collection_interval_ms");
            long jLongValue = ((objOpt instanceof Integer) || (objOpt instanceof Long)) ? ((Number) objOpt).longValue() : 0L;
            this.intervalMs = jLongValue <= 0 ? 60000L : jLongValue;
        }

        private static boolean enabled(JSONObject jSONObject, String str) {
            return jSONObject == null || !jSONObject.has(str) || Boolean.TRUE.equals(jSONObject.opt(str));
        }

        public boolean sameAs(CollectionPolicy collectionPolicy) {
            return this.bssid == collectionPolicy.bssid && this.ssid == collectionPolicy.ssid && this.installedApps == collectionPolicy.installedApps && this.sensor == collectionPolicy.sensor && this.location == collectionPolicy.location && this.androidId == collectionPolicy.androidId && this.oaid == collectionPolicy.oaid && this.intervalMs == collectionPolicy.intervalMs;
        }
    }

    public static final class PolicyState {
        final CollectionPolicy collection;
        final boolean mediation;

        public PolicyState(boolean z, CollectionPolicy collectionPolicy) {
            this.mediation = z;
            this.collection = collectionPolicy;
        }
    }

    private AndroidPrivacyPolicy() {
    }

    public static void addListener(Runnable runnable) {
        if (runnable != null) {
            listeners.addIfAbsent(runnable);
        }
    }

    /* JADX WARN: Code duplicated, block: B:9:0x000f  */
    public static boolean allowsAndroidId() {
        boolean z;
        TapAdCustomController tapAdCustomController = controller;
        if (tapAdCustomController != null) {
            try {
                if (tapAdCustomController.isCanUseAndroidId()) {
                    z = true;
                } else {
                    z = false;
                }
            } catch (Throwable th) {
                return false;
            }
        } else {
            z = false;
        }
        return allowsAndroidId(z);
    }

    public static boolean allowsBssid() {
        TapAdCustomController tapAdCustomController = controller;
        try {
            return state.get().collection.bssid && tapAdCustomController != null && tapAdCustomController.isCanUseWifiState() && tapAdCustomController.isCanUseBssid();
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean allowsInstalledApps() {
        TapAdCustomController tapAdCustomController = controller;
        try {
            return state.get().collection.installedApps && tapAdCustomController != null && tapAdCustomController.alist();
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean allowsLocation() {
        TapAdCustomController tapAdCustomController = controller;
        try {
            return state.get().collection.location && tapAdCustomController != null && tapAdCustomController.isCanUseLocation();
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean allowsOaid() {
        return controller != null && state.get().collection.oaid;
    }

    public static boolean allowsOaidResult(long j) {
        return j == oaidGeneration.get() && allowsOaid();
    }

    public static boolean allowsSensor() {
        TapAdCustomController tapAdCustomController = controller;
        try {
            return state.get().collection.sensor && tapAdCustomController != null && tapAdCustomController.isCanUseSensor();
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean allowsSsid() {
        TapAdCustomController tapAdCustomController = controller;
        try {
            return state.get().collection.ssid && tapAdCustomController != null && tapAdCustomController.isCanUseWifiState() && tapAdCustomController.isCanUseSsid();
        } catch (Throwable th) {
            return false;
        }
    }

    public static void applyAdnCollectionPolicy(JSONObject jSONObject) {
        updatePolicy(jSONObject, false);
    }

    public static void applyCollectionPolicy(JSONObject jSONObject) {
        applyAdnCollectionPolicy(jSONObject);
    }

    public static void applyMediationCollectionPolicy(JSONObject jSONObject) {
        updatePolicy(jSONObject, true);
    }

    public static long collectionIntervalMs() {
        return state.get().collection.intervalMs;
    }

    public static void configure(TapAdCustomController tapAdCustomController) {
        if (controller != tapAdCustomController) {
            oaidGeneration.incrementAndGet();
        }
        controller = tapAdCustomController;
        notifyListeners();
    }

    private static void notifyListeners() {
        Iterator<Runnable> it = listeners.iterator();
        while (it.hasNext()) {
            it.next().run();
        }
    }

    public static long oaidGeneration() {
        return oaidGeneration.get();
    }

    public static void removeListener(Runnable runnable) {
        listeners.remove(runnable);
    }

    private static void updatePolicy(JSONObject jSONObject, boolean z) {
        AtomicReference<PolicyState> atomicReference;
        PolicyState policyState;
        CollectionPolicy collectionPolicy = new CollectionPolicy(jSONObject);
        do {
            atomicReference = state;
            policyState = atomicReference.get();
            boolean z2 = policyState.mediation;
            if (z2 && !z) {
                return;
            }
            if (z2 == z && policyState.collection.sameAs(collectionPolicy)) {
                return;
            }
        } while (!DirichletAd$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, policyState, new PolicyState(z, collectionPolicy)));
        if (policyState.collection.oaid != collectionPolicy.oaid) {
            oaidGeneration.incrementAndGet();
        }
        notifyListeners();
    }

    public static boolean allowsAndroidId(boolean z) {
        return z && state.get().collection.androidId;
    }
}
