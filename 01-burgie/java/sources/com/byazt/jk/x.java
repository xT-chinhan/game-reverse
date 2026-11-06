package com.byazt.jk;

import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.byazt.ca.ho;
import com.byazt.vkw.rc;
import com.byazt.zs.g;
import com.byazt.zs.k;
import com.byazt.zs.uc;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1123, 121})
public class x {
    public k hw;
    public volatile rc pr;

    public void pr(k kVar) {
        this.hw = kVar;
    }

    private rc hw() {
        if (this.pr == null) {
            this.pr = (rc) uc.pr("m_d_s");
        }
        return this.pr;
    }

    public Map<String, Object> pr() {
        rc rcVarHw = hw();
        if (rcVarHw != null) {
            synchronized (rcVarHw) {
                Object objPr = rcVarHw.pr(-1);
                if (objPr == null) {
                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                    rcVarHw.pr(-1, concurrentHashMap);
                    return concurrentHashMap;
                }
                if (objPr instanceof Map) {
                    return (Map) objPr;
                }
                return null;
            }
        }
        ho.hw(uc.TAG, "provideMemoryService: memoryDataService is null");
        return null;
    }

    private Object pr(g gVar) {
        Map<String, Object> mapPr = pr();
        if (mapPr == null) {
            return null;
        }
        String str = gVar.uc;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return mapPr.get(str);
    }

    public Pair<Function, Object> pr(g gVar, com.byazt.vkw.pr prVar) {
        Map map;
        Object objPr = pr(gVar);
        if (objPr == null) {
            return null;
        }
        if (!gVar.fw || prVar == null) {
            if (objPr instanceof Pair) {
                Pair<Function, Object> pair = (Pair) objPr;
                if (!pr(gVar, pair)) {
                    return null;
                }
                return pair;
            }
            ho.hw(uc.TAG, "provideMemoryService:noContextService serviceObj is not Pair, key: " + gVar.uc);
            return null;
        }
        if (!(objPr instanceof Map) || (map = (Map) objPr) == null || map.isEmpty() || TextUtils.isEmpty(prVar.pr())) {
            return null;
        }
        Pair<Function, Object> pair2 = (Pair) map.get(prVar.pr());
        if (!pr(gVar, pair2)) {
            return null;
        }
        return pair2;
    }

    private boolean pr(g gVar, Pair<Function, Object> pair) {
        if (pair == null || pair.first == null || !gVar.hn(com.byazt.vs.pr.pr((Function) pair.first, gVar.uc))) {
            return false;
        }
        return true;
    }

    public void pr(g gVar, com.byazt.vkw.pr prVar, Object obj, Function function) {
        Map map;
        Map<String, Object> mapPr = pr();
        if (mapPr == null) {
            return;
        }
        String str = gVar.uc;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!gVar.pr.isAssignableFrom(obj.getClass())) {
            if (this.hw != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("key", str);
                    jSONObject.putOpt(LiveConfigKey.ORIGIN, obj.getClass().getName());
                    jSONObject.putOpt("apiClazz", gVar.pr.getName());
                    if (function != null) {
                        jSONObject.putOpt("creator", function.getClass().getName());
                    }
                } catch (Exception e) {
                }
                this.hw.pr(6, jSONObject.toString(), new RuntimeException("newService is not assignable to apiClazz"));
                return;
            }
            return;
        }
        Object obj2 = mapPr.get(str);
        if (!gVar.fw || prVar == null) {
            if (obj2 instanceof Pair) {
                pr(gVar, ((Pair) obj2).second, obj);
            }
            mapPr.put(str, new Pair(function, obj));
            return;
        }
        String strPr = prVar.pr();
        if (obj2 instanceof Map) {
            map = (Map) obj2;
            Pair pair = (Pair) map.get(strPr);
            if (pair != null) {
                pr(gVar, pair.second, obj);
            }
        } else {
            map = new HashMap();
            mapPr.put(str, map);
        }
        map.put(strPr, new Pair(function, obj));
    }

    public void pr(g gVar, com.byazt.zs.pr prVar) {
        Map map;
        Pair<Function, Object> pairPr;
        Map<String, Object> mapPr = pr();
        if (mapPr == null) {
            return;
        }
        String str = gVar.uc;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Object obj = mapPr.get(str);
        if (!gVar.fw) {
            if (obj instanceof Pair) {
                Pair pair = (Pair) obj;
                int iPr = com.byazt.vs.pr.pr((Function) pair.first, gVar.uc);
                if (!gVar.hn(iPr) || iPr >= gVar.hn || (pairPr = prVar.c().pr(gVar, null, false)) == null) {
                    return;
                }
                pr(gVar, pair.second, pairPr.second);
                mapPr.put(str, pairPr);
                if (this.hw != null) {
                    Object obj2 = pair.second;
                    Object obj3 = pairPr.second;
                }
                prVar.uc().pr(gVar, null, pairPr.second, (Function) pairPr.first, true);
                return;
            }
            return;
        }
        if ((obj instanceof Map) && (map = (Map) obj) != null && !map.isEmpty()) {
            for (Map.Entry entry : new ArrayList(map.entrySet())) {
                Pair pair2 = (Pair) entry.getValue();
                int iPr2 = com.byazt.vs.pr.pr((Function) pair2.first, gVar.uc);
                if (gVar.hn(iPr2) && iPr2 < gVar.hn) {
                    pr prVarC = prVar.c();
                    com.byazt.vkw.pr prVarPr = prVar.pr((String) entry.getKey());
                    Pair<Function, Object> pairPr2 = prVarC.pr(gVar, prVarPr, false);
                    if (pairPr2 != null) {
                        pr(gVar, pair2.second, pairPr2.second);
                        map.put(entry.getKey(), pairPr2);
                        if (this.hw != null) {
                            Object obj4 = pair2.second;
                            Object obj5 = pairPr2.second;
                        }
                        prVar.uc().pr(gVar, prVarPr, pairPr2.second, (Function) pairPr2.first, true);
                    }
                }
            }
        }
    }

    private void pr(g gVar, Object obj, Object obj2) {
        Object objPr;
        if (gVar.zo != null && gVar.zo.length > 0 && (objPr = pr((Function) obj)) != null) {
            pr((Function) obj2, objPr);
        }
    }

    private void pr(Function function, Object obj) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, -3);
        sparseArray.put(1, obj);
        function.apply(sparseArray);
    }

    private Object pr(Function function) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, -2);
        return function.apply(sparseArray);
    }
}
