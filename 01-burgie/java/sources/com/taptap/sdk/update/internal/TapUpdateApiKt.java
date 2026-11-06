package com.taptap.sdk.update.internal;

import com.taptap.sdk.common.network.NetworkClientKt;
import com.taptap.sdk.kit.internal.TapSDKHost;
import com.taptap.sdk.update.network.UpdateApiService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: TapUpdateApi.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u001a\b\u0010\u000e\u001a\u00020\u000fH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"#\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\"\u001b\u0010\t\u001a\u00020\n8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"INVALID_VERSION_CODE", "", "updateApi", "Lcom/taptap/sdk/update/network/UpdateApiService;", "kotlin.jvm.PlatformType", "getUpdateApi", "()Lcom/taptap/sdk/update/network/UpdateApiService;", "updateApi$delegate", "Lkotlin/Lazy;", "updateScope", "Lkotlinx/coroutines/CoroutineScope;", "getUpdateScope", "()Lkotlinx/coroutines/CoroutineScope;", "updateScope$delegate", "getHost", "", "tap-update_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class TapUpdateApiKt {
    public static final int INVALID_VERSION_CODE = -1;
    private static final Lazy updateScope$delegate = LazyKt.lazy(TapUpdateApiKt$updateScope$2.INSTANCE);
    private static final Lazy updateApi$delegate = LazyKt.lazy(new Function0<UpdateApiService>() { // from class: com.taptap.sdk.update.internal.TapUpdateApiKt$updateApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final UpdateApiService invoke() {
            return (UpdateApiService) NetworkClientKt.provideRetrofit$default("https://" + TapUpdateApiKt.getHost(), null, 2, null).create(UpdateApiService.class);
        }
    });

    public static final CoroutineScope getUpdateScope() {
        return (CoroutineScope) updateScope$delegate.getValue();
    }

    public static final String getHost() {
        return TapSDKHost.INSTANCE.getApiHost();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UpdateApiService getUpdateApi() {
        return (UpdateApiService) updateApi$delegate.getValue();
    }
}
