package com.bytedance.sdk.openadsdk.core.component.splash.ah.ah;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ab;
import com.bytedance.sdk.openadsdk.core.nw.e;

/* JADX INFO: loaded from: classes2.dex */
public class ka {
    private ab ab;
    volatile boolean ah;
    private xr<com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c, ab> c;
    volatile boolean d;
    private com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ka ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    volatile boolean f2365ms;
    private com.bytedance.sdk.openadsdk.core.component.splash.ms.ms ny;
    private com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c x;
    volatile boolean xr;

    public ka(com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ka kaVar, xr<com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c, ab> xrVar, com.bytedance.sdk.openadsdk.core.component.splash.ms.ms msVar) {
        if (kaVar == null || xrVar == null) {
            return;
        }
        this.ka = kaVar;
        this.c = xrVar;
        this.ny = msVar;
    }

    public void ms(final int i) {
        if (this.ka == null || this.c == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "loadAd Type ".concat(String.valueOf(i)));
        if (i == 0) {
            new com.bytedance.sdk.openadsdk.core.component.splash.xr.ms.ah().ms(this.ka, this.c);
            return;
        }
        if (i == 1) {
            new com.bytedance.sdk.openadsdk.core.component.splash.xr.ms.ms(this.ny).ms(this.ka, new xr<com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c, ab>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.ka.1
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.xr
                /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
                public void xr(com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c cVar) {
                    ka.this.c.xr(cVar);
                    if (!com.bytedance.sdk.openadsdk.core.component.splash.ms.ms.ms(i) || ka.this.ny == null || ka.this.ka == null) {
                        return;
                    }
                    ka.this.ny.xr(ka.this.ka.d(), ka.this.ka.ka());
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.xr
                public void ms(ab abVar) {
                    if (abVar != null && ka.this.ka != null) {
                        ka.this.ka.ms(abVar.d());
                        ka.this.ka.ms(abVar.ah());
                    }
                    new com.bytedance.sdk.openadsdk.core.component.splash.xr.ms.ah().ms(ka.this.ka, new xr<com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c, ab>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.ka.1.1
                        @Override // com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.xr
                        /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
                        public void xr(com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c cVar) {
                            if (ka.this.d) {
                                if (ka.this.ny == null || ka.this.ka == null) {
                                    return;
                                }
                                ka.this.ny.ms(cVar, ka.this.ka.d(), true, 1);
                                return;
                            }
                            ka.this.c.xr(cVar);
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.xr
                        public void ms(ab abVar2) {
                            ka.this.c.ms(abVar2);
                            if (!com.bytedance.sdk.openadsdk.core.component.splash.ms.ms.ms(i) || ka.this.ny == null || ka.this.ka == null) {
                                return;
                            }
                            ka.this.ny.xr(ka.this.ka.d(), ka.this.ka.ka());
                        }
                    });
                }
            });
            return;
        }
        if (i == 2) {
            new com.bytedance.sdk.openadsdk.core.component.splash.xr.ms.ah().ms(this.ka, new xr<com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c, ab>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.ka.2
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.xr
                /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
                public void xr(com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c cVar) {
                    ka.this.x = cVar;
                    if (ka.this.ab != null && cVar != null) {
                        cVar.ms(ka.this.ab.d());
                        cVar.ms(ka.this.ab.ah());
                    }
                    com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "实时物料加载成功 isCache " + cVar.ka());
                    ka.this.c.xr(cVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.xr
                public void ms(ab abVar) {
                    com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "实时物料加载失败 ");
                    ka.this.c.ms(abVar);
                }
            });
            new com.bytedance.sdk.openadsdk.core.component.splash.xr.ms.ms(this.ny).ms(this.ka, new xr<com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c, ab>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.ka.3
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.xr
                /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
                public void xr(com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c cVar) {
                    com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "缓存物料加载成功 isCache " + cVar.ka());
                    ka.this.c.xr(cVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.xr
                public void ms(ab abVar) {
                    ka.this.ab = abVar;
                    com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "缓存物料加载失败  ");
                    if (ka.this.x != null && abVar != null) {
                        ka.this.x.ms(abVar.d());
                        ka.this.x.ms(abVar.ah());
                    }
                    ka.this.c.ms(abVar);
                }
            });
        } else if (i == 3) {
            new com.bytedance.sdk.openadsdk.core.component.splash.xr.ms.ah().ms(this.ka, new xr<com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c, ab>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.ka.4
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.xr
                /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
                public void xr(com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c cVar) {
                    ka.this.x = cVar;
                    if (ka.this.ah || ka.this.d) {
                        if (ka.this.ny == null || ka.this.ka == null) {
                            return;
                        }
                        ka.this.ny.ms(cVar, ka.this.ka.d(), true, 3);
                        return;
                    }
                    if (ka.this.ab != null && cVar != null) {
                        cVar.ms(ka.this.ab.d());
                        cVar.ms(ka.this.ab.ah());
                    }
                    ka.this.ah = true;
                    ka.this.c.xr(cVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.xr
                public void ms(ab abVar) {
                    ka.this.f2365ms = true;
                    if (ka.this.xr) {
                        ka.this.c.ms(abVar);
                    }
                    if (!com.bytedance.sdk.openadsdk.core.component.splash.ms.ms.ms(i) || ka.this.ny == null || ka.this.ka == null) {
                        return;
                    }
                    ka.this.ny.xr(ka.this.ka.d(), ka.this.ka.ka());
                }
            });
            new com.bytedance.sdk.openadsdk.core.component.splash.xr.ms.ms(this.ny).ms(this.ka, new xr<com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c, ab>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.ka.5
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.xr
                /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
                public void xr(com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c cVar) {
                    if (ka.this.ah) {
                        return;
                    }
                    ka.this.ah = true;
                    ka.this.c.xr(cVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.xr
                public void ms(ab abVar) {
                    ka.this.ab = abVar;
                    if (ka.this.x != null && abVar != null) {
                        ka.this.x.ms(abVar.d());
                        ka.this.x.ms(abVar.ah());
                    }
                    ka.this.xr = true;
                    if (ka.this.f2365ms) {
                        ka.this.c.ms(abVar);
                    }
                }
            });
        } else {
            if (i != 4) {
                return;
            }
            new com.bytedance.sdk.openadsdk.core.component.splash.xr.ms.ms(this.ny).ms(this.ka, new xr<com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c, ab>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.ka.6
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.xr
                /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
                public void xr(com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c cVar) {
                    ka.this.c.xr(cVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.xr
                public void ms(ab abVar) {
                    ka.this.c.ms(abVar);
                }
            });
        }
    }

    public void ms() {
        this.d = true;
    }

    public static boolean ms(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, e eVar) {
        return (xrVar == null || eVar == null || TextUtils.isEmpty(xrVar.nw()) || eVar.d > 0) ? false : true;
    }
}
