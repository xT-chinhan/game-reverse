package com.bytedance.sdk.openadsdk.mediation.bridge.valueset;

import android.util.SparseArray;
import com.byazt.cp.n;
import com.byazt.qvu.s;
import com.byazt.vx.w;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.IMediationLocation;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomInitConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 55, 56, 57, 58, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FFMPEG_LOG_LEVEL, 1557, 1962})
public class MediationInitConfig {
    private static String n = "MEDIATION_LOG";
    private ValueSet q;
    private ValueSet qg;
    private ValueSet s;

    private MediationInitConfig(ValueSet valueSet) {
        this.qg = valueSet;
        if (valueSet != null) {
            this.q = s.n((SparseArray<Object>) valueSet.objectValue(8457, SparseArray.class)).qg();
            this.s = s.n((SparseArray<Object>) this.qg.objectValue(8475, SparseArray.class)).qg();
        }
        n();
    }

    private void n() {
        s();
        q();
        qg();
    }

    private void qg() {
        w.s(n, "---------  sdk 聚合信息 start ----");
        w.s(n, "getHttps：" + getHttps());
        w.s(n, "getWxAppId：" + getWxAppId());
        w.s(n, "getPublisherDid：" + getPublisherDid());
        w.s(n, "isOpenAdnTest：" + isOpenAdnTest());
        w.s(n, "getMediationConfigUserInfoForSegment：" + getMediationConfigUserInfoForSegment());
        w.s(n, "getLocalExtra：" + getLocalExtra());
        w.s(n, "getCustomLocalConfig：" + getCustomLocalConfig());
        w.s(n, "getOpensdkVer：" + getOpensdkVer());
        w.s(n, "isWxInstalled：" + isWxInstalled());
        w.s(n, "isSupportH265：" + isSupportH265());
        w.s(n, "isSupportSplashZoomout：" + isSupportSplashZoomout());
        w.s(n, "---------  sdk 聚合信息 end ----");
    }

    private void s() {
        w.s(n, "---------  sdk 初始化信息 start ----");
        w.s(n, "isDebug：" + isDebug());
        w.s(n, "getClassName：" + getClassName());
        w.s(n, "getAppId：" + getAppId());
        w.s(n, "getAppName：" + getAppName());
        w.s(n, "getADNName：" + getADNName());
        w.s(n, "getAppKey：" + getAppKey());
        w.s(n, "getInitCallback：" + getInitCallback());
        w.s(n, "getAgeGroup：" + getAgeGroup());
        w.s(n, "isCustom：" + isCustom());
        w.s(n, "getCustomInitConfig：" + getCustomInitConfig());
        w.s(n, "getCustomInitMap：" + getCustomInitMap());
        w.s(n, "getCustomGMConfiguration：" + getCustomGMConfiguration());
        w.s(n, "getKsAdapterVersion：" + getKsAdapterVersion());
        w.s(n, "getGromoreVersion：" + getGromoreVersion());
        w.s(n, "getAdmobAdapterVersion：" + getAdmobAdapterVersion());
        w.s(n, "getBaiduAdapterVersion：" + getBaiduAdapterVersion());
        w.s(n, "getGdtAdapterVersion：" + getGdtAdapterVersion());
        w.s(n, "getKlevinAdapterVersion：" + getKlevinAdapterVersion());
        w.s(n, "getMintegralAdapterVersion：" + getMintegralAdapterVersion());
        w.s(n, "getSigmobAdapterVersion：" + getSigmobAdapterVersion());
        w.s(n, "getUnityAdapterVersion：" + getUnityAdapterVersion());
        w.s(n, "getMap：" + getInitAdnMap());
        w.s(n, "---------  sdk 初始化信息 end ----");
    }

