package com.byazt.ahr;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.content.Context;
import com.byazt.iza.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 98, 37})
public abstract class pr {
    public com.byazt.ik.hn fw;
    public Map<Float, String> hn;
    public String hw;
    public Context pr;
    public c x;
    public List<PropertyValuesHolder> uc = new ArrayList();
    public List<Keyframe> c = new ArrayList();

    public abstract void hw();

    public abstract void pr(float f, String str);

    public abstract TypeEvaluator uc();

    public pr(Context context, com.byazt.ik.hn hnVar, String str, Map<Float, String> map) {
        this.pr = context;
        this.hw = str;
        this.hn = map;
        this.x = c.pr(this.hw);
        this.fw = hnVar;
    }

    public String getType() {
        return this.x.hn();
    }

    public boolean pr() {
        Map<Float, String> map = this.hn;
        if (map == null || map.size() <= 0) {
            return false;
        }
        return this.hn.containsKey(Float.valueOf(0.0f));
    }

    public void hn() {
        Map<Float, String> map = this.hn;
        if (map == null || map.size() <= 0) {
            return;
        }
        Map<Float, String> map2 = this.hn;
        if (map2 instanceof TreeMap) {
            float fFloatValue = ((Float) ((TreeMap) map2).lastKey()).floatValue();
            if (fFloatValue != 100.0f) {
                pr(100.0f, this.hn.get(Float.valueOf(fFloatValue)));
            }
        }
    }

    public void x() {
        Map<Float, String> map = this.hn;
        if (map == null || map.size() <= 0) {
            return;
        }
        if (!pr()) {
            hw();
        }
        for (Map.Entry<Float, String> entry : this.hn.entrySet()) {
            if (entry != null) {
                pr(entry.getKey().floatValue() / 100.0f, entry.getValue());
            }
        }
        hn();
    }

    public List<PropertyValuesHolder> c() {
        String strHw = this.x.hw();
        x();
        PropertyValuesHolder propertyValuesHolderOfKeyframe = PropertyValuesHolder.ofKeyframe(strHw, (Keyframe[]) this.c.toArray(new Keyframe[0]));
        TypeEvaluator typeEvaluatorUc = uc();
        if (typeEvaluatorUc != null) {
            propertyValuesHolderOfKeyframe.setEvaluator(typeEvaluatorUc);
        }
        this.uc.add(propertyValuesHolderOfKeyframe);
        return this.uc;
    }
}
