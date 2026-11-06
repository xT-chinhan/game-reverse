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
import com.tapsdk.tapad.internal.runtime.view.ContainerViewManager;
import com.taptap.sdk.compliance.R;
import com.taptap.sdk.compliance.extensions.SystemExtKt;
import com.taptap.sdk.kit.internal.TapLoggerKt;
import com.taptap.sdk.kit.internal.extensions.UIExtKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ComplianceLoadingDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J(\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\u001c\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/taptap/sdk/compliance/widget/dialog/ComplianceLoadingDialog;", "Lcom/taptap/sdk/compliance/widget/dialog/BaseDialogFragment;", "()V", "mAnimation", "Landroid/view/animation/Animation;", "dismiss", "", "dismissAllowingStateLoss", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", ContainerViewManager.NAME, "Landroid/view/ViewGroup;", "onStart", "onViewCreated", "view", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ComplianceLoadingDialog extends BaseDialogFragment {
    private Animation mAnimation;

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        Window it;
        super.onCreate(savedInstanceState);
        Dialog dialog = getDialog();
        if (dialog != null && (it = dialog.getWindow()) != null) {
            it.setFlags(1024, 1024);
            it.getDecorView().setPadding(0, 0, 0, 0);
        }
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
        Dialog $this$onCreateDialog_u24lambda_u241 = super.onCreateDialog(savedInstanceState);
        Window window = $this$onCreateDialog_u24lambda_u241.getWindow();
        if (window != null) {
            window.requestFeature(1);
        }
        Intrinsics.checkNotNullExpressionValue($this$onCreateDialog_u24lambda_u241, "super.onCreateDialog(sav…ATURE_NO_TITLE)\n        }");
        return $this$onCreateDialog_u24lambda_u241;
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (view == null) {
            return;
        }
        ImageView iv = (ImageView) view.findViewById(R.id.iv_toast_loading);
        FrameLayout fl = (FrameLayout) view.findViewById(R.id.fl_toast_loading);
        UIExtKt.visible(fl);
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.compliance_anim_loading);
        this.mAnimation = animationLoadAnimation;
        if (animationLoadAnimation != null) {
            animationLoadAnimation.setInterpolator(new LinearInterpolator());
        }
        iv.setImageResource(R.drawable.compliance_loading);
        iv.startAnimation(this.mAnimation);
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
        WindowManager.LayoutParams lp = window3 != null ? window3.getAttributes() : null;
        if (lp != null) {
            lp.width = -1;
        }
        if (lp != null) {
            lp.height = -1;
        }
        Window window4 = getDialog().getWindow();
        Intrinsics.checkNotNull(window4);
        window4.setBackgroundDrawable(new ColorDrawable(0));
        if (getDialog() != null && getDialog().getWindow() != null) {
            Window window5 = getDialog().getWindow();
            View decorView = window5 != null ? window5.getDecorView() : null;
            if (Build.VERSION.SDK_INT >= 28) {
                if (lp != null) {
                    lp.layoutInDisplayCutoutMode = 1;
                }
                if (window5 != null) {
                    window5.setAttributes(lp);
                }
            }
            if (decorView != null) {
                decorView.setSystemUiVisibility(1024);
            }
        }
        Window window6 = getDialog().getWindow();
        if (window6 != null) {
            window6.setAttributes(lp);
        }
        Window window7 = getDialog().getWindow();
        if (window7 != null) {
            window7.setFlags(1024, 1024);
        }
    }

    @Override // android.app.DialogFragment
    public void dismiss() {
        Object objM534constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            ComplianceLoadingDialog $this$dismiss_u24lambda_u242 = this;
            super.dismiss();
            Animation animation = $this$dismiss_u24lambda_u242.mAnimation;
            if (animation != null) {
                animation.cancel();
            }
            $this$dismiss_u24lambda_u242.mAnimation = null;
            objM534constructorimpl = Result.m534constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM534constructorimpl = Result.m534constructorimpl(ResultKt.createFailure(th));
        }
        Throwable it = Result.m537exceptionOrNullimpl(objM534constructorimpl);
        if (it != null) {
            String message = it.getMessage();
            if (message == null) {
                message = "";
            }
            TapLoggerKt.logError(message, it);
        }
    }

    @Override // android.app.DialogFragment
    public void dismissAllowingStateLoss() {
        Object objM534constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            ComplianceLoadingDialog $this$dismissAllowingStateLoss_u24lambda_u244 = this;
            super.dismissAllowingStateLoss();
            Animation animation = $this$dismissAllowingStateLoss_u24lambda_u244.mAnimation;
            if (animation != null) {
                animation.cancel();
            }
            $this$dismissAllowingStateLoss_u24lambda_u244.mAnimation = null;
            objM534constructorimpl = Result.m534constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM534constructorimpl = Result.m534constructorimpl(ResultKt.createFailure(th));
        }
        Throwable it = Result.m537exceptionOrNullimpl(objM534constructorimpl);
        if (it != null) {
            String message = it.getMessage();
            if (message == null) {
                message = "";
            }
            TapLoggerKt.logError(message, it);
        }
    }
}
