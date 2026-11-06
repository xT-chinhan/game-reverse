package com.smartdigimkt.q2;

import android.content.Context;
import com.smartdigimkt.r4.h;
import com.smartdigimkt.r4.y;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.x.j;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ SDKContext d;

    public b(SDKContext sDKContext, String str, String str2, Context context) {
        this.d = sDKContext;
        this.a = str;
        this.b = str2;
        this.c = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SDKContext sDKContext = this.d;
        String str = this.a;
        String str2 = this.b;
        y.a(sDKContext.c, "sdm_adx_rp_sdk", "sdm_adx_rp_appid", str);
        y.a(sDKContext.c, "sdm_adx_rp_sdk", "sdm_adx_rp_appkey", str2);
        SDKContext.a(this.d);
        j.a().a(this.c, this.d.l);
        Context context = this.c;
        if (context != null) {
            SDKContext sDKContext2 = this.d;
            File file = new File(context.getDir("database", 0), "sdm_adx_rp_webview_db");
            if (!file.exists()) {
                file.mkdirs();
            }
            sDKContext2.I = file.getAbsolutePath();
        }
        try {
            h.a(this.d.k);
            h.h(this.c);
        } catch (Throwable unused) {
        }
    }
}
