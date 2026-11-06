package com.taptap.sdk.compilance.widget.dialog;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.Layout;
import android.text.SpannableString;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.taptap.sdk.compilance.R;
import com.taptap.sdk.compilance.RealNameVerifyCallback;
import com.taptap.sdk.compilance.api.IdentityVerifyApi;
import com.taptap.sdk.compilance.bean.IdentityVerifyInfo;
import com.taptap.sdk.compilance.bean.IdentityVerifyState;
import com.taptap.sdk.compilance.bean.IdentityVerifyStateKt;
import com.taptap.sdk.compilance.bean.Prompt;
import com.taptap.sdk.compilance.bean.RealNameConfig;
import com.taptap.sdk.compilance.bean.RealNameText;
import com.taptap.sdk.compilance.constants.BundleKey;
import com.taptap.sdk.compilance.extensions.SystemExtKt;
import com.taptap.sdk.compilance.internal.TapComplianceLoggerKt;
import com.taptap.sdk.compilance.internal.TapComplianceSettings;
import com.taptap.sdk.compilance.widget.ComplianceUIHelper;
import com.taptap.sdk.kit.internal.TapTapKit;
import com.taptap.sdk.kit.internal.callback.TapTapCallback;
import com.taptap.sdk.kit.internal.exception.TapTapException;
import com.taptap.sdk.kit.internal.extensions.UIExtKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: RealNameVerifyDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001e\u001a\u00020\bH\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0012\u0010#\u001a\u00020 2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\bH\u0002J\u0012\u0010'\u001a\u00020 2\b\u0010(\u001a\u0004\u0018\u00010%H\u0016J\b\u0010)\u001a\u00020 H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/taptap/sdk/compilance/widget/dialog/RealNameVerifyDialog;", "Lcom/taptap/sdk/compilance/widget/dialog/AbsDialogFragment;", "Landroid/view/View$OnClickListener;", "()V", "etUserIdentification", "Landroid/widget/EditText;", "etUserRealName", "hasAuthRecord", "", "isIdentificationInfoVerifying", "ivClose", "Landroid/widget/ImageView;", "layoutResId", "", "getLayoutResId", "()I", "llDetailTips", "Landroid/widget/LinearLayout;", "realNameCallback", "Lcom/taptap/sdk/compilance/RealNameVerifyCallback;", "tvDetailInformationTips", "Landroid/widget/TextView;", "tvFunctionButton", "tvRealNameTips", "tvTitle", "tvUserAuthorizationVerifyingTips", "userEditIdentificationInfo", "Lcom/taptap/sdk/compilance/bean/IdentityVerifyInfo;", "userIdentifier", "", "checkIdentityInfo", "handleArgumentsData", "", "bundle", "Landroid/os/Bundle;", "initView", "view", "Landroid/view/View;", "isDetailTipsShowing", "onClick", "v", "requestIdentityVerifyInfo", "Companion", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RealNameVerifyDialog extends AbsDialogFragment implements View.OnClickListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int DETAIL_TIPS_MAX_LINE = 3;
    private static final String TIPS_SUFFIX = " 详细内容";
    private EditText etUserIdentification;
    private EditText etUserRealName;
    private boolean hasAuthRecord;
    private boolean isIdentificationInfoVerifying;
    private ImageView ivClose;
    private LinearLayout llDetailTips;
    private RealNameVerifyCallback realNameCallback;
    private TextView tvDetailInformationTips;
    private TextView tvFunctionButton;
    private TextView tvRealNameTips;
    private TextView tvTitle;
    private TextView tvUserAuthorizationVerifyingTips;
    private final IdentityVerifyInfo userEditIdentificationInfo = new IdentityVerifyInfo((Integer) null, (String) null, (String) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
    private String userIdentifier;

    @Override // com.taptap.sdk.compilance.widget.dialog.AbsDialogFragment
    public int getLayoutResId() {
        return R.layout.compliance_dialog_real_name;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0092  */
    @Override // com.taptap.sdk.compilance.widget.dialog.AbsDialogFragment
    public void initView(View view) {
        RealNameText realNameText;
        Prompt manualAuth;
        RealNameText realNameText2;
        if (view == null) {
            return;
        }
        this.tvTitle = (TextView) view.findViewById(R.id.tv_title);
        this.ivClose = (ImageView) view.findViewById(R.id.iv_close);
        this.tvRealNameTips = (TextView) view.findViewById(R.id.tv_real_name_tips);
        this.etUserRealName = (EditText) view.findViewById(R.id.et_user_real_name);
        this.etUserIdentification = (EditText) view.findViewById(R.id.et_user_identification);
        this.tvFunctionButton = (TextView) view.findViewById(R.id.tv_function_button);
        this.tvUserAuthorizationVerifyingTips = (TextView) view.findViewById(R.id.tv_user_authorization_verifying_tips);
        this.llDetailTips = (LinearLayout) view.findViewById(R.id.ll_detail_tips);
        TextView textView = (TextView) view.findViewById(R.id.tv_detail_information_tips);
        this.tvDetailInformationTips = textView;
        if (textView != null) {
            textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        }
        if (this.hasAuthRecord) {
            RealNameConfig realNameConfig = TapComplianceSettings.INSTANCE.getRealNameConfig();
            if (realNameConfig == null || (realNameText2 = realNameConfig.getRealNameText()) == null) {
                manualAuth = null;
            } else {
                manualAuth = realNameText2.getAuthFailed();
            }
        } else {
            RealNameConfig realNameConfig2 = TapComplianceSettings.INSTANCE.getRealNameConfig();
            if (realNameConfig2 == null || (realNameText = realNameConfig2.getRealNameText()) == null) {
                manualAuth = null;
            } else {
                manualAuth = realNameText.getManualAuth();
            }
        }
        if (manualAuth != null) {
            TextView textView2 = this.tvTitle;
            if (textView2 != null) {
                textView2.setText(manualAuth.getTitle());
            }
            TextView textView3 = this.tvRealNameTips;
            if (textView3 != null) {
                textView3.setText(Html.fromHtml(manualAuth.getDescription()));
            }
            TextView textView4 = this.tvDetailInformationTips;
            if (textView4 != null) {
                textView4.setText(Html.fromHtml(manualAuth.getDescription()));
            }
            TextView textView5 = this.tvFunctionButton;
            if (textView5 != null) {
                textView5.setText(manualAuth.getPositiveButtonText());
            }
        }
        SystemExtKt.runOnMain(new AnonymousClass2(null));
        UIExtKt.visible(this.ivClose);
        ImageView imageView = this.ivClose;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        TextView textView6 = this.tvRealNameTips;
        if (textView6 != null) {
            textView6.setOnClickListener(this);
        }
        TextView textView7 = this.tvFunctionButton;
        if (textView7 != null) {
            textView7.setOnClickListener(this);
        }
    }

    /* JADX INFO: renamed from: com.taptap.sdk.compilance.widget.dialog.RealNameVerifyDialog$initView$2, reason: invalid class name */
    /* JADX INFO: compiled from: RealNameVerifyDialog.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.compilance.widget.dialog.RealNameVerifyDialog$initView$2", f = "RealNameVerifyDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return RealNameVerifyDialog.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (!RealNameVerifyDialog.this.hasAuthRecord) {
                    TextView textView = RealNameVerifyDialog.this.tvRealNameTips;
                    if ((textView != null ? textView.getLineCount() : 0) > 3) {
                        TextView textView2 = RealNameVerifyDialog.this.tvRealNameTips;
                        Layout layout = textView2 != null ? textView2.getLayout() : null;
                        int lineEnd = ((layout != null ? layout.getLineEnd(2) : 0) - 5) - 3;
                        StringBuilder sb = new StringBuilder();
                        TextView textView3 = RealNameVerifyDialog.this.tvRealNameTips;
                        String strSubstring = String.valueOf(textView3 != null ? textView3.getText() : null).substring(0, lineEnd);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                        String string = sb.append(strSubstring).append("... 详细内容").toString();
                        SpannableString spannableString = new SpannableString(string);
                        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) string, RealNameVerifyDialog.TIPS_SUFFIX, 0, false, 6, (Object) null);
                        int i = iIndexOf$default + 5;
                        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#00D9C5")), iIndexOf$default, i, 33);
                        spannableString.setSpan(new StyleSpan(1), iIndexOf$default, i, 33);
                        TextView textView4 = RealNameVerifyDialog.this.tvRealNameTips;
                        if (textView4 != null) {
                            textView4.setText(spannableString);
                        }
                    }
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final boolean isDetailTipsShowing() {
        LinearLayout linearLayout = this.llDetailTips;
        if (!(linearLayout != null && linearLayout.getVisibility() == 0)) {
            return false;
        }
        UIExtKt.gone(this.llDetailTips);
        return true;
    }

    @Override // com.taptap.sdk.compilance.widget.dialog.AbsDialogFragment
    public void handleArgumentsData(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        this.userIdentifier = bundle.getString(BundleKey.KEY_USER_IDENTIFIER);
        this.hasAuthRecord = bundle.getBoolean(BundleKey.KEY_HAS_AUTH_RECORD);
    }

    private final boolean checkIdentityInfo() {
        Editable editableText;
        Editable editableText2;
        EditText editText = this.etUserRealName;
        String string = null;
        String string2 = (editText == null || (editableText2 = editText.getEditableText()) == null) ? null : editableText2.toString();
        String str = string2;
        if (str == null || str.length() == 0) {
            ComplianceUIHelper.INSTANCE.showToast(TapTapKit.INSTANCE.getContext(), "姓名不能为空");
            return false;
        }
        EditText editText2 = this.etUserIdentification;
        if (editText2 != null && (editableText = editText2.getEditableText()) != null) {
            string = editableText.toString();
        }
        String str2 = string;
        if (str2 == null || str2.length() == 0) {
            ComplianceUIHelper.INSTANCE.showToast(TapTapKit.INSTANCE.getContext(), "身份信息不能为空");
            return false;
        }
        this.userEditIdentificationInfo.setName(string2);
        this.userEditIdentificationInfo.setIdCard(string);
        return true;
    }

    /* JADX INFO: compiled from: RealNameVerifyDialog.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/taptap/sdk/compilance/widget/dialog/RealNameVerifyDialog$Companion;", "", "()V", "DETAIL_TIPS_MAX_LINE", "", "TIPS_SUFFIX", "", "newInstance", "Lcom/taptap/sdk/compilance/widget/dialog/RealNameVerifyDialog;", "userIdentity", "hasAuthRecord", "", "callback", "Lcom/taptap/sdk/compilance/RealNameVerifyCallback;", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ RealNameVerifyDialog newInstance$default(Companion companion, String str, boolean z, RealNameVerifyCallback realNameVerifyCallback, int i, Object obj) {
            if ((i & 1) != 0) {
                str = "";
            }
            if ((i & 2) != 0) {
                z = false;
            }
            if ((i & 4) != 0) {
                realNameVerifyCallback = null;
            }
            return companion.newInstance(str, z, realNameVerifyCallback);
        }

        public final RealNameVerifyDialog newInstance(String userIdentity, boolean hasAuthRecord, RealNameVerifyCallback callback) {
            Intrinsics.checkNotNullParameter(userIdentity, "userIdentity");
            RealNameVerifyDialog realNameVerifyDialog = new RealNameVerifyDialog();
            Bundle bundle = new Bundle();
            bundle.putString(BundleKey.KEY_USER_IDENTIFIER, userIdentity);
            bundle.putBoolean(BundleKey.KEY_HAS_AUTH_RECORD, hasAuthRecord);
            realNameVerifyDialog.setArguments(bundle);
            realNameVerifyDialog.realNameCallback = callback;
            return realNameVerifyDialog;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (isDetailTipsShowing()) {
            return;
        }
        if (Intrinsics.areEqual(v, this.ivClose)) {
            RealNameVerifyCallback realNameVerifyCallback = this.realNameCallback;
            if (realNameVerifyCallback != null) {
                realNameVerifyCallback.onCloseRealName();
            }
            dismissAllowingStateLoss();
            return;
        }
        if (Intrinsics.areEqual(v, this.tvRealNameTips)) {
            if (this.hasAuthRecord) {
                return;
            }
            UIExtKt.visible(this.llDetailTips);
        } else if (Intrinsics.areEqual(v, this.tvFunctionButton)) {
            if (this.isIdentificationInfoVerifying) {
                dismissAllowingStateLoss();
            } else if (checkIdentityInfo()) {
                requestIdentityVerifyInfo();
            }
        }
    }

    private final void requestIdentityVerifyInfo() {
        String name = this.userEditIdentificationInfo.getName();
        String idCard = this.userEditIdentificationInfo.getIdCard();
        boolean z = true;
        if (name.length() == 0) {
            return;
        }
        String str = idCard;
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (z) {
            return;
        }
        IdentityVerifyApi.INSTANCE.requestIdentityVerifyInfoManually(name, idCard, new TapTapCallback<IdentityVerifyState>() { // from class: com.taptap.sdk.compilance.widget.dialog.RealNameVerifyDialog.requestIdentityVerifyInfo.1
            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onCancel() {
                TapTapCallback.DefaultImpls.onCancel(this);
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onSuccess(IdentityVerifyState result) {
                RealNameText realNameText;
                Intrinsics.checkNotNullParameter(result, "result");
                TapComplianceLoggerKt.logInfo("requestIdentityVerifyInfoManually success: result=" + result);
                String verifyState = result.getVerifyState();
                if (Intrinsics.areEqual(verifyState, IdentityVerifyStateKt.VERIFY_STATE_SUCCESS)) {
                    ComplianceUIHelper.INSTANCE.showToast(TapTapKit.INSTANCE.getContext(), "提交成功");
                    RealNameVerifyCallback realNameVerifyCallback = RealNameVerifyDialog.this.realNameCallback;
                    if (realNameVerifyCallback != null) {
                        realNameVerifyCallback.onRealNameResult(result);
                    }
                    RealNameVerifyDialog.this.dismissAllowingStateLoss();
                    return;
                }
                if (Intrinsics.areEqual(verifyState, IdentityVerifyStateKt.VERIFY_STATE_WAITING)) {
                    RealNameVerifyDialog.this.isIdentificationInfoVerifying = true;
                    UIExtKt.visible(RealNameVerifyDialog.this.tvUserAuthorizationVerifyingTips);
                    UIExtKt.gone(RealNameVerifyDialog.this.tvRealNameTips);
                    UIExtKt.gone(RealNameVerifyDialog.this.etUserRealName);
                    UIExtKt.gone(RealNameVerifyDialog.this.etUserIdentification);
                    RealNameConfig realNameConfig = TapComplianceSettings.INSTANCE.getRealNameConfig();
                    Prompt authWaiting = (realNameConfig == null || (realNameText = realNameConfig.getRealNameText()) == null) ? null : realNameText.getAuthWaiting();
                    if (authWaiting != null) {
                        TextView textView = RealNameVerifyDialog.this.tvUserAuthorizationVerifyingTips;
                        if (textView != null) {
                            textView.setText(Html.fromHtml(authWaiting.getDescription()));
                        }
                        TextView textView2 = RealNameVerifyDialog.this.tvFunctionButton;
                        if (textView2 == null) {
                            return;
                        }
                        textView2.setText(authWaiting.getPositiveButtonText());
                        return;
                    }
                    return;
                }
                RealNameVerifyDialog.this.isIdentificationInfoVerifying = false;
                ComplianceUIHelper.INSTANCE.showToast(TapTapKit.INSTANCE.getContext(), "认证未通过，请提交真实信息");
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onFail(TapTapException exception) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                TapComplianceLoggerKt.logInfo("requestIdentityVerifyInfoManually failed: cause=" + exception.getMessage());
                ComplianceUIHelper.INSTANCE.showToast(TapTapKit.INSTANCE.getContext(), "认证未通过，请提交真实信息");
            }
        });
    }
}
