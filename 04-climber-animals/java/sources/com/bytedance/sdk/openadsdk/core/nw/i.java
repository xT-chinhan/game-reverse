package com.bytedance.sdk.openadsdk.core.nw;

import android.util.SparseArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class i implements com.bytedance.sdk.component.adexpress.ah {
    public final int ab;
    public final float ah;
    public SparseArray<com.bytedance.sdk.openadsdk.core.xr.d.ms> ao;
    public final long c;
    public final int ch;
    public final float d;
    public String h;
    public final String hi;
    public final long ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public final float f3057ms;
    public final int ny;
    public int qv;
    public final String sl;
    public final String u;
    public final boolean ub;
    public final int x;
    public final float xr;
    private JSONObject y;
    public final String zb;

    private i(ms msVar) {
        this.qv = -1;
        this.f3057ms = msVar.ab;
        this.xr = msVar.c;
        this.ah = msVar.ka;
        this.d = msVar.d;
        this.ka = msVar.ah;
        this.c = msVar.xr;
        this.ab = msVar.x;
        this.x = msVar.ny;
        this.ny = msVar.ch;
        this.ch = msVar.hi;
        this.hi = msVar.sl;
        this.ao = msVar.f3058ms;
        this.ub = msVar.ao;
        this.y = msVar.h;
        this.sl = msVar.zb;
        this.zb = msVar.u;
        this.u = msVar.ub;
        this.h = msVar.qv;
        this.qv = msVar.y;
    }

    public JSONObject ms() {
        if (this.y == null) {
            this.y = new JSONObject();
        }
        return this.y;
    }

    public static class ms {
        private float ab;
        private long ah;
        private boolean ao;
        private float c;
        private int ch;
        private float d;
        private JSONObject h;
        private int hi;
        private float ka;
        private int ny;
        private String qv;
        private String sl;
        private String u;
        private String ub;
        private int x;
        private long xr;
        private String zb;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        protected SparseArray<com.bytedance.sdk.openadsdk.core.xr.d.ms> f3058ms = new SparseArray<>();
        private int y = -1;

        public ms ms(boolean z) {
            this.ao = z;
            return this;
        }

        public ms ms(long j) {
            this.xr = j;
            return this;
        }

        public ms xr(long j) {
            this.ah = j;
            return this;
        }

        public ms ms(float f) {
            this.d = f;
            return this;
        }

        public ms xr(float f) {
            this.ka = f;
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

        public ms ms(int i) {
            this.x = i;
            return this;
        }

        public ms xr(int i) {
            this.ny = i;
            return this;
        }

        public ms ah(int i) {
            this.ch = i;
            return this;
        }

        public ms d(int i) {
            this.hi = i;
            return this;
        }

        public ms ms(String str) {
            this.sl = str;
            return this;
        }

        public ms ms(SparseArray<com.bytedance.sdk.openadsdk.core.xr.d.ms> sparseArray) {
            this.f3058ms = sparseArray;
            return this;
        }

        public ms ms(JSONObject jSONObject) {
            this.h = jSONObject;
            return this;
        }

        public ms xr(String str) {
            this.zb = str;
            return this;
        }

        public ms ah(String str) {
            this.u = str;
            return this;
        }

        public ms d(String str) {
            this.ub = str;
            return this;
        }

        public ms ka(String str) {
            this.qv = str;
            return this;
        }

        public ms ka(int i) {
            this.y = i;
            return this;
        }

        public i ms() {
            return new i(this);
        }
    }
}
