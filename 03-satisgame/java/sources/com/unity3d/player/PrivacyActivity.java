package com.unity3d.player;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

/* JADX INFO: loaded from: classes3.dex */
public class PrivacyActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().addFlags(512);
        getWindow().setStatusBarColor(0);
        getWindow().setNavigationBarColor(0);
        getWindow().getDecorView().setSystemUiVisibility(5894);
        if (GetPrivacyAccept()) {
            EnterUnityActivity();
        } else {
            ShowPrivacyDialog();
        }
    }

    private void ShowPrivacyDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_privacy);
        TextView textView = (TextView) dialog.findViewById(R.id.tvContent);
        TextView textView2 = (TextView) dialog.findViewById(R.id.btnReject);
        TextView textView3 = (TextView) dialog.findViewById(R.id.btnAccept);
        textView.setText(Html.fromHtml("我们将通过<a href=\"https://dishudong.cc/privacy_aggrement_cn.html\">《隐私政策》</a>和<a href=\"https://dishudong.cc/user_agreement.html\">《用户协议》</a>向您说明我们对您个人信息的收集、使用、存储、保护等情况以及您享有的相关权利。您同意后，方可使用完整服务。<font color=\"#E65A5A\">点击链接阅读具体协议。</font>"));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(0);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.unity3d.player.PrivacyActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m99lambda$ShowPrivacyDialog$0$comunity3dplayerPrivacyActivity(dialog, view);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.unity3d.player.PrivacyActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m100lambda$ShowPrivacyDialog$1$comunity3dplayerPrivacyActivity(dialog, view);
            }
        });
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.getDecorView().setPadding(0, 0, 0, 0);
            window.setLayout(-1, -1);
            window.setDimAmount(0.0f);
            window.addFlags(Integer.MIN_VALUE);
            window.addFlags(512);
            window.setStatusBarColor(0);
            window.setNavigationBarColor(0);
            window.getDecorView().setSystemUiVisibility(5894);
        }
        dialog.show();
    }

    /* JADX INFO: renamed from: lambda$ShowPrivacyDialog$0$com-unity3d-player-PrivacyActivity, reason: not valid java name */
    /* synthetic */ void m99lambda$ShowPrivacyDialog$0$comunity3dplayerPrivacyActivity(Dialog dialog, View view) {
        dialog.dismiss();
        finish();
    }

    /* JADX INFO: renamed from: lambda$ShowPrivacyDialog$1$com-unity3d-player-PrivacyActivity, reason: not valid java name */
    /* synthetic */ void m100lambda$ShowPrivacyDialog$1$comunity3dplayerPrivacyActivity(Dialog dialog, View view) {
        SetPrivacyAccept(true);
        dialog.dismiss();
        EnterUnityActivity();
    }

    private void EnterUnityActivity() {
        Intent intent = new Intent();
        intent.setClassName(this, "com.unity3d.player.UnityPlayerActivity");
        startActivity(intent);
    }

    private void SetPrivacyAccept(boolean z) {
        SharedPreferences.Editor editorEdit = getSharedPreferences("PlayerPrefs", 0).edit();
        editorEdit.putBoolean("PrivacyAcceptedKey", z);
        editorEdit.apply();
    }

    private boolean GetPrivacyAccept() {
        return getSharedPreferences("PlayerPrefs", 0).getBoolean("PrivacyAcceptedKey", false);
    }
}
