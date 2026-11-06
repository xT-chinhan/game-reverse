package com.byazt.tk;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 350, 5})
public final class q implements tj {
    public static volatile q n;
    public volatile Sensor l;
    public volatile Sensor q;
    public final SensorManager qg;
    public volatile Sensor s;
    public volatile Sensor w;
    public final ConcurrentHashMap<Sensor, CopyOnWriteArraySet<SensorEventListener>> x = new ConcurrentHashMap<>();
    public final SensorEventListener fs = new SensorEventListener() { // from class: com.byazt.tk.q.1
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            CopyOnWriteArraySet<SensorEventListener> copyOnWriteArraySet;
            if (sensorEvent == null || sensorEvent.sensor == null || (copyOnWriteArraySet = (CopyOnWriteArraySet) q.this.x.get(sensorEvent.sensor)) == null) {
                return;
            }
            for (SensorEventListener sensorEventListener : copyOnWriteArraySet) {
                if (sensorEventListener != null) {
                    sensorEventListener.onSensorChanged(sensorEvent);
                }
            }
        }
    };

    private q(Context context) {
        this.qg = context != null ? (SensorManager) context.getSystemService("sensor") : null;
    }

    public static q n(Context context) {
        if (n == null || (n.qg == null && context != null)) {
            synchronized (q.class) {
                if (n == null || (n.qg == null && context != null)) {
                    n = new q(context);
                }
            }
        }
        return n;
    }

    private Sensor qg() {
        if (this.qg == null) {
            return null;
        }
        if (this.s == null) {
            synchronized (q.class) {
                if (this.s == null) {
                    this.s = this.qg.getDefaultSensor(1);
                }
            }
        }
        return this.s;
    }

    private Sensor s() {
        if (this.qg == null) {
            return null;
        }
        if (this.q == null) {
            synchronized (q.class) {
                if (this.q == null) {
                    this.q = this.qg.getDefaultSensor(15);
                }
            }
        }
        return this.q;
    }

    private Sensor q() {
        if (this.qg == null) {
            return null;
        }
        if (this.l == null) {
            synchronized (q.class) {
                if (this.l == null) {
                    this.l = this.qg.getDefaultSensor(4);
                }
            }
        }
        return this.l;
    }

    private Sensor l() {
        if (this.qg == null) {
            return null;
        }
        if (this.w == null) {
            synchronized (q.class) {
                if (this.w == null) {
                    this.w = this.qg.getDefaultSensor(10);
                }
            }
        }
        return this.w;
    }

    @Override // com.byazt.tk.tj
    public Sensor n(int i) {
        if (i == 1) {
            return qg();
        }
        if (i == 4) {
            return q();
        }
        if (i == 10) {
            return l();
        }
        if (i != 15) {
            return null;
        }
        return s();
    }

    @Override // com.byazt.tk.tj
    public boolean n(SensorEventListener sensorEventListener, Sensor sensor, int i) {
        boolean zRegisterListener;
        if (sensorEventListener == null || sensor == null || this.qg == null) {
            return false;
        }
        CopyOnWriteArraySet<SensorEventListener> copyOnWriteArraySet = this.x.get(sensor);
        if (copyOnWriteArraySet == null || copyOnWriteArraySet.isEmpty()) {
            zRegisterListener = this.qg.registerListener(this.fs, sensor, i);
            sensor.getName();
            sensorEventListener.hashCode();
        } else {
            zRegisterListener = true;
        }
        if (zRegisterListener) {
            if (copyOnWriteArraySet == null) {
                copyOnWriteArraySet = new CopyOnWriteArraySet<>();
                this.x.put(sensor, copyOnWriteArraySet);
            }
            copyOnWriteArraySet.add(sensorEventListener);
            sensor.getName();
            sensorEventListener.hashCode();
        }
        return zRegisterListener;
    }

    @Override // com.byazt.tk.tj
    public void n(SensorEventListener sensorEventListener) {
        if (sensorEventListener == null || this.qg == null) {
            return;
        }
        for (Map.Entry<Sensor, CopyOnWriteArraySet<SensorEventListener>> entry : this.x.entrySet()) {
            if (entry != null) {
                Sensor key = entry.getKey();
                CopyOnWriteArraySet<SensorEventListener> value = entry.getValue();
                if (value != null && value.contains(sensorEventListener)) {
                    value.remove(sensorEventListener);
                    if (key != null) {
                        key.getName();
                    }
                    sensorEventListener.hashCode();
                    if (value.isEmpty() && key != null) {
                        try {
                            this.qg.unregisterListener(this.fs, key);
                        } catch (Throwable unused) {
                        }
                        key.getName();
                    }
                }
            }
        }
        n();
    }

    public int n() {
        CopyOnWriteArraySet<SensorEventListener> value;
        int size = 0;
        for (Map.Entry<Sensor, CopyOnWriteArraySet<SensorEventListener>> entry : this.x.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                size += value.size();
            }
        }
        return size;
    }
}
