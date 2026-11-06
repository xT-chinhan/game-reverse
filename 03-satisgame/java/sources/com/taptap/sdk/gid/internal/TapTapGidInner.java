package com.taptap.sdk.gid.internal;

import android.content.Context;
import com.anythink.core.common.l.f;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import com.taptap.sdk.gid.api.GidService;
import com.taptap.sdk.gid.internal.bean.TapGid;
import com.taptap.sdk.gid.internal.bean.TapThemisData;
import com.taptap.sdk.gid.internal.util.TapOpenlogHelper;
import com.taptap.sdk.initializer.api.option.TapTapSdkOptions;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.TapTapKit;
import com.taptap.sdk.kit.internal.http.TapHttp;
import com.taptap.sdk.kit.internal.http.call.TapHttpCall;
import com.taptap.sdk.kit.internal.http.hanlder.TapHttpBackoff;
import com.taptap.sdk.kit.internal.http.hanlder.TapHttpParser;
import com.taptap.sdk.kit.internal.http.hanlder.TapHttpRetry;
import com.taptap.sdk.kit.internal.http.param.AbsTapHttpParam;
import com.taptap.sdk.kit.internal.http.param.TapHttpJsonParam;
import com.taptap.sdk.kit.internal.identifier.TapIdentifierUtil;
import com.taptap.sdk.kit.internal.json.TapJson;
import com.taptap.sdk.themis.lite.ThemisLite;
import com.taptap.sdk.themis.lite.ThemisLiteCallback;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Regex;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import org.koin.mp.KoinPlatformTools;

