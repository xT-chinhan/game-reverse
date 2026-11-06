package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Loader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.nw.e;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class p implements Loader, Function<SparseArray<Object>, Object> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final yu f3232ms = re.ms();
    private volatile Context xr;

    public p(Context context) {
        this.xr = (context == null ? re.getContext() : context).getApplicationContext();
    }

    private void x(ValueSet valueSet, Bridge bridge) {
        ms(com.bytedance.sdk.openadsdk.core.jw.op.ms(5, valueSet), new com.bytedance.sdk.openadsdk.core.ms.ka(bridge));
    }

    public void ms(final com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, final com.bytedance.sdk.openadsdk.t.ms.xr.ms.ah ahVar) {
        if (!com.bytedance.sdk.openadsdk.core.g.ny.ms()) {
            ahVar.ms(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        com.bytedance.sdk.component.ch.ny nyVar = new com.bytedance.sdk.component.ch.ny("loadFeedAd") { // from class: com.bytedance.sdk.openadsdk.core.p.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.bytedance.sdk.openadsdk.core.component.ms.ms.ms().ms(p.this.getContext(), xrVar, ahVar);
                } catch (Throwable th) {
                    ahVar.ms(TTAdConstant.INIT_LOCAL_FAIL_CODE, "feed component maybe not exist, pls check1, msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.sl.ah("TTAdNativeImpl", "feed component maybe not exist, pls check1", th);
                }
            }
        };
        if (!nw.f3028ms) {
            com.bytedance.sdk.component.utils.sl.d("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            ahVar.ms(10000, "Please exec  TTAdSdk.init and TTAdSdk.start before load ad");
        } else {
            ms(nyVar, 5);
            com.bytedance.sdk.openadsdk.core.c.ms.ah().ms(5, xrVar);
        }
    }

    public void ms(ValueSet valueSet, Bridge bridge) {
        xr(com.bytedance.sdk.openadsdk.core.jw.op.ms(6, valueSet), new com.bytedance.sdk.openadsdk.core.ms.ka(bridge));
    }

    public void xr(final com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, final com.bytedance.sdk.openadsdk.t.ms.xr.ms.ah ahVar) {
        if (!com.bytedance.sdk.openadsdk.core.g.ny.ms()) {
            ahVar.ms(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        com.bytedance.sdk.component.ch.ny nyVar = new com.bytedance.sdk.component.ch.ny("loadStream") { // from class: com.bytedance.sdk.openadsdk.core.p.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.bytedance.sdk.openadsdk.core.component.ms.ms.ms().xr(p.this.getContext(), xrVar, ahVar);
                } catch (Throwable th) {
                    ahVar.ms(TTAdConstant.INIT_LOCAL_FAIL_CODE, "feed component maybe not exist, pls check1, msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.sl.ah("TTAdNativeImpl", "feed component maybe not exist, pls check1", th);
                }
            }
        };
        if (!nw.f3028ms) {
            com.bytedance.sdk.component.utils.sl.d("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            ahVar.ms(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
        } else {
            ms(nyVar, 6);
            com.bytedance.sdk.openadsdk.core.c.ms.ah().ms(6, xrVar);
        }
    }

    public void xr(ValueSet valueSet, Bridge bridge) {
        ms(com.bytedance.sdk.openadsdk.core.jw.op.ms(9, valueSet), new com.bytedance.sdk.openadsdk.core.ms.d(bridge));
    }

    public void ms(final com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, final com.bytedance.sdk.openadsdk.t.ms.xr.ms.xr xrVar2) {
        if (!com.bytedance.sdk.openadsdk.core.g.ny.ms()) {
            xrVar2.ms(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        com.bytedance.sdk.component.ch.ny nyVar = new com.bytedance.sdk.component.ch.ny("loadDrawFeedAd") { // from class: com.bytedance.sdk.openadsdk.core.p.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    p.this.ms(xrVar);
                    com.bytedance.sdk.openadsdk.core.component.ms.ms.ms().ms(p.this.getContext(), xrVar, xrVar2);
                } catch (Throwable th) {
                    xrVar2.ms(TTAdConstant.INIT_LOCAL_FAIL_CODE, "feed component maybe not exist, pls check2, msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.sl.ah("TTAdNativeImpl", "feed component maybe not exist, pls check2", th);
                }
            }
        };
        if (!nw.f3028ms) {
            com.bytedance.sdk.component.utils.sl.d("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            xrVar2.ms(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
        } else {
            ms(nyVar, 9);
            com.bytedance.sdk.openadsdk.core.c.ms.ah().ms(9, xrVar);
        }
    }

    public void ah(ValueSet valueSet, Bridge bridge) {
        ms(1, com.bytedance.sdk.openadsdk.core.jw.op.ms(1, valueSet), new com.bytedance.sdk.openadsdk.core.ms.ab(bridge));
    }

    public void ms(final int i, final com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, final com.bytedance.sdk.openadsdk.t.ms.xr.ms.ka kaVar) {
        if (!com.bytedance.sdk.openadsdk.core.g.ny.ms()) {
            kaVar.ms(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.component.ch.ny nyVar = new com.bytedance.sdk.component.ch.ny("loadNativeAd") { // from class: com.bytedance.sdk.openadsdk.core.p.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    e eVar = new e();
                    eVar.x = jCurrentTimeMillis;
                    p.this.f3232ms.ms(xrVar, eVar, i, new yu.xr() { // from class: com.bytedance.sdk.openadsdk.core.p.5.1
                        @Override // com.bytedance.sdk.openadsdk.core.yu.xr
                        public void ms(int i2, String str, com.bytedance.sdk.openadsdk.core.nw.xr xrVar2) {
                            kaVar.ms(i2, str);
                            xrVar2.ms(i2);
                            com.bytedance.sdk.openadsdk.core.nw.xr.ms(xrVar2);
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.yu.xr
                        public void ms(com.bytedance.sdk.openadsdk.core.nw.ms msVar, com.bytedance.sdk.openadsdk.core.nw.xr xrVar2) {
                            if (msVar.xr() != null && !msVar.xr().isEmpty()) {
                                List<lm> listXr = msVar.xr();
                                ArrayList arrayList = new ArrayList(listXr.size());
                                for (lm lmVar : listXr) {
                                    if (lmVar.jl()) {
                                        arrayList.add(new com.bytedance.sdk.openadsdk.core.b.d(p.this.getContext(), lmVar, i, xrVar, false));
                                    }
                                }
                                if (!arrayList.isEmpty()) {
                                    com.bytedance.sdk.openadsdk.core.zb.ah.xr(listXr.get(0), com.bytedance.sdk.openadsdk.core.jw.f.xr(xrVar.t()), jCurrentTimeMillis);
                                    kaVar.ms(arrayList);
                                    return;
                                } else {
                                    kaVar.ms(-4, ny.ms(-4));
                                    xrVar2.ms(-4);
                                    com.bytedance.sdk.openadsdk.core.nw.xr.ms(xrVar2);
                                    return;
                                }
                            }
                            kaVar.ms(-3, ny.ms(-3));
                            xrVar2.ms(-3);
                            com.bytedance.sdk.openadsdk.core.nw.xr.ms(xrVar2);
                        }
                    });
                } catch (Throwable th) {
                    kaVar.ms(TTAdConstant.INIT_LOCAL_FAIL_CODE, " msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.sl.ah("TTAdNativeImpl", "Error msg = ", th.getMessage());
                }
            }
        };
        if (!nw.f3028ms) {
            com.bytedance.sdk.component.utils.sl.d("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            kaVar.ms(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
        } else {
            ms(nyVar, i);
            com.bytedance.sdk.openadsdk.core.c.ms.ah().ms(i, xrVar.d());
        }
    }

    public void ms(ValueSet valueSet, Bridge bridge, int i) {
        ms(com.bytedance.sdk.openadsdk.core.jw.op.ms(3, valueSet), new com.bytedance.sdk.openadsdk.core.ms.ah(bridge), i);
    }

    public void ms(final com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, final com.bytedance.sdk.openadsdk.t.ms.xr.ms.ms msVar, final int i) {
        if (!com.bytedance.sdk.openadsdk.core.g.ny.ms()) {
            msVar.ms(new com.bytedance.sdk.openadsdk.ao.xr.ka(1000, "广告请求开关已关闭,请联系穿山甲管理员"));
            return;
        }
        int iNy = re.xr().ny(com.bytedance.sdk.openadsdk.core.jw.f.xr(xrVar));
        com.bytedance.sdk.component.ch.ny nyVar = new com.bytedance.sdk.component.ch.ny("loadSplashAd b") { // from class: com.bytedance.sdk.openadsdk.core.p.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ch.ub().ab(1);
                    com.bytedance.sdk.openadsdk.core.component.splash.d.ms(p.this.getContext()).ms(xrVar, msVar, i);
                } catch (Throwable th) {
                    msVar.ms(new com.bytedance.sdk.openadsdk.ao.xr.ka(TTAdConstant.INIT_LOCAL_FAIL_CODE, " msg = " + th.getMessage()));
                    com.bytedance.sdk.component.utils.sl.ah("TTAdNativeImpl", "splash component maybe not exist, pls check1", th);
                }
            }
        };
        if (!nw.f3028ms) {
            com.bytedance.sdk.component.utils.sl.d("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            msVar.ms(new com.bytedance.sdk.openadsdk.ao.xr.ka(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad"));
            return;
        }
        if (AdSdkInitializerHolder.isSdkInitSuccess() && (iNy == 4 || com.bytedance.sdk.openadsdk.core.component.splash.d.ms(xrVar))) {
            nyVar.run();
        } else if (ms()) {
            com.bytedance.sdk.component.ch.ab.ka(nyVar);
        } else {
            com.bytedance.sdk.component.ch.hi.xr.sl().execute(nyVar);
        }
        com.bytedance.sdk.openadsdk.core.c.ms.ah().ms(3, xrVar);
    }

    private void ny(ValueSet valueSet, Bridge bridge) {
        ms(com.bytedance.sdk.openadsdk.core.jw.op.ms(7, valueSet), new com.bytedance.sdk.openadsdk.core.ms.ny(bridge));
    }

    public void ms(final com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, final com.bytedance.sdk.openadsdk.t.ms.xr.ms.ab abVar) {
        if (!com.bytedance.sdk.openadsdk.core.g.ny.ms()) {
            abVar.ms(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        com.bytedance.sdk.component.ch.ny nyVar = new com.bytedance.sdk.component.ch.ny("loadRewardVideoAd") { // from class: com.bytedance.sdk.openadsdk.core.p.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.bytedance.sdk.openadsdk.core.component.reward.ms.ka.ms().ms(xrVar, new com.bytedance.sdk.openadsdk.core.component.reward.ms.ah(abVar));
                } catch (Throwable th) {
                    abVar.ms(TTAdConstant.INIT_LOCAL_FAIL_CODE, " msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.sl.ah("TTAdNativeImpl", "reward  component maybe not exist, pls check1", th);
                }
            }
        };
        if (!nw.f3028ms) {
            com.bytedance.sdk.component.utils.sl.d("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            abVar.ms(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
        } else {
            ms(nyVar, 7);
            com.bytedance.sdk.openadsdk.core.c.ms.ah().ms(7, xrVar);
        }
    }

    public void d(ValueSet valueSet, Bridge bridge) {
        ms(com.bytedance.sdk.openadsdk.core.jw.op.ms(8, valueSet), new com.bytedance.sdk.openadsdk.core.ms.c(bridge));
    }

    public void ms(final com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, final com.bytedance.sdk.openadsdk.t.ms.xr.ms.d dVar) {
        if (!com.bytedance.sdk.openadsdk.core.g.ny.ms()) {
            dVar.ms(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        com.bytedance.sdk.component.ch.ny nyVar = new com.bytedance.sdk.component.ch.ny("loadFullScreenVideoAd") { // from class: com.bytedance.sdk.openadsdk.core.p.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.bytedance.sdk.openadsdk.core.component.reward.ms.ms.ms().ms(xrVar, new com.bytedance.sdk.openadsdk.core.component.reward.ms.ah(dVar));
                } catch (Throwable th) {
                    dVar.ms(TTAdConstant.INIT_LOCAL_FAIL_CODE, " msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.sl.xr("TTAdNativeImpl", "reward component maybe not exist, pls check2", th);
                }
            }
        };
        if (!nw.f3028ms) {
            com.bytedance.sdk.component.utils.sl.d("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            dVar.ms(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
        } else {
            ms(nyVar, 8);
            com.bytedance.sdk.openadsdk.core.c.ms.ah().ms(8, xrVar);
        }
    }

    public void ka(ValueSet valueSet, Bridge bridge) {
        ms(com.bytedance.sdk.openadsdk.core.jw.op.ms(5, valueSet), new com.bytedance.sdk.openadsdk.core.ms.x(bridge));
    }

    public void ms(final com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, final com.bytedance.sdk.openadsdk.t.ms.xr.ms.c cVar) {
        if (!com.bytedance.sdk.openadsdk.core.g.ny.ms()) {
            cVar.ms(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        com.bytedance.sdk.component.ch.ny nyVar = new com.bytedance.sdk.component.ch.ny("loadNativeExpressAd") { // from class: com.bytedance.sdk.openadsdk.core.p.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (p.this.ms(xrVar, false)) {
                        com.bytedance.sdk.openadsdk.core.nativeexpress.d.ms(p.this.getContext()).ms(xrVar, 5, cVar, 5000);
                    } else {
                        cVar.ms(110, ny.ms(110));
                    }
                } catch (Throwable th) {
                    cVar.ms(TTAdConstant.INIT_LOCAL_FAIL_CODE, " msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.sl.ah("TTAdNativeImpl", "Error msg = ", th);
                }
            }
        };
        if (!nw.f3028ms) {
            com.bytedance.sdk.component.utils.sl.d("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            cVar.ms(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
        } else {
            ms(nyVar, 5);
            com.bytedance.sdk.openadsdk.core.c.ms.ah().ms(5, xrVar);
        }
    }

    public void c(ValueSet valueSet, Bridge bridge) {
        xr(com.bytedance.sdk.openadsdk.core.jw.op.ms(9, valueSet), new com.bytedance.sdk.openadsdk.core.ms.x(bridge));
    }

    public void xr(final com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, final com.bytedance.sdk.openadsdk.t.ms.xr.ms.c cVar) {
        if (!com.bytedance.sdk.openadsdk.core.g.ny.ms()) {
            cVar.ms(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        com.bytedance.sdk.component.ch.ny nyVar = new com.bytedance.sdk.component.ch.ny("loadExpressDrawFeedAd") { // from class: com.bytedance.sdk.openadsdk.core.p.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (p.this.ms(xrVar, false)) {
                        com.bytedance.sdk.openadsdk.core.nativeexpress.d.ms(p.this.getContext()).ms(xrVar, 9, cVar, 5000);
                    } else {
                        cVar.ms(110, ny.ms(110));
                    }
                } catch (Throwable th) {
                    cVar.ms(TTAdConstant.INIT_LOCAL_FAIL_CODE, " msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.sl.ah("TTAdNativeImpl", "Error msg =", th);
                }
            }
        };
        if (!nw.f3028ms) {
            com.bytedance.sdk.component.utils.sl.d("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            cVar.ms(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
        } else {
            ms(nyVar, 9);
            com.bytedance.sdk.openadsdk.core.c.ms.ah().ms(9, xrVar);
        }
    }

    public void ab(ValueSet valueSet, Bridge bridge) {
        ah(com.bytedance.sdk.openadsdk.core.jw.op.ms(1, valueSet), new com.bytedance.sdk.openadsdk.core.ms.x(bridge));
    }

    public void ah(final com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, final com.bytedance.sdk.openadsdk.t.ms.xr.ms.c cVar) {
        if (!com.bytedance.sdk.openadsdk.core.g.ny.ms()) {
            cVar.ms(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        com.bytedance.sdk.component.ch.ny nyVar = new com.bytedance.sdk.component.ch.ny("loadBannerExpressAd") { // from class: com.bytedance.sdk.openadsdk.core.p.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (p.this.ms(xrVar, false)) {
                        com.bytedance.sdk.openadsdk.core.nativeexpress.d.ms(p.this.getContext()).ms(xrVar, 1, cVar, 5000);
                    } else {
                        cVar.ms(110, ny.ms(110));
                    }
                } catch (Throwable th) {
                    cVar.ms(TTAdConstant.INIT_LOCAL_FAIL_CODE, " msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.sl.ah("TTAdNativeImpl", "Banner express error, pls check", th);
                }
            }
        };
        if (!nw.f3028ms) {
            com.bytedance.sdk.component.utils.sl.d("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            cVar.ms(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
        } else {
            ms(nyVar, 1);
            com.bytedance.sdk.openadsdk.core.c.ms.ah().ms(1, xrVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        com.bytedance.sdk.component.utils.ao.ms(xrVar.c() > 0, "必须设置图片素材尺寸");
        com.bytedance.sdk.component.utils.ao.ms(xrVar.ab() > 0, "必须设置图片素材尺寸");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ms(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, boolean z) {
        if (xrVar == null) {
            return false;
        }
        return (z && !re.xr().ch(xrVar.d())) || xrVar.x() > 0.0f;
    }

    private boolean ms() {
        return AdSdkInitializerHolder.isSdkInitSuccess();
    }

    private void ms(com.bytedance.sdk.component.ch.ny nyVar, int i) {
        if (ms()) {
            com.bytedance.sdk.component.ch.ab.ka(nyVar);
        } else {
            com.bytedance.sdk.component.ch.hi.xr.sl().execute(nyVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        if (this.xr == null) {
            this.xr = re.getContext();
        }
        return this.xr;
    }

    @Override // com.bykv.vk.openvk.api.proto.Loader
    public void load(int i, ValueSet valueSet, EventListener eventListener) {
        if (valueSet == null) {
            com.bytedance.sdk.component.utils.sl.xr("load with null valueset");
            return;
        }
        Bridge bridge = (Bridge) valueSet.objectValue(1, Bridge.class);
        if (bridge == null) {
            com.bytedance.sdk.component.utils.sl.xr("load with null callback");
        } else {
            ms(i, valueSet, bridge);
        }
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            com.bytedance.sdk.component.utils.sl.xr("apply->load with null ->SparseArray");
            return null;
        }
        ValueSet valueSetXr = com.bykv.ms.ms.ms.ms.xr.ms(sparseArray).xr();
        int iIntValue = valueSetXr.intValue(-99999982);
        Object objObjectValue = valueSetXr.objectValue(1, Object.class);
        if (objObjectValue == null) {
            com.bytedance.sdk.component.utils.sl.xr("apply->load with null callback");
            return null;
        }
        ms(iIntValue, valueSetXr, new com.bytedance.sdk.openadsdk.core.f.ah(objObjectValue));
        return null;
    }

    public void ms(int i, ValueSet valueSet, Bridge bridge) {
        com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms(valueSet);
        xrVarMs.ms(1, 0);
        ValueSet valueSetXr = xrVarMs.xr();
        if (i == 1) {
            if (valueSetXr.booleanValue(2)) {
                ab(valueSetXr, bridge);
                return;
            } else {
                ah(valueSetXr, bridge);
                return;
            }
        }
        if (i == 3) {
            ms(valueSetXr, bridge, valueSetXr.intValue(3));
            return;
        }
        switch (i) {
            case 5:
                if (valueSetXr.booleanValue(2)) {
                    ka(valueSetXr, bridge);
                } else {
                    x(valueSetXr, bridge);
                }
                break;
            case 6:
                ms(valueSetXr, bridge);
                break;
            case 7:
                ny(valueSetXr, bridge);
                break;
            case 8:
                d(valueSetXr, bridge);
                break;
            case 9:
                if (valueSetXr.booleanValue(2)) {
                    c(valueSetXr, bridge);
                } else {
                    xr(valueSetXr, bridge);
                }
                break;
        }
    }
}
