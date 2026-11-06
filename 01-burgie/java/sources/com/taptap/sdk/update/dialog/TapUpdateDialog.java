package com.taptap.sdk.update.dialog;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tapsdk.tapad.internal.runtime.view.TextViewManager;
import com.taptap.sdk.flowlayout.FlowLayout;
import com.taptap.sdk.flowlayout.TagAdapter;
import com.taptap.sdk.flowlayout.TagFlowLayout;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.extensions.UIExtKt;
import com.taptap.sdk.update.R;
import com.taptap.sdk.update.bean.UIInformation;
import com.taptap.sdk.update.bean.UpdateFuncLink;
import com.taptap.sdk.update.internal.UpdateTracker;
import com.taptap.sdk.update.utils.UIUtilKt;
import com.umeng.analytics.pro.d;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONException;

/* JADX INFO: compiled from: TapUpdateDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u009c\u00012\u00020\u0001:\u0004\u009c\u0001\u009d\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010i\u001a\u00020jH\u0002J\b\u0010k\u001a\u00020jH\u0016J\u0014\u0010l\u001a\u0004\u0018\u00010G2\b\u0010m\u001a\u0004\u0018\u00010nH\u0002J\u0006\u0010o\u001a\u00020jJ\b\u0010p\u001a\u00020jH\u0002J\u0018\u0010q\u001a\u00020j2\u0006\u0010r\u001a\u00020s2\b\u0010t\u001a\u0004\u0018\u00010uJ\b\u0010v\u001a\u00020jH\u0014J\u0010\u0010w\u001a\u00020j2\u0006\u0010x\u001a\u00020sH\u0016J\u000e\u0010y\u001a\u00020j2\u0006\u0010z\u001a\u00020*J\u0010\u0010{\u001a\u00020j2\b\u0010|\u001a\u0004\u0018\u00010@J\u0018\u0010}\u001a\u00020j2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010~\u001a\u00020sH\u0002J\u000f\u0010\u007f\u001a\u00020j2\u0007\u0010\u0080\u0001\u001a\u00020sJ3\u0010\u0081\u0001\u001a\u00020j2\n\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u00012\u0007\u0010\u0084\u0001\u001a\u00020s2\n\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0083\u00012\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010uJ\u0007\u0010\u0087\u0001\u001a\u00020jJ\t\u0010\u0088\u0001\u001a\u00020jH\u0002J(\u0010\u0089\u0001\u001a\u00020j2\b\u0010\u008a\u0001\u001a\u00030\u008b\u00012\n\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u0083\u00012\u0007\u0010\u008d\u0001\u001a\u00020uH\u0002J\u001a\u0010\u008e\u0001\u001a\u00020j2\b\u0010\u008a\u0001\u001a\u00030\u008b\u00012\u0007\u0010\u008d\u0001\u001a\u00020uJ(\u0010\u008f\u0001\u001a\u00020j2\b\u0010\u008a\u0001\u001a\u00030\u008b\u00012\f\b\u0002\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u0083\u00012\u0007\u0010\u008d\u0001\u001a\u00020uJ\t\u0010\u0090\u0001\u001a\u00020jH\u0002J\t\u0010\u0091\u0001\u001a\u00020jH\u0002J\t\u0010\u0092\u0001\u001a\u00020jH\u0002J\u0013\u0010\u0093\u0001\u001a\u00020j2\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u008b\u0001J\u0010\u0010\u0095\u0001\u001a\u00020j2\u0007\u0010\u0096\u0001\u001a\u00020*J\u0013\u0010\u0097\u0001\u001a\u00020j2\n\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u008b\u0001J\u0013\u0010\u0099\u0001\u001a\u00020j2\n\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u009b\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0012\u001a\u0004\b\u001e\u0010\u001bR\u001b\u0010 \u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0012\u001a\u0004\b!\u0010\u001bR\u001b\u0010#\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0012\u001a\u0004\b$\u0010\u001bR\u001b\u0010&\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u0012\u001a\u0004\b'\u0010\u001bR\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010+\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0012\u001a\u0004\b-\u0010.R\u001b\u00100\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u0012\u001a\u0004\b1\u0010.R\u001b\u00103\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u0012\u001a\u0004\b4\u0010.R\u001b\u00106\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u0012\u001a\u0004\b7\u0010.R\u001b\u00109\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\u0012\u001a\u0004\b:\u0010.R\u001b\u0010<\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\u0012\u001a\u0004\b=\u0010.R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010A\u001a\u00020B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\u0012\u001a\u0004\bC\u0010DR\u001b\u0010F\u001a\u00020G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010\u0012\u001a\u0004\bH\u0010IR\u001b\u0010K\u001a\u00020G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\u0012\u001a\u0004\bL\u0010IR\u001b\u0010N\u001a\u00020G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bP\u0010\u0012\u001a\u0004\bO\u0010IR\u001b\u0010Q\u001a\u00020G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010\u0012\u001a\u0004\bR\u0010IR\u001b\u0010T\u001a\u00020G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bV\u0010\u0012\u001a\u0004\bU\u0010IR\u001b\u0010W\u001a\u00020G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bY\u0010\u0012\u001a\u0004\bX\u0010IR\u001b\u0010Z\u001a\u00020G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010\u0012\u001a\u0004\b[\u0010IR\u001b\u0010]\u001a\u00020G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b_\u0010\u0012\u001a\u0004\b^\u0010IR\u001b\u0010`\u001a\u00020G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bb\u0010\u0012\u001a\u0004\ba\u0010IR\u001b\u0010c\u001a\u00020G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\be\u0010\u0012\u001a\u0004\bd\u0010IR\u001b\u0010f\u001a\u00020G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bh\u0010\u0012\u001a\u0004\bg\u0010I¨\u0006\u009e\u0001"}, d2 = {"Lcom/taptap/sdk/update/dialog/TapUpdateDialog;", "Landroid/app/Dialog;", d.R, "Landroid/content/Context;", "(Landroid/content/Context;)V", "dialogState", "Lcom/taptap/sdk/update/dialog/TapUpdateDialogState;", "getDialogState", "()Lcom/taptap/sdk/update/dialog/TapUpdateDialogState;", "setDialogState", "(Lcom/taptap/sdk/update/dialog/TapUpdateDialogState;)V", "downloadAnimatorSet", "Landroid/animation/AnimatorSet;", "flRootContainer", "Landroid/widget/FrameLayout;", "getFlRootContainer", "()Landroid/widget/FrameLayout;", "flRootContainer$delegate", "Lkotlin/Lazy;", "flexLinkContainer", "Lcom/taptap/sdk/flowlayout/TagFlowLayout;", "getFlexLinkContainer", "()Lcom/taptap/sdk/flowlayout/TagFlowLayout;", "flexLinkContainer$delegate", "ivDownloadSpeedTriangle1", "Landroid/widget/ImageView;", "getIvDownloadSpeedTriangle1", "()Landroid/widget/ImageView;", "ivDownloadSpeedTriangle1$delegate", "ivDownloadSpeedTriangle2", "getIvDownloadSpeedTriangle2", "ivDownloadSpeedTriangle2$delegate", "ivIconRetry", "getIvIconRetry", "ivIconRetry$delegate", "ivRequestError", "getIvRequestError", "ivRequestError$delegate", "ivUpdateCancel", "getIvUpdateCancel", "ivUpdateCancel$delegate", "linkTextColor", "", "llDownloadContainer", "Landroid/widget/LinearLayout;", "getLlDownloadContainer", "()Landroid/widget/LinearLayout;", "llDownloadContainer$delegate", "llFuncContainer", "getLlFuncContainer", "llFuncContainer$delegate", "llProgressContainer", "getLlProgressContainer", "llProgressContainer$delegate", "llReadyContainer", "getLlReadyContainer", "llReadyContainer$delegate", "llRetry", "getLlRetry", "llRetry$delegate", "llSpeedTriangle", "getLlSpeedTriangle", "llSpeedTriangle$delegate", "mUpdateCancelListener", "Lcom/taptap/sdk/update/dialog/TapUpdateDialog$IUpdateCancelListener;", "pbDownloadProgress", "Landroid/widget/ProgressBar;", "getPbDownloadProgress", "()Landroid/widget/ProgressBar;", "pbDownloadProgress$delegate", "tvDeveloperInfo", "Landroid/widget/TextView;", "getTvDeveloperInfo", "()Landroid/widget/TextView;", "tvDeveloperInfo$delegate", "tvDownloadContentTitle", "getTvDownloadContentTitle", "tvDownloadContentTitle$delegate", "tvDownloadSpeed", "getTvDownloadSpeed", "tvDownloadSpeed$delegate", "tvErrorTips", "getTvErrorTips", "tvErrorTips$delegate", "tvFuncButton", "getTvFuncButton", "tvFuncButton$delegate", "tvFuncNegative", "getTvFuncNegative", "tvFuncNegative$delegate", "tvFuncPositive", "getTvFuncPositive", "tvFuncPositive$delegate", "tvFuncTips", "getTvFuncTips", "tvFuncTips$delegate", "tvOtherTips", "getTvOtherTips", "tvOtherTips$delegate", "tvReadyTips", "getTvReadyTips", "tvReadyTips$delegate", "tvUpdateTitle", "getTvUpdateTitle", "tvUpdateTitle$delegate", "adapterBlackScreenOnUnity", "", "dismiss", "generateLinkView", "linkBean", "Lcom/taptap/sdk/update/bean/UpdateFuncLink;", "hideDownloadErrorTips", "initView", "onDownloadReady", "reqSuccess", "", "positiveClickListener", "Landroid/view/View$OnClickListener;", "onStart", "onWindowFocusChanged", "hasFocus", "setMaxProgress", "maxProgress", "setUpdateCancelListener", "listener", "setupWindowAttribute", "isLandscape", "showCloseButton", "show", "showDownloadErrorTips", "errorTipsText", "", "retryEnable", "otherTipsText", "onRetryClickListener", "showDownloadPage", "showDownloadSpeedAnim", "showFunViewInternal", "funcText", "", "tipsText", "funcClickListener", "showFuncView", "showFuncViewWithTips", "startRetryAnim", "stopAnim", "stopRetryAnim", "updateDownloadContentTitle", TextViewManager.NAME, "updateProgress", NotificationCompat.CATEGORY_PROGRESS, "updateSpeed", "speed", "updateUIInformation", "uiInformation", "Lcom/taptap/sdk/update/bean/UIInformation;", "Companion", "IUpdateCancelListener", "tap-update_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapUpdateDialog extends Dialog {
    private static final float DEFAULT_HEIGHT = 128.0f;
    private static final float DEFAULT_WIDTH = 320.0f;
    private TapUpdateDialogState dialogState;
    private AnimatorSet downloadAnimatorSet;

    /* JADX INFO: renamed from: flRootContainer$delegate, reason: from kotlin metadata */
    private final Lazy flRootContainer;

    /* JADX INFO: renamed from: flexLinkContainer$delegate, reason: from kotlin metadata */
    private final Lazy flexLinkContainer;

    /* JADX INFO: renamed from: ivDownloadSpeedTriangle1$delegate, reason: from kotlin metadata */
    private final Lazy ivDownloadSpeedTriangle1;

    /* JADX INFO: renamed from: ivDownloadSpeedTriangle2$delegate, reason: from kotlin metadata */
    private final Lazy ivDownloadSpeedTriangle2;

    /* JADX INFO: renamed from: ivIconRetry$delegate, reason: from kotlin metadata */
    private final Lazy ivIconRetry;

    /* JADX INFO: renamed from: ivRequestError$delegate, reason: from kotlin metadata */
    private final Lazy ivRequestError;

    /* JADX INFO: renamed from: ivUpdateCancel$delegate, reason: from kotlin metadata */
    private final Lazy ivUpdateCancel;
    private final int linkTextColor;

    /* JADX INFO: renamed from: llDownloadContainer$delegate, reason: from kotlin metadata */
    private final Lazy llDownloadContainer;

    /* JADX INFO: renamed from: llFuncContainer$delegate, reason: from kotlin metadata */
    private final Lazy llFuncContainer;

    /* JADX INFO: renamed from: llProgressContainer$delegate, reason: from kotlin metadata */
    private final Lazy llProgressContainer;

    /* JADX INFO: renamed from: llReadyContainer$delegate, reason: from kotlin metadata */
    private final Lazy llReadyContainer;

    /* JADX INFO: renamed from: llRetry$delegate, reason: from kotlin metadata */
    private final Lazy llRetry;

    /* JADX INFO: renamed from: llSpeedTriangle$delegate, reason: from kotlin metadata */
    private final Lazy llSpeedTriangle;
    private IUpdateCancelListener mUpdateCancelListener;

    /* JADX INFO: renamed from: pbDownloadProgress$delegate, reason: from kotlin metadata */
    private final Lazy pbDownloadProgress;

    /* JADX INFO: renamed from: tvDeveloperInfo$delegate, reason: from kotlin metadata */
    private final Lazy tvDeveloperInfo;

    /* JADX INFO: renamed from: tvDownloadContentTitle$delegate, reason: from kotlin metadata */
    private final Lazy tvDownloadContentTitle;

    /* JADX INFO: renamed from: tvDownloadSpeed$delegate, reason: from kotlin metadata */
    private final Lazy tvDownloadSpeed;

    /* JADX INFO: renamed from: tvErrorTips$delegate, reason: from kotlin metadata */
    private final Lazy tvErrorTips;

    /* JADX INFO: renamed from: tvFuncButton$delegate, reason: from kotlin metadata */
    private final Lazy tvFuncButton;

    /* JADX INFO: renamed from: tvFuncNegative$delegate, reason: from kotlin metadata */
    private final Lazy tvFuncNegative;

    /* JADX INFO: renamed from: tvFuncPositive$delegate, reason: from kotlin metadata */
    private final Lazy tvFuncPositive;

    /* JADX INFO: renamed from: tvFuncTips$delegate, reason: from kotlin metadata */
    private final Lazy tvFuncTips;

    /* JADX INFO: renamed from: tvOtherTips$delegate, reason: from kotlin metadata */
    private final Lazy tvOtherTips;

    /* JADX INFO: renamed from: tvReadyTips$delegate, reason: from kotlin metadata */
    private final Lazy tvReadyTips;

    /* JADX INFO: renamed from: tvUpdateTitle$delegate, reason: from kotlin metadata */
    private final Lazy tvUpdateTitle;

    /* JADX INFO: compiled from: TapUpdateDialog.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/taptap/sdk/update/dialog/TapUpdateDialog$IUpdateCancelListener;", "", "onUpdateCancel", "", "state", "Lcom/taptap/sdk/update/dialog/TapUpdateDialogState;", "fromCloseButton", "", "tap-update_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface IUpdateCancelListener {
        void onUpdateCancel(TapUpdateDialogState state, boolean fromCloseButton);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TapUpdateDialog(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.flRootContainer = LazyKt.lazy(new Function0<FrameLayout>() { // from class: com.taptap.sdk.update.dialog.TapUpdateDialog$flRootContainer$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                return (FrameLayout) this.this$0.findViewById(R.id.fl_root_container);
            }
        });
        this.llReadyContainer = LazyKt.lazy(new Function0<LinearLayout>() { // from class: com.taptap.sdk.update.dialog.TapUpdateDialog$llReadyContainer$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                return (LinearLayout) this.this$0.findViewById(R.id.ll_ready_container);
            }
        });
        this.ivRequestError = LazyKt.lazy(new Function0<ImageView>() { // from class: com.taptap.sdk.update.dialog.TapUpdateDialog$ivRequestError$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) this.this$0.findViewById(R.id.iv_request_error);
            }
        });
        this.tvReadyTips = LazyKt.lazy(new Function0<TextView>() { // from class: com.taptap.sdk.update.dialog.TapUpdateDialog$tvReadyTips$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) this.this$0.findViewById(R.id.tv_ready_tips);
            }
        });
        this.tvFuncNegative = LazyKt.lazy(new Function0<TextView>() { // from class: com.taptap.sdk.update.dialog.TapUpdateDialog$tvFuncNegative$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) this.this$0.findViewById(R.id.tv_func_negative);
            }
        });
        this.tvFuncPositive = LazyKt.lazy(new Function0<TextView>() { // from class: com.taptap.sdk.update.dialog.TapUpdateDialog$tvFuncPositive$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) this.this$0.findViewById(R.id.tv_func_positive);
            }
        });
        this.llDownloadContainer = LazyKt.lazy(new Function0<LinearLayout>() { // from class: com.taptap.sdk.update.dialog.TapUpdateDialog$llDownloadContainer$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                return (LinearLayout) this.this$0.findViewById(R.id.ll_download_container);
            }
        });
        this.tvUpdateTitle = LazyKt.lazy(new Function0<TextView>() { // from class: com.taptap.sdk.update.dialog.TapUpdateDialog$tvUpdateTitle$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) this.this$0.findViewById(R.id.tv_update_title);
            }
        });
        this.ivUpdateCancel = LazyKt.lazy(new Function0<ImageView>() { // from class: com.taptap.sdk.update.dialog.TapUpdateDialog$ivUpdateCancel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) this.this$0.findViewById(R.id.iv_update_cancel);
            }
        });
        this.llProgressContainer = LazyKt.lazy(new Function0<LinearLayout>() { // from class: com.taptap.sdk.update.dialog.TapUpdateDialog$llProgressContainer$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                return (LinearLayout) this.this$0.findViewById(R.id.ll_progress_container);
            }
        });
        this.tvDownloadContentTitle = LazyKt.lazy(new Function0<TextView>() { // from class: com.taptap.sdk.update.dialog.TapUpdateDialog$tvDownloadContentTitle$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) this.this$0.findViewById(R.id.tv_download_content_title);
            }
        });
        this.tvDownloadSpeed = LazyKt.lazy(new Function0<TextView>() { // from class: com.taptap.sdk.update.dialog.TapUpdateDialog$tvDownloadSpeed$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) this.this$0.findViewById(R.id.tv_download_speed);
            }
        });
        this.llSpeedTriangle = LazyKt.lazy(new Function0<LinearLayout>() { // from class: com.taptap.sdk.update.dialog.TapUpdateDialog$llSpeedTriangle$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                return (LinearLayout) this.this$0.findViewById(R.id.ll_speed_triangle);
            }
        });
        this.ivDownloadSpeedTriangle1 = LazyKt.lazy(new Function0<ImageView>() { // from class: com.taptap.sdk.update.dialog.TapUpdateDialog$ivDownloadSpeedTriangle1$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) this.this$0.findViewById(R.id.iv_download_speed_triangle_1);
            }
        });
        this.ivDownloadSpeedTriangle2 = LazyKt.lazy(new Function0<ImageView>() { // from class: com.taptap.sdk.update.dialog.TapUpdateDialog$ivDownloadSpeedTriangle2$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) this.this$0.findViewById(R.id.iv_download_speed_triangle_2);
            }
        });
        this.pbDownloadProgress = LazyKt.lazy(new Function0<ProgressBar>() { // from class: com.taptap.sdk.update.dialog.TapUpdateDialog$pbDownloadProgress$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ProgressBar invoke() {
                return (ProgressBar) this.this$0.findViewById(R.id.pb_download_progress);
            }
        });
        this.tvErrorTips = LazyKt.lazy(new Function0<TextView>() { // from class: com.taptap.sdk.update.dialog.TapUpdateDialog$tvErrorTips$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) this.this$0.findViewById(R.id.tv_error_tips);
            }
        });
        this.llRetry = LazyKt.lazy(new Function0<LinearLayout>() { // from class: com.taptap.sdk.update.dialog.TapUpdateDialog$llRetry$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                return (LinearLayout) this.this$0.findViewById(R.id.ll_retry);
            }
        });
        this.tvOtherTips = LazyKt.lazy(new Function0<TextView>() { // from class: com.taptap.sdk.update.dialog.TapUpdateDialog$tvOtherTips$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) this.this$0.findViewById(R.id.tv_other_tips);
            }
        });
        this.ivIconRetry = LazyKt.lazy(new Function0<ImageView>() { // from class: com.taptap.sdk.update.dialog.TapUpdateDialog$ivIconRetry$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) this.this$0.findViewById(R.id.iv_icon_retry);
            }
        });
        this.llFuncContainer = LazyKt.lazy(new Function0<LinearLayout>() { // from class: com.taptap.sdk.update.dialog.TapUpdateDialog$llFuncContainer$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                return (LinearLayout) this.this$0.findViewById(R.id.ll_func_container);
            }
        });
        this.tvFuncButton = LazyKt.lazy(new Function0<TextView>() { // from class: com.taptap.sdk.update.dialog.TapUpdateDialog$tvFuncButton$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) this.this$0.findViewById(R.id.tv_func_button);
            }
        });
        this.tvFuncTips = LazyKt.lazy(new Function0<TextView>() { // from class: com.taptap.sdk.update.dialog.TapUpdateDialog$tvFuncTips$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) this.this$0.findViewById(R.id.tv_func_tips);
            }
        });
        this.flexLinkContainer = LazyKt.lazy(new Function0<TagFlowLayout>() { // from class: com.taptap.sdk.update.dialog.TapUpdateDialog$flexLinkContainer$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TagFlowLayout invoke() {
                return (TagFlowLayout) this.this$0.findViewById(R.id.flex_link_container);
            }
        });
        this.tvDeveloperInfo = LazyKt.lazy(new Function0<TextView>() { // from class: com.taptap.sdk.update.dialog.TapUpdateDialog$tvDeveloperInfo$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) this.this$0.findViewById(R.id.tv_developer_info);
            }
        });
        this.linkTextColor = Color.parseColor("#4B4B4B");
        this.dialogState = TapUpdateDialogState.NONE;
        Window theWindow = getWindow();
        if (theWindow != null) {
            WindowManager.LayoutParams lp = theWindow.getAttributes();
            lp.width = -1;
            lp.height = -1;
            lp.gravity = 17;
            theWindow.setAttributes(lp);
            theWindow.setBackgroundDrawable(new ColorDrawable(0));
            theWindow.requestFeature(1);
        }
        setContentView(R.layout.tapupdate_dialog_update);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        initView();
    }

    private final FrameLayout getFlRootContainer() {
        Object value = this.flRootContainer.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-flRootContainer>(...)");
        return (FrameLayout) value;
    }

    private final LinearLayout getLlReadyContainer() {
        Object value = this.llReadyContainer.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-llReadyContainer>(...)");
        return (LinearLayout) value;
    }

    private final ImageView getIvRequestError() {
        Object value = this.ivRequestError.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-ivRequestError>(...)");
        return (ImageView) value;
    }

    private final TextView getTvReadyTips() {
        Object value = this.tvReadyTips.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-tvReadyTips>(...)");
        return (TextView) value;
    }

    private final TextView getTvFuncNegative() {
        Object value = this.tvFuncNegative.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-tvFuncNegative>(...)");
        return (TextView) value;
    }

    private final TextView getTvFuncPositive() {
        Object value = this.tvFuncPositive.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-tvFuncPositive>(...)");
        return (TextView) value;
    }

    private final LinearLayout getLlDownloadContainer() {
        Object value = this.llDownloadContainer.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-llDownloadContainer>(...)");
        return (LinearLayout) value;
    }

    private final TextView getTvUpdateTitle() {
        Object value = this.tvUpdateTitle.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-tvUpdateTitle>(...)");
        return (TextView) value;
    }

    private final ImageView getIvUpdateCancel() {
        Object value = this.ivUpdateCancel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-ivUpdateCancel>(...)");
        return (ImageView) value;
    }

    private final LinearLayout getLlProgressContainer() {
        Object value = this.llProgressContainer.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-llProgressContainer>(...)");
        return (LinearLayout) value;
    }

    private final TextView getTvDownloadContentTitle() {
        Object value = this.tvDownloadContentTitle.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-tvDownloadContentTitle>(...)");
        return (TextView) value;
    }

    private final TextView getTvDownloadSpeed() {
        Object value = this.tvDownloadSpeed.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-tvDownloadSpeed>(...)");
        return (TextView) value;
    }

    private final LinearLayout getLlSpeedTriangle() {
        Object value = this.llSpeedTriangle.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-llSpeedTriangle>(...)");
        return (LinearLayout) value;
    }

    private final ImageView getIvDownloadSpeedTriangle1() {
        Object value = this.ivDownloadSpeedTriangle1.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-ivDownloadSpeedTriangle1>(...)");
        return (ImageView) value;
    }

    private final ImageView getIvDownloadSpeedTriangle2() {
        Object value = this.ivDownloadSpeedTriangle2.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-ivDownloadSpeedTriangle2>(...)");
        return (ImageView) value;
    }

    private final ProgressBar getPbDownloadProgress() {
        Object value = this.pbDownloadProgress.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-pbDownloadProgress>(...)");
        return (ProgressBar) value;
    }

    private final TextView getTvErrorTips() {
        Object value = this.tvErrorTips.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-tvErrorTips>(...)");
        return (TextView) value;
    }

    private final LinearLayout getLlRetry() {
        Object value = this.llRetry.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-llRetry>(...)");
        return (LinearLayout) value;
    }

    private final TextView getTvOtherTips() {
        Object value = this.tvOtherTips.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-tvOtherTips>(...)");
        return (TextView) value;
    }

    private final ImageView getIvIconRetry() {
        Object value = this.ivIconRetry.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-ivIconRetry>(...)");
        return (ImageView) value;
    }

    private final LinearLayout getLlFuncContainer() {
        Object value = this.llFuncContainer.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-llFuncContainer>(...)");
        return (LinearLayout) value;
    }

    private final TextView getTvFuncButton() {
        Object value = this.tvFuncButton.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-tvFuncButton>(...)");
        return (TextView) value;
    }

    private final TextView getTvFuncTips() {
        Object value = this.tvFuncTips.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-tvFuncTips>(...)");
        return (TextView) value;
    }

    private final TagFlowLayout getFlexLinkContainer() {
        Object value = this.flexLinkContainer.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-flexLinkContainer>(...)");
        return (TagFlowLayout) value;
    }

    private final TextView getTvDeveloperInfo() {
        Object value = this.tvDeveloperInfo.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-tvDeveloperInfo>(...)");
        return (TextView) value;
    }

    public final TapUpdateDialogState getDialogState() {
        return this.dialogState;
    }

    public final void setDialogState(TapUpdateDialogState tapUpdateDialogState) {
        Intrinsics.checkNotNullParameter(tapUpdateDialogState, "<set-?>");
        this.dialogState = tapUpdateDialogState;
    }

    public final void setUpdateCancelListener(IUpdateCancelListener listener) {
        this.mUpdateCancelListener = listener;
    }

    public final void showCloseButton(boolean show) {
        getIvUpdateCancel().setVisibility(show ? 0 : 8);
    }

    public final void onDownloadReady(boolean reqSuccess, View.OnClickListener positiveClickListener) throws JSONException {
        getLlReadyContainer().setVisibility(0);
        getLlDownloadContainer().setVisibility(8);
        if (reqSuccess) {
            this.dialogState = TapUpdateDialogState.CONFIRM;
            getIvRequestError().setVisibility(8);
            getTvReadyTips().setText("使用 TapTap 更新游戏？");
            getTvFuncPositive().setText("更新");
            UpdateTracker.INSTANCE.trackUpdateConfirmDialogVisible();
        } else {
            this.dialogState = TapUpdateDialogState.API_ERROR;
            getIvRequestError().setVisibility(0);
            getTvReadyTips().setText("请求失败，请重试");
            getTvFuncPositive().setText("点击重试");
            UpdateTracker.INSTANCE.trackRequestFailDialogVisible();
        }
        getTvFuncPositive().setOnClickListener(positiveClickListener);
    }

    public final void showDownloadPage() {
        this.dialogState = TapUpdateDialogState.DOWNLOAD;
        getLlReadyContainer().setVisibility(8);
        getLlDownloadContainer().setVisibility(0);
        getLlProgressContainer().setVisibility(0);
        getLlFuncContainer().setVisibility(8);
        showDownloadSpeedAnim();
    }

    public final void updateUIInformation(UIInformation uiInformation) {
        if (uiInformation == null) {
            return;
        }
        getTvUpdateTitle().setText(uiInformation.getUpdateTitle());
        getTvDeveloperInfo().setText(uiInformation.getAppInfo());
        List<UpdateFuncLink> linkList = uiInformation.getLinkList();
        List<UpdateFuncLink> list = linkList;
        if (list == null || list.isEmpty()) {
            UIExtKt.gone(getFlexLinkContainer());
            return;
        }
        getFlexLinkContainer().removeAllViews();
        UIExtKt.visible(getFlexLinkContainer());
        getFlexLinkContainer().setAdapter(new TagAdapter<UpdateFuncLink>(linkList) { // from class: com.taptap.sdk.update.dialog.TapUpdateDialog.updateUIInformation.1
            @Override // com.taptap.sdk.flowlayout.TagAdapter
            public View getView(FlowLayout parent, int position, UpdateFuncLink t) {
                TextView textViewGenerateLinkView = this.generateLinkView(t);
                if (textViewGenerateLinkView == null) {
                    textViewGenerateLinkView = new TextView(this.getContext());
                }
                return textViewGenerateLinkView;
            }
        });
    }

    public final void updateDownloadContentTitle(String text) {
        getTvDownloadContentTitle().setText(text);
    }

    public final void updateSpeed(String speed) {
        getTvDownloadSpeed().setText(speed);
        if (getLlSpeedTriangle().getVisibility() != 0) {
            getLlSpeedTriangle().setVisibility(0);
        }
        showDownloadSpeedAnim();
    }

    public final void setMaxProgress(int maxProgress) {
        getPbDownloadProgress().setMax(maxProgress);
    }

    public final void updateProgress(int progress) {
        getPbDownloadProgress().setProgress(progress);
    }

    public final void showDownloadErrorTips(CharSequence errorTipsText, final boolean retryEnable, CharSequence otherTipsText, final View.OnClickListener onRetryClickListener) {
        AnimatorSet animatorSet;
        boolean z = false;
        if (TextUtils.isEmpty(errorTipsText)) {
            getTvErrorTips().setVisibility(8);
            getTvErrorTips().setText("");
        } else {
            getTvErrorTips().setVisibility(0);
            getTvErrorTips().setText(errorTipsText);
            stopAnim();
        }
        stopRetryAnim();
        getLlRetry().setVisibility(retryEnable ? 0 : 8);
        getLlRetry().setOnClickListener(new View.OnClickListener() { // from class: com.taptap.sdk.update.dialog.TapUpdateDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TapUpdateDialog.showDownloadErrorTips$lambda$0(onRetryClickListener, retryEnable, this, view);
            }
        });
        if (TextUtils.isEmpty(otherTipsText)) {
            getTvOtherTips().setVisibility(8);
            getTvOtherTips().setText("");
        } else {
            getTvOtherTips().setVisibility(0);
            getTvOtherTips().setText(otherTipsText);
        }
        AnimatorSet animatorSet2 = this.downloadAnimatorSet;
        if (animatorSet2 != null && animatorSet2.isRunning()) {
            z = true;
        }
        if (!z || (animatorSet = this.downloadAnimatorSet) == null) {
            return;
        }
        animatorSet.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDownloadErrorTips$lambda$0(View.OnClickListener $onRetryClickListener, boolean $retryEnable, TapUpdateDialog this$0, View v) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if ($onRetryClickListener != null) {
            $onRetryClickListener.onClick(v);
        }
        if ($retryEnable) {
            this$0.startRetryAnim();
        }
    }

    public final void hideDownloadErrorTips() {
        getTvErrorTips().setVisibility(8);
        getLlRetry().setVisibility(8);
        getTvOtherTips().setVisibility(8);
    }

    public final void showFuncView(String funcText, View.OnClickListener funcClickListener) {
        Intrinsics.checkNotNullParameter(funcText, "funcText");
        Intrinsics.checkNotNullParameter(funcClickListener, "funcClickListener");
        showFunViewInternal(funcText, null, funcClickListener);
    }

    public static /* synthetic */ void showFuncViewWithTips$default(TapUpdateDialog tapUpdateDialog, String str, CharSequence charSequence, View.OnClickListener onClickListener, int i, Object obj) {
        if ((i & 2) != 0) {
        }
        tapUpdateDialog.showFuncViewWithTips(str, charSequence, onClickListener);
    }

    public final void showFuncViewWithTips(String funcText, CharSequence tipsText, View.OnClickListener funcClickListener) {
        Intrinsics.checkNotNullParameter(funcText, "funcText");
        Intrinsics.checkNotNullParameter(funcClickListener, "funcClickListener");
        showFunViewInternal(funcText, tipsText, funcClickListener);
    }

    @Override // android.app.Dialog
    protected void onStart() {
        Configuration configuration;
        super.onStart();
        Resources resources = getContext().getResources();
        if (resources != null && (configuration = resources.getConfiguration()) != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            setupWindowAttribute(context, 2 == configuration.orientation);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        AnimatorSet animatorSet = this.downloadAnimatorSet;
        if (animatorSet != null) {
            Intrinsics.checkNotNull(animatorSet);
            animatorSet.cancel();
            this.downloadAnimatorSet = null;
        }
    }

    private final void initView() {
        getTvErrorTips().setMovementMethod(LinkMovementMethod.getInstance());
        getTvOtherTips().setMovementMethod(LinkMovementMethod.getInstance());
        getTvFuncTips().setMovementMethod(LinkMovementMethod.getInstance());
        getIvUpdateCancel().setOnClickListener(new View.OnClickListener() { // from class: com.taptap.sdk.update.dialog.TapUpdateDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TapUpdateDialog.initView$lambda$1(this.f$0, view);
            }
        });
        getTvFuncNegative().setOnClickListener(new View.OnClickListener() { // from class: com.taptap.sdk.update.dialog.TapUpdateDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws JSONException {
                TapUpdateDialog.initView$lambda$2(this.f$0, view);
            }
        });
        getTvFuncNegative().setText("取消");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(TapUpdateDialog this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IUpdateCancelListener iUpdateCancelListener = this$0.mUpdateCancelListener;
        if (iUpdateCancelListener != null) {
            iUpdateCancelListener.onUpdateCancel(this$0.dialogState, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(TapUpdateDialog this$0, View it) throws JSONException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.dialogState == TapUpdateDialogState.API_ERROR) {
            UpdateTracker.INSTANCE.trackRequestFailNegativeButtonClick();
        }
        IUpdateCancelListener iUpdateCancelListener = this$0.mUpdateCancelListener;
        if (iUpdateCancelListener != null) {
            iUpdateCancelListener.onUpdateCancel(this$0.dialogState, false);
        }
    }

    private final void showFunViewInternal(String funcText, CharSequence tipsText, View.OnClickListener funcClickListener) {
        getLlReadyContainer().setVisibility(8);
        getLlDownloadContainer().setVisibility(0);
        getLlProgressContainer().setVisibility(8);
        getLlFuncContainer().setVisibility(0);
        getTvFuncButton().setText(funcText);
        getTvFuncButton().setOnClickListener(funcClickListener);
        if (TextUtils.isEmpty(tipsText)) {
            getTvFuncTips().setVisibility(8);
            getTvFuncTips().setText("");
        } else {
            getTvFuncTips().setVisibility(0);
            getTvFuncTips().setText(tipsText);
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
        getFlRootContainer().setLayoutParams(layoutParams);
    }

    private final void showDownloadSpeedAnim() {
        if (this.downloadAnimatorSet == null) {
            ObjectAnimator animator1 = ObjectAnimator.ofFloat(getIvDownloadSpeedTriangle1(), "alpha", 0.3f, 1.0f, 0.3f);
            animator1.setRepeatCount(-1);
            ObjectAnimator animator2 = ObjectAnimator.ofFloat(getIvDownloadSpeedTriangle2(), "alpha", 1.0f, 0.3f, 1.0f);
            animator2.setRepeatCount(-1);
            AnimatorSet animatorSet = new AnimatorSet();
            this.downloadAnimatorSet = animatorSet;
            Intrinsics.checkNotNull(animatorSet);
            animatorSet.setDuration(1000L);
            AnimatorSet animatorSet2 = this.downloadAnimatorSet;
            Intrinsics.checkNotNull(animatorSet2);
            animatorSet2.playTogether(animator1, animator2);
        }
        AnimatorSet animatorSet3 = this.downloadAnimatorSet;
        Intrinsics.checkNotNull(animatorSet3);
        if (!animatorSet3.isRunning()) {
            AnimatorSet animatorSet4 = this.downloadAnimatorSet;
            Intrinsics.checkNotNull(animatorSet4);
            animatorSet4.start();
        }
    }

    private final void stopAnim() {
        AnimatorSet animatorSet = this.downloadAnimatorSet;
        if (animatorSet != null) {
            Intrinsics.checkNotNull(animatorSet);
            if (animatorSet.isRunning()) {
                AnimatorSet animatorSet2 = this.downloadAnimatorSet;
                Intrinsics.checkNotNull(animatorSet2);
                animatorSet2.cancel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView generateLinkView(final UpdateFuncLink linkBean) {
        if (linkBean == null) {
            return null;
        }
        TextView textView = new TextView(getContext());
        textView.setTextSize(1, 12.0f);
        SpannableString ss = new SpannableString(linkBean.getText());
        try {
            ss.setSpan(new ClickableSpan() { // from class: com.taptap.sdk.update.dialog.TapUpdateDialog.generateLinkView.1
                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint ds) {
                    Intrinsics.checkNotNullParameter(ds, "ds");
                    ds.setColor(TapUpdateDialog.this.linkTextColor);
                    ds.setUnderlineText(false);
                }

                @Override // android.text.style.ClickableSpan
                public void onClick(View widget) {
                    Intrinsics.checkNotNullParameter(widget, "widget");
                    try {
                        Uri uri = Uri.parse(linkBean.getUrl());
                        Intent intent = new Intent("android.intent.action.VIEW", uri);
                        TapUpdateDialog.this.getContext().startActivity(intent);
                    } catch (Exception e) {
                        TapLogger.e$default(e.getMessage(), null, 2, null);
                    }
                }
            }, 0, linkBean.getText().length(), 33);
        } catch (Exception e) {
            TapLogger.e$default(e.getMessage(), null, 2, null);
        }
        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        return textView;
    }

    private final void startRetryAnim() {
        Animation rotateAnim = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnim.setDuration(1000L);
        rotateAnim.setRepeatCount(-1);
        rotateAnim.setInterpolator(new LinearInterpolator());
        getIvIconRetry().startAnimation(rotateAnim);
    }

    private final void stopRetryAnim() {
        getIvIconRetry().clearAnimation();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            adapterBlackScreenOnUnity();
        }
    }

    private final void adapterBlackScreenOnUnity() {
        try {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            if (context instanceof Activity) {
                ((Activity) context).onWindowFocusChanged(true);
            } else if (context instanceof ContextThemeWrapper) {
                Context activityCtx = ((ContextThemeWrapper) context).getBaseContext();
                if (activityCtx instanceof Activity) {
                    ((Activity) activityCtx).onWindowFocusChanged(true);
                }
            }
        } catch (Exception e) {
        }
    }
}
