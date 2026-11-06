package com.byazt.bt;

import android.animation.FloatEvaluator;
import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.text.TextUtils;
import com.byazt.hb.fs;
import com.byazt.kg.l;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, 5})
public class q extends n {
    public List<Keyframe> fs;

    public q(Context context, com.byazt.ih.s sVar, String str, Map<Float, String> map) {
        super(context, sVar, str, map);
        this.fs = new ArrayList();
    }

    /* JADX INFO: renamed from: com.byazt.bt.q$1, reason: invalid class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, 37})
    static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] n;

        static {
            int[] iArr = new int[l.values().length];
            n = iArr;
            try {
                iArr[l.TRANSLATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                n[l.SCALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.byazt.bt.n
    public void qg() {
        Keyframe keyframeOfFloat;
        Keyframe keyframeOfFloat2;
        int i = AnonymousClass1.n[this.q.ordinal()];
        if (i == 1) {
            keyframeOfFloat = Keyframe.ofFloat(0.0f, this.x.oa());
            keyframeOfFloat2 = Keyframe.ofFloat(0.0f, this.x.sz());
        } else if (i != 2) {
            keyframeOfFloat = null;
            keyframeOfFloat2 = null;
        } else {
            keyframeOfFloat = Keyframe.ofFloat(0.0f, this.x.k());
            keyframeOfFloat2 = Keyframe.ofFloat(0.0f, this.x.cy());
        }
        if (keyframeOfFloat != null) {
            this.l.add(keyframeOfFloat);
        }
        if (keyframeOfFloat2 != null) {
            this.fs.add(keyframeOfFloat2);
        }
    }

    @Override // com.byazt.bt.n
    public void n(float f, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() != 2) {
                return;
            }
            float fOptDouble = (float) jSONArray.optDouble(0);
            float fOptDouble2 = (float) jSONArray.optDouble(1);
            if (this.q == l.TRANSLATE) {
                fOptDouble = fs.n(this.n, fOptDouble);
                fOptDouble2 = fs.n(this.n, fOptDouble2);
            }
            this.l.add(Keyframe.ofFloat(f, fOptDouble));
            this.fs.add(Keyframe.ofFloat(f, fOptDouble2));
        } catch (JSONException unused) {
        }
    }

    @Override // com.byazt.bt.n
    public List<PropertyValuesHolder> l() {
        String strQg = this.q.qg();
        q();
        PropertyValuesHolder propertyValuesHolderOfKeyframe = PropertyValuesHolder.ofKeyframe(strQg + "X", (Keyframe[]) this.l.toArray(new Keyframe[0]));
        this.w.add(propertyValuesHolderOfKeyframe);
        PropertyValuesHolder propertyValuesHolderOfKeyframe2 = PropertyValuesHolder.ofKeyframe(strQg + "Y", (Keyframe[]) this.fs.toArray(new Keyframe[0]));
        this.w.add(propertyValuesHolderOfKeyframe2);
        TypeEvaluator typeEvaluatorW = w();
        if (typeEvaluatorW != null) {
            propertyValuesHolderOfKeyframe.setEvaluator(typeEvaluatorW);
            propertyValuesHolderOfKeyframe2.setEvaluator(typeEvaluatorW);
        }
        return this.w;
    }

    @Override // com.byazt.bt.n
    public TypeEvaluator w() {
        return new FloatEvaluator();
    }
}
