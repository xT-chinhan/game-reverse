package com.ss.android.socialbase.appdownloader.ms;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class zb extends ms {
    public zb(Context context, com.ss.android.socialbase.downloader.ab.ms msVar, String str) {
        super(context, msVar, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.ms.ka
    public Intent xr() {
        String strAh = this.xr.ah("s");
        String strMs = com.ss.android.socialbase.appdownloader.c.ah.ms(this.xr.ah("bb"), strAh);
        if (!TextUtils.isEmpty(strMs) && strMs.split(",").length == 2) {
            String strMs2 = com.ss.android.socialbase.appdownloader.c.ah.ms(this.xr.ah("bc"), strAh);
            if (!TextUtils.isEmpty(strMs2) && strMs2.split(",").length == 2) {
                String[] strArrSplit = strMs.split(",");
                String[] strArrSplit2 = strMs2.split(",");
                String strMs3 = com.ss.android.socialbase.appdownloader.c.ah.ms(this.xr.ah("bd"), strAh);
                String strMs4 = com.ss.android.socialbase.appdownloader.c.ah.ms(this.xr.ah("be"), strAh);
                String strMs5 = com.ss.android.socialbase.appdownloader.c.ah.ms(this.xr.ah("bf"), strAh);
                HashMap map = new HashMap();
                map.put(strArrSplit[0], strArrSplit[1]);
                map.put(strArrSplit2[0], strArrSplit2[1]);
                map.put(strMs3, this.ah);
                Intent intent = new Intent();
                intent.setAction(strMs5);
                intent.setData(Uri.parse(strMs4 + ms(map)));
                intent.addFlags(268468224);
                return intent;
            }
        }
        return null;
    }

    public static String ms(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            stringBuffer.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue()));
            stringBuffer.append("&");
        }
        String string = stringBuffer.toString();
        return string.endsWith("&") ? string.substring(0, string.length() - 1) : string;
    }
}
