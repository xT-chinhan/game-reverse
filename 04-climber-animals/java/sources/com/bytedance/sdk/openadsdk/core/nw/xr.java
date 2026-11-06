package com.bytedance.sdk.openadsdk.core.nw;

import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    private int ab;
    public int ah = 1;
    public com.bytedance.sdk.openadsdk.ao.xr.ah.xr c;
    private long ch;
    public String d;
    private long hi;
    public ArrayList<Integer> ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public String f3114ms;
    private long ny;
    private JSONObject sl;
    private long x;
    public int xr;

    public String ms() {
        return this.f3114ms;
    }

    public void ms(String str) {
        this.f3114ms = str;
    }

    public int xr() {
        return this.xr;
    }

    public void ms(int i) {
        this.xr = i;
    }

    public int ah() {
        return this.ab;
    }

    public void xr(int i) {
        this.ab = i;
    }

    public String d() {
        return this.d;
    }

    public void xr(String str) {
        this.d = str;
    }

    public JSONObject ka() {
        return this.sl;
    }

    public void ms(JSONObject jSONObject) {
        this.sl = jSONObject;
    }

    public int c() {
        return this.ah;
    }

    public void ah(int i) {
        this.ah = i;
    }

    public com.bytedance.sdk.openadsdk.ao.xr.ah.xr ab() {
        return this.c;
    }

    public void ms(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        this.c = xrVar;
    }

    public ArrayList<Integer> x() {
        return this.ka;
    }

    public void ms(ArrayList<Integer> arrayList) {
        this.ka = arrayList;
    }

    public static void ms(xr xrVar) {
        int iXr;
        if (xrVar == null || xrVar.ab() == null || (iXr = xrVar.xr()) >= 0 || iXr == -8) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.t.u.ms().xr(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.nw.xr.1
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                JSONObject jSONObjectKa = xr.this.ka();
                if (jSONObjectKa == null) {
                    jSONObjectKa = new JSONObject();
                }
                jSONObjectKa.put("from", xr.this.c());
                jSONObjectKa.put("err_code", xr.this.xr());
                jSONObjectKa.put("err_msg", xr.this.d());
                jSONObjectKa.put("server_res_str", xr.this.ms());
                if (xr.this.x() != null && xr.this.x().size() > 0) {
                    jSONObjectKa.put("mate_unavailable_code_list", new JSONArray((Collection) xr.this.x()).toString());
                }
                com.bytedance.sdk.component.utils.sl.ms("AdLogInfoModel", "rd_client_custom_error = ", jSONObjectKa);
                return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("rd_client_custom_error").ms(xr.this.ab().t()).xr(jSONObjectKa.toString());
            }
        }, "rd_client_custom_error");
    }

    public long ny() {
        return this.x;
    }

    public void ms(long j) {
        this.x = j;
    }

    public long ch() {
        return this.ny;
    }

    public void xr(long j) {
        this.ny = j;
    }

    public long hi() {
        return this.ch;
    }

    public void ah(long j) {
        this.ch = j;
    }

    public long sl() {
        return this.hi;
    }

    public void d(long j) {
        this.hi = j;
    }
}
