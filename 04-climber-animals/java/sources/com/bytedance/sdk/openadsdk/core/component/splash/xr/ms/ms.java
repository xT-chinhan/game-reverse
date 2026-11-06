package com.bytedance.sdk.openadsdk.core.component.splash.xr.ms;

import com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ab;
import com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c;
import com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ka;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.t.u;
import com.bytedance.sdk.openadsdk.core.yu;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    private com.bytedance.sdk.openadsdk.ao.xr.ah.xr ah;
    private boolean ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.splash.ms.ms f2443ms;
    private String xr;
    private ab d = new ab();
    private com.bytedance.sdk.openadsdk.core.ka.xr.ms c = new com.bytedance.sdk.openadsdk.core.ka.xr.ms(4);

    public ms(com.bytedance.sdk.openadsdk.core.component.splash.ms.ms msVar) {
        this.f2443ms = msVar;
        msVar.xr();
        this.ka = re.xr().qk();
    }

    public void ms(ka kaVar, com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.xr<c, ab> xrVar) {
        if (kaVar == null || xrVar == null) {
            return;
        }
        this.d.xr(true);
        this.ah = kaVar.d();
        this.xr = kaVar.c();
        if (com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.ka.ms(this.ah, kaVar.ka())) {
            this.d.xr(1);
            this.d.ms("no cache");
            xrVar.ms(this.d);
            return;
        }
        ms(this.xr, xrVar);
    }

    private void ms(String str, final com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.xr<c, ab> xrVar) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        this.f2443ms.ms(this.d, str, new com.bytedance.sdk.openadsdk.core.component.splash.ms.ms.InterfaceC0286ms() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.xr.ms.ms.1
            @Override // com.bytedance.sdk.openadsdk.core.component.splash.ms.ms.InterfaceC0286ms
            public void ms(final c cVar) {
                com.bytedance.sdk.openadsdk.core.ab.ms.ms("lqmt", "缓存读取总耗时： " + (System.currentTimeMillis() - jCurrentTimeMillis));
                if (xrVar == null) {
                    return;
                }
                if (cVar == null || cVar.xr() == null) {
                    if (cVar == null) {
                        ms.this.d.xr(1);
                        ms.this.d.ms("no ad model cache");
                        xrVar.ms(ms.this.d);
                        return;
                    } else if (cVar.xr() == null) {
                        ms.this.d.xr(1);
                        ms.this.d.ms("no splash material");
                        xrVar.ms(ms.this.d);
                        return;
                    }
                }
                lm lmVarXr = cVar.xr();
                ms.this.c.ms(jCurrentTimeMillis);
                ms.this.c.xr(System.currentTimeMillis());
                ms.this.c.ms(lmVarXr, new com.bytedance.sdk.openadsdk.core.ka.xr.c() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.xr.ms.ms.1.1
                    @Override // com.bytedance.sdk.openadsdk.core.ka.xr.c
                    public void ms(boolean z, long j) {
                        if (!z) {
                            ms.this.d.xr(22);
                            ms.this.d.ms("check server cache unavailable");
                            xrVar.ms(ms.this.d);
                            return;
                        }
                        xrVar.xr(cVar);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.ka.xr.c
                    public void ms() {
                        if (ms.this.ka) {
                            ms.this.ms(cVar, (com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.xr<c, ab>) xrVar);
                        } else {
                            xrVar.xr(cVar);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.ka.xr.c
                    public void xr() {
                        xrVar.xr(cVar);
                    }
                });
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.ms.ms.InterfaceC0286ms
            public void ms() {
                com.bytedance.sdk.openadsdk.core.ab.ms.ms("lqmt", "缓存读取失败");
                com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.xr xrVar2 = xrVar;
                if (xrVar2 == null) {
                    return;
                }
                xrVar2.ms(ms.this.d);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(final c cVar, final com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.xr<c, ab> xrVar) {
        if (xrVar == null) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        lm lmVarXr = cVar.xr();
        re.ms().ms(lmVarXr.df(), lmVarXr.lx(), new yu.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.xr.ms.ms.2
            @Override // com.bytedance.sdk.openadsdk.core.yu.ms
            public void ms(boolean z, long j, long j2) {
                u.ms(ms.this.ah, z, j, j2, System.currentTimeMillis() - jCurrentTimeMillis, 4);
                if (!z) {
                    ms.this.d.xr(22);
                    ms.this.d.ms("check server cache unavailable");
                    ms.this.d.ms(j);
                    xrVar.ms(ms.this.d);
                    return;
                }
                xrVar.xr(cVar);
            }
        });
    }
}
