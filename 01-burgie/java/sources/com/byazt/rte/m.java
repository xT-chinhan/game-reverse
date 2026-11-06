package com.byazt.rte;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.umeng.analytics.pro.an;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 580, 108})
public class m extends pr {
    public m(Context context, com.byazt.ew.pr prVar, String str) {
        super(context, prVar, str);
    }

    @Override // com.byazt.rte.c
    public Intent hw() {
        String strHn = this.hw.hn(an.aB);
        String strPr = com.byazt.now.hn.pr(this.hw.hn("bb"), strHn);
        if (TextUtils.isEmpty(strPr) || strPr.split(",").length != 2) {
            return null;
        }
        String strPr2 = com.byazt.now.hn.pr(this.hw.hn("bc"), strHn);
        if (TextUtils.isEmpty(strPr2) || strPr2.split(",").length != 2) {
            return null;
        }
        String[] strArrSplit = strPr.split(",");
        String[] strArrSplit2 = strPr2.split(",");
        String strPr3 = com.byazt.now.hn.pr(this.hw.hn("bd"), strHn);
        String strPr4 = com.byazt.now.hn.pr(this.hw.hn("be"), strHn);
        String strPr5 = com.byazt.now.hn.pr(this.hw.hn("bf"), strHn);
        HashMap map = new HashMap();
        map.put(strArrSplit[0], strArrSplit[1]);
        map.put(strArrSplit2[0], strArrSplit2[1]);
        map.put(strPr3, this.hn);
        Intent intent = new Intent();
        intent.setAction(strPr5);
        intent.setData(Uri.parse(strPr4 + pr(map)));
        intent.addFlags(268468224);
        return intent;
    }

    public static String pr(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            stringBuffer.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue()));
            stringBuffer.append("&");
        }
        String string = stringBuffer.toString();
        if (string.endsWith("&")) {
            return string.substring(0, string.length() - 1);
        }
        return string;
    }
}
