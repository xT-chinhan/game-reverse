package com.anythink.basead.d;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.anythink.basead.handler.ATShackSensorListener;
import com.anythink.basead.handler.DuplicateShakeSensorChangeHandler;
import com.anythink.basead.handler.IShackSensorChangeHandler;
import com.anythink.basead.handler.ShakeSensorSetting;
import com.anythink.basead.handler.SimpleShakeSensorChangeHandler;
import com.anythink.core.common.h.y;

/* JADX INFO: loaded from: classes.dex */
public abstract class i implements SensorEventListener {
    final String a = "ShakeEventListenerImpl";
    IShackSensorChangeHandler b;

    public abstract boolean a();

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void a(y yVar) {
        ShakeSensorSetting shakeSensorSetting = new ShakeSensorSetting(yVar);
        if (shakeSensorSetting.getShakeWay() == 1 && shakeSensorSetting.getShakeStrengthList() != null && shakeSensorSetting.getShakeStrengthList().size() > 0) {
            this.b = new DuplicateShakeSensorChangeHandler();
        } else {
            this.b = new SimpleShakeSensorChangeHandler();
        }
        shakeSensorSetting.toString();
        this.b.getClass().getSimpleName();
        this.b.initSetting(new ShakeSensorSetting(yVar));
        this.b.setListener(new ATShackSensorListener() { // from class: com.anythink.basead.d.i.1
            @Override // com.anythink.basead.handler.ATShackSensorListener
            public final boolean onShakeTrigger() {
                return i.this.a();
            }
        });
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        IShackSensorChangeHandler iShackSensorChangeHandler = this.b;
        if (iShackSensorChangeHandler != null) {
            iShackSensorChangeHandler.handleSensorData(sensorEvent);
        }
    }
}
