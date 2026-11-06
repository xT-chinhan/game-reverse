package com.taptap.sdk.update.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.taptap.sdk.kit.internal.extensions.UIExtKt;
import com.taptap.sdk.update.R;
import com.taptap.sdk.update.utils.UIUtilKt;
import com.umeng.analytics.pro.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: TapForceUpdateErrorDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\u0016\u001a\u00020\u0006H\u0002J\b\u0010\u0017\u001a\u00020\u0006H\u0014J\u0018\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u000f\u0010\u000bR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/taptap/sdk/update/dialog/TapForceUpdateErrorDialog;", "Landroid/app/Dialog;", d.R, "Landroid/content/Context;", "onRetryClick", "Lkotlin/Function0;", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;)V", "cancelText", "Landroid/widget/TextView;", "getCancelText", "()Landroid/widget/TextView;", "cancelText$delegate", "Lkotlin/Lazy;", "retryText", "getRetryText", "retryText$delegate", "rootContainer", "Landroid/view/ViewGroup;", "getRootContainer", "()Landroid/view/ViewGroup;", "rootContainer$delegate", "initView", "onStart", "setupWindowAttribute", "isLandscape", "", "Companion", "tap-update_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapForceUpdateErrorDialog extends Dialog {
    private static final float DEFAULT_HEIGHT = 128.0f;
    private static final float DEFAULT_WIDTH = 320.0f;

    /* JADX INFO: renamed from: cancelText$delegate, reason: from kotlin metadata */
    private final Lazy cancelText;
    private final Context context;
    private final Function0<Unit> onRetryClick;

    /* JADX INFO: renamed from: retryText$delegate, reason: from kotlin metadata */
    private final Lazy retryText;

    /* JADX INFO: renamed from: rootContainer$delegate, reason: from kotlin metadata */
    private final Lazy rootContainer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TapForceUpdateErrorDialog(Context context, Function0<Unit> onRetryClick) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onRetryClick, "onRetryClick");
        this.context = context;
        this.onRetryClick = onRetryClick;
        this.retryText = LazyKt.lazy(new Function0<TextView>() { // from class: com.taptap.sdk.update.dialog.TapForceUpdateErrorDialog$retryText$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) this.this$0.findViewById(R.id.update_error_dialog_retry);
            }
        });
        this.cancelText = LazyKt.lazy(new Function0<TextView>() { // from class: com.taptap.sdk.update.dialog.TapForceUpdateErrorDialog$cancelText$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) this.this$0.findViewById(R.id.update_error_dialog_cancel);
            }
        });
        this.rootContainer = LazyKt.lazy(new Function0<ViewGroup>() { // from class: com.taptap.sdk.update.dialog.TapForceUpdateErrorDialog$rootContainer$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewGroup invoke() {
                return (ViewGroup) this.this$0.findViewById(R.id.update_error_dialog_root_container);
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
        setContentView(R.layout.tapupdate_dialog_error);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        initView();
    }

    private final TextView getRetryText() {
        Object value = this.retryText.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-retryText>(...)");
        return (TextView) value;
    }

    private final TextView getCancelText() {
        Object value = this.cancelText.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-cancelText>(...)");
        return (TextView) value;
    }

    private final ViewGroup getRootContainer() {
        Object value = this.rootContainer.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-rootContainer>(...)");
        return (ViewGroup) value;
    }

    private final void initView() {
        UIExtKt.setDebounceClickListener$default(getRetryText(), 0L, new Function1<View, Unit>() { // from class: com.taptap.sdk.update.dialog.TapForceUpdateErrorDialog.initView.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                TapForceUpdateErrorDialog.this.dismiss();
                TapForceUpdateErrorDialog.this.onRetryClick.invoke();
            }
        }, 1, null);
        UIExtKt.setDebounceClickListener$default(getCancelText(), 0L, new Function1<View, Unit>() { // from class: com.taptap.sdk.update.dialog.TapForceUpdateErrorDialog.initView.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                TapForceUpdateErrorDialog.this.dismiss();
            }
        }, 1, null);
    }

    @Override // android.app.Dialog
    protected void onStart() {
        Configuration configuration;
        super.onStart();
        Resources resources = this.context.getResources();
        if (resources != null && (configuration = resources.getConfiguration()) != null) {
            setupWindowAttribute(this.context, 2 == configuration.orientation);
        }
    }

    private final void setupWindowAttribute(Context context, boolean isLandscape) {
        int windowWid;
        int windowHei;
        int i;
        ViewGroup.LayoutParams layoutParams = getRootContainer().getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        int paddingSize = com.taptap.sdk.update.extension.UIExtKt.toPx(15.0f);
        int screenWidWithPadding = UIUtilKt.getScreenWidth(context) - paddingSize;
        int screenHeiWithPadding = UIUtilKt.getScreenHeight(context) - paddingSize;
        if (isLandscape) {
            windowWid = RangesKt.coerceAtMost(com.taptap.sdk.update.extension.UIExtKt.toPx(320.0f), screenHeiWithPadding);
            int defaultHei = com.taptap.sdk.update.extension.UIExtKt.toPx(DEFAULT_HEIGHT);
            if (defaultHei > screenHeiWithPadding) {
                i = screenHeiWithPadding;
            } else {
                i = -2;
            }
            windowHei = i;
        } else {
            windowWid = RangesKt.coerceAtMost(com.taptap.sdk.update.extension.UIExtKt.toPx(320.0f), screenWidWithPadding);
            windowHei = -2;
        }
        layoutParams.width = windowWid;
        layoutParams.height = windowHei;
        getRootContainer().setLayoutParams(layoutParams);
    }
}
