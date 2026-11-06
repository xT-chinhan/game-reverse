package com.anythink.core.common.inner.b;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.anythink.core.common.h.y;
import com.anythink.core.common.inner.c.e;
import com.anythink.core.common.inner.c.f;

/* JADX INFO: loaded from: classes.dex */
public abstract class c implements SensorEventListener {
    final String a = "ShakeEventListenerImpl";
    com.anythink.core.common.inner.c.d b;

    public abstract boolean a();

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    private void a(y yVar) {
        e eVar = new e(yVar);
        if (eVar.a() == 1 && eVar.c() != null && eVar.c().size() > 0) {
            this.b = new com.anythink.core.common.inner.c.c();
        } else {
            this.b = new f();
        }
        this.b.a(new e(yVar));
        this.b.a(new com.anythink.core.common.inner.c.a() { // from class: com.anythink.core.common.inner.b.c.1
            @Override // com.anythink.core.common.inner.c.a
            public final boolean a() {
                return c.this.a();
            }
        });
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        com.anythink.core.common.inner.c.d dVar = this.b;
        if (dVar != null) {
            dVar.b(sensorEvent);
        }
    }
}
