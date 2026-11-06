package com.byazt.zs;

import android.support.v4.app.NotificationCompat;
import android.util.Log;
import com.byazt.mg.PluginConstants;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 14, 108})
public class m implements k {
    public static final m pr = new m();
    public Map<String, Object> hw = new ConcurrentHashMap(1);

    @Override // com.byazt.zs.k
    public void pr(String str, Throwable th) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("key", str);
            jSONObject2.put(NotificationCompat.CATEGORY_MESSAGE, "sv cr failed");
            jSONObject.put("object", jSONObject2);
            jSONObject.put("scene", "ats_b");
            if (th != null) {
                jSONObject.put("exception", Log.getStackTraceString(th));
            }
        } catch (JSONException e) {
        }
        pr(jSONObject);
    }

    @Override // com.byazt.zs.k
    public void pr(g gVar, int i, String str, Throwable th) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", gVar.uc);
            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, str);
            jSONObject.put("type", i);
        } catch (JSONException e) {
        }
        pr("ats_b_proxy", jSONObject, th);
    }

    @Override // com.byazt.zs.k
    public void pr(g gVar, Object obj, Object obj2, boolean z, JSONObject jSONObject, Throwable th) {
        Map<String, Object> map;
        if (gVar != null && obj2 != null && (map = this.hw) != null) {
            map.put(gVar.uc, obj2);
        }
    }

    @Override // com.byazt.zs.k
    public void pr(int i, String str, Throwable th) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, str);
            jSONObject.put(PluginConstants.KEY_ERROR_CODE, i);
        } catch (JSONException e) {
        }
        pr("ats_b_e", jSONObject, th);
    }

    public Map<String, Object> pr() {
        return this.hw;
    }

    private void pr(final String str, final JSONObject jSONObject, final Throwable th) {
        com.byazt.ca.aj.pr().postDelayed(new Runnable() { // from class: com.byazt.zs.m.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.xk.hw.pr().pr(str, jSONObject, th);
            }
        }, 2000L);
    }

    private void pr(final JSONObject jSONObject) {
        com.byazt.ca.aj.pr().postDelayed(new Runnable() { // from class: com.byazt.zs.m.2
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                com.byazt.pj.uc.pr("exception", jSONObject, false);
            }
        }, 2000L);
    }
}
