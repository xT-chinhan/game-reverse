package com.taptap.sdk.kit.internal.http.call;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: ITapHttpCall.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.taptap.sdk.kit.internal.http.call.ITapHttpCall$DefaultImpls", f = "ITapHttpCall.kt", i = {}, l = {19}, m = "enqueueResult-gIAlu-s", n = {}, s = {})
final class ITapHttpCall$enqueueResult$1<DataBean> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    ITapHttpCall$enqueueResult$1(Continuation<? super ITapHttpCall$enqueueResult$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM75enqueueResultgIAlus = ITapHttpCall.DefaultImpls.m75enqueueResultgIAlus(null, 0L, this);
        return objM75enqueueResultgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM75enqueueResultgIAlus : Result.m183boximpl(objM75enqueueResultgIAlus);
    }
}
