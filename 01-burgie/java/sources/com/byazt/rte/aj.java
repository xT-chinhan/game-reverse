package com.byazt.rte;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.umeng.analytics.pro.an;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 580, 61})
public class aj extends pr {
    public String c;
    public String x;

    public aj(Context context, com.byazt.ew.pr prVar, String str, String str2, String str3) {
        super(context, prVar, str);
        this.x = str2;
        this.c = str3;
    }

    @Override // com.byazt.rte.c
    public Intent hw() {
        String strHn = this.hw.hn(an.aB);
        String strPr = com.byazt.now.hn.pr(this.hw.hn("ak"), strHn);
        String strPr2 = com.byazt.now.hn.pr(this.hw.hn("am"), strHn);
        String strPr3 = com.byazt.now.hn.pr(this.hw.hn("an"), strHn);
        String strSubstring = null;
        if (TextUtils.isEmpty(strPr3) || strPr3.split(",").length != 2) {
            return null;
        }
        String[] strArrSplit = strPr3.split(",");
        String strPr4 = com.byazt.now.hn.pr(this.hw.hn("al"), strHn);
        String strPr5 = com.byazt.now.hn.pr(this.hw.hn(LiveConfigKey.AUDIO), strHn);
        if (TextUtils.isEmpty(strPr5) || strPr5.split(",").length != 2) {
            return null;
        }
        String[] strArrSplit2 = strPr5.split(",");
        JSONObject jSONObjectX = this.hw.x("download_dir");
        if (jSONObjectX != null) {
            String strOptString = jSONObjectX.optString("dir_name");
            if (!TextUtils.isEmpty(strOptString) && strOptString.contains("%s")) {
                try {
                    strSubstring = String.format(strOptString, this.c);
                } catch (Throwable th) {
                    strSubstring = this.c;
                }
            } else {
                strSubstring = this.c;
            }
            if (strSubstring.length() > 255) {
                strSubstring = strPr4.substring(strSubstring.length() - 255);
            }
        }
        Intent intent = new Intent(strPr);
        intent.putExtra(strArrSplit2[0], strArrSplit2[1]);
        intent.putExtra(strPr2, this.x);
        intent.putExtra(strPr4, strSubstring);
        intent.putExtra(strArrSplit[0], Integer.parseInt(strArrSplit[1]));
        intent.addFlags(268468224);
        return intent;
    }
}
