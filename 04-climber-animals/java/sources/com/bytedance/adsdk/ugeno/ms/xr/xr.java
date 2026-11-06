package com.bytedance.adsdk.ugeno.ms.xr;

import android.animation.FloatEvaluator;
import android.animation.Keyframe;
import android.animation.TypeEvaluator;
import android.content.Context;
import com.bytedance.adsdk.ugeno.c.x;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends ms {
    public xr(Context context, com.bytedance.adsdk.ugeno.xr.ah ahVar, String str, TreeMap<Float, String> treeMap) {
        super(context, ahVar, str, treeMap);
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.ms.xr.xr$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        static final /* synthetic */ int[] f388ms;

        static {
            int[] iArr = new int[com.bytedance.adsdk.ugeno.ms.d.values().length];
            f388ms = iArr;
            try {
                iArr[com.bytedance.adsdk.ugeno.ms.d.TRANSLATE_X.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f388ms[com.bytedance.adsdk.ugeno.ms.d.TRANSLATE_Y.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f388ms[com.bytedance.adsdk.ugeno.ms.d.SCALE_X.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f388ms[com.bytedance.adsdk.ugeno.ms.d.SCALE_Y.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f388ms[com.bytedance.adsdk.ugeno.ms.d.ROTATE_X.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f388ms[com.bytedance.adsdk.ugeno.ms.d.ROTATE_Y.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f388ms[com.bytedance.adsdk.ugeno.ms.d.ROTATE_Z.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f388ms[com.bytedance.adsdk.ugeno.ms.d.ALPHA.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f388ms[com.bytedance.adsdk.ugeno.ms.d.BORDER_RADIUS.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ms.xr.ms
    public void xr() {
        float fZb;
        switch (AnonymousClass1.f388ms[this.d.ordinal()]) {
            case 1:
                fZb = this.ab.zb();
                break;
            case 2:
                fZb = this.ab.u();
                break;
            case 3:
                fZb = this.ab.ub();
                break;
            case 4:
                fZb = this.ab.ao();
                break;
            case 5:
                fZb = this.ab.h();
                break;
            case 6:
                fZb = this.ab.qv();
                break;
            case 7:
                fZb = this.ab.y();
                break;
            case 8:
                fZb = this.ab.t();
                break;
            case 9:
                fZb = this.ab.nw();
                break;
            default:
                fZb = 0.0f;
                break;
        }
        this.ka.add(Keyframe.ofFloat(0.0f, fZb));
    }

    @Override // com.bytedance.adsdk.ugeno.ms.xr.ms
    public void ms(float f, String str) {
        float fMs;
        if (this.xr.startsWith(com.bytedance.adsdk.ugeno.ms.d.TRANSLATE.ms()) || this.d == com.bytedance.adsdk.ugeno.ms.d.BORDER_RADIUS) {
            fMs = x.ms(this.f387ms, com.bytedance.adsdk.ugeno.c.ah.ms(str, 0.0f));
        } else {
            fMs = com.bytedance.adsdk.ugeno.c.ah.ms(str, 0.0f);
        }
        this.ka.add(Keyframe.ofFloat(f, fMs));
    }

    @Override // com.bytedance.adsdk.ugeno.ms.xr.ms
    public TypeEvaluator c() {
        return new FloatEvaluator();
    }
}
