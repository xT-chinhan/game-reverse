package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class nw implements SensorEventListener {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile nw f1362ms;
    private volatile Sensor ah;
    private volatile Sensor c;
    private volatile Sensor d;
    private volatile Sensor ka;
    private final SensorManager xr;
    private final AtomicBoolean ab = new AtomicBoolean(false);
    private final AtomicBoolean x = new AtomicBoolean(false);
    private final AtomicBoolean ny = new AtomicBoolean(false);
    private final AtomicBoolean ch = new AtomicBoolean(false);
    private final Map<SensorEventListener, Object> hi = new ConcurrentHashMap();

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    private nw(Context context) {
        this.xr = (SensorManager) context.getSystemService("sensor");
    }

    public static nw ms(Context context) {
        if (f1362ms == null) {
            synchronized (nw.class) {
                if (f1362ms == null) {
                    f1362ms = new nw(context);
                }
            }
        }
        return f1362ms;
    }

    private Sensor xr() {
        if (this.ah == null) {
            synchronized (nw.class) {
                if (this.ah == null) {
                    this.ah = this.xr.getDefaultSensor(1);
                }
            }
        }
        return this.ah;
    }

    private Sensor ah() {
        if (this.d == null) {
            synchronized (nw.class) {
                if (this.d == null) {
                    this.d = this.xr.getDefaultSensor(15);
                }
            }
        }
        return this.d;
    }

    private Sensor d() {
        if (this.ka == null) {
            synchronized (nw.class) {
                if (this.ka == null) {
                    this.ka = this.xr.getDefaultSensor(4);
                }
            }
        }
        return this.ka;
    }

    private Sensor ka() {
        if (this.c == null) {
            synchronized (nw.class) {
                if (this.c == null) {
                    this.c = this.xr.getDefaultSensor(10);
                }
            }
        }
        return this.c;
    }

    public Sensor ms(int i) {
        if (i == 1) {
            return xr();
        }
        if (i == 4) {
            return d();
        }
        if (i == 10) {
            return ka();
        }
        if (i != 15) {
            return null;
        }
        return ah();
    }

    public boolean ms(SensorEventListener sensorEventListener, Sensor sensor, int i) {
        this.hi.put(sensorEventListener, 0);
        if (sensor == this.ah) {
            if (!this.ab.getAndSet(true)) {
                return this.xr.registerListener(this, sensor, i);
            }
        } else if (sensor == this.d) {
            if (!this.x.getAndSet(true)) {
                return this.xr.registerListener(this, sensor, i);
            }
        } else if (sensor == this.ka) {
            if (!this.ny.getAndSet(true)) {
                return this.xr.registerListener(this, sensor, i);
            }
        } else if (sensor == this.c && !this.ch.getAndSet(true)) {
            return this.xr.registerListener(this, sensor, i);
        }
        return true;
    }

    public void ms(SensorEventListener sensorEventListener) {
        this.hi.remove(sensorEventListener);
        sl.ms("TMe", "--==---- unreg shake size: " + this.hi.size());
        if (this.hi.isEmpty()) {
            try {
                this.xr.unregisterListener(this);
            } catch (Throwable th) {
                sl.ms(th);
            }
            this.ab.set(false);
            this.x.set(false);
            this.ny.set(false);
            this.ch.set(false);
        }
    }

    public int ms() {
        return this.hi.size();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        SensorEventListener key;
        for (Map.Entry<SensorEventListener, Object> entry : this.hi.entrySet()) {
            if (entry != null && (key = entry.getKey()) != null) {
                key.onSensorChanged(sensorEvent);
            }
        }
    }
}
