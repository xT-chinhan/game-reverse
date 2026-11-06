package com.byazt.hg;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 13})
public class hw {
    public long aj;
    public ArrayList<Integer> c;
    public int fw;
    public int hn = 1;
    public int hw;
    public JSONObject k;
    public String pr;
    public com.byazt.qe.hw uc;
    public long vk;
    public long w;
    public String x;
    public long zo;

    public String pr() {
        return this.pr;
    }

    public void pr(String str) {
        this.pr = str;
    }

    public int hw() {
        return this.hw;
    }

    public void pr(int i) {
        this.hw = i;
    }

    public int hn() {
        return this.fw;
    }

    public void hw(int i) {
        this.fw = i;
    }

    public String x() {
        return this.x;
    }

    public void hw(String str) {
        this.x = str;
    }

    public JSONObject c() {
        return this.k;
    }

    public void pr(JSONObject jSONObject) {
        this.k = jSONObject;
    }

    public int uc() {
        return this.hn;
    }

    public void hn(int i) {
        this.hn = i;
    }

    public com.byazt.qe.hw fw() {
        return this.uc;
    }

    public void pr(com.byazt.qe.hw hwVar) {
        this.uc = hwVar;
    }

    public ArrayList<Integer> zo() {
        return this.c;
    }

    public void pr(ArrayList<Integer> arrayList) {
        this.c = arrayList;
    }

    public static void pr(hw hwVar) {
        int iHw;
        if (hwVar == null || hwVar.fw() == null || hwVar.fw().ve() || (iHw = hwVar.hw()) >= 0 || iHw == -8) {
            return;
        }
        com.byazt.xk.hw.pr().pr("rd_client_custom_error", (String) null, (String) null, hwVar.fw().a(), new com.byazt.ttf.pr() { // from class: com.byazt.hg.hw.1
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObjectC = hw.this.c();
                if (jSONObjectC == null) {
                    jSONObjectC = new JSONObject();
                }
                jSONObjectC.put("from", hw.this.uc());
                jSONObjectC.put("err_code", hw.this.hw());
                jSONObjectC.put("err_msg", hw.this.x());
                jSONObjectC.put("server_res_str", hw.this.pr());
                if (hw.this.zo() != null && hw.this.zo().size() > 0) {
                    jSONObjectC.put("mate_unavailable_code_list", new JSONArray((Collection) hw.this.zo()).toString());
                }
                Object[] objArr = {"rd_client_custom_error = ", jSONObjectC};
                return jSONObjectC;
            }
        });
    }

    public long aj() {
        return this.zo;
    }

    public void pr(long j) {
        this.zo = j;
    }

    public long vk() {
        return this.aj;
    }

    public void hw(long j) {
        this.aj = j;
    }

    public long w() {
        return this.vk;
    }

    public void hn(long j) {
        this.vk = j;
    }

    public long k() {
        return this.w;
    }

    public void x(long j) {
        this.w = j;
    }
}
