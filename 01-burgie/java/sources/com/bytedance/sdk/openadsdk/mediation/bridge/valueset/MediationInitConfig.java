package com.bytedance.sdk.openadsdk.mediation.bridge.valueset;

import android.util.SparseArray;
import com.byazt.dea.uc;
import com.byazt.ij.hn;
import com.byazt.vzx.pr;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
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
@pr(pr = {0, 78, 79, 80, 81, 232, 1438, 1802})
public class MediationInitConfig {
    private static String pr = "MEDIATION_LOG";
    private ValueSet hn;
    private ValueSet hw;
    private ValueSet x;

    private MediationInitConfig(ValueSet valueSet) {
        this.hw = valueSet;
        if (valueSet != null) {
            this.x = hn.pr((SparseArray<Object>) valueSet.objectValue(8457, SparseArray.class)).hw();
            this.hn = hn.pr((SparseArray<Object>) this.hw.objectValue(8475, SparseArray.class)).hw();
        }
        pr();
    }

    private void pr() {
        hn();
        x();
        hw();
    }

    private void hw() {
        uc.hn(pr, "---------  sdk 聚合信息 start ----");
        uc.hn(pr, "getHttps：" + getHttps());
        uc.hn(pr, "getWxAppId：" + getWxAppId());
        uc.hn(pr, "getPublisherDid：" + getPublisherDid());
        uc.hn(pr, "isOpenAdnTest：" + isOpenAdnTest());
        uc.hn(pr, "getMediationConfigUserInfoForSegment：" + getMediationConfigUserInfoForSegment());
        uc.hn(pr, "getLocalExtra：" + getLocalExtra());
        uc.hn(pr, "getCustomLocalConfig：" + getCustomLocalConfig());
        uc.hn(pr, "getOpensdkVer：" + getOpensdkVer());
        uc.hn(pr, "isWxInstalled：" + isWxInstalled());
        uc.hn(pr, "isSupportH265：" + isSupportH265());
        uc.hn(pr, "isSupportSplashZoomout：" + isSupportSplashZoomout());
        uc.hn(pr, "---------  sdk 聚合信息 end ----");
    }

    private void hn() {
        uc.hn(pr, "---------  sdk 初始化信息 start ----");
        uc.hn(pr, "isDebug：" + isDebug());
        uc.hn(pr, "getClassName：" + getClassName());
        uc.hn(pr, "getAppId：" + getAppId());
        uc.hn(pr, "getAppName：" + getAppName());
        uc.hn(pr, "getADNName：" + getADNName());
        uc.hn(pr, "getAppKey：" + getAppKey());
        uc.hn(pr, "getInitCallback：" + getInitCallback());
        uc.hn(pr, "getAgeGroup：" + getAgeGroup());
        uc.hn(pr, "isCustom：" + isCustom());
        uc.hn(pr, "getCustomInitConfig：" + getCustomInitConfig());
        uc.hn(pr, "getCustomInitMap：" + getCustomInitMap());
        uc.hn(pr, "getCustomGMConfiguration：" + getCustomGMConfiguration());
        uc.hn(pr, "getKsAdapterVersion：" + getKsAdapterVersion());
        uc.hn(pr, "getGromoreVersion：" + getGromoreVersion());
        uc.hn(pr, "getAdmobAdapterVersion：" + getAdmobAdapterVersion());
        uc.hn(pr, "getBaiduAdapterVersion：" + getBaiduAdapterVersion());
        uc.hn(pr, "getGdtAdapterVersion：" + getGdtAdapterVersion());
        uc.hn(pr, "getKlevinAdapterVersion：" + getKlevinAdapterVersion());
        uc.hn(pr, "getMintegralAdapterVersion：" + getMintegralAdapterVersion());
        uc.hn(pr, "getSigmobAdapterVersion：" + getSigmobAdapterVersion());
        uc.hn(pr, "getUnityAdapterVersion：" + getUnityAdapterVersion());
        uc.hn(pr, "getMap：" + getInitAdnMap());
        uc.hn(pr, "---------  sdk 初始化信息 end ----");
    }

