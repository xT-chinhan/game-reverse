package com.taptap.sdk.compliance.widget;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.taptap.sdk.compliance.R;
import com.taptap.sdk.compliance.extensions.SystemExtKt;
import com.taptap.sdk.compliance.widget.dialog.ComplianceLoadingDialog;
import com.umeng.analytics.pro.g;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: ComplianceUIHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/taptap/sdk/compliance/widget/ComplianceUIHelper;", "", "()V", "loadingDialog", "Lcom/taptap/sdk/compliance/widget/dialog/ComplianceLoadingDialog;", "dismissLoading", "Lkotlinx/coroutines/Job;", "showLoading", TTDownloadField.TT_ACTIVITY, "Landroid/app/Activity;", "duration", "", "showToast", g.X, "Landroid/content/Context;", "res", "", "message", "", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ComplianceUIHelper {
    public static final ComplianceUIHelper INSTANCE = new ComplianceUIHelper();
    private static ComplianceLoadingDialog loadingDialog;

    private ComplianceUIHelper() {
    }

    /* JADX INFO: renamed from: com.taptap.sdk.compliance.widget.ComplianceUIHelper$showLoading$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ComplianceUIHelper.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.compliance.widget.ComplianceUIHelper$showLoading$1", f = "ComplianceUIHelper.kt", i = {}, l = {31}, m = "invokeSuspend", n = {}, s = {})
    static final class C08011 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ long $duration;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08011(long j, Activity activity, Continuation<? super C08011> continuation) {
            super(1, continuation);
            this.$duration = j;
            this.$activity = activity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C08011(this.$duration, this.$activity, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C08011) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objM174constructorimpl;
            Unit unit;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ComplianceLoadingDialog complianceLoadingDialog = ComplianceUIHelper.loadingDialog;
                if (complianceLoadingDialog != null) {
                    complianceLoadingDialog.dismissAllowingStateLoss();
                }
                ComplianceUIHelper complianceUIHelper = ComplianceUIHelper.INSTANCE;
                ComplianceUIHelper.loadingDialog = new ComplianceLoadingDialog();
                ComplianceUIHelper complianceUIHelper2 = ComplianceUIHelper.INSTANCE;
                Activity activity = this.$activity;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    ComplianceLoadingDialog complianceLoadingDialog2 = ComplianceUIHelper.loadingDialog;
                    if (complianceLoadingDialog2 != null) {
                        complianceLoadingDialog2.show(activity.getFragmentManager(), "ComplianceLoadingDialog");
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    objM174constructorimpl = Result.m174constructorimpl(unit);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM174constructorimpl = Result.m174constructorimpl(ResultKt.createFailure(th));
                }
                Throwable thM177exceptionOrNullimpl = Result.m177exceptionOrNullimpl(objM174constructorimpl);
                if (thM177exceptionOrNullimpl != null) {
                    thM177exceptionOrNullimpl.printStackTrace();
                }
                this.label = 1;
                if (DelayKt.delay(this.$duration, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ComplianceUIHelper.INSTANCE.dismissLoading();
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ Job showLoading$default(ComplianceUIHelper complianceUIHelper, Activity activity, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 15000;
        }
        return complianceUIHelper.showLoading(activity, j);
    }

    public final Job showLoading(Activity activity, long duration) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return SystemExtKt.runOnMain(new C08011(duration, activity, null));
    }

    /* JADX INFO: renamed from: com.taptap.sdk.compliance.widget.ComplianceUIHelper$dismissLoading$1, reason: invalid class name */
    /* JADX INFO: compiled from: ComplianceUIHelper.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.compliance.widget.ComplianceUIHelper$dismissLoading$1", f = "ComplianceUIHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objM174constructorimpl;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ComplianceUIHelper complianceUIHelper = ComplianceUIHelper.INSTANCE;
            try {
                Result.Companion companion = Result.INSTANCE;
                ComplianceLoadingDialog complianceLoadingDialog = ComplianceUIHelper.loadingDialog;
                if (complianceLoadingDialog != null) {
                    complianceLoadingDialog.dismissAllowingStateLoss();
                }
                ComplianceUIHelper.loadingDialog = null;
                objM174constructorimpl = Result.m174constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM174constructorimpl = Result.m174constructorimpl(ResultKt.createFailure(th));
            }
            Throwable thM177exceptionOrNullimpl = Result.m177exceptionOrNullimpl(objM174constructorimpl);
            if (thM177exceptionOrNullimpl != null) {
                thM177exceptionOrNullimpl.printStackTrace();
            }
            return Unit.INSTANCE;
        }
    }

    public final Job dismissLoading() {
        return SystemExtKt.runOnMain(new AnonymousClass1(null));
    }

    /* JADX INFO: renamed from: com.taptap.sdk.compliance.widget.ComplianceUIHelper$showToast$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ComplianceUIHelper.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.compliance.widget.ComplianceUIHelper$showToast$1", f = "ComplianceUIHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C08021 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ String $message;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08021(Context context, String str, Continuation<? super C08021> continuation) {
            super(1, continuation);
            this.$context = context;
            this.$message = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C08021(this.$context, this.$message, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C08021) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Toast toast = new Toast(this.$context);
            View viewInflate = LayoutInflater.from(this.$context).inflate(R.layout.compliance_view_toast_message, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "from(context).inflate(R.…view_toast_message, null)");
            View viewFindViewById = viewInflate.findViewById(R.id.tv_toast_message);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "customView.findViewById(R.id.tv_toast_message)");
            ((TextView) viewFindViewById).setText(this.$message);
            toast.setView(viewInflate);
            toast.setDuration(0);
            toast.setGravity(17, 0, 0);
            toast.show();
            return Unit.INSTANCE;
        }
    }

    public final Job showToast(Context context, String message) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(message, "message");
        return SystemExtKt.runOnMain(new C08021(context, message, null));
    }

    /* JADX INFO: renamed from: com.taptap.sdk.compliance.widget.ComplianceUIHelper$showToast$2, reason: invalid class name */
    /* JADX INFO: compiled from: ComplianceUIHelper.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.compliance.widget.ComplianceUIHelper$showToast$2", f = "ComplianceUIHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ int $res;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Context context, int i, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$context = context;
            this.$res = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass2(this.$context, this.$res, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Toast toast = new Toast(this.$context);
            View viewInflate = LayoutInflater.from(this.$context).inflate(R.layout.compliance_view_toast_message, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "from(context).inflate(R.…view_toast_message, null)");
            View viewFindViewById = viewInflate.findViewById(R.id.tv_toast_message);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "customView.findViewById(R.id.tv_toast_message)");
            ((TextView) viewFindViewById).setText(this.$context.getResources().getString(this.$res));
            toast.setView(viewInflate);
            toast.setDuration(0);
            toast.setGravity(17, 0, 0);
            toast.show();
            return Unit.INSTANCE;
        }
    }

    public final Job showToast(Context context, int res) {
        Intrinsics.checkNotNullParameter(context, "context");
        return SystemExtKt.runOnMain(new AnonymousClass2(context, res, null));
    }
}
