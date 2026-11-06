package com.byazt.e;

import android.app.Activity;
import android.content.Context;
import com.byazt.je.IDownloadFileUriProvider;
import com.byazt.je.IDownloadListener;
import com.byazt.je.cd;
import com.byazt.je.lh;
import com.byazt.je.m;
import com.byazt.je.oa;
import com.byazt.je.sz;
import com.byazt.q.AdBaseConstants;
import com.byazt.sk.EnqueueType;
import com.byazt.xv.fs;
import com.byazt.xv.um;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FILE_SIZE, 18})
public class l {
    public um a;
    public boolean ae;
    public boolean an;
    public JSONObject b;
    public int bb;
    public com.byazt.xv.x cd;
    public boolean cx;
    public int df;
    public m dg;
    public boolean dh;
    public long e;
    public List<com.byazt.wm.s> fs;
    public long h;
    public boolean hd;
    public String hf;
    public String hu;
    public String ic;
    public boolean j;
    public String k;
    public int[] kc;
    public String l;
    public String lh;
    public boolean ln;
    public String m;
    public Activity n;
    public IDownloadListener oa;
    public boolean ou;
    public int pe;
    public com.byazt.z.w pk;
    public com.byazt.av.n py;
    public List<String> q;
    public Context qg;
    public lh rf;
    public String ri;
    public String s;
    public cd sh;
    public IDownloadListener sz;
    public boolean t;
    public sz u;
    public fs um;
    public String w;
    public boolean wm;
    public IDownloadFileUriProvider wo;
    public String x;
    public boolean y;
    public int yw;
    public boolean rv = true;
    public boolean tj = false;
    public boolean cp = true;
    public boolean d = false;
    public String cy = AdBaseConstants.MIME_APK;
    public int ur = 5;
    public boolean v = true;
    public EnqueueType f = EnqueueType.ENQUEUE_NONE;
    public int fi = 150;
    public boolean oj = true;
    public List<oa> nf = new ArrayList();
    public boolean lq = true;
    public boolean ci = true;

    public l(Context context, String str) {
        this.qg = context.getApplicationContext();
        this.s = str;
    }

    public Activity getActivity() {
        return this.n;
    }

    public Context getContext() {
        return this.qg;
    }

    public String n() {
        return this.s;
    }

    public String qg() {
        return this.l;
    }

    public String s() {
        return this.x;
    }

    public List<com.byazt.wm.s> q() {
        return this.fs;
    }

    public boolean l() {
        return this.rv;
    }

    public boolean w() {
        return this.tj;
    }

    public boolean x() {
        return this.cp;
    }

    public boolean fs() {
        return this.d;
    }

    public IDownloadListener rv() {
        return this.oa;
    }

    public IDownloadListener tj() {
        return this.sz;
    }

    public String cp() {
        return this.k;
    }

    public String d() {
        return this.cy;
    }

    public boolean oa() {
        return this.hd;
    }

    public com.byazt.av.n sz() {
        return this.py;
    }

    public fs k() {
        return this.um;
    }

    public com.byazt.xv.x cy() {
        return this.cd;
    }

    public boolean hd() {
        return this.ou;
    }

    public boolean cd() {
        return this.wm;
    }

    public int um() {
        return this.yw;
    }

    public void n(int i) {
        this.yw = i;
    }

    public String a() {
        return this.m;
    }

    public String py() {
        return this.hu;
    }

    public long ou() {
        return this.h;
    }

    public int wm() {
        return this.ur;
    }

    public int m() {
        return this.bb;
    }

    public boolean hu() {
        return this.ln;
    }

    public String h() {
        return this.lh;
    }

    public boolean t() {
        return this.v;
    }

    public boolean ur() {
        return this.j;
    }

    public um bb() {
        return this.a;
    }

    public int ln() {
        return this.fi;
    }

    public int lh() {
        return this.df;
    }

    public boolean v() {
        return this.an;
    }

    public boolean j() {
        return this.ae;
    }

    public boolean an() {
        return this.oj;
    }

    public boolean ae() {
        return this.y;
    }

    public EnqueueType f() {
        return this.f;
    }

    public boolean fi() {
        return this.t;
    }

    public String df() {
        return this.w;
    }

    public m oj() {
        return this.dg;
    }

