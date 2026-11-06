package com.byazt.ahr;

import android.animation.ArgbEvaluator;
import android.animation.IntEvaluator;
import android.animation.Keyframe;
import android.animation.TypeEvaluator;
import android.content.Context;
import com.byazt.iza.c;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 98, 20})
public class hn extends pr {
    public hn(Context context, com.byazt.ik.hn hnVar, String str, TreeMap<Float, String> treeMap) {
        super(context, hnVar, str, treeMap);
    }

    @Override // com.byazt.ahr.pr
    public void hw() {
        if (this.x == c.BACKGROUND_COLOR) {
            this.c.add(Keyframe.ofInt(0.0f, this.fw.v()));
        }
    }

    @Override // com.byazt.ahr.pr
    public void pr(float f, String str) {
        Keyframe keyframeOfInt;
        if (this.x == c.BACKGROUND_COLOR) {
            keyframeOfInt = Keyframe.ofInt(f, com.byazt.aa.pr.pr(str));
        } else {
            keyframeOfInt = Keyframe.ofInt(f, com.byazt.aa.hn.pr(str, 0));
        }
        this.c.add(keyframeOfInt);
    }

    @Override // com.byazt.ahr.pr
    public TypeEvaluator uc() {
        if (this.x == c.BACKGROUND_COLOR) {
            return new ArgbEvaluator();
        }
        return new IntEvaluator();
    }
}
