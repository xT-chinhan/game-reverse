package com.taptap.sdk.compliance.widget.dialog;

import android.app.Dialog;
import android.app.DialogFragment;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: compiled from: BaseDialogFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016¨\u0006\u000b"}, d2 = {"Lcom/taptap/sdk/compliance/widget/dialog/BaseDialogFragment;", "Landroid/app/DialogFragment;", "()V", "adaptBlackScreenIssue", "", "adaptPaddingIssue", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onStart", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class BaseDialogFragment extends DialogFragment {
    @Override // android.app.DialogFragment, android.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        Object objM534constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            BaseDialogFragment baseDialogFragment = this;
            super.onActivityCreated(savedInstanceState);
            objM534constructorimpl = Result.m534constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM534constructorimpl = Result.m534constructorimpl(ResultKt.createFailure(th));
        }
        Throwable it = Result.m537exceptionOrNullimpl(objM534constructorimpl);
        if (it != null) {
            it.printStackTrace();
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        getDialog().setCancelable(false);
        getDialog().setCanceledOnTouchOutside(false);
        adaptPaddingIssue();
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        adaptBlackScreenIssue();
    }

    private final void adaptPaddingIssue() {
        Window window;
        View decorView;
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        decorView.setPadding(0, 0, 0, 0);
    }

    private final void adaptBlackScreenIssue() {
        if (getActivity() != null && !getActivity().isFinishing()) {
            getActivity().onWindowFocusChanged(true);
        }
    }
}