    private void x() {
        uc.hn(pr, "---------  sdk 隐私设置 start ----");
        uc.hn(pr, "isCanUseLocation：" + isCanUseLocation());
        IMediationLocation location = getLocation();
        if (location != null) {
            uc.hn(pr, "getLocation getLatitude：" + location.getLatitude());
            uc.hn(pr, "getLocation getLongitude：" + location.getLongitude());
        } else {
            uc.hn(pr, "getLocation is null");
        }
        uc.hn(pr, "appList：" + appList());
        uc.hn(pr, "isCanUsePhoneState：" + isCanUsePhoneState());
        uc.hn(pr, "isLimitPersonalAds：" + isLimitPersonalAds());
        uc.hn(pr, "getDevImei：" + getDevImei());
        uc.hn(pr, "isCanUseWifiState：" + isCanUseWifiState());
        uc.hn(pr, "getMacAddress：" + getMacAddress());
        uc.hn(pr, "isCanUseWriteExternal：" + isCanUseWriteExternal());
        uc.hn(pr, "isCanUseAndroidId：" + isCanUseAndroidId());
        uc.hn(pr, "getAndroidId：" + getAndroidId());
        uc.hn(pr, "isCanUseMessage：" + isCanUseMessage());
        List<String> appList = getAppList();
        uc.hn(pr, "getAppList：".concat(String.valueOf(appList)));
        if (appList != null) {
            Iterator<String> it = appList.iterator();
            while (it.hasNext()) {
                uc.hn(pr, "getAppList item: ".concat(String.valueOf(it.next())));
            }
        }
        List<String> devImeis = getDevImeis();
        uc.hn(pr, "getDevImeis：".concat(String.valueOf(devImeis)));
        if (devImeis != null) {
            Iterator<String> it2 = devImeis.iterator();
            while (it2.hasNext()) {
                uc.hn(pr, "getDevImeis item: ".concat(String.valueOf(it2.next())));
            }
        }
        uc.hn(pr, "getDevOaid：" + getDevOaid());
        uc.hn(pr, "isCanUseOaid：" + isCanUseOaid());
        uc.hn(pr, "isCanUseMacAddress：" + isCanUseMacAddress());
        uc.hn(pr, "isProgrammaticRecommend：" + isProgrammaticRecommend());
        uc.hn(pr, "isCanUsePermissionRecordAudio：" + isCanUsePermissionRecordAudio());
        uc.hn(pr, "---------  sdk 隐私设置 end ----");
    }

    public static MediationInitConfig create(ValueSet valueSet) {
        return new MediationInitConfig(valueSet);
    }

    public void setMediationCustomControllerValueSet(ValueSet valueSet) {
        this.hn = valueSet;
        x();
    }

    public ValueSet getValueSet() {
        return this.hw;
    }

    private boolean c() {
        ValueSet valueSet = this.hw;
        return (valueSet == null || valueSet.isEmpty()) ? false : true;
    }

    public String getClassName() {
        return c() ? this.hw.stringValue(AVMDLDataLoader.KeyIsLiveMobileUploadAllow) : "";
    }

    public String getAppId() {
        if (c()) {
            return this.hw.stringValue(3);
        }
        return null;
    }

    public String getAppName() {
        return c() ? this.hw.stringValue(8) : "";
    }

    public String getADNName() {
        return c() ? this.hw.stringValue(AVMDLDataLoader.KeyIsLiveGetPlayCacheSec) : "";
    }

    public String getAppKey() {
        return c() ? this.hw.stringValue(AVMDLDataLoader.KeyIsLiveWatchDurationThreshold) : "";
    }

    public Function getInitCallback() {
        if (c()) {
            return MediationValueUtil.covertToFunction(this.hw.objectValue(8300, Object.class));
        }
        return null;
    }

    public boolean isLimitPersonalAds() {
        Function<SparseArray<Object>, Object> functionCovertToFunction;
        ValueSet valueSet = this.hn;
        if (valueSet != null && (functionCovertToFunction = MediationValueUtil.covertToFunction(valueSet.objectValue(8311, Object.class))) != null) {
            Object obj = functionCovertToFunction instanceof Supplier ? ((Supplier) functionCovertToFunction).get() : null;
            if (obj instanceof SparseArray) {
                return ((Boolean) MediationValueUtil.objectValue(((SparseArray) obj).get(8027), Boolean.class, Boolean.FALSE)).booleanValue();
            }
            return false;
        }
        return false;
    }

    public boolean isCanUsePhoneState() {
        ValueSet valueSet = this.hn;
        if (valueSet != null) {
            return valueSet.booleanValue(8023);
        }
        return true;
    }

    public boolean isCanUseLocation() {
        ValueSet valueSet = this.hn;
        if (valueSet != null) {
            return valueSet.booleanValue(8024);
        }
        return true;
    }

    public boolean isCanUseWriteExternal() {
        ValueSet valueSet = this.hn;
        if (valueSet != null) {
            return valueSet.booleanValue(8025);
        }
        return true;
    }

    public boolean appList() {
        ValueSet valueSet = this.hn;
        if (valueSet != null) {
            return valueSet.booleanValue(8026);
        }
        return true;
    }

    public boolean isCanUseMacAddress() {
        return isCanUseWifiState();
    }

    public boolean isCanUseAndroidId() {
        ValueSet valueSet = this.hn;
        if (valueSet != null) {
            return valueSet.booleanValue(8479);
        }
        return true;
    }

