package com.byazt.du;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import com.byazt.ej.oa;
import com.byazt.ej.x;
import com.byazt.gct.pk;
import com.byazt.hlq.SSRenderTextureView;
import com.byazt.ia.qg;
import com.byazt.ia.w;
import com.byazt.iag.s;
import com.byazt.nf.rv;
import com.byazt.shr.um;
import com.byazt.tk.t;
import com.byazt.vf.wo;
import com.byazt.vzj.UpieVideoView;
import com.byazt.zsl.l;
import com.byazt.zsl.q;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1898, 19})
public abstract class n implements s, wo.n, com.byazt.cs.n.InterfaceC0149n, qg {
    public List<Runnable> cp;
    public long cy;
    public com.byazt.vzj.n h;
    public oa hu;
    public w l;
    public volatile String m;
    public l ou;
    public x q;
    public SurfaceHolder qg;
    public WeakReference<Context> rv;
    public SurfaceTexture s;
    public pk w;
    public InterfaceC0157n wm;
    public final t n = new t(Looper.getMainLooper(), this);
    public long x = 0;
    public long fs = 0;
    public boolean tj = false;
    public boolean d = true;
    public long oa = 0;
    public boolean sz = false;
    public boolean k = false;
    public boolean hd = false;
    public volatile boolean cd = false;
    public boolean um = false;
    public boolean a = false;
    public com.byazt.gw.n py = new com.byazt.gw.n();
    public Runnable t = new Runnable() { // from class: com.byazt.du.n.1
        @Override // java.lang.Runnable
        public void run() {
            Object[] objArr = new Object[2];
            Boolean.valueOf(n.this.tj);
            n.this.ae();
        }
    };
    public final AtomicBoolean ur = new AtomicBoolean(false);

    /* JADX INFO: renamed from: com.byazt.du.n$n, reason: collision with other inner class name */
    public interface InterfaceC0157n {
        void n(long j, long j2);
    }

    @Override // com.byazt.iag.s
    public boolean l() {
        return false;
    }

    public boolean lh() {
        return true;
    }

    @Override // com.byazt.vf.wo.n
    public void n(Message message) {
    }

    public Map<String, Object> pk() {
        return null;
    }

    @Override // com.byazt.iag.s
    public boolean q() {
        return false;
    }

    @Override // com.byazt.cs.n.InterfaceC0149n
    public boolean ur() {
        return false;
    }

    @Override // com.byazt.iag.s
    public void wm() {
    }

    public void bb() {
        if (this.q == null) {
            return;
        }
        if (m()) {
            SurfaceTexture surfaceTexture = this.s;
            if (surfaceTexture == null || surfaceTexture == this.q.hu()) {
                return;
            }
            this.q.n(this.s);
            return;
        }
        SurfaceHolder surfaceHolder = this.qg;
        if (surfaceHolder == null || surfaceHolder == this.q.m()) {
            return;
        }
        this.q.n(this.qg);
    }

