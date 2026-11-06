package com.byazt.vr;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import com.byazt.c.SSRenderTextureView;
import com.byazt.ca.aj;
import com.byazt.ca.iu;
import com.byazt.gz.hw;
import com.byazt.gz.uc;
import com.byazt.hg.of;
import com.byazt.ihe.c;
import com.byazt.ihe.fw;
import com.byazt.sd.a;
import com.byazt.te.UpieVideoView;
import com.byazt.vkw.qi;
import com.byazt.w.hn;
import com.byazt.wt.ls;
import com.byazt.yo.yb;
import com.byazt.zp.k;
import com.byazt.zp.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1184, 37})
public abstract class pr implements hn, qi.pr, com.byazt.mm.pr.InterfaceC0136pr, hw {
    public WeakReference<Context> aj;
    public uc c;
    public InterfaceC0217pr fo;
    public SurfaceTexture hn;
    public SurfaceHolder hw;
    public long nt;
    public com.byazt.n.uc ny;
    public volatile String rc;
    public of uc;
    public List<Runnable> w;
    public fw x;
    public com.byazt.n.hw z;
    public final iu pr = new iu(Looper.getMainLooper(), this);
    public long fw = 0;
    public long zo = 0;
    public boolean vk = false;
    public boolean k = true;
    public long m = 0;
    public boolean g = false;
    public boolean ho = false;
    public boolean yb = false;
    public volatile boolean lb = false;
    public boolean qa = false;
    public boolean a = false;
    public com.byazt.ne.pr cz = new com.byazt.ne.pr();
    public Runnable b = new Runnable() { // from class: com.byazt.vr.pr.1
        @Override // java.lang.Runnable
        public void run() {
            Object[] objArr = {"resumeVideo: run ", Boolean.valueOf(pr.this.vk)};
            pr.this.y();
        }
    };
    public final AtomicBoolean iu = new AtomicBoolean(false);

    /* JADX INFO: renamed from: com.byazt.vr.pr$pr, reason: collision with other inner class name */
    public interface InterfaceC0217pr {
        void pr(long j, long j2);
    }

    public void b() {
        if (this.x == null) {
            return;
        }
        if (fo()) {
            SurfaceTexture surfaceTexture = this.hn;
            if (surfaceTexture != null && surfaceTexture != this.x.z()) {
                this.x.pr(this.hn);
                return;
            }
            return;
        }
        SurfaceHolder surfaceHolder = this.hw;
        if (surfaceHolder != null && surfaceHolder != this.x.rc()) {
            this.x.pr(this.hw);
        }
    }

    public com.byazt.n.hw pr(String str) {
        of ofVar;
        if (!a.hw().fo() || (ofVar = this.uc) == null) {
            return null;
        }
        long jHw = w.pr(ofVar.sd()).hw(this.ny);
        int iPr = com.byazt.ne.hn.pr(this.uc, this.ny, jHw);
        c cVarWw = this.ny.ww();
        double dUc = -1.0d;
        if (cVarWw != null) {
            dUc = cVarWw.uc();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("video_source", str);
        } catch (JSONException e) {
        }
        return new com.byazt.n.c.pr().pr("video_life").pr(ls.k(this.uc)).x(ls.pr(this.uc, "")).hn(this.uc.ny()).hw(this.uc.x()).hw(this.uc.sd()).hn(iPr).pr(jHw).pr(dUc).x(this.uc.ab()).pr(jSONObject).c("7.7.1.4").pr();
    }

    public static com.byazt.n.hw pr(of ofVar) {
        if (!a.hw().fo() || ofVar == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("video_source", "assist");
        } catch (JSONException e) {
        }
        return new com.byazt.n.c.pr().pr("video_life").pr(ls.k(ofVar)).x(ls.pr(ofVar, "")).hn(ofVar.ny()).hw(ofVar.x()).hw(ofVar.sd()).hn(-1).pr(-1L).pr(-1.0d).x(ofVar.ab()).pr(jSONObject).c("7.7.1.4").pr();
    }

