package com.bytedance.adsdk.ugeno.ms.xr;

import android.animation.ArgbEvaluator;
import android.animation.IntEvaluator;
import android.animation.Keyframe;
import android.animation.TypeEvaluator;
import android.content.Context;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends ms {
    public ah(Context context, com.bytedance.adsdk.ugeno.xr.ah ahVar, String str, TreeMap<Float, String> treeMap) {
        super(context, ahVar, str, treeMap);
    }

    @Override // com.bytedance.adsdk.ugeno.ms.xr.ms
    public void xr() {
        if (this.d == com.bytedance.adsdk.ugeno.ms.d.BACKGROUND_COLOR) {
            this.ka.add(Keyframe.ofInt(0.0f, this.ab.az()));
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ms.xr.ms
    public void ms(float f, String str) {
        Keyframe keyframeOfInt;
        if (this.d == com.bytedance.adsdk.ugeno.ms.d.BACKGROUND_COLOR) {
            keyframeOfInt = Keyframe.ofInt(f, com.bytedance.adsdk.ugeno.c.ms.ms(str));
        } else {
            keyframeOfInt = Keyframe.ofInt(f, com.bytedance.adsdk.ugeno.c.ah.ms(str, 0));
        }
        this.ka.add(keyframeOfInt);
    }

    @Override // com.bytedance.adsdk.ugeno.ms.xr.ms
    public TypeEvaluator c() {
        if (this.d == com.bytedance.adsdk.ugeno.ms.d.BACKGROUND_COLOR) {
            return new ArgbEvaluator();
        }
        return new IntEvaluator();
    }
}
