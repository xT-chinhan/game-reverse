package com.byazt.bt;

import android.animation.ArgbEvaluator;
import android.animation.IntEvaluator;
import android.animation.Keyframe;
import android.animation.TypeEvaluator;
import android.content.Context;
import com.byazt.kg.l;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, 8})
public class s extends n {
    public s(Context context, com.byazt.ih.s sVar, String str, TreeMap<Float, String> treeMap) {
        super(context, sVar, str, treeMap);
    }

    @Override // com.byazt.bt.n
    public void qg() {
        if (this.q == l.BACKGROUND_COLOR) {
            this.l.add(Keyframe.ofInt(0.0f, this.x.df()));
        }
    }

    @Override // com.byazt.bt.n
    public void n(float f, String str) {
        Keyframe keyframeOfInt;
        if (this.q == l.BACKGROUND_COLOR) {
            keyframeOfInt = Keyframe.ofInt(f, com.byazt.hb.n.n(str));
        } else {
            keyframeOfInt = Keyframe.ofInt(f, com.byazt.hb.s.n(str, 0));
        }
        this.l.add(keyframeOfInt);
    }

    @Override // com.byazt.bt.n
    public TypeEvaluator w() {
        if (this.q == l.BACKGROUND_COLOR) {
            return new ArgbEvaluator();
        }
        return new IntEvaluator();
    }
}
