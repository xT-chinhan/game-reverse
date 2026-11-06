package com.smartdigimkt.b2;

import android.hardware.SensorEvent;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class y {
    public static volatile y k;
    public float g;
    public float h;
    public float i;
    public final String a = "y";
    public final Object b = new Object();
    public boolean d = true;
    public int e = 0;
    public int f = 0;
    public final w j = new w(this);
    public final ArrayList c = new ArrayList();

    public static boolean a(y yVar, SensorEvent sensorEvent) {
        float[] fArr;
        yVar.getClass();
        if (sensorEvent == null || (fArr = sensorEvent.values) == null || fArr.length < 3) {
            return false;
        }
        float f = -fArr[0];
        float f2 = -fArr[1];
        float f3 = -fArr[2];
        float f4 = yVar.g;
        if (f4 != 0.0f || yVar.h != 0.0f || yVar.i != 0.0f) {
            if (Math.abs(f3 - yVar.i) + Math.abs(f2 - yVar.h) + Math.abs(f - f4) < 0.5f) {
                return true;
            }
        }
        yVar.g = f;
        yVar.h = f2;
        yVar.i = f3;
        return false;
    }

    public static y a() {
        if (k == null) {
            synchronized (y.class) {
                if (k == null) {
                    k = new y();
                }
            }
        }
        return k;
    }
}
