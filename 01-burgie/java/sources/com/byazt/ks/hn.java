package com.byazt.ks;

import android.text.TextUtils;
import com.byazt.hg.of;
import com.byazt.hg.sv;
import com.byazt.py.fw;
import com.byazt.sd.rc;
import com.byazt.vkw.nt;
import com.byazt.wt.ls;
import com.byazt.zn.aj;
import com.byazt.zp.zo;
import com.byazt.zs.uc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE, 20})
public class hn extends pr {
    public volatile fw w;
    public static ConcurrentHashMap<String, hw> fw = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<String, List<String>> zo = new ConcurrentHashMap<>();
    public static ReferenceQueue<Object> aj = new ReferenceQueue<>();
    public static Map<Object, hw> vk = new ConcurrentHashMap();

    private void x() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.w = new fw(3);
        com.byazt.nz.pr.pr("lqmt", "NewCache 初始化耗时: " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    @Override // com.byazt.ks.pr
    public void hw() {
        if (this.w == null) {
            synchronized (this) {
                if (this.w == null) {
                    x();
                }
            }
        }
    }

    @Override // com.byazt.ks.pr
    public void pr(final sv svVar, com.byazt.qe.hw hwVar, boolean z) {
        if (hwVar == null || svVar == null || svVar.pr() == null) {
            return;
        }
        if (this.w == null) {
            hw();
        }
        try {
            final String strX = hwVar.x();
            com.byazt.nz.pr.pr("lqmt", "saveCache start >>  rit: " + strX + "  isUsing: " + z);
            final of ofVarPr = svVar.pr();
            String strNy = ofVarPr.ny();
            String strHw = hw(strX, strNy);
            if (!fw.contains(strHw)) {
                com.byazt.nz.pr.pr("lqmt", "save-updateMemoryRecord start >>  rit: " + strX + "  reqId: " + strNy);
                pr(strHw, strX, strNy, z ? 2 : 1);
                try {
                    pr(new Runnable() { // from class: com.byazt.ks.hn.1
                        @Override // java.lang.Runnable
                        public void run() {
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            hn.this.w.pr(strX, new fw.hw(((nt) uc.pr("encrypt_service")).hn(svVar.hw().hn().toString()), ofVarPr.ja(), 1000 * ofVarPr.hp(), ofVarPr.ny()), false, ls.qa(ofVarPr), ofVarPr.tc());
                            com.byazt.nz.pr.pr("lqmt", "saveMeta >>  rit: " + strX + " saveDb cost: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                        }
                    });
                } catch (Throwable th) {
                }
            }
        } catch (Throwable th2) {
        }
    }

    /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r10v5, types: [java.lang.Throwable] */
    @Override // com.byazt.ks.pr
    public void pr(com.byazt.zn.fw fwVar, final String str, pr.InterfaceC0116pr interfaceC0116pr, c cVar) {
        of ofVar;
        if (str == null || interfaceC0116pr == null) {
            return;
        }
        if (this.w == null) {
            hw();
        }
        this.uc = cVar;
        fw.hw hwVar = null;
        com.byazt.zn.uc ucVar = null;
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            c();
            List<String> listPr = pr(str);
            com.byazt.nz.pr.pr("lqmt", "readcache start >>  rit: " + str + "  usedReqIdList: " + (listPr == null ? 0 : listPr.size()));
            final fw.hw hwVarPr = this.w.pr(str, this.uc == null ? 0L : this.uc.pr, listPr);
            try {
                com.byazt.nz.pr.pr("lqmt", "readcache-getCacheMeta cost: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                if (hwVarPr == null) {
                    com.byazt.nz.pr.pr("lqmt", "readcache-cacheMeta: null ");
                    if (fwVar != null) {
                        fwVar.x(0);
                        fwVar.hw(1);
                        fwVar.pr("no cache");
                    }
                    interfaceC0116pr.pr();
                    return;
                }
                String str2 = hwVarPr.c;
                String strHw = hw(str, str2);
                com.byazt.nz.pr.pr("lqmt", "readcache-mapkey: " + strHw);
                hw hwVar2 = fw.get(strHw);
                if (hwVar2 != null && hwVar2.hw > 1) {
                    com.byazt.nz.pr.pr("lqmt", "readcache-cacheRecord != null && cacheRecord.status > CACHE_STATUS_NOUSE");
                    if (fwVar != null) {
                        fwVar.x(0);
                        fwVar.hw(1);
                        fwVar.pr("no cache");
                    }
                    interfaceC0116pr.pr();
                    return;
                }
                pr(strHw, str, str2, 2);
                com.byazt.hg.pr prVar = rc.pr.pr(new JSONObject(((nt) uc.pr("encrypt_service")).x(hwVarPr.hn))).zo;
                com.byazt.zn.uc ucVar2 = new com.byazt.zn.uc(prVar, true);
                if (prVar != null && prVar.hw() != null && !prVar.hw().isEmpty()) {
                    ofVar = prVar.hw().get(0);
                } else {
                    ofVar = null;
                }
                if (ofVar != null) {
                    ucVar2.pr(ofVar);
                }
                com.byazt.nz.pr.pr("lqmt", "readcache-updateMemoryRecord start >>  rit: " + str + "  reqId: " + str2);
                switch (com.byazt.eg.hw.pr().hn(ofVar)) {
                    case 3:
                        ucVar2.pr((of) null);
                        break;
                    default:
                        ucVar = ucVar2;
                        break;
                }
                interfaceC0116pr.pr(ucVar);
                boolean zVk = com.byazt.mp.c.pr().vk();
                com.byazt.nz.pr.pr("lqmt", "isSplashCacheRemoveChange: " + zVk);
                if (!zVk) {
                    pr(new Runnable() { // from class: com.byazt.ks.hn.2
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                long jCurrentTimeMillis2 = System.currentTimeMillis();
                                hn.this.w.pr(str, hwVarPr.c);
                                com.byazt.nz.pr.pr("lqmt", "readcache-deleteCacheMeta start >>  rit: " + str + "  reqId: " + hwVarPr.c + "  cost: " + (System.currentTimeMillis() - jCurrentTimeMillis2));
                            } catch (Exception e) {
                            }
                        }
                    });
                }
            } catch (Throwable th) {
                hwVar = hwVarPr;
                hwVarPr = hwVar;
            }
        } catch (Throwable th2) {
        }
    }

