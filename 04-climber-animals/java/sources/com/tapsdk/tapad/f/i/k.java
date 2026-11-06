package com.tapsdk.tapad.f.i;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

/* JADX INFO: loaded from: classes3.dex */
class k implements com.tapsdk.tapad.f.b {
    private final Context a;

    public k(Context context) {
        this.a = context;
    }

    @Override // com.tapsdk.tapad.f.b
    public void a() {
        if (Build.VERSION.SDK_INT < 29) {
            throw new com.tapsdk.tapad.f.c("Only supports Android 10.0 and above for Nubia");
        }
    }

    @Override // com.tapsdk.tapad.f.b
    public void a(com.tapsdk.tapad.f.a aVar) {
        try {
            ContentProviderClient contentProviderClientAcquireContentProviderClient = this.a.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
            if (contentProviderClientAcquireContentProviderClient == null) {
                return;
            }
            Bundle bundleCall = contentProviderClientAcquireContentProviderClient.call("getOAID", null, null);
            contentProviderClientAcquireContentProviderClient.close();
            if (bundleCall == null) {
                throw new com.tapsdk.tapad.f.c("OAID query failed: bundle is null");
            }
            String string = bundleCall.getInt("code", -1) == 0 ? bundleCall.getString("id") : null;
            if (string == null || string.length() == 0) {
                throw new com.tapsdk.tapad.f.c("OAID query failed: " + bundleCall.getString("message"));
            }
            aVar.a(string);
        } catch (Throwable th) {
            aVar.a(new com.tapsdk.tapad.f.c(th));
        }
    }

    @Override // com.tapsdk.tapad.f.b
    public String l() {
        return "Nubia";
    }
}
