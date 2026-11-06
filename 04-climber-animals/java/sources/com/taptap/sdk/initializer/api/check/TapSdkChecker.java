package com.taptap.sdk.initializer.api.check;

import com.taptap.sdk.initializer.api.service.InitializerService;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.extensions.SysExtKt;
import com.taptap.sdk.kit.internal.p000const.SdkModules;
import com.taptap.sdk.servicemanager.ServiceManager;
import com.taptap.sdk.servicemanager.utils.ServiceManagerComponent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TapSdkChecker.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nJ\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eR\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/taptap/sdk/initializer/api/check/TapSdkChecker;", "", "()V", "initializeService", "Lcom/taptap/sdk/initializer/api/service/InitializerService;", "getInitializeService", "()Lcom/taptap/sdk/initializer/api/service/InitializerService;", "initializeService$delegate", "Lkotlin/Lazy;", "checkInitialize", "", "showNotice", "checkModule", "moduleName", "", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapSdkChecker {
    public static final TapSdkChecker INSTANCE = new TapSdkChecker();

    /* JADX INFO: renamed from: initializeService$delegate, reason: from kotlin metadata */
    private static final Lazy initializeService;

    private TapSdkChecker() {
    }

    static {
        ServiceManagerComponent serviceManagerComponent = ServiceManagerComponent.INSTANCE;
        initializeService = LazyKt.lazy(new Function0<InitializerService>() { // from class: com.taptap.sdk.initializer.api.check.TapSdkChecker$special$$inlined$injectOrNull$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v1, types: [com.taptap.sdk.initializer.api.service.InitializerService, com.taptap.sdk.servicemanager.ServiceManager$Service] */
            @Override // kotlin.jvm.functions.Function0
            public final InitializerService invoke() {
                return ServiceManager.INSTANCE.getService(InitializerService.class);
            }
        });
    }

    private final InitializerService getInitializeService() {
        return (InitializerService) initializeService.getValue();
    }

    public static /* synthetic */ boolean checkInitialize$default(TapSdkChecker tapSdkChecker, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return tapSdkChecker.checkInitialize(z);
    }

    public final boolean checkInitialize(boolean showNotice) {
        InitializerService initializeService2 = getInitializeService();
        if (initializeService2 == null) {
            SysExtKt.showToast("当前应用还未初始化");
            TapLogger.loge$default("TapInitializer", "当前应用还未初始化: 请在调用 SDK 业务接口前，先调用 [TapTapSDK.init()] 接口", null, 4, null);
            return false;
        }
        return initializeService2.checkInitialize(showNotice);
    }

    public final boolean checkModule(String moduleName) {
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        String buildClz = SdkModules.INSTANCE.getBuildClz(moduleName);
        try {
            Class.forName(buildClz);
            return true;
        } catch (Throwable unused) {
            TapLogger.loge$default("ModuleCheck", "模块" + moduleName + " 未找到, class=" + buildClz, null, 4, null);
            return false;
        }
    }
}
