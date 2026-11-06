package com.smartdigimkt.h0;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.view.View;
import com.smartdigimkt.b2.w;
import com.smartdigimkt.b2.x;
import com.smartdigimkt.b2.y;
import com.smartdigimkt.n1.x4;
import com.smartdigimkt.n1.y4;
import com.smartdigimkt.sdk.basead.ui.ShakeNativeBorderThumbView;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d implements SensorEventListener {
    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        com.smartdigimkt.d1.d dVar;
        w wVar = (w) this;
        synchronized (wVar.a.b) {
            y yVar = wVar.a;
            if (yVar.d) {
                ArrayList<x> arrayList = new ArrayList();
                for (y4 y4Var : yVar.c) {
                    arrayList.add(new x(y4Var.a(), y4Var));
                }
                Collections.sort(arrayList);
                for (x xVar : arrayList) {
                    if (!xVar.b.a.s || !y.a(wVar.a, sensorEvent)) {
                        x4 x4Var = xVar.b.a.t;
                        if (x4Var.a.getParent() == null) {
                            String str = x4Var.a.p;
                        } else {
                            ShakeNativeBorderThumbView shakeNativeBorderThumbView = x4Var.a;
                            if (shakeNativeBorderThumbView.r.a((View) shakeNativeBorderThumbView.getParent(), x4Var.a, 80, 0) && (dVar = x4Var.a.q) != null && dVar.a(sensorEvent)) {
                                String str2 = wVar.a.a;
                                xVar.b.getClass();
                                wVar.a.d = false;
                                return;
                            }
                        }
                    }
                }
            }
        }
    }
}
