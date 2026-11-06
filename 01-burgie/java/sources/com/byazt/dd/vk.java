package com.byazt.dd;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_AUDIO_FIRSTSEG_CONNECT_TIME, 50})
public class vk implements k {
    public com.byazt.qi.pr aj;
    public com.byazt.ik.hn c;
    public ho fw;
    public Map<String, List<com.byazt.xv.hw>> hn;
    public pr hw;
    public boolean k;
    public boolean m;
    public com.byazt.ch.uc uc;
    public boolean vk;
    public boolean w;
    public Map<String, List<com.byazt.xv.hw>> x;
    public g zo;
    public boolean g = true;
    public Handler pr = new Handler(Looper.getMainLooper());

    public vk(com.byazt.ik.hn hnVar, pr prVar) {
        this.c = hnVar;
        this.hw = prVar;
        if (prVar != null) {
            this.hn = prVar.pr;
            this.x = prVar.hw;
        }
        com.byazt.ik.hn hnVar2 = this.c;
        if (hnVar2 != null && hnVar2.f() && this.aj == null) {
            this.aj = new com.byazt.qi.pr();
        }
    }

    public void pr(com.byazt.ch.uc ucVar) {
        this.uc = ucVar;
    }

    public void pr(ho hoVar) {
        this.fw = hoVar;
    }

    public void pr(g gVar) {
        this.zo = gVar;
    }

    public nt pr() {
        com.byazt.ik.hn hnVar = this.c;
        if (hnVar == null || hnVar.ls() == null) {
            return null;
        }
        return this.c.ls().hn();
    }

    private String vk() {
        com.byazt.ik.hn hnVar = this.c;
        if (hnVar == null || hnVar.ls() == null) {
            return null;
        }
        return this.c.ls().x();
    }

    private Set<String> w() {
        com.byazt.ik.hn hnVar = this.c;
        if (hnVar == null || hnVar.ls() == null) {
            return null;
        }
        return this.c.ls().c();
    }

    private boolean pr(com.byazt.xv.hw hwVar) {
        nt ntVarPr;
        return (hwVar == null || hwVar.fw() == null || (ntVarPr = pr()) == null || !ntVarPr.pr(hwVar.fw(), hwVar.vk())) ? false : true;
    }

    private boolean pr(com.byazt.xv.hw hwVar, Object... objArr) {
        Map<String, Object> mapHn;
        nt ntVarPr = pr();
        if (ntVarPr == null) {
            return false;
        }
        fw fwVarW = hwVar.w();
        if (fwVarW != null && fwVarW.pr() != null) {
            mapHn = fwVarW.pr().hn();
        } else {
            mapHn = null;
        }
        HashMap map = new HashMap();
        if (objArr != null && objArr.length > 0) {
            map.put("args", objArr);
        }
        com.byazt.ik.hn hnVar = this.c;
        if (hnVar != null) {
            map.put("viewAttachTime", Long.valueOf(hnVar.fo()));
            map.put("view", this.c.aj());
        }
        map.put("lastEventInView", Boolean.valueOf(this.g));
        final fw fwVarW2 = hwVar.w();
        final List<fw.pr> listHw = fwVarW2 != null ? fwVarW2.hw() : null;
        final String strFw = hwVar.fw();
        return ntVarPr.pr(vk(), strFw, hwVar.hashCode(), mapHn, map, new c() { // from class: com.byazt.dd.vk.1
            @Override // com.byazt.dd.c
            public void pr() {
                if (fwVarW2 == null || listHw == null) {
                    return;
                }
                vk vkVar = vk.this;
                vkVar.pr(vkVar.c, strFw, listHw, fwVarW2);
            }
        });
    }

    private void hw(final com.byazt.xv.hw hwVar) {
        nt ntVarPr = pr();
        if (ntVarPr != null) {
            ntVarPr.pr(vk(), hwVar.fw(), hwVar.vk(), hwVar.zo(), new c() { // from class: com.byazt.dd.vk.2
                @Override // com.byazt.dd.c
                public void pr() {
                    fw fwVarW = hwVar.w();
                    List<fw.pr> listHw = fwVarW == null ? null : fwVarW.hw();
                    if (fwVarW == null || listHw == null) {
                        return;
                    }
                    vk vkVar = vk.this;
                    vkVar.pr(vkVar.c, hwVar.fw(), listHw, fwVarW);
                }
            });
        }
    }

