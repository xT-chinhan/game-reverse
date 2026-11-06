package com.byazt.n;

import android.os.Build;
import android.text.TextUtils;
import com.byazt.ihe.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, 5})
public class uc implements m, Serializable {
    public int a;
    public com.byazt.ihe.c c;
    public int cz;
    public int fw;
    public List<String> g;
    public String ho;
    public int hw;
    public int k;
    public boolean lb;
    public int m;
    public long nt;
    public String pr;
    public String uc;
    public String w;
    public com.byazt.ihe.c x;
    public boolean yb;
    public int zo = 204800;
    public int aj = 0;
    public int vk = 0;
    public long qa = -1;
    public final HashMap<String, Object> hn = new HashMap<>();
    public int ny = 10000;
    public int fo = 10000;
    public int rc = 10000;
    public int z = 0;
    public JSONObject b = new JSONObject();

    public uc(String str, com.byazt.ihe.c cVar, com.byazt.ihe.c cVar2, int i, int i2) {
        this.a = 0;
        this.cz = 0;
        this.uc = str;
        this.x = cVar;
        this.c = cVar2;
        this.a = i;
        this.cz = i2;
    }

    @Override // com.byazt.ihe.m
    public JSONObject pr() {
        return this.b;
    }

    @Override // com.byazt.ihe.m
    public int hw() {
        return this.b.optInt("pitaya_cache_size", 0);
    }

    @Override // com.byazt.ihe.m
    public int hn() {
        return this.b.optInt("pitaya_code", 0);
    }

    @Override // com.byazt.ihe.m
    public String x() {
        return this.b.optString("pitaya_msg");
    }

    @Override // com.byazt.ihe.m
    public String c() {
        return this.uc;
    }

    @Override // com.byazt.ihe.m
    public void pr(String str) {
        this.uc = str;
    }

    @Override // com.byazt.ihe.m
    public int uc() {
        return this.fw;
    }

    @Override // com.byazt.ihe.m
    public void pr(int i) {
        this.fw = i;
    }

    @Override // com.byazt.ihe.m
    public int fw() {
        if (a()) {
            return this.c.nt();
        }
        com.byazt.ihe.c cVar = this.x;
        if (cVar != null) {
            return cVar.nt();
        }
        return 0;
    }

    @Override // com.byazt.ihe.m
    public boolean zo() {
        return this.lb;
    }

    @Override // com.byazt.ihe.m
    public void pr(boolean z) {
        this.lb = z;
    }

    @Override // com.byazt.ihe.m
    public String aj() {
        return this.w;
    }

    @Override // com.byazt.ihe.m
    public void hw(String str) {
        this.w = str;
    }

    @Override // com.byazt.ihe.m
    public int vk() {
        return this.k;
    }

    @Override // com.byazt.ihe.m
    public void hw(int i) {
        this.k = i;
    }

    @Override // com.byazt.ihe.m
    public int w() {
        return this.m;
    }

    @Override // com.byazt.ihe.m
    public void hn(int i) {
        this.m = i;
    }

    @Override // com.byazt.ihe.m
    public List<String> k() {
        return this.g;
    }

    @Override // com.byazt.ihe.m
    public void pr(List<String> list) {
        this.g = list;
    }

    @Override // com.byazt.ihe.m
    public String m() {
        return this.ho;
    }

    @Override // com.byazt.ihe.m
    public void hn(String str) {
        this.ho = str;
    }

    @Override // com.byazt.ihe.m
    public long g() {
        return this.nt;
    }

    @Override // com.byazt.ihe.m
    public void pr(long j) {
        this.nt = j;
    }

    @Override // com.byazt.ihe.m
    public boolean ho() {
        return this.yb;
    }

    @Override // com.byazt.ihe.m
    public void hw(boolean z) {
        this.yb = z;
    }

    @Override // com.byazt.ihe.m
    public long nt() {
        if (a()) {
            return this.c.c();
        }
        com.byazt.ihe.c cVar = this.x;
        if (cVar != null) {
            return cVar.c();
        }
        return 0L;
    }

