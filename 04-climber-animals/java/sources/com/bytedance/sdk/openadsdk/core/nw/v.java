package com.bytedance.sdk.openadsdk.core.nw;

import android.graphics.Color;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class v {
    private int ab;
    private int c;
    private int d;
    private xr hi;
    private int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f3103ms;
    private xr sl;
    private ms u;
    private int ub;
    private int x;
    private String xr;
    private int zb;
    private boolean ah = false;
    private String ny = "#008DEA";
    private String ch = "点击查看";

    public int ms() {
        return this.f3103ms;
    }

    public void ms(int i) {
        this.f3103ms = i;
    }

    public String xr() {
        if (this.d == 4 && !com.bytedance.sdk.openadsdk.core.ch.ub().ms(com.bytedance.sdk.openadsdk.core.re.getContext())) {
            this.xr = "点击跳转至详情页或第三方应用";
        } else if (this.d == 7 && !com.bytedance.sdk.openadsdk.core.ch.ub().xr(com.bytedance.sdk.openadsdk.core.re.getContext())) {
            this.xr = "点击跳转至详情页或第三方应用";
        }
        return this.xr;
    }

    public boolean ah() {
        return this.ah;
    }

    public void ms(String str) {
        if (TextUtils.isEmpty(str)) {
            this.ah = true;
            int i = this.d;
            if (i == 3) {
                this.xr = "跳转至详情页或第三方应用";
                return;
            }
            if (i == 4) {
                this.xr = "前往详情页或第三方应用";
                return;
            } else if (i == 5 || i == 7) {
                this.xr = "前往详情页或第三方应用";
                return;
            } else {
                this.xr = "点击跳转至详情页或第三方应用";
                return;
            }
        }
        this.xr = str;
    }

    public int d() {
        return this.ka;
    }

    public void xr(int i) {
        this.ka = i;
    }

    public int ka() {
        return this.c;
    }

    public void ah(int i) {
        this.c = i;
    }

    public int c() {
        return this.ab;
    }

    public void d(int i) {
        this.ab = i;
    }

    public int ab() {
        return this.x;
    }

    public void ka(int i) {
        this.x = i;
    }

    public void c(int i) {
        this.ub = i;
    }

    public int x() {
        return this.ub;
    }

    public int ny() {
        if (this.d == 4 && !com.bytedance.sdk.openadsdk.core.ch.ub().ms(com.bytedance.sdk.openadsdk.core.re.getContext())) {
            this.d = 0;
        } else if (this.d == 7 && !com.bytedance.sdk.openadsdk.core.ch.ub().xr(com.bytedance.sdk.openadsdk.core.re.getContext())) {
            this.d = 0;
        }
        return this.d;
    }

    public void ab(int i) {
        this.d = i;
    }

    public String ch() {
        return this.ny;
    }

    public void xr(String str) {
        try {
            Color.parseColor(str);
            this.ny = str;
        } catch (Throwable unused) {
            this.ny = "#008DEA";
        }
    }

    public String hi() {
        return this.ch;
    }

    public void ah(String str) {
        if (TextUtils.isEmpty(str)) {
            int i = this.d;
            if (i == 7) {
                this.ch = "扭动手机";
                return;
            } else if (i == 5) {
                this.ch = "向上滑动";
                return;
            } else {
                if (i == 4) {
                    this.ch = "摇一摇";
                    return;
                }
                return;
            }
        }
        this.ch = str;
    }

    public void ms(JSONObject jSONObject) {
        this.hi = new xr(jSONObject, 14);
    }

    public void xr(JSONObject jSONObject) {
        this.sl = new xr(jSONObject, 20);
    }

    public xr sl() {
        return this.hi;
    }

    public xr zb() {
        return this.sl;
    }

    public void ms(JSONObject jSONObject, int i) {
        this.u = new ms(jSONObject, i);
    }

    public ms u() {
        return this.u;
    }

    public class ms {
        int ah;
        int d;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        int f3104ms;
        int xr;

        public int ms() {
            return this.f3104ms;
        }

        public int xr() {
            return this.xr;
        }

        public int ah() {
            return this.ah;
        }

        public int d() {
            return this.d;
        }

        public JSONObject ka() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("left_margin", 30);
                jSONObject.put("right_margin", 30);
                jSONObject.put("top_margin", 150);
                jSONObject.put("bottom_margin", 40);
            } catch (Exception unused) {
            }
            return jSONObject;
        }

        public ms(JSONObject jSONObject, int i) {
            this.f3104ms = 30;
            this.xr = 30;
            this.ah = 150;
            this.d = 40;
            if (jSONObject == null) {
                if (i == 2) {
                    this.ah = 40;
                    this.d = 20;
                    return;
                }
                return;
            }
            int iOptInt = jSONObject.optInt("left_margin", 30);
            this.f3104ms = iOptInt;
            if (iOptInt < 0 || iOptInt > v.this.h()) {
                this.f3104ms = 30;
            }
            int iOptInt2 = jSONObject.optInt("right_margin", 30);
            this.xr = iOptInt2;
            if (iOptInt2 < 0 || iOptInt2 > v.this.h()) {
                this.xr = 30;
            }
            if (i == 2) {
                int iOptInt3 = jSONObject.optInt("top_margin", 40);
                this.ah = iOptInt3;
                if (iOptInt3 < 0 || iOptInt3 > v.this.ao()) {
                    this.ah = 40;
                }
                int iOptInt4 = jSONObject.optInt("bottom_margin", 20);
                this.d = iOptInt4;
                if (iOptInt4 < 0 || iOptInt4 > v.this.ao()) {
                    this.d = 20;
                    return;
                }
                return;
            }
            int iOptInt5 = jSONObject.optInt("top_margin", 150);
            this.ah = iOptInt5;
            if (iOptInt5 < 0 || iOptInt5 > v.this.ao()) {
                this.ah = 150;
            }
            int iOptInt6 = jSONObject.optInt("bottom_margin", 40);
            this.d = iOptInt6;
            if (iOptInt6 < 0 || iOptInt6 > v.this.ao()) {
                this.d = 40;
            }
        }
    }

    public class xr {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        int f3105ms;

        public JSONObject ms() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("font_size", this.f3105ms);
            } catch (Exception unused) {
            }
            return jSONObject;
        }

        public xr(JSONObject jSONObject, int i) {
            this.f3105ms = 14;
            if (jSONObject == null) {
                return;
            }
            this.f3105ms = jSONObject.optInt("font_size", i);
        }

        public int xr() {
            return this.f3105ms;
        }
    }

    public int ub() {
        return this.zb;
    }

    public void x(int i) {
        if (i <= 0 || i >= ao()) {
            this.zb = 5;
        } else {
            this.zb = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ao() {
        return com.bytedance.sdk.openadsdk.core.jw.ul.d(com.bytedance.sdk.openadsdk.core.re.getContext(), com.bytedance.sdk.openadsdk.core.jw.ul.ka(com.bytedance.sdk.openadsdk.core.re.getContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h() {
        return com.bytedance.sdk.openadsdk.core.jw.ul.d(com.bytedance.sdk.openadsdk.core.re.getContext(), com.bytedance.sdk.openadsdk.core.jw.ul.d(com.bytedance.sdk.openadsdk.core.re.getContext()));
    }
}
