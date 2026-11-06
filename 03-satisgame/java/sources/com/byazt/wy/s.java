package com.byazt.wy;

import android.util.Pair;
import com.anythink.core.common.f.e;
import com.byazt.qp.d;
import com.byazt.qp.tj;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1896, 8})
public class s {
    public tj n;
    public final com.byazt.qp.n qg;

    public void n(tj tjVar) {
        this.n = tjVar;
    }

    public s(com.byazt.qp.n nVar) {
        this.qg = nVar;
    }

    public Object n(d dVar, com.byazt.vf.n nVar, Object obj, Function function, boolean z) {
        return n(dVar, nVar, obj, function, z, false);
    }

    private Object n(d dVar, com.byazt.vf.n nVar, Object obj, Function function, boolean z, boolean z2) {
        if (obj.getClass().getClassLoader() == com.byazt.qp.n.class.getClassLoader() && !dVar.n.isAssignableFrom(obj.getClass())) {
            Object objN = dVar.n(nVar);
            if (this.n != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt(e.a.b, dVar.w);
                    jSONObject.putOpt(LiveConfigKey.ORIGIN, obj.getClass().getName());
                    jSONObject.putOpt("memoryProxyService", objN);
                    jSONObject.putOpt("apiClazz", dVar.n.getName());
                    Map<String, Object> mapN = this.qg.l().n();
                    if (mapN != null) {
                        for (String str : mapN.keySet()) {
                            Object obj2 = mapN.get(str);
                            if (obj2 instanceof Pair) {
                                Pair pair = (Pair) obj2;
                                jSONObject.putOpt(str + "_create", pair.first);
                                jSONObject.putOpt(str, pair.second);
                            } else {
                                jSONObject.putOpt(str, obj2);
                            }
                        }
                    }
                    jSONObject.putOpt("allServices", mapN);
                } catch (JSONException unused) {
                }
                this.n.n(5, jSONObject.toString(), new RuntimeException("service not match"));
            }
            if (objN != null) {
                return objN;
            }
            return null;
        }
        Object objN2 = n(dVar, nVar, obj, z2);
        if (z) {
            dVar.n(objN2, nVar);
            if (function != null) {
                dVar.n(function);
                dVar.n(com.byazt.lx.n.n(function, dVar.w));
            } else {
                dVar.n(dVar.s);
            }
        }
        return objN2;
    }

    public Object qg(d dVar, com.byazt.vf.n nVar, Object obj, Function function, boolean z) {
        return n(dVar, nVar, obj, function, z, true);
    }

    private Object n(d dVar, com.byazt.vf.n nVar, Object obj, boolean z) {
        Object objNewInstance;
        int i = 0;
        try {
            if (dVar.qg.isInstance(obj)) {
                return obj;
            }
            if (dVar.n.isInstance(obj)) {
                return dVar.qg.getDeclaredConstructor(dVar.n).newInstance(obj);
            }
            if (obj instanceof Function) {
                if (dVar.rv && z) {
                    objNewInstance = dVar.qg.getDeclaredConstructor(Function.class, dVar.n).newInstance(obj, this.qg.s().n(dVar, nVar, false).second);
                    i = 1;
                } else {
                    objNewInstance = dVar.qg.getDeclaredConstructor(Function.class).newInstance(obj);
                    i = 2;
                }
                try {
                    tj tjVar = this.n;
                    if (tjVar != null) {
                        tjVar.n(dVar, i, obj, objNewInstance);
                        return objNewInstance;
                    }
                    obj = objNewInstance;
                } catch (Throwable th) {
                    obj = objNewInstance;
                    th = th;
                    tj tjVar2 = this.n;
                    if (tjVar2 != null) {
                        tjVar2.n(dVar, i, "reuse failed", th);
                    }
                }
            } else {
                tj tjVar3 = this.n;
                if (tjVar3 != null) {
                    tjVar3.n(dVar, 0, "service not instanceof Function:".concat(String.valueOf(obj)), (Throwable) null);
                }
            }
            return obj;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
