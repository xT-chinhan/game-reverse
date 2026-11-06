package com.byazt.wu;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.byazt.ec.g;
import com.byazt.gq.hw;
import com.byazt.lq.uc;
import com.umeng.analytics.pro.an;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1321, 37})
public class pr extends com.byazt.uh.pr {
    public final Map<String, com.byazt.jdi.pr> c;
    public final List<String> uc;

    public pr(Context context, hw hwVar, com.byazt.xg.pr prVar) {
        super(context, hwVar, prVar);
        this.c = new HashMap();
        this.uc = new ArrayList();
    }

    @Override // com.byazt.uh.pr
    public List<String> pr() {
        this.uc.add("d_i0");
        this.uc.add("d_a0");
        return this.uc;
    }

    public void pr(final JSONObject jSONObject, final String str) {
        com.byazt.wx.pr.pr("__kite", "doReport");
        com.byazt.jcn.pr.pr().postDelayed(new Runnable() { // from class: com.byazt.wu.pr.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.wx.pr.pr("__kite", "run()");
                JSONObject jSONObject2 = new JSONObject();
                try {
                    JSONObject jSONObjectPr = g.pr(jSONObject, str);
                    String strPr = pr.this.hn.pr("d_data");
                    if (!TextUtils.isEmpty(strPr)) {
                        jSONObject2.putOpt("message", "ok");
                        jSONObject2.putOpt("data", strPr);
                        com.byazt.wx.pr.pr("__kite", "config from cache");
                    } else {
                        JSONObject jSONObject3 = new JSONObject();
                        String strHw = g.hw(jSONObjectPr);
                        jSONObject3.putOpt("header", strHw);
                        if (com.byazt.wx.pr.hw()) {
                            com.byazt.wx.pr.pr("__kite", "config 请求header进行sword加密：加密内容：".concat(String.valueOf(jSONObjectPr)));
                            com.byazt.wx.pr.pr("__kite", "config 请求header进行sword加密：加密结果：".concat(String.valueOf(strHw)));
                        }
                        jSONObject3.putOpt("fetch_config", Boolean.TRUE);
                        jSONObject3.putOpt("client_time", Long.valueOf(System.currentTimeMillis() / 1000));
                        jSONObject2 = com.byazt.cqx.pr.pr(pr.this.hw, jSONObject3, pr.this.pr(jSONObjectPr));
                        com.byazt.wx.pr.pr("__kite", "config from server.");
                    }
                    if (com.byazt.wx.pr.hw()) {
                        com.byazt.wx.pr.pr("__kite", "config: ".concat(String.valueOf(jSONObject2)));
                    }
                    pr.this.x.pr(jSONObject2);
                    pr.this.pr(5L);
                    pr.this.hw();
                    pr.this.hn();
                    pr.this.hw(jSONObjectPr);
                } catch (Exception e) {
                    com.byazt.wx.pr.x("__kite", "error " + e.getMessage());
                }
            }
        }, this.x.hn());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hn() {
        for (Map.Entry<String, com.byazt.jdi.pr> entry : this.c.entrySet()) {
            if (TextUtils.equals(entry.getKey(), "d_i0")) {
                JSONObject jSONObjectHw = entry.getValue().hw();
                uc ucVarUc = g.uc();
                if (ucVarUc != null && jSONObjectHw != null) {
                    JSONObject jSONObjectOptJSONObject = jSONObjectHw.optJSONObject("data");
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
                    ucVarUc.pr(strArr, iArr, false);
                    return;
                }
            }
        }
    }

    public void pr(long j) {
        Map<String, JSONObject> mapPr = this.x.pr();
        if (mapPr.isEmpty()) {
            com.byazt.wx.pr.pr("__kite", "map is empty");
        } else {
            pr(mapPr, j);
        }
    }

    public void hw() {
        if (this.pr.size() <= 0) {
            com.byazt.wx.pr.pr("__kite", "return");
            return;
        }
        for (int i = 0; i < this.pr.size(); i++) {
            try {
                com.byazt.jdi.pr prVar = this.pr.get(i).get();
                this.c.put(prVar.pr(), prVar);
                if (com.byazt.wx.pr.hw()) {
                    com.byazt.wx.pr.pr("__kite", "result: ".concat(String.valueOf(prVar)));
                }
            } catch (Exception e) {
                com.byazt.wx.pr.x("__kite", "error " + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(final JSONObject jSONObject) {
        if (this.c.size() <= 0) {
            return;
        }
        final JSONObject jSONObject2 = new JSONObject();
        for (Map.Entry<String, com.byazt.jdi.pr> entry : this.c.entrySet()) {
            try {
                JSONObject jSONObjectHw = entry.getValue().hw();
                jSONObject2.putOpt(entry.getKey(), g.hw(jSONObjectHw));
                if (com.byazt.wx.pr.hw()) {
                    com.byazt.wx.pr.pr("__kite", "report 请求data中的字段进行sword加密：加密内容：".concat(String.valueOf(jSONObjectHw)));
                }
            } catch (JSONException e) {
                com.byazt.wx.pr.x("__kite", "error " + e.getMessage());
            }
        }
        com.byazt.jcn.pr.pr(new Runnable() { // from class: com.byazt.wu.pr.2
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject.putOpt(an.ai, Build.MODEL);
                    jSONObject.putOpt("device_platform", "android");
                    jSONObject3.putOpt("header", g.hw(jSONObject));
                    if (com.byazt.wx.pr.hw()) {
                        com.byazt.wx.pr.pr("__kite", "report 请求header进行sword加密：加密内容：" + jSONObject);
                    }
                    jSONObject3.putOpt("client_time", Long.valueOf(System.currentTimeMillis() / 1000));
                    jSONObject3.putOpt("data", jSONObject2);
                    jSONObject3.putOpt("version", Integer.valueOf(pr.this.x.hw()));
                } catch (Exception e2) {
                    com.byazt.wx.pr.pr("__kite", "error: " + e2.getMessage());
                }
                JSONObject jSONObjectPr = com.byazt.cqx.pr.pr(pr.this.hw, jSONObject3, pr.this.pr(jSONObject));
                if (com.byazt.wx.pr.hw()) {
                    com.byazt.wx.pr.hn("__kite", "response:".concat(String.valueOf(jSONObjectPr)));
                }
                pr.this.x.hw(jSONObjectPr);
            }
        });
    }
}