/* JADX INFO: compiled from: TapTapGidInner.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010*\u001a\u00020\bH\u0002J\b\u0010+\u001a\u00020\bH\u0002J\b\u0010,\u001a\u00020-H\u0002J\u0016\u0010.\u001a\u00020-2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010/\u001a\u000200J\u0012\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u00104\u001a\u00020-2\u0006\u00105\u001a\u00020\u00042\u0006\u00106\u001a\u00020\bH\u0002J\b\u00107\u001a\u00020-H\u0002J\u0012\u00108\u001a\u00020-2\b\u00109\u001a\u0004\u0018\u00010:H\u0002J\u0012\u0010;\u001a\u00020-2\b\u0010<\u001a\u0004\u0018\u00010\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010 \u001a\u0004\b'\u0010(¨\u0006="}, d2 = {"Lcom/taptap/sdk/gid/internal/TapTapGidInner;", "Lorg/koin/core/component/KoinComponent;", "()V", "CALLBACK_CODE_CACHE", "", "CALLBACK_CODE_CURRENT", "CALLBACK_CODE_NETWORK", "GID_QUERY_HOST_CN", "", "GID_QUERY_HOST_CN_RND", "GID_QUERY_HOST_COM", "GID_QUERY_HOST_COM_RND", "REQUEST_DELAY", "", "THEMIS_HOST_CN", "THEMIS_HOST_COM", "THEMIS_INIT_TIME_OUT", "URL_QUERY", "clientId", "clientToken", "context", "Landroid/content/Context;", "currentGid", "getCurrentGid$tap_gid_release", "()Ljava/lang/String;", "setCurrentGid$tap_gid_release", "(Ljava/lang/String;)V", "gidService", "Lcom/taptap/sdk/gid/api/GidService;", "getGidService", "()Lcom/taptap/sdk/gid/api/GidService;", "gidService$delegate", "Lkotlin/Lazy;", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "regionType", "startTime", "tapHttp", "Lcom/taptap/sdk/kit/internal/http/TapHttp;", "getTapHttp", "()Lcom/taptap/sdk/kit/internal/http/TapHttp;", "tapHttp$delegate", "getQueryHost", "getThemisHost", "initGidCache", "", "initialize", "option", "Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "isStringMadeOfZeroAndDash", "", "str", "notifyUpdateCallbacks", "code", TapEventParamConstants.PARAM_SUB_GID, "startQueryADID", "startQueryGid", "themisData", "Lcom/taptap/sdk/gid/internal/bean/TapThemisData;", "startQueryThemisData", "currentADID", "tap-gid_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapTapGidInner implements KoinComponent {
    public static final int CALLBACK_CODE_CACHE = 1;
    public static final int CALLBACK_CODE_CURRENT = 3;
    public static final int CALLBACK_CODE_NETWORK = 2;
    private static final String GID_QUERY_HOST_CN = "gid.tapapis.cn";
    private static final String GID_QUERY_HOST_CN_RND = "gid.api.xdrnd.cn";
    private static final String GID_QUERY_HOST_COM = "gid.tapapis.com";
    private static final String GID_QUERY_HOST_COM_RND = "gid.api.xdrnd.com";
    public static final TapTapGidInner INSTANCE;
    private static final long REQUEST_DELAY = 600;
    private static final String THEMIS_HOST_CN = "gid-data.tapapis.cn";
    private static final String THEMIS_HOST_COM = "gid-data.tapapis.com";
    private static final long THEMIS_INIT_TIME_OUT = 5000;
    private static final String URL_QUERY = "device/v1/query";
    private static String clientId;
    private static String clientToken;
    private static Context context;
    private static volatile String currentGid;

    /* JADX INFO: renamed from: gidService$delegate, reason: from kotlin metadata */
    private static final Lazy gidService;
    private static final AtomicBoolean initialized;
    private static int regionType;
    private static long startTime;

    /* JADX INFO: renamed from: tapHttp$delegate, reason: from kotlin metadata */
    private static final Lazy tapHttp;

    private TapTapGidInner() {
    }

    @Override // org.koin.core.component.KoinComponent
    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        TapTapGidInner tapTapGidInner = new TapTapGidInner();
        INSTANCE = tapTapGidInner;
        initialized = new AtomicBoolean(false);
        clientId = "";
        clientToken = "";
        tapHttp = LazyKt.lazy(new Function0<TapHttp>() { // from class: com.taptap.sdk.gid.internal.TapTapGidInner$tapHttp$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TapHttp invoke() {
                return TapHttp.INSTANCE.newBuilder("TapSDKCore", "4.5.0").domain(TapTapGidInner.INSTANCE.getQueryHost()).build();
            }
        });
        final TapTapGidInner tapTapGidInner2 = tapTapGidInner;
        LazyThreadSafetyMode lazyThreadSafetyModeDefaultLazyMode = KoinPlatformTools.INSTANCE.defaultLazyMode();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        gidService = LazyKt.lazy(lazyThreadSafetyModeDefaultLazyMode, (Function0) new Function0<GidService>() { // from class: com.taptap.sdk.gid.internal.TapTapGidInner$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v5, types: [com.taptap.sdk.gid.api.GidService, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final GidService invoke() {
                Scope rootScope;
                KoinComponent koinComponent = tapTapGidInner2;
                Qualifier qualifier2 = qualifier;
                Function0<? extends ParametersHolder> function0 = objArr;
                if (koinComponent instanceof KoinScopeComponent) {
                    rootScope = ((KoinScopeComponent) koinComponent).getScope();
                } else {
                    rootScope = koinComponent.getKoin().getScopeRegistry().getRootScope();
                }
                return rootScope.get(Reflection.getOrCreateKotlinClass(GidService.class), qualifier2, function0);
            }
        });
        startTime = System.currentTimeMillis();
    }

    public final String getCurrentGid$tap_gid_release() {
        return currentGid;
    }

    public final void setCurrentGid$tap_gid_release(String str) {
        currentGid = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TapHttp getTapHttp() {
        return (TapHttp) tapHttp.getValue();
    }

    private final GidService getGidService() {
        return (GidService) gidService.getValue();
    }

    public final void initialize(Context context2, TapTapSdkOptions option) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(option, "option");
        if (initialized.compareAndSet(false, true)) {
            TapLogger.logd("TapTapGid", "initialize start");
            TapOpenlogHelper.INSTANCE.reportTechnicalLog("initialize", MapsKt.mapOf(TuplesKt.to("clientId", option.getClientId()), TuplesKt.to("clientToken", option.getClientToken()), TuplesKt.to("regionType", String.valueOf(regionType)), TuplesKt.to("preferredLanguage", option.getPreferredLanguage().getLanguage())));
            startTime = System.currentTimeMillis();
            Context applicationContext = context2.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            context = applicationContext;
            clientId = option.getClientId();
            clientToken = option.getClientToken();
            regionType = option.getRegion();
            initGidCache();
            startQueryADID();
            TapLogger.logd("TapTapGid", "initialize end, cost: " + (System.currentTimeMillis() - startTime) + "ms");
        }
    }

    private final void startQueryADID() {
        TapLogger.logd("TapTapGid", "startQueryADID");
        int i = regionType;
        if (i == 0) {
            TapIdentifierUtil.INSTANCE.queryOAID(new Function1<String, Unit>() { // from class: com.taptap.sdk.gid.internal.TapTapGidInner.startQueryADID.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str) {
                    String str2 = str;
                    String str3 = ((str2 == null || str2.length() == 0) || TapTapGidInner.INSTANCE.isStringMadeOfZeroAndDash(str)) ? null : "O:" + str;
                    TapLogger.logd("TapTapGid", "queryOAID: " + str3 + ", cost: " + (System.currentTimeMillis() - TapTapGidInner.startTime) + "ms");
                    TapOpenlogHelper.INSTANCE.reportTechnicalLog("query_oaid", MapsKt.mapOf(TuplesKt.to("oaid", str3)));
                    TapTapGidInner.INSTANCE.startQueryThemisData(str3);
                }
            });
        } else if (i == 1) {
            TapIdentifierUtil.INSTANCE.queryGAID(new Function1<TapIdentifierUtil.GAID, Unit>() { // from class: com.taptap.sdk.gid.internal.TapTapGidInner.startQueryADID.2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TapIdentifierUtil.GAID gaid) {
                    invoke2(gaid);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(TapIdentifierUtil.GAID gaid) {
                    String str = null;
                    String androidAdvertiserIdValue = gaid != null ? gaid.getAndroidAdvertiserIdValue() : null;
                    String str2 = androidAdvertiserIdValue;
                    if (!(str2 == null || str2.length() == 0) && !TapTapGidInner.INSTANCE.isStringMadeOfZeroAndDash(androidAdvertiserIdValue)) {
                        str = "G:" + androidAdvertiserIdValue;
                    }
                    TapLogger.logd("TapTapGid", "queryGAID: " + gaid + ", cost: " + (System.currentTimeMillis() - TapTapGidInner.startTime) + "ms");
                    TapOpenlogHelper.INSTANCE.reportTechnicalLog("query_gaid", MapsKt.mapOf(TuplesKt.to("gaid", str)));
                    TapTapGidInner.INSTANCE.startQueryThemisData(str);
                }
            });
        } else {
            TapLogger.logd("TapTapGid", "Wrong configuration [regionType], please check whether the initialization parameter regionType is correct");
            TapOpenlogHelper.INSTANCE.reportTechnicalLog("query_adid_wrong", MapsKt.mapOf(TuplesKt.to("message", "Wrong configuration RegionType[" + regionType + AbstractJsonLexerKt.END_LIST)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startQueryThemisData(String currentADID) {
        TapLogger.logd("TapTapGid", "startQueryThemisData currentADID: " + currentADID);
        String str = currentGid;
        ThemisLiteCallback themisLiteCallback = new ThemisLiteCallback() { // from class: com.taptap.sdk.gid.internal.TapTapGidInner$startQueryThemisData$themisLiteCallback$1
            @Override // com.taptap.sdk.themis.lite.ThemisLiteCallback
            public void getThemisOAID(String oaid) {
                TapLogger.logd("TapTapGid", "ThemisRemote getThemisOAID: " + oaid);
            }

            @Override // com.taptap.sdk.themis.lite.ThemisLiteCallback
            public void getThemisOneIDData(String oneIDData) throws JSONException {
                TapLogger.logd("TapTapGid", "ThemisRemote getThemisOneIDData: " + oneIDData + ", cost: " + (System.currentTimeMillis() - TapTapGidInner.startTime) + "ms");
                if (oneIDData == null) {
                    return;
                }
                TapJson tapJson = TapJson.INSTANCE;
                Object objDecodeFromString = null;
                if (!(oneIDData.length() == 0)) {
                    try {
                        Json json = tapJson.getJson();
                        KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(TapThemisData.class));
                        Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                        objDecodeFromString = json.decodeFromString(kSerializerSerializer, oneIDData);
                    } catch (Exception e) {
                        TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
                    }
                }
                TapTapGidInner.INSTANCE.startQueryGid((TapThemisData) objDecodeFromString);
            }
        };
        String themisHost = getThemisHost();
        ThemisLiteCallback themisLiteCallback2 = themisLiteCallback;
        String str2 = currentADID == null ? "" : currentADID;
        String str3 = str == null ? "" : str;
        int i = regionType;
        ThemisLite.InitThemis(themisHost, themisLiteCallback2, 5000L, str2, str3, i == 0, i == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startQueryGid(TapThemisData themisData) throws JSONException {
        String data = themisData != null ? themisData.getData() : null;
        String str = data;
        if (str == null || str.length() == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("platform", "android");
        jSONObject.put("metadata", data);
        BuildersKt__Builders_commonKt.launch$default(TapTapKit.INSTANCE.getTapApplicationScope(), null, null, new C04781(jSONObject, null), 3, null);
    }

    /* JADX INFO: renamed from: com.taptap.sdk.gid.internal.TapTapGidInner$startQueryGid$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TapTapGidInner.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.gid.internal.TapTapGidInner$startQueryGid$1", f = "TapTapGidInner.kt", i = {}, l = {203}, m = "invokeSuspend", n = {}, s = {})
    static final class C04781 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ JSONObject $params;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04781(JSONObject jSONObject, Continuation<? super C04781> continuation) {
            super(2, continuation);
            this.$params = jSONObject;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C04781(this.$params, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04781) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objMo73enqueueResultgIAlus;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            int i2 = 1;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AbsTapHttpParam<TapHttpJsonParam> absTapHttpParamRetryBackoff = TapTapGidInner.INSTANCE.getTapHttp().postJson(TapTapGidInner.URL_QUERY).addBody(this.$params).retryBackoff(new TapHttpBackoff.Exponential());
                this.label = 1;
                objMo73enqueueResultgIAlus = new TapHttpCall(absTapHttpParamRetryBackoff, new TapHttpParser.SdkDefaultParser(null, new Function1<JsonObject, TapGid>() { // from class: com.taptap.sdk.gid.internal.TapTapGidInner$startQueryGid$1$invokeSuspend$$inlined$toCall$1
                    /* JADX WARN: Type inference failed for: r1v2, types: [com.taptap.sdk.gid.internal.bean.TapGid, java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function1
                    public final TapGid invoke(JsonObject jsonObject) {
                        TapJson tapJson = TapJson.INSTANCE;
                        try {
                            if (jsonObject == null) {
                                return null;
                            }
                            Json json = tapJson.getJson();
                            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.nullableTypeOf(TapGid.class));
                            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                            return json.decodeFromJsonElement(kSerializerSerializer, jsonObject);
                        } catch (Exception e) {
                            TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
                            return null;
                        }
                    }
                }, i2, 0 == true ? 1 : 0), new TapHttpRetry.SdkDefault(absTapHttpParamRetryBackoff.getBackoffHandler())).mo73enqueueResultgIAlus(TapTapGidInner.REQUEST_DELAY, this);
                if (objMo73enqueueResultgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objMo73enqueueResultgIAlus = ((Result) obj).getValue();
            }
            if (Result.m191isSuccessimpl(objMo73enqueueResultgIAlus)) {
                TapGid tapGid = (TapGid) objMo73enqueueResultgIAlus;
                TapLogger.logd("TapTapGid", "queryGid onSuccess, response = " + tapGid + ", cost: " + (System.currentTimeMillis() - TapTapGidInner.startTime) + "ms");
                String id = tapGid.getId();
                TapOpenlogHelper.INSTANCE.reportTechnicalLog("http_successful", MapsKt.mapOf(TuplesKt.to(f.R, tapGid.toString()), TuplesKt.to("id", id)));
                String str = id;
                if (str != null && str.length() != 0) {
                    i2 = 0;
                }
                if (i2 == 0) {
                    TapTapGidInner.INSTANCE.setCurrentGid$tap_gid_release(id);
                    TapGidStorage.INSTANCE.saveGidToSp(TapTapGidInner.regionType, id);
                    TapTapGidInner.INSTANCE.notifyUpdateCallbacks(2, id);
                }
                TapLogger.logd("TapTapGid", "queryGid onSuccess, newGid = " + id + ", cost: " + (System.currentTimeMillis() - TapTapGidInner.startTime) + "ms");
            }
            Throwable thM187exceptionOrNullimpl = Result.m187exceptionOrNullimpl(objMo73enqueueResultgIAlus);
            if (thM187exceptionOrNullimpl != null) {
                TapLogger.logd("TapTapGid", "queryGid onError, responseError = " + thM187exceptionOrNullimpl);
                TapOpenlogHelper.INSTANCE.reportTechnicalLog("http_failure", MapsKt.mapOf(TuplesKt.to("throwable", String.valueOf(thM187exceptionOrNullimpl.getMessage()))));
            }
            return Unit.INSTANCE;
        }
    }

    private final void initGidCache() {
        String gidFromSp = TapGidStorage.INSTANCE.getGidFromSp(regionType);
        String str = gidFromSp;
        if (str == null || str.length() == 0) {
            TapGidStorage tapGidStorage = TapGidStorage.INSTANCE;
            Context context2 = context;
            Context context3 = null;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context2 = null;
            }
            String deprecatedSpGid = tapGidStorage.getDeprecatedSpGid(context2);
            String str2 = deprecatedSpGid;
            if (!(str2 == null || str2.length() == 0)) {
                TapGidStorage tapGidStorage2 = TapGidStorage.INSTANCE;
                Context context4 = context;
                if (context4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("context");
                } else {
                    context3 = context4;
                }
                tapGidStorage2.clearDeprecatedSpGid(context3);
                TapGidStorage.INSTANCE.saveGidToSp(regionType, deprecatedSpGid);
                TapLogger.logd("TapTapGid", "find deprecatedCache: " + deprecatedSpGid);
                TapOpenlogHelper.INSTANCE.reportTechnicalLog("find_deprecated_cache", MapsKt.mapOf(TuplesKt.to("deprecated_cache", gidFromSp)));
                currentGid = deprecatedSpGid;
                notifyUpdateCallbacks(1, deprecatedSpGid);
            }
        } else {
            TapLogger.logd("TapTapGid", "find cache: " + gidFromSp);
            TapOpenlogHelper.INSTANCE.reportTechnicalLog("find_cache", MapsKt.mapOf(TuplesKt.to("cache", gidFromSp)));
            currentGid = gidFromSp;
            notifyUpdateCallbacks(1, gidFromSp);
        }
        TapOpenlogHelper.INSTANCE.reportTechnicalLog("init_gid_cache", MapsKt.mapOf(TuplesKt.to("currentGid", gidFromSp)));
        TapLogger.logd("TapTapGid", "initGidCache currentGid: " + currentGid + ", cost: " + (System.currentTimeMillis() - startTime) + "ms");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isStringMadeOfZeroAndDash(String str) {
        if (str == null) {
            return false;
        }
        try {
            return new Regex("^[0\\-]*$").matches(str);
        } catch (Exception e) {
            TapLogger.logd("TapTapGid", e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getQueryHost() {
        if (TapTapKit.INSTANCE.isRND()) {
            int i = regionType;
            return (i == 0 || i != 1) ? GID_QUERY_HOST_CN_RND : GID_QUERY_HOST_COM_RND;
        }
        int i2 = regionType;
        return (i2 == 0 || i2 != 1) ? GID_QUERY_HOST_CN : GID_QUERY_HOST_COM;
    }

    private final String getThemisHost() {
        int i = regionType;
        return (i == 0 || i != 1) ? THEMIS_HOST_CN : THEMIS_HOST_COM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyUpdateCallbacks(int code, String gid) {
        TapLogger.logd("TapTapGid", "notifyUpdateCallbacks gid = " + gid);
        getGidService().notifyUpdateCallbacks(code, gid);
    }
}
