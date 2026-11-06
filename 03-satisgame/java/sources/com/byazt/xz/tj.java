package com.byazt.xz;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 774, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj implements d {
    public boolean cp;
    public boolean d;
    public sz fs;
    public com.byazt.ih.s l;
    public boolean oa;
    public Map<String, List<com.byazt.et.qg>> q;
    public n qg;
    public com.byazt.uy.n rv;
    public Map<String, List<com.byazt.et.qg>> s;
    public boolean tj;
    public com.byazt.vh.w w;
    public k x;
    public boolean sz = true;
    public final Set<com.byazt.et.qg> k = Collections.newSetFromMap(new IdentityHashMap());
    public Handler n = new Handler(Looper.getMainLooper());

    public tj(com.byazt.ih.s sVar, n nVar) {
        this.l = sVar;
        this.qg = nVar;
        if (nVar != null) {
            this.s = nVar.n;
            this.q = nVar.qg;
        }
        com.byazt.ih.s sVar2 = this.l;
        if (sVar2 != null && sVar2.nf() && this.rv == null) {
            this.rv = new com.byazt.uy.n();
        }
    }

    public void n(com.byazt.vh.w wVar) {
        this.w = wVar;
    }

    public void n(k kVar) {
        this.x = kVar;
    }

    public void n(sz szVar) {
        this.fs = szVar;
    }

    public cy n() {
        com.byazt.ih.s sVar = this.l;
        if (sVar == null || sVar.f() == null) {
            return null;
        }
        return this.l.f().s();
    }

    private String cp() {
        com.byazt.ih.s sVar = this.l;
        if (sVar == null || sVar.f() == null) {
            return null;
        }
        return this.l.f().q();
    }

    private Set<String> d() {
        com.byazt.ih.s sVar = this.l;
        if (sVar == null || sVar.f() == null) {
            return null;
        }
        return this.l.f().l();
    }

    private boolean n(com.byazt.et.qg qgVar) {
        cy cyVarN;
        return (qgVar == null || qgVar.x() == null || (cyVarN = n()) == null || !cyVarN.n(qgVar.x(), qgVar.tj())) ? false : true;
    }

    private boolean n(com.byazt.et.qg qgVar, Object... objArr) {
        cy cyVarN = n();
        if (cyVarN == null) {
            return false;
        }
        x xVarCp = qgVar.cp();
        Map<String, Object> mapS = (xVarCp == null || xVarCp.n() == null) ? null : xVarCp.n().s();
        HashMap map = new HashMap();
        if (objArr != null && objArr.length > 0) {
            map.put("args", objArr);
        }
        com.byazt.ih.s sVar = this.l;
        if (sVar != null) {
            map.put("viewAttachTime", Long.valueOf(sVar.wm()));
            map.put("view", this.l.rv());
        }
        map.put("lastEventInView", Boolean.valueOf(this.sz));
        map.put("eventMonitor", qgVar);
        return cyVarN.n(cp(), qgVar.x(), qgVar.hashCode(), mapS, map, new qg(this, this.l, qgVar));
    }

    private void qg(com.byazt.et.qg qgVar) {
        cy cyVarN = n();
        if (cyVarN == null || qgVar == null || !this.k.add(qgVar)) {
            return;
        }
        cyVarN.n(cp(), qgVar.x(), qgVar.tj(), qgVar.fs(), new qg(this, this.l, qgVar));
    }

    public void qg() {
        Map<String, List<com.byazt.et.qg>> map;
        n nVar = this.qg;
        if (nVar == null || (map = nVar.n) == null || map.isEmpty()) {
            return;
        }
        for (List<com.byazt.et.qg> list : map.values()) {
            if (list != null) {
                for (com.byazt.et.qg qgVar : list) {
                    if (qgVar != null && !"timer".equals(qgVar.x()) && n(qgVar)) {
                        qg(qgVar);
                    }
                }
            }
        }
    }

    public void n(boolean z) {
        this.sz = z;
        sz szVar = this.fs;
        if (szVar != null) {
            szVar.n("lastEventInView", Boolean.valueOf(z));
        }
    }

    public void s() {
        List<com.byazt.et.qg> listL = l("shake");
        if (listL == null || listL.isEmpty()) {
            return;
        }
        for (com.byazt.et.qg qgVar : listL) {
            if (qgVar != null) {
                qgVar.n(this);
                qgVar.n(new Object[0]);
            }
        }
    }

    public void q() {
        List<com.byazt.et.qg> listL = l("twist");
        if (listL == null || listL.isEmpty()) {
            return;
        }
        for (com.byazt.et.qg qgVar : listL) {
            if (qgVar != null) {
                qgVar.n(this);
                qgVar.n(new Object[0]);
            }
        }
    }

    public void l() {
        List<com.byazt.et.qg> value;
        n nVar = this.qg;
        if (nVar == null) {
            return;
        }
        for (Map.Entry<String, List<com.byazt.et.qg>> entry : nVar.n.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null && !value.isEmpty()) {
                for (com.byazt.et.qg qgVar : value) {
                    if (qgVar instanceof com.byazt.et.s) {
                        qgVar.n(this);
                        qgVar.n(new Object[0]);
                    }
                }
            }
        }
    }

    public void w() {
        List<com.byazt.et.qg> listL = l("animateState");
        if (listL == null || listL.isEmpty()) {
            return;
        }
        for (com.byazt.et.qg qgVar : listL) {
            if (qgVar != null) {
                if (n(qgVar)) {
                    qg(qgVar);
                } else {
                    qgVar.n(this);
                    qgVar.n(new Object[0]);
                }
            }
        }
    }

    public void x() {
        Set<String> setD = d();
        if (setD == null || setD.isEmpty()) {
            return;
        }
        Iterator<String> it = setD.iterator();
        while (it.hasNext()) {
            List<com.byazt.et.qg> listL = l(it.next());
            if (listL != null && !listL.isEmpty()) {
                for (com.byazt.et.qg qgVar : listL) {
                    if (n(qgVar)) {
                        qg(qgVar);
                    }
                }
            }
        }
    }

    public void fs() {
        List<com.byazt.et.qg> listL = l("timerState");
        if (listL == null || listL.isEmpty()) {
            return;
        }
        for (com.byazt.et.qg qgVar : listL) {
            if (qgVar != null) {
                qgVar.n(this);
                qgVar.n(new Object[0]);
            }
        }
    }

    public void rv() {
        List<com.byazt.et.qg> listL = l("timer");
        if (listL != null) {
            String.valueOf(listL.size());
        }
        if (listL == null || listL.isEmpty()) {
            return;
        }
        for (com.byazt.et.qg qgVar : listL) {
            if (qgVar != null) {
                if (n(qgVar)) {
                    n(qgVar, new Object[0]);
                } else {
                    qgVar.n(this);
                    qgVar.n(new Object[0]);
                }
            }
        }
    }

    public void n(int i) {
        List<com.byazt.et.qg> listL = l("timer");
        if (listL == null || listL.isEmpty()) {
            return;
        }
        cy cyVarN = n();
        String strCp = cp();
        for (com.byazt.et.qg qgVar : listL) {
            if (qgVar != null) {
                if (cyVarN != null && n(qgVar)) {
                    cyVarN.n(strCp, qgVar.x(), qgVar.hashCode(), i);
                } else if (qgVar instanceof com.byazt.et.x) {
                    ((com.byazt.et.x) qgVar).n(i);
                }
            }
        }
    }

    public void qg(boolean z) {
        List<com.byazt.et.qg> listL = l("timer");
        if (listL == null || listL.isEmpty()) {
            return;
        }
        cy cyVarN = n();
        String strCp = cp();
        for (com.byazt.et.qg qgVar : listL) {
            if (qgVar != null) {
                if (cyVarN != null && n(qgVar)) {
                    cyVarN.n(strCp, qgVar.x(), qgVar.hashCode(), z);
                } else if (qgVar instanceof com.byazt.et.x) {
                    ((com.byazt.et.x) qgVar).n(z);
                }
            }
        }
    }

    public void n(String str) {
        List<com.byazt.et.qg> listL = l("timer");
        if (listL == null || listL.isEmpty()) {
            return;
        }
        if (str == null) {
            str = "";
        }
        cy cyVarN = n();
        String strCp = cp();
        for (com.byazt.et.qg qgVar : listL) {
            if (qgVar != null) {
                if (cyVarN != null && n(qgVar)) {
                    cyVarN.n(strCp, qgVar.x(), qgVar.hashCode(), str);
                } else if (qgVar instanceof com.byazt.et.x) {
                    com.byazt.et.x xVar = (com.byazt.et.x) qgVar;
                    if (TextUtils.equals(str, xVar.l())) {
                        xVar.n();
                    }
                }
            }
        }
    }

    public void qg(String str) {
        List<com.byazt.et.qg> listL = l("timer");
        if (listL == null || listL.isEmpty()) {
            return;
        }
        if (str == null) {
            str = "";
        }
        cy cyVarN = n();
        String strCp = cp();
        for (com.byazt.et.qg qgVar : listL) {
            if (qgVar != null) {
                if (cyVarN != null && n(qgVar)) {
                    cyVarN.qg(strCp, qgVar.x(), qgVar.hashCode(), str);
                } else if (qgVar instanceof com.byazt.et.x) {
                    com.byazt.et.x xVar = (com.byazt.et.x) qgVar;
                    if (TextUtils.equals(str, xVar.l())) {
                        xVar.qg();
                    }
                }
            }
        }
    }

    public void s(String str) {
        List<com.byazt.et.qg> listL = l("timer");
        if (listL == null || listL.isEmpty()) {
            return;
        }
        if (str == null) {
            str = "";
        }
        cy cyVarN = n();
        String strCp = cp();
        for (com.byazt.et.qg qgVar : listL) {
            if (qgVar != null) {
                if (cyVarN != null && n(qgVar)) {
                    cyVarN.s(strCp, qgVar.x(), qgVar.hashCode(), str);
                } else if (qgVar instanceof com.byazt.et.x) {
                    com.byazt.et.x xVar = (com.byazt.et.x) qgVar;
                    if (TextUtils.equals(str, xVar.l())) {
                        xVar.s();
                    }
                }
            }
        }
    }

    public void q(String str) {
        List<com.byazt.et.qg> listL = l("timer");
        if (listL == null || listL.isEmpty()) {
            return;
        }
        if (str == null) {
            str = "";
        }
        cy cyVarN = n();
        String strCp = cp();
        for (com.byazt.et.qg qgVar : listL) {
            if (qgVar != null) {
                if (cyVarN != null && n(qgVar)) {
                    cyVarN.q(strCp, qgVar.x(), qgVar.hashCode(), str);
                } else if (qgVar instanceof com.byazt.et.x) {
                    com.byazt.et.x xVar = (com.byazt.et.x) qgVar;
                    if (TextUtils.equals(str, xVar.l())) {
                        xVar.q();
                    }
                }
            }
        }
    }

    public boolean n(MotionEvent motionEvent) {
        List<com.byazt.et.qg> listL = l("touchStart");
        if (listL != null && !listL.isEmpty()) {
            for (com.byazt.et.qg qgVar : listL) {
                if (qgVar instanceof com.byazt.et.cp) {
                    if (n(qgVar)) {
                        n(qgVar, motionEvent);
                    } else {
                        qgVar.n(this);
                        qgVar.n(motionEvent);
                    }
                }
            }
        }
        List<com.byazt.et.qg> listL2 = l("touchEnd");
        List<com.byazt.et.qg> listL3 = l("tap");
        List<com.byazt.et.qg> listL4 = l("longTap");
        List<com.byazt.et.qg> listL5 = l("slide");
        if (listL2 != null && !listL2.isEmpty()) {
            for (com.byazt.et.qg qgVar2 : listL2) {
                if (qgVar2 instanceof com.byazt.et.tj) {
                    if (n(qgVar2)) {
                        this.oa = n(qgVar2, motionEvent);
                    } else {
                        qgVar2.n(this);
                        this.oa = qgVar2.n(motionEvent);
                    }
                }
            }
        }
        if ((listL3 == null || listL3.isEmpty()) && ((listL5 == null || listL5.isEmpty()) && (listL4 == null || listL4.isEmpty()))) {
            return this.oa;
        }
        if (this.oa && motionEvent.getAction() == 1) {
            return true;
        }
        com.byazt.uy.n nVar = this.rv;
        if (nVar != null) {
            if (nVar.n(motionEvent)) {
                return false;
            }
            this.rv.n(this.l, motionEvent);
        }
        if (listL3 != null && !listL3.isEmpty()) {
            for (com.byazt.et.qg qgVar3 : listL3) {
                if (qgVar3 instanceof com.byazt.et.w) {
                    if (n(qgVar3)) {
                        this.tj = n(qgVar3, motionEvent);
                    } else {
                        ((com.byazt.et.w) qgVar3).n(this.x);
                        qgVar3.n(this);
                        this.tj = qgVar3.n(motionEvent);
                    }
                }
            }
        }
        if (listL4 != null && !listL4.isEmpty()) {
            for (com.byazt.et.qg qgVar4 : listL4) {
                if (n(qgVar4)) {
                    this.cp = n(qgVar4, motionEvent);
                }
            }
        }
        int action = motionEvent.getAction();
        if ((action == 1 || action == 3) && (this.tj || this.cp)) {
            com.byazt.uy.n nVar2 = this.rv;
            if (nVar2 != null) {
                nVar2.n();
            }
            return true;
        }
        if (listL5 != null && !listL5.isEmpty()) {
            for (com.byazt.et.qg qgVar5 : listL5) {
                if (qgVar5 instanceof com.byazt.et.l) {
                    if (n(qgVar5)) {
                        this.d = n(qgVar5, motionEvent);
                    } else {
                        ((com.byazt.et.l) qgVar5).n(this.fs);
                        qgVar5.n(this);
                        this.d = qgVar5.n(motionEvent);
                    }
                }
            }
        }
        if (action == 1 || action == 3) {
            if (this.d) {
                com.byazt.uy.n nVar3 = this.rv;
                if (nVar3 != null) {
                    nVar3.n();
                }
                return true;
            }
            com.byazt.uy.n nVar4 = this.rv;
            if (nVar4 != null) {
                nVar4.n(this.l);
            }
        }
        return this.tj || this.d || this.cp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str, List<x.n> list) {
        n(str, list, (Map<String, Object>) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str, List<x.n> list, Map<String, Object> map) {
        com.byazt.ss.n nVarN;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (x.n nVar : list) {
            if (nVar != null) {
                x.n nVarN2 = n(nVar, n(map));
                if (n(nVarN2) && (nVarN = com.byazt.ss.n.C0336n.n(this.l, str, nVarN2)) != null) {
                    nVarN.n();
                    nVarN.qg();
                }
            }
        }
    }

    private boolean n(x.n nVar) {
        if (nVar == null) {
            return false;
        }
        Map<String, Object> mapS = nVar.s();
        if (mapS == null || !mapS.containsKey("exec_condition")) {
            return true;
        }
        Object objRemove = mapS.remove("exec_condition");
        return objRemove != null && Boolean.parseBoolean(String.valueOf(objRemove));
    }

    private JSONObject n(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            com.byazt.ih.s sVar = this.l;
            JSONObject jSONObjectTj = sVar == null ? null : sVar.tj();
            if (jSONObjectTj != null) {
                Iterator<String> itKeys = jSONObjectTj.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObject.put(next, jSONObjectTj.opt(next));
                }
            }
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    if (entry.getKey() != null) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                }
            }
        } catch (JSONException unused) {
        }
        com.byazt.ih.s sVar2 = this.l;
        com.byazt.vh.sz szVarF = sVar2 != null ? sVar2.f() : null;
        return szVarF != null ? szVarF.l(jSONObject) : jSONObject;
    }

    private x.n n(x.n nVar, JSONObject jSONObject) {
        x.n nVarN;
        String strL = nVar.l();
        if (!TextUtils.isEmpty(strL) && strL.contains("${") && (nVarN = oa.n(com.byazt.mcb.qg.qg(strL, jSONObject), (JSONObject) null)) != null) {
            nVarN.s(nVar.x());
            return nVarN;
        }
        x.n nVar2 = new x.n();
        nVar2.n(nVar.n());
        nVar2.qg(nVar.qg());
        nVar2.q(nVar.w());
        nVar2.s(nVar.l());
        nVar2.s(nVar.x());
        Map<String, Object> mapQ = nVar.q();
        Map<String, Object> mapS = mapQ == null ? nVar.s() : mapQ;
        if (mapS != null) {
            HashMap map = new HashMap(mapS.size());
            for (Map.Entry<String, Object> entry : mapS.entrySet()) {
                Object value = entry.getValue();
                if (value instanceof String) {
                    map.put(entry.getKey(), com.byazt.mcb.qg.qg((String) value, jSONObject));
                } else {
                    map.put(entry.getKey(), value);
                }
            }
            nVar2.n(map);
        }
        nVar2.qg(mapQ != null ? new HashMap(mapQ) : null);
        return nVar2;
    }

    public List<com.byazt.et.qg> l(String str) {
        Map<String, List<com.byazt.et.qg>> map;
        Map<String, List<com.byazt.et.qg>> map2 = this.s;
        if (((map2 == null || map2.isEmpty()) && ((map = this.q) == null || map.isEmpty())) || TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, List<com.byazt.et.qg>> map3 = this.s;
        if (map3 != null && map3.containsKey(str)) {
            return this.s.get(str);
        }
        Map<String, List<com.byazt.et.qg>> map4 = this.q;
        if (map4 != null && map4.containsKey(str)) {
            return this.q.get(str);
        }
        return null;
    }

    public List<com.byazt.et.qg> w(String str) {
        Map<String, List<com.byazt.et.qg>> map;
        Map<String, List<com.byazt.et.qg>> map2 = this.q;
        if (map2 == null || map2.isEmpty() || TextUtils.isEmpty(str) || (map = this.q) == null || !map.containsKey(str)) {
            return null;
        }
        return this.q.get(str);
    }

    public void n(String str, Object... objArr) {
        List<com.byazt.et.qg> listW = w(str);
        if (listW == null || listW.isEmpty()) {
            return;
        }
        for (com.byazt.et.qg qgVar : listW) {
            if (n(qgVar)) {
                n(qgVar, objArr);
            } else {
                qgVar.n(this);
                qgVar.n(objArr);
            }
        }
    }

    public Map<String, List<com.byazt.et.qg>> tj() {
        return this.s;
    }

    @Override // com.byazt.xz.d
    public void n(final com.byazt.ih.s sVar, final String str, final List<x.n> list, x xVar) {
        if (xVar.s()) {
            return;
        }
        final int iQ = xVar.q();
        if (iQ > 0) {
            this.n.postDelayed(new com.byazt.hb.tj(new Runnable() { // from class: com.byazt.xz.tj.1
                @Override // java.lang.Runnable
                public void run() {
                    if (tj.this.w != null) {
                        tj.this.w.n(sVar, str, list);
                    }
                    tj.this.n(str, (List<x.n>) list);
                }
            }), iQ);
            return;
        }
        com.byazt.vh.w wVar = this.w;
        if (wVar != null) {
            wVar.n(sVar, str, list);
        }
        n(str, list);
    }

    public void n(final com.byazt.ih.s sVar, final String str, final List<x.n> list, x xVar, final Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            n(sVar, str, list, xVar);
            return;
        }
        if (xVar.s()) {
            return;
        }
        int iQ = xVar.q();
        if (iQ > 0) {
            this.n.postDelayed(new com.byazt.hb.tj(new Runnable() { // from class: com.byazt.xz.tj.2
                @Override // java.lang.Runnable
                public void run() {
                    if (tj.this.w != null) {
                        tj.this.w.n(sVar, str, list);
                    }
                    tj.this.n(str, (List<x.n>) list, (Map<String, Object>) map);
                }
            }), iQ);
            return;
        }
        com.byazt.vh.w wVar = this.w;
        if (wVar != null) {
            wVar.n(sVar, str, list);
        }
        n(str, list, map);
    }

    public static tj n(com.byazt.ih.s sVar, String str) {
        com.byazt.et.qg qgVarN;
        if (sVar != null && !TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() <= 0) {
                    return null;
                }
                n nVar = new n(new HashMap(), new HashMap(), new HashMap());
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null && (qgVarN = com.byazt.et.qg.n.n(sVar.rv().getContext(), sVar, jSONObjectOptJSONObject, sVar.tj())) != null) {
                        if (nVar.n.containsKey(qgVarN.x())) {
                            List<com.byazt.et.qg> list = nVar.n.get(qgVarN.x());
                            if (list == null) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(qgVarN);
                                nVar.n.put(qgVarN.x(), arrayList);
                                nVar.qg.put(qgVarN.tj(), arrayList);
                            } else {
                                list.add(qgVarN);
                            }
                        } else {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(qgVarN);
                            nVar.n.put(qgVarN.x(), arrayList2);
                            nVar.qg.put(qgVarN.tj(), arrayList2);
                        }
                        nVar.s.put(qgVarN.rv(), qgVarN);
                    }
                }
                return new tj(sVar, nVar);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    @com.byazt.cp.n(n = {0, 1, 774, 855})
    public static class n {
        public Map<String, List<com.byazt.et.qg>> n;
        public Map<String, List<com.byazt.et.qg>> qg;
        public Map<String, com.byazt.et.qg> s;

        public n(Map<String, List<com.byazt.et.qg>> map, Map<String, com.byazt.et.qg> map2, Map<String, List<com.byazt.et.qg>> map3) {
            this.n = map;
            this.s = map2;
            this.qg = map3;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 774, 765})
    private static class qg implements l {
        public final WeakReference<tj> n;
        public final WeakReference<com.byazt.ih.s> qg;
        public final WeakReference<com.byazt.et.qg> s;

        public qg(tj tjVar, com.byazt.ih.s sVar, com.byazt.et.qg qgVar) {
            this.n = new WeakReference<>(tjVar);
            this.qg = new WeakReference<>(sVar);
            this.s = new WeakReference<>(qgVar);
        }

        @Override // com.byazt.xz.l
        public void n() {
            tj tjVar = this.n.get();
            com.byazt.ih.s sVar = this.qg.get();
            com.byazt.et.qg qgVar = this.s.get();
            if (tjVar == null || sVar == null || qgVar == null) {
                return;
            }
            x xVarCp = qgVar.cp();
            List<x.n> listQg = xVarCp == null ? null : xVarCp.qg();
            if (xVarCp == null || listQg == null) {
                return;
            }
            tjVar.n(sVar, qgVar.x(), listQg, xVarCp);
        }

        @Override // com.byazt.xz.l
        public void n(Map<String, Object> map) {
            tj tjVar = this.n.get();
            com.byazt.ih.s sVar = this.qg.get();
            com.byazt.et.qg qgVar = this.s.get();
            if (tjVar == null || sVar == null || qgVar == null) {
                return;
            }
            x xVarCp = qgVar.cp();
            List<x.n> listQg = xVarCp == null ? null : xVarCp.qg();
            if (xVarCp == null || listQg == null) {
                return;
            }
            if (map == null || map.isEmpty()) {
                tjVar.n(sVar, qgVar.x(), listQg, xVarCp);
            } else {
                tjVar.n(sVar, qgVar.x(), listQg, xVarCp, map);
            }
        }
    }
}
