package com.taptap.sdk.compliance.widget.dialog;

import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.taptap.sdk.compliance.HealthReminderCallback;
import com.taptap.sdk.compliance.R;
import com.taptap.sdk.compliance.bean.Prompt;
import com.taptap.sdk.compliance.bean.RealNameConfig;
import com.taptap.sdk.compliance.bean.RealNameText;
import com.taptap.sdk.compliance.constants.BundleKey;
import com.taptap.sdk.compliance.internal.TapComplianceInternal;
import com.taptap.sdk.compliance.internal.TapComplianceSettings;
import com.taptap.sdk.kit.internal.extensions.UIExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HealthReminderDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/taptap/sdk/compliance/widget/dialog/HealthReminderDialog;", "Lcom/taptap/sdk/compliance/widget/dialog/AbsDialogFragment;", "()V", "currentLimitType", "", BundleKey.DESCRIPTION, "", "layoutResId", "getLayoutResId", "()I", "negativeButtonStr", "positiveButtonStr", "reminderCallback", "Lcom/taptap/sdk/compliance/HealthReminderCallback;", BundleKey.TITLE, "tvFunctionButton", "Landroid/widget/TextView;", "tvLimitTips", "tvSwitchAccountButton", "tvTitle", "handleArgumentsData", "", "bundle", "Landroid/os/Bundle;", "initView", "view", "Landroid/view/View;", "updateButtonView", "Companion", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class HealthReminderDialog extends AbsDialogFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private int currentLimitType;
    private HealthReminderCallback reminderCallback;
    private TextView tvFunctionButton;
    private TextView tvLimitTips;
    private TextView tvSwitchAccountButton;
    private TextView tvTitle;
    private String title = "";
    private String description = "";
    private String negativeButtonStr = "";
    private String positiveButtonStr = "";

    @Override // com.taptap.sdk.compliance.widget.dialog.AbsDialogFragment
    public int getLayoutResId() {
        return R.layout.compliance_dialog_health_reminder;
    }

    @Override // com.taptap.sdk.compliance.widget.dialog.AbsDialogFragment
    public void initView(View view) {
        Prompt prompt;
        RealNameText realNameText;
        if (view == null) {
            return;
        }
        this.tvTitle = (TextView) view.findViewById(R.id.tv_title);
        this.tvLimitTips = (TextView) view.findViewById(R.id.tv_limit_tips);
        this.tvSwitchAccountButton = (TextView) view.findViewById(R.id.tv_switch_account_button);
        this.tvFunctionButton = (TextView) view.findViewById(R.id.tv_function_button);
        TextView textView = this.tvLimitTips;
        if (textView != null) {
            textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        }
        TextView textView2 = this.tvSwitchAccountButton;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.taptap.sdk.compliance.widget.dialog.HealthReminderDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    HealthReminderDialog.initView$lambda$0(this.f$0, view2);
                }
            });
        }
        TextView textView3 = this.tvFunctionButton;
        if (textView3 != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.taptap.sdk.compliance.widget.dialog.HealthReminderDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    HealthReminderDialog.initView$lambda$1(this.f$0, view2);
                }
            });
        }
        updateButtonView();
        if (!TapComplianceInternal.INSTANCE.getShowSwitchAccount()) {
            UIExtKt.gone(this.tvSwitchAccountButton);
        }
        TextView textView4 = this.tvSwitchAccountButton;
        boolean z = false;
        if (textView4 != null && textView4.getVisibility() == 0) {
            z = true;
        }
        if (!z) {
            TextView textView5 = this.tvFunctionButton;
            if (textView5 != null) {
                textView5.setBackgroundResource(R.drawable.compliance_alert_positive_bg);
            }
            TextView textView6 = this.tvFunctionButton;
            if (textView6 != null) {
                textView6.setTextColor(-1);
            }
        }
        if (this.currentLimitType == 1002) {
            RealNameConfig realNameConfig = TapComplianceSettings.INSTANCE.getRealNameConfig();
            prompt = (realNameConfig == null || (realNameText = realNameConfig.getRealNameText()) == null) ? null : realNameText.getAuthWaiting();
        } else {
            prompt = new Prompt(this.title, this.description, this.negativeButtonStr, this.positiveButtonStr);
        }
        if (prompt != null) {
            Prompt it = prompt;
            TextView textView7 = this.tvTitle;
            if (textView7 != null) {
                textView7.setText(it.getTitle());
            }
            TextView textView8 = this.tvLimitTips;
            if (textView8 != null) {
                textView8.setText(Html.fromHtml(it.getDescription()));
            }
            TextView textView9 = this.tvFunctionButton;
            if (textView9 == null) {
                return;
            }
            textView9.setText(it.getPositiveButtonText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(HealthReminderDialog this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TapComplianceInternal.INSTANCE.switchAccount();
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(HealthReminderDialog this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        switch (this$0.currentLimitType) {
            case 1002:
                HealthReminderCallback healthReminderCallback = this$0.reminderCallback;
                if (healthReminderCallback != null) {
                    healthReminderCallback.checkPending();
                    return;
                }
                return;
            case 1003:
                this$0.getActivity().finishAffinity();
                System.exit(0);
                throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
            case 1004:
                HealthReminderCallback healthReminderCallback2 = this$0.reminderCallback;
                if (healthReminderCallback2 != null) {
                    healthReminderCallback2.enterGame();
                    return;
                }
                return;
            case 1005:
                this$0.dismissAllowingStateLoss();
                return;
            default:
                return;
        }
    }

    @Override // com.taptap.sdk.compliance.widget.dialog.AbsDialogFragment
    public void handleArgumentsData(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        this.currentLimitType = bundle.getInt(BundleKey.KEY_LIMIT_TYPE);
        String string = bundle.getString(BundleKey.KEY_TITLE, "");
        Intrinsics.checkNotNullExpressionValue(string, "bundle.getString(BundleKey.KEY_TITLE, \"\")");
        this.title = string;
        String string2 = bundle.getString(BundleKey.KEY_DESCRIPTION, "");
        Intrinsics.checkNotNullExpressionValue(string2, "bundle.getString(BundleKey.KEY_DESCRIPTION, \"\")");
        this.description = string2;
        String string3 = bundle.getString(BundleKey.KEY_NEGATIVE_BUTTON, "");
        Intrinsics.checkNotNullExpressionValue(string3, "bundle.getString(BundleK….KEY_NEGATIVE_BUTTON, \"\")");
        this.negativeButtonStr = string3;
        String string4 = bundle.getString(BundleKey.KEY_POSITIVE_BUTTON, "");
        Intrinsics.checkNotNullExpressionValue(string4, "bundle.getString(BundleK….KEY_POSITIVE_BUTTON, \"\")");
        this.positiveButtonStr = string4;
    }

    private final void updateButtonView() {
        UIExtKt.visible(this.tvFunctionButton);
        switch (this.currentLimitType) {
            case 1004:
            case 1005:
                UIExtKt.gone(this.tvSwitchAccountButton);
                break;
            default:
                UIExtKt.visible(this.tvSwitchAccountButton);
                break;
        }
    }

    /* JADX INFO: compiled from: HealthReminderDialog.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JD\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¨\u0006\u000e"}, d2 = {"Lcom/taptap/sdk/compliance/widget/dialog/HealthReminderDialog$Companion;", "", "()V", "newInstance", "Lcom/taptap/sdk/compliance/widget/dialog/HealthReminderDialog;", "limitType", "", BundleKey.TITLE, "", BundleKey.DESCRIPTION, "positiveText", "negativeText", "reminderCallback", "Lcom/taptap/sdk/compliance/HealthReminderCallback;", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ HealthReminderDialog newInstance$default(Companion companion, int i, String str, String str2, String str3, String str4, HealthReminderCallback healthReminderCallback, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = 0;
            }
            return companion.newInstance(i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? "" : str3, (i2 & 16) == 0 ? str4 : "", (i2 & 32) != 0 ? null : healthReminderCallback);
        }

        public final HealthReminderDialog newInstance(int limitType, String title, String description, String positiveText, String negativeText, HealthReminderCallback reminderCallback) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(description, "description");
            Intrinsics.checkNotNullParameter(positiveText, "positiveText");
            Intrinsics.checkNotNullParameter(negativeText, "negativeText");
            HealthReminderDialog dialog = new HealthReminderDialog();
            Bundle $this$newInstance_u24lambda_u240 = new Bundle();
            $this$newInstance_u24lambda_u240.putInt(BundleKey.KEY_LIMIT_TYPE, limitType);
            $this$newInstance_u24lambda_u240.putString(BundleKey.KEY_TITLE, title);
            $this$newInstance_u24lambda_u240.putString(BundleKey.KEY_DESCRIPTION, description);
            $this$newInstance_u24lambda_u240.putString(BundleKey.KEY_NEGATIVE_BUTTON, negativeText);
            $this$newInstance_u24lambda_u240.putString(BundleKey.KEY_POSITIVE_BUTTON, positiveText);
            dialog.setArguments($this$newInstance_u24lambda_u240);
            dialog.reminderCallback = reminderCallback;
            return dialog;
        }
    }
}
