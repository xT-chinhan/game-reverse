package com.taptap.sdk.compilance.api;

import com.anythink.core.common.l.f;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.compilance.bean.CheckPlayResult;
import com.taptap.sdk.compilance.bean.IdentityVerifyState;
import com.taptap.sdk.compilance.bean.UserInfo;
import com.taptap.sdk.compilance.bean.request.HeartbeatRequestParams;
import com.taptap.sdk.compilance.bean.request.IdentityVerifyRequestParams;
import com.taptap.sdk.compilance.bean.request.UpgradeTokenRequestParams;
import com.taptap.sdk.compilance.constants.RequestPath;
import com.taptap.sdk.compilance.extensions.SystemExtKt;
import com.taptap.sdk.compilance.internal.TapComplianceApi;
import com.taptap.sdk.compilance.internal.TapComplianceApiKt;
import com.taptap.sdk.compilance.internal.TapComplianceInternal;
import com.taptap.sdk.compilance.internal.TapComplianceLoggerKt;
import com.taptap.sdk.compilance.internal.TapComplianceSettings;
import com.taptap.sdk.compilance.model.PlayLogModel;
import com.taptap.sdk.compilance.model.TapLoginModel;
import com.taptap.sdk.compilance.model.UserModel;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.callback.TapTapCallback;
import com.taptap.sdk.kit.internal.exception.TapTapException;
import com.taptap.sdk.kit.internal.extensions.NetExtKt;
import com.taptap.sdk.kit.internal.http.TapErrorConstants;
import com.taptap.sdk.kit.internal.http.TapHttp;
import com.taptap.sdk.kit.internal.http.TapHttpException;
import com.taptap.sdk.kit.internal.http.call.ITapHttpCall;
import com.taptap.sdk.kit.internal.http.call.TapHttpCall;
import com.taptap.sdk.kit.internal.http.hanlder.ITapHttpResponseHandler;
import com.taptap.sdk.kit.internal.http.hanlder.TapHttpParser;
import com.taptap.sdk.kit.internal.http.hanlder.TapHttpRetry;
import com.taptap.sdk.kit.internal.http.param.AbsTapHttpParam;
import com.taptap.sdk.kit.internal.http.param.TapHttpJsonParam;
import com.taptap.sdk.kit.internal.http.param.TapHttpNoBodyParam;
import com.taptap.sdk.kit.internal.json.TapJson;
import com.taptap.sdk.login.AccessToken;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonObject;
import org.json.JSONObject;

