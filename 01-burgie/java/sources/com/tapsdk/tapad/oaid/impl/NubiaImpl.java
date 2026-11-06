package com.tapsdk.tapad.oaid.impl;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.byazt.mg.PluginConstants;
import com.tapsdk.tapad.oaid.IGetter;
import com.tapsdk.tapad.oaid.IOAID;
import com.tapsdk.tapad.oaid.OAIDException;

/* JADX INFO: loaded from: classes3.dex */
class NubiaImpl implements IOAID {
    private final Context context;

    public NubiaImpl(Context context) {
        this.context = context;
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public void doGet(IGetter iGetter) {
        try {
            ContentProviderClient contentProviderClientAcquireContentProviderClient = this.context.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
            if (contentProviderClientAcquireContentProviderClient == null) {
                throw new OAIDException("Nubia identity provider not found");
            }
            Bundle bundleCall = contentProviderClientAcquireContentProviderClient.call("getOAID", null, null);
            if (Build.VERSION.SDK_INT >= 24) {
                contentProviderClientAcquireContentProviderClient.close();
            } else {
                contentProviderClientAcquireContentProviderClient.release();
            }
            if (bundleCall == null) {
                throw new OAIDException("OAID query failed: bundle is null");
            }
            String string = bundleCall.getInt(PluginConstants.KEY_ERROR_CODE, -1) == 0 ? bundleCall.getString("id") : null;
            if (string == null || string.length() == 0) {
                throw new OAIDException("OAID query failed: " + bundleCall.getString("message"));
            }
            iGetter.onOAIDGetComplete(string);
        } catch (Throwable th) {
            iGetter.onOAIDGetError(new OAIDException(th));
        }
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public String getName() {
        return "Nubia";
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public void supported() {
        if (Build.VERSION.SDK_INT < 29) {
            throw new OAIDException("Only supports Android 10.0 and above for Nubia");
        }
    }
}
