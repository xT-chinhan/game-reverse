package com.mar.sdk.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mar.sdk.MARSDK;
import com.mar.sdk.SDKParams;
import com.mar.sdk.permission.MARProtocolActivity;
import com.mar.sdk.utils.ResourceHelper;
import com.mar.sdk.verify.UPrivacy;

/* JADX INFO: loaded from: classes2.dex */
public class PrivacyDialog extends Dialog {
    private Button btnClose;
    private Activity mActivity;
    private TextView txtContent;
    private TextView txtPrivaceTips;
    private TextView txtTitle;
    private UPrivacy uPrivacy;

    public PrivacyDialog(Activity context, UPrivacy u) {
        super(context, ResourceHelper.getIdentifier(context, "R.style.mar_dialog_with_alpha"));
        this.mActivity = context;
        this.uPrivacy = u;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        setContentView(ResourceHelper.getIdentifier(this.mActivity, "R.layout.mar_privacy_layout"));
        this.txtTitle = (TextView) findViewById(ResourceHelper.getIdentifier(this.mActivity, "R.id.txtTitle"));
        this.txtContent = (TextView) findViewById(ResourceHelper.getIdentifier(this.mActivity, "R.id.txtContent"));
        this.txtPrivaceTips = (TextView) findViewById(ResourceHelper.getIdentifier(this.mActivity, "R.id.txtPrivaceTips"));
        this.btnClose = (Button) findViewById(ResourceHelper.getIdentifier(this.mActivity, "R.id.btnClose"));
        LinearLayout layout = (LinearLayout) findViewById(ResourceHelper.getIdentifier(this.mActivity, "R.id.mar_privacy_lay"));
        TextView txtCode = (TextView) findViewById(ResourceHelper.getIdentifier(this.mActivity, "R.id.mar_privacy_code"));
        if (!TextUtils.isEmpty(this.uPrivacy.getAppBeianCode()) && !TextUtils.isEmpty(this.uPrivacy.getAppBeianUrl())) {
            layout.setVisibility(0);
            txtCode.setText(this.uPrivacy.getAppBeianCode());
            txtCode.setOnClickListener(new View.OnClickListener() { // from class: com.mar.sdk.dialog.PrivacyDialog.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MARProtocolActivity.showBeiAn(PrivacyDialog.this.mActivity, PrivacyDialog.this.uPrivacy.getAppBeianUrl());
                }
            });
        }
        SDKParams sdkParams = MARSDK.getInstance().getSDKParams();
        if (sdkParams != null) {
            boolean isv = sdkParams.contains("HUAWEI_DEREGISTER") ? sdkParams.getBoolean("HUAWEI_DEREGISTER").booleanValue() : false;
            if (isv) {
                Button deregister = (Button) findViewById(ResourceHelper.getIdentifier(this.mActivity, "R.id.txtderegister"));
                deregister.setVisibility(0);
                deregister.setOnClickListener(new View.OnClickListener() { // from class: com.mar.sdk.dialog.PrivacyDialog.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        DeregisterDialog dialog = new DeregisterDialog(PrivacyDialog.this.mActivity);
                        dialog.show();
                        PrivacyDialog.this.dismiss();
                    }
                });
            }
        }
        this.btnClose.setOnClickListener(new View.OnClickListener() { // from class: com.mar.sdk.dialog.PrivacyDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                PrivacyDialog.this.dismiss();
            }
        });
        String text = this.uPrivacy.getContent();
        if (text != null && !text.equals("") && text.contains("<p>")) {
            this.txtContent.setMovementMethod(ScrollingMovementMethod.getInstance());
            if (Build.VERSION.SDK_INT >= 24) {
                this.txtContent.setText(Html.fromHtml(text, 0));
            } else {
                this.txtContent.setText(Html.fromHtml(text));
            }
        } else {
            this.txtContent.setText("");
        }
        SpannableStringBuilder builder = new SpannableStringBuilder("请您阅读并同意");
        int length = builder.length();
        builder.setSpan(new ForegroundColorSpan(Color.parseColor("#ffffff")), 0, length, 18);
        SpannableString protocol = new SpannableString("《隐私政策》");
        int lengthprotocol = protocol.length();
        protocol.setSpan(new ClickableSpan() { // from class: com.mar.sdk.dialog.PrivacyDialog.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                MARProtocolActivity.showProtocol(PrivacyDialog.this.mActivity, PrivacyDialog.this.uPrivacy.getPrivacyAgreementPath());
            }
        }, 0, lengthprotocol, 33);
        protocol.setSpan(new UnderlineSpan() { // from class: com.mar.sdk.dialog.PrivacyDialog.5
            @Override // android.text.style.UnderlineSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint ds) {
                ds.setColor(Color.parseColor("#00bfff"));
                ds.setUnderlineText(true);
            }
        }, 0, lengthprotocol, 33);
        SpannableStringBuilder builder2 = new SpannableStringBuilder("和");
        int length2 = builder2.length();
        builder2.setSpan(new ForegroundColorSpan(Color.parseColor("#ffffff")), 0, length2, 18);
        SpannableString protocol2 = new SpannableString("《用户协议》");
        int lengthprotocol2 = protocol2.length();
        protocol2.setSpan(new ClickableSpan() { // from class: com.mar.sdk.dialog.PrivacyDialog.6
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                MARProtocolActivity.showUserAgreement(PrivacyDialog.this.mActivity, PrivacyDialog.this.uPrivacy.getUserAgreementPath());
            }
        }, 0, lengthprotocol2, 33);
        protocol2.setSpan(new UnderlineSpan() { // from class: com.mar.sdk.dialog.PrivacyDialog.7
            @Override // android.text.style.UnderlineSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint ds) {
                ds.setColor(Color.parseColor("#00bfff"));
                ds.setUnderlineText(true);
            }
        }, 0, lengthprotocol2, 33);
        builder.append((CharSequence) protocol).append((CharSequence) builder2).append((CharSequence) protocol2);
        this.txtPrivaceTips.setText(builder);
        this.txtPrivaceTips.setMovementMethod(LinkMovementMethod.getInstance());
        this.txtPrivaceTips.setHighlightColor(0);
    }
}