/* JADX INFO: compiled from: IdentityVerifyApi.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u001e\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000e0\bJ(\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\bJ\u0014\u0010\u0013\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000e0\bJ\u0014\u0010\u0014\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000e0\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/taptap/sdk/compilance/api/IdentityVerifyApi;", "", "()V", "tapAuthRequestRetryCount", "", "checkPlay", "Lkotlinx/coroutines/Job;", "callback", "Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", "Lcom/taptap/sdk/compilance/bean/CheckPlayResult;", "getTokenWithTapToken", "", "accessToken", "Lcom/taptap/sdk/login/AccessToken;", "Lcom/taptap/sdk/compilance/bean/IdentityVerifyState;", "requestIdentityVerifyInfoManually", TapEventParamConstants.PARAM_NAME, "", "idCard", "requestIdentityVerifyInfoRemotely", "upgradeToken", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class IdentityVerifyApi {
    public static final IdentityVerifyApi INSTANCE = new IdentityVerifyApi();
    private static volatile int tapAuthRequestRetryCount = 1;

    private IdentityVerifyApi() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Job requestIdentityVerifyInfoManually$default(IdentityVerifyApi identityVerifyApi, String str, String str2, TapTapCallback tapTapCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            tapTapCallback = null;
        }
        return identityVerifyApi.requestIdentityVerifyInfoManually(str, str2, tapTapCallback);
    }

    /* JADX INFO: renamed from: com.taptap.sdk.compilance.api.IdentityVerifyApi$requestIdentityVerifyInfoManually$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IdentityVerifyApi.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.compilance.api.IdentityVerifyApi$requestIdentityVerifyInfoManually$1", f = "IdentityVerifyApi.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM, 47, 52}, m = "invokeSuspend", n = {}, s = {})
    static final class C04541 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ TapTapCallback<IdentityVerifyState> $callback;
        final /* synthetic */ String $idCard;
        final /* synthetic */ String $name;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04541(String str, String str2, TapTapCallback<IdentityVerifyState> tapTapCallback, Continuation<? super C04541> continuation) {
            super(1, continuation);
            this.$name = str;
            this.$idCard = str2;
            this.$callback = tapTapCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C04541(this.$name, this.$idCard, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C04541) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:43:0x014e  */
        /* JADX WARN: Code duplicated, block: B:45:0x015f A[RETURN] */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String strEncodeToString;
            JSONObject jSONObject;
            String accessToken;
            Object objM76enqueueResultgIAlus$default;
            Object obj2;
            TapTapCallback<IdentityVerifyState> tapTapCallback;
            Throwable thM187exceptionOrNullimpl;
            IdentityVerifyApi$requestIdentityVerifyInfoManually$1$2$1 identityVerifyApi$requestIdentityVerifyInfoManually$1$2$1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            int i2 = 1;
            ITapHttpResponseHandler iTapHttpResponseHandler = null;
            Object[] objArr = 0;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                TapComplianceApi tapComplianceApi = TapComplianceApi.INSTANCE;
                TapJson tapJson = TapJson.INSTANCE;
                IdentityVerifyRequestParams identityVerifyRequestParams = new IdentityVerifyRequestParams(this.$name, this.$idCard);
                try {
                    Json json = tapJson.getJson();
                    KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(IdentityVerifyRequestParams.class));
                    Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    strEncodeToString = json.encodeToString(kSerializerSerializer, identityVerifyRequestParams);
                } catch (Exception e) {
                    TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
                    strEncodeToString = null;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                TapHttpJsonParam tapHttpJsonParamPostJson = TapComplianceApiKt.getNetApi().postJson(RequestPath.IDENTITY_VERIFY_MANUAL);
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    AbsTapHttpParam.addQuery$default(tapHttpJsonParamPostJson, (String) entry.getKey(), (String) entry.getValue(), false, 4, null);
                }
                if (strEncodeToString != null) {
                    jSONObject = new JSONObject(strEncodeToString);
                } else {
                    jSONObject = new JSONObject();
                }
                if (TapComplianceInternal.INSTANCE.isTestEnvironment()) {
                    AbsTapHttpParam.addQuery$default(tapHttpJsonParamPostJson, f.aI, "1", false, 4, null);
                }
                tapHttpJsonParamPostJson.addBody(jSONObject);
                TapComplianceLoggerKt.logInfo("TapComplianceApi post: body=" + jSONObject);
                TapHttpJsonParam tapHttpJsonParam = tapHttpJsonParamPostJson;
                UserInfo currentUser = UserModel.INSTANCE.getCurrentUser();
                if (currentUser == null || (accessToken = currentUser.getAccessToken()) == null) {
                    accessToken = "";
                }
                AbsTapHttpParam absTapHttpParamAddHeader$default = AbsTapHttpParam.addHeader$default(tapHttpJsonParam, "X-TAP-Anti-Addiction-Token", accessToken, false, 4, null);
                this.label = 1;
                objM76enqueueResultgIAlus$default = ITapHttpCall.DefaultImpls.m76enqueueResultgIAlus$default(new TapHttpCall(absTapHttpParamAddHeader$default, new TapHttpParser.SdkDefaultParser(iTapHttpResponseHandler, new Function1<JsonObject, IdentityVerifyState>() { // from class: com.taptap.sdk.compilance.api.IdentityVerifyApi$requestIdentityVerifyInfoManually$1$invokeSuspend$$inlined$post-BWLJW6A$default$1
                    /* JADX WARN: Type inference failed for: r1v2, types: [com.taptap.sdk.compilance.bean.IdentityVerifyState, java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function1
                    public final IdentityVerifyState invoke(JsonObject jsonObject) {
                        TapJson tapJson2 = TapJson.INSTANCE;
                        try {
                            if (jsonObject == null) {
                                return null;
                            }
                            Json json2 = tapJson2.getJson();
                            KSerializer<Object> kSerializerSerializer2 = SerializersKt.serializer(json2.getSerializersModule(), Reflection.nullableTypeOf(IdentityVerifyState.class));
                            Intrinsics.checkNotNull(kSerializerSerializer2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                            return json2.decodeFromJsonElement(kSerializerSerializer2, jsonObject);
                        } catch (Exception e2) {
                            TapLogger.loge$default(TapJson.TAG, null, e2, 2, null);
                            return null;
                        }
                    }
                }, i2, objArr == true ? 1 : 0), new TapHttpRetry.SdkDefault(absTapHttpParamAddHeader$default.getBackoffHandler())), 0L, this, 1, null);
                if (objM76enqueueResultgIAlus$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    objM76enqueueResultgIAlus$default = ((Result) obj).getValue();
                } else if (i == 2) {
                    obj2 = this.L$0;
                    ResultKt.throwOnFailure(obj);
                    tapTapCallback = this.$callback;
                    thM187exceptionOrNullimpl = Result.m187exceptionOrNullimpl(obj2);
                    if (thM187exceptionOrNullimpl != null) {
                        identityVerifyApi$requestIdentityVerifyInfoManually$1$2$1 = new IdentityVerifyApi$requestIdentityVerifyInfoManually$1$2$1(tapTapCallback, thM187exceptionOrNullimpl, null);
                        this.L$0 = obj2;
                        this.label = 3;
                        if (SystemExtKt.dispatchMain(identityVerifyApi$requestIdentityVerifyInfoManually$1$2$1, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
            obj2 = objM76enqueueResultgIAlus$default;
            TapTapCallback<IdentityVerifyState> tapTapCallback2 = this.$callback;
            if (Result.m191isSuccessimpl(obj2)) {
                IdentityVerifyApi$requestIdentityVerifyInfoManually$1$1$1 identityVerifyApi$requestIdentityVerifyInfoManually$1$1$1 = new IdentityVerifyApi$requestIdentityVerifyInfoManually$1$1$1(tapTapCallback2, (IdentityVerifyState) obj2, null);
                this.L$0 = obj2;
                this.label = 2;
                if (SystemExtKt.dispatchMain(identityVerifyApi$requestIdentityVerifyInfoManually$1$1$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            tapTapCallback = this.$callback;
            thM187exceptionOrNullimpl = Result.m187exceptionOrNullimpl(obj2);
            if (thM187exceptionOrNullimpl != null) {
                identityVerifyApi$requestIdentityVerifyInfoManually$1$2$1 = new IdentityVerifyApi$requestIdentityVerifyInfoManually$1$2$1(tapTapCallback, thM187exceptionOrNullimpl, null);
                this.L$0 = obj2;
                this.label = 3;
                if (SystemExtKt.dispatchMain(identityVerifyApi$requestIdentityVerifyInfoManually$1$2$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    public final Job requestIdentityVerifyInfoManually(String name, String idCard, TapTapCallback<IdentityVerifyState> callback) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(idCard, "idCard");
        return SystemExtKt.runAsync(new C04541(name, idCard, callback, null));
    }

    /* JADX INFO: renamed from: com.taptap.sdk.compilance.api.IdentityVerifyApi$getTokenWithTapToken$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IdentityVerifyApi.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.compilance.api.IdentityVerifyApi$getTokenWithTapToken$1", f = "IdentityVerifyApi.kt", i = {}, l = {208, 87, 99}, m = "invokeSuspend", n = {}, s = {})
    static final class C04531 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ AccessToken $accessToken;
        final /* synthetic */ TapTapCallback<IdentityVerifyState> $callback;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04531(AccessToken accessToken, TapTapCallback<IdentityVerifyState> tapTapCallback, Continuation<? super C04531> continuation) {
            super(1, continuation);
            this.$accessToken = accessToken;
            this.$callback = tapTapCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C04531(this.$accessToken, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C04531) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:23:0x009b  */
        /* JADX WARN: Code duplicated, block: B:50:0x0196  */
        /* JADX WARN: Code duplicated, block: B:60:0x01dc A[RETURN] */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            LinkedHashMap linkedHashMap;
            String accessToken;
            Object objM76enqueueResultgIAlus$default;
            TapTapCallback<IdentityVerifyState> tapTapCallback;
            Throwable thM187exceptionOrNullimpl;
            IdentityVerifyApi$getTokenWithTapToken$1$2$1 identityVerifyApi$getTokenWithTapToken$1$2$1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            ITapHttpResponseHandler iTapHttpResponseHandler = null;
            Object[] objArr = 0;
            int i2 = 1;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (!TapLoginModel.INSTANCE.checkAccessTokenLocally(this.$accessToken)) {
                    this.$callback.onFail(new TapTapException("no valid access token found"));
                    return Unit.INSTANCE;
                }
                AccessToken accessToken2 = this.$accessToken;
                if (accessToken2 != null) {
                    String authorization = TapComplianceApiKt.getAuthorization("https://" + TapComplianceApiKt.getHost() + "/real-name/v1/anti-addiction-token-taptap?client_id=" + TapComplianceInternal.INSTANCE.getClientId(), TapHttp.METHOD_GET, accessToken2.getKid(), accessToken2.getMacKey());
                    linkedHashMap = authorization != null ? MapsKt.mutableMapOf(TuplesKt.to("Authorization", authorization)) : null;
                    if (linkedHashMap == null) {
                        linkedHashMap = new LinkedHashMap();
                    }
                } else {
                    linkedHashMap = new LinkedHashMap();
                }
                TapComplianceApi tapComplianceApi = TapComplianceApi.INSTANCE;
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                TapHttpNoBodyParam tapHttpNoBodyParam = TapComplianceApiKt.getNetApi().get(RequestPath.GET_TAP_TOKEN);
                for (Map.Entry entry : linkedHashMap2.entrySet()) {
                    AbsTapHttpParam.addQuery$default(tapHttpNoBodyParam, (String) entry.getKey(), (String) entry.getValue(), false, 4, null);
                }
                for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                    AbsTapHttpParam.addHeader$default(tapHttpNoBodyParam, (String) entry2.getKey(), (String) entry2.getValue(), false, 4, null);
                }
                if (TapComplianceInternal.INSTANCE.isTestEnvironment()) {
                    AbsTapHttpParam.addQuery$default(tapHttpNoBodyParam, f.aI, "1", false, 4, null);
                }
                TapHttpNoBodyParam tapHttpNoBodyParam2 = tapHttpNoBodyParam;
                UserInfo currentUser = UserModel.INSTANCE.getCurrentUser();
                if (currentUser == null || (accessToken = currentUser.getAccessToken()) == null) {
                    accessToken = "";
                }
                AbsTapHttpParam absTapHttpParamAddHeader$default = AbsTapHttpParam.addHeader$default(tapHttpNoBodyParam2, "X-TAP-Anti-Addiction-Token", accessToken, false, 4, null);
                this.label = 1;
                objM76enqueueResultgIAlus$default = ITapHttpCall.DefaultImpls.m76enqueueResultgIAlus$default(new TapHttpCall(absTapHttpParamAddHeader$default, new TapHttpParser.SdkDefaultParser(iTapHttpResponseHandler, new Function1<JsonObject, IdentityVerifyState>() { // from class: com.taptap.sdk.compilance.api.IdentityVerifyApi$getTokenWithTapToken$1$invokeSuspend$$inlined$get-BWLJW6A$default$1
                    /* JADX WARN: Type inference failed for: r1v2, types: [com.taptap.sdk.compilance.bean.IdentityVerifyState, java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function1
                    public final IdentityVerifyState invoke(JsonObject jsonObject) {
                        TapJson tapJson = TapJson.INSTANCE;
                        try {
                            if (jsonObject == null) {
                                return null;
                            }
                            Json json = tapJson.getJson();
                            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.nullableTypeOf(IdentityVerifyState.class));
                            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                            return json.decodeFromJsonElement(kSerializerSerializer, jsonObject);
                        } catch (Exception e) {
                            TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
                            return null;
                        }
                    }
                }, i2, objArr == true ? 1 : 0), new TapHttpRetry.SdkDefault(absTapHttpParamAddHeader$default.getBackoffHandler())), 0L, this, 1, null);
                if (objM76enqueueResultgIAlus$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    objM76enqueueResultgIAlus$default = ((Result) obj).getValue();
                } else if (i == 2) {
                    objM76enqueueResultgIAlus$default = this.L$0;
                    ResultKt.throwOnFailure(obj);
                    AccessToken accessToken3 = this.$accessToken;
                    tapTapCallback = this.$callback;
                    thM187exceptionOrNullimpl = Result.m187exceptionOrNullimpl(objM76enqueueResultgIAlus$default);
                    if (thM187exceptionOrNullimpl != null) {
                        if (!(thM187exceptionOrNullimpl instanceof TapHttpException.ServerError) && Intrinsics.areEqual(((TapHttpException.ServerError) thM187exceptionOrNullimpl).getError().getError(), TapErrorConstants.ERROR_INVALID_TIME) && IdentityVerifyApi.tapAuthRequestRetryCount > 0) {
                            IdentityVerifyApi identityVerifyApi = IdentityVerifyApi.INSTANCE;
                            IdentityVerifyApi.tapAuthRequestRetryCount--;
                            IdentityVerifyApi.INSTANCE.getTokenWithTapToken(accessToken3, tapTapCallback);
                            return Unit.INSTANCE;
                        }
                        IdentityVerifyApi identityVerifyApi2 = IdentityVerifyApi.INSTANCE;
                        IdentityVerifyApi.tapAuthRequestRetryCount = 1;
                        identityVerifyApi$getTokenWithTapToken$1$2$1 = new IdentityVerifyApi$getTokenWithTapToken$1$2$1(tapTapCallback, thM187exceptionOrNullimpl, null);
                        this.L$0 = objM76enqueueResultgIAlus$default;
                        this.label = 3;
                        if (SystemExtKt.dispatchMain(identityVerifyApi$getTokenWithTapToken$1$2$1, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
            TapTapCallback<IdentityVerifyState> tapTapCallback2 = this.$callback;
            if (Result.m191isSuccessimpl(objM76enqueueResultgIAlus$default)) {
                IdentityVerifyApi$getTokenWithTapToken$1$1$1 identityVerifyApi$getTokenWithTapToken$1$1$1 = new IdentityVerifyApi$getTokenWithTapToken$1$1$1(tapTapCallback2, (IdentityVerifyState) objM76enqueueResultgIAlus$default, null);
                this.L$0 = objM76enqueueResultgIAlus$default;
                this.label = 2;
                if (SystemExtKt.dispatchMain(identityVerifyApi$getTokenWithTapToken$1$1$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            AccessToken accessToken4 = this.$accessToken;
            tapTapCallback = this.$callback;
            thM187exceptionOrNullimpl = Result.m187exceptionOrNullimpl(objM76enqueueResultgIAlus$default);
            if (thM187exceptionOrNullimpl != null) {
                if (!(thM187exceptionOrNullimpl instanceof TapHttpException.ServerError)) {
                }
                IdentityVerifyApi identityVerifyApi3 = IdentityVerifyApi.INSTANCE;
                IdentityVerifyApi.tapAuthRequestRetryCount = 1;
                identityVerifyApi$getTokenWithTapToken$1$2$1 = new IdentityVerifyApi$getTokenWithTapToken$1$2$1(tapTapCallback, thM187exceptionOrNullimpl, null);
                this.L$0 = objM76enqueueResultgIAlus$default;
                this.label = 3;
                if (SystemExtKt.dispatchMain(identityVerifyApi$getTokenWithTapToken$1$2$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    public final void getTokenWithTapToken(AccessToken accessToken, TapTapCallback<IdentityVerifyState> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        SystemExtKt.runAsync(new C04531(accessToken, callback, null));
    }

    /* JADX INFO: renamed from: com.taptap.sdk.compilance.api.IdentityVerifyApi$upgradeToken$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IdentityVerifyApi.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.compilance.api.IdentityVerifyApi$upgradeToken$1", f = "IdentityVerifyApi.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM, 122, WorkQueueKt.MASK}, m = "invokeSuspend", n = {}, s = {})
    static final class C04561 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ TapTapCallback<IdentityVerifyState> $callback;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04561(TapTapCallback<IdentityVerifyState> tapTapCallback, Continuation<? super C04561> continuation) {
            super(1, continuation);
            this.$callback = tapTapCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C04561(this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C04561) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:50:0x0187  */
        /* JADX WARN: Code duplicated, block: B:52:0x0198 A[RETURN] */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String strEncodeToString;
            JSONObject jSONObject;
            String accessToken;
            Object objM76enqueueResultgIAlus$default;
            Object obj2;
            TapTapCallback<IdentityVerifyState> tapTapCallback;
            Throwable thM187exceptionOrNullimpl;
            IdentityVerifyApi$upgradeToken$1$2$1 identityVerifyApi$upgradeToken$1$2$1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            int i2 = 1;
            ITapHttpResponseHandler iTapHttpResponseHandler = null;
            Object[] objArr = 0;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Pair<String, Integer> cachedLegacyAccessToken = TapComplianceSettings.INSTANCE.getCachedLegacyAccessToken();
                if ((cachedLegacyAccessToken.getFirst().length() > 0) && cachedLegacyAccessToken.getSecond().intValue() >= 0) {
                    TapLogger.logi(TapComplianceLoggerKt.LOGGER_TAG, "has cached v1 token: token=" + cachedLegacyAccessToken);
                    TapComplianceApi tapComplianceApi = TapComplianceApi.INSTANCE;
                    TapJson tapJson = TapJson.INSTANCE;
                    UpgradeTokenRequestParams upgradeTokenRequestParams = new UpgradeTokenRequestParams(cachedLegacyAccessToken.getFirst());
                    try {
                        Json json = tapJson.getJson();
                        KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(UpgradeTokenRequestParams.class));
                        Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                        strEncodeToString = json.encodeToString(kSerializerSerializer, upgradeTokenRequestParams);
                    } catch (Exception e) {
                        TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
                        strEncodeToString = null;
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    TapHttpJsonParam tapHttpJsonParamPostJson = TapComplianceApiKt.getNetApi().postJson(RequestPath.UPGRADE_TOKEN);
                    for (Map.Entry entry : linkedHashMap.entrySet()) {
                        AbsTapHttpParam.addQuery$default(tapHttpJsonParamPostJson, (String) entry.getKey(), (String) entry.getValue(), false, 4, null);
                    }
                    if (strEncodeToString != null) {
                        jSONObject = new JSONObject(strEncodeToString);
                    } else {
                        jSONObject = new JSONObject();
                    }
                    if (TapComplianceInternal.INSTANCE.isTestEnvironment()) {
                        AbsTapHttpParam.addQuery$default(tapHttpJsonParamPostJson, f.aI, "1", false, 4, null);
                    }
                    tapHttpJsonParamPostJson.addBody(jSONObject);
                    TapComplianceLoggerKt.logInfo("TapComplianceApi post: body=" + jSONObject);
                    TapHttpJsonParam tapHttpJsonParam = tapHttpJsonParamPostJson;
                    UserInfo currentUser = UserModel.INSTANCE.getCurrentUser();
                    if (currentUser == null || (accessToken = currentUser.getAccessToken()) == null) {
                        accessToken = "";
                    }
                    AbsTapHttpParam absTapHttpParamAddHeader$default = AbsTapHttpParam.addHeader$default(tapHttpJsonParam, "X-TAP-Anti-Addiction-Token", accessToken, false, 4, null);
                    this.label = 1;
                    objM76enqueueResultgIAlus$default = ITapHttpCall.DefaultImpls.m76enqueueResultgIAlus$default(new TapHttpCall(absTapHttpParamAddHeader$default, new TapHttpParser.SdkDefaultParser(iTapHttpResponseHandler, new Function1<JsonObject, IdentityVerifyState>() { // from class: com.taptap.sdk.compilance.api.IdentityVerifyApi$upgradeToken$1$invokeSuspend$$inlined$post-BWLJW6A$default$1
                        /* JADX WARN: Type inference failed for: r1v2, types: [com.taptap.sdk.compilance.bean.IdentityVerifyState, java.lang.Object] */
                        @Override // kotlin.jvm.functions.Function1
                        public final IdentityVerifyState invoke(JsonObject jsonObject) {
                            TapJson tapJson2 = TapJson.INSTANCE;
                            try {
                                if (jsonObject == null) {
                                    return null;
                                }
                                Json json2 = tapJson2.getJson();
                                KSerializer<Object> kSerializerSerializer2 = SerializersKt.serializer(json2.getSerializersModule(), Reflection.nullableTypeOf(IdentityVerifyState.class));
                                Intrinsics.checkNotNull(kSerializerSerializer2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                                return json2.decodeFromJsonElement(kSerializerSerializer2, jsonObject);
                            } catch (Exception e2) {
                                TapLogger.loge$default(TapJson.TAG, null, e2, 2, null);
                                return null;
                            }
                        }
                    }, i2, objArr == true ? 1 : 0), new TapHttpRetry.SdkDefault(absTapHttpParamAddHeader$default.getBackoffHandler())), 0L, this, 1, null);
                    if (objM76enqueueResultgIAlus$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    this.$callback.onFail(new TapTapException("legacy token invalid"));
                }
                return Unit.INSTANCE;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                objM76enqueueResultgIAlus$default = ((Result) obj).getValue();
            } else {
                if (i == 2) {
                    obj2 = this.L$0;
                    ResultKt.throwOnFailure(obj);
                    tapTapCallback = this.$callback;
                    thM187exceptionOrNullimpl = Result.m187exceptionOrNullimpl(obj2);
                    if (thM187exceptionOrNullimpl != null) {
                        identityVerifyApi$upgradeToken$1$2$1 = new IdentityVerifyApi$upgradeToken$1$2$1(tapTapCallback, thM187exceptionOrNullimpl, null);
                        this.L$0 = obj2;
                        this.label = 3;
                        if (SystemExtKt.dispatchMain(identityVerifyApi$upgradeToken$1$2$1, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                }
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            TapComplianceSettings.INSTANCE.clearLegacyCachedToken(TapComplianceInternal.INSTANCE.getUserId());
            return Unit.INSTANCE;
            obj2 = objM76enqueueResultgIAlus$default;
            TapTapCallback<IdentityVerifyState> tapTapCallback2 = this.$callback;
            if (Result.m191isSuccessimpl(obj2)) {
                IdentityVerifyApi$upgradeToken$1$1$1 identityVerifyApi$upgradeToken$1$1$1 = new IdentityVerifyApi$upgradeToken$1$1$1(tapTapCallback2, (IdentityVerifyState) obj2, null);
                this.L$0 = obj2;
                this.label = 2;
                if (SystemExtKt.dispatchMain(identityVerifyApi$upgradeToken$1$1$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            tapTapCallback = this.$callback;
            thM187exceptionOrNullimpl = Result.m187exceptionOrNullimpl(obj2);
            if (thM187exceptionOrNullimpl != null) {
                identityVerifyApi$upgradeToken$1$2$1 = new IdentityVerifyApi$upgradeToken$1$2$1(tapTapCallback, thM187exceptionOrNullimpl, null);
                this.L$0 = obj2;
                this.label = 3;
                if (SystemExtKt.dispatchMain(identityVerifyApi$upgradeToken$1$2$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                TapComplianceSettings.INSTANCE.clearLegacyCachedToken(TapComplianceInternal.INSTANCE.getUserId());
            }
            return Unit.INSTANCE;
        }
    }

    public final Job upgradeToken(TapTapCallback<IdentityVerifyState> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        return SystemExtKt.runAsync(new C04561(callback, null));
    }

    /* JADX INFO: renamed from: com.taptap.sdk.compilance.api.IdentityVerifyApi$requestIdentityVerifyInfoRemotely$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IdentityVerifyApi.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.compilance.api.IdentityVerifyApi$requestIdentityVerifyInfoRemotely$1", f = "IdentityVerifyApi.kt", i = {}, l = {208, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE, 149}, m = "invokeSuspend", n = {}, s = {})
    static final class C04551 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ TapTapCallback<IdentityVerifyState> $callback;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04551(TapTapCallback<IdentityVerifyState> tapTapCallback, Continuation<? super C04551> continuation) {
            super(1, continuation);
            this.$callback = tapTapCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C04551(this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C04551) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:38:0x0131  */
        /* JADX WARN: Code duplicated, block: B:40:0x0142 A[RETURN] */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String accessToken;
            Object objM76enqueueResultgIAlus$default;
            TapTapCallback<IdentityVerifyState> tapTapCallback;
            Throwable thM187exceptionOrNullimpl;
            IdentityVerifyApi$requestIdentityVerifyInfoRemotely$1$2$1 identityVerifyApi$requestIdentityVerifyInfoRemotely$1$2$1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            int i2 = 1;
            ITapHttpResponseHandler iTapHttpResponseHandler = null;
            Object[] objArr = 0;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                TapComplianceApi tapComplianceApi = TapComplianceApi.INSTANCE;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                TapHttpNoBodyParam tapHttpNoBodyParam = TapComplianceApiKt.getNetApi().get(RequestPath.IDENTITY_VERIFY);
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    AbsTapHttpParam.addQuery$default(tapHttpNoBodyParam, (String) entry.getKey(), (String) entry.getValue(), false, 4, null);
                }
                for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                    AbsTapHttpParam.addHeader$default(tapHttpNoBodyParam, (String) entry2.getKey(), (String) entry2.getValue(), false, 4, null);
                }
                if (TapComplianceInternal.INSTANCE.isTestEnvironment()) {
                    AbsTapHttpParam.addQuery$default(tapHttpNoBodyParam, f.aI, "1", false, 4, null);
                }
                TapHttpNoBodyParam tapHttpNoBodyParam2 = tapHttpNoBodyParam;
                UserInfo currentUser = UserModel.INSTANCE.getCurrentUser();
                if (currentUser == null || (accessToken = currentUser.getAccessToken()) == null) {
                    accessToken = "";
                }
                AbsTapHttpParam absTapHttpParamAddHeader$default = AbsTapHttpParam.addHeader$default(tapHttpNoBodyParam2, "X-TAP-Anti-Addiction-Token", accessToken, false, 4, null);
                this.label = 1;
                objM76enqueueResultgIAlus$default = ITapHttpCall.DefaultImpls.m76enqueueResultgIAlus$default(new TapHttpCall(absTapHttpParamAddHeader$default, new TapHttpParser.SdkDefaultParser(iTapHttpResponseHandler, new Function1<JsonObject, IdentityVerifyState>() { // from class: com.taptap.sdk.compilance.api.IdentityVerifyApi$requestIdentityVerifyInfoRemotely$1$invokeSuspend$$inlined$get-BWLJW6A$default$1
                    /* JADX WARN: Type inference failed for: r1v2, types: [com.taptap.sdk.compilance.bean.IdentityVerifyState, java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function1
                    public final IdentityVerifyState invoke(JsonObject jsonObject) {
                        TapJson tapJson = TapJson.INSTANCE;
                        try {
                            if (jsonObject == null) {
                                return null;
                            }
                            Json json = tapJson.getJson();
                            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.nullableTypeOf(IdentityVerifyState.class));
                            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                            return json.decodeFromJsonElement(kSerializerSerializer, jsonObject);
                        } catch (Exception e) {
                            TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
                            return null;
                        }
                    }
                }, i2, objArr == true ? 1 : 0), new TapHttpRetry.SdkDefault(absTapHttpParamAddHeader$default.getBackoffHandler())), 0L, this, 1, null);
                if (objM76enqueueResultgIAlus$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    objM76enqueueResultgIAlus$default = ((Result) obj).getValue();
                } else if (i == 2) {
                    objM76enqueueResultgIAlus$default = this.L$0;
                    ResultKt.throwOnFailure(obj);
                    tapTapCallback = this.$callback;
                    thM187exceptionOrNullimpl = Result.m187exceptionOrNullimpl(objM76enqueueResultgIAlus$default);
                    if (thM187exceptionOrNullimpl != null) {
                        identityVerifyApi$requestIdentityVerifyInfoRemotely$1$2$1 = new IdentityVerifyApi$requestIdentityVerifyInfoRemotely$1$2$1(tapTapCallback, thM187exceptionOrNullimpl, null);
                        this.L$0 = objM76enqueueResultgIAlus$default;
                        this.label = 3;
                        if (SystemExtKt.dispatchMain(identityVerifyApi$requestIdentityVerifyInfoRemotely$1$2$1, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
            TapTapCallback<IdentityVerifyState> tapTapCallback2 = this.$callback;
            if (Result.m191isSuccessimpl(objM76enqueueResultgIAlus$default)) {
                IdentityVerifyApi$requestIdentityVerifyInfoRemotely$1$1$1 identityVerifyApi$requestIdentityVerifyInfoRemotely$1$1$1 = new IdentityVerifyApi$requestIdentityVerifyInfoRemotely$1$1$1(tapTapCallback2, (IdentityVerifyState) objM76enqueueResultgIAlus$default, null);
                this.L$0 = objM76enqueueResultgIAlus$default;
                this.label = 2;
                if (SystemExtKt.dispatchMain(identityVerifyApi$requestIdentityVerifyInfoRemotely$1$1$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            tapTapCallback = this.$callback;
            thM187exceptionOrNullimpl = Result.m187exceptionOrNullimpl(objM76enqueueResultgIAlus$default);
            if (thM187exceptionOrNullimpl != null) {
                identityVerifyApi$requestIdentityVerifyInfoRemotely$1$2$1 = new IdentityVerifyApi$requestIdentityVerifyInfoRemotely$1$2$1(tapTapCallback, thM187exceptionOrNullimpl, null);
                this.L$0 = objM76enqueueResultgIAlus$default;
                this.label = 3;
                if (SystemExtKt.dispatchMain(identityVerifyApi$requestIdentityVerifyInfoRemotely$1$2$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    public final Job requestIdentityVerifyInfoRemotely(TapTapCallback<IdentityVerifyState> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        return SystemExtKt.runAsync(new C04551(callback, null));
    }

    /* JADX INFO: renamed from: com.taptap.sdk.compilance.api.IdentityVerifyApi$checkPlay$1, reason: invalid class name */
    /* JADX INFO: compiled from: IdentityVerifyApi.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.compilance.api.IdentityVerifyApi$checkPlay$1", f = "IdentityVerifyApi.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ TapTapCallback<CheckPlayResult> $callback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TapTapCallback<CheckPlayResult> tapTapCallback, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$callback = tapTapCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String strEncodeToString;
            JSONObject jSONObject;
            String accessToken;
            Object objM76enqueueResultgIAlus$default;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            int i2 = 1;
            ITapHttpResponseHandler iTapHttpResponseHandler = null;
            Object[] objArr = 0;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                TapComplianceApi tapComplianceApi = TapComplianceApi.INSTANCE;
                TapJson tapJson = TapJson.INSTANCE;
                HeartbeatRequestParams heartbeatRequestParams = new HeartbeatRequestParams(PlayLogModel.INSTANCE.getSessionId());
                try {
                    Json json = tapJson.getJson();
                    KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(HeartbeatRequestParams.class));
                    Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    strEncodeToString = json.encodeToString(kSerializerSerializer, heartbeatRequestParams);
                } catch (Exception e) {
                    TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
                    strEncodeToString = null;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                TapHttpJsonParam tapHttpJsonParamPostJson = TapComplianceApiKt.getNetApi().postJson(RequestPath.HEARTBEAT);
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    AbsTapHttpParam.addQuery$default(tapHttpJsonParamPostJson, (String) entry.getKey(), (String) entry.getValue(), false, 4, null);
                }
                if (strEncodeToString != null) {
                    jSONObject = new JSONObject(strEncodeToString);
                } else {
                    jSONObject = new JSONObject();
                }
                if (TapComplianceInternal.INSTANCE.isTestEnvironment()) {
                    AbsTapHttpParam.addQuery$default(tapHttpJsonParamPostJson, f.aI, "1", false, 4, null);
                }
                tapHttpJsonParamPostJson.addBody(jSONObject);
                TapComplianceLoggerKt.logInfo("TapComplianceApi post: body=" + jSONObject);
                TapHttpJsonParam tapHttpJsonParam = tapHttpJsonParamPostJson;
                UserInfo currentUser = UserModel.INSTANCE.getCurrentUser();
                if (currentUser == null || (accessToken = currentUser.getAccessToken()) == null) {
                    accessToken = "";
                }
                AbsTapHttpParam absTapHttpParamAddHeader$default = AbsTapHttpParam.addHeader$default(tapHttpJsonParam, "X-TAP-Anti-Addiction-Token", accessToken, false, 4, null);
                this.label = 1;
                objM76enqueueResultgIAlus$default = ITapHttpCall.DefaultImpls.m76enqueueResultgIAlus$default(new TapHttpCall(absTapHttpParamAddHeader$default, new TapHttpParser.SdkDefaultParser(iTapHttpResponseHandler, new Function1<JsonObject, CheckPlayResult>() { // from class: com.taptap.sdk.compilance.api.IdentityVerifyApi$checkPlay$1$invokeSuspend$$inlined$post-BWLJW6A$default$1
                    /* JADX WARN: Type inference failed for: r1v2, types: [com.taptap.sdk.compilance.bean.CheckPlayResult, java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function1
                    public final CheckPlayResult invoke(JsonObject jsonObject) {
                        TapJson tapJson2 = TapJson.INSTANCE;
                        try {
                            if (jsonObject == null) {
                                return null;
                            }
                            Json json2 = tapJson2.getJson();
                            KSerializer<Object> kSerializerSerializer2 = SerializersKt.serializer(json2.getSerializersModule(), Reflection.nullableTypeOf(CheckPlayResult.class));
                            Intrinsics.checkNotNull(kSerializerSerializer2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                            return json2.decodeFromJsonElement(kSerializerSerializer2, jsonObject);
                        } catch (Exception e2) {
                            TapLogger.loge$default(TapJson.TAG, null, e2, 2, null);
                            return null;
                        }
                    }
                }, i2, objArr == true ? 1 : 0), new TapHttpRetry.SdkDefault(absTapHttpParamAddHeader$default.getBackoffHandler())), 0L, this, 1, null);
                if (objM76enqueueResultgIAlus$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objM76enqueueResultgIAlus$default = ((Result) obj).getValue();
            }
            TapTapCallback<CheckPlayResult> tapTapCallback = this.$callback;
            if (Result.m191isSuccessimpl(objM76enqueueResultgIAlus$default)) {
                tapTapCallback.onSuccess((CheckPlayResult) objM76enqueueResultgIAlus$default);
            }
            TapTapCallback<CheckPlayResult> tapTapCallback2 = this.$callback;
            Throwable thM187exceptionOrNullimpl = Result.m187exceptionOrNullimpl(objM76enqueueResultgIAlus$default);
            if (thM187exceptionOrNullimpl != null) {
                if (NetExtKt.isTokenExpired(thM187exceptionOrNullimpl)) {
                    TapComplianceInternal.notifyMessageInternal$default(TapComplianceInternal.INSTANCE, 9001, null, 2, null);
                } else {
                    tapTapCallback2.onFail(new TapTapException("checkPlay failed, cause=" + thM187exceptionOrNullimpl.getMessage()));
                }
            }
            return Unit.INSTANCE;
        }
    }

    public final Job checkPlay(TapTapCallback<CheckPlayResult> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        return SystemExtKt.runAsync(new AnonymousClass1(callback, null));
    }
}
