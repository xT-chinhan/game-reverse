package com.tapsdk.tapad.internal.animation;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.util.Log;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class h implements c {
    private static String l = "ShakeAnimationController";
    public static final WeakHashMap<h, Boolean> m = new WeakHashMap<>();
    private i a;
    private com.tapsdk.tapad.internal.animation.l.b b;
    private com.tapsdk.tapad.internal.animation.l.a c;
    private final e d;
    private com.tapsdk.tapad.internal.animation.b e;
    private SensorManager f;
    private Sensor g;
    private Sensor h;
    private Sensor i;
    private final g j = new a();
    private final f k = new b();

    class a implements g {
        a() {
        }

        @Override // com.tapsdk.tapad.internal.animation.g
        public void a(int i) {
            if (h.this.e != null) {
                h.this.e.a(i);
            } else if (h.this.d != null) {
                h.this.d.a(i);
            }
            h.this.a();
        }
    }

    class b implements f {
        b() {
        }

        @Override // com.tapsdk.tapad.internal.animation.f
        public void a(int i) {
            if (h.this.d != null) {
                h.this.d.a(i);
            }
        }
    }

    private h(Activity activity, e eVar) {
        this.d = eVar;
        try {
            SensorManager sensorManager = (SensorManager) activity.getSystemService("sensor");
            this.f = sensorManager;
            this.g = sensorManager.getDefaultSensor(4);
            this.h = this.f.getDefaultSensor(1);
            this.i = this.f.getDefaultSensor(11);
        } finally {
            if (this.f == null) {
                eVar.a();
            }
        }
    }

    public static h a(Activity activity, e eVar) {
        h hVar;
        synchronized (h.class) {
            for (h hVar2 : m.keySet()) {
                hVar2.a();
                m.put(hVar2, Boolean.FALSE);
            }
            hVar = new h(activity, eVar);
            m.put(hVar, Boolean.FALSE);
        }
        return hVar;
    }

    private boolean a(i iVar) {
        if (this.f != null && this.g != null && this.h != null) {
            i iVar2 = this.a;
            if (iVar2 != null) {
                if (iVar2 == iVar) {
                    return true;
                }
                d();
            }
            this.a = iVar;
            try {
                this.f.registerListener(iVar, this.g, 3);
                this.f.registerListener(iVar, this.h, 3);
                return true;
            } catch (Exception e) {
                Log.w(l, e.getMessage());
                d();
                e eVar = this.d;
                if (eVar != null) {
                    eVar.a();
                }
            }
        }
        return false;
    }

    private boolean a(com.tapsdk.tapad.internal.animation.l.a aVar) {
        if (this.f != null && this.h != null) {
            com.tapsdk.tapad.internal.animation.l.a aVar2 = this.c;
            if (aVar2 != null) {
                if (aVar2 == aVar) {
                    return true;
                }
                b();
            }
            this.c = aVar;
            try {
                this.f.registerListener(aVar, this.h, 3);
                return true;
            } catch (Exception e) {
                Log.w(l, e.getMessage());
            }
        }
        return false;
    }

    private boolean a(com.tapsdk.tapad.internal.animation.l.b bVar) {
        if (this.f != null && this.i != null) {
            com.tapsdk.tapad.internal.animation.l.b bVar2 = this.b;
            if (bVar2 != null) {
                if (bVar2 == bVar) {
                    return true;
                }
                d();
            }
            this.b = bVar;
            try {
                this.f.registerListener(bVar, this.i, 3);
                return true;
            } catch (Exception e) {
                Log.w(l, e.getMessage());
            }
        }
        return false;
    }

    private void b() {
        com.tapsdk.tapad.internal.animation.l.a aVar = this.c;
        if (aVar != null) {
            this.f.unregisterListener(aVar);
            this.c = null;
        }
    }

    private void c() {
        com.tapsdk.tapad.internal.animation.l.b bVar = this.b;
        if (bVar != null) {
            this.f.unregisterListener(bVar);
            this.b = null;
        }
    }

    private void d() {
        i iVar = this.a;
        if (iVar != null) {
            this.f.unregisterListener(iVar);
            this.a = null;
        }
    }

    @Override // com.tapsdk.tapad.internal.animation.c
    public void a() {
        d();
        c();
        b();
    }

    @Override // com.tapsdk.tapad.internal.animation.c
    public void a(com.tapsdk.tapad.internal.animation.b bVar) {
        this.e = bVar;
        bVar.setListener(this.k);
    }

    @Override // com.tapsdk.tapad.internal.animation.c
    public boolean a(com.tapsdk.tapad.internal.animation.a aVar) {
        if (aVar == null) {
            return false;
        }
        aVar.reset();
        aVar.a(this.j);
        synchronized (this) {
            for (h hVar : m.keySet()) {
                if (hVar != this) {
                    hVar.a();
                    m.put(hVar, Boolean.FALSE);
                }
            }
            m.put(this, Boolean.TRUE);
        }
        if (aVar instanceof i) {
            return a((i) aVar);
        }
        if (aVar instanceof com.tapsdk.tapad.internal.animation.l.b) {
            return a((com.tapsdk.tapad.internal.animation.l.b) aVar);
        }
        if (aVar instanceof com.tapsdk.tapad.internal.animation.l.a) {
            return a((com.tapsdk.tapad.internal.animation.l.a) aVar);
        }
        return false;
    }
}
