package com.byazt.ua;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.anythink.network.gdt.GDTATConst;
import com.byazt.jp.rv;
import com.byazt.ya.l;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 958, 8})
public class s extends qg {
    public com.byazt.qn.qg q;
    public n qg;
    public com.byazt.dd.qg s;

    public s(com.byazt.nw.qg qgVar) {
        super(qgVar);
    }

    @Override // com.byazt.ua.qg
    public void qg(Context context, com.byazt.dd.qg qgVar, com.byazt.qn.qg qgVar2, Map<String, Object> map) {
        this.s = qgVar;
        this.q = qgVar2;
        com.byazt.of.qg qgVarN = n(qgVar, qgVar2, map);
        if (qgVarN != null) {
            this.qg = new n(qgVar2, qgVar, this);
            qgVarN.n(8429, qgVar.cy());
            qgVarN.n(8430, qgVar.hd());
            qgVarN.n(AVMDLDataLoader.KeyIsLiveMobileDownloadAllow, this.qg);
            qgVarN.n(AVMDLDataLoader.KeyIsLiveMobileUploadAllow, qgVar.cd());
            qgVarN.n(8561, Integer.valueOf(qgVar.f()));
            n(context, qgVar.oa(), qgVarN);
        }
    }

    @Override // com.byazt.ua.qg, com.byazt.nw.n
    public String n(Context context, com.byazt.dd.qg qgVar, com.byazt.qn.qg qgVar2) {
        if (qgVar != null && qgVar2 != null) {
            HashMap map = new HashMap();
            map.put("bidding_token", "true");
            if (this.qg == null) {
                this.qg = new n(qgVar2, qgVar, this);
                com.byazt.of.qg qgVarN = com.byazt.of.qg.n();
                qgVarN.n(AVMDLDataLoader.KeyIsLiveMobileDownloadAllow, this.qg);
                qgVarN.n(AVMDLDataLoader.KeyIsLiveMobileUploadAllow, qgVar.cd());
                com.byazt.of.qg qgVarN2 = com.byazt.of.qg.n();
                qgVarN2.n(8449, map);
                com.byazt.of.qg qgVarN3 = com.byazt.of.qg.n();
                qgVarN3.n(8443, qgVarN2.qg());
                qgVarN.n(8090, com.byazt.of.qg.n(qgVar2.ae()).n(8089, qgVarN3.qg()).qg());
                Function<SparseArray<Object>, Object> functionL = com.byazt.zs.n.n().l();
                if (functionL != null) {
                    com.byazt.of.qg qgVarN4 = com.byazt.of.qg.n();
                    qgVarN4.n(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, com.byazt.rb.n.n(context)).n(8106).n(Void.class);
                    l.n(qgVarN4, qgVarN);
                    functionL.apply(qgVarN4.qg());
                } else {
                    com.byazt.rb.qg.qg(MediationConstant.TAG, "load ad class loader is null ");
                }
            }
            if (this.qg != null && qgVar2.cd() != null) {
                com.byazt.pch.qg qgVarUr = qgVar2.cd().ur();
                return this.qg.n(context, qgVar.d(), com.byazt.ef.n.n(qgVarUr != null ? qgVarUr.w() : null));
            }
        }
        return null;
    }

    private void n(Context context, String str, com.byazt.of.qg qgVar) {
        com.byazt.dd.qg qgVar2 = this.s;
        Function<SparseArray<Object>, Object> functionN = (qgVar2 == null || this.q == null) ? null : com.byazt.mh.l.n(qgVar2.oa(), this.q.um(), this.s.k());
        com.byazt.ya.n.n(str, functionN != null);
        if (functionN != null) {
            this.s.qg(true);
            functionN.apply(com.byazt.of.qg.n().n(8241).n(Void.class).n(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, com.byazt.rb.n.n(context)).n(8424, qgVar.qg()).qg());
        } else {
            this.s.qg(false);
            n(context, qgVar);
        }
    }

    private void n(Context context, com.byazt.of.qg qgVar) {
        Function<SparseArray<Object>, Object> functionL = com.byazt.zs.n.n().l();
        if (functionL != null) {
            if (com.byazt.zo.qg.n() >= 5900) {
                com.byazt.of.qg qgVarN = com.byazt.of.qg.n().n(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, com.byazt.rb.n.n(context)).n(8106).n(Void.class);
                l.n(qgVarN, qgVar);
                functionL.apply(qgVarN.qg());
                return;
            } else {
                qgVar.n(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, com.byazt.rb.n.n(context)).n(8106).n(Void.class);
                functionL.apply(qgVar.qg());
                return;
            }
        }
        com.byazt.rb.qg.qg(MediationConstant.TAG, "load ad class loader is null ");
    }

