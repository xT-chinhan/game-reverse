package com.byazt.ahr;

import android.animation.FloatEvaluator;
import android.animation.Keyframe;
import android.animation.TypeEvaluator;
import android.content.Context;
import com.byazt.aa.zo;
import com.byazt.iza.c;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 98, 13})
public class hw extends pr {
    public hw(Context context, com.byazt.ik.hn hnVar, String str, TreeMap<Float, String> treeMap) {
        super(context, hnVar, str, treeMap);
    }

    /* JADX INFO: renamed from: com.byazt.ahr.hw$1, reason: invalid class name */
    @com.byazt.vzx.pr(pr = {0, 1, 98, MediaPlayer.MEDIA_PLAYER_OPTION_LAZY_SEEK})
    static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] pr;

        static {
            int[] iArr = new int[c.values().length];
            pr = iArr;
            try {
                iArr[c.TRANSLATE_X.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                pr[c.TRANSLATE_Y.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                pr[c.SCALE_X.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                pr[c.SCALE_Y.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                pr[c.ROTATE_X.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                pr[c.ROTATE_Y.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                pr[c.ROTATE_Z.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                pr[c.ALPHA.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                pr[c.BORDER_RADIUS.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    @Override // com.byazt.ahr.pr
    public void hw() {
        float fM;
        switch (AnonymousClass1.pr[this.x.ordinal()]) {
            case 1:
                fM = this.fw.m();
                break;
            case 2:
                fM = this.fw.g();
                break;
            case 3:
                fM = this.fw.ho();
                break;
            case 4:
                fM = this.fw.nt();
                break;
            case 5:
                fM = this.fw.yb();
                if (this.fw.aj() != null) {
                    this.fw.aj().setCameraDistance(10000.0f);
                }
                break;
            case 6:
                fM = this.fw.lb();
                if (this.fw.aj() != null) {
                    this.fw.aj().setCameraDistance(10000.0f);
                }
                break;
            case 7:
                fM = this.fw.qa();
                break;
            case 8:
                fM = this.fw.a();
                break;
            case 9:
                fM = this.fw.cz();
                break;
            default:
                fM = 0.0f;
                break;
        }
        this.c.add(Keyframe.ofFloat(0.0f, fM));
    }

    @Override // com.byazt.ahr.pr
    public void pr(float f, String str) {
        float fPr;
        if (this.hw.startsWith(c.TRANSLATE.pr()) || this.x == c.BORDER_RADIUS) {
            fPr = zo.pr(this.pr, com.byazt.aa.hn.pr(str, 0.0f));
        } else {
            fPr = com.byazt.aa.hn.pr(str, 0.0f);
        }
        this.c.add(Keyframe.ofFloat(f, fPr));
    }

    @Override // com.byazt.ahr.pr
    public TypeEvaluator uc() {
        return new FloatEvaluator();
    }
}
