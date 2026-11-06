package com.taptap.sdk.kit.internal.utils;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
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

/* JADX INFO: compiled from: KoinUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u0002H\u0004\"\u0006\b\u0000\u0010\u0004\u0018\u0001H\u0086\b¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/kit/internal/utils/KoinUtils;", "", "()V", "get", "T", "()Ljava/lang/Object;", "tap-kit_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class KoinUtils {
    public static final KoinUtils INSTANCE = new KoinUtils();

    private KoinUtils() {
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.taptap.sdk.kit.internal.utils.KoinUtils$get$koinComponent$1] */
    public final /* synthetic */ <T> T get() {
        Intrinsics.needClassReification();
        return (T) new KoinComponent() { // from class: com.taptap.sdk.kit.internal.utils.KoinUtils$get$koinComponent$1

            /* JADX INFO: renamed from: value$delegate, reason: from kotlin metadata */
            private final Lazy value;

            /* JADX WARN: Multi-variable type inference failed */
            {
                final KoinUtils$get$koinComponent$1 koinUtils$get$koinComponent$1 = this;
                LazyThreadSafetyMode lazyThreadSafetyModeDefaultLazyMode = KoinPlatformTools.INSTANCE.defaultLazyMode();
                Intrinsics.needClassReification();
                final Qualifier qualifier = null;
                final Object[] objArr = 0 == true ? 1 : 0;
                this.value = LazyKt.lazy(lazyThreadSafetyModeDefaultLazyMode, new Function0<T>() { // from class: com.taptap.sdk.kit.internal.utils.KoinUtils$get$koinComponent$1$special$$inlined$inject$default$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final T invoke() {
                        Scope rootScope;
                        KoinComponent koinComponent = koinUtils$get$koinComponent$1;
                        Qualifier qualifier2 = qualifier;
                        Function0<? extends ParametersHolder> function0 = objArr;
                        if (koinComponent instanceof KoinScopeComponent) {
                            rootScope = ((KoinScopeComponent) koinComponent).getScope();
                        } else {
                            rootScope = koinComponent.getKoin().getScopeRegistry().getRootScope();
                        }
                        Intrinsics.reifiedOperationMarker(4, "T");
                        return (T) rootScope.get(Reflection.getOrCreateKotlinClass(Object.class), qualifier2, function0);
                    }
                });
            }

            @Override // org.koin.core.component.KoinComponent
            public Koin getKoin() {
                return KoinComponent.DefaultImpls.getKoin(this);
            }

            /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
            public final T getValue() {
                return this.value.getValue();
            }
        }.getValue();
    }
}
