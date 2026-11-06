package com.tapsdk.tapad.group.config;

import android.content.Context;
import android.text.TextUtils;
import com.tapsdk.tapad.group.AdNetworkType;
import com.tapsdk.tapad.group.AdType;
import com.tapsdk.tapad.group.DirichletAdConfig;
import com.tapsdk.tapad.group.DirichletAdRequest;
import com.tapsdk.tapad.group.DirichletSdk;
import com.tapsdk.tapad.group.adapter.AdapterInitConfig;
import com.tapsdk.tapad.group.adapter.AdapterInitConfigFactory;
import com.tapsdk.tapad.internal.observability.MediationTelemetryHost;
import com.tapsdk.tapad.internal.platform.AndroidLifecycleHost;
import com.tapsdk.tapad.internal.runtime.DirichletRuntime;
import com.tapsdk.tapad.internal.runtime.MediationControlBridge;
import com.tapsdk.tapad.internal.runtime.MediationPlatformEffects;
import com.tapsdk.tapad.internal.runtime.MediationRuntimeCoreBridge;
import com.tapsdk.tapad.internal.runtime.PublisherSettingsBridge;
import com.tapsdk.tapad.internal.storage.SafeSP;
import com.tapsdk.tapad.internal.utils.AndroidUserAgent;
import com.tapsdk.tapad.log.TapADLogger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class MediationCompositionRoot {
    private static final String SHOW_ADN_VERSION_MISMATCH_TOAST = "show_adn_version_mismatch_toast";
    private volatile AdapterRegistryCoordinator adapterRegistryCoordinator;
    private volatile long adapterRegistryEpoch;
    private volatile DirichletSdk.InitListener adapterRegistryInitListener;
    private final AtomicLong originEpoch;

    public static final class Holder {
        private static final MediationCompositionRoot INSTANCE = new MediationCompositionRoot();

        private Holder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<AdapterRegistryCoordinator.Binding> buildBindings(JSONObject jSONObject, DirichletAdConfig dirichletAdConfig, JSONObject jSONObject2) throws JSONException {
        ArrayList arrayList = new ArrayList();
        boolean zOptBoolean = jSONObject.optBoolean(SHOW_ADN_VERSION_MISMATCH_TOAST, true);
        if (jSONObject.getBoolean("initialize_direct")) {
            arrayList.add(createBinding(AdNetworkType.AD_TAP, AdapterInitConfigFactory.direct(dirichletAdConfig, jSONObject2), false, zOptBoolean));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("adapter_commands");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject3 = jSONArray.getJSONObject(i);
            AdNetworkType adNetworkForValue = AdNetworkType.getAdNetworkForValue(jSONObject3.getInt("network_type"));
            if (adNetworkForValue == AdNetworkType.AD_UNKOWN) {
                throw new IllegalArgumentException("unsupported adapter network");
            }
            arrayList.add(createBinding(adNetworkForValue, AdapterInitConfigFactory.fromCoreProjection(jSONObject3, dirichletAdConfig, jSONObject2), jSONObject3.getBoolean("sdk_version_no_limited"), zOptBoolean));
        }
        return arrayList;
    }

    private AdapterRegistryCoordinator.Binding createBinding(AdNetworkType adNetworkType, AdapterInitConfig adapterInitConfig, boolean z, boolean z2) {
        return new AdapterRegistryCoordinator.Binding(adNetworkType, adapterInitConfig, AdNetworkCapabilityDetector.getManagerHolderClassName(adNetworkType), AdNetworkCapabilityDetector.detect(adNetworkType).toRegistryFact(z, "5.3.0.1"), z2);
    }

    private AdapterRegistryCoordinator ensureAdapterRegistry(Context context) {
        AdapterRegistryCoordinator adapterRegistryCoordinator;
        AdapterRegistryCoordinator adapterRegistryCoordinator2 = this.adapterRegistryCoordinator;
        if (adapterRegistryCoordinator2 != null) {
            return adapterRegistryCoordinator2;
        }
        synchronized (this) {
            adapterRegistryCoordinator = this.adapterRegistryCoordinator;
            if (adapterRegistryCoordinator == null) {
                adapterRegistryCoordinator = new AdapterRegistryCoordinator(context, new AdapterRegistryCoordinator.Completion() { // from class: com.tapsdk.tapad.group.config.MediationCompositionRoot$$ExternalSyntheticLambda1
                    @Override // com.tapsdk.tapad.group.config.AdapterRegistryCoordinator.Completion
                    public final void onComplete(long j, boolean z, int i, String str) {
                        this.f$0.onAdapterRegistryComplete(j, z, i, str);
                    }
                });
                this.adapterRegistryCoordinator = adapterRegistryCoordinator;
            }
        }
        return adapterRegistryCoordinator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void failInitialization(long j, DirichletSdk.InitListener initListener, int i, String str) {
        if (isCurrentOrigin(j)) {
            this.adapterRegistryEpoch = 0L;
            this.adapterRegistryInitListener = null;
            AdapterRegistryCoordinator adapterRegistryCoordinator = this.adapterRegistryCoordinator;
            if (adapterRegistryCoordinator != null) {
                adapterRegistryCoordinator.cancel();
            }
            if (initListener != null) {
                if (TextUtils.isEmpty(str)) {
                    str = "共享 Rust mediation control 不可用";
                }
                initListener.onInitFail(i, str);
            }
        }
    }

    public static MediationCompositionRoot getInstance() {
        return Holder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initializeAdapterRegistry(long j, Context context, List<AdapterRegistryCoordinator.Binding> list, DirichletSdk.InitListener initListener) {
        if (isCurrentOrigin(j)) {
            ArrayList arrayList = new ArrayList(list);
            Collections.sort(arrayList, new Comparator<AdapterRegistryCoordinator.Binding>() { // from class: com.tapsdk.tapad.group.config.MediationCompositionRoot.2
                @Override // java.util.Comparator
                public int compare(AdapterRegistryCoordinator.Binding binding, AdapterRegistryCoordinator.Binding binding2) {
                    return Integer.compare(binding.networkType.getValue(), binding2.networkType.getValue());
                }
            });
            this.adapterRegistryInitListener = initListener;
            this.adapterRegistryEpoch = j;
            ensureAdapterRegistry(context).replace(j, arrayList);
        }
    }

    private void initializeOrigin(final Context context, final DirichletAdConfig dirichletAdConfig, final DirichletSdk.InitListener initListener) {
        final long jIncrementAndGet = this.originEpoch.incrementAndGet();
        this.adapterRegistryEpoch = 0L;
        this.adapterRegistryInitListener = null;
        ensureAdapterRegistry(context).cancel();
        MediationControlBridge.initializeOrigin(context, jIncrementAndGet, dirichletAdConfig, new MediationControlBridge.Callback() { // from class: com.tapsdk.tapad.group.config.MediationCompositionRoot.1
            @Override // com.tapsdk.tapad.internal.runtime.MediationControlBridge.Callback
            public void onError(int i, String str, Throwable th) {
                MediationCompositionRoot.this.failInitialization(jIncrementAndGet, initListener, i, str);
            }

            @Override // com.tapsdk.tapad.internal.runtime.MediationControlBridge.Callback
            public void onReady(JSONObject jSONObject) {
                if (MediationCompositionRoot.this.isCurrentOrigin(jIncrementAndGet)) {
                    MediationTelemetryHost.onOriginReady();
                    try {
                        MediationRuntimeCoreBridge.Result resultProjectPublisherSettings = MediationRuntimeCoreBridge.projectPublisherSettings(dirichletAdConfig.data);
                        if (!resultProjectPublisherSettings.isSuccess()) {
                            throw new IllegalStateException("shared Rust publisher settings projection unavailable");
                        }
                        MediationCompositionRoot.this.initializeAdapterRegistry(jIncrementAndGet, context, MediationCompositionRoot.this.buildBindings(jSONObject, dirichletAdConfig, resultProjectPublisherSettings.output), initListener);
                    } catch (Exception e) {
                        onError(-9606, "invalid adapter init command", e);
                    }
                }
            }
        });
    }

    private boolean isCurrentAdapterRegistry(long j) {
        return j > 0 && this.adapterRegistryEpoch == j && isCurrentOrigin(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCurrentOrigin(long j) {
        return j > 0 && this.originEpoch.get() == j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdapterRegistryComplete(long j, boolean z, int i, String str) {
        if (isCurrentAdapterRegistry(j)) {
            DirichletSdk.InitListener initListener = this.adapterRegistryInitListener;
            this.adapterRegistryInitListener = null;
            if (!z) {
                this.adapterRegistryEpoch = 0L;
            }
            if (initListener == null) {
                return;
            }
            if (z) {
                initListener.onInitSuccess();
            } else {
                initListener.onInitFail(i, str);
            }
        }
    }

    public synchronized void init(Context context, DirichletAdConfig dirichletAdConfig, DirichletSdk.InitListener initListener) {
        if (dirichletAdConfig.mIsDebug) {
            TapADLogger.setIsDebug(true);
        }
        SafeSP.initialize(context);
        AndroidUserAgent.initialize(context);
        MediationTelemetryHost.initialize(context, dirichletAdConfig.mMediaId);
        AndroidLifecycleHost.getInstance().m194lambda$init$0$comtapsdktapadinternalplatformAndroidLifecycleHost(context);
        MediationPlatformEffects.bind();
        initializeOrigin(context, dirichletAdConfig, initListener);
    }

    /* JADX INFO: renamed from: lambda$putMediaGlobalSettings$0$com-tapsdk-tapad-group-config-MediationCompositionRoot, reason: not valid java name */
    /* synthetic */ void m98lambda$putMediaGlobalSettings$0$comtapsdktapadgroupconfigMediationCompositionRoot(String str, String str2) {
        AdapterRegistryCoordinator adapterRegistryCoordinator;
        MediationRuntimeCoreBridge.Result resultProjectCurrentPublisherSettings = MediationRuntimeCoreBridge.projectCurrentPublisherSettings();
        if (resultProjectCurrentPublisherSettings.isSuccess() && (adapterRegistryCoordinator = this.adapterRegistryCoordinator) != null) {
            adapterRegistryCoordinator.updatePublisherSettings(resultProjectCurrentPublisherSettings.output, str, str2);
        }
    }

    public void prepareLoad(Context context, DirichletAdRequest dirichletAdRequest, AdType adType, MediationControlBridge.Callback callback) {
        AdapterRegistryCoordinator adapterRegistryCoordinator = this.adapterRegistryCoordinator;
        AdapterRegistryCoordinator.ReadyAdapters readyAdapters = adapterRegistryCoordinator == null ? AdapterRegistryCoordinator.ReadyAdapters.EMPTY : adapterRegistryCoordinator.readyAdapters();
        if (readyAdapters.isEmpty()) {
            callback.onError(-1, "sdk_not_initialized", null);
        } else {
            MediationControlBridge.prepareLoad(context, dirichletAdRequest, adType, readyAdapters.registryEpoch, readyAdapters.networkIds, callback);
        }
    }

    public void putMediaGlobalSettings(final String str, final String str2) {
        if (PublisherSettingsBridge.put(str, str2)) {
            DirichletRuntime dirichletRuntime = DirichletRuntime.getInstance();
            Runnable runnable = new Runnable() { // from class: com.tapsdk.tapad.group.config.MediationCompositionRoot$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m98lambda$putMediaGlobalSettings$0$comtapsdktapadgroupconfigMediationCompositionRoot(str, str2);
                }
            };
            if (dirichletRuntime.isOnRuntimeQueue()) {
                runnable.run();
            } else {
                dirichletRuntime.runOnRuntimeQueue(runnable);
            }
        }
    }

    private MediationCompositionRoot() {
        this.originEpoch = new AtomicLong();
    }
}
