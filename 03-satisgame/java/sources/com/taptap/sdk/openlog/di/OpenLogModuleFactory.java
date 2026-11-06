package com.taptap.sdk.openlog.di;

import com.taptap.sdk.initializer.api.Initializers;
import com.taptap.sdk.initializer.api.ModuleFactory;
import com.taptap.sdk.initializer.api.ModuleInitializer;
import com.taptap.sdk.openlog.TapTapOpenlogSdk;
import com.taptap.sdk.openlog.api.OpenLogService;
import com.taptap.sdk.openlog.service.OpenLogServiceImpl;
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
import org.koin.core.qualifier.Qualifier;
import org.koin.core.qualifier.QualifierKt;
import org.koin.core.registry.ScopeRegistry;
import org.koin.core.scope.Scope;
import org.koin.dsl.ModuleDSLKt;

/* JADX INFO: compiled from: OpenLogModuleFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/taptap/sdk/openlog/di/OpenLogModuleFactory;", "Lcom/taptap/sdk/initializer/api/ModuleFactory;", "()V", "create", "Lorg/koin/core/module/Module;", "tap-openlog_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class OpenLogModuleFactory implements ModuleFactory {
    @Override // com.taptap.sdk.initializer.api.ModuleFactory
    public Module create() {
        return ModuleDSLKt.module$default(false, new Function1<Module, Unit>() { // from class: com.taptap.sdk.openlog.di.OpenLogModuleFactory.create.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Module module) {
                invoke2(module);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Module module) {
                Intrinsics.checkNotNullParameter(module, "$this$module");
                C04461 c04461 = new Function2<Scope, ParametersHolder, TapTapOpenlogSdk>() { // from class: com.taptap.sdk.openlog.di.OpenLogModuleFactory.create.1.1
                    @Override // kotlin.jvm.functions.Function2
                    public final TapTapOpenlogSdk invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new TapTapOpenlogSdk();
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(TapTapOpenlogSdk.class), null, c04461, Kind.Singleton, CollectionsKt.emptyList()));
                SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
                module.indexPrimaryType(singleInstanceFactory2);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory);
                }
                new KoinDefinition(module, singleInstanceFactory2);
                Qualifier qualifierNamed = QualifierKt.named(Initializers.OPENLOG);
                AnonymousClass2 anonymousClass2 = new Function2<Scope, ParametersHolder, ModuleInitializer>() { // from class: com.taptap.sdk.openlog.di.OpenLogModuleFactory.create.1.2
                    @Override // kotlin.jvm.functions.Function2
                    public final ModuleInitializer invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new OpenLogInitializer((TapTapOpenlogSdk) single.get(Reflection.getOrCreateKotlinClass(TapTapOpenlogSdk.class), null, null));
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory3 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(ModuleInitializer.class), qualifierNamed, anonymousClass2, Kind.Singleton, CollectionsKt.emptyList()));
                SingleInstanceFactory<?> singleInstanceFactory4 = singleInstanceFactory3;
                module.indexPrimaryType(singleInstanceFactory4);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory3);
                }
                new KoinDefinition(module, singleInstanceFactory4);
                AnonymousClass3 anonymousClass3 = new Function2<Scope, ParametersHolder, OpenLogService>() { // from class: com.taptap.sdk.openlog.di.OpenLogModuleFactory.create.1.3
                    @Override // kotlin.jvm.functions.Function2
                    public final OpenLogService invoke(Scope single, ParametersHolder it) {
                        Intrinsics.checkNotNullParameter(single, "$this$single");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new OpenLogServiceImpl((TapTapOpenlogSdk) single.get(Reflection.getOrCreateKotlinClass(TapTapOpenlogSdk.class), null, null));
                    }
                };
                SingleInstanceFactory<?> singleInstanceFactory5 = new SingleInstanceFactory<>(new BeanDefinition(ScopeRegistry.INSTANCE.getRootScopeQualifier(), Reflection.getOrCreateKotlinClass(OpenLogService.class), null, anonymousClass3, Kind.Singleton, CollectionsKt.emptyList()));
                SingleInstanceFactory<?> singleInstanceFactory6 = singleInstanceFactory5;
                module.indexPrimaryType(singleInstanceFactory6);
                if (module.get_createdAtStart()) {
                    module.prepareForCreationAtStart(singleInstanceFactory5);
                }
                new KoinDefinition(module, singleInstanceFactory6);
            }
        }, 1, null);
    }
}
