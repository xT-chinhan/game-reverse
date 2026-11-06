package com.byazt.bt;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.content.Context;
import com.byazt.kg.l;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, 19})
public abstract class n {
    public Context n;
    public l q;
    public String qg;
    public Map<Float, String> s;
    public com.byazt.ih.s x;
    public List<PropertyValuesHolder> w = new ArrayList();
    public List<Keyframe> l = new ArrayList();

    public abstract void n(float f, String str);

    public abstract void qg();

    public abstract TypeEvaluator w();

    public n(Context context, com.byazt.ih.s sVar, String str, Map<Float, String> map) {
        this.n = context;
        this.qg = str;
        this.s = map;
        this.q = l.n(this.qg);
        this.x = sVar;
    }

    public String getType() {
        return this.q.s();
    }

    public boolean n() {
        Map<Float, String> map = this.s;
        if (map == null || map.size() <= 0) {
            return false;
        }
        return this.s.containsKey(Float.valueOf(0.0f));
    }

    public void s() {
        Map<Float, String> map = this.s;
        if (map == null || map.size() <= 0) {
            return;
        }
        Map<Float, String> map2 = this.s;
        if (map2 instanceof TreeMap) {
            float fFloatValue = ((Float) ((TreeMap) map2).lastKey()).floatValue();
            if (fFloatValue != 100.0f) {
                n(100.0f, this.s.get(Float.valueOf(fFloatValue)));
            }
        }
    }

    public void q() {
        Map<Float, String> map = this.s;
        if (map == null || map.size() <= 0) {
            return;
        }
        if (!n()) {
            qg();
        }
        for (Map.Entry<Float, String> entry : this.s.entrySet()) {
            if (entry != null) {
                n(entry.getKey().floatValue() / 100.0f, entry.getValue());
            }
        }
        s();
    }

    public List<PropertyValuesHolder> l() {
        String strQg = this.q.qg();
        q();
        PropertyValuesHolder propertyValuesHolderOfKeyframe = PropertyValuesHolder.ofKeyframe(strQg, (Keyframe[]) this.l.toArray(new Keyframe[0]));
        TypeEvaluator typeEvaluatorW = w();
        if (typeEvaluatorW != null) {
            propertyValuesHolderOfKeyframe.setEvaluator(typeEvaluatorW);
        }
        this.w.add(propertyValuesHolderOfKeyframe);
        return this.w;
    }
}
