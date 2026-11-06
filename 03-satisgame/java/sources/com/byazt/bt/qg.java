package com.byazt.bt;

import android.animation.FloatEvaluator;
import android.animation.Keyframe;
import android.animation.TypeEvaluator;
import android.content.Context;
import com.byazt.hb.fs;
import com.byazt.kg.l;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, 26})
public class qg extends n {
    public qg(Context context, com.byazt.ih.s sVar, String str, TreeMap<Float, String> treeMap) {
        super(context, sVar, str, treeMap);
    }

    /* JADX INFO: renamed from: com.byazt.bt.qg$1, reason: invalid class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, 51})
    static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] n;

        static {
            int[] iArr = new int[l.values().length];
            n = iArr;
            try {
                iArr[l.TRANSLATE_X.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                n[l.TRANSLATE_Y.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                n[l.SCALE_X.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                n[l.SCALE_Y.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                n[l.ROTATE_X.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                n[l.ROTATE_Y.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                n[l.ROTATE_Z.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                n[l.ALPHA.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                n[l.BORDER_RADIUS.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    @Override // com.byazt.bt.n
    public void qg() {
        float fOa;
        switch (AnonymousClass1.n[this.q.ordinal()]) {
            case 1:
                fOa = this.x.oa();
                break;
            case 2:
                fOa = this.x.sz();
                break;
            case 3:
                fOa = this.x.k();
                break;
            case 4:
                fOa = this.x.cy();
                break;
            case 5:
                fOa = this.x.hd();
                if (this.x.rv() != null) {
                    this.x.rv().setCameraDistance(10000.0f);
                }
                break;
            case 6:
                fOa = this.x.cd();
                if (this.x.rv() != null) {
                    this.x.rv().setCameraDistance(10000.0f);
                }
                break;
            case 7:
                fOa = this.x.um();
                break;
            case 8:
                fOa = this.x.a();
                break;
            case 9:
                fOa = this.x.py();
                break;
            default:
                fOa = 0.0f;
                break;
        }
        this.l.add(Keyframe.ofFloat(0.0f, fOa));
    }

    @Override // com.byazt.bt.n
    public void n(float f, String str) {
        float fN;
        if (this.qg.startsWith(l.TRANSLATE.n()) || this.q == l.BORDER_RADIUS) {
            fN = fs.n(this.n, com.byazt.hb.s.n(str, 0.0f));
        } else {
            fN = com.byazt.hb.s.n(str, 0.0f);
        }
        this.l.add(Keyframe.ofFloat(f, fN));
    }

    @Override // com.byazt.bt.n
    public TypeEvaluator w() {
        return new FloatEvaluator();
    }
}
