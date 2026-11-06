package com.taptap.sdk.compliance.api;

import android.net.Uri;
import com.byazt.fi.BaseConstants;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.common.network.throwable.ApiErr;
import com.taptap.sdk.common.network.throwable.TapNetworkException;
import com.taptap.sdk.compliance.bean.CheckPlayResult;
import com.taptap.sdk.compliance.bean.IdentityVerifyState;
import com.taptap.sdk.compliance.bean.UserInfo;
import com.taptap.sdk.compliance.bean.request.HeartbeatRequestParams;
import com.taptap.sdk.compliance.bean.request.IdentityVerifyRequestParams;
import com.taptap.sdk.compliance.bean.request.UpgradeTokenRequestParams;
import com.taptap.sdk.compliance.constants.BundleKey;
import com.taptap.sdk.compliance.constants.RequestPath;
import com.taptap.sdk.compliance.extensions.SystemExtKt;
import com.taptap.sdk.compliance.internal.ComplianceApiService;
import com.taptap.sdk.compliance.internal.TapComplianceApi;
import com.taptap.sdk.compliance.internal.TapComplianceApiKt;
import com.taptap.sdk.compliance.internal.TapComplianceInternal;
import com.taptap.sdk.compliance.internal.TapComplianceSettings;
import com.taptap.sdk.compliance.model.PlayLogModel;
import com.taptap.sdk.compliance.model.TapLoginModel;
import com.taptap.sdk.compliance.model.UserModel;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.TapLoggerKt;
import com.taptap.sdk.kit.internal.callback.TapTapCallback;
import com.taptap.sdk.kit.internal.exception.TapTapException;
import com.taptap.sdk.kit.internal.extensions.NetExtKt;
import com.taptap.sdk.kit.internal.http.TapHttp;
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
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: compiled from: IdentityVerifyApi.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u001e\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000e0\bJ(\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\bJ\u0014\u0010\u0013\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000e0\bJ\u0014\u0010\u0014\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000e0\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/taptap/sdk/compliance/api/IdentityVerifyApi;", "", "()V", "tapAuthRequestRetryCount", "", "checkPlay", "Lkotlinx/coroutines/Job;", "callback", "Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", "Lcom/taptap/sdk/compliance/bean/CheckPlayResult;", "getTokenWithTapToken", "", "accessToken", "Lcom/taptap/sdk/login/AccessToken;", "Lcom/taptap/sdk/compliance/bean/IdentityVerifyState;", "requestIdentityVerifyInfoManually", Common.System.NAME, "", "idCard", "requestIdentityVerifyInfoRemotely", "upgradeToken", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
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

    /* JADX INFO: renamed from: com.taptap.sdk.compliance.api.IdentityVerifyApi$requestIdentityVerifyInfoManually$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IdentityVerifyApi.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.compliance.api.IdentityVerifyApi$requestIdentityVerifyInfoManually$1", f = "IdentityVerifyApi.kt", i = {}, l = {227, 47, 52}, m = "invokeSuspend", n = {}, s = {})
    static final class C03041 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ TapTapCallback<IdentityVerifyState> $callback;
        final /* synthetic */ String $idCard;
        final /* synthetic */ String $name;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03041(String str, String str2, TapTapCallback<IdentityVerifyState> tapTapCallback, Continuation<? super C03041> continuation) {
            super(1, continuation);
            this.$name = str;
            this.$idCard = str2;
            this.$callback = tapTapCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C03041(this.$name, this.$idCard, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C03041) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:34:0x00ef A[Catch: all -> 0x01d6, TryCatch #3 {all -> 0x01d6, blocks: (B:19:0x009b, B:21:0x00a1, B:32:0x00ea, B:35:0x00fd, B:36:0x0114, B:38:0x011a, B:39:0x013e, B:41:0x015b, B:44:0x0163, B:28:0x00b6, B:31:0x00e1, B:34:0x00ef), top: B:86:0x009b, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:38:0x011a A[Catch: all -> 0x01d6, LOOP:0: B:36:0x0114->B:38:0x011a, LOOP_END, TryCatch #3 {all -> 0x01d6, blocks: (B:19:0x009b, B:21:0x00a1, B:32:0x00ea, B:35:0x00fd, B:36:0x0114, B:38:0x011a, B:39:0x013e, B:41:0x015b, B:44:0x0163, B:28:0x00b6, B:31:0x00e1, B:34:0x00ef), top: B:86:0x009b, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:43:0x0161  */
        /* JADX WARN: Code duplicated, block: B:46:0x0180 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:47:0x0181  */
        /* JADX WARN: Code duplicated, block: B:51:0x0190  */
        /* JADX WARN: Code duplicated, block: B:57:0x01bf A[Catch: all -> 0x01d3, TryCatch #2 {all -> 0x01d3, blocks: (B:48:0x0189, B:57:0x01bf, B:58:0x01c7, B:59:0x01d2, B:52:0x0192, B:55:0x01b4), top: B:85:0x0189, inners: #4 }] */
        /* JADX WARN: Code duplicated, block: B:58:0x01c7 A[Catch: all -> 0x01d3, TryCatch #2 {all -> 0x01d3, blocks: (B:48:0x0189, B:57:0x01bf, B:58:0x01c7, B:59:0x01d2, B:52:0x0192, B:55:0x01b4), top: B:85:0x0189, inners: #4 }] */
        /* JADX WARN: Code duplicated, block: B:67:0x01ee  */
        /* JADX WARN: Code duplicated, block: B:69:0x0205 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:70:0x0206  */
        /* JADX WARN: Code duplicated, block: B:74:0x0211  */
        /* JADX WARN: Code duplicated, block: B:76:0x0225 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:77:0x0226  */
        /* JADX WARN: Code duplicated, block: B:88:0x0192 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C03041 c03041;
            Object $result;
            String body$iv;
            Map mapBuild;
            JsonObjectBuilder builder$iv$iv;
            UserInfo currentUser;
            String accessToken;
            TapJson tapJson;
            Object objPost;
            TapJson this_$iv$iv;
            Object $result2;
            Object objM534constructorimpl;
            C03041 c03042;
            Object $result3;
            TapTapCallback<IdentityVerifyState> tapTapCallback;
            IdentityVerifyApi$requestIdentityVerifyInfoManually$1$1$1 identityVerifyApi$requestIdentityVerifyInfoManually$1$1$1;
            JsonElement data$iv$iv;
            Object objDecodeFromJsonElement;
            TapTapCallback<IdentityVerifyState> tapTapCallback2;
            Throwable it;
            IdentityVerifyApi$requestIdentityVerifyInfoManually$1$2$1 identityVerifyApi$requestIdentityVerifyInfoManually$1$2$1;
            Object $result4;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            Object objDecodeFromString = null;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    c03041 = this;
                    $result = obj;
                    TapComplianceApi tapComplianceApi = TapComplianceApi.INSTANCE;
                    TapJson this_$iv = TapJson.INSTANCE;
                    IdentityVerifyRequestParams identityVerifyRequestParams = new IdentityVerifyRequestParams(c03041.$name, c03041.$idCard);
                    try {
                        StringFormat $this$encodeToString$iv$iv = this_$iv.getJson();
                        SerializersModule $this$serializer$iv$iv$iv = $this$encodeToString$iv$iv.getSerializersModule();
                        KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv, Reflection.typeOf(IdentityVerifyRequestParams.class));
                        Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                        body$iv = $this$encodeToString$iv$iv.encodeToString(kSerializerSerializer, identityVerifyRequestParams);
                    } catch (Exception e$iv) {
                        TapLogger.loge$default(TapJson.TAG, null, e$iv, 2, null);
                        body$iv = null;
                    }
                    Map queryMap$iv = new LinkedHashMap();
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        if (body$iv != null) {
                            String it$iv = body$iv;
                            TapJson this_$iv$iv2 = TapJson.INSTANCE;
                            if (!(it$iv.length() == 0)) {
                                try {
                                    StringFormat $this$decodeFromString$iv$iv$iv = this_$iv$iv2.getJson();
                                    SerializersModule $this$serializer$iv$iv$iv$iv = $this$decodeFromString$iv$iv$iv.getSerializersModule();
                                    KSerializer<Object> kSerializerSerializer2 = SerializersKt.serializer($this$serializer$iv$iv$iv$iv, Reflection.typeOf(JsonObject.class));
                                    Intrinsics.checkNotNull(kSerializerSerializer2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                                    objDecodeFromString = $this$decodeFromString$iv$iv$iv.decodeFromString(kSerializerSerializer2, it$iv);
                                } catch (Exception e$iv$iv) {
                                    TapLogger.loge$default(TapJson.TAG, null, e$iv$iv, 2, null);
                                    objDecodeFromString = null;
                                }
                            }
                            mapBuild = (JsonObject) objDecodeFromString;
                            if (mapBuild == null) {
                                mapBuild = new JsonObjectBuilder().build();
                            }
                            Map postBody$iv = mapBuild;
                            builder$iv$iv = new JsonObjectBuilder();
                            Map $this$forEach$iv$iv = postBody$iv;
                            for (Map.Entry<String, JsonElement> entry : $this$forEach$iv$iv.entrySet()) {
                                String key$iv = entry.getKey();
                                JsonElement value$iv = entry.getValue();
                                builder$iv$iv.put(key$iv, value$iv);
                            }
                            JsonElementBuildersKt.put(builder$iv$iv, BundleKey.KEY_USER_IDENTIFIER, TapComplianceInternal.INSTANCE.getUserId());
                            JsonObject requestBody$iv = builder$iv$iv.build();
                            currentUser = UserModel.INSTANCE.getCurrentUser();
                            if (currentUser != null || (accessToken = currentUser.getAccessToken()) == null) {
                                accessToken = "";
                            }
                            Map<String, String> mapMapOf = MapsKt.mapOf(TuplesKt.to("X-TAP-Anti-Addiction-Token", accessToken));
                            tapJson = TapJson.INSTANCE;
                            ComplianceApiService api = TapComplianceApiKt.getApi();
                            c03041.L$0 = tapJson;
                            c03041.label = 1;
                            objPost = api.post(RequestPath.IDENTITY_VERIFY_MANUAL, queryMap$iv, mapMapOf, requestBody$iv, c03041);
                            if (objPost == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            this_$iv$iv = tapJson;
                            $result = objPost;
                            $result2 = $result;
                            try {
                                data$iv$iv = (JsonElement) $result;
                                if (data$iv$iv == null) {
                                    objDecodeFromJsonElement = null;
                                } else {
                                    try {
                                        Json $this$decodeFromJsonElement$iv$iv$iv = this_$iv$iv.getJson();
                                        SerializersModule $this$serializer$iv$iv$iv$iv2 = $this$decodeFromJsonElement$iv$iv$iv.getSerializersModule();
                                        KSerializer<Object> kSerializerSerializer3 = SerializersKt.serializer($this$serializer$iv$iv$iv$iv2, Reflection.typeOf(IdentityVerifyState.class));
                                        Intrinsics.checkNotNull(kSerializerSerializer3, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                                        objDecodeFromJsonElement = $this$decodeFromJsonElement$iv$iv$iv.decodeFromJsonElement(kSerializerSerializer3, data$iv$iv);
                                    } catch (Exception e$iv$iv2) {
                                        TapLogger.loge$default(TapJson.TAG, null, e$iv$iv2, 2, null);
                                        objDecodeFromJsonElement = null;
                                    }
                                }
                                if (objDecodeFromJsonElement == null) {
                                    throw new IllegalStateException("empty compliance response".toString());
                                }
                                objM534constructorimpl = Result.m534constructorimpl(objDecodeFromJsonElement);
                                $result3 = $result2;
                                c03042 = c03041;
                                tapTapCallback = c03042.$callback;
                                if (Result.m541isSuccessimpl(objM534constructorimpl)) {
                                    identityVerifyApi$requestIdentityVerifyInfoManually$1$1$1 = new IdentityVerifyApi$requestIdentityVerifyInfoManually$1$1$1(tapTapCallback, (IdentityVerifyState) objM534constructorimpl, null);
                                    c03042.L$0 = objM534constructorimpl;
                                    c03042.label = 2;
                                    if (SystemExtKt.dispatchMain(identityVerifyApi$requestIdentityVerifyInfoManually$1$1$1, c03042) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                                tapTapCallback2 = c03042.$callback;
                                it = Result.m537exceptionOrNullimpl(objM534constructorimpl);
                                if (it != null) {
                                    identityVerifyApi$requestIdentityVerifyInfoManually$1$2$1 = new IdentityVerifyApi$requestIdentityVerifyInfoManually$1$2$1(it, tapTapCallback2, null);
                                    c03042.L$0 = objM534constructorimpl;
                                    c03042.label = 3;
                                    if (SystemExtKt.dispatchMain(identityVerifyApi$requestIdentityVerifyInfoManually$1$2$1, c03042) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    $result4 = $result3;
                                }
                            } catch (Throwable th) {
                                th = th;
                                $result = $result2;
                                Result.Companion companion2 = Result.INSTANCE;
                                objM534constructorimpl = Result.m534constructorimpl(ResultKt.createFailure(th));
                                c03042 = c03041;
                                $result3 = $result;
                            }
                        } else {
                            mapBuild = new JsonObjectBuilder().build();
                            Map postBody$iv2 = mapBuild;
                            builder$iv$iv = new JsonObjectBuilder();
                            Map $this$forEach$iv$iv2 = postBody$iv2;
                            while (r15.hasNext()) {
                                String key$iv2 = entry.getKey();
                                JsonElement value$iv2 = entry.getValue();
                                builder$iv$iv.put(key$iv2, value$iv2);
                            }
                            JsonElementBuildersKt.put(builder$iv$iv, BundleKey.KEY_USER_IDENTIFIER, TapComplianceInternal.INSTANCE.getUserId());
                            JsonObject requestBody$iv2 = builder$iv$iv.build();
                            currentUser = UserModel.INSTANCE.getCurrentUser();
                            if (currentUser != null) {
                                accessToken = "";
                            } else {
                                accessToken = "";
                            }
                            Map<String, String> mapMapOf2 = MapsKt.mapOf(TuplesKt.to("X-TAP-Anti-Addiction-Token", accessToken));
                            tapJson = TapJson.INSTANCE;
                            ComplianceApiService api2 = TapComplianceApiKt.getApi();
                            c03041.L$0 = tapJson;
                            c03041.label = 1;
                            objPost = api2.post(RequestPath.IDENTITY_VERIFY_MANUAL, queryMap$iv, mapMapOf2, requestBody$iv2, c03041);
                            if (objPost == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            this_$iv$iv = tapJson;
                            $result = objPost;
                            $result2 = $result;
                            data$iv$iv = (JsonElement) $result;
                            if (data$iv$iv == null) {
                                Json $this$decodeFromJsonElement$iv$iv$iv2 = this_$iv$iv.getJson();
                                SerializersModule $this$serializer$iv$iv$iv$iv3 = $this$decodeFromJsonElement$iv$iv$iv2.getSerializersModule();
                                KSerializer<Object> kSerializerSerializer4 = SerializersKt.serializer($this$serializer$iv$iv$iv$iv3, Reflection.typeOf(IdentityVerifyState.class));
                                Intrinsics.checkNotNull(kSerializerSerializer4, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                                objDecodeFromJsonElement = $this$decodeFromJsonElement$iv$iv$iv2.decodeFromJsonElement(kSerializerSerializer4, data$iv$iv);
                            } else {
                                objDecodeFromJsonElement = null;
                            }
                            if (objDecodeFromJsonElement == null) {
                                throw new IllegalStateException("empty compliance response".toString());
                            }
                            objM534constructorimpl = Result.m534constructorimpl(objDecodeFromJsonElement);
                            $result3 = $result2;
                            c03042 = c03041;
                            tapTapCallback = c03042.$callback;
                            if (Result.m541isSuccessimpl(objM534constructorimpl)) {
                                identityVerifyApi$requestIdentityVerifyInfoManually$1$1$1 = new IdentityVerifyApi$requestIdentityVerifyInfoManually$1$1$1(tapTapCallback, (IdentityVerifyState) objM534constructorimpl, null);
                                c03042.L$0 = objM534constructorimpl;
                                c03042.label = 2;
                                if (SystemExtKt.dispatchMain(identityVerifyApi$requestIdentityVerifyInfoManually$1$1$1, c03042) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            tapTapCallback2 = c03042.$callback;
                            it = Result.m537exceptionOrNullimpl(objM534constructorimpl);
                            if (it != null) {
                                identityVerifyApi$requestIdentityVerifyInfoManually$1$2$1 = new IdentityVerifyApi$requestIdentityVerifyInfoManually$1$2$1(it, tapTapCallback2, null);
                                c03042.L$0 = objM534constructorimpl;
                                c03042.label = 3;
                                if (SystemExtKt.dispatchMain(identityVerifyApi$requestIdentityVerifyInfoManually$1$2$1, c03042) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                $result4 = $result3;
                            }
                        }
                        break;
                    } catch (Throwable th2) {
                        th = th2;
                        Result.Companion companion3 = Result.INSTANCE;
                        objM534constructorimpl = Result.m534constructorimpl(ResultKt.createFailure(th));
                        c03042 = c03041;
                        $result3 = $result;
                        tapTapCallback = c03042.$callback;
                        if (Result.m541isSuccessimpl(objM534constructorimpl)) {
                            identityVerifyApi$requestIdentityVerifyInfoManually$1$1$1 = new IdentityVerifyApi$requestIdentityVerifyInfoManually$1$1$1(tapTapCallback, (IdentityVerifyState) objM534constructorimpl, null);
                            c03042.L$0 = objM534constructorimpl;
                            c03042.label = 2;
                            if (SystemExtKt.dispatchMain(identityVerifyApi$requestIdentityVerifyInfoManually$1$1$1, c03042) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        tapTapCallback2 = c03042.$callback;
                        it = Result.m537exceptionOrNullimpl(objM534constructorimpl);
                        if (it != null) {
                            identityVerifyApi$requestIdentityVerifyInfoManually$1$2$1 = new IdentityVerifyApi$requestIdentityVerifyInfoManually$1$2$1(it, tapTapCallback2, null);
                            c03042.L$0 = objM534constructorimpl;
                            c03042.label = 3;
                            if (SystemExtKt.dispatchMain(identityVerifyApi$requestIdentityVerifyInfoManually$1$2$1, c03042) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $result4 = $result3;
                        }
                        return Unit.INSTANCE;
                    }
                    return Unit.INSTANCE;
                case 1:
                    c03041 = this;
                    $result = obj;
                    this_$iv$iv = (TapJson) c03041.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        $result2 = $result;
                        data$iv$iv = (JsonElement) $result;
                        if (data$iv$iv == null) {
                            Json $this$decodeFromJsonElement$iv$iv$iv3 = this_$iv$iv.getJson();
                            SerializersModule $this$serializer$iv$iv$iv$iv4 = $this$decodeFromJsonElement$iv$iv$iv3.getSerializersModule();
                            KSerializer<Object> kSerializerSerializer5 = SerializersKt.serializer($this$serializer$iv$iv$iv$iv4, Reflection.typeOf(IdentityVerifyState.class));
                            Intrinsics.checkNotNull(kSerializerSerializer5, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                            objDecodeFromJsonElement = $this$decodeFromJsonElement$iv$iv$iv3.decodeFromJsonElement(kSerializerSerializer5, data$iv$iv);
                            break;
                        } else {
                            objDecodeFromJsonElement = null;
                        }
                        if (objDecodeFromJsonElement == null) {
                            throw new IllegalStateException("empty compliance response".toString());
                        }
                        objM534constructorimpl = Result.m534constructorimpl(objDecodeFromJsonElement);
                        $result3 = $result2;
                        c03042 = c03041;
                        tapTapCallback = c03042.$callback;
                        if (Result.m541isSuccessimpl(objM534constructorimpl)) {
                            identityVerifyApi$requestIdentityVerifyInfoManually$1$1$1 = new IdentityVerifyApi$requestIdentityVerifyInfoManually$1$1$1(tapTapCallback, (IdentityVerifyState) objM534constructorimpl, null);
                            c03042.L$0 = objM534constructorimpl;
                            c03042.label = 2;
                            if (SystemExtKt.dispatchMain(identityVerifyApi$requestIdentityVerifyInfoManually$1$1$1, c03042) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        tapTapCallback2 = c03042.$callback;
                        it = Result.m537exceptionOrNullimpl(objM534constructorimpl);
                        if (it != null) {
                            identityVerifyApi$requestIdentityVerifyInfoManually$1$2$1 = new IdentityVerifyApi$requestIdentityVerifyInfoManually$1$2$1(it, tapTapCallback2, null);
                            c03042.L$0 = objM534constructorimpl;
                            c03042.label = 3;
                            if (SystemExtKt.dispatchMain(identityVerifyApi$requestIdentityVerifyInfoManually$1$2$1, c03042) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $result4 = $result3;
                        }
                        return Unit.INSTANCE;
                    } catch (Throwable th3) {
                        th = th3;
                        Result.Companion companion4 = Result.INSTANCE;
                        objM534constructorimpl = Result.m534constructorimpl(ResultKt.createFailure(th));
                        c03042 = c03041;
                        $result3 = $result;
                        tapTapCallback = c03042.$callback;
                        if (Result.m541isSuccessimpl(objM534constructorimpl)) {
                            identityVerifyApi$requestIdentityVerifyInfoManually$1$1$1 = new IdentityVerifyApi$requestIdentityVerifyInfoManually$1$1$1(tapTapCallback, (IdentityVerifyState) objM534constructorimpl, null);
                            c03042.L$0 = objM534constructorimpl;
                            c03042.label = 2;
                            if (SystemExtKt.dispatchMain(identityVerifyApi$requestIdentityVerifyInfoManually$1$1$1, c03042) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        tapTapCallback2 = c03042.$callback;
                        it = Result.m537exceptionOrNullimpl(objM534constructorimpl);
                        if (it != null) {
                            identityVerifyApi$requestIdentityVerifyInfoManually$1$2$1 = new IdentityVerifyApi$requestIdentityVerifyInfoManually$1$2$1(it, tapTapCallback2, null);
                            c03042.L$0 = objM534constructorimpl;
                            c03042.label = 3;
                            if (SystemExtKt.dispatchMain(identityVerifyApi$requestIdentityVerifyInfoManually$1$2$1, c03042) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $result4 = $result3;
                        }
                        return Unit.INSTANCE;
                    }
                case 2:
                    c03042 = this;
                    $result3 = obj;
                    objM534constructorimpl = c03042.L$0;
                    ResultKt.throwOnFailure($result3);
                    tapTapCallback2 = c03042.$callback;
                    it = Result.m537exceptionOrNullimpl(objM534constructorimpl);
                    if (it != null) {
                        identityVerifyApi$requestIdentityVerifyInfoManually$1$2$1 = new IdentityVerifyApi$requestIdentityVerifyInfoManually$1$2$1(it, tapTapCallback2, null);
                        c03042.L$0 = objM534constructorimpl;
                        c03042.label = 3;
                        if (SystemExtKt.dispatchMain(identityVerifyApi$requestIdentityVerifyInfoManually$1$2$1, c03042) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result4 = $result3;
                    }
                    return Unit.INSTANCE;
                case 3:
                    $result4 = obj;
                    ResultKt.throwOnFailure($result4);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Job requestIdentityVerifyInfoManually(String name, String idCard, TapTapCallback<IdentityVerifyState> callback) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(idCard, "idCard");
        return SystemExtKt.runAsync(new C03041(name, idCard, callback, null));
    }

    /* JADX INFO: renamed from: com.taptap.sdk.compliance.api.IdentityVerifyApi$getTokenWithTapToken$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IdentityVerifyApi.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.compliance.api.IdentityVerifyApi$getTokenWithTapToken$1", f = "IdentityVerifyApi.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, 96, 108}, m = "invokeSuspend", n = {}, s = {})
    static final class C03031 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ AccessToken $accessToken;
        final /* synthetic */ TapTapCallback<IdentityVerifyState> $callback;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03031(AccessToken accessToken, TapTapCallback<IdentityVerifyState> tapTapCallback, Continuation<? super C03031> continuation) {
            super(1, continuation);
            this.$accessToken = accessToken;
            this.$callback = tapTapCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C03031(this.$accessToken, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C03031) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:30:0x00e1  */
        /* JADX WARN: Code duplicated, block: B:44:0x0146  */
        /* JADX WARN: Code duplicated, block: B:50:0x0179 A[Catch: all -> 0x018c, TryCatch #2 {all -> 0x018c, blocks: (B:41:0x0140, B:50:0x0179, B:51:0x0180, B:52:0x018b, B:45:0x0148, B:48:0x016d), top: B:86:0x0140, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:51:0x0180 A[Catch: all -> 0x018c, TryCatch #2 {all -> 0x018c, blocks: (B:41:0x0140, B:50:0x0179, B:51:0x0180, B:52:0x018b, B:45:0x0148, B:48:0x016d), top: B:86:0x0140, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:60:0x01a6  */
        /* JADX WARN: Code duplicated, block: B:62:0x01bc A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:63:0x01bd  */
        /* JADX WARN: Code duplicated, block: B:67:0x01ca  */
        /* JADX WARN: Code duplicated, block: B:69:0x01cf  */
        /* JADX WARN: Code duplicated, block: B:77:0x0213 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:78:0x0214  */
        /* JADX WARN: Code duplicated, block: B:84:0x0148 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C03031 c03031;
            Object $result;
            LinkedHashMap header;
            String accessToken;
            TapJson this_$iv$iv;
            Object $result2;
            Object $result3;
            C03031 c03032;
            TapTapCallback<IdentityVerifyState> tapTapCallback;
            IdentityVerifyApi$getTokenWithTapToken$1$1$1 identityVerifyApi$getTokenWithTapToken$1$1$1;
            JsonElement data$iv$iv;
            Object objDecodeFromJsonElement;
            TapTapCallback<IdentityVerifyState> tapTapCallback2;
            Throwable it;
            IdentityVerifyApi$getTokenWithTapToken$1$2$1 identityVerifyApi$getTokenWithTapToken$1$2$1;
            Object $result4;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    c03031 = this;
                    $result = obj;
                    if (!TapLoginModel.INSTANCE.checkAccessTokenLocally(c03031.$accessToken)) {
                        c03031.$callback.onFail(new TapTapException("no valid access token found"));
                        return Unit.INSTANCE;
                    }
                    AccessToken it2 = c03031.$accessToken;
                    if (it2 != null) {
                        Uri.Builder $this$invokeSuspend_u24lambda_u242_u24lambda_u240 = new Uri.Builder().scheme(BaseConstants.SCHEME_HTTPS).authority(TapComplianceApiKt.getHost()).path(RequestPath.GET_TAP_TOKEN);
                        if (TapComplianceInternal.INSTANCE.getUserId().length() > 0) {
                            $this$invokeSuspend_u24lambda_u242_u24lambda_u240.appendQueryParameter(BundleKey.KEY_USER_IDENTIFIER, TapComplianceInternal.INSTANCE.getUserId());
                        }
                        $this$invokeSuspend_u24lambda_u242_u24lambda_u240.appendQueryParameter("client_id", TapComplianceInternal.INSTANCE.getClientId());
                        Uri url = $this$invokeSuspend_u24lambda_u242_u24lambda_u240.build();
                        String string = url.toString();
                        Intrinsics.checkNotNullExpressionValue(string, "url.toString()");
                        String $this$invokeSuspend_u24lambda_u242_u24lambda_u241 = TapComplianceApiKt.getAuthorization(string, TapHttp.METHOD_GET, it2.getKid(), it2.getMacKey());
                        header = $this$invokeSuspend_u24lambda_u242_u24lambda_u241 != null ? MapsKt.mutableMapOf(TuplesKt.to("Authorization", $this$invokeSuspend_u24lambda_u242_u24lambda_u241)) : null;
                        if (header == null) {
                            header = new LinkedHashMap();
                        }
                    } else {
                        header = new LinkedHashMap();
                    }
                    TapComplianceApi tapComplianceApi = TapComplianceApi.INSTANCE;
                    Map queryMap$iv = new LinkedHashMap();
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        Map<String, String> mutableMap = MapsKt.toMutableMap(queryMap$iv);
                        mutableMap.put(BundleKey.KEY_USER_IDENTIFIER, TapComplianceInternal.INSTANCE.getUserId());
                        Map<String, String> mutableMap2 = MapsKt.toMutableMap(header);
                        UserInfo currentUser = UserModel.INSTANCE.getCurrentUser();
                        if (currentUser == null || (accessToken = currentUser.getAccessToken()) == null) {
                            accessToken = "";
                        }
                        mutableMap2.put("X-TAP-Anti-Addiction-Token", accessToken);
                        TapJson tapJson = TapJson.INSTANCE;
                        ComplianceApiService api = TapComplianceApiKt.getApi();
                        c03031.L$0 = tapJson;
                        c03031.label = 1;
                        Object obj2 = api.get(RequestPath.GET_TAP_TOKEN, mutableMap, mutableMap2, c03031);
                        if (obj2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        this_$iv$iv = tapJson;
                        $result2 = $result;
                        $result = obj2;
                        try {
                            data$iv$iv = (JsonElement) $result;
                            if (data$iv$iv == null) {
                                try {
                                    Json $this$decodeFromJsonElement$iv$iv$iv = this_$iv$iv.getJson();
                                    SerializersModule $this$serializer$iv$iv$iv$iv = $this$decodeFromJsonElement$iv$iv$iv.getSerializersModule();
                                    KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv$iv, Reflection.typeOf(IdentityVerifyState.class));
                                    Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                                    objDecodeFromJsonElement = $this$decodeFromJsonElement$iv$iv$iv.decodeFromJsonElement(kSerializerSerializer, data$iv$iv);
                                } catch (Exception e$iv$iv) {
                                    TapLogger.loge$default(TapJson.TAG, null, e$iv$iv, 2, null);
                                    objDecodeFromJsonElement = null;
                                }
                                break;
                            } else {
                                objDecodeFromJsonElement = null;
                            }
                            if (objDecodeFromJsonElement != null) {
                                throw new IllegalStateException("empty compliance response".toString());
                            }
                            $result3 = Result.m534constructorimpl(objDecodeFromJsonElement);
                            c03032 = c03031;
                            tapTapCallback = c03032.$callback;
                            if (Result.m541isSuccessimpl($result3)) {
                                identityVerifyApi$getTokenWithTapToken$1$1$1 = new IdentityVerifyApi$getTokenWithTapToken$1$1$1(tapTapCallback, (IdentityVerifyState) $result3, null);
                                c03032.L$0 = $result3;
                                c03032.label = 2;
                                if (SystemExtKt.dispatchMain(identityVerifyApi$getTokenWithTapToken$1$1$1, c03032) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            AccessToken accessToken2 = c03032.$accessToken;
                            tapTapCallback2 = c03032.$callback;
                            it = Result.m537exceptionOrNullimpl($result3);
                            if (it != null) {
                                if (!(it instanceof TapNetworkException) && Intrinsics.areEqual(((TapNetworkException) it).getErr().getApiErr(), ApiErr.INVALID_TIME.INSTANCE) && IdentityVerifyApi.tapAuthRequestRetryCount > 0) {
                                    IdentityVerifyApi identityVerifyApi = IdentityVerifyApi.INSTANCE;
                                    IdentityVerifyApi.tapAuthRequestRetryCount--;
                                    IdentityVerifyApi.INSTANCE.getTokenWithTapToken(accessToken2, tapTapCallback2);
                                    return Unit.INSTANCE;
                                }
                                IdentityVerifyApi identityVerifyApi2 = IdentityVerifyApi.INSTANCE;
                                IdentityVerifyApi.tapAuthRequestRetryCount = 1;
                                identityVerifyApi$getTokenWithTapToken$1$2$1 = new IdentityVerifyApi$getTokenWithTapToken$1$2$1(tapTapCallback2, it, null);
                                c03032.L$0 = $result3;
                                c03032.label = 3;
                                if (SystemExtKt.dispatchMain(identityVerifyApi$getTokenWithTapToken$1$2$1, c03032) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                $result4 = $result2;
                            }
                            return Unit.INSTANCE;
                        } catch (Throwable th) {
                            th = th;
                            $result = $result2;
                            Result.Companion companion2 = Result.INSTANCE;
                            $result2 = $result;
                            $result3 = Result.m534constructorimpl(ResultKt.createFailure(th));
                            c03032 = c03031;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        Result.Companion companion3 = Result.INSTANCE;
                        $result2 = $result;
                        $result3 = Result.m534constructorimpl(ResultKt.createFailure(th));
                        c03032 = c03031;
                        tapTapCallback = c03032.$callback;
                        if (Result.m541isSuccessimpl($result3)) {
                            identityVerifyApi$getTokenWithTapToken$1$1$1 = new IdentityVerifyApi$getTokenWithTapToken$1$1$1(tapTapCallback, (IdentityVerifyState) $result3, null);
                            c03032.L$0 = $result3;
                            c03032.label = 2;
                            if (SystemExtKt.dispatchMain(identityVerifyApi$getTokenWithTapToken$1$1$1, c03032) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        AccessToken accessToken3 = c03032.$accessToken;
                        tapTapCallback2 = c03032.$callback;
                        it = Result.m537exceptionOrNullimpl($result3);
                        if (it != null) {
                            if (!(it instanceof TapNetworkException)) {
                            }
                            IdentityVerifyApi identityVerifyApi3 = IdentityVerifyApi.INSTANCE;
                            IdentityVerifyApi.tapAuthRequestRetryCount = 1;
                            identityVerifyApi$getTokenWithTapToken$1$2$1 = new IdentityVerifyApi$getTokenWithTapToken$1$2$1(tapTapCallback2, it, null);
                            c03032.L$0 = $result3;
                            c03032.label = 3;
                            if (SystemExtKt.dispatchMain(identityVerifyApi$getTokenWithTapToken$1$2$1, c03032) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $result4 = $result2;
                        }
                        return Unit.INSTANCE;
                    }
                    break;
                case 1:
                    c03031 = this;
                    $result = obj;
                    TapJson this_$iv$iv2 = (TapJson) c03031.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        $result2 = $result;
                        this_$iv$iv = this_$iv$iv2;
                        data$iv$iv = (JsonElement) $result;
                        if (data$iv$iv == null) {
                            Json $this$decodeFromJsonElement$iv$iv$iv2 = this_$iv$iv.getJson();
                            SerializersModule $this$serializer$iv$iv$iv$iv2 = $this$decodeFromJsonElement$iv$iv$iv2.getSerializersModule();
                            KSerializer<Object> kSerializerSerializer2 = SerializersKt.serializer($this$serializer$iv$iv$iv$iv2, Reflection.typeOf(IdentityVerifyState.class));
                            Intrinsics.checkNotNull(kSerializerSerializer2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                            objDecodeFromJsonElement = $this$decodeFromJsonElement$iv$iv$iv2.decodeFromJsonElement(kSerializerSerializer2, data$iv$iv);
                            break;
                        } else {
                            objDecodeFromJsonElement = null;
                        }
                        if (objDecodeFromJsonElement != null) {
                            throw new IllegalStateException("empty compliance response".toString());
                        }
                        $result3 = Result.m534constructorimpl(objDecodeFromJsonElement);
                        c03032 = c03031;
                        tapTapCallback = c03032.$callback;
                        if (Result.m541isSuccessimpl($result3)) {
                            identityVerifyApi$getTokenWithTapToken$1$1$1 = new IdentityVerifyApi$getTokenWithTapToken$1$1$1(tapTapCallback, (IdentityVerifyState) $result3, null);
                            c03032.L$0 = $result3;
                            c03032.label = 2;
                            if (SystemExtKt.dispatchMain(identityVerifyApi$getTokenWithTapToken$1$1$1, c03032) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        AccessToken accessToken4 = c03032.$accessToken;
                        tapTapCallback2 = c03032.$callback;
                        it = Result.m537exceptionOrNullimpl($result3);
                        if (it != null) {
                            if (!(it instanceof TapNetworkException)) {
                            }
                            IdentityVerifyApi identityVerifyApi4 = IdentityVerifyApi.INSTANCE;
                            IdentityVerifyApi.tapAuthRequestRetryCount = 1;
                            identityVerifyApi$getTokenWithTapToken$1$2$1 = new IdentityVerifyApi$getTokenWithTapToken$1$2$1(tapTapCallback2, it, null);
                            c03032.L$0 = $result3;
                            c03032.label = 3;
                            if (SystemExtKt.dispatchMain(identityVerifyApi$getTokenWithTapToken$1$2$1, c03032) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $result4 = $result2;
                            break;
                        }
                        return Unit.INSTANCE;
                    } catch (Throwable th3) {
                        th = th3;
                        Result.Companion companion4 = Result.INSTANCE;
                        $result2 = $result;
                        $result3 = Result.m534constructorimpl(ResultKt.createFailure(th));
                        c03032 = c03031;
                        tapTapCallback = c03032.$callback;
                        if (Result.m541isSuccessimpl($result3)) {
                            identityVerifyApi$getTokenWithTapToken$1$1$1 = new IdentityVerifyApi$getTokenWithTapToken$1$1$1(tapTapCallback, (IdentityVerifyState) $result3, null);
                            c03032.L$0 = $result3;
                            c03032.label = 2;
                            if (SystemExtKt.dispatchMain(identityVerifyApi$getTokenWithTapToken$1$1$1, c03032) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        AccessToken accessToken5 = c03032.$accessToken;
                        tapTapCallback2 = c03032.$callback;
                        it = Result.m537exceptionOrNullimpl($result3);
                        if (it != null) {
                            if (!(it instanceof TapNetworkException)) {
                            }
                            IdentityVerifyApi identityVerifyApi5 = IdentityVerifyApi.INSTANCE;
                            IdentityVerifyApi.tapAuthRequestRetryCount = 1;
                            identityVerifyApi$getTokenWithTapToken$1$2$1 = new IdentityVerifyApi$getTokenWithTapToken$1$2$1(tapTapCallback2, it, null);
                            c03032.L$0 = $result3;
                            c03032.label = 3;
                            if (SystemExtKt.dispatchMain(identityVerifyApi$getTokenWithTapToken$1$2$1, c03032) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $result4 = $result2;
                            break;
                        }
                        return Unit.INSTANCE;
                    }
                case 2:
                    c03032 = this;
                    $result2 = obj;
                    $result3 = c03032.L$0;
                    ResultKt.throwOnFailure($result2);
                    AccessToken accessToken6 = c03032.$accessToken;
                    tapTapCallback2 = c03032.$callback;
                    it = Result.m537exceptionOrNullimpl($result3);
                    if (it != null) {
                        if (!(it instanceof TapNetworkException)) {
                        }
                        IdentityVerifyApi identityVerifyApi6 = IdentityVerifyApi.INSTANCE;
                        IdentityVerifyApi.tapAuthRequestRetryCount = 1;
                        identityVerifyApi$getTokenWithTapToken$1$2$1 = new IdentityVerifyApi$getTokenWithTapToken$1$2$1(tapTapCallback2, it, null);
                        c03032.L$0 = $result3;
                        c03032.label = 3;
                        if (SystemExtKt.dispatchMain(identityVerifyApi$getTokenWithTapToken$1$2$1, c03032) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result4 = $result2;
                        break;
                    }
                    return Unit.INSTANCE;
                case 3:
                    $result4 = obj;
                    ResultKt.throwOnFailure($result4);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final void getTokenWithTapToken(AccessToken accessToken, TapTapCallback<IdentityVerifyState> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        SystemExtKt.runAsync(new C03031(accessToken, callback, null));
    }

    /* JADX INFO: renamed from: com.taptap.sdk.compliance.api.IdentityVerifyApi$upgradeToken$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IdentityVerifyApi.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.compliance.api.IdentityVerifyApi$upgradeToken$1", f = "IdentityVerifyApi.kt", i = {}, l = {227, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_START_OFFSET}, m = "invokeSuspend", n = {}, s = {})
    static final class C03061 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ TapTapCallback<IdentityVerifyState> $callback;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03061(TapTapCallback<IdentityVerifyState> tapTapCallback, Continuation<? super C03061> continuation) {
            super(1, continuation);
            this.$callback = tapTapCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C03061(this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C03061) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:41:0x0137 A[Catch: all -> 0x021f, TryCatch #5 {all -> 0x021f, blocks: (B:26:0x00e6, B:28:0x00ec, B:39:0x0132, B:42:0x0146, B:43:0x015d, B:45:0x0163, B:46:0x0186, B:48:0x01a3, B:51:0x01ab, B:35:0x0104, B:38:0x012a, B:41:0x0137), top: B:99:0x00e6, inners: #2 }] */
        /* JADX WARN: Code duplicated, block: B:45:0x0163 A[Catch: all -> 0x021f, LOOP:0: B:43:0x015d->B:45:0x0163, LOOP_END, TryCatch #5 {all -> 0x021f, blocks: (B:26:0x00e6, B:28:0x00ec, B:39:0x0132, B:42:0x0146, B:43:0x015d, B:45:0x0163, B:46:0x0186, B:48:0x01a3, B:51:0x01ab, B:35:0x0104, B:38:0x012a, B:41:0x0137), top: B:99:0x00e6, inners: #2 }] */
        /* JADX WARN: Code duplicated, block: B:50:0x01a9  */
        /* JADX WARN: Code duplicated, block: B:53:0x01c9 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:54:0x01ca  */
        /* JADX WARN: Code duplicated, block: B:58:0x01d9  */
        /* JADX WARN: Code duplicated, block: B:64:0x0208 A[Catch: all -> 0x021c, TryCatch #4 {all -> 0x021c, blocks: (B:55:0x01d2, B:64:0x0208, B:65:0x0210, B:66:0x021b, B:59:0x01db, B:62:0x01fd), top: B:98:0x01d2, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:65:0x0210 A[Catch: all -> 0x021c, TryCatch #4 {all -> 0x021c, blocks: (B:55:0x01d2, B:64:0x0208, B:65:0x0210, B:66:0x021b, B:59:0x01db, B:62:0x01fd), top: B:98:0x01d2, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:74:0x0237  */
        /* JADX WARN: Code duplicated, block: B:76:0x024e A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:77:0x024f  */
        /* JADX WARN: Code duplicated, block: B:81:0x025a  */
        /* JADX WARN: Code duplicated, block: B:83:0x026e A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:84:0x026f  */
        /* JADX WARN: Code duplicated, block: B:86:0x0280  */
        /* JADX WARN: Code duplicated, block: B:92:0x01db A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C03061 c03061;
            Object $result;
            String body$iv;
            String path$iv;
            Map mapBuild;
            JsonObjectBuilder builder$iv$iv;
            UserInfo currentUser;
            String accessToken;
            TapJson tapJson;
            Object objPost;
            TapJson this_$iv$iv;
            Object $result2;
            Object objDecodeFromString;
            Object $result3;
            C03061 c03062;
            Object $result4;
            TapTapCallback<IdentityVerifyState> tapTapCallback;
            IdentityVerifyApi$upgradeToken$1$1$1 identityVerifyApi$upgradeToken$1$1$1;
            JsonElement data$iv$iv;
            Object objDecodeFromJsonElement;
            TapTapCallback<IdentityVerifyState> tapTapCallback2;
            Throwable it;
            IdentityVerifyApi$upgradeToken$1$2$1 identityVerifyApi$upgradeToken$1$2$1;
            Object $result5;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    c03061 = this;
                    $result = obj;
                    Pair<String, Integer> cachedLegacyAccessToken = TapComplianceSettings.INSTANCE.getCachedLegacyAccessToken();
                    if ((cachedLegacyAccessToken.getFirst().length() > 0) && cachedLegacyAccessToken.getSecond().intValue() >= 0) {
                        TapLoggerKt.logInfo("has cached v1 token: token=" + cachedLegacyAccessToken);
                        TapComplianceApi tapComplianceApi = TapComplianceApi.INSTANCE;
                        TapJson this_$iv = TapJson.INSTANCE;
                        UpgradeTokenRequestParams upgradeTokenRequestParams = new UpgradeTokenRequestParams(cachedLegacyAccessToken.getFirst());
                        try {
                            StringFormat $this$encodeToString$iv$iv = this_$iv.getJson();
                            SerializersModule $this$serializer$iv$iv$iv = $this$encodeToString$iv$iv.getSerializersModule();
                            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv, Reflection.typeOf(UpgradeTokenRequestParams.class));
                            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                            body$iv = $this$encodeToString$iv$iv.encodeToString(kSerializerSerializer, upgradeTokenRequestParams);
                            path$iv = RequestPath.UPGRADE_TOKEN;
                        } catch (Exception e$iv) {
                            TapLogger.loge$default(TapJson.TAG, null, e$iv, 2, null);
                            body$iv = null;
                            path$iv = RequestPath.UPGRADE_TOKEN;
                        }
                        Map queryMap$iv = new LinkedHashMap();
                        try {
                            Result.Companion companion = Result.INSTANCE;
                            if (body$iv != null) {
                                String it$iv = body$iv;
                                TapJson this_$iv$iv2 = TapJson.INSTANCE;
                                if (it$iv.length() == 0) {
                                    objDecodeFromString = null;
                                } else {
                                    try {
                                        StringFormat $this$decodeFromString$iv$iv$iv = this_$iv$iv2.getJson();
                                        SerializersModule $this$serializer$iv$iv$iv$iv = $this$decodeFromString$iv$iv$iv.getSerializersModule();
                                        KSerializer<Object> kSerializerSerializer2 = SerializersKt.serializer($this$serializer$iv$iv$iv$iv, Reflection.typeOf(JsonObject.class));
                                        Intrinsics.checkNotNull(kSerializerSerializer2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                                        objDecodeFromString = $this$decodeFromString$iv$iv$iv.decodeFromString(kSerializerSerializer2, it$iv);
                                    } catch (Exception e$iv$iv) {
                                        TapLogger.loge$default(TapJson.TAG, null, e$iv$iv, 2, null);
                                        objDecodeFromString = null;
                                    }
                                }
                                mapBuild = (JsonObject) objDecodeFromString;
                                if (mapBuild == null) {
                                    mapBuild = new JsonObjectBuilder().build();
                                }
                                Map postBody$iv = mapBuild;
                                builder$iv$iv = new JsonObjectBuilder();
                                Map $this$forEach$iv$iv = postBody$iv;
                                for (Map.Entry<String, JsonElement> entry : $this$forEach$iv$iv.entrySet()) {
                                    String key$iv = entry.getKey();
                                    JsonElement value$iv = entry.getValue();
                                    builder$iv$iv.put(key$iv, value$iv);
                                }
                                JsonElementBuildersKt.put(builder$iv$iv, BundleKey.KEY_USER_IDENTIFIER, TapComplianceInternal.INSTANCE.getUserId());
                                JsonObject requestBody$iv = builder$iv$iv.build();
                                currentUser = UserModel.INSTANCE.getCurrentUser();
                                if (currentUser != null || (accessToken = currentUser.getAccessToken()) == null) {
                                    accessToken = "";
                                }
                                Map<String, String> mapMapOf = MapsKt.mapOf(TuplesKt.to("X-TAP-Anti-Addiction-Token", accessToken));
                                tapJson = TapJson.INSTANCE;
                                ComplianceApiService api = TapComplianceApiKt.getApi();
                                c03061.L$0 = tapJson;
                                c03061.label = 1;
                                objPost = api.post(path$iv, queryMap$iv, mapMapOf, requestBody$iv, c03061);
                                if (objPost == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                this_$iv$iv = tapJson;
                                $result = objPost;
                                $result2 = $result;
                                try {
                                    data$iv$iv = (JsonElement) $result;
                                    if (data$iv$iv == null) {
                                        objDecodeFromJsonElement = null;
                                    } else {
                                        try {
                                            Json $this$decodeFromJsonElement$iv$iv$iv = this_$iv$iv.getJson();
                                            SerializersModule $this$serializer$iv$iv$iv$iv2 = $this$decodeFromJsonElement$iv$iv$iv.getSerializersModule();
                                            KSerializer<Object> kSerializerSerializer3 = SerializersKt.serializer($this$serializer$iv$iv$iv$iv2, Reflection.typeOf(IdentityVerifyState.class));
                                            Intrinsics.checkNotNull(kSerializerSerializer3, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                                            objDecodeFromJsonElement = $this$decodeFromJsonElement$iv$iv$iv.decodeFromJsonElement(kSerializerSerializer3, data$iv$iv);
                                        } catch (Exception e$iv$iv2) {
                                            TapLogger.loge$default(TapJson.TAG, null, e$iv$iv2, 2, null);
                                            objDecodeFromJsonElement = null;
                                        }
                                    }
                                    if (objDecodeFromJsonElement == null) {
                                        throw new IllegalStateException("empty compliance response".toString());
                                    }
                                    Object objM534constructorimpl = Result.m534constructorimpl(objDecodeFromJsonElement);
                                    $result4 = $result2;
                                    $result3 = objM534constructorimpl;
                                    c03062 = c03061;
                                    tapTapCallback = c03062.$callback;
                                    if (Result.m541isSuccessimpl($result3)) {
                                        identityVerifyApi$upgradeToken$1$1$1 = new IdentityVerifyApi$upgradeToken$1$1$1(tapTapCallback, (IdentityVerifyState) $result3, null);
                                        c03062.L$0 = $result3;
                                        c03062.label = 2;
                                        if (SystemExtKt.dispatchMain(identityVerifyApi$upgradeToken$1$1$1, c03062) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    }
                                    tapTapCallback2 = c03062.$callback;
                                    it = Result.m537exceptionOrNullimpl($result3);
                                    if (it != null) {
                                        identityVerifyApi$upgradeToken$1$2$1 = new IdentityVerifyApi$upgradeToken$1$2$1(tapTapCallback2, it, null);
                                        c03062.L$0 = $result3;
                                        c03062.label = 3;
                                        if (SystemExtKt.dispatchMain(identityVerifyApi$upgradeToken$1$2$1, c03062) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        $result5 = $result4;
                                        TapComplianceSettings.INSTANCE.clearLegacyCachedToken(TapComplianceInternal.INSTANCE.getUserId());
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    $result = $result2;
                                    Result.Companion companion2 = Result.INSTANCE;
                                    $result3 = Result.m534constructorimpl(ResultKt.createFailure(th));
                                    c03062 = c03061;
                                    $result4 = $result;
                                }
                                break;
                            } else {
                                mapBuild = new JsonObjectBuilder().build();
                                Map postBody$iv2 = mapBuild;
                                builder$iv$iv = new JsonObjectBuilder();
                                Map $this$forEach$iv$iv2 = postBody$iv2;
                                while (r15.hasNext()) {
                                    String key$iv2 = entry.getKey();
                                    JsonElement value$iv2 = entry.getValue();
                                    builder$iv$iv.put(key$iv2, value$iv2);
                                }
                                JsonElementBuildersKt.put(builder$iv$iv, BundleKey.KEY_USER_IDENTIFIER, TapComplianceInternal.INSTANCE.getUserId());
                                JsonObject requestBody$iv2 = builder$iv$iv.build();
                                currentUser = UserModel.INSTANCE.getCurrentUser();
                                if (currentUser != null) {
                                    accessToken = "";
                                } else {
                                    accessToken = "";
                                }
                                Map<String, String> mapMapOf2 = MapsKt.mapOf(TuplesKt.to("X-TAP-Anti-Addiction-Token", accessToken));
                                tapJson = TapJson.INSTANCE;
                                ComplianceApiService api2 = TapComplianceApiKt.getApi();
                                c03061.L$0 = tapJson;
                                c03061.label = 1;
                                objPost = api2.post(path$iv, queryMap$iv, mapMapOf2, requestBody$iv2, c03061);
                                if (objPost == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                this_$iv$iv = tapJson;
                                $result = objPost;
                                $result2 = $result;
                                data$iv$iv = (JsonElement) $result;
                                if (data$iv$iv == null) {
                                    Json $this$decodeFromJsonElement$iv$iv$iv2 = this_$iv$iv.getJson();
                                    SerializersModule $this$serializer$iv$iv$iv$iv3 = $this$decodeFromJsonElement$iv$iv$iv2.getSerializersModule();
                                    KSerializer<Object> kSerializerSerializer4 = SerializersKt.serializer($this$serializer$iv$iv$iv$iv3, Reflection.typeOf(IdentityVerifyState.class));
                                    Intrinsics.checkNotNull(kSerializerSerializer4, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                                    objDecodeFromJsonElement = $this$decodeFromJsonElement$iv$iv$iv2.decodeFromJsonElement(kSerializerSerializer4, data$iv$iv);
                                } else {
                                    objDecodeFromJsonElement = null;
                                }
                                if (objDecodeFromJsonElement == null) {
                                    throw new IllegalStateException("empty compliance response".toString());
                                }
                                Object objM534constructorimpl2 = Result.m534constructorimpl(objDecodeFromJsonElement);
                                $result4 = $result2;
                                $result3 = objM534constructorimpl2;
                                c03062 = c03061;
                                tapTapCallback = c03062.$callback;
                                if (Result.m541isSuccessimpl($result3)) {
                                    identityVerifyApi$upgradeToken$1$1$1 = new IdentityVerifyApi$upgradeToken$1$1$1(tapTapCallback, (IdentityVerifyState) $result3, null);
                                    c03062.L$0 = $result3;
                                    c03062.label = 2;
                                    if (SystemExtKt.dispatchMain(identityVerifyApi$upgradeToken$1$1$1, c03062) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                                tapTapCallback2 = c03062.$callback;
                                it = Result.m537exceptionOrNullimpl($result3);
                                if (it != null) {
                                    identityVerifyApi$upgradeToken$1$2$1 = new IdentityVerifyApi$upgradeToken$1$2$1(tapTapCallback2, it, null);
                                    c03062.L$0 = $result3;
                                    c03062.label = 3;
                                    if (SystemExtKt.dispatchMain(identityVerifyApi$upgradeToken$1$2$1, c03062) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    $result5 = $result4;
                                    TapComplianceSettings.INSTANCE.clearLegacyCachedToken(TapComplianceInternal.INSTANCE.getUserId());
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            Result.Companion companion3 = Result.INSTANCE;
                            $result3 = Result.m534constructorimpl(ResultKt.createFailure(th));
                            c03062 = c03061;
                            $result4 = $result;
                            tapTapCallback = c03062.$callback;
                            if (Result.m541isSuccessimpl($result3)) {
                                identityVerifyApi$upgradeToken$1$1$1 = new IdentityVerifyApi$upgradeToken$1$1$1(tapTapCallback, (IdentityVerifyState) $result3, null);
                                c03062.L$0 = $result3;
                                c03062.label = 2;
                                if (SystemExtKt.dispatchMain(identityVerifyApi$upgradeToken$1$1$1, c03062) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            tapTapCallback2 = c03062.$callback;
                            it = Result.m537exceptionOrNullimpl($result3);
                            if (it != null) {
                                identityVerifyApi$upgradeToken$1$2$1 = new IdentityVerifyApi$upgradeToken$1$2$1(tapTapCallback2, it, null);
                                c03062.L$0 = $result3;
                                c03062.label = 3;
                                if (SystemExtKt.dispatchMain(identityVerifyApi$upgradeToken$1$2$1, c03062) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                $result5 = $result4;
                                TapComplianceSettings.INSTANCE.clearLegacyCachedToken(TapComplianceInternal.INSTANCE.getUserId());
                            }
                            return Unit.INSTANCE;
                        }
                        break;
                    } else {
                        c03061.$callback.onFail(new TapTapException("legacy token invalid"));
                    }
                    return Unit.INSTANCE;
                case 1:
                    c03061 = this;
                    $result = obj;
                    this_$iv$iv = (TapJson) c03061.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        $result2 = $result;
                        data$iv$iv = (JsonElement) $result;
                        if (data$iv$iv == null) {
                            Json $this$decodeFromJsonElement$iv$iv$iv3 = this_$iv$iv.getJson();
                            SerializersModule $this$serializer$iv$iv$iv$iv4 = $this$decodeFromJsonElement$iv$iv$iv3.getSerializersModule();
                            KSerializer<Object> kSerializerSerializer5 = SerializersKt.serializer($this$serializer$iv$iv$iv$iv4, Reflection.typeOf(IdentityVerifyState.class));
                            Intrinsics.checkNotNull(kSerializerSerializer5, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                            objDecodeFromJsonElement = $this$decodeFromJsonElement$iv$iv$iv3.decodeFromJsonElement(kSerializerSerializer5, data$iv$iv);
                            break;
                        } else {
                            objDecodeFromJsonElement = null;
                        }
                        if (objDecodeFromJsonElement == null) {
                            throw new IllegalStateException("empty compliance response".toString());
                        }
                        Object objM534constructorimpl3 = Result.m534constructorimpl(objDecodeFromJsonElement);
                        $result4 = $result2;
                        $result3 = objM534constructorimpl3;
                        c03062 = c03061;
                        tapTapCallback = c03062.$callback;
                        if (Result.m541isSuccessimpl($result3)) {
                            identityVerifyApi$upgradeToken$1$1$1 = new IdentityVerifyApi$upgradeToken$1$1$1(tapTapCallback, (IdentityVerifyState) $result3, null);
                            c03062.L$0 = $result3;
                            c03062.label = 2;
                            if (SystemExtKt.dispatchMain(identityVerifyApi$upgradeToken$1$1$1, c03062) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        tapTapCallback2 = c03062.$callback;
                        it = Result.m537exceptionOrNullimpl($result3);
                        if (it != null) {
                            identityVerifyApi$upgradeToken$1$2$1 = new IdentityVerifyApi$upgradeToken$1$2$1(tapTapCallback2, it, null);
                            c03062.L$0 = $result3;
                            c03062.label = 3;
                            if (SystemExtKt.dispatchMain(identityVerifyApi$upgradeToken$1$2$1, c03062) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $result5 = $result4;
                            TapComplianceSettings.INSTANCE.clearLegacyCachedToken(TapComplianceInternal.INSTANCE.getUserId());
                        }
                        return Unit.INSTANCE;
                    } catch (Throwable th3) {
                        th = th3;
                        Result.Companion companion4 = Result.INSTANCE;
                        $result3 = Result.m534constructorimpl(ResultKt.createFailure(th));
                        c03062 = c03061;
                        $result4 = $result;
                        tapTapCallback = c03062.$callback;
                        if (Result.m541isSuccessimpl($result3)) {
                            identityVerifyApi$upgradeToken$1$1$1 = new IdentityVerifyApi$upgradeToken$1$1$1(tapTapCallback, (IdentityVerifyState) $result3, null);
                            c03062.L$0 = $result3;
                            c03062.label = 2;
                            if (SystemExtKt.dispatchMain(identityVerifyApi$upgradeToken$1$1$1, c03062) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        tapTapCallback2 = c03062.$callback;
                        it = Result.m537exceptionOrNullimpl($result3);
                        if (it != null) {
                            identityVerifyApi$upgradeToken$1$2$1 = new IdentityVerifyApi$upgradeToken$1$2$1(tapTapCallback2, it, null);
                            c03062.L$0 = $result3;
                            c03062.label = 3;
                            if (SystemExtKt.dispatchMain(identityVerifyApi$upgradeToken$1$2$1, c03062) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $result5 = $result4;
                            TapComplianceSettings.INSTANCE.clearLegacyCachedToken(TapComplianceInternal.INSTANCE.getUserId());
                        }
                        return Unit.INSTANCE;
                    }
                case 2:
                    c03062 = this;
                    $result4 = obj;
                    $result3 = c03062.L$0;
                    ResultKt.throwOnFailure($result4);
                    tapTapCallback2 = c03062.$callback;
                    it = Result.m537exceptionOrNullimpl($result3);
                    if (it != null) {
                        identityVerifyApi$upgradeToken$1$2$1 = new IdentityVerifyApi$upgradeToken$1$2$1(tapTapCallback2, it, null);
                        c03062.L$0 = $result3;
                        c03062.label = 3;
                        if (SystemExtKt.dispatchMain(identityVerifyApi$upgradeToken$1$2$1, c03062) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result5 = $result4;
                        TapComplianceSettings.INSTANCE.clearLegacyCachedToken(TapComplianceInternal.INSTANCE.getUserId());
                    }
                    return Unit.INSTANCE;
                case 3:
                    c03062 = this;
                    $result5 = obj;
                    ResultKt.throwOnFailure($result5);
                    TapComplianceSettings.INSTANCE.clearLegacyCachedToken(TapComplianceInternal.INSTANCE.getUserId());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Job upgradeToken(TapTapCallback<IdentityVerifyState> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        return SystemExtKt.runAsync(new C03061(callback, null));
    }

    /* JADX INFO: renamed from: com.taptap.sdk.compliance.api.IdentityVerifyApi$requestIdentityVerifyInfoRemotely$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IdentityVerifyApi.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.compliance.api.IdentityVerifyApi$requestIdentityVerifyInfoRemotely$1", f = "IdentityVerifyApi.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, MediaPlayer.MEDIA_PLAYER_OPTION_GET_CLOCK_DIFF, 157}, m = "invokeSuspend", n = {}, s = {})
    static final class C03051 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ TapTapCallback<IdentityVerifyState> $callback;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03051(TapTapCallback<IdentityVerifyState> tapTapCallback, Continuation<? super C03051> continuation) {
            super(1, continuation);
            this.$callback = tapTapCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C03051(this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C03051) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:26:0x00b0  */
        /* JADX WARN: Code duplicated, block: B:32:0x00e3 A[Catch: all -> 0x00fa, TryCatch #1 {all -> 0x00fa, blocks: (B:23:0x00a9, B:32:0x00e3, B:33:0x00ee, B:34:0x00f9, B:27:0x00b2, B:30:0x00d7), top: B:58:0x00a9, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:33:0x00ee A[Catch: all -> 0x00fa, TryCatch #1 {all -> 0x00fa, blocks: (B:23:0x00a9, B:32:0x00e3, B:33:0x00ee, B:34:0x00f9, B:27:0x00b2, B:30:0x00d7), top: B:58:0x00a9, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:42:0x0117  */
        /* JADX WARN: Code duplicated, block: B:44:0x012d A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:45:0x012e  */
        /* JADX WARN: Code duplicated, block: B:49:0x0139  */
        /* JADX WARN: Code duplicated, block: B:51:0x014c A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:52:0x014d  */
        /* JADX WARN: Code duplicated, block: B:56:0x00b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C03051 c03051;
            Object $result;
            int i;
            int i2;
            String accessToken;
            Object obj2;
            TapJson this_$iv$iv;
            Object $result2;
            C03051 c03052;
            Object $result3;
            Object $result4;
            C03051 c03053;
            TapTapCallback<IdentityVerifyState> tapTapCallback;
            IdentityVerifyApi$requestIdentityVerifyInfoRemotely$1$1$1 identityVerifyApi$requestIdentityVerifyInfoRemotely$1$1$1;
            JsonElement data$iv$iv;
            Object objDecodeFromJsonElement;
            TapTapCallback<IdentityVerifyState> tapTapCallback2;
            Throwable it;
            IdentityVerifyApi$requestIdentityVerifyInfoRemotely$1$2$1 identityVerifyApi$requestIdentityVerifyInfoRemotely$1$2$1;
            Object $result5;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    c03051 = this;
                    $result = obj;
                    TapComplianceApi tapComplianceApi = TapComplianceApi.INSTANCE;
                    Map queryMap$iv = new LinkedHashMap();
                    Map headerMap$iv = new LinkedHashMap();
                    i = 0;
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        Map<String, String> mutableMap = MapsKt.toMutableMap(queryMap$iv);
                        mutableMap.put(BundleKey.KEY_USER_IDENTIFIER, TapComplianceInternal.INSTANCE.getUserId());
                        Map<String, String> mutableMap2 = MapsKt.toMutableMap(headerMap$iv);
                        UserInfo currentUser = UserModel.INSTANCE.getCurrentUser();
                        if (currentUser == null || (accessToken = currentUser.getAccessToken()) == null) {
                            accessToken = "";
                        }
                        mutableMap2.put("X-TAP-Anti-Addiction-Token", accessToken);
                        TapJson tapJson = TapJson.INSTANCE;
                        ComplianceApiService api = TapComplianceApiKt.getApi();
                        c03051.L$0 = tapJson;
                        c03051.label = 1;
                        obj2 = api.get(RequestPath.IDENTITY_VERIFY, mutableMap, mutableMap2, c03051);
                        if (obj2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        this_$iv$iv = tapJson;
                        $result2 = $result;
                        c03052 = c03051;
                        try {
                            data$iv$iv = (JsonElement) obj2;
                            if (data$iv$iv == null) {
                                try {
                                    Json $this$decodeFromJsonElement$iv$iv$iv = this_$iv$iv.getJson();
                                    SerializersModule $this$serializer$iv$iv$iv$iv = $this$decodeFromJsonElement$iv$iv$iv.getSerializersModule();
                                    KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv$iv, Reflection.typeOf(IdentityVerifyState.class));
                                    Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                                    objDecodeFromJsonElement = $this$decodeFromJsonElement$iv$iv$iv.decodeFromJsonElement(kSerializerSerializer, data$iv$iv);
                                } catch (Exception e$iv$iv) {
                                    TapLogger.loge$default(TapJson.TAG, null, e$iv$iv, 2, null);
                                    objDecodeFromJsonElement = null;
                                }
                                break;
                            } else {
                                objDecodeFromJsonElement = null;
                            }
                            if (objDecodeFromJsonElement != null) {
                                throw new IllegalStateException("empty compliance response".toString());
                            }
                            Object objM534constructorimpl = Result.m534constructorimpl(objDecodeFromJsonElement);
                            $result3 = $result2;
                            C03051 c03054 = c03052;
                            $result4 = objM534constructorimpl;
                            c03053 = c03054;
                            tapTapCallback = c03053.$callback;
                            if (Result.m541isSuccessimpl($result4)) {
                                identityVerifyApi$requestIdentityVerifyInfoRemotely$1$1$1 = new IdentityVerifyApi$requestIdentityVerifyInfoRemotely$1$1$1(tapTapCallback, (IdentityVerifyState) $result4, null);
                                c03053.L$0 = $result4;
                                c03053.label = 2;
                                if (SystemExtKt.dispatchMain(identityVerifyApi$requestIdentityVerifyInfoRemotely$1$1$1, c03053) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            tapTapCallback2 = c03053.$callback;
                            it = Result.m537exceptionOrNullimpl($result4);
                            if (it != null) {
                                identityVerifyApi$requestIdentityVerifyInfoRemotely$1$2$1 = new IdentityVerifyApi$requestIdentityVerifyInfoRemotely$1$2$1(tapTapCallback2, it, null);
                                c03053.L$0 = $result4;
                                c03053.label = 3;
                                if (SystemExtKt.dispatchMain(identityVerifyApi$requestIdentityVerifyInfoRemotely$1$2$1, c03053) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                $result5 = $result3;
                            }
                            return Unit.INSTANCE;
                        } catch (Throwable th) {
                            th = th;
                            c03051 = c03052;
                            $result = $result2;
                            i2 = i;
                            Result.Companion companion2 = Result.INSTANCE;
                            $result3 = $result;
                            $result4 = Result.m534constructorimpl(ResultKt.createFailure(th));
                            c03053 = c03051;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        i2 = 0;
                        Result.Companion companion3 = Result.INSTANCE;
                        $result3 = $result;
                        $result4 = Result.m534constructorimpl(ResultKt.createFailure(th));
                        c03053 = c03051;
                        tapTapCallback = c03053.$callback;
                        if (Result.m541isSuccessimpl($result4)) {
                            identityVerifyApi$requestIdentityVerifyInfoRemotely$1$1$1 = new IdentityVerifyApi$requestIdentityVerifyInfoRemotely$1$1$1(tapTapCallback, (IdentityVerifyState) $result4, null);
                            c03053.L$0 = $result4;
                            c03053.label = 2;
                            if (SystemExtKt.dispatchMain(identityVerifyApi$requestIdentityVerifyInfoRemotely$1$1$1, c03053) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        tapTapCallback2 = c03053.$callback;
                        it = Result.m537exceptionOrNullimpl($result4);
                        if (it != null) {
                            identityVerifyApi$requestIdentityVerifyInfoRemotely$1$2$1 = new IdentityVerifyApi$requestIdentityVerifyInfoRemotely$1$2$1(tapTapCallback2, it, null);
                            c03053.L$0 = $result4;
                            c03053.label = 3;
                            if (SystemExtKt.dispatchMain(identityVerifyApi$requestIdentityVerifyInfoRemotely$1$2$1, c03053) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $result5 = $result3;
                        }
                        return Unit.INSTANCE;
                    }
                    break;
                case 1:
                    c03051 = this;
                    $result = obj;
                    i2 = 0;
                    this_$iv$iv = (TapJson) c03051.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        obj2 = $result;
                        i = 0;
                        c03052 = c03051;
                        $result2 = obj2;
                        data$iv$iv = (JsonElement) obj2;
                        if (data$iv$iv == null) {
                            Json $this$decodeFromJsonElement$iv$iv$iv2 = this_$iv$iv.getJson();
                            SerializersModule $this$serializer$iv$iv$iv$iv2 = $this$decodeFromJsonElement$iv$iv$iv2.getSerializersModule();
                            KSerializer<Object> kSerializerSerializer2 = SerializersKt.serializer($this$serializer$iv$iv$iv$iv2, Reflection.typeOf(IdentityVerifyState.class));
                            Intrinsics.checkNotNull(kSerializerSerializer2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                            objDecodeFromJsonElement = $this$decodeFromJsonElement$iv$iv$iv2.decodeFromJsonElement(kSerializerSerializer2, data$iv$iv);
                            break;
                        } else {
                            objDecodeFromJsonElement = null;
                        }
                        if (objDecodeFromJsonElement != null) {
                            throw new IllegalStateException("empty compliance response".toString());
                        }
                        Object objM534constructorimpl2 = Result.m534constructorimpl(objDecodeFromJsonElement);
                        $result3 = $result2;
                        C03051 c03055 = c03052;
                        $result4 = objM534constructorimpl2;
                        c03053 = c03055;
                        tapTapCallback = c03053.$callback;
                        if (Result.m541isSuccessimpl($result4)) {
                            identityVerifyApi$requestIdentityVerifyInfoRemotely$1$1$1 = new IdentityVerifyApi$requestIdentityVerifyInfoRemotely$1$1$1(tapTapCallback, (IdentityVerifyState) $result4, null);
                            c03053.L$0 = $result4;
                            c03053.label = 2;
                            if (SystemExtKt.dispatchMain(identityVerifyApi$requestIdentityVerifyInfoRemotely$1$1$1, c03053) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        tapTapCallback2 = c03053.$callback;
                        it = Result.m537exceptionOrNullimpl($result4);
                        if (it != null) {
                            identityVerifyApi$requestIdentityVerifyInfoRemotely$1$2$1 = new IdentityVerifyApi$requestIdentityVerifyInfoRemotely$1$2$1(tapTapCallback2, it, null);
                            c03053.L$0 = $result4;
                            c03053.label = 3;
                            if (SystemExtKt.dispatchMain(identityVerifyApi$requestIdentityVerifyInfoRemotely$1$2$1, c03053) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $result5 = $result3;
                        }
                        return Unit.INSTANCE;
                    } catch (Throwable th3) {
                        th = th3;
                        Result.Companion companion4 = Result.INSTANCE;
                        $result3 = $result;
                        $result4 = Result.m534constructorimpl(ResultKt.createFailure(th));
                        c03053 = c03051;
                        tapTapCallback = c03053.$callback;
                        if (Result.m541isSuccessimpl($result4)) {
                            identityVerifyApi$requestIdentityVerifyInfoRemotely$1$1$1 = new IdentityVerifyApi$requestIdentityVerifyInfoRemotely$1$1$1(tapTapCallback, (IdentityVerifyState) $result4, null);
                            c03053.L$0 = $result4;
                            c03053.label = 2;
                            if (SystemExtKt.dispatchMain(identityVerifyApi$requestIdentityVerifyInfoRemotely$1$1$1, c03053) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        tapTapCallback2 = c03053.$callback;
                        it = Result.m537exceptionOrNullimpl($result4);
                        if (it != null) {
                            identityVerifyApi$requestIdentityVerifyInfoRemotely$1$2$1 = new IdentityVerifyApi$requestIdentityVerifyInfoRemotely$1$2$1(tapTapCallback2, it, null);
                            c03053.L$0 = $result4;
                            c03053.label = 3;
                            if (SystemExtKt.dispatchMain(identityVerifyApi$requestIdentityVerifyInfoRemotely$1$2$1, c03053) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $result5 = $result3;
                        }
                        return Unit.INSTANCE;
                    }
                case 2:
                    c03053 = this;
                    $result3 = obj;
                    $result4 = c03053.L$0;
                    ResultKt.throwOnFailure($result3);
                    tapTapCallback2 = c03053.$callback;
                    it = Result.m537exceptionOrNullimpl($result4);
                    if (it != null) {
                        identityVerifyApi$requestIdentityVerifyInfoRemotely$1$2$1 = new IdentityVerifyApi$requestIdentityVerifyInfoRemotely$1$2$1(tapTapCallback2, it, null);
                        c03053.L$0 = $result4;
                        c03053.label = 3;
                        if (SystemExtKt.dispatchMain(identityVerifyApi$requestIdentityVerifyInfoRemotely$1$2$1, c03053) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result5 = $result3;
                    }
                    return Unit.INSTANCE;
                case 3:
                    $result5 = obj;
                    ResultKt.throwOnFailure($result5);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Job requestIdentityVerifyInfoRemotely(TapTapCallback<IdentityVerifyState> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        return SystemExtKt.runAsync(new C03051(callback, null));
    }

    /* JADX INFO: renamed from: com.taptap.sdk.compliance.api.IdentityVerifyApi$checkPlay$1, reason: invalid class name */
    /* JADX INFO: compiled from: IdentityVerifyApi.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.compliance.api.IdentityVerifyApi$checkPlay$1", f = "IdentityVerifyApi.kt", i = {}, l = {227}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ TapTapCallback<CheckPlayResult> $callback;
        Object L$0;
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

        /* JADX WARN: Code duplicated, block: B:32:0x00da A[Catch: all -> 0x01ba, TryCatch #4 {all -> 0x01ba, blocks: (B:17:0x008b, B:19:0x0091, B:30:0x00d5, B:33:0x00e8, B:34:0x00ff, B:36:0x0105, B:37:0x0128, B:39:0x0145, B:42:0x014d, B:26:0x00a7, B:29:0x00cd, B:32:0x00da), top: B:82:0x008b, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:36:0x0105 A[Catch: all -> 0x01ba, LOOP:0: B:34:0x00ff->B:36:0x0105, LOOP_END, TryCatch #4 {all -> 0x01ba, blocks: (B:17:0x008b, B:19:0x0091, B:30:0x00d5, B:33:0x00e8, B:34:0x00ff, B:36:0x0105, B:37:0x0128, B:39:0x0145, B:42:0x014d, B:26:0x00a7, B:29:0x00cd, B:32:0x00da), top: B:82:0x008b, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:41:0x014b  */
        /* JADX WARN: Code duplicated, block: B:44:0x016a A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:45:0x016b  */
        /* JADX WARN: Code duplicated, block: B:49:0x0175  */
        /* JADX WARN: Code duplicated, block: B:55:0x01a4 A[Catch: all -> 0x01b5, TryCatch #2 {all -> 0x01b5, blocks: (B:46:0x016e, B:55:0x01a4, B:56:0x01a9, B:57:0x01b4, B:50:0x0177, B:53:0x0199), top: B:79:0x016e, inners: #3 }] */
        /* JADX WARN: Code duplicated, block: B:56:0x01a9 A[Catch: all -> 0x01b5, TryCatch #2 {all -> 0x01b5, blocks: (B:46:0x016e, B:55:0x01a4, B:56:0x01a9, B:57:0x01b4, B:50:0x0177, B:53:0x0199), top: B:79:0x016e, inners: #3 }] */
        /* JADX WARN: Code duplicated, block: B:65:0x01d4  */
        /* JADX WARN: Code duplicated, block: B:68:0x01e5  */
        /* JADX WARN: Code duplicated, block: B:70:0x01ec  */
        /* JADX WARN: Code duplicated, block: B:71:0x01f6  */
        /* JADX WARN: Code duplicated, block: B:80:0x0177 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object $result;
            String body$iv;
            int i;
            AnonymousClass1 anonymousClass1;
            Object $result2;
            int i2;
            Map mapBuild;
            JsonObjectBuilder builder$iv$iv;
            UserInfo currentUser;
            String accessToken;
            TapJson tapJson;
            Object objPost;
            TapJson this_$iv$iv;
            Object objDecodeFromString;
            Object objM534constructorimpl;
            TapTapCallback<CheckPlayResult> tapTapCallback;
            TapTapCallback<CheckPlayResult> tapTapCallback2;
            Throwable it;
            JsonElement data$iv$iv;
            Object objDecodeFromJsonElement;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    $result = obj;
                    TapComplianceApi tapComplianceApi = TapComplianceApi.INSTANCE;
                    TapJson this_$iv = TapJson.INSTANCE;
                    HeartbeatRequestParams heartbeatRequestParams = new HeartbeatRequestParams(PlayLogModel.INSTANCE.getSessionId());
                    try {
                        StringFormat $this$encodeToString$iv$iv = this_$iv.getJson();
                        SerializersModule $this$serializer$iv$iv$iv = $this$encodeToString$iv$iv.getSerializersModule();
                        KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv, Reflection.typeOf(HeartbeatRequestParams.class));
                        Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                        body$iv = $this$encodeToString$iv$iv.encodeToString(kSerializerSerializer, heartbeatRequestParams);
                    } catch (Exception e$iv) {
                        TapLogger.loge$default(TapJson.TAG, null, e$iv, 2, null);
                        body$iv = null;
                    }
                    Map queryMap$iv = new LinkedHashMap();
                    i = 0;
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        if (body$iv != null) {
                            String it$iv = body$iv;
                            TapJson this_$iv$iv2 = TapJson.INSTANCE;
                            if (it$iv.length() == 0) {
                                objDecodeFromString = null;
                            } else {
                                try {
                                    StringFormat $this$decodeFromString$iv$iv$iv = this_$iv$iv2.getJson();
                                    SerializersModule $this$serializer$iv$iv$iv$iv = $this$decodeFromString$iv$iv$iv.getSerializersModule();
                                    KSerializer<Object> kSerializerSerializer2 = SerializersKt.serializer($this$serializer$iv$iv$iv$iv, Reflection.typeOf(JsonObject.class));
                                    Intrinsics.checkNotNull(kSerializerSerializer2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                                    objDecodeFromString = $this$decodeFromString$iv$iv$iv.decodeFromString(kSerializerSerializer2, it$iv);
                                } catch (Exception e$iv$iv) {
                                    TapLogger.loge$default(TapJson.TAG, null, e$iv$iv, 2, null);
                                    objDecodeFromString = null;
                                }
                            }
                            mapBuild = (JsonObject) objDecodeFromString;
                            if (mapBuild == null) {
                                mapBuild = new JsonObjectBuilder().build();
                            }
                            Map postBody$iv = mapBuild;
                            builder$iv$iv = new JsonObjectBuilder();
                            Map $this$forEach$iv$iv = postBody$iv;
                            for (Map.Entry<String, JsonElement> entry : $this$forEach$iv$iv.entrySet()) {
                                String key$iv = entry.getKey();
                                JsonElement value$iv = entry.getValue();
                                builder$iv$iv.put(key$iv, value$iv);
                            }
                            JsonElementBuildersKt.put(builder$iv$iv, BundleKey.KEY_USER_IDENTIFIER, TapComplianceInternal.INSTANCE.getUserId());
                            JsonObject requestBody$iv = builder$iv$iv.build();
                            currentUser = UserModel.INSTANCE.getCurrentUser();
                            if (currentUser != null || (accessToken = currentUser.getAccessToken()) == null) {
                                accessToken = "";
                            }
                            Map<String, String> mapMapOf = MapsKt.mapOf(TuplesKt.to("X-TAP-Anti-Addiction-Token", accessToken));
                            tapJson = TapJson.INSTANCE;
                            ComplianceApiService api = TapComplianceApiKt.getApi();
                            this.L$0 = tapJson;
                            this.label = 1;
                            objPost = api.post(RequestPath.HEARTBEAT, queryMap$iv, mapMapOf, requestBody$iv, this);
                            if (objPost == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            this_$iv$iv = tapJson;
                            anonymousClass1 = this;
                            $result2 = objPost;
                            try {
                                data$iv$iv = (JsonElement) $result2;
                                if (data$iv$iv == null) {
                                    objDecodeFromJsonElement = null;
                                } else {
                                    try {
                                        Json $this$decodeFromJsonElement$iv$iv$iv = this_$iv$iv.getJson();
                                        SerializersModule $this$serializer$iv$iv$iv$iv2 = $this$decodeFromJsonElement$iv$iv$iv.getSerializersModule();
                                        KSerializer<Object> kSerializerSerializer3 = SerializersKt.serializer($this$serializer$iv$iv$iv$iv2, Reflection.typeOf(CheckPlayResult.class));
                                        Intrinsics.checkNotNull(kSerializerSerializer3, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                                        objDecodeFromJsonElement = $this$decodeFromJsonElement$iv$iv$iv.decodeFromJsonElement(kSerializerSerializer3, data$iv$iv);
                                    } catch (Exception e$iv$iv2) {
                                        TapLogger.loge$default(TapJson.TAG, null, e$iv$iv2, 2, null);
                                        objDecodeFromJsonElement = null;
                                    }
                                }
                                if (objDecodeFromJsonElement == null) {
                                    throw new IllegalStateException("empty compliance response".toString());
                                }
                                objM534constructorimpl = Result.m534constructorimpl(objDecodeFromJsonElement);
                            } catch (Throwable th) {
                                th = th;
                                $result2 = $result;
                                i2 = i;
                                Result.Companion companion2 = Result.INSTANCE;
                                objM534constructorimpl = Result.m534constructorimpl(ResultKt.createFailure(th));
                            }
                        } else {
                            mapBuild = new JsonObjectBuilder().build();
                            Map postBody$iv2 = mapBuild;
                            builder$iv$iv = new JsonObjectBuilder();
                            Map $this$forEach$iv$iv2 = postBody$iv2;
                            while (r15.hasNext()) {
                                String key$iv2 = entry.getKey();
                                JsonElement value$iv2 = entry.getValue();
                                builder$iv$iv.put(key$iv2, value$iv2);
                            }
                            JsonElementBuildersKt.put(builder$iv$iv, BundleKey.KEY_USER_IDENTIFIER, TapComplianceInternal.INSTANCE.getUserId());
                            JsonObject requestBody$iv2 = builder$iv$iv.build();
                            currentUser = UserModel.INSTANCE.getCurrentUser();
                            if (currentUser != null) {
                                accessToken = "";
                            } else {
                                accessToken = "";
                            }
                            Map<String, String> mapMapOf2 = MapsKt.mapOf(TuplesKt.to("X-TAP-Anti-Addiction-Token", accessToken));
                            tapJson = TapJson.INSTANCE;
                            ComplianceApiService api2 = TapComplianceApiKt.getApi();
                            this.L$0 = tapJson;
                            this.label = 1;
                            objPost = api2.post(RequestPath.HEARTBEAT, queryMap$iv, mapMapOf2, requestBody$iv2, this);
                            if (objPost == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            this_$iv$iv = tapJson;
                            anonymousClass1 = this;
                            $result2 = objPost;
                            data$iv$iv = (JsonElement) $result2;
                            if (data$iv$iv == null) {
                                Json $this$decodeFromJsonElement$iv$iv$iv2 = this_$iv$iv.getJson();
                                SerializersModule $this$serializer$iv$iv$iv$iv3 = $this$decodeFromJsonElement$iv$iv$iv2.getSerializersModule();
                                KSerializer<Object> kSerializerSerializer4 = SerializersKt.serializer($this$serializer$iv$iv$iv$iv3, Reflection.typeOf(CheckPlayResult.class));
                                Intrinsics.checkNotNull(kSerializerSerializer4, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                                objDecodeFromJsonElement = $this$decodeFromJsonElement$iv$iv$iv2.decodeFromJsonElement(kSerializerSerializer4, data$iv$iv);
                            } else {
                                objDecodeFromJsonElement = null;
                            }
                            if (objDecodeFromJsonElement == null) {
                                throw new IllegalStateException("empty compliance response".toString());
                            }
                            objM534constructorimpl = Result.m534constructorimpl(objDecodeFromJsonElement);
                        }
                        break;
                    } catch (Throwable th2) {
                        th = th2;
                        anonymousClass1 = this;
                        $result2 = $result;
                        i2 = 0;
                        Result.Companion companion3 = Result.INSTANCE;
                        objM534constructorimpl = Result.m534constructorimpl(ResultKt.createFailure(th));
                        tapTapCallback = anonymousClass1.$callback;
                        if (Result.m541isSuccessimpl(objM534constructorimpl)) {
                            tapTapCallback.onSuccess((CheckPlayResult) objM534constructorimpl);
                        }
                        tapTapCallback2 = anonymousClass1.$callback;
                        it = Result.m537exceptionOrNullimpl(objM534constructorimpl);
                        if (it != null) {
                            if (NetExtKt.isTokenExpired(it)) {
                                TapComplianceInternal.notifyMessageInternal$default(TapComplianceInternal.INSTANCE, 9001, null, 2, null);
                            } else {
                                tapTapCallback2.onFail(new TapTapException("checkPlay failed, cause=" + it.getMessage()));
                            }
                        }
                        return Unit.INSTANCE;
                    }
                    tapTapCallback = anonymousClass1.$callback;
                    if (Result.m541isSuccessimpl(objM534constructorimpl)) {
                        tapTapCallback.onSuccess((CheckPlayResult) objM534constructorimpl);
                    }
                    tapTapCallback2 = anonymousClass1.$callback;
                    it = Result.m537exceptionOrNullimpl(objM534constructorimpl);
                    if (it != null) {
                        if (NetExtKt.isTokenExpired(it)) {
                            TapComplianceInternal.notifyMessageInternal$default(TapComplianceInternal.INSTANCE, 9001, null, 2, null);
                        } else {
                            tapTapCallback2.onFail(new TapTapException("checkPlay failed, cause=" + it.getMessage()));
                        }
                    }
                    return Unit.INSTANCE;
                case 1:
                    anonymousClass1 = this;
                    $result2 = obj;
                    i2 = 0;
                    this_$iv$iv = (TapJson) anonymousClass1.L$0;
                    try {
                        ResultKt.throwOnFailure($result2);
                        i = 0;
                        $result = $result2;
                        data$iv$iv = (JsonElement) $result2;
                        if (data$iv$iv == null) {
                            Json $this$decodeFromJsonElement$iv$iv$iv3 = this_$iv$iv.getJson();
                            SerializersModule $this$serializer$iv$iv$iv$iv4 = $this$decodeFromJsonElement$iv$iv$iv3.getSerializersModule();
                            KSerializer<Object> kSerializerSerializer5 = SerializersKt.serializer($this$serializer$iv$iv$iv$iv4, Reflection.typeOf(CheckPlayResult.class));
                            Intrinsics.checkNotNull(kSerializerSerializer5, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                            objDecodeFromJsonElement = $this$decodeFromJsonElement$iv$iv$iv3.decodeFromJsonElement(kSerializerSerializer5, data$iv$iv);
                            break;
                        } else {
                            objDecodeFromJsonElement = null;
                        }
                        if (objDecodeFromJsonElement == null) {
                            throw new IllegalStateException("empty compliance response".toString());
                        }
                        objM534constructorimpl = Result.m534constructorimpl(objDecodeFromJsonElement);
                        tapTapCallback = anonymousClass1.$callback;
                        if (Result.m541isSuccessimpl(objM534constructorimpl)) {
                            tapTapCallback.onSuccess((CheckPlayResult) objM534constructorimpl);
                        }
                        tapTapCallback2 = anonymousClass1.$callback;
                        it = Result.m537exceptionOrNullimpl(objM534constructorimpl);
                        if (it != null) {
                            if (NetExtKt.isTokenExpired(it)) {
                                TapComplianceInternal.notifyMessageInternal$default(TapComplianceInternal.INSTANCE, 9001, null, 2, null);
                            } else {
                                tapTapCallback2.onFail(new TapTapException("checkPlay failed, cause=" + it.getMessage()));
                            }
                        }
                        return Unit.INSTANCE;
                    } catch (Throwable th3) {
                        th = th3;
                        Result.Companion companion4 = Result.INSTANCE;
                        objM534constructorimpl = Result.m534constructorimpl(ResultKt.createFailure(th));
                        tapTapCallback = anonymousClass1.$callback;
                        if (Result.m541isSuccessimpl(objM534constructorimpl)) {
                            tapTapCallback.onSuccess((CheckPlayResult) objM534constructorimpl);
                        }
                        tapTapCallback2 = anonymousClass1.$callback;
                        it = Result.m537exceptionOrNullimpl(objM534constructorimpl);
                        if (it != null) {
                            if (NetExtKt.isTokenExpired(it)) {
                                TapComplianceInternal.notifyMessageInternal$default(TapComplianceInternal.INSTANCE, 9001, null, 2, null);
                            } else {
                                tapTapCallback2.onFail(new TapTapException("checkPlay failed, cause=" + it.getMessage()));
                            }
                        }
                        return Unit.INSTANCE;
                    }
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Job checkPlay(TapTapCallback<CheckPlayResult> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        return SystemExtKt.runAsync(new AnonymousClass1(callback, null));
    }
}
