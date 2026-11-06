package com.taptap.sdk.gid;

import com.taptap.sdk.common.services.GidService;
import com.taptap.sdk.gid.data.response.Gid;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GidServiceImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0096@¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0096@¢\u0006\u0002\u0010\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000eH\u0016¨\u0006\u0011"}, d2 = {"Lcom/taptap/sdk/gid/GidServiceImpl;", "Lcom/taptap/sdk/common/services/GidService;", "()V", "getCurrentGid", "", "getCurrentTdid", "getGid", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTdid", "registerGidCallback", "", "callback", "Lcom/taptap/sdk/common/services/GidService$GidCallback;", "registerTdidCallback", "Lcom/taptap/sdk/common/services/GidService$TdidCallback;", "unregisterGidCallback", "unregisterTdidCallback", "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class GidServiceImpl implements GidService {

    /* JADX INFO: renamed from: com.taptap.sdk.gid.GidServiceImpl$getGid$1, reason: invalid class name */
    /* JADX INFO: compiled from: GidServiceImpl.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.gid.GidServiceImpl", f = "GidServiceImpl.kt", i = {}, l = {55}, m = "getGid", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GidServiceImpl.this.getGid(this);
        }
    }

    @Override // com.taptap.sdk.common.services.GidService
    public String getCurrentGid() {
        Gid currentGid;
        TapSdkGid iNSTANCE$tap_core_release = TapSdkGid.INSTANCE.getINSTANCE$tap_core_release();
        if (iNSTANCE$tap_core_release == null || (currentGid = iNSTANCE$tap_core_release.getCurrentGid()) == null) {
            return null;
        }
        return currentGid.getId();
    }

    @Override // com.taptap.sdk.common.services.GidService
    public String getCurrentTdid() {
        TapSdkGid iNSTANCE$tap_core_release = TapSdkGid.INSTANCE.getINSTANCE$tap_core_release();
        if (iNSTANCE$tap_core_release != null) {
            return iNSTANCE$tap_core_release.getCurrentTdid();
        }
        return null;
    }

    @Override // com.taptap.sdk.common.services.GidService
    public void registerTdidCallback(GidService.TdidCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        TapSdkGid iNSTANCE$tap_core_release = TapSdkGid.INSTANCE.getINSTANCE$tap_core_release();
        if (iNSTANCE$tap_core_release != null) {
            iNSTANCE$tap_core_release.registerTdidCallback(callback);
        }
    }

    @Override // com.taptap.sdk.common.services.GidService
    public void unregisterTdidCallback(GidService.TdidCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        TapSdkGid iNSTANCE$tap_core_release = TapSdkGid.INSTANCE.getINSTANCE$tap_core_release();
        if (iNSTANCE$tap_core_release != null) {
            iNSTANCE$tap_core_release.unregisterTdidCallback(callback);
        }
    }

    @Override // com.taptap.sdk.common.services.GidService
    public void registerGidCallback(GidService.GidCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        TapSdkGid iNSTANCE$tap_core_release = TapSdkGid.INSTANCE.getINSTANCE$tap_core_release();
        if (iNSTANCE$tap_core_release != null) {
            iNSTANCE$tap_core_release.registerGidCallback(callback);
        }
    }

    @Override // com.taptap.sdk.common.services.GidService
    public void unregisterGidCallback(GidService.GidCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        TapSdkGid iNSTANCE$tap_core_release = TapSdkGid.INSTANCE.getINSTANCE$tap_core_release();
        if (iNSTANCE$tap_core_release != null) {
            iNSTANCE$tap_core_release.unregisterGidCallback(callback);
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x004b  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.taptap.sdk.common.services.GidService
    public Object getGid(Continuation<? super String> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Object gid;
        Gid gid2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object $result = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (anonymousClass2.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                TapSdkGid iNSTANCE$tap_core_release = TapSdkGid.INSTANCE.getINSTANCE$tap_core_release();
                if (iNSTANCE$tap_core_release != null) {
                    anonymousClass2.label = 1;
                    gid = iNSTANCE$tap_core_release.getGid(anonymousClass2);
                    if (gid == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    gid2 = (Gid) gid;
                    if (gid2 != null) {
                        return gid2.getId();
                    }
                }
                return null;
            case 1:
                ResultKt.throwOnFailure($result);
                gid = $result;
                gid2 = (Gid) gid;
                if (gid2 != null) {
                    return gid2.getId();
                }
                return null;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.taptap.sdk.common.services.GidService
    public Object getTdid(Continuation<? super String> continuation) {
        TapSdkGid iNSTANCE$tap_core_release = TapSdkGid.INSTANCE.getINSTANCE$tap_core_release();
        if (iNSTANCE$tap_core_release != null) {
            return iNSTANCE$tap_core_release.getTdid(continuation);
        }
        return null;
    }
}