    private com.byazt.of.qg n(com.byazt.dd.qg qgVar, com.byazt.qn.qg qgVar2, Map<String, Object> map) {
        HashMap map2 = null;
        if (qgVar == null || qgVar2 == null || qgVar2.cd() == null) {
            return null;
        }
        com.byazt.of.qg qgVarN = com.byazt.of.qg.n();
        com.byazt.pch.n nVarCd = qgVar2.cd();
        com.byazt.pch.qg qgVarUr = nVarCd.ur();
        com.byazt.of.qg qgVarN2 = com.byazt.of.qg.n(qgVar2.ae()).n(15, nVarCd.sz()).n(13, Integer.valueOf(qgVar2.m())).n(7, Integer.valueOf(nVarCd.w())).n(8, Integer.valueOf(nVarCd.x())).n(16, Integer.valueOf(nVarCd.k())).n(20, Integer.valueOf(nVarCd.cd())).n(11, Boolean.valueOf(nVarCd.tj())).n(17, Integer.valueOf(qgVar2.cy()));
        com.byazt.of.qg qgVarN3 = com.byazt.of.qg.n();
        HashMap map3 = new HashMap();
        if (qgVarUr != null) {
            if (qgVarUr.w() != null) {
                map3.putAll(qgVarUr.w());
            }
            if (qgVar.fs() != null) {
                map3.put("waterfall_config", qgVar.fs());
            }
            map3.put("dynamic_adapter_type", Integer.valueOf(com.byazt.ir.qg.n().q()));
            map3.put("wf_dynamic_adapter_type", Integer.valueOf(com.byazt.ir.qg.n().l()));
            com.byazt.vp.n.n(qgVar2, qgVar.fs(), map3);
            qgVarN3.n(8444, Boolean.valueOf(qgVarUr.s())).n(8445, Boolean.valueOf(qgVarUr.n())).n(8446, Boolean.valueOf(qgVarUr.qg())).n(8447, Float.valueOf(qgVarUr.q())).n(8448, Boolean.valueOf(qgVarUr.l())).n(8450, Boolean.valueOf(qgVarUr.x())).n(8451, qgVarUr.fs()).n(8454, Boolean.valueOf(qgVarUr.rv())).n(8455, Float.valueOf(qgVarUr.cp())).n(8456, Float.valueOf(qgVarUr.d()));
        } else {
            map3.put("dynamic_adapter_type", Integer.valueOf(com.byazt.ir.qg.n().q()));
            map3.put("wf_dynamic_adapter_type", Integer.valueOf(com.byazt.ir.qg.n().l()));
        }
        rv rvVarN = com.byazt.qt.n.d().ou().n();
        if (rvVarN != null) {
            map3.put(GDTATConst.EXTRA_DATA.LNG, Double.valueOf(rvVarN.qg()));
            map3.put("lat", Double.valueOf(rvVarN.n()));
            map3.put(GDTATConst.EXTRA_DATA.LOC_TIME, Long.valueOf(System.currentTimeMillis() / 1000));
        } else {
            map3.put(GDTATConst.EXTRA_DATA.LNG, -1);
            map3.put("lat", -1);
            map3.put(GDTATConst.EXTRA_DATA.LOC_TIME, -1);
        }
        map3.put("load_can_log", Boolean.valueOf(com.byazt.ir.qg.n().rv()));
        qgVarN3.n(8449, map3);
        qgVarN3.n(8044, map3);
        n(qgVarN3, nVarCd, qgVarUr);
        qgVarN2.n(8443, qgVarN3.qg());
        qgVarN.n(8090, com.byazt.hn.s.n(com.byazt.of.qg.n(qgVar2.ae()).n(8089, qgVarN2.qg()).qg()));
        qgVarN.n(AVMDLDataLoader.KeyIsLiveCacheThresholdP2pToHttp, qgVar.d());
        qgVarN.n(4, qgVar2.a());
        qgVarN.n(AVMDLDataLoader.KeyIsLiveGetPlayCacheSec, qgVar.oa());
        qgVarN.n(17, Integer.valueOf(qgVar2.cy()));
        if (qgVar2.an() != null) {
            HashMap map4 = new HashMap();
            for (Map.Entry<String, Object> entry : qgVar2.an().entrySet()) {
                Object value = entry.getValue();
                map4.put(entry.getKey(), value == null ? null : value.toString());
            }
            map2 = map4;
        }
        if (map2 != null) {
            qgVarN.n(8013, map2);
        }
        if (map != null) {
            qgVarN.n(8096, Integer.valueOf(map.get("ad_load_timeout") != null ? ((Integer) map.get("ad_load_timeout")).intValue() : 3000));
        }
        Object obj = map.get("contentUrl");
        if (obj instanceof String) {
            qgVarN.n(8083, (String) obj);
        }
        Object obj2 = map.get("testDevices");
        if (obj2 instanceof String) {
            qgVarN.n(8084, (String) obj2);
        }
        Object obj3 = map.get("tt_ad_origin_type");
        if (obj3 != null) {
            int iIntValue = ((Integer) obj3).intValue();
            if (iIntValue == 1 || iIntValue == 3) {
                qgVarN.n(8033, Boolean.TRUE);
            }
            qgVarN.n(8085, Integer.valueOf(iIntValue));
        }
        Object obj4 = map.get("tt_ad_sub_type");
        if (obj4 != null) {
            qgVarN.n(8094, Integer.valueOf(((Integer) obj4).intValue()));
        }
        Object obj5 = map.get("render_control");
        if (obj5 instanceof Integer) {
            qgVarN.n(8553, Integer.valueOf(((Integer) obj5).intValue()));
        }
        return qgVarN;
    }

    private void n(com.byazt.of.qg qgVar, com.byazt.pch.n nVar, com.byazt.pch.qg qgVar2) {
        if (qgVar == null || nVar == null) {
            return;
        }
        if (qgVar2 != null && !TextUtils.isEmpty(qgVar2.sz()) && qgVar2.k() != 0) {
            qgVar.n(8452, qgVar2.sz());
            qgVar.n(8453, Integer.valueOf(qgVar2.k()));
        } else {
            if (TextUtils.isEmpty(nVar.m()) || nVar.hu() == 0) {
                return;
            }
            qgVar.n(8452, nVar.m());
            qgVar.n(8453, Integer.valueOf(nVar.hu()));
        }
    }

    @Override // com.byazt.nw.n
    public String n(String str) {
        com.byazt.ju.q qVarN = com.byazt.ya.qg.n().n(str);
        if (qVarN != null) {
            return qVarN.qg();
        }
        return null;
    }
}
