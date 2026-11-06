package com.taptap.sdk.compliance.widget.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.taptap.sdk.compliance.R;
import com.taptap.sdk.compliance.extensions.SystemExtKt;
import com.taptap.sdk.compliance.internal.TapComplianceLoggerKt;
import com.taptap.sdk.kit.internal.extensions.UIExtKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ComplianceLoadingDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J(\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\u001c\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/taptap/sdk/compliance/widget/dialog/ComplianceLoadingDialog;", "Lcom/taptap/sdk/compliance/widget/dialog/BaseDialogFragment;", "()V", "mAnimation", "Landroid/view/animation/Animation;", "dismiss", "", "dismissAllowingStateLoss", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "onViewCreated", "view", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ComplianceLoadingDialog extends BaseDialogFragment {
    private Animation mAnimation;

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        Window window;
        super.onCreate(savedInstanceState);
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setFlags(1024, 1024);
        window.getDecorView().setPadding(0, 0, 0, 0);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (inflater != null) {
            return inflater.inflate(R.layout.compliance_loading_dialog, container, false);
        }
        return null;
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

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (view == null) {
            return;
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_toast_loading);
        UIExtKt.visible((FrameLayout) view.findViewById(R.id.fl_toast_loading));
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.compliance_anim_loading);
        this.mAnimation = animationLoadAnimation;
        if (animationLoadAnimation != null) {
            animationLoadAnimation.setInterpolator(new LinearInterpolator());
        }
        imageView.setImageResource(R.drawable.compliance_loading);
        imageView.startAnimation(this.mAnimation);
    }

    @Override // com.taptap.sdk.compliance.widget.dialog.BaseDialogFragment, android.app.DialogFragment, android.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            SystemExtKt.fixHoloThemeIssue(dialog);
        }
        Window window = getDialog().getWindow();
        if (window != null) {
            window.clearFlags(2);
        }
        Window window2 = getDialog().getWindow();
        if (window2 != null) {
            window2.setBackgroundDrawable(new ColorDrawable(0));
        }
        getDialog().setCancelable(false);
        getDialog().setCanceledOnTouchOutside(false);
        Window window3 = getDialog().getWindow();
        WindowManager.LayoutParams attributes = window3 != null ? window3.getAttributes() : null;
        if (attributes != null) {
            attributes.width = -1;
        }
        if (attributes != null) {
            attributes.height = -1;
        }
        Window window4 = getDialog().getWindow();
        Intrinsics.checkNotNull(window4);
        window4.setBackgroundDrawable(new ColorDrawable(0));
        if (getDialog() != null && getDialog().getWindow() != null) {
            Window window5 = getDialog().getWindow();
            View decorView = window5 != null ? window5.getDecorView() : null;
            if (Build.VERSION.SDK_INT >= 28) {
                if (attributes != null) {
                    attributes.layoutInDisplayCutoutMode = 1;
                }
                if (window5 != null) {
                    window5.setAttributes(attributes);
                }
            }
            if (decorView != null) {
                decorView.setSystemUiVisibility(1024);
            }
        }
        Window window6 = getDialog().getWindow();
        if (window6 != null) {
            window6.setAttributes(attributes);
        }
        Window window7 = getDialog().getWindow();
        if (window7 != null) {
            window7.setFlags(1024, 1024);
        }
    }

    @Override // android.app.DialogFragment
    public void dismiss() {
        Object objM174constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            ComplianceLoadingDialog complianceLoadingDialog = this;
            super.dismiss();
            Animation animation = this.mAnimation;
            if (animation != null) {
                animation.cancel();
            }
            this.mAnimation = null;
            objM174constructorimpl = Result.m174constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM174constructorimpl = Result.m174constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM177exceptionOrNullimpl = Result.m177exceptionOrNullimpl(objM174constructorimpl);
        if (thM177exceptionOrNullimpl != null) {
            String message = thM177exceptionOrNullimpl.getMessage();
            if (message == null) {
                message = "";
            }
            TapComplianceLoggerKt.logError(message, thM177exceptionOrNullimpl);
        }
    }

    @Override // android.app.DialogFragment
    public void dismissAllowingStateLoss() {
        Object objM174constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            ComplianceLoadingDialog complianceLoadingDialog = this;
            super.dismissAllowingStateLoss();
            Animation animation = this.mAnimation;
            if (animation != null) {
                animation.cancel();
            }
            this.mAnimation = null;
            objM174constructorimpl = Result.m174constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM174constructorimpl = Result.m174constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM177exceptionOrNullimpl = Result.m177exceptionOrNullimpl(objM174constructorimpl);
        if (thM177exceptionOrNullimpl != null) {
            String message = thM177exceptionOrNullimpl.getMessage();
            if (message == null) {
                message = "";
            }
            TapComplianceLoggerKt.logError(message, thM177exceptionOrNullimpl);
        }
    }
}
