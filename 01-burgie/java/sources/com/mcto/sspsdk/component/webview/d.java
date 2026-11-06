package com.mcto.sspsdk.component.webview;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.EditText;
import com.mcto.sspsdk.internal.Cif;
import com.mcto.sspsdk.internal.hf;
import com.mcto.sspsdk.internal.jf;
import com.mcto.sspsdk.internal.kf;
import com.mcto.sspsdk.internal.r9;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends WebChromeClient {
    public final Context a;
    public final /* synthetic */ QyWebViewPanel b;

    public d(QyWebViewPanel qyWebViewPanel, Context context) {
        this.b = qyWebViewPanel;
        this.a = context;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.a);
            StringBuilder sb = new StringBuilder("来自");
            if (str.length() > 20) {
                str = str.substring(0, 20);
            }
            builder.setTitle(sb.append(str).append("...的消息").toString());
            builder.setMessage(str2).setPositiveButton("确定", (DialogInterface.OnClickListener) null);
            builder.setCancelable(false);
            builder.create().show();
        } catch (Exception e) {
            r9.a("ssp_web_view", "onJsAlert():", e);
        }
        jsResult.confirm();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.a);
            StringBuilder sb = new StringBuilder("来自");
            if (str.length() > 20) {
                str = str.substring(0, 20);
            }
            builder.setTitle(sb.append(str).append("...的消息").toString());
            builder.setMessage(str2).setPositiveButton("确定", new kf(jsResult)).setNegativeButton("取消", new jf(jsResult)).create().show();
            return true;
        } catch (Exception e) {
            r9.a("ssp_web_view", "onJsAlert():", e);
            return true;
        }
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.a);
            StringBuilder sb = new StringBuilder("来自");
            if (str.length() > 20) {
                str = str.substring(0, 20);
            }
            builder.setTitle(sb.append(str).append("...的消息").toString());
            builder.setMessage(str2);
            EditText editText = new EditText(this.a);
            editText.setText(str3);
            builder.setView(editText);
            builder.setPositiveButton("确定", new hf(editText, jsPromptResult));
            builder.setNegativeButton("取消", new Cif(jsPromptResult));
            builder.show();
            return true;
        } catch (Exception e) {
            r9.a("ssp_web_view", "onJsAlert():", e);
            return true;
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView webView, int i) {
        if (this.b.d != null) {
            this.b.d.setProgress(i);
        }
    }
}
