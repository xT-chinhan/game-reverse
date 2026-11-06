package com.byazt.qa;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.byazt.jp.oa;
import com.byazt.ws.tj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 944, 5})
public class q extends com.byazt.tp.n {
    public static volatile q n;
    public List<String> cp;
    public int d;
    public int oa;
    public final Map<String, Integer> qg = new HashMap();
    public final Map<String, Long> s = new HashMap();
    public final Map<String, com.byazt.qn.qg> q = new HashMap();
    public final Map<String, ConcurrentHashMap<String, List<x>>> l = new HashMap();
    public final Map<String, Map<String, com.byazt.mj.n>> w = new HashMap();
    public final Map<String, Boolean> x = new HashMap();
    public final Map<String, com.byazt.qa.qg> fs = new HashMap();
    public boolean rv = false;
    public int tj = 20;

    public interface qg {
        void n(boolean z);
    }

    public interface s {
        void n(String str, boolean z, int i, List<com.byazt.sg.s> list);
    }

    private q() {
    }

    public static q n() {
        if (n == null) {
            synchronized (q.class) {
                if (n == null) {
                    n = new q();
                }
            }
        }
        return n;
    }

    public void n(String str, int i) {
        this.qg.put(str, Integer.valueOf(i));
    }

    public int qg(String str, int i) {
        Integer num;
        if (i == 2 || (num = this.qg.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public boolean s(String str, int i) {
        int iQg = qg(str, i);
        return iQg == 2 || iQg == 3 || iQg == 4;
    }

    public void n(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.s.put(str, Long.valueOf(j));
    }

    public Long n(String str) {
        return this.s.get(str);
    }

    public void n(String str, com.byazt.qn.qg qgVar) {
        if (qgVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.q.put(str, qgVar);
    }

    public com.byazt.qn.qg qg(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.q.get(str);
    }

    public com.byazt.qa.qg s(String str) {
        return this.fs.get(str);
    }

    public void n(String str, x xVar) {
        if (n(str) == null || n(str).longValue() == xVar.n()) {
            ConcurrentHashMap<String, List<x>> concurrentHashMap = this.l.get(str);
            String strEl = xVar.n.el();
            if (TextUtils.isEmpty(strEl)) {
                return;
            }
            if (concurrentHashMap == null) {
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                copyOnWriteArrayList.add(xVar);
                ConcurrentHashMap<String, List<x>> concurrentHashMap2 = new ConcurrentHashMap<>();
                concurrentHashMap2.put(strEl, copyOnWriteArrayList);
                this.l.put(str, concurrentHashMap2);
                return;
            }
            List<x> list = concurrentHashMap.get(strEl);
            if (list == null) {
                CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
                copyOnWriteArrayList2.add(xVar);
                concurrentHashMap.put(strEl, copyOnWriteArrayList2);
                return;
            }
            list.add(xVar);
        }
    }

    public boolean n(String str, com.byazt.qn.qg qgVar, String str2) {
        boolean z;
        this.x.put(str, Boolean.FALSE);
        com.byazt.qa.qg qgVar2 = this.fs.get(str);
        if (qgVar2 == null) {
            return false;
        }
        List<tj> listQg = qgVar2.qg();
        if (com.byazt.rb.qg.qg()) {
            for (tj tjVar : listQg) {
                com.byazt.rb.qg.n(MediationConstant.TAG, com.byazt.rb.q.n(str) + "waterfall: " + tjVar.k() + ", loadSort: " + tjVar.h() + ", showSort: " + tjVar.t() + ", eCpm: " + tjVar.m());
            }
        }
        boolean[] zArr = {true};
        String strN = n(listQg, str, qgVar, qgVar2, zArr);
        qg(str, qgVar);
        ConcurrentHashMap<String, List<x>> concurrentHashMap = this.l.get(str);
        if (concurrentHashMap == null) {
            z = false;
            break;
        }
        int i = 0;
        while (true) {
            if (i >= listQg.size()) {
                z = false;
                break;
            }
            List<x> list = concurrentHashMap.get(listQg.get(i).cd());
            if (list != null && list.size() > 0) {
                z = true;
                break;
            }
            i++;
        }
        if (strN != null) {
            if (z) {
                com.byazt.gp.s.n(this.q.get(str), strN);
            } else {
                qgVar.qg(3);
                if (zArr[0]) {
                    qgVar.qg(1);
                }
                com.byazt.gp.s.n(qgVar, strN);
            }
        }
        return z;
    }

    private String n(List<tj> list, String str, com.byazt.qn.qg qgVar, com.byazt.qa.qg qgVar2, boolean[] zArr) {
        List<x> list2;
        if (list.size() <= 0) {
            return null;
        }
        ConcurrentHashMap<String, List<x>> concurrentHashMap = this.l.get(str);
        if (concurrentHashMap != null && (list2 = concurrentHashMap.get(list.get(0).cd())) != null && list2.size() > 0 && list2.get(0) != null) {
            x xVar = list2.get(0);
            if (n(xVar, xVar.q(), qgVar, "聚合预请求") == -1) {
                com.byazt.rb.qg.n(MediationConstant.TAG, com.byazt.rb.q.n(str) + "--==-- 命中最优广告： " + xVar.n.lq() + ", loadSort: " + xVar.n.la() + ", showSort: " + xVar.n.il());
                return null;
            }
        }
        List<com.byazt.qa.n> listN = n(list, str, concurrentHashMap, qgVar, qgVar2, zArr);
        if (listN.size() > 0) {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < listN.size(); i++) {
                sb.append(listN.get(i).n());
                if (i == listN.size() - 1) {
                    sb.append("]");
                } else {
                    sb.append(",");
                }
            }
            try {
                String string = new JSONArray(sb.toString()).toString();
                com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(str) + "adCannotUseInfo: " + string);
                return string;
            } catch (JSONException e) {
                com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(str) + "adCannotUseInfo json err: " + e.getMessage());
            }
        }
        return null;
    }

    private void qg(String str, com.byazt.qn.qg qgVar) {
        ConcurrentHashMap<String, List<x>> concurrentHashMap = this.l.get(str);
        if (concurrentHashMap != null) {
            for (String str2 : concurrentHashMap.keySet()) {
                List<x> list = concurrentHashMap.get(str2);
                if (list != null && list.size() > 0 && list.get(0) != null) {
                    x xVar = list.get(0);
                    if (n(xVar, xVar.q(), qgVar, "聚合预缓存") != -1) {
                        concurrentHashMap.remove(str2);
                    }
                }
            }
        }
    }

    private List<com.byazt.qa.n> n(List<tj> list, String str, Map<String, List<x>> map, com.byazt.qn.qg qgVar, com.byazt.qa.qg qgVar2, boolean[] zArr) {
        List<x> list2;
        ArrayList arrayList = new ArrayList();
        int iN = qgVar2.n();
        for (int i = 0; i < list.size() && i < iN; i++) {
            String strCd = list.get(i).cd();
            com.byazt.qa.n nVar = new com.byazt.qa.n();
            nVar.qg(strCd);
            nVar.l(list.get(i).t());
            nVar.q(list.get(i).h());
            x xVar = (map == null || (list2 = map.get(strCd)) == null || list2.size() <= 0) ? null : list2.get(0);
            if (xVar == null || xVar.n == null) {
                Map<String, com.byazt.mj.n> map2 = this.w.get(str);
                com.byazt.mj.n nVar2 = map2 != null ? map2.get(strCd) : null;
                if (nVar2 != null) {
                    nVar.qg(3);
                    nVar.s(nVar2.s);
                    nVar.n(nVar2.q);
                } else {
                    nVar.qg(4);
                }
                arrayList.add(nVar);
            } else {
                nVar.n(xVar.n.nf() ? 1 : 0);
                zArr[0] = false;
                int iN2 = n(xVar, this.q.get(str), qgVar, "预缓存");
                if (iN2 != -1) {
                    nVar.qg(iN2);
                    arrayList.add(nVar);
                }
            }
        }
        return arrayList;
    }

    public List<x> q(String str) {
        ArrayList arrayList = new ArrayList();
        ConcurrentHashMap<String, List<x>> concurrentHashMap = this.l.get(str);
        if (concurrentHashMap != null) {
            Iterator<String> it = concurrentHashMap.keySet().iterator();
            while (it.hasNext()) {
                List<x> list = concurrentHashMap.get(it.next());
                if (list != null && list.size() > 0) {
                    arrayList.addAll(list);
                }
            }
        }
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
        Map<String, com.byazt.mj.n> map = this.w.get(str);
        if (map != null) {
            map.clear();
        }
        return arrayList;
    }

    public void n(final Context context, final String str, final int i) {
        com.byazt.rb.l.n(new Runnable() { // from class: com.byazt.qa.q.1
            @Override // java.lang.Runnable
            public void run() {
                q.this.n(context, str, 2, i, (s) null);
            }
        });
    }

    public void qg(final Context context, final String str, final int i) {
        com.byazt.rb.l.n(new Runnable() { // from class: com.byazt.qa.q.2
            @Override // java.lang.Runnable
            public void run() {
                q.this.n(context, str, 4, i, (s) null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Context context, String str, int i, int i2, s sVar) {
        int iQg = qg(str, i2);
        if (!s(str, i2)) {
            com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(str) + "--==-- 配置未开启预加载缓存，req_type: " + iQg);
            if (sVar != null) {
                sVar.n(str, false, 0, null);
                return;
            }
            return;
        }
        Boolean bool = this.x.get(str);
        if (bool != null && bool.booleanValue()) {
            com.byazt.rb.qg.n(MediationConstant.TAG, com.byazt.rb.q.n(str) + "--==-- 已发起过预缓存，还未使用掉，此次不发起");
            if (sVar != null) {
                sVar.n(str, true, 0, null);
                return;
            }
            return;
        }
        com.byazt.qn.qg qgVar = this.q.get(str);
        if (qgVar == null) {
            com.byazt.rb.qg.n(MediationConstant.TAG, com.byazt.rb.q.n(str) + "--==-- 预缓存取消，adslot为null，rit：" + str);
            return;
        }
        com.byazt.qn.qg qgVar2 = new com.byazt.qn.qg(qgVar);
        com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(str) + "--==-- 预缓存开始请求, req_type: " + iQg);
        com.byazt.qa.qg qgVarN = l.n(context, str, qgVar2.um());
        this.fs.put(str, qgVarN);
        this.x.put(str, Boolean.TRUE);
        qgVar2.q(str);
        qgVar2.qg(i);
        qgVar2.l(3);
        qgVarN.n(context, qgVar2, sVar);
        w(str);
    }

    private static void w(String str) {
        JSONObject jSONObject;
        com.byazt.gwu.l lVarQg = com.byazt.lk.l.qg(com.byazt.qt.n.d().oa(), "gm_tt_ad_mediation_sdk_sp");
        String string = lVarQg.getString("preload_rit_ts", "");
        try {
            if (TextUtils.isEmpty(string)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(string);
            }
            jSONObject.put(str, System.currentTimeMillis());
            lVarQg.n("preload_rit_ts", jSONObject.toString());
        } catch (Throwable unused) {
        }
    }

    public static long l(String str) {
        String string = com.byazt.lk.l.qg(com.byazt.qt.n.d().oa(), "gm_tt_ad_mediation_sdk_sp").getString("preload_rit_ts", "");
        try {
            if (!TextUtils.isEmpty(string)) {
                return new JSONObject(string).optLong(str, -1L);
            }
        } catch (Throwable unused) {
        }
        return -1L;
    }

    public List<String> qg() {
        return this.cp;
    }

    public int s() {
        return this.d;
    }

    public int q() {
        return this.oa;
    }

    public void n(int i) {
        this.tj = i;
    }

    public void n(final Activity activity, final List<oa> list, final int i, final int i2) {
        com.byazt.rb.l.n(new Runnable() { // from class: com.byazt.qa.q.3
            @Override // java.lang.Runnable
            public void run() {
                if (q.this.rv) {
                    com.byazt.rb.qg.n(MediationConstant.TAG, "注意：预加载preload只能调用一次");
                    return;
                }
                if (activity == null) {
                    com.byazt.rb.qg.n(MediationConstant.TAG, "预加载preload传入的activity不能是null");
                    return;
                }
                List list2 = list;
                if (list2 != null && list2.size() > 0) {
                    q.this.rv = true;
                    q.this.d = i;
                    q.this.oa = i2;
                    q.this.cp = new ArrayList();
                    for (oa oaVar : list) {
                        if (oaVar != null && oaVar.qg() != null) {
                            q.this.cp.addAll(oaVar.qg());
                        }
                    }
                    int i3 = i;
                    int i4 = (i3 <= 0 || i3 > 20) ? 2 : i3;
                    int i5 = i2;
                    int i6 = (i5 <= 0 || i5 > 10) ? 2 : i5;
                    List listN = q.this.n((List<oa>) list);
                    if (listN.isEmpty()) {
                        return;
                    }
                    q.this.new n(activity, listN, i4, i6, new qg() { // from class: com.byazt.qa.q.3.1
                        @Override // com.byazt.qa.q.qg
                        public void n(boolean z) {
                            if (z) {
                                return;
                            }
                            com.byazt.cby.l.q().n(q.this.l);
                        }
                    }).n();
                    return;
                }
                com.byazt.rb.qg.n(MediationConstant.TAG, "预加载preload传入的requestInfos不能是null或者size为0");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<oa> n(List<oa> list) {
        ArrayList arrayList = new ArrayList();
        int i = this.tj;
        HashSet hashSet = new HashSet();
        for (oa oaVar : list) {
            if (arrayList.size() >= i) {
                break;
            }
            if (oaVar != null && oaVar.qg() != null) {
                for (String str : oaVar.qg()) {
                    if (arrayList.size() >= i) {
                        break;
                    }
                    if (!TextUtils.isEmpty(str) && !hashSet.contains(str)) {
                        hashSet.add(str);
                        ArrayList arrayList2 = new ArrayList(1);
                        arrayList2.add(str);
                        arrayList.add(new oa(oaVar.n(), arrayList2));
                    }
                }
            }
        }
        return arrayList;
    }

    @com.byazt.cp.n(n = {0, 1, 944, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME})
    private class n {
        public int fs;
        public final List<oa> l;
        public final int q;
        public final Activity qg;
        public final int s;
        public final qg w;
        public int x;

        public static /* synthetic */ int qg(n nVar) {
            int i = nVar.x;
            nVar.x = i - 1;
            return i;
        }

        public static /* synthetic */ int s(n nVar) {
            int i = nVar.fs;
            nVar.fs = i - 1;
            return i;
        }

        public n(Activity activity, List<oa> list, int i, int i2, qg qgVar) {
            this.qg = activity;
            this.l = list;
            this.s = i;
            this.q = i2;
            this.w = qgVar;
            this.x = list.size();
            this.fs = list.size();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n() {
            oa oaVarRemove;
            for (int i = 0; i < this.s; i++) {
                if (this.l.size() > 0 && (oaVarRemove = this.l.remove(0)) != null) {
                    com.byazt.qn.qg qgVarN = oaVarRemove.n();
                    String str = oaVarRemove.qg().get(0);
                    if (qgVarN != null) {
                        if (qgVarN.um() == 1) {
                            com.byazt.rb.qg.q(MediationConstant.TAG, "预加载preload传入的GMAdSlotBase为banner类型，不支持该类型预加载，广告位: ".concat(String.valueOf(str)));
                        } else if (qgVarN.um() == 2) {
                            com.byazt.rb.qg.q(MediationConstant.TAG, "预加载preload传入的GMAdSlotBase为插屏类型，不支持该类型预加载，广告位: ".concat(String.valueOf(str)));
                        } else if (qgVarN.um() == 9) {
                            com.byazt.rb.qg.q(MediationConstant.TAG, "预加载preload传入的GMAdSlotBase为Draw类型，不支持该类型预加载，广告位: ".concat(String.valueOf(str)));
                        } else {
                            q.this.n(str, qgVarN);
                            qgVarN.q(str);
                            com.byazt.ws.qg qgVarN2 = com.byazt.ir.q.n().n(str, 0, 101);
                            if (qgVarN2 != null) {
                                qgVarN.x(qgVarN2.fi());
                            } else if (qgVarN.um() == 8) {
                                qgVarN.x(10);
                            }
                            q.this.n(this.qg, str, 5, 0, new s() { // from class: com.byazt.qa.q.n.1
                                @Override // com.byazt.qa.q.s
                                public void n(String str2, boolean z, int i2, List<com.byazt.sg.s> list) {
                                    n.qg(n.this);
                                    if (!z) {
                                        n.s(n.this);
                                    }
                                    com.byazt.rb.qg.n(MediationConstant.TAG, "--==-- pendingLoadNum: " + n.this.x);
                                    if (n.this.x > 0 || n.this.w == null) {
                                        return;
                                    }
                                    n.this.w.n(n.this.fs <= 0);
                                }
                            });
                        }
                    } else {
                        com.byazt.rb.qg.n(MediationConstant.TAG, "预加载preload传入的GMAdSlotBase为空，广告位：".concat(String.valueOf(str)));
                    }
                }
            }
            if (this.l.size() > 0) {
                com.byazt.rb.l.n(new Runnable() { // from class: com.byazt.qa.q.n.2
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.n();
                    }
                }, ((long) this.q) * 1000);
            }
        }
    }

    public void n(Context context, String str, int i, com.byazt.qn.qg qgVar, com.byazt.sg.s sVar, s sVar2) {
        com.byazt.qa.s sVarN = w.n(i, context, str, qgVar == null ? 0 : qgVar.um());
        if (sVarN != null) {
            com.byazt.rb.qg.q(MediationConstant.TAG, "--==-- 预缓存补充请求发起 reqType: " + i);
            sVarN.n(qgVar, sVar, sVar2);
        }
    }
}
