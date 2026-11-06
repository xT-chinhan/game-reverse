package com.byazt.ca;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.an;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ANSWER_RECV_TIME, 121})
public final class x implements vk {
    public static volatile x pr = null;
    public volatile Sensor c;
    public volatile Sensor hn;
    public final SensorManager hw;
    public volatile Sensor uc;
    public volatile Sensor x;
    public final ConcurrentHashMap<Sensor, CopyOnWriteArraySet<SensorEventListener>> fw = new ConcurrentHashMap<>();
    public final SensorEventListener zo = new SensorEventListener() { // from class: com.byazt.ca.x.1
        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            CopyOnWriteArraySet<SensorEventListener> copyOnWriteArraySet;
            if (sensorEvent != null && sensorEvent.sensor != null && (copyOnWriteArraySet = (CopyOnWriteArraySet) x.this.fw.get(sensorEvent.sensor)) != null) {
                for (SensorEventListener sensorEventListener : copyOnWriteArraySet) {
                    if (sensorEventListener != null) {
                        sensorEventListener.onSensorChanged(sensorEvent);
                    }
                }
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    };

    private x(Context context) {
        this.hw = context != null ? (SensorManager) context.getSystemService(an.ac) : null;
    }

    public static x pr(Context context) {
        if (pr == null || (pr.hw == null && context != null)) {
            synchronized (x.class) {
                if (pr == null || (pr.hw == null && context != null)) {
                    pr = new x(context);
                }
            }
        }
        return pr;
    }

    private Sensor hw() {
        if (this.hw == null) {
            return null;
        }
        if (this.hn == null) {
            synchronized (x.class) {
                if (this.hn == null) {
                    this.hn = this.hw.getDefaultSensor(1);
                }
            }
        }
        return this.hn;
    }

    private Sensor hn() {
        if (this.hw == null) {
            return null;
        }
        if (this.x == null) {
            synchronized (x.class) {
                if (this.x == null) {
                    this.x = this.hw.getDefaultSensor(15);
                }
            }
        }
        return this.x;
    }

    private Sensor x() {
        if (this.hw == null) {
            return null;
        }
        if (this.c == null) {
            synchronized (x.class) {
                if (this.c == null) {
                    this.c = this.hw.getDefaultSensor(4);
                }
            }
        }
        return this.c;
    }

    private Sensor c() {
        if (this.hw == null) {
            return null;
        }
        if (this.uc == null) {
            synchronized (x.class) {
                if (this.uc == null) {
                    this.uc = this.hw.getDefaultSensor(10);
                }
            }
        }
        return this.uc;
    }

    @Override // com.byazt.ca.vk
    public Sensor pr(int i) {
        switch (i) {
            case 1:
                return hw();
            case 4:
                return x();
            case 10:
                return c();
            case 15:
                return hn();
            default:
                return null;
        }
    }

    @Override // com.byazt.ca.vk
    public boolean pr(SensorEventListener sensorEventListener, Sensor sensor, int i) {
        if (sensorEventListener == null || sensor == null || this.hw == null) {
            return false;
        }
        CopyOnWriteArraySet<SensorEventListener> copyOnWriteArraySet = this.fw.get(sensor);
        boolean zRegisterListener = true;
        if (copyOnWriteArraySet == null || copyOnWriteArraySet.isEmpty()) {
            zRegisterListener = this.hw.registerListener(this.zo, sensor, i);
            sensor.getName();
            sensorEventListener.hashCode();
        }
        if (zRegisterListener) {
            if (copyOnWriteArraySet == null) {
                copyOnWriteArraySet = new CopyOnWriteArraySet<>();
                this.fw.put(sensor, copyOnWriteArraySet);
            }
            copyOnWriteArraySet.add(sensorEventListener);
            sensor.getName();
            sensorEventListener.hashCode();
        }
        return zRegisterListener;
    }

    @Override // com.byazt.ca.vk
    public void pr(SensorEventListener sensorEventListener) {
        if (sensorEventListener == null || this.hw == null) {
            return;
        }
        for (Map.Entry<Sensor, CopyOnWriteArraySet<SensorEventListener>> entry : this.fw.entrySet()) {
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
                            this.hw.unregisterListener(this.zo, key);
                        } catch (Throwable th) {
                        }
                        key.getName();
                    }
                }
            }
        }
        pr();
    }

    public int pr() {
        CopyOnWriteArraySet<SensorEventListener> value;
        int size = 0;
        for (Map.Entry<Sensor, CopyOnWriteArraySet<SensorEventListener>> entry : this.fw.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                size += value.size();
            }
        }
        return size;
    }
}
