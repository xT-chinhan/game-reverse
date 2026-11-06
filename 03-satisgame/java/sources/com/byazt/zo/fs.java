package com.byazt.zo;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.anythink.core.common.f.e;
import com.byazt.tk.k;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 588, 101})
public class fs implements Function<SparseArray<Object>, Object> {
    public Function<SparseArray<Object>, Object> n;
    public Context qg;

    public fs(Context context, Function<SparseArray<Object>, Object> function) {
        this.n = function;
        this.qg = context;
    }

    private PluginValueSet n(PluginValueSet pluginValueSet) {
        JSONArray jSONArray;
        if (pluginValueSet == null) {
            return null;
        }
        String strOu = new com.byazt.zq.qg(pluginValueSet.sparseArray(), com.byazt.vgx.s.qg()).ou();
        try {
            if (TextUtils.isEmpty(strOu)) {
                jSONArray = new JSONArray();
            } else {
                jSONArray = new JSONArray(strOu);
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && TextUtils.equals("personal_ads_type", jSONObjectOptJSONObject.optString(TapEventParamConstants.PARAM_NAME))) {
                    return pluginValueSet;
                }
            }
            JSONObject jSONObject = new JSONObject();
            com.byazt.mt.s sVarQg = com.byazt.qt.n.d().qg();
            if (sVarQg == null) {
                return pluginValueSet;
            }
            String str = sVarQg.x() ? "0" : "1";
            jSONObject.put(TapEventParamConstants.PARAM_NAME, "personal_ads_type");
            jSONObject.put(e.a.d, str);
            jSONArray.put(jSONObject);
            return com.byazt.pch.n.n(pluginValueSet, jSONArray.toString());
        } catch (Throwable unused) {
            return pluginValueSet;
        }
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        qg(sparseArray);
        return null;
    }

    private void qg(final SparseArray<Object> sparseArray) {
        final PluginValueSet pluginValueSetQg = com.byazt.qvu.n.n(sparseArray).qg();
        final int iIntValue = pluginValueSetQg.intValue(-99999982);
        final String strStringValue = pluginValueSetQg.stringValue(260004);
        final Function<SparseArray<Object>, Object> function = (Function) pluginValueSetQg.objectValue(1, Function.class);
        if (!com.byazt.zs.n.n().s()) {
            if (this.n instanceof com.byazt.yn.n) {
                com.byazt.rb.qg.qg("TMe", "load csj 代码位未开启聚合开关");
                ((com.byazt.yn.n) this.n).n(iIntValue, pluginValueSetQg, function);
                return;
            }
            return;
        }
        n.n().n(new com.byazt.kv.q() { // from class: com.byazt.zo.fs.1
            @Override // com.byazt.kv.q
            public void n(boolean z, Map<String, Object> map) {
                fs.this.n(iIntValue, sparseArray, pluginValueSetQg, function, map, z);
            }

            @Override // com.byazt.kv.q
            public int n() {
                return iIntValue;
            }

            @Override // com.byazt.kv.q
            public String qg() {
                return strStringValue;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:161:0x040d  */
    /* JADX WARN: Code duplicated, block: B:163:0x0416  */
    /* JADX WARN: Code duplicated, block: B:165:0x0424  */
    /* JADX WARN: Code duplicated, block: B:167:0x0439  */
    /* JADX WARN: Code duplicated, block: B:16:0x008a  */
    public void n(int i, SparseArray<Object> sparseArray, PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function, Map<String, Object> map, boolean z) {
        boolean z2;
        PluginValueSet pluginValueSetN;
        boolean z3;
        final com.byazt.yy.s sVar;
        com.byazt.rb.qg.qg(MediationConstant.TAG, "CSJM_loadAD Type:".concat(String.valueOf(i)));
        final com.byazt.zr.n nVar = new com.byazt.zr.n(sparseArray);
        com.byazt.zq.qg.n nVar2 = new com.byazt.zq.qg.n(new com.byazt.zq.qg(sparseArray, com.byazt.vgx.s.qg()));
        if (map != null && !map.isEmpty()) {
            nVar2.n(map);
        }
        com.byazt.zs.n.n().n(nVar.fs());
        com.byazt.zq.qg.n nVar3 = new com.byazt.zq.qg.n(new com.byazt.zq.qg(sparseArray, com.byazt.vgx.s.qg()));
        n(nVar, nVar3);
        float fS = nVar.s();
        float fQ = nVar.q();
        if (nVar.n() == 0 || !(fS == 0.0f || nVar.n() == fS)) {
            z2 = false;
        } else {
            nVar2.n(com.byazt.mj.l.qg(this.qg, nVar.n()));
            if (nVar.n() == fS) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        if (nVar.qg() != 0 && ((fS == 0.0f && fQ == 0.0f) || fQ == nVar.qg())) {
            nVar2.qg(com.byazt.mj.l.qg(this.qg, nVar.qg()));
        }
        if (nVar.n() == 0 && fS != 0.0f) {
            nVar2.n(com.byazt.mj.l.n(this.qg, fS));
        }
        if (nVar.qg() == 0 && fQ != 0.0f) {
            nVar2.qg(com.byazt.mj.l.n(this.qg, fQ));
        }
        if (com.byazt.vyf.s.cy().j()) {
            pluginValueSetN = com.byazt.yc.q.n(nVar.l(), nVar2, i);
        } else {
            pluginValueSetN = com.byazt.pch.n.n(nVar2.n());
        }
        final com.byazt.pch.n nVar4 = new com.byazt.pch.n(pluginValueSetN != null ? pluginValueSetN.sparseArray() : new SparseArray<>(), com.byazt.vgx.s.qg());
        PluginValueSet pluginValueSetN2 = n(pluginValueSet, nVar3.n());
        boolean z4 = !TextUtils.isEmpty(nVar4.bb());
        if (i == 1) {
            if (com.byazt.zs.n.n().n(nVar4.q(), 1, z4)) {
                com.byazt.yy.fs fsVar = new com.byazt.yy.fs(function);
                if (!com.byazt.vyf.l.n) {
                    k.qg("TMe", com.byazt.yn.n.NOT_INIT_TIPS_MSG);
                    fsVar.n(10000, com.byazt.yn.n.NOT_INIT_TIPS_MSG);
                    return;
                } else if (z) {
                    fsVar.n(10089, com.byazt.yn.n.GET_CONFIG_TIME_OUT_MSG);
                    return;
                } else {
                    com.byazt.rb.qg.qg("TMe", "load m banner 广告位 = " + nVar.l() + ",ritId:" + nVar4.q());
                    com.byazt.yc.qg.qg(this.qg, nVar4, fsVar, z2);
                    return;
                }
            }
            com.byazt.rb.qg.qg("TMe", "load csj banner 代码位 = " + nVar.l());
            n(i, pluginValueSetN2);
            return;
        }
        if (i == 3) {
            if (com.byazt.zs.n.n().n(nVar4.q(), 3, z4)) {
                com.byazt.rb.qg.qg("TMe", "load m splash 广告位 = " + nVar.l() + ",ritId:" + nVar4.q());
            } else {
                if (!com.byazt.ir.q.n().s() || nVar.x() == null || TextUtils.isEmpty(nVar.x().n()) || TextUtils.isEmpty(nVar.x().s()) || TextUtils.isEmpty(nVar.x().qg())) {
                    z3 = false;
                } else {
                    com.byazt.rb.qg.qg("TMe", "load m splash 开屏兜底代码位 = " + nVar.x().qg());
                }
                if (z3) {
                    sVar = new com.byazt.yy.s(function);
                    if (!com.byazt.vyf.l.n) {
                        k.qg("TMe", com.byazt.yn.n.NOT_INIT_TIPS_MSG);
                        sVar.n(new com.byazt.fb.n(10000, com.byazt.yn.n.NOT_INIT_TIPS_MSG));
                        return;
                    } else {
                        final boolean z5 = z2;
                        com.byazt.jp.tj.n(new com.byazt.vv.n() { // from class: com.byazt.zo.fs.2
                            @Override // com.byazt.vv.n
                            public void n() {
                                com.byazt.yc.qg.n(fs.this.qg, nVar4, nVar, sVar, z5);
                            }
                        });
                        return;
                    }
                }
                com.byazt.rb.qg.qg("TMe", "load csj splash 代码位 = " + nVar.l());
                n(i, pluginValueSetN2);
                return;
            }
            z3 = true;
            if (z3) {
                sVar = new com.byazt.yy.s(function);
                if (!com.byazt.vyf.l.n) {
                    k.qg("TMe", com.byazt.yn.n.NOT_INIT_TIPS_MSG);
                    sVar.n(new com.byazt.fb.n(10000, com.byazt.yn.n.NOT_INIT_TIPS_MSG));
                    return;
                } else {
                    final boolean z6 = z2;
                    com.byazt.jp.tj.n(new com.byazt.vv.n() { // from class: com.byazt.zo.fs.2
                        @Override // com.byazt.vv.n
                        public void n() {
                            com.byazt.yc.qg.n(fs.this.qg, nVar4, nVar, sVar, z6);
                        }
                    });
                    return;
                }
            }
            com.byazt.rb.qg.qg("TMe", "load csj splash 代码位 = " + nVar.l());
            n(i, pluginValueSetN2);
            return;
        }
        if (i == 5) {
            boolean zBooleanValue = pluginValueSetN2.booleanValue(2);
            if (com.byazt.zs.n.n().n(nVar4.q(), 5, z4)) {
                com.byazt.rb.qg.qg("TMe", "load m feed 广告位 = " + nVar.l() + ",ritId:" + nVar4.q() + ", isExpress: " + zBooleanValue);
                if (zBooleanValue) {
                    com.byazt.yy.fs fsVar2 = new com.byazt.yy.fs(function);
                    if (!com.byazt.vyf.l.n) {
                        k.qg("TMe", com.byazt.yn.n.NOT_INIT_TIPS_MSG);
                        fsVar2.n(10000, com.byazt.yn.n.NOT_INIT_TIPS_MSG);
                        return;
                    } else {
                        if (z) {
                            fsVar2.n(10089, com.byazt.yn.n.GET_CONFIG_TIME_OUT_MSG);
                            return;
                        }
                        Context context = this.qg;
                        if (context != null) {
                            com.byazt.yc.qg.n(context, nVar4, fsVar2, z2);
                            return;
                        } else {
                            fsVar2.n(81005, "context is null");
                            return;
                        }
                    }
                }
                com.byazt.yy.l lVar = new com.byazt.yy.l(function);
                if (!com.byazt.vyf.l.n) {
                    k.qg("TMe", com.byazt.yn.n.NOT_INIT_TIPS_MSG);
                    lVar.n(10000, com.byazt.yn.n.NOT_INIT_TIPS_MSG);
                    return;
                } else {
                    if (z) {
                        lVar.n(10089, com.byazt.yn.n.GET_CONFIG_TIME_OUT_MSG);
                        return;
                    }
                    Context context2 = this.qg;
                    if (context2 != null) {
                        com.byazt.yc.qg.n(context2, nVar4, lVar, z2);
                        return;
                    } else {
                        lVar.n(81005, "context is null");
                        return;
                    }
                }
            }
            com.byazt.rb.qg.qg("TMe", "load csj feed 代码位 = " + nVar.l() + ", isExpress: " + zBooleanValue);
            n(i, pluginValueSetN2);
            return;
        }
        if (i == 7) {
            if (com.byazt.zs.n.n().n(nVar4.q(), 7, z4)) {
                com.byazt.yy.rv rvVar = new com.byazt.yy.rv(function);
                if (!com.byazt.vyf.l.n) {
                    k.qg("TMe", com.byazt.yn.n.NOT_INIT_TIPS_MSG);
                    rvVar.n(10000, com.byazt.yn.n.NOT_INIT_TIPS_MSG);
                    return;
                } else if (z) {
                    rvVar.n(10089, com.byazt.yn.n.GET_CONFIG_TIME_OUT_MSG);
                    return;
                } else {
                    com.byazt.rb.qg.qg("TMe", "load m reward video 广告位 = " + nVar.l() + ",ritId:" + nVar4.q());
                    com.byazt.yc.qg.n(this.qg, nVar4, rvVar);
                    return;
                }
            }
            n(i, pluginValueSetN2);
            return;
        }
        if (i != 8) {
            if (i == 9) {
                if (com.byazt.zs.n.n().n(nVar4.q(), 9, z4)) {
                    com.byazt.rb.qg.qg("TMe", "load m draw 广告位 = " + nVar.l() + ",ritId:" + nVar4.q());
                    com.byazt.yy.q qVar = new com.byazt.yy.q(function);
                    if (!com.byazt.vyf.l.n) {
                        k.qg("TMe", com.byazt.yn.n.NOT_INIT_TIPS_MSG);
                        qVar.n(10000, com.byazt.yn.n.NOT_INIT_TIPS_MSG);
                        return;
                    } else {
                        if (z) {
                            qVar.n(10089, com.byazt.yn.n.GET_CONFIG_TIME_OUT_MSG);
                            return;
                        }
                        Context context3 = this.qg;
                        if (context3 != null) {
                            com.byazt.yc.qg.n(context3, nVar4, qVar);
                            return;
                        } else {
                            qVar.n(81005, "context is null");
                            return;
                        }
                    }
                }
                com.byazt.rb.qg.qg("TMe", "load csj draw 代码位 = " + nVar.l());
                n(i, pluginValueSetN2);
                return;
            }
            com.byazt.rb.qg.q(MediationConstant.TAG, "CSJM_loadAD load default mCSJLoader = " + this.n);
            n(i, pluginValueSetN2);
            return;
        }
        if (com.byazt.zs.n.n().n(nVar4.q(), 8, z4) || com.byazt.zs.n.n().n(nVar4.q(), 10, z4)) {
            com.byazt.yy.w wVar = new com.byazt.yy.w(function);
            if (!com.byazt.vyf.l.n) {
                k.qg("TMe", com.byazt.yn.n.NOT_INIT_TIPS_MSG);
                wVar.n(10000, com.byazt.yn.n.NOT_INIT_TIPS_MSG);
                return;
            }
            if (z) {
                wVar.n(10089, com.byazt.yn.n.GET_CONFIG_TIME_OUT_MSG);
                return;
            }
            com.byazt.ws.qg qgVarN = com.byazt.qt.qg.n().n(nVar4.q(), 8, 101);
            if (qgVarN == null) {
                qgVarN = com.byazt.qt.qg.n().n(nVar4.q(), 10, 101);
            }
            if (qgVarN != null && qgVarN.fi() == 8) {
                com.byazt.rb.qg.qg("TMe", "load m full 广告位 = " + nVar.l() + ",ritId:" + nVar4.q());
                com.byazt.yc.qg.n(this.qg, nVar4, wVar);
                return;
            } else {
                com.byazt.rb.qg.qg("TMe", "load m interstitial full 广告位 = " + nVar.l() + ",ritId:" + nVar4.q());
                com.byazt.yc.qg.qg(this.qg, nVar4, wVar);
                return;
            }
        }
        com.byazt.rb.qg.qg("TMe", "load csj full");
        n(i, pluginValueSetN2);
    }

    private void n(int i, PluginValueSet pluginValueSet) {
        if (this.n instanceof com.byazt.yn.n) {
            Object objObjectValue = n(pluginValueSet).objectValue(1, Object.class);
            if (objObjectValue == null) {
                k.n("apply->load with null callback");
            } else {
                ((com.byazt.yn.n) this.n).n(i, pluginValueSet, com.byazt.mp.s.n(objObjectValue));
            }
        }
    }

    private void n(com.byazt.zr.n nVar, com.byazt.zq.qg.n nVar2) {
        nVar2.q(nVar.l());
        nVar2.n(nVar.s());
        nVar2.qg(nVar.q());
        nVar2.qg(nVar.qg());
        nVar2.n(nVar.n());
    }

    private PluginValueSet n(PluginValueSet pluginValueSet, com.byazt.zq.qg qgVar) {
        com.byazt.qvu.n nVarN = com.byazt.qvu.n.n(pluginValueSet);
        nVarN.n(260009, qgVar.rv());
        nVarN.n(260008, qgVar.fs());
        nVarN.n(260007, qgVar.x());
        nVarN.n(260006, qgVar.w());
        nVarN.n(260004, qgVar.q());
        return nVarN.qg();
    }
}
