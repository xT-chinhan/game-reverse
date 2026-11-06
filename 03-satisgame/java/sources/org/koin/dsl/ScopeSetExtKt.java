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
import org.koin.core.instance.ScopedInstanceFactory;
import org.koin.core.module.Module;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* JADX INFO: compiled from: ScopeSetExt.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a+\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0087\b\u001a+\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0087\b¨\u0006\b"}, d2 = {"factory", "Lorg/koin/core/definition/KoinDefinition;", "R", "", "Lorg/koin/dsl/ScopeDSL;", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "scoped", "koin-core"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ScopeSetExtKt {
    public static /* synthetic */ KoinDefinition scoped$default(ScopeDSL scopeDSL, Qualifier qualifier, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.needClassReification();
        C06581 c06581 = C06581.INSTANCE;
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, c06581, kind, listEmptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return new KoinDefinition(scopeDSL.getModule(), scopedInstanceFactory);
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: org.koin.dsl.ScopeSetExtKt$scoped$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ScopeSetExt.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "R", "", "Lorg/koin/core/scope/Scope;", "params", "Lorg/koin/core/parameter/ParametersHolder;", "invoke", "(Lorg/koin/core/scope/Scope;Lorg/koin/core/parameter/ParametersHolder;)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HURRY_THRESHOLD)
    public static final class C06581<R> extends Lambda implements Function2<Scope, ParametersHolder, R> {
        public static final C06581 INSTANCE = new C06581();

        public C06581() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public final R invoke(Scope scoped, ParametersHolder params) {
            Intrinsics.checkNotNullParameter(scoped, "$this$scoped");
            Intrinsics.checkNotNullParameter(params, "params");
            Intrinsics.reifiedOperationMarker(4, "R");
            return (R) InstanceBuilderKt.newInstance(scoped, Reflection.getOrCreateKotlinClass(Object.class), params);
        }
    }

    @Deprecated(message = "API is deprecated in favor of scopedOf DSL")
    @KoinReflectAPI
    public static final /* synthetic */ <R> KoinDefinition<R> scoped(ScopeDSL scopeDSL, Qualifier qualifier) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.needClassReification();
        C06581 c06581 = C06581.INSTANCE;
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, c06581, kind, listEmptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return new KoinDefinition<>(scopeDSL.getModule(), scopedInstanceFactory);
    }

    public static /* synthetic */ KoinDefinition factory$default(ScopeDSL scopeDSL, Qualifier qualifier, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        Qualifier qualifier2 = qualifier;
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.needClassReification();
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier2, anonymousClass1, kind, listEmptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return new KoinDefinition(module, factoryInstanceFactory);
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: org.koin.dsl.ScopeSetExtKt$factory$1, reason: invalid class name */
    /* JADX INFO: compiled from: ScopeSetExt.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "R", "", "Lorg/koin/core/scope/Scope;", "params", "Lorg/koin/core/parameter/ParametersHolder;", "invoke", "(Lorg/koin/core/scope/Scope;Lorg/koin/core/parameter/ParametersHolder;)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HURRY_THRESHOLD)
    public static final class AnonymousClass1<R> extends Lambda implements Function2<Scope, ParametersHolder, R> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public final R invoke(Scope factory, ParametersHolder params) {
            Intrinsics.checkNotNullParameter(factory, "$this$factory");
            Intrinsics.checkNotNullParameter(params, "params");
            Intrinsics.reifiedOperationMarker(4, "R");
            return (R) InstanceBuilderKt.newInstance(factory, Reflection.getOrCreateKotlinClass(Object.class), params);
        }
    }

    @Deprecated(message = "API is deprecated in favor of factoryOf DSL")
    @KoinReflectAPI
    public static final /* synthetic */ <R> KoinDefinition<R> factory(ScopeDSL scopeDSL, Qualifier qualifier) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.needClassReification();
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, anonymousClass1, kind, listEmptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return new KoinDefinition<>(module, factoryInstanceFactory);
    }
}
