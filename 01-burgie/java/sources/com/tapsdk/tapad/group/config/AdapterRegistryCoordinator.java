package com.tapsdk.tapad.group.config;

import android.content.Context;
import android.os.SystemClock;
import com.byazt.mg.PluginConstants;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.tapsdk.tapad.group.AdNetworkType;
import com.tapsdk.tapad.group.adapter.AdapterInitCallback;
import com.tapsdk.tapad.group.adapter.AdapterInitConfig;
import com.tapsdk.tapad.group.adapter.AdapterInitConfigFactory;
import com.tapsdk.tapad.group.adapter.AdapterInitializer;
import com.tapsdk.tapad.group.constants.Constants;
import com.tapsdk.tapad.internal.observability.MediationTelemetryHost;
import com.tapsdk.tapad.internal.runtime.DirichletRuntime;
import com.tapsdk.tapad.internal.runtime.MediationControlBridge;
import com.tapsdk.tapad.internal.runtime.MediationRuntimeCoreBridge;
import com.tapsdk.tapad.internal.utils.AsyncExecutor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class AdapterRegistryCoordinator {
    private static final int INIT_EXECUTOR_REJECTED = -9505;
    private static final int OBSERVATION_INITIALIZE_RESULT = 2;
    private static final int OBSERVATION_INITIALIZE_START = 1;
    private static final int OBSERVATION_PUBLISH = 3;
    private static final int OBSERVATION_SKIP = 4;
    private static final int RUNTIME_UNAVAILABLE = -9502;
    private final Completion completion;
    private final Context context;
    private Run current;
    private volatile ReadyAdapters readyAdapters = ReadyAdapters.EMPTY;

    public static final class Binding {
        final AdapterInitConfig adapterConfig;
        final AdapterRegistryNativeBridge.Fact fact;
        final String managerHolderClassName;
        final AdNetworkType networkType;
        final boolean showAdnVersionMismatchToast;

        public Binding(AdNetworkType adNetworkType, AdapterInitConfig adapterInitConfig, String str, AdapterRegistryNativeBridge.Fact fact, boolean z) {
            this.networkType = adNetworkType;
            this.adapterConfig = adapterInitConfig;
            this.managerHolderClassName = str;
            this.fact = fact;
            this.showAdnVersionMismatchToast = z;
        }
    }

    public interface Completion {
        void onComplete(long j, boolean z, int i, String str);
    }

    public static final class ReadyAdapters {
        static final ReadyAdapters EMPTY = new ReadyAdapters(0, Collections.EMPTY_LIST);
        final List<Integer> networkIds;
        final long registryEpoch;

        public boolean isEmpty() {
            return this.registryEpoch <= 0 || this.networkIds.isEmpty();
        }

        private ReadyAdapters(long j, List<Integer> list) {
            this.registryEpoch = j;
            this.networkIds = list;
        }
    }

    public static final class Run {
        final Map<Integer, Binding> bindings;
        final Map<Integer, AdapterInitializer> instances = new LinkedHashMap();
        final Map<Integer, AdapterInitializer> published = new LinkedHashMap();
        final long requestEpoch;
        AdapterRegistryNativeBridge.Session session;
        boolean terminalDelivered;

        public Run(long j, Map<Integer, Binding> map) {
            this.requestEpoch = j;
            this.bindings = map;
        }
    }

    public AdapterRegistryCoordinator(Context context, Completion completion) {
        this.context = context.getApplicationContext();
        this.completion = completion;
    }

    private void begin(Run run) {
        if (this.current != run) {
            return;
        }
        ArrayList arrayList = new ArrayList(run.bindings.size());
        Iterator<Binding> it = run.bindings.values().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().fact);
        }
        try {
            AdapterRegistryNativeBridge.Session sessionBegin = AdapterRegistryNativeBridge.begin(arrayList);
            run.session = sessionBegin;
            consume(run, sessionBegin.initialCommands);
        } catch (AdapterRegistryNativeBridge.RegistryException e) {
            failClosed(run, e.status);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeCurrent() {
        Run run = this.current;
        this.current = null;
        this.readyAdapters = ReadyAdapters.EMPTY;
        if (run == null) {
            return;
        }
        AdapterRegistryNativeBridge.Session session = run.session;
        if (session != null) {
            try {
                Iterator<AdapterRegistryNativeBridge.Command> it = session.close().commands.iterator();
                while (it.hasNext()) {
                    run.instances.remove(Integer.valueOf(it.next().networkId));
                }
            } catch (AdapterRegistryNativeBridge.RegistryException e) {
            }
        }
        run.published.clear();
        run.instances.clear();
    }

    private void completeTerminal(Run run, AdapterRegistryNativeBridge.CommandBatch commandBatch) {
        MediationRuntimeCoreBridge.Result resultResolveAdapterRegistryTerminal = MediationRuntimeCoreBridge.resolveAdapterRegistryTerminal(commandBatch.readyCount, commandBatch.failedCount, commandBatch.unavailableCount);
        if (!resultResolveAdapterRegistryTerminal.isSuccess()) {
            failClosed(run, resultResolveAdapterRegistryTerminal.status);
        } else {
            run.terminalDelivered = true;
            this.completion.onComplete(run.requestEpoch, resultResolveAdapterRegistryTerminal.output.optBoolean("succeeded", false), resultResolveAdapterRegistryTerminal.output.optInt(PluginConstants.KEY_ERROR_CODE, -1), resultResolveAdapterRegistryTerminal.output.optString("message", ""));
        }
    }

    private void consume(Run run, AdapterRegistryNativeBridge.CommandBatch commandBatch) {
        if (this.current != run) {
            return;
        }
        int i = commandBatch.readyCount + commandBatch.failedCount + commandBatch.unavailableCount;
        if (i <= run.bindings.size()) {
            if (commandBatch.terminal == (i == run.bindings.size())) {
                for (AdapterRegistryNativeBridge.Command command : commandBatch.commands) {
                    Binding binding = run.bindings.get(Integer.valueOf(command.networkId));
                    if (binding == null) {
                        failClosed(run, -9504);
                        return;
                    }
                    switch (command.command) {
                        case 1:
                            if (command.hasPartnerVersionAdvisory()) {
                                Context context = this.context;
                                AdNetworkType adNetworkType = binding.networkType;
                                AdapterRegistryNativeBridge.Fact fact = binding.fact;
                                AdnVersionMismatchNotifier.notify(context, adNetworkType, fact.pinnedPartnerVersion, fact.actualPartnerVersion, binding.showAdnVersionMismatchToast);
                            }
                            initialize(run, binding, command.lifecycleToken);
                            break;
                        case 2:
                            AdapterInitializer adapterInitializer = run.instances.get(Integer.valueOf(command.networkId));
                            if (adapterInitializer == null) {
                                failClosed(run, -9504);
                                return;
                            }
                            run.published.put(Integer.valueOf(command.networkId), adapterInitializer);
                            publishReadyNetworkIds(run);
                            observe(run, binding, 3, command.reason, false, 0, "", 0L);
                            break;
                            break;
                        case 3:
                        case 5:
                            run.published.remove(Integer.valueOf(command.networkId));
                            run.instances.remove(Integer.valueOf(command.networkId));
                            publishReadyNetworkIds(run);
                            break;
                        case 4:
                            observe(run, binding, 4, command.reason, false, 0, "", 0L);
                            break;
                        default:
                            failClosed(run, -9504);
                            return;
                    }
                }
                if (!commandBatch.terminal || run.terminalDelivered) {
                    return;
                }
                completeTerminal(run, commandBatch);
                return;
            }
        }
        failClosed(run, -9504);
    }

    private void failClosed(Run run, int i) {
        if (this.current != run) {
            return;
        }
        this.current = null;
        this.readyAdapters = ReadyAdapters.EMPTY;
        AdapterRegistryNativeBridge.Session session = run.session;
        if (session != null) {
            session.abort();
            run.session = null;
        }
        run.published.clear();
        run.instances.clear();
        this.completion.onComplete(run.requestEpoch, false, i, "共享 Rust AdapterRegistry 不可用");
    }

    private void initialize(final Run run, final Binding binding, final int i) {
        observe(run, binding, 1, 0, false, 0, "", 0L);
        if (AsyncExecutor.tryExecuteIO(new Runnable() { // from class: com.tapsdk.tapad.group.config.AdapterRegistryCoordinator$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m94lambda$initialize$3$comtapsdktapadgroupconfigAdapterRegistryCoordinator(binding, run, i);
            }
        })) {
            return;
        }
        postResult(run, binding, i, false, INIT_EXECUTOR_REJECTED, "adapter init executor is saturated", 0L);
    }

    private void observe(Run run, Binding binding, int i, int i2, boolean z, int i3, String str, long j) {
        if (this.current != run || binding == null) {
            return;
        }
        try {
            JSONObject jSONObjectPut = new JSONObject().put("origin_id", run.requestEpoch).put("stage", i).put("network_id", binding.networkType.getValue()).put(MediationConstant.KEY_REASON, i2).put("succeeded", z).put(PluginConstants.KEY_ERROR_CODE, i3);
            if (str == null) {
                str = "";
            }
            MediationControlBridge.submitAdapterRegistryObservation(jSONObjectPut.put("message", str).put("elapsed_ms", Math.max(0L, j)));
        } catch (Throwable th) {
        }
    }

    private boolean post(Runnable runnable) {
        return DirichletRuntime.getInstance().runOnRuntimeQueue(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postResult(final Run run, final Binding binding, final int i, final boolean z, final int i2, final String str, final long j) {
        post(new Runnable() { // from class: com.tapsdk.tapad.group.config.AdapterRegistryCoordinator$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m95lambda$postResult$4$comtapsdktapadgroupconfigAdapterRegistryCoordinator(run, i, z, binding, i2, str, j);
            }
        });
    }

    private void publishReadyNetworkIds(Run run) {
        if (this.current != run) {
            return;
        }
        ArrayList arrayList = new ArrayList(run.published.keySet());
        Collections.sort(arrayList);
        this.readyAdapters = new ReadyAdapters(run.requestEpoch, Collections.unmodifiableList(arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: replaceOnQueue, reason: merged with bridge method [inline-methods] */
    public void m96lambda$replace$0$comtapsdktapadgroupconfigAdapterRegistryCoordinator(long j, List<Binding> list) {
        AdNetworkType adNetworkType;
        closeCurrent();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Binding binding : list) {
            if (binding == null || (adNetworkType = binding.networkType) == null || adNetworkType.getValue() < 0 || linkedHashMap.put(Integer.valueOf(binding.networkType.getValue()), binding) != null) {
                this.completion.onComplete(j, false, -9501, "共享 Rust AdapterRegistry 不可用");
                return;
            }
        }
        Run run = new Run(j, linkedHashMap);
        this.current = run;
        begin(run);
    }

    private static void reportReflectionFailure(Binding binding, Throwable th) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(Constants.AD_NETWORK_TYPE_FIELD, Integer.valueOf(binding.networkType.getValue()));
        linkedHashMap.put(Constants.AD_NETWORK_MEDIA_ID_FIELD, binding.adapterConfig.getMediaId());
        linkedHashMap.put(Constants.ERROR_CODE_FIELD, 3001);
        linkedHashMap.put(Constants.ERROR_MSG_FIELD, String.valueOf(th.getMessage()));
        MediationTelemetryHost.report(63, linkedHashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: updatePublisherSettingsOnQueue, reason: merged with bridge method [inline-methods] */
    public void m97lambda$updatePublisherSettings$1$comtapsdktapadgroupconfigAdapterRegistryCoordinator(String str, String str2, String str3) {
        Run run = this.current;
        if (run == null || run.published.isEmpty()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            ArrayList arrayList = new ArrayList(run.published.entrySet());
            int i = 0;
            int size = arrayList.size();
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                Map.Entry entry = (Map.Entry) obj;
                Binding binding = run.bindings.get(entry.getKey());
                if (binding != null && entry.getValue() != null) {
                    try {
                        AdapterInitConfigFactory.refreshPublisherSettings(binding.adapterConfig, jSONObject);
                        ((AdapterInitializer) entry.getValue()).updateGlobalSettings(binding.adapterConfig, str2, str3);
                    } catch (Throwable th) {
                        Objects.toString(binding.networkType);
                        th.toString();
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public void cancel() {
        this.readyAdapters = ReadyAdapters.EMPTY;
        post(new Runnable() { // from class: com.tapsdk.tapad.group.config.AdapterRegistryCoordinator$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.closeCurrent();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initialize$2$com-tapsdk-tapad-group-config-AdapterRegistryCoordinator, reason: not valid java name */
    /* synthetic */ void m93lambda$initialize$2$comtapsdktapadgroupconfigAdapterRegistryCoordinator(Run run, Binding binding, AdapterInitializer adapterInitializer) {
        if (this.current == run) {
            run.instances.put(Integer.valueOf(binding.networkType.getValue()), adapterInitializer);
        }
    }

    /* JADX INFO: renamed from: lambda$initialize$3$com-tapsdk-tapad-group-config-AdapterRegistryCoordinator, reason: not valid java name */
    /* synthetic */ void m94lambda$initialize$3$comtapsdktapadgroupconfigAdapterRegistryCoordinator(final Binding binding, final Run run, final int i) {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            Object objNewInstance = Class.forName(binding.managerHolderClassName).getDeclaredConstructor(null).newInstance(null);
            try {
                if (!(objNewInstance instanceof AdapterInitializer)) {
                    throw new IllegalStateException(binding.managerHolderClassName + " does not implement AdapterInitializer");
                }
                final AdapterInitializer adapterInitializer = (AdapterInitializer) objNewInstance;
                post(new Runnable() { // from class: com.tapsdk.tapad.group.config.AdapterRegistryCoordinator$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m93lambda$initialize$2$comtapsdktapadgroupconfigAdapterRegistryCoordinator(run, binding, adapterInitializer);
                    }
                });
                adapterInitializer.initialize(this.context, binding.adapterConfig, new AdapterInitCallback() { // from class: com.tapsdk.tapad.group.config.AdapterRegistryCoordinator.1
                    @Override // com.tapsdk.tapad.group.adapter.AdapterInitCallback
                    public void onFailure(int i2, String str) {
                        AdapterRegistryCoordinator.this.postResult(run, binding, i, false, i2, str, SystemClock.elapsedRealtime() - jElapsedRealtime);
                    }

                    @Override // com.tapsdk.tapad.group.adapter.AdapterInitCallback
                    public void onSuccess() {
                        AdapterRegistryCoordinator.this.postResult(run, binding, i, true, 0, "", SystemClock.elapsedRealtime() - jElapsedRealtime);
                    }
                });
                return;
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        reportReflectionFailure(binding, th);
        postResult(run, binding, i, false, -1, th.toString(), SystemClock.elapsedRealtime() - jElapsedRealtime);
    }

    /* JADX INFO: renamed from: lambda$postResult$4$com-tapsdk-tapad-group-config-AdapterRegistryCoordinator, reason: not valid java name */
    /* synthetic */ void m95lambda$postResult$4$comtapsdktapadgroupconfigAdapterRegistryCoordinator(Run run, int i, boolean z, Binding binding, int i2, String str, long j) {
        AdapterRegistryNativeBridge.Session session;
        if (this.current != run || (session = run.session) == null) {
            return;
        }
        try {
            AdapterRegistryNativeBridge.CommandBatch commandBatchApply = session.apply(i, z);
            if (commandBatchApply.commands.size() != 1) {
                failClosed(run, -9504);
                return;
            }
            AdapterRegistryNativeBridge.Command command = commandBatchApply.commands.get(0);
            if (command.networkId != binding.networkType.getValue() || ((!z || command.command != 2 || command.reason != 0) && (z || command.command != 3 || command.reason != 10))) {
                failClosed(run, -9504);
            } else {
                observe(run, binding, 2, command.reason, z, i2, str == null ? "" : str, j);
                consume(run, commandBatchApply);
            }
        } catch (AdapterRegistryNativeBridge.RegistryException e) {
            failClosed(run, e.status);
        }
    }

    public ReadyAdapters readyAdapters() {
        return this.readyAdapters;
    }

    public void replace(final long j, List<Binding> list) {
        this.readyAdapters = ReadyAdapters.EMPTY;
        final ArrayList arrayList = list == null ? new ArrayList() : new ArrayList(list);
        if (post(new Runnable() { // from class: com.tapsdk.tapad.group.config.AdapterRegistryCoordinator$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m96lambda$replace$0$comtapsdktapadgroupconfigAdapterRegistryCoordinator(j, arrayList);
            }
        })) {
            return;
        }
        this.completion.onComplete(j, false, RUNTIME_UNAVAILABLE, "共享 Rust AdapterRegistry 不可用");
    }

    public void updatePublisherSettings(JSONObject jSONObject, final String str, final String str2) {
        if (jSONObject == null) {
            return;
        }
        final String string = jSONObject.toString();
        post(new Runnable() { // from class: com.tapsdk.tapad.group.config.AdapterRegistryCoordinator$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m97lambda$updatePublisherSettings$1$comtapsdktapadgroupconfigAdapterRegistryCoordinator(string, str, str2);
            }
        });
    }
}
