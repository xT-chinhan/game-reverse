package com.byazt.ra;

import android.text.TextUtils;
import android.util.LruCache;
import com.byazt.ca.ho;
import com.byazt.hg.i;
import com.byazt.hg.of;
import com.byazt.is.aj;
import com.byazt.mr.g;
import com.byazt.sd.gz;
import com.byazt.sd.lb;
import com.byazt.wt.ls;
import com.byazt.xlm.fw;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.tapsdk.tapad.constants.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_STALL_COUNTER, 37})
public abstract class pr<T, V> {
    public com.byazt.pe.x pr = new com.byazt.pe.x(pr());
    public static LruCache<String, Integer> hw = new LruCache<>(20);
    public static LruCache<String, Integer> hn = new LruCache<>(20);

    public abstract String hw(V v);

    public abstract int pr();

    public abstract List<String> pr(V v);

    public abstract void pr(T t, int i, String str);

    public abstract void pr(T t, V v);

    public i pr(boolean z, boolean z2, long j, int i, com.byazt.qe.hw hwVar, com.byazt.tt.x xVar) {
        i iVar = new i();
        iVar.aj = j;
        if (z) {
            iVar.pr = 2;
        }
        if (z2) {
            iVar.fw = 2;
        }
        if (xVar != null && xVar.c()) {
            iVar.yb = xVar.hn();
            iVar.lb = xVar.x();
            iVar.a = true;
        }
        if (hwVar == null) {
            iVar.pr(i, "", 1, hwVar);
        } else {
            iVar.pr(i, hwVar.x(), hwVar.k(), hwVar);
        }
        return iVar;
    }

