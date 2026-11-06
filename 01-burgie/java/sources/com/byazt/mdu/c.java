package com.byazt.mdu;

import android.app.Activity;
import android.content.Context;
import com.byazt.eyv.AdBaseConstants;
import com.byazt.fn.IDownloadFileUriProvider;
import com.byazt.fn.IDownloadListener;
import com.byazt.fn.g;
import com.byazt.fn.lb;
import com.byazt.fn.m;
import com.byazt.fn.rc;
import com.byazt.fn.y;
import com.byazt.lj.qa;
import com.byazt.lj.zo;
import com.byazt.mrs.EnqueueType;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_EXCEPTION, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public qa a;
    public long b;
    public String c;
    public com.byazt.lxs.pr cz;
    public int[] d;
    public boolean e;
    public String f;
    public boolean fo;
    public String fw;
    public IDownloadListener g;
    public String gu;
    public int gz;
    public String hn;
    public String ho;
    public boolean hs;
    public Context hw;
    public IDownloadFileUriProvider i;
    public boolean ie;
    public com.byazt.zkm.uc ii;
    public boolean iu;
    public int jn;
    public long l;
    public com.byazt.lj.fw lb;
    public int lv;
    public IDownloadListener m;
    public String mw;
    public boolean n;
    public boolean nl;
    public y nw;
    public boolean ny;
    public JSONObject o;
    public boolean od;
    public g of;
    public Activity pr;
    public zo qa;
    public rc qn;
    public lb r;
    public String rc;
    public boolean s;
    public String uc;
    public int v;
    public List<String> x;
    public String y;
    public boolean yb;
    public String z;
    public List<com.byazt.auw.hn> zo;
    public boolean aj = true;
    public boolean vk = false;
    public boolean w = true;
    public boolean k = false;
    public String nt = AdBaseConstants.MIME_APK;
    public int ve = 5;
    public boolean ww = true;
    public EnqueueType ls = EnqueueType.ENQUEUE_NONE;
    public int er = MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS;
    public boolean qi = true;
    public List<m> bm = new ArrayList();
    public boolean vj = true;
    public boolean sv = true;

    public c(Context context, String str) {
        this.hw = context.getApplicationContext();
        this.hn = str;
    }

    public Activity getActivity() {
        return this.pr;
    }

    public Context getContext() {
        return this.hw;
    }

    public String pr() {
        return this.hn;
    }

    public String hw() {
        return this.c;
    }

    public String hn() {
        return this.fw;
    }

    public List<com.byazt.auw.hn> x() {
        return this.zo;
    }

    public boolean c() {
        return this.aj;
    }

    public boolean uc() {
        return this.vk;
    }

    public boolean fw() {
        return this.w;
    }

    public boolean zo() {
        return this.k;
    }

    public IDownloadListener aj() {
        return this.m;
    }

    public IDownloadListener vk() {
        return this.g;
    }

    public String w() {
        return this.ho;
    }

    public String k() {
        return this.nt;
    }

    public boolean m() {
        return this.yb;
    }

    public com.byazt.lxs.pr g() {
        return this.cz;
    }

    public zo ho() {
        return this.qa;
    }

    public com.byazt.lj.fw nt() {
        return this.lb;
    }

    public boolean yb() {
        return this.ny;
    }

    public boolean lb() {
        return this.fo;
    }

    public int qa() {
        return this.lv;
    }

    public void pr(int i) {
        this.lv = i;
    }

    public String a() {
        return this.rc;
    }

    public String cz() {
        return this.z;
    }

    public long ny() {
        return this.b;
    }

    public int fo() {
        return this.ve;
    }

    public int rc() {
        return this.gz;
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

    public boolean ve() {
        return this.n;
    }

    public qa gz() {
        return this.a;
    }

    public int nl() {
        return this.er;
    }

    public int y() {
        return this.v;
    }

    public boolean ww() {
        return this.e;
    }

    public boolean n() {
        return this.s;
    }

    public boolean e() {
        return this.qi;
    }

    public boolean s() {
        return this.hs;
    }

    public EnqueueType ls() {
        return this.ls;
    }

    public boolean er() {
        return this.iu;
    }

    public String v() {
        return this.uc;
    }

    public rc qi() {
        return this.qn;
    }

    public g qn() {
        return this.of;
    }

    public com.byazt.zkm.uc of() {
        return this.ii;
    }

    public IDownloadFileUriProvider ii() {
        return this.i;
    }

    public y i() {
        return this.nw;
    }

    public List<m> r() {
        return this.bm;
    }

    public String hs() {
        return this.mw;
    }

    public boolean nw() {
        return this.ie;
    }

    public int ie() {
        return this.jn;
    }

    public long o() {
        return this.l;
    }

    public boolean f() {
        return this.sv;
    }

    public String bm() {
        return this.gu;
    }

    public int[] jn() {
        return this.d;
    }

    public boolean l() {
        return this.od;
    }

    public boolean lv() {
        return this.vj;
    }

    public c pr(String str) {
        this.c = str;
        return this;
    }

    public c hw(String str) {
        this.uc = str;
        return this;
    }

    public c hn(String str) {
        this.fw = str;
        return this;
    }

    public c pr(List<com.byazt.auw.hn> list) {
        this.zo = list;
        return this;
    }

    public c pr(boolean z) {
        this.aj = z;
        return this;
    }

    public c x(String str) {
        this.mw = str;
        return this;
    }

    public c hw(boolean z) {
        this.vk = z;
        return this;
    }

    public c hn(boolean z) {
        this.k = z;
        return this;
    }

    public c pr(IDownloadListener iDownloadListener) {
        this.m = iDownloadListener;
        return this;
    }

    public c c(String str) {
        this.ho = str;
        return this;
    }

    public c uc(String str) {
        this.nt = str;
        return this;
    }

    public c x(boolean z) {
        this.yb = z;
        return this;
    }

    public c c(boolean z) {
        this.ny = z;
        return this;
    }

    public c uc(boolean z) {
        this.fo = z;
        return this;
    }

    public c fw(String str) {
        this.rc = str;
        return this;
    }

    public c zo(String str) {
        this.z = str;
        return this;
    }

    public c pr(long j) {
        this.b = j;
        return this;
    }

    public c hw(int i) {
        this.ve = i;
        return this;
    }

    public c hn(int i) {
        this.gz = i;
        return this;
    }

    public c fw(boolean z) {
        this.nl = z;
        return this;
    }

    public c aj(String str) {
        this.y = str;
        return this;
    }

    public c zo(boolean z) {
        this.hs = z;
        return this;
    }

    public c aj(boolean z) {
        this.ww = z;
        return this;
    }

    public c vk(boolean z) {
        this.n = z;
        return this;
    }

    public c w(boolean z) {
        this.e = z;
        return this;
    }

    public c k(boolean z) {
        this.s = z;
        return this;
    }

    public c x(int i) {
        this.er = i;
        return this;
    }

    public c c(int i) {
        this.v = i;
        return this;
    }

    public c m(boolean z) {
        this.qi = z;
        return this;
    }

    public c pr(EnqueueType enqueueType) {
        this.ls = enqueueType;
        return this;
    }

    public c g(boolean z) {
        this.iu = z;
        return this;
    }

    public c pr(IDownloadFileUriProvider iDownloadFileUriProvider) {
        this.i = iDownloadFileUriProvider;
        return this;
    }

    public c vk(String str) {
        this.gu = str;
        return this;
    }

    public c w(String str) {
        this.f = str;
        return this;
    }

    public String od() {
        return this.f;
    }

    public c uc(int i) {
        this.jn = i;
        return this;
    }

    public List<String> vj() {
        return this.x;
    }

    public c hw(List<String> list) {
        this.x = list;
        return this;
    }

    public lb mw() {
        return this.r;
    }

    public c pr(lb lbVar) {
        this.r = lbVar;
        return this;
    }

    public JSONObject sv() {
        return this.o;
    }

    public c pr(JSONObject jSONObject) {
        this.o = jSONObject;
        return this;
    }

    public c pr(m mVar) {
        synchronized (this.bm) {
            if (mVar != null) {
                if (!this.bm.contains(mVar)) {
                    this.bm.add(mVar);
                    return this;
                }
            }
            return this;
        }
    }

    public c ho(boolean z) {
        this.od = z;
        return this;
    }

    public c nt(boolean z) {
        this.vj = z;
        return this;
    }
}
