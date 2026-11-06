package com.taptap.sdk.login.internal.net;

import android.net.Uri;
import android.os.Build;
import com.anythink.core.common.h.au;
import com.byazt.ho.BaseConstants;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.TapTapKit;
import com.taptap.sdk.kit.internal.callback.TapTapCallback;
import com.taptap.sdk.kit.internal.exception.TapTapException;
import com.taptap.sdk.kit.internal.http.TapHttp;
import com.taptap.sdk.kit.internal.http.TapHttpExtKt;
import com.taptap.sdk.kit.internal.http.call.TapHttpCall;
import com.taptap.sdk.kit.internal.http.hanlder.TapHttpBackoff;
import com.taptap.sdk.kit.internal.http.hanlder.TapHttpParser;
import com.taptap.sdk.kit.internal.http.hanlder.TapHttpRetry;
import com.taptap.sdk.kit.internal.http.param.AbsTapHttpParam;
import com.taptap.sdk.kit.internal.http.param.TapHttpFormParam;
import com.taptap.sdk.kit.internal.http.param.TapHttpNoBodyParam;
import com.taptap.sdk.kit.internal.identifier.TapIdentifierUtil;
import com.taptap.sdk.kit.internal.json.TapJson;
import com.taptap.sdk.login.AccessToken;
import com.taptap.sdk.login.Scopes;
import com.taptap.sdk.login.TapTapAccount;
import com.taptap.sdk.login.internal.AccountManager;
import com.taptap.sdk.login.internal.bean.Profile;
import com.taptap.sdk.login.internal.util.CodeUtil;
import com.taptap.sdk.login.internal.util.Constants;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonObject;

