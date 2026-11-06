package com.byazt.lh;

import android.text.TextUtils;
import com.anythink.core.common.f.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1475, 101})
public class fs {
    public fs cp;
    public List<List<fs>> d;
    public float fs;
    public float l;
    public String n;
    public String oa;
    public float q;
    public float qg;
    public l rv;
    public float s;
    public boolean sz;
    public List<fs> tj;
    public float w;
    public float x;
    public Map<String, String> k = new HashMap();
    public Map<Integer, String> cy = new HashMap();

    public String n() {
        return this.oa;
    }

    public void n(String str) {
        this.oa = str;
    }

    public Map<Integer, String> qg() {
        return this.cy;
    }

    public void n(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() == 0) {
                    return;
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    this.cy.put(Integer.valueOf(jSONObjectOptJSONObject.optInt("id")), jSONObjectOptJSONObject.optString(e.a.d));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public String s() {
        return this.n;
    }

    public void qg(String str) {
        this.n = str;
    }

    public float q() {
        return this.q;
    }

    public void n(float f) {
        this.q = f;
    }

    public float l() {
        return this.l;
    }

    public void qg(float f) {
        this.l = f;
    }

    public float w() {
        return this.qg;
    }

    public void s(float f) {
        this.qg = f;
    }

    public float x() {
        return this.s;
    }

    public void q(float f) {
        this.s = f;
    }

    public float fs() {
        return this.w;
    }

    public void l(float f) {
        this.w = f;
    }

    public float rv() {
        return this.x;
    }

    public void w(float f) {
        this.x = f;
    }

    public void x(float f) {
        this.fs = f;
    }

    public l tj() {
        return this.rv;
    }

    public void n(l lVar) {
        this.rv = lVar;
    }

    public List<fs> cp() {
        return this.tj;
    }

    public void n(List<fs> list) {
        this.tj = list;
    }

    public void n(fs fsVar) {
        this.cp = fsVar;
    }

    public fs d() {
        return this.cp;
    }

    public int oa() {
        w wVarL = this.rv.l();
        return wVarL.y() + wVarL.rf();
    }

    public int sz() {
        w wVarL = this.rv.l();
        return wVarL.wo() + wVarL.sh();
    }

    public float k() {
        w wVarL = this.rv.l();
        return oa() + wVarL.k() + wVarL.cy() + (wVarL.d() * 2.0f);
    }

    public float cy() {
        w wVarL = this.rv.l();
        return sz() + wVarL.hd() + wVarL.sz() + (wVarL.d() * 2.0f);
    }

    public void qg(List<List<fs>> list) {
        this.d = list;
    }

    public List<List<fs>> hd() {
        return this.d;
    }

    public boolean cd() {
        List<fs> list = this.tj;
        return list == null || list.size() <= 0;
    }

    public boolean um() {
        return this.sz;
    }

    public void n(boolean z) {
        this.sz = z;
    }

    public Map<String, String> a() {
        return this.k;
    }

    public void n(String str, String str2) {
        this.k.put(str, str2);
    }

    public void py() {
        List<List<fs>> list = this.d;
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (List<fs> list2 : this.d) {
            if (list2 != null && list2.size() > 0) {
                arrayList.add(list2);
            }
        }
        this.d = arrayList;
    }

    public boolean ou() {
        return TextUtils.equals(this.rv.l().ur(), "flex");
    }

    public String wm() {
        return this.rv.l().wm();
    }

    public void s(String str) {
        this.rv.l().w(str);
    }

    public String toString() {
        return "DynamicLayoutUnit{id='" + this.n + "', x=" + this.qg + ", y=" + this.s + ", width=" + this.w + ", height=" + this.x + ", remainWidth=" + this.fs + ", rootBrick=" + this.rv + ", childrenBrickUnits=" + this.tj + AbstractJsonLexerKt.END_OBJ;
    }

    public boolean m() {
        return this.rv.l().i() < 0 || this.rv.l().dw() < 0 || this.rv.l().vb() < 0 || this.rv.l().fl() < 0;
    }

    public String n(int i) {
        int i2;
        StringBuilder sb = new StringBuilder();
        sb.append(this.rv.getType());
        sb.append(":");
        sb.append(this.n);
        if (this.rv.l() != null) {
            sb.append(":");
            sb.append(this.rv.l().nk());
        }
        sb.append(":");
        sb.append(i);
        if (this.rv.l() != null) {
            sb.append(":");
            String strF = this.rv.l().f();
            strF.hashCode();
            switch (strF) {
                case "9":
                case "16":
                case "29":
                    i2 = 1;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            String strF2 = this.rv.l().f();
            strF2.hashCode();
            if (strF2.equals("17") || strF2.equals("18")) {
                i2 = (i2 * 10) + 2;
            }
            String strF3 = this.rv.l().f();
            strF3.hashCode();
            switch (strF3) {
                case "0":
                case "5":
                case "10":
                case "12":
                case "13":
                case "20":
                case "22":
                case "24":
                case "29":
                    i2 = (i2 * 10) + 3;
                    break;
            }
            sb.append(i2);
        }
        return sb.toString();
    }
}
