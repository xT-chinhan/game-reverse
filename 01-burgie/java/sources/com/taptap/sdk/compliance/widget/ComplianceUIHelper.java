package com.taptap.sdk.compliance.widget;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.byazt.ol.TTDownloadField;
import com.tapsdk.tapad.internal.ionia.IoniaAdWindowTracker;
import com.taptap.sdk.compliance.R;
import com.taptap.sdk.compliance.extensions.SystemExtKt;
import com.taptap.sdk.compliance.widget.dialog.ComplianceLoadingDialog;
import com.umeng.analytics.pro.d;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/taptap/sdk/compliance/widget/ComplianceUIHelper;", "", "()V", "loadingDialog", "Lcom/taptap/sdk/compliance/widget/dialog/ComplianceLoadingDialog;", "dismissLoading", "Lkotlinx/coroutines/Job;", "showLoading", TTDownloadField.TT_ACTIVITY, "Landroid/app/Activity;", "duration", "", "showToast", d.R, "Landroid/content/Context;", "res", "", "message", "", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ComplianceUIHelper {
    public static final ComplianceUIHelper INSTANCE = new ComplianceUIHelper();
    private static ComplianceLoadingDialog loadingDialog;

    private ComplianceUIHelper() {
    }

    /* JADX INFO: renamed from: com.taptap.sdk.compliance.widget.ComplianceUIHelper$showLoading$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ComplianceUIHelper.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.compliance.widget.ComplianceUIHelper$showLoading$1", f = "ComplianceUIHelper.kt", i = {}, l = {31}, m = "invokeSuspend", n = {}, s = {})
    static final class C03251 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ long $duration;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03251(long j, Activity activity, Continuation<? super C03251> continuation) {
            super(1, continuation);
            this.$duration = j;
            this.$activity = activity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C03251(this.$duration, this.$activity, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C03251) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            Object objM534constructorimpl;
            Unit unit;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
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
                        objM534constructorimpl = Result.m534constructorimpl(unit);
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        objM534constructorimpl = Result.m534constructorimpl(ResultKt.createFailure(th));
                    }
                    Throwable it = Result.m537exceptionOrNullimpl(objM534constructorimpl);
                    if (it != null) {
                        it.printStackTrace();
                    }
                    this.label = 1;
                    if (DelayKt.delay(this.$duration, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ComplianceUIHelper.INSTANCE.dismissLoading();
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ Job showLoading$default(ComplianceUIHelper complianceUIHelper, Activity activity, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = IoniaAdWindowTracker.BANNER_WINDOW_IDLE_TIMEOUT_MS;
        }
        return complianceUIHelper.showLoading(activity, j);
    }

    public final Job showLoading(Activity activity, long duration) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return SystemExtKt.runOnMain(new C03251(duration, activity, null));
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
            Object objM534constructorimpl;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    ComplianceUIHelper complianceUIHelper = ComplianceUIHelper.INSTANCE;
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        ComplianceLoadingDialog complianceLoadingDialog = ComplianceUIHelper.loadingDialog;
                        if (complianceLoadingDialog != null) {
                            complianceLoadingDialog.dismissAllowingStateLoss();
                        }
                        ComplianceUIHelper.loadingDialog = null;
                        objM534constructorimpl = Result.m534constructorimpl(Unit.INSTANCE);
                        break;
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        objM534constructorimpl = Result.m534constructorimpl(ResultKt.createFailure(th));
                    }
                    Throwable it = Result.m537exceptionOrNullimpl(objM534constructorimpl);
                    if (it != null) {
                        it.printStackTrace();
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Job dismissLoading() {
        return SystemExtKt.runOnMain(new AnonymousClass1(null));
    }

    /* JADX INFO: renamed from: com.taptap.sdk.compliance.widget.ComplianceUIHelper$showToast$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ComplianceUIHelper.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.compliance.widget.ComplianceUIHelper$showToast$1", f = "ComplianceUIHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03261 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ String $message;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03261(Context context, String str, Continuation<? super C03261> continuation) {
            super(1, continuation);
            this.$context = context;
            this.$message = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C03261(this.$context, this.$message, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C03261) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    Toast customToast = new Toast(this.$context);
                    View customView = LayoutInflater.from(this.$context).inflate(R.layout.compliance_view_toast_message, (ViewGroup) null);
                    Intrinsics.checkNotNullExpressionValue(customView, "from(context).inflate(R.…view_toast_message, null)");
                    View viewFindViewById = customView.findViewById(R.id.tv_toast_message);
                    Intrinsics.checkNotNullExpressionValue(viewFindViewById, "customView.findViewById(R.id.tv_toast_message)");
                    TextView tv = (TextView) viewFindViewById;
                    tv.setText(this.$message);
                    customToast.setView(customView);
                    customToast.setDuration(0);
                    customToast.setGravity(17, 0, 0);
                    customToast.show();
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Job showToast(Context context, String message) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(message, "message");
        return SystemExtKt.runOnMain(new C03261(context, message, null));
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
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    Toast customToast = new Toast(this.$context);
                    View customView = LayoutInflater.from(this.$context).inflate(R.layout.compliance_view_toast_message, (ViewGroup) null);
                    Intrinsics.checkNotNullExpressionValue(customView, "from(context).inflate(R.…view_toast_message, null)");
                    View viewFindViewById = customView.findViewById(R.id.tv_toast_message);
                    Intrinsics.checkNotNullExpressionValue(viewFindViewById, "customView.findViewById(R.id.tv_toast_message)");
                    TextView tv = (TextView) viewFindViewById;
                    tv.setText(this.$context.getResources().getString(this.$res));
                    customToast.setView(customView);
                    customToast.setDuration(0);
                    customToast.setGravity(17, 0, 0);
                    customToast.show();
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Job showToast(Context context, int res) {
        Intrinsics.checkNotNullParameter(context, "context");
        return SystemExtKt.runOnMain(new AnonymousClass2(context, res, null));
    }
}
