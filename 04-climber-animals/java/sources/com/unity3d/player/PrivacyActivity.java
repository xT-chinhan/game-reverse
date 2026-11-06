package com.unity3d.player;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes4.dex */
public class PrivacyActivity extends Activity implements DialogInterface.OnClickListener {
    final String privacyContext = "欢迎使用本游戏，在使用本游戏前，请您充分阅读并理解 <a href=\"http://www.dodobirdio.com/privatelink_new.html\">《隐私协议》</a>\n\n1.保护用户隐私是本游戏的一项基本政策，本游戏不会泄露您的个人信息；\n\n2.我们会根据您使用的具体功能需要，收集必要的用户信息（如申请设备信息，存储等相关权限）；\n\n3.在您同意App隐私政策后，我们将进行集成SDK的初始化工作，会收集您的android_id、Mac地址、IMEI，以保障App正常数据统计和安全风控；\n\n4.您可以阅读完整版的隐私保护政策了解我们申请使用相关权限的情况，以及对您个人隐私的保护措施。\n\n权限使用说明: 电话、定位权限：获取用户地理位置信息，帮助投放定位广告，以此提高用户的广告体验";

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (GetPrivacyAccept()) {
            EnterUnityActivity();
        } else {
            ShowPrivacyDialog();
        }
    }

    private void ShowPrivacyDialog() {
        WebView webView = new WebView(this);
        webView.loadData("欢迎使用本游戏，在使用本游戏前，请您充分阅读并理解 <a href=\"http://www.dodobirdio.com/privatelink_new.html\">《隐私协议》</a>\n\n1.保护用户隐私是本游戏的一项基本政策，本游戏不会泄露您的个人信息；\n\n2.我们会根据您使用的具体功能需要，收集必要的用户信息（如申请设备信息，存储等相关权限）；\n\n3.在您同意App隐私政策后，我们将进行集成SDK的初始化工作，会收集您的android_id、Mac地址、IMEI，以保障App正常数据统计和安全风控；\n\n4.您可以阅读完整版的隐私保护政策了解我们申请使用相关权限的情况，以及对您个人隐私的保护措施。\n\n权限使用说明: 电话、定位权限：获取用户地理位置信息，帮助投放定位广告，以此提高用户的广告体验", "text/html", "utf-8");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setView(webView);
        builder.setTitle("提示");
        builder.setNegativeButton("拒绝", this);
        builder.setPositiveButton("同意", this);
        builder.create().show();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -2) {
            finish();
        } else {
            if (i != -1) {
                return;
            }
            SetPrivacyAccept(true);
            EnterUnityActivity();
        }
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
