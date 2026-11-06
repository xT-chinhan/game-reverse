package com.byazt.eq;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v4.app.NotificationCompat;
import com.byazt.mg.PluginConstants;
import com.bytedance.android.live.base.api.push.ILivePush;
import com.umeng.analytics.pro.an;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 661, 5})
public class uc {
    public WeakReference<zo> hw;
    public Context pr;
    public Map<String, pr> hn = new HashMap();
    public SensorEventListener x = new SensorEventListener() { // from class: com.byazt.eq.uc.1
        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            zo zoVarX;
            if (sensorEvent.sensor.getType() != 1 || (zoVarX = uc.this.x()) == null) {
                return;
            }
            float f = sensorEvent.values[0];
            float f2 = sensorEvent.values[1];
            float f3 = sensorEvent.values[2];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", f);
                jSONObject.put("y", f2);
                jSONObject.put(an.aD, f3);
                zoVarX.pr("accelerometer_callback", jSONObject);
            } catch (Throwable th) {
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    };
    public SensorEventListener c = new SensorEventListener() { // from class: com.byazt.eq.uc.12
        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            zo zoVarX;
            if (sensorEvent.sensor.getType() != 4 || (zoVarX = uc.this.x()) == null) {
                return;
            }
            float degrees = (float) Math.toDegrees(sensorEvent.values[0]);
            float degrees2 = (float) Math.toDegrees(sensorEvent.values[1]);
            float degrees3 = (float) Math.toDegrees(sensorEvent.values[2]);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", degrees);
                jSONObject.put("y", degrees2);
                jSONObject.put(an.aD, degrees3);
                zoVarX.pr("gyro_callback", jSONObject);
            } catch (Throwable th) {
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    };
    public SensorEventListener uc = new SensorEventListener() { // from class: com.byazt.eq.uc.23
        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            zo zoVarX;
            if (sensorEvent.sensor.getType() != 10 || (zoVarX = uc.this.x()) == null) {
                return;
            }
            float f = sensorEvent.values[0];
            float f2 = sensorEvent.values[1];
            float f3 = sensorEvent.values[2];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", f);
                jSONObject.put("y", f2);
                jSONObject.put(an.aD, f3);
                zoVarX.pr("accelerometer_grativityless_callback", jSONObject);
            } catch (Throwable th) {
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    };
    public SensorEventListener fw = new SensorEventListener() { // from class: com.byazt.eq.uc.34
        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 1) {
                System.arraycopy(sensorEvent.values, 0, vk.hw, 0, vk.hw.length);
            } else if (sensorEvent.sensor.getType() == 2) {
                System.arraycopy(sensorEvent.values, 0, vk.hn, 0, vk.hn.length);
            }
            SensorManager.getRotationMatrix(vk.x, null, vk.hw, vk.hn);
            SensorManager.getOrientation(vk.x, vk.c);
            zo zoVarX = uc.this.x();
            if (zoVarX == null) {
                return;
            }
            float f = vk.c[0];
            float f2 = vk.c[1];
            float f3 = vk.c[2];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("alpha", f);
                jSONObject.put("beta", f2);
                jSONObject.put("gamma", f3);
                zoVarX.pr("rotation_vector_callback", jSONObject);
            } catch (Throwable th) {
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    };

    interface pr {
        JSONObject pr(JSONObject jSONObject) throws Throwable;
    }

    public uc(zo zoVar) {
        this.pr = zoVar.getContext();
        this.hw = new WeakReference<>(zoVar);
        hn();
    }

    public Set<String> pr() {
        return this.hn.keySet();
    }

    private void hn() {
        this.hn.put("adInfo", new pr() { // from class: com.byazt.eq.uc.45
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                zo zoVarX = uc.this.x();
                if (zoVarX != null) {
                    JSONObject jSONObjectQa = zoVarX.qa();
                    if (jSONObjectQa != null) {
                        jSONObjectQa.put(PluginConstants.KEY_ERROR_CODE, 1);
                        return jSONObjectQa;
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(PluginConstants.KEY_ERROR_CODE, -1);
                return jSONObject3;
            }
        });
        this.hn.put("appInfo", new pr() { // from class: com.byazt.eq.uc.56
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                jSONObject2.put("appName", "playable_sdk");
                jSONObject2.put("playableSdkEdition", "6.5.1");
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = uc.this.pr().iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                jSONObject2.put("supportList", jSONArray);
                zo zoVarX = uc.this.x();
                if (zoVarX != null) {
                    jSONObject2.put("deviceId", zoVarX.uc());
                    jSONObject2.put("netType", zoVarX.nt());
                    jSONObject2.put("innerAppName", zoVarX.hn());
                    jSONObject2.put("appName", zoVarX.x());
                    jSONObject2.put("appVersion", zoVarX.c());
                    Map<String, String> mapPr = zoVarX.pr();
                    for (String str : mapPr.keySet()) {
                        jSONObject2.put(str, mapPr.get(str));
                    }
                }
                return jSONObject2;
            }
        });
        this.hn.put("playableSDKInfo", new pr() { // from class: com.byazt.eq.uc.61
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                jSONObject2.put("appName", "playable_sdk");
                jSONObject2.put("playableSdkEdition", "6.5.1");
                jSONObject2.put("os", "android");
                return jSONObject2;
            }
        });
        this.hn.put("subscribe_app_ad", new pr() { // from class: com.byazt.eq.uc.62
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                com.byazt.eq.pr prVarC = uc.this.c();
                JSONObject jSONObject2 = new JSONObject();
                if (prVarC == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.hn.put("download_app_ad", new pr() { // from class: com.byazt.eq.uc.63
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                com.byazt.eq.pr prVarC = uc.this.c();
                JSONObject jSONObject2 = new JSONObject();
                if (prVarC == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.hn.put("isViewable", new pr() { // from class: com.byazt.eq.uc.2
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                zo zoVarX = uc.this.x();
                if (zoVarX == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(PluginConstants.KEY_ERROR_CODE, 1);
                jSONObject3.put("viewStatus", zoVarX.zo());
                return jSONObject3;
            }
        });
        this.hn.put("getVolume", new pr() { // from class: com.byazt.eq.uc.3
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                zo zoVarX = uc.this.x();
                if (zoVarX == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(PluginConstants.KEY_ERROR_CODE, 1);
                jSONObject3.put("endcard_mute", zoVarX.fw());
                return jSONObject3;
            }
        });
        this.hn.put("getScreenSize", new pr() { // from class: com.byazt.eq.uc.4
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                zo zoVarX = uc.this.x();
                if (zoVarX == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectLb = zoVarX.lb();
                jSONObjectLb.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObjectLb;
            }
        });
        this.hn.put("start_accelerometer_observer", new pr() { // from class: com.byazt.eq.uc.5
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int iOptInt = 2;
                if (jSONObject != null) {
                    try {
                        iOptInt = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        fw.pr("PlayableJsBridge", "invoke start_accelerometer_observer error", th);
                        jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                vk.pr(uc.this.pr, uc.this.x, iOptInt);
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.hn.put("close_accelerometer_observer", new pr() { // from class: com.byazt.eq.uc.6
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    vk.pr(uc.this.pr, uc.this.x);
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    fw.pr("PlayableJsBridge", "invoke close_accelerometer_observer error", th);
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.hn.put("start_gyro_observer", new pr() { // from class: com.byazt.eq.uc.7
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int iOptInt = 2;
                if (jSONObject != null) {
                    try {
                        iOptInt = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        fw.pr("PlayableJsBridge", "invoke start_gyro_observer error", th);
                        jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                vk.hw(uc.this.pr, uc.this.c, iOptInt);
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.hn.put("close_gyro_observer", new pr() { // from class: com.byazt.eq.uc.8
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    vk.pr(uc.this.pr, uc.this.c);
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    fw.pr("PlayableJsBridge", "invoke close_gyro_observer error", th);
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.hn.put("start_accelerometer_grativityless_observer", new pr() { // from class: com.byazt.eq.uc.9
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int iOptInt = 2;
                if (jSONObject != null) {
                    try {
                        iOptInt = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        fw.pr("PlayableJsBridge", "invoke start_accelerometer_grativityless_observer error", th);
                        jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                vk.hn(uc.this.pr, uc.this.uc, iOptInt);
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.hn.put("close_accelerometer_grativityless_observer", new pr() { // from class: com.byazt.eq.uc.10
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    vk.pr(uc.this.pr, uc.this.uc);
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    fw.pr("PlayableJsBridge", "invoke close_accelerometer_grativityless_observer error", th);
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.hn.put("start_rotation_vector_observer", new pr() { // from class: com.byazt.eq.uc.11
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int iOptInt = 2;
                if (jSONObject != null) {
                    try {
                        iOptInt = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        fw.pr("PlayableJsBridge", "invoke start_rotation_vector_observer error", th);
                        jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                vk.x(uc.this.pr, uc.this.fw, iOptInt);
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.hn.put("close_rotation_vector_observer", new pr() { // from class: com.byazt.eq.uc.13
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    vk.pr(uc.this.pr, uc.this.fw);
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    fw.pr("PlayableJsBridge", "invoke close_rotation_vector_observer error", th);
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.hn.put("device_shake", new pr() { // from class: com.byazt.eq.uc.14
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    vk.pr(uc.this.pr, 300L);
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    fw.pr("PlayableJsBridge", "invoke device_shake error", th);
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.hn.put("device_shake_short", new pr() { // from class: com.byazt.eq.uc.15
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    vk.pr(uc.this.pr, 150L);
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    fw.pr("PlayableJsBridge", "invoke device_shake error", th);
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.hn.put("playable_style", new pr() { // from class: com.byazt.eq.uc.16
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                zo zoVarX = uc.this.x();
                JSONObject jSONObject2 = new JSONObject();
                if (zoVarX == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectHw = zoVarX.hw();
                jSONObjectHw.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObjectHw;
            }
        });
        this.hn.put("sendReward", new pr() { // from class: com.byazt.eq.uc.17
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                zo zoVarX = uc.this.x();
                JSONObject jSONObject2 = new JSONObject();
                if (zoVarX == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                zoVarX.cz();
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.hn.put("webview_time_track", new pr() { // from class: com.byazt.eq.uc.18
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                return new JSONObject();
            }
        });
        this.hn.put("playable_event", new pr() { // from class: com.byazt.eq.uc.19
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                zo zoVarX = uc.this.x();
                JSONObject jSONObject2 = new JSONObject();
                if (zoVarX == null || jSONObject == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                zoVarX.hw(jSONObject.optString(NotificationCompat.CATEGORY_EVENT, null), jSONObject.optJSONObject("params"));
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.hn.put("reportAd", new pr() { // from class: com.byazt.eq.uc.20
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                zo zoVarX = uc.this.x();
                JSONObject jSONObject2 = new JSONObject();
                if (zoVarX == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.hn.put(ILivePush.ClickType.CLOSE, new pr() { // from class: com.byazt.eq.uc.21
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                zo zoVarX = uc.this.x();
                JSONObject jSONObject2 = new JSONObject();
                if (zoVarX == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.hn.put("openAdLandPageLinks", new pr() { // from class: com.byazt.eq.uc.22
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                zo zoVarX = uc.this.x();
                JSONObject jSONObject2 = new JSONObject();
                if (zoVarX == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.hn.put("get_viewport", new pr() { // from class: com.byazt.eq.uc.24
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                zo zoVarX = uc.this.x();
                JSONObject jSONObject2 = new JSONObject();
                if (zoVarX == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectA = zoVarX.a();
                jSONObjectA.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObjectA;
            }
        });
        this.hn.put("jssdk_load_finish", new pr() { // from class: com.byazt.eq.uc.25
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                zo zoVarX = uc.this.x();
                JSONObject jSONObject2 = new JSONObject();
                if (zoVarX == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                zoVarX.gz();
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.hn.put("playable_material_render_result", new pr() { // from class: com.byazt.eq.uc.26
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                zo zoVarX = uc.this.x();
                JSONObject jSONObject2 = new JSONObject();
                if (zoVarX == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                zoVarX.w(jSONObject);
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.hn.put("detect_change_playable_click", new pr() { // from class: com.byazt.eq.uc.27
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                zo zoVarX = uc.this.x();
                JSONObject jSONObject2 = new JSONObject();
                if (zoVarX == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectAj = zoVarX.aj();
                jSONObjectAj.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObjectAj;
            }
        });
        this.hn.put("check_camera_permission", new pr() { // from class: com.byazt.eq.uc.28
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                zo zoVarX = uc.this.x();
                JSONObject jSONObject2 = new JSONObject();
                if (zoVarX == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectK = zoVarX.k();
                jSONObjectK.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObjectK;
            }
        });
        this.hn.put("check_external_storage", new pr() { // from class: com.byazt.eq.uc.29
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                zo zoVarX = uc.this.x();
                JSONObject jSONObject2 = new JSONObject();
                if (zoVarX == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectM = zoVarX.m();
                if (jSONObjectM.isNull("result")) {
                    jSONObjectM.put(PluginConstants.KEY_ERROR_CODE, -1);
                } else {
                    jSONObjectM.put(PluginConstants.KEY_ERROR_CODE, 1);
                }
                return jSONObjectM;
            }
        });
        this.hn.put("playable_open_camera", new pr() { // from class: com.byazt.eq.uc.30
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                zo zoVarX = uc.this.x();
                JSONObject jSONObject2 = new JSONObject();
                if (zoVarX == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                zoVarX.pr(jSONObject);
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.hn.put("playable_pick_photo", new pr() { // from class: com.byazt.eq.uc.31
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                zo zoVarX = uc.this.x();
                JSONObject jSONObject2 = new JSONObject();
                if (zoVarX == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                zoVarX.hw(jSONObject);
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.hn.put("playable_download_media_in_photos", new pr() { // from class: com.byazt.eq.uc.32
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                zo zoVarX = uc.this.x();
                JSONObject jSONObject2 = new JSONObject();
                if (zoVarX == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                zoVarX.hn(jSONObject);
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.hn.put("playable_preventTouchEvent", new pr() { // from class: com.byazt.eq.uc.33
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                zo zoVarX = uc.this.x();
                JSONObject jSONObject2 = new JSONObject();
                if (zoVarX == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                zoVarX.x(jSONObject);
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.hn.put("playable_settings_info", new pr() { // from class: com.byazt.eq.uc.35
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                zo zoVarX = uc.this.x();
                JSONObject jSONObject2 = new JSONObject();
                if (zoVarX == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectG = zoVarX.g();
                jSONObjectG.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObjectG;
            }
        });
        this.hn.put("playable_load_main_scene", new pr() { // from class: com.byazt.eq.uc.36
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                zo zoVarX = uc.this.x();
                JSONObject jSONObject2 = new JSONObject();
                if (zoVarX == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                zoVarX.ny();
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.hn.put("playable_enter_section", new pr() { // from class: com.byazt.eq.uc.37
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                zo zoVarX = uc.this.x();
                JSONObject jSONObject2 = new JSONObject();
                if (zoVarX == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                zoVarX.uc(jSONObject);
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.hn.put("playable_end", new pr() { // from class: com.byazt.eq.uc.38
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                zo zoVarX = uc.this.x();
                JSONObject jSONObject2 = new JSONObject();
                if (zoVarX == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                zoVarX.fo();
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.hn.put("playable_finish_play_playable", new pr() { // from class: com.byazt.eq.uc.39
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                zo zoVarX = uc.this.x();
                JSONObject jSONObject2 = new JSONObject();
                if (zoVarX == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                zoVarX.rc();
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.hn.put("playable_transfrom_module_show", new pr() { // from class: com.byazt.eq.uc.40
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                zo zoVarX = uc.this.x();
                JSONObject jSONObject2 = new JSONObject();
                if (zoVarX == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                zoVarX.z();
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.hn.put("playable_transfrom_module_change_color", new pr() { // from class: com.byazt.eq.uc.41
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                zo zoVarX = uc.this.x();
                JSONObject jSONObject2 = new JSONObject();
                if (zoVarX == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                zoVarX.b();
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.hn.put("playable_set_scroll_rect", new pr() { // from class: com.byazt.eq.uc.42
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                zo zoVarX = uc.this.x();
                JSONObject jSONObject2 = new JSONObject();
                if (zoVarX == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.hn.put("playable_click_area", new pr() { // from class: com.byazt.eq.uc.43
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                zo zoVarX = uc.this.x();
                JSONObject jSONObject2 = new JSONObject();
                if (zoVarX == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                zoVarX.fw(jSONObject);
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.hn.put("playable_real_play_start", new pr() { // from class: com.byazt.eq.uc.44
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                zo zoVarX = uc.this.x();
                JSONObject jSONObject2 = new JSONObject();
                if (zoVarX == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.hn.put("playable_material_first_frame_show", new pr() { // from class: com.byazt.eq.uc.46
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                zo zoVarX = uc.this.x();
                JSONObject jSONObject2 = new JSONObject();
                if (zoVarX == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                zoVarX.iu();
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.hn.put("playable_stuck_check_pong", new pr() { // from class: com.byazt.eq.uc.47
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                zo zoVarX = uc.this.x();
                JSONObject jSONObject2 = new JSONObject();
                if (zoVarX == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                zoVarX.ve();
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.hn.put("playable_material_adnormal_mask", new pr() { // from class: com.byazt.eq.uc.48
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                zo zoVarX = uc.this.x();
                JSONObject jSONObject2 = new JSONObject();
                if (zoVarX == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                zoVarX.zo(jSONObject);
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.hn.put("playable_long_press_panel", new pr() { // from class: com.byazt.eq.uc.49
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                zo zoVarX = uc.this.x();
                JSONObject jSONObject2 = new JSONObject();
                if (zoVarX == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.hn.put("playable_alpha_player_play", new pr() { // from class: com.byazt.eq.uc.50
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                zo zoVarX = uc.this.x();
                JSONObject jSONObject2 = new JSONObject();
                if (zoVarX == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.hn.put("playable_transfrom_module_highlight", new pr() { // from class: com.byazt.eq.uc.51
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                zo zoVarX = uc.this.x();
                JSONObject jSONObject2 = new JSONObject();
                if (zoVarX == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.hn.put("playable_send_click_event", new pr() { // from class: com.byazt.eq.uc.52
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                zo zoVarX = uc.this.x();
                JSONObject jSONObject2 = new JSONObject();
                if (zoVarX == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.hn.put("playable_query_media_permission_declare", new pr() { // from class: com.byazt.eq.uc.53
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                zo zoVarX = uc.this.x();
                JSONObject jSONObject2 = new JSONObject();
                if (zoVarX == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectAj = zoVarX.aj(jSONObject);
                jSONObjectAj.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObjectAj;
            }
        });
        this.hn.put("playable_query_media_permission_enable", new pr() { // from class: com.byazt.eq.uc.54
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                zo zoVarX = uc.this.x();
                JSONObject jSONObject2 = new JSONObject();
                if (zoVarX == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectVk = zoVarX.vk(jSONObject);
                jSONObjectVk.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObjectVk;
            }
        });
        this.hn.put("playable_apply_media_permission", new pr() { // from class: com.byazt.eq.uc.55
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                com.byazt.eq.pr prVarC = uc.this.c();
                JSONObject jSONObject2 = new JSONObject();
                if (prVarC == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.hn.put("playable_start_kws", new pr() { // from class: com.byazt.eq.uc.57
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                com.byazt.eq.pr prVarC = uc.this.c();
                JSONObject jSONObject2 = new JSONObject();
                if (prVarC == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.hn.put("playable_close_kws", new pr() { // from class: com.byazt.eq.uc.58
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                com.byazt.eq.pr prVarC = uc.this.c();
                JSONObject jSONObject2 = new JSONObject();
                if (prVarC == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.hn.put("playable_video_preload_task_add", new pr() { // from class: com.byazt.eq.uc.59
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                com.byazt.eq.pr prVarC = uc.this.c();
                JSONObject jSONObject2 = new JSONObject();
                if (prVarC == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.hn.put("playable_video_preload_task_cancel", new pr() { // from class: com.byazt.eq.uc.60
            @Override // com.byazt.eq.uc.pr
            public JSONObject pr(JSONObject jSONObject) throws Throwable {
                com.byazt.eq.pr prVarC = uc.this.c();
                JSONObject jSONObject2 = new JSONObject();
                if (prVarC == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public zo x() {
        WeakReference<zo> weakReference = this.hw;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.eq.pr c() {
        zo zoVarX = x();
        if (zoVarX == null) {
            return null;
        }
        return zoVarX.yb();
    }

    public JSONObject pr(String str, JSONObject jSONObject) {
        try {
            pr prVar = this.hn.get(str);
            if (prVar == null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                return jSONObject2;
            }
            return prVar.pr(jSONObject);
        } catch (Throwable th) {
            fw.pr("PlayableJsBridge", "invoke error", th);
            return null;
        }
    }

    public void hw() {
        vk.pr(this.pr, this.x);
        vk.pr(this.pr, this.c);
        vk.pr(this.pr, this.uc);
        vk.pr(this.pr, this.fw);
    }
}
