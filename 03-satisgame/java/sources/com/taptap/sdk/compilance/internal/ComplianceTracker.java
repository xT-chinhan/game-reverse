package com.taptap.sdk.compilance.internal;

import com.anythink.core.common.l.f;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.json.TapJson;
import com.taptap.sdk.kit.internal.openlog.ITapOpenlog;
import com.taptap.sdk.kit.internal.service.CoreService;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import org.koin.mp.KoinPlatformTools;

/* JADX INFO: compiled from: ComplianceTracker.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\n\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0013H\u0002J3\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0013H\u0000¢\u0006\u0002\b\u0018JM\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00132\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0011H\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u000fH\u0000¢\u0006\u0002\b J3\u0010!\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0013H\u0000¢\u0006\u0002\b\"J3\u0010#\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0013H\u0000¢\u0006\u0002\b$R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f¨\u0006%"}, d2 = {"Lcom/taptap/sdk/compilance/internal/ComplianceTracker;", "Lorg/koin/core/component/KoinComponent;", "()V", "coreService", "Lcom/taptap/sdk/kit/internal/service/CoreService;", "getCoreService", "()Lcom/taptap/sdk/kit/internal/service/CoreService;", "coreService$delegate", "Lkotlin/Lazy;", "loggerHelper", "Lcom/taptap/sdk/kit/internal/openlog/ITapOpenlog;", "getLoggerHelper", "()Lcom/taptap/sdk/kit/internal/openlog/ITapOpenlog;", "loggerHelper$delegate", "reportBizLog", "", "action", "", "paramMap", "", "trackCancel", "funcName", "sessionId", "params", "trackCancel$tap_compliance_release", "trackFail", MediationConstant.KEY_ERROR_CODE, "", "errorMessage", "trackFail$tap_compliance_release", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Integer;Ljava/lang/String;)V", "trackInit", "trackInit$tap_compliance_release", "trackStart", "trackStart$tap_compliance_release", "trackSuccess", "trackSuccess$tap_compliance_release", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ComplianceTracker implements KoinComponent {
    public static final ComplianceTracker INSTANCE;

    /* JADX INFO: renamed from: coreService$delegate, reason: from kotlin metadata */
    private static final Lazy coreService;

    /* JADX INFO: renamed from: loggerHelper$delegate, reason: from kotlin metadata */
    private static final Lazy loggerHelper;

    private ComplianceTracker() {
    }

    @Override // org.koin.core.component.KoinComponent
    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        ComplianceTracker complianceTracker = new ComplianceTracker();
        INSTANCE = complianceTracker;
        final ComplianceTracker complianceTracker2 = complianceTracker;
        LazyThreadSafetyMode lazyThreadSafetyModeDefaultLazyMode = KoinPlatformTools.INSTANCE.defaultLazyMode();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        coreService = LazyKt.lazy(lazyThreadSafetyModeDefaultLazyMode, (Function0) new Function0<CoreService>() { // from class: com.taptap.sdk.compilance.internal.ComplianceTracker$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v5, types: [com.taptap.sdk.kit.internal.service.CoreService, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final CoreService invoke() {
                Scope rootScope;
                KoinComponent koinComponent = complianceTracker2;
                Qualifier qualifier2 = qualifier;
                Function0<? extends ParametersHolder> function0 = objArr;
                if (koinComponent instanceof KoinScopeComponent) {
                    rootScope = ((KoinScopeComponent) koinComponent).getScope();
                } else {
                    rootScope = koinComponent.getKoin().getScopeRegistry().getRootScope();
                }
                return rootScope.get(Reflection.getOrCreateKotlinClass(CoreService.class), qualifier2, function0);
            }
        });
        loggerHelper = LazyKt.lazy(new Function0<ITapOpenlog>() { // from class: com.taptap.sdk.compilance.internal.ComplianceTracker$loggerHelper$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ITapOpenlog invoke() {
                return ComplianceTracker.INSTANCE.getCoreService().obtainOpenlog("TapCompliance", "4.5.0");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreService getCoreService() {
        return (CoreService) coreService.getValue();
    }

    private final ITapOpenlog getLoggerHelper() {
        return (ITapOpenlog) loggerHelper.getValue();
    }

    public final void trackInit$tap_compliance_release() {
        String strEncodeToString;
        Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("func_name", "init"));
        try {
            Json json = TapJson.INSTANCE.getJson();
            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class))));
            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            strEncodeToString = json.encodeToString(kSerializerSerializer, mapMutableMapOf);
        } catch (Exception e) {
            TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
            strEncodeToString = null;
        }
        if (strEncodeToString == null) {
            strEncodeToString = "json convert error";
        }
        reportBizLog("init", MapsKt.mapOf(TuplesKt.to("args", strEncodeToString)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void trackStart$tap_compliance_release$default(ComplianceTracker complianceTracker, String str, String str2, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        complianceTracker.trackStart$tap_compliance_release(str, str2, map);
    }

    public final void trackStart$tap_compliance_release(String funcName, String sessionId, Map<String, String> params) {
        String strEncodeToString;
        Intrinsics.checkNotNullParameter(funcName, "funcName");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(params, "params");
        Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("func_name", funcName), TuplesKt.to(f.bo, sessionId));
        mapMutableMapOf.putAll(params);
        try {
            Json json = TapJson.INSTANCE.getJson();
            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class))));
            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            strEncodeToString = json.encodeToString(kSerializerSerializer, mapMutableMapOf);
        } catch (Exception e) {
            TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
            strEncodeToString = null;
        }
        if (strEncodeToString == null) {
            strEncodeToString = "json convert error";
        }
        reportBizLog("start", MapsKt.mapOf(TuplesKt.to("args", strEncodeToString)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void trackCancel$tap_compliance_release$default(ComplianceTracker complianceTracker, String str, String str2, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        complianceTracker.trackCancel$tap_compliance_release(str, str2, map);
    }

    public final void trackCancel$tap_compliance_release(String funcName, String sessionId, Map<String, String> params) {
        String strEncodeToString;
        Intrinsics.checkNotNullParameter(funcName, "funcName");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(params, "params");
        Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("func_name", funcName), TuplesKt.to(f.bo, sessionId));
        mapMutableMapOf.putAll(params);
        try {
            Json json = TapJson.INSTANCE.getJson();
            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class))));
            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            strEncodeToString = json.encodeToString(kSerializerSerializer, mapMutableMapOf);
        } catch (Exception e) {
            TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
            strEncodeToString = null;
        }
        if (strEncodeToString == null) {
            strEncodeToString = "json convert error";
        }
        reportBizLog("cancel", MapsKt.mapOf(TuplesKt.to("args", strEncodeToString)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void trackSuccess$tap_compliance_release$default(ComplianceTracker complianceTracker, String str, String str2, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        complianceTracker.trackSuccess$tap_compliance_release(str, str2, map);
    }

    public final void trackSuccess$tap_compliance_release(String funcName, String sessionId, Map<String, String> params) {
        String strEncodeToString;
        Intrinsics.checkNotNullParameter(funcName, "funcName");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(params, "params");
        Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("func_name", funcName), TuplesKt.to(f.bo, sessionId));
        mapMutableMapOf.putAll(params);
        try {
            Json json = TapJson.INSTANCE.getJson();
            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class))));
            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            strEncodeToString = json.encodeToString(kSerializerSerializer, mapMutableMapOf);
        } catch (Exception e) {
            TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
            strEncodeToString = null;
        }
        if (strEncodeToString == null) {
            strEncodeToString = "json convert error";
        }
        reportBizLog("success", MapsKt.mapOf(TuplesKt.to("args", strEncodeToString)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void trackFail$tap_compliance_release$default(ComplianceTracker complianceTracker, String str, String str2, Map map, Integer num, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        complianceTracker.trackFail$tap_compliance_release(str, str2, map, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : str3);
    }

    public final void trackFail$tap_compliance_release(String funcName, String sessionId, Map<String, String> params, Integer errorCode, String errorMessage) {
        String strEncodeToString;
        Intrinsics.checkNotNullParameter(funcName, "funcName");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(params, "params");
        Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("func_name", funcName), TuplesKt.to(f.bo, sessionId));
        mapMutableMapOf.putAll(params);
        if (errorCode != null) {
            mapMutableMapOf.put("error_code", String.valueOf(errorCode.intValue()));
        }
        if (errorMessage != null) {
            mapMutableMapOf.put("error_msg", errorMessage);
        }
        try {
            Json json = TapJson.INSTANCE.getJson();
            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class))));
            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            strEncodeToString = json.encodeToString(kSerializerSerializer, mapMutableMapOf);
        } catch (Exception e) {
            TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
            strEncodeToString = null;
        }
        if (strEncodeToString == null) {
            strEncodeToString = "json convert error";
        }
        reportBizLog("fail", MapsKt.mapOf(TuplesKt.to("args", strEncodeToString)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void reportBizLog$default(ComplianceTracker complianceTracker, String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        complianceTracker.reportBizLog(str, map);
    }

    private final void reportBizLog(String action, Map<String, String> paramMap) {
        TapComplianceLoggerKt.logInfo("reportBizLog: action=" + action + ", params=" + paramMap);
        ITapOpenlog loggerHelper2 = getLoggerHelper();
        if (loggerHelper2 != null) {
            loggerHelper2.reportBusinessLog(action, paramMap);
        }
    }
}
