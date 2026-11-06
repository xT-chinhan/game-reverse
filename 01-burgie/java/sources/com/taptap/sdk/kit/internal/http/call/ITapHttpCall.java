package com.taptap.sdk.kit.internal.http.call;

import com.tapsdk.tapad.group.constants.Constants;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: compiled from: ITapHttpCall.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J&\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\u0006J\u0017\u0010\n\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005H'¢\u0006\u0002\u0010\u000bJ%\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000b\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u000e"}, d2 = {"Lcom/taptap/sdk/kit/internal/http/call/ITapHttpCall;", "DataBean", "", "enqueue", Constants.DELAY_FIELD, "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enqueueResult", "Lkotlin/Result;", "enqueueResult-gIAlu-s", "execute", "(J)Ljava/lang/Object;", "executeResult", "executeResult-IoAF18A", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface ITapHttpCall<DataBean> {
    Object enqueue(long j, Continuation<? super DataBean> continuation);

    /* JADX INFO: renamed from: enqueueResult-gIAlu-s, reason: not valid java name */
    Object mo415enqueueResultgIAlus(long j, Continuation<? super Result<? extends DataBean>> continuation);

    DataBean execute(long delay);

    /* JADX INFO: renamed from: executeResult-IoAF18A, reason: not valid java name */
    Object mo416executeResultIoAF18A(long delay);

    /* JADX INFO: compiled from: ITapHttpCall.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object enqueue$default(ITapHttpCall iTapHttpCall, long j, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enqueue");
            }
            if ((i & 1) != 0) {
                j = -1;
            }
            return iTapHttpCall.enqueue(j, continuation);
        }

        public static /* synthetic */ Object execute$default(ITapHttpCall iTapHttpCall, long j, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: execute");
            }
            if ((i & 1) != 0) {
                j = -1;
            }
            return iTapHttpCall.execute(j);
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
        /* JADX INFO: renamed from: enqueueResult-gIAlu-s, reason: not valid java name */
        public static <DataBean> Object m417enqueueResultgIAlus(ITapHttpCall<DataBean> iTapHttpCall, long delay, Continuation<? super Result<? extends DataBean>> continuation) throws Throwable {
            ITapHttpCall$enqueueResult$1 iTapHttpCall$enqueueResult$1;
            Object objEnqueue;
            if (continuation instanceof ITapHttpCall$enqueueResult$1) {
                iTapHttpCall$enqueueResult$1 = (ITapHttpCall$enqueueResult$1) continuation;
                if ((iTapHttpCall$enqueueResult$1.label & Integer.MIN_VALUE) != 0) {
                    iTapHttpCall$enqueueResult$1.label -= Integer.MIN_VALUE;
                } else {
                    iTapHttpCall$enqueueResult$1 = new ITapHttpCall$enqueueResult$1(continuation);
                }
            } else {
                iTapHttpCall$enqueueResult$1 = new ITapHttpCall$enqueueResult$1(continuation);
            }
            ITapHttpCall$enqueueResult$1 iTapHttpCall$enqueueResult$2 = iTapHttpCall$enqueueResult$1;
            Object $result = iTapHttpCall$enqueueResult$2.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (iTapHttpCall$enqueueResult$2.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Result.Companion companion = Result.INSTANCE;
                        iTapHttpCall$enqueueResult$2.label = 1;
                        objEnqueue = iTapHttpCall.enqueue(delay, iTapHttpCall$enqueueResult$2);
                        if (objEnqueue == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        objEnqueue = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Result.m534constructorimpl(objEnqueue);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                return Result.m534constructorimpl(ResultKt.createFailure(th));
            }
        }

        /* JADX INFO: renamed from: enqueueResult-gIAlu-s$default, reason: not valid java name */
        public static /* synthetic */ Object m418enqueueResultgIAlus$default(ITapHttpCall iTapHttpCall, long j, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enqueueResult-gIAlu-s");
            }
            if ((i & 1) != 0) {
                j = -1;
            }
            return iTapHttpCall.mo415enqueueResultgIAlus(j, continuation);
        }

        /* JADX INFO: renamed from: executeResult-IoAF18A, reason: not valid java name */
        public static <DataBean> Object m419executeResultIoAF18A(ITapHttpCall<DataBean> iTapHttpCall, long delay) {
            try {
                Result.Companion companion = Result.INSTANCE;
                return Result.m534constructorimpl(iTapHttpCall.execute(delay));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                return Result.m534constructorimpl(ResultKt.createFailure(th));
            }
        }

        /* JADX INFO: renamed from: executeResult-IoAF18A$default, reason: not valid java name */
        public static /* synthetic */ Object m420executeResultIoAF18A$default(ITapHttpCall iTapHttpCall, long j, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: executeResult-IoAF18A");
            }
            if ((i & 1) != 0) {
                j = -1;
            }
            return iTapHttpCall.mo416executeResultIoAF18A(j);
        }
    }
}
