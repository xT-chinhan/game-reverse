package com.taptap.sdk.compliance.internal;

import com.taptap.sdk.compliance.bean.UserInfo;
import com.taptap.sdk.compliance.constants.BundleKey;
import com.taptap.sdk.compliance.model.UserModel;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.json.TapJson;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: compiled from: TapComplianceApi.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jb\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0006\b\u0000\u0010\u0005\u0018\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\t2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0086Hø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000eJX\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0006\b\u0000\u0010\u0005\u0018\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0086Hø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"Lcom/taptap/sdk/compliance/internal/TapComplianceApi;", "", "()V", "get", "Lkotlin/Result;", "T", "path", "", "queryMap", "", "headerMap", "needUserId", "", "get-yxL6bBk", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "post", "body", "post-yxL6bBk", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapComplianceApi {
    public static final TapComplianceApi INSTANCE = new TapComplianceApi();

    private TapComplianceApi() {
    }

    /* JADX INFO: renamed from: get-yxL6bBk$default, reason: not valid java name */
    public static /* synthetic */ Object m407getyxL6bBk$default(TapComplianceApi $this, String path, Map queryMap, Map headerMap, boolean needUserId, Continuation $completion, int i, Object obj) {
        String userId;
        String accessToken;
        Map queryMap2 = (i & 2) != 0 ? new LinkedHashMap() : queryMap;
        Map headerMap2 = (i & 4) != 0 ? new LinkedHashMap() : headerMap;
        boolean needUserId2 = (i & 8) != 0 ? true : needUserId;
        try {
            Result.Companion companion = Result.INSTANCE;
            TapComplianceApi tapComplianceApi = $this;
            Map<String, String> mutableMap = MapsKt.toMutableMap(queryMap2);
            Map<String, String> map = mutableMap;
            String str = "";
            if (needUserId2) {
                try {
                    userId = TapComplianceInternal.INSTANCE.getUserId();
                } catch (Throwable th) {
                    th = th;
                    Result.Companion companion2 = Result.INSTANCE;
                    return Result.m534constructorimpl(ResultKt.createFailure(th));
                }
            } else {
                userId = "";
            }
            mutableMap.put(BundleKey.KEY_USER_IDENTIFIER, userId);
            Unit unit = Unit.INSTANCE;
            Map<String, String> map2 = mutableMap;
            Map<String, String> mutableMap2 = MapsKt.toMutableMap(headerMap2);
            Map<String, String> map3 = mutableMap2;
            UserInfo currentUser = UserModel.INSTANCE.getCurrentUser();
            if (currentUser != null && (accessToken = currentUser.getAccessToken()) != null) {
                str = accessToken;
            }
            mutableMap2.put("X-TAP-Anti-Addiction-Token", str);
            Unit unit2 = Unit.INSTANCE;
            Map<String, String> map4 = mutableMap2;
            TapJson this_$iv = TapJson.INSTANCE;
            ComplianceApiService api = TapComplianceApiKt.getApi();
            InlineMarker.mark(3);
            InlineMarker.mark(0);
            Object objDecodeFromJsonElement = null;
            try {
                Object obj2 = api.get(path, mutableMap, mutableMap2, null);
                InlineMarker.mark(1);
                JsonElement data$iv = (JsonElement) obj2;
                if (data$iv != null) {
                    try {
                        Json $this$decodeFromJsonElement$iv$iv = this_$iv.getJson();
                        SerializersModule $this$serializer$iv$iv$iv = $this$decodeFromJsonElement$iv$iv.getSerializersModule();
                        try {
                            Intrinsics.reifiedOperationMarker(6, "T");
                            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv, (KType) null);
                            try {
                                try {
                                    Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                                    objDecodeFromJsonElement = $this$decodeFromJsonElement$iv$iv.decodeFromJsonElement(kSerializerSerializer, data$iv);
                                } catch (Exception e) {
                                    e$iv = e;
                                    TapLogger.loge$default(TapJson.TAG, null, e$iv, 2, null);
                                    objDecodeFromJsonElement = null;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                Result.Companion companion3 = Result.INSTANCE;
                                return Result.m534constructorimpl(ResultKt.createFailure(th));
                            }
                        } catch (Exception e2) {
                            e$iv = e2;
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (Exception e3) {
                        e$iv = e3;
                    }
                }
                if (objDecodeFromJsonElement != null) {
                    return Result.m534constructorimpl(objDecodeFromJsonElement);
                }
                throw new IllegalStateException("empty compliance response".toString());
            } catch (Throwable th4) {
                th = th4;
                Result.Companion companion4 = Result.INSTANCE;
                return Result.m534constructorimpl(ResultKt.createFailure(th));
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    /* JADX INFO: renamed from: get-yxL6bBk, reason: not valid java name */
    public final /* synthetic */ <T> Object m409getyxL6bBk(String path, Map<String, String> map, Map<String, String> map2, boolean needUserId, Continuation<? super Result<? extends T>> continuation) {
        String accessToken;
        try {
            Result.Companion companion = Result.INSTANCE;
            TapComplianceApi tapComplianceApi = this;
            Map<String, String> mutableMap = MapsKt.toMutableMap(map);
            Map<String, String> map3 = mutableMap;
            String str = "";
            mutableMap.put(BundleKey.KEY_USER_IDENTIFIER, needUserId ? TapComplianceInternal.INSTANCE.getUserId() : "");
            Unit unit = Unit.INSTANCE;
            Map<String, String> map4 = mutableMap;
            Map<String, String> mutableMap2 = MapsKt.toMutableMap(map2);
            Map<String, String> map5 = mutableMap2;
            UserInfo currentUser = UserModel.INSTANCE.getCurrentUser();
            if (currentUser != null && (accessToken = currentUser.getAccessToken()) != null) {
                str = accessToken;
            }
            mutableMap2.put("X-TAP-Anti-Addiction-Token", str);
            Unit unit2 = Unit.INSTANCE;
            Map<String, String> map6 = mutableMap2;
            TapJson this_$iv = TapJson.INSTANCE;
            ComplianceApiService api = TapComplianceApiKt.getApi();
            InlineMarker.mark(3);
            InlineMarker.mark(0);
            Object objDecodeFromJsonElement = null;
            try {
                Object obj = api.get(path, mutableMap, mutableMap2, null);
                InlineMarker.mark(1);
                JsonElement data$iv = (JsonElement) obj;
                if (data$iv != null) {
                    try {
                        Json $this$decodeFromJsonElement$iv$iv = this_$iv.getJson();
                        SerializersModule $this$serializer$iv$iv$iv = $this$decodeFromJsonElement$iv$iv.getSerializersModule();
                        Intrinsics.reifiedOperationMarker(6, "T");
                        KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv, (KType) null);
                        Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                        objDecodeFromJsonElement = $this$decodeFromJsonElement$iv$iv.decodeFromJsonElement(kSerializerSerializer, data$iv);
                    } catch (Exception e$iv) {
                        TapLogger.loge$default(TapJson.TAG, null, e$iv, 2, null);
                        objDecodeFromJsonElement = null;
                    }
                }
                if (objDecodeFromJsonElement != null) {
                    return Result.m534constructorimpl(objDecodeFromJsonElement);
                }
                throw new IllegalStateException("empty compliance response".toString());
            } catch (Throwable th) {
                th = th;
                Result.Companion companion2 = Result.INSTANCE;
                return Result.m534constructorimpl(ResultKt.createFailure(th));
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0095  */
    /* JADX WARN: Code duplicated, block: B:42:0x00c9 A[Catch: all -> 0x0090, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0090, blocks: (B:18:0x0032, B:20:0x0041, B:32:0x0087, B:42:0x00c9, B:48:0x00f8, B:53:0x0116, B:28:0x0050, B:31:0x0080), top: B:81:0x0032, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00f8 A[Catch: all -> 0x0090, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0090, blocks: (B:18:0x0032, B:20:0x0041, B:32:0x0087, B:42:0x00c9, B:48:0x00f8, B:53:0x0116, B:28:0x0050, B:31:0x0080), top: B:81:0x0032, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:61:0x0149  */
    /* JADX WARN: Code duplicated, block: B:72:0x018a A[Catch: all -> 0x019b, TryCatch #4 {all -> 0x019b, blocks: (B:58:0x013a, B:72:0x018a, B:73:0x018f, B:74:0x019a, B:62:0x014b, B:64:0x015d, B:70:0x017f), top: B:89:0x013a }] */
    /* JADX WARN: Code duplicated, block: B:73:0x018f A[Catch: all -> 0x019b, TryCatch #4 {all -> 0x019b, blocks: (B:58:0x013a, B:72:0x018a, B:73:0x018f, B:74:0x019a, B:62:0x014b, B:64:0x015d, B:70:0x017f), top: B:89:0x013a }] */
    /* JADX WARN: Code duplicated, block: B:85:0x014b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: post-yxL6bBk$default, reason: not valid java name */
    public static /* synthetic */ Object m408postyxL6bBk$default(TapComplianceApi $this, String path, Map queryMap, String body, boolean needUserId, Continuation $completion, int i, Object obj) {
        Object objDecodeFromString;
        Map mapBuild;
        JsonObjectBuilder $this$post_yxL6bBk_u24lambda_u247_u24lambda_u246;
        String str;
        String userId;
        UserInfo currentUser;
        TapJson this_$iv;
        JsonElement data$iv;
        Object objDecodeFromJsonElement;
        String accessToken;
        Map queryMap2 = (i & 2) != 0 ? new LinkedHashMap() : queryMap;
        String body2 = (i & 4) != 0 ? null : body;
        boolean needUserId2 = (i & 8) != 0 ? true : needUserId;
        try {
            Result.Companion companion = Result.INSTANCE;
            TapComplianceApi tapComplianceApi = $this;
            if (body2 == null) {
                JsonObjectBuilder builder$iv = new JsonObjectBuilder();
                JsonObjectBuilder jsonObjectBuilder = builder$iv;
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
                mapBuild = builder$iv.build();
                Map postBody = mapBuild;
                JsonObjectBuilder builder$iv2 = new JsonObjectBuilder();
                $this$post_yxL6bBk_u24lambda_u247_u24lambda_u246 = builder$iv2;
                Map $this$forEach$iv = postBody;
                for (Map.Entry<String, JsonElement> entry : $this$forEach$iv.entrySet()) {
                    String key = entry.getKey();
                    JsonElement value = entry.getValue();
                    $this$post_yxL6bBk_u24lambda_u247_u24lambda_u246.put(key, value);
                    Unit unit3 = Unit.INSTANCE;
                }
                str = "";
                if (needUserId2) {
                    userId = TapComplianceInternal.INSTANCE.getUserId();
                } else {
                    userId = "";
                }
                JsonElementBuildersKt.put($this$post_yxL6bBk_u24lambda_u247_u24lambda_u246, BundleKey.KEY_USER_IDENTIFIER, userId);
                Unit unit4 = Unit.INSTANCE;
                JsonObject requestBody = builder$iv2.build();
                currentUser = UserModel.INSTANCE.getCurrentUser();
                if (currentUser != null) {
                    str = accessToken;
                }
                Map headers = MapsKt.mapOf(TuplesKt.to("X-TAP-Anti-Addiction-Token", str));
                this_$iv = TapJson.INSTANCE;
                ComplianceApiService api = TapComplianceApiKt.getApi();
                InlineMarker.mark(3);
                InlineMarker.mark(0);
                Object objPost = api.post(path, queryMap2, headers, requestBody, null);
                InlineMarker.mark(1);
                data$iv = (JsonElement) objPost;
                if (data$iv == null) {
                    objDecodeFromJsonElement = null;
                } else {
                    Json $this$decodeFromJsonElement$iv$iv = this_$iv.getJson();
                    SerializersModule $this$serializer$iv$iv$iv = $this$decodeFromJsonElement$iv$iv.getSerializersModule();
                    Intrinsics.reifiedOperationMarker(6, "T");
                    KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv, (KType) null);
                    Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    objDecodeFromJsonElement = $this$decodeFromJsonElement$iv$iv.decodeFromJsonElement(kSerializerSerializer, data$iv);
                }
                if (objDecodeFromJsonElement != null) {
                    return Result.m534constructorimpl(objDecodeFromJsonElement);
                }
                throw new IllegalStateException("empty compliance response".toString());
            }
            try {
                String it = body2;
                TapJson this_$iv2 = TapJson.INSTANCE;
                String str2 = it;
                if (str2 == null || str2.length() == 0) {
                    objDecodeFromString = null;
                } else {
                    try {
                        StringFormat $this$decodeFromString$iv$iv = this_$iv2.getJson();
                        SerializersModule $this$serializer$iv$iv$iv2 = $this$decodeFromString$iv$iv.getSerializersModule();
                        KSerializer<Object> kSerializerSerializer2 = SerializersKt.serializer($this$serializer$iv$iv$iv2, Reflection.typeOf(JsonObject.class));
                        Intrinsics.checkNotNull(kSerializerSerializer2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                        objDecodeFromString = $this$decodeFromString$iv$iv.decodeFromString(kSerializerSerializer2, it);
                    } catch (Exception e$iv) {
                        TapLogger.loge$default(TapJson.TAG, null, e$iv, 2, null);
                        objDecodeFromString = null;
                    }
                }
                mapBuild = (JsonObject) objDecodeFromString;
                if (mapBuild == null) {
                    JsonObjectBuilder builder$iv3 = new JsonObjectBuilder();
                    JsonObjectBuilder jsonObjectBuilder2 = builder$iv3;
                    Unit unit5 = Unit.INSTANCE;
                    Unit unit6 = Unit.INSTANCE;
                    mapBuild = builder$iv3.build();
                }
                Map postBody2 = mapBuild;
                JsonObjectBuilder builder$iv4 = new JsonObjectBuilder();
                $this$post_yxL6bBk_u24lambda_u247_u24lambda_u246 = builder$iv4;
                Map $this$forEach$iv2 = postBody2;
                while (r17.hasNext()) {
                    String key2 = entry.getKey();
                    JsonElement value2 = entry.getValue();
                    $this$post_yxL6bBk_u24lambda_u247_u24lambda_u246.put(key2, value2);
                    Unit unit7 = Unit.INSTANCE;
                }
                str = "";
                if (needUserId2) {
                    userId = TapComplianceInternal.INSTANCE.getUserId();
                } else {
                    userId = "";
                }
                JsonElementBuildersKt.put($this$post_yxL6bBk_u24lambda_u247_u24lambda_u246, BundleKey.KEY_USER_IDENTIFIER, userId);
                Unit unit8 = Unit.INSTANCE;
                JsonObject requestBody2 = builder$iv4.build();
                currentUser = UserModel.INSTANCE.getCurrentUser();
                if (currentUser != null && (accessToken = currentUser.getAccessToken()) != null) {
                    str = accessToken;
                }
                Map headers2 = MapsKt.mapOf(TuplesKt.to("X-TAP-Anti-Addiction-Token", str));
                this_$iv = TapJson.INSTANCE;
                ComplianceApiService api2 = TapComplianceApiKt.getApi();
                InlineMarker.mark(3);
                InlineMarker.mark(0);
                try {
                    Object objPost2 = api2.post(path, queryMap2, headers2, requestBody2, null);
                    InlineMarker.mark(1);
                    data$iv = (JsonElement) objPost2;
                    if (data$iv == null) {
                        objDecodeFromJsonElement = null;
                    } else {
                        try {
                            Json $this$decodeFromJsonElement$iv$iv2 = this_$iv.getJson();
                            SerializersModule $this$serializer$iv$iv$iv3 = $this$decodeFromJsonElement$iv$iv2.getSerializersModule();
                            try {
                                Intrinsics.reifiedOperationMarker(6, "T");
                                KSerializer<Object> kSerializerSerializer3 = SerializersKt.serializer($this$serializer$iv$iv$iv3, (KType) null);
                                Intrinsics.checkNotNull(kSerializerSerializer3, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                                objDecodeFromJsonElement = $this$decodeFromJsonElement$iv$iv2.decodeFromJsonElement(kSerializerSerializer3, data$iv);
                            } catch (Exception e) {
                                e$iv = e;
                                TapLogger.loge$default(TapJson.TAG, null, e$iv, 2, null);
                                objDecodeFromJsonElement = null;
                            }
                        } catch (Exception e2) {
                            e$iv = e2;
                        }
                    }
                    if (objDecodeFromJsonElement != null) {
                        return Result.m534constructorimpl(objDecodeFromJsonElement);
                    }
                    throw new IllegalStateException("empty compliance response".toString());
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
        Result.Companion companion2 = Result.INSTANCE;
        return Result.m534constructorimpl(ResultKt.createFailure(th));
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0070  */
    /* JADX WARN: Code duplicated, block: B:30:0x00a3 A[Catch: all -> 0x006b, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x006b, blocks: (B:6:0x0012, B:8:0x0021, B:20:0x0062, B:30:0x00a3, B:36:0x00d2, B:41:0x00f0, B:16:0x0030, B:19:0x005b), top: B:74:0x0012, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x00d2 A[Catch: all -> 0x006b, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x006b, blocks: (B:6:0x0012, B:8:0x0021, B:20:0x0062, B:30:0x00a3, B:36:0x00d2, B:41:0x00f0, B:16:0x0030, B:19:0x005b), top: B:74:0x0012, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:47:0x0121  */
    /* JADX WARN: Code duplicated, block: B:58:0x015d A[Catch: all -> 0x016e, TryCatch #5 {all -> 0x016e, blocks: (B:58:0x015d, B:59:0x0162, B:60:0x016d, B:50:0x0134, B:56:0x0152), top: B:70:0x0134 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x0162 A[Catch: all -> 0x016e, TryCatch #5 {all -> 0x016e, blocks: (B:58:0x015d, B:59:0x0162, B:60:0x016d, B:50:0x0134, B:56:0x0152), top: B:70:0x0134 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0125 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: post-yxL6bBk, reason: not valid java name */
    public final /* synthetic */ <T> Object m410postyxL6bBk(String path, Map<String, String> map, String body, boolean needUserId, Continuation<? super Result<? extends T>> continuation) {
        Object objDecodeFromString;
        Map postBody;
        JsonObjectBuilder $this$post_yxL6bBk_u24lambda_u247_u24lambda_u246;
        String str;
        String userId;
        UserInfo currentUser;
        TapJson this_$iv;
        JsonElement data$iv;
        Object objDecodeFromJsonElement;
        String accessToken;
        try {
            Result.Companion companion = Result.INSTANCE;
            TapComplianceApi tapComplianceApi = this;
            if (body == null) {
                JsonObjectBuilder builder$iv = new JsonObjectBuilder();
                JsonObjectBuilder jsonObjectBuilder = builder$iv;
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
                postBody = builder$iv.build();
                JsonObjectBuilder builder$iv2 = new JsonObjectBuilder();
                $this$post_yxL6bBk_u24lambda_u247_u24lambda_u246 = builder$iv2;
                Map $this$forEach$iv = postBody;
                for (Map.Entry<String, JsonElement> entry : $this$forEach$iv.entrySet()) {
                    String key = entry.getKey();
                    JsonElement value = entry.getValue();
                    $this$post_yxL6bBk_u24lambda_u247_u24lambda_u246.put(key, value);
                    Unit unit3 = Unit.INSTANCE;
                }
                str = "";
                if (needUserId) {
                    userId = TapComplianceInternal.INSTANCE.getUserId();
                } else {
                    userId = "";
                }
                JsonElementBuildersKt.put($this$post_yxL6bBk_u24lambda_u247_u24lambda_u246, BundleKey.KEY_USER_IDENTIFIER, userId);
                Unit unit4 = Unit.INSTANCE;
                JsonObject requestBody = builder$iv2.build();
                currentUser = UserModel.INSTANCE.getCurrentUser();
                if (currentUser != null) {
                    str = accessToken;
                }
                Map<String, String> mapMapOf = MapsKt.mapOf(TuplesKt.to("X-TAP-Anti-Addiction-Token", str));
                this_$iv = TapJson.INSTANCE;
                ComplianceApiService api = TapComplianceApiKt.getApi();
                InlineMarker.mark(3);
                InlineMarker.mark(0);
                Object objPost = api.post(path, map, mapMapOf, requestBody, null);
                InlineMarker.mark(1);
                data$iv = (JsonElement) objPost;
                if (data$iv == null) {
                    objDecodeFromJsonElement = null;
                } else {
                    Json $this$decodeFromJsonElement$iv$iv = this_$iv.getJson();
                    SerializersModule $this$serializer$iv$iv$iv = $this$decodeFromJsonElement$iv$iv.getSerializersModule();
                    Intrinsics.reifiedOperationMarker(6, "T");
                    KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv, (KType) null);
                    Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    objDecodeFromJsonElement = $this$decodeFromJsonElement$iv$iv.decodeFromJsonElement(kSerializerSerializer, data$iv);
                }
                if (objDecodeFromJsonElement != null) {
                    return Result.m534constructorimpl(objDecodeFromJsonElement);
                }
                throw new IllegalStateException("empty compliance response".toString());
            }
            try {
                String it = body;
                TapJson this_$iv2 = TapJson.INSTANCE;
                String str2 = it;
                if (str2 == null || str2.length() == 0) {
                    objDecodeFromString = null;
                } else {
                    try {
                        StringFormat $this$decodeFromString$iv$iv = this_$iv2.getJson();
                        SerializersModule $this$serializer$iv$iv$iv2 = $this$decodeFromString$iv$iv.getSerializersModule();
                        KSerializer<Object> kSerializerSerializer2 = SerializersKt.serializer($this$serializer$iv$iv$iv2, Reflection.typeOf(JsonObject.class));
                        Intrinsics.checkNotNull(kSerializerSerializer2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                        objDecodeFromString = $this$decodeFromString$iv$iv.decodeFromString(kSerializerSerializer2, it);
                    } catch (Exception e$iv) {
                        TapLogger.loge$default(TapJson.TAG, null, e$iv, 2, null);
                        objDecodeFromString = null;
                    }
                }
                postBody = (JsonObject) objDecodeFromString;
                if (postBody == null) {
                    JsonObjectBuilder builder$iv3 = new JsonObjectBuilder();
                    JsonObjectBuilder jsonObjectBuilder2 = builder$iv3;
                    Unit unit5 = Unit.INSTANCE;
                    Unit unit6 = Unit.INSTANCE;
                    postBody = builder$iv3.build();
                }
                JsonObjectBuilder builder$iv4 = new JsonObjectBuilder();
                $this$post_yxL6bBk_u24lambda_u247_u24lambda_u246 = builder$iv4;
                Map $this$forEach$iv2 = postBody;
                while (r15.hasNext()) {
                    String key2 = entry.getKey();
                    JsonElement value2 = entry.getValue();
                    $this$post_yxL6bBk_u24lambda_u247_u24lambda_u246.put(key2, value2);
                    Unit unit7 = Unit.INSTANCE;
                }
                str = "";
                if (needUserId) {
                    userId = TapComplianceInternal.INSTANCE.getUserId();
                } else {
                    userId = "";
                }
                JsonElementBuildersKt.put($this$post_yxL6bBk_u24lambda_u247_u24lambda_u246, BundleKey.KEY_USER_IDENTIFIER, userId);
                Unit unit8 = Unit.INSTANCE;
                JsonObject requestBody2 = builder$iv4.build();
                currentUser = UserModel.INSTANCE.getCurrentUser();
                if (currentUser != null && (accessToken = currentUser.getAccessToken()) != null) {
                    str = accessToken;
                }
                Map<String, String> mapMapOf2 = MapsKt.mapOf(TuplesKt.to("X-TAP-Anti-Addiction-Token", str));
                this_$iv = TapJson.INSTANCE;
                ComplianceApiService api2 = TapComplianceApiKt.getApi();
                InlineMarker.mark(3);
                InlineMarker.mark(0);
                Object objPost2 = api2.post(path, map, mapMapOf2, requestBody2, null);
                InlineMarker.mark(1);
                data$iv = (JsonElement) objPost2;
                if (data$iv == null) {
                    objDecodeFromJsonElement = null;
                } else {
                    try {
                        Json $this$decodeFromJsonElement$iv$iv2 = this_$iv.getJson();
                        SerializersModule $this$serializer$iv$iv$iv3 = $this$decodeFromJsonElement$iv$iv2.getSerializersModule();
                        try {
                            try {
                                Intrinsics.reifiedOperationMarker(6, "T");
                                KSerializer<Object> kSerializerSerializer3 = SerializersKt.serializer($this$serializer$iv$iv$iv3, (KType) null);
                                Intrinsics.checkNotNull(kSerializerSerializer3, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                                objDecodeFromJsonElement = $this$decodeFromJsonElement$iv$iv2.decodeFromJsonElement(kSerializerSerializer3, data$iv);
                            } catch (Exception e) {
                                e$iv = e;
                                TapLogger.loge$default(TapJson.TAG, null, e$iv, 2, null);
                                objDecodeFromJsonElement = null;
                            }
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (Exception e2) {
                        e$iv = e2;
                    }
                }
                if (objDecodeFromJsonElement != null) {
                    return Result.m534constructorimpl(objDecodeFromJsonElement);
                }
                throw new IllegalStateException("empty compliance response".toString());
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
        Result.Companion companion2 = Result.INSTANCE;
        return Result.m534constructorimpl(ResultKt.createFailure(th));
    }
}
