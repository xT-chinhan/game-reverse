package com.byazt.np;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATBiddingNotice;
import com.anythink.core.common.l.f;
import com.byazt.vy.hd;
import com.byazt.vy.py;
import com.byazt.vy.sz;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.api.model.AdnName;
import java.lang.ref.SoftReference;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 20, 26})
public abstract class qg implements com.byazt.jg.n {
    public SoftReference<Context> fs;
    public String l;
    public com.byazt.kv.qg oa;
    public com.byazt.sg.s q;
    public com.byazt.kt.w rv;
    public com.byazt.zb.qg s;
    public com.byazt.mi.qg sz;
    public com.byazt.qn.qg w;
    public com.byazt.ws.qg x;
    public boolean tj = false;
    public int cp = 0;
    public volatile boolean d = false;
    public final Comparator<com.byazt.ws.tj> n = new Comparator<com.byazt.ws.tj>() { // from class: com.byazt.np.qg.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public int compare(com.byazt.ws.tj tjVar, com.byazt.ws.tj tjVar2) {
            int iH;
            int iH2;
            if (tjVar.h() == tjVar2.h()) {
                iH = tjVar.t();
                iH2 = tjVar2.t();
            } else {
                iH = tjVar.h();
                iH2 = tjVar2.h();
            }
            return iH - iH2;
        }
    };
    public final Comparator<com.byazt.ws.tj> k = new Comparator<com.byazt.ws.tj>() { // from class: com.byazt.np.qg.2
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public int compare(com.byazt.ws.tj tjVar, com.byazt.ws.tj tjVar2) {
            if (tjVar.m() > tjVar2.m()) {
                return -1;
            }
            return tjVar.m() < tjVar2.m() ? 1 : 0;
        }
    };
    public final Comparator<com.byazt.ws.tj> qg = new Comparator<com.byazt.ws.tj>() { // from class: com.byazt.np.qg.3
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public int compare(com.byazt.ws.tj tjVar, com.byazt.ws.tj tjVar2) {
            if (tjVar.hu() > tjVar2.hu()) {
                return -1;
            }
            return tjVar.hu() < tjVar2.hu() ? 1 : 0;
        }
    };

    @Override // com.byazt.jg.n
    public void fs() {
    }

    @Override // com.byazt.jg.n
    public void n(String str) {
    }

    @Override // com.byazt.jg.n
    public void n(List<com.byazt.sg.s> list, com.byazt.mj.n nVar) {
    }

    @Override // com.byazt.jg.n
    public void qg(com.byazt.mj.n nVar) {
    }

    @Override // com.byazt.jg.n
    public void x() {
    }

    public qg(Context context) {
        this.fs = new SoftReference<>(context);
    }

    public void n(com.byazt.qn.qg qgVar) {
        com.byazt.zb.qg qgVarN = com.byazt.zb.qg.n(this.fs, qgVar, this);
        this.s = qgVarN;
        com.byazt.qn.qg qgVarWm = qgVarN.wm();
        this.w = qgVarWm;
        this.l = qgVarWm.a();
        this.s.v().put("allow_show_close_btn", Boolean.valueOf(qgVar.hd()));
        this.x = this.s.cy();
    }

    public com.byazt.ie.x rv() {
        com.byazt.rb.qg.q(MediationConstant.TAG, "ad load start.....");
        if (com.byazt.qt.qg.n().wo()) {
            com.byazt.gp.s.n((com.byazt.sg.s) null, this.s.wm(), com.byazt.vy.d.n(), 3);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.byazt.ie.cp());
        arrayList.add(new com.byazt.ie.d());
        arrayList.add(new com.byazt.ie.l());
        arrayList.add(new com.byazt.ie.s());
        arrayList.add(new com.byazt.ie.oa());
        arrayList.add(new com.byazt.ie.w());
        arrayList.add(new com.byazt.ie.fs());
        arrayList.add(new com.byazt.ie.qg());
        arrayList.add(new com.byazt.ie.q());
        com.byazt.ie.x xVar = new com.byazt.ie.x(arrayList);
        xVar.n(this.s);
        return xVar;
    }

    public void s() {
        com.byazt.sg.s sVar = this.q;
        if (sVar != null) {
            sVar.cd();
        }
        this.s.oj();
        this.rv = null;
    }

    public List<com.byazt.mj.qg> tj() {
        return this.s.ur();
    }

    public List<com.byazt.mj.s> cp() {
        if (!com.byazt.qt.qg.n().fi()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (com.byazt.sg.s sVar : this.s.sz()) {
            if (sVar != null) {
                arrayList.add(com.byazt.vy.x.n(this.w, sVar, false));
            }
        }
        return arrayList;
    }

    public List<com.byazt.mj.s> d() {
        if (!com.byazt.qt.qg.n().fi()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (com.byazt.sg.s sVar : this.s.n(false)) {
            if (sVar != null) {
                arrayList.add(com.byazt.vy.x.n(this.w, sVar, false));
            }
        }
        return arrayList;
    }

    public void n(com.byazt.sg.s sVar) {
        if (com.byazt.qt.qg.n().wo()) {
            com.byazt.gp.s.n(sVar, this.w, com.byazt.vy.d.n(), 2);
        }
    }

    public static int qg(String str) {
        if (!com.byazt.bf.oa.n().fs(str)) {
            com.byazt.rb.qg.q(MediationConstant.TAG, "--==--: 命中展示频次");
            return 840041;
        }
        if (com.byazt.bf.oa.n().s(str)) {
            return 0;
        }
        com.byazt.rb.qg.q(MediationConstant.TAG, "--==--: 命中展示间隔");
        return 840042;
    }

    public boolean oa() {
        boolean zS = hd.s(com.byazt.qt.qg.getContext());
        boolean zQg = hd.qg(com.byazt.qt.qg.getContext());
        com.byazt.rb.qg.qg(MediationConstant.TAG, com.byazt.rb.q.n(this.l) + "setting 下发是否为弱网执行：" + com.byazt.qt.qg.n().a() + "，当前网络环境：2G-type=" + zS + ",3G-type=" + zQg);
        if (com.byazt.qt.qg.n().a()) {
            return zS || zQg;
        }
        return false;
    }

    @DungeonFlag
    public void n(List<com.byazt.sg.s> list) {
        boolean z;
        if (list == null || list.size() == 0) {
            return;
        }
        com.byazt.vp.n.n(this.w, this.x, list, this.s.sz());
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            q((com.byazt.sg.s) it.next());
        }
        if (this.s.sz().size() == 0) {
            return;
        }
        ArrayList<com.byazt.sg.s> arrayList2 = new ArrayList();
        arrayList2.addAll(this.s.sz());
        com.byazt.sg.s sVarS = s(list);
        for (com.byazt.sg.s sVar : arrayList2) {
            Iterator<com.byazt.sg.s> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z = true;
                    break;
                }
                com.byazt.sg.s next = it2.next();
                if (next != null && sVar != null && next == sVar) {
                    z = false;
                    break;
                }
            }
            if (z) {
                n(sVarS, sVar, 1);
            }
        }
    }

    private com.byazt.sg.s s(com.byazt.sg.s sVar) {
        LinkedList<com.byazt.sg.s> linkedList = new LinkedList();
        com.byazt.zb.qg qgVar = this.s;
        if (qgVar != null) {
            if (qgVar.sz() != null && this.s.sz().size() != 0) {
                linkedList.addAll(this.s.sz());
            }
            if (this.s.d() != null && this.s.d().size() != 0) {
                linkedList.addAll(this.s.d());
            }
            if (this.s.cp() != null && this.s.cp().size() != 0) {
                linkedList.addAll(this.s.cp());
            }
        }
        com.byazt.sg.s sVar2 = null;
        if (linkedList.size() != 0 && sVar != null) {
            double dTa = Double.MIN_NORMAL;
            for (com.byazt.sg.s sVar3 : linkedList) {
                if (sVar3.ta() < sVar.ta() && sVar3.ta() > dTa) {
                    dTa = sVar3.ta();
                    sVar2 = sVar3;
                }
            }
        }
        return sVar2;
    }

    private com.byazt.sg.s s(List<com.byazt.sg.s> list) {
        com.byazt.sg.s sVar = null;
        if (list != null && list.size() != 0) {
            if (list.size() == 1) {
                return list.get(0);
            }
            double dTa = Double.MIN_NORMAL;
            for (com.byazt.sg.s sVar2 : list) {
                if (sVar2.ta() > dTa) {
                    dTa = sVar2.ta();
                    sVar = sVar2;
                }
            }
        }
        return sVar;
    }

    @DungeonFlag
    private void q(com.byazt.sg.s sVar) {
        if (sVar == null || this.w == null) {
            return;
        }
        if (TextUtils.equals(sVar.ci(), MediationConstant.ADN_XIAOMI)) {
            HashMap map = new HashMap();
            map.put("ecpm", Long.valueOf((long) sVar.ta()));
            sVar.qg(map);
            return;
        }
        if (this.w.j()) {
            if (sVar.nk() || sVar.o() || sVar.dm()) {
                HashMap map2 = new HashMap();
                if (TextUtils.equals(sVar.ci(), "baidu")) {
                    if (com.byazt.qt.qg.n().fl()) {
                        com.byazt.sg.s sVarS = s(sVar);
                        map2.put("ecpm", Integer.valueOf(sVarS != null ? (int) sVarS.ta() : 0));
                        map2.put("adn", 10);
                        map2.put("ad_t", 7);
                        map2.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                        map2.put("bid_t", 3);
                    } else if (com.byazt.qt.qg.n().i()) {
                        com.byazt.sg.s sVarS2 = s(sVar);
                        int iTa = sVarS2 != null ? (int) sVarS2.ta() : 0;
                        int iTa2 = (int) sVar.ta();
                        int iNextInt = new SecureRandom().nextInt(21) + 10;
                        com.byazt.rb.qg.qg(MediationConstant.TAG, "-------baidu_bid_win firstAdEcpm = " + iTa2 + " secondAdEcpm =" + iTa + " randomNumber = " + iNextInt);
                        map2.put("ecpm", Integer.valueOf(Math.max(iTa2 - iNextInt, iTa)));
                        map2.put("adn", 10);
                        map2.put("ad_t", 7);
                        map2.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                        map2.put("bid_t", 4);
                    } else {
                        map2.put("ecpm", 0);
                        map2.put("adn", 10);
                        map2.put("ad_t", 7);
                        map2.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                        map2.put("bid_t", 4);
                    }
                } else if (TextUtils.equals(sVar.ci(), MediationConstant.ADN_KS)) {
                    if (com.byazt.qt.qg.n().dw()) {
                        com.byazt.sg.s sVarS3 = s(sVar);
                        map2.put("bidEcpm", Double.valueOf(sVar.ta()));
                        map2.put("lossBidEcpm", Double.valueOf(sVarS3 != null ? sVarS3.ta() : 0.0d));
                    } else {
                        map2.put("bidEcpm", 0);
                        map2.put("lossBidEcpm", 0);
                    }
                }
                sVar.qg(map2);
            }
        }
    }

    @DungeonFlag
    public void n(com.byazt.sg.s sVar, com.byazt.sg.s sVar2, int i) {
        if (sVar2 == null || this.w == null || i <= 0) {
            return;
        }
        if (TextUtils.equals(sVar2.ci(), MediationConstant.ADN_XIAOMI)) {
            HashMap map = new HashMap();
            map.put("ecpm", Long.valueOf(sVar != null ? (long) sVar.ta() : 0L));
            map.put(MediationConstant.KEY_REASON, "其他");
            map.put(ATBiddingNotice.ADN_ID, 1);
            sVar2.n((Map<String, Object>) map);
            return;
        }
        if (this.w.j()) {
            HashMap map2 = new HashMap();
            map2.put(MediationConstant.BIDDING_LOSE_REASON, com.byazt.lpr.qg.n(i));
            map2.put("bidding_lose_reason_NUM", Integer.valueOf(i));
            if (TextUtils.equals(sVar2.ci(), "baidu")) {
                if (com.byazt.qt.qg.n().fl()) {
                    map2.put("ecpm", Integer.valueOf(sVar != null ? (int) sVar.ta() : 0));
                    map2.put("adn", 10);
                    map2.put("ad_t", 7);
                    map2.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                    map2.put("bid_t", 3);
                    map2.put(MediationConstant.KEY_REASON, 203);
                    map2.put(f.bh, 1);
                    map2.put("is_c", 2);
                } else if (com.byazt.qt.qg.n().i()) {
                    map2.put("ecpm", Integer.valueOf(sVar != null ? (int) sVar.ta() : 0));
                    map2.put("adn", 10);
                    map2.put("ad_t", 7);
                    map2.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                    map2.put("bid_t", 4);
                    map2.put(MediationConstant.KEY_REASON, 203);
                    map2.put(f.bh, 1);
                    map2.put("is_c", 2);
                } else {
                    map2.put("ecpm", 0);
                    map2.put("adn", 10);
                    map2.put("ad_t", 7);
                    map2.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                    map2.put("bid_t", 4);
                    map2.put(MediationConstant.KEY_REASON, 203);
                    map2.put(f.bh, 1);
                    map2.put("is_c", 2);
                }
            } else if (TextUtils.equals(sVar2.ci(), MediationConstant.ADN_KS)) {
                if (com.byazt.qt.qg.n().dw()) {
                    map2.put("failureCode", 2);
                    map2.put("bidEcpm", Double.valueOf(sVar != null ? sVar.ta() : 0.0d));
                    map2.put("adType", 2);
                    map2.put(MediationConstant.KEY_ADN_NAME, AdnName.OTHER);
                } else {
                    map2.put("failureCode", 0);
                    map2.put("bidEcpm", 0);
                    map2.put("adType", 2);
                    map2.put(MediationConstant.KEY_ADN_NAME, AdnName.OTHER);
                }
            }
            sVar2.n((Map<String, Object>) map2);
        }
    }

    public HashMap<String, com.byazt.sg.s> qg(List<com.byazt.sg.s> list) {
        HashMap<String, com.byazt.sg.s> map = new HashMap<>();
        if (list != null && list.size() > 0) {
            for (com.byazt.sg.s sVar : list) {
                if (sVar != null) {
                    map.put(sVar.el(), sVar);
                }
            }
        }
        return map;
    }

    public void qg(com.byazt.sg.s sVar) {
        com.byazt.qn.qg qgVar = this.w;
        int iFs = sVar.fs(qgVar != null ? qgVar.n() : null);
        sVar.rv(3);
        sVar.tj(iFs);
    }

    public List<com.byazt.ws.tj> qg() {
        boolean z;
        List<com.byazt.ws.tj> arrayList = new ArrayList<>();
        com.byazt.zb.qg qgVar = this.s;
        if (qgVar == null || this.x == null || qgVar.tj()) {
            return arrayList;
        }
        Map<Integer, List<com.byazt.ws.tj>> mapUr = this.x.ur();
        ArrayList arrayList2 = new ArrayList();
        for (Integer num : mapUr.keySet()) {
            if (num != null) {
                arrayList2.add(num);
            }
        }
        com.byazt.sq.qg.n(arrayList2);
        int i = 0;
        if (arrayList2.size() > 0) {
            int i2 = 0;
            z = false;
            while (i < arrayList2.size()) {
                Integer num2 = (Integer) arrayList2.get(i);
                if (num2 != null) {
                    int iIntValue = num2.intValue();
                    if (iIntValue == -100) {
                        i2 = 1;
                    }
                    if (iIntValue < -100) {
                        z = true;
                    }
                    if (mapUr.get(Integer.valueOf(iIntValue)) != null) {
                        arrayList.addAll(mapUr.get(Integer.valueOf(iIntValue)));
                    }
                }
                i++;
            }
            i = i2;
        } else {
            z = false;
        }
        if (i == 0 && this.x.j() && !py.qg(this.s.sz())) {
            for (com.byazt.sg.s sVar : this.s.sz()) {
                if (this.x != null && (sVar.nk() || sVar.o())) {
                    com.byazt.ws.tj tjVarW = this.x.w(sVar.el());
                    if (tjVarW != null) {
                        arrayList.add(tjVarW);
                    }
                }
            }
        }
        if (!z) {
            List<com.byazt.ws.tj> listSz = sz();
            if (!py.n(listSz)) {
                arrayList.addAll(listSz);
            }
        }
        Iterator<com.byazt.ws.tj> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                it.remove();
            }
        }
        if (this.x.v() || this.x.j()) {
            return l(arrayList);
        }
        if (q(arrayList)) {
            Collections.sort(arrayList, this.qg);
            return arrayList;
        }
        Collections.sort(arrayList, this.n);
        return arrayList;
    }

    private boolean q(List<com.byazt.ws.tj> list) {
        Iterator<com.byazt.ws.tj> it = list.iterator();
        while (it.hasNext()) {
            if (!TextUtils.isEmpty(it.next().wm())) {
                return true;
            }
        }
        return false;
    }

    private List<com.byazt.ws.tj> l(List<com.byazt.ws.tj> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<com.byazt.ws.tj> it = list.iterator();
        while (it.hasNext()) {
            com.byazt.ws.tj next = it.next();
            if (next.an()) {
                it.remove();
                arrayList2.add(next);
            } else if (next.v() || next.ae() || next.j()) {
                it.remove();
                com.byazt.ws.tj tjVar = new com.byazt.ws.tj();
                tjVar.l(next.cd());
                tjVar.tj(next.um());
                tjVar.s(next.k());
                tjVar.q(next.fs());
                tjVar.n(next.x());
                tjVar.cp(next.h());
                tjVar.d(next.t());
                tjVar.rv(next.oa());
                tjVar.x(new StringBuilder().append(next.m()).toString());
                tjVar.qg(next.sz());
                tjVar.fs(next.ur());
                tjVar.rv(next.bb());
                tjVar.n(next.ln());
                tjVar.w(next.wm());
                com.byazt.sg.s sVarN = n(tjVar);
                if (sVarN != null) {
                    tjVar.x(new StringBuilder().append(sVarN.np()).toString());
                }
                arrayList.add(tjVar);
            }
        }
        list.addAll(arrayList);
        Collections.sort(list, this.qg);
        Collections.sort(arrayList2, this.n);
        list.addAll(0, arrayList2);
        return list;
    }

    private com.byazt.sg.s n(com.byazt.ws.tj tjVar) {
        if (tjVar == null) {
            return null;
        }
        String strCd = tjVar.cd();
        String strS = tjVar.ln() != null ? tjVar.ln().s() : null;
        if (TextUtils.isEmpty(strCd)) {
            return null;
        }
        for (com.byazt.sg.s sVar : this.s.cp()) {
            if (sVar != null && strCd.equals(sVar.el())) {
                return sVar;
            }
        }
        for (com.byazt.sg.s sVar2 : this.s.d()) {
            if (sVar2 != null && strCd.equals(sVar2.el())) {
                return sVar2;
            }
        }
        for (com.byazt.sg.s sVar3 : this.s.sz()) {
            if (sVar3 != null) {
                if (sVar3.dm() && !TextUtils.isEmpty(strS) && !TextUtils.isEmpty(sVar3.fi())) {
                    if (strCd.equals(sVar3.el()) && strS.equals(sVar3.fi())) {
                        return sVar3;
                    }
                } else if (strCd.equals(sVar3.el())) {
                    return sVar3;
                }
            }
        }
        return null;
    }

    public List<com.byazt.ws.tj> sz() {
        com.byazt.ws.qg qgVar = this.x;
        if (qgVar == null || qgVar.y() == null || this.x.y().size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (com.byazt.ws.tj tjVar : this.x.y()) {
            if (tjVar != null && tjVar.um() == 100) {
                arrayList.add(tjVar);
            }
        }
        return arrayList;
    }

    public com.byazt.mj.s f_() {
        if (this.q == null || com.byazt.vy.tj.n()) {
            return null;
        }
        return com.byazt.vy.x.n(this.w, this.q, true);
    }

    public com.byazt.mj.s k() {
        List<com.byazt.sg.s> listN;
        com.byazt.qn.qg qgVar = this.w;
        if ((qgVar != null && !qgVar.nf() && !com.byazt.qt.qg.n().fi()) || (listN = this.s.n(true)) == null || listN.size() == 0) {
            return null;
        }
        return com.byazt.vy.x.n(this.w, listN.get(0), false);
    }

    public int cy() {
        com.byazt.sg.s sVar = this.q;
        if (sVar != null) {
            return sVar.z();
        }
        return -1;
    }

    public Map<String, Object> hd() {
        com.byazt.sg.s sVar = this.q;
        Map<String, Object> mapBb = sVar != null ? sVar.bb() : null;
        if (mapBb == null) {
            mapBb = s(this.l);
        }
        com.byazt.sg.s sVar2 = this.q;
        if (sVar2 != null && sVar2.dh() != null) {
            mapBb.putAll(this.q.dh());
        }
        if (this.w.an() != null) {
            mapBb.putAll(this.w.an());
        }
        if (com.byazt.vy.tj.n()) {
            String strN = com.byazt.vy.tj.n(com.byazt.vy.x.n(this.w, this.q, true));
            if (!TextUtils.isEmpty(strN)) {
                mapBb.put("get_show_ecpm_info", strN);
            }
        }
        return mapBb;
    }

    public static Map<String, Object> s(String str) {
        sz szVar = new sz();
        szVar.put(MediationConstant.KEY_GM_PRIME_RIT, str);
        return szVar;
    }

    public int cd() {
        com.byazt.qn.qg qgVar = this.w;
        if (qgVar != null) {
            return qgVar.l();
        }
        return 0;
    }

    public com.byazt.qn.qg um() {
        return this.w;
    }

    public void n(com.byazt.kv.qg qgVar) {
        this.oa = qgVar;
    }

    public void n(com.byazt.mi.qg qgVar) {
        this.sz = qgVar;
    }

    public int a() {
        com.byazt.sg.s sVar = this.q;
        if (sVar == null || this.s == null) {
            return 0;
        }
        return TextUtils.equals(sVar.el(), this.s.qg()) ? 1 : 0;
    }
}
