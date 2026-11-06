package com.bytedance.sdk.openadsdk.core.component.splash.ms;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ab;
import com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c;
import com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ny;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.ka.d.ka;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.tz;
import com.bytedance.sdk.openadsdk.core.nw.x;
import com.bytedance.sdk.openadsdk.core.op;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends ms {
    private volatile ka ch;
    static ConcurrentHashMap<String, xr> c = new ConcurrentHashMap<>();
    static ConcurrentHashMap<String, List<String>> ab = new ConcurrentHashMap<>();
    static ReferenceQueue<Object> x = new ReferenceQueue<>();
    static Map<Object, xr> ny = new ConcurrentHashMap();

    private void d() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.ch = new ka(3);
        com.bytedance.sdk.openadsdk.core.ab.ms.ms("lqmt", "NewCache 初始化耗时: " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.ms.ms
    public void xr() {
        if (this.ch == null) {
            synchronized (this) {
                if (this.ch == null) {
                    d();
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.ms.ms
    public void ms(final tz tzVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, boolean z) {
        if (xrVar == null || tzVar == null || tzVar.ms() == null) {
            return;
        }
        if (this.ch == null) {
            xr();
        }
        try {
            final String strD = xrVar.d();
            com.bytedance.sdk.openadsdk.core.ab.ms.ms("lqmt", "saveCache start >>  rit: " + strD + "  isUsing: " + z);
            final lm lmVarMs = tzVar.ms();
            String strEu = lmVarMs.eu();
            String strXr = xr(strD, strEu);
            if (c.contains(strXr)) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.ab.ms.ms("lqmt", "save-updateMemoryRecord start >>  rit: " + strD + "  reqId: " + strEu);
            ms(strXr, strD, strEu, z ? 2 : 1);
            ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ms.ah.1
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    ah.this.ch.ms(strD, new ka.xr(com.bytedance.sdk.component.utils.ms.xr(tzVar.xr().ah().toString()), lmVarMs.bk(), 1000 * lmVarMs.no(), lmVarMs.eu()), false, f.ub(lmVarMs));
                    com.bytedance.sdk.openadsdk.core.ab.ms.ms("lqmt", "saveMeta >>  rit: " + strD + " saveDb cost: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                }
            });
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.ms.ms
    public void ms(ab abVar, final String str, ms.InterfaceC0286ms interfaceC0286ms) {
        if (str == null || interfaceC0286ms == null) {
            return;
        }
        if (this.ch == null) {
            xr();
        }
        ka.xr xrVar = null;
        c cVar = null;
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            ka();
            List<String> listMs = ms(str);
            com.bytedance.sdk.openadsdk.core.ab.ms.ms("lqmt", "readcache start >>  rit: " + str + "  usedReqIdList: " + (listMs == null ? 0 : listMs.size()));
            final ka.xr xrVarMs = this.ch.ms(str, listMs);
            try {
                com.bytedance.sdk.openadsdk.core.ab.ms.ms("lqmt", "readcache-getCacheMeta cost: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                if (xrVarMs == null) {
                    com.bytedance.sdk.openadsdk.core.ab.ms.ms("lqmt", "readcache-cacheMeta: null ");
                    if (abVar != null) {
                        abVar.d(0);
                        abVar.xr(1);
                        abVar.ms("no cache");
                    }
                    interfaceC0286ms.ms();
                    return;
                }
                String str2 = xrVarMs.ka;
                String strXr = xr(str, str2);
                com.bytedance.sdk.openadsdk.core.ab.ms.ms("lqmt", "readcache-mapkey: " + strXr);
                xr xrVar2 = c.get(strXr);
                if (xrVar2 != null && xrVar2.xr > 1) {
                    com.bytedance.sdk.openadsdk.core.ab.ms.ms("lqmt", "readcache-cacheRecord != null && cacheRecord.status > CACHE_STATUS_NOUSE");
                    if (abVar != null) {
                        abVar.d(0);
                        abVar.xr(1);
                        abVar.ms("no cache");
                    }
                    interfaceC0286ms.ms();
                    return;
                }
                ms(strXr, str, str2, 2);
                com.bytedance.sdk.openadsdk.core.nw.ms msVar = op.ms.ms(new JSONObject(com.bytedance.sdk.component.utils.ms.ah(xrVarMs.ah))).x;
                c cVar2 = new c(msVar, true);
                lm lmVar = (msVar == null || msVar.xr() == null || msVar.xr().isEmpty()) ? null : msVar.xr().get(0);
                if (lmVar != null) {
                    cVar2.ms(lmVar);
                }
                com.bytedance.sdk.openadsdk.core.ab.ms.ms("lqmt", "readcache-updateMemoryRecord start >>  rit: " + str + "  reqId: " + str2);
                if (com.bytedance.sdk.openadsdk.core.live.xr.ms().ah(lmVar) != 3) {
                    cVar = cVar2;
                } else {
                    cVar2.ms((lm) null);
                }
                interfaceC0286ms.ms(cVar);
                boolean zCh = com.bytedance.sdk.openadsdk.core.ah.ka.ms().ch();
                com.bytedance.sdk.openadsdk.core.ab.ms.ms("lqmt", "isSplashCacheRemoveChange: " + zCh);
                if (zCh) {
                    return;
                }
                ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ms.ah.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            long jCurrentTimeMillis2 = System.currentTimeMillis();
                            ah.this.ch.ms(str, xrVarMs.ka);
                            com.bytedance.sdk.openadsdk.core.ab.ms.ms("lqmt", "readcache-deleteCacheMeta start >>  rit: " + str + "  reqId: " + xrVarMs.ka + "  cost: " + (System.currentTimeMillis() - jCurrentTimeMillis2));
                        } catch (Exception unused) {
                        }
                    }
                });
            } catch (Throwable unused) {
                xrVar = xrVarMs;
                xrVarMs = xrVar;
            }
        } catch (Throwable unused2) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.ms.ms
    public void ms(com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.d<ny, ab> dVar, final lm lmVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, boolean z) {
        if (lmVar == null || xrVar == null) {
            return;
        }
        if (this.ch == null) {
            xr();
        }
        try {
            com.bytedance.sdk.openadsdk.core.ab.ms.ms("lqmt", "removeCache>> start ");
            final String strD = xrVar.d();
            String strEu = lmVar.eu();
            String strXr = xr(strD, strEu);
            if (this.ka.get()) {
                com.bytedance.sdk.openadsdk.core.ab.ms.ms("lqmt", "removeCache-mIsRemoveCacheAd: true");
                return;
            }
            this.ka.set(true);
            ms(strXr, strD, strEu, 3);
            com.bytedance.sdk.openadsdk.core.ab.ms.ms("lqmt", "removeCache-updateMemoryRecord: 完成");
            ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ms.ah.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        ah.this.ch.ms(strD, lmVar.eu());
                        com.bytedance.sdk.openadsdk.core.ab.ms.ms("lqmt", "removeCache-deleteCacheMeta  rit: " + strD + "  cost: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                    } catch (Throwable unused) {
                    }
                }
            });
            if (dVar != null) {
                dVar.ms();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.ms.ms
    public void ah() {
        if (this.ch == null) {
            xr();
        }
        if (this.ch != null) {
            this.ch.ms();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.ms.ms
    public void ms(String str, String str2, boolean z, boolean z2, Object obj) {
        if (c() != 3 || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        if (z2 || !z) {
            ms(str, str2);
        } else {
            ms(obj, str, str2);
        }
    }

    private void ms(final Runnable runnable) {
        if (com.bytedance.sdk.openadsdk.op.ab.ms()) {
            com.bytedance.sdk.component.ch.ab.xr(new com.bytedance.sdk.component.ch.ny("") { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ms.ah.4
                @Override // java.lang.Runnable
                public void run() {
                    runnable.run();
                }
            });
        } else {
            runnable.run();
        }
    }

    private List<String> ms(String str) {
        List<String> list = ab.get(str);
        com.bytedance.sdk.openadsdk.core.ab.ms.ms("lqmt", "getUsedReqIdList: list : " + (list == null ? 0 : list.size()));
        return list;
    }

    private void ms(String str, String str2, String str3, int i) {
        int iC = c();
        com.bytedance.sdk.openadsdk.core.ab.ms.ms("lqmt", "updateMemoryRecord>> start rit: " + str2 + ", status: " + i + ", cacheStrategyType: " + iC);
        if (iC != 3) {
            return;
        }
        c.put(str, new xr(str3, i, str2));
        if (i <= 1) {
            com.bytedance.sdk.openadsdk.core.ab.ms.ms("lqmt", "updateMemoryRecord>> :status <= CACHE_STATUS_NOUSE");
            return;
        }
        List<String> copyOnWriteArrayList = ab.get(str2);
        com.bytedance.sdk.openadsdk.core.ab.ms.ms("lqmt", "updateMemoryRecord>>: list1 : " + (copyOnWriteArrayList == null ? 0 : copyOnWriteArrayList.size()));
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            copyOnWriteArrayList.add(str3);
        } else if (copyOnWriteArrayList.contains(str3)) {
            return;
        } else {
            copyOnWriteArrayList.add(str3);
        }
        com.bytedance.sdk.openadsdk.core.ab.ms.ms("lqmt", "updateMemoryRecord>>: list2 : " + copyOnWriteArrayList.size());
        ab.put(str2, copyOnWriteArrayList);
    }

    private void ms(Object obj, String str, String str2) {
        try {
            xr xrVar = c.get(xr(str, str2));
            if (xrVar != null && obj != null) {
                PhantomReference phantomReference = new PhantomReference(obj, x);
                com.bytedance.sdk.openadsdk.core.ab.ms.ms("lqmt", xrVar.ah + "，uuid：" + xrVar.f2437ms + " watching");
                ny.put(phantomReference, xrVar);
            }
        } catch (Exception unused) {
        }
    }

    private void ka() {
        if (c() != 3) {
            return;
        }
        try {
            for (Reference<? extends Object> referencePoll = x.poll(); referencePoll != null; referencePoll = x.poll()) {
                xr xrVar = ny.get(referencePoll);
                if (xrVar != null) {
                    ms(xrVar.ah, xrVar.f2437ms);
                }
                ny.remove(referencePoll);
            }
        } catch (Exception unused) {
        }
    }

    private void ms(String str, String str2) {
        c.remove(xr(str, str2));
        List<String> list = ab.get(str);
        com.bytedance.sdk.openadsdk.core.ab.ms.ms("lqmt", "checkCaches>>: list1 : " + (list == null ? 0 : list.size()));
        if (list == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.ab.ms.ms("lqmt", "checkCaches>>: rmCache : " + str2);
        list.remove(str2);
        ab.put(str, list);
    }

    private static int c() {
        if (x.ah() == null) {
            return 1;
        }
        return x.ah().d();
    }

    private String xr(String str, String str2) {
        return str + str2;
    }
}
