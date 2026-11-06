package com.taptap.sdk.initializer;

import android.content.Context;
import com.anythink.core.common.e.f;
import com.anythink.network.tap.TapATInitManager;
import com.bytedance.ms.xr.ka.c$$ExternalSyntheticBackportWithForwarding0;
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
import com.taptap.sdk.initializer.api.model.Language;
import com.taptap.sdk.initializer.api.model.RegionType;
import com.taptap.sdk.initializer.api.option.TapTapSdkOptions;
import com.taptap.sdk.initializer.data.response.GateKeeper;
import com.taptap.sdk.initializer.manager.GatekeeperManager;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.TapTapKit;
import com.taptap.sdk.kit.internal.utils.localize.TapLocalizeUtil;
import com.taptap.sdk.servicemanager.ServiceManager;
import com.taptap.sdk.servicemanager.utils.ServiceManagerComponent;
import com.taptap.sdk.startup.StartUp;
import com.umeng.analytics.pro.cl;
import com.umeng.analytics.pro.g;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: TapTapSdkInitializer.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eB\u000f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u000fJ\u0006\u0010\u0018\u001a\u00020\u0000J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001cR\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/taptap/sdk/initializer/TapTapSdkInitializer;", "", "builder", "Lcom/taptap/sdk/initializer/TapTapSdkInitializer$Builder;", "(Lcom/taptap/sdk/initializer/TapTapSdkInitializer$Builder;)V", "options", "Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "(Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;)V", "dbService", "Lcom/taptap/sdk/core/DBService;", "getDbService", "()Lcom/taptap/sdk/core/DBService;", "dbService$delegate", "Lkotlin/Lazy;", "gatekeeperManager", "Lcom/taptap/sdk/initializer/manager/GatekeeperManager;", "openLogService", "Lcom/taptap/sdk/common/services/OpenLogService;", "getOpenLogService", "()Lcom/taptap/sdk/common/services/OpenLogService;", "openLogService$delegate", "getCurrentGateKeeper", "Lcom/taptap/sdk/initializer/data/response/GateKeeper;", "getGateKeepManager", "initialize", "isGatekeeperLoadedSuccessfully", "", "showGatekeeperError", "", "Builder", "Companion", "tap-initializer_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapTapSdkInitializer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AtomicReference<TapTapSdkInitializer> INSTANCE_REF = new AtomicReference<>();

    /* JADX INFO: renamed from: dbService$delegate, reason: from kotlin metadata */
    private final Lazy dbService;
    private GatekeeperManager gatekeeperManager;

    /* JADX INFO: renamed from: openLogService$delegate, reason: from kotlin metadata */
    private final Lazy openLogService;
    private final TapTapSdkOptions options;

    public /* synthetic */ TapTapSdkInitializer(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private TapTapSdkInitializer(TapTapSdkOptions tapTapSdkOptions) {
        this.options = tapTapSdkOptions;
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

    public final TapTapSdkInitializer initialize() {
        TapTapKit.INSTANCE.initialize(this.options);
        if (!this.options.getDisableReflectionOAID()) {
            OAIDManager.INSTANCE.attach(new OAIDManager.Builder().setRepository(new OAIDRepository(new CompositeOAIDCertProvider(CollectionsKt.listOf((Object[]) new OAIDCertProvider[]{new StringOAIDCertProvider(this.options.getOaidCert()), new AssetOAIDCertProvider(this.options.getContext())})), new OAIDHelper(this.options.getContext()))).build().initialize());
        }
        if (this.options.getRegion() == RegionType.GLOBAL) {
            GAIDManager.INSTANCE.attach(new GAIDManager.Builder().setRepository(new GAIDRepository(new GAIDHelper.Builder(this.options.getContext()).setReflectionGAIDProvider(new ReflectionGAIDProvider()).setServiceGAIDProvider(new ServiceGAIDProvider()).build())).build().initialize());
        }
        TapLocalizeUtil.INSTANCE.initialize(this.options.getRegion(), this.options.getPreferredLanguage().getLanguage());
        new StartUp.Builder(this.options.getContext()).setOptions(this.options).build().initialize();
        TapLogger.INSTANCE.setEnableLog(this.options.getEnableLog());
        this.gatekeeperManager = new GatekeeperManager.Builder(this.options).addOnGateKeeperChangeListener(new GatekeeperManager.OnGateKeeperChangeListener() { // from class: com.taptap.sdk.initializer.TapTapSdkInitializer$initialize$1$1
            @Override // com.taptap.sdk.initializer.manager.GatekeeperManager.OnGateKeeperChangeListener
            public void onGateKeeperChange(GateKeeper newValue) {
                Intrinsics.checkNotNullParameter(newValue, "newValue");
                this.$this_apply.getOpenLogService().enableHeartbeat(newValue.getSwitch().getHeartbeat());
            }
        }).build().initialize();
        if (!this.options.getDisableAutoLogDeviceLogin()) {
            getDbService().sendDeviceLoginEvent(this.options);
        }
        return this;
    }

    public final GatekeeperManager getGateKeepManager() {
        GatekeeperManager gatekeeperManager = this.gatekeeperManager;
        if (gatekeeperManager != null) {
            return gatekeeperManager;
        }
        throw new IllegalStateException("gatekeeperManager is null, please initialize it first".toString());
    }

    public final GateKeeper getCurrentGateKeeper() {
        return getGateKeepManager().getCurrentGateKeeper();
    }

    public final boolean isGatekeeperLoadedSuccessfully() {
        return getGateKeepManager().isGatekeeperLoadedSuccessfully();
    }

    public final void showGatekeeperError() {
        getGateKeepManager().showGatekeeperError();
    }

    /* JADX INFO: compiled from: TapTapSdkInitializer.kt */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0010J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0010J\u0010\u0010\u0015\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0017J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0017J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0010J\u0010\u0010\u001e\u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010\u0017J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"J\u0010\u0010#\u001a\u00020\u00002\b\u0010$\u001a\u0004\u0018\u00010\u0017J\u000e\u0010%\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0010J\u0010\u0010&\u001a\u00020\u00002\b\u0010'\u001a\u0004\u0018\u00010(J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+J\u000e\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020.J\u000e\u0010/\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0010J\u000e\u00100\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0010J\u000e\u00101\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u00062"}, d2 = {"Lcom/taptap/sdk/initializer/TapTapSdkInitializer$Builder;", "", g.X, "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "<set-?>", "Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "options", "getOptions$tap_initializer_release", "()Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "build", "Lcom/taptap/sdk/initializer/TapTapSdkInitializer;", "disableAutoLogDeviceLogin", f.a.d, "", "disableReflectionOAID", "enableLog", "setAutoIAPEventEnabled", cl.q, "setChannel", "channel", "", "setClientId", "clientId", "setClientToken", "clientToken", "setEnableToast", "enabled", "setGameVersion", "gameVersion", "setLanguage", "language", "Lcom/taptap/sdk/initializer/api/model/Language;", "setOAIDCert", "oaidCert", "setOverrideBuiltInParameters", "setProperties", Common.Predefined.PROPERTIES, "Lorg/json/JSONObject;", "setRegion", "region", "Lcom/taptap/sdk/initializer/api/model/RegionType;", "setScreenOrientation", TapATInitManager.ORIENTATION_KEY, "", "setShowSwitchAccount", "setTapEventEnable", "setUseAgeRange", "tap-initializer_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
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

        /* JADX INFO: renamed from: getOptions$tap_initializer_release, reason: from getter */
        public final TapTapSdkOptions getOptions() {
            return this.options;
        }

        public final Builder setClientId(String clientId) {
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            TapTapSdkOptions tapTapSdkOptions = this.options;
            this.options = tapTapSdkOptions.copy((458751 & 1) != 0 ? tapTapSdkOptions.context : null, (458751 & 2) != 0 ? tapTapSdkOptions.clientId : clientId, (458751 & 4) != 0 ? tapTapSdkOptions.clientToken : null, (458751 & 8) != 0 ? tapTapSdkOptions.region : null, (458751 & 16) != 0 ? tapTapSdkOptions.channel : null, (458751 & 32) != 0 ? tapTapSdkOptions.gameVersion : null, (458751 & 64) != 0 ? tapTapSdkOptions.autoIAPEventEnabled : false, (458751 & 128) != 0 ? tapTapSdkOptions.overrideBuiltInParameters : false, (458751 & 256) != 0 ? tapTapSdkOptions.properties : null, (458751 & 512) != 0 ? tapTapSdkOptions.oaidCert : null, (458751 & 1024) != 0 ? tapTapSdkOptions.enableLog : false, (458751 & 2048) != 0 ? tapTapSdkOptions.preferredLanguage : null, (458751 & 4096) != 0 ? tapTapSdkOptions.useAgeRange : false, (458751 & 8192) != 0 ? tapTapSdkOptions.showSwitchAccount : false, (458751 & 16384) != 0 ? tapTapSdkOptions.enableToast : false, (458751 & 32768) != 0 ? tapTapSdkOptions.disableReflectionOAID : false, (458751 & 65536) != 0 ? tapTapSdkOptions.disableAutoLogDeviceLogin : false, (458751 & 131072) != 0 ? tapTapSdkOptions.screenOrientation : 0, (458751 & 262144) != 0 ? tapTapSdkOptions.enableTapTapEvent : false);
            return this;
        }

        public final Builder enableLog(boolean enableLog) {
            TapTapSdkOptions tapTapSdkOptions = this.options;
            this.options = tapTapSdkOptions.copy((458751 & 1) != 0 ? tapTapSdkOptions.context : null, (458751 & 2) != 0 ? tapTapSdkOptions.clientId : null, (458751 & 4) != 0 ? tapTapSdkOptions.clientToken : null, (458751 & 8) != 0 ? tapTapSdkOptions.region : null, (458751 & 16) != 0 ? tapTapSdkOptions.channel : null, (458751 & 32) != 0 ? tapTapSdkOptions.gameVersion : null, (458751 & 64) != 0 ? tapTapSdkOptions.autoIAPEventEnabled : false, (458751 & 128) != 0 ? tapTapSdkOptions.overrideBuiltInParameters : false, (458751 & 256) != 0 ? tapTapSdkOptions.properties : null, (458751 & 512) != 0 ? tapTapSdkOptions.oaidCert : null, (458751 & 1024) != 0 ? tapTapSdkOptions.enableLog : enableLog, (458751 & 2048) != 0 ? tapTapSdkOptions.preferredLanguage : null, (458751 & 4096) != 0 ? tapTapSdkOptions.useAgeRange : false, (458751 & 8192) != 0 ? tapTapSdkOptions.showSwitchAccount : false, (458751 & 16384) != 0 ? tapTapSdkOptions.enableToast : false, (458751 & 32768) != 0 ? tapTapSdkOptions.disableReflectionOAID : false, (458751 & 65536) != 0 ? tapTapSdkOptions.disableAutoLogDeviceLogin : false, (458751 & 131072) != 0 ? tapTapSdkOptions.screenOrientation : 0, (458751 & 262144) != 0 ? tapTapSdkOptions.enableTapTapEvent : false);
            return this;
        }

        public final Builder setOAIDCert(String oaidCert) {
            TapTapSdkOptions tapTapSdkOptions = this.options;
            this.options = tapTapSdkOptions.copy((458751 & 1) != 0 ? tapTapSdkOptions.context : null, (458751 & 2) != 0 ? tapTapSdkOptions.clientId : null, (458751 & 4) != 0 ? tapTapSdkOptions.clientToken : null, (458751 & 8) != 0 ? tapTapSdkOptions.region : null, (458751 & 16) != 0 ? tapTapSdkOptions.channel : null, (458751 & 32) != 0 ? tapTapSdkOptions.gameVersion : null, (458751 & 64) != 0 ? tapTapSdkOptions.autoIAPEventEnabled : false, (458751 & 128) != 0 ? tapTapSdkOptions.overrideBuiltInParameters : false, (458751 & 256) != 0 ? tapTapSdkOptions.properties : null, (458751 & 512) != 0 ? tapTapSdkOptions.oaidCert : oaidCert, (458751 & 1024) != 0 ? tapTapSdkOptions.enableLog : false, (458751 & 2048) != 0 ? tapTapSdkOptions.preferredLanguage : null, (458751 & 4096) != 0 ? tapTapSdkOptions.useAgeRange : false, (458751 & 8192) != 0 ? tapTapSdkOptions.showSwitchAccount : false, (458751 & 16384) != 0 ? tapTapSdkOptions.enableToast : false, (458751 & 32768) != 0 ? tapTapSdkOptions.disableReflectionOAID : false, (458751 & 65536) != 0 ? tapTapSdkOptions.disableAutoLogDeviceLogin : false, (458751 & 131072) != 0 ? tapTapSdkOptions.screenOrientation : 0, (458751 & 262144) != 0 ? tapTapSdkOptions.enableTapTapEvent : false);
            return this;
        }

        public final Builder setRegion(RegionType region) {
            Intrinsics.checkNotNullParameter(region, "region");
            TapTapSdkOptions tapTapSdkOptions = this.options;
            this.options = tapTapSdkOptions.copy((458751 & 1) != 0 ? tapTapSdkOptions.context : null, (458751 & 2) != 0 ? tapTapSdkOptions.clientId : null, (458751 & 4) != 0 ? tapTapSdkOptions.clientToken : null, (458751 & 8) != 0 ? tapTapSdkOptions.region : region, (458751 & 16) != 0 ? tapTapSdkOptions.channel : null, (458751 & 32) != 0 ? tapTapSdkOptions.gameVersion : null, (458751 & 64) != 0 ? tapTapSdkOptions.autoIAPEventEnabled : false, (458751 & 128) != 0 ? tapTapSdkOptions.overrideBuiltInParameters : false, (458751 & 256) != 0 ? tapTapSdkOptions.properties : null, (458751 & 512) != 0 ? tapTapSdkOptions.oaidCert : null, (458751 & 1024) != 0 ? tapTapSdkOptions.enableLog : false, (458751 & 2048) != 0 ? tapTapSdkOptions.preferredLanguage : null, (458751 & 4096) != 0 ? tapTapSdkOptions.useAgeRange : false, (458751 & 8192) != 0 ? tapTapSdkOptions.showSwitchAccount : false, (458751 & 16384) != 0 ? tapTapSdkOptions.enableToast : false, (458751 & 32768) != 0 ? tapTapSdkOptions.disableReflectionOAID : false, (458751 & 65536) != 0 ? tapTapSdkOptions.disableAutoLogDeviceLogin : false, (458751 & 131072) != 0 ? tapTapSdkOptions.screenOrientation : 0, (458751 & 262144) != 0 ? tapTapSdkOptions.enableTapTapEvent : false);
            return this;
        }

        public final Builder setClientToken(String clientToken) {
            Intrinsics.checkNotNullParameter(clientToken, "clientToken");
            TapTapSdkOptions tapTapSdkOptions = this.options;
            this.options = tapTapSdkOptions.copy((458751 & 1) != 0 ? tapTapSdkOptions.context : null, (458751 & 2) != 0 ? tapTapSdkOptions.clientId : null, (458751 & 4) != 0 ? tapTapSdkOptions.clientToken : clientToken, (458751 & 8) != 0 ? tapTapSdkOptions.region : null, (458751 & 16) != 0 ? tapTapSdkOptions.channel : null, (458751 & 32) != 0 ? tapTapSdkOptions.gameVersion : null, (458751 & 64) != 0 ? tapTapSdkOptions.autoIAPEventEnabled : false, (458751 & 128) != 0 ? tapTapSdkOptions.overrideBuiltInParameters : false, (458751 & 256) != 0 ? tapTapSdkOptions.properties : null, (458751 & 512) != 0 ? tapTapSdkOptions.oaidCert : null, (458751 & 1024) != 0 ? tapTapSdkOptions.enableLog : false, (458751 & 2048) != 0 ? tapTapSdkOptions.preferredLanguage : null, (458751 & 4096) != 0 ? tapTapSdkOptions.useAgeRange : false, (458751 & 8192) != 0 ? tapTapSdkOptions.showSwitchAccount : false, (458751 & 16384) != 0 ? tapTapSdkOptions.enableToast : false, (458751 & 32768) != 0 ? tapTapSdkOptions.disableReflectionOAID : false, (458751 & 65536) != 0 ? tapTapSdkOptions.disableAutoLogDeviceLogin : false, (458751 & 131072) != 0 ? tapTapSdkOptions.screenOrientation : 0, (458751 & 262144) != 0 ? tapTapSdkOptions.enableTapTapEvent : false);
            return this;
        }

        public final Builder setLanguage(Language language) {
            Intrinsics.checkNotNullParameter(language, "language");
            TapTapSdkOptions tapTapSdkOptions = this.options;
            this.options = tapTapSdkOptions.copy((458751 & 1) != 0 ? tapTapSdkOptions.context : null, (458751 & 2) != 0 ? tapTapSdkOptions.clientId : null, (458751 & 4) != 0 ? tapTapSdkOptions.clientToken : null, (458751 & 8) != 0 ? tapTapSdkOptions.region : null, (458751 & 16) != 0 ? tapTapSdkOptions.channel : null, (458751 & 32) != 0 ? tapTapSdkOptions.gameVersion : null, (458751 & 64) != 0 ? tapTapSdkOptions.autoIAPEventEnabled : false, (458751 & 128) != 0 ? tapTapSdkOptions.overrideBuiltInParameters : false, (458751 & 256) != 0 ? tapTapSdkOptions.properties : null, (458751 & 512) != 0 ? tapTapSdkOptions.oaidCert : null, (458751 & 1024) != 0 ? tapTapSdkOptions.enableLog : false, (458751 & 2048) != 0 ? tapTapSdkOptions.preferredLanguage : language, (458751 & 4096) != 0 ? tapTapSdkOptions.useAgeRange : false, (458751 & 8192) != 0 ? tapTapSdkOptions.showSwitchAccount : false, (458751 & 16384) != 0 ? tapTapSdkOptions.enableToast : false, (458751 & 32768) != 0 ? tapTapSdkOptions.disableReflectionOAID : false, (458751 & 65536) != 0 ? tapTapSdkOptions.disableAutoLogDeviceLogin : false, (458751 & 131072) != 0 ? tapTapSdkOptions.screenOrientation : 0, (458751 & 262144) != 0 ? tapTapSdkOptions.enableTapTapEvent : false);
            return this;
        }

        public final Builder setProperties(JSONObject properties) {
            TapTapSdkOptions tapTapSdkOptions = this.options;
            this.options = tapTapSdkOptions.copy((458751 & 1) != 0 ? tapTapSdkOptions.context : null, (458751 & 2) != 0 ? tapTapSdkOptions.clientId : null, (458751 & 4) != 0 ? tapTapSdkOptions.clientToken : null, (458751 & 8) != 0 ? tapTapSdkOptions.region : null, (458751 & 16) != 0 ? tapTapSdkOptions.channel : null, (458751 & 32) != 0 ? tapTapSdkOptions.gameVersion : null, (458751 & 64) != 0 ? tapTapSdkOptions.autoIAPEventEnabled : false, (458751 & 128) != 0 ? tapTapSdkOptions.overrideBuiltInParameters : false, (458751 & 256) != 0 ? tapTapSdkOptions.properties : properties, (458751 & 512) != 0 ? tapTapSdkOptions.oaidCert : null, (458751 & 1024) != 0 ? tapTapSdkOptions.enableLog : false, (458751 & 2048) != 0 ? tapTapSdkOptions.preferredLanguage : null, (458751 & 4096) != 0 ? tapTapSdkOptions.useAgeRange : false, (458751 & 8192) != 0 ? tapTapSdkOptions.showSwitchAccount : false, (458751 & 16384) != 0 ? tapTapSdkOptions.enableToast : false, (458751 & 32768) != 0 ? tapTapSdkOptions.disableReflectionOAID : false, (458751 & 65536) != 0 ? tapTapSdkOptions.disableAutoLogDeviceLogin : false, (458751 & 131072) != 0 ? tapTapSdkOptions.screenOrientation : 0, (458751 & 262144) != 0 ? tapTapSdkOptions.enableTapTapEvent : false);
            return this;
        }

        public final Builder setChannel(String channel) {
            TapTapSdkOptions tapTapSdkOptions = this.options;
            this.options = tapTapSdkOptions.copy((458751 & 1) != 0 ? tapTapSdkOptions.context : null, (458751 & 2) != 0 ? tapTapSdkOptions.clientId : null, (458751 & 4) != 0 ? tapTapSdkOptions.clientToken : null, (458751 & 8) != 0 ? tapTapSdkOptions.region : null, (458751 & 16) != 0 ? tapTapSdkOptions.channel : channel, (458751 & 32) != 0 ? tapTapSdkOptions.gameVersion : null, (458751 & 64) != 0 ? tapTapSdkOptions.autoIAPEventEnabled : false, (458751 & 128) != 0 ? tapTapSdkOptions.overrideBuiltInParameters : false, (458751 & 256) != 0 ? tapTapSdkOptions.properties : null, (458751 & 512) != 0 ? tapTapSdkOptions.oaidCert : null, (458751 & 1024) != 0 ? tapTapSdkOptions.enableLog : false, (458751 & 2048) != 0 ? tapTapSdkOptions.preferredLanguage : null, (458751 & 4096) != 0 ? tapTapSdkOptions.useAgeRange : false, (458751 & 8192) != 0 ? tapTapSdkOptions.showSwitchAccount : false, (458751 & 16384) != 0 ? tapTapSdkOptions.enableToast : false, (458751 & 32768) != 0 ? tapTapSdkOptions.disableReflectionOAID : false, (458751 & 65536) != 0 ? tapTapSdkOptions.disableAutoLogDeviceLogin : false, (458751 & 131072) != 0 ? tapTapSdkOptions.screenOrientation : 0, (458751 & 262144) != 0 ? tapTapSdkOptions.enableTapTapEvent : false);
            return this;
        }

        public final Builder setAutoIAPEventEnabled(boolean enable) {
            TapTapSdkOptions tapTapSdkOptions = this.options;
            this.options = tapTapSdkOptions.copy((458751 & 1) != 0 ? tapTapSdkOptions.context : null, (458751 & 2) != 0 ? tapTapSdkOptions.clientId : null, (458751 & 4) != 0 ? tapTapSdkOptions.clientToken : null, (458751 & 8) != 0 ? tapTapSdkOptions.region : null, (458751 & 16) != 0 ? tapTapSdkOptions.channel : null, (458751 & 32) != 0 ? tapTapSdkOptions.gameVersion : null, (458751 & 64) != 0 ? tapTapSdkOptions.autoIAPEventEnabled : enable, (458751 & 128) != 0 ? tapTapSdkOptions.overrideBuiltInParameters : false, (458751 & 256) != 0 ? tapTapSdkOptions.properties : null, (458751 & 512) != 0 ? tapTapSdkOptions.oaidCert : null, (458751 & 1024) != 0 ? tapTapSdkOptions.enableLog : false, (458751 & 2048) != 0 ? tapTapSdkOptions.preferredLanguage : null, (458751 & 4096) != 0 ? tapTapSdkOptions.useAgeRange : false, (458751 & 8192) != 0 ? tapTapSdkOptions.showSwitchAccount : false, (458751 & 16384) != 0 ? tapTapSdkOptions.enableToast : false, (458751 & 32768) != 0 ? tapTapSdkOptions.disableReflectionOAID : false, (458751 & 65536) != 0 ? tapTapSdkOptions.disableAutoLogDeviceLogin : false, (458751 & 131072) != 0 ? tapTapSdkOptions.screenOrientation : 0, (458751 & 262144) != 0 ? tapTapSdkOptions.enableTapTapEvent : false);
            return this;
        }

        public final Builder setOverrideBuiltInParameters(boolean enable) {
            TapTapSdkOptions tapTapSdkOptions = this.options;
            this.options = tapTapSdkOptions.copy((458751 & 1) != 0 ? tapTapSdkOptions.context : null, (458751 & 2) != 0 ? tapTapSdkOptions.clientId : null, (458751 & 4) != 0 ? tapTapSdkOptions.clientToken : null, (458751 & 8) != 0 ? tapTapSdkOptions.region : null, (458751 & 16) != 0 ? tapTapSdkOptions.channel : null, (458751 & 32) != 0 ? tapTapSdkOptions.gameVersion : null, (458751 & 64) != 0 ? tapTapSdkOptions.autoIAPEventEnabled : false, (458751 & 128) != 0 ? tapTapSdkOptions.overrideBuiltInParameters : enable, (458751 & 256) != 0 ? tapTapSdkOptions.properties : null, (458751 & 512) != 0 ? tapTapSdkOptions.oaidCert : null, (458751 & 1024) != 0 ? tapTapSdkOptions.enableLog : false, (458751 & 2048) != 0 ? tapTapSdkOptions.preferredLanguage : null, (458751 & 4096) != 0 ? tapTapSdkOptions.useAgeRange : false, (458751 & 8192) != 0 ? tapTapSdkOptions.showSwitchAccount : false, (458751 & 16384) != 0 ? tapTapSdkOptions.enableToast : false, (458751 & 32768) != 0 ? tapTapSdkOptions.disableReflectionOAID : false, (458751 & 65536) != 0 ? tapTapSdkOptions.disableAutoLogDeviceLogin : false, (458751 & 131072) != 0 ? tapTapSdkOptions.screenOrientation : 0, (458751 & 262144) != 0 ? tapTapSdkOptions.enableTapTapEvent : false);
            return this;
        }

        public final Builder setGameVersion(String gameVersion) {
            TapTapSdkOptions tapTapSdkOptions = this.options;
            this.options = tapTapSdkOptions.copy((458751 & 1) != 0 ? tapTapSdkOptions.context : null, (458751 & 2) != 0 ? tapTapSdkOptions.clientId : null, (458751 & 4) != 0 ? tapTapSdkOptions.clientToken : null, (458751 & 8) != 0 ? tapTapSdkOptions.region : null, (458751 & 16) != 0 ? tapTapSdkOptions.channel : null, (458751 & 32) != 0 ? tapTapSdkOptions.gameVersion : gameVersion, (458751 & 64) != 0 ? tapTapSdkOptions.autoIAPEventEnabled : false, (458751 & 128) != 0 ? tapTapSdkOptions.overrideBuiltInParameters : false, (458751 & 256) != 0 ? tapTapSdkOptions.properties : null, (458751 & 512) != 0 ? tapTapSdkOptions.oaidCert : null, (458751 & 1024) != 0 ? tapTapSdkOptions.enableLog : false, (458751 & 2048) != 0 ? tapTapSdkOptions.preferredLanguage : null, (458751 & 4096) != 0 ? tapTapSdkOptions.useAgeRange : false, (458751 & 8192) != 0 ? tapTapSdkOptions.showSwitchAccount : false, (458751 & 16384) != 0 ? tapTapSdkOptions.enableToast : false, (458751 & 32768) != 0 ? tapTapSdkOptions.disableReflectionOAID : false, (458751 & 65536) != 0 ? tapTapSdkOptions.disableAutoLogDeviceLogin : false, (458751 & 131072) != 0 ? tapTapSdkOptions.screenOrientation : 0, (458751 & 262144) != 0 ? tapTapSdkOptions.enableTapTapEvent : false);
            return this;
        }

        public final Builder setEnableToast(boolean enabled) {
            TapTapSdkOptions tapTapSdkOptions = this.options;
            this.options = tapTapSdkOptions.copy((458751 & 1) != 0 ? tapTapSdkOptions.context : null, (458751 & 2) != 0 ? tapTapSdkOptions.clientId : null, (458751 & 4) != 0 ? tapTapSdkOptions.clientToken : null, (458751 & 8) != 0 ? tapTapSdkOptions.region : null, (458751 & 16) != 0 ? tapTapSdkOptions.channel : null, (458751 & 32) != 0 ? tapTapSdkOptions.gameVersion : null, (458751 & 64) != 0 ? tapTapSdkOptions.autoIAPEventEnabled : false, (458751 & 128) != 0 ? tapTapSdkOptions.overrideBuiltInParameters : false, (458751 & 256) != 0 ? tapTapSdkOptions.properties : null, (458751 & 512) != 0 ? tapTapSdkOptions.oaidCert : null, (458751 & 1024) != 0 ? tapTapSdkOptions.enableLog : false, (458751 & 2048) != 0 ? tapTapSdkOptions.preferredLanguage : null, (458751 & 4096) != 0 ? tapTapSdkOptions.useAgeRange : false, (458751 & 8192) != 0 ? tapTapSdkOptions.showSwitchAccount : false, (458751 & 16384) != 0 ? tapTapSdkOptions.enableToast : enabled, (458751 & 32768) != 0 ? tapTapSdkOptions.disableReflectionOAID : false, (458751 & 65536) != 0 ? tapTapSdkOptions.disableAutoLogDeviceLogin : false, (458751 & 131072) != 0 ? tapTapSdkOptions.screenOrientation : 0, (458751 & 262144) != 0 ? tapTapSdkOptions.enableTapTapEvent : false);
            return this;
        }

        public final Builder setShowSwitchAccount(boolean enabled) {
            TapTapSdkOptions tapTapSdkOptions = this.options;
            this.options = tapTapSdkOptions.copy((458751 & 1) != 0 ? tapTapSdkOptions.context : null, (458751 & 2) != 0 ? tapTapSdkOptions.clientId : null, (458751 & 4) != 0 ? tapTapSdkOptions.clientToken : null, (458751 & 8) != 0 ? tapTapSdkOptions.region : null, (458751 & 16) != 0 ? tapTapSdkOptions.channel : null, (458751 & 32) != 0 ? tapTapSdkOptions.gameVersion : null, (458751 & 64) != 0 ? tapTapSdkOptions.autoIAPEventEnabled : false, (458751 & 128) != 0 ? tapTapSdkOptions.overrideBuiltInParameters : false, (458751 & 256) != 0 ? tapTapSdkOptions.properties : null, (458751 & 512) != 0 ? tapTapSdkOptions.oaidCert : null, (458751 & 1024) != 0 ? tapTapSdkOptions.enableLog : false, (458751 & 2048) != 0 ? tapTapSdkOptions.preferredLanguage : null, (458751 & 4096) != 0 ? tapTapSdkOptions.useAgeRange : false, (458751 & 8192) != 0 ? tapTapSdkOptions.showSwitchAccount : enabled, (458751 & 16384) != 0 ? tapTapSdkOptions.enableToast : false, (458751 & 32768) != 0 ? tapTapSdkOptions.disableReflectionOAID : false, (458751 & 65536) != 0 ? tapTapSdkOptions.disableAutoLogDeviceLogin : false, (458751 & 131072) != 0 ? tapTapSdkOptions.screenOrientation : 0, (458751 & 262144) != 0 ? tapTapSdkOptions.enableTapTapEvent : false);
            return this;
        }

        public final Builder setUseAgeRange(boolean enabled) {
            TapTapSdkOptions tapTapSdkOptions = this.options;
            this.options = tapTapSdkOptions.copy((458751 & 1) != 0 ? tapTapSdkOptions.context : null, (458751 & 2) != 0 ? tapTapSdkOptions.clientId : null, (458751 & 4) != 0 ? tapTapSdkOptions.clientToken : null, (458751 & 8) != 0 ? tapTapSdkOptions.region : null, (458751 & 16) != 0 ? tapTapSdkOptions.channel : null, (458751 & 32) != 0 ? tapTapSdkOptions.gameVersion : null, (458751 & 64) != 0 ? tapTapSdkOptions.autoIAPEventEnabled : false, (458751 & 128) != 0 ? tapTapSdkOptions.overrideBuiltInParameters : false, (458751 & 256) != 0 ? tapTapSdkOptions.properties : null, (458751 & 512) != 0 ? tapTapSdkOptions.oaidCert : null, (458751 & 1024) != 0 ? tapTapSdkOptions.enableLog : false, (458751 & 2048) != 0 ? tapTapSdkOptions.preferredLanguage : null, (458751 & 4096) != 0 ? tapTapSdkOptions.useAgeRange : enabled, (458751 & 8192) != 0 ? tapTapSdkOptions.showSwitchAccount : false, (458751 & 16384) != 0 ? tapTapSdkOptions.enableToast : false, (458751 & 32768) != 0 ? tapTapSdkOptions.disableReflectionOAID : false, (458751 & 65536) != 0 ? tapTapSdkOptions.disableAutoLogDeviceLogin : false, (458751 & 131072) != 0 ? tapTapSdkOptions.screenOrientation : 0, (458751 & 262144) != 0 ? tapTapSdkOptions.enableTapTapEvent : false);
            return this;
        }

        public final Builder setScreenOrientation(int orientation) {
            TapTapSdkOptions tapTapSdkOptions = this.options;
            this.options = tapTapSdkOptions.copy((458751 & 1) != 0 ? tapTapSdkOptions.context : null, (458751 & 2) != 0 ? tapTapSdkOptions.clientId : null, (458751 & 4) != 0 ? tapTapSdkOptions.clientToken : null, (458751 & 8) != 0 ? tapTapSdkOptions.region : null, (458751 & 16) != 0 ? tapTapSdkOptions.channel : null, (458751 & 32) != 0 ? tapTapSdkOptions.gameVersion : null, (458751 & 64) != 0 ? tapTapSdkOptions.autoIAPEventEnabled : false, (458751 & 128) != 0 ? tapTapSdkOptions.overrideBuiltInParameters : false, (458751 & 256) != 0 ? tapTapSdkOptions.properties : null, (458751 & 512) != 0 ? tapTapSdkOptions.oaidCert : null, (458751 & 1024) != 0 ? tapTapSdkOptions.enableLog : false, (458751 & 2048) != 0 ? tapTapSdkOptions.preferredLanguage : null, (458751 & 4096) != 0 ? tapTapSdkOptions.useAgeRange : false, (458751 & 8192) != 0 ? tapTapSdkOptions.showSwitchAccount : false, (458751 & 16384) != 0 ? tapTapSdkOptions.enableToast : false, (458751 & 32768) != 0 ? tapTapSdkOptions.disableReflectionOAID : false, (458751 & 65536) != 0 ? tapTapSdkOptions.disableAutoLogDeviceLogin : false, (458751 & 131072) != 0 ? tapTapSdkOptions.screenOrientation : orientation, (458751 & 262144) != 0 ? tapTapSdkOptions.enableTapTapEvent : false);
            return this;
        }

        public final Builder disableReflectionOAID(boolean value) {
            TapTapSdkOptions tapTapSdkOptions = this.options;
            this.options = tapTapSdkOptions.copy((458751 & 1) != 0 ? tapTapSdkOptions.context : null, (458751 & 2) != 0 ? tapTapSdkOptions.clientId : null, (458751 & 4) != 0 ? tapTapSdkOptions.clientToken : null, (458751 & 8) != 0 ? tapTapSdkOptions.region : null, (458751 & 16) != 0 ? tapTapSdkOptions.channel : null, (458751 & 32) != 0 ? tapTapSdkOptions.gameVersion : null, (458751 & 64) != 0 ? tapTapSdkOptions.autoIAPEventEnabled : false, (458751 & 128) != 0 ? tapTapSdkOptions.overrideBuiltInParameters : false, (458751 & 256) != 0 ? tapTapSdkOptions.properties : null, (458751 & 512) != 0 ? tapTapSdkOptions.oaidCert : null, (458751 & 1024) != 0 ? tapTapSdkOptions.enableLog : false, (458751 & 2048) != 0 ? tapTapSdkOptions.preferredLanguage : null, (458751 & 4096) != 0 ? tapTapSdkOptions.useAgeRange : false, (458751 & 8192) != 0 ? tapTapSdkOptions.showSwitchAccount : false, (458751 & 16384) != 0 ? tapTapSdkOptions.enableToast : false, (458751 & 32768) != 0 ? tapTapSdkOptions.disableReflectionOAID : value, (458751 & 65536) != 0 ? tapTapSdkOptions.disableAutoLogDeviceLogin : false, (458751 & 131072) != 0 ? tapTapSdkOptions.screenOrientation : 0, (458751 & 262144) != 0 ? tapTapSdkOptions.enableTapTapEvent : false);
            return this;
        }

        public final Builder disableAutoLogDeviceLogin(boolean value) {
            TapTapSdkOptions tapTapSdkOptions = this.options;
            this.options = tapTapSdkOptions.copy((458751 & 1) != 0 ? tapTapSdkOptions.context : null, (458751 & 2) != 0 ? tapTapSdkOptions.clientId : null, (458751 & 4) != 0 ? tapTapSdkOptions.clientToken : null, (458751 & 8) != 0 ? tapTapSdkOptions.region : null, (458751 & 16) != 0 ? tapTapSdkOptions.channel : null, (458751 & 32) != 0 ? tapTapSdkOptions.gameVersion : null, (458751 & 64) != 0 ? tapTapSdkOptions.autoIAPEventEnabled : false, (458751 & 128) != 0 ? tapTapSdkOptions.overrideBuiltInParameters : false, (458751 & 256) != 0 ? tapTapSdkOptions.properties : null, (458751 & 512) != 0 ? tapTapSdkOptions.oaidCert : null, (458751 & 1024) != 0 ? tapTapSdkOptions.enableLog : false, (458751 & 2048) != 0 ? tapTapSdkOptions.preferredLanguage : null, (458751 & 4096) != 0 ? tapTapSdkOptions.useAgeRange : false, (458751 & 8192) != 0 ? tapTapSdkOptions.showSwitchAccount : false, (458751 & 16384) != 0 ? tapTapSdkOptions.enableToast : false, (458751 & 32768) != 0 ? tapTapSdkOptions.disableReflectionOAID : false, (458751 & 65536) != 0 ? tapTapSdkOptions.disableAutoLogDeviceLogin : value, (458751 & 131072) != 0 ? tapTapSdkOptions.screenOrientation : 0, (458751 & 262144) != 0 ? tapTapSdkOptions.enableTapTapEvent : false);
            return this;
        }

        public final Builder setTapEventEnable(boolean enabled) {
            TapTapSdkOptions tapTapSdkOptions = this.options;
            this.options = tapTapSdkOptions.copy((458751 & 1) != 0 ? tapTapSdkOptions.context : null, (458751 & 2) != 0 ? tapTapSdkOptions.clientId : null, (458751 & 4) != 0 ? tapTapSdkOptions.clientToken : null, (458751 & 8) != 0 ? tapTapSdkOptions.region : null, (458751 & 16) != 0 ? tapTapSdkOptions.channel : null, (458751 & 32) != 0 ? tapTapSdkOptions.gameVersion : null, (458751 & 64) != 0 ? tapTapSdkOptions.autoIAPEventEnabled : false, (458751 & 128) != 0 ? tapTapSdkOptions.overrideBuiltInParameters : false, (458751 & 256) != 0 ? tapTapSdkOptions.properties : null, (458751 & 512) != 0 ? tapTapSdkOptions.oaidCert : null, (458751 & 1024) != 0 ? tapTapSdkOptions.enableLog : false, (458751 & 2048) != 0 ? tapTapSdkOptions.preferredLanguage : null, (458751 & 4096) != 0 ? tapTapSdkOptions.useAgeRange : false, (458751 & 8192) != 0 ? tapTapSdkOptions.showSwitchAccount : false, (458751 & 16384) != 0 ? tapTapSdkOptions.enableToast : false, (458751 & 32768) != 0 ? tapTapSdkOptions.disableReflectionOAID : false, (458751 & 65536) != 0 ? tapTapSdkOptions.disableAutoLogDeviceLogin : false, (458751 & 131072) != 0 ? tapTapSdkOptions.screenOrientation : 0, (458751 & 262144) != 0 ? tapTapSdkOptions.enableTapTapEvent : enabled);
            return this;
        }

        public final TapTapSdkInitializer build() {
            if (!(this.options.getClientId().length() > 0)) {
                throw new IllegalStateException("clientId 不可为空".toString());
            }
            if (!(this.options.getClientToken().length() > 0)) {
                throw new IllegalStateException("clientToken 不可为空".toString());
            }
            return new TapTapSdkInitializer(this, null);
        }
    }

    /* JADX INFO: compiled from: TapTapSdkInitializer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\u0007R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/taptap/sdk/initializer/TapTapSdkInitializer$Companion;", "", "()V", "INSTANCE_REF", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/taptap/sdk/initializer/TapTapSdkInitializer;", "attach", "", "instance", "getInstance", "isAttached", "tap-initializer_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean attach(TapTapSdkInitializer instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            return c$$ExternalSyntheticBackportWithForwarding0.m(TapTapSdkInitializer.INSTANCE_REF, null, instance);
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
    }
}
