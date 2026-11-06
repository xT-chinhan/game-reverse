package com.byazt.vzj;

import android.graphics.SurfaceTexture;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import com.byazt.ej.k;
import com.byazt.ej.oa;
import com.byazt.ej.x;
import com.byazt.pp.LottieAnimationView;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX, 8})
public class s implements x {
    public final com.byazt.hlq.qg cp;
    public LottieAnimationView d;
    public boolean q;
    public final int qg;
    public final x rv;
    public final int s;
    public long w;
    public final String n = "UpieVideoPlayer";
    public int l = 0;
    public volatile boolean x = false;
    public volatile boolean fs = false;
    public final Map<x.n, x.n> tj = new ConcurrentHashMap();

    @Override // com.byazt.ej.x
    public String h() {
        return "";
    }

    @Override // com.byazt.ej.x
    public void n(oa oaVar) {
    }

    public static /* synthetic */ int n(s sVar) {
        int i = sVar.l;
        sVar.l = i + 1;
        return i;
    }

    public s(x xVar, com.byazt.ts.n nVar, oa oaVar, com.byazt.hlq.qg qgVar) {
        this.rv = xVar;
        this.qg = nVar.q();
        this.s = nVar.l();
        this.cp = qgVar;
        if (qgVar instanceof UpieVideoView) {
            LottieAnimationView lottieAnimationView = ((UpieVideoView) qgVar).getLottieAnimationView();
            this.d = lottieAnimationView;
            if (lottieAnimationView != null) {
                lottieAnimationView.setVideoStats(oaVar);
            }
        }
        n(nVar.n());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final String str) {
        if (TextUtils.isEmpty(str)) {
            n(new com.byazt.zsl.qg(60008, 10000, "lottieJsonUrl为空"));
        } else {
            com.byazt.oa.qg.s(new Runnable() { // from class: com.byazt.vzj.s.1
                @Override // java.lang.Runnable
                public void run() {
                    String strQg = com.byazt.ts.qg.n().qg(str);
                    if (!TextUtils.isEmpty(strQg)) {
                        s.this.n(strQg, str);
                    } else {
                        com.byazt.ts.qg.n().n(str, new com.byazt.ts.qg.n<String>() { // from class: com.byazt.vzj.s.1.1
                            @Override // com.byazt.ts.qg.n
                            public void n(String str2) {
                                s.this.n(str2, str);
                            }

                            @Override // com.byazt.ts.qg.n
                            public void n(int i, String str2) {
                                if (i == 10006) {
                                    s.this.n(new com.byazt.zsl.qg(60008, i, str2));
                                    return;
                                }
                                s.n(s.this);
                                if (s.this.l <= 3) {
                                    s.this.n(str);
                                } else {
                                    s.this.n(new com.byazt.zsl.qg(60008, i, str2));
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final com.byazt.ej.s sVar) {
        com.byazt.oa.qg.qg(new Runnable() { // from class: com.byazt.vzj.s.2
            @Override // java.lang.Runnable
            public void run() {
                if (s.this.q) {
                    return;
                }
                s.this.q = true;
                sVar.n();
                sVar.qg();
                sVar.s();
                Iterator it = s.this.tj.entrySet().iterator();
                while (it.hasNext()) {
                    ((x.n) ((Map.Entry) it.next()).getKey()).n(s.this, sVar);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final String str, final String str2) {
        com.byazt.oa.qg.n(new Runnable() { // from class: com.byazt.vzj.s.3
            @Override // java.lang.Runnable
            public void run() {
                s.this.x = true;
                if (s.this.d != null) {
                    s.this.d.n(str, str2);
                }
                s.this.n();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        com.byazt.oa.qg.qg(new Runnable() { // from class: com.byazt.vzj.s.4
            @Override // java.lang.Runnable
            public void run() {
                if (s.this.fs && s.this.x) {
                    s.this.rv.s();
                    if (s.this.d != null) {
                        s.this.d.n();
                        if (s.this.w > 0) {
                            s sVar = s.this;
                            sVar.qg(sVar.w);
                        }
                    }
                }
            }
        });
    }

    @Override // com.byazt.ej.x
    public void n(k kVar) {
        this.rv.n(kVar);
    }

    @Override // com.byazt.ej.x
    public void qg(boolean z) {
        this.rv.qg(z);
    }

    @Override // com.byazt.ej.x
    public void qg(int i) {
        this.rv.qg(i);
    }

    @Override // com.byazt.ej.x
    public void n(boolean z, long j, boolean z2) {
        this.rv.n(z, j, z2);
        this.w = j;
        com.byazt.hlq.qg qgVar = this.cp;
        if (qgVar instanceof UpieVideoView) {
            ((UpieVideoView) qgVar).n();
        }
    }

    @Override // com.byazt.ej.x
    public void qg() {
        this.rv.qg();
        LottieAnimationView lottieAnimationView = this.d;
        if (lottieAnimationView != null) {
            lottieAnimationView.w();
            this.d.setProgress(0.0f);
            this.d.n();
        }
        com.byazt.hlq.qg qgVar = this.cp;
        if (qgVar instanceof UpieVideoView) {
            ((UpieVideoView) qgVar).n();
        }
    }

    @Override // com.byazt.ej.x
    public void s() {
        this.rv.s();
        LottieAnimationView lottieAnimationView = this.d;
        if (lottieAnimationView != null) {
            lottieAnimationView.qg();
        }
        com.byazt.hlq.qg qgVar = this.cp;
        if (qgVar instanceof UpieVideoView) {
            ((UpieVideoView) qgVar).n();
        }
    }

    @Override // com.byazt.ej.x
    public void q() {
        this.rv.q();
        LottieAnimationView lottieAnimationView = this.d;
        if (lottieAnimationView != null) {
            lottieAnimationView.x();
        }
        com.byazt.hlq.qg qgVar = this.cp;
        if (qgVar instanceof UpieVideoView) {
            ((UpieVideoView) qgVar).qg();
        }
    }

    @Override // com.byazt.ej.x
    public void x() {
        this.rv.x();
        LottieAnimationView lottieAnimationView = this.d;
        if (lottieAnimationView != null) {
            lottieAnimationView.x();
        }
        com.byazt.hlq.qg qgVar = this.cp;
        if (qgVar instanceof UpieVideoView) {
            ((UpieVideoView) qgVar).qg();
        }
    }

    @Override // com.byazt.ej.x
    public void l() {
        this.rv.l();
        LottieAnimationView lottieAnimationView = this.d;
        if (lottieAnimationView != null) {
            lottieAnimationView.x();
            this.d.setProgress(0.0f);
        }
        com.byazt.hlq.qg qgVar = this.cp;
        if (qgVar instanceof UpieVideoView) {
            ((UpieVideoView) qgVar).qg();
        }
    }

    @Override // com.byazt.ej.x
    public void w() {
        this.rv.w();
        LottieAnimationView lottieAnimationView = this.d;
        if (lottieAnimationView != null) {
            lottieAnimationView.w();
        }
        com.byazt.hlq.qg qgVar = this.cp;
        if (qgVar instanceof UpieVideoView) {
            ((UpieVideoView) qgVar).qg();
        }
    }

    @Override // com.byazt.ej.x
    public void n(long j) {
        this.rv.n(j);
        qg(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(long j) {
        LottieAnimationView lottieAnimationView = this.d;
        if (lottieAnimationView != null) {
            long duration = lottieAnimationView.getDuration();
            if (duration <= 0) {
                duration = a();
            }
            if (duration > 0) {
                this.d.setProgress((j % duration) / duration);
            }
        }
    }

    @Override // com.byazt.ej.x
    public boolean fs() {
        return this.rv.fs();
    }

    @Override // com.byazt.ej.x
    public void n(boolean z) {
        this.rv.n(z);
    }

    @Override // com.byazt.ej.x
    public void n(SurfaceHolder surfaceHolder) {
        this.rv.n(surfaceHolder);
    }

    @Override // com.byazt.ej.x
    public SurfaceHolder m() {
        return this.rv.m();
    }

    @Override // com.byazt.ej.x
    public void n(SurfaceTexture surfaceTexture) {
        this.rv.n(surfaceTexture);
    }

    @Override // com.byazt.ej.x
    public SurfaceTexture hu() {
        return this.rv.hu();
    }

    @Override // com.byazt.ej.x
    public boolean k() {
        return !this.q && this.rv.k();
    }

    @Override // com.byazt.ej.x
    public boolean sz() {
        return !this.q && this.rv.sz();
    }

    @Override // com.byazt.ej.x
    public boolean cp() {
        return !this.q && this.rv.cp();
    }

    @Override // com.byazt.ej.x
    public int hd() {
        return this.qg;
    }

    @Override // com.byazt.ej.x
    public int cd() {
        return this.s;
    }

    @Override // com.byazt.ej.x
    public boolean tj() {
        return !this.q && this.rv.tj();
    }

    @Override // com.byazt.ej.x
    public boolean d() {
        return !this.q && this.rv.d();
    }

    @Override // com.byazt.ej.x
    public boolean oa() {
        return !this.q && this.rv.oa();
    }

    @Override // com.byazt.ej.x
    public long cy() {
        return this.rv.cy();
    }

    @Override // com.byazt.ej.x
    public int um() {
        return this.rv.um();
    }

    @Override // com.byazt.ej.x
    public long a() {
        return this.rv.a();
    }

    @Override // com.byazt.ej.x
    public long py() {
        return this.rv.py();
    }

    @Override // com.byazt.ej.x
    public void s(boolean z) {
        this.rv.s(z);
    }

    @Override // com.byazt.ej.x
    public boolean ou() {
        return this.rv.ou();
    }

    @Override // com.byazt.ej.x
    public void n(final x.n nVar) {
        if (nVar == null) {
            return;
        }
        x.n nVar2 = new x.n() { // from class: com.byazt.vzj.s.5
            @Override // com.byazt.ej.x.n
            public void n(x xVar) {
                nVar.n(s.this);
            }

            @Override // com.byazt.ej.x.n
            public void n(x xVar, final long j) {
                com.byazt.oa.qg.n(new Runnable() { // from class: com.byazt.vzj.s.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        nVar.n(s.this, j);
                    }
                });
            }

            @Override // com.byazt.ej.x.n
            public void s(x xVar) {
                com.byazt.oa.qg.n(new Runnable() { // from class: com.byazt.vzj.s.5.2
                    @Override // java.lang.Runnable
                    public void run() {
                        s.this.fs = true;
                        if (!s.this.x) {
                            s.this.rv.q();
                        }
                        nVar.s(s.this);
                        s.this.n();
                    }
                });
            }

            @Override // com.byazt.ej.x.n
            public void n(x xVar, com.byazt.ej.s sVar) {
                s.this.n(sVar);
            }

            @Override // com.byazt.ej.x.n
            public void n(x xVar, boolean z) {
                nVar.n(s.this, z);
            }

            @Override // com.byazt.ej.x.n
            public void q(x xVar) {
                nVar.q(s.this);
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // com.byazt.ej.x.n
            public void n(x xVar, int i, int i2) {
                x.n nVar3 = nVar;
                s sVar = s.this;
                nVar3.n((x) sVar, sVar.qg, s.this.s);
            }

            @Override // com.byazt.ej.x.n
            public void n(x xVar, int i, int i2, int i3) {
                nVar.n(s.this, i, i2, i3);
            }

            @Override // com.byazt.ej.x.n
            public void n(x xVar, int i) {
                nVar.n((x) s.this, i);
            }

            @Override // com.byazt.ej.x.n
            public void qg(x xVar, int i) {
                nVar.qg(s.this, i);
            }

            @Override // com.byazt.ej.x.n
            public void n(x xVar, long j, long j2) {
                nVar.n(s.this, j, j2);
            }

            @Override // com.byazt.ej.x.n
            public void n(x xVar, JSONObject jSONObject, String str) {
                nVar.n(s.this, jSONObject, str);
            }

            @Override // com.byazt.ej.x.n
            public void l(x xVar) {
                nVar.l(s.this);
            }

            @Override // com.byazt.ej.x.n
            public void w(x xVar) {
                nVar.w(s.this);
            }

            @Override // com.byazt.ej.x.n
            public void qg(x xVar) {
                nVar.qg(s.this);
            }
        };
        this.tj.put(nVar, nVar2);
        this.rv.n(nVar2);
    }

    @Override // com.byazt.ej.x
    public void qg(x.n nVar) {
        x.n nVarRemove = this.tj.remove(nVar);
        if (nVarRemove != null) {
            this.rv.qg(nVarRemove);
        }
    }

    @Override // com.byazt.ej.x
    public void n(int i) {
        this.rv.n(i);
    }

    @Override // com.byazt.ej.x
    public int wm() {
        return this.rv.wm();
    }

    @Override // com.byazt.ej.x
    public void n(float f) {
        this.rv.n(f);
        LottieAnimationView lottieAnimationView = this.d;
        if (lottieAnimationView != null) {
            lottieAnimationView.setSpeed(f);
        }
    }
}
