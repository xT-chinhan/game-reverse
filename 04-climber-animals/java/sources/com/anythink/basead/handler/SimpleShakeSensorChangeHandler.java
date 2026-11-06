package com.anythink.basead.handler;

import android.hardware.SensorEvent;

/* JADX INFO: loaded from: classes.dex */
public class SimpleShakeSensorChangeHandler extends BaseShakeSensorChangeHandlerImp {
    ATShackSensorListener d;
    public float lastX = 0.0f;
    public float lastY = 0.0f;
    public float lastZ = 0.0f;
    public long lastCallBackTimeMs = 0;
    private int e = 10;
    private long f = 5000;

    @Override // com.anythink.basead.handler.IShackSensorChangeHandler
    public void initSetting(ShakeSensorSetting shakeSensorSetting) {
        if (shakeSensorSetting != null) {
            this.e = shakeSensorSetting.getShakeStrength();
            this.f = shakeSensorSetting.getShakeTimeMs();
        }
    }

    @Override // com.anythink.basead.handler.IShackSensorChangeHandler
    public void setListener(ATShackSensorListener aTShackSensorListener) {
        this.d = aTShackSensorListener;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0075  */
    /* JADX WARN: Code duplicated, block: B:22:0x0083  */
    /* JADX WARN: Code duplicated, block: B:24:0x008e  */
    @Override // com.anythink.basead.handler.IShackSensorChangeHandler
    public boolean handleSensorData(SensorEvent sensorEvent) {
        long jCurrentTimeMillis;
        if (this.d != null && sensorEvent.values != null && sensorEvent.values.length >= 3) {
            float[] fArr = sensorEvent.values;
            float f = -fArr[0];
            float f2 = -fArr[1];
            float f3 = -fArr[2];
            a(sensorEvent);
            String.format("handleSensorData lastx:%d,lasty:%d,lastz:%d", Integer.valueOf((int) f), Integer.valueOf((int) f2), Integer.valueOf((int) f3));
            float f4 = this.lastX;
            if (f4 == 0.0f || Math.abs(f - f4) <= this.e) {
                float f5 = this.lastY;
                if (f5 == 0.0f || Math.abs(f2 - f5) <= this.e) {
                    float f6 = this.lastZ;
                    if (f6 != 0.0f && Math.abs(f3 - f6) > this.e) {
                        jCurrentTimeMillis = System.currentTimeMillis();
                        if (jCurrentTimeMillis - this.lastCallBackTimeMs > this.f) {
                            b();
                            if (this.d.onShakeTrigger()) {
                                this.lastCallBackTimeMs = jCurrentTimeMillis;
                                a();
                                return true;
                            }
                        }
                    }
                } else {
                    jCurrentTimeMillis = System.currentTimeMillis();
                    if (jCurrentTimeMillis - this.lastCallBackTimeMs > this.f) {
                        b();
                        if (this.d.onShakeTrigger()) {
                            this.lastCallBackTimeMs = jCurrentTimeMillis;
                            a();
                            return true;
                        }
                    }
                }
            } else {
                jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - this.lastCallBackTimeMs > this.f) {
                    b();
                    if (this.d.onShakeTrigger()) {
                        this.lastCallBackTimeMs = jCurrentTimeMillis;
                        a();
                        return true;
                    }
                }
            }
            this.lastX = f;
            this.lastY = f2;
            this.lastZ = f3;
        }
        return false;
    }

    @Override // com.anythink.basead.handler.BaseShakeSensorChangeHandlerImp
    protected final void a() {
        super.a();
        this.lastX = 0.0f;
        this.lastY = 0.0f;
        this.lastZ = 0.0f;
    }
}