    private void q() {
        w.s(n, "---------  sdk 隐私设置 start ----");
        w.s(n, "isCanUseLocation：" + isCanUseLocation());
        IMediationLocation location = getLocation();
        if (location != null) {
            w.s(n, "getLocation getLatitude：" + location.getLatitude());
            w.s(n, "getLocation getLongitude：" + location.getLongitude());
        } else {
            w.s(n, "getLocation is null");
        }
        w.s(n, "appList：" + appList());
        w.s(n, "isCanUsePhoneState：" + isCanUsePhoneState());
        w.s(n, "isLimitPersonalAds：" + isLimitPersonalAds());
        w.s(n, "getDevImei：" + getDevImei());
        w.s(n, "isCanUseWifiState：" + isCanUseWifiState());
        w.s(n, "getMacAddress：" + getMacAddress());
        w.s(n, "isCanUseWriteExternal：" + isCanUseWriteExternal());
        w.s(n, "isCanUseAndroidId：" + isCanUseAndroidId());
        w.s(n, "getAndroidId：" + getAndroidId());
        w.s(n, "isCanUseMessage：" + isCanUseMessage());
        List<String> appList = getAppList();
        w.s(n, "getAppList：".concat(String.valueOf(appList)));
        if (appList != null) {
            Iterator<String> it = appList.iterator();
            while (it.hasNext()) {
                w.s(n, "getAppList item: ".concat(String.valueOf(it.next())));
            }
        }
        List<String> devImeis = getDevImeis();
        w.s(n, "getDevImeis：".concat(String.valueOf(devImeis)));
        if (devImeis != null) {
            Iterator<String> it2 = devImeis.iterator();
            while (it2.hasNext()) {
                w.s(n, "getDevImeis item: ".concat(String.valueOf(it2.next())));
            }
        }
        w.s(n, "getDevOaid：" + getDevOaid());
        w.s(n, "isCanUseOaid：" + isCanUseOaid());
        w.s(n, "isCanUseMacAddress：" + isCanUseMacAddress());
        w.s(n, "isProgrammaticRecommend：" + isProgrammaticRecommend());
        w.s(n, "isCanUsePermissionRecordAudio：" + isCanUsePermissionRecordAudio());
        w.s(n, "---------  sdk 隐私设置 end ----");
    }

    public static MediationInitConfig create(ValueSet valueSet) {
        return new MediationInitConfig(valueSet);
    }

    public void setMediationCustomControllerValueSet(ValueSet valueSet) {
        this.s = valueSet;
        q();
    }

    public ValueSet getValueSet() {
        return this.qg;
    }

    private boolean l() {
        ValueSet valueSet = this.qg;
        return (valueSet == null || valueSet.isEmpty()) ? false : true;
    }

    public String getClassName() {
        return l() ? this.qg.stringValue(AVMDLDataLoader.KeyIsLiveMobileUploadAllow) : "";
    }

    public String getAppId() {
        if (l()) {
            return this.qg.stringValue(3);
        }
        return null;
    }

    public String getAppName() {
        return l() ? this.qg.stringValue(8) : "";
    }

    public String getADNName() {
        return l() ? this.qg.stringValue(AVMDLDataLoader.KeyIsLiveGetPlayCacheSec) : "";
    }

    public String getAppKey() {
        return l() ? this.qg.stringValue(AVMDLDataLoader.KeyIsLiveWatchDurationThreshold) : "";
    }

    public Function getInitCallback() {
        if (l()) {
            return MediationValueUtil.covertToFunction(this.qg.objectValue(8300, Object.class));
        }
        return null;
    }

    public boolean isLimitPersonalAds() {
        Function<SparseArray<Object>, Object> functionCovertToFunction;
        ValueSet valueSet = this.s;
        if (valueSet == null || (functionCovertToFunction = MediationValueUtil.covertToFunction(valueSet.objectValue(8311, Object.class))) == null) {
            return false;
        }
        Object obj = functionCovertToFunction instanceof Supplier ? ((Supplier) functionCovertToFunction).get() : null;
        if (obj instanceof SparseArray) {
            return ((Boolean) MediationValueUtil.objectValue(((SparseArray) obj).get(8027), Boolean.class, Boolean.FALSE)).booleanValue();
        }
        return false;
    }

    public boolean isCanUsePhoneState() {
        ValueSet valueSet = this.s;
        if (valueSet != null) {
            return valueSet.booleanValue(8023);
        }
        return true;
    }

    public boolean isCanUseLocation() {
        ValueSet valueSet = this.s;
        if (valueSet != null) {
            return valueSet.booleanValue(8024);
        }
        return true;
    }

    public boolean isCanUseWriteExternal() {
        ValueSet valueSet = this.s;
        if (valueSet != null) {
            return valueSet.booleanValue(8025);
        }
        return true;
    }

    public boolean appList() {
        ValueSet valueSet = this.s;
        if (valueSet != null) {
            return valueSet.booleanValue(8026);
        }
        return true;
    }

    public boolean isCanUseMacAddress() {
        return isCanUseWifiState();
    }

    public boolean isCanUseAndroidId() {
        ValueSet valueSet = this.s;
        if (valueSet != null) {
            return valueSet.booleanValue(8479);
        }
        return true;
    }

    public boolean isProgrammaticRecommend() {
        Function<SparseArray<Object>, Object> functionCovertToFunction;
        ValueSet valueSet = this.s;
        if (valueSet == null || (functionCovertToFunction = MediationValueUtil.covertToFunction(valueSet.objectValue(8311, Object.class))) == null) {
            return true;
        }
        Object obj = functionCovertToFunction instanceof Supplier ? ((Supplier) functionCovertToFunction).get() : null;
        if (obj instanceof SparseArray) {
            return ((Boolean) MediationValueUtil.objectValue(((SparseArray) obj).get(8028), Boolean.class, Boolean.FALSE)).booleanValue();
        }
        return true;
    }

