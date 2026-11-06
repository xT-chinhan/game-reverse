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
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.taptap.sdk.compliance.extensions.SystemExtKt;
import com.taptap.sdk.compliance.internal.TapComplianceLoggerKt;
import com.taptap.sdk.compliance.widget.ComplianceUIHelperKt;
import com.taptap.sdk.kit.internal.extensions.UIExtKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AbsDialogFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH&J\u0012\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0016J(\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0017\u001a\u00020\bH\u0016J\u001c\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001d"}, d2 = {"Lcom/taptap/sdk/compliance/widget/dialog/AbsDialogFragment;", "Lcom/taptap/sdk/compliance/widget/dialog/BaseDialogFragment;", "()V", "layoutResId", "", "getLayoutResId", "()I", "dismissAllowingStateLoss", "", "handleArgumentsData", "bundle", "Landroid/os/Bundle;", "initView", "view", "Landroid/view/View;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "show", "manager", "Landroid/app/FragmentManager;", TTDownloadField.TT_TAG, "", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class AbsDialogFragment extends BaseDialogFragment {
    public abstract int getLayoutResId();

    public abstract void handleArgumentsData(Bundle bundle);

    public abstract void initView(View view);

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Unit unit;
        View viewInflate;
        Window window;
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setFlags(16777216, 16777216);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            handleArgumentsData(arguments);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            dismissAllowingStateLoss();
            return null;
        }
        if (inflater == null || (viewInflate = inflater.inflate(getLayoutResId(), container, false)) == null) {
            return null;
        }
        initView(viewInflate);
        return viewInflate;
    }

    @Override // com.taptap.sdk.compliance.widget.dialog.BaseDialogFragment, android.app.DialogFragment, android.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (Build.VERSION.SDK_INT >= 28) {
            attributes.layoutInDisplayCutoutMode = 1;
            window.setAttributes(attributes);
        }
        window.getDecorView().setSystemUiVisibility(1024);
        int px = UIExtKt.toPx(335.0f);
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        attributes.width = Math.min(px, ComplianceUIHelperKt.getScreenWidth(activity));
        int px2 = UIExtKt.toPx(320.0f);
        Activity activity2 = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity2, "activity");
        attributes.height = Math.min(px2, ComplianceUIHelperKt.getScreenHeight(activity2));
        window.setAttributes(attributes);
        SystemExtKt.hideNavBar(window);
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        Window window = dialogOnCreateDialog.getWindow();
        if (window != null) {
            window.requestFeature(1);
        }
        Intrinsics.checkNotNullExpressionValue(dialogOnCreateDialog, "super.onCreateDialog(sav…ATURE_NO_TITLE)\n        }");
        return dialogOnCreateDialog;
    }

    @Override // android.app.DialogFragment
    public void dismissAllowingStateLoss() {
        Object objM174constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            AbsDialogFragment absDialogFragment = this;
            super.dismissAllowingStateLoss();
            objM174constructorimpl = Result.m174constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM174constructorimpl = Result.m174constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM177exceptionOrNullimpl = Result.m177exceptionOrNullimpl(objM174constructorimpl);
        if (thM177exceptionOrNullimpl != null) {
            TapComplianceLoggerKt.logError("dismissAllowingStateLoss with error", thM177exceptionOrNullimpl);
        }
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager manager, String tag) {
        Object objM174constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            AbsDialogFragment absDialogFragment = this;
            super.show(manager, tag);
            objM174constructorimpl = Result.m174constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM174constructorimpl = Result.m174constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM177exceptionOrNullimpl = Result.m177exceptionOrNullimpl(objM174constructorimpl);
        if (thM177exceptionOrNullimpl != null) {
            TapComplianceLoggerKt.logError("", thM177exceptionOrNullimpl);
        }
    }
}
