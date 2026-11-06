package com.efs.sdk.base.core.f;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.http.HttpResponse;
import com.taptap.sdk.update.download.core.Util;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements com.efs.sdk.base.core.c.c {
    @Override // com.efs.sdk.base.core.c.c
    @NonNull
    public final HttpResponse a(com.efs.sdk.base.core.d.b bVar, boolean z) {
        HttpResponse httpResponse = null;
        try {
            c cVar = f.a.a.a;
            String strValueOf = String.valueOf(System.currentTimeMillis());
            String strA = com.efs.sdk.base.core.util.b.b.a(cVar.b + cVar.c + strValueOf + "AppChk#2014");
            StringBuilder sb = new StringBuilder();
            String str = cVar.a;
            if (str.startsWith("http")) {
                sb.append(str);
                sb.append("?chk=");
            } else {
                sb.append(str);
                sb.append("?chk=");
            }
            sb.append(strA.substring(strA.length() - 8));
            sb.append("&vno=");
            sb.append(strValueOf);
            sb.append("&uuid=");
            sb.append(cVar.c);
            sb.append("&app=");
            sb.append(cVar.b);
            sb.append("&zip=gzip");
            String string = sb.toString();
            int length = 0;
            byte[] bArrA = new byte[0];
            if (bVar.a.c != 0) {
                if (1 == bVar.a.c) {
                    bArrA = com.efs.sdk.base.core.util.b.a(bVar.d.getPath());
                    length = bArrA.length;
                }
            } else {
                bArrA = bVar.c;
                length = bArrA.length;
            }
            HashMap map = new HashMap();
            map.put("Content-Type", "application/x-www-form-urlencoded");
            map.put(Util.CONTENT_LENGTH, String.valueOf(length));
            com.efs.sdk.base.core.util.a.d dVarA = new com.efs.sdk.base.core.util.a.d(string).a(map);
            dVarA.a.c = bArrA;
            HttpResponse httpResponseB = dVarA.a().b();
            try {
                a(httpResponseB);
                if (httpResponseB.succ) {
                    Log.i("efs.base", "wa upload succ, " + httpResponseB.toString());
                    com.efs.sdk.base.core.util.b.b(bVar.d);
                    return httpResponseB;
                }
                Log.i("efs.base", "wa upload fail, resp is " + httpResponseB.toString());
                return httpResponseB;
            } catch (Throwable th) {
                th = th;
                httpResponse = httpResponseB;
                if (httpResponse == null) {
                    httpResponse = new HttpResponse();
                }
                HttpResponse httpResponse2 = httpResponse;
                Log.e("efs.wa.send", "get file size error", th);
                return httpResponse2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void a(HttpResponse httpResponse) {
        if (httpResponse == null || TextUtils.isEmpty(httpResponse.data)) {
            return;
        }
        for (String str : httpResponse.data.split("`")) {
            String[] strArrSplit = str.split("=");
            if (strArrSplit.length >= 2) {
                if (strArrSplit[0].equalsIgnoreCase("retcode")) {
                    httpResponse.setBizCode(strArrSplit[1]);
                } else {
                    ((Map) httpResponse.extra).put(strArrSplit[0], strArrSplit[1]);
                }
            }
        }
    }
}
