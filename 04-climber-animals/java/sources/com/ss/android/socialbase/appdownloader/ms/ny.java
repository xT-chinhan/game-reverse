package com.ss.android.socialbase.appdownloader.ms;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ny extends ms {
    private String d;
    private String ka;

    public ny(Context context, com.ss.android.socialbase.downloader.ab.ms msVar, String str, String str2, String str3) {
        super(context, msVar, str);
        this.d = str2;
        this.ka = str3;
    }

    @Override // com.ss.android.socialbase.appdownloader.ms.ka
    public Intent xr() {
        String str;
        String strAh = this.xr.ah("s");
        String strMs = com.ss.android.socialbase.appdownloader.c.ah.ms(this.xr.ah("ak"), strAh);
        String strMs2 = com.ss.android.socialbase.appdownloader.c.ah.ms(this.xr.ah("am"), strAh);
        String strMs3 = com.ss.android.socialbase.appdownloader.c.ah.ms(this.xr.ah("an"), strAh);
        String strSubstring = null;
        if (!TextUtils.isEmpty(strMs3) && strMs3.split(",").length == 2) {
            String[] strArrSplit = strMs3.split(",");
            String strMs4 = com.ss.android.socialbase.appdownloader.c.ah.ms(this.xr.ah("al"), strAh);
            String strMs5 = com.ss.android.socialbase.appdownloader.c.ah.ms(this.xr.ah(LiveConfigKey.AUDIO), strAh);
            if (!TextUtils.isEmpty(strMs5) && strMs5.split(",").length == 2) {
                String[] strArrSplit2 = strMs5.split(",");
                JSONObject jSONObjectD = this.xr.d("download_dir");
                if (jSONObjectD != null) {
                    String strOptString = jSONObjectD.optString("dir_name");
                    if (TextUtils.isEmpty(strOptString) || !strOptString.contains("%s")) {
                        str = this.ka;
                    } else {
                        try {
                            str = String.format(strOptString, this.ka);
                        } catch (Throwable unused) {
                            str = this.ka;
                        }
                    }
                    strSubstring = str;
                    if (strSubstring.length() > 255) {
                        strSubstring = strMs4.substring(strSubstring.length() - 255);
                    }
                }
                Intent intent = new Intent(strMs);
                intent.putExtra(strArrSplit2[0], strArrSplit2[1]);
                intent.putExtra(strMs2, this.d);
                intent.putExtra(strMs4, strSubstring);
                intent.putExtra(strArrSplit[0], Integer.parseInt(strArrSplit[1]));
                intent.addFlags(268468224);
                return intent;
            }
        }
        return null;
    }
}
