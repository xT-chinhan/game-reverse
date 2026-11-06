package com.anythink.unitybridge.sdkinit;

import android.app.Activity;
import android.app.Application;
import android.location.Location;
import android.text.TextUtils;
import com.alliance.ssp.ad.api.SAAllianceAdInitParams;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.ATSDKGlobalSetting;
import com.anythink.core.api.ATUserDeviceInfo;
import com.anythink.network.aqy.AqyATInitManager;
import com.anythink.network.baidu.BaiduATCustomController;
import com.anythink.network.baidu.BaiduATInitManager;
import com.anythink.network.beizi.BzATInitManager;
import com.anythink.network.fanwei.FwATInitManager;
import com.anythink.network.funlink.FunlinkATInitManager;
import com.anythink.network.gdt.GDTATCustomController;
import com.anythink.network.gdt.GDTATInitManager;
import com.anythink.network.gtm.GTMATCustomController;
import com.anythink.network.gtm.GTMATInitManager;
import com.anythink.network.jingdong.JADATInitManager;
import com.anythink.network.jutui.JTATInitManager;
import com.anythink.network.ks.KSATCustomController;
import com.anythink.network.ks.KSATInitManager;
import com.anythink.network.lingye.LyATInitManager;
import com.anythink.network.meishu.MsATInitManager;
import com.anythink.network.mimo.MimoATInitManager;
import com.anythink.network.octopus.ZyATInitManager;
import com.anythink.network.oppo.OppoATInitManager;
import com.anythink.network.qumeng.QMATInitManager;
import com.anythink.network.sigmob.SigmobATInitManager;
import com.anythink.network.tanx.TanxATCustomController;
import com.anythink.network.tanx.TanxATInitManager;
import com.anythink.network.tap.TapATInitManager;
import com.anythink.network.toutiao.TTATInitManager;
import com.anythink.network.ubix.UbATInitManager;
import com.anythink.network.vivo.VivoATInitManager;
import com.anythink.network.youtui.YtATInitManager;
import com.anythink.unitybridge.MsgTools;
import com.anythink.unitybridge.UnityPluginUtils;
import com.beizi.ad.model.BeiZiLocation;
import com.beizi.fusion.BeiZiCustomController;
import com.bytedance.sdk.openadsdk.LocationProvider;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.fl.saas.adx.api.FLParamConfig;
import com.fl.saas.adx.base.bean.CustomLocation;
import com.heytap.msp.mobad.api.MobCustomController;
import com.jd.ad.sdk.bl.initsdk.JADPrivateController;
import com.jd.ad.sdk.dl.baseinfo.JADLocation;
import com.jutui.ads.core.JuTuiLocation;
import com.jutui.ads.core.JuTuiPrivacyController;
import com.mcto.sspsdk.QyCustomMade;
import com.meishu.sdk.core.MSAdConfig;
import com.miui.zeus.mimo.sdk.MimoCustomController;
import com.miui.zeus.mimo.sdk.MimoLocation;
import com.octopus.ad.OctopusAdSdkController;
import com.octopus.ad.model.OctLocation;
import com.octopus.ad.model.ShakeValue;
import com.qumeng.advlib.core.QMCustomControl;
import com.sigmob.windad.WindCustomController;
import com.tapsdk.tapad.TapAdCustomController;
import com.tapsdk.tapad.TapAdLocation;
import com.tk.adsdk.lib.interf.PtgCustomController;
import com.tk.adsdk.lib.model.AdLocation;
import com.ubix.ssp.open.UBiXAdPrivacyManager;
import com.vivo.mobilead.model.VCustomController;
import com.vivo.mobilead.model.VLocation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class AdSourcePrivacyPolicyStore {
    private static final int FIRM_AQY = 94;
    private static final int FIRM_BAIDU = 22;
    private static final int FIRM_BEIZI = 95;
    private static final int FIRM_FANWEI = 102;
    private static final int FIRM_FUNLINK = 97;
    private static final int FIRM_GDT = 8;
    private static final int FIRM_GTM = 6;
    private static final int[] FIRM_ID_APPLY_ORDER = {8, 22, 28, 82, 15, 29, 80, 79, 95, 93, 69, 51, 96, 74, 72, 102, 6, 94, 49, 97, 106, 107, 109, 101};
    private static final int FIRM_JD = 72;
    private static final int FIRM_JUTUI = 109;
    private static final int FIRM_KLEVIN = 51;
    private static final int FIRM_KS = 28;
    private static final int FIRM_LINGYE = 101;
    private static final int FIRM_MEISHU = 93;
    private static final int FIRM_MIMO = 49;
    private static final int FIRM_OCTOPUS = 96;
    private static final int FIRM_OPPO = 80;
    private static final int FIRM_QUMENG = 74;
    private static final int FIRM_SIGMOB = 29;
    private static final int FIRM_TANX = 82;
    private static final int FIRM_TAP = 69;
    private static final int FIRM_TT = 15;
    private static final int FIRM_UBIX = 106;
    private static final int FIRM_VIVO = 79;
    private static final int FIRM_YOUTUI = 107;
    private static final String KEY_NETWORK_FIRM_IDS = "networkFirmIds";
    private static volatile String sPolicyJson;

    private static void applyKlevin(JSONObject jSONObject) {
    }

    private static final class Keys {
        private static final String AD_MUTED = "isAdMuted";
        private static final String AGREE_PRIVACY_STRATEGY = "agreePrivacyStrategy";
        private static final String ALLOW_HARD_DISK_SIZE_KBYTES = "isAllowHardDiskSizeKBytes";
        private static final String CAN_PERSONAL_RECOMMEND = "isCanPersonalRecommend";
        private static final String CAN_SHAKE = "isCanShake";
        private static final String CAN_USE_ANDROID_ID = "isCanUseAndroidId";
        private static final String CAN_USE_APP_LIST = "isCanUseAppList";
        private static final String CAN_USE_GENERAL_DATA = "isCanUseGeneralData";
        private static final String CAN_USE_IP = "isCanUseIp";
        private static final String CAN_USE_LOCATION = "isCanUseLocation";
        private static final String CAN_USE_MAC_ADDRESS = "isCanUseMacAddress";
        private static final String CAN_USE_OAID = "isCanUseOaid";
        private static final String CAN_USE_PHONE_STATE = "isCanUsePhoneState";
        private static final String CAN_USE_RECORD_AUDIO = "isCanUsePermissionRecordAudio";
        private static final String CAN_USE_WIFI_STATE = "isCanUseWifiState";
        private static final String CAN_USE_WRITE_EXTERNAL = "isCanUseWriteExternal";
        private static final String CUSTOM_ANDROID_ID = "customAndroidId";
        private static final String CUSTOM_IMEI = "customIMEI";
        private static final String CUSTOM_IP = "customIp";
        private static final String CUSTOM_LOCATION = "customLocation";
        private static final String CUSTOM_MAC_ADDRESS = "customMacAddress";
        private static final String CUSTOM_OAID = "customOaid";
        private static final String FORBID_SENSOR = "forbidSensor";
        private static final String ID_ALL_SWITCH = "idAllSwitch";
        private static final String LATITUDE = "latitude";
        private static final String LONGITUDE = "longitude";
        private static final String SHAKE_ACCELERATION = "acceleration";
        private static final String SHAKE_ANGLE = "angle";
        private static final String SHAKE_TIME = "time";
        private static final String SHAKE_VALUE = "shakeValue";

        private Keys() {
        }
    }

    private AdSourcePrivacyPolicyStore() {
    }

    public static synchronized void setPolicyJson(String str) {
        if (TextUtils.isEmpty(str)) {
            sPolicyJson = null;
            return;
        }
        if (TextUtils.equals(str, sPolicyJson)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            MsgTools.printMsg("setPolicyJson : " + str);
            applyToAvailableNetworks(jSONObject);
            sPolicyJson = str;
        } catch (Throwable th) {
            MsgTools.printMsg("setPolicyJson parse error: " + th.getMessage());
        }
    }

    public static String getPolicyJson() {
        return sPolicyJson;
    }

    private static void applyToAvailableNetworks(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            HashSet<Integer> networkFirmIdFilter = parseNetworkFirmIdFilter(jSONObject);
            applyGlobalSettings(jSONObject, networkFirmIdFilter);
            for (int i : FIRM_ID_APPLY_ORDER) {
                if (filterAllows(i, networkFirmIdFilter)) {
                    applyForFirmId(i, jSONObject);
                }
            }
            ATUserDeviceInfo aTUserDeviceInfo = new ATUserDeviceInfo();
            aTUserDeviceInfo.setDevImei(optString(jSONObject, "customIMEI"));
            aTUserDeviceInfo.setDevOaid(optString(jSONObject, "customOaid"));
            ATSDK.setATUserDeviceInfo(aTUserDeviceInfo);
        } catch (Throwable th) {
            MsgTools.printMsg("applyToAvailableNetworks apply error: " + th.getMessage());
        }
    }

    private static void applyGlobalSettings(JSONObject jSONObject, HashSet<Integer> hashSet) {
        ATSDKGlobalSetting.SHAKE_TYPE shake_type;
        ATSDKGlobalSetting.SHAKE_TYPE shake_type2;
        if (jSONObject == null) {
            return;
        }
        if (hashSet == null) {
            try {
                if (jSONObject.has("isAdMuted")) {
                    ATSDKGlobalSetting.setAdMuted(Boolean.valueOf(optBoolean(jSONObject, "isAdMuted", false)));
                }
            } catch (Throwable th) {
                logApplyThrowable("applyGlobalSettings", th);
                return;
            }
        }
        if (jSONObject.has("isCanShake")) {
            boolean zOptBoolean = optBoolean(jSONObject, "isCanShake", true);
            if (hashSet == null) {
                ArrayList arrayList = new ArrayList();
                for (int i : FIRM_ID_APPLY_ORDER) {
                    arrayList.add(String.valueOf(i));
                }
                if (zOptBoolean) {
                    shake_type2 = ATSDKGlobalSetting.SHAKE_TYPE.ALLOW_ALL;
                } else {
                    shake_type2 = ATSDKGlobalSetting.SHAKE_TYPE.FORBID_ALL;
                }
                ATSDKGlobalSetting.setShakeControl(shake_type2, arrayList);
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<Integer> it = hashSet.iterator();
            while (it.hasNext()) {
                arrayList2.add(String.valueOf(it.next()));
            }
            if (zOptBoolean) {
                shake_type = ATSDKGlobalSetting.SHAKE_TYPE.ALLOW_NETWORK;
            } else {
                shake_type = ATSDKGlobalSetting.SHAKE_TYPE.FORBID_ALL;
            }
            ATSDKGlobalSetting.setShakeControl(shake_type, arrayList2);
        }
    }

    private static void logApplyThrowable(String str, Throwable th) {
        MsgTools.printMsg(str + " error: " + (th == null ? "" : th.getMessage()));
    }

    private static HashSet<Integer> parseNetworkFirmIdFilter(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject == null || !jSONObject.has(KEY_NETWORK_FIRM_IDS) || (jSONArrayOptJSONArray = jSONObject.optJSONArray(KEY_NETWORK_FIRM_IDS)) == null || jSONArrayOptJSONArray.length() == 0) {
            return null;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            int iOptInt = jSONArrayOptJSONArray.optInt(i, Integer.MIN_VALUE);
            if (iOptInt != Integer.MIN_VALUE) {
                hashSet.add(Integer.valueOf(iOptInt));
            }
        }
        if (hashSet.isEmpty()) {
            return null;
        }
        return hashSet;
    }

    private static boolean filterAllows(int i, HashSet<Integer> hashSet) {
        if (hashSet == null) {
            return true;
        }
        return hashSet.contains(Integer.valueOf(i));
    }

    private static void applyForFirmId(int i, JSONObject jSONObject) {
        if (i == 6) {
            applyGtm(jSONObject);
            return;
        }
        if (i == 8) {
            applyGdt(jSONObject);
            return;
        }
        if (i == 15) {
            applyTt(jSONObject);
            return;
        }
        if (i == 22) {
            applyBaidu(jSONObject);
            return;
        }
        if (i == 49) {
            applyMimo(jSONObject);
            return;
        }
        if (i == 69) {
            applyTap(jSONObject);
            return;
        }
        if (i == 72) {
            applyJd(jSONObject);
            return;
        }
        if (i == 74) {
            applyQumeng(jSONObject);
            return;
        }
        if (i == 82) {
            applyTanx(jSONObject);
            return;
        }
        if (i == 109) {
            applyJutui(jSONObject);
            return;
        }
        if (i == 28) {
            applyKs(jSONObject);
            return;
        }
        if (i == 29) {
            applySigmob(jSONObject);
            return;
        }
        if (i == 79) {
            applyVivo(jSONObject);
            return;
        }
        if (i == 80) {
            applyOppo(jSONObject);
            return;
        }
        if (i == 101) {
            applyLingye(jSONObject);
            return;
        }
        if (i == 102) {
            applyFanwei(jSONObject);
            return;
        }
        if (i == 106) {
            applyUbix(jSONObject);
            return;
        }
        if (i != 107) {
            switch (i) {
                case 93:
                    applyMeishu(jSONObject);
                    break;
                case 94:
                    applyAqy(jSONObject);
                    break;
                case 95:
                    applyBeizi(jSONObject);
                    break;
                case 96:
                    applyOctopus(jSONObject);
                    break;
                case 97:
                    applyFunlink(jSONObject);
                    break;
            }
            return;
        }
        applyYoutui(jSONObject);
    }

    private static void applyFunlink(JSONObject jSONObject) {
        try {
            boolean zOptBoolean = optBoolean(jSONObject, "isCanUsePhoneState", false);
            FLParamConfig.Builder builder = (FLParamConfig.Builder) ((FLParamConfig.Builder) ((FLParamConfig.Builder) ((FLParamConfig.Builder) ((FLParamConfig.Builder) ((FLParamConfig.Builder) ((FLParamConfig.Builder) ((FLParamConfig.Builder) ((FLParamConfig.Builder) ((FLParamConfig.Builder) ((FLParamConfig.Builder) ((FLParamConfig.Builder) new FLParamConfig.Builder().setCanUseSSID(optBoolean(jSONObject, "isCanUseWifiState", false))).setCanUseAndroid(optBoolean(jSONObject, "isCanUseAndroidId", false))).setCanUseMac(optBoolean(jSONObject, "isCanUseMacAddress", false))).setCanUseIMEI(zOptBoolean)).setCanUseIMSI(zOptBoolean)).setCanUseLocation(optBoolean(jSONObject, "isCanUseLocation", false))).setCanUseOaid(optBoolean(jSONObject, "isCanUseOaid", false))).setCanUseSensor(!optBoolean(jSONObject, "forbidSensor", false))).setCustomAndroidId(optString(jSONObject, "customAndroidId"))).setCustomIMEI(optString(jSONObject, "customIMEI"))).setCustomOaid(optString(jSONObject, "customOaid"))).setCustomMac(optString(jSONObject, "customMacAddress"));
            double[] dArr = new double[2];
            if (readCustomLocation(jSONObject, dArr)) {
                builder.setCustomLocation(new CustomLocation(dArr[0], dArr[1]));
            }
            FunlinkATInitManager.getInstance().setFunlinkParamConfigBuilder(builder);
        } catch (Throwable th) {
            logApplyThrowable("applyFunlink", th);
        }
    }

    private static void applyUbix(JSONObject jSONObject) {
        try {
            UBiXAdPrivacyManager.Builder personalizedState = new UBiXAdPrivacyManager.Builder().setCanGetAppList(optBoolean(jSONObject, "isCanUseAppList", false)).setCanUseLocation(optBoolean(jSONObject, "isCanUseLocation", false)).setCanUseWifiState(optBoolean(jSONObject, "isCanUseWifiState", false)).setCanUseWriteExternal(optBoolean(jSONObject, "isCanUseWriteExternal", false)).setCanUseMacAddress(optBoolean(jSONObject, "isCanUseMacAddress", false)).setCanUseAndroidId(optBoolean(jSONObject, "isCanUseAndroidId", false)).setCanUseOaid(optBoolean(jSONObject, "isCanUseOaid", false)).setCanUsePhoneState(optBoolean(jSONObject, "isCanUsePhoneState", false)).setDevImei(optString(jSONObject, "customIMEI")).setDevOaid(optString(jSONObject, "customOaid")).setAndroidId(optString(jSONObject, "customAndroidId")).setMacAddress(optString(jSONObject, "customMacAddress")).setPersonalizedState(optBoolean(jSONObject, "isCanPersonalRecommend", false) ? 0 : 1);
            double[] dArr = new double[2];
            if (readCustomLocation(jSONObject, dArr)) {
                personalizedState.setLocation(dArr[1], dArr[0]);
            }
            UbATInitManager.getInstance().setUBiXAdPrivacyManager(personalizedState.build());
        } catch (Throwable th) {
            logApplyThrowable("applyUbix", th);
        }
    }

    private static void applyYoutui(JSONObject jSONObject) {
        try {
            SAAllianceAdInitParams.Builder customMacAddress = new SAAllianceAdInitParams.Builder().setCanUseInstallAppList(optBoolean(jSONObject, "isCanUseAppList", false)).setDebug(ATSDK.isNetworkLogDebug()).setEnablePersonalized(optBoolean(jSONObject, "isCanPersonalRecommend", false)).setCanUseIMei(optBoolean(jSONObject, "isCanUsePhoneState", false)).setCanUseOaid(optBoolean(jSONObject, "isCanUseOaid", false)).setCanUseMac(optBoolean(jSONObject, "isCanUseMacAddress", false)).setCanUseCarrier(optBoolean(jSONObject, "isCanUsePhoneState", false)).setCanUseWifiState(optBoolean(jSONObject, "isCanUseWifiState", false)).setCanUseLocation(optBoolean(jSONObject, "isCanUseLocation", false)).setCanUseMotionSensor(!optBoolean(jSONObject, "forbidSensor", false)).setCustomImei(optString(jSONObject, "customIMEI")).setCustomOaid(optString(jSONObject, "customOaid")).setCustomMacAddress(optString(jSONObject, "customMacAddress"));
            double[] dArr = new double[2];
            if (readCustomLocation(jSONObject, dArr)) {
                customMacAddress.setCustomLocation(new double[]{dArr[1], dArr[0]});
            }
            YtATInitManager.getInstance().setCustomInitParams(customMacAddress.build());
        } catch (Throwable th) {
            logApplyThrowable("applyYoutui", th);
        }
    }

    private static void applyJutui(final JSONObject jSONObject) {
        try {
            JTATInitManager.getInstance().setJuTuiCustomController(new JuTuiPrivacyController() { // from class: com.anythink.unitybridge.sdkinit.AdSourcePrivacyPolicyStore.1
                public boolean isCanGetOaid() {
                    return AdSourcePrivacyPolicyStore.isCanUseOaidEffective(jSONObject);
                }

                public String getOaid() {
                    return AdSourcePrivacyPolicyStore.optString(jSONObject, "customOaid");
                }

                public boolean isCanUseAndroidId() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseAndroidId", false);
                }

                public String getAndroidId() {
                    return AdSourcePrivacyPolicyStore.optString(jSONObject, "customAndroidId");
                }

                public boolean isCanUsePhoneState() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUsePhoneState", false);
                }

                public String getDevImei() {
                    return AdSourcePrivacyPolicyStore.optString(jSONObject, "customIMEI");
                }

                public boolean isCanGetMacAddress() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseMacAddress", false);
                }

                public String getMacAddress() {
                    return AdSourcePrivacyPolicyStore.optString(jSONObject, "customMacAddress");
                }

                public boolean isCanUseWifiState() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseWifiState", false);
                }

                public boolean isCanUseLocation() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseLocation", false);
                }

                public JuTuiLocation getLocation() {
                    final double[] dArr = new double[2];
                    if (AdSourcePrivacyPolicyStore.readCustomLocation(jSONObject, dArr)) {
                        return new JuTuiLocation() { // from class: com.anythink.unitybridge.sdkinit.AdSourcePrivacyPolicyStore.1.1
                            public String getLatitude() {
                                return String.valueOf(dArr[0]);
                            }

                            public String getLongitude() {
                                return String.valueOf(dArr[1]);
                            }
                        };
                    }
                    return null;
                }

                public boolean isCanGetAppList() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseAppList", false);
                }

                public boolean isCanUseWriteExternal() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseWriteExternal", false);
                }

                public boolean isCanUseSimOperator() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUsePhoneState", false);
                }

                public boolean isCanUseDevSpaceSize() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isAllowHardDiskSizeKBytes", false);
                }
            });
        } catch (Throwable th) {
            logApplyThrowable("applyJutui", th);
        }
    }

    private static void applyMimo(final JSONObject jSONObject) {
        try {
            MimoATInitManager.getInstance().setMimoCustomController(new MimoCustomController() { // from class: com.anythink.unitybridge.sdkinit.AdSourcePrivacyPolicyStore.2
                public boolean isCanUseLocation() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseLocation", false);
                }

                public MimoLocation getMimoLocation() {
                    if (AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseLocation", false)) {
                        return null;
                    }
                    double[] dArr = new double[2];
                    if (AdSourcePrivacyPolicyStore.readCustomLocation(jSONObject, dArr)) {
                        return new MimoLocation(dArr[0], dArr[1]);
                    }
                    return null;
                }

                public boolean isCanUseWifiState() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseWifiState", false);
                }

                public boolean alist() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseAppList", false);
                }
            });
        } catch (Throwable th) {
            logApplyThrowable("applyMimo", th);
        }
    }

    private static void applyGdt(final JSONObject jSONObject) {
        try {
            GDTATInitManager.getInstance().setGDTATCustomController(new GDTATCustomController() { // from class: com.anythink.unitybridge.sdkinit.AdSourcePrivacyPolicyStore.3
                @Override // com.anythink.network.gdt.GDTATCustomController
                public boolean getAgreePrivacyStrategy() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "agreePrivacyStrategy", true);
                }

                @Override // com.anythink.network.gdt.GDTATCustomController
                public boolean isCanUseAndroidId() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseAndroidId", false);
                }

                @Override // com.anythink.network.gdt.GDTATCustomController
                public boolean isCanUseDeviceId() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUsePhoneState", false);
                }

                @Override // com.anythink.network.gdt.GDTATCustomController
                public boolean isCanUseMacAddress() {
                    return AdSourcePrivacyPolicyStore.isCanUseMacAddressEffective(jSONObject);
                }
            });
        } catch (Throwable th) {
            logApplyThrowable("applyGdt", th);
        }
    }

    private static void applyKs(final JSONObject jSONObject) {
        try {
            KSATInitManager.getInstance().setKSATCustomController(new KSATCustomController() { // from class: com.anythink.unitybridge.sdkinit.AdSourcePrivacyPolicyStore.4
                @Override // com.anythink.network.ks.KSATCustomController
                public boolean getCanReadICCID() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUsePhoneState", false);
                }

                @Override // com.anythink.network.ks.KSATCustomController
                public boolean getCanReadMacAddress() {
                    return AdSourcePrivacyPolicyStore.isCanUseMacAddressEffective(jSONObject);
                }

                @Override // com.anythink.network.ks.KSATCustomController
                public boolean getCanReadNearbyWifiList() {
                    return AdSourcePrivacyPolicyStore.shouldAllowNearbyWifiList(jSONObject);
                }
            });
        } catch (Throwable th) {
            logApplyThrowable("applyKs", th);
        }
    }

    private static void applyBaidu(final JSONObject jSONObject) {
        try {
            BaiduATInitManager.getInstance().setBaiduATCustomController(new BaiduATCustomController() { // from class: com.anythink.unitybridge.sdkinit.AdSourcePrivacyPolicyStore.5
                public boolean getPermissionReadDeviceID() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUsePhoneState", false);
                }

                public boolean getPermissionLocation() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseLocation", false);
                }

                public boolean getPermissionStorage() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseWriteExternal", false);
                }

                public boolean getPermissionAppList() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseAppList", false);
                }

                public boolean getPermissionOAID() {
                    return AdSourcePrivacyPolicyStore.isCanUseOaidEffective(jSONObject);
                }

                public boolean getPermissionDeviceInfo() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUsePhoneState", false);
                }

                public boolean getPermissionAppUpdate() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseAppList", false);
                }

                public boolean getPermissionRunningApp() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseAppList", false);
                }
            });
        } catch (Throwable th) {
            logApplyThrowable("applyBaidu", th);
        }
    }

    private static void applyTanx(final JSONObject jSONObject) {
        try {
            TanxATInitManager.getInstance().setCustomController(new TanxATCustomController() { // from class: com.anythink.unitybridge.sdkinit.AdSourcePrivacyPolicyStore.6
                public String getImei() {
                    return AdSourcePrivacyPolicyStore.optString(jSONObject, "customIMEI");
                }

                public String getOaid() {
                    return AdSourcePrivacyPolicyStore.optString(jSONObject, "customOaid");
                }

                public boolean oaidSwitch() {
                    return AdSourcePrivacyPolicyStore.isCanUseOaidEffective(jSONObject);
                }

                public boolean imeiSwitch() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUsePhoneState", false);
                }

                public boolean idAllSwitch() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "idAllSwitch", false);
                }
            });
        } catch (Throwable th) {
            logApplyThrowable("applyTanx", th);
        }
    }

    private static void applyTt(final JSONObject jSONObject) {
        try {
            TTATInitManager.getInstance().setTtCustomController(new TTCustomController() { // from class: com.anythink.unitybridge.sdkinit.AdSourcePrivacyPolicyStore.7
                @Override // com.bytedance.sdk.openadsdk.TTCustomController
                public boolean isCanUseLocation() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseLocation", false);
                }

                @Override // com.bytedance.sdk.openadsdk.TTCustomController
                public boolean isCanUsePhoneState() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUsePhoneState", false);
                }

                @Override // com.bytedance.sdk.openadsdk.TTCustomController
                public String getDevImei() {
                    return AdSourcePrivacyPolicyStore.optString(jSONObject, "customIMEI");
                }

                @Override // com.bytedance.sdk.openadsdk.TTCustomController
                public boolean isCanUseWifiState() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseWifiState", false);
                }

                @Override // com.bytedance.sdk.openadsdk.TTCustomController
                public String getMacAddress() {
                    return AdSourcePrivacyPolicyStore.optString(jSONObject, "customMacAddress");
                }

                @Override // com.bytedance.sdk.openadsdk.TTCustomController
                public boolean isCanUseWriteExternal() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseWriteExternal", false);
                }

                @Override // com.bytedance.sdk.openadsdk.TTCustomController
                public String getDevOaid() {
                    return AdSourcePrivacyPolicyStore.optString(jSONObject, "customOaid");
                }

                @Override // com.bytedance.sdk.openadsdk.TTCustomController
                public boolean isCanUseAndroidId() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseAndroidId", false);
                }

                @Override // com.bytedance.sdk.openadsdk.TTCustomController
                public String getAndroidId() {
                    return AdSourcePrivacyPolicyStore.optString(jSONObject, "customAndroidId");
                }

                @Override // com.bytedance.sdk.openadsdk.TTCustomController
                public boolean isCanUsePermissionRecordAudio() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUsePermissionRecordAudio", false);
                }

                @Override // com.bytedance.sdk.openadsdk.TTCustomController
                public boolean alist() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseAppList", false);
                }
            });
        } catch (Throwable th) {
            logApplyThrowable("applyTt", th);
        }
    }

    private static void applySigmob(final JSONObject jSONObject) {
        try {
            SigmobATInitManager.getInstance().setWindCustomController(new WindCustomController() { // from class: com.anythink.unitybridge.sdkinit.AdSourcePrivacyPolicyStore.8
                public boolean isCanUseLocation() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseLocation", false);
                }

                public Location getLocation() {
                    double[] dArr = new double[2];
                    if (!AdSourcePrivacyPolicyStore.readCustomLocation(jSONObject, dArr)) {
                        return null;
                    }
                    Location location = new Location("policy");
                    location.setLatitude(dArr[0]);
                    location.setLongitude(dArr[1]);
                    return location;
                }

                public boolean isCanUseOaid() {
                    return AdSourcePrivacyPolicyStore.isCanUseOaidEffective(jSONObject);
                }

                public String getDevOaid() {
                    return AdSourcePrivacyPolicyStore.optString(jSONObject, "customOaid");
                }

                public boolean isCanUseAndroidId() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseAndroidId", false);
                }

                public String getAndroidId() {
                    return AdSourcePrivacyPolicyStore.optString(jSONObject, "customAndroidId");
                }

                public boolean isCanUseAppList() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseAppList", false);
                }

                public boolean isCanUseSimOperator() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUsePhoneState", false);
                }

                public boolean isCanUseSpaceSize() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isAllowHardDiskSizeKBytes", false);
                }
            });
        } catch (Throwable th) {
            logApplyThrowable("applySigmob", th);
        }
    }

    private static void applyOppo(final JSONObject jSONObject) {
        try {
            OppoATInitManager.getInstance().setCustomController(new MobCustomController() { // from class: com.anythink.unitybridge.sdkinit.AdSourcePrivacyPolicyStore.9
                public String getDevImei() {
                    return AdSourcePrivacyPolicyStore.optString(jSONObject, "customIMEI");
                }

                public boolean isCanUseLocation() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseLocation", false);
                }

                public MobCustomController.LocationProvider getLocation() {
                    final double[] dArr = new double[2];
                    if (AdSourcePrivacyPolicyStore.readCustomLocation(jSONObject, dArr)) {
                        return new MobCustomController.LocationProvider() { // from class: com.anythink.unitybridge.sdkinit.AdSourcePrivacyPolicyStore.9.1
                            public double getLatitude() {
                                return dArr[0];
                            }

                            public double getLongitude() {
                                return dArr[1];
                            }
                        };
                    }
                    return null;
                }

                public boolean isCanUsePhoneState() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUsePhoneState", false);
                }

                public boolean isCanUseAndroidId() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseAndroidId", false);
                }

                public String getAndroidId() {
                    return AdSourcePrivacyPolicyStore.optString(jSONObject, "customAndroidId");
                }

                public boolean isCanUseWifiState() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseWifiState", false);
                }

                public String getMacAddress() {
                    return AdSourcePrivacyPolicyStore.optString(jSONObject, "customMacAddress");
                }

                public boolean isCanUseWriteExternal() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseWriteExternal", false);
                }

                public boolean alist() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseAppList", false);
                }
            });
        } catch (Throwable th) {
            logApplyThrowable("applyOppo", th);
        }
    }

    private static void applyVivo(final JSONObject jSONObject) {
        try {
            VivoATInitManager.getInstance().setCustomController(new VCustomController() { // from class: com.anythink.unitybridge.sdkinit.AdSourcePrivacyPolicyStore.10
                public boolean isCanUseLocation() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseLocation", false);
                }

                public VLocation getLocation() {
                    double[] dArr = new double[2];
                    if (AdSourcePrivacyPolicyStore.readCustomLocation(jSONObject, dArr)) {
                        return new VLocation(dArr[0], dArr[1]);
                    }
                    return null;
                }

                public boolean isCanUsePhoneState() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUsePhoneState", false);
                }

                public String getImei() {
                    return AdSourcePrivacyPolicyStore.optString(jSONObject, "customIMEI");
                }

                public boolean isCanUseWriteExternal() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseWriteExternal", false);
                }

                public boolean isCanPersonalRecommend() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanPersonalRecommend", false);
                }

                public boolean isCanUseImsi() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUsePhoneState", false);
                }

                public boolean isCanUseApplist() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseAppList", false);
                }

                public boolean isCanUseAndroidId() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseAndroidId", false);
                }

                public boolean isCanUseMac() {
                    return AdSourcePrivacyPolicyStore.isCanUseMacAddressEffective(jSONObject);
                }

                public boolean isCanUseIp() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseIp", false);
                }

                public String getOaid() {
                    return AdSourcePrivacyPolicyStore.optString(jSONObject, "customOaid");
                }
            });
        } catch (Throwable th) {
            logApplyThrowable("applyVivo", th);
        }
    }

    private static void applyBeizi(final JSONObject jSONObject) {
        try {
            BzATInitManager.getInstance().setBeiZiCustomController(new BeiZiCustomController() { // from class: com.anythink.unitybridge.sdkinit.AdSourcePrivacyPolicyStore.11
                public boolean isCanUseLocation() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseLocation", false);
                }

                public BeiZiLocation getLocation() {
                    double[] dArr = new double[2];
                    if (!AdSourcePrivacyPolicyStore.readCustomLocation(jSONObject, dArr)) {
                        return null;
                    }
                    BeiZiLocation beiZiLocation = new BeiZiLocation();
                    beiZiLocation.setLatitude(String.valueOf(dArr[0]));
                    beiZiLocation.setLongitude(String.valueOf(dArr[1]));
                    return beiZiLocation;
                }

                public boolean isCanUseWifiState() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseWifiState", false);
                }

                public boolean isCanUsePhoneState() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUsePhoneState", false);
                }

                public boolean isCanUseOaid() {
                    return AdSourcePrivacyPolicyStore.isCanUseOaidEffective(jSONObject);
                }

                public String getDevOaid() {
                    return AdSourcePrivacyPolicyStore.optString(jSONObject, "customOaid");
                }

                public boolean isCanUseAppList() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseAppList", false);
                }

                public boolean forbidSensor() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "forbidSensor", false);
                }

                public boolean isCanUseAndroidId() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseAndroidId", false);
                }

                public String getAndroidId() {
                    return AdSourcePrivacyPolicyStore.optString(jSONObject, "customAndroidId");
                }
            });
        } catch (Throwable th) {
            logApplyThrowable("applyBeizi", th);
        }
    }

    private static void applyMeishu(final JSONObject jSONObject) {
        try {
            MsATInitManager.getInstance().setCustomController(new MSAdConfig.CustomController() { // from class: com.anythink.unitybridge.sdkinit.AdSourcePrivacyPolicyStore.12
                public String getOaid() {
                    return AdSourcePrivacyPolicyStore.optString(jSONObject, "customOaid");
                }

                public boolean isCanUseLocation() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseLocation", false);
                }

                public LocationProvider getTTLocation() {
                    final double[] dArr = new double[2];
                    if (AdSourcePrivacyPolicyStore.readCustomLocation(jSONObject, dArr)) {
                        return new LocationProvider() { // from class: com.anythink.unitybridge.sdkinit.AdSourcePrivacyPolicyStore.12.1
                            @Override // com.bytedance.sdk.openadsdk.LocationProvider
                            public double getLatitude() {
                                return dArr[0];
                            }

                            @Override // com.bytedance.sdk.openadsdk.LocationProvider
                            public double getLongitude() {
                                return dArr[1];
                            }
                        };
                    }
                    return null;
                }

                public Location getLocation() {
                    double[] dArr = new double[2];
                    if (!AdSourcePrivacyPolicyStore.readCustomLocation(jSONObject, dArr)) {
                        return null;
                    }
                    Location location = new Location("policy");
                    location.setLatitude(dArr[0]);
                    location.setLongitude(dArr[1]);
                    return location;
                }

                public boolean isCanUsePhoneState() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUsePhoneState", false);
                }

                public boolean isCsjUsePhoneState() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUsePhoneState", false);
                }

                public String getDevImei() {
                    return AdSourcePrivacyPolicyStore.optString(jSONObject, "customIMEI");
                }

                public boolean isCanUseImsi() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUsePhoneState", false);
                }

                public boolean isCanUseWifiState() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseWifiState", false);
                }

                public String getMacAddress() {
                    return AdSourcePrivacyPolicyStore.optString(jSONObject, "customMacAddress");
                }

                public boolean isCanUseAndroidId() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseAndroidId", false);
                }

                public String getAndroidId() {
                    return AdSourcePrivacyPolicyStore.optString(jSONObject, "customAndroidId");
                }

                public boolean canUseMacAddress() {
                    return AdSourcePrivacyPolicyStore.isCanUseMacAddressEffective(jSONObject);
                }

                public boolean canUseNetworkState() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseWifiState", false);
                }

                public boolean canUseStoragePermission() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseWriteExternal", false);
                }

                public boolean canReadInstalledPackages() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseAppList", false);
                }

                public boolean isCanUsePermissionRecordAudio() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUsePermissionRecordAudio", false);
                }
            });
        } catch (Throwable th) {
            logApplyThrowable("applyMeishu", th);
        }
    }

    private static void applyTap(final JSONObject jSONObject) {
        try {
            TapATInitManager.getInstance().setTapAdCustomController(new TapAdCustomController() { // from class: com.anythink.unitybridge.sdkinit.AdSourcePrivacyPolicyStore.13
                public boolean isCanUseLocation() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseLocation", false);
                }

                public TapAdLocation getTapAdLocation() {
                    double[] dArr = new double[2];
                    if (AdSourcePrivacyPolicyStore.readCustomLocation(jSONObject, dArr)) {
                        return new TapAdLocation(dArr[0], dArr[1], 1.0d);
                    }
                    return null;
                }

                public boolean isCanUsePhoneState() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUsePhoneState", false);
                }

                public String getDevImei() {
                    return AdSourcePrivacyPolicyStore.optString(jSONObject, "customIMEI");
                }

                public boolean isCanUseWifiState() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseWifiState", false);
                }

                public boolean isCanUseWriteExternal() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseWriteExternal", false);
                }

                public String getDevOaid() {
                    return AdSourcePrivacyPolicyStore.optString(jSONObject, "customOaid");
                }

                public boolean alist() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseAppList", false);
                }

                public boolean isCanUseAndroidId() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseAndroidId", false);
                }
            });
        } catch (Throwable th) {
            logApplyThrowable("applyTap", th);
        }
    }

    private static void applyLingye(JSONObject jSONObject) {
        Application application;
        try {
            boolean zOptBoolean = optBoolean(jSONObject, "isCanUseAppList", false);
            LyATInitManager.getInstance().isCanUseAppList(zOptBoolean);
            Activity activity = UnityPluginUtils.getActivity("applyLingye");
            if (activity == null || (application = activity.getApplication()) == null) {
                return;
            }
            LyATInitManager.getInstance().privacyCompliance(application, (optBoolean(jSONObject, "isCanUseLocation", false) && zOptBoolean) ? false : true);
        } catch (Throwable th) {
            logApplyThrowable("applyLingye", th);
        }
    }

    private static void applyOctopus(final JSONObject jSONObject) {
        try {
            ZyATInitManager.getInstance().setOctopusAdSdkController(new OctopusAdSdkController() { // from class: com.anythink.unitybridge.sdkinit.AdSourcePrivacyPolicyStore.14
                public boolean isCanUseAppList() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseAppList", false);
                }

                public boolean isCanUseLocation() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseLocation", false);
                }

                public OctLocation getLocation() {
                    double[] dArr = new double[2];
                    if (!AdSourcePrivacyPolicyStore.readCustomLocation(jSONObject, dArr)) {
                        return null;
                    }
                    OctLocation octLocation = new OctLocation();
                    octLocation.setLatitude(dArr[0]);
                    octLocation.setLongitude(dArr[1]);
                    return octLocation;
                }

                public boolean isCanUsePhoneState() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUsePhoneState", false);
                }

                public String getImei() {
                    return AdSourcePrivacyPolicyStore.optString(jSONObject, "customIMEI");
                }

                public String getOaid() {
                    return AdSourcePrivacyPolicyStore.optString(jSONObject, "customOaid");
                }

                public boolean isCanUseOaid() {
                    return AdSourcePrivacyPolicyStore.isCanUseOaidEffective(jSONObject);
                }

                public boolean isCanUseAndroidId() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseAndroidId", false);
                }

                public String getAndroidId() {
                    return AdSourcePrivacyPolicyStore.optString(jSONObject, "customAndroidId");
                }

                public boolean isCanShake() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanShake", true);
                }

                public ShakeValue getShakeValue() {
                    try {
                        JSONObject jSONObject2 = jSONObject;
                        JSONObject jSONObjectOptJSONObject = jSONObject2 != null ? jSONObject2.optJSONObject("shakeValue") : null;
                        if (jSONObjectOptJSONObject == null) {
                            return null;
                        }
                        return new ShakeValue(jSONObjectOptJSONObject.optDouble("acceleration", 0.0d), jSONObjectOptJSONObject.optDouble("angle", 0.0d), jSONObjectOptJSONObject.optInt("time", 0));
                    } catch (Throwable unused) {
                        return null;
                    }
                }
            });
        } catch (Throwable th) {
            logApplyThrowable("applyOctopus", th);
        }
    }

    private static void applyQumeng(final JSONObject jSONObject) {
        try {
            QMATInitManager.getInstance().setQMCustomControl(new QMCustomControl() { // from class: com.anythink.unitybridge.sdkinit.AdSourcePrivacyPolicyStore.15
                public String getOaid() {
                    return AdSourcePrivacyPolicyStore.optString(jSONObject, "customOaid");
                }

                public boolean isCanUseOaid() {
                    return AdSourcePrivacyPolicyStore.isCanUseOaidEffective(jSONObject);
                }

                public boolean isCanUseAppList() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseAppList", false);
                }

                public boolean isCanUsePhoneState() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUsePhoneState", false);
                }

                public String getDevImei() {
                    return AdSourcePrivacyPolicyStore.optString(jSONObject, "customIMEI");
                }

                public boolean isCanUseAndroidId() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseAndroidId", false);
                }

                public String getAndroidId() {
                    return AdSourcePrivacyPolicyStore.optString(jSONObject, "customAndroidId");
                }

                public String getMacAddress() {
                    return AdSourcePrivacyPolicyStore.optString(jSONObject, "customMacAddress");
                }
            });
        } catch (Throwable th) {
            logApplyThrowable("applyQumeng", th);
        }
    }

    private static void applyJd(final JSONObject jSONObject) {
        try {
            JADATInitManager.getInstance().setJADPrivateController(new JADPrivateController() { // from class: com.anythink.unitybridge.sdkinit.AdSourcePrivacyPolicyStore.16
                public boolean isCanUseLocation() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseLocation", false);
                }

                public JADLocation getLocation() {
                    double[] dArr = new double[2];
                    if (AdSourcePrivacyPolicyStore.readCustomLocation(jSONObject, dArr)) {
                        return new JADLocation(dArr[0], dArr[1], 0.0d);
                    }
                    return new JADLocation();
                }

                public String getOaid() {
                    return AdSourcePrivacyPolicyStore.optString(jSONObject, "customOaid");
                }

                public boolean isCanUseIP() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseIp", false);
                }

                public String getIP() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseIp", false) ? "" : AdSourcePrivacyPolicyStore.optString(jSONObject, "customIp");
                }
            });
        } catch (Throwable th) {
            logApplyThrowable("applyJd", th);
        }
    }

    private static void applyFanwei(final JSONObject jSONObject) {
        try {
            FwATInitManager.getInstance().setFanWeiCustomController(new PtgCustomController() { // from class: com.anythink.unitybridge.sdkinit.AdSourcePrivacyPolicyStore.17
                public String getMediaDeviceImei() {
                    return AdSourcePrivacyPolicyStore.optString(jSONObject, "customIMEI");
                }

                public boolean isAllowSDKObtainAndroidId() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseAndroidId", false);
                }

                public String getMediaAndroidId() {
                    return AdSourcePrivacyPolicyStore.optString(jSONObject, "customAndroidId");
                }

                public boolean isAllowSDKObtainOaId() {
                    return AdSourcePrivacyPolicyStore.isCanUseOaidEffective(jSONObject);
                }

                public String getMediaDeviceOaId() {
                    return AdSourcePrivacyPolicyStore.optString(jSONObject, "customOaid");
                }

                public String getMediaMacAddress() {
                    return AdSourcePrivacyPolicyStore.optString(jSONObject, "customMacAddress");
                }

                public boolean isAllowSDKObtainNetworkState() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseWifiState", false);
                }

                public boolean isAllowSDKObtainStoragePermission() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseWriteExternal", false);
                }

                public boolean isAllowSDKObtainWriteExternal() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseWriteExternal", false);
                }

                public boolean isAllowSDKObtainLocation() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseLocation", false);
                }

                public AdLocation getMediaLocation() {
                    double[] dArr = new double[2];
                    if (!AdSourcePrivacyPolicyStore.readCustomLocation(jSONObject, dArr)) {
                        return null;
                    }
                    AdLocation adLocation = new AdLocation();
                    adLocation.setLatitude(dArr[0]);
                    adLocation.setLongitude(dArr[1]);
                    return adLocation;
                }

                public boolean isAllowHardDiskSizeKBytes() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isAllowHardDiskSizeKBytes", false);
                }

                public boolean isAllowSDKInstallList() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseAppList", false);
                }

                public boolean isAllowSDKObtainWifiState() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseWifiState", false);
                }
            });
        } catch (Throwable th) {
            logApplyThrowable("applyFanwei", th);
        }
    }

    private static void applyGtm(final JSONObject jSONObject) {
        try {
            GTMATInitManager.getInstance().setGTMATCustomerController(new GTMATCustomController() { // from class: com.anythink.unitybridge.sdkinit.AdSourcePrivacyPolicyStore.18
                public boolean getAuthorityGeneralData() {
                    return AdSourcePrivacyPolicyStore.isCanUseGeneralDataEffective(jSONObject);
                }

                public boolean getAuthorityDeviceID() {
                    return AdSourcePrivacyPolicyStore.isCanUseOaidEffective(jSONObject);
                }

                public boolean getAuthoritySerialID() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUsePhoneState", false);
                }
            });
        } catch (Throwable th) {
            logApplyThrowable("applyGtm", th);
        }
    }

    private static void applyAqy(final JSONObject jSONObject) {
        try {
            AqyATInitManager.getInstance().setCustomMade(new QyCustomMade() { // from class: com.anythink.unitybridge.sdkinit.AdSourcePrivacyPolicyStore.19
                public String getOaid() {
                    return AdSourcePrivacyPolicyStore.optString(jSONObject, "customOaid");
                }

                public boolean isCanUsePhoneIMEI() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUsePhoneState", false);
                }

                public boolean isCanUsePhoneAndroidId() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseAndroidId", false);
                }

                public boolean isCanUsePhoneMacAddress() {
                    return AdSourcePrivacyPolicyStore.isCanUseMacAddressEffective(jSONObject);
                }

                public boolean isCanUsePhoneWifiSSID() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseWifiState", false);
                }

                public String getDevImei() {
                    return AdSourcePrivacyPolicyStore.optString(jSONObject, "customIMEI");
                }

                public String getDevMac() {
                    return AdSourcePrivacyPolicyStore.optString(jSONObject, "customMacAddress");
                }

                public String getDevAndroidId() {
                    return AdSourcePrivacyPolicyStore.optString(jSONObject, "customAndroidId");
                }

                public boolean alist() {
                    return AdSourcePrivacyPolicyStore.optBoolean(jSONObject, "isCanUseAppList", false);
                }
            });
        } catch (Throwable th) {
            logApplyThrowable("applyAqy", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isCanUseOaidEffective(JSONObject jSONObject) {
        return optBoolean(jSONObject, "isCanUseOaid", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isCanUseGeneralDataEffective(JSONObject jSONObject) {
        return optBoolean(jSONObject, "isCanUseGeneralData", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String optString(JSONObject jSONObject, String str) {
        return (jSONObject == null || str == null) ? "" : jSONObject.optString(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean optBoolean(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject != null) {
            try {
                if (jSONObject.has(str)) {
                    Object objOpt = jSONObject.opt(str);
                    if (objOpt instanceof Boolean) {
                        return ((Boolean) objOpt).booleanValue();
                    }
                    if (objOpt instanceof Number) {
                        return ((Number) objOpt).intValue() != 0;
                    }
                    if (objOpt instanceof String) {
                        String str2 = (String) objOpt;
                        if ("1".equals(str2)) {
                            return true;
                        }
                        if ("0".equals(str2)) {
                            return false;
                        }
                        return Boolean.parseBoolean(str2);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean readCustomLocation(JSONObject jSONObject, double[] dArr) {
        if (jSONObject != null && dArr != null && dArr.length >= 2) {
            try {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("customLocation");
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has("latitude") && jSONObjectOptJSONObject.has("longitude")) {
                    double d = jSONObjectOptJSONObject.getDouble("latitude");
                    double d2 = jSONObjectOptJSONObject.getDouble("longitude");
                    dArr[0] = d;
                    dArr[1] = d2;
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean shouldAllowNearbyWifiList(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return optBoolean(jSONObject, "isCanUseWifiState", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isCanUseMacAddressEffective(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return optBoolean(jSONObject, "isCanUseMacAddress", false);
    }
}
