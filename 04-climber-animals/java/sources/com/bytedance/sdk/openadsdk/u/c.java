package com.bytedance.sdk.openadsdk.u;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.core.app.NotificationCompat;
import com.bytedance.android.live.base.api.push.ILivePush;
import com.umeng.analytics.pro.bv;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Context f4134ms;
    private WeakReference<x> xr;
    private Map<String, ms> ah = new HashMap();
    private SensorEventListener d = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.u.c.1
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            x xVarD;
            if (sensorEvent.sensor.getType() != 1 || (xVarD = c.this.d()) == null) {
                return;
            }
            float f = sensorEvent.values[0];
            float f2 = sensorEvent.values[1];
            float f3 = sensorEvent.values[2];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", f);
                jSONObject.put("y", f2);
                jSONObject.put(bv.aD, f3);
                xVarD.ms("accelerometer_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }
    };
    private SensorEventListener ka = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.u.c.12
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            x xVarD;
            if (sensorEvent.sensor.getType() != 4 || (xVarD = c.this.d()) == null) {
                return;
            }
            float degrees = (float) Math.toDegrees(sensorEvent.values[0]);
            float degrees2 = (float) Math.toDegrees(sensorEvent.values[1]);
            float degrees3 = (float) Math.toDegrees(sensorEvent.values[2]);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", degrees);
                jSONObject.put("y", degrees2);
                jSONObject.put(bv.aD, degrees3);
                xVarD.ms("gyro_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }
    };
    private SensorEventListener c = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.u.c.23
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            x xVarD;
            if (sensorEvent.sensor.getType() != 10 || (xVarD = c.this.d()) == null) {
                return;
            }
            float f = sensorEvent.values[0];
            float f2 = sensorEvent.values[1];
            float f3 = sensorEvent.values[2];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", f);
                jSONObject.put("y", f2);
                jSONObject.put(bv.aD, f3);
                xVarD.ms("accelerometer_grativityless_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }
    };
    private SensorEventListener ab = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.u.c.34
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 1) {
                System.arraycopy(sensorEvent.values, 0, ch.xr, 0, ch.xr.length);
            } else if (sensorEvent.sensor.getType() == 2) {
                System.arraycopy(sensorEvent.values, 0, ch.ah, 0, ch.ah.length);
            }
            SensorManager.getRotationMatrix(ch.d, null, ch.xr, ch.ah);
            SensorManager.getOrientation(ch.d, ch.ka);
            x xVarD = c.this.d();
            if (xVarD == null) {
                return;
            }
            float f = ch.ka[0];
            float f2 = ch.ka[1];
            float f3 = ch.ka[2];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("alpha", f);
                jSONObject.put("beta", f2);
                jSONObject.put("gamma", f3);
                xVarD.ms("rotation_vector_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }
    };

    interface ms {
        JSONObject ms(JSONObject jSONObject) throws Throwable;
    }

    public c(x xVar) {
        this.f4134ms = xVar.getContext();
        this.xr = new WeakReference<>(xVar);
        ah();
    }

    public Set<String> ms() {
        return this.ah.keySet();
    }

    private void ah() {
        this.ah.put("adInfo", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.45
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                x xVarD = c.this.d();
                if (xVarD != null) {
                    JSONObject jSONObjectY = xVarD.y();
                    if (jSONObjectY != null) {
                        jSONObjectY.put("code", 1);
                        return jSONObjectY;
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("code", -1);
                return jSONObject3;
            }
        });
        this.ah.put("appInfo", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.56
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", 1);
                jSONObject2.put("appName", "playable_sdk");
                jSONObject2.put("playableSdkEdition", "6.5.1");
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = c.this.ms().iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                jSONObject2.put("supportList", jSONArray);
                x xVarD = c.this.d();
                if (xVarD != null) {
                    jSONObject2.put("deviceId", xVarD.c());
                    jSONObject2.put("netType", xVarD.ao());
                    jSONObject2.put("innerAppName", xVarD.ah());
                    jSONObject2.put("appName", xVarD.d());
                    jSONObject2.put("appVersion", xVarD.ka());
                    Map<String, String> mapMs = xVarD.ms();
                    for (String str : mapMs.keySet()) {
                        jSONObject2.put(str, mapMs.get(str));
                    }
                }
                return jSONObject2;
            }
        });
        this.ah.put("playableSDKInfo", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.61
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", 1);
                jSONObject2.put("appName", "playable_sdk");
                jSONObject2.put("playableSdkEdition", "6.5.1");
                jSONObject2.put("os", "android");
                return jSONObject2;
            }
        });
        this.ah.put("subscribe_app_ad", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.62
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.u.ms msVarKa = c.this.ka();
                JSONObject jSONObject2 = new JSONObject();
                if (msVarKa == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ah.put("download_app_ad", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.63
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.u.ms msVarKa = c.this.ka();
                JSONObject jSONObject2 = new JSONObject();
                if (msVarKa == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ah.put("isViewable", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.2
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                x xVarD = c.this.d();
                if (xVarD == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("code", 1);
                jSONObject3.put("viewStatus", xVarD.x());
                return jSONObject3;
            }
        });
        this.ah.put("getVolume", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.3
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                x xVarD = c.this.d();
                if (xVarD == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("code", 1);
                jSONObject3.put("endcard_mute", xVarD.ab());
                return jSONObject3;
            }
        });
        this.ah.put("getScreenSize", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.4
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                x xVarD = c.this.d();
                if (xVarD == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectQv = xVarD.qv();
                jSONObjectQv.put("code", 1);
                return jSONObjectQv;
            }
        });
        this.ah.put("start_accelerometer_observer", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.5
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int iOptInt = 2;
                if (jSONObject != null) {
                    try {
                        iOptInt = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        ab.ms("PlayableJsBridge", "invoke start_accelerometer_observer error", th);
                        jSONObject2.put("code", -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                ch.ms(c.this.f4134ms, c.this.d, iOptInt);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ah.put("close_accelerometer_observer", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.6
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    ch.ms(c.this.f4134ms, c.this.d);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    ab.ms("PlayableJsBridge", "invoke close_accelerometer_observer error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.ah.put("start_gyro_observer", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.7
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int iOptInt = 2;
                if (jSONObject != null) {
                    try {
                        iOptInt = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        ab.ms("PlayableJsBridge", "invoke start_gyro_observer error", th);
                        jSONObject2.put("code", -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                ch.xr(c.this.f4134ms, c.this.ka, iOptInt);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ah.put("close_gyro_observer", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.8
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    ch.ms(c.this.f4134ms, c.this.ka);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    ab.ms("PlayableJsBridge", "invoke close_gyro_observer error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.ah.put("start_accelerometer_grativityless_observer", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.9
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int iOptInt = 2;
                if (jSONObject != null) {
                    try {
                        iOptInt = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        ab.ms("PlayableJsBridge", "invoke start_accelerometer_grativityless_observer error", th);
                        jSONObject2.put("code", -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                ch.ah(c.this.f4134ms, c.this.c, iOptInt);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ah.put("close_accelerometer_grativityless_observer", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.10
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    ch.ms(c.this.f4134ms, c.this.c);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    ab.ms("PlayableJsBridge", "invoke close_accelerometer_grativityless_observer error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.ah.put("start_rotation_vector_observer", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.11
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int iOptInt = 2;
                if (jSONObject != null) {
                    try {
                        iOptInt = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        ab.ms("PlayableJsBridge", "invoke start_rotation_vector_observer error", th);
                        jSONObject2.put("code", -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                ch.d(c.this.f4134ms, c.this.ab, iOptInt);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ah.put("close_rotation_vector_observer", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.13
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    ch.ms(c.this.f4134ms, c.this.ab);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    ab.ms("PlayableJsBridge", "invoke close_rotation_vector_observer error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.ah.put("device_shake", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.14
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    ch.ms(c.this.f4134ms, 300L);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    ab.ms("PlayableJsBridge", "invoke device_shake error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.ah.put("device_shake_short", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.15
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    ch.ms(c.this.f4134ms, 150L);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    ab.ms("PlayableJsBridge", "invoke device_shake error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.ah.put("playable_style", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.16
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                x xVarD = c.this.d();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarD != null) {
                    JSONObject jSONObjectXr = xVarD.xr();
                    jSONObjectXr.put("code", 1);
                    return jSONObjectXr;
                }
                jSONObject2.put("code", -1);
                return jSONObject2;
            }
        });
        this.ah.put("sendReward", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.17
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                x xVarD = c.this.d();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarD != null) {
                    xVarD.nw();
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                }
                jSONObject2.put("code", -1);
                return jSONObject2;
            }
        });
        this.ah.put("webview_time_track", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.18
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                return new JSONObject();
            }
        });
        this.ah.put("playable_event", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.19
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                x xVarD = c.this.d();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarD == null || jSONObject == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                xVarD.xr(jSONObject.optString(NotificationCompat.CATEGORY_EVENT, null), jSONObject.optJSONObject("params"));
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ah.put("reportAd", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.20
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                x xVarD = c.this.d();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarD == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ah.put(ILivePush.ClickType.CLOSE, new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.21
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                x xVarD = c.this.d();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarD == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ah.put("openAdLandPageLinks", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.22
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                x xVarD = c.this.d();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarD == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ah.put("get_viewport", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.24
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                x xVarD = c.this.d();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarD == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectT = xVarD.t();
                jSONObjectT.put("code", 1);
                return jSONObjectT;
            }
        });
        this.ah.put("jssdk_load_finish", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.25
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                x xVarD = c.this.d();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarD == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                xVarD.cv();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ah.put("playable_material_render_result", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.26
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                x xVarD = c.this.d();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarD == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                xVarD.hi(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ah.put("detect_change_playable_click", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.27
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                x xVarD = c.this.d();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarD == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectNy = xVarD.ny();
                jSONObjectNy.put("code", 1);
                return jSONObjectNy;
            }
        });
        this.ah.put("check_camera_permission", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.28
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                x xVarD = c.this.d();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarD == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectSl = xVarD.sl();
                jSONObjectSl.put("code", 1);
                return jSONObjectSl;
            }
        });
        this.ah.put("check_external_storage", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.29
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                x xVarD = c.this.d();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarD == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectZb = xVarD.zb();
                if (jSONObjectZb.isNull("result")) {
                    jSONObjectZb.put("code", -1);
                } else {
                    jSONObjectZb.put("code", 1);
                }
                return jSONObjectZb;
            }
        });
        this.ah.put("playable_open_camera", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.30
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                x xVarD = c.this.d();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarD == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                xVarD.ms(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ah.put("playable_pick_photo", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.31
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                x xVarD = c.this.d();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarD == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                xVarD.xr(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ah.put("playable_download_media_in_photos", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.32
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                x xVarD = c.this.d();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarD == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                xVarD.ah(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ah.put("playable_preventTouchEvent", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.33
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                x xVarD = c.this.d();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarD == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                xVarD.d(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ah.put("playable_settings_info", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.35
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                x xVarD = c.this.d();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarD == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectU = xVarD.u();
                jSONObjectU.put("code", 1);
                return jSONObjectU;
            }
        });
        this.ah.put("playable_load_main_scene", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.36
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                x xVarD = c.this.d();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarD == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                xVarD.b();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ah.put("playable_enter_section", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.37
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                x xVarD = c.this.d();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarD == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                xVarD.c(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ah.put("playable_end", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.38
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                x xVarD = c.this.d();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarD == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                xVarD.re();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ah.put("playable_finish_play_playable", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.39
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                x xVarD = c.this.d();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarD == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                xVarD.i();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ah.put("playable_transfrom_module_show", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.40
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                x xVarD = c.this.d();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarD == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                xVarD.w();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ah.put("playable_transfrom_module_change_color", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.41
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                x xVarD = c.this.d();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarD == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                xVarD.yu();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ah.put("playable_set_scroll_rect", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.42
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                x xVarD = c.this.d();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarD == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ah.put("playable_click_area", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.43
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                x xVarD = c.this.d();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarD == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                xVarD.ab(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ah.put("playable_real_play_start", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.44
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                x xVarD = c.this.d();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarD == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ah.put("playable_material_first_frame_show", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.46
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                x xVarD = c.this.d();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarD == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                xVarD.op();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ah.put("playable_stuck_check_pong", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.47
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                x xVarD = c.this.d();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarD == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                xVarD.le();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ah.put("playable_material_adnormal_mask", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.48
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                x xVarD = c.this.d();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarD == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                xVarD.x(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ah.put("playable_long_press_panel", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.49
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                x xVarD = c.this.d();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarD == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ah.put("playable_alpha_player_play", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.50
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                x xVarD = c.this.d();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarD == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ah.put("playable_transfrom_module_highlight", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.51
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                x xVarD = c.this.d();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarD == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ah.put("playable_send_click_event", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.52
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                x xVarD = c.this.d();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarD == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ah.put("playable_query_media_permission_declare", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.53
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                x xVarD = c.this.d();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarD == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectNy = xVarD.ny(jSONObject);
                jSONObjectNy.put("code", 1);
                return jSONObjectNy;
            }
        });
        this.ah.put("playable_query_media_permission_enable", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.54
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                x xVarD = c.this.d();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarD == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectCh = xVarD.ch(jSONObject);
                jSONObjectCh.put("code", 1);
                return jSONObjectCh;
            }
        });
        this.ah.put("playable_apply_media_permission", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.55
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.u.ms msVarKa = c.this.ka();
                JSONObject jSONObject2 = new JSONObject();
                if (msVarKa == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ah.put("playable_start_kws", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.57
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.u.ms msVarKa = c.this.ka();
                JSONObject jSONObject2 = new JSONObject();
                if (msVarKa == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ah.put("playable_close_kws", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.58
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.u.ms msVarKa = c.this.ka();
                JSONObject jSONObject2 = new JSONObject();
                if (msVarKa == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ah.put("playable_video_preload_task_add", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.59
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.u.ms msVarKa = c.this.ka();
                JSONObject jSONObject2 = new JSONObject();
                if (msVarKa == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ah.put("playable_video_preload_task_cancel", new ms() { // from class: com.bytedance.sdk.openadsdk.u.c.60
            @Override // com.bytedance.sdk.openadsdk.u.c.ms
            public JSONObject ms(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.u.ms msVarKa = c.this.ka();
                JSONObject jSONObject2 = new JSONObject();
                if (msVarKa == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public x d() {
        WeakReference<x> weakReference = this.xr;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.u.ms ka() {
        x xVarD = d();
        if (xVarD == null) {
            return null;
        }
        return xVarD.h();
    }

    public JSONObject ms(String str, JSONObject jSONObject) {
        try {
            ms msVar = this.ah.get(str);
            if (msVar == null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", -1);
                return jSONObject2;
            }
            return msVar.ms(jSONObject);
        } catch (Throwable th) {
            ab.ms("PlayableJsBridge", "invoke error", th);
            return null;
        }
    }

    public void xr() {
        ch.ms(this.f4134ms, this.d);
        ch.ms(this.f4134ms, this.ka);
        ch.ms(this.f4134ms, this.c);
        ch.ms(this.f4134ms, this.ab);
    }
}
