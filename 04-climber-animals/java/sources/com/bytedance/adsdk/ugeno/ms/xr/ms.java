package com.bytedance.adsdk.ugeno.ms.xr;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms {
    protected com.bytedance.adsdk.ugeno.xr.ah ab;
    protected Map<Float, String> ah;
    protected com.bytedance.adsdk.ugeno.ms.d d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected Context f387ms;
    protected String xr;
    protected List<PropertyValuesHolder> c = new ArrayList();
    protected List<Keyframe> ka = new ArrayList();

    public abstract TypeEvaluator c();

    public abstract void ms(float f, String str);

    public abstract void xr();

    public ms(Context context, com.bytedance.adsdk.ugeno.xr.ah ahVar, String str, Map<Float, String> map) {
        this.f387ms = context;
        this.xr = str;
        this.ah = map;
        this.d = com.bytedance.adsdk.ugeno.ms.d.ms(this.xr);
        this.ab = ahVar;
    }

    public String getType() {
        return this.d.ah();
    }

    public boolean ms() {
        Map<Float, String> map = this.ah;
        if (map == null || map.size() <= 0) {
            return false;
        }
        return this.ah.containsKey(Float.valueOf(0.0f));
    }

    public void ah() {
        Map<Float, String> map = this.ah;
        if (map == null || map.size() <= 0) {
            return;
        }
        Map<Float, String> map2 = this.ah;
        if (map2 instanceof TreeMap) {
            float fFloatValue = ((Float) ((TreeMap) map2).lastKey()).floatValue();
            if (fFloatValue != 100.0f) {
                ms(100.0f, this.ah.get(Float.valueOf(fFloatValue)));
            }
        }
    }

    public void d() {
        Map<Float, String> map = this.ah;
        if (map == null || map.size() <= 0) {
            return;
        }
        if (!ms()) {
            xr();
        }
        for (Map.Entry<Float, String> entry : this.ah.entrySet()) {
            if (entry != null) {
                ms(entry.getKey().floatValue() / 100.0f, entry.getValue());
            }
        }
        ah();
    }

    public List<PropertyValuesHolder> ka() {
        String strXr = this.d.xr();
        d();
        PropertyValuesHolder propertyValuesHolderOfKeyframe = PropertyValuesHolder.ofKeyframe(strXr, (Keyframe[]) this.ka.toArray(new Keyframe[0]));
        TypeEvaluator typeEvaluatorC = c();
        if (typeEvaluatorC != null) {
            propertyValuesHolderOfKeyframe.setEvaluator(typeEvaluatorC);
        }
        this.c.add(propertyValuesHolderOfKeyframe);
        return this.c;
    }
}
