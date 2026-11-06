package com.smartdigimkt.r;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: loaded from: classes3.dex */
public final class x {
    public final Context a;

    public x(Context context) {
        this.a = context;
    }

    public final String a() {
        try {
            ContentProviderClient contentProviderClientAcquireContentProviderClient = this.a.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
            Bundle bundleCall = contentProviderClientAcquireContentProviderClient.call("getOAID", null, null);
            contentProviderClientAcquireContentProviderClient.close();
            return (bundleCall == null || bundleCall.getInt("code", -1) != 0) ? "" : bundleCall.getString("id");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }
}
