package com.byazt.fs;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.anythink.core.common.l.f;
import com.byazt.km.sz;
import com.byazt.va.qg;
import com.byazt.zve.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 101, 19})
public class n extends com.byazt.sh.n {
    public final Map<String, com.byazt.ahu.n> l;
    public final List<String> w;

    public n(Context context, qg qgVar, com.byazt.kn.n nVar) {
        super(context, qgVar, nVar);
        this.l = new HashMap();
        this.w = new ArrayList();
    }

    @Override // com.byazt.sh.n
    public List<String> n() {
        this.w.add("d_i0");
        this.w.add("d_a0");
        return this.w;
    }

    public void n(final JSONObject jSONObject, final String str) {
        com.byazt.nt.n.n("__kite", "doReport");
        com.byazt.dp.n.n().postDelayed(new Runnable() { // from class: com.byazt.fs.n.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.nt.n.n("__kite", "run()");
                JSONObject jSONObject2 = new JSONObject();
                try {
                    JSONObject jSONObjectN = sz.n(jSONObject, str);
                    String strN = n.this.s.n("d_data");
                    if (!TextUtils.isEmpty(strN)) {
                        jSONObject2.putOpt("message", "ok");
                        jSONObject2.putOpt(f.R, strN);
                        com.byazt.nt.n.n("__kite", "config from cache");
                    } else {
                        JSONObject jSONObject3 = new JSONObject();
                        String strQg = sz.qg(jSONObjectN);
                        jSONObject3.putOpt("header", strQg);
                        if (com.byazt.nt.n.qg()) {
                            com.byazt.nt.n.n("__kite", "config 请求header进行sword加密：加密内容：".concat(String.valueOf(jSONObjectN)));
                            com.byazt.nt.n.n("__kite", "config 请求header进行sword加密：加密结果：".concat(String.valueOf(strQg)));
                        }
                        jSONObject3.putOpt("fetch_config", Boolean.TRUE);
                        jSONObject3.putOpt("client_time", Long.valueOf(System.currentTimeMillis() / 1000));
                        jSONObject2 = com.byazt.ov.n.n(n.this.qg, jSONObject3, n.this.n(jSONObjectN));
                        com.byazt.nt.n.n("__kite", "config from server.");
                    }
                    if (com.byazt.nt.n.qg()) {
                        com.byazt.nt.n.n("__kite", "config: ".concat(String.valueOf(jSONObject2)));
                    }
                    n.this.q.n(jSONObject2);
                    n.this.n(5L);
                    n.this.qg();
                    n.this.s();
                    n.this.qg(jSONObjectN);
                } catch (Exception e) {
                    com.byazt.nt.n.q("__kite", "error " + e.getMessage());
                }
            }
        }, this.q.s());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        for (Map.Entry<String, com.byazt.ahu.n> entry : this.l.entrySet()) {
            if (TextUtils.equals(entry.getKey(), "d_i0")) {
                JSONObject jSONObjectQg = entry.getValue().qg();
                w wVarW = sz.w();
                if (wVarW != null && jSONObjectQg != null) {
                    JSONObject jSONObjectOptJSONObject = jSONObjectQg.optJSONObject(f.R);
                    ArrayList arrayList = new ArrayList();
                    Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                    while (itKeys.hasNext()) {
                        arrayList.add(itKeys.next());
                    }
                    String[] strArr = (String[]) arrayList.toArray(new String[0]);
                    int[] iArr = new int[strArr.length];
                    for (int i = 0; i < strArr.length; i++) {
                        iArr[i] = jSONObjectOptJSONObject.optInt(strArr[i]);
                    }
                    wVarW.n(strArr, iArr, false);
                    return;
                }
            }
        }
    }

    public void n(long j) {
        Map<String, JSONObject> mapN = this.q.n();
        if (mapN.isEmpty()) {
            com.byazt.nt.n.n("__kite", "map is empty");
        } else {
            n(mapN, j);
        }
    }

    public void qg() {
        if (this.n.size() <= 0) {
            com.byazt.nt.n.n("__kite", "return");
            return;
        }
        for (int i = 0; i < this.n.size(); i++) {
            try {
                com.byazt.ahu.n nVar = this.n.get(i).get();
                this.l.put(nVar.n(), nVar);
                if (com.byazt.nt.n.qg()) {
                    com.byazt.nt.n.n("__kite", "result: ".concat(String.valueOf(nVar)));
                }
            } catch (Exception e) {
                com.byazt.nt.n.q("__kite", "error " + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(final JSONObject jSONObject) {
        if (this.l.size() <= 0) {
            return;
        }
        final JSONObject jSONObject2 = new JSONObject();
        for (Map.Entry<String, com.byazt.ahu.n> entry : this.l.entrySet()) {
            try {
                JSONObject jSONObjectQg = entry.getValue().qg();
                jSONObject2.putOpt(entry.getKey(), sz.qg(jSONObjectQg));
                if (com.byazt.nt.n.qg()) {
                    com.byazt.nt.n.n("__kite", "report 请求data中的字段进行sword加密：加密内容：".concat(String.valueOf(jSONObjectQg)));
                }
            } catch (JSONException e) {
                com.byazt.nt.n.q("__kite", "error " + e.getMessage());
            }
        }
        com.byazt.dp.n.n(new Runnable() { // from class: com.byazt.fs.n.2
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject.putOpt("device_type", Build.MODEL);
                    jSONObject.putOpt("device_platform", "android");
                    jSONObject3.putOpt("header", sz.qg(jSONObject));
                    if (com.byazt.nt.n.qg()) {
                        com.byazt.nt.n.n("__kite", "report 请求header进行sword加密：加密内容：" + jSONObject);
                    }
                    jSONObject3.putOpt("client_time", Long.valueOf(System.currentTimeMillis() / 1000));
                    jSONObject3.putOpt(f.R, jSONObject2);
                    jSONObject3.putOpt("version", Integer.valueOf(n.this.q.qg()));
                } catch (Exception e2) {
                    com.byazt.nt.n.n("__kite", "error: " + e2.getMessage());
                }
                JSONObject jSONObjectN = com.byazt.ov.n.n(n.this.qg, jSONObject3, n.this.n(jSONObject));
                if (com.byazt.nt.n.qg()) {
                    com.byazt.nt.n.s("__kite", "response:".concat(String.valueOf(jSONObjectN)));
                }
                n.this.q.qg(jSONObjectN);
            }
        });
    }
}