    private boolean fo() {
        uc ucVar = this.c;
        if (ucVar == null) {
            return false;
        }
        com.byazt.c.hw hwVarYb = ucVar.yb();
        return (hwVarYb instanceof SSRenderTextureView) || (hwVarYb instanceof UpieVideoView);
    }

    public boolean iu() {
        return true;
    }

    @Override // com.byazt.w.hn
    public long w() {
        return this.fw;
    }

    @Override // com.byazt.w.hn
    public void hw(long j) {
        this.fw = j;
        long j2 = this.zo;
        if (j2 > j) {
            j = j2;
        }
        this.zo = j;
    }

    public boolean ve() {
        WeakReference<Context> weakReference = this.aj;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    public void pr(Runnable runnable) {
        if (runnable == null || this.uc == null) {
            return;
        }
        if ((this.c.m() && this.vk) || k.pr(this.uc) || com.byazt.ja.pr.hw(this.uc)) {
            runnable.run();
        } else {
            hw(runnable);
        }
    }

    public boolean gz() {
        if ((this.c.m() && this.vk) || k.pr(this.uc) || com.byazt.ja.pr.hw(this.uc)) {
            zo(false);
            nl();
            return true;
        }
        hw("not exec pending");
        return false;
    }

    public void hw(Runnable runnable) {
        if (this.w == null) {
            this.w = new ArrayList();
        }
        this.w.add(runnable);
    }

    public void nl() {
        List<Runnable> list = this.w;
        if (list == null || list.isEmpty() || this.lb) {
            return;
        }
        aj.hw().post(new Runnable() { // from class: com.byazt.vr.pr.2
            @Override // java.lang.Runnable
            public void run() {
                pr.this.rc();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rc() {
        Iterator it = new ArrayList(this.w).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.w.clear();
    }

    public void zo(boolean z) {
        this.lb = z;
    }

    @Override // com.byazt.w.pr
    public void pr(com.byazt.w.hw hwVar, SurfaceTexture surfaceTexture) {
        this.vk = true;
        this.hn = surfaceTexture;
        fw fwVar = this.x;
        if (fwVar != null) {
            fwVar.pr(surfaceTexture);
            this.x.pr(this.vk);
        }
        nl();
    }

    @Override // com.byazt.w.pr
    public void hw(com.byazt.w.hw hwVar, SurfaceTexture surfaceTexture) {
        this.vk = false;
        fw fwVar = this.x;
        if (fwVar != null) {
            fwVar.pr(false);
        }
        this.hn = null;
        nl();
    }

    public void y() {
        this.pr.postAtFrontOfQueue(new Runnable() { // from class: com.byazt.vr.pr.3
            @Override // java.lang.Runnable
            public void run() {
                if (pr.this.x != null) {
                    Object[] objArr = {"resumeVideo: execResumePlay", Boolean.valueOf(pr.this.vk)};
                    pr.this.x.hn();
                }
            }
        });
    }

    @Override // com.byazt.w.hn
    public fw yb() {
        return this.x;
    }

    @Override // com.byazt.w.hn
    /* JADX INFO: renamed from: ww, reason: merged with bridge method [inline-methods] */
    public uc lb() {
        return this.c;
    }

    public boolean n() {
        return this.k;
    }

    @Override // com.byazt.w.hn
    public void pr(boolean z) {
        this.k = z;
        uc ucVar = this.c;
        if (ucVar != null) {
            ucVar.x(z);
        }
    }

    @Override // com.byazt.w.hn
    public void hn(long j) {
        this.m = j;
    }

    @Override // com.byazt.w.hn
    public boolean nt() {
        return this.ho;
    }

    @Override // com.byazt.w.hn
    public void x(long j) {
        this.nt = j;
    }

    @Override // com.byazt.w.hn
    public long k() {
        if (yb() == null) {
            return 0L;
        }
        return yb().nt();
    }

    @Override // com.byazt.w.hn
    public boolean qa() {
        return this.yb;
    }

    @Override // com.byazt.w.hn
    public void hw(boolean z) {
        this.yb = z;
        fw fwVar = this.x;
        if (fwVar != null) {
            fwVar.hw(z);
        }
    }

    @Override // com.byazt.w.hn
    public long g() {
        fw fwVar = this.x;
        if (fwVar == null) {
            return 0L;
        }
        return fwVar.a();
    }

    @Override // com.byazt.w.hn
    public boolean a() {
        return this.qa;
    }

    @Override // com.byazt.w.hn
    public void hn(boolean z) {
        this.qa = z;
    }

    @Override // com.byazt.vkw.qi.pr
    public void pr(Message message) {
    }

    public void aj(boolean z) {
        this.a = z;
    }

    public void hw(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error", str);
        } catch (JSONException e) {
        }
        com.byazt.xk.hw.pr().pr("video", jSONObject, (Throwable) null);
    }

    public void pr(int i, int i2, String str, JSONArray jSONArray) {
        if (this.aj == null) {
            return;
        }
        yb.pr prVar = new yb.pr();
        prVar.hw(k());
        prVar.hn(g());
        prVar.pr(w());
        prVar.pr(i);
        prVar.hw(i2);
        prVar.pr(jSONArray);
        if (!this.cz.pr(256)) {
            this.cz.hn(256);
            com.byazt.ne.hn.pr(lb(), prVar, str, !this.cz.pr(2) ? 1 : 0, this.cz.pr(128));
        }
    }

    public void e() {
        yb.pr prVar = new yb.pr();
        prVar.pr(w());
        prVar.hn(g());
        prVar.hw(k());
        prVar.uc(m());
        com.byazt.n.uc ucVarHw = com.byazt.ne.hn.hw(this.c);
        if (ucVarHw != null) {
            ucVarHw.pr("EXTRA_PLAY_ACTION", er());
        }
        com.byazt.ne.hn.x(this.c, prVar);
    }

    public void hw(int i) {
        if (this.cz.x(1)) {
            if (!this.k) {
                i *= 10;
            }
            pr(-900001, i, "only play start", (JSONArray) null);
        }
        JSONArray jSONArray = new JSONArray();
        if (!this.cz.pr(1)) {
            String strHw = ls.hw(this.uc);
            JSONObject jSONObjectPr = pr(4, strHw);
            if (jSONObjectPr != null) {
                jSONArray.put(jSONObjectPr);
            }
            JSONObject jSONObjectPr2 = pr(2, strHw);
            if (jSONObjectPr2 != null) {
                jSONArray.put(jSONObjectPr2);
            }
            JSONObject jSONObjectPr3 = pr(8, strHw);
            if (jSONObjectPr3 != null) {
                jSONArray.put(jSONObjectPr3);
            }
            JSONObject jSONObjectPr4 = pr(32, strHw);
            if (jSONObjectPr4 != null) {
                jSONArray.put(jSONObjectPr4);
            }
            JSONObject jSONObjectPr5 = pr(64, strHw);
            if (jSONObjectPr5 != null) {
                jSONArray.put(jSONObjectPr5);
            }
            JSONObject jSONObjectPr6 = pr(128, strHw);
            if (jSONObjectPr6 != null) {
                jSONArray.put(jSONObjectPr6);
            }
            pr(-900002, -701, "lack play start", jSONArray);
        }
    }

    private JSONObject pr(int i, String str) {
        String str2;
        try {
            if (this.cz.pr(128)) {
                str2 = "endcard_skip";
            } else if (this.cz.pr(8)) {
                str2 = "feed_continue";
            } else if (this.cz.pr(4)) {
                str2 = "feed_pause";
            } else if (this.cz.pr(2)) {
                str2 = "feed_play";
            } else if (this.cz.pr(64)) {
                str2 = "feed_over";
            } else if (!this.cz.pr(32)) {
                str2 = null;
            } else {
                str2 = "feed_break";
            }
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("tag", str);
                jSONObject.putOpt("label", str2);
                jSONObject.putOpt("time", this.cz.hw(i));
                return jSONObject;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void hn(Map<String, Object> map) {
        yb.pr prVar = new yb.pr();
        prVar.pr(w());
        prVar.hn(g());
        prVar.hw(k());
        com.byazt.n.uc ucVarHw = com.byazt.ne.hn.hw(this.c);
        if (ucVarHw != null) {
            ucVarHw.pr("EXTRA_PLAY_ACTION", er());
        }
        if (map != null) {
            prVar.pr(map);
        }
        pr(this.c, prVar);
    }

    public void pr(com.byazt.iw.pr prVar, yb.pr prVar2) {
        this.cz.hn(4);
        com.byazt.ne.hn.pr(this.c, prVar2, !this.cz.pr(2) ? 1 : 0);
    }

    public void s() {
        yb.pr prVar = new yb.pr();
        prVar.pr(w());
        prVar.hn(g());
        prVar.hw(k());
        com.byazt.n.uc ucVarHw = com.byazt.ne.hn.hw(this.c);
        if (ucVarHw != null) {
            ucVarHw.pr("EXTRA_PLAY_ACTION", er());
        }
        hw(lb(), prVar);
    }

    public void hw(com.byazt.iw.pr prVar, yb.pr prVar2) {
        this.cz.hn(8);
        com.byazt.ne.hn.hw(lb(), prVar2);
    }

    public void vk(boolean z) {
        yb.pr prVar = new yb.pr();
        prVar.hw(true);
        prVar.hn(z);
        com.byazt.n.uc ucVarHw = com.byazt.ne.hn.hw(this.c);
        if (ucVarHw != null) {
            ucVarHw.pr("EXTRA_PLAY_START", er());
        }
        hn(this.c, prVar);
    }

    public void hn(com.byazt.iw.pr prVar, yb.pr prVar2) {
        this.cz.hn(2);
        com.byazt.ne.hn.pr(prVar, prVar2);
    }

    public void ls() {
        if (this.ny == null) {
            return;
        }
        this.rc = com.byazt.ne.hn.pr();
        com.byazt.n.hw hwVar = this.z;
        if (hwVar != null) {
            hwVar.hw(this.rc);
        }
        this.cz.hn(1);
        this.ny.pr("EXTRA_PLAY_START", er());
        com.byazt.ne.hn.pr(this.uc, (com.byazt.iw.pr) this.c, this.ny, true, this.rc);
    }

    public void hn(int i) {
        fw fwVar = this.x;
        if (fwVar != null) {
            fwVar.pr(i);
        }
    }

    public void pr(InterfaceC0217pr interfaceC0217pr) {
        this.fo = interfaceC0217pr;
    }

    public Map<String, Object> er() {
        return null;
    }

    @Override // com.byazt.w.hn
    public boolean x() {
        return false;
    }

    @Override // com.byazt.w.hn
    public boolean c() {
        return false;
    }

    @Override // com.byazt.mm.pr.InterfaceC0136pr
    public boolean l_() {
        return false;
    }

    @Override // com.byazt.mm.pr.InterfaceC0136pr
    public com.byazt.mm.pr q_() {
        com.byazt.mm.pr prVar = new com.byazt.mm.pr();
        prVar.fw = this.fw;
        prVar.pr = a();
        prVar.zo = qa();
        prVar.x = cz();
        return prVar;
    }

    public void pr(long j, long j2) {
        if (!this.iu.get() && a.hw().tt() && (j * 1.0d) / j2 > 0.3d) {
            this.iu.set(true);
            com.byazt.mk.hn.fw().pr("videoPercent30", this.uc);
        }
    }
}
