package com.byazt.wy;

import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.anythink.core.common.f.e;
import com.byazt.qp.d;
import com.byazt.qp.tj;
import com.byazt.tk.k;
import com.byazt.vf.hu;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1896, 5})
public class q {
    public volatile hu n;
    public tj qg;

    public void n(tj tjVar) {
        this.qg = tjVar;
    }

    private hu qg() {
        if (this.n == null) {
            this.n = (hu) com.byazt.qp.q.n("m_d_s");
        }
        return this.n;
    }

    public Map<String, Object> n() {
        hu huVarQg = qg();
        if (huVarQg != null) {
            synchronized (huVarQg) {
                Object objN = huVarQg.n(-1);
                if (objN == null) {
                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                    huVarQg.n(-1, concurrentHashMap);
                    return concurrentHashMap;
                }
                if (objN instanceof Map) {
                    return (Map) objN;
                }
                return null;
            }
        }
        k.qg(com.byazt.qp.q.TAG, "provideMemoryService: memoryDataService is null");
        return null;
    }

    private Object n(d dVar) {
        Map<String, Object> mapN = n();
        if (mapN == null) {
            return null;
        }
        String str = dVar.w;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return mapN.get(str);
    }

    public Pair<Function, Object> n(d dVar, com.byazt.vf.n nVar) {
        Map map;
        Object objN = n(dVar);
        if (objN == null) {
            return null;
        }
        if (!dVar.x || nVar == null) {
            if (objN instanceof Pair) {
                Pair<Function, Object> pair = (Pair) objN;
                if (n(dVar, pair)) {
                    return pair;
                }
                return null;
            }
            k.qg(com.byazt.qp.q.TAG, "provideMemoryService:noContextService serviceObj is not Pair, key: " + dVar.w);
            return null;
        }
        if (!(objN instanceof Map) || (map = (Map) objN) == null || map.isEmpty() || TextUtils.isEmpty(nVar.n())) {
            return null;
        }
        Pair<Function, Object> pair2 = (Pair) map.get(nVar.n());
        if (n(dVar, pair2)) {
            return pair2;
        }
        return null;
    }

    private boolean n(d dVar, Pair<Function, Object> pair) {
        return (pair == null || pair.first == null || !dVar.q(com.byazt.lx.n.n((Function) pair.first, dVar.w))) ? false : true;
    }

    public void n(d dVar, com.byazt.vf.n nVar, Object obj, Function function) {
        Map map;
        Map<String, Object> mapN = n();
        if (mapN == null) {
            return;
        }
        String str = dVar.w;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!dVar.n.isAssignableFrom(obj.getClass())) {
            if (this.qg != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt(e.a.b, str);
                    jSONObject.putOpt(LiveConfigKey.ORIGIN, obj.getClass().getName());
                    jSONObject.putOpt("apiClazz", dVar.n.getName());
                    if (function != null) {
                        jSONObject.putOpt("creator", function.getClass().getName());
                    }
                } catch (Exception unused) {
                }
                this.qg.n(6, jSONObject.toString(), new RuntimeException("newService is not assignable to apiClazz"));
                return;
            }
            return;
        }
        Object obj2 = mapN.get(str);
        if (!dVar.x || nVar == null) {
            if (obj2 instanceof Pair) {
                n(dVar, ((Pair) obj2).second, obj);
            }
            mapN.put(str, new Pair(function, obj));
            return;
        }
        String strN = nVar.n();
        if (obj2 instanceof Map) {
            map = (Map) obj2;
            Pair pair = (Pair) map.get(strN);
            if (pair != null) {
                n(dVar, pair.second, obj);
            }
        } else {
            map = new HashMap();
            mapN.put(str, map);
        }
        map.put(strN, new Pair(function, obj));
    }

    public void n(d dVar, com.byazt.qp.n nVar) {
        Map map;
        Pair<Function, Object> pairN;
        Map<String, Object> mapN = n();
        if (mapN == null) {
            return;
        }
        String str = dVar.w;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Object obj = mapN.get(str);
        if (!dVar.x) {
            if (obj instanceof Pair) {
                Pair pair = (Pair) obj;
                int iN = com.byazt.lx.n.n((Function) pair.first, dVar.w);
                if (dVar.s(iN) && iN < dVar.s && (pairN = nVar.s().n(dVar, null, false)) != null) {
                    n(dVar, pair.second, pairN.second);
                    mapN.put(str, pairN);
                    tj tjVar = this.qg;
                    if (tjVar != null) {
                        tjVar.qg(str, pair.second, pairN.second, iN, dVar.s);
                    }
                    nVar.q().n(dVar, null, pairN.second, (Function) pairN.first, true);
                    return;
                }
                return;
            }
            return;
        }
        if (!(obj instanceof Map) || (map = (Map) obj) == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry entry : new ArrayList(map.entrySet())) {
            Pair pair2 = (Pair) entry.getValue();
            int iN2 = com.byazt.lx.n.n((Function) pair2.first, dVar.w);
            if (dVar.s(iN2) && iN2 < dVar.s) {
                n nVarS = nVar.s();
                com.byazt.vf.n nVarN = nVar.n((String) entry.getKey());
                Pair<Function, Object> pairN2 = nVarS.n(dVar, nVarN, false);
                if (pairN2 != null) {
                    n(dVar, pair2.second, pairN2.second);
                    map.put(entry.getKey(), pairN2);
                    tj tjVar2 = this.qg;
                    if (tjVar2 != null) {
                        tjVar2.qg(dVar.w, pair2.second, pairN2.second, iN2, dVar.s);
                    }
                    nVar.q().n(dVar, nVarN, pairN2.second, (Function) pairN2.first, true);
                }
            }
        }
    }

    private void n(d dVar, Object obj, Object obj2) {
        Object objN;
        if (dVar.fs == null || dVar.fs.length <= 0 || (objN = n((Function) obj)) == null) {
            return;
        }
        n((Function) obj2, objN);
    }

    private void n(Function function, Object obj) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, -3);
        sparseArray.put(1, obj);
        function.apply(sparseArray);
    }

    private Object n(Function function) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, -2);
        return function.apply(sparseArray);
    }
}
