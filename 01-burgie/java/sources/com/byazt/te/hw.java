package com.byazt.te;

import android.graphics.SurfaceTexture;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import com.byazt.dx.LottieAnimationView;
import com.byazt.ihe.fw;
import com.byazt.ihe.m;
import com.byazt.n.hn;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_ADAPTIVE_WORK_AROUND_MODE, 13})
public class hw implements fw {
    public final fw aj;
    public final int hn;
    public final int hw;
    public LottieAnimationView k;
    public long uc;
    public final com.byazt.c.hw w;
    public boolean x;
    public final String pr = "UpieVideoPlayer";
    public int c = 0;
    public volatile boolean fw = false;
    public volatile boolean zo = false;
    public final Map<fw.pr, fw.pr> vk = new ConcurrentHashMap();

    public static /* synthetic */ int pr(hw hwVar) {
        int i = hwVar.c;
        hwVar.c = i + 1;
        return i;
    }

    public hw(fw fwVar, com.byazt.ic.pr prVar, com.byazt.n.hw hwVar, com.byazt.c.hw hwVar2) {
        this.aj = fwVar;
        this.hw = prVar.x();
        this.hn = prVar.c();
        this.w = hwVar2;
        if (hwVar2 instanceof UpieVideoView) {
            LottieAnimationView lottieAnimationView = ((UpieVideoView) hwVar2).getLottieAnimationView();
            this.k = lottieAnimationView;
            if (lottieAnimationView != null) {
                lottieAnimationView.setVideoStats(hwVar);
            }
        }
        pr(prVar.pr());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(final String str) {
        if (TextUtils.isEmpty(str)) {
            pr(new hn(60008, 10000, "lottieJsonUrl为空"));
        } else {
            com.byazt.rhv.hw.hn(new Runnable() { // from class: com.byazt.te.hw.1
                @Override // java.lang.Runnable
                public void run() {
                    String strPr = com.byazt.ic.hw.pr().pr(str);
                    if (!TextUtils.isEmpty(strPr)) {
                        hw.this.pr(strPr, str);
                    } else {
                        com.byazt.ic.hw.pr().pr(str, new com.byazt.ic.hw.pr<String>() { // from class: com.byazt.te.hw.1.1
                            @Override // com.byazt.ic.hw.pr
                            public void pr(String str2) {
                                hw.this.pr(str2, str);
                            }

                            @Override // com.byazt.ic.hw.pr
                            public void pr(int i, String str2) {
                                if (i == 10006) {
                                    hw.this.pr(new hn(60008, i, str2));
                                    return;
                                }
                                hw.pr(hw.this);
                                if (hw.this.c <= 3) {
                                    hw.this.pr(str);
                                } else {
                                    hw.this.pr(new hn(60008, i, str2));
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(final com.byazt.ihe.hn hnVar) {
        com.byazt.rhv.hw.hw(new Runnable() { // from class: com.byazt.te.hw.2
            @Override // java.lang.Runnable
            public void run() {
                if (!hw.this.x) {
                    hw.this.x = true;
                    hnVar.pr();
                    hnVar.hw();
                    hnVar.hn();
                    Iterator it = hw.this.vk.entrySet().iterator();
                    while (it.hasNext()) {
                        ((fw.pr) ((Map.Entry) it.next()).getKey()).pr(hw.this, hnVar);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(final String str, final String str2) {
        com.byazt.rhv.hw.pr(new Runnable() { // from class: com.byazt.te.hw.3
            @Override // java.lang.Runnable
            public void run() {
                hw.this.fw = true;
                if (hw.this.k != null) {
                    hw.this.k.pr(str, str2);
                }
                hw.this.pr();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr() {
        com.byazt.rhv.hw.hw(new Runnable() { // from class: com.byazt.te.hw.4
            @Override // java.lang.Runnable
            public void run() {
                if (hw.this.zo && hw.this.fw) {
                    hw.this.aj.hn();
                    if (hw.this.k != null) {
                        hw.this.k.pr();
                        if (hw.this.uc > 0) {
                            hw hwVar = hw.this;
                            hwVar.hw(hwVar.uc);
                        }
                    }
                }
            }
        });
    }

    @Override // com.byazt.ihe.fw
    public void pr(m mVar) {
        this.aj.pr(mVar);
    }

    @Override // com.byazt.ihe.fw
    public void hw(boolean z) {
        this.aj.hw(z);
    }

    @Override // com.byazt.ihe.fw
    public void hw(int i) {
        this.aj.hw(i);
    }

    @Override // com.byazt.ihe.fw
    public void pr(boolean z, long j, boolean z2) {
        this.aj.pr(z, j, z2);
        this.uc = j;
        com.byazt.c.hw hwVar = this.w;
        if (hwVar instanceof UpieVideoView) {
            ((UpieVideoView) hwVar).pr();
        }
    }

    @Override // com.byazt.ihe.fw
    public void hw() {
        this.aj.hw();
        LottieAnimationView lottieAnimationView = this.k;
        if (lottieAnimationView != null) {
            lottieAnimationView.uc();
            this.k.setProgress(0.0f);
            this.k.pr();
        }
        com.byazt.c.hw hwVar = this.w;
        if (hwVar instanceof UpieVideoView) {
            ((UpieVideoView) hwVar).pr();
        }
    }

    @Override // com.byazt.ihe.fw
    public void hn() {
        this.aj.hn();
        LottieAnimationView lottieAnimationView = this.k;
        if (lottieAnimationView != null) {
            lottieAnimationView.hw();
        }
        com.byazt.c.hw hwVar = this.w;
        if (hwVar instanceof UpieVideoView) {
            ((UpieVideoView) hwVar).pr();
        }
    }

    @Override // com.byazt.ihe.fw
    public void x() {
        this.aj.x();
        LottieAnimationView lottieAnimationView = this.k;
        if (lottieAnimationView != null) {
            lottieAnimationView.fw();
        }
        com.byazt.c.hw hwVar = this.w;
        if (hwVar instanceof UpieVideoView) {
            ((UpieVideoView) hwVar).hw();
        }
    }

    @Override // com.byazt.ihe.fw
    public void fw() {
        this.aj.fw();
        LottieAnimationView lottieAnimationView = this.k;
        if (lottieAnimationView != null) {
            lottieAnimationView.fw();
        }
        com.byazt.c.hw hwVar = this.w;
        if (hwVar instanceof UpieVideoView) {
            ((UpieVideoView) hwVar).hw();
        }
    }

    @Override // com.byazt.ihe.fw
    public void c() {
        this.aj.c();
        LottieAnimationView lottieAnimationView = this.k;
        if (lottieAnimationView != null) {
            lottieAnimationView.fw();
            this.k.setProgress(0.0f);
        }
        com.byazt.c.hw hwVar = this.w;
        if (hwVar instanceof UpieVideoView) {
            ((UpieVideoView) hwVar).hw();
        }
    }

    @Override // com.byazt.ihe.fw
    public void uc() {
        this.aj.uc();
        LottieAnimationView lottieAnimationView = this.k;
        if (lottieAnimationView != null) {
            lottieAnimationView.uc();
        }
        com.byazt.c.hw hwVar = this.w;
        if (hwVar instanceof UpieVideoView) {
            ((UpieVideoView) hwVar).hw();
        }
    }

    @Override // com.byazt.ihe.fw
    public void pr(long j) {
        this.aj.pr(j);
        hw(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(long j) {
        LottieAnimationView lottieAnimationView = this.k;
        if (lottieAnimationView != null) {
            long duration = lottieAnimationView.getDuration();
            if (duration <= 0) {
                duration = a();
            }
            if (duration > 0) {
                this.k.setProgress((j % duration) / duration);
            }
        }
    }

    @Override // com.byazt.ihe.fw
    public boolean zo() {
        return this.aj.zo();
    }

    @Override // com.byazt.ihe.fw
    public void pr(boolean z) {
        this.aj.pr(z);
    }

    @Override // com.byazt.ihe.fw
    public void pr(SurfaceHolder surfaceHolder) {
        this.aj.pr(surfaceHolder);
    }

    @Override // com.byazt.ihe.fw
    public SurfaceHolder rc() {
        return this.aj.rc();
    }

    @Override // com.byazt.ihe.fw
    public void pr(SurfaceTexture surfaceTexture) {
        this.aj.pr(surfaceTexture);
    }

    @Override // com.byazt.ihe.fw
    public SurfaceTexture z() {
        return this.aj.z();
    }

    @Override // com.byazt.ihe.fw
    public boolean ho() {
        return !this.x && this.aj.ho();
    }

    @Override // com.byazt.ihe.fw
    public boolean g() {
        return !this.x && this.aj.g();
    }

    @Override // com.byazt.ihe.fw
    public boolean w() {
        return !this.x && this.aj.w();
    }

    @Override // com.byazt.ihe.fw
    public int yb() {
        return this.hw;
    }

    @Override // com.byazt.ihe.fw
    public int lb() {
        return this.hn;
    }

    @Override // com.byazt.ihe.fw
    public boolean vk() {
        return !this.x && this.aj.vk();
    }

    @Override // com.byazt.ihe.fw
    public boolean k() {
        return !this.x && this.aj.k();
    }

    @Override // com.byazt.ihe.fw
    public boolean m() {
        return !this.x && this.aj.m();
    }

    @Override // com.byazt.ihe.fw
    public long nt() {
        return this.aj.nt();
    }

    @Override // com.byazt.ihe.fw
    public int qa() {
        return this.aj.qa();
    }

    @Override // com.byazt.ihe.fw
    public long a() {
        return this.aj.a();
    }

    @Override // com.byazt.ihe.fw
    public long cz() {
        return this.aj.cz();
    }

    @Override // com.byazt.ihe.fw
    public void hn(boolean z) {
        this.aj.hn(z);
    }

    @Override // com.byazt.ihe.fw
    public boolean ny() {
        return this.aj.ny();
    }

    @Override // com.byazt.ihe.fw
    public void pr(final fw.pr prVar) {
        if (prVar == null) {
            return;
        }
        fw.pr prVar2 = new fw.pr() { // from class: com.byazt.te.hw.5
            @Override // com.byazt.ihe.fw.pr
            public void pr(fw fwVar) {
                prVar.pr(hw.this);
            }

            @Override // com.byazt.ihe.fw.pr
            public void pr(fw fwVar, final long j) {
                com.byazt.rhv.hw.pr(new Runnable() { // from class: com.byazt.te.hw.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        prVar.pr(hw.this, j);
                    }
                });
            }

            @Override // com.byazt.ihe.fw.pr
            public void hn(fw fwVar) {
                com.byazt.rhv.hw.pr(new Runnable() { // from class: com.byazt.te.hw.5.2
                    @Override // java.lang.Runnable
                    public void run() {
                        hw.this.zo = true;
                        if (!hw.this.fw) {
                            hw.this.aj.x();
                        }
                        prVar.hn(hw.this);
                        hw.this.pr();
                    }
                });
            }

            @Override // com.byazt.ihe.fw.pr
            public void pr(fw fwVar, com.byazt.ihe.hn hnVar) {
                hw.this.pr(hnVar);
            }

            @Override // com.byazt.ihe.fw.pr
            public void pr(fw fwVar, boolean z) {
                prVar.pr(hw.this, z);
            }

            @Override // com.byazt.ihe.fw.pr
            public void x(fw fwVar) {
                prVar.x(hw.this);
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
            @Override // com.byazt.ihe.fw.pr
            public void pr(fw fwVar, int i, int i2) {
                fw.pr prVar3 = prVar;
                hw hwVar = hw.this;
                prVar3.pr((fw) hwVar, hwVar.hw, hw.this.hn);
            }

            @Override // com.byazt.ihe.fw.pr
            public void pr(fw fwVar, int i, int i2, int i3) {
                prVar.pr(hw.this, i, i2, i3);
            }

            @Override // com.byazt.ihe.fw.pr
            public void pr(fw fwVar, int i) {
                prVar.pr((fw) hw.this, i);
            }

            @Override // com.byazt.ihe.fw.pr
            public void hw(fw fwVar, int i) {
                prVar.hw(hw.this, i);
            }

            @Override // com.byazt.ihe.fw.pr
            public void pr(fw fwVar, long j, long j2) {
                prVar.pr(hw.this, j, j2);
            }

            @Override // com.byazt.ihe.fw.pr
            public void pr(fw fwVar, JSONObject jSONObject, String str) {
                prVar.pr(hw.this, jSONObject, str);
            }

            @Override // com.byazt.ihe.fw.pr
            public void c(fw fwVar) {
                prVar.c(hw.this);
            }

            @Override // com.byazt.ihe.fw.pr
            public void uc(fw fwVar) {
                prVar.uc(hw.this);
            }

            @Override // com.byazt.ihe.fw.pr
            public void hw(fw fwVar) {
                prVar.hw(hw.this);
            }
        };
        this.vk.put(prVar, prVar2);
        this.aj.pr(prVar2);
    }

    @Override // com.byazt.ihe.fw
    public void hw(fw.pr prVar) {
        fw.pr prVarRemove = this.vk.remove(prVar);
        if (prVarRemove != null) {
            this.aj.hw(prVarRemove);
        }
    }

    @Override // com.byazt.ihe.fw
    public void pr(int i) {
        this.aj.pr(i);
    }

    @Override // com.byazt.ihe.fw
    public int fo() {
        return this.aj.fo();
    }

    @Override // com.byazt.ihe.fw
    public void pr(float f) {
        this.aj.pr(f);
        LottieAnimationView lottieAnimationView = this.k;
        if (lottieAnimationView != null) {
            lottieAnimationView.setSpeed(f);
        }
    }

    @Override // com.byazt.ihe.fw
    public String b() {
        return "";
    }
}