    public sz dg() {
        return this.u;
    }

    public com.byazt.z.w u() {
        return this.pk;
    }

    public IDownloadFileUriProvider pk() {
        return this.wo;
    }

    public lh wo() {
        return this.rf;
    }

    public List<oa> sh() {
        return this.nf;
    }

    public String y() {
        return this.ic;
    }

    public boolean rf() {
        return this.dh;
    }

    public int dh() {
        return this.pe;
    }

    public long b() {
        return this.e;
    }

    public boolean ri() {
        return this.ci;
    }

    public String nf() {
        return this.hf;
    }

    public int[] pe() {
        return this.kc;
    }

    public boolean e() {
        return this.cx;
    }

    public boolean yw() {
        return this.lq;
    }

    public l n(String str) {
        this.l = str;
        return this;
    }

    public l qg(String str) {
        this.w = str;
        return this;
    }

    public l s(String str) {
        this.x = str;
        return this;
    }

    public l n(List<com.byazt.wm.s> list) {
        this.fs = list;
        return this;
    }

    public l n(boolean z) {
        this.rv = z;
        return this;
    }

    public l q(String str) {
        this.ic = str;
        return this;
    }

    public l qg(boolean z) {
        this.tj = z;
        return this;
    }

    public l s(boolean z) {
        this.d = z;
        return this;
    }

    public l n(IDownloadListener iDownloadListener) {
        this.oa = iDownloadListener;
        return this;
    }

    public l l(String str) {
        this.k = str;
        return this;
    }

    public l w(String str) {
        this.cy = str;
        return this;
    }

    public l q(boolean z) {
        this.hd = z;
        return this;
    }

    public l l(boolean z) {
        this.ou = z;
        return this;
    }

    public l w(boolean z) {
        this.wm = z;
        return this;
    }

    public l x(String str) {
        this.m = str;
        return this;
    }

    public l fs(String str) {
        this.hu = str;
        return this;
    }

    public l n(long j) {
        this.h = j;
        return this;
    }

    public l qg(int i) {
        this.ur = i;
        return this;
    }

    public l s(int i) {
        this.bb = i;
        return this;
    }

    public l x(boolean z) {
        this.ln = z;
        return this;
    }

    public l rv(String str) {
        this.lh = str;
        return this;
    }

    public l fs(boolean z) {
        this.y = z;
        return this;
    }

    public l rv(boolean z) {
        this.v = z;
        return this;
    }

    public l tj(boolean z) {
        this.j = z;
        return this;
    }

    public l cp(boolean z) {
        this.an = z;
        return this;
    }

    public l d(boolean z) {
        this.ae = z;
        return this;
    }

    public l q(int i) {
        this.fi = i;
        return this;
    }

    public l l(int i) {
        this.df = i;
        return this;
    }

    public l oa(boolean z) {
        this.oj = z;
        return this;
    }

    public l n(EnqueueType enqueueType) {
        this.f = enqueueType;
        return this;
    }

    public l sz(boolean z) {
        this.t = z;
        return this;
    }

    public l n(IDownloadFileUriProvider iDownloadFileUriProvider) {
        this.wo = iDownloadFileUriProvider;
        return this;
    }

    public l tj(String str) {
        this.hf = str;
        return this;
    }

    public l cp(String str) {
        this.ri = str;
        return this;
    }

    public String cx() {
        return this.ri;
    }

    public l w(int i) {
        this.pe = i;
        return this;
    }

    public List<String> lq() {
        return this.q;
    }

    public l qg(List<String> list) {
        this.q = list;
        return this;
    }

    public cd ic() {
        return this.sh;
    }

    public l n(cd cdVar) {
        this.sh = cdVar;
        return this;
    }

    public JSONObject ci() {
        return this.b;
    }

    public l n(JSONObject jSONObject) {
        this.b = jSONObject;
        return this;
    }

    public l n(oa oaVar) {
        synchronized (this.nf) {
            if (oaVar != null) {
                if (!this.nf.contains(oaVar)) {
                    this.nf.add(oaVar);
                    return this;
                }
            }
            return this;
        }
    }

    public l k(boolean z) {
        this.cx = z;
        return this;
    }

    public l cy(boolean z) {
        this.lq = z;
        return this;
    }
}
