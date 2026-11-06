package com.taptap.sdk.compliance.widget.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.tapsdk.tapad.internal.runtime.view.ContainerViewManager;
import com.taptap.sdk.compliance.extensions.SystemExtKt;
import com.taptap.sdk.compliance.widget.ComplianceUIHelperKt;
import com.taptap.sdk.kit.internal.TapLoggerKt;
import com.taptap.sdk.kit.internal.extensions.UIExtKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AbsDialogFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH&J\u0012\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0016J(\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0017\u001a\u00020\bH\u0016J\u001c\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001d"}, d2 = {"Lcom/taptap/sdk/compliance/widget/dialog/AbsDialogFragment;", "Lcom/taptap/sdk/compliance/widget/dialog/BaseDialogFragment;", "()V", "layoutResId", "", "getLayoutResId", "()I", "dismissAllowingStateLoss", "", "handleArgumentsData", "bundle", "Landroid/os/Bundle;", "initView", "view", "Landroid/view/View;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", ContainerViewManager.NAME, "Landroid/view/ViewGroup;", "onStart", "show", "manager", "Landroid/app/FragmentManager;", "tag", "", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class AbsDialogFragment extends BaseDialogFragment {
    public abstract int getLayoutResId();

    public abstract void handleArgumentsData(Bundle bundle);

    public abstract void initView(View view);

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Unit unit;
        View $this$onCreateView_u24lambda_u242;
        Window window;
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setFlags(16777216, 16777216);
        }
        Bundle it = getArguments();
        if (it != null) {
            handleArgumentsData(it);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            AbsDialogFragment $this$onCreateView_u24lambda_u241 = this;
            $this$onCreateView_u24lambda_u241.dismissAllowingStateLoss();
            return null;
        }
        if (inflater == null || ($this$onCreateView_u24lambda_u242 = inflater.inflate(getLayoutResId(), container, false)) == null) {
            return null;
        }
        initView($this$onCreateView_u24lambda_u242);
        return $this$onCreateView_u24lambda_u242;
    }

    @Override // com.taptap.sdk.compliance.widget.dialog.BaseDialogFragment, android.app.DialogFragment, android.app.Fragment
    public void onStart() {
        Window it;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (it = dialog.getWindow()) != null) {
            WindowManager.LayoutParams params = it.getAttributes();
            if (Build.VERSION.SDK_INT >= 28) {
                params.layoutInDisplayCutoutMode = 1;
                it.setAttributes(params);
            }
            it.getDecorView().setSystemUiVisibility(1024);
            int px = UIExtKt.toPx(335.0f);
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            params.width = Math.min(px, ComplianceUIHelperKt.getScreenWidth(activity));
            int px2 = UIExtKt.toPx(320.0f);
            Activity activity2 = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity2, "activity");
            params.height = Math.min(px2, ComplianceUIHelperKt.getScreenHeight(activity2));
            it.setAttributes(params);
            SystemExtKt.hideNavBar(it);
        }
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog $this$onCreateDialog_u24lambda_u244 = super.onCreateDialog(savedInstanceState);
        Window window = $this$onCreateDialog_u24lambda_u244.getWindow();
        if (window != null) {
            window.requestFeature(1);
        }
        Intrinsics.checkNotNullExpressionValue($this$onCreateDialog_u24lambda_u244, "super.onCreateDialog(sav…ATURE_NO_TITLE)\n        }");
        return $this$onCreateDialog_u24lambda_u244;
    }

    @Override // android.app.DialogFragment
    public void dismissAllowingStateLoss() {
        Object objM534constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            AbsDialogFragment absDialogFragment = this;
            super.dismissAllowingStateLoss();
            objM534constructorimpl = Result.m534constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM534constructorimpl = Result.m534constructorimpl(ResultKt.createFailure(th));
        }
        Throwable it = Result.m537exceptionOrNullimpl(objM534constructorimpl);
        if (it != null) {
            TapLoggerKt.logError("dismissAllowingStateLoss with error", it);
        }
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager manager, String tag) {
        Object objM534constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            AbsDialogFragment absDialogFragment = this;
            super.show(manager, tag);
            objM534constructorimpl = Result.m534constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM534constructorimpl = Result.m534constructorimpl(ResultKt.createFailure(th));
        }
        Throwable it = Result.m537exceptionOrNullimpl(objM534constructorimpl);
        if (it != null) {
            TapLoggerKt.logError("", it);
        }
    }
}
