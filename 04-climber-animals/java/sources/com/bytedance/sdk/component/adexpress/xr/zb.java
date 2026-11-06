package com.bytedance.sdk.component.adexpress.xr;

import android.view.View;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class zb {
    private String ab;
    private String ah;
    private boolean ao;
    private int b;
    private String c;
    private int ch;
    private JSONObject cv;
    private ny d;
    private String f;
    private boolean g;
    private String h;
    private long hi;
    private double i;
    private View jw;
    private int ka;
    private JSONObject le;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private JSONObject f1000ms;
    private int nw;
    private boolean ny;
    private String of;
    private JSONObject op;
    private final boolean p;
    private boolean pc;
    private int qv;
    private String re;
    private int sl;
    private int t;
    private Map<String, String> u;
    private int ub;
    private int ul;
    private int w;
    private String x;
    private ka xr;
    private int y;
    private boolean yu;
    private String zb;

    public zb(ms msVar) {
        this.pc = true;
        this.f1000ms = msVar.f1001ms;
        this.xr = msVar.xr;
        this.ah = msVar.ah;
        this.d = msVar.d;
        this.ka = msVar.ka;
        this.c = msVar.c;
        this.ab = msVar.ab;
        this.x = msVar.x;
        this.ny = msVar.ny;
        this.ch = msVar.ch;
        this.hi = msVar.hi;
        this.sl = msVar.sl;
        this.zb = msVar.zb;
        this.u = msVar.u;
        this.ub = msVar.ub;
        this.ao = msVar.ao;
        this.h = msVar.h;
        this.qv = msVar.qv;
        this.y = msVar.y;
        this.t = msVar.t;
        this.nw = msVar.nw;
        this.b = msVar.b;
        this.re = msVar.re;
        this.i = msVar.i;
        this.w = msVar.w;
        this.yu = msVar.yu;
        this.op = msVar.op;
        this.le = msVar.le;
        this.cv = msVar.cv;
        this.g = msVar.g;
        this.of = msVar.of;
        this.p = msVar.p;
        this.pc = msVar.pc;
        this.ul = msVar.jw;
        this.f = msVar.ul;
        this.jw = msVar.f;
    }

    public String ms() {
        return this.f;
    }

    public View xr() {
        return this.jw;
    }

    public boolean ah() {
        return this.yu;
    }

    public double d() {
        return this.i;
    }

    public JSONObject ka() {
        ka kaVar;
        if (this.f1000ms == null && (kaVar = this.xr) != null) {
            this.f1000ms = kaVar.ms();
        }
        return this.f1000ms;
    }

    public String c() {
        return this.ah;
    }

    public ny ab() {
        return this.d;
    }

    public int x() {
        return this.ka;
    }

    public boolean ny() {
        return this.pc;
    }

    public int ch() {
        return this.w;
    }

    public boolean hi() {
        return this.ny;
    }

    public long sl() {
        return this.hi;
    }

    public int zb() {
        return this.sl;
    }

    public Map<String, String> u() {
        return this.u;
    }

    public int ub() {
        return this.ub;
    }

    public boolean ao() {
        return this.ao;
    }

    public String h() {
        return this.h;
    }

    public void ms(int i) {
        this.ka = i;
    }

    public int qv() {
        return this.qv;
    }

    public int y() {
        return this.y;
    }

    public int t() {
        return this.t;
    }

    public JSONObject nw() {
        return this.op;
    }

    public JSONObject b() {
        return this.le;
    }

    public JSONObject re() {
        return this.cv;
    }

    public int i() {
        return this.nw;
    }

    public int w() {
        return this.b;
    }

    public boolean yu() {
        return this.g;
    }

    public String op() {
        return this.of;
    }

    public boolean le() {
        return this.p;
    }

    public int cv() {
        return this.ul;
    }

    public static class ms {
        private String ab;
        private String ah;
        private boolean ao;
        private int b;
        private String c;
        private int ch;
        private JSONObject cv;
        private ny d;
        private View f;
        private boolean g;
        private String h;
        private long hi;
        private double i;
        private int jw;
        private int ka;
        private JSONObject le;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private JSONObject f1001ms;
        private int nw;
        private boolean ny;
        private String of;
        private JSONObject op;
        private int qv;
        private String re;
        private int sl;
        private int t;
        private Map<String, String> u;
        private int ub;
        private String ul;
        private int w;
        private String x;
        private ka xr;
        private int y;
        private String zb;
        private boolean yu = true;
        private boolean p = true;
        private boolean pc = true;

        public ms ms(boolean z) {
            this.pc = z;
            return this;
        }

        public ms ms(JSONObject jSONObject) {
            this.f1001ms = jSONObject;
            return this;
        }

        public ms ms(String str) {
            this.ah = str;
            return this;
        }

        public ms ms(ny nyVar) {
            this.d = nyVar;
            return this;
        }

        public ms ms(int i) {
            this.ka = i;
            return this;
        }

        public ms xr(String str) {
            this.c = str;
            return this;
        }

        public ms ah(String str) {
            this.ab = str;
            return this;
        }

        public ms d(String str) {
            this.x = str;
            return this;
        }

        public ms xr(boolean z) {
            this.ny = z;
            return this;
        }

        public ms xr(int i) {
            this.ch = i;
            return this;
        }

        public ms ah(int i) {
            this.sl = i;
            return this;
        }

        public ms ka(String str) {
            this.zb = str;
            return this;
        }

        public ms ms(Map<String, String> map) {
            this.u = map;
            return this;
        }

        public ms d(int i) {
            this.ub = i;
            return this;
        }

        public ms c(String str) {
            this.h = str;
            return this;
        }

        public ms ka(int i) {
            this.qv = i;
            return this;
        }

        public ms c(int i) {
            this.y = i;
            return this;
        }

        public ms ab(int i) {
            this.t = i;
            return this;
        }

        public ms x(int i) {
            this.nw = i;
            return this;
        }

        public ms ny(int i) {
            this.b = i;
            return this;
        }

        public ms ab(String str) {
            this.re = str;
            return this;
        }

        public ms ah(boolean z) {
            this.g = z;
            return this;
        }

        public ms x(String str) {
            this.of = str;
            return this;
        }

        public ms ch(int i) {
            this.jw = i;
            return this;
        }

        public zb ms() {
            return new zb(this);
        }

        public ms xr(JSONObject jSONObject) {
            this.op = jSONObject;
            return this;
        }

        public ms ah(JSONObject jSONObject) {
            this.le = jSONObject;
            return this;
        }

        public ms d(JSONObject jSONObject) {
            this.cv = jSONObject;
            return this;
        }

        public ms ny(String str) {
            this.ul = str;
            return this;
        }

        public ms ms(View view) {
            this.f = view;
            return this;
        }
    }
}
