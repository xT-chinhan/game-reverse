package com.byazt.mt;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME, 8})
public class s {
    public Function<SparseArray<Object>, Object> l;
    public PluginValueSet n;
    public com.byazt.zq.n q = new com.byazt.zq.n(com.byazt.qt.n.d().an().sparseArray());
    public PluginValueSet qg;
    public PluginValueSet s;

    private s(SparseArray<Object> sparseArray) {
        this.l = null;
        PluginValueSet pluginValueSetQg = com.byazt.qvu.n.n(sparseArray).qg();
        this.n = pluginValueSetQg;
        if (pluginValueSetQg != null) {
            this.s = com.byazt.hn.s.n(8457, pluginValueSetQg);
            PluginValueSet pluginValueSetN = com.byazt.hn.s.n(8475, this.n);
            this.qg = pluginValueSetN;
            if (pluginValueSetN != null) {
                this.l = (Function) pluginValueSetN.objectValue(8311, Function.class);
            }
        }
        rf();
    }

    private void rf() {
        b();
        ri();
        dh();
    }

    private void dh() {
        com.byazt.rb.qg.n("---------  sdk 聚合信息 start ----");
        com.byazt.rb.qg.n("getHttps：" + ae());
        com.byazt.rb.qg.n("getWxAppId：" + f());
        com.byazt.rb.qg.n("getPublisherDid：" + fi());
        com.byazt.rb.qg.n("isOpenAdnTest：" + df());
        com.byazt.rb.qg.n("getMediationConfigUserInfoForSegment：" + oj());
        com.byazt.rb.qg.n("getLocalExtra：" + dg());
        com.byazt.rb.qg.n("getCustomLocalConfig：" + u());
        com.byazt.rb.qg.n("getOpensdkVer：" + pk());
        com.byazt.rb.qg.n("isWxInstalled：" + wo());
        com.byazt.rb.qg.n("isSupportH265：" + sh());
        com.byazt.rb.qg.n("isSupportSplashZoomout：" + y());
        com.byazt.rb.qg.n("---------  sdk 聚合信息 end ----");
    }

    private void b() {
        com.byazt.rb.qg.n("---------  sdk 初始化信息 start ----");
        com.byazt.rb.qg.n("isDebug：" + v());
        com.byazt.rb.qg.n("getClassName：" + n());
        com.byazt.rb.qg.n("getAppId：" + qg());
        com.byazt.rb.qg.n("getAppName：" + s());
        com.byazt.rb.qg.n("getADNName：" + q());
        com.byazt.rb.qg.n("getAppKey：" + l());
        com.byazt.rb.qg.n("getInitCallback：" + w());
        com.byazt.rb.qg.n("getAgeGroup：" + ur());
        com.byazt.rb.qg.n("isCustom：" + bb());
        com.byazt.rb.qg.n("getCustomInitMap：" + ln());
        com.byazt.rb.qg.n("getCustomGMConfiguration：" + lh());
        com.byazt.rb.qg.n("getGromoreVersion：" + j());
        com.byazt.rb.qg.n("getMap：" + an());
        com.byazt.rb.qg.n("---------  sdk 初始化信息 end ----");
    }

    private void ri() {
        com.byazt.rb.qg.n("---------  sdk 隐私设置 start ----");
        com.byazt.rb.qg.n("isCanUseLocation：" + rv());
        q qVarK = k();
        com.byazt.rb.qg.n("getLocation：".concat(String.valueOf(qVarK)));
        if (qVarK != null) {
            com.byazt.rb.qg.n("getLocation getLatitude：" + qVarK.n());
            com.byazt.rb.qg.n("getLocation getLongitude：" + qVarK.qg());
        }
        com.byazt.rb.qg.n("appList：" + cp());
        com.byazt.rb.qg.n("isCanUsePhoneState：" + fs());
        com.byazt.rb.qg.n("isLimitPersonalAds：" + x());
        com.byazt.rb.qg.n("getDevImei：" + cd());
        com.byazt.rb.qg.n("isCanUseWifiState：" + hu());
        com.byazt.rb.qg.n("getMacAddress：" + wm());
        com.byazt.rb.qg.n("userPrivacyConfig：" + m());
        com.byazt.rb.qg.n("isCanUseWriteExternal：" + tj());
        com.byazt.rb.qg.n("isCanUseAndroidId：" + oa());
        com.byazt.rb.qg.n("getAndroidId：" + a());
        List<String> listT = t();
        com.byazt.rb.qg.n("getAppList：".concat(String.valueOf(listT)));
        if (listT != null) {
            Iterator<String> it = listT.iterator();
            while (it.hasNext()) {
                com.byazt.rb.qg.n("getAppList item: ".concat(String.valueOf(it.next())));
            }
        }
        List<String> listUm = um();
        com.byazt.rb.qg.n("getDevImeis：".concat(String.valueOf(listUm)));
        if (listUm != null) {
            Iterator<String> it2 = listUm.iterator();
            while (it2.hasNext()) {
                com.byazt.rb.qg.n("getDevImeis item: ".concat(String.valueOf(it2.next())));
            }
        }
        com.byazt.rb.qg.n("getDevOaid：" + ou());
        com.byazt.rb.qg.n("isCanUseOaid：" + py());
        com.byazt.rb.qg.n("isCanUseMacAddress：" + d());
        com.byazt.rb.qg.n("isProgrammaticRecommend：" + sz());
        com.byazt.rb.qg.n("---------  sdk 隐私设置 end ----");
    }

