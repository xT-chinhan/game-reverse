package com.byazt.jk;

import android.util.Pair;
import com.byazt.zs.g;
import com.byazt.zs.k;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1123, 20})
public class hn {
    public final com.byazt.zs.pr hw;
    public k pr;

    public void pr(k kVar) {
        this.pr = kVar;
    }

    public hn(com.byazt.zs.pr prVar) {
        this.hw = prVar;
    }

    public Object pr(g gVar, com.byazt.vkw.pr prVar, Object obj, Function function, boolean z) {
        return pr(gVar, prVar, obj, function, z, false);
    }

    private Object pr(g gVar, com.byazt.vkw.pr prVar, Object obj, Function function, boolean z, boolean z2) {
        if (obj.getClass().getClassLoader() == com.byazt.zs.pr.class.getClassLoader() && !gVar.pr.isAssignableFrom(obj.getClass())) {
            Object objPr = gVar.pr(prVar);
            if (this.pr != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("key", gVar.uc);
                    jSONObject.putOpt(LiveConfigKey.ORIGIN, obj.getClass().getName());
                    jSONObject.putOpt("memoryProxyService", objPr);
                    jSONObject.putOpt("apiClazz", gVar.pr.getName());
                    Map<String, Object> mapPr = this.hw.fw().pr();
                    if (mapPr != null) {
                        for (String str : mapPr.keySet()) {
                            Object obj2 = mapPr.get(str);
                            if (obj2 instanceof Pair) {
                                Pair pair = (Pair) obj2;
                                jSONObject.putOpt(str + "_create", pair.first);
                                jSONObject.putOpt(str, pair.second);
                            } else {
                                jSONObject.putOpt(str, obj2);
                            }
                        }
                    }
                    jSONObject.putOpt("allServices", mapPr);
                } catch (JSONException e) {
                }
                this.pr.pr(5, jSONObject.toString(), new RuntimeException("service not match"));
            }
            if (objPr != null) {
                return objPr;
            }
            return null;
        }
        Object objPr2 = pr(gVar, prVar, obj, z2);
        if (z) {
            gVar.pr(objPr2, prVar);
            if (function != null) {
                gVar.pr(function);
                gVar.pr(com.byazt.vs.pr.pr(function, gVar.uc));
            } else {
                gVar.pr(gVar.hn);
            }
        }
        return objPr2;
    }

    public Object hw(g gVar, com.byazt.vkw.pr prVar, Object obj, Function function, boolean z) {
        return pr(gVar, prVar, obj, function, z, true);
    }

    private Object pr(g gVar, com.byazt.vkw.pr prVar, Object obj, boolean z) {
        try {
            if (gVar.hw.isInstance(obj)) {
                return obj;
            }
            if (gVar.pr.isInstance(obj)) {
                return gVar.hw.getDeclaredConstructor(gVar.pr).newInstance(obj);
            }
            if (obj instanceof Function) {
                if (gVar.aj && z) {
                    obj = gVar.hw.getDeclaredConstructor(Function.class, gVar.pr).newInstance(obj, this.hw.c().pr(gVar, prVar, false).second);
                } else {
                    obj = gVar.hw.getDeclaredConstructor(Function.class).newInstance(obj);
                }
                if (this.pr != null) {
                    return obj;
                }
            } else {
                k kVar = this.pr;
                if (kVar != null) {
                    kVar.pr(gVar, 0, "service not instanceof Function:".concat(String.valueOf(obj)), null);
                }
            }
            return obj;
        } catch (Throwable th) {
            k kVar2 = this.pr;
            if (kVar2 != null) {
                kVar2.pr(gVar, 0, "reuse failed", th);
            }
            return obj;
        }
    }
}
