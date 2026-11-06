package com.taptap.sdk.update.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.taptap.sdk.update.R;
import com.taptap.sdk.update.utils.UIUtilKt;
import com.umeng.analytics.pro.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TapUpdateLoadingDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/taptap/sdk/update/dialog/TapUpdateLoadingDialog;", "Landroid/app/Dialog;", d.R, "Landroid/content/Context;", "(Landroid/content/Context;)V", "ivLoading", "Landroid/widget/ImageView;", "getIvLoading", "()Landroid/widget/ImageView;", "ivLoading$delegate", "Lkotlin/Lazy;", "loadingAnimation", "Landroid/view/animation/RotateAnimation;", "getLoadingAnimation", "()Landroid/view/animation/RotateAnimation;", "loadingAnimation$delegate", "dismiss", "", "show", "tap-update_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapUpdateLoadingDialog extends Dialog {

    /* JADX INFO: renamed from: ivLoading$delegate, reason: from kotlin metadata */
    private final Lazy ivLoading;

    /* JADX INFO: renamed from: loadingAnimation$delegate, reason: from kotlin metadata */
    private final Lazy loadingAnimation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TapUpdateLoadingDialog(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.ivLoading = LazyKt.lazy(new Function0<ImageView>() { // from class: com.taptap.sdk.update.dialog.TapUpdateLoadingDialog$ivLoading$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) this.this$0.findViewById(R.id.iv_loading);
            }
        });
        this.loadingAnimation = LazyKt.lazy(new Function0<RotateAnimation>() { // from class: com.taptap.sdk.update.dialog.TapUpdateLoadingDialog$loadingAnimation$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RotateAnimation invoke() {
                RotateAnimation $this$invoke_u24lambda_u240 = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
                $this$invoke_u24lambda_u240.setDuration(1500L);
                $this$invoke_u24lambda_u240.setRepeatCount(-1);
                $this$invoke_u24lambda_u240.setInterpolator(new LinearInterpolator());
                return $this$invoke_u24lambda_u240;
            }
        });
        Window theWindow = getWindow();
        if (theWindow != null) {
            WindowManager.LayoutParams lp = theWindow.getAttributes();
            lp.width = -1;
            lp.height = -1;
            lp.gravity = 17;
            theWindow.setAttributes(lp);
            theWindow.setBackgroundDrawable(new ColorDrawable(0));
        }
        setContentView(R.layout.tapupdate_dialog_loading);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }

    private final ImageView getIvLoading() {
        Object value = this.ivLoading.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-ivLoading>(...)");
        return (ImageView) value;
    }

    private final RotateAnimation getLoadingAnimation() {
        return (RotateAnimation) this.loadingAnimation.getValue();
    }

    @Override // android.app.Dialog
    public void show() {
        UIUtilKt.setNotFocusable(getWindow());
        super.show();
        UIUtilKt.hideNavBar(getWindow());
        UIUtilKt.clearNotFocusable(getWindow());
        getIvLoading().startAnimation(getLoadingAnimation());
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        getLoadingAnimation().cancel();
    }
}
