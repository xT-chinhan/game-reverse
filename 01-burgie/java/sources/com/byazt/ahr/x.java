package com.byazt.ahr;

import android.animation.FloatEvaluator;
import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.text.TextUtils;
import com.byazt.aa.zo;
import com.byazt.iza.c;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 98, 121})
public class x extends pr {
    public List<Keyframe> zo;

    public x(Context context, com.byazt.ik.hn hnVar, String str, Map<Float, String> map) {
        super(context, hnVar, str, map);
        this.zo = new ArrayList();
    }

    @Override // com.byazt.ahr.pr
    public void hw() {
        Keyframe keyframeOfFloat;
        Keyframe keyframeOfFloat2 = null;
        switch (AnonymousClass1.pr[this.x.ordinal()]) {
            case 1:
                keyframeOfFloat2 = Keyframe.ofFloat(0.0f, this.fw.m());
                keyframeOfFloat = Keyframe.ofFloat(0.0f, this.fw.g());
                break;
            case 2:
                keyframeOfFloat2 = Keyframe.ofFloat(0.0f, this.fw.ho());
                keyframeOfFloat = Keyframe.ofFloat(0.0f, this.fw.nt());
                break;
            default:
                keyframeOfFloat = null;
                break;
        }
        if (keyframeOfFloat2 != null) {
            this.c.add(keyframeOfFloat2);
        }
        if (keyframeOfFloat != null) {
            this.zo.add(keyframeOfFloat);
        }
    }

    /* JADX INFO: renamed from: com.byazt.ahr.x$1, reason: invalid class name */
    @com.byazt.vzx.pr(pr = {0, 1, 98, MediaPlayer.MEDIA_PLAYER_OPTION_BIT_RATE})
    static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] pr;

        static {
            int[] iArr = new int[c.values().length];
            pr = iArr;
            try {
                iArr[c.TRANSLATE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                pr[c.SCALE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    @Override // com.byazt.ahr.pr
    public void pr(float f, String str) {
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
            if (this.x == c.TRANSLATE) {
                fOptDouble = zo.pr(this.pr, fOptDouble);
                fOptDouble2 = zo.pr(this.pr, fOptDouble2);
            }
            this.c.add(Keyframe.ofFloat(f, fOptDouble));
            this.zo.add(Keyframe.ofFloat(f, fOptDouble2));
        } catch (JSONException e) {
        }
    }

    @Override // com.byazt.ahr.pr
    public List<PropertyValuesHolder> c() {
        String strHw = this.x.hw();
        x();
        PropertyValuesHolder propertyValuesHolderOfKeyframe = PropertyValuesHolder.ofKeyframe(strHw + "X", (Keyframe[]) this.c.toArray(new Keyframe[0]));
        this.uc.add(propertyValuesHolderOfKeyframe);
        PropertyValuesHolder propertyValuesHolderOfKeyframe2 = PropertyValuesHolder.ofKeyframe(strHw + "Y", (Keyframe[]) this.zo.toArray(new Keyframe[0]));
        this.uc.add(propertyValuesHolderOfKeyframe2);
        TypeEvaluator typeEvaluatorUc = uc();
        if (typeEvaluatorUc != null) {
            propertyValuesHolderOfKeyframe.setEvaluator(typeEvaluatorUc);
            propertyValuesHolderOfKeyframe2.setEvaluator(typeEvaluatorUc);
        }
        return this.uc;
    }

    @Override // com.byazt.ahr.pr
    public TypeEvaluator uc() {
        return new FloatEvaluator();
    }
}
