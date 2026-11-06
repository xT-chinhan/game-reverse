package com.byazt.xev;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.byazt.mg.PluginConstants;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 75, 19})
public final class ho implements yb {
    @Override // com.byazt.xev.yb
    public boolean hw(Context context) {
        return Build.VERSION.SDK_INT > 28;
    }

    @Override // com.byazt.xev.yb
    public yb.pr hn(Context context) {
        Bundle bundleCall;
        Uri uri = Uri.parse("content://cn.nubia.identity/identity");
        try {
            if (Build.VERSION.SDK_INT <= 17) {
                bundleCall = context.getContentResolver().call(uri, "getOAID", (String) null, (Bundle) null);
            } else {
                ContentProviderClient contentProviderClientAcquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(uri);
                if (contentProviderClientAcquireContentProviderClient == null) {
                    return null;
                }
                bundleCall = contentProviderClientAcquireContentProviderClient.call("getOAID", null, null);
                if (Build.VERSION.SDK_INT >= 24) {
                    contentProviderClientAcquireContentProviderClient.close();
                } else {
                    contentProviderClientAcquireContentProviderClient.release();
                }
            }
            if (bundleCall == null) {
                return null;
            }
            if (bundleCall.getInt(PluginConstants.KEY_ERROR_CODE, -1) == 0) {
                yb.pr prVar = new yb.pr();
                prVar.hw = bundleCall.getString("id");
                return prVar;
            }
            String string = bundleCall.getString("message");
            if (!TextUtils.isEmpty(string)) {
                com.byazt.ec.w.hw(string);
            }
            return null;
        } catch (Exception e) {
            com.byazt.ec.w.pr(e);
            return null;
        }
    }
}
