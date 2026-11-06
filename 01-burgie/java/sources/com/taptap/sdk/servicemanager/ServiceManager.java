package com.taptap.sdk.servicemanager;

import com.taptap.sdk.servicemanager.services.ServiceFactoryCollector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ServiceManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002J<\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\r0\u0007\"\b\b\u0000\u0010\r*\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u00052\u0014\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00050\u0007H\u0002J&\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\r0\u0007\"\b\b\u0000\u0010\r*\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u0005H\u0002R0\u0010\u0003\u001a$\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00050\u00070\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\b\u001a\u001c\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00070\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/taptap/sdk/servicemanager/ServiceManager;", "", "()V", "serviceClassCache", "", "Ljava/lang/Class;", "Lcom/taptap/sdk/servicemanager/ServiceManager$Service;", "", "serviceImplCache", "", "__inject", "", "getOrPutServiceImplSet", "T", "interfaceClass", "implClassSet", "getServiceByReflect", "Companion", "Service", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ServiceManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static volatile ServiceManager INSTANCE;
    private Map<Class<? extends Service>, ? extends Set<? extends Class<? extends Service>>> serviceClassCache;
    private Map<Class<? extends Service>, Set<Service>> serviceImplCache;

    /* JADX INFO: compiled from: ServiceManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/taptap/sdk/servicemanager/ServiceManager$Service;", "", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface Service {
    }

    public /* synthetic */ ServiceManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    private static final ServiceManager getInstance() {
        return INSTANCE.getInstance();
    }

    private ServiceManager() {
        this.serviceClassCache = new HashMap();
        this.serviceImplCache = new ConcurrentHashMap();
        __inject();
    }

    private final void __inject() {
        this.serviceClassCache = new ServiceFactoryCollector().collect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T extends Service> Set<T> getServiceByReflect(Class<T> interfaceClass) {
        Set<T> orPutServiceImplSet;
        Set<T> set = (Set) this.serviceImplCache.get(interfaceClass);
        if (set != null) {
            return set;
        }
        synchronized (this) {
            Set<? extends Class<? extends Service>> set2 = this.serviceClassCache.get(interfaceClass);
            if (set2 == null) {
                orPutServiceImplSet = SetsKt.emptySet();
            } else {
                orPutServiceImplSet = getOrPutServiceImplSet(interfaceClass, set2);
            }
        }
        return orPutServiceImplSet;
    }

    private static final <T extends Service> T getOrPutServiceImplSet$createServiceImplByReflect(Class<? extends Service> cls) {
        try {
            Service serviceNewInstance = cls.newInstance();
            if (serviceNewInstance instanceof Service) {
                return (T) serviceNewInstance;
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    private final <T extends Service> Set<T> getOrPutServiceImplSet(Class<T> interfaceClass, Set<? extends Class<? extends Service>> implClassSet) {
        Set<T> setEmptySet;
        Object answer$iv;
        try {
            Map $this$getOrPut$iv = this.serviceImplCache;
            Object value$iv = $this$getOrPut$iv.get(interfaceClass);
            if (value$iv == null) {
                Set<? extends Class<? extends Service>> $this$mapNotNull$iv = implClassSet;
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                    Class implClass = (Class) element$iv$iv$iv;
                    Service orPutServiceImplSet$createServiceImplByReflect = getOrPutServiceImplSet$createServiceImplByReflect(implClass);
                    if (orPutServiceImplSet$createServiceImplByReflect != null) {
                        destination$iv$iv.add(orPutServiceImplSet$createServiceImplByReflect);
                    }
                }
                answer$iv = CollectionsKt.toSet((List) destination$iv$iv);
                $this$getOrPut$iv.put(interfaceClass, answer$iv);
            } else {
                answer$iv = value$iv;
            }
            setEmptySet = (Set) answer$iv;
        } catch (Throwable th) {
            setEmptySet = SetsKt.emptySet();
        }
        Intrinsics.checkNotNull(setEmptySet, "null cannot be cast to non-null type kotlin.collections.Set<T of com.taptap.sdk.servicemanager.ServiceManager.getOrPutServiceImplSet>");
        return setEmptySet;
    }

    /* JADX INFO: compiled from: ServiceManager.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0003J%\u0010\u0006\u001a\u0004\u0018\u0001H\u0007\"\b\b\u0000\u0010\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n¢\u0006\u0002\u0010\u000bJ$\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00070\r\"\b\b\u0000\u0010\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\nR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/taptap/sdk/servicemanager/ServiceManager$Companion;", "", "()V", "INSTANCE", "Lcom/taptap/sdk/servicemanager/ServiceManager;", "getInstance", "getService", "T", "Lcom/taptap/sdk/servicemanager/ServiceManager$Service;", "interfaceClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/taptap/sdk/servicemanager/ServiceManager$Service;", "getServices", "", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final ServiceManager getInstance() {
            ServiceManager it;
            ServiceManager serviceManager = ServiceManager.INSTANCE;
            if (serviceManager == null) {
                synchronized (this) {
                    it = ServiceManager.INSTANCE;
                    if (it == null) {
                        it = new ServiceManager(null);
                        Companion companion = ServiceManager.INSTANCE;
                        ServiceManager.INSTANCE = it;
                    }
                }
                return it;
            }
            return serviceManager;
        }

        public final <T extends Service> T getService(Class<T> interfaceClass) {
            Intrinsics.checkNotNullParameter(interfaceClass, "interfaceClass");
            return (T) CollectionsKt.firstOrNull(getServices(interfaceClass));
        }

        public final <T extends Service> Set<T> getServices(Class<T> interfaceClass) {
            Intrinsics.checkNotNullParameter(interfaceClass, "interfaceClass");
            Set<T> serviceByReflect = getInstance().getServiceByReflect(interfaceClass);
            Intrinsics.checkNotNull(serviceByReflect, "null cannot be cast to non-null type kotlin.collections.Set<T of com.taptap.sdk.servicemanager.ServiceManager.Companion.getServices>");
            return serviceByReflect;
        }
    }
}