    public void pr(int i, final com.byazt.qe.hw hwVar, final T t) {
        String str;
        String str2;
        final String string = UUID.randomUUID().toString();
        if (hwVar != null && TextUtils.isEmpty(hwVar.cz())) {
            String string2 = UUID.randomUUID().toString();
            pr(string2, hwVar, i);
            str = string2;
        } else {
            str = null;
        }
        pr(str);
        if (!aj.pr()) {
            pr(str, null, false, new com.byazt.xn.hn(1000, "广告请求开关已关闭,请联系穿山甲管理员"));
            pr(t, 1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        if (i == 1) {
            str2 = "loadNativeAd";
        } else if (i == 5) {
            str2 = "loadFeedAd";
        } else if (i == 9) {
            str2 = "loadDrawFeedAd";
        } else if (i != 6) {
            str2 = "loadNativeAd";
        } else {
            str2 = "loadStream";
        }
        com.byazt.ua.hw.pr(hwVar, true, string);
        final String str3 = str;
        final String str4 = str2;
        fw fwVar = new fw(str2) { // from class: com.byazt.ra.pr.1
            /* JADX WARN: Multi-variable type inference failed */
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
            @Override // java.lang.Runnable
            public void run() {
                try {
                    pr.this.pr(hwVar, t, jCurrentTimeMillis, (com.byazt.tt.x) null, str3, string);
                } catch (Throwable th) {
                    pr.this.pr(str3, null, false, new com.byazt.xn.hn(TTAdConstant.INIT_LOCAL_FAIL_CODE, " msg = " + th.getMessage()));
                    pr.this.pr(t, TTAdConstant.INIT_LOCAL_FAIL_CODE, " msg = " + th.getMessage());
                    ho.pr("BaseLoadManager", str4 + " Error msg = ", th.getMessage());
                }
            }
        };
        if (!lb.pr) {
            ho.hw("BaseLoadManager", gz.NOT_INIT_TIPS_MSG);
            pr(str, null, false, new com.byazt.xn.hn(10000, gz.NOT_INIT_TIPS_MSG));
            pr(t, 10000, gz.NOT_INIT_TIPS_MSG);
        } else {
            gz.pr(fwVar, i);
            com.byazt.ip.pr.c().pr(i, hwVar.x(), hwVar);
        }
    }

    public void pr(com.byazt.qe.hw hwVar, com.byazt.tt.x xVar, T t) {
        pr(hwVar, t, System.currentTimeMillis(), xVar, (String) null, (String) null);
        com.byazt.tt.hn.pr(xVar.pr(), true, xVar.hn(), 0);
    }

    public void pr(final com.byazt.qe.hw hwVar, final T t, long j, final com.byazt.tt.x xVar, final String str, final String str2) {
        hw(str);
        final i iVarPr = pr(false, false, j, pr(), hwVar, xVar);
        iVarPr.qa = str2;
        hwVar.x();
        if (this.pr != null) {
            final AtomicReference atomicReference = new AtomicReference(str);
            this.pr.pr(hwVar, iVarPr, new com.byazt.pe.c<V>() { // from class: com.byazt.ra.pr.2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.byazt.pe.c
                public void pr(V v, boolean z, of ofVar) {
                    String strHw = (String) atomicReference.get();
                    if (TextUtils.isEmpty(strHw) && !TextUtils.isEmpty(hwVar.cz())) {
                        strHw = pr.this.x().hw(pr.this.hw(v));
                        atomicReference.set(strHw);
                    }
                    pr.this.pr(strHw, true);
                    iVarPr.pr(v, z ? 3 : 2);
                    hwVar.x();
                    pr prVar = pr.this;
                    prVar.pr(strHw, prVar.pr(v), true, null);
                    com.byazt.tt.x xVar2 = xVar;
                    if (xVar2 != null && xVar2.c()) {
                        xVar.hw(ofVar);
                    }
                    pr.this.pr(t, v);
                    if (ofVar != null && !TextUtils.isEmpty(str2)) {
                        ofVar.pr(str2);
                        com.byazt.ua.hw.pr(ofVar, ls.hw(pr.this.pr()));
                    }
                }

                @Override // com.byazt.pe.c
                public void pr(V v) {
                    hwVar.x();
                    String strHw = (String) atomicReference.get();
                    if (TextUtils.isEmpty(strHw) && !TextUtils.isEmpty(hwVar.cz())) {
                        strHw = pr.this.x().hw(pr.this.hw(v));
                        atomicReference.set(strHw);
                    }
                    if (com.byazt.cf.uc.pr().pr(pr.this.pr()) && !TextUtils.isEmpty(strHw)) {
                        com.byazt.cf.uc.pr().hw(strHw, System.currentTimeMillis());
                    }
                }

                /* JADX WARN: Multi-variable type inference failed */
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
                @Override // com.byazt.pe.c
                public void pr(int i, String str3) {
                    pr.this.pr(str, false);
                    iVarPr.pr((Object) null, 1);
                    hwVar.x();
                    pr.this.pr(str, null, false, new com.byazt.xn.hn(i, str3));
                    pr.this.pr(t, i, str3);
                }
            });
        }
    }

    public void pr(int i, final com.byazt.qe.hw hwVar, final com.byazt.pis.uc ucVar) {
        String str;
        String str2;
        final String string = UUID.randomUUID().toString();
        if (hwVar != null && TextUtils.isEmpty(hwVar.cz())) {
            String string2 = UUID.randomUUID().toString();
            pr(string2, hwVar, i);
            str = string2;
        } else {
            str = null;
        }
        pr(str);
        if (!aj.pr()) {
            pr(str, null, false, new com.byazt.xn.hn(1000, "广告请求开关已关闭,请联系穿山甲管理员"));
            ucVar.pr(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        if (i == 1) {
            str2 = "loadBannerExpressAd";
        } else if (i == 5) {
            str2 = "loadNativeExpressAd";
        } else if (i != 9) {
            str2 = "loadExpressAd";
        } else {
            str2 = "loadExpressDrawFeedAd";
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.byazt.ua.hw.pr(hwVar, true, string);
        final String str3 = str;
        final String str4 = str2;
        fw fwVar = new fw(str2) { // from class: com.byazt.ra.pr.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (gz.pr(hwVar, false)) {
                        pr.this.pr(hwVar, ucVar, jCurrentTimeMillis, str3, string);
                    } else {
                        pr.this.pr(str3, null, false, new com.byazt.xn.hn(110, com.byazt.sd.fw.pr(110)));
                        ucVar.pr(110, com.byazt.sd.fw.pr(110));
                    }
                } catch (Throwable th) {
                    pr.this.pr(str3, null, false, new com.byazt.xn.hn(TTAdConstant.INIT_LOCAL_FAIL_CODE, " msg = " + th.getMessage()));
                    ucVar.pr(TTAdConstant.INIT_LOCAL_FAIL_CODE, " msg = " + th.getMessage());
                    ho.pr("BaseLoadManager", str4 + " error, pls check", th);
                }
            }
        };
        if (!lb.pr) {
            ho.hw("BaseLoadManager", gz.NOT_INIT_TIPS_MSG);
            pr(str, null, false, new com.byazt.xn.hn(10000, gz.NOT_INIT_TIPS_MSG));
            ucVar.pr(10000, gz.NOT_INIT_TIPS_MSG);
        } else {
            gz.pr(fwVar, i);
            com.byazt.ip.pr.c().pr(i, hwVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(final com.byazt.qe.hw hwVar, final com.byazt.pis.uc ucVar, long j, final String str, final String str2) {
        final i iVarPr = pr(false, true, j, pr(), hwVar, (com.byazt.tt.x) null);
        iVarPr.qa = str2;
        hwVar.x();
        hw(str);
        com.byazt.pe.x xVar = this.pr;
        if (xVar != null) {
            xVar.pr(hwVar, iVarPr, new com.byazt.pe.c<List<g>>() { // from class: com.byazt.ra.pr.4
                @Override // com.byazt.pe.c
                public void pr(List<g> list, boolean z, of ofVar) {
                    com.byazt.qe.hw hwVar2;
                    String strHw = str;
                    if (TextUtils.isEmpty(strHw) && (hwVar2 = hwVar) != null && !TextUtils.isEmpty(hwVar2.cz())) {
                        strHw = pr.this.x().hw(pr.this.hw(list));
                    }
                    pr.this.pr(strHw, true);
                    iVarPr.pr(list, z ? 3 : 2);
                    hwVar.x();
                    pr prVar = pr.this;
                    prVar.pr(strHw, prVar.pr(list), true, null);
                    com.byazt.pis.uc ucVar2 = ucVar;
                    if (ucVar2 != null) {
                        ucVar2.pr(list);
                    }
                    if (ofVar != null && !TextUtils.isEmpty(str2)) {
                        ofVar.pr(str2);
                        com.byazt.ua.hw.pr(ofVar, ls.hw(pr.this.pr()));
                    }
                }

                @Override // com.byazt.pe.c
                public void pr(List<g> list) {
                    hwVar.x();
                }

                @Override // com.byazt.pe.c
                public void pr(int i, String str3) {
                    pr.this.pr(str, false);
                    iVarPr.pr((Object) null, 1);
                    hwVar.x();
                    pr.this.pr(str, null, false, new com.byazt.xn.hn(i, str3));
                    com.byazt.pis.uc ucVar2 = ucVar;
                    if (ucVar2 != null) {
                        ucVar2.pr(i, str3);
                    }
                }
            });
        }
    }

    public static pr pr(int i) {
        switch (i) {
            case 1:
                return com.byazt.om.pr.x();
            case 5:
                return com.byazt.yb.pr.x();
            case 6:
                return com.byazt.si.pr.x();
            case 9:
                return com.byazt.ju.pr.x();
            default:
                return null;
        }
    }

    public void pr(of ofVar) {
        com.byazt.pe.x xVar = this.pr;
        if (xVar != null) {
            xVar.hw().pr(ofVar);
        }
    }

    public static void pr(int i, of ofVar) {
        pr prVarPr = pr(i);
        if (prVarPr != null) {
            prVarPr.pr(ofVar);
        }
    }

    public static LruCache<String, Integer> hw() {
        return hw;
    }

    public static LruCache<String, Integer> hn() {
        return hn;
    }

    private void pr(String str, final com.byazt.qe.hw hwVar, final int i) {
        com.byazt.dc.hw hwVar2 = (com.byazt.dc.hw) com.byazt.ewt.c.pr(0);
        hwVar2.hw(str, hwVar.gz());
        hwVar2.pr(str, new com.byazt.tb.hn());
        if (com.byazt.cf.uc.pr().pr(i)) {
            hwVar2.pr(str, new com.byazt.cf.hn());
        }
        hwVar2.pr(str, new com.byazt.ewt.x.pr() { // from class: com.byazt.ra.pr.5
            @Override // com.byazt.ewt.x.pr
            public void pr(com.byazt.ewt.hw hwVar3) {
                if (hwVar3 instanceof com.byazt.pv.hw) {
                    com.byazt.pv.hw hwVar4 = (com.byazt.pv.hw) hwVar3;
                    hwVar4.pr = hwVar;
                    hwVar4.k = i;
                    hwVar4.m = 0;
                    com.byazt.qe.hw hwVar5 = hwVar;
                    if (hwVar5 != null) {
                        hwVar4.g = hwVar5.x();
                    }
                }
            }
        });
    }

    public void pr(String str) {
        x().pr(str, com.byazt.tq.hw.STARTED);
    }

    public void hw(String str) {
        x().pr(str, com.byazt.tq.hw.REQED);
    }

    public void pr(String str, final boolean z) {
        x().pr(str, new com.byazt.ewt.x.pr() { // from class: com.byazt.ra.pr.6
            @Override // com.byazt.ewt.x.pr
            public void pr(com.byazt.ewt.hw hwVar) {
                if (hwVar instanceof com.byazt.pv.hw) {
                    ((com.byazt.pv.hw) hwVar).hw = z;
                }
            }
        });
        x().pr(str, com.byazt.tq.hw.RECEIVED);
    }

    public void pr(final String str, final List<String> list, final boolean z, final com.byazt.xn.hn hnVar) {
        x().pr(str, new com.byazt.ewt.x.pr() { // from class: com.byazt.ra.pr.7
            @Override // com.byazt.ewt.x.pr
            public void pr(com.byazt.ewt.hw hwVar) {
                if (hwVar instanceof com.byazt.pv.hw) {
                    com.byazt.pv.hw hwVar2 = (com.byazt.pv.hw) hwVar;
                    hwVar2.hn = z;
                    hwVar2.x = hnVar;
                    if (list != null) {
                        hwVar2.c.addAll(list);
                    }
                }
            }
        });
        com.byazt.dc.hn hnVar2 = (com.byazt.dc.hn) com.byazt.ewt.c.pr(1);
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                hnVar2.pr(it.next(), new com.byazt.ewt.x.pr() { // from class: com.byazt.ra.pr.8
                    @Override // com.byazt.ewt.x.pr
                    public void pr(com.byazt.ewt.hw hwVar) {
                        if (hwVar instanceof com.byazt.pv.hn) {
                            ((com.byazt.pv.hn) hwVar).pr = str;
                        }
                    }
                });
            }
        }
        x().pr(str, com.byazt.tq.hw.LOADED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.dc.hw x() {
        return (com.byazt.dc.hw) com.byazt.ewt.c.pr(0);
    }

    public List<String> pr(List<g> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<g> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().vk());
        }
        return arrayList;
    }

    public String hw(List<g> list) {
        Map<String, Object> mapZo;
        if (list != null && !list.isEmpty() && (mapZo = list.get(0).zo()) != null && mapZo.get(Constants.Bidding.REQUEST_ID) != null) {
            return (String) mapZo.get(Constants.Bidding.REQUEST_ID);
        }
        return null;
    }
}
