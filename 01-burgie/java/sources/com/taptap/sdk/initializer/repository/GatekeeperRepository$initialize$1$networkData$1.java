package com.taptap.sdk.initializer.repository;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.initializer.data.request.GateKeeperRequest;
import com.taptap.sdk.initializer.data.response.GateKeeper;
import com.taptap.sdk.initializer.repository.remote.GatekeeperApiService;
import com.taptap.sdk.kit.internal.utils.TapSignKit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: GatekeeperRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/taptap/sdk/initializer/data/response/GateKeeper;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.taptap.sdk.initializer.repository.GatekeeperRepository$initialize$1$networkData$1", f = "GatekeeperRepository.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_GET_CONTAINER_FPS}, m = "invokeSuspend", n = {}, s = {})
final class GatekeeperRepository$initialize$1$networkData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super GateKeeper>, Object> {
    int label;
    final /* synthetic */ GatekeeperRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GatekeeperRepository$initialize$1$networkData$1(GatekeeperRepository gatekeeperRepository, Continuation<? super GatekeeperRepository$initialize$1$networkData$1> continuation) {
        super(2, continuation);
        this.this$0 = gatekeeperRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GatekeeperRepository$initialize$1$networkData$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super GateKeeper> continuation) {
        return ((GatekeeperRepository$initialize$1$networkData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                GatekeeperApiService gatekeeperApiService = this.this$0.apiService;
                String packageName = this.this$0.context.getPackageName();
                Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
                this.label = 1;
                Object objFetchGatekeeper = gatekeeperApiService.fetchGatekeeper(new GateKeeperRequest("android", packageName, TapSignKit.INSTANCE.getSign(this.this$0.context)), this);
                return objFetchGatekeeper == coroutine_suspended ? coroutine_suspended : objFetchGatekeeper;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
