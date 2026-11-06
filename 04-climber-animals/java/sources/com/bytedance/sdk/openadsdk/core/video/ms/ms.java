package com.bytedance.sdk.openadsdk.core.video.ms;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import com.bykv.vk.openvk.component.video.api.ah.d;
import com.bykv.vk.openvk.component.video.api.d.ah;
import com.bykv.vk.openvk.component.video.api.renderview.SSRenderTextureView;
import com.bytedance.sdk.component.utils.le;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.c.ah.h;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw.l;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.t.u;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.xr;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.op.ch;
import com.bytedance.sdk.openadsdk.op.ny;
import com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms implements ah, le.ms, com.bytedance.sdk.openadsdk.core.multipro.xr.ms.InterfaceC0296ms, xr {
    protected SurfaceTexture ah;
    protected long ao;
    protected d b;
    protected lm c;
    protected com.bykv.vk.openvk.component.video.api.ms d;
    protected List<Runnable> hi;
    protected c ka;
    protected WeakReference<Context> ny;
    protected InterfaceC0322ms re;
    private long w;
    protected SurfaceHolder xr;
    private long yu;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected final le f3587ms = new le(Looper.getMainLooper(), this);
    protected long ab = 0;
    protected long x = 0;
    protected boolean ch = false;
    protected boolean sl = true;
    protected long zb = 0;
    protected boolean u = false;
    protected boolean ub = false;
    protected boolean h = false;
    protected volatile boolean qv = false;
    protected boolean y = false;
    protected boolean t = false;
    public com.bytedance.sdk.openadsdk.c.xr.ms nw = new com.bytedance.sdk.openadsdk.c.xr.ms();
    protected Runnable i = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.ms.ms.1
        @Override // java.lang.Runnable
        public void run() {
            sl.ms("BaseController", "resumeVideo: run ", Boolean.valueOf(ms.this.ch));
            ms.this.jw();
        }
    };

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.video.ms.ms$ms, reason: collision with other inner class name */
    public interface InterfaceC0322ms {
        void ms(long j, long j2);
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public boolean d() {
        return false;
    }

    protected Map<String, Object> e() {
        return null;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public boolean ka() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.xr.ms.InterfaceC0296ms
    public boolean m_() {
        return false;
    }

    @Override // com.bytedance.sdk.component.utils.le.ms
    public void ms(Message message) {
    }

    public boolean op() {
        return true;
    }

    public boolean xr(int i) {
        return i == 6 || i == 8 || i == 9;
    }

    protected void yu() {
        if (this.d == null) {
            return;
        }
        if (re()) {
            SurfaceTexture surfaceTexture = this.ah;
            if (surfaceTexture == null || surfaceTexture == this.d.x()) {
                return;
            }
            this.d.ms(this.ah);
            return;
        }
        SurfaceHolder surfaceHolder = this.xr;
        if (surfaceHolder == null || surfaceHolder == this.d.ab()) {
            return;
        }
        this.d.ms(this.xr);
    }

    private boolean re() {
        c cVar = this.ka;
        if (cVar == null) {
            return false;
        }
        com.bykv.vk.openvk.component.video.api.renderview.xr xrVarH = cVar.h();
        return (xrVarH instanceof SSRenderTextureView) || (xrVarH instanceof UpieVideoView);
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public long hi() {
        return this.ab;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public void xr(long j) {
        this.ab = j;
        long j2 = this.x;
        if (j2 > j) {
            j = j2;
        }
        this.x = j;
    }

    protected boolean le() {
        WeakReference<Context> weakReference = this.ny;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    protected void ms(Runnable runnable) {
        if (runnable == null || this.c == null) {
            return;
        }
        if ((this.ka.zb() && this.ch) || ch.ms(this.c) || com.bytedance.sdk.openadsdk.ka.ms.xr(this.c)) {
            runnable.run();
        } else {
            xr(runnable);
        }
    }

    public boolean cv() {
        if ((this.ka.zb() && this.ch) || ch.ms(this.c) || com.bytedance.sdk.openadsdk.ka.ms.xr(this.c)) {
            x(false);
            pc();
            return true;
        }
        ms("not exec pending");
        return false;
    }

    protected int g() {
        int i = l.ms(this.c) ? 3 : 0;
        if (of()) {
            return 3;
        }
        return i;
    }

    public boolean of() {
        return this.w > 0;
    }

    public long p() {
        return this.w;
    }

    protected long ah(d dVar) {
        com.bykv.vk.openvk.component.video.api.ah.ah ahVarW;
        if (dVar == null || (ahVarW = dVar.w()) == null) {
            return 0L;
        }
        int iQw = this.c.qw();
        lm lmVar = this.c;
        if (lmVar != null) {
            int iX = f.x(lmVar);
            if (!xr(iQw)) {
                return 0L;
            }
            if ((iX != 7 && iX != 8) || l.ms(this.c)) {
                return 0L;
            }
        }
        double dAb = ahVarW.ab();
        if (dAb < 0.0d || dAb >= ahVarW.c()) {
            return 0L;
        }
        long jXr = ny.ms(dVar.qv()).xr(dVar);
        int iAo = ahVarW.ao();
        if (!(iAo > 0 && jXr >= ((long) iAo))) {
            return 0L;
        }
        long j = (long) (dAb * 1000.0d);
        this.w = j;
        return j;
    }

    protected void xr(Runnable runnable) {
        if (this.hi == null) {
            this.hi = new ArrayList();
        }
        this.hi.add(runnable);
    }

    protected void pc() {
        sl.ms("BaseController", "execPendingActions: before ");
        List<Runnable> list = this.hi;
        if (list == null || list.isEmpty() || this.qv) {
            return;
        }
        sl.ms("BaseController", "execPendingActions:  exec");
        x.xr().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.ms.ms.2
            @Override // java.lang.Runnable
            public void run() {
                ms.this.i();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        Iterator it = new ArrayList(this.hi).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.hi.clear();
    }

    public void x(boolean z) {
        this.qv = z;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ms
    public void ms(com.bykv.vk.openvk.component.video.api.d.xr xrVar, SurfaceHolder surfaceHolder) {
        this.ch = true;
        this.xr = surfaceHolder;
        com.bykv.vk.openvk.component.video.api.ms msVar = this.d;
        if (msVar == null) {
            return;
        }
        if (msVar != null) {
            msVar.ms(surfaceHolder);
        }
        sl.ms("BaseController", "surfaceCreated: ");
        pc();
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ms
    public void xr(com.bykv.vk.openvk.component.video.api.d.xr xrVar, SurfaceHolder surfaceHolder) {
        this.ch = false;
        this.xr = null;
        com.bykv.vk.openvk.component.video.api.ms msVar = this.d;
        if (msVar != null) {
            msVar.xr(false);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ms
    public void ms(com.bykv.vk.openvk.component.video.api.d.xr xrVar, SurfaceTexture surfaceTexture) {
        this.ch = true;
        this.ah = surfaceTexture;
        com.bykv.vk.openvk.component.video.api.ms msVar = this.d;
        if (msVar != null) {
            msVar.ms(surfaceTexture);
            this.d.xr(this.ch);
        }
        sl.ms("BaseController", "surfaceTextureCreated: ");
        pc();
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ms
    public void xr(com.bykv.vk.openvk.component.video.api.d.xr xrVar, SurfaceTexture surfaceTexture) {
        this.ch = false;
        sl.ms("BaseController", "surfaceTextureDestroyed: ");
        com.bykv.vk.openvk.component.video.api.ms msVar = this.d;
        if (msVar != null) {
            msVar.xr(false);
        }
        this.ah = null;
        pc();
    }

    protected void jw() {
        this.f3587ms.postAtFrontOfQueue(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.ms.ms.3
            @Override // java.lang.Runnable
            public void run() {
                if (ms.this.d != null) {
                    sl.ms("BaseController", "resumeVideo: execResumePlay", Boolean.valueOf(ms.this.ch));
                    ms.this.d.xr();
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public com.bykv.vk.openvk.component.video.api.ms h() {
        return this.d;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public c qv() {
        return this.ka;
    }

    public boolean ul() {
        return this.sl;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public void ms(boolean z) {
        this.sl = z;
        c cVar = this.ka;
        if (cVar != null) {
            cVar.d(z);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public void ah(long j) {
        this.zb = j;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public boolean ao() {
        return this.ub;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public void d(long j) {
        this.ao = j;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public long sl() {
        if (h() == null) {
            return 0L;
        }
        return h().ao();
    }

    public long ms(long j, long j2) {
        long jP = p();
        if (!ah() && (j == jP || j - jP < 0 || j == 0)) {
            return 0L;
        }
        lm lmVar = this.c;
        if (lmVar == null) {
            return j;
        }
        if (lmVar.tf() == 2 && j2 > 60000) {
            if (this.u) {
                long j3 = j2 - 60000;
                long j4 = this.yu;
                if (j - j4 >= j3) {
                    return j4;
                }
            }
            j2 = 60000;
        }
        long j5 = j - jP;
        long j6 = j5 + (j2 * ((long) (j5 > 0 ? 0 : 1)));
        this.yu = j6;
        return j6;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public boolean y() {
        return this.h;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public void xr(boolean z) {
        this.h = z;
        com.bykv.vk.openvk.component.video.api.ms msVar = this.d;
        if (msVar != null) {
            msVar.ms(z);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public long u() {
        com.bykv.vk.openvk.component.video.api.ms msVar = this.d;
        if (msVar == null) {
            return 0L;
        }
        return msVar.qv();
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public boolean t() {
        return this.y;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public void ah(boolean z) {
        this.y = z;
    }

    protected void ny(boolean z) {
        this.t = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ms(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error", str);
        } catch (JSONException unused) {
        }
        u.ms().ms("video", jSONObject, (Throwable) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ms(int i, int i2, String str, JSONArray jSONArray) {
        if (this.ny == null) {
            return;
        }
        h.ms msVar = new h.ms();
        msVar.xr(sl());
        long jU = u();
        msVar.ah(jU);
        msVar.ms(ka(jU));
        msVar.ms(i);
        msVar.xr(i2);
        msVar.ms(jSONArray);
        if (this.nw.ms(256)) {
            return;
        }
        this.nw.ah(256);
        com.bytedance.sdk.openadsdk.c.xr.d.ms(qv(), msVar, str, !this.nw.ms(2) ? 1 : 0, this.nw.ms(128));
    }

    private long ka(long j) {
        long jHi = hi();
        return of() ? ms(jHi, j) : jHi;
    }

    protected void az() {
        h.ms msVar = new h.ms();
        long jU = u();
        msVar.ms(ka(jU));
        msVar.ah(jU);
        msVar.xr(sl());
        msVar.c(zb());
        d dVarXr = com.bytedance.sdk.openadsdk.c.xr.d.xr(this.ka);
        if (dVarXr != null) {
            dVarXr.ms("EXTRA_PLAY_ACTION", e());
        }
        com.bytedance.sdk.openadsdk.c.xr.d.d(this.ka, msVar);
    }

    public void ah(int i) {
        if (this.nw.d(1)) {
            if (!this.sl) {
                i *= 10;
            }
            ms(-900001, i, "only play start", (JSONArray) null);
        }
        JSONArray jSONArray = new JSONArray();
        if (this.nw.ms(1)) {
            return;
        }
        String strXr = f.xr(this.c);
        JSONObject jSONObjectMs = ms(4, strXr);
        if (jSONObjectMs != null) {
            jSONArray.put(jSONObjectMs);
        }
        JSONObject jSONObjectMs2 = ms(2, strXr);
        if (jSONObjectMs2 != null) {
            jSONArray.put(jSONObjectMs2);
        }
        JSONObject jSONObjectMs3 = ms(8, strXr);
        if (jSONObjectMs3 != null) {
            jSONArray.put(jSONObjectMs3);
        }
        JSONObject jSONObjectMs4 = ms(32, strXr);
        if (jSONObjectMs4 != null) {
            jSONArray.put(jSONObjectMs4);
        }
        JSONObject jSONObjectMs5 = ms(64, strXr);
        if (jSONObjectMs5 != null) {
            jSONArray.put(jSONObjectMs5);
        }
        JSONObject jSONObjectMs6 = ms(128, strXr);
        if (jSONObjectMs6 != null) {
            jSONArray.put(jSONObjectMs6);
        }
        ms(-900002, -701, "lack play start", jSONArray);
    }

    private JSONObject ms(int i, String str) {
        String str2;
        try {
            if (this.nw.ms(128)) {
                str2 = "endcard_skip";
            } else if (this.nw.ms(8)) {
                str2 = "feed_continue";
            } else if (this.nw.ms(4)) {
                str2 = "feed_pause";
            } else if (this.nw.ms(2)) {
                str2 = "feed_play";
            } else if (this.nw.ms(64)) {
                str2 = "feed_over";
            } else {
                str2 = this.nw.ms(32) ? "feed_break" : null;
            }
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt(TTDownloadField.TT_TAG, str);
                jSONObject.putOpt(TTDownloadField.TT_LABEL, str2);
                jSONObject.putOpt("time", this.nw.xr(i));
                return jSONObject;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    protected void ah(Map<String, Object> map) {
        h.ms msVar = new h.ms();
        long jU = u();
        msVar.ms(ka(jU));
        msVar.ah(jU);
        msVar.xr(sl());
        d dVarXr = com.bytedance.sdk.openadsdk.c.xr.d.xr(this.ka);
        if (dVarXr != null) {
            dVarXr.ms("EXTRA_PLAY_ACTION", e());
        }
        if (map != null) {
            msVar.ms(map);
        }
        ms(this.ka, msVar);
    }

    protected void ms(com.bykv.vk.openvk.component.video.api.xr.ms msVar, h.ms msVar2) {
        this.nw.ah(4);
        com.bytedance.sdk.openadsdk.c.xr.d.ms(this.ka, msVar2, !this.nw.ms(2) ? 1 : 0);
    }

    protected void m() {
        h.ms msVar = new h.ms();
        long jU = u();
        msVar.ms(ka(jU));
        msVar.ah(jU);
        msVar.xr(sl());
        d dVarXr = com.bytedance.sdk.openadsdk.c.xr.d.xr(this.ka);
        if (dVarXr != null) {
            dVarXr.ms("EXTRA_PLAY_ACTION", e());
        }
        xr(qv(), msVar);
    }

    public void xr(com.bykv.vk.openvk.component.video.api.xr.ms msVar, h.ms msVar2) {
        this.nw.ah(8);
        com.bytedance.sdk.openadsdk.c.xr.d.xr(qv(), msVar2);
    }

    protected void ch(boolean z) {
        h.ms msVar = new h.ms();
        msVar.xr(true);
        msVar.ah(z);
        d dVarXr = com.bytedance.sdk.openadsdk.c.xr.d.xr(this.ka);
        if (dVarXr != null) {
            dVarXr.ms("EXTRA_PLAY_START", e());
        }
        ah(this.ka, msVar);
    }

    protected void ah(com.bykv.vk.openvk.component.video.api.xr.ms msVar, h.ms msVar2) {
        this.nw.ah(2);
        com.bytedance.sdk.openadsdk.c.xr.d.ms(msVar, msVar2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void lm() {
        if (this.b == null) {
            return;
        }
        this.nw.ah(1);
        this.b.ms("EXTRA_PLAY_START", e());
        com.bytedance.sdk.openadsdk.c.xr.d.ms(this.c, (com.bykv.vk.openvk.component.video.api.xr.ms) this.ka, this.b, true);
    }

    public void d(int i) {
        com.bykv.vk.openvk.component.video.api.ms msVar = this.d;
        if (msVar != null) {
            msVar.xr(i);
        }
    }

    public void ms(InterfaceC0322ms interfaceC0322ms) {
        this.re = interfaceC0322ms;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.xr.ms.InterfaceC0296ms
    public com.bytedance.sdk.openadsdk.core.multipro.xr.ms r_() {
        com.bytedance.sdk.openadsdk.core.multipro.xr.ms msVar = new com.bytedance.sdk.openadsdk.core.multipro.xr.ms();
        msVar.ab = this.ab;
        msVar.f2932ms = t();
        msVar.x = y();
        msVar.d = nw();
        return msVar;
    }
}
