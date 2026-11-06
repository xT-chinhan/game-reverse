package com.bytedance.sdk.openadsdk.core.ka.ka;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.u;
import com.bytedance.sdk.openadsdk.core.nw.e;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.x;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.yu;
import com.bytedance.sdk.openadsdk.op.ab;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class d extends xr {
    private final long ka;

    private interface ms {
        void ms(boolean z);
    }

    public d(int i) {
        super(i);
        this.ka = System.currentTimeMillis();
    }

    public void ms(final com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, final e eVar, final int i, final ka kaVar) {
        ab.d(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ka.ka.d.1
            @Override // java.lang.Runnable
            public void run() {
                d.this.xr(xrVar, eVar, i, new c(kaVar));
            }
        });
    }

    public void xr(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, e eVar, int i, ka kaVar) {
        if (i == -1) {
            i = xr();
        }
        if (this.f2806ms != null) {
            this.f2806ms.ms();
        }
        if (i == 1) {
            ms(xrVar, kaVar, eVar, 0L);
            return;
        }
        if (i == 2) {
            ms(xrVar, kaVar, eVar);
            return;
        }
        if (i == 3) {
            xr(xrVar, kaVar, eVar);
            return;
        }
        if (i == 4) {
            d(xrVar, kaVar, eVar);
        } else if (i == 5) {
            c(xrVar, kaVar, eVar);
        } else {
            ah(xrVar, kaVar, eVar);
        }
    }

    private void ms(final com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, final ka kaVar, final e eVar, long j) {
        final com.bytedance.sdk.openadsdk.core.ka.ka.ms.ms msVar = new com.bytedance.sdk.openadsdk.core.ka.ka.ms.ms(this.f2806ms) { // from class: com.bytedance.sdk.openadsdk.core.ka.ka.d.6
            @Override // com.bytedance.sdk.openadsdk.core.ka.ka.ms.ms
            public void ms() {
                d.this.ms(xrVar, kaVar, eVar, this);
            }
        };
        ms(xrVar, kaVar, msVar, j, new ms() { // from class: com.bytedance.sdk.openadsdk.core.ka.ka.d.7
            @Override // com.bytedance.sdk.openadsdk.core.ka.ka.d.ms
            public void ms(boolean z) {
                if (z) {
                    return;
                }
                msVar.ms(false);
            }
        });
    }

    private void ms(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, ka kaVar, e eVar) {
        final com.bytedance.sdk.openadsdk.core.ka.ka.ms.d dVar = new com.bytedance.sdk.openadsdk.core.ka.ka.ms.d(this.f2806ms);
        dVar.ms();
        ms(xrVar, kaVar, eVar, dVar);
        ms(xrVar, kaVar, dVar, 0L, new ms() { // from class: com.bytedance.sdk.openadsdk.core.ka.ka.d.8
            @Override // com.bytedance.sdk.openadsdk.core.ka.ka.d.ms
            public void ms(boolean z) {
                dVar.ms(true);
            }
        });
    }

    private void xr(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, ka kaVar, e eVar) {
        final com.bytedance.sdk.openadsdk.core.ka.ka.ms.ah ahVar = new com.bytedance.sdk.openadsdk.core.ka.ka.ms.ah(this.f2806ms);
        ms(xrVar, kaVar, eVar, ahVar);
        ms(xrVar, kaVar, ahVar, 0L, new ms() { // from class: com.bytedance.sdk.openadsdk.core.ka.ka.d.9
            @Override // com.bytedance.sdk.openadsdk.core.ka.ka.d.ms
            public void ms(boolean z) {
                if (z) {
                    return;
                }
                ahVar.ms(false);
            }
        });
    }

    private void ah(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, ka kaVar, e eVar) {
        ms(xrVar, kaVar, eVar, (com.bytedance.sdk.openadsdk.core.ka.ka.ms.xr) null);
    }

    private void d(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, final ka kaVar, e eVar) {
        ms(xrVar, kaVar, (com.bytedance.sdk.openadsdk.core.ka.ka.ms.xr) null, 0L, new ms() { // from class: com.bytedance.sdk.openadsdk.core.ka.ka.d.10
            @Override // com.bytedance.sdk.openadsdk.core.ka.ka.d.ms
            public void ms(boolean z) {
                if (z) {
                    return;
                }
                kaVar.ms(-3, "no cache");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ka(final com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, ka kaVar, e eVar) {
        final x.xr xrVarHi = this.f2806ms.hi();
        final com.bytedance.sdk.openadsdk.core.ka.xr.ms msVarMs = com.bytedance.sdk.openadsdk.core.ka.xr.ms(xrVar.d(), xrVarHi);
        final com.bytedance.sdk.openadsdk.core.ka.ka.ms.d dVar = new com.bytedance.sdk.openadsdk.core.ka.ka.ms.d(this.f2806ms);
        dVar.ms();
        ms(xrVar, kaVar, eVar, dVar);
        final int iMs = msVarMs.ms(xrVarHi.ka(), xrVarHi);
        if (iMs < 0) {
            dVar.ms(false);
        } else {
            ms(xrVar, kaVar, dVar, iMs > 0 ? System.currentTimeMillis() - ((((long) iMs) * 60) * 1000) : 0L, new ms() { // from class: com.bytedance.sdk.openadsdk.core.ka.ka.d.11
                @Override // com.bytedance.sdk.openadsdk.core.ka.ka.d.ms
                public void ms(boolean z) {
                    dVar.ms(z);
                    if (z) {
                        msVarMs.ms(xrVar, xrVarHi, "backup_cache", new StringBuilder().append(iMs).toString());
                    }
                }
            });
        }
    }

    private void c(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, ka kaVar, e eVar) {
        double d;
        x.xr xrVarHi = this.f2806ms.hi();
        com.bytedance.sdk.openadsdk.core.ka.xr.ms msVarMs = com.bytedance.sdk.openadsdk.core.ka.xr.ms(xrVar.d(), xrVarHi);
        if (xrVarHi.xr() > 0) {
            try {
                d = Double.parseDouble(com.bytedance.sdk.openadsdk.core.w.ms.ms().ms("DeviceRate", "bytebench_value"));
            } catch (Exception unused) {
                d = 0.0d;
            }
            if (d > 0.0d && d < xrVarHi.xr()) {
                ms(xrVar, kaVar, eVar, true, 0L, "device_score", new StringBuilder().append(d).toString());
                return;
            }
        }
        if (xrVarHi.ah() > 0) {
            int iAh = u.ah(re.getContext());
            boolean z = true;
            if (iAh == 2 ? (xrVarHi.ah() & 1) == 0 : iAh == 3 ? (2 & xrVarHi.ah()) == 0 : iAh == 4 ? (xrVarHi.ah() & 16) == 0 : iAh == 5 ? (4 & xrVarHi.ah()) == 0 : iAh != 6 || (xrVarHi.ah() & 8) == 0) {
                z = false;
            }
            if (z) {
                ms(xrVar, kaVar, eVar, true, 0L, "net_type", new StringBuilder().append(iAh).toString());
                return;
            }
        }
        if (xrVarHi.d() > 0) {
            msVarMs.ms(xrVarHi);
            int iMs = msVarMs.ms(xrVarHi.d(), xrVarHi);
            if (iMs > 0) {
                ms(xrVar, kaVar, eVar, true, System.currentTimeMillis() - ((((long) iMs) * 60) * 1000), "good_cache", new StringBuilder().append(iMs).toString());
                return;
            } else if (iMs == 0) {
                ms(xrVar, kaVar, eVar, true, 0L, "behavior_score", new StringBuilder().append(iMs).toString());
                return;
            }
        }
        ms(xrVar, kaVar, eVar, false, 0L, "", "");
    }

    private void ms(final com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, final ka kaVar, final e eVar, boolean z, long j, final String str, final String str2) {
        final x.xr xrVarHi = this.f2806ms.hi();
        final com.bytedance.sdk.openadsdk.core.ka.xr.ms msVarMs = com.bytedance.sdk.openadsdk.core.ka.xr.ms(xrVar.d(), xrVarHi);
        if (z) {
            final com.bytedance.sdk.openadsdk.core.ka.ka.ms.ms msVar = new com.bytedance.sdk.openadsdk.core.ka.ka.ms.ms(this.f2806ms) { // from class: com.bytedance.sdk.openadsdk.core.ka.ka.d.12
                @Override // com.bytedance.sdk.openadsdk.core.ka.ka.ms.ms
                public void ms() {
                    d.this.ka(xrVar, kaVar, eVar);
                }
            };
            ms(xrVar, kaVar, msVar, j, new ms() { // from class: com.bytedance.sdk.openadsdk.core.ka.ka.d.13
                @Override // com.bytedance.sdk.openadsdk.core.ka.ka.d.ms
                public void ms(boolean z2) {
                    if (!z2) {
                        msVar.ms(false);
                    } else {
                        msVarMs.ms(xrVar, xrVarHi, str, str2);
                    }
                }
            });
        } else {
            ka(xrVar, kaVar, eVar);
        }
    }

    private void ms(final com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, final ka kaVar, final com.bytedance.sdk.openadsdk.core.ka.ka.ms.xr xrVar2, long j, final ms msVar) {
        lm lmVarMs;
        xrVar.d();
        if (!TextUtils.isEmpty(xrVar.nw())) {
            msVar.ms(false);
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strD = xrVar.d();
        if (this.ah != null) {
            this.ah.xr(strD);
            lmVarMs = this.ah.ms(strD, j);
        } else {
            lmVarMs = null;
        }
        final lm lmVar = lmVarMs;
        if (lmVar == null) {
            msVar.ms(false);
            return;
        }
        if (!ms(lmVar)) {
            msVar.ms(false);
            return;
        }
        if (this.d == null) {
            msVar.ms(false);
            return;
        }
        if (!this.d.ms(xrVar, lmVar)) {
            msVar.ms(false);
            return;
        }
        com.bytedance.sdk.openadsdk.core.ka.xr.ms msVar2 = new com.bytedance.sdk.openadsdk.core.ka.xr.ms(this.xr);
        msVar2.ms(jCurrentTimeMillis);
        msVar2.xr(System.currentTimeMillis());
        msVar2.ms(lmVar, new com.bytedance.sdk.openadsdk.core.ka.xr.c() { // from class: com.bytedance.sdk.openadsdk.core.ka.ka.d.2
            @Override // com.bytedance.sdk.openadsdk.core.ka.xr.c
            public void ms(boolean z, long j2) {
                if (z) {
                    d.this.ms(lmVar, xrVar, xrVar2, kaVar, msVar);
                } else {
                    msVar.ms(false);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ka.xr.c
            public void ms() {
                d.this.ms(xrVar, lmVar, kaVar, xrVar2, msVar);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ka.xr.c
            public void xr() {
                d.this.ms(lmVar, xrVar, xrVar2, kaVar, msVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(final com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, final lm lmVar, final ka kaVar, final com.bytedance.sdk.openadsdk.core.ka.ka.ms.xr xrVar2, final ms msVar) {
        if (this.f2806ms == null || this.f2806ms.ch() != 1) {
            ms(lmVar, xrVar, xrVar2, kaVar, msVar);
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        List<com.bytedance.sdk.openadsdk.core.ka.xr.d> listMs = com.bytedance.sdk.openadsdk.core.ka.xr.d.ms(lmVar);
        if (listMs == null || listMs.isEmpty()) {
            msVar.ms(false);
        } else {
            listMs.size();
            re.ms().ms(listMs, new com.bytedance.sdk.openadsdk.core.ka.xr.xr<com.bytedance.sdk.openadsdk.core.ka.xr.ah>() { // from class: com.bytedance.sdk.openadsdk.core.ka.ka.d.3
                @Override // com.bytedance.sdk.openadsdk.core.ka.xr.xr
                public void ms(com.bytedance.sdk.openadsdk.core.ka.xr.ah ahVar, long j, long j2) {
                    lm lmVarMs = com.bytedance.sdk.openadsdk.core.ka.xr.d.ms(ahVar, lmVar);
                    com.bytedance.sdk.openadsdk.core.t.u.ms(xrVar, lmVarMs != null, j, j2, System.currentTimeMillis() - jCurrentTimeMillis, d.this.xr);
                    if (lmVarMs != null) {
                        d.this.ms(lmVarMs, xrVar, xrVar2, kaVar, msVar);
                    } else {
                        msVar.ms(false);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(final com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, final ka kaVar, final e eVar, final com.bytedance.sdk.openadsdk.core.ka.ka.ms.xr xrVar2) {
        xrVar.d();
        re.ms().ms(xrVar, eVar, this.xr, new yu.xr() { // from class: com.bytedance.sdk.openadsdk.core.ka.ka.d.4
            @Override // com.bytedance.sdk.openadsdk.core.yu.xr
            public void ms(int i, String str, com.bytedance.sdk.openadsdk.core.nw.xr xrVar3) {
                if (d.this.d != null) {
                    d.this.d.ms(xrVar, i, str, xrVar3);
                }
                com.bytedance.sdk.openadsdk.core.ka.ka.ms.xr xrVar4 = xrVar2;
                if (xrVar4 != null) {
                    xrVar4.ms(kaVar, i, str);
                    return;
                }
                ka kaVar2 = kaVar;
                if (kaVar2 != null) {
                    kaVar2.ms(i, str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.yu.xr
            public void ms(com.bytedance.sdk.openadsdk.core.nw.ms msVar, com.bytedance.sdk.openadsdk.core.nw.xr xrVar3) {
                ah ahVarMs = d.this.d == null ? null : d.this.d.ms(msVar, xrVar3, eVar, xrVar, kaVar);
                if (ahVarMs != null) {
                    com.bytedance.sdk.openadsdk.core.ka.ka.ms.xr xrVar4 = xrVar2;
                    if (xrVar4 == null) {
                        ahVarMs.ms();
                    } else {
                        xrVar4.ms(ahVarMs);
                    }
                }
                com.bytedance.sdk.openadsdk.core.ka.ka.ms.xr xrVar5 = xrVar2;
                if (xrVar5 != null) {
                    xrVar5.ah();
                }
            }
        });
    }

    public void ms(final com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, final e eVar) {
        if (xrVar == null) {
            return;
        }
        xrVar.d();
        if (com.bytedance.sdk.openadsdk.core.live.ka.d.ms(xrVar.b())) {
            ab.d(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ka.ka.d.5
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(xrVar.nw())) {
                        if (d.this.xr() != 0 && d.this.ah.ms(xrVar.d())) {
                            xrVar.d();
                            d.this.ms(xrVar, (ka) null, eVar, (com.bytedance.sdk.openadsdk.core.ka.ka.ms.xr) null);
                            return;
                        }
                        return;
                    }
                    if (d.this.d != null) {
                        d.this.d.ms(xrVar);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(lm lmVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, com.bytedance.sdk.openadsdk.core.ka.ka.ms.xr xrVar2, ka kaVar, ms msVar) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_playAgain", false);
        bundle.putBoolean("is_cache", true);
        bundle.putLong("start_time", this.ka);
        ah ahVarMs = this.d.ms(lmVar, xrVar, kaVar, bundle);
        if (xrVar2 != null) {
            xrVar2.xr(ahVarMs);
            xrVar2.ms(true);
            xrVar.d();
        } else {
            ahVarMs.ms();
            xrVar.d();
        }
        msVar.ms(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int xr() {
        return (this.f2806ms == null || this.f2806ms.x() == -1) ? com.bytedance.sdk.openadsdk.core.ka.ka.ms.ms(this.xr) : this.f2806ms.x();
    }
}
