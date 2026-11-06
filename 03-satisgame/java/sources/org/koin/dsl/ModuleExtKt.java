package org.koin.dsl;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.annotation.KoinReflectAPI;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Kind;
import org.koin.core.definition.KoinDefinition;
import org.koin.core.instance.FactoryInstanceFactory;
import org.koin.core.instance.InstanceBuilderKt;
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.module.Module;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.qualifier.StringQualifier;
import org.koin.core.registry.ScopeRegistry;
import org.koin.core.scope.Scope;

/* JADX INFO: compiled from: ModuleExt.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a+\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0087\b\u001a5\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\tH\u0087\b¨\u0006\n"}, d2 = {"factory", "Lorg/koin/core/definition/KoinDefinition;", "T", "", "Lorg/koin/core/module/Module;", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "single", "createOnStart", "", "koin-core"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ModuleExtKt {
    public static /* synthetic */ KoinDefinition single$default(Module module, Qualifier qualifier, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        Qualifier qualifier2 = qualifier;
        if ((i & 2) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.needClassReification();
        C06571 c06571 = C06571.INSTANCE;
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "T");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier2, c06571, kind, listEmptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (z || module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return new KoinDefinition(module, singleInstanceFactory2);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: org.koin.dsl.ModuleExtKt$single$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ModuleExt.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "T", "", "Lorg/koin/core/scope/Scope;", "params", "Lorg/koin/core/parameter/ParametersHolder;", "invoke", "(Lorg/koin/core/scope/Scope;Lorg/koin/core/parameter/ParametersHolder;)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HURRY_THRESHOLD)
    public static final class C06571<T> extends Lambda implements Function2<Scope, ParametersHolder, T> {
        public static final C06571 INSTANCE = new C06571();

        public C06571() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public final T invoke(Scope single, ParametersHolder params) {
            Intrinsics.checkNotNullParameter(single, "$this$single");
            Intrinsics.checkNotNullParameter(params, "params");
            Intrinsics.reifiedOperationMarker(4, "T");
            return (T) InstanceBuilderKt.newInstance(single, Reflection.getOrCreateKotlinClass(Object.class), params);
        }
    }

    @Deprecated(message = "API is deprecated in favor of singleOf DSL")
    @KoinReflectAPI
    public static final /* synthetic */ <T> KoinDefinition<T> single(Module module, Qualifier qualifier, boolean z) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.needClassReification();
        C06571 c06571 = C06571.INSTANCE;
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "T");
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, c06571, kind, listEmptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (z || module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return new KoinDefinition<>(module, singleInstanceFactory2);
    }

    public static /* synthetic */ KoinDefinition factory$default(Module module, Qualifier qualifier, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.needClassReification();
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Factory;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "T");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, anonymousClass1, kind, listEmptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return new KoinDefinition(module, factoryInstanceFactory);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: org.koin.dsl.ModuleExtKt$factory$1, reason: invalid class name */
    /* JADX INFO: compiled from: ModuleExt.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "T", "", "Lorg/koin/core/scope/Scope;", "params", "Lorg/koin/core/parameter/ParametersHolder;", "invoke", "(Lorg/koin/core/scope/Scope;Lorg/koin/core/parameter/ParametersHolder;)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HURRY_THRESHOLD)
    public static final class AnonymousClass1<T> extends Lambda implements Function2<Scope, ParametersHolder, T> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public final T invoke(Scope factory, ParametersHolder params) {
            Intrinsics.checkNotNullParameter(factory, "$this$factory");
            Intrinsics.checkNotNullParameter(params, "params");
            Intrinsics.reifiedOperationMarker(4, "T");
            return (T) InstanceBuilderKt.newInstance(factory, Reflection.getOrCreateKotlinClass(Object.class), params);
        }
    }

    @Deprecated(message = "API is deprecated in favor of factoryOf DSL")
    @KoinReflectAPI
    public static final /* synthetic */ <T> KoinDefinition<T> factory(Module module, Qualifier qualifier) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.needClassReification();
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Factory;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "T");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, anonymousClass1, kind, listEmptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return new KoinDefinition<>(module, factoryInstanceFactory);
    }
}
