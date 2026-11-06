package com.smartdigimkt.x3;

import android.content.Context;
import android.text.TextUtils;
import com.smartdigimkt.r4.h;
import com.smartdigimkt.sdk.api.IntegrationCheckListener;
import com.smartdigimkt.sdk.core.SDKContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Runnable {
    public final /* synthetic */ IntegrationCheckListener a;
    public final /* synthetic */ Map b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ b d;

    public a(b bVar, IntegrationCheckListener integrationCheckListener, Map map, Context context) {
        this.d = bVar;
        this.a = integrationCheckListener;
        this.b = map;
        this.c = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.d.b) {
            if (this.d.c != null) {
                if (this.a != null) {
                    b bVar = this.d;
                    String str = bVar.a;
                    if (TextUtils.isEmpty(bVar.c)) {
                        this.a.onValidationSucceed();
                    } else {
                        this.a.onValidationFail(this.d.c);
                    }
                }
                return;
            }
            try {
                h.a(new HashMap(this.b));
            } catch (Throwable unused) {
            }
            b bVar2 = this.d;
            Context context = this.c;
            bVar2.getClass();
            ArrayList arrayList = new ArrayList();
            arrayList.add("sdm_myoffer_full_screen");
            arrayList.add("sdm_myoffer_splash_ad_layout_asseblem_vertical_port");
            String strA = b.a(context, arrayList, SDKContext.getInstance().h);
            String str2 = this.d.a;
            TextUtils.isEmpty(strA);
            if (this.a != null) {
                String str3 = this.d.a;
                if (TextUtils.isEmpty(strA)) {
                    this.d.c = "";
                    this.a.onValidationSucceed();
                } else {
                    this.d.c = "The " + strA + " resources are missing, If shrinkResources is enabled, the " + strA + " resources must be added to the whitelist (keep.xml)";
                    this.a.onValidationFail(this.d.c);
                }
            }
        }
    }
}
