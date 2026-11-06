package com.taptap.sdk.review.internal;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.common.services.OpenLogService;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.json.TapJson;
import com.taptap.sdk.kit.internal.openlog.ITapOpenlog;
import com.taptap.sdk.kit.internal.p001const.SdkModules;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import com.taptap.sdk.servicemanager.ServiceManager;
import com.taptap.sdk.servicemanager.utils.ServiceManagerComponent;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: compiled from: ReviewTracker.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0013H\u0002JM\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00132\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0011H\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u001eJ3\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0013H\u0000¢\u0006\u0002\b J3\u0010!\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0013H\u0000¢\u0006\u0002\b\"R\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f¨\u0006#"}, d2 = {"Lcom/taptap/sdk/review/internal/ReviewTracker;", "", "()V", "loggerHelper", "Lcom/taptap/sdk/kit/internal/openlog/ITapOpenlog;", "getLoggerHelper", "()Lcom/taptap/sdk/kit/internal/openlog/ITapOpenlog;", "loggerHelper$delegate", "Lkotlin/Lazy;", "openLogService", "Lcom/taptap/sdk/common/services/OpenLogService;", "getOpenLogService", "()Lcom/taptap/sdk/common/services/OpenLogService;", "openLogService$delegate", "reportBizLog", "", "action", "", "paramMap", "", "trackFail", "funcName", "sessionId", "params", MediationConstant.KEY_ERROR_CODE, "", "errorMessage", "trackFail$tap_review_release", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Integer;Ljava/lang/String;)V", "trackInit", "trackInit$tap_review_release", "trackStart", "trackStart$tap_review_release", "trackSuccess", "trackSuccess$tap_review_release", "tap-review_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ReviewTracker {
    public static final ReviewTracker INSTANCE = new ReviewTracker();

    /* JADX INFO: renamed from: loggerHelper$delegate, reason: from kotlin metadata */
    private static final Lazy loggerHelper;

    /* JADX INFO: renamed from: openLogService$delegate, reason: from kotlin metadata */
    private static final Lazy openLogService;

    private ReviewTracker() {
    }

    static {
        ServiceManagerComponent serviceManagerComponent = ServiceManagerComponent.INSTANCE;
        openLogService = LazyKt.lazy(new Function0<OpenLogService>() { // from class: com.taptap.sdk.review.internal.ReviewTracker$special$$inlined$inject$1
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
        loggerHelper = LazyKt.lazy(new Function0<ITapOpenlog>() { // from class: com.taptap.sdk.review.internal.ReviewTracker$loggerHelper$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ITapOpenlog invoke() {
                return ReviewTracker.INSTANCE.getOpenLogService().obtainOpenlog(SdkModules.REVIEW, "4.10.9");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OpenLogService getOpenLogService() {
        return (OpenLogService) openLogService.getValue();
    }

    private final ITapOpenlog getLoggerHelper() {
        return (ITapOpenlog) loggerHelper.getValue();
    }

    public final void trackInit$tap_review_release() {
        Map argsMap = MapsKt.mutableMapOf(TuplesKt.to("func_name", TrackAction.INIT));
        TapJson this_$iv$iv = TapJson.INSTANCE;
        String strEncodeToString = null;
        try {
            StringFormat $this$encodeToString$iv$iv$iv = this_$iv$iv.getJson();
            SerializersModule $this$serializer$iv$iv$iv$iv = $this$encodeToString$iv$iv$iv.getSerializersModule();
            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv$iv, Reflection.typeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class))));
            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            strEncodeToString = $this$encodeToString$iv$iv$iv.encodeToString(kSerializerSerializer, argsMap);
        } catch (Exception e$iv$iv) {
            TapLogger.loge$default(TapJson.TAG, null, e$iv$iv, 2, null);
        }
        if (strEncodeToString == null) {
            strEncodeToString = "json convert error";
        }
        reportBizLog(TrackAction.INIT, MapsKt.mapOf(TuplesKt.to("args", strEncodeToString)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void trackStart$tap_review_release$default(ReviewTracker reviewTracker, String str, String str2, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        reviewTracker.trackStart$tap_review_release(str, str2, map);
    }

    public final void trackStart$tap_review_release(String funcName, String sessionId, Map<String, String> params) {
        String strEncodeToString;
        Intrinsics.checkNotNullParameter(funcName, "funcName");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(params, "params");
        Map argsMap = MapsKt.mutableMapOf(TuplesKt.to("func_name", funcName), TuplesKt.to("session_id", sessionId));
        argsMap.putAll(params);
        TapJson this_$iv$iv = TapJson.INSTANCE;
        try {
            StringFormat $this$encodeToString$iv$iv$iv = this_$iv$iv.getJson();
            SerializersModule $this$serializer$iv$iv$iv$iv = $this$encodeToString$iv$iv$iv.getSerializersModule();
            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv$iv, Reflection.typeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class))));
            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            strEncodeToString = $this$encodeToString$iv$iv$iv.encodeToString(kSerializerSerializer, argsMap);
        } catch (Exception e$iv$iv) {
            TapLogger.loge$default(TapJson.TAG, null, e$iv$iv, 2, null);
            strEncodeToString = null;
        }
        if (strEncodeToString == null) {
            strEncodeToString = "json convert error";
        }
        reportBizLog(TrackAction.START, MapsKt.mapOf(TuplesKt.to("args", strEncodeToString)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void trackSuccess$tap_review_release$default(ReviewTracker reviewTracker, String str, String str2, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        reviewTracker.trackSuccess$tap_review_release(str, str2, map);
    }

    public final void trackSuccess$tap_review_release(String funcName, String sessionId, Map<String, String> params) {
        String strEncodeToString;
        Intrinsics.checkNotNullParameter(funcName, "funcName");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(params, "params");
        Map argsMap = MapsKt.mutableMapOf(TuplesKt.to("func_name", funcName), TuplesKt.to("session_id", sessionId));
        argsMap.putAll(params);
        TapJson this_$iv$iv = TapJson.INSTANCE;
        try {
            StringFormat $this$encodeToString$iv$iv$iv = this_$iv$iv.getJson();
            SerializersModule $this$serializer$iv$iv$iv$iv = $this$encodeToString$iv$iv$iv.getSerializersModule();
            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv$iv, Reflection.typeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class))));
            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            strEncodeToString = $this$encodeToString$iv$iv$iv.encodeToString(kSerializerSerializer, argsMap);
        } catch (Exception e$iv$iv) {
            TapLogger.loge$default(TapJson.TAG, null, e$iv$iv, 2, null);
            strEncodeToString = null;
        }
        if (strEncodeToString == null) {
            strEncodeToString = "json convert error";
        }
        reportBizLog(TrackAction.SUCCESS, MapsKt.mapOf(TuplesKt.to("args", strEncodeToString)));
    }

    public final void trackFail$tap_review_release(String funcName, String sessionId, Map<String, String> params, Integer errorCode, String errorMessage) {
        String strEncodeToString;
        Intrinsics.checkNotNullParameter(funcName, "funcName");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(params, "params");
        Map argsMap = MapsKt.mutableMapOf(TuplesKt.to("func_name", funcName), TuplesKt.to("session_id", sessionId));
        argsMap.putAll(params);
        if (errorCode != null) {
            int it = errorCode.intValue();
            argsMap.put(Constants.ERROR_CODE_FIELD, String.valueOf(it));
        }
        if (errorMessage != null) {
            argsMap.put(Constants.ERROR_MSG_FIELD, errorMessage);
        }
        TapJson this_$iv$iv = TapJson.INSTANCE;
        try {
            StringFormat $this$encodeToString$iv$iv$iv = this_$iv$iv.getJson();
            SerializersModule $this$serializer$iv$iv$iv$iv = $this$encodeToString$iv$iv$iv.getSerializersModule();
            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv$iv, Reflection.typeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class))));
            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            strEncodeToString = $this$encodeToString$iv$iv$iv.encodeToString(kSerializerSerializer, argsMap);
        } catch (Exception e$iv$iv) {
            TapLogger.loge$default(TapJson.TAG, null, e$iv$iv, 2, null);
            strEncodeToString = null;
        }
        if (strEncodeToString == null) {
            strEncodeToString = "json convert error";
        }
        reportBizLog(TrackAction.FAIL, MapsKt.mapOf(TuplesKt.to("args", strEncodeToString)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void reportBizLog$default(ReviewTracker reviewTracker, String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        reviewTracker.reportBizLog(str, map);
    }

    private final void reportBizLog(String action, Map<String, String> paramMap) {
        TapLogger.logi("TapReviewLog", "reportBizLog: action=" + action + ", params=" + paramMap);
        ITapOpenlog loggerHelper2 = getLoggerHelper();
        if (loggerHelper2 != null) {
            ITapOpenlog.DefaultImpls.reportBusinessLog$default(loggerHelper2, null, action, paramMap, 1, null);
        }
    }
}
