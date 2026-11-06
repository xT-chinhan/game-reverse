package com.bytedance.sdk.component.panglearmor.xr;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.bytedance.sdk.component.ch.ab;
import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.component.panglearmor.c;
import com.bytedance.sdk.component.utils.u;
import com.umeng.analytics.pro.bv;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d implements SensorEventListener {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile d f1319ms;
    private Sensor u;
    private Sensor ub;
    private volatile ms y;
    private volatile boolean xr = false;
    private final List<Float> ah = new ArrayList(1);
    private final List<Float> d = new ArrayList(1);
    private final List<Float> ka = new ArrayList(1);
    private final List<Float> c = new ArrayList(1);
    private final List<Float> ab = new ArrayList(1);
    private final List<Float> x = new ArrayList(1);
    private final int ny = 0;
    private final int ch = 1;
    private final int hi = 2;
    private final int sl = 16;
    private final int zb = 32;
    private long ao = 0;
    private volatile boolean h = false;
    private volatile AtomicInteger qv = new AtomicInteger(0);
    private volatile int t = 0;

    public interface ms {
        void ms(JSONObject jSONObject);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    private d() {
        this.u = null;
        this.ub = null;
        SensorManager sensorManager = (SensorManager) c.d().getApplicationContext().getSystemService("sensor");
        if (sensorManager != null) {
            try {
                this.u = sensorManager.getDefaultSensor(1);
                this.ub = sensorManager.getDefaultSensor(2);
            } catch (Exception unused) {
            }
        }
    }

    public static d ms() {
        if (f1319ms == null) {
            synchronized (d.class) {
                if (f1319ms == null) {
                    f1319ms = new d();
                }
            }
        }
        return f1319ms;
    }

    public void ms(ms msVar) {
        this.y = msVar;
    }

    public synchronized boolean xr() {
        int i;
        int i2;
        this.t = 0;
        if (this.h) {
            return false;
        }
        if (this.u != null && this.ub != null) {
            this.h = false;
            SensorManager sensorManager = (SensorManager) c.d().getApplicationContext().getSystemService("sensor");
            i = 1;
            if (sensorManager != null) {
                try {
                    boolean zRegisterListener = sensorManager.registerListener(this, this.u, 1);
                    boolean zRegisterListener2 = sensorManager.registerListener(this, this.ub, 1);
                    if (!zRegisterListener || !zRegisterListener2) {
                        this.t |= 32;
                        ka();
                        ab();
                    } else {
                        this.h = true;
                        this.xr = false;
                    }
                } catch (Exception unused) {
                    i2 = this.t;
                    i = 32;
                    this.t = i2 | i;
                }
                return this.h;
            }
            i2 = this.t;
        } else {
            this.t |= this.u == null ? 2 : 0;
            int i3 = this.t;
            i = this.ub == null ? 16 : 0;
            i2 = i3;
        }
        this.t = i2 | i;
        return this.h;
    }

    private void ka() {
        this.qv = new AtomicInteger(0);
        SensorManager sensorManager = (SensorManager) c.d().getApplicationContext().getSystemService("sensor");
        if (sensorManager != null) {
            Sensor sensor = this.u;
            if (sensor != null) {
                sensorManager.unregisterListener(this, sensor);
            }
            Sensor sensor2 = this.ub;
            if (sensor2 != null) {
                sensorManager.unregisterListener(this, sensor2);
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        this.qv.incrementAndGet();
        int type = sensorEvent.sensor.getType();
        if (type == 1) {
            if (this.ah.size() <= 0) {
                this.ah.add(Float.valueOf(sensorEvent.values[0]));
                this.d.add(Float.valueOf(sensorEvent.values[1]));
                this.ka.add(Float.valueOf(sensorEvent.values[2]));
                return;
            }
            c();
            return;
        }
        if (type != 2) {
            return;
        }
        if (this.c.size() <= 0) {
            this.c.add(Float.valueOf(sensorEvent.values[0]));
            this.ab.add(Float.valueOf(sensorEvent.values[1]));
            this.x.add(Float.valueOf(sensorEvent.values[2]));
            return;
        }
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(float[] fArr) {
        this.ao = System.currentTimeMillis();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(bv.aI, d());
            jSONObject.put("val", new JSONArray(fArr));
            xr.ms().ms(jSONObject, "sp_angle");
            xr.ms().ms(u.ah(c.d()));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private synchronized void c() {
        if (!this.xr && this.ah.size() > 0 && this.c.size() > 0) {
            this.xr = true;
            ka();
            ab.xr(new ny("har") { // from class: com.bytedance.sdk.component.panglearmor.xr.d.1
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        float[] fArrMs = ah.ms(d.this.ah, d.this.d, d.this.ka, d.this.c, d.this.ab, d.this.x);
                        d.this.ms(fArrMs);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        long jC = ka.ms().c();
                        long jAb = ka.ms().ab();
                        int iAh = (int) (((ka.ms().ah() / 1000) / 60) / 60);
                        if (iAh <= 0) {
                            iAh = 1;
                        }
                        jSONObject.put("azimuth_unit", jC);
                        jSONObject.put("angle_unit", jAb);
                        LinkedList<JSONObject> linkedListMs = xr.ms().ms(0L);
                        jSONObject.put("active", Arrays.toString(ah.ms(linkedListMs, iAh)));
                        com.bytedance.sdk.component.panglearmor.xr.ms.ms().ms(iAh);
                        jSONObject.put("screen", Arrays.toString(com.bytedance.sdk.component.panglearmor.xr.ms.ms().ah()));
                        jSONObject.put("network", Arrays.toString(com.bytedance.sdk.component.panglearmor.xr.ms.ms().xr()));
                        jSONObject.put("support_net", com.bytedance.sdk.component.panglearmor.xr.ms.ms().d());
                        jSONObject.put("sim_status", com.bytedance.sdk.component.panglearmor.xr.ms.ms().ka());
                        int[][] iArrMs = ah.ms(linkedListMs, jC, jAb);
                        jSONObject.put("ax", Arrays.toString(iArrMs[0]));
                        jSONObject.put("ay", Arrays.toString(iArrMs[1]));
                        jSONObject.put("az", Arrays.toString(iArrMs[2]));
                        int[][] iArrMs2 = ah.ms(xr.ms().ms(10800000L), jC, jAb);
                        jSONObject.put("ax3", Arrays.toString(iArrMs2[0]));
                        jSONObject.put("ay3", Arrays.toString(iArrMs2[1]));
                        jSONObject.put("az3", Arrays.toString(iArrMs2[2]));
                        int[][] iArrMs3 = ah.ms(xr.ms().ms(21600000L), jC, jAb);
                        jSONObject.put("ax6", Arrays.toString(iArrMs3[0]));
                        jSONObject.put("ay6", Arrays.toString(iArrMs3[1]));
                        jSONObject.put("az6", Arrays.toString(iArrMs3[2]));
                        jSONObject.put("angleAvg", Arrays.toString(fArrMs));
                        jSONObject.put("timestamp", jCurrentTimeMillis);
                    } catch (Exception unused) {
                        jSONObject = null;
                    }
                    if (d.this.y != null) {
                        d.this.y.ms(jSONObject);
                    }
                    d.this.ab();
                    d.this.h = false;
                }
            });
        } else {
            if (this.qv.get() > 3) {
                ka();
                ab();
                this.h = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab() {
        this.ah.clear();
        this.d.clear();
        this.ka.clear();
        this.c.clear();
        this.ab.clear();
        this.x.clear();
    }

    public boolean ah() {
        return this.h;
    }

    public long d() {
        return this.ao;
    }
}
