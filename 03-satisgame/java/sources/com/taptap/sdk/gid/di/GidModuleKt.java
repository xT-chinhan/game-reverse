package com.taptap.sdk.gid.di;

import com.taptap.sdk.gid.api.GidService;
import com.taptap.sdk.gid.service.GidServiceImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Kind;
import org.koin.core.definition.KoinDefinition;
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.module.Module;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.registry.ScopeRegistry;
import org.koin.core.scope.Scope;
import org.koin.dsl.ModuleDSLKt;

/* JADX INFO: compiled from: GidModule.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"gidModule", "Lorg/koin/core/module/Module;", "getGidModule", "()Lorg/koin/core/module/Module;", "tap-gid_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class GidModuleKt {
    private static final Module gidModule = ModuleDSLKt.module$default(false, new Function1<Module, Unit>() { // from class: com.taptap.sdk.gid.di.GidModuleKt$gidModule$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Module module) {
            invoke2(module);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Module module) {
            Intrinsics.checkNotNullParameter(module, "$this$module");
            AnonymousClass1 anonymousClass1 = new Function2<Scope, ParametersHolder, GidService>() { // from class: com.taptap.sdk.gid.di.GidModuleKt$gidModule$1.1
                @Override // kotlin.jvm.functions.Function2
                public final GidService invoke(Scope single, ParametersHolder it) {
                    Intrinsics.checkNotNullParameter(single, "$this$single");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new GidServiceImpl();
                }
            };
            SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(GidService.class), null, anonymousClass1, Kind.Singleton, CollectionsKt.emptyList()));
            SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
            module.indexPrimaryType(singleInstanceFactory2);
            if (module.get_createdAtStart()) {
                module.prepareForCreationAtStart(singleInstanceFactory);
            }
            new KoinDefinition(module, singleInstanceFactory2);
        }
    }, 1, null);

    public static final Module getGidModule() {
        return gidModule;
    }
}
