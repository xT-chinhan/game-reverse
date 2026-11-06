package com.taptap.sdk.compilance.widget.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.taptap.sdk.compilance.ComplianceAuthorizationCallback;
import com.taptap.sdk.compilance.R;
import com.taptap.sdk.compilance.TapAuthorizationCallback;
import com.taptap.sdk.compilance.api.TapAuthorizationApi;
import com.taptap.sdk.compilance.bean.IdentityVerifyState;
import com.taptap.sdk.compilance.bean.Prompt;
import com.taptap.sdk.compilance.bean.RealNameConfig;
import com.taptap.sdk.compilance.bean.RealNameText;
import com.taptap.sdk.compilance.constants.BundleKey;
import com.taptap.sdk.compilance.internal.TapComplianceLoggerKt;
import com.taptap.sdk.compilance.internal.TapComplianceSettings;
import com.taptap.sdk.kit.internal.extensions.UIExtKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TapAuthorizationDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0017J\b\u0010\u001e\u001a\u00020\u0006H\u0002J\b\u0010\u001f\u001a\u00020\u0017H\u0016J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u0006H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/taptap/sdk/compilance/widget/dialog/TapAuthorizationDialog;", "Lcom/taptap/sdk/compilance/widget/dialog/AbsDialogFragment;", "()V", "authorizationCallback", "Lcom/taptap/sdk/compilance/ComplianceAuthorizationCallback;", "isTapUser", "", "ivClose", "Landroid/widget/ImageView;", "layoutResId", "", "getLayoutResId", "()I", "rootContainer", "Landroid/widget/ScrollView;", "tvAgreeUseButton", "Landroid/widget/TextView;", "tvDisagreeUseButton", "tvTitle", "useManual", "webContent", "Landroid/webkit/WebView;", "authorizeFromTapTap", "", "handleArgumentsData", "bundle", "Landroid/os/Bundle;", "initView", "view", "Landroid/view/View;", "isManualIdentify", "onDestroy", "setAgreeClickable", "enable", "Companion", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapAuthorizationDialog extends AbsDialogFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private ComplianceAuthorizationCallback authorizationCallback;
    private boolean isTapUser;
    private ImageView ivClose;
    private ScrollView rootContainer;
    private TextView tvAgreeUseButton;
    private TextView tvDisagreeUseButton;
    private TextView tvTitle;
    private boolean useManual;
    private WebView webContent;

    @Override // com.taptap.sdk.compilance.widget.dialog.AbsDialogFragment
    public int getLayoutResId() {
        return R.layout.compliance_dialog_tap_authorization;
    }

    @Override // com.taptap.sdk.compilance.widget.dialog.AbsDialogFragment
    public void initView(View view) {
        RealNameText realNameText;
        if (view == null) {
            return;
        }
        Prompt tapAuth = null;
        this.rootContainer = view instanceof ScrollView ? (ScrollView) view : null;
        this.tvTitle = (TextView) view.findViewById(R.id.tv_title);
        this.ivClose = (ImageView) view.findViewById(R.id.iv_close);
        this.webContent = (WebView) view.findViewById(R.id.web_content);
        this.tvAgreeUseButton = (TextView) view.findViewById(R.id.tv_agree_use_button);
        this.tvDisagreeUseButton = (TextView) view.findViewById(R.id.tv_disagree_use_button);
        UIExtKt.visible(this.ivClose);
        ImageView imageView = this.ivClose;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.taptap.sdk.compilance.widget.dialog.TapAuthorizationDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TapAuthorizationDialog.initView$lambda$0(this.f$0, view2);
                }
            });
        }
        TextView textView = this.tvAgreeUseButton;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.taptap.sdk.compilance.widget.dialog.TapAuthorizationDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TapAuthorizationDialog.initView$lambda$1(this.f$0, view2);
                }
            });
        }
        TextView textView2 = this.tvDisagreeUseButton;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.taptap.sdk.compilance.widget.dialog.TapAuthorizationDialog$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TapAuthorizationDialog.initView$lambda$2(this.f$0, view2);
                }
            });
        }
        WebView webView = this.webContent;
        if (webView != null) {
            webView.setOnTouchListener(new View.OnTouchListener() { // from class: com.taptap.sdk.compilance.widget.dialog.TapAuthorizationDialog$$ExternalSyntheticLambda3
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    return TapAuthorizationDialog.initView$lambda$3(this.f$0, view2, motionEvent);
                }
            });
        }
        RealNameConfig realNameConfig = TapComplianceSettings.INSTANCE.getRealNameConfig();
        if (realNameConfig != null && (realNameText = realNameConfig.getRealNameText()) != null) {
            tapAuth = realNameText.getTapAuth();
        }
        TapComplianceLoggerKt.logInfo("authorization web content: prompt=" + tapAuth);
        if (tapAuth != null) {
            TextView textView3 = this.tvTitle;
            if (textView3 != null) {
                textView3.setText(tapAuth.getTitle());
            }
            String description = tapAuth.getDescription();
            if (description == null) {
                description = "";
            }
            String str = description;
            TapComplianceLoggerKt.logInfo("authorization web content: " + str);
            WebView webView2 = this.webContent;
            if (webView2 != null) {
                webView2.loadDataWithBaseURL(null, str, "text/html", "utf-8", null);
            }
            TextView textView4 = this.tvAgreeUseButton;
            if (textView4 != null) {
                textView4.setText(tapAuth.getPositiveButtonText());
            }
            TextView textView5 = this.tvDisagreeUseButton;
            if (textView5 != null) {
                textView5.setText(tapAuth.getNegativeButtonText());
            }
            if (isManualIdentify()) {
                return;
            }
            UIExtKt.gone(this.tvDisagreeUseButton);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(TapAuthorizationDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ComplianceAuthorizationCallback complianceAuthorizationCallback = this$0.authorizationCallback;
        if (complianceAuthorizationCallback != null) {
            complianceAuthorizationCallback.onCloseRealName();
        }
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(TapAuthorizationDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setAgreeClickable(false);
        this$0.authorizeFromTapTap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(TapAuthorizationDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ComplianceAuthorizationCallback complianceAuthorizationCallback = this$0.authorizationCallback;
        if (complianceAuthorizationCallback != null) {
            complianceAuthorizationCallback.goToRealNameManual(false);
        }
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:35:0x006f  */
    /* JADX WARN: Code duplicated, block: B:37:0x0073  */
    public static final boolean initView$lambda$3(TapAuthorizationDialog this$0, View view, MotionEvent motionEvent) {
        int historySize;
        WebView webView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent.getAction() == 2 && (historySize = motionEvent.getHistorySize()) > 0) {
            boolean z = true;
            int i = motionEvent.getHistoricalY(historySize - 1) > motionEvent.getHistoricalY(0) ? 1 : 0;
            WebView webView2 = this$0.webContent;
            Boolean boolValueOf = webView2 != null ? Boolean.valueOf(webView2.canScrollVertically(i)) : null;
            ScrollView scrollView = this$0.rootContainer;
            Boolean boolValueOf2 = scrollView != null ? Boolean.valueOf(scrollView.canScrollVertically(i)) : null;
            if (i > 0) {
                WebView webView3 = this$0.webContent;
                if (!(webView3 != null && webView3.getScrollY() == 0)) {
                    ScrollView scrollView2 = this$0.rootContainer;
                    Intrinsics.checkNotNull(scrollView2);
                    if (scrollView2.getScrollY() != 0) {
                        webView = this$0.webContent;
                        if (webView != null) {
                            if (!Intrinsics.areEqual((Object) boolValueOf, (Object) true)) {
                                z = false;
                            }
                            webView.requestDisallowInterceptTouchEvent(z);
                        }
                    }
                }
                WebView webView4 = this$0.webContent;
                if (webView4 != null) {
                    webView4.requestDisallowInterceptTouchEvent(!(webView4 != null && webView4.getScrollY() == 0));
                }
            } else {
                webView = this$0.webContent;
                if (webView != null) {
                    if (!Intrinsics.areEqual((Object) boolValueOf, (Object) true) && Intrinsics.areEqual((Object) boolValueOf2, (Object) true)) {
                        z = false;
                    }
                    webView.requestDisallowInterceptTouchEvent(z);
                }
            }
        }
        return false;
    }

    private final void authorizeFromTapTap() {
        TapAuthorizationApi tapAuthorizationApi = TapAuthorizationApi.INSTANCE;
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        tapAuthorizationApi.checkAuthorizationFromTapTap(activity, new TapAuthorizationCallback() { // from class: com.taptap.sdk.compilance.widget.dialog.TapAuthorizationDialog.authorizeFromTapTap.1
            @Override // com.taptap.sdk.compilance.TapAuthorizationCallback
            public void onSuccess(IdentityVerifyState identifyState) {
                Intrinsics.checkNotNullParameter(identifyState, "identifyState");
                ComplianceAuthorizationCallback complianceAuthorizationCallback = TapAuthorizationDialog.this.authorizationCallback;
                if (complianceAuthorizationCallback != null) {
                    complianceAuthorizationCallback.onRealNameSuccess(identifyState);
                }
                TapAuthorizationDialog.this.dismissAllowingStateLoss();
            }

            @Override // com.taptap.sdk.compilance.TapAuthorizationCallback
            public void onCancel() {
                TapAuthorizationDialog.this.setAgreeClickable(true);
            }

            @Override // com.taptap.sdk.compilance.TapAuthorizationCallback
            public void onFail(Throwable e) {
                TapAuthorizationDialog.this.setAgreeClickable(true);
            }

            @Override // com.taptap.sdk.compilance.TapAuthorizationCallback
            public void goToUnderReview() {
                ComplianceAuthorizationCallback complianceAuthorizationCallback = TapAuthorizationDialog.this.authorizationCallback;
                if (complianceAuthorizationCallback != null) {
                    complianceAuthorizationCallback.goToUnderReview();
                }
            }

            @Override // com.taptap.sdk.compilance.TapAuthorizationCallback
            public void goToRealNameManual() {
                ComplianceAuthorizationCallback complianceAuthorizationCallback = TapAuthorizationDialog.this.authorizationCallback;
                if (complianceAuthorizationCallback != null) {
                    complianceAuthorizationCallback.goToRealNameManual(true);
                }
                TapAuthorizationDialog.this.dismissAllowingStateLoss();
            }
        });
    }

    @Override // com.taptap.sdk.compilance.widget.dialog.AbsDialogFragment
    public void handleArgumentsData(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        this.isTapUser = bundle.getBoolean(BundleKey.KEY_IS_TAP_USER);
        this.useManual = bundle.getBoolean(BundleKey.KEY_USE_MANUAL);
    }

    private final boolean isManualIdentify() {
        return !this.isTapUser && this.useManual;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setAgreeClickable(boolean enable) {
        TextView textView = this.tvAgreeUseButton;
        if (textView == null) {
            return;
        }
        textView.setClickable(enable);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        Object objM184constructorimpl;
        super.onDestroy();
        try {
            Result.Companion companion = Result.INSTANCE;
            TapAuthorizationDialog tapAuthorizationDialog = this;
            WebView webView = this.webContent;
            if (webView != null) {
                webView.destroy();
            }
            this.webContent = null;
            objM184constructorimpl = Result.m184constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM184constructorimpl = Result.m184constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM187exceptionOrNullimpl = Result.m187exceptionOrNullimpl(objM184constructorimpl);
        if (thM187exceptionOrNullimpl != null) {
            thM187exceptionOrNullimpl.printStackTrace();
        }
    }

    /* JADX INFO: compiled from: TapAuthorizationDialog.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\n"}, d2 = {"Lcom/taptap/sdk/compilance/widget/dialog/TapAuthorizationDialog$Companion;", "", "()V", "newInstance", "Lcom/taptap/sdk/compilance/widget/dialog/TapAuthorizationDialog;", "isTapUser", "", "useManual", "callback", "Lcom/taptap/sdk/compilance/ComplianceAuthorizationCallback;", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ TapAuthorizationDialog newInstance$default(Companion companion, boolean z, boolean z2, ComplianceAuthorizationCallback complianceAuthorizationCallback, int i, Object obj) {
            if ((i & 4) != 0) {
                complianceAuthorizationCallback = null;
            }
            return companion.newInstance(z, z2, complianceAuthorizationCallback);
        }

        public final TapAuthorizationDialog newInstance(boolean isTapUser, boolean useManual, ComplianceAuthorizationCallback callback) {
            TapAuthorizationDialog tapAuthorizationDialog = new TapAuthorizationDialog();
            Bundle bundle = new Bundle();
            bundle.putBoolean(BundleKey.KEY_IS_TAP_USER, isTapUser);
            bundle.putBoolean(BundleKey.KEY_USE_MANUAL, useManual);
            tapAuthorizationDialog.setArguments(bundle);
            tapAuthorizationDialog.authorizationCallback = callback;
            return tapAuthorizationDialog;
        }
    }
}
