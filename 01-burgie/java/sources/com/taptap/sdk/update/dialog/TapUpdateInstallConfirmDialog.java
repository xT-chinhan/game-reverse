package com.taptap.sdk.update.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.taptap.sdk.kit.internal.extensions.SysExtKt;
import com.taptap.sdk.update.R;
import com.taptap.sdk.update.extension.UIExtKt;
import com.taptap.sdk.update.internal.UpdateTracker;
import com.taptap.sdk.update.utils.UIUtilKt;
import com.umeng.analytics.pro.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONException;

/* JADX INFO: compiled from: TapUpdateInstallConfirmDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001f B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0014J\u0018\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u000e\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0011\u0010\u000eR\u001b\u0010\u0013\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0014\u0010\u000e¨\u0006!"}, d2 = {"Lcom/taptap/sdk/update/dialog/TapUpdateInstallConfirmDialog;", "Landroid/app/Dialog;", d.R, "Landroid/content/Context;", "(Landroid/content/Context;)V", "flRootContainer", "Landroid/widget/FrameLayout;", "getFlRootContainer", "()Landroid/widget/FrameLayout;", "flRootContainer$delegate", "Lkotlin/Lazy;", "mNegativeButton", "Landroid/widget/TextView;", "getMNegativeButton", "()Landroid/widget/TextView;", "mNegativeButton$delegate", "mPositiveButton", "getMPositiveButton", "mPositiveButton$delegate", "mTitle", "getMTitle", "mTitle$delegate", "initView", "", "onStart", "setupWindowAttribute", "isLandscape", "", "switchState", "type", "Lcom/taptap/sdk/update/dialog/TapUpdateInstallConfirmDialog$TapUpdateConfirmDialogType;", "Companion", "TapUpdateConfirmDialogType", "tap-update_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapUpdateInstallConfirmDialog extends Dialog {
    private static final float DEFAULT_HEIGHT = 128.0f;
    private static final float DEFAULT_WIDTH = 320.0f;
    private final Context context;

    /* JADX INFO: renamed from: flRootContainer$delegate, reason: from kotlin metadata */
    private final Lazy flRootContainer;

    /* JADX INFO: renamed from: mNegativeButton$delegate, reason: from kotlin metadata */
    private final Lazy mNegativeButton;

    /* JADX INFO: renamed from: mPositiveButton$delegate, reason: from kotlin metadata */
    private final Lazy mPositiveButton;

    /* JADX INFO: renamed from: mTitle$delegate, reason: from kotlin metadata */
    private final Lazy mTitle;

    /* JADX INFO: compiled from: TapUpdateInstallConfirmDialog.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/taptap/sdk/update/dialog/TapUpdateInstallConfirmDialog$TapUpdateConfirmDialogType;", "", "(Ljava/lang/String;I)V", "INSTALL_CONFIRM", "INSTALL_FAIL", "tap-update_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum TapUpdateConfirmDialogType {
        INSTALL_CONFIRM,
        INSTALL_FAIL
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TapUpdateInstallConfirmDialog(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.flRootContainer = LazyKt.lazy(new Function0<FrameLayout>() { // from class: com.taptap.sdk.update.dialog.TapUpdateInstallConfirmDialog$flRootContainer$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                return (FrameLayout) this.this$0.findViewById(R.id.fl_root_container);
            }
        });
        this.mTitle = LazyKt.lazy(new Function0<TextView>() { // from class: com.taptap.sdk.update.dialog.TapUpdateInstallConfirmDialog$mTitle$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) this.this$0.findViewById(R.id.tv_ready_tips);
            }
        });
        this.mNegativeButton = LazyKt.lazy(new Function0<TextView>() { // from class: com.taptap.sdk.update.dialog.TapUpdateInstallConfirmDialog$mNegativeButton$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) this.this$0.findViewById(R.id.tv_func_negative);
            }
        });
        this.mPositiveButton = LazyKt.lazy(new Function0<TextView>() { // from class: com.taptap.sdk.update.dialog.TapUpdateInstallConfirmDialog$mPositiveButton$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) this.this$0.findViewById(R.id.tv_func_positive);
            }
        });
        Window it = getWindow();
        if (it != null) {
            WindowManager.LayoutParams lp = it.getAttributes();
            lp.width = -1;
            lp.height = -1;
            lp.gravity = 17;
            it.setAttributes(lp);
            it.setBackgroundDrawable(new ColorDrawable(0));
            it.requestFeature(1);
        }
        setContentView(R.layout.tapupdate_dialog_confrim);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        initView(context);
    }

    private final FrameLayout getFlRootContainer() {
        Object value = this.flRootContainer.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-flRootContainer>(...)");
        return (FrameLayout) value;
    }

    private final TextView getMTitle() {
        Object value = this.mTitle.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mTitle>(...)");
        return (TextView) value;
    }

    private final TextView getMNegativeButton() {
        Object value = this.mNegativeButton.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mNegativeButton>(...)");
        return (TextView) value;
    }

    private final TextView getMPositiveButton() {
        Object value = this.mPositiveButton.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mPositiveButton>(...)");
        return (TextView) value;
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        Resources resources = this.context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        Configuration configuration = resources.getConfiguration();
        if (configuration != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext()");
            setupWindowAttribute(context, 2 == configuration.orientation);
        }
    }

    private final void initView(final Context context) {
        getMNegativeButton().setText("取消");
        getMNegativeButton().setOnClickListener(new View.OnClickListener() { // from class: com.taptap.sdk.update.dialog.TapUpdateInstallConfirmDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws JSONException {
                TapUpdateInstallConfirmDialog.initView$lambda$1(this.f$0, view);
            }
        });
        getMPositiveButton().setOnClickListener(new View.OnClickListener() { // from class: com.taptap.sdk.update.dialog.TapUpdateInstallConfirmDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws JSONException {
                TapUpdateInstallConfirmDialog.initView$lambda$2(this.f$0, context, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(TapUpdateInstallConfirmDialog this$0, View it) throws JSONException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        UpdateTracker.INSTANCE.trackInstallConfirmCancelButtonClick(Intrinsics.areEqual(this$0.getMPositiveButton().getText(), "安装完成"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(TapUpdateInstallConfirmDialog this$0, Context context, View it) throws JSONException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        UpdateTracker.INSTANCE.trackInstallConfirmPositiveButtonClick(Intrinsics.areEqual(this$0.getMPositiveButton().getText(), "安装完成"));
        if (SysExtKt.isTapInstalled()) {
            TapUpdateDialogManager.INSTANCE.installSuccess(context);
            this$0.dismiss();
        } else if (TextUtils.equals(this$0.getMPositiveButton().getText(), "重新安装")) {
            this$0.dismiss();
        } else {
            this$0.switchState(TapUpdateConfirmDialogType.INSTALL_FAIL);
            UpdateTracker.INSTANCE.trackNotInstallDialogVisible();
        }
    }

    public final void switchState(TapUpdateConfirmDialogType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (type == TapUpdateConfirmDialogType.INSTALL_CONFIRM) {
            getMTitle().setText("TapTap 是否已经安装完成？");
            getMPositiveButton().setText("安装完成");
        } else if (type == TapUpdateConfirmDialogType.INSTALL_FAIL) {
            getMTitle().setText("TapTap 尚未安装成功，请重新安装。");
            getMPositiveButton().setText("重新安装");
        }
    }

    private final void setupWindowAttribute(Context context, boolean isLandscape) {
        int windowWid;
        int windowHei;
        int i;
        ViewGroup.LayoutParams layoutParams = getFlRootContainer().getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        int paddingSize = UIExtKt.toPx(15.0f);
        int screenWidWithPadding = UIUtilKt.getScreenWidth(context) - paddingSize;
        int screenHeiWithPadding = UIUtilKt.getScreenHeight(context) - paddingSize;
        if (isLandscape) {
            windowWid = RangesKt.coerceAtMost(UIExtKt.toPx(320.0f), screenHeiWithPadding);
            int defaultHei = UIExtKt.toPx(DEFAULT_HEIGHT);
            if (defaultHei > screenHeiWithPadding) {
                i = screenHeiWithPadding;
            } else {
                i = -2;
            }
            windowHei = i;
        } else {
            windowWid = RangesKt.coerceAtMost(UIExtKt.toPx(320.0f), screenWidWithPadding);
            windowHei = -2;
        }
        layoutParams.width = windowWid;
        layoutParams.height = windowHei;
        getFlRootContainer().setLayoutParams(layoutParams);
    }
}
