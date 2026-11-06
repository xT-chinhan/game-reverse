package com.anythink.basead.handler;

import android.hardware.SensorEvent;
import com.anythink.core.common.d.t;
import com.anythink.core.common.u.e;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DuplicateShakeSensorChangeHandler extends BaseShakeSensorChangeHandlerImp {
    List<Double> d;
    long e;
    ATShackSensorListener m;
    float n;
    float o;
    float p;
    public long lastCallBackTimeMs = 0;
    private long s = 0;
    String q = "";
    List<Double> j = new ArrayList();
    List<Double> k = new ArrayList();
    List<Double> l = new ArrayList();
    long f = 0;
    int g = 0;
    int h = 0;
    int i = 0;
    boolean r = false;

    @Override // com.anythink.basead.handler.IShackSensorChangeHandler
    public void initSetting(ShakeSensorSetting shakeSensorSetting) {
        if (shakeSensorSetting != null) {
            this.s = shakeSensorSetting.getShakeTimeMs();
            this.d = shakeSensorSetting.getShakeStrengthList();
            this.e = shakeSensorSetting.getShakeDetectDurationTime();
            this.q = shakeSensorSetting.toString();
        }
    }

    @Override // com.anythink.basead.handler.IShackSensorChangeHandler
    public void setListener(ATShackSensorListener aTShackSensorListener) {
        this.m = aTShackSensorListener;
    }

    @Override // com.anythink.basead.handler.IShackSensorChangeHandler
    public boolean handleSensorData(SensorEvent sensorEvent) {
        if (this.m != null && sensorEvent.values != null && sensorEvent.values.length >= 3) {
            try {
                float[] fArr = sensorEvent.values;
                float f = this.n;
                if (f == 0.0f) {
                    this.n = -fArr[0];
                    this.o = -fArr[1];
                    this.p = -fArr[2];
                    return false;
                }
                float f2 = (-fArr[0]) - f;
                float f3 = (-fArr[1]) - this.o;
                float f4 = (-fArr[2]) - this.p;
                a(sensorEvent);
                if (this.f == 0) {
                    this.f = a(f2, f3, f4);
                } else if (System.currentTimeMillis() - this.f > this.e) {
                    c();
                } else {
                    if (this.g > 0 && this.j.size() > 0) {
                        if (this.g >= this.j.size()) {
                            c();
                            return d();
                        }
                        double dDoubleValue = this.j.get(this.g).doubleValue();
                        if (((double) f2) * dDoubleValue > 0.0d && Math.abs(f2) > Math.abs(dDoubleValue)) {
                            this.g++;
                        }
                    }
                    if (this.h > 0 && this.k.size() > 0) {
                        if (this.h >= this.k.size()) {
                            c();
                            return d();
                        }
                        double dDoubleValue2 = this.k.get(this.h).doubleValue();
                        if (((double) f3) * dDoubleValue2 > 0.0d && Math.abs(f3) > Math.abs(dDoubleValue2)) {
                            this.h++;
                        }
                    }
                    if (this.i > 0 && this.l.size() > 0) {
                        if (this.i >= this.l.size()) {
                            c();
                            return d();
                        }
                        double dDoubleValue3 = this.l.get(this.i).doubleValue();
                        if (((double) f4) * dDoubleValue3 > 0.0d && Math.abs(f4) > Math.abs(dDoubleValue3)) {
                            this.i++;
                        }
                    }
                    a(f2, f3, f4);
                }
            } catch (Throwable th) {
                if (!this.r) {
                    e.b("ShakeHandler", "Throwable:" + th.getMessage() + ",params:" + this.q, t.b().r());
                    this.r = true;
                }
            }
        }
        return false;
    }

    private void c() {
        this.f = 0L;
        this.g = 0;
        this.j.clear();
        this.h = 0;
        this.k.clear();
        this.i = 0;
        this.l.clear();
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0025  */
    private long a(float f, float f2, float f3) {
        long jCurrentTimeMillis;
        double dA = a(0);
        if (this.g != 0 || Math.abs(f) < dA) {
            jCurrentTimeMillis = 0;
        } else {
            a(0, f);
            this.g = 1;
            if (this.f == 0) {
                jCurrentTimeMillis = System.currentTimeMillis();
            } else {
                jCurrentTimeMillis = 0;
            }
        }
        if (this.h == 0 && Math.abs(f2) >= dA) {
            a(1, f2);
            this.h = 1;
            if (this.f == 0) {
                jCurrentTimeMillis = System.currentTimeMillis();
            }
        }
        if (this.i != 0 || Math.abs(f3) < dA) {
            return jCurrentTimeMillis;
        }
        a(2, f3);
        this.i = 1;
        return this.f == 0 ? System.currentTimeMillis() : jCurrentTimeMillis;
    }

    private boolean d() {
        if (this.m == null) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.lastCallBackTimeMs <= this.s) {
            return false;
        }
        b();
        if (!this.m.onShakeTrigger()) {
            return false;
        }
        this.lastCallBackTimeMs = jCurrentTimeMillis;
        a();
        return true;
    }

    private void a(int i, float f) {
        List<Double> list;
        if (i == 1) {
            list = this.k;
        } else if (i == 2) {
            list = this.l;
        } else {
            list = this.j;
        }
        list.clear();
        for (int i2 = 0; i2 < this.d.size() - 1; i2++) {
            double dA = a(i2);
            if (f < 0.0f) {
                list.add(Double.valueOf((-1.0d) * dA));
                list.add(Double.valueOf(dA * 1.0d));
            } else {
                list.add(Double.valueOf(1.0d * dA));
                list.add(Double.valueOf(dA * (-1.0d)));
            }
        }
        double dA2 = a(this.d.size() - 1);
        if (f < 0.0f) {
            list.add(Double.valueOf(dA2 * (-1.0d)));
        } else {
            list.add(Double.valueOf(dA2 * 1.0d));
        }
    }

    private double a(int i) {
        List<Double> list = this.d;
        if (list == null || list.size() <= i) {
            return Double.MAX_VALUE;
        }
        return this.d.get(i).doubleValue();
    }

    @Override // com.anythink.basead.handler.BaseShakeSensorChangeHandlerImp
    protected final void a() {
        super.a();
        c();
    }
}
