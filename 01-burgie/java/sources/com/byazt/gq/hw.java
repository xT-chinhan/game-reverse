package com.byazt.gq;

import android.content.Context;
import android.text.TextUtils;
import com.byakv.z.TTEncryptUtils;
import com.byazt.ec.g;
import com.taptap.sdk.db.constant.Common;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1588, 13})
public class hw {
    public final com.byazt.xg.pr pr;
    public long hw = 5000;
    public long hn = 1800000;
    public final Map<String, JSONObject> x = new HashMap();
    public final Map<String, JSONObject> c = new HashMap();
    public String uc = "";
    public final ReentrantLock fw = new ReentrantLock();

    public hw(Context context, com.byazt.xg.pr prVar) {
        this.pr = prVar;
        hw(g.hw(context).getString("d_data", ""));
    }

    private boolean hn(JSONObject jSONObject) {
        if (!"ok".equals(jSONObject.optString("message", ""))) {
            com.byazt.wx.pr.pr("__kite", "error response");
            return false;
        }
        return true;
    }

    private void pr(String str) {
        this.pr.hw("d_data", str);
        this.pr.pr("d_data", str);
    }

    private void hw(String str) {
        if (!this.x.isEmpty() && !this.c.isEmpty()) {
            com.byazt.wx.pr.hn("__kite", " map is empty");
            return;
        }
        byte[] bArrClientUnpackedBase64 = TTEncryptUtils.clientUnpackedBase64(str);
        if (bArrClientUnpackedBase64 == null || bArrClientUnpackedBase64.length == 0) {
            com.byazt.wx.pr.hn("__kite", "parse is null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArrClientUnpackedBase64));
            if (com.byazt.wx.pr.hw()) {
                com.byazt.wx.pr.pr("__kite", " data:".concat(String.valueOf(jSONObject)));
            }
            this.uc = jSONObject.optString("version", "");
            pr(jSONObject, "fields", this.x);
            int iOptInt = jSONObject.optInt("delay_sec", 0);
            if (iOptInt > 0) {
                this.hw = ((long) iOptInt) * 1000;
            }
            int iOptInt2 = jSONObject.optInt("dtrait_mem_ttl_sec", 0);
            if (iOptInt2 > 0) {
                this.hn = ((long) iOptInt2) * 1000;
            }
            pr(jSONObject, "dtrait_fields", this.c);
            if (com.byazt.wx.pr.hw()) {
                com.byazt.wx.pr.pr("__kite" + String.format("parseConfigFields# fields: status_collect delay time:%s, dtraitExpireTime:%s", Long.valueOf(this.hw), Long.valueOf(this.hn)));
            }
        } catch (Exception e) {
            com.byazt.wx.pr.hw("__kiteparseConfigFields# error: " + e.getMessage());
        }
    }

    private void pr(JSONObject jSONObject, String str, Map<String, JSONObject> map) throws JSONException {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        if (jSONArrayOptJSONArray == null) {
            return;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObject2 = (JSONObject) jSONArrayOptJSONArray.get(i);
            map.put(jSONObject2.optString(Common.System.NAME), jSONObject2);
        }
    }

    public void pr(JSONObject jSONObject) {
        this.fw.lock();
        try {
            try {
                if (!hn(jSONObject)) {
                    com.byazt.wx.pr.hn("__kite", "invalid response");
                    return;
                }
                String strOptString = jSONObject.optString("data");
                if (TextUtils.isEmpty(strOptString)) {
                    com.byazt.wx.pr.hn("__kite", "response is empty");
                    return;
                }
                pr(strOptString);
                hw(strOptString);
                if (com.byazt.wx.pr.hw()) {
                    com.byazt.wx.pr.pr("__kiteconfig parse success");
                }
            } catch (Exception e) {
                com.byazt.wx.pr.hw("__kiteerror" + e.getMessage());
            }
        } finally {
            this.fw.unlock();
        }
    }

    public void hw(JSONObject jSONObject) {
        try {
            if (!hn(jSONObject)) {
                return;
            }
            String strOptString = jSONObject.optString("data");
            if (TextUtils.isEmpty(strOptString)) {
                com.byazt.wx.pr.pr("__kite", "data is null");
                return;
            }
            pr(strOptString);
            hw(strOptString);
            com.byazt.wx.pr.pr("__kitesuccess");
        } catch (Exception e) {
            com.byazt.wx.pr.hw("__kiteerror " + e.getMessage());
        }
    }

    public Map<String, JSONObject> pr() {
        return this.x;
    }

    public String hw() {
        return this.uc;
    }

    public long hn() {
        return this.hw;
    }
}
