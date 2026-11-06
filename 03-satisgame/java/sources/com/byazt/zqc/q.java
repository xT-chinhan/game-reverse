package com.byazt.zqc;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.byazt.tka.tj;
import com.byazt.vf.oa;
import com.byazt.vf.wo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_START_TIME, 5})
public class q implements SensorEventListener {
    public static volatile q n;
    public Sensor k;
    public Sensor sz;
    public volatile n um;
    public volatile boolean qg = false;
    public final List<Float> s = new ArrayList(1);
    public final List<Float> q = new ArrayList(1);
    public final List<Float> l = new ArrayList(1);
    public final List<Float> w = new ArrayList(1);
    public final List<Float> x = new ArrayList(1);
    public final List<Float> fs = new ArrayList(1);
    public final int rv = 0;
    public final int tj = 1;
    public final int cp = 2;
    public final int d = 16;
    public final int oa = 32;
    public long cy = 0;
    public volatile boolean hd = false;
    public volatile AtomicInteger cd = new AtomicInteger(0);
    public volatile int a = 0;

    public interface n {
        void n(JSONObject jSONObject);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    private q() {
        this.sz = null;
        this.k = null;
        SensorManager sensorManager = (SensorManager) tj.s().getApplicationContext().getSystemService("sensor");
        if (sensorManager != null) {
            try {
                this.sz = sensorManager.getDefaultSensor(1);
                this.k = sensorManager.getDefaultSensor(2);
            } catch (Exception unused) {
            }
        }
    }

    public static q n() {
        if (n == null) {
            synchronized (q.class) {
                if (n == null) {
                    n = new q();
                }
            }
        }
        return n;
    }

    public void n(n nVar) {
        this.um = nVar;
    }

    public synchronized boolean qg() {
        int i;
        int i2;
        this.a = 0;
        if (this.hd) {
            return false;
        }
        if (this.sz != null && this.k != null) {
            this.hd = false;
            SensorManager sensorManager = (SensorManager) tj.s().getApplicationContext().getSystemService("sensor");
            i = 1;
            if (sensorManager != null) {
                try {
                    boolean zRegisterListener = sensorManager.registerListener(this, this.sz, 1);
                    boolean zRegisterListener2 = sensorManager.registerListener(this, this.k, 1);
                    if (!zRegisterListener || !zRegisterListener2) {
                        this.a |= 32;
                        l();
                        x();
                    } else {
                        this.hd = true;
                        this.qg = false;
                    }
                } catch (Exception unused) {
                    i2 = this.a;
                    i = 32;
                    this.a = i2 | i;
                }
                return this.hd;
            }
            i2 = this.a;
        } else {
            this.a |= this.sz == null ? 2 : 0;
            int i3 = this.a;
            i = this.k == null ? 16 : 0;
            i2 = i3;
        }
        this.a = i2 | i;
        return this.hd;
    }

    private void l() {
        this.cd = new AtomicInteger(0);
        SensorManager sensorManager = (SensorManager) tj.s().getApplicationContext().getSystemService("sensor");
        if (sensorManager != null) {
            Sensor sensor = this.sz;
            if (sensor != null) {
                sensorManager.unregisterListener(this, sensor);
            }
            Sensor sensor2 = this.k;
            if (sensor2 != null) {
                sensorManager.unregisterListener(this, sensor2);
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        this.cd.incrementAndGet();
        if (sensorEvent == null || sensorEvent.sensor == null) {
            return;
        }
        int type = sensorEvent.sensor.getType();
        if (sensorEvent.values == null || sensorEvent.values.length < 3) {
            return;
        }
        if (type == 1) {
            if (this.s.size() <= 0) {
                this.s.add(Float.valueOf(sensorEvent.values[0]));
                this.q.add(Float.valueOf(sensorEvent.values[1]));
                this.l.add(Float.valueOf(sensorEvent.values[2]));
                return;
            }
            w();
            return;
        }
        if (type != 2) {
            return;
        }
        if (this.w.size() <= 0) {
            this.w.add(Float.valueOf(sensorEvent.values[0]));
            this.x.add(Float.valueOf(sensorEvent.values[1]));
            this.fs.add(Float.valueOf(sensorEvent.values[2]));
            return;
        }
        w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(float[] fArr) {
        this.cy = System.currentTimeMillis();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("t", q());
            jSONObject.put("val", new JSONArray(fArr));
            qg.n().n(jSONObject, "sp_angle");
            qg.n().n(((oa) com.byazt.qp.q.n("device_info_new")).n(60000L));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private synchronized void w() {
        if (!this.qg && this.s.size() > 0 && this.w.size() > 0) {
            this.qg = true;
            l();
            ((wo) com.byazt.qp.q.n("thread_service")).n(new Runnable() { // from class: com.byazt.zqc.q.1
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        float[] fArrN = s.n(q.this.s, q.this.q, q.this.l, q.this.w, q.this.x, q.this.fs);
                        q.this.n(fArrN);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        long jW = l.n().w();
                        long jX = l.n().x();
                        int iS = (int) (((l.n().s() / 1000) / 60) / 60);
                        if (iS <= 0) {
                            iS = 1;
                        }
                        jSONObject.put("azimuth_unit", jW);
                        jSONObject.put("angle_unit", jX);
                        LinkedList<JSONObject> linkedListN = qg.n().n(0L);
                        jSONObject.put("active", Arrays.toString(s.n(linkedListN, iS)));
                        com.byazt.zqc.n.n().n(iS);
                        jSONObject.put("screen", Arrays.toString(com.byazt.zqc.n.n().s()));
                        jSONObject.put("network", Arrays.toString(com.byazt.zqc.n.n().qg()));
                        jSONObject.put("support_net", com.byazt.zqc.n.n().q());
                        jSONObject.put("sim_status", com.byazt.zqc.n.n().l());
                        int[][] iArrN = s.n(linkedListN, jW, jX);
                        jSONObject.put("ax", Arrays.toString(iArrN[0]));
                        jSONObject.put("ay", Arrays.toString(iArrN[1]));
                        jSONObject.put("az", Arrays.toString(iArrN[2]));
                        int[][] iArrN2 = s.n(qg.n().n(10800000L), jW, jX);
                        jSONObject.put("ax3", Arrays.toString(iArrN2[0]));
                        jSONObject.put("ay3", Arrays.toString(iArrN2[1]));
                        jSONObject.put("az3", Arrays.toString(iArrN2[2]));
                        int[][] iArrN3 = s.n(qg.n().n(21600000L), jW, jX);
                        jSONObject.put("ax6", Arrays.toString(iArrN3[0]));
                        jSONObject.put("ay6", Arrays.toString(iArrN3[1]));
                        jSONObject.put("az6", Arrays.toString(iArrN3[2]));
                        jSONObject.put("angleAvg", Arrays.toString(fArrN));
                        jSONObject.put(TapEventParamConstants.PARAM_SUB_TIMESTAMP, jCurrentTimeMillis);
                    } catch (Exception unused) {
                        jSONObject = null;
                    }
                    if (q.this.um != null) {
                        q.this.um.n(jSONObject);
                    }
                    q.this.x();
                    q.this.hd = false;
                }
            });
        } else {
            if (this.cd.get() > 3) {
                l();
                x();
                this.hd = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        this.s.clear();
        this.q.clear();
        this.l.clear();
        this.w.clear();
        this.x.clear();
        this.fs.clear();
    }

    public boolean s() {
        return this.hd;
    }

    public long q() {
        return this.cy;
    }
}
