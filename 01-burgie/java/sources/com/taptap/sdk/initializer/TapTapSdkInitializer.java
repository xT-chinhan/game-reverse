package com.taptap.sdk.initializer;

import android.content.Context;
import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.common.gaid.GAIDManager;
import com.taptap.sdk.common.gaid.helper.GAIDHelper;
import com.taptap.sdk.common.gaid.provider.ReflectionGAIDProvider;
import com.taptap.sdk.common.gaid.provider.ServiceGAIDProvider;
import com.taptap.sdk.common.gaid.repository.GAIDRepository;
import com.taptap.sdk.common.oaid.OAIDManager;
import com.taptap.sdk.common.oaid.cert.AssetOAIDCertProvider;
import com.taptap.sdk.common.oaid.cert.CompositeOAIDCertProvider;
import com.taptap.sdk.common.oaid.cert.OAIDCertProvider;
import com.taptap.sdk.common.oaid.cert.StringOAIDCertProvider;
import com.taptap.sdk.common.oaid.helper.OAIDHelper;
import com.taptap.sdk.common.oaid.repository.OAIDRepository;
import com.taptap.sdk.common.services.OpenLogService;
import com.taptap.sdk.core.DBService;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.initializer.api.SessionAwareTapInitCallback;
import com.taptap.sdk.initializer.api.TapInitCallback;
import com.taptap.sdk.initializer.api.TapInitState;
import com.taptap.sdk.initializer.api.model.Language;
import com.taptap.sdk.initializer.api.model.RegionType;
import com.taptap.sdk.initializer.api.option.TapTapSdkOptions;
import com.taptap.sdk.initializer.data.response.GateKeeper;
import com.taptap.sdk.initializer.manager.GatekeeperManager;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.TapTapKit;
import com.taptap.sdk.kit.internal.executor.TapNetExecutor;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import com.taptap.sdk.kit.internal.utils.localize.TapLocalizeUtil;
import com.taptap.sdk.servicemanager.ServiceManager;
import com.taptap.sdk.servicemanager.utils.ServiceManagerComponent;
import com.taptap.sdk.startup.StartUp;
import com.umeng.analytics.pro.d;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: compiled from: TapTapSdkInitializer.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 !2\u00020\u0001:\u0002 !B\u000f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u000fJ\b\u0010\u001a\u001a\u00020\u0000H\u0007J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001d\u001a\u00020\u001eH\u0007J\b\u0010\u001f\u001a\u00020\u0016H\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/taptap/sdk/initializer/TapTapSdkInitializer;", "", "builder", "Lcom/taptap/sdk/initializer/TapTapSdkInitializer$Builder;", "(Lcom/taptap/sdk/initializer/TapTapSdkInitializer$Builder;)V", "options", "Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "(Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;)V", "dbService", "Lcom/taptap/sdk/core/DBService;", "getDbService", "()Lcom/taptap/sdk/core/DBService;", "dbService$delegate", "Lkotlin/Lazy;", "gatekeeperManager", "Lcom/taptap/sdk/initializer/manager/GatekeeperManager;", "openLogService", "Lcom/taptap/sdk/common/services/OpenLogService;", "getOpenLogService", "()Lcom/taptap/sdk/common/services/OpenLogService;", "openLogService$delegate", TrackAction.CANCEL, "", "getCurrentGateKeeper", "Lcom/taptap/sdk/initializer/data/response/GateKeeper;", "getGateKeepManager", "initialize", d.aw, "", "isGatekeeperLoadedSuccessfully", "", "showGatekeeperError", "Builder", "Companion", "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapTapSdkInitializer {

    /* JADX INFO: renamed from: dbService$delegate, reason: from kotlin metadata */
    private final Lazy dbService;
    private GatekeeperManager gatekeeperManager;

    /* JADX INFO: renamed from: openLogService$delegate, reason: from kotlin metadata */
    private final Lazy openLogService;
    private final TapTapSdkOptions options;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AtomicReference<TapTapSdkInitializer> INSTANCE_REF = new AtomicReference<>();
    private static final AtomicReference<TapInitState> initState = new AtomicReference<>(TapInitState.Idle.INSTANCE);
    private static final CopyOnWriteArrayList<TapInitCallback> initCallbacks = new CopyOnWriteArrayList<>();
    private static final Object lock = new Object();
    private static final AtomicLong generation = new AtomicLong(0);

    public /* synthetic */ TapTapSdkInitializer(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private TapTapSdkInitializer(TapTapSdkOptions options) {
        this.options = options;
        ServiceManagerComponent serviceManagerComponent = ServiceManagerComponent.INSTANCE;
        this.openLogService = LazyKt.lazy(new Function0<OpenLogService>() { // from class: com.taptap.sdk.initializer.TapTapSdkInitializer$special$$inlined$inject$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final OpenLogService invoke() {
                ServiceManager.Service service = ServiceManager.INSTANCE.getService(OpenLogService.class);
                if (service != null) {
                    return (OpenLogService) service;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.taptap.sdk.common.services.OpenLogService");
            }
        });
        ServiceManagerComponent serviceManagerComponent2 = ServiceManagerComponent.INSTANCE;
        this.dbService = LazyKt.lazy(new Function0<DBService>() { // from class: com.taptap.sdk.initializer.TapTapSdkInitializer$special$$inlined$inject$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DBService invoke() {
                ServiceManager.Service service = ServiceManager.INSTANCE.getService(DBService.class);
                if (service != null) {
                    return (DBService) service;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.taptap.sdk.core.DBService");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OpenLogService getOpenLogService() {
        return (OpenLogService) this.openLogService.getValue();
    }

    private final DBService getDbService() {
        return (DBService) this.dbService.getValue();
    }

    private TapTapSdkInitializer(Builder builder) {
        this(builder.getOptions());
    }

    public final TapTapSdkInitializer initialize(final long session) {
        final TapTapSdkInitializer $this$initialize_u24lambda_u240 = this;
        TapLogger.INSTANCE.setEnableLog($this$initialize_u24lambda_u240.options.getEnableLog());
        TapTapKit.INSTANCE.initialize($this$initialize_u24lambda_u240.options);
        if (!$this$initialize_u24lambda_u240.options.getDisableReflectionOAID()) {
            OAIDManager.INSTANCE.attach(new OAIDManager.Builder().setRepository(new OAIDRepository(new CompositeOAIDCertProvider(CollectionsKt.listOf((Object[]) new OAIDCertProvider[]{new StringOAIDCertProvider($this$initialize_u24lambda_u240.options.getOaidCert()), new AssetOAIDCertProvider($this$initialize_u24lambda_u240.options.getContext())})), new OAIDHelper($this$initialize_u24lambda_u240.options.getContext()))).build().initialize());
        }
        if ($this$initialize_u24lambda_u240.options.getRegion() == RegionType.GLOBAL) {
            GAIDManager.INSTANCE.attach(new GAIDManager.Builder().setRepository(new GAIDRepository(new GAIDHelper.Builder($this$initialize_u24lambda_u240.options.getContext()).setReflectionGAIDProvider(new ReflectionGAIDProvider()).setServiceGAIDProvider(new ServiceGAIDProvider()).build())).build().initialize());
        }
        TapLocalizeUtil.INSTANCE.initialize($this$initialize_u24lambda_u240.options.getRegion(), $this$initialize_u24lambda_u240.options.getPreferredLanguage().getLanguage());
        new StartUp.Builder($this$initialize_u24lambda_u240.options.getContext()).setOptions($this$initialize_u24lambda_u240.options).build().initialize();
        $this$initialize_u24lambda_u240.gatekeeperManager = new GatekeeperManager.Builder($this$initialize_u24lambda_u240.options).addOnGateKeeperChangeListener(new GatekeeperManager.OnGateKeeperChangeListener() { // from class: com.taptap.sdk.initializer.TapTapSdkInitializer$initialize$1$1
            @Override // com.taptap.sdk.initializer.manager.GatekeeperManager.OnGateKeeperChangeListener
            public void onGateKeeperChange(GateKeeper newValue) {
                Intrinsics.checkNotNullParameter(newValue, "newValue");
                this.$this_apply.getOpenLogService().enableHeartbeat(newValue.getSwitch().getHeartbeat());
            }
        }).setOnInitStateChangeListener(new Function1<TapInitState, Unit>() { // from class: com.taptap.sdk.initializer.TapTapSdkInitializer$initialize$1$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TapInitState tapInitState) {
                invoke2(tapInitState);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TapInitState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                TapTapSdkInitializer.INSTANCE.updateInitState(state, session);
            }
        }).build().initialize();
        if (!$this$initialize_u24lambda_u240.options.getDisableAutoLogDeviceLogin()) {
            $this$initialize_u24lambda_u240.getDbService().sendDeviceLoginEvent($this$initialize_u24lambda_u240.options);
        }
        return this;
    }

    @Deprecated(message = "请改用 initialize(session)，session 来自 TapTapSdkInitializer.beginSession()")
    public final TapTapSdkInitializer initialize() {
        TapTapSdkInitializer $this$initialize_u24lambda_u241 = this;
        $this$initialize_u24lambda_u241.initialize(INSTANCE.beginSession());
        return this;
    }

    public final GatekeeperManager getGateKeepManager() {
        GatekeeperManager gatekeeperManager = this.gatekeeperManager;
        if (gatekeeperManager != null) {
            return gatekeeperManager;
        }
        throw new IllegalStateException("gatekeeperManager is null, please initialize it first".toString());
    }

    @Deprecated(message = "请改用 TapTapSdkInitializer.getInitState() 读取真实的会话终态")
    public final boolean isGatekeeperLoadedSuccessfully() {
        return getGateKeepManager().isGatekeeperLoadedSuccessfully();
    }

    @Deprecated(message = "请改用 TapTapSdkInitializer.getInitState() 读取真实的会话终态")
    public final void showGatekeeperError() {
        getGateKeepManager().showGatekeeperError();
    }

    public final void cancel() {
        GatekeeperManager gatekeeperManager = this.gatekeeperManager;
        if (gatekeeperManager != null) {
            gatekeeperManager.cancel();
        }
    }

    public final GateKeeper getCurrentGateKeeper() {
        return getGateKeepManager().getCurrentGateKeeper();
    }

    /* JADX INFO: compiled from: TapTapSdkInitializer.kt */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0010J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0010J\u0010\u0010\u0015\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0017J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0017J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0010J\u0010\u0010\u001e\u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010\u0017J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"J\u0010\u0010#\u001a\u00020\u00002\b\u0010$\u001a\u0004\u0018\u00010\u0017J\u000e\u0010%\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0010J\u0010\u0010&\u001a\u00020\u00002\b\u0010'\u001a\u0004\u0018\u00010(J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+J\u000e\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020.J\u000e\u0010/\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0010J\u000e\u00100\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0010J\u000e\u00101\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u00062"}, d2 = {"Lcom/taptap/sdk/initializer/TapTapSdkInitializer$Builder;", "", d.R, "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "<set-?>", "Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "options", "getOptions$tap_core_release", "()Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "build", "Lcom/taptap/sdk/initializer/TapTapSdkInitializer;", "disableAutoLogDeviceLogin", Constants.VALUE_FIELD, "", "disableReflectionOAID", "enableLog", "setAutoIAPEventEnabled", "enable", "setChannel", "channel", "", "setClientId", "clientId", "setClientToken", "clientToken", "setEnableToast", "enabled", "setGameVersion", "gameVersion", "setLanguage", "language", "Lcom/taptap/sdk/initializer/api/model/Language;", "setOAIDCert", "oaidCert", "setOverrideBuiltInParameters", "setProperties", Common.Predefined.PROPERTIES, "Lorg/json/JSONObject;", "setRegion", "region", "Lcom/taptap/sdk/initializer/api/model/RegionType;", "setScreenOrientation", "orientation", "", "setShowSwitchAccount", "setTapEventEnable", "setUseAgeRange", "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Builder {
        private final Context context;
        private TapTapSdkOptions options;

        public Builder(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
            this.options = new TapTapSdkOptions(context, null, null, null, null, null, false, false, null, null, false, null, false, false, false, false, false, 0, false, 524286, null);
        }

        public final Context getContext() {
            return this.context;
        }

        /* JADX INFO: renamed from: getOptions$tap_core_release, reason: from getter */
        public final TapTapSdkOptions getOptions() {
            return this.options;
        }

        public final Builder setClientId(String clientId) {
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Builder $this$setClientId_u24lambda_u240 = this;
            TapTapSdkOptions tapTapSdkOptions = $this$setClientId_u24lambda_u240.options;
            $this$setClientId_u24lambda_u240.options = tapTapSdkOptions.copy((458751 & 1) != 0 ? tapTapSdkOptions.context : null, (458751 & 2) != 0 ? tapTapSdkOptions.clientId : clientId, (458751 & 4) != 0 ? tapTapSdkOptions.clientToken : null, (458751 & 8) != 0 ? tapTapSdkOptions.region : null, (458751 & 16) != 0 ? tapTapSdkOptions.channel : null, (458751 & 32) != 0 ? tapTapSdkOptions.gameVersion : null, (458751 & 64) != 0 ? tapTapSdkOptions.autoIAPEventEnabled : false, (458751 & 128) != 0 ? tapTapSdkOptions.overrideBuiltInParameters : false, (458751 & 256) != 0 ? tapTapSdkOptions.properties : null, (458751 & 512) != 0 ? tapTapSdkOptions.oaidCert : null, (458751 & 1024) != 0 ? tapTapSdkOptions.enableLog : false, (458751 & 2048) != 0 ? tapTapSdkOptions.preferredLanguage : null, (458751 & 4096) != 0 ? tapTapSdkOptions.useAgeRange : false, (458751 & 8192) != 0 ? tapTapSdkOptions.showSwitchAccount : false, (458751 & 16384) != 0 ? tapTapSdkOptions.enableToast : false, (458751 & 32768) != 0 ? tapTapSdkOptions.disableReflectionOAID : false, (458751 & 65536) != 0 ? tapTapSdkOptions.disableAutoLogDeviceLogin : false, (458751 & 131072) != 0 ? tapTapSdkOptions.screenOrientation : 0, (458751 & 262144) != 0 ? tapTapSdkOptions.enableTapTapEvent : false);
            return this;
        }

        public final Builder enableLog(boolean enableLog) {
            Builder $this$enableLog_u24lambda_u241 = this;
            TapTapSdkOptions tapTapSdkOptions = $this$enableLog_u24lambda_u241.options;
            $this$enableLog_u24lambda_u241.options = tapTapSdkOptions.copy((458751 & 1) != 0 ? tapTapSdkOptions.context : null, (458751 & 2) != 0 ? tapTapSdkOptions.clientId : null, (458751 & 4) != 0 ? tapTapSdkOptions.clientToken : null, (458751 & 8) != 0 ? tapTapSdkOptions.region : null, (458751 & 16) != 0 ? tapTapSdkOptions.channel : null, (458751 & 32) != 0 ? tapTapSdkOptions.gameVersion : null, (458751 & 64) != 0 ? tapTapSdkOptions.autoIAPEventEnabled : false, (458751 & 128) != 0 ? tapTapSdkOptions.overrideBuiltInParameters : false, (458751 & 256) != 0 ? tapTapSdkOptions.properties : null, (458751 & 512) != 0 ? tapTapSdkOptions.oaidCert : null, (458751 & 1024) != 0 ? tapTapSdkOptions.enableLog : enableLog, (458751 & 2048) != 0 ? tapTapSdkOptions.preferredLanguage : null, (458751 & 4096) != 0 ? tapTapSdkOptions.useAgeRange : false, (458751 & 8192) != 0 ? tapTapSdkOptions.showSwitchAccount : false, (458751 & 16384) != 0 ? tapTapSdkOptions.enableToast : false, (458751 & 32768) != 0 ? tapTapSdkOptions.disableReflectionOAID : false, (458751 & 65536) != 0 ? tapTapSdkOptions.disableAutoLogDeviceLogin : false, (458751 & 131072) != 0 ? tapTapSdkOptions.screenOrientation : 0, (458751 & 262144) != 0 ? tapTapSdkOptions.enableTapTapEvent : false);
            return this;
        }

        public final Builder setOAIDCert(String oaidCert) {
            Builder $this$setOAIDCert_u24lambda_u242 = this;
            TapTapSdkOptions tapTapSdkOptions = $this$setOAIDCert_u24lambda_u242.options;
            $this$setOAIDCert_u24lambda_u242.options = tapTapSdkOptions.copy((458751 & 1) != 0 ? tapTapSdkOptions.context : null, (458751 & 2) != 0 ? tapTapSdkOptions.clientId : null, (458751 & 4) != 0 ? tapTapSdkOptions.clientToken : null, (458751 & 8) != 0 ? tapTapSdkOptions.region : null, (458751 & 16) != 0 ? tapTapSdkOptions.channel : null, (458751 & 32) != 0 ? tapTapSdkOptions.gameVersion : null, (458751 & 64) != 0 ? tapTapSdkOptions.autoIAPEventEnabled : false, (458751 & 128) != 0 ? tapTapSdkOptions.overrideBuiltInParameters : false, (458751 & 256) != 0 ? tapTapSdkOptions.properties : null, (458751 & 512) != 0 ? tapTapSdkOptions.oaidCert : oaidCert, (458751 & 1024) != 0 ? tapTapSdkOptions.enableLog : false, (458751 & 2048) != 0 ? tapTapSdkOptions.preferredLanguage : null, (458751 & 4096) != 0 ? tapTapSdkOptions.useAgeRange : false, (458751 & 8192) != 0 ? tapTapSdkOptions.showSwitchAccount : false, (458751 & 16384) != 0 ? tapTapSdkOptions.enableToast : false, (458751 & 32768) != 0 ? tapTapSdkOptions.disableReflectionOAID : false, (458751 & 65536) != 0 ? tapTapSdkOptions.disableAutoLogDeviceLogin : false, (458751 & 131072) != 0 ? tapTapSdkOptions.screenOrientation : 0, (458751 & 262144) != 0 ? tapTapSdkOptions.enableTapTapEvent : false);
            return this;
        }

        public final Builder setRegion(RegionType region) {
            Intrinsics.checkNotNullParameter(region, "region");
            Builder $this$setRegion_u24lambda_u243 = this;
            TapTapSdkOptions tapTapSdkOptions = $this$setRegion_u24lambda_u243.options;
            $this$setRegion_u24lambda_u243.options = tapTapSdkOptions.copy((458751 & 1) != 0 ? tapTapSdkOptions.context : null, (458751 & 2) != 0 ? tapTapSdkOptions.clientId : null, (458751 & 4) != 0 ? tapTapSdkOptions.clientToken : null, (458751 & 8) != 0 ? tapTapSdkOptions.region : region, (458751 & 16) != 0 ? tapTapSdkOptions.channel : null, (458751 & 32) != 0 ? tapTapSdkOptions.gameVersion : null, (458751 & 64) != 0 ? tapTapSdkOptions.autoIAPEventEnabled : false, (458751 & 128) != 0 ? tapTapSdkOptions.overrideBuiltInParameters : false, (458751 & 256) != 0 ? tapTapSdkOptions.properties : null, (458751 & 512) != 0 ? tapTapSdkOptions.oaidCert : null, (458751 & 1024) != 0 ? tapTapSdkOptions.enableLog : false, (458751 & 2048) != 0 ? tapTapSdkOptions.preferredLanguage : null, (458751 & 4096) != 0 ? tapTapSdkOptions.useAgeRange : false, (458751 & 8192) != 0 ? tapTapSdkOptions.showSwitchAccount : false, (458751 & 16384) != 0 ? tapTapSdkOptions.enableToast : false, (458751 & 32768) != 0 ? tapTapSdkOptions.disableReflectionOAID : false, (458751 & 65536) != 0 ? tapTapSdkOptions.disableAutoLogDeviceLogin : false, (458751 & 131072) != 0 ? tapTapSdkOptions.screenOrientation : 0, (458751 & 262144) != 0 ? tapTapSdkOptions.enableTapTapEvent : false);
            return this;
        }

        public final Builder setClientToken(String clientToken) {
            Intrinsics.checkNotNullParameter(clientToken, "clientToken");
            Builder $this$setClientToken_u24lambda_u244 = this;
            TapTapSdkOptions tapTapSdkOptions = $this$setClientToken_u24lambda_u244.options;
            $this$setClientToken_u24lambda_u244.options = tapTapSdkOptions.copy((458751 & 1) != 0 ? tapTapSdkOptions.context : null, (458751 & 2) != 0 ? tapTapSdkOptions.clientId : null, (458751 & 4) != 0 ? tapTapSdkOptions.clientToken : clientToken, (458751 & 8) != 0 ? tapTapSdkOptions.region : null, (458751 & 16) != 0 ? tapTapSdkOptions.channel : null, (458751 & 32) != 0 ? tapTapSdkOptions.gameVersion : null, (458751 & 64) != 0 ? tapTapSdkOptions.autoIAPEventEnabled : false, (458751 & 128) != 0 ? tapTapSdkOptions.overrideBuiltInParameters : false, (458751 & 256) != 0 ? tapTapSdkOptions.properties : null, (458751 & 512) != 0 ? tapTapSdkOptions.oaidCert : null, (458751 & 1024) != 0 ? tapTapSdkOptions.enableLog : false, (458751 & 2048) != 0 ? tapTapSdkOptions.preferredLanguage : null, (458751 & 4096) != 0 ? tapTapSdkOptions.useAgeRange : false, (458751 & 8192) != 0 ? tapTapSdkOptions.showSwitchAccount : false, (458751 & 16384) != 0 ? tapTapSdkOptions.enableToast : false, (458751 & 32768) != 0 ? tapTapSdkOptions.disableReflectionOAID : false, (458751 & 65536) != 0 ? tapTapSdkOptions.disableAutoLogDeviceLogin : false, (458751 & 131072) != 0 ? tapTapSdkOptions.screenOrientation : 0, (458751 & 262144) != 0 ? tapTapSdkOptions.enableTapTapEvent : false);
            return this;
        }

        public final Builder setLanguage(Language language) {
            Intrinsics.checkNotNullParameter(language, "language");
            Builder $this$setLanguage_u24lambda_u245 = this;
            TapTapSdkOptions tapTapSdkOptions = $this$setLanguage_u24lambda_u245.options;
            $this$setLanguage_u24lambda_u245.options = tapTapSdkOptions.copy((458751 & 1) != 0 ? tapTapSdkOptions.context : null, (458751 & 2) != 0 ? tapTapSdkOptions.clientId : null, (458751 & 4) != 0 ? tapTapSdkOptions.clientToken : null, (458751 & 8) != 0 ? tapTapSdkOptions.region : null, (458751 & 16) != 0 ? tapTapSdkOptions.channel : null, (458751 & 32) != 0 ? tapTapSdkOptions.gameVersion : null, (458751 & 64) != 0 ? tapTapSdkOptions.autoIAPEventEnabled : false, (458751 & 128) != 0 ? tapTapSdkOptions.overrideBuiltInParameters : false, (458751 & 256) != 0 ? tapTapSdkOptions.properties : null, (458751 & 512) != 0 ? tapTapSdkOptions.oaidCert : null, (458751 & 1024) != 0 ? tapTapSdkOptions.enableLog : false, (458751 & 2048) != 0 ? tapTapSdkOptions.preferredLanguage : language, (458751 & 4096) != 0 ? tapTapSdkOptions.useAgeRange : false, (458751 & 8192) != 0 ? tapTapSdkOptions.showSwitchAccount : false, (458751 & 16384) != 0 ? tapTapSdkOptions.enableToast : false, (458751 & 32768) != 0 ? tapTapSdkOptions.disableReflectionOAID : false, (458751 & 65536) != 0 ? tapTapSdkOptions.disableAutoLogDeviceLogin : false, (458751 & 131072) != 0 ? tapTapSdkOptions.screenOrientation : 0, (458751 & 262144) != 0 ? tapTapSdkOptions.enableTapTapEvent : false);
            return this;
        }

        public final Builder setProperties(JSONObject properties) {
            Builder $this$setProperties_u24lambda_u246 = this;
            TapTapSdkOptions tapTapSdkOptions = $this$setProperties_u24lambda_u246.options;
            $this$setProperties_u24lambda_u246.options = tapTapSdkOptions.copy((458751 & 1) != 0 ? tapTapSdkOptions.context : null, (458751 & 2) != 0 ? tapTapSdkOptions.clientId : null, (458751 & 4) != 0 ? tapTapSdkOptions.clientToken : null, (458751 & 8) != 0 ? tapTapSdkOptions.region : null, (458751 & 16) != 0 ? tapTapSdkOptions.channel : null, (458751 & 32) != 0 ? tapTapSdkOptions.gameVersion : null, (458751 & 64) != 0 ? tapTapSdkOptions.autoIAPEventEnabled : false, (458751 & 128) != 0 ? tapTapSdkOptions.overrideBuiltInParameters : false, (458751 & 256) != 0 ? tapTapSdkOptions.properties : properties, (458751 & 512) != 0 ? tapTapSdkOptions.oaidCert : null, (458751 & 1024) != 0 ? tapTapSdkOptions.enableLog : false, (458751 & 2048) != 0 ? tapTapSdkOptions.preferredLanguage : null, (458751 & 4096) != 0 ? tapTapSdkOptions.useAgeRange : false, (458751 & 8192) != 0 ? tapTapSdkOptions.showSwitchAccount : false, (458751 & 16384) != 0 ? tapTapSdkOptions.enableToast : false, (458751 & 32768) != 0 ? tapTapSdkOptions.disableReflectionOAID : false, (458751 & 65536) != 0 ? tapTapSdkOptions.disableAutoLogDeviceLogin : false, (458751 & 131072) != 0 ? tapTapSdkOptions.screenOrientation : 0, (458751 & 262144) != 0 ? tapTapSdkOptions.enableTapTapEvent : false);
            return this;
        }

        public final Builder setChannel(String channel) {
            Builder $this$setChannel_u24lambda_u247 = this;
            TapTapSdkOptions tapTapSdkOptions = $this$setChannel_u24lambda_u247.options;
            $this$setChannel_u24lambda_u247.options = tapTapSdkOptions.copy((458751 & 1) != 0 ? tapTapSdkOptions.context : null, (458751 & 2) != 0 ? tapTapSdkOptions.clientId : null, (458751 & 4) != 0 ? tapTapSdkOptions.clientToken : null, (458751 & 8) != 0 ? tapTapSdkOptions.region : null, (458751 & 16) != 0 ? tapTapSdkOptions.channel : channel, (458751 & 32) != 0 ? tapTapSdkOptions.gameVersion : null, (458751 & 64) != 0 ? tapTapSdkOptions.autoIAPEventEnabled : false, (458751 & 128) != 0 ? tapTapSdkOptions.overrideBuiltInParameters : false, (458751 & 256) != 0 ? tapTapSdkOptions.properties : null, (458751 & 512) != 0 ? tapTapSdkOptions.oaidCert : null, (458751 & 1024) != 0 ? tapTapSdkOptions.enableLog : false, (458751 & 2048) != 0 ? tapTapSdkOptions.preferredLanguage : null, (458751 & 4096) != 0 ? tapTapSdkOptions.useAgeRange : false, (458751 & 8192) != 0 ? tapTapSdkOptions.showSwitchAccount : false, (458751 & 16384) != 0 ? tapTapSdkOptions.enableToast : false, (458751 & 32768) != 0 ? tapTapSdkOptions.disableReflectionOAID : false, (458751 & 65536) != 0 ? tapTapSdkOptions.disableAutoLogDeviceLogin : false, (458751 & 131072) != 0 ? tapTapSdkOptions.screenOrientation : 0, (458751 & 262144) != 0 ? tapTapSdkOptions.enableTapTapEvent : false);
            return this;
        }

        public final Builder setAutoIAPEventEnabled(boolean enable) {
            Builder $this$setAutoIAPEventEnabled_u24lambda_u248 = this;
            TapTapSdkOptions tapTapSdkOptions = $this$setAutoIAPEventEnabled_u24lambda_u248.options;
            $this$setAutoIAPEventEnabled_u24lambda_u248.options = tapTapSdkOptions.copy((458751 & 1) != 0 ? tapTapSdkOptions.context : null, (458751 & 2) != 0 ? tapTapSdkOptions.clientId : null, (458751 & 4) != 0 ? tapTapSdkOptions.clientToken : null, (458751 & 8) != 0 ? tapTapSdkOptions.region : null, (458751 & 16) != 0 ? tapTapSdkOptions.channel : null, (458751 & 32) != 0 ? tapTapSdkOptions.gameVersion : null, (458751 & 64) != 0 ? tapTapSdkOptions.autoIAPEventEnabled : enable, (458751 & 128) != 0 ? tapTapSdkOptions.overrideBuiltInParameters : false, (458751 & 256) != 0 ? tapTapSdkOptions.properties : null, (458751 & 512) != 0 ? tapTapSdkOptions.oaidCert : null, (458751 & 1024) != 0 ? tapTapSdkOptions.enableLog : false, (458751 & 2048) != 0 ? tapTapSdkOptions.preferredLanguage : null, (458751 & 4096) != 0 ? tapTapSdkOptions.useAgeRange : false, (458751 & 8192) != 0 ? tapTapSdkOptions.showSwitchAccount : false, (458751 & 16384) != 0 ? tapTapSdkOptions.enableToast : false, (458751 & 32768) != 0 ? tapTapSdkOptions.disableReflectionOAID : false, (458751 & 65536) != 0 ? tapTapSdkOptions.disableAutoLogDeviceLogin : false, (458751 & 131072) != 0 ? tapTapSdkOptions.screenOrientation : 0, (458751 & 262144) != 0 ? tapTapSdkOptions.enableTapTapEvent : false);
            return this;
        }

        public final Builder setOverrideBuiltInParameters(boolean enable) {
            Builder $this$setOverrideBuiltInParameters_u24lambda_u249 = this;
            TapTapSdkOptions tapTapSdkOptions = $this$setOverrideBuiltInParameters_u24lambda_u249.options;
            $this$setOverrideBuiltInParameters_u24lambda_u249.options = tapTapSdkOptions.copy((458751 & 1) != 0 ? tapTapSdkOptions.context : null, (458751 & 2) != 0 ? tapTapSdkOptions.clientId : null, (458751 & 4) != 0 ? tapTapSdkOptions.clientToken : null, (458751 & 8) != 0 ? tapTapSdkOptions.region : null, (458751 & 16) != 0 ? tapTapSdkOptions.channel : null, (458751 & 32) != 0 ? tapTapSdkOptions.gameVersion : null, (458751 & 64) != 0 ? tapTapSdkOptions.autoIAPEventEnabled : false, (458751 & 128) != 0 ? tapTapSdkOptions.overrideBuiltInParameters : enable, (458751 & 256) != 0 ? tapTapSdkOptions.properties : null, (458751 & 512) != 0 ? tapTapSdkOptions.oaidCert : null, (458751 & 1024) != 0 ? tapTapSdkOptions.enableLog : false, (458751 & 2048) != 0 ? tapTapSdkOptions.preferredLanguage : null, (458751 & 4096) != 0 ? tapTapSdkOptions.useAgeRange : false, (458751 & 8192) != 0 ? tapTapSdkOptions.showSwitchAccount : false, (458751 & 16384) != 0 ? tapTapSdkOptions.enableToast : false, (458751 & 32768) != 0 ? tapTapSdkOptions.disableReflectionOAID : false, (458751 & 65536) != 0 ? tapTapSdkOptions.disableAutoLogDeviceLogin : false, (458751 & 131072) != 0 ? tapTapSdkOptions.screenOrientation : 0, (458751 & 262144) != 0 ? tapTapSdkOptions.enableTapTapEvent : false);
            return this;
        }

        public final Builder setGameVersion(String gameVersion) {
            Builder $this$setGameVersion_u24lambda_u2410 = this;
            TapTapSdkOptions tapTapSdkOptions = $this$setGameVersion_u24lambda_u2410.options;
            $this$setGameVersion_u24lambda_u2410.options = tapTapSdkOptions.copy((458751 & 1) != 0 ? tapTapSdkOptions.context : null, (458751 & 2) != 0 ? tapTapSdkOptions.clientId : null, (458751 & 4) != 0 ? tapTapSdkOptions.clientToken : null, (458751 & 8) != 0 ? tapTapSdkOptions.region : null, (458751 & 16) != 0 ? tapTapSdkOptions.channel : null, (458751 & 32) != 0 ? tapTapSdkOptions.gameVersion : gameVersion, (458751 & 64) != 0 ? tapTapSdkOptions.autoIAPEventEnabled : false, (458751 & 128) != 0 ? tapTapSdkOptions.overrideBuiltInParameters : false, (458751 & 256) != 0 ? tapTapSdkOptions.properties : null, (458751 & 512) != 0 ? tapTapSdkOptions.oaidCert : null, (458751 & 1024) != 0 ? tapTapSdkOptions.enableLog : false, (458751 & 2048) != 0 ? tapTapSdkOptions.preferredLanguage : null, (458751 & 4096) != 0 ? tapTapSdkOptions.useAgeRange : false, (458751 & 8192) != 0 ? tapTapSdkOptions.showSwitchAccount : false, (458751 & 16384) != 0 ? tapTapSdkOptions.enableToast : false, (458751 & 32768) != 0 ? tapTapSdkOptions.disableReflectionOAID : false, (458751 & 65536) != 0 ? tapTapSdkOptions.disableAutoLogDeviceLogin : false, (458751 & 131072) != 0 ? tapTapSdkOptions.screenOrientation : 0, (458751 & 262144) != 0 ? tapTapSdkOptions.enableTapTapEvent : false);
            return this;
        }

        public final Builder setEnableToast(boolean enabled) {
            Builder $this$setEnableToast_u24lambda_u2411 = this;
            TapTapSdkOptions tapTapSdkOptions = $this$setEnableToast_u24lambda_u2411.options;
            $this$setEnableToast_u24lambda_u2411.options = tapTapSdkOptions.copy((458751 & 1) != 0 ? tapTapSdkOptions.context : null, (458751 & 2) != 0 ? tapTapSdkOptions.clientId : null, (458751 & 4) != 0 ? tapTapSdkOptions.clientToken : null, (458751 & 8) != 0 ? tapTapSdkOptions.region : null, (458751 & 16) != 0 ? tapTapSdkOptions.channel : null, (458751 & 32) != 0 ? tapTapSdkOptions.gameVersion : null, (458751 & 64) != 0 ? tapTapSdkOptions.autoIAPEventEnabled : false, (458751 & 128) != 0 ? tapTapSdkOptions.overrideBuiltInParameters : false, (458751 & 256) != 0 ? tapTapSdkOptions.properties : null, (458751 & 512) != 0 ? tapTapSdkOptions.oaidCert : null, (458751 & 1024) != 0 ? tapTapSdkOptions.enableLog : false, (458751 & 2048) != 0 ? tapTapSdkOptions.preferredLanguage : null, (458751 & 4096) != 0 ? tapTapSdkOptions.useAgeRange : false, (458751 & 8192) != 0 ? tapTapSdkOptions.showSwitchAccount : false, (458751 & 16384) != 0 ? tapTapSdkOptions.enableToast : enabled, (458751 & 32768) != 0 ? tapTapSdkOptions.disableReflectionOAID : false, (458751 & 65536) != 0 ? tapTapSdkOptions.disableAutoLogDeviceLogin : false, (458751 & 131072) != 0 ? tapTapSdkOptions.screenOrientation : 0, (458751 & 262144) != 0 ? tapTapSdkOptions.enableTapTapEvent : false);
            return this;
        }

        public final Builder setShowSwitchAccount(boolean enabled) {
            Builder $this$setShowSwitchAccount_u24lambda_u2412 = this;
            TapTapSdkOptions tapTapSdkOptions = $this$setShowSwitchAccount_u24lambda_u2412.options;
            $this$setShowSwitchAccount_u24lambda_u2412.options = tapTapSdkOptions.copy((458751 & 1) != 0 ? tapTapSdkOptions.context : null, (458751 & 2) != 0 ? tapTapSdkOptions.clientId : null, (458751 & 4) != 0 ? tapTapSdkOptions.clientToken : null, (458751 & 8) != 0 ? tapTapSdkOptions.region : null, (458751 & 16) != 0 ? tapTapSdkOptions.channel : null, (458751 & 32) != 0 ? tapTapSdkOptions.gameVersion : null, (458751 & 64) != 0 ? tapTapSdkOptions.autoIAPEventEnabled : false, (458751 & 128) != 0 ? tapTapSdkOptions.overrideBuiltInParameters : false, (458751 & 256) != 0 ? tapTapSdkOptions.properties : null, (458751 & 512) != 0 ? tapTapSdkOptions.oaidCert : null, (458751 & 1024) != 0 ? tapTapSdkOptions.enableLog : false, (458751 & 2048) != 0 ? tapTapSdkOptions.preferredLanguage : null, (458751 & 4096) != 0 ? tapTapSdkOptions.useAgeRange : false, (458751 & 8192) != 0 ? tapTapSdkOptions.showSwitchAccount : enabled, (458751 & 16384) != 0 ? tapTapSdkOptions.enableToast : false, (458751 & 32768) != 0 ? tapTapSdkOptions.disableReflectionOAID : false, (458751 & 65536) != 0 ? tapTapSdkOptions.disableAutoLogDeviceLogin : false, (458751 & 131072) != 0 ? tapTapSdkOptions.screenOrientation : 0, (458751 & 262144) != 0 ? tapTapSdkOptions.enableTapTapEvent : false);
            return this;
        }

        public final Builder setUseAgeRange(boolean enabled) {
            Builder $this$setUseAgeRange_u24lambda_u2413 = this;
            TapTapSdkOptions tapTapSdkOptions = $this$setUseAgeRange_u24lambda_u2413.options;
            $this$setUseAgeRange_u24lambda_u2413.options = tapTapSdkOptions.copy((458751 & 1) != 0 ? tapTapSdkOptions.context : null, (458751 & 2) != 0 ? tapTapSdkOptions.clientId : null, (458751 & 4) != 0 ? tapTapSdkOptions.clientToken : null, (458751 & 8) != 0 ? tapTapSdkOptions.region : null, (458751 & 16) != 0 ? tapTapSdkOptions.channel : null, (458751 & 32) != 0 ? tapTapSdkOptions.gameVersion : null, (458751 & 64) != 0 ? tapTapSdkOptions.autoIAPEventEnabled : false, (458751 & 128) != 0 ? tapTapSdkOptions.overrideBuiltInParameters : false, (458751 & 256) != 0 ? tapTapSdkOptions.properties : null, (458751 & 512) != 0 ? tapTapSdkOptions.oaidCert : null, (458751 & 1024) != 0 ? tapTapSdkOptions.enableLog : false, (458751 & 2048) != 0 ? tapTapSdkOptions.preferredLanguage : null, (458751 & 4096) != 0 ? tapTapSdkOptions.useAgeRange : enabled, (458751 & 8192) != 0 ? tapTapSdkOptions.showSwitchAccount : false, (458751 & 16384) != 0 ? tapTapSdkOptions.enableToast : false, (458751 & 32768) != 0 ? tapTapSdkOptions.disableReflectionOAID : false, (458751 & 65536) != 0 ? tapTapSdkOptions.disableAutoLogDeviceLogin : false, (458751 & 131072) != 0 ? tapTapSdkOptions.screenOrientation : 0, (458751 & 262144) != 0 ? tapTapSdkOptions.enableTapTapEvent : false);
            return this;
        }

        public final Builder setScreenOrientation(int orientation) {
            Builder $this$setScreenOrientation_u24lambda_u2414 = this;
            TapTapSdkOptions tapTapSdkOptions = $this$setScreenOrientation_u24lambda_u2414.options;
            $this$setScreenOrientation_u24lambda_u2414.options = tapTapSdkOptions.copy((458751 & 1) != 0 ? tapTapSdkOptions.context : null, (458751 & 2) != 0 ? tapTapSdkOptions.clientId : null, (458751 & 4) != 0 ? tapTapSdkOptions.clientToken : null, (458751 & 8) != 0 ? tapTapSdkOptions.region : null, (458751 & 16) != 0 ? tapTapSdkOptions.channel : null, (458751 & 32) != 0 ? tapTapSdkOptions.gameVersion : null, (458751 & 64) != 0 ? tapTapSdkOptions.autoIAPEventEnabled : false, (458751 & 128) != 0 ? tapTapSdkOptions.overrideBuiltInParameters : false, (458751 & 256) != 0 ? tapTapSdkOptions.properties : null, (458751 & 512) != 0 ? tapTapSdkOptions.oaidCert : null, (458751 & 1024) != 0 ? tapTapSdkOptions.enableLog : false, (458751 & 2048) != 0 ? tapTapSdkOptions.preferredLanguage : null, (458751 & 4096) != 0 ? tapTapSdkOptions.useAgeRange : false, (458751 & 8192) != 0 ? tapTapSdkOptions.showSwitchAccount : false, (458751 & 16384) != 0 ? tapTapSdkOptions.enableToast : false, (458751 & 32768) != 0 ? tapTapSdkOptions.disableReflectionOAID : false, (458751 & 65536) != 0 ? tapTapSdkOptions.disableAutoLogDeviceLogin : false, (458751 & 131072) != 0 ? tapTapSdkOptions.screenOrientation : orientation, (458751 & 262144) != 0 ? tapTapSdkOptions.enableTapTapEvent : false);
            return this;
        }

        public final Builder disableReflectionOAID(boolean value) {
            Builder $this$disableReflectionOAID_u24lambda_u2415 = this;
            TapTapSdkOptions tapTapSdkOptions = $this$disableReflectionOAID_u24lambda_u2415.options;
            $this$disableReflectionOAID_u24lambda_u2415.options = tapTapSdkOptions.copy((458751 & 1) != 0 ? tapTapSdkOptions.context : null, (458751 & 2) != 0 ? tapTapSdkOptions.clientId : null, (458751 & 4) != 0 ? tapTapSdkOptions.clientToken : null, (458751 & 8) != 0 ? tapTapSdkOptions.region : null, (458751 & 16) != 0 ? tapTapSdkOptions.channel : null, (458751 & 32) != 0 ? tapTapSdkOptions.gameVersion : null, (458751 & 64) != 0 ? tapTapSdkOptions.autoIAPEventEnabled : false, (458751 & 128) != 0 ? tapTapSdkOptions.overrideBuiltInParameters : false, (458751 & 256) != 0 ? tapTapSdkOptions.properties : null, (458751 & 512) != 0 ? tapTapSdkOptions.oaidCert : null, (458751 & 1024) != 0 ? tapTapSdkOptions.enableLog : false, (458751 & 2048) != 0 ? tapTapSdkOptions.preferredLanguage : null, (458751 & 4096) != 0 ? tapTapSdkOptions.useAgeRange : false, (458751 & 8192) != 0 ? tapTapSdkOptions.showSwitchAccount : false, (458751 & 16384) != 0 ? tapTapSdkOptions.enableToast : false, (458751 & 32768) != 0 ? tapTapSdkOptions.disableReflectionOAID : value, (458751 & 65536) != 0 ? tapTapSdkOptions.disableAutoLogDeviceLogin : false, (458751 & 131072) != 0 ? tapTapSdkOptions.screenOrientation : 0, (458751 & 262144) != 0 ? tapTapSdkOptions.enableTapTapEvent : false);
            return this;
        }

        public final Builder disableAutoLogDeviceLogin(boolean value) {
            Builder $this$disableAutoLogDeviceLogin_u24lambda_u2416 = this;
            TapTapSdkOptions tapTapSdkOptions = $this$disableAutoLogDeviceLogin_u24lambda_u2416.options;
            $this$disableAutoLogDeviceLogin_u24lambda_u2416.options = tapTapSdkOptions.copy((458751 & 1) != 0 ? tapTapSdkOptions.context : null, (458751 & 2) != 0 ? tapTapSdkOptions.clientId : null, (458751 & 4) != 0 ? tapTapSdkOptions.clientToken : null, (458751 & 8) != 0 ? tapTapSdkOptions.region : null, (458751 & 16) != 0 ? tapTapSdkOptions.channel : null, (458751 & 32) != 0 ? tapTapSdkOptions.gameVersion : null, (458751 & 64) != 0 ? tapTapSdkOptions.autoIAPEventEnabled : false, (458751 & 128) != 0 ? tapTapSdkOptions.overrideBuiltInParameters : false, (458751 & 256) != 0 ? tapTapSdkOptions.properties : null, (458751 & 512) != 0 ? tapTapSdkOptions.oaidCert : null, (458751 & 1024) != 0 ? tapTapSdkOptions.enableLog : false, (458751 & 2048) != 0 ? tapTapSdkOptions.preferredLanguage : null, (458751 & 4096) != 0 ? tapTapSdkOptions.useAgeRange : false, (458751 & 8192) != 0 ? tapTapSdkOptions.showSwitchAccount : false, (458751 & 16384) != 0 ? tapTapSdkOptions.enableToast : false, (458751 & 32768) != 0 ? tapTapSdkOptions.disableReflectionOAID : false, (458751 & 65536) != 0 ? tapTapSdkOptions.disableAutoLogDeviceLogin : value, (458751 & 131072) != 0 ? tapTapSdkOptions.screenOrientation : 0, (458751 & 262144) != 0 ? tapTapSdkOptions.enableTapTapEvent : false);
            return this;
        }

        public final Builder setTapEventEnable(boolean enabled) {
            Builder $this$setTapEventEnable_u24lambda_u2417 = this;
            TapTapSdkOptions tapTapSdkOptions = $this$setTapEventEnable_u24lambda_u2417.options;
            $this$setTapEventEnable_u24lambda_u2417.options = tapTapSdkOptions.copy((458751 & 1) != 0 ? tapTapSdkOptions.context : null, (458751 & 2) != 0 ? tapTapSdkOptions.clientId : null, (458751 & 4) != 0 ? tapTapSdkOptions.clientToken : null, (458751 & 8) != 0 ? tapTapSdkOptions.region : null, (458751 & 16) != 0 ? tapTapSdkOptions.channel : null, (458751 & 32) != 0 ? tapTapSdkOptions.gameVersion : null, (458751 & 64) != 0 ? tapTapSdkOptions.autoIAPEventEnabled : false, (458751 & 128) != 0 ? tapTapSdkOptions.overrideBuiltInParameters : false, (458751 & 256) != 0 ? tapTapSdkOptions.properties : null, (458751 & 512) != 0 ? tapTapSdkOptions.oaidCert : null, (458751 & 1024) != 0 ? tapTapSdkOptions.enableLog : false, (458751 & 2048) != 0 ? tapTapSdkOptions.preferredLanguage : null, (458751 & 4096) != 0 ? tapTapSdkOptions.useAgeRange : false, (458751 & 8192) != 0 ? tapTapSdkOptions.showSwitchAccount : false, (458751 & 16384) != 0 ? tapTapSdkOptions.enableToast : false, (458751 & 32768) != 0 ? tapTapSdkOptions.disableReflectionOAID : false, (458751 & 65536) != 0 ? tapTapSdkOptions.disableAutoLogDeviceLogin : false, (458751 & 131072) != 0 ? tapTapSdkOptions.screenOrientation : 0, (458751 & 262144) != 0 ? tapTapSdkOptions.enableTapTapEvent : enabled);
            return this;
        }

        public final TapTapSdkInitializer build() {
            if (!(this.options.getClientId().length() > 0)) {
                throw new IllegalStateException("clientId 不可为空".toString());
            }
            if (this.options.getClientToken().length() > 0) {
                return new TapTapSdkInitializer(this, null);
            }
            throw new IllegalStateException("clientToken 不可为空".toString());
        }
    }

    /* JADX INFO: compiled from: TapTapSdkInitializer.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005J\u0006\u0010\u0014\u001a\u00020\u0015J\r\u0010\u0016\u001a\u00020\u000fH\u0001¢\u0006\u0002\b\u0017J \u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0015H\u0002J\u0006\u0010\u001b\u001a\u00020\u0015J\u0006\u0010\u001c\u001a\u00020\fJ\u0006\u0010\u001d\u001a\u00020\u0005J\u0006\u0010\u001e\u001a\u00020\u0012J\u000e\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nJ\u0018\u0010 \u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\f2\b\b\u0002\u0010\u001a\u001a\u00020\u0015R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/taptap/sdk/initializer/TapTapSdkInitializer$Companion;", "", "()V", "INSTANCE_REF", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/taptap/sdk/initializer/TapTapSdkInitializer;", "generation", "Ljava/util/concurrent/atomic/AtomicLong;", "initCallbacks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/taptap/sdk/initializer/api/TapInitCallback;", "initState", "Lcom/taptap/sdk/initializer/api/TapInitState;", "lock", "addInitCallback", "", "callback", "attach", "", "instance", "beginSession", "", "clearInitCallbacksForTest", "clearInitCallbacksForTest$tap_core_release", "dispatch", "state", d.aw, "getCurrentSession", "getInitState", "getInstance", "isAttached", "removeInitCallback", "updateInitState", "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean attach(TapTapSdkInitializer instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            TapTapSdkInitializer.INSTANCE_REF.set(instance);
            return true;
        }

        public final boolean isAttached() {
            return TapTapSdkInitializer.INSTANCE_REF.get() != null;
        }

        public final TapTapSdkInitializer getInstance() {
            Object obj = TapTapSdkInitializer.INSTANCE_REF.get();
            if (obj != null) {
                return (TapTapSdkInitializer) obj;
            }
            throw new IllegalStateException("TapTapSdkInitializer companion object instance is not attached, please call TapTapSdkInitializer.attach() first".toString());
        }

        public final long getCurrentSession() {
            return TapTapSdkInitializer.generation.get();
        }

        public final long beginSession() {
            TapTapSdkInitializer tapTapSdkInitializer = (TapTapSdkInitializer) TapTapSdkInitializer.INSTANCE_REF.get();
            if (tapTapSdkInitializer != null) {
                tapTapSdkInitializer.cancel();
            }
            long session = TapTapSdkInitializer.generation.incrementAndGet();
            updateInitState(TapInitState.InProgress.INSTANCE, session);
            return session;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void addInitCallback(final TapInitCallback callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            final Ref.LongRef longRef = new Ref.LongRef();
            synchronized (TapTapSdkInitializer.lock) {
                if (!TapTapSdkInitializer.initCallbacks.contains(callback)) {
                    TapTapSdkInitializer.initCallbacks.add(callback);
                }
                Object obj = TapTapSdkInitializer.initState.get();
                TapInitState tapInitState = (TapInitState) obj;
                objectRef.element = Boolean.valueOf((tapInitState instanceof TapInitState.Success) || (tapInitState instanceof TapInitState.Failed)).booleanValue() ? obj : 0;
                longRef.element = TapTapSdkInitializer.generation.get();
                Unit unit = Unit.INSTANCE;
            }
            if (objectRef.element != 0) {
                TapNetExecutor.executeUIThread(new Runnable() { // from class: com.taptap.sdk.initializer.TapTapSdkInitializer$Companion$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        TapTapSdkInitializer.Companion.addInitCallback$lambda$3(longRef, callback, objectRef);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static final void addInitCallback$lambda$3(Ref.LongRef session, TapInitCallback callback, Ref.ObjectRef terminalState) {
            Intrinsics.checkNotNullParameter(session, "$session");
            Intrinsics.checkNotNullParameter(callback, "$callback");
            Intrinsics.checkNotNullParameter(terminalState, "$terminalState");
            if (session.element == TapTapSdkInitializer.generation.get() && TapTapSdkInitializer.initCallbacks.contains(callback)) {
                TapTapSdkInitializer.INSTANCE.dispatch((TapInitState) terminalState.element, callback, session.element);
            }
        }

        public final void removeInitCallback(TapInitCallback callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            synchronized (TapTapSdkInitializer.lock) {
                TapTapSdkInitializer.initCallbacks.remove(callback);
            }
        }

        public final TapInitState getInitState() {
            Object obj = TapTapSdkInitializer.initState.get();
            Intrinsics.checkNotNullExpressionValue(obj, "initState.get()");
            return (TapInitState) obj;
        }

        public static /* synthetic */ void updateInitState$default(Companion companion, TapInitState tapInitState, long j, int i, Object obj) {
            if ((i & 2) != 0) {
                j = TapTapSdkInitializer.generation.get();
            }
            companion.updateInitState(tapInitState, j);
        }

        public final void updateInitState(final TapInitState state, final long session) {
            List list;
            Intrinsics.checkNotNullParameter(state, "state");
            synchronized (TapTapSdkInitializer.lock) {
                if (session != TapTapSdkInitializer.generation.get()) {
                    return;
                }
                TapInitState current = (TapInitState) TapTapSdkInitializer.initState.get();
                Function1 isTerminal = new Function1<TapInitState, Boolean>() { // from class: com.taptap.sdk.initializer.TapTapSdkInitializer$Companion$updateInitState$snapshot$1$isTerminal$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(TapInitState s) {
                        Intrinsics.checkNotNullParameter(s, "s");
                        return Boolean.valueOf((s instanceof TapInitState.Success) || (s instanceof TapInitState.Failed));
                    }
                };
                if (isTerminal.invoke(state).booleanValue()) {
                    Intrinsics.checkNotNullExpressionValue(current, "current");
                    if (isTerminal.invoke(current).booleanValue()) {
                        return;
                    }
                }
                TapTapSdkInitializer.initState.set(state);
                if ((state instanceof TapInitState.Success) || (state instanceof TapInitState.Failed)) {
                    list = CollectionsKt.toList(TapTapSdkInitializer.initCallbacks);
                } else {
                    list = null;
                }
                final List snapshot = list;
                if (snapshot != null) {
                    TapNetExecutor.executeUIThread(new Runnable() { // from class: com.taptap.sdk.initializer.TapTapSdkInitializer$Companion$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            TapTapSdkInitializer.Companion.updateInitState$lambda$7(session, snapshot, state);
                        }
                    });
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void updateInitState$lambda$7(long $session, List $snapshot, TapInitState state) {
            Intrinsics.checkNotNullParameter(state, "$state");
            if ($session == TapTapSdkInitializer.generation.get()) {
                List $this$forEach$iv = $snapshot;
                for (Object element$iv : $this$forEach$iv) {
                    TapInitCallback callback = (TapInitCallback) element$iv;
                    if (TapTapSdkInitializer.initCallbacks.contains(callback)) {
                        Companion companion = TapTapSdkInitializer.INSTANCE;
                        Intrinsics.checkNotNullExpressionValue(callback, "callback");
                        companion.dispatch(state, callback, $session);
                    }
                }
            }
        }

        public final void clearInitCallbacksForTest$tap_core_release() {
            synchronized (TapTapSdkInitializer.lock) {
                TapTapSdkInitializer.initCallbacks.clear();
                Unit unit = Unit.INSTANCE;
            }
        }

        private final void dispatch(TapInitState state, TapInitCallback callback, long session) {
            try {
                if (state instanceof TapInitState.Success) {
                    if (callback instanceof SessionAwareTapInitCallback) {
                        ((SessionAwareTapInitCallback) callback).onInitSuccess(session);
                    } else {
                        callback.onInitSuccess();
                    }
                } else if (state instanceof TapInitState.Failed) {
                    if (callback instanceof SessionAwareTapInitCallback) {
                        ((SessionAwareTapInitCallback) callback).onInitFail(((TapInitState.Failed) state).getErrorCode(), ((TapInitState.Failed) state).getErrorMsg(), session);
                    } else {
                        callback.onInitFail(((TapInitState.Failed) state).getErrorCode(), ((TapInitState.Failed) state).getErrorMsg());
                    }
                }
            } catch (Exception e) {
                TapLogger.loge$default(null, "TapInitCallback threw", e, 1, null);
            }
        }
    }
}
