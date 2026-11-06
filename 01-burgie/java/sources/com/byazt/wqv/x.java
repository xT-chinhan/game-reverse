package com.byazt.wqv;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import com.byazt.vkw.g;
import com.byazt.vkw.qi;
import com.byazt.yi.zo;
import com.byazt.zs.uc;
import com.umeng.analytics.pro.an;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 399, 121})
public class x implements SensorEventListener {
    public static volatile x pr;
    public Sensor g;
    public Sensor ho;
    public volatile pr qa;
    public volatile boolean hw = false;
    public final List<Float> hn = new ArrayList(1);
    public final List<Float> x = new ArrayList(1);
    public final List<Float> c = new ArrayList(1);
    public final List<Float> uc = new ArrayList(1);
    public final List<Float> fw = new ArrayList(1);
    public final List<Float> zo = new ArrayList(1);
    public final int aj = 0;
    public final int vk = 1;
    public final int w = 2;
    public final int k = 16;
    public final int m = 32;
    public long nt = 0;
    public volatile boolean yb = false;
    public volatile AtomicInteger lb = new AtomicInteger(0);
    public volatile int a = 0;

    public interface pr {
        void pr(JSONObject jSONObject);
    }

    private x() {
        this.g = null;
        this.ho = null;
        SensorManager sensorManager = (SensorManager) zo.hn().getApplicationContext().getSystemService(an.ac);
        if (sensorManager != null) {
            try {
                this.g = sensorManager.getDefaultSensor(1);
                this.ho = sensorManager.getDefaultSensor(2);
            } catch (Exception e) {
            }
        }
    }

    public static x pr() {
        if (pr == null) {
            synchronized (x.class) {
                if (pr == null) {
                    pr = new x();
                }
            }
        }
        return pr;
    }

    public void pr(pr prVar) {
        this.qa = prVar;
    }

    public synchronized boolean hw() {
        int i;
        this.a = 0;
        if (this.yb) {
            return false;
        }
        int i2 = 32;
        if (this.g != null && this.ho != null) {
            this.yb = false;
            SensorManager sensorManager = (SensorManager) zo.hn().getApplicationContext().getSystemService(an.ac);
            if (sensorManager != null) {
                try {
                    boolean zRegisterListener = sensorManager.registerListener(this, this.g, 1);
                    boolean zRegisterListener2 = sensorManager.registerListener(this, this.ho, 1);
                    if (!zRegisterListener || !zRegisterListener2) {
                        this.a |= 32;
                        c();
                        fw();
                    } else {
                        this.yb = true;
                        this.hw = false;
                    }
                } catch (Exception e) {
                    i = this.a;
                    this.a = i | i2;
                }
                return this.yb;
            }
            i = this.a;
            i2 = 1;
        } else {
            this.a |= this.g == null ? 2 : 0;
            int i3 = this.a;
            i2 = this.ho == null ? 16 : 0;
            i = i3;
        }
        this.a = i | i2;
        return this.yb;
    }

