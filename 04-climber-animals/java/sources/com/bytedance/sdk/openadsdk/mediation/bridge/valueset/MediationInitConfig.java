package com.bytedance.sdk.openadsdk.mediation.bridge.valueset;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.bridge.IMediationLocation;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomInitConfig;
import com.bytedance.sdk.openadsdk.mediation.ms.xr;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class MediationInitConfig {
    private ValueSet ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ValueSet f3982ms;
    private ValueSet xr;

    private MediationInitConfig(ValueSet valueSet) {
        this.f3982ms = valueSet;
        if (valueSet != null) {
            this.ah = (ValueSet) valueSet.objectValue(8457, ValueSet.class);
            this.xr = (ValueSet) this.f3982ms.objectValue(8475, ValueSet.class);
        }
        ms();
    }

    private void ms() {
        MediationApiLog.setDebug(Boolean.valueOf(isDebug()));
        ah();
        d();
        xr();
    }

    private void xr() {
        MediationApiLog.i("---------  sdk 聚合信息 start ----");
        MediationApiLog.i("getHttps：" + getHttps());
        MediationApiLog.i("getWxAppId：" + getWxAppId());
        MediationApiLog.i("getPublisherDid：" + getPublisherDid());
        MediationApiLog.i("isOpenAdnTest：" + isOpenAdnTest());
        MediationApiLog.i("getMediationConfigUserInfoForSegment：" + getMediationConfigUserInfoForSegment());
        MediationApiLog.i("getLocalExtra：" + getLocalExtra());
        MediationApiLog.i("getCustomLocalConfig：" + getCustomLocalConfig());
        MediationApiLog.i("getOpensdkVer：" + getOpensdkVer());
        MediationApiLog.i("isWxInstalled：" + isWxInstalled());
        MediationApiLog.i("isSupportH265：" + isSupportH265());
        MediationApiLog.i("isSupportSplashZoomout：" + isSupportSplashZoomout());
        MediationApiLog.i("---------  sdk 聚合信息 end ----");
    }

    private void ah() {
        MediationApiLog.i("---------  sdk 初始化信息 start ----");
        MediationApiLog.i("isDebug：" + isDebug());
        MediationApiLog.i("getClassName：" + getClassName());
        MediationApiLog.i("getAppId：" + getAppId());
        MediationApiLog.i("getAppName：" + getAppName());
        MediationApiLog.i("getADNName：" + getADNName());
        MediationApiLog.i("getAppKey：" + getAppKey());
        MediationApiLog.i("getInitCallback：" + getInitCallback());
        MediationApiLog.i("getAgeGroup：" + getAgeGroup());
        MediationApiLog.i("isCustom：" + isCustom());
        MediationApiLog.i("getCustomInitConfig：" + getCustomInitConfig());
        MediationApiLog.i("getCustomInitMap：" + getCustomInitMap());
        MediationApiLog.i("getCustomGMConfiguration：" + getCustomGMConfiguration());
        MediationApiLog.i("getKsAdapterVersion：" + getKsAdapterVersion());
        MediationApiLog.i("getGromoreVersion：" + getGromoreVersion());
        MediationApiLog.i("getAdmobAdapterVersion：" + getAdmobAdapterVersion());
        MediationApiLog.i("getBaiduAdapterVersion：" + getBaiduAdapterVersion());
        MediationApiLog.i("getGdtAdapterVersion：" + getGdtAdapterVersion());
        MediationApiLog.i("getKlevinAdapterVersion：" + getKlevinAdapterVersion());
        MediationApiLog.i("getMintegralAdapterVersion：" + getMintegralAdapterVersion());
        MediationApiLog.i("getSigmobAdapterVersion：" + getSigmobAdapterVersion());
        MediationApiLog.i("getUnityAdapterVersion：" + getUnityAdapterVersion());
        MediationApiLog.i("getMap：" + getInitAdnMap());
        MediationApiLog.i("---------  sdk 初始化信息 end ----");
    }

    private void d() {
        MediationApiLog.i("---------  sdk 隐私设置 start ----");
        MediationApiLog.i("isCanUseLocation：" + isCanUseLocation());
        IMediationLocation location = getLocation();
        if (location != null) {
            MediationApiLog.i("getLocation getLatitude：" + location.getLatitude());
            MediationApiLog.i("getLocation getLongitude：" + location.getLongitude());
        } else {
            MediationApiLog.i("getLocation is null");
        }
        MediationApiLog.i("appList：" + appList());
        MediationApiLog.i("isCanUsePhoneState：" + isCanUsePhoneState());
        MediationApiLog.i("isLimitPersonalAds：" + isLimitPersonalAds());
        MediationApiLog.i("getDevImei：" + getDevImei());
        MediationApiLog.i("isCanUseWifiState：" + isCanUseWifiState());
        MediationApiLog.i("getMacAddress：" + getMacAddress());
        MediationApiLog.i("isCanUseWriteExternal：" + isCanUseWriteExternal());
        MediationApiLog.i("isCanUseAndroidId：" + isCanUseAndroidId());
        MediationApiLog.i("getAndroidId：" + getAndroidId());
        List<String> appList = getAppList();
        MediationApiLog.i("getAppList：".concat(String.valueOf(appList)));
        if (appList != null) {
            Iterator<String> it = appList.iterator();
            while (it.hasNext()) {
                MediationApiLog.i("getAppList item: ".concat(String.valueOf(it.next())));
            }
        }
        List<String> devImeis = getDevImeis();
        MediationApiLog.i("getDevImeis：".concat(String.valueOf(devImeis)));
        if (devImeis != null) {
            Iterator<String> it2 = devImeis.iterator();
            while (it2.hasNext()) {
                MediationApiLog.i("getDevImeis item: ".concat(String.valueOf(it2.next())));
            }
        }
        MediationApiLog.i("getDevOaid：" + getDevOaid());
        MediationApiLog.i("isCanUseOaid：" + isCanUseOaid());
        MediationApiLog.i("isCanUseMacAddress：" + isCanUseMacAddress());
        MediationApiLog.i("isProgrammaticRecommend：" + isProgrammaticRecommend());
        MediationApiLog.i("isCanUsePermissionRecordAudio：" + isCanUsePermissionRecordAudio());
        MediationApiLog.i("---------  sdk 隐私设置 end ----");
    }

    public static MediationInitConfig create(ValueSet valueSet) {
        return new MediationInitConfig(valueSet);
    }

    public void setMediationCustomControllerValueSet(ValueSet valueSet) {
        this.xr = valueSet;
        d();
    }

    public ValueSet getValueSet() {
        return this.f3982ms;
    }

    private boolean ka() {
        ValueSet valueSet = this.f3982ms;
        return (valueSet == null || valueSet.isEmpty()) ? false : true;
    }

    public String getClassName() {
        return ka() ? this.f3982ms.stringValue(AVMDLDataLoader.KeyIsLiveMobileUploadAllow) : "";
    }

    public String getAppId() {
        if (ka()) {
            return this.f3982ms.stringValue(3);
        }
        return null;
    }

    public String getAppName() {
        return ka() ? this.f3982ms.stringValue(8) : "";
    }

    public String getADNName() {
        return ka() ? this.f3982ms.stringValue(AVMDLDataLoader.KeyIsLiveGetPlayCacheSec) : "";
    }

    public String getAppKey() {
        return ka() ? this.f3982ms.stringValue(AVMDLDataLoader.KeyIsLiveWatchDurationThreshold) : "";
    }

    public Function getInitCallback() {
        if (ka()) {
            return xr.ms(this.f3982ms.objectValue(8300, Object.class));
        }
        return null;
    }

    public boolean isLimitPersonalAds() {
        Function<SparseArray<Object>, Object> functionMs;
        ValueSet valueSet = this.xr;
        if (valueSet == null || (functionMs = xr.ms(valueSet.objectValue(8311, Object.class))) == null) {
            return false;
        }
        Object obj = functionMs instanceof Supplier ? ((Supplier) functionMs).get() : null;
        if (obj instanceof SparseArray) {
            return ((Boolean) MediationValueUtil.objectValue(((SparseArray) obj).get(8027), Boolean.class, Boolean.FALSE)).booleanValue();
        }
        return false;
    }

    public boolean isCanUsePhoneState() {
        ValueSet valueSet = this.xr;
        if (valueSet != null) {
            return valueSet.booleanValue(8023);
        }
        return true;
    }

    public boolean isCanUseLocation() {
        ValueSet valueSet = this.xr;
        if (valueSet != null) {
            return valueSet.booleanValue(8024);
        }
        return true;
    }

    public boolean isCanUseWriteExternal() {
        ValueSet valueSet = this.xr;
        if (valueSet != null) {
            return valueSet.booleanValue(8025);
        }
        return true;
    }

    public boolean appList() {
        ValueSet valueSet = this.xr;
        if (valueSet != null) {
            return valueSet.booleanValue(8026);
        }
        return true;
    }

    public boolean isCanUseMacAddress() {
        return isCanUseWifiState();
    }

    public boolean isCanUseAndroidId() {
        ValueSet valueSet = this.xr;
        if (valueSet != null) {
            return valueSet.booleanValue(8479);
        }
        return true;
    }

    public boolean isProgrammaticRecommend() {
        Function<SparseArray<Object>, Object> functionMs;
        ValueSet valueSet = this.xr;
        if (valueSet == null || (functionMs = xr.ms(valueSet.objectValue(8311, Object.class))) == null) {
            return true;
        }
        Object obj = functionMs instanceof Supplier ? ((Supplier) functionMs).get() : null;
        if (obj instanceof SparseArray) {
            return ((Boolean) MediationValueUtil.objectValue(((SparseArray) obj).get(8028), Boolean.class, Boolean.FALSE)).booleanValue();
        }
        return true;
    }

    public IMediationLocation getLocation() {
        Function<SparseArray<Object>, Object> functionMs;
        ValueSet valueSet = this.xr;
        if (valueSet != null && (functionMs = xr.ms(valueSet.objectValue(8312, Object.class))) != null) {
            Object obj = functionMs instanceof Supplier ? ((Supplier) functionMs).get() : null;
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
        ValueSet valueSet = this.xr;
        return valueSet != null ? valueSet.stringValue(8484) : "";
    }

    public List<String> getDevImeis() {
        Function<SparseArray<Object>, Object> functionMs;
        ValueSet valueSet = this.xr;
        if (valueSet != null && (functionMs = xr.ms(valueSet.objectValue(8311, Object.class))) != null) {
            Object obj = functionMs instanceof Supplier ? ((Supplier) functionMs).get() : null;
            if (obj instanceof SparseArray) {
                return (List) MediationValueUtil.objectValue(((SparseArray) obj).get(8477), List.class, null);
            }
        }
        return new LinkedList();
    }

    public String getAndroidId() {
        ValueSet valueSet = this.xr;
        return valueSet != null ? valueSet.stringValue(8485) : "";
    }

    public boolean isCanUseOaid() {
        Function<SparseArray<Object>, Object> functionMs;
        ValueSet valueSet = this.xr;
        if (valueSet == null || (functionMs = xr.ms(valueSet.objectValue(8311, Object.class))) == null) {
            return true;
        }
        Object obj = functionMs instanceof Supplier ? ((Supplier) functionMs).get() : null;
        if (obj instanceof SparseArray) {
            return ((Boolean) MediationValueUtil.objectValue(((SparseArray) obj).get(8478), Boolean.class, Boolean.FALSE)).booleanValue();
        }
        return true;
    }

    public String getDevOaid() {
        ValueSet valueSet = this.xr;
        return valueSet != null ? valueSet.stringValue(8486) : "";
    }

    public String getMacAddress() {
        ValueSet valueSet = this.xr;
        return valueSet != null ? valueSet.stringValue(8487) : "";
    }

    public boolean isCanUseWifiState() {
        ValueSet valueSet = this.xr;
        if (valueSet != null) {
            return valueSet.booleanValue(8480);
        }
        return true;
    }

    public boolean isCanUsePermissionRecordAudio() {
        ValueSet valueSet = this.xr;
        if (valueSet != null) {
            return valueSet.booleanValue(8549);
        }
        return true;
    }

    public List<String> getAppList() {
        Function<SparseArray<Object>, Object> functionMs;
        ValueSet valueSet = this.xr;
        if (valueSet != null && (functionMs = xr.ms(valueSet.objectValue(8311, Object.class))) != null) {
            Object obj = functionMs instanceof Supplier ? ((Supplier) functionMs).get() : null;
            if (obj instanceof SparseArray) {
                return (List) MediationValueUtil.objectValue(((SparseArray) obj).get(8476), List.class, null);
            }
        }
        return new LinkedList();
    }

    public Map<String, Object> userPrivacyConfig() {
        ValueSet valueSet = this.xr;
        if (valueSet != null) {
            return (Map) valueSet.objectValue(8554, Map.class);
        }
        return null;
    }

    public int getAgeGroup() {
        if (ka()) {
            return this.f3982ms.intValue(7);
        }
        return 0;
    }

    public boolean isCustom() {
        if (ka()) {
            return this.f3982ms.booleanValue(8098);
        }
        return false;
    }

    public MediationCustomInitConfig getCustomInitConfig() {
        if (ka()) {
            return (MediationCustomInitConfig) this.f3982ms.objectValue(8099, MediationCustomInitConfig.class);
        }
        return null;
    }

    public ValueSet getCustomInitConfigValueSet() {
        if (ka()) {
            return (ValueSet) this.f3982ms.objectValue(8545, ValueSet.class);
        }
        return null;
    }

    public Map getCustomInitMap() {
        if (ka()) {
            return (Map) this.f3982ms.objectValue(8400, Map.class);
        }
        return null;
    }

    public Function getCustomGMConfiguration() {
        if (ka()) {
            return xr.ms(this.f3982ms.objectValue(8401, Object.class));
        }
        return null;
    }

    public boolean isDebug() {
        ValueSet valueSet = this.f3982ms;
        if (valueSet != null) {
            return valueSet.booleanValue(1);
        }
        return false;
    }

    public String getKsAdapterVersion() {
        ValueSet valueSet = this.f3982ms;
        return valueSet != null ? valueSet.stringValue(8410) : "";
    }

    public String getGromoreVersion() {
        ValueSet valueSet = this.f3982ms;
        return valueSet != null ? valueSet.stringValue(8411) : "";
    }

    public String getAdmobAdapterVersion() {
        ValueSet valueSet = this.f3982ms;
        return valueSet != null ? valueSet.stringValue(8412) : "";
    }

    public String getBaiduAdapterVersion() {
        ValueSet valueSet = this.f3982ms;
        return valueSet != null ? valueSet.stringValue(8413) : "";
    }

    public String getGdtAdapterVersion() {
        ValueSet valueSet = this.f3982ms;
        return valueSet != null ? valueSet.stringValue(8414) : "";
    }

    public String getKlevinAdapterVersion() {
        ValueSet valueSet = this.f3982ms;
        return valueSet != null ? valueSet.stringValue(8415) : "";
    }

    public String getMintegralAdapterVersion() {
        ValueSet valueSet = this.f3982ms;
        return valueSet != null ? valueSet.stringValue(8416) : "";
    }

    public String getSigmobAdapterVersion() {
        ValueSet valueSet = this.f3982ms;
        return valueSet != null ? valueSet.stringValue(8417) : "";
    }

    public String getUnityAdapterVersion() {
        ValueSet valueSet = this.f3982ms;
        return valueSet != null ? valueSet.stringValue(8418) : "";
    }

    public Map getInitAdnMap() {
        ValueSet valueSet = this.f3982ms;
        if (valueSet != null) {
            return (Map) valueSet.objectValue(8425, Map.class);
        }
        return new HashMap();
    }

    public boolean getHttps() {
        ValueSet valueSet = this.ah;
        if (valueSet != null) {
            return valueSet.booleanValue(8458);
        }
        return false;
    }

    public String getWxAppId() {
        ValueSet valueSet = this.ah;
        return valueSet != null ? valueSet.stringValue(8459) : "";
    }

    public String getPublisherDid() {
        ValueSet valueSet = this.ah;
        return valueSet != null ? valueSet.stringValue(8460) : "";
    }

    public boolean isOpenAdnTest() {
        ValueSet valueSet = this.ah;
        if (valueSet != null) {
            return valueSet.booleanValue(8461);
        }
        return false;
    }

    public Function getMediationConfigUserInfoForSegment() {
        ValueSet valueSet = this.ah;
        if (valueSet != null) {
            return xr.ms(valueSet.objectValue(8310, Object.class));
        }
        return null;
    }

    public Map getLocalExtra() {
        ValueSet valueSet = this.ah;
        if (valueSet != null) {
            return (Map) valueSet.objectValue(8462, Map.class);
        }
        return new HashMap();
    }

    public JSONObject getCustomLocalConfig() {
        ValueSet valueSet = this.ah;
        if (valueSet != null) {
            return (JSONObject) valueSet.objectValue(8463, JSONObject.class);
        }
        return null;
    }

    public String getOpensdkVer() {
        ValueSet valueSet = this.ah;
        return valueSet != null ? valueSet.stringValue(8464) : "";
    }

    public boolean isWxInstalled() {
        ValueSet valueSet = this.ah;
        if (valueSet != null) {
            return valueSet.booleanValue(8465);
        }
        return false;
    }

    public boolean isSupportH265() {
        ValueSet valueSet = this.ah;
        if (valueSet != null) {
            return valueSet.booleanValue(8466);
        }
        return false;
    }

    public boolean isSupportSplashZoomout() {
        ValueSet valueSet = this.ah;
        if (valueSet != null) {
            return valueSet.booleanValue(8467);
        }
        return false;
    }
}
