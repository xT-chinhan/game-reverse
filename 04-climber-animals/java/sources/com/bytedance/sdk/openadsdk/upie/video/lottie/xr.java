package com.bytedance.sdk.openadsdk.upie.video.lottie;

import android.graphics.SurfaceTexture;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import com.bykv.vk.openvk.component.video.api.ah.d;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.sdk.component.utils.sl;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements com.bykv.vk.openvk.component.video.api.ms {
    private final int ah;
    private long c;
    private boolean d;
    private final com.bykv.vk.openvk.component.video.api.renderview.xr hi;
    private final com.bykv.vk.openvk.component.video.api.ms ny;
    private LottieAnimationView sl;
    private final int xr;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final String f4270ms = "UpieVideoPlayer";
    private int ka = 0;
    private volatile boolean ab = false;
    private volatile boolean x = false;
    private final Map<com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms, com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms> ch = new ConcurrentHashMap();

    static /* synthetic */ int ms(xr xrVar) {
        int i = xrVar.ka;
        xrVar.ka = i + 1;
        return i;
    }

    public xr(com.bykv.vk.openvk.component.video.api.ms msVar, com.bytedance.sdk.openadsdk.upie.ms msVar2, com.bykv.vk.openvk.component.video.api.renderview.xr xrVar) {
        this.ny = msVar;
        this.xr = msVar2.d();
        this.ah = msVar2.ka();
        this.hi = xrVar;
        if (xrVar instanceof UpieVideoView) {
            this.sl = ((UpieVideoView) xrVar).getLottieAnimationView();
        }
        ms(msVar2.ms());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(final String str) {
        if (TextUtils.isEmpty(str)) {
            ms(new com.bykv.vk.openvk.component.video.api.ah.xr(60008, 10000, "lottieJsonUrl为空"));
        } else {
            com.bytedance.sdk.openadsdk.upie.ms.xr.ah(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.xr.1
                @Override // java.lang.Runnable
                public void run() {
                    String strMs = com.bytedance.sdk.openadsdk.upie.xr.ms().ms(str);
                    if (!TextUtils.isEmpty(strMs)) {
                        sl.ms("UpieVideoPlayer", "--==-- lottie use cache ok");
                        xr.this.ms(strMs, str);
                    } else {
                        com.bytedance.sdk.openadsdk.upie.xr.ms().ms(str, new com.bytedance.sdk.openadsdk.upie.xr.ms<String>() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.xr.1.1
                            @Override // com.bytedance.sdk.openadsdk.upie.xr.ms
                            public void ms(String str2) {
                                sl.ms("UpieVideoPlayer", "--==-- lottie load jsonStr ok");
                                xr.this.ms(str2, str);
                            }

                            @Override // com.bytedance.sdk.openadsdk.upie.xr.ms
                            public void ms(int i, String str2) {
                                sl.ms("UpieVideoPlayer", "--==-- lottie jsonStr load fail: " + i + ", " + str2);
                                if (i == 10006) {
                                    xr.this.ms(new com.bykv.vk.openvk.component.video.api.ah.xr(60008, i, str2));
                                    return;
                                }
                                xr.ms(xr.this);
                                if (xr.this.ka <= 3) {
                                    xr.this.ms(str);
                                } else {
                                    xr.this.ms(new com.bykv.vk.openvk.component.video.api.ah.xr(60008, i, str2));
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(final com.bykv.vk.openvk.component.video.api.ah.xr xrVar) {
        com.bytedance.sdk.openadsdk.upie.ms.xr.xr(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.xr.2
            @Override // java.lang.Runnable
            public void run() {
                if (xr.this.d) {
                    return;
                }
                xr.this.d = true;
                sl.ms("UpieVideoPlayer", "--==--play err, code: " + xrVar.ms() + ", extra: " + xrVar.xr() + ", msg: " + xrVar.ah());
                Iterator it = xr.this.ch.entrySet().iterator();
                while (it.hasNext()) {
                    ((com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms) ((Map.Entry) it.next()).getKey()).ms(xr.this, xrVar);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(final String str, final String str2) {
        com.bytedance.sdk.openadsdk.upie.ms.xr.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.xr.3
            @Override // java.lang.Runnable
            public void run() {
                xr.this.ab = true;
                if (xr.this.sl != null) {
                    xr.this.sl.ms(str, str2);
                }
                xr.this.t();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        com.bytedance.sdk.openadsdk.upie.ms.xr.xr(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.xr.4
            @Override // java.lang.Runnable
            public void run() {
                if (xr.this.x && xr.this.ab) {
                    xr.this.ny.xr();
                    if (xr.this.sl != null) {
                        xr.this.sl.ms();
                        if (xr.this.c > 0) {
                            xr xrVar = xr.this;
                            xrVar.xr(xrVar.c);
                        }
                    }
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms(d dVar) {
        sl.ms("UpieVideoPlayer", "--==--setDataSource: ".concat(String.valueOf(dVar)));
        this.ny.ms(dVar);
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms(boolean z) {
        sl.ms("UpieVideoPlayer", "--==--isMute: ".concat(String.valueOf(z)));
        this.ny.ms(z);
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms(int i) {
        sl.ms("UpieVideoPlayer", "--==--setSeekMode: ".concat(String.valueOf(i)));
        this.ny.ms(i);
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms(boolean z, long j, boolean z2) {
        sl.ms("UpieVideoPlayer", "--==--start: " + z + ", " + j + ", " + z2);
        this.ny.ms(z, j, z2);
        this.c = j;
        com.bykv.vk.openvk.component.video.api.renderview.xr xrVar = this.hi;
        if (xrVar instanceof UpieVideoView) {
            ((UpieVideoView) xrVar).ms();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms() {
        sl.ms("UpieVideoPlayer", "--==--restart");
        this.ny.ms();
        LottieAnimationView lottieAnimationView = this.sl;
        if (lottieAnimationView != null) {
            lottieAnimationView.c();
            this.sl.setProgress(0.0f);
            this.sl.ms();
        }
        com.bykv.vk.openvk.component.video.api.renderview.xr xrVar = this.hi;
        if (xrVar instanceof UpieVideoView) {
            ((UpieVideoView) xrVar).ms();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void xr() {
        sl.ms("UpieVideoPlayer", "--==--play");
        this.ny.xr();
        LottieAnimationView lottieAnimationView = this.sl;
        if (lottieAnimationView != null) {
            lottieAnimationView.xr();
        }
        com.bykv.vk.openvk.component.video.api.renderview.xr xrVar = this.hi;
        if (xrVar instanceof UpieVideoView) {
            ((UpieVideoView) xrVar).ms();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ah() {
        sl.ms("UpieVideoPlayer", "--==--pause");
        this.ny.ah();
        LottieAnimationView lottieAnimationView = this.sl;
        if (lottieAnimationView != null) {
            lottieAnimationView.ab();
        }
        com.bykv.vk.openvk.component.video.api.renderview.xr xrVar = this.hi;
        if (xrVar instanceof UpieVideoView) {
            ((UpieVideoView) xrVar).xr();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void d() {
        sl.ms("UpieVideoPlayer", "--==--stop");
        this.ny.d();
        LottieAnimationView lottieAnimationView = this.sl;
        if (lottieAnimationView != null) {
            lottieAnimationView.ab();
        }
        com.bykv.vk.openvk.component.video.api.renderview.xr xrVar = this.hi;
        if (xrVar instanceof UpieVideoView) {
            ((UpieVideoView) xrVar).xr();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ka() {
        sl.ms("UpieVideoPlayer", "--==--release");
        this.ny.ka();
        LottieAnimationView lottieAnimationView = this.sl;
        if (lottieAnimationView != null) {
            lottieAnimationView.c();
        }
        com.bykv.vk.openvk.component.video.api.renderview.xr xrVar = this.hi;
        if (xrVar instanceof UpieVideoView) {
            ((UpieVideoView) xrVar).xr();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms(long j) {
        sl.ms("UpieVideoPlayer", "--==--seekTo: ".concat(String.valueOf(j)));
        this.ny.ms(j);
        xr(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(long j) {
        LottieAnimationView lottieAnimationView = this.sl;
        if (lottieAnimationView != null) {
            long duration = lottieAnimationView.getDuration();
            if (duration <= 0) {
                duration = qv();
            }
            if (duration > 0) {
                this.sl.setProgress((j % duration) / duration);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public boolean c() {
        return this.ny.c();
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void xr(boolean z) {
        this.ny.xr(z);
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms(SurfaceHolder surfaceHolder) {
        this.ny.ms(surfaceHolder);
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public SurfaceHolder ab() {
        return this.ny.ab();
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms(SurfaceTexture surfaceTexture) {
        this.ny.ms(surfaceTexture);
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public SurfaceTexture x() {
        return this.ny.x();
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public boolean ny() {
        boolean z = !this.d && this.ny.ny();
        sl.ms("UpieVideoPlayer", "--==--isCompleted: " + z + ",      errorInvoked: " + this.d);
        return z;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public boolean ch() {
        boolean z = !this.d && this.ny.ch();
        sl.ms("UpieVideoPlayer", "--==--isStarted: " + z + ",      errorInvoked: " + this.d);
        return z;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public int hi() {
        return this.xr;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public int sl() {
        return this.ah;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public boolean zb() {
        boolean z = !this.d && this.ny.zb();
        sl.ms("UpieVideoPlayer", "--==--isPlaying: " + z + ",      errorInvoked: " + this.d);
        return z;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public boolean u() {
        boolean z = !this.d && this.ny.u();
        sl.ms("UpieVideoPlayer", "--==--isPaused: " + z + ",      errorInvoked: " + this.d);
        return z;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public boolean ub() {
        boolean z = !this.d && this.ny.ub();
        sl.ms("UpieVideoPlayer", "--==--isReleased: " + z + ",      errorInvoked: " + this.d);
        return z;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public long ao() {
        return this.ny.ao();
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public int h() {
        return this.ny.h();
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public long qv() {
        return this.ny.qv();
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public long y() {
        return this.ny.y();
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ah(boolean z) {
        this.ny.ah(z);
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms(final com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms interfaceC0179ms) {
        if (interfaceC0179ms == null) {
            return;
        }
        com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms interfaceC0179ms2 = new com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.xr.5
            @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
            public void ms(com.bykv.vk.openvk.component.video.api.ms msVar) {
                interfaceC0179ms.ms(xr.this);
            }

            @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
            public void ms(com.bykv.vk.openvk.component.video.api.ms msVar, final long j) {
                com.bytedance.sdk.openadsdk.upie.ms.xr.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.xr.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        interfaceC0179ms.ms(xr.this, j);
                    }
                });
            }

            @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
            public void xr(com.bykv.vk.openvk.component.video.api.ms msVar) {
                com.bytedance.sdk.openadsdk.upie.ms.xr.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.xr.5.2
                    @Override // java.lang.Runnable
                    public void run() {
                        xr.this.x = true;
                        if (!xr.this.ab) {
                            xr.this.ny.ah();
                        }
                        interfaceC0179ms.xr(xr.this);
                        xr.this.t();
                    }
                });
            }

            @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
            public void ms(com.bykv.vk.openvk.component.video.api.ms msVar, com.bykv.vk.openvk.component.video.api.ah.xr xrVar) {
                xr.this.ms(xrVar);
            }

            @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
            public void ms(com.bykv.vk.openvk.component.video.api.ms msVar, boolean z) {
                interfaceC0179ms.ms(xr.this, z);
            }

            @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
            public void ah(com.bykv.vk.openvk.component.video.api.ms msVar) {
                interfaceC0179ms.ah(xr.this);
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
            @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
            public void ms(com.bykv.vk.openvk.component.video.api.ms msVar, int i, int i2) {
                com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms interfaceC0179ms3 = interfaceC0179ms;
                xr xrVar = xr.this;
                interfaceC0179ms3.ms((com.bykv.vk.openvk.component.video.api.ms) xrVar, xrVar.xr, xr.this.ah);
            }

            @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
            public void ms(com.bykv.vk.openvk.component.video.api.ms msVar, int i, int i2, int i3) {
                interfaceC0179ms.ms(xr.this, i, i2, i3);
            }

            @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
            public void ms(com.bykv.vk.openvk.component.video.api.ms msVar, int i) {
                interfaceC0179ms.ms((com.bykv.vk.openvk.component.video.api.ms) xr.this, i);
            }

            @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
            public void xr(com.bykv.vk.openvk.component.video.api.ms msVar, int i) {
                interfaceC0179ms.xr(xr.this, i);
            }

            @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
            public void ms(com.bykv.vk.openvk.component.video.api.ms msVar, long j, long j2) {
                interfaceC0179ms.ms(xr.this, j, j2);
            }

            @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
            public void ms(com.bykv.vk.openvk.component.video.api.ms msVar, JSONObject jSONObject, String str) {
                interfaceC0179ms.ms(xr.this, jSONObject, str);
            }
        };
        this.ch.put(interfaceC0179ms, interfaceC0179ms2);
        this.ny.ms(interfaceC0179ms2);
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void xr(int i) {
        this.ny.xr(i);
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms(float f) {
        this.ny.ms(f);
        LottieAnimationView lottieAnimationView = this.sl;
        if (lottieAnimationView != null) {
            lottieAnimationView.setSpeed(f);
        }
    }
}
