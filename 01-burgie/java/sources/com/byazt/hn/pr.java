package com.byazt.hn;

import android.content.Context;
import com.byazt.is.w;
import com.byazt.qn.x;
import com.byazt.rwn.hn;
import com.byazt.rwn.uc;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 20, 37})
public final class pr {
    public static void pr(Context context, final String str, w wVar) {
        uc.pr().pr(context);
        uc.pr().pr(new com.byazt.rwn.hw() { // from class: com.byazt.hn.pr.1
            @Override // com.byazt.rwn.hw
            public String pr(String str2, String str3, String str4) {
                return x.pr(str, str2).getString(str3, str4);
            }

            @Override // com.byazt.rwn.hw
            public void hw(String str2, String str3, String str4) {
                x.pr(str, str2).pr(str3, str4);
            }
        });
        uc.pr().pr(new hn() { // from class: com.byazt.hn.pr.2
            @Override // com.byazt.rwn.hn
            public void pr(String str2, final JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                com.byazt.xk.hw.pr().pr(new com.byazt.ttf.pr() { // from class: com.byazt.hn.pr.2.1
                    @Override // com.byazt.ttf.pr
                    public JSONObject pr(JSONObject jSONObject2) throws JSONException {
                        return jSONObject;
                    }
                }, str2);
            }
        });
        pr(wVar.m(), wVar.g());
    }

    public static void pr(int i, boolean z) {
        uc.pr().pr(i);
        uc.pr().pr(z);
    }
}
