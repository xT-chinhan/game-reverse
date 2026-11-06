package com.bytedance.embedapplog;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
final class wq implements pl {
    wq() {
    }

    @Override // com.bytedance.embedapplog.pl
    public boolean ms(Context context) {
        return Build.VERSION.SDK_INT > 28;
    }

    @Override // com.bytedance.embedapplog.pl
    public pl.ms xr(Context context) {
        try {
            ContentProviderClient contentProviderClientAcquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
            if (contentProviderClientAcquireContentProviderClient == null) {
                return null;
            }
            Bundle bundleCall = contentProviderClientAcquireContentProviderClient.call("getOAID", null, null);
            contentProviderClientAcquireContentProviderClient.close();
            if (bundleCall == null) {
                return null;
            }
            if (bundleCall.getInt("code", -1) == 0) {
                pl.ms msVar = new pl.ms();
                msVar.xr = bundleCall.getString("id");
                return msVar;
            }
            String string = bundleCall.getString("message");
            if (!TextUtils.isEmpty(string)) {
                oh.xr(string);
            }
            return null;
        } catch (Exception e) {
            oh.ms(e);
            return null;
        }
    }
}
