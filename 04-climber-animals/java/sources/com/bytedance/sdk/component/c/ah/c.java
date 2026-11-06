package com.bytedance.sdk.component.c.ah;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.sdk.component.c.h;
import com.bytedance.sdk.component.c.nw;
import com.bytedance.sdk.component.c.qv;
import com.bytedance.sdk.component.c.sl;
import com.bytedance.sdk.component.c.y;
import com.bytedance.sdk.component.c.zb;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    private sl ab;
    private com.bytedance.sdk.component.c.d c;
    private h ny;
    private ExecutorService x;
    private final zb xr;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Map<String, List<ah>> f1161ms = new ConcurrentHashMap();
    private Map<String, qv> ah = new HashMap();
    private Map<String, y> d = new HashMap();
    private Map<String, com.bytedance.sdk.component.c.ah> ka = new HashMap();

    public c(Context context, zb zbVar) {
        this.xr = (zb) x.ms(zbVar);
        com.bytedance.sdk.component.c.ah.ms.ms.ms(context, zbVar.ny());
    }

    public Collection<qv> ms() {
        return this.ah.values();
    }

    public Collection<y> xr() {
        return this.d.values();
    }

    public Collection<com.bytedance.sdk.component.c.ah> ah() {
        return this.ka.values();
    }

    public qv ms(com.bytedance.sdk.component.c.xr xrVar) {
        if (xrVar == null) {
            xrVar = com.bytedance.sdk.component.c.ah.ms.ms.ny();
        }
        String string = xrVar.ka().toString();
        qv qvVar = this.ah.get(string);
        if (qvVar != null) {
            return qvVar;
        }
        qv qvVarD = d(xrVar);
        this.ah.put(string, qvVarD);
        return qvVarD;
    }

    private qv d(com.bytedance.sdk.component.c.xr xrVar) {
        qv qvVarKa = this.xr.ka();
        if (qvVarKa != null) {
            return com.bytedance.sdk.component.c.ah.ms.xr.ms.ms(qvVarKa);
        }
        return com.bytedance.sdk.component.c.ah.ms.xr.ms.ms(xrVar.xr());
    }

    public y xr(com.bytedance.sdk.component.c.xr xrVar) {
        if (xrVar == null) {
            xrVar = com.bytedance.sdk.component.c.ah.ms.ms.ny();
        }
        String string = xrVar.ka().toString();
        y yVar = this.d.get(string);
        if (yVar != null) {
            return yVar;
        }
        y yVarKa = ka(xrVar);
        this.d.put(string, yVarKa);
        return yVarKa;
    }

    private y ka(com.bytedance.sdk.component.c.xr xrVar) {
        y yVarC = this.xr.c();
        return yVarC != null ? yVarC : com.bytedance.sdk.component.c.ah.ms.xr.ka.ms(xrVar.x());
    }

    public com.bytedance.sdk.component.c.ah ah(com.bytedance.sdk.component.c.xr xrVar) {
        if (xrVar == null) {
            xrVar = com.bytedance.sdk.component.c.ah.ms.ms.ny();
        }
        String string = xrVar.ka().toString();
        com.bytedance.sdk.component.c.ah ahVar = this.ka.get(string);
        if (ahVar != null) {
            return ahVar;
        }
        com.bytedance.sdk.component.c.ah ahVarC = c(xrVar);
        this.ka.put(string, ahVarC);
        return ahVarC;
    }

    public com.bytedance.sdk.component.c.ah ms(String str) {
        return ah(com.bytedance.sdk.component.c.ah.ms.ms.ms(new File(str)));
    }

    private com.bytedance.sdk.component.c.ah c(com.bytedance.sdk.component.c.xr xrVar) {
        com.bytedance.sdk.component.c.ah ahVarAb = this.xr.ab();
        return ahVarAb != null ? ahVarAb : new com.bytedance.sdk.component.c.ah.ms.ms.xr(xrVar.ka(), xrVar.ms(), c());
    }

    public com.bytedance.sdk.component.c.d d() {
        if (this.c == null) {
            this.c = ny();
        }
        return this.c;
    }

    private com.bytedance.sdk.component.c.d ny() {
        com.bytedance.sdk.component.c.d dVarD = this.xr.d();
        return dVarD == null ? com.bytedance.sdk.component.c.xr.xr.ms() : dVarD;
    }

    public sl ka() {
        if (this.ab == null) {
            this.ab = ch();
        }
        return this.ab;
    }

    private sl ch() {
        sl slVarMs = this.xr.ms();
        return slVarMs != null ? slVarMs : com.bytedance.sdk.component.c.ms.xr.ms();
    }

    public ExecutorService c() {
        ExecutorService executorServiceMs;
        nw nwVarAh = this.xr.ah();
        if (nwVarAh != null && (executorServiceMs = nwVarAh.ms()) != null) {
            return executorServiceMs;
        }
        if (this.x == null) {
            this.x = hi();
        }
        return this.x;
    }

    private ExecutorService hi() {
        ExecutorService executorServiceXr = this.xr.xr();
        return executorServiceXr != null ? executorServiceXr : com.bytedance.sdk.component.c.ms.ah.ms();
    }

    public Map<String, List<ah>> ab() {
        return this.f1161ms;
    }

    public com.bytedance.sdk.component.c.ah.xr.ms ms(ah ahVar) {
        ImageView.ScaleType scaleTypeKa = ahVar.ka();
        if (scaleTypeKa == null) {
            scaleTypeKa = com.bytedance.sdk.component.c.ah.xr.ms.f1184ms;
        }
        ImageView.ScaleType scaleType = scaleTypeKa;
        Bitmap.Config configSl = ahVar.sl();
        if (configSl == null) {
            configSl = com.bytedance.sdk.component.c.ah.xr.ms.xr;
        }
        return new com.bytedance.sdk.component.c.ah.xr.ms(ahVar.ah(), ahVar.d(), scaleType, configSl, ahVar.ny(), ahVar.ch());
    }

    public h x() {
        if (this.ny == null) {
            this.ny = sl();
        }
        return this.ny;
    }

    private h sl() {
        h hVarX = this.xr.x();
        return hVarX == null ? new ab() : hVarX;
    }
}
