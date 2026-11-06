package com.smartdigimkt.i2;

import android.content.DialogInterface;
import android.webkit.GeolocationPermissions;

/* JADX INFO: loaded from: classes3.dex */
public final class v implements DialogInterface.OnClickListener {
    public final /* synthetic */ GeolocationPermissions.Callback a;
    public final /* synthetic */ String b;

    public v(String str, GeolocationPermissions.Callback callback) {
        this.a = callback;
        this.b = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        GeolocationPermissions.Callback callback = this.a;
        if (callback != null) {
            callback.invoke(this.b, false, false);
        }
    }
}