    private void c() {
        this.lb = new AtomicInteger(0);
        SensorManager sensorManager = (SensorManager) zo.hn().getApplicationContext().getSystemService(an.ac);
        if (sensorManager != null) {
            Sensor sensor = this.g;
            if (sensor != null) {
                sensorManager.unregisterListener(this, sensor);
            }
            Sensor sensor2 = this.ho;
            if (sensor2 != null) {
                sensorManager.unregisterListener(this, sensor2);
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        this.lb.incrementAndGet();
        if (sensorEvent == null || sensorEvent.sensor == null) {
            return;
        }
        int type = sensorEvent.sensor.getType();
        if (sensorEvent.values == null || sensorEvent.values.length < 3) {
            return;
        }
        switch (type) {
            case 1:
                if (this.hn.size() <= 0) {
                    this.hn.add(Float.valueOf(sensorEvent.values[0]));
                    this.x.add(Float.valueOf(sensorEvent.values[1]));
                    this.c.add(Float.valueOf(sensorEvent.values[2]));
                } else {
                    uc();
                }
                break;
            case 2:
                if (this.uc.size() <= 0) {
                    this.uc.add(Float.valueOf(sensorEvent.values[0]));
                    this.fw.add(Float.valueOf(sensorEvent.values[1]));
                    this.zo.add(Float.valueOf(sensorEvent.values[2]));
                } else {
                    uc();
                }
                break;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(float[] fArr) {
        this.nt = System.currentTimeMillis();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(an.aI, x());
            if (Build.VERSION.SDK_INT >= 19) {
                jSONObject.put("val", new JSONArray(fArr));
            }
            hw.pr().pr(jSONObject, "sp_angle");
            hw.pr().pr(((g) uc.pr("device_info_new")).pr(60000L));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private synchronized void uc() {
        if (!this.hw && this.hn.size() > 0 && this.uc.size() > 0) {
            this.hw = true;
            c();
            ((qi) uc.pr("thread_service")).pr(new Runnable() { // from class: com.byazt.wqv.x.1
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        float[] fArrPr = hn.pr(x.this.hn, x.this.x, x.this.c, x.this.uc, x.this.fw, x.this.zo);
                        x.this.pr(fArrPr);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        long jUc = c.pr().uc();
                        long jFw = c.pr().fw();
                        int iHn = (int) (((c.pr().hn() / 1000) / 60) / 60);
                        if (iHn <= 0) {
                            iHn = 1;
                        }
                        jSONObject.put("azimuth_unit", jUc);
                        jSONObject.put("angle_unit", jFw);
                        LinkedList<JSONObject> linkedListPr = hw.pr().pr(0L);
                        jSONObject.put("active", Arrays.toString(hn.pr(linkedListPr, iHn)));
                        com.byazt.wqv.pr.pr().pr(iHn);
                        jSONObject.put("screen", Arrays.toString(com.byazt.wqv.pr.pr().hn()));
                        jSONObject.put("network", Arrays.toString(com.byazt.wqv.pr.pr().hw()));
                        jSONObject.put("support_net", com.byazt.wqv.pr.pr().x());
                        jSONObject.put("sim_status", com.byazt.wqv.pr.pr().c());
                        int[][] iArrPr = hn.pr(linkedListPr, jUc, jFw);
                        jSONObject.put("ax", Arrays.toString(iArrPr[0]));
                        jSONObject.put("ay", Arrays.toString(iArrPr[1]));
                        jSONObject.put("az", Arrays.toString(iArrPr[2]));
                        int[][] iArrPr2 = hn.pr(hw.pr().pr(10800000L), jUc, jFw);
                        jSONObject.put("ax3", Arrays.toString(iArrPr2[0]));
                        jSONObject.put("ay3", Arrays.toString(iArrPr2[1]));
                        jSONObject.put("az3", Arrays.toString(iArrPr2[2]));
                        int[][] iArrPr3 = hn.pr(hw.pr().pr(21600000L), jUc, jFw);
                        jSONObject.put("ax6", Arrays.toString(iArrPr3[0]));
                        jSONObject.put("ay6", Arrays.toString(iArrPr3[1]));
                        jSONObject.put("az6", Arrays.toString(iArrPr3[2]));
                        jSONObject.put("angleAvg", Arrays.toString(fArrPr));
                        jSONObject.put("timestamp", jCurrentTimeMillis);
                    } catch (Exception e) {
                        jSONObject = null;
                    }
                    if (x.this.qa != null) {
                        x.this.qa.pr(jSONObject);
                    }
                    x.this.fw();
                    x.this.yb = false;
                }
            });
        } else {
            if (this.lb.get() > 3) {
                c();
                fw();
                this.yb = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fw() {
        this.hn.clear();
        this.x.clear();
        this.c.clear();
        this.uc.clear();
        this.fw.clear();
        this.zo.clear();
    }

    public boolean hn() {
        return this.yb;
    }

    public long x() {
        return this.nt;
    }
}
