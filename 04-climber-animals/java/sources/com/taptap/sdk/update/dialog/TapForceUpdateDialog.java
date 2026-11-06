package com.taptap.sdk.update.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.taptap.sdk.kit.internal.extensions.SysExtKt;
import com.taptap.sdk.kit.internal.extensions.UIExtKt;
import com.taptap.sdk.update.R;
import com.taptap.sdk.update.bean.ForceUpdateResult;
import com.taptap.sdk.update.extension.SystemExtKt;
import com.taptap.sdk.update.internal.UpdateTracker;
import com.taptap.sdk.update.utils.UIUtilKt;
import com.umeng.analytics.pro.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONException;

/* JADX INFO: compiled from: TapForceUpdateDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 +2\u00020\u0001:\u0001+B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\b\u0010&\u001a\u00020\bH\u0002J\b\u0010'\u001a\u00020\bH\u0014J\u0018\u0010(\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010)\u001a\u00020*H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0011\u0010\rR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000f\u001a\u0004\b\u001e\u0010\rR\u001b\u0010 \u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u000f\u001a\u0004\b!\u0010\rR\u001b\u0010#\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u000f\u001a\u0004\b$\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/taptap/sdk/update/dialog/TapForceUpdateDialog;", "Landroid/app/Dialog;", g.X, "Landroid/content/Context;", "updateInfo", "Lcom/taptap/sdk/update/bean/ForceUpdateResult;", "onUpdateConfirm", "Lkotlin/Function0;", "", "(Landroid/content/Context;Lcom/taptap/sdk/update/bean/ForceUpdateResult;Lkotlin/jvm/functions/Function0;)V", "exitGame", "Landroid/widget/TextView;", "getExitGame", "()Landroid/widget/TextView;", "exitGame$delegate", "Lkotlin/Lazy;", "gameVersion", "getGameVersion", "gameVersion$delegate", "rootContainer", "Landroid/widget/LinearLayout;", "getRootContainer", "()Landroid/widget/LinearLayout;", "rootContainer$delegate", "tipsContainer", "Landroid/view/ViewGroup;", "getTipsContainer", "()Landroid/view/ViewGroup;", "tipsContainer$delegate", "updateConfirm", "getUpdateConfirm", "updateConfirm$delegate", "updateContent", "getUpdateContent", "updateContent$delegate", "updateDate", "getUpdateDate", "updateDate$delegate", "initView", "onStart", "setupWindowAttribute", "isLandscape", "", "Companion", "tap-update_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapForceUpdateDialog extends Dialog {
    private static final float DEFAULT_HEIGHT = 128.0f;
    private static final float DEFAULT_WIDTH = 320.0f;
    private final Context context;

    /* JADX INFO: renamed from: exitGame$delegate, reason: from kotlin metadata */
    private final Lazy exitGame;

    /* JADX INFO: renamed from: gameVersion$delegate, reason: from kotlin metadata */
    private final Lazy gameVersion;
    private final Function0<Unit> onUpdateConfirm;

    /* JADX INFO: renamed from: rootContainer$delegate, reason: from kotlin metadata */
    private final Lazy rootContainer;

    /* JADX INFO: renamed from: tipsContainer$delegate, reason: from kotlin metadata */
    private final Lazy tipsContainer;

    /* JADX INFO: renamed from: updateConfirm$delegate, reason: from kotlin metadata */
    private final Lazy updateConfirm;

    /* JADX INFO: renamed from: updateContent$delegate, reason: from kotlin metadata */
    private final Lazy updateContent;

    /* JADX INFO: renamed from: updateDate$delegate, reason: from kotlin metadata */
    private final Lazy updateDate;
    private final ForceUpdateResult updateInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TapForceUpdateDialog(Context context, ForceUpdateResult updateInfo, Function0<Unit> onUpdateConfirm) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(updateInfo, "updateInfo");
        Intrinsics.checkNotNullParameter(onUpdateConfirm, "onUpdateConfirm");
        this.context = context;
        this.updateInfo = updateInfo;
        this.onUpdateConfirm = onUpdateConfirm;
        this.rootContainer = LazyKt.lazy(new Function0<LinearLayout>() { // from class: com.taptap.sdk.update.dialog.TapForceUpdateDialog$rootContainer$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                return (LinearLayout) this.this$0.findViewById(R.id.force_update_root);
            }
        });
        this.exitGame = LazyKt.lazy(new Function0<TextView>() { // from class: com.taptap.sdk.update.dialog.TapForceUpdateDialog$exitGame$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) this.this$0.findViewById(R.id.force_update_exit);
            }
        });
        this.updateConfirm = LazyKt.lazy(new Function0<TextView>() { // from class: com.taptap.sdk.update.dialog.TapForceUpdateDialog$updateConfirm$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) this.this$0.findViewById(R.id.force_update_confirm);
            }
        });
        this.gameVersion = LazyKt.lazy(new Function0<TextView>() { // from class: com.taptap.sdk.update.dialog.TapForceUpdateDialog$gameVersion$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) this.this$0.findViewById(R.id.force_update_game_version);
            }
        });
        this.updateDate = LazyKt.lazy(new Function0<TextView>() { // from class: com.taptap.sdk.update.dialog.TapForceUpdateDialog$updateDate$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) this.this$0.findViewById(R.id.force_update_date);
            }
        });
        this.updateContent = LazyKt.lazy(new Function0<TextView>() { // from class: com.taptap.sdk.update.dialog.TapForceUpdateDialog$updateContent$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) this.this$0.findViewById(R.id.force_update_content);
            }
        });
        this.tipsContainer = LazyKt.lazy(new Function0<ViewGroup>() { // from class: com.taptap.sdk.update.dialog.TapForceUpdateDialog$tipsContainer$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewGroup invoke() {
                return (ViewGroup) this.this$0.findViewById(R.id.tips_container);
            }
        });
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            attributes.gravity = 17;
            window.setAttributes(attributes);
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.requestFeature(1);
        }
        setContentView(R.layout.tapupdate_dialog_force_update);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        initView();
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.taptap.sdk.update.dialog.TapForceUpdateDialog$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) throws JSONException {
                TapForceUpdateDialog._init_$lambda$1(dialogInterface);
            }
        });
    }

    private final LinearLayout getRootContainer() {
        Object value = this.rootContainer.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-rootContainer>(...)");
        return (LinearLayout) value;
    }

    private final TextView getExitGame() {
        Object value = this.exitGame.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-exitGame>(...)");
        return (TextView) value;
    }

    private final TextView getUpdateConfirm() {
        Object value = this.updateConfirm.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-updateConfirm>(...)");
        return (TextView) value;
    }

    private final TextView getGameVersion() {
        Object value = this.gameVersion.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-gameVersion>(...)");
        return (TextView) value;
    }

    private final TextView getUpdateDate() {
        Object value = this.updateDate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-updateDate>(...)");
        return (TextView) value;
    }

    private final TextView getUpdateContent() {
        Object value = this.updateContent.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-updateContent>(...)");
        return (TextView) value;
    }

    private final ViewGroup getTipsContainer() {
        Object value = this.tipsContainer.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-tipsContainer>(...)");
        return (ViewGroup) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(DialogInterface dialogInterface) throws JSONException {
        UpdateTracker.INSTANCE.trackView("tap_force_update_confirm_dialog");
    }

    private final void initView() {
        UIExtKt.setDebounceClickListener$default(getExitGame(), 0L, new Function1<View, Unit>() { // from class: com.taptap.sdk.update.dialog.TapForceUpdateDialog.initView.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) throws JSONException {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) throws JSONException {
                Intrinsics.checkNotNullParameter(it, "it");
                UpdateTracker.INSTANCE.trackClick("tap_force_update_confirm_dialog", "tap_update_quit_but");
                SystemExtKt.runOnMainWithDelay(300L, new C06561(null));
            }

            /* JADX INFO: renamed from: com.taptap.sdk.update.dialog.TapForceUpdateDialog$initView$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: TapForceUpdateDialog.kt */
            @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
            @DebugMetadata(c = "com.taptap.sdk.update.dialog.TapForceUpdateDialog$initView$1$1", f = "TapForceUpdateDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            static final class C06561 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
                int label;

                C06561(Continuation<? super C06561> continuation) {
                    super(1, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Continuation<?> continuation) {
                    return new C06561(continuation);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Continuation<? super Unit> continuation) {
                    return ((C06561) create(continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    System.exit(0);
                    throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
                }
            }
        }, 1, null);
        UIExtKt.setDebounceClickListener$default(getUpdateConfirm(), 0L, new Function1<View, Unit>() { // from class: com.taptap.sdk.update.dialog.TapForceUpdateDialog.initView.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) throws JSONException {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) throws JSONException {
                Intrinsics.checkNotNullParameter(it, "it");
                UpdateTracker.INSTANCE.trackClick("tap_force_update_confirm_dialog", "tap_update_confirm_but");
                TapForceUpdateDialog.this.onUpdateConfirm.invoke();
            }
        }, 1, null);
        getGameVersion().setText(this.updateInfo.getForceUpdateInfo().getVersionName());
        getUpdateDate().setText(SysExtKt.toDateString$default(this.updateInfo.getForceUpdateInfo().getReleaseTime(), null, 1, null));
        getUpdateContent().setMovementMethod(new ScrollingMovementMethod());
        getUpdateContent().setText(this.updateInfo.getForceUpdateInfo().getWhatsNew());
        if (SysExtKt.isTapInstalled()) {
            UIExtKt.gone(getTipsContainer());
        } else {
            UIExtKt.visible(getTipsContainer());
        }
    }

    @Override // android.app.Dialog
    protected void onStart() {
        Configuration configuration;
        super.onStart();
        Resources resources = this.context.getResources();
        if (resources == null || (configuration = resources.getConfiguration()) == null) {
            return;
        }
        setupWindowAttribute(this.context, 2 == configuration.orientation);
    }

    private final void setupWindowAttribute(Context context, boolean isLandscape) {
        int iCoerceAtMost;
        ViewGroup.LayoutParams layoutParams = getRootContainer().getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        int px = com.taptap.sdk.update.extension.UIExtKt.toPx(15.0f);
        int screenWidth = UIUtilKt.getScreenWidth(context) - px;
        int screenHeight = UIUtilKt.getScreenHeight(context) - px;
        int i = -2;
        if (isLandscape) {
            iCoerceAtMost = RangesKt.coerceAtMost(com.taptap.sdk.update.extension.UIExtKt.toPx(320.0f), screenHeight);
            if (com.taptap.sdk.update.extension.UIExtKt.toPx(DEFAULT_HEIGHT) <= screenHeight) {
                screenHeight = -2;
            }
            i = screenHeight;
        } else {
            iCoerceAtMost = RangesKt.coerceAtMost(com.taptap.sdk.update.extension.UIExtKt.toPx(320.0f), screenWidth);
        }
        layoutParams.width = iCoerceAtMost;
        layoutParams.height = i;
        getRootContainer().setLayoutParams(layoutParams);
    }
}