    @Override // com.byazt.ihe.m
    public boolean yb() {
        if (a()) {
            return this.c.fo();
        }
        com.byazt.ihe.c cVar = this.x;
        if (cVar != null) {
            return cVar.fo();
        }
        return true;
    }

    @Override // com.byazt.ihe.m
    public String lb() {
        return this.pr;
    }

    @Override // com.byazt.ihe.m
    public void x(String str) {
        this.pr = str;
    }

    @Override // com.byazt.ihe.m
    public int qa() {
        return this.hw;
    }

    @Override // com.byazt.ihe.m
    public void x(int i) {
        this.hw = i;
    }

    @Override // com.byazt.ihe.m
    public boolean a() {
        com.byazt.ihe.c cVar;
        if (this.cz == 1 && (cVar = this.c) != null && !TextUtils.isEmpty(cVar.k())) {
            if (com.byazt.y.hw.c() == 2) {
                if (Build.VERSION.SDK_INT >= 26) {
                    return true;
                }
            } else if (this.a == 1) {
                return true;
            }
        }
        return false;
    }

    @Override // com.byazt.ihe.m
    public float cz() {
        if (a()) {
            return this.c.zo();
        }
        com.byazt.ihe.c cVar = this.x;
        if (cVar != null) {
            return cVar.zo();
        }
        return -1.0f;
    }

    @Override // com.byazt.ihe.m
    public String ny() {
        if (a()) {
            return this.c.k();
        }
        com.byazt.ihe.c cVar = this.x;
        if (cVar != null) {
            return cVar.k();
        }
        return null;
    }

    @Override // com.byazt.ihe.m
    public String fo() {
        if (a()) {
            return this.c.ho();
        }
        com.byazt.ihe.c cVar = this.x;
        if (cVar != null) {
            return cVar.ho();
        }
        return null;
    }

    @Override // com.byazt.ihe.m
    public int rc() {
        return this.a;
    }

    @Override // com.byazt.ihe.m
    public void c(int i) {
        this.a = i;
    }

    @Override // com.byazt.ihe.m
    public synchronized void pr(String str, Object obj) {
        this.hn.put(str, obj);
    }

    @Override // com.byazt.ihe.m
    public synchronized Object c(String str) {
        return this.hn.get(str);
    }

    @Override // com.byazt.ihe.m
    public Object uc(String str) {
        return this.hn.remove(str);
    }

    @Override // com.byazt.ihe.m
    public int z() {
        return this.ny;
    }

    @Override // com.byazt.ihe.m
    public void uc(int i) {
        this.ny = i;
    }

    @Override // com.byazt.ihe.m
    public int b() {
        return this.fo;
    }

    @Override // com.byazt.ihe.m
    public void fw(int i) {
        this.fo = i;
    }

    @Override // com.byazt.ihe.m
    public int iu() {
        return this.rc;
    }

    @Override // com.byazt.ihe.m
    public void zo(int i) {
        this.rc = i;
    }

    @Override // com.byazt.ihe.m
    public int ve() {
        return this.z;
    }

    @Override // com.byazt.ihe.m
    public void aj(int i) {
        this.z = i;
    }

    @Override // com.byazt.ihe.m
    public int gz() {
        return this.cz;
    }

    @Override // com.byazt.ihe.m
    public void vk(int i) {
        this.cz = i;
    }

    @Override // com.byazt.ihe.m
    public com.byazt.ihe.c nl() {
        return this.x;
    }

    @Override // com.byazt.ihe.m
    public void pr(com.byazt.ihe.c cVar) {
        this.x = cVar;
    }

    @Override // com.byazt.ihe.m
    public com.byazt.ihe.c y() {
        return this.c;
    }

    @Override // com.byazt.ihe.m
    public com.byazt.ihe.c ww() {
        if (a()) {
            return this.c;
        }
        com.byazt.ihe.c cVar = this.x;
        if (cVar != null) {
            return cVar;
        }
        return null;
    }

    @Override // com.byazt.ihe.m
    public void hw(com.byazt.ihe.c cVar) {
        this.c = cVar;
    }
}