    public oa ln() {
        pk pkVar;
        if (!rv.qg().wm() || (pkVar = this.w) == null) {
            return null;
        }
        long jQg = com.byazt.ql.qg.n(pkVar.io()).qg(this.ou);
        int iN = com.byazt.gw.s.n(this.w, this.ou, jQg);
        com.byazt.ej.l lVarV = this.ou.v();
        double dW = lVarV != null ? lVarV.w() : -1.0d;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("video_source", "ad");
        } catch (JSONException unused) {
        }
        return new q.n().n("video_life").n(com.byazt.vgx.w.d(this.w)).q(com.byazt.vgx.w.n(this.w, "")).s(this.w.ou()).qg(this.w.q()).qg(this.w.io()).s(iN).n(jQg).n(dW).q(this.w.ds()).n(jSONObject).l("7.8.1.4").n();
    }

    public static oa n(pk pkVar) {
        return n(pkVar, "assist", -1L);
    }

    public static oa n(pk pkVar, long j) {
        return n(pkVar, "join", j);
    }

    private static oa n(pk pkVar, String str, long j) {
        if (!rv.qg().wm() || pkVar == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("video_source", str);
        } catch (JSONException unused) {
        }
        return new q.n().n("video_life").n(com.byazt.vgx.w.d(pkVar)).q(com.byazt.vgx.w.n(pkVar, "")).s(pkVar.ou()).qg(pkVar.q()).qg(pkVar.io()).s(-1).n(-1L).n(j).q(pkVar.ds()).n(jSONObject).l("7.8.1.4").n();
    }

    private boolean m() {
        w wVar = this.l;
        if (wVar == null) {
            return false;
        }
        com.byazt.hlq.qg qgVarHd = wVar.hd();
        return (qgVarHd instanceof SSRenderTextureView) || (qgVarHd instanceof UpieVideoView);
    }

    @Override // com.byazt.iag.s
    public long cp() {
        return this.x;
    }

    @Override // com.byazt.iag.s
    public void qg(long j) {
        this.x = j;
        long j2 = this.fs;
        if (j2 > j) {
            j = j2;
        }
        this.fs = j;
    }

    public boolean v() {
        WeakReference<Context> weakReference = this.rv;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    public void n(Runnable runnable) {
        if (runnable == null || this.w == null) {
            return;
        }
        if ((this.l.k() && this.tj) || com.byazt.ql.s.n(this.w) || com.byazt.aci.n.qg(this.w)) {
            runnable.run();
        } else {
            qg(runnable);
        }
    }

    public boolean j() {
        if ((this.l.k() && this.tj) || com.byazt.ql.s.n(this.w) || com.byazt.aci.n.qg(this.w)) {
            fs(false);
            an();
            return true;
        }
        n("not exec pending");
        return false;
    }

    public void qg(Runnable runnable) {
        if (this.cp == null) {
            this.cp = new ArrayList();
        }
        this.cp.add(runnable);
    }

    public void an() {
        List<Runnable> list = this.cp;
        if (list == null || list.isEmpty() || this.cd) {
            return;
        }
        com.byazt.tk.rv.qg().post(new Runnable() { // from class: com.byazt.du.n.2
            @Override // java.lang.Runnable
            public void run() {
                n.this.hu();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hu() {
        Iterator it = new ArrayList(this.cp).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.cp.clear();
    }

    public void fs(boolean z) {
        this.cd = z;
    }

    @Override // com.byazt.iag.n
    public void n(com.byazt.iag.qg qgVar, SurfaceTexture surfaceTexture) {
        this.tj = true;
        this.s = surfaceTexture;
        x xVar = this.q;
        if (xVar != null) {
            xVar.n(surfaceTexture);
            this.q.n(this.tj);
        }
        an();
    }

    @Override // com.byazt.iag.n
    public void qg(com.byazt.iag.qg qgVar, SurfaceTexture surfaceTexture) {
        this.tj = false;
        x xVar = this.q;
        if (xVar != null) {
            xVar.n(false);
        }
        this.s = null;
        an();
    }

    public void ae() {
        this.n.postAtFrontOfQueue(new Runnable() { // from class: com.byazt.du.n.3
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.q != null) {
                    Object[] objArr = new Object[2];
                    Boolean.valueOf(n.this.tj);
                    n.this.q.s();
                }
            }
        });
    }

    @Override // com.byazt.iag.s
    public x hd() {
        return this.q;
    }

    @Override // com.byazt.iag.s
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public w cd() {
        return this.l;
    }

    public boolean fi() {
        return this.d;
    }

    @Override // com.byazt.iag.s
    public void n(boolean z) {
        this.d = z;
        w wVar = this.l;
        if (wVar != null) {
            wVar.q(z);
        }
    }

    @Override // com.byazt.iag.s
    public void s(long j) {
        this.oa = j;
    }

    @Override // com.byazt.iag.s
    public boolean cy() {
        return this.k;
    }

    @Override // com.byazt.iag.s
    public void q(long j) {
        this.cy = j;
    }

    @Override // com.byazt.iag.s
    public long d() {
        if (hd() == null) {
            return 0L;
        }
        return hd().cy();
    }

    @Override // com.byazt.iag.s
    public boolean um() {
        return this.hd;
    }

    @Override // com.byazt.iag.s
    public void qg(boolean z) {
        this.hd = z;
        x xVar = this.q;
        if (xVar != null) {
            xVar.qg(z);
        }
    }

    @Override // com.byazt.iag.s
    public long sz() {
        x xVar = this.q;
        if (xVar == null) {
            return 0L;
        }
        return xVar.a();
    }

    @Override // com.byazt.iag.s
    public boolean a() {
        return this.um;
    }

    @Override // com.byazt.iag.s
    public void s(boolean z) {
        this.um = z;
    }

    public void rv(boolean z) {
        this.a = z;
    }

    public void n(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error", str);
        } catch (JSONException unused) {
        }
        com.byazt.eji.s.n().n(MediaFormat.KEY_VIDEO, jSONObject, (Throwable) null);
    }

    public um.n df() {
        um.n nVar = new um.n();
        n(nVar);
        return nVar;
    }

    public void n(um.n nVar) {
        com.byazt.vzj.n nVar2 = this.h;
        if (nVar == null || nVar2 == null) {
            return;
        }
        nVar.q(nVar2.n());
    }

    public void n(int i, int i2, String str, JSONArray jSONArray) {
        if (this.rv == null) {
            return;
        }
        um.n nVarDf = df();
        nVarDf.qg(d());
        nVarDf.s(sz());
        nVarDf.n(cp());
        nVarDf.n(i);
        nVarDf.qg(i2);
        nVarDf.n(jSONArray);
        if (this.py.n(256)) {
            return;
        }
        this.py.s(256);
        com.byazt.gw.s.n(cd(), nVarDf, str, !this.py.n(2) ? 1 : 0, this.py.n(128));
    }

    public void oj() {
        um.n nVarDf = df();
        nVarDf.n(cp());
        nVarDf.s(sz());
        nVarDf.qg(d());
        nVarDf.w(oa());
        l lVarQg = com.byazt.gw.s.qg(this.l);
        if (lVarQg != null) {
            lVarQg.n("EXTRA_PLAY_ACTION", pk());
        }
        com.byazt.gw.s.q(this.l, nVarDf);
    }

    public void qg(int i) {
        if (this.py.q(1)) {
            if (!this.d) {
                i *= 10;
            }
            n(-900001, i, "only play start", (JSONArray) null);
        }
        JSONArray jSONArray = new JSONArray();
        if (this.py.n(1)) {
            return;
        }
        String strQg = com.byazt.vgx.w.qg(this.w);
        JSONObject jSONObjectN = n(4, strQg);
        if (jSONObjectN != null) {
            jSONArray.put(jSONObjectN);
        }
        JSONObject jSONObjectN2 = n(2, strQg);
        if (jSONObjectN2 != null) {
            jSONArray.put(jSONObjectN2);
        }
        JSONObject jSONObjectN3 = n(8, strQg);
        if (jSONObjectN3 != null) {
            jSONArray.put(jSONObjectN3);
        }
        JSONObject jSONObjectN4 = n(32, strQg);
        if (jSONObjectN4 != null) {
            jSONArray.put(jSONObjectN4);
        }
        JSONObject jSONObjectN5 = n(64, strQg);
        if (jSONObjectN5 != null) {
            jSONArray.put(jSONObjectN5);
        }
        JSONObject jSONObjectN6 = n(128, strQg);
        if (jSONObjectN6 != null) {
            jSONArray.put(jSONObjectN6);
        }
        n(-900002, -701, "lack play start", jSONArray);
    }

    private JSONObject n(int i, String str) {
        String str2;
        try {
            if (this.py.n(128)) {
                str2 = "endcard_skip";
            } else if (this.py.n(8)) {
                str2 = "feed_continue";
            } else if (this.py.n(4)) {
                str2 = "feed_pause";
            } else if (this.py.n(2)) {
                str2 = "feed_play";
            } else if (this.py.n(64)) {
                str2 = "feed_over";
            } else {
                str2 = this.py.n(32) ? "feed_break" : null;
            }
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("tag", str);
                jSONObject.putOpt("label", str2);
                jSONObject.putOpt("time", this.py.qg(i));
                return jSONObject;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public void s(Map<String, Object> map) {
        um.n nVarDf = df();
        nVarDf.n(cp());
        nVarDf.s(sz());
        nVarDf.qg(d());
        l lVarQg = com.byazt.gw.s.qg(this.l);
        if (lVarQg != null) {
            lVarQg.n("EXTRA_PLAY_ACTION", pk());
        }
        if (map != null) {
            nVarDf.n(map);
        }
        n(this.l, nVarDf);
    }

    public void n(com.byazt.kb.n nVar, um.n nVar2) {
        n(nVar2);
        this.py.s(4);
        com.byazt.gw.s.n(this.l, nVar2, !this.py.n(2) ? 1 : 0);
    }

    public void dg() {
        um.n nVarDf = df();
        nVarDf.n(cp());
        nVarDf.s(sz());
        nVarDf.qg(d());
        l lVarQg = com.byazt.gw.s.qg(this.l);
        if (lVarQg != null) {
            lVarQg.n("EXTRA_PLAY_ACTION", pk());
        }
        qg(cd(), nVarDf);
    }

    public void qg(com.byazt.kb.n nVar, um.n nVar2) {
        n(nVar2);
        this.py.s(8);
        com.byazt.gw.s.qg(cd(), nVar2);
    }

    public void tj(boolean z) {
        um.n nVarDf = df();
        nVarDf.qg(true);
        nVarDf.s(z);
        l lVarQg = com.byazt.gw.s.qg(this.l);
        if (lVarQg != null) {
            lVarQg.n("EXTRA_PLAY_START", pk());
        }
        s(this.l, nVarDf);
    }

    public void s(com.byazt.kb.n nVar, um.n nVar2) {
        this.py.s(2);
        com.byazt.gw.s.n(nVar, nVar2);
    }

    public void u() {
        if (this.ou == null) {
            return;
        }
        this.m = com.byazt.gw.s.n();
        oa oaVar = this.hu;
        if (oaVar != null) {
            oaVar.n(this.m);
        }
        this.py.s(1);
        this.ou.n("EXTRA_PLAY_START", pk());
        com.byazt.gw.s.n(this.w, (com.byazt.kb.n) this.l, this.ou, true, this.m);
    }

    public void s(int i) {
        x xVar = this.q;
        if (xVar != null) {
            xVar.n(i);
        }
    }

    public void n(InterfaceC0157n interfaceC0157n) {
        this.wm = interfaceC0157n;
    }

    @Override // com.byazt.cs.n.InterfaceC0149n
    public com.byazt.cs.n t() {
        com.byazt.cs.n nVar = new com.byazt.cs.n();
        nVar.x = this.x;
        nVar.n = a();
        nVar.fs = um();
        nVar.q = py();
        return nVar;
    }

    public void n(long j, long j2) {
        if (!this.ur.get() && rv.qg().cl() && (j * 1.0d) / j2 > 0.3d) {
            this.ur.set(true);
            com.byazt.wb.s.x().n("videoPercent30", this.w);
            if (this.w != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("req_id", this.w.ou());
                    jSONObject2.putOpt("ad_slot_type", Integer.valueOf(com.byazt.vgx.w.d(this.w)));
                    jSONObject.putOpt("ad_info", jSONObject2);
                    com.byazt.rm.qg.n("videoPercent30", jSONObject);
                } catch (Exception unused) {
                }
            }
        }
    }
}
