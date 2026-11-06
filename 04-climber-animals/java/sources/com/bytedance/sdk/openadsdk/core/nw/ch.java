package com.bytedance.sdk.openadsdk.core.nw;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ch {
    private final float ab;
    private final int[] ah;
    private final float ao;
    private SparseArray<com.bytedance.sdk.openadsdk.core.xr.d.ms> b;
    private final float c;
    private final long ch;
    private final int[] d;
    private final int h;
    private final int hi;
    private int i;
    private final float ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final int[] f3039ms;
    private final String nw;
    private final long ny;
    private final String qv;
    private int re;
    private final int sl;
    private final String t;
    private final float u;
    private final int ub;
    private String w;
    private final float x;
    private final int[] xr;
    private final String y;
    private int yu;
    private final int zb;

    private ch(ms msVar) {
        this.i = -1;
        this.yu = -1;
        this.f3039ms = msVar.hi;
        this.xr = msVar.sl;
        this.d = msVar.zb;
        this.ah = msVar.ch;
        this.ka = msVar.ny;
        this.c = msVar.x;
        this.ab = msVar.ab;
        this.x = msVar.c;
        this.ny = msVar.ka;
        this.ch = msVar.d;
        this.hi = msVar.u;
        this.sl = msVar.ub;
        this.zb = msVar.ao;
        this.u = msVar.f3040ms;
        this.qv = msVar.y;
        this.y = msVar.t;
        this.nw = msVar.b;
        this.t = msVar.nw;
        this.ub = msVar.xr;
        this.ao = msVar.ah;
        this.h = msVar.qv;
        this.b = msVar.h;
        this.re = msVar.re;
        this.i = msVar.i;
        this.w = msVar.w;
        this.yu = msVar.yu;
    }

    public JSONObject ms() {
        JSONObject jSONObject = new JSONObject();
        try {
            int[] iArr = this.f3039ms;
            if (iArr != null && iArr.length == 2) {
                jSONObject.putOpt("ad_x", Integer.valueOf(iArr[0])).putOpt("ad_y", Integer.valueOf(this.f3039ms[1]));
            }
            int[] iArr2 = this.xr;
            if (iArr2 != null && iArr2.length == 2) {
                jSONObject.putOpt("width", Integer.valueOf(iArr2[0])).putOpt("height", Integer.valueOf(this.xr[1]));
            }
            int[] iArr3 = this.ah;
            if (iArr3 != null && iArr3.length == 2) {
                jSONObject.putOpt("button_x", Integer.valueOf(iArr3[0])).putOpt("button_y", Integer.valueOf(this.ah[1]));
            }
            int[] iArr4 = this.d;
            if (iArr4 != null && iArr4.length == 2) {
                jSONObject.putOpt("button_width", Integer.valueOf(iArr4[0])).putOpt("button_height", Integer.valueOf(this.d[1]));
            }
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (this.b != null) {
                for (int i = 0; i < this.b.size(); i++) {
                    com.bytedance.sdk.openadsdk.core.xr.d.ms msVarValueAt = this.b.valueAt(i);
                    if (msVarValueAt != null) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.putOpt(TTDownloadField.TT_FORCE, Double.valueOf(msVarValueAt.ah)).putOpt("mr", Double.valueOf(msVarValueAt.xr)).putOpt("phase", Integer.valueOf(msVarValueAt.f3764ms)).putOpt("ts", Long.valueOf(msVarValueAt.d));
                        jSONArray.put(jSONObject3);
                    }
                }
            }
            jSONObject2.putOpt("ftc", Integer.valueOf(this.h)).putOpt("info", jSONArray);
            jSONObject.putOpt("down_x", Float.toString(this.ka)).putOpt("down_y", Float.toString(this.c)).putOpt("up_x", Float.toString(this.ab)).putOpt("up_y", Float.toString(this.x)).putOpt("down_time", Long.valueOf(this.ny)).putOpt("up_time", Long.valueOf(this.ch)).putOpt("toolType", Integer.valueOf(this.hi)).putOpt("deviceId", Integer.valueOf(this.sl)).putOpt("source", Integer.valueOf(this.zb)).putOpt("density", Float.valueOf(this.u)).putOpt("densityDpi", Integer.valueOf(this.ub)).putOpt("scaleDensity", Float.valueOf(this.ao)).putOpt("ft", jSONObject2).putOpt("click_area_type", this.qv).putOpt("areaType", this.y).putOpt("rectInfo", this.nw).putOpt("click_area_id", this.t);
            int i2 = this.re;
            if (i2 != -1) {
                jSONObject.putOpt("if_shake", Integer.valueOf(i2));
            }
            int i3 = this.i;
            if (i3 != -1) {
                jSONObject.putOpt("if_twist", Integer.valueOf(i3));
            }
            int i4 = this.yu;
            if (i4 != -1) {
                jSONObject.putOpt("dpa_position", Integer.valueOf(i4)).putOpt("dpa_pid", this.w);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static class ms {
        float ah;
        private String b;
        private int[] ch;
        private SparseArray<com.bytedance.sdk.openadsdk.core.xr.d.ms> h;
        private int[] hi;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        float f3040ms;
        private String nw;
        private int qv;
        private int[] sl;
        private String t;
        private String w;
        int xr;
        private String y;
        private int[] zb;
        private long d = -1;
        private long ka = -1;
        private float c = -1.0f;
        private float ab = -1.0f;
        private float x = -1.0f;
        private float ny = -1.0f;
        private int u = -1;
        private int ub = -1;
        private int ao = -1024;
        private int re = -1;
        private int i = -1;
        private int yu = -1;

        public ms ms(float f) {
            this.f3040ms = f;
            return this;
        }

        public ms ms(int i) {
            this.xr = i;
            return this;
        }

        public ms xr(float f) {
            this.ah = f;
            return this;
        }

        public ms xr(int i) {
            this.qv = i;
            return this;
        }

        public ms ms(SparseArray<com.bytedance.sdk.openadsdk.core.xr.d.ms> sparseArray) {
            this.h = sparseArray;
            return this;
        }

        public ms ms(long j) {
            this.d = j;
            return this;
        }

        public ms xr(long j) {
            this.ka = j;
            return this;
        }

        public ms ah(float f) {
            this.c = f;
            return this;
        }

        public ms d(float f) {
            this.ab = f;
            return this;
        }

        public ms ka(float f) {
            this.x = f;
            return this;
        }

        public ms c(float f) {
            this.ny = f;
            return this;
        }

        public ms ms(int[] iArr) {
            this.ch = iArr;
            return this;
        }

        public ms xr(int[] iArr) {
            this.hi = iArr;
            return this;
        }

        public ms ah(int[] iArr) {
            this.sl = iArr;
            return this;
        }

        public ms d(int[] iArr) {
            this.zb = iArr;
            return this;
        }

        public ms ah(int i) {
            this.u = i;
            return this;
        }

        public ms d(int i) {
            this.ub = i;
            return this;
        }

        public ms ka(int i) {
            this.ao = i;
            return this;
        }

        public ms ms(String str) {
            this.y = str;
            return this;
        }

        public ms xr(String str) {
            this.t = str;
            return this;
        }

        public ms ah(String str) {
            this.nw = str;
            return this;
        }

        public ms d(String str) {
            this.b = str;
            return this;
        }

        public ms c(int i) {
            this.re = i;
            return this;
        }

        public ms ab(int i) {
            this.i = i;
            return this;
        }

        public ms ka(String str) {
            this.w = str;
            return this;
        }

        public ms x(int i) {
            this.yu = i;
            return this;
        }

        public ch ms() {
            return new ch(this);
        }
    }
}
