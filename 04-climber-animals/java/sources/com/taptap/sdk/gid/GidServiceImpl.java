package com.taptap.sdk.gid;

import com.taptap.sdk.common.services.GidService;
import com.taptap.sdk.gid.data.response.Gid;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: GidServiceImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0013\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lcom/taptap/sdk/gid/GidServiceImpl;", "Lcom/taptap/sdk/common/services/GidService;", "()V", "getCurrentGid", "", "getCurrentTdid", "getGid", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTdid", "tap-gid_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class GidServiceImpl implements GidService {

    /* JADX INFO: renamed from: com.taptap.sdk.gid.GidServiceImpl$getGid$1, reason: invalid class name */
    /* JADX INFO: compiled from: GidServiceImpl.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.gid.GidServiceImpl", f = "GidServiceImpl.kt", i = {}, l = {27}, m = "getGid", n = {}, s = {})
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
        TapSdkGid iNSTANCE$tap_gid_release = TapSdkGid.INSTANCE.getINSTANCE$tap_gid_release();
        if (iNSTANCE$tap_gid_release == null || (currentGid = iNSTANCE$tap_gid_release.getCurrentGid()) == null) {
            return null;
        }
        return currentGid.getId();
    }

    @Override // com.taptap.sdk.common.services.GidService
    public String getCurrentTdid() {
        TapSdkGid iNSTANCE$tap_gid_release = TapSdkGid.INSTANCE.getINSTANCE$tap_gid_release();
        if (iNSTANCE$tap_gid_release != null) {
            return iNSTANCE$tap_gid_release.getCurrentTdid();
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.taptap.sdk.common.services.GidService
    public Object getGid(Continuation<? super String> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
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
        Object gid = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(gid);
            TapSdkGid iNSTANCE$tap_gid_release = TapSdkGid.INSTANCE.getINSTANCE$tap_gid_release();
            if (iNSTANCE$tap_gid_release != null) {
                anonymousClass1.label = 1;
                gid = iNSTANCE$tap_gid_release.getGid(anonymousClass1);
                if (gid == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return null;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(gid);
        Gid gid2 = (Gid) gid;
        if (gid2 != null) {
            return gid2.getId();
        }
        return null;
    }

    @Override // com.taptap.sdk.common.services.GidService
    public Object getTdid(Continuation<? super String> continuation) {
        TapSdkGid iNSTANCE$tap_gid_release = TapSdkGid.INSTANCE.getINSTANCE$tap_gid_release();
        if (iNSTANCE$tap_gid_release != null) {
            return iNSTANCE$tap_gid_release.getTdid(continuation);
        }
        return null;
    }
}
