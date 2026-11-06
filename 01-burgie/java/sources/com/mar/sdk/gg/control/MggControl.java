package com.mar.sdk.gg.control;

import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.mar.sdk.MARSDK;
import com.mar.sdk.utils.StoreUtils;
import com.mar.sdk.verify.MARProxy;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class MggControl {
    private static final String TAG = "MARSDK-MggControl";
    private static MggControl instance;
    private static boolean isFreeFlag = false;
    private boolean VideoControl_enableSwitch;
    private int VideoControl_intervalTime;
    private int VideoControl_limitNum;
    private int VideoControl_startNum;
    private JSONObject dynamicInfo;
    private int intersRatio;
    private int nativeIntersRatio;
    private int nativeSplashRatio;
    private JSONObject remoteConfig;
    private int splashAdvertRatio;
    private boolean mainSwitch = false;
    private int videoLoadCount = 0;
    private int videoShowCount = 0;
    private long lastTime = 0;
    private boolean ad_banner_flag = false;
    private boolean ad_inters_flag = false;
    private boolean ad_splash_flag = false;
    private boolean ad_video_flag = false;
    private boolean ad_native_banner_flag = false;
    private boolean ad_native_inters_flag = false;
    private boolean ad_native_big_flag = false;
    private boolean ad_flaot_icon_flag = false;
    private boolean ad_inters_video_flag = false;
    private boolean disableRealnameSwitch = false;
    private boolean skipRealNameSwitch = false;
    private boolean rebootSkipLoginSwitch = false;
    private boolean nativeLucencyAdvertSwitch = false;
    private boolean nativeSplashSwitch = false;
    private boolean customSwitch = false;
    private int banner_update_time = 30;
    private int banner_close_reload_time = 15;
    private String banner_priority = MediationConstant.RIT_TYPE_BANNER;
    private int inters_begin_count = 0;
    private int inters_interval_count = 0;
    private int inters_interval_times = 0;
    private boolean inters_turn_flag = false;
    private int inters_ratio_self = 0;
    private int inters_turn_native_ratio = 0;
    private int inters_turn_intervideo_ratio = 0;
    private int inters_turn_video_ratio = 0;
    private int inters_turn_splash_ratio = 0;
    private int save_flag_type = 0;
    private boolean show_delay_flag = false;
    private int show_delay_times = 0;
    private int show_delay_times_begin = 0;
    private int show_delay_times_end = 0;
    private int Show_delay_count = 0;
    private boolean ad_in_out_flag = false;
    private String ad_in_out_type = "";
    private int inout_interval_startnum = 0;
    private int inout_interval_count = 0;
    private int inout_interval_times = 0;
    private String dynamic_nativePaster_type = "";
    private boolean native_inters_random_style_switch = false;
    private int nativeIntersIntervalNumber = 0;
    private int nativeIntersStartNumber = 0;
    private int nativeIntersIntervalTime = 0;
    private int nativeIntersMaxNumber = 0;
    private boolean android_key_flag = false;
    private int android_key_radio = 0;
    private boolean android_key_back_flag = false;
    private int android_key_back_radio = 0;
    private String android_key_back_type = "";
    List<ReqResult> reqRemoteList = new ArrayList();
    private boolean isLoaded = false;
    private int inout_count = 0;
    private long inout_time = 0;

    public interface ReqResult {
        void onResult(boolean z);
    }

    private MggControl() {
    }

    public static MggControl getInstance() {
        if (instance == null) {
            instance = new MggControl();
            isFreeFlag = MARSDK.getInstance().getFreeStyle();
        }
        return instance;
    }

    public void reqAdControlInfo() {
        if (MARSDK.getInstance().getGameType() == 2) {
            Log.d(TAG, "not support ad");
        } else {
            startAdJugdeTask();
        }
    }

    private void startAdJugdeTask() {
        GetAdInfoTask authTask = new GetAdInfoTask();
        if (Build.VERSION.SDK_INT >= 11) {
            authTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            authTask.execute(new Void[0]);
        }
    }

    class GetAdInfoTask extends AsyncTask<Void, Void, String> {
        public GetAdInfoTask() {
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            Log.d(MggControl.TAG, "before to GetAdInfoTask from marserver...");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(Void... args) {
            Log.d(MggControl.TAG, "begin to GetAdInfoTask from marserver..." + System.currentTimeMillis());
            String ret = MARProxy.getAdConfigToApp();
            Log.d(MggControl.TAG, "end to GetAdFlagTask from marserver..." + System.currentTimeMillis());
            if (ret == null || ret.trim().length() == 0) {
                Log.d(MggControl.TAG, "GetAdInfoTask from marserver failed.");
                MggControl.this.analysisMggControlData(StoreUtils.getString(MARSDK.getInstance().getContext(), StoreUtils.mGgControleData));
                return "";
            }
            if (MARSDK.getInstance().getContext() != null) {
                StoreUtils.putString(MARSDK.getInstance().getContext(), StoreUtils.mGgControleData, ret);
                MggControl.this.analysisMggControlData(ret);
            }
            return "";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String ret) {
            Log.d(MggControl.TAG, "GetAdInfoTask onPostExecute.");
            if (ret == null || ret.isEmpty()) {
                Log.d(MggControl.TAG, "GetAdInfoTask from ascserver failed.");
            } else if (MARSDK.getInstance().getContext() != null) {
                MggControl.this.analysisMggControlData(StoreUtils.getString(MARSDK.getInstance().getContext(), StoreUtils.mGgControleData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void analysisMggControlData(String ret) {
        JSONObject jsonObject;
        JSONObject json_adControl;
        JSONObject json_adControl2;
        JSONObject json_adControl3;
        JSONObject json_adControl4;
        JSONObject json_adControl5;
        JSONObject json_adControl6;
        JSONObject json_adControl7;
        JSONObject json_adControl8;
        JSONObject json_confing;
        if (ret != null && ret.trim().length() != 0) {
            try {
                JSONObject jsonObj = new JSONObject(ret);
                try {
                    if (jsonObj.optBoolean("advertSwitch")) {
                        this.isLoaded = true;
                        this.mainSwitch = true;
                        if (!jsonObj.isNull("adSwitch") && jsonObj.optString("adSwitch").trim().length() > 0 && (json_confing = jsonObj.optJSONObject("adSwitch")) != null) {
                            Log.d(TAG, "adSwitch ========================== msg : " + json_confing.toString());
                            this.ad_banner_flag = json_confing.optBoolean("bannerSwitch");
                            this.ad_inters_flag = json_confing.optBoolean("intersSwitch");
                            this.ad_splash_flag = json_confing.optBoolean("splashSwitch");
                            this.ad_video_flag = json_confing.optBoolean("videoSwitch");
                            this.ad_inters_video_flag = json_confing.optBoolean("intersVideoSwitch");
                            this.ad_native_banner_flag = json_confing.optBoolean("nativeBannerSwitch");
                            this.ad_native_inters_flag = json_confing.optBoolean("nativeIntersSwitch");
                            this.ad_native_big_flag = json_confing.optBoolean("nativeBigSwitch");
                            this.ad_flaot_icon_flag = json_confing.optBoolean("floatSwitch");
                            this.nativeLucencyAdvertSwitch = json_confing.optBoolean("nativeLucencyAdvertSwitch");
                            this.nativeSplashSwitch = json_confing.optBoolean("nativeSplashSwitch");
                            this.customSwitch = json_confing.optBoolean("customSwitch");
                            this.disableRealnameSwitch = json_confing.optBoolean("disableRealnameSwitch");
                            this.skipRealNameSwitch = json_confing.getBoolean("jumpRealnameSwitch");
                            this.rebootSkipLoginSwitch = json_confing.getBoolean("rebootSkipLoginSwitch");
                        }
                        if (!jsonObj.isNull("adBannerControl") && jsonObj.optString("adBannerControl").trim().length() > 0 && (json_adControl8 = jsonObj.optJSONObject("adBannerControl")) != null) {
                            Log.d(TAG, "adBannerControl ========================== msg : " + json_adControl8.toString());
                            this.banner_update_time = json_adControl8.optInt("refreshRate");
                            this.banner_close_reload_time = json_adControl8.optInt("loadIntervalTime");
                            this.banner_priority = json_adControl8.optString("priority");
                        }
                        if (!jsonObj.isNull("adIntersControl") && jsonObj.optString("adIntersControl").trim().length() > 0 && (json_adControl7 = jsonObj.optJSONObject("adIntersControl")) != null) {
                            Log.d(TAG, "adIntersControl ========================== msg : " + json_adControl7.toString());
                            this.inters_begin_count = json_adControl7.optInt("startNum");
                            this.inters_interval_count = json_adControl7.optInt("intervalNum");
                            this.inters_interval_times = json_adControl7.optInt("intervalTime");
                        }
                        if (!jsonObj.isNull("adCombineControl") && jsonObj.optString("adCombineControl").trim().length() > 0 && (json_adControl6 = jsonObj.optJSONObject("adCombineControl")) != null) {
                            Log.d(TAG, "adCombineControl ========================== msg : " + json_adControl6.toString());
                            this.inters_turn_flag = json_adControl6.optBoolean("enableSwitch");
                            this.inters_ratio_self = json_adControl6.optInt("intersRatio");
                            this.inters_turn_native_ratio = json_adControl6.optInt("nativeIntersRatio");
                            this.inters_turn_intervideo_ratio = json_adControl6.optInt("intersVideoRatio");
                            this.inters_turn_video_ratio = json_adControl6.optInt("incentiveVideoRatio");
                            this.inters_turn_splash_ratio = json_adControl6.optInt("splashAdvertRatio");
                        }
                        if (!jsonObj.isNull("adCombineDelayed") && jsonObj.optString("adCombineDelayed").trim().length() > 0 && (json_adControl5 = jsonObj.optJSONObject("adCombineDelayed")) != null) {
                            Log.d(TAG, "adCombineDelayed ========================== msg : " + json_adControl5.toString());
                            this.show_delay_flag = json_adControl5.optBoolean("delayedSwitch");
                            this.show_delay_times_begin = json_adControl5.optInt("ejectionTime");
                            this.show_delay_times_end = json_adControl5.optInt("ejectionEndTime");
                            this.Show_delay_count = json_adControl5.optInt("ejectionInterval");
                        }
                        if (!jsonObj.isNull("adInoutControlEntity") && jsonObj.optString("adInoutControlEntity").trim().length() > 0 && (json_adControl4 = jsonObj.optJSONObject("adInoutControlEntity")) != null) {
                            Log.d(TAG, "adInoutControl ========================== msg : " + json_adControl4.toString());
                            this.ad_in_out_flag = json_adControl4.optBoolean("enableSwitch");
                            this.ad_in_out_type = json_adControl4.optString("popupType");
                            this.inout_interval_startnum = json_adControl4.optInt("startNum");
                            this.inout_interval_count = json_adControl4.optInt("intervalNum");
                            this.inout_interval_times = json_adControl4.optInt("intervalTime");
                            this.intersRatio = json_adControl4.optInt("intersRatio");
                            this.nativeIntersRatio = json_adControl4.optInt("nativeIntersRatio");
                            this.nativeSplashRatio = json_adControl4.optInt("nativeSplashRatio");
                            this.splashAdvertRatio = json_adControl4.optInt("splashAdvertRatio");
                        }
                        if (!jsonObj.isNull("adDynamicNativeInters") && jsonObj.optString("adDynamicNativeInters").trim().length() > 0 && (json_adControl3 = jsonObj.optJSONObject("adDynamicNativeInters")) != null) {
                            this.dynamicInfo = json_adControl3;
                            Log.d(TAG, "adDynamicNativeInters ========================== msg : " + json_adControl3.toString());
                            this.dynamic_nativePaster_type = json_adControl3.optString("nativePasterBigPicStyle");
                            StoreUtils.putString(MARSDK.getInstance().getContext(), "native_big_type", this.dynamic_nativePaster_type);
                            this.native_inters_random_style_switch = json_adControl3.optBoolean("nativeIntersRandomStyleSwitch");
                            if (json_adControl3.optBoolean("nativeIntersSwitch")) {
                                this.nativeIntersIntervalNumber = json_adControl3.optInt("nativeIntersIntervalNumber");
                                this.nativeIntersStartNumber = json_adControl3.optInt("nativeIntersStartNumber");
                                this.nativeIntersIntervalTime = json_adControl3.optInt("nativeIntersIntervalTime");
                                this.nativeIntersMaxNumber = json_adControl3.optInt("nativeIntersMaxNumber");
                            }
                        }
                        if (!jsonObj.isNull("adVirtualKeyControl") && jsonObj.optString("adVirtualKeyControl").trim().length() > 0 && (json_adControl2 = jsonObj.optJSONObject("adVirtualKeyControl")) != null) {
                            Log.d(TAG, "adVirtualKeyControl ========================== msg : " + json_adControl2.toString());
                            this.android_key_flag = json_adControl2.optBoolean("virtualKeySwitch");
                            this.android_key_radio = json_adControl2.optInt("virtualProbability");
                        }
                        if (!jsonObj.isNull("adReturnKeyControl") && jsonObj.optString("adReturnKeyControl").trim().length() > 0 && (json_adControl = jsonObj.optJSONObject("adReturnKeyControl")) != null) {
                            Log.d(TAG, "adReturnKeyControl ========================== msg : " + json_adControl.toString());
                            this.android_key_back_flag = json_adControl.optBoolean("returnKeySwitch");
                            this.android_key_back_radio = json_adControl.optInt("returnProbability");
                            this.android_key_back_type = json_adControl.optString("popupType");
                        }
                        if (!jsonObj.isNull("adIncentiveVideoControl") && jsonObj.optString("adIncentiveVideoControl").trim().length() > 0 && (jsonObject = jsonObj.optJSONObject("adIncentiveVideoControl")) != null) {
                            Log.d(TAG, "adIncentiveVideoControl ========================== msg : " + jsonObject.toString());
                            this.VideoControl_enableSwitch = jsonObject.optBoolean("enableSwitch");
                            this.VideoControl_startNum = jsonObject.optInt("startNum");
                            this.VideoControl_limitNum = jsonObject.optInt("limitNum");
                            this.VideoControl_intervalTime = jsonObject.optInt("intervalTime");
                        }
                    } else {
                        return;
                    }
                } catch (JSONException e) {
                    e = e;
                    Log.d(TAG, "method to doInBackground...");
                    e.printStackTrace();
                }
            } catch (JSONException e2) {
                e = e2;
            }
            this.remoteConfig = new JSONObject();
            try {
                this.remoteConfig.put("VideoControl_enableSwitch", this.VideoControl_enableSwitch);
                this.remoteConfig.put("VideoControl_startNum", this.VideoControl_startNum);
                this.remoteConfig.put("VideoControl_limitNum", this.VideoControl_limitNum);
                this.remoteConfig.put("VideoControl_intervalTime", this.VideoControl_intervalTime);
                this.remoteConfig.put("ad_float_icon_flag", this.ad_flaot_icon_flag);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            for (ReqResult req : this.reqRemoteList) {
                req.onResult(true);
            }
            this.reqRemoteList.clear();
            MARSDK.getInstance().onResult(61, "");
        }
    }

    public JSONObject getDynamicInfo() {
        return this.dynamicInfo;
    }

    public int getNativeIntersIntervalNumber() {
        return this.nativeIntersIntervalNumber;
    }

    public int getNativeIntersStartNumber() {
        return this.nativeIntersStartNumber;
    }

    public int getNativeIntersIntervalTime() {
        return this.nativeIntersIntervalTime;
    }

    public int getNativeIntersMaxNumber() {
        return this.nativeIntersMaxNumber;
    }

    public boolean getInterControlPass() {
        int sb;
        int show_cnt = StoreUtils.getInt(MARSDK.getInstance().getContext(), "show_count", 0);
        StoreUtils.putInt(MARSDK.getInstance().getContext(), "show_count", show_cnt + 1);
        if (this.inters_begin_count > 0 && this.inters_interval_count == 0) {
            if (show_cnt < this.inters_begin_count) {
                Log.d(TAG, "inters_begin_count:" + this.inters_begin_count + " show_cnt:" + show_cnt);
                return false;
            }
        } else if (this.inters_interval_count > 0 && ((sb = show_cnt - this.inters_begin_count) < 0 || sb % (this.inters_interval_count + 1) != 0)) {
            Log.d(TAG, "inters_interval_count:" + this.inters_interval_count + " now_inters_interval_count:" + sb);
            return false;
        }
        Calendar calendar = Calendar.getInstance();
        if (this.inters_interval_times > 0) {
            long svt = StoreUtils.getLong(MARSDK.getInstance().getContext(), "inters_time", 0L).longValue();
            calendar.setTime(new Date());
            long now_time_sb = calendar.getTimeInMillis() - svt;
            if (now_time_sb - ((long) (this.inters_interval_times * 1000)) < 0) {
                Log.d(TAG, "inters_interval_times:" + this.inters_interval_times + " now_inters_interval_times:" + now_time_sb);
                return false;
            }
        }
        StoreUtils.putlong(MARSDK.getInstance().getContext(), "inters_time", calendar.getTimeInMillis());
        return true;
    }

    public int getTypeForIntersTurn() {
        String adType;
        if (!this.inters_turn_flag) {
            this.save_flag_type = 0;
            return 0;
        }
        int a = getIntersEable() ? this.inters_ratio_self : 0;
        int b = getNativeIntersEable() ? this.inters_turn_native_ratio : 0;
        int c = getIntersVideoEable() ? this.inters_turn_intervideo_ratio : 0;
        int d = getSplashEable() ? this.inters_turn_splash_ratio : 0;
        int e = getVideoEable() ? this.inters_turn_video_ratio : 0;
        if (a == 0 && b == 0 && c == 0 && d == 0 && e == 0) {
            this.save_flag_type = 0;
            return 0;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(a));
        arrayList.add(Integer.valueOf(b));
        arrayList.add(Integer.valueOf(c));
        arrayList.add(Integer.valueOf(d));
        arrayList.add(Integer.valueOf(e));
        WeightRandom wr = new WeightRandom();
        int index = wr.getIntersTypeByWeight(arrayList);
        this.save_flag_type = index;
        switch (index) {
            case 0:
                adType = "inters";
                break;
            case 1:
                adType = "nativeInters";
                break;
            case 2:
                adType = "intersVideo";
                break;
            case 3:
                adType = MediationConstant.RIT_TYPE_SPLASH;
                break;
            case 4:
                adType = "video";
                break;
            default:
                adType = "inters ";
                break;
        }
        Log.d(TAG, "getIntersFlag type ================= " + this.save_flag_type + " adType:" + adType);
        return this.save_flag_type;
    }

    public boolean getDelayShowControlPass() {
        Log.d(TAG, "=============== getDelayShowControlPass flag : " + this.show_delay_flag + " times : " + this.show_delay_times + " cnt :" + this.Show_delay_count);
        if (!this.show_delay_flag || this.show_delay_times == 0) {
            return false;
        }
        if (this.Show_delay_count == 0) {
            return true;
        }
        int show_cnt = StoreUtils.getInt(MARSDK.getInstance().getContext(), "show_count", 0) + 1;
        Log.d(TAG, "=============== control now_show_cnt : " + show_cnt + " Show_delay_count : " + this.Show_delay_count);
        return show_cnt > 0 && show_cnt % this.Show_delay_count == 0;
    }

    public boolean getInOutControlPass() {
        if (!this.ad_in_out_flag) {
            return false;
        }
        boolean isinout = true;
        Log.d(TAG, "=============== getInOutControlPass==" + this.inout_count + "==" + this.inout_time);
        Calendar calendar = Calendar.getInstance();
        if (this.inout_count - this.inout_interval_startnum >= 0) {
            if (this.inout_interval_count > 0 && (this.inout_count - this.inout_interval_startnum) % (this.inout_interval_count + 1) != 0) {
                Log.d(TAG, "=============== InOut Control not pass limit 1");
                isinout = false;
            }
            if (this.inout_interval_times > 0) {
                calendar.setTime(new Date());
                long now_time_sb = calendar.getTimeInMillis() - this.inout_time;
                if (now_time_sb < this.inout_interval_times * 1000) {
                    Log.d(TAG, "=============== InOut Control not pass limit 2");
                    isinout = false;
                }
            }
            if (isinout) {
                this.inout_time = calendar.getTimeInMillis();
            }
        } else {
            Log.d(TAG, "=============== InOut Control not pass limit 3");
            isinout = false;
        }
        this.inout_count++;
        return isinout;
    }

    public String getInOutControlRadio() {
        String index = MediationConstant.RIT_TYPE_SPLASH;
        HashMap<String, Integer> map = new HashMap<>();
        if (this.intersRatio != 0) {
            map.put("inters", Integer.valueOf(this.intersRatio));
        }
        if (this.nativeIntersRatio != 0) {
            map.put("nativeInters", Integer.valueOf(this.nativeIntersRatio));
        }
        if (this.nativeSplashRatio != 0) {
            map.put("nativeSplash", Integer.valueOf(this.nativeSplashRatio));
        }
        if (this.splashAdvertRatio != 0) {
            map.put(MediationConstant.RIT_TYPE_SPLASH, Integer.valueOf(this.splashAdvertRatio));
        }
        if (map.size() > 0) {
            WeightRandom wr = new WeightRandom();
            index = wr.getIntersTypeByWeight(map);
        }
        Log.d(TAG, "=============== getInOutControlRadio:" + index);
        return index;
    }

    public boolean getAndroidKeyClickFlag() {
        int bd = this.android_key_radio;
        int fbd = 100 - this.android_key_radio;
        WeightRandom wr = new WeightRandom();
        String ret = wr.getRandomForInters(bd, fbd, 0);
        if (ret.equals("A")) {
            return true;
        }
        if (ret.equals("B")) {
        }
        return false;
    }

    public boolean getAndroidKeyBackFlag() {
        int bd = this.android_key_back_radio;
        int fbd = 100 - this.android_key_back_radio;
        WeightRandom wr = new WeightRandom();
        String ret = wr.getRandomForInters(bd, fbd, 0);
        if (ret.equals("A")) {
            return true;
        }
        if (ret.equals("B")) {
        }
        return false;
    }

    public String getAndroidKeyBackShowType() {
        return this.android_key_back_type;
    }

    public boolean getMainSwitchEable() {
        return this.mainSwitch;
    }

    public boolean getSplashEable() {
        return this.ad_splash_flag | isFreeFlag;
    }

    public boolean getBannerEable() {
        return this.ad_banner_flag | isFreeFlag;
    }

    public boolean getIntersEable() {
        return this.ad_inters_flag | isFreeFlag;
    }

    public boolean getIntersVideoEable() {
        return this.ad_inters_video_flag | isFreeFlag;
    }

    public boolean getVideoEable() {
        return this.ad_video_flag | isFreeFlag;
    }

    public boolean getNativeBannerEable() {
        return this.ad_native_banner_flag | isFreeFlag;
    }

    public boolean getNativeIntersEable() {
        return this.ad_native_inters_flag | isFreeFlag;
    }

    public boolean getNativeBigEable() {
        return this.ad_native_big_flag | isFreeFlag;
    }

    public String getBannerpriority() {
        return this.banner_priority;
    }

    public int getBannerUpdate() {
        return this.banner_update_time;
    }

    public int getBannerCloseReload() {
        return this.banner_close_reload_time;
    }

    public boolean getInOutEable() {
        return this.ad_in_out_flag;
    }

    public String getInOutType() {
        return this.ad_in_out_type;
    }

    public int getSaveFlagType() {
        return this.save_flag_type;
    }

    public void resetSaveFlagType() {
        this.save_flag_type = 0;
    }

    public boolean getFloatIconEable() {
        return this.ad_flaot_icon_flag | isFreeFlag;
    }

    public boolean getNativeLucencyEable() {
        return this.nativeLucencyAdvertSwitch | isFreeFlag;
    }

    public boolean getNativeSplashEable() {
        return this.nativeSplashSwitch | isFreeFlag;
    }

    public boolean getCustomSwitch() {
        return this.customSwitch | isFreeFlag;
    }

    public void setCustomSwitch(boolean sw) {
        this.customSwitch = sw;
    }

    public boolean getFreeFlag() {
        return isFreeFlag;
    }

    public boolean getShowDelayFlag() {
        return this.show_delay_flag;
    }

    public int getShowDelayTimes() {
        WeightRandom wr = new WeightRandom();
        this.show_delay_times = wr.getRandomForInterval(this.show_delay_times_begin, this.show_delay_times_end);
        return this.show_delay_times;
    }

    public boolean getAndroidKeyEable() {
        return this.android_key_flag;
    }

    public boolean getAndroidKeyBackEable() {
        return this.android_key_back_flag;
    }

    public void setDisableRealnameSwitch(boolean disableRealnameSwitch) {
        this.disableRealnameSwitch = disableRealnameSwitch;
    }

    public boolean isDisableRealnameSwitch() {
        return this.disableRealnameSwitch;
    }

    public boolean isSkipRealNameSwitch() {
        return this.skipRealNameSwitch;
    }

    public void setRebootSkipLoginSwitch(boolean rebootSkipLoginSwitch) {
        this.rebootSkipLoginSwitch = rebootSkipLoginSwitch;
    }

    public boolean isRebootSkipLoginSwitch() {
        return this.rebootSkipLoginSwitch;
    }

    public boolean getVideoControlEnable() {
        if (this.VideoControl_enableSwitch) {
            this.videoLoadCount++;
            long nowTime = System.currentTimeMillis();
            if (this.VideoControl_startNum != 0 && this.VideoControl_startNum > this.videoLoadCount) {
                Log.d(TAG, "start time limit");
                return false;
            }
            if (this.VideoControl_intervalTime != 0 && nowTime < this.lastTime) {
                Log.d(TAG, "interval time limit");
                return false;
            }
            if (this.VideoControl_limitNum != 0 && this.VideoControl_limitNum <= this.videoShowCount) {
                Log.d(TAG, "time limit");
                return false;
            }
            this.videoShowCount++;
            this.lastTime = ((long) (this.VideoControl_intervalTime * 1000)) + nowTime;
            return true;
        }
        Log.d(TAG, "VideoControlEnable false");
        return false;
    }

    public boolean getNativeIntersRandomStyleSwitch() {
        return this.native_inters_random_style_switch;
    }

    public void reqRemoteConfig(ReqResult req) {
        Log.d(TAG, "reqRemoteConfig isLoaded:" + this.isLoaded);
        if (this.isLoaded) {
            req.onResult(true);
        } else {
            this.reqRemoteList.add(req);
        }
    }

    public String getRemoteConfig(String name) {
        if (this.remoteConfig != null && this.remoteConfig.has(name)) {
            try {
                return String.valueOf(this.remoteConfig.get(name));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public JSONObject getAllRemoteConfig() {
        return this.remoteConfig;
    }
}
