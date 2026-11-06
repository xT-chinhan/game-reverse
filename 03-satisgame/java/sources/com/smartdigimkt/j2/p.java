package com.smartdigimkt.j2;

import android.content.Intent;
import android.text.TextUtils;
import android.webkit.GeolocationPermissions;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;
import com.smartdigimkt.i2.x;
import com.smartdigimkt.sdk.basead.ui.web.WebLandPageActivity;

/* JADX INFO: loaded from: classes3.dex */
public final class p extends WebChromeClient {
    public final /* synthetic */ WebLandPageActivity a;

    public p(WebLandPageActivity webLandPageActivity) {
        this.a = webLandPageActivity;
    }

    @Override // android.webkit.WebChromeClient
    public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        x.a(this.a, str, callback);
        super.onGeolocationPermissionsShowPrompt(str, callback);
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView webView, int i) {
        WebLandPageActivity webLandPageActivity = this.a;
        if (webLandPageActivity.b != null) {
            if (!webLandPageActivity.h.isRunning()) {
                this.a.b.setProgress(((i * 30) / 100) + 70);
            }
            if (i == 100) {
                if (this.a.h.isRunning()) {
                    this.a.h.cancel();
                    this.a.b.setProgress(100);
                }
                com.smartdigimkt.q3.f.a().a(200L, new o(this));
            }
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onReceivedTitle(WebView webView, String str) {
        TextView textView;
        super.onReceivedTitle(webView, str);
        if (TextUtils.isEmpty(str) || (textView = this.a.f) == null || textView.getText().toString().length() != 0) {
            return;
        }
        this.a.f.setText(str);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onShowFileChooser(WebView webView, ValueCallback valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        try {
            this.a.z = valueCallback;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*", "audio/*"});
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("image/* video/* audio/*");
            this.a.startActivityForResult(Intent.createChooser(intent, "File Chooser"), 512);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