/* JADX INFO: compiled from: NetworkClient.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015J\b\u0010\u0017\u001a\u00020\u0003H\u0002J\b\u0010\u0018\u001a\u00020\u0003H\u0002J$\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u001cJ.\u0010\u001d\u001a\u00020\u00112\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00110\u001f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00110\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u000e\u0010\n¨\u0006#"}, d2 = {"Lcom/taptap/sdk/login/internal/net/NetworkClient;", "", "clientId", "", "regionType", "", "(Ljava/lang/String;I)V", "openAPIHttp", "Lcom/taptap/sdk/kit/internal/http/TapHttp;", "getOpenAPIHttp", "()Lcom/taptap/sdk/kit/internal/http/TapHttp;", "openAPIHttp$delegate", "Lkotlin/Lazy;", "tokenHttp", "getTokenHttp", "tokenHttp$delegate", "fetchProfile", "", "accessToken", "Lcom/taptap/sdk/login/AccessToken;", "callback", "Lcom/taptap/sdk/login/internal/net/HttpCallback;", "Lcom/taptap/sdk/login/internal/bean/Profile;", "getOpenAPIDomain", "getTokenDomain", "loginWithCode", "code", "codeVerifier", "Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", "refreshToken", "onSuccess", "Lkotlin/Function1;", "onFail", "", "Companion", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class NetworkClient {
    private static final CoroutineScope loginNetworkScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));
    private final String clientId;

    /* JADX INFO: renamed from: openAPIHttp$delegate, reason: from kotlin metadata */
    private final Lazy openAPIHttp;
    private final int regionType;

    /* JADX INFO: renamed from: tokenHttp$delegate, reason: from kotlin metadata */
    private final Lazy tokenHttp;

    public NetworkClient(String clientId, int i) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        this.clientId = clientId;
        this.regionType = i;
        this.openAPIHttp = LazyKt.lazy(new Function0<TapHttp>() { // from class: com.taptap.sdk.login.internal.net.NetworkClient$openAPIHttp$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TapHttp invoke() {
                return TapHttp.INSTANCE.newBuilder(Constants.TAG, "4.5.0").domain(this.this$0.getOpenAPIDomain()).signHandler(new TapSignLogin()).build();
            }
        });
        this.tokenHttp = LazyKt.lazy(new Function0<TapHttp>() { // from class: com.taptap.sdk.login.internal.net.NetworkClient$tokenHttp$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TapHttp invoke() {
                return TapHttp.INSTANCE.newBuilder(Constants.TAG, "4.5.0").domain(this.this$0.getTokenDomain()).signHandler(new TapSignLogin()).build();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TapHttp getOpenAPIHttp() {
        return (TapHttp) this.openAPIHttp.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TapHttp getTokenHttp() {
        return (TapHttp) this.tokenHttp.getValue();
    }

    public final void refreshToken(Function1<? super AccessToken, Unit> onSuccess, Function1<? super Throwable, Unit> onFail) {
        String strEncodeToString;
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onFail, "onFail");
        TapTapAccount account = AccountManager.INSTANCE.getAccount();
        if (account == null) {
            return;
        }
        Pair[] pairArr = new Pair[5];
        pairArr[0] = TuplesKt.to(TapEventParamConstants.PARAM_CLIENT_ID, this.clientId);
        pairArr[1] = TuplesKt.to("grant_type", "refresh_token");
        pairArr[2] = TuplesKt.to(au.b.a, account.getAccessToken().getKid());
        pairArr[3] = TuplesKt.to("token_type_hint", "access_token");
        TapJson tapJson = TapJson.INSTANCE;
        HashMap mapHashMapOf = MapsKt.hashMapOf(TuplesKt.to(TapEventParamConstants.PARAM_DEVICE_ID, Build.MANUFACTURER + ' ' + Build.MODEL), TuplesKt.to("uuid", TapIdentifierUtil.INSTANCE.getInstallUUID()));
        try {
            Json json = tapJson.getJson();
            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(HashMap.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class))));
            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            strEncodeToString = json.encodeToString(kSerializerSerializer, mapHashMapOf);
        } catch (Exception e) {
            TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
            strEncodeToString = null;
        }
        if (strEncodeToString == null) {
            strEncodeToString = "";
        }
        pairArr[4] = TuplesKt.to("info", strEncodeToString);
        BuildersKt__Builders_commonKt.launch$default(loginNetworkScope, null, null, new C04851(MapsKt.hashMapOf(pairArr), onSuccess, onFail, null), 3, null);
    }

    /* JADX INFO: renamed from: com.taptap.sdk.login.internal.net.NetworkClient$refreshToken$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NetworkClient.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.login.internal.net.NetworkClient$refreshToken$1", f = "NetworkClient.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {})
    static final class C04851 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Throwable, Unit> $onFail;
        final /* synthetic */ Function1<AccessToken, Unit> $onSuccess;
        final /* synthetic */ HashMap<String, String> $params;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C04851(HashMap<String, String> map, Function1<? super AccessToken, Unit> function1, Function1<? super Throwable, Unit> function2, Continuation<? super C04851> continuation) {
            super(2, continuation);
            this.$params = map;
            this.$onSuccess = function1;
            this.$onFail = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NetworkClient.this.new C04851(this.$params, this.$onSuccess, this.$onFail, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04851) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objEnqueueResult;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            int i2 = 1;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AbsTapHttpParam<TapHttpFormParam> absTapHttpParamRetryBackoff = NetworkClient.this.getTokenHttp().postForm("/oauth2/v1/token", this.$params).retryBackoff(new TapHttpBackoff.None());
                TapHttpCall tapHttpCall = new TapHttpCall(absTapHttpParamRetryBackoff, new TapHttpParser.SdkDefaultParser(null, new Function1<JsonObject, AccessToken>() { // from class: com.taptap.sdk.login.internal.net.NetworkClient$refreshToken$1$invokeSuspend$$inlined$toCall$1
                    /* JADX WARN: Type inference failed for: r1v2, types: [com.taptap.sdk.login.AccessToken, java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function1
                    public final AccessToken invoke(JsonObject jsonObject) {
                        TapJson tapJson = TapJson.INSTANCE;
                        try {
                            if (jsonObject == null) {
                                return null;
                            }
                            Json json = tapJson.getJson();
                            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.nullableTypeOf(AccessToken.class));
                            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                            return json.decodeFromJsonElement(kSerializerSerializer, jsonObject);
                        } catch (Exception e) {
                            TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
                            return null;
                        }
                    }
                }, i2, 0 == true ? 1 : 0), new TapHttpRetry.SdkDefault(absTapHttpParamRetryBackoff.getBackoffHandler()));
                final Function1<AccessToken, Unit> function1 = this.$onSuccess;
                this.label = 1;
                objEnqueueResult = TapHttpExtKt.enqueueResult(tapHttpCall, new Function1<AccessToken, Unit>() { // from class: com.taptap.sdk.login.internal.net.NetworkClient.refreshToken.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(AccessToken accessToken) {
                        invoke2(accessToken);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(AccessToken it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        function1.invoke(it);
                    }
                }, this);
                if (objEnqueueResult == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objEnqueueResult = ((Result) obj).getValue();
            }
            Function1<Throwable, Unit> function2 = this.$onFail;
            Throwable thM187exceptionOrNullimpl = Result.m187exceptionOrNullimpl(objEnqueueResult);
            if (thM187exceptionOrNullimpl != null) {
                function2.invoke(thM187exceptionOrNullimpl);
            }
            return Unit.INSTANCE;
        }
    }

    public final void fetchProfile(AccessToken accessToken, HttpCallback<Profile> callback) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(loginNetworkScope, null, null, new AnonymousClass1(accessToken.getScopes().contains(Scopes.SCOPE_PROFILE) ? "/account/profile/v1" : "/account/basic-info/v1", accessToken, callback, null), 3, null);
    }

    /* JADX INFO: renamed from: com.taptap.sdk.login.internal.net.NetworkClient$fetchProfile$1, reason: invalid class name */
    /* JADX INFO: compiled from: NetworkClient.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.login.internal.net.NetworkClient$fetchProfile$1", f = "NetworkClient.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AccessToken $accessToken;
        final /* synthetic */ HttpCallback<Profile> $callback;
        final /* synthetic */ String $path;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, AccessToken accessToken, HttpCallback<Profile> httpCallback, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$path = str;
            this.$accessToken = accessToken;
            this.$callback = httpCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NetworkClient.this.new AnonymousClass1(this.$path, this.$accessToken, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objEnqueueResult;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            int i2 = 1;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String string = new Uri.Builder().scheme(BaseConstants.SCHEME_HTTPS).authority(NetworkClient.this.getOpenAPIDomain()).path(this.$path).appendQueryParameter(TapEventParamConstants.PARAM_CLIENT_ID, NetworkClient.this.clientId).build().toString();
                Intrinsics.checkNotNullExpressionValue(string, "Builder()\n              …      .build().toString()");
                TapHttpNoBodyParam tapHttpNoBodyParam = NetworkClient.this.getOpenAPIHttp().get(string);
                String authorization = CodeUtil.INSTANCE.getAuthorization(string, TapHttp.METHOD_GET, this.$accessToken.getKid(), this.$accessToken.getMacKey());
                if (authorization == null) {
                    authorization = "";
                }
                AbsTapHttpParam<TapHttpNoBodyParam> absTapHttpParamRetryBackoff = ((TapHttpNoBodyParam) AbsTapHttpParam.addHeader$default(tapHttpNoBodyParam, "Authorization", authorization, false, 4, null)).retryBackoff(new TapHttpBackoff.None());
                TapHttpCall tapHttpCall = new TapHttpCall(absTapHttpParamRetryBackoff, new TapHttpParser.SdkDefaultParser(null, new Function1<JsonObject, Profile>() { // from class: com.taptap.sdk.login.internal.net.NetworkClient$fetchProfile$1$invokeSuspend$$inlined$toCall$1
                    /* JADX WARN: Type inference failed for: r1v2, types: [com.taptap.sdk.login.internal.bean.Profile, java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function1
                    public final Profile invoke(JsonObject jsonObject) {
                        TapJson tapJson = TapJson.INSTANCE;
                        try {
                            if (jsonObject == null) {
                                return null;
                            }
                            Json json = tapJson.getJson();
                            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.nullableTypeOf(Profile.class));
                            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                            return json.decodeFromJsonElement(kSerializerSerializer, jsonObject);
                        } catch (Exception e) {
                            TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
                            return null;
                        }
                    }
                }, i2, 0 == true ? 1 : 0), new TapHttpRetry.SdkDefault(absTapHttpParamRetryBackoff.getBackoffHandler()));
                final HttpCallback<Profile> httpCallback = this.$callback;
                this.label = 1;
                objEnqueueResult = TapHttpExtKt.enqueueResult(tapHttpCall, new Function1<Profile, Unit>() { // from class: com.taptap.sdk.login.internal.net.NetworkClient.fetchProfile.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Profile profile) {
                        invoke2(profile);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Profile it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        httpCallback.onSuccess(it);
                    }
                }, this);
                if (objEnqueueResult == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objEnqueueResult = ((Result) obj).getValue();
            }
            HttpCallback<Profile> httpCallback2 = this.$callback;
            Throwable thM187exceptionOrNullimpl = Result.m187exceptionOrNullimpl(objEnqueueResult);
            if (thM187exceptionOrNullimpl != null) {
                TapLogger.logd("TapHttp", thM187exceptionOrNullimpl);
                httpCallback2.onFail(new TapTapException("Fail to fetch profile"));
            }
            return Unit.INSTANCE;
        }
    }

    public final void loginWithCode(String code, String codeVerifier, TapTapCallback<AccessToken> callback) {
        String strEncodeToString;
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(codeVerifier, "codeVerifier");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Pair[] pairArr = new Pair[9];
        pairArr[0] = TuplesKt.to(TapEventParamConstants.PARAM_CLIENT_ID, this.clientId);
        pairArr[1] = TuplesKt.to("grant_type", "authorization_code");
        pairArr[2] = TuplesKt.to("secret_type", "hmac-sha-1");
        pairArr[3] = TuplesKt.to("code", code);
        pairArr[4] = TuplesKt.to("redirect_uri", "tapoauth://authorize");
        pairArr[5] = TuplesKt.to("code_verifier", codeVerifier);
        pairArr[6] = TuplesKt.to("version", "4.5.0");
        pairArr[7] = TuplesKt.to("platform", "android");
        TapJson tapJson = TapJson.INSTANCE;
        HashMap mapHashMapOf = MapsKt.hashMapOf(TuplesKt.to(TapEventParamConstants.PARAM_DEVICE_ID, Build.MANUFACTURER + ' ' + Build.MODEL), TuplesKt.to("uuid", TapIdentifierUtil.INSTANCE.getInstallUUID()));
        try {
            Json json = tapJson.getJson();
            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(HashMap.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class))));
            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            strEncodeToString = json.encodeToString(kSerializerSerializer, mapHashMapOf);
        } catch (Exception e) {
            TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
            strEncodeToString = null;
        }
        if (strEncodeToString == null) {
            strEncodeToString = "";
        }
        pairArr[8] = TuplesKt.to("info", strEncodeToString);
        BuildersKt__Builders_commonKt.launch$default(loginNetworkScope, null, null, new C04841(MapsKt.hashMapOf(pairArr), callback, null), 3, null);
    }

    /* JADX INFO: renamed from: com.taptap.sdk.login.internal.net.NetworkClient$loginWithCode$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NetworkClient.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.login.internal.net.NetworkClient$loginWithCode$1", f = "NetworkClient.kt", i = {}, l = {119}, m = "invokeSuspend", n = {}, s = {})
    static final class C04841 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TapTapCallback<AccessToken> $callback;
        final /* synthetic */ HashMap<String, String> $params;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04841(HashMap<String, String> map, TapTapCallback<AccessToken> tapTapCallback, Continuation<? super C04841> continuation) {
            super(2, continuation);
            this.$params = map;
            this.$callback = tapTapCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NetworkClient.this.new C04841(this.$params, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04841) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objEnqueueResult;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            int i2 = 1;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AbsTapHttpParam<TapHttpFormParam> absTapHttpParamRetryBackoff = NetworkClient.this.getTokenHttp().postForm("/oauth2/v1/token", this.$params).retryBackoff(new TapHttpBackoff.None());
                TapHttpCall tapHttpCall = new TapHttpCall(absTapHttpParamRetryBackoff, new TapHttpParser.SdkDefaultParser(null, new Function1<JsonObject, AccessToken>() { // from class: com.taptap.sdk.login.internal.net.NetworkClient$loginWithCode$1$invokeSuspend$$inlined$toCall$1
                    /* JADX WARN: Type inference failed for: r1v2, types: [com.taptap.sdk.login.AccessToken, java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function1
                    public final AccessToken invoke(JsonObject jsonObject) {
                        TapJson tapJson = TapJson.INSTANCE;
                        try {
                            if (jsonObject == null) {
                                return null;
                            }
                            Json json = tapJson.getJson();
                            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.nullableTypeOf(AccessToken.class));
                            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                            return json.decodeFromJsonElement(kSerializerSerializer, jsonObject);
                        } catch (Exception e) {
                            TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
                            return null;
                        }
                    }
                }, i2, 0 == true ? 1 : 0), new TapHttpRetry.SdkDefault(absTapHttpParamRetryBackoff.getBackoffHandler()));
                final TapTapCallback<AccessToken> tapTapCallback = this.$callback;
                this.label = 1;
                objEnqueueResult = TapHttpExtKt.enqueueResult(tapHttpCall, new Function1<AccessToken, Unit>() { // from class: com.taptap.sdk.login.internal.net.NetworkClient.loginWithCode.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(AccessToken accessToken) {
                        invoke2(accessToken);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(AccessToken it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        tapTapCallback.onSuccess(it);
                    }
                }, this);
                if (objEnqueueResult == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objEnqueueResult = ((Result) obj).getValue();
            }
            TapTapCallback<AccessToken> tapTapCallback2 = this.$callback;
            if (Result.m187exceptionOrNullimpl(objEnqueueResult) != null) {
                tapTapCallback2.onFail(new TapTapException("Fail to fetch token"));
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getOpenAPIDomain() {
        if (TapTapKit.INSTANCE.isRND()) {
            return this.regionType == 0 ? "open.api.xdrnd.cn" : "open.api.xdrnd.com";
        }
        return this.regionType == 0 ? "open.tapapis.cn" : "open.tapapis.com";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getTokenDomain() {
        if (TapTapKit.INSTANCE.isRND()) {
            return this.regionType == 0 ? "oauth.api.xdrnd.cn" : "oauth.api.xdrnd.com";
        }
        return this.regionType == 0 ? "accounts.tapapis.cn" : "accounts.tapapis.com";
    }
}