    public boolean isProgrammaticRecommend() {
        Function<SparseArray<Object>, Object> functionCovertToFunction;
        ValueSet valueSet = this.hn;
        if (valueSet != null && (functionCovertToFunction = MediationValueUtil.covertToFunction(valueSet.objectValue(8311, Object.class))) != null) {
            Object obj = functionCovertToFunction instanceof Supplier ? ((Supplier) functionCovertToFunction).get() : null;
            if (obj instanceof SparseArray) {
                return ((Boolean) MediationValueUtil.objectValue(((SparseArray) obj).get(8028), Boolean.class, Boolean.FALSE)).booleanValue();
            }
            return true;
        }
        return true;
    }

    public IMediationLocation getLocation() {
        Function<SparseArray<Object>, Object> functionCovertToFunction;
        ValueSet valueSet = this.hn;
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
        ValueSet valueSet = this.hn;
        if (valueSet != null) {
            return valueSet.stringValue(8484);
        }
        return "";
    }

    public List<String> getDevImeis() {
        Function<SparseArray<Object>, Object> functionCovertToFunction;
        ValueSet valueSet = this.hn;
        if (valueSet != null && (functionCovertToFunction = MediationValueUtil.covertToFunction(valueSet.objectValue(8311, Object.class))) != null) {
            Object obj = functionCovertToFunction instanceof Supplier ? ((Supplier) functionCovertToFunction).get() : null;
            if (obj instanceof SparseArray) {
                return (List) MediationValueUtil.objectValue(((SparseArray) obj).get(8477), List.class, null);
            }
        }
        return new LinkedList();
    }

    public String getAndroidId() {
        ValueSet valueSet = this.hn;
        if (valueSet != null) {
            return valueSet.stringValue(8485);
        }
        return "";
    }

    public boolean isCanUseOaid() {
        Function<SparseArray<Object>, Object> functionCovertToFunction;
        ValueSet valueSet = this.hn;
        if (valueSet != null && (functionCovertToFunction = MediationValueUtil.covertToFunction(valueSet.objectValue(8311, Object.class))) != null) {
            Object obj = functionCovertToFunction instanceof Supplier ? ((Supplier) functionCovertToFunction).get() : null;
            if (obj instanceof SparseArray) {
                return ((Boolean) MediationValueUtil.objectValue(((SparseArray) obj).get(8478), Boolean.class, Boolean.FALSE)).booleanValue();
            }
            return true;
        }
        return true;
    }

    public String getDevOaid() {
        ValueSet valueSet = this.hn;
        if (valueSet != null) {
            return valueSet.stringValue(8486);
        }
        return "";
    }

    public String getMacAddress() {
        ValueSet valueSet = this.hn;
        if (valueSet != null) {
            return valueSet.stringValue(8487);
        }
        return "";
    }

    public boolean isCanUseWifiState() {
        ValueSet valueSet = this.hn;
        if (valueSet != null) {
            return valueSet.booleanValue(8480);
        }
        return true;
    }

    public boolean isCanUsePermissionRecordAudio() {
        ValueSet valueSet = this.hn;
        if (valueSet != null) {
            return valueSet.booleanValue(8549);
        }
        return true;
    }

    public List<String> getAppList() {
        Function<SparseArray<Object>, Object> functionCovertToFunction;
        ValueSet valueSet = this.hn;
        if (valueSet != null && (functionCovertToFunction = MediationValueUtil.covertToFunction(valueSet.objectValue(8311, Object.class))) != null) {
            Object obj = functionCovertToFunction instanceof Supplier ? ((Supplier) functionCovertToFunction).get() : null;
            if (obj instanceof SparseArray) {
                return (List) MediationValueUtil.objectValue(((SparseArray) obj).get(8476), List.class, null);
            }
        }
        return new LinkedList();
    }

    public Map<String, Object> userPrivacyConfig() {
        ValueSet valueSet = this.hn;
        if (valueSet != null) {
            return (Map) valueSet.objectValue(8554, Map.class);
        }
        return null;
    }

    public boolean isCanUseMessage() {
        ValueSet valueSet = this.hn;
        if (valueSet != null) {
            return valueSet.booleanValue(8562);
        }
        return true;
    }

    public int getAgeGroup() {
        if (c()) {
            return this.hw.intValue(7);
        }
        return 0;
    }

    public boolean isCustom() {
        if (c()) {
            return this.hw.booleanValue(8098);
        }
        return false;
    }

    public MediationCustomInitConfig getCustomInitConfig() {
        if (c()) {
            return (MediationCustomInitConfig) this.hw.objectValue(8099, MediationCustomInitConfig.class);
        }
        return null;
    }

