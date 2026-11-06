package com.bytedance.adsdk.ugeno.ms.xr;

import android.animation.FloatEvaluator;
import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.c.x;
import com.bytedance.sdk.component.utils.sl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public class d extends ms {
    private List<Keyframe> x;

    public d(Context context, com.bytedance.adsdk.ugeno.xr.ah ahVar, String str, Map<Float, String> map) {
        super(context, ahVar, str, map);
        this.x = new ArrayList();
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.ms.xr.d$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        static final /* synthetic */ int[] f386ms;

        static {
            int[] iArr = new int[com.bytedance.adsdk.ugeno.ms.d.values().length];
            f386ms = iArr;
            try {
                iArr[com.bytedance.adsdk.ugeno.ms.d.TRANSLATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f386ms[com.bytedance.adsdk.ugeno.ms.d.SCALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ms.xr.ms
    public void xr() {
        Keyframe keyframeOfFloat;
        Keyframe keyframeOfFloat2;
        int i = AnonymousClass1.f386ms[this.d.ordinal()];
        if (i == 1) {
            keyframeOfFloat = Keyframe.ofFloat(0.0f, this.ab.zb());
            keyframeOfFloat2 = Keyframe.ofFloat(0.0f, this.ab.u());
        } else if (i != 2) {
            keyframeOfFloat = null;
            keyframeOfFloat2 = null;
        } else {
            keyframeOfFloat = Keyframe.ofFloat(0.0f, this.ab.ub());
            keyframeOfFloat2 = Keyframe.ofFloat(0.0f, this.ab.ao());
        }
        if (keyframeOfFloat != null) {
            this.ka.add(keyframeOfFloat);
        }
        if (keyframeOfFloat2 != null) {
            this.x.add(keyframeOfFloat2);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ms.xr.ms
    public void ms(float f, String str) {
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
            if (this.d == com.bytedance.adsdk.ugeno.ms.d.TRANSLATE) {
                fOptDouble = x.ms(this.f387ms, fOptDouble);
                fOptDouble2 = x.ms(this.f387ms, fOptDouble2);
            }
            this.ka.add(Keyframe.ofFloat(f, fOptDouble));
            this.x.add(Keyframe.ofFloat(f, fOptDouble2));
        } catch (JSONException e) {
            sl.ms(e);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ms.xr.ms
    public List<PropertyValuesHolder> ka() {
        String strXr = this.d.xr();
        d();
        PropertyValuesHolder propertyValuesHolderOfKeyframe = PropertyValuesHolder.ofKeyframe(strXr + "X", (Keyframe[]) this.ka.toArray(new Keyframe[0]));
        this.c.add(propertyValuesHolderOfKeyframe);
        PropertyValuesHolder propertyValuesHolderOfKeyframe2 = PropertyValuesHolder.ofKeyframe(strXr + "Y", (Keyframe[]) this.x.toArray(new Keyframe[0]));
        this.c.add(propertyValuesHolderOfKeyframe2);
        TypeEvaluator typeEvaluatorC = c();
        if (typeEvaluatorC != null) {
            propertyValuesHolderOfKeyframe.setEvaluator(typeEvaluatorC);
            propertyValuesHolderOfKeyframe2.setEvaluator(typeEvaluatorC);
        }
        return this.c;
    }

    @Override // com.bytedance.adsdk.ugeno.ms.xr.ms
    public TypeEvaluator c() {
        return new FloatEvaluator();
    }
}