    public IMediationLocation getLocation() {
        Function<SparseArray<Object>, Object> functionCovertToFunction;
        ValueSet valueSet = this.s;
        if (valueSet != null && (functionCovertToFunction = MediationValueUtil.covertToFunction(valueSet.objectValue(8312, Object.class))) != null) {
            Object obj = functionCovertToFunction instanceof Supplier ? ((Supplier) functionCovertToFunction).get() : null;
            if (obj instanceof SparseArray) {
                SparseArray sparseArray = (SparseArray) obj;
                final double dDoubleValue = ((Double) MediationValueUtil.objectValue(sparseArray.get(8481), Double.class, Double.valueOf(0.0d))).doubleValue();
                final double dDoubleValue2 = ((Double) MediationValueUtil.objectValue(sparseArray.get(8482), Double.class, Double.valueOf(0.0d))).doubleValue();
                return new IMediationLocation() { // from class: com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationInitConfig.1
                    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationLocation
                    public double getLatitude() {
                        return dDoubleValue;
                    }

                    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationLocation
                    public double getLongitude() {
                        return dDoubleValue2;
                    }
                };
            }
        }
        return null;
    }

    public String getDevImei() {
        ValueSet valueSet = this.s;
        return valueSet != null ? valueSet.stringValue(8484) : "";
    }

    public List<String> getDevImeis() {
        Function<SparseArray<Object>, Object> functionCovertToFunction;
        ValueSet valueSet = this.s;
        if (valueSet != null && (functionCovertToFunction = MediationValueUtil.covertToFunction(valueSet.objectValue(8311, Object.class))) != null) {
            Object obj = functionCovertToFunction instanceof Supplier ? ((Supplier) functionCovertToFunction).get() : null;
            if (obj instanceof SparseArray) {
                return (List) MediationValueUtil.objectValue(((SparseArray) obj).get(8477), List.class, null);
            }
        }
        return new LinkedList();
    }

    public String getAndroidId() {
        ValueSet valueSet = this.s;
        return valueSet != null ? valueSet.stringValue(8485) : "";
    }

    public boolean isCanUseOaid() {
        Function<SparseArray<Object>, Object> functionCovertToFunction;
        ValueSet valueSet = this.s;
        if (valueSet == null || (functionCovertToFunction = MediationValueUtil.covertToFunction(valueSet.objectValue(8311, Object.class))) == null) {
            return true;
        }
        Object obj = functionCovertToFunction instanceof Supplier ? ((Supplier) functionCovertToFunction).get() : null;
        if (obj instanceof SparseArray) {
            return ((Boolean) MediationValueUtil.objectValue(((SparseArray) obj).get(8478), Boolean.class, Boolean.FALSE)).booleanValue();
        }
        return true;
    }

    public String getDevOaid() {
        ValueSet valueSet = this.s;
        return valueSet != null ? valueSet.stringValue(8486) : "";
    }

    public String getMacAddress() {
        ValueSet valueSet = this.s;
        return valueSet != null ? valueSet.stringValue(8487) : "";
    }

    public boolean isCanUseWifiState() {
        ValueSet valueSet = this.s;
        if (valueSet != null) {
            return valueSet.booleanValue(8480);
        }
        return true;
    }

    public boolean isCanUsePermissionRecordAudio() {
        ValueSet valueSet = this.s;
        if (valueSet != null) {
            return valueSet.booleanValue(8549);
        }
        return true;
    }

    public List<String> getAppList() {
        Function<SparseArray<Object>, Object> functionCovertToFunction;
        ValueSet valueSet = this.s;
        if (valueSet != null && (functionCovertToFunction = MediationValueUtil.covertToFunction(valueSet.objectValue(8311, Object.class))) != null) {
            Object obj = functionCovertToFunction instanceof Supplier ? ((Supplier) functionCovertToFunction).get() : null;
            if (obj instanceof SparseArray) {
                return (List) MediationValueUtil.objectValue(((SparseArray) obj).get(8476), List.class, null);
            }
        }
        return new LinkedList();
    }

    public Map<String, Object> userPrivacyConfig() {
        ValueSet valueSet = this.s;
        if (valueSet != null) {
            return (Map) valueSet.objectValue(8554, Map.class);
        }
        return null;
    }

    public boolean isCanUseMessage() {
        ValueSet valueSet = this.s;
        if (valueSet != null) {
            return valueSet.booleanValue(8562);
        }
        return true;
    }

    public int getAgeGroup() {
        if (l()) {
            return this.qg.intValue(7);
        }
        return 0;
    }

    public boolean isCustom() {
        if (l()) {
            return this.qg.booleanValue(8098);
        }
        return false;
    }