    public void pr(boolean z) {
        this.g = z;
        g gVar = this.zo;
        if (gVar != null) {
            gVar.pr("lastEventInView", Boolean.valueOf(z));
        }
    }

    public void hw() {
        List<com.byazt.xv.hw> listHw = hw("shake");
        if (listHw == null || listHw.isEmpty()) {
            return;
        }
        for (com.byazt.xv.hw hwVar : listHw) {
            if (hwVar != null) {
                hwVar.pr(this);
                hwVar.pr(new Object[0]);
            }
        }
    }

    public void hn() {
        List<com.byazt.xv.hw> listHw = hw("twist");
        if (listHw == null || listHw.isEmpty()) {
            return;
        }
        for (com.byazt.xv.hw hwVar : listHw) {
            if (hwVar != null) {
                hwVar.pr(this);
                hwVar.pr(new Object[0]);
            }
        }
    }

    public void x() {
        List<com.byazt.xv.hw> value;
        pr prVar = this.hw;
        if (prVar == null) {
            return;
        }
        for (Map.Entry<String, List<com.byazt.xv.hw>> entry : prVar.pr.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null && !value.isEmpty()) {
                for (com.byazt.xv.hw hwVar : value) {
                    if (hwVar instanceof com.byazt.xv.hn) {
                        hwVar.pr(this);
                        hwVar.pr(new Object[0]);
                    }
                }
            }
        }
    }

    public void c() {
        List<com.byazt.xv.hw> listHw = hw("animateState");
        if (listHw == null || listHw.isEmpty()) {
            return;
        }
        for (com.byazt.xv.hw hwVar : listHw) {
            if (hwVar != null) {
                if (pr(hwVar)) {
                    hw(hwVar);
                } else {
                    hwVar.pr(this);
                    hwVar.pr(new Object[0]);
                }
            }
        }
    }

    public void uc() {
        Set<String> setW = w();
        if (setW == null || setW.isEmpty()) {
            return;
        }
        Iterator<String> it = setW.iterator();
        while (it.hasNext()) {
            List<com.byazt.xv.hw> listHw = hw(it.next());
            if (listHw != null && !listHw.isEmpty()) {
                for (com.byazt.xv.hw hwVar : listHw) {
                    if (pr(hwVar)) {
                        hw(hwVar);
                    }
                }
            }
        }
    }

    public void fw() {
        List<com.byazt.xv.hw> listHw = hw("timerState");
        if (listHw == null || listHw.isEmpty()) {
            return;
        }
        for (com.byazt.xv.hw hwVar : listHw) {
            if (hwVar != null) {
                hwVar.pr(this);
                hwVar.pr(new Object[0]);
            }
        }
    }

    public void zo() {
        List<com.byazt.xv.hw> listHw = hw("timer");
        if (listHw == null || listHw.isEmpty()) {
            return;
        }
        for (com.byazt.xv.hw hwVar : listHw) {
            if (hwVar != null) {
                hwVar.pr(this);
                hwVar.pr(new Object[0]);
            }
        }
    }

    public void pr(int i) {
        List<com.byazt.xv.hw> listHw = hw("timer");
        if (listHw == null || listHw.isEmpty()) {
            return;
        }
        for (com.byazt.xv.hw hwVar : listHw) {
            if (hwVar instanceof com.byazt.xv.uc) {
                ((com.byazt.xv.uc) hwVar).pr(i);
            }
        }
    }

    public void hw(boolean z) {
        List<com.byazt.xv.hw> listHw = hw("timer");
        if (listHw == null || listHw.isEmpty()) {
            return;
        }
        for (com.byazt.xv.hw hwVar : listHw) {
            if (hwVar instanceof com.byazt.xv.uc) {
                ((com.byazt.xv.uc) hwVar).pr(z);
            }
        }
    }

    public void pr(String str) {
        List<com.byazt.xv.hw> listHw = hw("timer");
        if (listHw == null || listHw.isEmpty()) {
            return;
        }
        if (str == null) {
            str = "";
        }
        for (com.byazt.xv.hw hwVar : listHw) {
            if (hwVar instanceof com.byazt.xv.uc) {
                com.byazt.xv.uc ucVar = (com.byazt.xv.uc) hwVar;
                if (TextUtils.equals(str, ucVar.hw())) {
                    ucVar.pr();
                }
            }
        }
    }

    public boolean pr(MotionEvent motionEvent) {
        List<com.byazt.xv.hw> listHw = hw("touchStart");
        if (listHw != null && !listHw.isEmpty()) {
            for (com.byazt.xv.hw hwVar : listHw) {
                if (hwVar instanceof com.byazt.xv.vk) {
                    if (pr(hwVar)) {
                        pr(hwVar, motionEvent);
                    } else {
                        hwVar.pr(this);
                        hwVar.pr(motionEvent);
                    }
                }
            }
        }
        List<com.byazt.xv.hw> listHw2 = hw("touchEnd");
        List<com.byazt.xv.hw> listHw3 = hw("tap");
        List<com.byazt.xv.hw> listHw4 = hw("longTap");
        List<com.byazt.xv.hw> listHw5 = hw("slide");
        if (listHw2 != null && !listHw2.isEmpty()) {
            for (com.byazt.xv.hw hwVar2 : listHw2) {
                if (hwVar2 instanceof com.byazt.xv.aj) {
                    if (pr(hwVar2)) {
                        this.m = pr(hwVar2, motionEvent);
                    } else {
                        hwVar2.pr(this);
                        this.m = hwVar2.pr(motionEvent);
                    }
                }
            }
        }
        if ((listHw3 == null || listHw3.isEmpty()) && ((listHw5 == null || listHw5.isEmpty()) && (listHw4 == null || listHw4.isEmpty()))) {
            return this.m;
        }
        if (this.m && motionEvent.getAction() == 1) {
            return true;
        }
        com.byazt.qi.pr prVar = this.aj;
        if (prVar != null) {
            if (prVar.pr(motionEvent)) {
                return false;
            }
            this.aj.pr(this.c, motionEvent);
        }
        if (listHw3 != null && !listHw3.isEmpty()) {
            for (com.byazt.xv.hw hwVar3 : listHw3) {
                if (hwVar3 instanceof com.byazt.xv.c) {
                    if (pr(hwVar3)) {
                        this.vk = pr(hwVar3, motionEvent);
                    } else {
                        ((com.byazt.xv.c) hwVar3).pr(this.fw);
                        hwVar3.pr(this);
                        this.vk = hwVar3.pr(motionEvent);
                    }
                }
            }
        }
        if (listHw4 != null && !listHw4.isEmpty()) {
            for (com.byazt.xv.hw hwVar4 : listHw4) {
                if (pr(hwVar4)) {
                    this.w = pr(hwVar4, motionEvent);
                }
            }
        }
        int action = motionEvent.getAction();
        if ((action == 1 || action == 3) && (this.vk || this.w)) {
            com.byazt.qi.pr prVar2 = this.aj;
            if (prVar2 != null) {
                prVar2.pr();
            }
            return true;
        }
        if (listHw5 != null && !listHw5.isEmpty()) {
            for (com.byazt.xv.hw hwVar5 : listHw5) {
                if (hwVar5 instanceof com.byazt.xv.x) {
                    if (pr(hwVar5)) {
                        this.k = pr(hwVar5, motionEvent);
                    } else {
                        ((com.byazt.xv.x) hwVar5).pr(this.zo);
                        hwVar5.pr(this);
                        this.k = hwVar5.pr(motionEvent);
                    }
                }
            }
        }
        if (action == 1 || action == 3) {
            if (this.k) {
                com.byazt.qi.pr prVar3 = this.aj;
                if (prVar3 != null) {
                    prVar3.pr();
                }
                return true;
            }
            com.byazt.qi.pr prVar4 = this.aj;
            if (prVar4 != null) {
                prVar4.pr(this.c);
            }
        }
        return this.vk || this.k || this.w;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(String str, List<fw.pr> list) {
        com.byazt.tby.pr prVarPr;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (fw.pr prVar : list) {
            if (prVar != null && (prVarPr = com.byazt.tby.pr.C0193pr.pr(this.c, str, prVar)) != null) {
                prVarPr.pr();
                prVarPr.hw();
            }
        }
    }

    public List<com.byazt.xv.hw> hw(String str) {
        Map<String, List<com.byazt.xv.hw>> map;
        Map<String, List<com.byazt.xv.hw>> map2 = this.hn;
        if (((map2 == null || map2.isEmpty()) && ((map = this.x) == null || map.isEmpty())) || TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, List<com.byazt.xv.hw>> map3 = this.hn;
        if (map3 != null && map3.containsKey(str)) {
            return this.hn.get(str);
        }
        Map<String, List<com.byazt.xv.hw>> map4 = this.x;
        if (map4 == null || !map4.containsKey(str)) {
            return null;
        }
        return this.x.get(str);
    }

    public List<com.byazt.xv.hw> hn(String str) {
        Map<String, List<com.byazt.xv.hw>> map;
        Map<String, List<com.byazt.xv.hw>> map2 = this.x;
        if (map2 == null || map2.isEmpty() || TextUtils.isEmpty(str) || (map = this.x) == null || !map.containsKey(str)) {
            return null;
        }
        return this.x.get(str);
    }

    public void pr(String str, Object... objArr) {
        List<com.byazt.xv.hw> listHn = hn(str);
        if (listHn != null && !listHn.isEmpty()) {
            for (com.byazt.xv.hw hwVar : listHn) {
                if (pr(hwVar)) {
                    pr(hwVar, objArr);
                } else {
                    hwVar.pr(this);
                    hwVar.pr(objArr);
                }
            }
        }
    }

    public Map<String, List<com.byazt.xv.hw>> aj() {
        return this.hn;
    }

    @Override // com.byazt.dd.k
    public void pr(final com.byazt.ik.hn hnVar, final String str, final List<fw.pr> list, fw fwVar) {
        if (fwVar.hn()) {
            return;
        }
        final int iX = fwVar.x();
        if (iX > 0) {
            this.pr.postDelayed(new com.byazt.aa.vk(new Runnable() { // from class: com.byazt.dd.vk.3
                @Override // java.lang.Runnable
                public void run() {
                    if (vk.this.uc != null) {
                        vk.this.uc.pr(hnVar, str, list);
                    }
                    vk.this.pr(str, (List<fw.pr>) list);
                }
            }), iX);
            return;
        }
        com.byazt.ch.uc ucVar = this.uc;
        if (ucVar != null) {
            ucVar.pr(hnVar, str, list);
        }
        pr(str, list);
    }

    public static vk pr(com.byazt.ik.hn hnVar, String str) {
        com.byazt.xv.hw hwVarPr;
        if (hnVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() <= 0) {
                return null;
            }
            pr prVar = new pr(new HashMap(), new HashMap(), new HashMap());
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && (hwVarPr = com.byazt.xv.hw.pr.pr(hnVar.aj().getContext(), hnVar, jSONObjectOptJSONObject, hnVar.vk())) != null) {
                    if (prVar.pr.containsKey(hwVarPr.fw())) {
                        List<com.byazt.xv.hw> list = prVar.pr.get(hwVarPr.fw());
                        if (list == null) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(hwVarPr);
                            prVar.pr.put(hwVarPr.fw(), arrayList);
                            prVar.hw.put(hwVarPr.vk(), arrayList);
                        } else {
                            list.add(hwVarPr);
                        }
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(hwVarPr);
                        prVar.pr.put(hwVarPr.fw(), arrayList2);
                        prVar.hw.put(hwVarPr.vk(), arrayList2);
                    }
                    prVar.hn.put(hwVarPr.aj(), hwVarPr);
                }
            }
            return new vk(hnVar, prVar);
        } catch (JSONException e) {
            return null;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_AUDIO_FIRSTSEG_CONNECT_TIME, 590})
    public static class pr {
        public Map<String, com.byazt.xv.hw> hn;
        public Map<String, List<com.byazt.xv.hw>> hw;
        public Map<String, List<com.byazt.xv.hw>> pr;

        public pr(Map<String, List<com.byazt.xv.hw>> map, Map<String, com.byazt.xv.hw> map2, Map<String, List<com.byazt.xv.hw>> map3) {
            this.pr = map;
            this.hn = map2;
            this.hw = map3;
        }
    }
}
