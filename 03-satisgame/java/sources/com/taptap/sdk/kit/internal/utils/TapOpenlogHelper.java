package com.taptap.sdk.kit.internal.utils;

import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.openlog.ITapOpenlog;
import com.taptap.sdk.kit.internal.service.CoreService;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import org.koin.mp.KoinPlatformTools;

/* JADX INFO: compiled from: TapOpenlogHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0014J*\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u001a\u0010\u0016\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00140\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/taptap/sdk/kit/internal/utils/TapOpenlogHelper;", "Lorg/koin/core/component/KoinComponent;", "()V", "TAG", "", "coreService", "Lcom/taptap/sdk/kit/internal/service/CoreService;", "getCoreService", "()Lcom/taptap/sdk/kit/internal/service/CoreService;", "coreService$delegate", "Lkotlin/Lazy;", "openlog", "Lcom/taptap/sdk/kit/internal/openlog/ITapOpenlog;", "getOpenlog", "()Lcom/taptap/sdk/kit/internal/openlog/ITapOpenlog;", "openlog$delegate", "reportBusinessLog", "", "action", TapEventParamConstants.PARAM_PROPERTIES, "", "reportTechnicalLog", "block", "Lkotlin/Function0;", "tap-kit_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapOpenlogHelper implements KoinComponent {
    public static final TapOpenlogHelper INSTANCE;
    private static final String TAG = "TapOpenlogHelper-Kit";

    /* JADX INFO: renamed from: coreService$delegate, reason: from kotlin metadata */
    private static final Lazy coreService;

    /* JADX INFO: renamed from: openlog$delegate, reason: from kotlin metadata */
    private static final Lazy openlog;

    private TapOpenlogHelper() {
    }

    @Override // org.koin.core.component.KoinComponent
    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        TapOpenlogHelper tapOpenlogHelper = new TapOpenlogHelper();
        INSTANCE = tapOpenlogHelper;
        final TapOpenlogHelper tapOpenlogHelper2 = tapOpenlogHelper;
        LazyThreadSafetyMode lazyThreadSafetyModeDefaultLazyMode = KoinPlatformTools.INSTANCE.defaultLazyMode();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        coreService = LazyKt.lazy(lazyThreadSafetyModeDefaultLazyMode, (Function0) new Function0<CoreService>() { // from class: com.taptap.sdk.kit.internal.utils.TapOpenlogHelper$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v5, types: [com.taptap.sdk.kit.internal.service.CoreService, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final CoreService invoke() {
                Scope rootScope;
                KoinComponent koinComponent = tapOpenlogHelper2;
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
        openlog = LazyKt.lazy(new Function0<ITapOpenlog>() { // from class: com.taptap.sdk.kit.internal.utils.TapOpenlogHelper$openlog$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ITapOpenlog invoke() {
                return TapOpenlogHelper.INSTANCE.getCoreService().obtainOpenlog("TapSDKCore", "4.5.0");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreService getCoreService() {
        return (CoreService) coreService.getValue();
    }

    private final ITapOpenlog getOpenlog() {
        return (ITapOpenlog) openlog.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reportBusinessLog$default(TapOpenlogHelper tapOpenlogHelper, String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        tapOpenlogHelper.reportBusinessLog(str, map);
    }

    public final void reportBusinessLog(String action, Map<String, String> properties) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(properties, "properties");
        ITapOpenlog openlog2 = getOpenlog();
        if (openlog2 != null) {
            openlog2.reportBusinessLog(action, properties);
        }
    }

    public final void reportTechnicalLog(String action, Function0<? extends Map<String, String>> block) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(block, "block");
        HashMap map = new HashMap();
        try {
            map = block.invoke();
        } catch (Exception e) {
            TapLogger.logd(TAG, e);
        }
        ITapOpenlog openlog2 = getOpenlog();
        if (openlog2 != null) {
            openlog2.reportTechnicalLog("core__" + action, map);
        }
    }
}
