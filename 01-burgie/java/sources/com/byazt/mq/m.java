package com.byazt.mq;

import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 427, 108})
public class m {
    public int a;
    public boolean aj;
    public boolean b;
    public int c;
    public int cz;
    public View e;
    public boolean er;
    public String fo;
    public String fw;
    public Map<String, String> g;
    public JSONObject gz;
    public String hn;
    public int ho;
    public c hw;
    public JSONObject iu;
    public int k;
    public int lb;
    public int ls;
    public String m;
    public boolean n;
    public boolean nl;
    public boolean nt;
    public int ny;
    public JSONObject pr;
    public int qa;
    public double rc;
    public String s;
    public String uc;
    public JSONObject ve;
    public int vk;
    public long w;
    public final boolean ww;
    public aj x;
    public String y;
    public String yb;
    public int z;
    public String zo;

    public m(pr prVar) {
        this.n = true;
        this.pr = prVar.pr;
        this.hw = prVar.hw;
        this.hn = prVar.hn;
        this.x = prVar.x;
        this.c = prVar.c;
        this.uc = prVar.uc;
        this.fw = prVar.fw;
        this.zo = prVar.zo;
        this.aj = prVar.aj;
        this.vk = prVar.vk;
        this.w = prVar.w;
        this.k = prVar.k;
        this.m = prVar.m;
        this.g = prVar.g;
        this.ho = prVar.ho;
        this.nt = prVar.nt;
        this.yb = prVar.yb;
        this.lb = prVar.lb;
        this.qa = prVar.qa;
        this.a = prVar.a;
        this.cz = prVar.cz;
        this.ny = prVar.ny;
        this.fo = prVar.fo;
        this.rc = prVar.rc;
        this.z = prVar.z;
        this.b = prVar.b;
        this.iu = prVar.iu;
        this.ve = prVar.ve;
        this.gz = prVar.gz;
        this.nl = prVar.nl;
        this.y = prVar.y;
        this.ww = prVar.ww;
        this.n = prVar.n;
        this.ls = prVar.e;
        this.s = prVar.ls;
        this.e = prVar.s;
        this.er = prVar.er;
    }

    public String pr() {
        return this.s;
    }

    public View hw() {
        return this.e;
    }

    public boolean hn() {
        return this.b;
    }

    public double x() {
        return this.rc;
    }

    public JSONObject c() {
        c cVar;
        if (this.pr == null && (cVar = this.hw) != null) {
            this.pr = cVar.pr();
        }
        return this.pr;
    }

    public String uc() {
        return this.hn;
    }

    public aj fw() {
        return this.x;
    }

    public int zo() {
        return this.c;
    }

    public boolean aj() {
        return this.n;
    }

    public boolean vk() {
        return this.aj;
    }

    public long w() {
        return this.w;
    }

    public int k() {
        return this.k;
    }

    public Map<String, String> m() {
        return this.g;
    }

    public int g() {
        return this.ho;
    }

    public boolean ho() {
        return this.nt;
    }

    public String nt() {
        return this.yb;
    }

    public void pr(int i) {
        this.c = i;
    }

    public int yb() {
        return this.lb;
    }

    public int lb() {
        return this.qa;
    }

    public int qa() {
        return this.a;
    }

    public JSONObject a() {
        return this.iu;
    }

    public JSONObject cz() {
        return this.ve;
    }

    public JSONObject ny() {
        return this.gz;
    }

    public int fo() {
        return this.cz;
    }

    public int rc() {
        return this.ny;
    }

    public boolean z() {
        return this.nl;
    }

    public String b() {
        return this.y;
    }

    public boolean iu() {
        return this.ww;
    }

    public int ve() {
        return this.ls;
    }

    public boolean gz() {
        return this.er;
    }

    @com.byazt.vzx.pr(pr = {0, 1, 427, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_STREAM_RECEIVED_WINDOW})
    public static class pr {
        public int a;
        public boolean aj;
        public int c;
        public int cz;
        public int e;
        public String fo;
        public String fw;
        public Map<String, String> g;
        public JSONObject gz;
        public String hn;
        public int ho;
        public c hw;
        public JSONObject iu;
        public int k;
        public int lb;
        public String ls;
        public String m;
        public boolean nl;
        public boolean nt;
        public int ny;
        public JSONObject pr;
        public int qa;
        public double rc;
        public View s;
        public String uc;
        public JSONObject ve;
        public int vk;
        public long w;
        public aj x;
        public String y;
        public String yb;
        public int z;
        public String zo;
        public boolean b = true;
        public boolean ww = true;
        public boolean n = true;
        public boolean er = false;

        public pr pr(boolean z) {
            this.n = z;
            return this;
        }

        public pr pr(JSONObject jSONObject) {
            this.pr = jSONObject;
            return this;
        }

        public pr pr(String str) {
            this.hn = str;
            return this;
        }

        public pr pr(aj ajVar) {
            this.x = ajVar;
            return this;
        }

        public pr pr(int i) {
            this.c = i;
            return this;
        }

        public pr hw(String str) {
            this.uc = str;
            return this;
        }

        public pr hn(String str) {
            this.fw = str;
            return this;
        }

        public pr x(String str) {
            this.zo = str;
            return this;
        }

        public pr hw(boolean z) {
            this.aj = z;
            return this;
        }

        public pr hw(int i) {
            this.vk = i;
            return this;
        }

        public pr hn(int i) {
            this.k = i;
            return this;
        }

        public pr c(String str) {
            this.m = str;
            return this;
        }

        public pr pr(Map<String, String> map) {
            this.g = map;
            return this;
        }

        public pr x(int i) {
            this.ho = i;
            return this;
        }

        public pr uc(String str) {
            this.yb = str;
            return this;
        }

        public pr c(int i) {
            this.lb = i;
            return this;
        }

        public pr uc(int i) {
            this.qa = i;
            return this;
        }

        public pr fw(int i) {
            this.a = i;
            return this;
        }

        public pr zo(int i) {
            this.cz = i;
            return this;
        }

        public pr aj(int i) {
            this.ny = i;
            return this;
        }

        public pr fw(String str) {
            this.fo = str;
            return this;
        }

        public pr hn(boolean z) {
            this.nl = z;
            return this;
        }

        public pr zo(String str) {
            this.y = str;
            return this;
        }

        public pr vk(int i) {
            this.e = i;
            return this;
        }

        public m pr() {
            return new m(this);
        }

        public pr hw(JSONObject jSONObject) {
            this.iu = jSONObject;
            return this;
        }

        public pr hn(JSONObject jSONObject) {
            this.ve = jSONObject;
            return this;
        }

        public pr x(JSONObject jSONObject) {
            this.gz = jSONObject;
            return this;
        }

        public pr aj(String str) {
            this.ls = str;
            return this;
        }

        public pr pr(View view) {
            this.s = view;
            return this;
        }

        public pr x(boolean z) {
            this.er = z;
            return this;
        }
    }
}
