package com.anythink.basead.handler;

import android.hardware.SensorEvent;

/* JADX INFO: loaded from: classes.dex */
public interface IShackSensorChangeHandler {
    boolean handleSensorData(SensorEvent sensorEvent);

    void initSetting(ShakeSensorSetting shakeSensorSetting);

    void setListener(ATShackSensorListener aTShackSensorListener);
}