    public MediationCustomInitConfig getCustomInitConfig() {
        if (l()) {
            return (MediationCustomInitConfig) this.qg.objectValue(8099, MediationCustomInitConfig.class);
        }
        return null;
    }

    public ValueSet getCustomInitConfigValueSet() {
        if (l()) {
            return s.n((SparseArray<Object>) this.qg.objectValue(8545, SparseArray.class)).qg();
        }
        return null;
    }

    public Map getCustomInitMap() {
        if (l()) {
            return (Map) this.qg.objectValue(8400, Map.class);
        }
        return null;
    }

    public Function getCustomGMConfiguration() {
        if (l()) {
            return MediationValueUtil.covertToFunction(this.qg.objectValue(8401, Object.class));
        }
        return null;
    }

    public boolean isDebug() {
        ValueSet valueSet = this.qg;
        if (valueSet != null) {
            return valueSet.booleanValue(1);
        }
        return false;
    }

    public String getKsAdapterVersion() {
        ValueSet valueSet = this.qg;
        return valueSet != null ? valueSet.stringValue(8410) : "";
    }

    public String getGromoreVersion() {
        ValueSet valueSet = this.qg;
        return valueSet != null ? valueSet.stringValue(8411) : "";
    }

    public String getAdmobAdapterVersion() {
        ValueSet valueSet = this.qg;
        return valueSet != null ? valueSet.stringValue(8412) : "";
    }

    public String getBaiduAdapterVersion() {
        ValueSet valueSet = this.qg;
        return valueSet != null ? valueSet.stringValue(8413) : "";
    }

    public String getGdtAdapterVersion() {
        ValueSet valueSet = this.qg;
        return valueSet != null ? valueSet.stringValue(8414) : "";
    }

    public String getKlevinAdapterVersion() {
        ValueSet valueSet = this.qg;
        return valueSet != null ? valueSet.stringValue(8415) : "";
    }

    public String getMintegralAdapterVersion() {
        ValueSet valueSet = this.qg;
        return valueSet != null ? valueSet.stringValue(8416) : "";
    }

    public String getSigmobAdapterVersion() {
        ValueSet valueSet = this.qg;
        return valueSet != null ? valueSet.stringValue(8417) : "";
    }

    public String getUnityAdapterVersion() {
        ValueSet valueSet = this.qg;
        return valueSet != null ? valueSet.stringValue(8418) : "";
    }

    public Map getInitAdnMap() {
        ValueSet valueSet = this.qg;
        if (valueSet != null) {
            return (Map) valueSet.objectValue(8425, Map.class);
        }
        return new HashMap();
    }

    public boolean getHttps() {
        ValueSet valueSet = this.q;
        if (valueSet != null) {
            return valueSet.booleanValue(8458);
        }
        return false;
    }

    public String getWxAppId() {
        ValueSet valueSet = this.q;
        return valueSet != null ? valueSet.stringValue(8459) : "";
    }

    public String getPublisherDid() {
        ValueSet valueSet = this.q;
        return valueSet != null ? valueSet.stringValue(8460) : "";
    }

    public boolean isOpenAdnTest() {
        ValueSet valueSet = this.q;
        if (valueSet != null) {
            return valueSet.booleanValue(8461);
        }
        return false;
    }

    public Function getMediationConfigUserInfoForSegment() {
        ValueSet valueSet = this.q;
        if (valueSet != null) {
            return MediationValueUtil.covertToFunction(valueSet.objectValue(8310, Object.class));
        }
        return null;
    }

    public Map getLocalExtra() {
        ValueSet valueSet = this.q;
        if (valueSet != null) {
            return (Map) valueSet.objectValue(8462, Map.class);
        }
        return new HashMap();
    }

    public JSONObject getCustomLocalConfig() {
        ValueSet valueSet = this.q;
        if (valueSet != null) {
            return (JSONObject) valueSet.objectValue(8463, JSONObject.class);
        }
        return null;
    }

    public String getOpensdkVer() {
        ValueSet valueSet = this.q;
        return valueSet != null ? valueSet.stringValue(8464) : "";
    }

    public boolean isWxInstalled() {
        ValueSet valueSet = this.q;
        if (valueSet != null) {
            return valueSet.booleanValue(8465);
        }
        return false;
    }

    public boolean isSupportH265() {
        ValueSet valueSet = this.q;
        if (valueSet != null) {
            return valueSet.booleanValue(8466);
        }
        return false;
    }

    public boolean isSupportSplashZoomout() {
        ValueSet valueSet = this.q;
        if (valueSet != null) {
            return valueSet.booleanValue(8467);
        }
        return false;
    }

    public String getAdapterManagerClassName() {
        ValueSet valueSet = this.qg;
        if (valueSet != null) {
            return valueSet.stringValue(8560);
        }
        return null;
    }
}