    @Override // com.byazt.ks.pr
    public void pr(com.byazt.vx.x<aj, com.byazt.zn.fw> xVar, final of ofVar, com.byazt.qe.hw hwVar, boolean z) {
        if (ofVar == null || hwVar == null) {
            return;
        }
        if (this.w == null) {
            hw();
        }
        try {
            com.byazt.nz.pr.pr("lqmt", "removeCache>> start ");
            final String strX = hwVar.x();
            String strNy = ofVar.ny();
            String strHw = hw(strX, strNy);
            if (this.c.get()) {
                com.byazt.nz.pr.pr("lqmt", "removeCache-mIsRemoveCacheAd: true");
                return;
            }
            this.c.set(true);
            pr(strHw, strX, strNy, 3);
            com.byazt.nz.pr.pr("lqmt", "removeCache-updateMemoryRecord: 完成");
            pr(new Runnable() { // from class: com.byazt.ks.hn.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        hn.this.w.pr(strX, ofVar.ny());
                        com.byazt.nz.pr.pr("lqmt", "removeCache-deleteCacheMeta  rit: " + strX + "  cost: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                    } catch (Throwable th) {
                    }
                }
            });
            if (xVar != null) {
                xVar.pr();
            }
        } catch (Throwable th) {
        }
    }

    @Override // com.byazt.ks.pr
    public void pr(String str, of ofVar) {
        if (this.w == null) {
            hw();
        }
        if (this.w != null) {
            this.w.pr(str, ofVar.ny());
        }
    }

    @Override // com.byazt.ks.pr
    public void hn() {
        if (this.w == null) {
            hw();
        }
        if (this.w != null) {
            this.w.pr();
        }
    }

    @Override // com.byazt.ks.pr
    public void pr(String str, String str2, boolean z, boolean z2, Object obj) {
        if (uc() != 3 || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        if (z2 || !z) {
            pr(str, str2);
        } else {
            pr(obj, str, str2);
        }
    }

    private void pr(final Runnable runnable) {
        if (zo.pr()) {
            com.byazt.xlm.c.hw(new com.byazt.xlm.fw("") { // from class: com.byazt.ks.hn.4
                @Override // java.lang.Runnable
                public void run() {
                    runnable.run();
                }
            });
        } else {
            runnable.run();
        }
    }

    private List<String> pr(String str) {
        List<String> list = zo.get(str);
        com.byazt.nz.pr.pr("lqmt", "getUsedReqIdList: list : " + (list == null ? 0 : list.size()));
        return list;
    }

    private void pr(String str, String str2, String str3, int i) {
        int iUc = uc();
        com.byazt.nz.pr.pr("lqmt", "updateMemoryRecord>> start rit: " + str2 + ", status: " + i + ", cacheStrategyType: " + iUc);
        if (iUc != 3) {
            return;
        }
        fw.put(str, new hw(str3, i, str2));
        if (i <= 1) {
            com.byazt.nz.pr.pr("lqmt", "updateMemoryRecord>> :status <= CACHE_STATUS_NOUSE");
            return;
        }
        List<String> copyOnWriteArrayList = zo.get(str2);
        com.byazt.nz.pr.pr("lqmt", "updateMemoryRecord>>: list1 : " + (copyOnWriteArrayList == null ? 0 : copyOnWriteArrayList.size()));
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            copyOnWriteArrayList.add(str3);
        } else if (!copyOnWriteArrayList.contains(str3)) {
            copyOnWriteArrayList.add(str3);
        } else {
            return;
        }
        com.byazt.nz.pr.pr("lqmt", "updateMemoryRecord>>: list2 : " + copyOnWriteArrayList.size());
        zo.put(str2, copyOnWriteArrayList);
    }

    private void pr(Object obj, String str, String str2) {
        try {
            hw hwVar = fw.get(hw(str, str2));
            if (hwVar != null && obj != null) {
                PhantomReference phantomReference = new PhantomReference(obj, aj);
                com.byazt.nz.pr.pr("lqmt", hwVar.hn + "，uuid：" + hwVar.pr + " watching");
                vk.put(phantomReference, hwVar);
            }
        } catch (Exception e) {
        }
    }

    private void c() {
        if (uc() != 3) {
            return;
        }
        try {
            for (Reference<? extends Object> referencePoll = aj.poll(); referencePoll != null; referencePoll = aj.poll()) {
                hw hwVar = vk.get(referencePoll);
                if (hwVar != null) {
                    pr(hwVar.hn, hwVar.pr);
                }
                vk.remove(referencePoll);
            }
        } catch (Exception e) {
        }
    }

    private void pr(String str, String str2) {
        fw.remove(hw(str, str2));
        List<String> list = zo.get(str);
        com.byazt.nz.pr.pr("lqmt", "checkCaches>>: list1 : " + (list == null ? 0 : list.size()));
        if (list == null) {
            return;
        }
        com.byazt.nz.pr.pr("lqmt", "checkCaches>>: rmCache : " + str2);
        list.remove(str2);
        zo.put(str, list);
    }

    private static int uc() {
        if (com.byazt.hg.zo.pr() == null) {
            return 1;
        }
        return com.byazt.hg.zo.pr().x();
    }

    private String hw(String str, String str2) {
        return str + str2;
    }
}
