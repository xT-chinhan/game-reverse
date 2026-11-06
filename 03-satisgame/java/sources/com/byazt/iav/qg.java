package com.byazt.iav;

import android.util.Pair;
import android.util.SparseArray;
import com.byazt.ir.q;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODE_MULTI_SEI, 26})
public class qg implements Function<SparseArray<Object>, Object> {
    public final Map<String, Supplier<?>> n;
    public Function<SparseArray<Object>, Object> qg;

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODE_MULTI_SEI, 48})
    private static class n {
        public static final qg n = new qg();
    }

    private qg() {
        HashMap map = new HashMap();
        this.n = map;
        map.put("PluginInitConfig.isCanUseLocation", new Supplier() { // from class: com.byazt.iav.qg$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return qg.rf();
            }
        });
        map.put("PluginInitConfig.isCanUsePhoneState", new Supplier() { // from class: com.byazt.iav.qg$$ExternalSyntheticLambda2
            @Override // java.util.function.Supplier
            public final Object get() {
                return qg.y();
            }
        });
        map.put("PluginInitConfig.isCanUseWriteExternal", new Supplier() { // from class: com.byazt.iav.qg$$ExternalSyntheticLambda14
            @Override // java.util.function.Supplier
            public final Object get() {
                return qg.sh();
            }
        });
        map.put("PluginInitConfig.appList", new Supplier() { // from class: com.byazt.iav.qg$$ExternalSyntheticLambda26
            @Override // java.util.function.Supplier
            public final Object get() {
                return qg.wo();
            }
        });
        map.put("PluginInitConfig.isCanUseMacAddress", new Supplier() { // from class: com.byazt.iav.qg$$ExternalSyntheticLambda32
            @Override // java.util.function.Supplier
            public final Object get() {
                return qg.pk();
            }
        });
        map.put("PluginInitConfig.isCanUseAndroidId", new Supplier() { // from class: com.byazt.iav.qg$$ExternalSyntheticLambda34
            @Override // java.util.function.Supplier
            public final Object get() {
                return qg.u();
            }
        });
        map.put("PluginInitConfig.isProgrammaticRecommend", new Supplier() { // from class: com.byazt.iav.qg$$ExternalSyntheticLambda35
            @Override // java.util.function.Supplier
            public final Object get() {
                return qg.dg();
            }
        });
        map.put("PluginInitConfig.getDevImei", new Supplier() { // from class: com.byazt.iav.qg$$ExternalSyntheticLambda36
            @Override // java.util.function.Supplier
            public final Object get() {
                return qg.oj();
            }
        });
        map.put("PluginInitConfig.getDevImeis", new Supplier() { // from class: com.byazt.iav.qg$$ExternalSyntheticLambda37
            @Override // java.util.function.Supplier
            public final Object get() {
                return qg.df();
            }
        });
        map.put("PluginInitConfig.getAndroidId", new Supplier() { // from class: com.byazt.iav.qg$$ExternalSyntheticLambda38
            @Override // java.util.function.Supplier
            public final Object get() {
                return qg.fi();
            }
        });
        map.put("PluginInitConfig.isCanUseOaid", new Supplier() { // from class: com.byazt.iav.qg$$ExternalSyntheticLambda11
            @Override // java.util.function.Supplier
            public final Object get() {
                return qg.f();
            }
        });
        map.put("PluginInitConfig.getDevOaid", new Supplier() { // from class: com.byazt.iav.qg$$ExternalSyntheticLambda22
            @Override // java.util.function.Supplier
            public final Object get() {
                return qg.ae();
            }
        });
        map.put("PluginInitConfig.getMacAddress", new Supplier() { // from class: com.byazt.iav.qg$$ExternalSyntheticLambda33
            @Override // java.util.function.Supplier
            public final Object get() {
                return qg.an();
            }
        });
        map.put("PluginInitConfig.isCanUseWifiState", new Supplier() { // from class: com.byazt.iav.qg$$ExternalSyntheticLambda39
            @Override // java.util.function.Supplier
            public final Object get() {
                return qg.j();
            }
        });
        map.put("PluginInitConfig.getAppList", new Supplier() { // from class: com.byazt.iav.qg$$ExternalSyntheticLambda40
            @Override // java.util.function.Supplier
            public final Object get() {
                return qg.v();
            }
        });
        map.put("PluginInitConfig.getAgeGroup", new Supplier() { // from class: com.byazt.iav.qg$$ExternalSyntheticLambda41
            @Override // java.util.function.Supplier
            public final Object get() {
                return qg.lh();
            }
        });
        map.put("PluginInitConfig.isCustom", new Supplier() { // from class: com.byazt.iav.qg$$ExternalSyntheticLambda42
            @Override // java.util.function.Supplier
            public final Object get() {
                return qg.ln();
            }
        });
        map.put("PluginInitConfig.isLimitPersonalAds", new Supplier() { // from class: com.byazt.iav.qg$$ExternalSyntheticLambda43
            @Override // java.util.function.Supplier
            public final Object get() {
                return qg.bb();
            }
        });
        map.put("PluginInitConfig.getLatitude", new Supplier() { // from class: com.byazt.iav.qg$$ExternalSyntheticLambda44
            @Override // java.util.function.Supplier
            public final Object get() {
                return qg.ur();
            }
        });
        map.put("PluginInitConfig.getLongitude", new Supplier() { // from class: com.byazt.iav.qg$$ExternalSyntheticLambda1
            @Override // java.util.function.Supplier
            public final Object get() {
                return qg.t();
            }
        });
        map.put("PluginInitConfig.isWxInstalled", new Supplier() { // from class: com.byazt.iav.qg$$ExternalSyntheticLambda3
            @Override // java.util.function.Supplier
            public final Object get() {
                return qg.h();
            }
        });
        map.put("PluginInitConfig.isSupportH265", new Supplier() { // from class: com.byazt.iav.qg$$ExternalSyntheticLambda4
            @Override // java.util.function.Supplier
            public final Object get() {
                return qg.hu();
            }
        });
        map.put("PluginInitConfig.isSupportSplashZoomout", new Supplier() { // from class: com.byazt.iav.qg$$ExternalSyntheticLambda5
            @Override // java.util.function.Supplier
            public final Object get() {
                return qg.m();
            }
        });
        map.put("PluginInitConfig.getAppId", new Supplier() { // from class: com.byazt.iav.qg$$ExternalSyntheticLambda6
            @Override // java.util.function.Supplier
            public final Object get() {
                return qg.wm();
            }
        });
        map.put("PluginInitConfig.getAppName", new Supplier() { // from class: com.byazt.iav.qg$$ExternalSyntheticLambda7
            @Override // java.util.function.Supplier
            public final Object get() {
                return qg.ou();
            }
        });
        map.put("PluginInitConfig.getLocalExtra", new Supplier() { // from class: com.byazt.iav.qg$$ExternalSyntheticLambda8
            @Override // java.util.function.Supplier
            public final Object get() {
                return qg.py();
            }
        });
        map.put("PluginInitConfig.getHttps", new Supplier() { // from class: com.byazt.iav.qg$$ExternalSyntheticLambda9
            @Override // java.util.function.Supplier
            public final Object get() {
                return qg.a();
            }
        });
        map.put("PluginInitConfig.getCustomLocalConfig", new Supplier() { // from class: com.byazt.iav.qg$$ExternalSyntheticLambda10
            @Override // java.util.function.Supplier
            public final Object get() {
                return qg.um();
            }
        });
        map.put("PluginInitConfig.getOpensdkVer", new Supplier() { // from class: com.byazt.iav.qg$$ExternalSyntheticLambda12
            @Override // java.util.function.Supplier
            public final Object get() {
                return qg.cd();
            }
        });
        map.put("PluginInitConfig.getWxAppId", new Supplier() { // from class: com.byazt.iav.qg$$ExternalSyntheticLambda13
            @Override // java.util.function.Supplier
            public final Object get() {
                return qg.hd();
            }
        });
        map.put("PluginInitConfig.getPublisherDid", new Supplier() { // from class: com.byazt.iav.qg$$ExternalSyntheticLambda15
            @Override // java.util.function.Supplier
            public final Object get() {
                return qg.cy();
            }
        });
        map.put("PluginInitConfig.isOpenAdnTest", new Supplier() { // from class: com.byazt.iav.qg$$ExternalSyntheticLambda16
            @Override // java.util.function.Supplier
            public final Object get() {
                return qg.k();
            }
        });
        map.put("PluginInitConfig.getMediationConfigUserInfoForSegment", new Supplier() { // from class: com.byazt.iav.qg$$ExternalSyntheticLambda17
            @Override // java.util.function.Supplier
            public final Object get() {
                return qg.sz();
            }
        });
        map.put("PluginInitConfig.isCanUsePermissionRecordAudio", new Supplier() { // from class: com.byazt.iav.qg$$ExternalSyntheticLambda18
            @Override // java.util.function.Supplier
            public final Object get() {
                return qg.oa();
            }
        });
        map.put("GMConfigUserInfoForSegment.getUserId", new Supplier() { // from class: com.byazt.iav.qg$$ExternalSyntheticLambda19
            @Override // java.util.function.Supplier
            public final Object get() {
                return qg.d();
            }
        });
        map.put("GMConfigUserInfoForSegment.getChannel", new Supplier() { // from class: com.byazt.iav.qg$$ExternalSyntheticLambda20
            @Override // java.util.function.Supplier
            public final Object get() {
                return qg.cp();
            }
        });
        map.put("GMConfigUserInfoForSegment.getSubChannel", new Supplier() { // from class: com.byazt.iav.qg$$ExternalSyntheticLambda21
            @Override // java.util.function.Supplier
            public final Object get() {
                return qg.tj();
            }
        });
        map.put("GMConfigUserInfoForSegment.getAge", new Supplier() { // from class: com.byazt.iav.qg$$ExternalSyntheticLambda23
            @Override // java.util.function.Supplier
            public final Object get() {
                return qg.rv();
            }
        });
        map.put("GMConfigUserInfoForSegment.getGender", new Supplier() { // from class: com.byazt.iav.qg$$ExternalSyntheticLambda24
            @Override // java.util.function.Supplier
            public final Object get() {
                return qg.fs();
            }
        });
        map.put("GMConfigUserInfoForSegment.getUserValueGroup", new Supplier() { // from class: com.byazt.iav.qg$$ExternalSyntheticLambda25
            @Override // java.util.function.Supplier
            public final Object get() {
                return qg.x();
            }
        });
        map.put("GMConfigUserInfoForSegment.getCustomInfos", new Supplier() { // from class: com.byazt.iav.qg$$ExternalSyntheticLambda27
            @Override // java.util.function.Supplier
            public final Object get() {
                return qg.w();
            }
        });
        map.put("AdCacheManager.clearCache", new Supplier() { // from class: com.byazt.iav.qg$$ExternalSyntheticLambda28
            @Override // java.util.function.Supplier
            public final Object get() {
                return qg.l();
            }
        });
        map.put("TTSdkSettings.getIsLimitPersonalAds", new Supplier() { // from class: com.byazt.iav.qg$$ExternalSyntheticLambda29
            @Override // java.util.function.Supplier
            public final Object get() {
                return qg.q();
            }
        });
        map.put("TTSdkSettings.getIsLimitProgrammaticRecommend", new Supplier() { // from class: com.byazt.iav.qg$$ExternalSyntheticLambda30
            @Override // java.util.function.Supplier
            public final Object get() {
                return qg.s();
            }
        });
        map.put("TTSdkSettings.getEtag", new Supplier() { // from class: com.byazt.iav.qg$$ExternalSyntheticLambda31
            @Override // java.util.function.Supplier
            public final Object get() {
                return qg.qg();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object rf() {
        return Boolean.valueOf(com.byazt.qt.n.d().qg().rv());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object y() {
        return Boolean.valueOf(com.byazt.qt.n.d().qg().fs());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object sh() {
        return Boolean.valueOf(com.byazt.qt.n.d().qg().tj());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object wo() {
        return Boolean.valueOf(com.byazt.qt.n.d().qg().cp());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object pk() {
        return Boolean.valueOf(com.byazt.qt.n.d().qg().d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object u() {
        return Boolean.valueOf(com.byazt.qt.n.d().qg().oa());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object dg() {
        return Boolean.valueOf(com.byazt.qt.n.d().qg().sz());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object oj() {
        return com.byazt.qt.n.d().qg().cd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object df() {
        return com.byazt.qt.n.d().qg().um();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object fi() {
        return com.byazt.qt.n.d().qg().a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object f() {
        return Boolean.valueOf(com.byazt.qt.n.d().qg().py());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object ae() {
        return com.byazt.qt.n.d().qg().ou();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object an() {
        return com.byazt.qt.n.d().qg().wm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object j() {
        return Boolean.valueOf(com.byazt.qt.n.d().qg().hu());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object v() {
        return com.byazt.qt.n.d().qg().t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lh() {
        return Integer.valueOf(com.byazt.qt.n.d().qg().ur());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object ln() {
        return Boolean.valueOf(com.byazt.qt.n.d().qg().bb());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object bb() {
        return Boolean.valueOf(com.byazt.qt.n.d().qg().x());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object ur() {
        return Double.valueOf(com.byazt.qt.n.d().qg().cy());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object t() {
        return Double.valueOf(com.byazt.qt.n.d().qg().hd());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object h() {
        return Boolean.valueOf(com.byazt.qt.n.d().qg().wo());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object hu() {
        return Boolean.valueOf(com.byazt.qt.n.d().qg().sh());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object m() {
        return Boolean.valueOf(com.byazt.qt.n.d().qg().y());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object wm() {
        return com.byazt.qt.n.d().qg().qg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object ou() {
        return com.byazt.qt.n.d().qg().s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object py() {
        return com.byazt.qt.n.d().qg().dg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object a() {
        return Boolean.valueOf(com.byazt.qt.n.d().qg().ae());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object um() {
        return com.byazt.qt.n.d().qg().u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object cd() {
        return com.byazt.qt.n.d().qg().pk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object hd() {
        return com.byazt.qt.n.d().qg().f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object cy() {
        return com.byazt.qt.n.d().qg().fi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object k() {
        return Boolean.valueOf(com.byazt.qt.n.d().qg().df());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object sz() {
        return com.byazt.qt.n.d().qg().oj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object oa() {
        return Boolean.valueOf(com.byazt.qt.n.d().qg().h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object d() {
        return com.byazt.qt.n.d().py().qg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object cp() {
        return com.byazt.qt.n.d().py().s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object tj() {
        return com.byazt.qt.n.d().py().q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object rv() {
        return Integer.valueOf(com.byazt.qt.n.d().py().l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object fs() {
        return com.byazt.qt.n.d().py().w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object x() {
        return com.byazt.qt.n.d().py().x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object w() {
        return com.byazt.qt.n.d().py().n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object l() {
        com.byazt.ra.n.n().s();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object q() {
        return Integer.valueOf(com.byazt.qt.qg.n().he());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object s() {
        return Integer.valueOf(com.byazt.qt.qg.n().el());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object qg() {
        return com.byazt.qt.qg.n().cd();
    }

    public static qg n() {
        return n.n;
    }

    public void n(Function<SparseArray<Object>, Object> function) {
        this.qg = function;
    }

    public void n(String str, Object obj, boolean z) {
        if (this.qg != null) {
            com.byazt.of.qg qgVarN = com.byazt.of.qg.n();
            qgVarN.n(10012).n(Void.class);
            qgVarN.n(20012, new Pair(str, obj));
            qgVarN.n(20017, Boolean.valueOf(z));
            this.qg.apply(qgVarN.qg());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        int iIntValue = ((Integer) n(sparseArray.get(-99999987), (Class<int>) Integer.class, 0)).intValue();
        n(sparseArray.get(-99999985), (Class<Object>) Class.class, (Object) null);
        if (iIntValue == 10007) {
            Supplier<?> supplier = this.n.get((String) n(sparseArray.get(20007), (Class<String>) String.class, ""));
            if (supplier != null) {
                return supplier.get();
            }
        } else if (iIntValue == 10011) {
            JSONArray jSONArray = (JSONArray) n(sparseArray.get(20011), (Class<Object>) JSONArray.class, (Object) null);
            if (jSONArray != null) {
                q.n().n(jSONArray, false, false);
            }
        } else {
            switch (iIntValue) {
                case 10013:
                    JSONObject jSONObject = (JSONObject) n(sparseArray.get(20013), (Class<Object>) JSONObject.class, (Object) null);
                    if (jSONObject != null) {
                        com.byazt.qt.qg.n().n(jSONObject);
                    }
                    break;
                case 10014:
                    return q.n().n(((Integer) n(sparseArray.get(20015), (Class<int>) Integer.class, -1)).intValue(), (String) n(sparseArray.get(20016), (Class<String>) String.class, ""));
                case 10015:
                    return Integer.valueOf(com.byazt.ra.n.n().qg((String) n(sparseArray.get(20018), (Class<String>) String.class, "")));
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> T n(Object obj, Class<T> cls, T t) {
        return cls.isInstance(obj) ? obj : t;
    }
}
