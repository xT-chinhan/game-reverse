package com.taptap.sdk.initializer;

import android.content.Context;
import com.taptap.sdk.core.DBService;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import com.taptap.sdk.initializer.api.Initializers;
import com.taptap.sdk.initializer.api.ModuleInitializer;
import com.taptap.sdk.initializer.api.model.Language;
import com.taptap.sdk.initializer.api.option.TapTapSdkOptions;
import com.taptap.sdk.initializer.di.ModuleFactories;
import com.taptap.sdk.initializer.gate.TapGatekeeperManager;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.TapTapKit;
import com.taptap.sdk.kit.internal.identifier.TapIdentifierUtil;
import com.taptap.sdk.kit.internal.utils.TapActivityLifecycleTracker;
import com.taptap.sdk.kit.internal.utils.localize.TapLocalizeUtil;
import com.taptap.sdk.openlog.api.OpenLogService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.json.JSONException;
import org.json.JSONObject;
import org.koin.core.Koin;
import org.koin.core.KoinApplication;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.context.DefaultContextExtKt;
import org.koin.core.context.GlobalContext;
import org.koin.core.logger.PrintLogger;
import org.koin.core.module.Module;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.qualifier.QualifierKt;
import org.koin.core.scope.Scope;
import org.koin.mp.KoinPlatformTools;