    public ValueSet getCustomInitConfigValueSet() {
        if (c()) {
            return hn.pr((SparseArray<Object>) this.hw.objectValue(8545, SparseArray.class)).hw();
        }
        return null;
    }

    public Map getCustomInitMap() {
        if (c()) {
            return (Map) this.hw.objectValue(8400, Map.class);
        }
        return null;
    }

    public Function getCustomGMConfiguration() {
        if (c()) {
            return MediationValueUtil.covertToFunction(this.hw.objectValue(8401, Object.class));
        }
        return null;
    }

    public boolean isDebug() {
        ValueSet valueSet = this.hw;
        if (valueSet != null) {
            return valueSet.booleanValue(1);
        }
        return false;
    }

    public String getKsAdapterVersion() {
        ValueSet valueSet = this.hw;
        if (valueSet != null) {
            return valueSet.stringValue(8410);
        }
        return "";
    }

    public String getGromoreVersion() {
        ValueSet valueSet = this.hw;
        if (valueSet != null) {
            return valueSet.stringValue(8411);
        }
        return "";
    }

    public String getAdmobAdapterVersion() {
        ValueSet valueSet = this.hw;
        if (valueSet != null) {
            return valueSet.stringValue(8412);
        }
        return "";
    }

    public String getBaiduAdapterVersion() {
        ValueSet valueSet = this.hw;
        if (valueSet != null) {
            return valueSet.stringValue(8413);
        }
        return "";
    }

    public String getGdtAdapterVersion() {
        ValueSet valueSet = this.hw;
        if (valueSet != null) {
            return valueSet.stringValue(8414);
        }
        return "";
    }

    public String getKlevinAdapterVersion() {
        ValueSet valueSet = this.hw;
        if (valueSet != null) {
            return valueSet.stringValue(8415);
        }
        return "";
    }

    public String getMintegralAdapterVersion() {
        ValueSet valueSet = this.hw;
        if (valueSet != null) {
            return valueSet.stringValue(8416);
        }
        return "";
    }

    public String getSigmobAdapterVersion() {
        ValueSet valueSet = this.hw;
        if (valueSet != null) {
            return valueSet.stringValue(8417);
        }
        return "";
    }

    public String getUnityAdapterVersion() {
        ValueSet valueSet = this.hw;
        if (valueSet != null) {
            return valueSet.stringValue(8418);
        }
        return "";
    }

    public Map getInitAdnMap() {
        ValueSet valueSet = this.hw;
        if (valueSet != null) {
            return (Map) valueSet.objectValue(8425, Map.class);
        }
        return new HashMap();
    }

    public boolean getHttps() {
        ValueSet valueSet = this.x;
        if (valueSet != null) {
            return valueSet.booleanValue(8458);
        }
        return false;
    }

    public String getWxAppId() {
        ValueSet valueSet = this.x;
        if (valueSet != null) {
            return valueSet.stringValue(8459);
        }
        return "";
    }

    public String getPublisherDid() {
        ValueSet valueSet = this.x;
        if (valueSet != null) {
            return valueSet.stringValue(8460);
        }
        return "";
    }

    public boolean isOpenAdnTest() {
        ValueSet valueSet = this.x;
        if (valueSet != null) {
            return valueSet.booleanValue(8461);
        }
        return false;
    }

    public Function getMediationConfigUserInfoForSegment() {
        ValueSet valueSet = this.x;
        if (valueSet != null) {
            return MediationValueUtil.covertToFunction(valueSet.objectValue(8310, Object.class));
        }
        return null;
    }

    public Map getLocalExtra() {
        ValueSet valueSet = this.x;
        if (valueSet != null) {
            return (Map) valueSet.objectValue(8462, Map.class);
        }
        return new HashMap();
    }

    public JSONObject getCustomLocalConfig() {
        ValueSet valueSet = this.x;
        if (valueSet != null) {
            return (JSONObject) valueSet.objectValue(8463, JSONObject.class);
        }
        return null;
    }

    public String getOpensdkVer() {
        ValueSet valueSet = this.x;
        if (valueSet != null) {
            return valueSet.stringValue(8464);
        }
        return "";
    }

    public boolean isWxInstalled() {
        ValueSet valueSet = this.x;
        if (valueSet != null) {
            return valueSet.booleanValue(8465);
        }
        return false;
    }

    public boolean isSupportH265() {
        ValueSet valueSet = this.x;
        if (valueSet != null) {
            return valueSet.booleanValue(8466);
        }
        return false;
    }

    public boolean isSupportSplashZoomout() {
        ValueSet valueSet = this.x;
        if (valueSet != null) {
            return valueSet.booleanValue(8467);
        }
        return false;
    }

    public String getAdapterManagerClassName() {
        ValueSet valueSet = this.hw;
        if (valueSet != null) {
            return valueSet.stringValue(8560);
        }
        return null;
    }
}
