package com.bytedance.sdk.openadsdk.c.ah;

import com.bytedance.sdk.openadsdk.core.nw.lm;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class h {
    private int ah;
    private com.bykv.vk.openvk.component.video.api.ah.d d;
    private lm ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private long f1847ms;
    private String xr;

    public h(long j, String str, int i, com.bykv.vk.openvk.component.video.api.ah.d dVar, lm lmVar) {
        this.f1847ms = j;
        this.xr = str;
        this.ah = i;
        this.d = dVar;
        this.ka = lmVar;
    }

    public long ms() {
        return this.f1847ms;
    }

    public String xr() {
        return this.xr;
    }

    public int ah() {
        return this.ah;
    }

    public com.bykv.vk.openvk.component.video.api.ah.d d() {
        return this.d;
    }

    public lm ka() {
        return this.ka;
    }

    public static class ms {
        private int ch;
        private int hi;
        private int ny;
        private int sl;
        private JSONArray u;
        private Map<String, Object> ub;
        private int x;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private long f1848ms = 0;
        private long xr = 0;
        private long ah = 0;
        private boolean d = false;
        private boolean ka = false;
        private int c = 0;
        private int ab = 0;
        private boolean zb = false;

        public void ms(JSONArray jSONArray) {
            this.u = jSONArray;
        }

        public JSONArray ms() {
            return this.u;
        }

        public long xr() {
            return this.f1848ms;
        }

        public void ms(long j) {
            this.f1848ms = j;
        }

        public long ah() {
            return this.xr;
        }

        public void xr(long j) {
            this.xr = j;
        }

        public long d() {
            return this.ah;
        }

        public void ah(long j) {
            this.ah = j;
        }

        public int ka() {
            return this.c;
        }

        public void ms(int i) {
            this.c = i;
        }

        public int c() {
            return this.ab;
        }

        public void xr(int i) {
            this.ab = i;
        }

        public int ab() {
            return this.x;
        }

        public void ah(int i) {
            this.x = i;
        }

        public int x() {
            return this.ny;
        }

        public void d(int i) {
            this.ny = i;
        }

        public int ny() {
            long j = this.ah;
            if (j <= 0) {
                return 0;
            }
            return Math.min((int) ((this.f1848ms * 100) / j), 100);
        }

        public int ch() {
            return this.ch;
        }

        public void ka(int i) {
            this.ch = i;
        }

        public int hi() {
            return this.hi;
        }

        public int sl() {
            return this.sl;
        }

        public void c(int i) {
            this.sl = i;
        }

        public boolean zb() {
            return this.zb;
        }

        public void ms(boolean z) {
            this.zb = z;
        }

        public boolean u() {
            return this.d;
        }

        public void xr(boolean z) {
            this.d = z;
        }

        public void ah(boolean z) {
            this.ka = z;
        }

        public boolean ub() {
            return this.ka;
        }

        public void ms(Map<String, Object> map) {
            this.ub = map;
        }

        public Map<String, Object> ao() {
            return this.ub;
        }
    }
}
