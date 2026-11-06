package com.bytedance.adsdk.ugeno.ms;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    private ValueAnimator ah;
    private com.bytedance.adsdk.ugeno.ms.ms.ms c;
    private Context d;
    private int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private com.bytedance.adsdk.ugeno.xr.ah f381ms;
    private xr xr;

    public ms(Context context, com.bytedance.adsdk.ugeno.xr.ah ahVar, xr xrVar) {
        this.f381ms = ahVar;
        this.xr = xrVar;
        this.d = context;
    }

    public void ms() {
        ValueAnimator valueAnimator = this.ah;
        if (valueAnimator == null || this.ka == -2) {
            return;
        }
        valueAnimator.start();
    }

    public void xr() {
        ValueAnimator valueAnimator = this.ah;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public ValueAnimator ah() {
        com.bytedance.adsdk.ugeno.ms.xr.ms ahVar;
        xr xrVar = this.xr;
        if (xrVar == null || this.f381ms == null) {
            return null;
        }
        Map<String, TreeMap<Float, String>> mapXr = xrVar.xr();
        ArrayList arrayList = new ArrayList();
        if (mapXr != null && !mapXr.isEmpty()) {
            for (Map.Entry<String, TreeMap<Float, String>> entry : mapXr.entrySet()) {
                if (entry != null) {
                    String key = entry.getKey();
                    String strAh = d.ms(key).ah();
                    strAh.hashCode();
                    switch (strAh) {
                        case "int":
                            ahVar = new com.bytedance.adsdk.ugeno.ms.xr.ah(this.d, this.f381ms, key, entry.getValue());
                            break;
                        case "float":
                            ahVar = new com.bytedance.adsdk.ugeno.ms.xr.xr(this.d, this.f381ms, key, entry.getValue());
                            break;
                        case "point":
                            ahVar = new com.bytedance.adsdk.ugeno.ms.xr.d(this.d, this.f381ms, key, entry.getValue());
                            break;
                        default:
                            ahVar = null;
                            break;
                    }
                    if (ahVar != null) {
                        arrayList.addAll(ahVar.ka());
                    }
                }
            }
        }
        JSONObject jSONObjectMs = this.xr.ms();
        if (jSONObjectMs != null) {
            com.bytedance.adsdk.ugeno.ms.ms.ms msVarMs = com.bytedance.adsdk.ugeno.ms.ms.ms.C0197ms.ms(this.f381ms, jSONObjectMs);
            this.c = msVarMs;
            if (msVarMs != null) {
                arrayList.addAll(msVarMs.ah());
            }
        }
        final View viewNy = this.f381ms.ny();
        if (viewNy == null) {
            return null;
        }
        final xr.ms msVarAb = this.xr.ab();
        if (msVarAb != null) {
            viewNy.post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.ms.ms.1
                @Override // java.lang.Runnable
                public void run() {
                    int width = viewNy.getWidth();
                    int height = viewNy.getHeight();
                    viewNy.setPivotX(ah.ms(msVarAb.f385ms, width));
                    viewNy.setPivotY(ah.ms(msVarAb.xr, height));
                }
            });
        }
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(viewNy, (PropertyValuesHolder[]) arrayList.toArray(new PropertyValuesHolder[0]));
        this.ka = ah.ms(this.xr.d());
        objectAnimatorOfPropertyValuesHolder.setDuration(this.xr.ah());
        int i = this.ka;
        if (i != -2) {
            objectAnimatorOfPropertyValuesHolder.setRepeatCount(i);
        }
        objectAnimatorOfPropertyValuesHolder.setStartDelay(this.xr.c());
        objectAnimatorOfPropertyValuesHolder.setRepeatMode(ah.ms(this.xr.ka()));
        objectAnimatorOfPropertyValuesHolder.setInterpolator(ah.xr(this.xr.x()));
        this.ah = objectAnimatorOfPropertyValuesHolder;
        return objectAnimatorOfPropertyValuesHolder;
    }

    public void ms(Canvas canvas) {
        com.bytedance.adsdk.ugeno.ms.ms.ms msVar = this.c;
        if (msVar != null) {
            msVar.ms(canvas);
        }
    }

    public void ms(int i, int i2) {
        com.bytedance.adsdk.ugeno.ms.ms.ms msVar = this.c;
        if (msVar != null) {
            msVar.ms(i, i2);
        }
    }
}
