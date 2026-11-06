package com.taptap.sdk.rep.internal;

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
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: compiled from: RepTracker.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0013H\u0002JK\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00132\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u000fH\u0007J.\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0013H\u0007J.\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0013H\u0007R\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/taptap/sdk/rep/internal/RepTracker;", "", "()V", "loggerHelper", "Lcom/taptap/sdk/kit/internal/openlog/ITapOpenlog;", "getLoggerHelper", "()Lcom/taptap/sdk/kit/internal/openlog/ITapOpenlog;", "loggerHelper$delegate", "Lkotlin/Lazy;", "openLogService", "Lcom/taptap/sdk/common/services/OpenLogService;", "getOpenLogService", "()Lcom/taptap/sdk/common/services/OpenLogService;", "openLogService$delegate", "reportBizLog", "", "action", "", "paramMap", "", "trackFail", "funcName", "sessionId", "params", MediationConstant.KEY_ERROR_CODE, "", "errorMessage", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Integer;Ljava/lang/String;)V", "trackInit", "trackStart", "trackSuccess", "tap-rep_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RepTracker {
    public static final RepTracker INSTANCE = new RepTracker();

    /* JADX INFO: renamed from: loggerHelper$delegate, reason: from kotlin metadata */
    private static final Lazy loggerHelper;

    /* JADX INFO: renamed from: openLogService$delegate, reason: from kotlin metadata */
    private static final Lazy openLogService;

    private RepTracker() {
    }

    static {
        ServiceManagerComponent serviceManagerComponent = ServiceManagerComponent.INSTANCE;
        openLogService = LazyKt.lazy(new Function0<OpenLogService>() { // from class: com.taptap.sdk.rep.internal.RepTracker$special$$inlined$inject$1
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
        loggerHelper = LazyKt.lazy(new Function0<ITapOpenlog>() { // from class: com.taptap.sdk.rep.internal.RepTracker$loggerHelper$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ITapOpenlog invoke() {
                return RepTracker.INSTANCE.getOpenLogService().obtainOpenlog(SdkModules.REP, "4.10.9");
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

    @JvmStatic
    public static final void trackInit() {
        Map argsMap = MapsKt.mutableMapOf(TuplesKt.to("func_name", TrackAction.INIT));
        RepTracker repTracker = INSTANCE;
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
        repTracker.reportBizLog(TrackAction.INIT, MapsKt.mapOf(TuplesKt.to("args", strEncodeToString)));
    }

    public static /* synthetic */ void trackStart$default(String str, String str2, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        trackStart(str, str2, map);
    }

    @JvmStatic
    public static final void trackStart(String funcName, String sessionId, Map<String, String> params) {
        String strEncodeToString;
        Intrinsics.checkNotNullParameter(funcName, "funcName");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(params, "params");
        Map argsMap = MapsKt.mutableMapOf(TuplesKt.to("func_name", funcName), TuplesKt.to("session_id", sessionId));
        argsMap.putAll(params);
        RepTracker repTracker = INSTANCE;
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
        repTracker.reportBizLog(TrackAction.START, MapsKt.mapOf(TuplesKt.to("args", strEncodeToString)));
    }

    public static /* synthetic */ void trackSuccess$default(String str, String str2, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        trackSuccess(str, str2, map);
    }

    @JvmStatic
    public static final void trackSuccess(String funcName, String sessionId, Map<String, String> params) {
        String strEncodeToString;
        Intrinsics.checkNotNullParameter(funcName, "funcName");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(params, "params");
        Map argsMap = MapsKt.mutableMapOf(TuplesKt.to("func_name", funcName), TuplesKt.to("session_id", sessionId));
        argsMap.putAll(params);
        RepTracker repTracker = INSTANCE;
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
        repTracker.reportBizLog(TrackAction.SUCCESS, MapsKt.mapOf(TuplesKt.to("args", strEncodeToString)));
    }

    public static /* synthetic */ void trackFail$default(String str, String str2, Map map, Integer num, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        if ((i & 8) != 0) {
            num = null;
        }
        if ((i & 16) != 0) {
            str3 = null;
        }
        trackFail(str, str2, map, num, str3);
    }

    @JvmStatic
    public static final void trackFail(String funcName, String sessionId, Map<String, String> params, Integer errorCode, String errorMessage) {
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
        RepTracker repTracker = INSTANCE;
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
        repTracker.reportBizLog(TrackAction.FAIL, MapsKt.mapOf(TuplesKt.to("args", strEncodeToString)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void reportBizLog$default(RepTracker repTracker, String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        repTracker.reportBizLog(str, map);
    }

    private final void reportBizLog(String action, Map<String, String> paramMap) {
        TapLogger.logi("TapRepLog", "reportBizLog: action=" + action + ", params=" + paramMap);
        ITapOpenlog loggerHelper2 = getLoggerHelper();
        if (loggerHelper2 != null) {
            ITapOpenlog.DefaultImpls.reportBusinessLog$default(loggerHelper2, null, action, paramMap, 1, null);
        }
    }
}
