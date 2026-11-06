package com.byazt.cr;

import android.content.Context;
import com.byazt.ivn.w;
import com.byazt.lk.l;
import com.byazt.vk.s;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 753, 19})
public final class n {
    public static void n(Context context, final String str, w wVar) {
        com.byazt.vk.w.n().n(context);
        com.byazt.vk.w.n().n(new com.byazt.vk.qg() { // from class: com.byazt.cr.n.1
            @Override // com.byazt.vk.qg
            public String n(String str2, String str3, String str4) {
                return l.n(str, str2).getString(str3, str4);
            }

            @Override // com.byazt.vk.qg
            public void qg(String str2, String str3, String str4) {
                l.n(str, str2).n(str3, str4);
            }
        });
        com.byazt.vk.w.n().n(new s() { // from class: com.byazt.cr.n.2
            @Override // com.byazt.vk.s
            public void n(String str2, final JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                com.byazt.eji.s.n().n(new com.byazt.rs.n() { // from class: com.byazt.cr.n.2.1
                    @Override // com.byazt.rs.n
                    public JSONObject n(JSONObject jSONObject2) throws JSONException {
                        return jSONObject;
                    }
                }, str2);
            }
        });
        n(wVar.oa(), wVar.sz());
    }

    public static void n(int i, boolean z) {
        com.byazt.vk.w.n().n(i);
        com.byazt.vk.w.n().n(z);
    }
}