    public static s n(SparseArray<Object> sparseArray) {
        return new s(sparseArray);
    }

    public void qg(SparseArray<Object> sparseArray) {
        PluginValueSet pluginValueSetQg = com.byazt.qvu.n.n(sparseArray).qg();
        this.qg = pluginValueSetQg;
        if (pluginValueSetQg != null) {
            this.l = (Function) pluginValueSetQg.objectValue(8311, Function.class);
        }
        ri();
    }

    private boolean nf() {
        PluginValueSet pluginValueSet = this.n;
        return (pluginValueSet == null || pluginValueSet.isEmpty()) ? false : true;
    }

    public String n() {
        return nf() ? this.n.stringValue(AVMDLDataLoader.KeyIsLiveMobileUploadAllow) : "";
    }

    public String qg() {
        if (nf()) {
            return this.n.stringValue(3);
        }
        return null;
    }

    public String s() {
        return nf() ? this.n.stringValue(8) : "";
    }

    public String q() {
        return nf() ? this.n.stringValue(AVMDLDataLoader.KeyIsLiveGetPlayCacheSec) : "";
    }

    public String l() {
        return nf() ? this.n.stringValue(AVMDLDataLoader.KeyIsLiveWatchDurationThreshold) : "";
    }

    public Function<SparseArray<Object>, Object> w() {
        if (nf()) {
            return (Function) this.n.objectValue(8300, Function.class);
        }
        return null;
    }

    public boolean x() {
        PluginValueSet pluginValueSetQg;
        Function<SparseArray<Object>, Object> function = this.l;
        if (function == null || (pluginValueSetQg = com.byazt.of.n.qg(function)) == null) {
            return false;
        }
        return pluginValueSetQg.booleanValue(8027);
    }

