package com.mcto.sspsdk.internal;

import android.content.res.Resources;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Vibrator;
import android.util.DisplayMetrics;
import android.view.View;
import com.umeng.analytics.pro.an;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
public final class qh {
    public static volatile qh l;
    public final SensorManager b;
    public final Sensor c;
    public final Sensor d;
    public final LinkedList a = new LinkedList();
    public volatile boolean e = false;
    public boolean f = false;
    public int g = 1000;
    public float h = 12.0f;
    public int i = 1;
    public final ph j = new ph(this);
    public final oh k = new oh();

    public qh() {
        SensorManager sensorManager = (SensorManager) jd.a.getSystemService(an.ac);
        this.b = sensorManager;
        this.c = sensorManager.getDefaultSensor(1);
        this.d = sensorManager.getDefaultSensor(2);
    }

    public static void a(qh qhVar) {
        synchronized (qhVar) {
            DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
            int i = displayMetrics.widthPixels / 2;
            int i2 = displayMetrics.heightPixels / 2;
            td tdVar = null;
            double d = Double.MAX_VALUE;
            Iterator it = qhVar.a.iterator();
            while (it.hasNext()) {
                td tdVar2 = (td) it.next();
                if (tdVar2 == null || ((View) tdVar2.a.get()) == null) {
                    it.remove();
                } else {
                    int[] iArr = new int[2];
                    ((View) tdVar2.a.get()).getLocationOnScreen(iArr);
                    double dHypot = Math.hypot(((((View) tdVar2.a.get()).getWidth() / 2) + iArr[0]) - i, ((((View) tdVar2.a.get()).getHeight() / 2) + iArr[1]) - i2);
                    if (dHypot < d) {
                        tdVar = tdVar2;
                        d = dHypot;
                    }
                }
            }
            if (tdVar != null) {
                try {
                    Vibrator vibrator = (Vibrator) jd.a.getSystemService("vibrator");
                    if (vibrator != null) {
                        vibrator.vibrate(100L);
                    }
                } catch (Exception e) {
                }
                tdVar.a();
            }
            if (qhVar.a.isEmpty() && qhVar.f) {
                qhVar.b.unregisterListener(qhVar.k);
                qhVar.b.unregisterListener(qhVar.j);
                qhVar.k.a();
                qhVar.f = false;
            }
        }
    }

    public final synchronized void b(td tdVar) {
        if (tdVar != null) {
            this.a.remove(tdVar);
            if (this.a.isEmpty() && this.f) {
                this.b.unregisterListener(this.k);
                this.b.unregisterListener(this.j);
                this.k.a();
                this.f = false;
            }
        }
    }

    public static qh a() {
        if (l == null) {
            synchronized (qh.class) {
                if (l == null) {
                    l = new qh();
                }
            }
        }
        return l;
    }

    public final synchronized void a(td tdVar) {
        if (tdVar != null) {
            if (!this.a.contains(tdVar)) {
                this.a.add(tdVar);
                if (!this.f) {
                    this.e = false;
                    this.k.a();
                    this.b.registerListener(this.j, this.c, 3);
                    this.b.registerListener(this.k, this.c, 3);
                    this.b.registerListener(this.k, this.d, 3);
                }
                this.f = true;
            }
        }
    }
}
