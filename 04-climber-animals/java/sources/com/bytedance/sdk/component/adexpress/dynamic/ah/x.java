package com.bytedance.sdk.component.adexpress.dynamic.ah;

import android.text.TextUtils;
import com.anythink.core.common.e.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class x {
    private float ab;
    private float ah;
    private float c;
    private List<x> ch;
    private float d;
    private x hi;
    private float ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f767ms;
    private ka ny;
    private List<List<x>> sl;
    private boolean u;
    private float x;
    private float xr;
    private String zb;
    private Map<String, String> ub = new HashMap();
    private Map<Integer, String> ao = new HashMap();

    public String ms() {
        return this.zb;
    }

    public void ms(String str) {
        this.zb = str;
    }

    public Map<Integer, String> xr() {
        return this.ao;
    }

    public void ms(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() == 0) {
                    return;
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    this.ao.put(Integer.valueOf(jSONObjectOptJSONObject.optInt("id")), jSONObjectOptJSONObject.optString(f.a.d));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public String ah() {
        return this.f767ms;
    }

    public void xr(String str) {
        this.f767ms = str;
    }

    public float d() {
        return this.d;
    }

    public void ms(float f) {
        this.d = f;
    }

    public float ka() {
        return this.ka;
    }

    public void xr(float f) {
        this.ka = f;
    }

    public float c() {
        return this.xr;
    }

    public void ah(float f) {
        this.xr = f;
    }

    public float ab() {
        return this.ah;
    }

    public void d(float f) {
        this.ah = f;
    }

    public float x() {
        return this.c;
    }

    public void ka(float f) {
        this.c = f;
    }

    public float ny() {
        return this.ab;
    }

    public void c(float f) {
        this.ab = f;
    }

    public void ab(float f) {
        this.x = f;
    }

    public ka ch() {
        return this.ny;
    }

    public void ms(ka kaVar) {
        this.ny = kaVar;
    }

    public List<x> hi() {
        return this.ch;
    }

    public void ms(List<x> list) {
        this.ch = list;
    }

    public void ms(x xVar) {
        this.hi = xVar;
    }

    public x sl() {
        return this.hi;
    }

    public int zb() {
        c cVarKa = this.ny.ka();
        return cVarKa.il() + cVarKa.qf();
    }

    public int u() {
        c cVarKa = this.ny.ka();
        return cVarKa.fm() + cVarKa.xn();
    }

    public float ub() {
        c cVarKa = this.ny.ka();
        return zb() + cVarKa.ub() + cVarKa.ao() + (cVarKa.sl() * 2.0f);
    }

    public float ao() {
        c cVarKa = this.ny.ka();
        return u() + cVarKa.h() + cVarKa.u() + (cVarKa.sl() * 2.0f);
    }

    public void xr(List<List<x>> list) {
        this.sl = list;
    }

    public List<List<x>> h() {
        return this.sl;
    }

    public boolean qv() {
        List<x> list = this.ch;
        return list == null || list.size() <= 0;
    }

    public boolean y() {
        return this.u;
    }

    public void ms(boolean z) {
        this.u = z;
    }

    public Map<String, String> t() {
        return this.ub;
    }

    public void ms(String str, String str2) {
        this.ub.put(str, str2);
    }

    public void nw() {
        List<List<x>> list = this.sl;
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (List<x> list2 : this.sl) {
            if (list2 != null && list2.size() > 0) {
                arrayList.add(list2);
            }
        }
        this.sl = arrayList;
    }

    public boolean b() {
        return TextUtils.equals(this.ny.ka().le(), "flex");
    }

    public String re() {
        return this.ny.ka().re();
    }

    public void ah(String str) {
        this.ny.ka().c(str);
    }

    public String toString() {
        return "DynamicLayoutUnit{id='" + this.f767ms + "', x=" + this.xr + ", y=" + this.ah + ", width=" + this.c + ", height=" + this.ab + ", remainWidth=" + this.x + ", rootBrick=" + this.ny + ", childrenBrickUnits=" + this.ch + AbstractJsonLexerKt.END_OBJ;
    }

    public boolean i() {
        return this.ny.ka().jy() < 0 || this.ny.ka().j() < 0 || this.ny.ka().jm() < 0 || this.ny.ka().bz() < 0;
    }

    public String ms(int i) {
        int i2;
        StringBuilder sb = new StringBuilder();
        sb.append(this.ny.getType());
        sb.append(":");
        sb.append(this.f767ms);
        if (this.ny.ka() != null) {
            sb.append(":");
            sb.append(this.ny.ka().cj());
        }
        sb.append(":");
        sb.append(i);
        if (this.ny.ka() != null) {
            sb.append(":");
            String strUl = this.ny.ka().ul();
            strUl.hashCode();
            switch (strUl) {
                case "9":
                case "16":
                case "29":
                    i2 = 1;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            String strUl2 = this.ny.ka().ul();
            strUl2.hashCode();
            if (strUl2.equals("17") || strUl2.equals("18")) {
                i2 = (i2 * 10) + 2;
            }
            String strUl3 = this.ny.ka().ul();
            strUl3.hashCode();
            switch (strUl3) {
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
