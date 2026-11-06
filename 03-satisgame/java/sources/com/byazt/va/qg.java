package com.byazt.va;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.g.c;
import com.anythink.core.common.l.f;
import com.byakv.z.TTEncryptUtils;
import com.byazt.km.sz;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 44, 26})
public class qg {
    public final com.byazt.kn.n n;
    public long qg = 5000;
    public long s = c.a;
    public final Map<String, JSONObject> q = new HashMap();
    public final Map<String, JSONObject> l = new HashMap();
    public String w = "";
    public final ReentrantLock x = new ReentrantLock();

    public qg(Context context, com.byazt.kn.n nVar) {
        this.n = nVar;
        qg(sz.qg(context).getString("d_data", ""));
    }

    private boolean s(JSONObject jSONObject) {
        if ("ok".equals(jSONObject.optString("message", ""))) {
            return true;
        }
        com.byazt.nt.n.n("__kite", "error response");
        return false;
    }

    private void n(String str) {
        this.n.qg("d_data", str);
        this.n.n("d_data", str);
    }

    private void qg(String str) {
        if (!this.q.isEmpty() && !this.l.isEmpty()) {
            com.byazt.nt.n.s("__kite", " map is empty");
            return;
        }
        byte[] bArrClientUnpackedBase64 = TTEncryptUtils.clientUnpackedBase64(str);
        if (bArrClientUnpackedBase64 == null || bArrClientUnpackedBase64.length == 0) {
            com.byazt.nt.n.s("__kite", "parse is null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArrClientUnpackedBase64));
            if (com.byazt.nt.n.qg()) {
                com.byazt.nt.n.n("__kite", " data:".concat(String.valueOf(jSONObject)));
            }
            this.w = jSONObject.optString("version", "");
            n(jSONObject, "fields", this.q);
            int iOptInt = jSONObject.optInt("delay_sec", 0);
            if (iOptInt > 0) {
                this.qg = ((long) iOptInt) * 1000;
            }
            int iOptInt2 = jSONObject.optInt("dtrait_mem_ttl_sec", 0);
            if (iOptInt2 > 0) {
                this.s = ((long) iOptInt2) * 1000;
            }
            n(jSONObject, "dtrait_fields", this.l);
            if (com.byazt.nt.n.qg()) {
                com.byazt.nt.n.n("__kite" + String.format("parseConfigFields# fields: status_collect delay time:%s, dtraitExpireTime:%s", Long.valueOf(this.qg), Long.valueOf(this.s)));
            }
        } catch (Exception e) {
            com.byazt.nt.n.qg("__kiteparseConfigFields# error: " + e.getMessage());
        }
    }

    private void n(JSONObject jSONObject, String str, Map<String, JSONObject> map) throws JSONException {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        if (jSONArrayOptJSONArray == null) {
            return;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObject2 = (JSONObject) jSONArrayOptJSONArray.get(i);
            map.put(jSONObject2.optString(TapEventParamConstants.PARAM_NAME), jSONObject2);
        }
    }

    public void n(JSONObject jSONObject) {
        this.x.lock();
        try {
            try {
                if (!s(jSONObject)) {
                    com.byazt.nt.n.s("__kite", "invalid response");
                } else {
                    String strOptString = jSONObject.optString(f.R);
                    if (TextUtils.isEmpty(strOptString)) {
                        com.byazt.nt.n.s("__kite", "response is empty");
                    } else {
                        n(strOptString);
                        qg(strOptString);
                        if (com.byazt.nt.n.qg()) {
                            com.byazt.nt.n.n("__kiteconfig parse success");
                        }
                    }
                }
            } catch (Exception e) {
                com.byazt.nt.n.qg("__kiteerror" + e.getMessage());
            }
        } finally {
            this.x.unlock();
        }
    }

    public void qg(JSONObject jSONObject) {
        try {
            if (s(jSONObject)) {
                String strOptString = jSONObject.optString(f.R);
                if (TextUtils.isEmpty(strOptString)) {
                    com.byazt.nt.n.n("__kite", "data is null");
                    return;
                }
                n(strOptString);
                qg(strOptString);
                com.byazt.nt.n.n("__kitesuccess");
            }
        } catch (Exception e) {
            com.byazt.nt.n.qg("__kiteerror " + e.getMessage());
        }
    }

    public Map<String, JSONObject> n() {
        return this.q;
    }

    public String qg() {
        return this.w;
    }

    public long s() {
        return this.qg;
    }
}