    public boolean fs() {
        PluginValueSet pluginValueSet = this.qg;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8023);
        }
        return true;
    }

    public boolean rv() {
        PluginValueSet pluginValueSet = this.qg;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8024);
        }
        return true;
    }

    public boolean tj() {
        PluginValueSet pluginValueSet = this.qg;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8025);
        }
        return true;
    }

    public boolean cp() {
        PluginValueSet pluginValueSet = this.qg;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8026);
        }
        return true;
    }

    public boolean d() {
        return hu();
    }

    public boolean oa() {
        PluginValueSet pluginValueSet = this.qg;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8479);
        }
        return true;
    }

    public boolean sz() {
        PluginValueSet pluginValueSetQg;
        Function<SparseArray<Object>, Object> function = this.l;
        if (function == null || (pluginValueSetQg = com.byazt.of.n.qg(function)) == null) {
            return true;
        }
        return pluginValueSetQg.booleanValue(8028);
    }

    public q k() {
        if (cy() == -1.0d || cy() == -1.0d) {
            return null;
        }
        return new q() { // from class: com.byazt.mt.s.1
            @Override // com.byazt.mt.q
            public double n() {
                return s.this.cy();
            }

            @Override // com.byazt.mt.q
            public double qg() {
                return s.this.hd();
            }
        };
    }

    public double cy() {
        Function function;
        PluginValueSet pluginValueSetQg;
        PluginValueSet pluginValueSet = this.qg;
        if (pluginValueSet == null || (function = (Function) pluginValueSet.objectValue(8312, Function.class)) == null || (pluginValueSetQg = com.byazt.of.n.qg(function)) == null) {
            return -1.0d;
        }
        return pluginValueSetQg.doubleValue(8481);
    }

    public double hd() {
        Function function;
        PluginValueSet pluginValueSetQg;
        PluginValueSet pluginValueSet = this.qg;
        if (pluginValueSet == null || (function = (Function) pluginValueSet.objectValue(8312, Function.class)) == null || (pluginValueSetQg = com.byazt.of.n.qg(function)) == null) {
            return -1.0d;
        }
        return pluginValueSetQg.doubleValue(8482);
    }

    public String cd() {
        PluginValueSet pluginValueSet = this.qg;
        return pluginValueSet != null ? pluginValueSet.stringValue(8484) : "";
    }

    public List<String> um() {
        PluginValueSet pluginValueSetQg;
        Function<SparseArray<Object>, Object> function = this.l;
        if (function != null && (pluginValueSetQg = com.byazt.of.n.qg(function)) != null) {
            return (List) pluginValueSetQg.objectValue(8477, List.class);
        }
        return new LinkedList();
    }

    public String a() {
        PluginValueSet pluginValueSet = this.qg;
        return pluginValueSet != null ? pluginValueSet.stringValue(8485) : "";
    }

    public boolean py() {
        PluginValueSet pluginValueSetQg;
        Function<SparseArray<Object>, Object> function = this.l;
        if (function == null || (pluginValueSetQg = com.byazt.of.n.qg(function)) == null) {
            return true;
        }
        return pluginValueSetQg.booleanValue(8478);
    }

    public String ou() {
        PluginValueSet pluginValueSet = this.qg;
        return pluginValueSet != null ? pluginValueSet.stringValue(8486) : "";
    }

    public String wm() {
        PluginValueSet pluginValueSet = this.qg;
        return pluginValueSet != null ? pluginValueSet.stringValue(8487) : "";
    }

    public Map<String, Object> m() {
        PluginValueSet pluginValueSet = this.qg;
        if (pluginValueSet != null) {
            return (Map) pluginValueSet.objectValue(8554, Map.class);
        }
        return null;
    }

    public boolean hu() {
        PluginValueSet pluginValueSet = this.qg;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8480);
        }
        return true;
    }

    public boolean h() {
        PluginValueSet pluginValueSet = this.qg;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8549);
        }
        return true;
    }

    public List<String> t() {
        PluginValueSet pluginValueSetQg;
        Function<SparseArray<Object>, Object> function = this.l;
        if (function != null && (pluginValueSetQg = com.byazt.of.n.qg(function)) != null) {
            return (List) pluginValueSetQg.objectValue(8476, List.class);
        }
        return new LinkedList();
    }

    public int ur() {
        return this.q.oa();
    }

    public boolean bb() {
        if (nf()) {
            return this.n.booleanValue(8098);
        }
        return false;
    }

    public Map ln() {
        if (nf()) {
            return (Map) this.n.objectValue(8400, Map.class);
        }
        return null;
    }

    public Function<SparseArray<Object>, Object> lh() {
        if (nf()) {
            return (Function) this.n.objectValue(8401, Function.class);
        }
        return null;
    }

    public boolean v() {
        PluginValueSet pluginValueSet = this.n;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(1);
        }
        return false;
    }

    public String j() {
        PluginValueSet pluginValueSet = this.n;
        return pluginValueSet != null ? pluginValueSet.stringValue(8411) : "";
    }

    public Map an() {
        PluginValueSet pluginValueSet = this.n;
        if (pluginValueSet != null) {
            return (Map) pluginValueSet.objectValue(8425, Map.class);
        }
        return new HashMap();
    }

    public boolean ae() {
        PluginValueSet pluginValueSet = this.s;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8458);
        }
        return false;
    }

    public String f() {
        PluginValueSet pluginValueSet = this.s;
        return pluginValueSet != null ? pluginValueSet.stringValue(8459) : "";
    }

    public String fi() {
        PluginValueSet pluginValueSet = this.s;
        return pluginValueSet != null ? pluginValueSet.stringValue(8460) : "";
    }

    public boolean df() {
        PluginValueSet pluginValueSet = this.s;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8461);
        }
        return false;
    }

    public Function<SparseArray<Object>, Object> oj() {
        PluginValueSet pluginValueSet = this.s;
        if (pluginValueSet != null) {
            return (Function) pluginValueSet.objectValue(8310, Function.class);
        }
        return null;
    }

    public Map dg() {
        PluginValueSet pluginValueSet = this.s;
        if (pluginValueSet != null) {
            return (Map) pluginValueSet.objectValue(8462, Map.class);
        }
        return new HashMap();
    }

    public JSONObject u() {
        PluginValueSet pluginValueSet = this.s;
        if (pluginValueSet != null) {
            return (JSONObject) pluginValueSet.objectValue(8463, JSONObject.class);
        }
        return null;
    }

    public String pk() {
        PluginValueSet pluginValueSet = this.s;
        return pluginValueSet != null ? pluginValueSet.stringValue(8464) : "";
    }

    public boolean wo() {
        PluginValueSet pluginValueSet = this.s;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8465);
        }
        return false;
    }

    public boolean sh() {
        PluginValueSet pluginValueSet = this.s;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8466);
        }
        return false;
    }

    public boolean y() {
        PluginValueSet pluginValueSet = this.s;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8467);
        }
        return false;
    }
}
