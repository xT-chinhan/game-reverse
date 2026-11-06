package com.byazt.ew;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.core.app.NotificationCompat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.android.live.base.api.push.ILivePush;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_INDEX_CACHE, 13})
public class w {
    public Context n;
    public WeakReference<fs> qg;
    public Map<String, n> s = new HashMap();
    public SensorEventListener q = new SensorEventListener() { // from class: com.byazt.ew.w.1
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            fs fsVarQ;
            if (sensorEvent.sensor.getType() != 1 || (fsVarQ = w.this.q()) == null) {
                return;
            }
            float f = sensorEvent.values[0];
            float f2 = sensorEvent.values[1];
            float f3 = sensorEvent.values[2];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(com.byazt.af.x.n, f);
                jSONObject.put("y", f2);
                jSONObject.put("z", f3);
                fsVarQ.n("accelerometer_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }
    };
    public SensorEventListener l = new SensorEventListener() { // from class: com.byazt.ew.w.12
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            fs fsVarQ;
            if (sensorEvent.sensor.getType() != 4 || (fsVarQ = w.this.q()) == null) {
                return;
            }
            float degrees = (float) Math.toDegrees(sensorEvent.values[0]);
            float degrees2 = (float) Math.toDegrees(sensorEvent.values[1]);
            float degrees3 = (float) Math.toDegrees(sensorEvent.values[2]);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(com.byazt.af.x.n, degrees);
                jSONObject.put("y", degrees2);
                jSONObject.put("z", degrees3);
                fsVarQ.n("gyro_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }
    };
    public SensorEventListener w = new SensorEventListener() { // from class: com.byazt.ew.w.23
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            fs fsVarQ;
            if (sensorEvent.sensor.getType() != 10 || (fsVarQ = w.this.q()) == null) {
                return;
            }
            float f = sensorEvent.values[0];
            float f2 = sensorEvent.values[1];
            float f3 = sensorEvent.values[2];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(com.byazt.af.x.n, f);
                jSONObject.put("y", f2);
                jSONObject.put("z", f3);
                fsVarQ.n("accelerometer_grativityless_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }
    };
    public SensorEventListener x = new SensorEventListener() { // from class: com.byazt.ew.w.34
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 1) {
                System.arraycopy(sensorEvent.values, 0, tj.qg, 0, tj.qg.length);
            } else if (sensorEvent.sensor.getType() == 2) {
                System.arraycopy(sensorEvent.values, 0, tj.s, 0, tj.s.length);
            }
            SensorManager.getRotationMatrix(tj.q, null, tj.qg, tj.s);
            SensorManager.getOrientation(tj.q, tj.l);
            fs fsVarQ = w.this.q();
            if (fsVarQ == null) {
                return;
            }
            float f = tj.l[0];
            float f2 = tj.l[1];
            float f3 = tj.l[2];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("alpha", f);
                jSONObject.put("beta", f2);
                jSONObject.put("gamma", f3);
                fsVarQ.n("rotation_vector_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }
    };

    interface n {
        JSONObject n(JSONObject jSONObject) throws Throwable;
    }

    public w(fs fsVar) {
        this.n = fsVar.getContext();
        this.qg = new WeakReference<>(fsVar);
        s();
    }

    public Set<String> n() {
        return this.s.keySet();
    }

    private void s() {
        this.s.put("adInfo", new n() { // from class: com.byazt.ew.w.45
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                fs fsVarQ = w.this.q();
                if (fsVarQ != null) {
                    JSONObject jSONObjectUm = fsVarQ.um();
                    if (jSONObjectUm != null) {
                        jSONObjectUm.put("code", 1);
                        return jSONObjectUm;
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
        this.s.put("appInfo", new n() { // from class: com.byazt.ew.w.56
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", 1);
                jSONObject2.put("appName", "playable_sdk");
                jSONObject2.put("playableSdkEdition", "6.5.1");
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = w.this.n().iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                jSONObject2.put("supportList", jSONArray);
                fs fsVarQ = w.this.q();
                if (fsVarQ != null) {
                    jSONObject2.put("deviceId", fsVarQ.w());
                    jSONObject2.put("netType", fsVarQ.cy());
                    jSONObject2.put("innerAppName", fsVarQ.s());
                    jSONObject2.put("appName", fsVarQ.q());
                    jSONObject2.put("appVersion", fsVarQ.l());
                    Map<String, String> mapN = fsVarQ.n();
                    for (String str : mapN.keySet()) {
                        jSONObject2.put(str, mapN.get(str));
                    }
                }
                return jSONObject2;
            }
        });
        this.s.put("playableSDKInfo", new n() { // from class: com.byazt.ew.w.61
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", 1);
                jSONObject2.put("appName", "playable_sdk");
                jSONObject2.put("playableSdkEdition", "6.5.1");
                jSONObject2.put(TapEventParamConstants.PARAM_SUB_OS, "android");
                return jSONObject2;
            }
        });
        this.s.put("subscribe_app_ad", new n() { // from class: com.byazt.ew.w.62
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                com.byazt.ew.n nVarL = w.this.l();
                JSONObject jSONObject2 = new JSONObject();
                if (nVarL == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.s.put("download_app_ad", new n() { // from class: com.byazt.ew.w.63
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                com.byazt.ew.n nVarL = w.this.l();
                JSONObject jSONObject2 = new JSONObject();
                if (nVarL == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.s.put("isViewable", new n() { // from class: com.byazt.ew.w.2
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                fs fsVarQ = w.this.q();
                if (fsVarQ == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("code", 1);
                jSONObject3.put("viewStatus", fsVarQ.fs());
                return jSONObject3;
            }
        });
        this.s.put("getVolume", new n() { // from class: com.byazt.ew.w.3
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                fs fsVarQ = w.this.q();
                if (fsVarQ == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("code", 1);
                jSONObject3.put("endcard_mute", fsVarQ.x());
                return jSONObject3;
            }
        });
        this.s.put("getScreenSize", new n() { // from class: com.byazt.ew.w.4
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                fs fsVarQ = w.this.q();
                if (fsVarQ == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectCd = fsVarQ.cd();
                jSONObjectCd.put("code", 1);
                return jSONObjectCd;
            }
        });
        this.s.put("start_accelerometer_observer", new n() { // from class: com.byazt.ew.w.5
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int iOptInt = 2;
                if (jSONObject != null) {
                    try {
                        iOptInt = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        x.n("PlayableJsBridge", "invoke start_accelerometer_observer error", th);
                        jSONObject2.put("code", -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                tj.n(w.this.n, w.this.q, iOptInt);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.s.put("close_accelerometer_observer", new n() { // from class: com.byazt.ew.w.6
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    tj.n(w.this.n, w.this.q);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    x.n("PlayableJsBridge", "invoke close_accelerometer_observer error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.s.put("start_gyro_observer", new n() { // from class: com.byazt.ew.w.7
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int iOptInt = 2;
                if (jSONObject != null) {
                    try {
                        iOptInt = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        x.n("PlayableJsBridge", "invoke start_gyro_observer error", th);
                        jSONObject2.put("code", -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                tj.qg(w.this.n, w.this.l, iOptInt);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.s.put("close_gyro_observer", new n() { // from class: com.byazt.ew.w.8
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    tj.n(w.this.n, w.this.l);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    x.n("PlayableJsBridge", "invoke close_gyro_observer error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.s.put("start_accelerometer_grativityless_observer", new n() { // from class: com.byazt.ew.w.9
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int iOptInt = 2;
                if (jSONObject != null) {
                    try {
                        iOptInt = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        x.n("PlayableJsBridge", "invoke start_accelerometer_grativityless_observer error", th);
                        jSONObject2.put("code", -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                tj.s(w.this.n, w.this.w, iOptInt);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.s.put("close_accelerometer_grativityless_observer", new n() { // from class: com.byazt.ew.w.10
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    tj.n(w.this.n, w.this.w);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    x.n("PlayableJsBridge", "invoke close_accelerometer_grativityless_observer error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.s.put("start_rotation_vector_observer", new n() { // from class: com.byazt.ew.w.11
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int iOptInt = 2;
                if (jSONObject != null) {
                    try {
                        iOptInt = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        x.n("PlayableJsBridge", "invoke start_rotation_vector_observer error", th);
                        jSONObject2.put("code", -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                tj.q(w.this.n, w.this.x, iOptInt);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.s.put("close_rotation_vector_observer", new n() { // from class: com.byazt.ew.w.13
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    tj.n(w.this.n, w.this.x);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    x.n("PlayableJsBridge", "invoke close_rotation_vector_observer error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.s.put("device_shake", new n() { // from class: com.byazt.ew.w.14
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    tj.n(w.this.n, 300L);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    x.n("PlayableJsBridge", "invoke device_shake error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.s.put("device_shake_short", new n() { // from class: com.byazt.ew.w.15
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    tj.n(w.this.n, 150L);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    x.n("PlayableJsBridge", "invoke device_shake error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.s.put("playable_style", new n() { // from class: com.byazt.ew.w.16
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                fs fsVarQ = w.this.q();
                JSONObject jSONObject2 = new JSONObject();
                if (fsVarQ != null) {
                    JSONObject jSONObjectQg = fsVarQ.qg();
                    jSONObjectQg.put("code", 1);
                    return jSONObjectQg;
                }
                jSONObject2.put("code", -1);
                return jSONObject2;
            }
        });
        this.s.put("sendReward", new n() { // from class: com.byazt.ew.w.17
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                fs fsVarQ = w.this.q();
                JSONObject jSONObject2 = new JSONObject();
                if (fsVarQ != null) {
                    fsVarQ.py();
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                }
                jSONObject2.put("code", -1);
                return jSONObject2;
            }
        });
        this.s.put("webview_time_track", new n() { // from class: com.byazt.ew.w.18
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                return new JSONObject();
            }
        });
        this.s.put("playable_event", new n() { // from class: com.byazt.ew.w.19
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                fs fsVarQ = w.this.q();
                JSONObject jSONObject2 = new JSONObject();
                if (fsVarQ == null || jSONObject == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                fsVarQ.qg(jSONObject.optString(NotificationCompat.CATEGORY_EVENT, null), jSONObject.optJSONObject("params"));
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.s.put("reportAd", new n() { // from class: com.byazt.ew.w.20
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                fs fsVarQ = w.this.q();
                JSONObject jSONObject2 = new JSONObject();
                if (fsVarQ == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.s.put(ILivePush.ClickType.CLOSE, new n() { // from class: com.byazt.ew.w.21
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                fs fsVarQ = w.this.q();
                JSONObject jSONObject2 = new JSONObject();
                if (fsVarQ == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.s.put("openAdLandPageLinks", new n() { // from class: com.byazt.ew.w.22
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                fs fsVarQ = w.this.q();
                JSONObject jSONObject2 = new JSONObject();
                if (fsVarQ == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.s.put("get_viewport", new n() { // from class: com.byazt.ew.w.24
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                fs fsVarQ = w.this.q();
                JSONObject jSONObject2 = new JSONObject();
                if (fsVarQ == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectA = fsVarQ.a();
                jSONObjectA.put("code", 1);
                return jSONObjectA;
            }
        });
        this.s.put("jssdk_load_finish", new n() { // from class: com.byazt.ew.w.25
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                fs fsVarQ = w.this.q();
                JSONObject jSONObject2 = new JSONObject();
                if (fsVarQ == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                fsVarQ.bb();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.s.put("playable_material_render_result", new n() { // from class: com.byazt.ew.w.26
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                fs fsVarQ = w.this.q();
                JSONObject jSONObject2 = new JSONObject();
                if (fsVarQ == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                fsVarQ.cp(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.s.put("detect_change_playable_click", new n() { // from class: com.byazt.ew.w.27
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                fs fsVarQ = w.this.q();
                JSONObject jSONObject2 = new JSONObject();
                if (fsVarQ == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectRv = fsVarQ.rv();
                jSONObjectRv.put("code", 1);
                return jSONObjectRv;
            }
        });
        this.s.put("check_camera_permission", new n() { // from class: com.byazt.ew.w.28
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                fs fsVarQ = w.this.q();
                JSONObject jSONObject2 = new JSONObject();
                if (fsVarQ == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectD = fsVarQ.d();
                jSONObjectD.put("code", 1);
                return jSONObjectD;
            }
        });
        this.s.put("check_external_storage", new n() { // from class: com.byazt.ew.w.29
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                fs fsVarQ = w.this.q();
                JSONObject jSONObject2 = new JSONObject();
                if (fsVarQ == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectOa = fsVarQ.oa();
                if (jSONObjectOa.isNull("result")) {
                    jSONObjectOa.put("code", -1);
                } else {
                    jSONObjectOa.put("code", 1);
                }
                return jSONObjectOa;
            }
        });
        this.s.put("playable_open_camera", new n() { // from class: com.byazt.ew.w.30
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                fs fsVarQ = w.this.q();
                JSONObject jSONObject2 = new JSONObject();
                if (fsVarQ == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                fsVarQ.n(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.s.put("playable_pick_photo", new n() { // from class: com.byazt.ew.w.31
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                fs fsVarQ = w.this.q();
                JSONObject jSONObject2 = new JSONObject();
                if (fsVarQ == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                fsVarQ.qg(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.s.put("playable_download_media_in_photos", new n() { // from class: com.byazt.ew.w.32
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                fs fsVarQ = w.this.q();
                JSONObject jSONObject2 = new JSONObject();
                if (fsVarQ == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                fsVarQ.s(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.s.put("playable_preventTouchEvent", new n() { // from class: com.byazt.ew.w.33
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                fs fsVarQ = w.this.q();
                JSONObject jSONObject2 = new JSONObject();
                if (fsVarQ == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                fsVarQ.q(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.s.put("playable_settings_info", new n() { // from class: com.byazt.ew.w.35
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                fs fsVarQ = w.this.q();
                JSONObject jSONObject2 = new JSONObject();
                if (fsVarQ == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectSz = fsVarQ.sz();
                jSONObjectSz.put("code", 1);
                return jSONObjectSz;
            }
        });
        this.s.put("playable_load_main_scene", new n() { // from class: com.byazt.ew.w.36
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                fs fsVarQ = w.this.q();
                JSONObject jSONObject2 = new JSONObject();
                if (fsVarQ == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                fsVarQ.ou();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.s.put("playable_enter_section", new n() { // from class: com.byazt.ew.w.37
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                fs fsVarQ = w.this.q();
                JSONObject jSONObject2 = new JSONObject();
                if (fsVarQ == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                fsVarQ.w(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.s.put("playable_end", new n() { // from class: com.byazt.ew.w.38
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                fs fsVarQ = w.this.q();
                JSONObject jSONObject2 = new JSONObject();
                if (fsVarQ == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                fsVarQ.wm();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.s.put("playable_finish_play_playable", new n() { // from class: com.byazt.ew.w.39
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                fs fsVarQ = w.this.q();
                JSONObject jSONObject2 = new JSONObject();
                if (fsVarQ == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                fsVarQ.m();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.s.put("playable_transfrom_module_show", new n() { // from class: com.byazt.ew.w.40
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                fs fsVarQ = w.this.q();
                JSONObject jSONObject2 = new JSONObject();
                if (fsVarQ == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                fsVarQ.hu();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.s.put("playable_transfrom_module_change_color", new n() { // from class: com.byazt.ew.w.41
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                fs fsVarQ = w.this.q();
                JSONObject jSONObject2 = new JSONObject();
                if (fsVarQ == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                fsVarQ.h();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.s.put("playable_set_scroll_rect", new n() { // from class: com.byazt.ew.w.42
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                fs fsVarQ = w.this.q();
                JSONObject jSONObject2 = new JSONObject();
                if (fsVarQ == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.s.put("playable_click_area", new n() { // from class: com.byazt.ew.w.43
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                fs fsVarQ = w.this.q();
                JSONObject jSONObject2 = new JSONObject();
                if (fsVarQ == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                fsVarQ.x(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.s.put("playable_real_play_start", new n() { // from class: com.byazt.ew.w.44
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                fs fsVarQ = w.this.q();
                JSONObject jSONObject2 = new JSONObject();
                if (fsVarQ == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.s.put("playable_material_first_frame_show", new n() { // from class: com.byazt.ew.w.46
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                fs fsVarQ = w.this.q();
                JSONObject jSONObject2 = new JSONObject();
                if (fsVarQ == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                fsVarQ.t();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.s.put("playable_stuck_check_pong", new n() { // from class: com.byazt.ew.w.47
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                fs fsVarQ = w.this.q();
                JSONObject jSONObject2 = new JSONObject();
                if (fsVarQ == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                fsVarQ.ur();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.s.put("playable_material_adnormal_mask", new n() { // from class: com.byazt.ew.w.48
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                fs fsVarQ = w.this.q();
                JSONObject jSONObject2 = new JSONObject();
                if (fsVarQ == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                fsVarQ.fs(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.s.put("playable_long_press_panel", new n() { // from class: com.byazt.ew.w.49
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                fs fsVarQ = w.this.q();
                JSONObject jSONObject2 = new JSONObject();
                if (fsVarQ == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.s.put("playable_alpha_player_play", new n() { // from class: com.byazt.ew.w.50
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                fs fsVarQ = w.this.q();
                JSONObject jSONObject2 = new JSONObject();
                if (fsVarQ == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.s.put("playable_transfrom_module_highlight", new n() { // from class: com.byazt.ew.w.51
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                fs fsVarQ = w.this.q();
                JSONObject jSONObject2 = new JSONObject();
                if (fsVarQ == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.s.put("playable_send_click_event", new n() { // from class: com.byazt.ew.w.52
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                fs fsVarQ = w.this.q();
                JSONObject jSONObject2 = new JSONObject();
                if (fsVarQ == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.s.put("playable_query_media_permission_declare", new n() { // from class: com.byazt.ew.w.53
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                fs fsVarQ = w.this.q();
                JSONObject jSONObject2 = new JSONObject();
                if (fsVarQ == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectRv = fsVarQ.rv(jSONObject);
                jSONObjectRv.put("code", 1);
                return jSONObjectRv;
            }
        });
        this.s.put("playable_query_media_permission_enable", new n() { // from class: com.byazt.ew.w.54
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                fs fsVarQ = w.this.q();
                JSONObject jSONObject2 = new JSONObject();
                if (fsVarQ == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectTj = fsVarQ.tj(jSONObject);
                jSONObjectTj.put("code", 1);
                return jSONObjectTj;
            }
        });
        this.s.put("playable_apply_media_permission", new n() { // from class: com.byazt.ew.w.55
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                com.byazt.ew.n nVarL = w.this.l();
                JSONObject jSONObject2 = new JSONObject();
                if (nVarL == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.s.put("playable_start_kws", new n() { // from class: com.byazt.ew.w.57
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                com.byazt.ew.n nVarL = w.this.l();
                JSONObject jSONObject2 = new JSONObject();
                if (nVarL == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.s.put("playable_close_kws", new n() { // from class: com.byazt.ew.w.58
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                com.byazt.ew.n nVarL = w.this.l();
                JSONObject jSONObject2 = new JSONObject();
                if (nVarL == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.s.put("playable_video_preload_task_add", new n() { // from class: com.byazt.ew.w.59
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                com.byazt.ew.n nVarL = w.this.l();
                JSONObject jSONObject2 = new JSONObject();
                if (nVarL == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.s.put("playable_video_preload_task_cancel", new n() { // from class: com.byazt.ew.w.60
            @Override // com.byazt.ew.w.n
            public JSONObject n(JSONObject jSONObject) throws Throwable {
                com.byazt.ew.n nVarL = w.this.l();
                JSONObject jSONObject2 = new JSONObject();
                if (nVarL == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public fs q() {
        WeakReference<fs> weakReference = this.qg;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.ew.n l() {
        fs fsVarQ = q();
        if (fsVarQ == null) {
            return null;
        }
        return fsVarQ.hd();
    }

    public JSONObject n(String str, JSONObject jSONObject) {
        try {
            n nVar = this.s.get(str);
            if (nVar == null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", -1);
                return jSONObject2;
            }
            return nVar.n(jSONObject);
        } catch (Throwable th) {
            x.n("PlayableJsBridge", "invoke error", th);
            return null;
        }
    }

    public void qg() {
        tj.n(this.n, this.q);
        tj.n(this.n, this.l);
        tj.n(this.n, this.w);
        tj.n(this.n, this.x);
    }
}