/* JADX INFO: compiled from: TapTapSdkInitializer.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 22\u00020\u0001:\u000212B\u000f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0085\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u000b\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u001aJ\u001e\u0010&\u001a\u00020'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\u0006\u0010+\u001a\u00020,H\u0002J\u0006\u0010-\u001a\u00020'J\u000e\u0010.\u001a\b\u0012\u0004\u0012\u00020*0)H\u0002J\u000e\u0010/\u001a\b\u0012\u0004\u0012\u0002000)H\u0002R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010 \u001a\u0004\b#\u0010$R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/taptap/sdk/initializer/TapTapSdkInitializer;", "Lorg/koin/core/component/KoinComponent;", "builder", "Lcom/taptap/sdk/initializer/TapTapSdkInitializer$Builder;", "(Lcom/taptap/sdk/initializer/TapTapSdkInitializer$Builder;)V", "context", "Landroid/content/Context;", "clientId", "", "clientToken", "enableLog", "", "oaidCert", "language", "Lcom/taptap/sdk/initializer/api/model/Language;", TapEventParamConstants.PARAM_PROPERTIES, "Lorg/json/JSONObject;", "region", "", "overrideBuiltInParameters", "autoIAPEventEnabled", "enableToast", "showSwitchAccount", "useAgeRange", "gameVersion", "channel", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/taptap/sdk/initializer/api/model/Language;Lorg/json/JSONObject;IZZZZZLjava/lang/String;Ljava/lang/String;)V", "dbService", "Lcom/taptap/sdk/core/DBService;", "getDbService", "()Lcom/taptap/sdk/core/DBService;", "dbService$delegate", "Lkotlin/Lazy;", "openLogService", "Lcom/taptap/sdk/openlog/api/OpenLogService;", "getOpenLogService", "()Lcom/taptap/sdk/openlog/api/OpenLogService;", "openLogService$delegate", "_initialize", "", "initializers", "", "Lcom/taptap/sdk/initializer/api/ModuleInitializer;", "options", "Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "initialize", "loadInitializers", "loadModules", "Lorg/koin/core/module/Module;", "Builder", "Companion", "tap-initializer_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapTapSdkInitializer implements KoinComponent {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean autoIAPEventEnabled;
    private final String channel;
    private final String clientId;
    private final String clientToken;
    private final Context context;

    /* JADX INFO: renamed from: dbService$delegate, reason: from kotlin metadata */
    private final Lazy dbService;
    private final boolean enableLog;
    private final boolean enableToast;
    private final String gameVersion;
    private final Language language;
    private final String oaidCert;

    /* JADX INFO: renamed from: openLogService$delegate, reason: from kotlin metadata */
    private final Lazy openLogService;
    private final boolean overrideBuiltInParameters;
    private final JSONObject properties;
    private final int region;
    private final boolean showSwitchAccount;
    private final boolean useAgeRange;

    public /* synthetic */ TapTapSdkInitializer(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TapTapSdkInitializer(Context context, String clientId, String clientToken, boolean z, String str, Language language, JSONObject jSONObject, int i, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str2, String str3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(clientToken, "clientToken");
        Intrinsics.checkNotNullParameter(language, "language");
        this.context = context;
        this.clientId = clientId;
        this.clientToken = clientToken;
        this.enableLog = z;
        this.oaidCert = str;
        this.language = language;
        this.properties = jSONObject;
        this.region = i;
        this.overrideBuiltInParameters = z2;
        this.autoIAPEventEnabled = z3;
        this.enableToast = z4;
        this.showSwitchAccount = z5;
        this.useAgeRange = z6;
        this.gameVersion = str2;
        this.channel = str3;
        final TapTapSdkInitializer tapTapSdkInitializer = this;
        LazyThreadSafetyMode lazyThreadSafetyModeDefaultLazyMode = KoinPlatformTools.INSTANCE.defaultLazyMode();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.openLogService = LazyKt.lazy(lazyThreadSafetyModeDefaultLazyMode, (Function0) new Function0<OpenLogService>() { // from class: com.taptap.sdk.initializer.TapTapSdkInitializer$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v5, types: [com.taptap.sdk.openlog.api.OpenLogService, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final OpenLogService invoke() {
                Scope rootScope;
                KoinComponent koinComponent = tapTapSdkInitializer;
                Qualifier qualifier2 = qualifier;
                Function0<? extends ParametersHolder> function0 = objArr;
                if (koinComponent instanceof KoinScopeComponent) {
                    rootScope = ((KoinScopeComponent) koinComponent).getScope();
                } else {
                    rootScope = koinComponent.getKoin().getScopeRegistry().getRootScope();
                }
                return rootScope.get(Reflection.getOrCreateKotlinClass(OpenLogService.class), qualifier2, function0);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeDefaultLazyMode2 = KoinPlatformTools.INSTANCE.defaultLazyMode();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.dbService = LazyKt.lazy(lazyThreadSafetyModeDefaultLazyMode2, (Function0) new Function0<DBService>() { // from class: com.taptap.sdk.initializer.TapTapSdkInitializer$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v5, types: [com.taptap.sdk.core.DBService, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final DBService invoke() {
                Scope rootScope;
                KoinComponent koinComponent = tapTapSdkInitializer;
                Qualifier qualifier2 = objArr2;
                Function0<? extends ParametersHolder> function0 = objArr3;
                if (koinComponent instanceof KoinScopeComponent) {
                    rootScope = ((KoinScopeComponent) koinComponent).getScope();
                } else {
                    rootScope = koinComponent.getKoin().getScopeRegistry().getRootScope();
                }
                return rootScope.get(Reflection.getOrCreateKotlinClass(DBService.class), qualifier2, function0);
            }
        });
    }

    @Override // org.koin.core.component.KoinComponent
    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OpenLogService getOpenLogService() {
        return (OpenLogService) this.openLogService.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DBService getDbService() {
        return (DBService) this.dbService.getValue();
    }

    private TapTapSdkInitializer(Builder builder) {
        this(builder.getContext(), builder.getClientId(), builder.getClientToken(), builder.getEnableLog(), builder.getOaidCert(), builder.getPreferredLanguage(), builder.getProperties(), builder.getRegion(), builder.getOverrideBuiltInParameters(), builder.getAutoIAPEventEnabled(), builder.getEnableToast(), builder.getShowSwitchAccount(), builder.getUseAgeRange(), builder.getGameVersion(), builder.getChannel());
    }

    public final void initialize() throws JSONException {
        if (GlobalContext.INSTANCE.getOrNull() == null) {
            DefaultContextExtKt.startKoin(new Function1<KoinApplication, Unit>() { // from class: com.taptap.sdk.initializer.TapTapSdkInitializer.initialize.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KoinApplication koinApplication) {
                    invoke2(koinApplication);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KoinApplication startKoin) {
                    Intrinsics.checkNotNullParameter(startKoin, "$this$startKoin");
                    startKoin.modules(TapTapSdkInitializer.this.loadModules());
                    startKoin.logger(new PrintLogger(null, 1, null));
                }
            });
        }
        List<ModuleInitializer> listLoadInitializers = loadInitializers();
        String str = this.clientId;
        String str2 = this.clientToken;
        int i = this.region;
        boolean z = this.autoIAPEventEnabled;
        JSONObject jSONObject = this.properties;
        boolean z2 = this.overrideBuiltInParameters;
        Language language = this.language;
        boolean z3 = this.useAgeRange;
        boolean z4 = this.showSwitchAccount;
        boolean z5 = this.enableToast;
        String str3 = this.oaidCert;
        _initialize(listLoadInitializers, new TapTapSdkOptions(str, str2, i, this.channel, this.gameVersion, z, z2, jSONObject, str3, false, language, z3, z4, z5, 512, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Module> loadModules() {
        Object objM184constructorimpl;
        ModuleFactories[] moduleFactoriesArrValues = ModuleFactories.values();
        ArrayList arrayList = new ArrayList();
        for (ModuleFactories moduleFactories : moduleFactoriesArrValues) {
            try {
                Result.Companion companion = Result.INSTANCE;
                TapTapSdkInitializer tapTapSdkInitializer = this;
                objM184constructorimpl = Result.m184constructorimpl(moduleFactories.getFactory().create());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM184constructorimpl = Result.m184constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m190isFailureimpl(objM184constructorimpl)) {
                objM184constructorimpl = null;
            }
            Module module = (Module) objM184constructorimpl;
            if (module != null) {
                arrayList.add(module);
            }
        }
        return CollectionsKt.toList(arrayList);
    }

    private final List<ModuleInitializer> loadInitializers() {
        Object objM184constructorimpl;
        Scope rootScope;
        KClass<?> orCreateKotlinClass;
        Initializers[] initializersArrValues = Initializers.values();
        ArrayList arrayList = new ArrayList();
        for (Initializers initializers : initializersArrValues) {
            try {
                Result.Companion companion = Result.INSTANCE;
                TapTapSdkInitializer tapTapSdkInitializer = this;
                TapTapSdkInitializer tapTapSdkInitializer2 = this;
                Qualifier qualifierNamed = QualifierKt.named(initializers);
                if (tapTapSdkInitializer2 instanceof KoinScopeComponent) {
                    rootScope = ((KoinScopeComponent) tapTapSdkInitializer2).getScope();
                    orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ModuleInitializer.class);
                } else {
                    rootScope = tapTapSdkInitializer2.getKoin().getScopeRegistry().getRootScope();
                    orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ModuleInitializer.class);
                }
                objM184constructorimpl = Result.m184constructorimpl((ModuleInitializer) rootScope.get(orCreateKotlinClass, qualifierNamed, null));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM184constructorimpl = Result.m184constructorimpl(ResultKt.createFailure(th));
            }
            ModuleInitializer moduleInitializer = (ModuleInitializer) (Result.m190isFailureimpl(objM184constructorimpl) ? null : objM184constructorimpl);
            if (moduleInitializer != null) {
                arrayList.add(moduleInitializer);
            }
        }
        return CollectionsKt.toList(arrayList);
    }

    private final void _initialize(List<? extends ModuleInitializer> initializers, TapTapSdkOptions options) throws JSONException {
        TapTapKit.INSTANCE.initializeClient(options.getClientId(), options.getClientToken(), options.getRegion());
        TapIdentifierUtil.INSTANCE.setOAIDCertString(options.getOaidCert());
        TapLocalizeUtil.INSTANCE.initialize(options.getRegion(), options.getPreferredLanguage().getLanguage());
        Iterator<T> it = initializers.iterator();
        while (it.hasNext()) {
            ((ModuleInitializer) it.next()).initialize(this.context, options);
        }
        TapLogger.INSTANCE.setEnableLog(this.enableLog);
        TapLogger.logi("TapTapKit", "startInitialize");
        TapActivityLifecycleTracker.INSTANCE.init(this.context);
        TapGatekeeperManager.INSTANCE.initialize$tap_initializer_release(this.context);
        getDbService().setAutoEventEnable(TapGatekeeperManager.INSTANCE.isAutoEventEnable());
        getOpenLogService().enableHeartbeat(TapGatekeeperManager.INSTANCE.isHeartbeatEnable());
        TapGatekeeperManager.INSTANCE.queryGatekeeper(this.context, new Function0<Unit>() { // from class: com.taptap.sdk.initializer.TapTapSdkInitializer._initialize.2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                TapTapSdkInitializer.this.getDbService().setAutoEventEnable(TapGatekeeperManager.INSTANCE.isAutoEventEnable());
                TapTapSdkInitializer.this.getOpenLogService().enableHeartbeat(TapGatekeeperManager.INSTANCE.isHeartbeatEnable());
            }
        });
        getDbService().trackDeviceLogin(options);
        getDbService().flush();
    }

    /* JADX INFO: compiled from: TapTapSdkInitializer.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010B\u001a\u00020CJ\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0006J\u000e\u0010D\u001a\u00020\u00002\u0006\u0010E\u001a\u00020\u0006J\u0010\u0010F\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u000e\u0010G\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\fJ\u000e\u0010H\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\fJ\u000e\u0010I\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u0006J\u000e\u0010K\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u0006J\u0010\u0010L\u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010\fJ\u000e\u0010M\u001a\u00020\u00002\u0006\u0010N\u001a\u00020)J\u0010\u0010O\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010\fJ\u000e\u0010P\u001a\u00020\u00002\u0006\u0010E\u001a\u00020\u0006J\u0010\u0010Q\u001a\u00020\u00002\b\u0010.\u001a\u0004\u0018\u00010/J\u000e\u0010R\u001a\u00020\u00002\u0006\u00104\u001a\u000205J\u000e\u0010S\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u0006J\u000e\u0010T\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u0006R\u001a\u0010\u0005\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\b\"\u0004\b\u001b\u0010\nR\u001a\u0010\u001c\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\b\"\u0004\b\u001e\u0010\nR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000e\"\u0004\b!\u0010\u0010R\u001c\u0010\"\u001a\u0004\u0018\u00010\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u000e\"\u0004\b$\u0010\u0010R\u001a\u0010%\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\b\"\u0004\b'\u0010\nR\u001a\u0010(\u001a\u00020)X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R \u00104\u001a\u000205X\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010<\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\b\"\u0004\b>\u0010\nR\u001a\u0010?\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\b\"\u0004\bA\u0010\n¨\u0006U"}, d2 = {"Lcom/taptap/sdk/initializer/TapTapSdkInitializer$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "autoIAPEventEnabled", "", "getAutoIAPEventEnabled$tap_initializer_release", "()Z", "setAutoIAPEventEnabled$tap_initializer_release", "(Z)V", "channel", "", "getChannel$tap_initializer_release", "()Ljava/lang/String;", "setChannel$tap_initializer_release", "(Ljava/lang/String;)V", "clientId", "getClientId$tap_initializer_release", "setClientId$tap_initializer_release", "clientToken", "getClientToken$tap_initializer_release", "setClientToken$tap_initializer_release", "getContext$tap_initializer_release", "()Landroid/content/Context;", "enableLog", "getEnableLog$tap_initializer_release", "setEnableLog$tap_initializer_release", "enableToast", "getEnableToast$tap_initializer_release", "setEnableToast$tap_initializer_release", "gameVersion", "getGameVersion$tap_initializer_release", "setGameVersion$tap_initializer_release", "oaidCert", "getOaidCert$tap_initializer_release", "setOaidCert$tap_initializer_release", "overrideBuiltInParameters", "getOverrideBuiltInParameters$tap_initializer_release", "setOverrideBuiltInParameters$tap_initializer_release", "preferredLanguage", "Lcom/taptap/sdk/initializer/api/model/Language;", "getPreferredLanguage$tap_initializer_release", "()Lcom/taptap/sdk/initializer/api/model/Language;", "setPreferredLanguage$tap_initializer_release", "(Lcom/taptap/sdk/initializer/api/model/Language;)V", TapEventParamConstants.PARAM_PROPERTIES, "Lorg/json/JSONObject;", "getProperties$tap_initializer_release", "()Lorg/json/JSONObject;", "setProperties$tap_initializer_release", "(Lorg/json/JSONObject;)V", "region", "", "getRegion$tap_initializer_release$annotations", "()V", "getRegion$tap_initializer_release", "()I", "setRegion$tap_initializer_release", "(I)V", "showSwitchAccount", "getShowSwitchAccount$tap_initializer_release", "setShowSwitchAccount$tap_initializer_release", "useAgeRange", "getUseAgeRange$tap_initializer_release", "setUseAgeRange$tap_initializer_release", "build", "Lcom/taptap/sdk/initializer/TapTapSdkInitializer;", "setAutoIAPEventEnabled", "enable", "setChannel", "setClientId", "setClientToken", "setEnableLog", "enabled", "setEnableToast", "setGameVersion", "setLanguage", "language", "setOaidCert", "setOverrideBuiltInParameters", "setProperties", "setRegion", "setShowSwitchAccount", "setUseAgeRange", "tap-initializer_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Builder {
        private boolean autoIAPEventEnabled;
        private String channel;
        private String clientId;
        private String clientToken;
        private final Context context;
        private boolean enableLog;
        private boolean enableToast;
        private String gameVersion;
        private String oaidCert;
        private boolean overrideBuiltInParameters;
        private Language preferredLanguage;
        private JSONObject properties;
        private int region;
        private boolean showSwitchAccount;
        private boolean useAgeRange;

        public static /* synthetic */ void getRegion$tap_initializer_release$annotations() {
        }

        public Builder(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
            this.clientId = "";
            this.clientToken = "";
            this.preferredLanguage = Language.AUTO;
        }

        /* JADX INFO: renamed from: getContext$tap_initializer_release, reason: from getter */
        public final Context getContext() {
            return this.context;
        }

        /* JADX INFO: renamed from: getUseAgeRange$tap_initializer_release, reason: from getter */
        public final boolean getUseAgeRange() {
            return this.useAgeRange;
        }

        public final void setUseAgeRange$tap_initializer_release(boolean z) {
            this.useAgeRange = z;
        }

        /* JADX INFO: renamed from: getShowSwitchAccount$tap_initializer_release, reason: from getter */
        public final boolean getShowSwitchAccount() {
            return this.showSwitchAccount;
        }

        public final void setShowSwitchAccount$tap_initializer_release(boolean z) {
            this.showSwitchAccount = z;
        }

        /* JADX INFO: renamed from: getEnableToast$tap_initializer_release, reason: from getter */
        public final boolean getEnableToast() {
            return this.enableToast;
        }

        public final void setEnableToast$tap_initializer_release(boolean z) {
            this.enableToast = z;
        }

        /* JADX INFO: renamed from: getClientId$tap_initializer_release, reason: from getter */
        public final String getClientId() {
            return this.clientId;
        }

        public final void setClientId$tap_initializer_release(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.clientId = str;
        }

        /* JADX INFO: renamed from: getClientToken$tap_initializer_release, reason: from getter */
        public final String getClientToken() {
            return this.clientToken;
        }

        public final void setClientToken$tap_initializer_release(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.clientToken = str;
        }

        /* JADX INFO: renamed from: getRegion$tap_initializer_release, reason: from getter */
        public final int getRegion() {
            return this.region;
        }

        public final void setRegion$tap_initializer_release(int i) {
            this.region = i;
        }

        /* JADX INFO: renamed from: getChannel$tap_initializer_release, reason: from getter */
        public final String getChannel() {
            return this.channel;
        }

        public final void setChannel$tap_initializer_release(String str) {
            this.channel = str;
        }

        /* JADX INFO: renamed from: getGameVersion$tap_initializer_release, reason: from getter */
        public final String getGameVersion() {
            return this.gameVersion;
        }

        public final void setGameVersion$tap_initializer_release(String str) {
            this.gameVersion = str;
        }

        /* JADX INFO: renamed from: getAutoIAPEventEnabled$tap_initializer_release, reason: from getter */
        public final boolean getAutoIAPEventEnabled() {
            return this.autoIAPEventEnabled;
        }

        public final void setAutoIAPEventEnabled$tap_initializer_release(boolean z) {
            this.autoIAPEventEnabled = z;
        }

        /* JADX INFO: renamed from: getOverrideBuiltInParameters$tap_initializer_release, reason: from getter */
        public final boolean getOverrideBuiltInParameters() {
            return this.overrideBuiltInParameters;
        }

        public final void setOverrideBuiltInParameters$tap_initializer_release(boolean z) {
            this.overrideBuiltInParameters = z;
        }

        /* JADX INFO: renamed from: getProperties$tap_initializer_release, reason: from getter */
        public final JSONObject getProperties() {
            return this.properties;
        }

        public final void setProperties$tap_initializer_release(JSONObject jSONObject) {
            this.properties = jSONObject;
        }

        /* JADX INFO: renamed from: getOaidCert$tap_initializer_release, reason: from getter */
        public final String getOaidCert() {
            return this.oaidCert;
        }

        public final void setOaidCert$tap_initializer_release(String str) {
            this.oaidCert = str;
        }

        /* JADX INFO: renamed from: getEnableLog$tap_initializer_release, reason: from getter */
        public final boolean getEnableLog() {
            return this.enableLog;
        }

        public final void setEnableLog$tap_initializer_release(boolean z) {
            this.enableLog = z;
        }

        /* JADX INFO: renamed from: getPreferredLanguage$tap_initializer_release, reason: from getter */
        public final Language getPreferredLanguage() {
            return this.preferredLanguage;
        }

        public final void setPreferredLanguage$tap_initializer_release(Language language) {
            Intrinsics.checkNotNullParameter(language, "<set-?>");
            this.preferredLanguage = language;
        }

        public final Builder setClientId(String clientId) {
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            this.clientId = clientId;
            return this;
        }

        public final Builder enableLog(boolean enableLog) {
            this.enableLog = enableLog;
            return this;
        }

        public final Builder setOaidCert(String oaidCert) {
            this.oaidCert = oaidCert;
            return this;
        }

        public final Builder setRegion(int region) {
            this.region = region;
            return this;
        }

        public final Builder setClientToken(String clientToken) {
            Intrinsics.checkNotNullParameter(clientToken, "clientToken");
            this.clientToken = clientToken;
            return this;
        }

        public final Builder setLanguage(Language language) {
            Intrinsics.checkNotNullParameter(language, "language");
            this.preferredLanguage = language;
            return this;
        }

        public final Builder setProperties(JSONObject properties) {
            this.properties = properties;
            return this;
        }

        public final Builder setChannel(String channel) {
            this.channel = channel;
            return this;
        }

        public final Builder setAutoIAPEventEnabled(boolean enable) {
            this.autoIAPEventEnabled = enable;
            return this;
        }

        public final Builder setOverrideBuiltInParameters(boolean enable) {
            this.overrideBuiltInParameters = enable;
            return this;
        }

        public final Builder setGameVersion(String gameVersion) {
            this.gameVersion = gameVersion;
            return this;
        }

        public final Builder setEnableLog(boolean enabled) {
            this.enableLog = enabled;
            return this;
        }

        public final Builder setEnableToast(boolean enabled) {
            this.enableToast = enabled;
            return this;
        }

        public final Builder setShowSwitchAccount(boolean enabled) {
            this.showSwitchAccount = enabled;
            return this;
        }

        public final Builder setUseAgeRange(boolean enabled) {
            this.useAgeRange = enabled;
            return this;
        }

        public final TapTapSdkInitializer build() {
            if (!(this.clientId.length() > 0)) {
                throw new IllegalStateException("A valid TapTap clientId must be not null or empty in init".toString());
            }
            if (!(this.clientToken.length() > 0)) {
                throw new IllegalStateException("A valid TapTap clientToken must be not null or empty in init".toString());
            }
            return new TapTapSdkInitializer(this, null);
        }
    }

    /* JADX INFO: compiled from: TapTapSdkInitializer.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/taptap/sdk/initializer/TapTapSdkInitializer$Companion;", "", "()V", "setPreferredLanguage", "", "language", "Lcom/taptap/sdk/initializer/api/model/Language;", "tap-initializer_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void setPreferredLanguage(Language language) {
            Intrinsics.checkNotNullParameter(language, "language");
            TapLocalizeUtil.INSTANCE.setPreferredLanguage(language.getLanguage());
        }
    }
}
