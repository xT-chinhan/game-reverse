package com.tapsdk.tapad.group;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import com.tapsdk.tapad.exceptions.ClientException;
import com.tapsdk.tapad.group.adapter.AdapterAdSession;
import com.tapsdk.tapad.group.adapter.AdapterBannerLoader;
import com.tapsdk.tapad.group.adapter.AdapterBannerSession;
import com.tapsdk.tapad.group.adapter.AdapterExpressFeedLoader;
import com.tapsdk.tapad.group.adapter.AdapterExpressFeedSession;
import com.tapsdk.tapad.group.adapter.AdapterInterstitialLoadRequest;
import com.tapsdk.tapad.group.adapter.AdapterInterstitialLoader;
import com.tapsdk.tapad.group.adapter.AdapterInterstitialSession;
import com.tapsdk.tapad.group.adapter.AdapterLoadCallback;
import com.tapsdk.tapad.group.adapter.AdapterLoadRequest;
import com.tapsdk.tapad.group.adapter.AdapterNativeFeedLoader;
import com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession;
import com.tapsdk.tapad.group.adapter.AdapterRewardLoadRequest;
import com.tapsdk.tapad.group.adapter.AdapterRewardLoader;
import com.tapsdk.tapad.group.adapter.AdapterRewardSession;
import com.tapsdk.tapad.group.adapter.AdapterSplashLoadRequest;
import com.tapsdk.tapad.group.adapter.AdapterSplashLoader;
import com.tapsdk.tapad.group.adapter.AdapterSplashSession;
import com.tapsdk.tapad.group.ads.DirichletAd;
import com.tapsdk.tapad.group.ads.MediationAdFactory;
import com.tapsdk.tapad.group.config.AdNetworkCapabilityDetector;
import com.tapsdk.tapad.group.config.MediationCompositionRoot;
import com.tapsdk.tapad.group.constants.Constants;
import com.tapsdk.tapad.internal.Callback;
import com.tapsdk.tapad.internal.ionia.IoniaIdentityManager;
import com.tapsdk.tapad.internal.observability.MediationTelemetryHost;
import com.tapsdk.tapad.internal.runtime.DirichletRuntime;
import com.tapsdk.tapad.internal.runtime.MediationControlBridge;
import com.tapsdk.tapad.internal.runtime.MediationRuntimeCoreBridge;
import com.tapsdk.tapad.internal.utils.ActivityUtil;
import com.tapsdk.tapad.internal.utils.AsyncExecutor;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class MediationAdapterLoadHost {
    private static final ThreadPoolExecutor ADAPTER_EXECUTOR = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactory() { // from class: com.tapsdk.tapad.group.MediationAdapterLoadHost$$ExternalSyntheticLambda12
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return MediationAdapterLoadHost.lambda$static$0(runnable);
        }
    }, new ThreadPoolExecutor.AbortPolicy());
    private static final Map<String, LoaderPort> ADAPTER_LOADERS = new HashMap();
    private static final int CONTROL_ERROR_SPACE_UNAVAILABLE = -9658;
    private static final int PUBLIC_ERROR_LOAD_FAILED = 200001;
    private static final int PUBLIC_ERROR_NO_FILL = 200002;
    private static final String ROUTE_KEY_FIELD = "__d_route_key";

    public static final class AdapterAttempt implements SchedulerMechanicalAdapterExecutor.Route, Runnable {
        private static final int ACTIVE = 1;
        private static final int CANCELLED = 3;
        private static final int IDLE = 0;
        private static final int REPORTED = 2;
        private final WeakReference<Context> context;
        private volatile long deadlineMs;
        private final LoadPlan loadPlan;
        private final LoaderPort loader;
        private final DirichletAdRequest request;
        private final RequestHost requestHost;
        private final SchedulerResultGate resultGate;
        private final AdapterRoute route;
        private final long schedulerRequestId;
        private volatile long startedAtMs;
        private volatile Runnable timeoutTask;
        private final AtomicLong attemptId = new AtomicLong(0);
        private final AtomicInteger state = new AtomicInteger(0);

        /* JADX INFO: renamed from: com.tapsdk.tapad.group.MediationAdapterLoadHost$AdapterAttempt$2, reason: invalid class name */
        public class AnonymousClass2 implements AttemptCallback {
            public AnonymousClass2() {
            }

            /* JADX INFO: renamed from: lambda$onFailure$1$com-tapsdk-tapad-group-MediationAdapterLoadHost$AdapterAttempt$2, reason: not valid java name */
            /* synthetic */ void m20lambda$onFailure$1$comtapsdktapadgroupMediationAdapterLoadHost$AdapterAttempt$2(int i, String str) {
                AdapterAttempt.this.handleFailure(i, str);
            }

            /* JADX INFO: renamed from: lambda$onSuccess$0$com-tapsdk-tapad-group-MediationAdapterLoadHost$AdapterAttempt$2, reason: not valid java name */
            /* synthetic */ void m21lambda$onSuccess$0$comtapsdktapadgroupMediationAdapterLoadHost$AdapterAttempt$2(List list) {
                AdapterAttempt.this.handleSuccess(list);
            }

            @Override // com.tapsdk.tapad.group.MediationAdapterLoadHost.AttemptCallback
            public void onFailure(final int i, final String str) {
                AdapterAttempt.this.dispatchResult(new Runnable() { // from class: com.tapsdk.tapad.group.MediationAdapterLoadHost$AdapterAttempt$2$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m20lambda$onFailure$1$comtapsdktapadgroupMediationAdapterLoadHost$AdapterAttempt$2(i, str);
                    }
                }, Collections.EMPTY_LIST, "adapter failure callback");
            }

            @Override // com.tapsdk.tapad.group.MediationAdapterLoadHost.AttemptCallback
            public void onSuccess(final List<DirichletAd> list) {
                AdapterAttempt.this.dispatchResult(new Runnable() { // from class: com.tapsdk.tapad.group.MediationAdapterLoadHost$AdapterAttempt$2$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m21lambda$onSuccess$0$comtapsdktapadgroupMediationAdapterLoadHost$AdapterAttempt$2(list);
                    }
                }, list, "adapter success callback");
            }
        }

        public AdapterAttempt(long j, Context context, AdapterBinding adapterBinding, DirichletAdRequest dirichletAdRequest, LoadPlan loadPlan, RequestHost requestHost) {
            this.schedulerRequestId = j;
            this.context = new WeakReference<>(context);
            AdapterRoute adapterRoute = adapterBinding.route;
            this.route = adapterRoute;
            this.loader = adapterBinding.loader;
            this.request = dirichletAdRequest;
            this.loadPlan = loadPlan;
            this.requestHost = requestHost;
            this.resultGate = new SchedulerResultGate(j, adapterRoute.routeKey, requestHost.terminal);
        }

        private Map<String, Object> attemptTelemetryFields() {
            Map<String, Object> mapRouteTelemetryFields = MediationAdapterLoadHost.routeTelemetryFields(this.loadPlan.getRequestId(), this.request, this.route);
            mapRouteTelemetryFields.put("attempt_id", Long.valueOf(this.attemptId.get()));
            if (this.startedAtMs <= 0) {
                mapRouteTelemetryFields.put(Constants.DELAY_FIELD, 0L);
                return mapRouteTelemetryFields;
            }
            mapRouteTelemetryFields.put("ad_request_time", Long.valueOf(this.startedAtMs));
            mapRouteTelemetryFields.put(Constants.DELAY_FIELD, Long.valueOf(Math.max(0L, System.currentTimeMillis() - this.startedAtMs)));
            return mapRouteTelemetryFields;
        }

        private void cancelTimeout() {
            SchedulerNativeBridge.cancelWake(this.timeoutTask);
            this.timeoutTask = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dispatchResult(Runnable runnable, List<DirichletAd> list, String str) {
            if (DirichletRuntime.getInstance().runOnRuntimeQueue(runnable)) {
                return;
            }
            if (!this.state.compareAndSet(1, 2)) {
                MediationAdapterLoadHost.destroyCandidates(list);
                return;
            }
            cancelTimeout();
            MediationAdapterLoadHost.destroyCandidates(list);
            this.attemptId.get();
            int i = this.route.routeKey;
        }

        private void failBeforeStart(String str) {
            if (this.state.compareAndSet(1, 2)) {
                cancelTimeout();
                recordFailure(Constants.SDK_AD_LOAD_ERROR_CODE, str, false);
                submit(3, Collections.EMPTY_LIST, new byte[0]);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void handleFailure(int i, String str) {
            if (this.state.compareAndSet(1, 2)) {
                cancelTimeout();
                recordFailure(i, str, true);
                submit(3, Collections.EMPTY_LIST, new byte[0]);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v23 */
        public void handleSuccess(List<DirichletAd> list) {
            int i;
            DirichletAd dirichletAd;
            if (!this.state.compareAndSet(1, 2)) {
                MediationAdapterLoadHost.destroyCandidates(list);
                return;
            }
            cancelTimeout();
            Context context = this.context.get();
            if (!(context instanceof Activity) || ActivityUtil.isActivityNotAlive((Activity) context)) {
                int i2 = 0;
                MediationAdapterLoadHost.destroyCandidates(list);
                recordFailure(Constants.SDK_AD_LOAD_ERROR_CODE, "adapter activity unavailable after load", i2);
                submit(3, Collections.EMPTY_LIST, new byte[i2]);
                return;
            }
            long jMax = Math.max(0L, System.currentTimeMillis() - this.startedAtMs);
            long j = this.attemptId.get();
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                try {
                    for (DirichletAd dirichletAd2 : list) {
                        if (dirichletAd2 != null) {
                            int size = arrayList.size();
                            String strMakeTrackId = this.loadPlan.makeTrackId(this.route, size);
                            if (strMakeTrackId.isEmpty()) {
                                i = size;
                                dirichletAd = dirichletAd2;
                            } else {
                                String requestId = this.loadPlan.getRequestId();
                                AdapterRoute adapterRoute = this.route;
                                i = size;
                                dirichletAd = dirichletAd2;
                                if (MediationAdFactory.bindLoadedCandidate(dirichletAd2, requestId, adapterRoute.adNetworkType, adapterRoute.doubleWindow, adapterRoute.nativeSplashClosePosition, this.request, strMakeTrackId, adapterRoute.routeKey, j, i, jMax)) {
                                    arrayList.add(dirichletAd);
                                }
                            }
                            Map<String, Object> mapAttemptTelemetryFields = attemptTelemetryFields();
                            mapAttemptTelemetryFields.put(Constants.INDEX_FIELD, Integer.valueOf(i));
                            MediationAdapterLoadHost.addErrorFields(mapAttemptTelemetryFields, Constants.SDK_AD_LOAD_ERROR_CODE, "candidate pricing item rejected");
                            MediationTelemetryHost.report(75, mapAttemptTelemetryFields);
                            dirichletAd.destroy();
                        }
                    }
                } catch (Throwable th) {
                    MediationAdapterLoadHost.destroyCandidates(arrayList);
                    recordFailure(Constants.SDK_AD_LOAD_ERROR_CODE, "adapter result normalization failed: ".concat(th.getClass().getSimpleName()), false);
                    submit(3, Collections.EMPTY_LIST, new byte[0]);
                    return;
                }
            }
            byte[] bArrProjectPricingIngress = arrayList.isEmpty() ? new byte[0] : projectPricingIngress(arrayList);
            if (arrayList.isEmpty()) {
                MediationRuntimeCoreBridge.recordNoFill(this.loadPlan.getRequestId(), this.route.routeKey, j, 0, jMax);
                Map<String, Object> mapAttemptTelemetryFields2 = attemptTelemetryFields();
                MediationAdapterLoadHost.addErrorFields(mapAttemptTelemetryFields2, 200002, "无填充广告");
                mapAttemptTelemetryFields2.put("count", 0);
                mapAttemptTelemetryFields2.put(Constants.DELAY_FIELD, Long.valueOf(jMax));
                MediationTelemetryHost.report(10, mapAttemptTelemetryFields2);
            } else {
                Map<String, Object> mapAttemptTelemetryFields3 = attemptTelemetryFields();
                mapAttemptTelemetryFields3.put("count", Integer.valueOf(arrayList.size()));
                mapAttemptTelemetryFields3.put(Constants.DELAY_FIELD, Long.valueOf(jMax));
                MediationTelemetryHost.report(12, mapAttemptTelemetryFields3);
            }
            submit(arrayList.isEmpty() ? 2 : 1, arrayList, bArrProjectPricingIngress);
        }

        private byte[] projectPricingIngress(List<DirichletAd> list) {
            JSONArray jSONArray = new JSONArray();
            Iterator<DirichletAd> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().getTrackId());
            }
            return MediationRuntimeCoreBridge.projectPricingIngress(this.loadPlan.getRequestId(), this.route.routeKey, jSONArray);
        }

        private void recordFailure(int i, String str, boolean z) {
            String str2 = this.route.networkSpaceId;
            Map<String, Object> mapAttemptTelemetryFields = attemptTelemetryFields();
            MediationAdapterLoadHost.addErrorFields(mapAttemptTelemetryFields, i, str);
            MediationTelemetryHost.report(10, mapAttemptTelemetryFields);
            if (z) {
                MediationRuntimeCoreBridge.recordNoFill(this.loadPlan.getRequestId(), this.route.routeKey, this.attemptId.get(), 0, this.startedAtMs != 0 ? Math.max(0L, System.currentTimeMillis() - this.startedAtMs) : 0L);
            }
        }

        private void submit(int i, List<DirichletAd> list, byte[] bArr) {
            this.attemptId.get();
            AdapterRoute adapterRoute = this.route;
            int i2 = adapterRoute.routeKey;
            Objects.toString(adapterRoute.adNetworkType);
            if (list != null) {
                list.size();
            }
            SchedulerNativeBridge.acceptOwnedLoadFact(this.schedulerRequestId, this.attemptId.get(), this.route.routeKey, i, list, bArr, this.resultGate);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void timeout() {
            if (this.state.compareAndSet(1, 3)) {
                cancelTimeout();
                MediationTelemetryHost.report(8, attemptTelemetryFields());
                SchedulerNativeBridge.acceptOwnedLoadFact(this.schedulerRequestId, this.attemptId.get(), this.route.routeKey, 4, Collections.EMPTY_LIST, new byte[0], this.resultGate);
                Objects.toString(this.route.adNetworkType);
                String str = this.route.networkSpaceId;
                Thread.currentThread().getName();
            }
        }

        @Override // com.tapsdk.tapad.group.SchedulerMechanicalAdapterExecutor.Route
        public void cancel(long j) {
            if (j <= 0 || this.attemptId.get() != j) {
                throw new IllegalStateException("unknown scheduler attempt");
            }
            this.resultGate.cancel(j);
            this.state.compareAndSet(1, 3);
            cancelTimeout();
        }

        /* JADX INFO: renamed from: lambda$run$0$com-tapsdk-tapad-group-MediationAdapterLoadHost$AdapterAttempt, reason: not valid java name */
        /* synthetic */ void m19lambda$run$0$comtapsdktapadgroupMediationAdapterLoadHost$AdapterAttempt(Throwable th) {
            handleFailure(Constants.SDK_AD_LOAD_ERROR_CODE, "adapter load threw: ".concat(th.getClass().getSimpleName()));
        }

        @Override // com.tapsdk.tapad.group.SchedulerMechanicalAdapterExecutor.Route
        public void load(long j, long j2) {
            if (j <= 0 || j2 <= 0 || !this.attemptId.compareAndSet(0L, j) || !this.state.compareAndSet(0, 1)) {
                throw new IllegalStateException("invalid scheduler load identity");
            }
            this.resultGate.bind(j);
            this.deadlineMs = j2;
            this.requestHost.startLegacySchedulerPhase(this.route.biddingType);
            AdapterRoute adapterRoute = this.route;
            int i = adapterRoute.routeKey;
            Objects.toString(adapterRoute.adNetworkType);
            String str = this.route.networkSpaceId;
            Math.max(0L, j2 - SystemClock.uptimeMillis());
            if (j2 <= SystemClock.uptimeMillis()) {
                timeout();
                return;
            }
            if (this.context.get() == null) {
                failBeforeStart("adapter context unavailable");
                return;
            }
            try {
                MediationAdapterLoadHost.ADAPTER_EXECUTOR.execute(this);
            } catch (RejectedExecutionException e) {
                Map<String, Object> mapAttemptTelemetryFields = attemptTelemetryFields();
                MediationAdapterLoadHost.addErrorFields(mapAttemptTelemetryFields, -1, e.getMessage());
                mapAttemptTelemetryFields.put("extra", "adapter_load");
                MediationTelemetryHost.report(64, mapAttemptTelemetryFields);
                failBeforeStart("adapter executor rejected request");
            }
        }

        @Override // com.tapsdk.tapad.group.SchedulerMechanicalAdapterExecutor.Route
        public int routeKey() {
            return this.route.routeKey;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.state.get() != 1) {
                return;
            }
            Context context = this.context.get();
            if (context == null) {
                failBeforeStart("adapter execution unavailable");
                return;
            }
            this.startedAtMs = System.currentTimeMillis();
            if (this.deadlineMs <= SystemClock.uptimeMillis()) {
                timeout();
                return;
            }
            this.timeoutTask = SchedulerNativeBridge.scheduleWakeAt(this.deadlineMs, new Runnable() { // from class: com.tapsdk.tapad.group.MediationAdapterLoadHost.AdapterAttempt.1
                @Override // java.lang.Runnable
                public void run() {
                    AdapterAttempt.this.timeout();
                }
            });
            if (this.timeoutTask == null) {
                failBeforeStart("adapter timeout queue unavailable");
                return;
            }
            if (this.state.get() != 1) {
                cancelTimeout();
                return;
            }
            MediationTelemetryHost.report(11, attemptTelemetryFields());
            try {
                this.loader.load(context, this.route, this.request, new AnonymousClass2());
            } catch (Throwable th) {
                dispatchResult(new Runnable() { // from class: com.tapsdk.tapad.group.MediationAdapterLoadHost$AdapterAttempt$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m19lambda$run$0$comtapsdktapadgroupMediationAdapterLoadHost$AdapterAttempt(th);
                    }
                }, Collections.EMPTY_LIST, "adapter throw");
            }
        }
    }

    public static final class AdapterBinding {
        final LoaderPort loader;
        final AdapterRoute route;

        public AdapterBinding(AdapterRoute adapterRoute, LoaderPort loaderPort) {
            this.route = adapterRoute;
            this.loader = loaderPort;
        }
    }

    public static final class AdapterRoute {
        final AdNetworkType adNetworkType;
        final AdType adType;
        final int adsCount;
        final boolean allowCached;
        final int biddingType;
        final boolean doubleWindow;
        final int insertStyle;
        final int nativeSplashClosePosition;
        final String networkSpaceId;
        final boolean preload;
        final int routeKey;
        final int screenType;
        final long timeout;

        private AdapterRoute(int i, String str, AdNetworkType adNetworkType, boolean z, int i2, int i3, long j, int i4, boolean z2, boolean z3, int i5, AdType adType, int i6) {
            this.routeKey = i;
            this.networkSpaceId = str;
            this.adNetworkType = adNetworkType;
            this.allowCached = z;
            this.biddingType = i2;
            this.insertStyle = i3;
            this.timeout = j;
            this.adsCount = i4;
            this.preload = z2;
            this.doubleWindow = z3;
            this.nativeSplashClosePosition = i5;
            this.adType = adType;
            this.screenType = i6;
        }

        public static AdapterRoute fromCoreProjection(int i, JSONObject jSONObject, int i2, boolean z, boolean z2, int i3) {
            if (i <= 0 || jSONObject == null || i2 <= 0) {
                throw new IllegalArgumentException("missing adapter route projection");
            }
            AdNetworkType adNetworkForValue = AdNetworkType.getAdNetworkForValue(jSONObject.getInt("network_type"));
            AdType adTypeForValue = AdType.getAdTypeForValue(jSONObject.getInt("ad_type"));
            if (adNetworkForValue == AdNetworkType.AD_UNKOWN || adTypeForValue == AdType.UNKOWN) {
                throw new IllegalArgumentException("unsupported adapter route enum");
            }
            return new AdapterRoute(i, jSONObject.getString("network_space_id"), adNetworkForValue, jSONObject.getBoolean("is_cached"), jSONObject.getInt("bidding_type"), jSONObject.getInt("insert_style"), jSONObject.getLong("timeout"), i2, z, z2, jSONObject.getInt("native_splash_close_position"), adTypeForValue, i3);
        }
    }

    public interface AttemptCallback {
        void onFailure(int i, String str);

        void onSuccess(List<DirichletAd> list);
    }

    public interface CandidateFactory<S extends AdapterAdSession> {
        DirichletAd create(S s);
    }

    public static final class LoadPlan {
        private final List<AdapterRoute> adapterRoutes;
        private final String requestId;

        public LoadPlan(String str, List<AdapterRoute> list) {
            this.requestId = str;
            this.adapterRoutes = list;
        }

        public String getRequestId() {
            return this.requestId;
        }

        public List<AdapterRoute> getRoutes() {
            return this.adapterRoutes;
        }

        public String makeTrackId(AdapterRoute adapterRoute, int i) {
            return !this.adapterRoutes.contains(adapterRoute) ? "" : MediationRuntimeCoreBridge.makeTrackId(this.requestId, adapterRoute.routeKey, i, System.currentTimeMillis());
        }

        public void release() {
            MediationRuntimeCoreBridge.releaseLoadPlan(this.requestId);
        }
    }

    public interface LoaderPort {
        void load(Context context, AdapterRoute adapterRoute, DirichletAdRequest dirichletAdRequest, AttemptCallback attemptCallback);
    }

    public interface ProviderLoad<S extends AdapterAdSession> {
        void load(Context context, AdapterRoute adapterRoute, DirichletAdRequest dirichletAdRequest, AdapterLoadCallback<S> adapterLoadCallback);
    }

    public static final class RequestHost {
        private final AdType adType;
        private final Callback<List<DirichletAd>> callback;
        private final WeakReference<Context> context;
        private volatile LoadPlan loadPlan;
        private final DirichletAdRequest request;
        private volatile boolean schedulerCompleted;
        private volatile long schedulerRequestId;
        private final AtomicBoolean terminal = new AtomicBoolean(false);
        private final long startedAtMs = System.currentTimeMillis();
        private volatile String requestId = "";
        private final Map<Integer, Long> legacySchedulerPhases = new HashMap();

        public RequestHost(Context context, AdType adType, DirichletAdRequest dirichletAdRequest, Callback<List<DirichletAd>> callback) {
            this.context = new WeakReference<>(context);
            this.adType = adType;
            this.request = dirichletAdRequest;
            this.callback = callback;
        }

        private boolean claimTerminal(boolean z, int i, Map<String, Object> map) {
            if (!this.terminal.compareAndSet(false, true)) {
                return false;
            }
            long j = this.schedulerRequestId;
            this.schedulerRequestId = 0L;
            if (j != 0) {
                SchedulerNativeBridge.close(j);
            }
            LoadPlan loadPlan = this.loadPlan;
            this.loadPlan = null;
            try {
                finishLegacySchedulerTelemetry(this.schedulerCompleted);
                if (!this.requestId.isEmpty()) {
                    MediationTelemetryHost.report(i, map);
                }
                return true;
            } finally {
                if (loadPlan != null) {
                    if (z) {
                        MediationControlBridge.submitFillSummaryAndRelease(loadPlan.getRequestId());
                    } else {
                        loadPlan.release();
                    }
                }
            }
        }

        private List<AdapterBinding> createBindings(List<AdapterRoute> list) {
            if (list == null || list.isEmpty()) {
                return Collections.EMPTY_LIST;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (AdapterRoute adapterRoute : list) {
                AdNetworkType adNetworkType = adapterRoute.adNetworkType;
                try {
                    arrayList.add(new AdapterBinding(adapterRoute, MediationAdapterLoadHost.cachedLoaderPort(this.adType, AdNetworkCapabilityDetector.getAdapterPackageName(adNetworkType) + ".Tap" + adNetworkType.getName() + this.adType.getName() + "Loader")));
                } catch (Exception e) {
                    Map mapRouteTelemetryFields = MediationAdapterLoadHost.routeTelemetryFields(this.requestId, this.request, adapterRoute);
                    MediationAdapterLoadHost.addErrorFields(mapRouteTelemetryFields, Constants.SDK_AD_LOAD_ERROR_CODE, e.getMessage());
                    MediationTelemetryHost.report(5, mapRouteTelemetryFields);
                } catch (LinkageError e2) {
                    adNetworkType.toString();
                    e2.toString();
                    Map mapRouteTelemetryFields2 = MediationAdapterLoadHost.routeTelemetryFields(this.requestId, this.request, adapterRoute);
                    MediationAdapterLoadHost.addErrorFields(mapRouteTelemetryFields2, Constants.SDK_AD_LOAD_ERROR_CODE, e2.getMessage());
                    MediationTelemetryHost.report(5, mapRouteTelemetryFields2);
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void fail(final int i, final String str, boolean z) {
            Map<String, Object> mapRequestTelemetryFields = MediationAdapterLoadHost.requestTelemetryFields(this.requestId, this.request, this.adType);
            MediationAdapterLoadHost.addErrorFields(mapRequestTelemetryFields, i, str);
            mapRequestTelemetryFields.put(Constants.DELAY_FIELD, Long.valueOf(Math.max(0L, System.currentTimeMillis() - this.startedAtMs)));
            if (claimTerminal(z, 2, mapRequestTelemetryFields)) {
                AsyncExecutor.runOnMain(new Runnable() { // from class: com.tapsdk.tapad.group.MediationAdapterLoadHost$RequestHost$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m22lambda$fail$1$comtapsdktapadgroupMediationAdapterLoadHost$RequestHost(i, str);
                    }
                });
            }
        }

        private synchronized void finishLegacySchedulerTelemetry(boolean z) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            boolean zIsEmpty = this.legacySchedulerPhases.isEmpty();
            for (Map.Entry<Integer, Long> entry : this.legacySchedulerPhases.entrySet()) {
                reportLegacySchedulerFact(phaseCompleteFact(entry.getKey().intValue()), Math.max(0L, jCurrentTimeMillis - entry.getValue().longValue()));
            }
            this.legacySchedulerPhases.clear();
            if (z || !zIsEmpty) {
                reportLegacySchedulerFact(65, -1L);
                reportLegacySchedulerFact(z ? 73 : 74, -1L);
                reportLegacySchedulerFact(66, 0L);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void open(JSONObject jSONObject) {
            if (this.terminal.get()) {
                MediationRuntimeCoreBridge.releaseLoadPlan(jSONObject != null ? jSONObject.optString(com.tapsdk.tapad.constants.Constants.Bidding.REQUEST_ID, "") : "");
                return;
            }
            LoadPlan loadPlanMaterializeLoadPlan = MediationAdapterLoadHost.materializeLoadPlan(jSONObject, this.request.spaceId);
            if (loadPlanMaterializeLoadPlan == null) {
                MediationRuntimeCoreBridge.releaseLoadPlan(jSONObject != null ? jSONObject.optString(com.tapsdk.tapad.constants.Constants.Bidding.REQUEST_ID, "") : "");
                fail(200001, "invalid Rust load command", false);
                return;
            }
            this.loadPlan = loadPlanMaterializeLoadPlan;
            this.requestId = loadPlanMaterializeLoadPlan.getRequestId();
            List<AdapterRoute> routes = loadPlanMaterializeLoadPlan.getRoutes();
            Context context = this.context.get();
            if (context == null) {
                Map mapRequestTelemetryFields = MediationAdapterLoadHost.requestTelemetryFields(this.requestId, this.request, this.adType);
                MediationAdapterLoadHost.addErrorFields(mapRequestTelemetryFields, -1, "context 已被回收，无法继续加载广告");
                MediationTelemetryHost.report(64, mapRequestTelemetryFields);
                fail(200001, "adapter context unavailable", false);
                return;
            }
            List<AdapterBinding> listCreateBindings = createBindings(routes);
            if (listCreateBindings.isEmpty()) {
                fail(200002, this.requestId + ", 无可执行代码位", false);
                return;
            }
            Objects.toString(this.adType);
            listCreateBindings.size();
            ArrayList arrayList = new ArrayList(listCreateBindings.size());
            Iterator<AdapterBinding> it = listCreateBindings.iterator();
            while (it.hasNext()) {
                int i = it.next().route.routeKey;
                if (i <= 0) {
                    fail(MediationAdapterLoadHost.publicLoadErrorCodeForSchedulerFailure(), this.requestId + ", invalid adapter route", false);
                    return;
                }
                arrayList.add(Integer.valueOf(i));
            }
            byte[] bArrBindLoadPlan = MediationRuntimeCoreBridge.bindLoadPlan(this.requestId, arrayList);
            if (bArrBindLoadPlan.length == 0) {
                fail(MediationAdapterLoadHost.publicLoadErrorCodeForSchedulerFailure(), this.requestId + ", Rust 调度计划绑定失败", false);
                return;
            }
            long jBegin = SchedulerNativeBridge.begin(bArrBindLoadPlan);
            if (jBegin == 0) {
                fail(MediationAdapterLoadHost.publicLoadErrorCodeForSchedulerFailure(), this.requestId + ", Rust 调度初始化失败", false);
                return;
            }
            this.schedulerRequestId = jBegin;
            ArrayList arrayList2 = new ArrayList(listCreateBindings.size());
            Iterator<AdapterBinding> it2 = listCreateBindings.iterator();
            while (it2.hasNext()) {
                arrayList2.add(new AdapterAttempt(jBegin, context, it2.next(), this.request, loadPlanMaterializeLoadPlan, this));
            }
            if (SchedulerNativeBridge.start(jBegin, arrayList2, new SchedulerMechanicalAdapterExecutor.TerminalActions() { // from class: com.tapsdk.tapad.group.MediationAdapterLoadHost.RequestHost.2
                @Override // com.tapsdk.tapad.group.SchedulerMechanicalAdapterExecutor.TerminalActions
                public void complete(boolean z, List<DirichletAd> list) {
                    RequestHost.this.schedulerCompleted = true;
                    if (!z || list == null || list.isEmpty()) {
                        RequestHost.this.fail(200002, RequestHost.this.requestId + ", 无填充广告", true);
                    } else {
                        RequestHost.this.succeed(new ArrayList(list));
                    }
                }

                @Override // com.tapsdk.tapad.group.SchedulerMechanicalAdapterExecutor.TerminalActions
                public void fail(String str) {
                    RequestHost.this.fail(MediationAdapterLoadHost.publicLoadErrorCodeForSchedulerFailure(), RequestHost.this.requestId + ", Rust 调度执行失败 (" + str + ")", true);
                }
            })) {
                return;
            }
            fail(MediationAdapterLoadHost.publicLoadErrorCodeForSchedulerFailure(), this.requestId + ", Rust 调度启动失败", false);
        }

        private static int phaseCompleteFact(int i) {
            if (i == 2) {
                return 70;
            }
            if (i == 3) {
                return 72;
            }
            return i == 4 ? 68 : 0;
        }

        private static int phaseStartFact(int i) {
            if (i == 2) {
                return 69;
            }
            if (i == 3) {
                return 71;
            }
            return i == 4 ? 67 : 0;
        }

        private void reportLegacySchedulerFact(int i, long j) {
            if (i <= 0 || this.requestId.isEmpty()) {
                return;
            }
            Map mapRequestTelemetryFields = MediationAdapterLoadHost.requestTelemetryFields(this.requestId, this.request, this.adType);
            mapRequestTelemetryFields.put("ad_request_time", Long.valueOf(this.startedAtMs));
            if (j >= 0) {
                mapRequestTelemetryFields.put(Constants.DELAY_FIELD, Long.valueOf(j));
            }
            MediationTelemetryHost.report(i, mapRequestTelemetryFields);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void startLegacySchedulerPhase(int i) {
            if (phaseStartFact(i) > 0 && !this.legacySchedulerPhases.containsKey(Integer.valueOf(i))) {
                this.legacySchedulerPhases.put(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()));
                reportLegacySchedulerFact(phaseStartFact(i), -1L);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void succeed(final List<DirichletAd> list) {
            Map<String, Object> mapRequestTelemetryFields = MediationAdapterLoadHost.requestTelemetryFields(this.requestId, this.request, this.adType);
            mapRequestTelemetryFields.put("count", Integer.valueOf(list == null ? 0 : list.size()));
            mapRequestTelemetryFields.put(Constants.DELAY_FIELD, Long.valueOf(Math.max(0L, System.currentTimeMillis() - this.startedAtMs)));
            if (claimTerminal(true, 3, mapRequestTelemetryFields)) {
                if (list != null) {
                    list.size();
                }
                IoniaIdentityManager.getInstance().enrichAfterGetAds(this.requestId);
                AsyncExecutor.runOnMain(new Runnable() { // from class: com.tapsdk.tapad.group.MediationAdapterLoadHost$RequestHost$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m23lambda$succeed$0$comtapsdktapadgroupMediationAdapterLoadHost$RequestHost(list);
                    }
                });
            }
        }

        /* JADX INFO: renamed from: lambda$fail$1$com-tapsdk-tapad-group-MediationAdapterLoadHost$RequestHost, reason: not valid java name */
        /* synthetic */ void m22lambda$fail$1$comtapsdktapadgroupMediationAdapterLoadHost$RequestHost(int i, String str) {
            Callback<List<DirichletAd>> callback = this.callback;
            if (callback != null) {
                callback.onFail(new ClientException(i, str));
            }
        }

        /* JADX INFO: renamed from: lambda$succeed$0$com-tapsdk-tapad-group-MediationAdapterLoadHost$RequestHost, reason: not valid java name */
        /* synthetic */ void m23lambda$succeed$0$comtapsdktapadgroupMediationAdapterLoadHost$RequestHost(List list) {
            Callback<List<DirichletAd>> callback = this.callback;
            if (callback != null) {
                callback.onSuccess(list);
            }
        }

        public void prepare() {
            DirichletAdRequest dirichletAdRequest;
            Context context = this.context.get();
            if (!(context instanceof Activity)) {
                fail(-1, "context 必须是 Activity", false);
                return;
            }
            if (ActivityUtil.isActivityNotAlive((Activity) context)) {
                fail(-1, "activity已被销毁", false);
                return;
            }
            if (this.adType == null || (dirichletAdRequest = this.request) == null || dirichletAdRequest.spaceId <= 0) {
                fail(200001, "invalid ad request", false);
            } else {
                IoniaIdentityManager.getInstance().onAdLoadRequested();
                MediationCompositionRoot.getInstance().prepareLoad(context, this.request, this.adType, new MediationControlBridge.Callback() { // from class: com.tapsdk.tapad.group.MediationAdapterLoadHost.RequestHost.1
                    private void handleControlError(JSONObject jSONObject, int i, String str) {
                        if (jSONObject != null) {
                            RequestHost requestHost = RequestHost.this;
                            requestHost.requestId = jSONObject.optString(com.tapsdk.tapad.constants.Constants.Bidding.REQUEST_ID, requestHost.requestId);
                        }
                        int iPublicLoadErrorCodeForControlError = MediationAdapterLoadHost.publicLoadErrorCodeForControlError(i);
                        RequestHost.this.fail(iPublicLoadErrorCodeForControlError, iPublicLoadErrorCodeForControlError == 200002 ? "无填充广告 (" + i + "," + str + ")" : RequestHost.this.requestId + "," + i + "," + str, false);
                    }

                    @Override // com.tapsdk.tapad.internal.runtime.MediationControlBridge.Callback
                    public void onError(int i, String str, Throwable th) {
                        handleControlError(null, i, str);
                    }

                    @Override // com.tapsdk.tapad.internal.runtime.MediationControlBridge.Callback
                    public void onReady(JSONObject jSONObject) {
                        RequestHost.this.open(jSONObject);
                    }

                    @Override // com.tapsdk.tapad.internal.runtime.MediationControlBridge.Callback
                    public void onError(JSONObject jSONObject, int i, String str, Throwable th) {
                        handleControlError(jSONObject, i, str);
                    }
                });
            }
        }
    }

    private MediationAdapterLoadHost() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void addErrorFields(Map<String, Object> map, int i, String str) {
        map.put(Constants.ERROR_CODE_FIELD, Integer.valueOf(i));
        if (str == null) {
            str = "";
        }
        map.put(Constants.ERROR_MSG_FIELD, str);
        if (str.isEmpty()) {
            return;
        }
        map.put(Constants.ERROR_MSG_HASH_FIELD, Integer.valueOf(str.hashCode()));
    }

    private static AdapterLoadRequest baseRequest(AdapterRoute adapterRoute, DirichletAdRequest dirichletAdRequest) {
        return new AdapterLoadRequest(adapterRoute.networkSpaceId, dirichletAdRequest.expressViewAcceptedWidth, dirichletAdRequest.expressViewAcceptedHeight, adapterRoute.adsCount, adapterRoute.preload, dirichletAdRequest.minaId, dirichletAdRequest.query);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static LoaderPort cachedLoaderPort(AdType adType, String str) {
        Map<String, LoaderPort> map = ADAPTER_LOADERS;
        synchronized (map) {
            LoaderPort loaderPort = map.get(str);
            if (loaderPort != null) {
                return loaderPort;
            }
            LoaderPort loaderPort2 = loaderPort(adType, Class.forName(str).getDeclaredConstructor(null).newInstance(null));
            map.put(str, loaderPort2);
            return loaderPort2;
        }
    }

    private static <S extends AdapterAdSession> LoaderPort compose(final ProviderLoad<S> providerLoad, final CandidateFactory<S> candidateFactory) {
        return new LoaderPort() { // from class: com.tapsdk.tapad.group.MediationAdapterLoadHost$$ExternalSyntheticLambda13
            @Override // com.tapsdk.tapad.group.MediationAdapterLoadHost.LoaderPort
            public final void load(Context context, MediationAdapterLoadHost.AdapterRoute adapterRoute, DirichletAdRequest dirichletAdRequest, MediationAdapterLoadHost.AttemptCallback attemptCallback) {
                providerLoad.load(context, adapterRoute, dirichletAdRequest, new AdapterLoadCallback<S>() { // from class: com.tapsdk.tapad.group.MediationAdapterLoadHost.1
                    @Override // com.tapsdk.tapad.group.adapter.AdapterLoadCallback
                    public void onFailure(int i, String str) {
                        attemptCallback.onFailure(i, str);
                    }

                    @Override // com.tapsdk.tapad.group.adapter.AdapterLoadCallback
                    public void onSuccess(List<S> list) {
                        if (list == null || list.isEmpty()) {
                            attemptCallback.onSuccess(Collections.EMPTY_LIST);
                            return;
                        }
                        ArrayList arrayList = new ArrayList(list.size());
                        try {
                            for (S s : list) {
                                if (s != null) {
                                    DirichletAd dirichletAdCreate = candidateFactory.create(s);
                                    if (dirichletAdCreate == null) {
                                        s.destroy();
                                    } else {
                                        arrayList.add(dirichletAdCreate);
                                    }
                                }
                            }
                            attemptCallback.onSuccess(arrayList);
                        } catch (Throwable th) {
                            MediationAdapterLoadHost.destroySessions(list);
                            attemptCallback.onFailure(Constants.SDK_AD_LOAD_ERROR_CODE, "adapter session normalization failed: ".concat(th.getClass().getSimpleName()));
                        }
                    }
                });
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void destroyCandidates(List<DirichletAd> list) {
        if (list == null) {
            return;
        }
        for (DirichletAd dirichletAd : list) {
            if (dirichletAd != null) {
                dirichletAd.destroy();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void destroySessions(List<? extends AdapterAdSession> list) {
        if (list == null) {
            return;
        }
        for (AdapterAdSession adapterAdSession : list) {
            if (adapterAdSession != null) {
                adapterAdSession.destroy();
            }
        }
    }

    private static AdapterInterstitialLoadRequest interstitialRequest(AdapterRoute adapterRoute, DirichletAdRequest dirichletAdRequest) {
        return new AdapterInterstitialLoadRequest(baseRequest(adapterRoute, dirichletAdRequest), adapterRoute.insertStyle, adapterRoute.adType == AdType.NativeFeedAd, adapterRoute.timeout);
    }

    static /* synthetic */ Thread lambda$static$0(Runnable runnable) {
        return new Thread(runnable, "dirichlet_adapter");
    }

    public static void load(Context context, AdType adType, DirichletAdRequest dirichletAdRequest, Callback<List<DirichletAd>> callback) {
        new RequestHost(context, adType, dirichletAdRequest, callback).prepare();
    }

    private static LoaderPort loaderPort(AdType adType, Object obj) {
        if (adType == AdType.Banner && (obj instanceof AdapterBannerLoader)) {
            final AdapterBannerLoader adapterBannerLoader = (AdapterBannerLoader) obj;
            return compose(new ProviderLoad() { // from class: com.tapsdk.tapad.group.MediationAdapterLoadHost$$ExternalSyntheticLambda0
                @Override // com.tapsdk.tapad.group.MediationAdapterLoadHost.ProviderLoad
                public final void load(Context context, MediationAdapterLoadHost.AdapterRoute adapterRoute, DirichletAdRequest dirichletAdRequest, AdapterLoadCallback adapterLoadCallback) {
                    adapterBannerLoader.load(context, MediationAdapterLoadHost.baseRequest(adapterRoute, dirichletAdRequest), adapterLoadCallback);
                }
            }, new CandidateFactory() { // from class: com.tapsdk.tapad.group.MediationAdapterLoadHost$$ExternalSyntheticLambda3
                @Override // com.tapsdk.tapad.group.MediationAdapterLoadHost.CandidateFactory
                public final DirichletAd create(AdapterAdSession adapterAdSession) {
                    return MediationAdFactory.bannerCandidate((AdapterBannerSession) adapterAdSession);
                }
            });
        }
        if (adType == AdType.ExpressFeedAd && (obj instanceof AdapterExpressFeedLoader)) {
            final AdapterExpressFeedLoader adapterExpressFeedLoader = (AdapterExpressFeedLoader) obj;
            return compose(new ProviderLoad() { // from class: com.tapsdk.tapad.group.MediationAdapterLoadHost$$ExternalSyntheticLambda4
                @Override // com.tapsdk.tapad.group.MediationAdapterLoadHost.ProviderLoad
                public final void load(Context context, MediationAdapterLoadHost.AdapterRoute adapterRoute, DirichletAdRequest dirichletAdRequest, AdapterLoadCallback adapterLoadCallback) {
                    adapterExpressFeedLoader.load(context, MediationAdapterLoadHost.baseRequest(adapterRoute, dirichletAdRequest), adapterLoadCallback);
                }
            }, new CandidateFactory() { // from class: com.tapsdk.tapad.group.MediationAdapterLoadHost$$ExternalSyntheticLambda5
                @Override // com.tapsdk.tapad.group.MediationAdapterLoadHost.CandidateFactory
                public final DirichletAd create(AdapterAdSession adapterAdSession) {
                    return MediationAdFactory.expressFeedCandidate((AdapterExpressFeedSession) adapterAdSession);
                }
            });
        }
        if (adType == AdType.NativeFeedAd && (obj instanceof AdapterNativeFeedLoader)) {
            final AdapterNativeFeedLoader adapterNativeFeedLoader = (AdapterNativeFeedLoader) obj;
            return compose(new ProviderLoad() { // from class: com.tapsdk.tapad.group.MediationAdapterLoadHost$$ExternalSyntheticLambda6
                @Override // com.tapsdk.tapad.group.MediationAdapterLoadHost.ProviderLoad
                public final void load(Context context, MediationAdapterLoadHost.AdapterRoute adapterRoute, DirichletAdRequest dirichletAdRequest, AdapterLoadCallback adapterLoadCallback) {
                    adapterNativeFeedLoader.load(context, MediationAdapterLoadHost.baseRequest(adapterRoute, dirichletAdRequest), adapterLoadCallback);
                }
            }, new CandidateFactory() { // from class: com.tapsdk.tapad.group.MediationAdapterLoadHost$$ExternalSyntheticLambda7
                @Override // com.tapsdk.tapad.group.MediationAdapterLoadHost.CandidateFactory
                public final DirichletAd create(AdapterAdSession adapterAdSession) {
                    return MediationAdFactory.nativeFeedCandidate((AdapterNativeFeedSession) adapterAdSession);
                }
            });
        }
        if (adType == AdType.InterstitialAd && (obj instanceof AdapterInterstitialLoader)) {
            final AdapterInterstitialLoader adapterInterstitialLoader = (AdapterInterstitialLoader) obj;
            return compose(new ProviderLoad() { // from class: com.tapsdk.tapad.group.MediationAdapterLoadHost$$ExternalSyntheticLambda8
                @Override // com.tapsdk.tapad.group.MediationAdapterLoadHost.ProviderLoad
                public final void load(Context context, MediationAdapterLoadHost.AdapterRoute adapterRoute, DirichletAdRequest dirichletAdRequest, AdapterLoadCallback adapterLoadCallback) {
                    adapterInterstitialLoader.load(context, MediationAdapterLoadHost.interstitialRequest(adapterRoute, dirichletAdRequest), adapterLoadCallback);
                }
            }, new CandidateFactory() { // from class: com.tapsdk.tapad.group.MediationAdapterLoadHost$$ExternalSyntheticLambda9
                @Override // com.tapsdk.tapad.group.MediationAdapterLoadHost.CandidateFactory
                public final DirichletAd create(AdapterAdSession adapterAdSession) {
                    return MediationAdFactory.interstitialCandidate((AdapterInterstitialSession) adapterAdSession);
                }
            });
        }
        if (adType == AdType.SplashAd && (obj instanceof AdapterSplashLoader)) {
            final AdapterSplashLoader adapterSplashLoader = (AdapterSplashLoader) obj;
            return compose(new ProviderLoad() { // from class: com.tapsdk.tapad.group.MediationAdapterLoadHost$$ExternalSyntheticLambda10
                @Override // com.tapsdk.tapad.group.MediationAdapterLoadHost.ProviderLoad
                public final void load(Context context, MediationAdapterLoadHost.AdapterRoute adapterRoute, DirichletAdRequest dirichletAdRequest, AdapterLoadCallback adapterLoadCallback) {
                    adapterSplashLoader.load(context, MediationAdapterLoadHost.splashRequest(adapterRoute, dirichletAdRequest), adapterLoadCallback);
                }
            }, new CandidateFactory() { // from class: com.tapsdk.tapad.group.MediationAdapterLoadHost$$ExternalSyntheticLambda11
                @Override // com.tapsdk.tapad.group.MediationAdapterLoadHost.CandidateFactory
                public final DirichletAd create(AdapterAdSession adapterAdSession) {
                    return MediationAdFactory.splashCandidate((AdapterSplashSession) adapterAdSession);
                }
            });
        }
        if (adType != AdType.RewardedAd || !(obj instanceof AdapterRewardLoader)) {
            throw new IllegalStateException("loader does not implement the " + adType + " adapter SPI");
        }
        final AdapterRewardLoader adapterRewardLoader = (AdapterRewardLoader) obj;
        return compose(new ProviderLoad() { // from class: com.tapsdk.tapad.group.MediationAdapterLoadHost$$ExternalSyntheticLambda1
            @Override // com.tapsdk.tapad.group.MediationAdapterLoadHost.ProviderLoad
            public final void load(Context context, MediationAdapterLoadHost.AdapterRoute adapterRoute, DirichletAdRequest dirichletAdRequest, AdapterLoadCallback adapterLoadCallback) {
                adapterRewardLoader.load(context, MediationAdapterLoadHost.rewardRequest(adapterRoute, dirichletAdRequest), adapterLoadCallback);
            }
        }, new CandidateFactory() { // from class: com.tapsdk.tapad.group.MediationAdapterLoadHost$$ExternalSyntheticLambda2
            @Override // com.tapsdk.tapad.group.MediationAdapterLoadHost.CandidateFactory
            public final DirichletAd create(AdapterAdSession adapterAdSession) {
                return MediationAdFactory.rewardCandidate((AdapterRewardSession) adapterAdSession);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static LoadPlan materializeLoadPlan(JSONObject jSONObject, long j) {
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(com.tapsdk.tapad.constants.Constants.Bidding.REQUEST_ID);
            JSONObject jSONObject2 = jSONObject.getJSONObject("load");
            if (Long.parseLong(jSONObject2.getString(com.tapsdk.tapad.constants.Constants.Bidding.SPACE_ID)) != j) {
                return null;
            }
            int i = jSONObject2.getInt("count");
            boolean z = jSONObject2.getBoolean("is_preload");
            boolean z2 = jSONObject2.getBoolean("double_window");
            int i2 = jSONObject2.getInt("screen_type");
            JSONArray jSONArray = jSONObject.getJSONArray("routes");
            ArrayList arrayList = new ArrayList(jSONArray.length());
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i3);
                arrayList.add(AdapterRoute.fromCoreProjection(jSONObject3.getInt("route_key"), jSONObject3.getJSONObject("code_bit"), i, z, z2, i2));
            }
            if (!string.isEmpty() && !arrayList.isEmpty()) {
                return new LoadPlan(string, Collections.unmodifiableList(arrayList));
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    public static int publicLoadErrorCodeForControlError(int i) {
        return i == CONTROL_ERROR_SPACE_UNAVAILABLE ? 200002 : 200001;
    }

    public static int publicLoadErrorCodeForSchedulerFailure() {
        return 200001;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, Object> requestTelemetryFields(String str, DirichletAdRequest dirichletAdRequest, AdType adType) {
        HashMap map = new HashMap();
        if (str != null && !str.isEmpty()) {
            map.put(com.tapsdk.tapad.constants.Constants.Bidding.REQUEST_ID, str);
            map.put("ad_request_id", str);
        }
        if (dirichletAdRequest != null) {
            map.put(Constants.AD_SPACE_ID_FIELD, Long.valueOf(dirichletAdRequest.spaceId));
            map.put(com.tapsdk.tapad.constants.Constants.Bidding.SPACE_ID, Long.valueOf(dirichletAdRequest.spaceId));
            map.put("width", Integer.valueOf(dirichletAdRequest.expressViewAcceptedWidth));
            map.put("height", Integer.valueOf(dirichletAdRequest.expressViewAcceptedHeight));
        }
        if (adType != null) {
            String name = adType.getName();
            map.put(Constants.AD_SPACE_TYPE_FIELD, name);
            map.put("ad_type", name);
        }
        return map;
    }

    private static AdapterRewardLoadRequest rewardRequest(AdapterRoute adapterRoute, DirichletAdRequest dirichletAdRequest) {
        return new AdapterRewardLoadRequest(baseRequest(adapterRoute, dirichletAdRequest), dirichletAdRequest.expressImageAcceptedWidth, dirichletAdRequest.expressImageAcceptedHeight, adapterRoute.screenType, adapterRoute.adType == AdType.NativeFeedAd, dirichletAdRequest.rewardAmount, dirichletAdRequest.rewardName, dirichletAdRequest.userId, dirichletAdRequest.extra1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, Object> routeTelemetryFields(String str, DirichletAdRequest dirichletAdRequest, AdapterRoute adapterRoute) {
        Map<String, Object> mapRequestTelemetryFields = requestTelemetryFields(str, dirichletAdRequest, adapterRoute == null ? null : adapterRoute.adType);
        if (adapterRoute != null) {
            mapRequestTelemetryFields.put(ROUTE_KEY_FIELD, Integer.valueOf(adapterRoute.routeKey));
        }
        return mapRequestTelemetryFields;
    }

    private static AdapterSplashLoadRequest splashRequest(AdapterRoute adapterRoute, DirichletAdRequest dirichletAdRequest) {
        return new AdapterSplashLoadRequest(baseRequest(adapterRoute, dirichletAdRequest), dirichletAdRequest.expressImageAcceptedWidth, dirichletAdRequest.expressImageAcceptedHeight, adapterRoute.screenType, adapterRoute.adType == AdType.NativeFeedAd, adapterRoute.allowCached, adapterRoute.doubleWindow, adapterRoute.timeout);
    }
}
