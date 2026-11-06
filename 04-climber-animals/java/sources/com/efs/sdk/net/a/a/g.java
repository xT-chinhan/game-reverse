package com.efs.sdk.net.a.a;

import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.net.NetManager;
import java.io.InputStream;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements f {
    private static AtomicInteger a = new AtomicInteger(0);
    private static g c;
    private b b = new b();

    public static g b() {
        if (c == null) {
            c = new g();
        }
        return c;
    }

    private g() {
    }

    @Override // com.efs.sdk.net.a.a.f
    public final void a(f.b bVar) {
        Log.d("NetTrace-Interceptor", "request will be sent");
        b bVar2 = this.b;
        try {
            String strA = bVar.a();
            bVar2.a.put(bVar.a(), Long.valueOf(System.currentTimeMillis()));
            Log.i("NetTrace-Interceptor", "save request");
            com.efs.sdk.net.a.c cVarA = com.efs.sdk.net.a.a.a().a(strA);
            String strB = bVar.b();
            if (!TextUtils.isEmpty(strB)) {
                cVarA.d = strB;
            }
            cVarA.e = bVar.c();
            HashMap map = new HashMap();
            int iE = bVar.e();
            for (int i = 0; i < iE; i++) {
                map.put(bVar.a(i), bVar.b(i));
            }
            if (NetManager.getNetConfigManager().getNetRequestHeaderCollectState()) {
                cVarA.f = map;
            }
            cVarA.g = b.a(bVar);
            if (NetManager.getNetConfigManager().getNetRequestBodyCollectState()) {
                if ((cVarA.e == null || !cVarA.e.equalsIgnoreCase("get")) && cVarA.e != null && cVarA.e.equalsIgnoreCase("post") && cVarA.g < 10240) {
                    if (map.containsKey("Content-Type") || map.containsKey("content-type")) {
                        String str = (String) map.get("Content-Type");
                        if (TextUtils.isEmpty(str)) {
                            str = (String) map.get("content-type");
                        }
                        if (str != null) {
                            if (str.contains("application/json") || str.contains(ShareTarget.ENCODING_TYPE_URL_ENCODED)) {
                                cVarA.h = new String(bVar.d());
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.efs.sdk.net.a.a.f
    public final void a(f.d dVar) {
        Log.d("NetTrace-Interceptor", "response headers received");
        b bVar = this.b;
        Log.i("NetTrace-Interceptor", "save response");
        String strA = dVar.a();
        if (bVar.a != null) {
            com.efs.sdk.net.a.c cVarA = com.efs.sdk.net.a.a.a().a(strA);
            cVarA.i = dVar.b();
            try {
                if (NetManager.getNetConfigManager().getNetResponseHeaderCollectState()) {
                    HashMap map = new HashMap();
                    int iE = dVar.e();
                    for (int i = 0; i < iE; i++) {
                        map.put(dVar.a(i), dVar.b(i));
                    }
                    cVarA.l = map;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.efs.sdk.net.a.a.f
    public final InputStream a(String str, String str2, String str3, InputStream inputStream) {
        Log.d("NetTrace-Interceptor", "interpret response stream");
        return b.a(str, str2, str3, inputStream);
    }

    @Override // com.efs.sdk.net.a.a.f
    public final void a() {
        Log.d("NetTrace-Interceptor", "data sent");
    }
}
