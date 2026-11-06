package com.smartdigimkt.q1;

import android.app.Activity;
import android.content.Intent;
import android.webkit.GeolocationPermissions;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.smartdigimkt.i2.x;
import com.smartdigimkt.sdk.basead.ui.animplayerview.WebLandpagePlayerView;

/* JADX INFO: loaded from: classes3.dex */
public final class s extends WebChromeClient {
    public final /* synthetic */ WebLandpagePlayerView a;

    public s(WebLandpagePlayerView webLandpagePlayerView) {
        this.a = webLandpagePlayerView;
    }

    @Override // android.webkit.WebChromeClient
    public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        x.a(this.a.getContext(), str, callback);
        super.onGeolocationPermissionsShowPrompt(str, callback);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onShowFileChooser(WebView webView, ValueCallback valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        try {
            this.a.L = valueCallback;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*", "audio/*"});
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("image/* video/* audio/*");
            if (!(this.a.getContext() instanceof Activity)) {
                return true;
            }
            ((Activity) this.a.getContext()).startActivityForResult(Intent.createChooser(intent, "File Chooser"), 512);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
