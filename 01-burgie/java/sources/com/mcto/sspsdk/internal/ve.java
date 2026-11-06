package com.mcto.sspsdk.internal;

import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Build;
import android.os.SystemClock;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.transition.AutoTransition;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.byazt.eyv.AdBaseConstants;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mcto.sspsdk.QyAdSlot;
import com.mcto.sspsdk.QyRewardProperty;
import com.mcto.sspsdk.R;
import com.mcto.sspsdk.component.button.DownloadButtonView;
import com.taptap.sdk.kit.internal.http.TapHttp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class ve extends sc implements View.OnClickListener {
    public static final /* synthetic */ int i0 = 0;
    public final int A;
    public final AppCompatActivity B;
    public re C;
    public j7 D;
    public float E;
    public float F;
    public float G;
    public float H;
    public int I;
    public int J;
    public int K;
    public long L;
    public final AtomicBoolean M;
    public final AtomicBoolean N;
    public final AtomicBoolean O;
    public final AtomicBoolean P;
    public final AtomicBoolean Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public long U;
    public long V;
    public long W;
    public final AtomicBoolean a0;
    public final AppCompatActivity b;
    public final AtomicBoolean b0;
    public final p c;
    public final AtomicBoolean c0;
    public final int d;
    public final pe d0;
    public final int e;
    public qe e0;
    public final e f;
    public final te f0;
    public final cd g;
    public final int g0;
    public final ImageView h;
    public volatile int h0;
    public final j4 i;
    public final TextView j;
    public final jc k;
    public final xc l;
    public final TextView m;
    public final gf n;
    public final ProgressBar o;
    public com.mcto.sspsdk.ssp.reward.a p;
    public final QyAdSlot q;
    public final int r;
    public final int s;
    public final boolean t;
    public int u;
    public boolean v;
    public boolean w;
    public final le x;
    public ne y;
    public final int z;

    /* JADX WARN: Failed to calculate best type for var: r7v18 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v18 ??, new type: com.mcto.sspsdk.internal.gf
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r7v18 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v18 ??, new type: com.mcto.sspsdk.internal.gf
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v18 ??, new type: android.widget.FrameLayout
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderAllow(TypeUpdate.java:66)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryWiderObjects(FixTypesVisitor.java:795)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:249)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 5 more
        */
    public ve(com.mcto.sspsdk.internal.ue r21) {
        /*
            Method dump skipped, instruction units count: 1360
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mcto.sspsdk.internal.ve.<init>(com.mcto.sspsdk.internal.ue):void");
    }

    public final void a(int i) {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this);
        constraintSet.clear(R.id.qy_trueview_player);
        switch (j.a(i)) {
            case 0:
            case 10:
            case 13:
                constraintSet.constrainWidth(R.id.qy_trueview_player, -1);
                constraintSet.constrainHeight(R.id.qy_trueview_player, 0);
                constraintSet.setDimensionRatio(R.id.qy_trueview_player, "W,16:9");
                constraintSet.connect(R.id.qy_trueview_player, 1, 0, 1);
                constraintSet.connect(R.id.qy_trueview_player, 2, 0, 2);
                constraintSet.connect(R.id.qy_trueview_player, 3, 0, 3);
                constraintSet.setVerticalBias(R.id.qy_trueview_player, 0.0f);
                break;
            case 1:
                constraintSet.constrainWidth(R.id.qy_trueview_player, -1);
                constraintSet.constrainHeight(R.id.qy_trueview_player, 0);
                constraintSet.connect(R.id.qy_trueview_player, 3, 0, 3);
                constraintSet.connect(R.id.qy_trueview_player, 4, 0, 4);
                constraintSet.connect(R.id.qy_trueview_player, 1, 0, 1);
                constraintSet.connect(R.id.qy_trueview_player, 2, 0, 2);
                constraintSet.setDimensionRatio(R.id.qy_trueview_player, "H,16:9");
                break;
            case 2:
            case 12:
            case 15:
            case 16:
            case 17:
            case 18:
            default:
                constraintSet.constrainWidth(R.id.qy_trueview_player, -1);
                constraintSet.constrainHeight(R.id.qy_trueview_player, -1);
                break;
            case 3:
            case 19:
                constraintSet.constrainWidth(R.id.qy_trueview_player, 0);
                constraintSet.constrainHeight(R.id.qy_trueview_player, -1);
                constraintSet.connect(R.id.qy_trueview_player, 3, 0, 3);
                constraintSet.connect(R.id.qy_trueview_player, 4, 0, 4);
                constraintSet.connect(R.id.qy_trueview_player, 1, 0, 1);
                constraintSet.connect(R.id.qy_trueview_player, 2, 0, 2);
                constraintSet.setDimensionRatio(R.id.qy_trueview_player, "W,9:16");
                constraintSet.setHorizontalBias(R.id.qy_trueview_player, 0.38f);
                break;
            case 4:
                constraintSet.constrainWidth(R.id.qy_trueview_player, -1);
                constraintSet.constrainHeight(R.id.qy_trueview_player, 0);
                constraintSet.setDimensionRatio(R.id.qy_trueview_player, "H,16:9");
                constraintSet.connect(R.id.qy_trueview_player, 1, 0, 1);
                constraintSet.connect(R.id.qy_trueview_player, 3, 0, 3);
                constraintSet.connect(R.id.qy_trueview_player, 4, R.id.qy_card_view, 3);
                constraintSet.connect(R.id.qy_trueview_player, 2, 0, 2);
                break;
            case 5:
            case 8:
            case 9:
                constraintSet.constrainWidth(R.id.qy_trueview_player, 0);
                constraintSet.constrainHeight(R.id.qy_trueview_player, 0);
                constraintSet.connect(R.id.qy_trueview_player, 1, 0, 1);
                constraintSet.connect(R.id.qy_trueview_player, 3, 0, 3);
                constraintSet.connect(R.id.qy_trueview_player, 4, R.id.qy_card_view, 3);
                constraintSet.connect(R.id.qy_trueview_player, 2, 0, 2);
                break;
            case 6:
                constraintSet.constrainWidth(R.id.qy_trueview_player, 0);
                constraintSet.constrainHeight(R.id.qy_trueview_player, 0);
                constraintSet.connect(R.id.qy_trueview_player, 1, 0, 1);
                constraintSet.connect(R.id.qy_trueview_player, 3, 0, 3);
                constraintSet.connect(R.id.qy_trueview_player, 4, 0, 4);
                constraintSet.connect(R.id.qy_trueview_player, 2, R.id.qy_card_view, 1);
                break;
            case 7:
                constraintSet.constrainWidth(R.id.qy_trueview_player, 0);
                constraintSet.constrainHeight(R.id.qy_trueview_player, -1);
                constraintSet.setDimensionRatio(R.id.qy_trueview_player, "W,9:16");
                constraintSet.connect(R.id.qy_trueview_player, 1, 0, 1);
                constraintSet.connect(R.id.qy_trueview_player, 3, 0, 3);
                constraintSet.connect(R.id.qy_trueview_player, 4, 0, 4);
                constraintSet.connect(R.id.qy_trueview_player, 2, R.id.qy_card_view, 1);
                break;
            case 11:
            case 14:
                constraintSet.constrainWidth(R.id.qy_trueview_player, -1);
                constraintSet.constrainHeight(R.id.qy_trueview_player, 0);
                constraintSet.connect(R.id.qy_trueview_player, 3, 0, 3);
                constraintSet.connect(R.id.qy_trueview_player, 4, 0, 4);
                constraintSet.connect(R.id.qy_trueview_player, 1, 0, 1);
                constraintSet.connect(R.id.qy_trueview_player, 2, 0, 2);
                constraintSet.setDimensionRatio(R.id.qy_trueview_player, "W,9:16");
                constraintSet.setVerticalBias(R.id.qy_trueview_player, 0.38f);
                break;
        }
        if ((i == 4 || i == 3) && this.c.p()) {
            constraintSet.clear(R.id.qy_trueview_gradient_overlay);
            constraintSet.constrainWidth(R.id.qy_trueview_gradient_overlay, -1);
            constraintSet.constrainHeight(R.id.qy_trueview_gradient_overlay, hk.b(this.b) / 2);
            constraintSet.connect(R.id.qy_trueview_gradient_overlay, 4, getId(), 4);
        }
        constraintSet.clear(R.id.qy_card_view);
        switch (j.a(i)) {
            case 1:
                this.g.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                constraintSet.constrainWidth(R.id.qy_card_view, -1);
                constraintSet.constrainHeight(R.id.qy_card_view, -1);
                break;
            case 2:
            case 3:
                constraintSet.constrainWidth(R.id.qy_card_view, 0);
                constraintSet.constrainHeight(R.id.qy_card_view, hk.a(this.b, 130.0f));
                constraintSet.connect(R.id.qy_card_view, 3, 0, 4);
                constraintSet.connect(R.id.qy_card_view, 2, R.id.qy_count_down_btn, 2);
                constraintSet.connect(R.id.qy_card_view, 1, R.id.qy_video_voice_img, 1);
                this.g.getBackground().setAlpha(MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA);
                r0.a(this.g, "translationY", 0.0f, -hk.a(this.b, 135.0f), 800L);
                break;
            case 4:
            case 5:
                constraintSet.constrainWidth(R.id.qy_card_view, 0);
                constraintSet.constrainHeight(R.id.qy_card_view, 0);
                constraintSet.connect(R.id.qy_card_view, 1, 0, 1);
                constraintSet.connect(R.id.qy_card_view, 2, 0, 2);
                constraintSet.connect(R.id.qy_card_view, 3, R.id.qy_trueview_player, 4);
                constraintSet.connect(R.id.qy_card_view, 4, 0, 4);
                break;
            case 6:
            case 7:
                constraintSet.constrainWidth(R.id.qy_card_view, 0);
                constraintSet.constrainHeight(R.id.qy_card_view, 0);
                constraintSet.connect(R.id.qy_card_view, 1, R.id.qy_trueview_player, 2);
                constraintSet.connect(R.id.qy_card_view, 2, 0, 2);
                constraintSet.connect(R.id.qy_card_view, 3, 0, 3);
                constraintSet.connect(R.id.qy_card_view, 4, 0, 4);
                break;
            case 8:
                constraintSet.constrainWidth(R.id.qy_card_view, 0);
                constraintSet.constrainHeight(R.id.qy_card_view, (hk.b(this.b) - hk.a(this.b)) - ((this.b.getResources().getDisplayMetrics().widthPixels * 9) / 16));
                constraintSet.connect(R.id.qy_card_view, 1, 0, 1);
                constraintSet.connect(R.id.qy_card_view, 2, 0, 2);
                constraintSet.connect(R.id.qy_card_view, 3, R.id.qy_trueview_player, 4);
                constraintSet.connect(R.id.qy_card_view, 4, 0, 4);
                break;
            case 9:
                constraintSet.constrainWidth(R.id.qy_card_view, 0);
                constraintSet.constrainHeight(R.id.qy_card_view, (hk.b(this.b) * 4) / 10);
                constraintSet.connect(R.id.qy_card_view, 1, 0, 1);
                constraintSet.connect(R.id.qy_card_view, 2, 0, 2);
                constraintSet.connect(R.id.qy_card_view, 3, R.id.qy_trueview_player, 4);
                constraintSet.connect(R.id.qy_card_view, 4, 0, 4);
                break;
            case 10:
            case 11:
            case 13:
            case 14:
            default:
                constraintSet.constrainWidth(R.id.qy_card_view, 0);
                constraintSet.constrainHeight(R.id.qy_card_view, -2);
                constraintSet.connect(R.id.qy_card_view, 1, 0, 1);
                constraintSet.connect(R.id.qy_card_view, 2, 0, 2);
                constraintSet.connect(R.id.qy_card_view, 4, 0, 4);
                constraintSet.setMargin(R.id.qy_card_view, 1, hk.a(this.b, 16.0f));
                constraintSet.setMargin(R.id.qy_card_view, 2, hk.a(this.b, 16.0f));
                constraintSet.setMargin(R.id.qy_card_view, 4, hk.a(this.b, 26.0f));
                this.g.setTranslationX(-this.b.getResources().getDisplayMetrics().widthPixels);
                r0.a(this.g, "translationX", -this.b.getResources().getDisplayMetrics().widthPixels, 0.0f, 700L);
                break;
            case 12:
                constraintSet.constrainWidth(R.id.qy_card_view, -2);
                constraintSet.constrainHeight(R.id.qy_card_view, -2);
                constraintSet.connect(R.id.qy_card_view, 4, R.id.qy_ad_badge, 3);
                constraintSet.connect(R.id.qy_card_view, 2, R.id.qy_count_down_btn, 2);
                this.g.getBackground().setAlpha(MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA);
                r0.a(this.g, "translationX", hk.a(this.b, 430.0f), 0.0f, 800L);
                break;
            case 15:
            case 16:
            case 17:
                constraintSet.constrainWidth(R.id.qy_card_view, hk.a(this.b, 335.0f));
                constraintSet.constrainHeight(R.id.qy_card_view, -2);
                constraintSet.connect(R.id.qy_card_view, 4, R.id.qy_ad_badge, 3);
                constraintSet.connect(R.id.qy_card_view, 2, R.id.qy_count_down_btn, 2);
                this.g.getBackground().setAlpha(MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA);
                r0.a(this.g, "translationX", hk.a(this.b, 430.0f), 0.0f, 800L);
                break;
            case 18:
            case 19:
                boolean z = this.d == 2;
                boolean zD = hk.d(this.b);
                hk.a(this.g, hk.a(this.b, 17.5f));
                if (z || zD) {
                    constraintSet.constrainWidth(R.id.qy_card_view, hk.a(this.b, 351.0f));
                    constraintSet.constrainHeight(R.id.qy_card_view, -2);
                    constraintSet.connect(R.id.qy_card_view, 2, 0, 2);
                    constraintSet.connect(R.id.qy_card_view, 4, 0, 4);
                    constraintSet.setMargin(R.id.qy_card_view, 2, 24);
                    constraintSet.setMargin(R.id.qy_card_view, 4, 22);
                } else {
                    constraintSet.constrainWidth(R.id.qy_card_view, 0);
                    constraintSet.constrainHeight(R.id.qy_card_view, hk.a(this.b, 175.0f));
                    constraintSet.connect(R.id.qy_card_view, 1, 0, 1);
                    constraintSet.connect(R.id.qy_card_view, 2, 0, 2);
                    constraintSet.connect(R.id.qy_card_view, 4, 0, 4);
                    int iA = hk.a(this.b, 12.0f);
                    constraintSet.setMargin(R.id.qy_card_view, 1, iA);
                    constraintSet.setMargin(R.id.qy_card_view, 2, iA);
                    constraintSet.setMargin(R.id.qy_card_view, 4, hk.a(this.b, 49.0f));
                }
                break;
        }
        constraintSet.clear(R.id.qy_video_voice_img);
        constraintSet.constrainWidth(R.id.qy_video_voice_img, hk.a(this.b, 30.0f));
        constraintSet.constrainHeight(R.id.qy_video_voice_img, hk.a(this.b, 30.0f));
        constraintSet.connect(R.id.qy_video_voice_img, 1, getId(), 1);
        constraintSet.connect(R.id.qy_video_voice_img, 3, R.id.qy_count_down_btn, 3);
        constraintSet.setMargin(R.id.qy_video_voice_img, 1, hk.a(this.b, 12.0f));
        if (this.j != null) {
            constraintSet.clear(R.id.qy_trueview_ad_index);
            constraintSet.constrainWidth(R.id.qy_trueview_ad_index, -2);
            constraintSet.constrainHeight(R.id.qy_trueview_ad_index, 0);
            constraintSet.connect(R.id.qy_trueview_ad_index, 2, R.id.qy_count_down_btn, 1);
            constraintSet.connect(R.id.qy_trueview_ad_index, 3, R.id.qy_count_down_btn, 3);
            constraintSet.connect(R.id.qy_trueview_ad_index, 4, R.id.qy_count_down_btn, 4);
            constraintSet.setMargin(R.id.qy_trueview_ad_index, 2, hk.a(this.b, 8.0f));
        }
        constraintSet.clear(R.id.qy_count_down_btn);
        constraintSet.constrainWidth(R.id.qy_count_down_btn, -2);
        constraintSet.constrainHeight(R.id.qy_count_down_btn, hk.a(this.b, 30.0f));
        constraintSet.connect(R.id.qy_count_down_btn, 2, getId(), 2);
        constraintSet.connect(R.id.qy_count_down_btn, 3, getId(), 3);
        constraintSet.setMargin(R.id.qy_count_down_btn, 2, hk.a(this.b, 12.0f));
        constraintSet.setMargin(R.id.qy_count_down_btn, 3, hk.a(this.b, 12.0f));
        constraintSet.clear(R.id.qy_ad_badge);
        constraintSet.constrainWidth(R.id.qy_ad_badge, -2);
        constraintSet.constrainHeight(R.id.qy_ad_badge, -2);
        constraintSet.connect(R.id.qy_ad_badge, 1, R.id.qy_video_voice_img, 1);
        constraintSet.connect(R.id.qy_ad_badge, 4, getId(), 4);
        constraintSet.setMargin(R.id.qy_ad_badge, 4, hk.a(this.b, 8.0f));
        if (this.o != null) {
            constraintSet.clear(R.id.qy_trueview_progress);
            constraintSet.constrainWidth(R.id.qy_trueview_progress, -1);
            constraintSet.constrainHeight(R.id.qy_trueview_progress, hk.a(this.b, 1.0f));
            constraintSet.connect(R.id.qy_trueview_progress, 3, getId(), 3);
        }
        if (i != 15 && i != 14 && i != 18 && this.f.c() && (i == 11 || i == 12 || i == 3 || i == 4)) {
            if (i == 11 || i == 12) {
                constraintSet.clear(R.id.qy_card_slide_view);
                constraintSet.constrainWidth(R.id.qy_card_slide_view, hk.a(this.b, 100.0f));
                constraintSet.constrainHeight(R.id.qy_card_slide_view, hk.a(this.b, 100.0f));
                constraintSet.connect(R.id.qy_card_slide_view, 4, R.id.qy_card_slide_desc, 3);
                constraintSet.connect(R.id.qy_card_slide_view, 1, 0, 1);
                constraintSet.connect(R.id.qy_card_slide_view, 2, 0, 2);
                constraintSet.setMargin(R.id.qy_card_slide_view, 4, hk.a(this.b, 5.0f));
                constraintSet.clear(R.id.qy_card_slide_desc);
                constraintSet.constrainWidth(R.id.qy_card_slide_desc, -2);
                constraintSet.constrainHeight(R.id.qy_card_slide_desc, -2);
                constraintSet.connect(R.id.qy_card_slide_desc, 4, R.id.qy_card_view, 3);
                constraintSet.connect(R.id.qy_card_slide_desc, 1, 0, 1);
                constraintSet.connect(R.id.qy_card_slide_desc, 2, 0, 2);
                constraintSet.setMargin(R.id.qy_card_slide_desc, 4, hk.a(this.b, 10.0f));
            } else {
                constraintSet.clear(R.id.qy_card_slide_view);
                constraintSet.constrainWidth(R.id.qy_card_slide_view, hk.a(this.b, 100.0f));
                constraintSet.constrainHeight(R.id.qy_card_slide_view, hk.a(this.b, 100.0f));
                constraintSet.connect(R.id.qy_card_slide_view, 4, R.id.qy_card_slide_desc, 3);
                constraintSet.connect(R.id.qy_card_slide_view, 1, 0, 1);
                constraintSet.connect(R.id.qy_card_slide_view, 2, 0, 2);
                constraintSet.connect(R.id.qy_card_slide_view, 3, 0, 3);
                constraintSet.setVerticalChainStyle(R.id.qy_card_slide_view, 2);
                constraintSet.setMargin(R.id.qy_card_slide_view, 4, hk.a(this.b, 5.0f));
                constraintSet.clear(R.id.qy_card_slide_desc);
                constraintSet.constrainWidth(R.id.qy_card_slide_desc, -2);
                constraintSet.constrainHeight(R.id.qy_card_slide_desc, -2);
                constraintSet.connect(R.id.qy_card_slide_desc, 3, R.id.qy_card_slide_view, 4);
                constraintSet.connect(R.id.qy_card_slide_desc, 1, 0, 1);
                constraintSet.connect(R.id.qy_card_slide_desc, 2, 0, 2);
                constraintSet.connect(R.id.qy_card_slide_desc, 4, 0, 4);
                constraintSet.setMargin(R.id.qy_card_slide_desc, 4, hk.a(this.b, 10.0f));
            }
        }
        constraintSet.applyTo(this);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.g.getLayoutParams();
        if (i == 13) {
            layoutParams.matchConstraintMaxWidth = hk.a(this.b, 420.0f);
            layoutParams.matchConstraintMinWidth = hk.a(this.b, 320.0f);
            this.g.setLayoutParams(layoutParams);
        }
        if (i == 2) {
            this.n.bringToFront();
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00bf  */
    /* JADX WARN: Type inference failed for: r7v3, types: [android.support.v7.app.AppCompatActivity, com.mcto.sspsdk.internal.o7] */
    public final void b(b4 b4Var) {
        z3 z3Var = b4Var.a;
        if (z3Var == null) {
            z3Var = z3.GRAPHIC;
        }
        if (z3Var.c == 0) {
            c(b4Var);
            return;
        }
        j7 j7Var = this.D;
        if (j7Var != null && !(j7Var instanceof u8)) {
            j7Var.destroy();
        }
        int i = this.A;
        if ((i > 0 && this.u >= i) || this.P.get()) {
            d(1);
        }
        if (this.f.U == 1) {
            int i2 = this.h0;
            if (i2 == 0) {
                throw null;
            }
            if (i2 == 1 || i2 == 2) {
                if (this.c.n()) {
                    this.U = SystemClock.elapsedRealtime();
                } else {
                    p pVar = this.c;
                    if (pVar.S0 != 3) {
                        this.U = SystemClock.elapsedRealtime();
                    } else if (e1.c(pVar.i().optString("apkName"))) {
                        q9 q9Var = p9.a;
                        String str = this.c.i().optString("apkName") + " not exist";
                        q9Var.getClass();
                        eh.a.a(new o9("ssp_reward", str, null));
                        this.U = SystemClock.elapsedRealtime();
                    } else {
                        fc.a(jd.a, "请先安装" + this.c.P + "，再点击参与！", 3000);
                    }
                }
            } else if (this.h0 == 5) {
                l();
            }
        }
        if (this.S) {
            this.S = false;
            b4Var.a(this.E, this.F, this.G, this.H);
            b4Var.c = this.I + "_" + this.J;
        }
        cd cdVar = this.g;
        if (cdVar != null) {
            DownloadButtonView downloadButtonView = cdVar.b;
            b4Var.a(downloadButtonView != null ? downloadButtonView.c() : 0);
            DownloadButtonView downloadButtonView2 = this.g.b;
            b4Var.k = downloadButtonView2 != null ? downloadButtonView2.a() : null;
        }
        b4Var.l = this;
        l lVarA = l.a();
        p pVar2 = this.c;
        HashMap mapA = gj.a(b4Var, this);
        lVarA.getClass();
        l.a(21, pVar2, mapA);
        l lVarA2 = l.a();
        p pVar3 = this.c;
        HashMap mapA2 = gj.a(b4Var, this);
        lVarA2.getClass();
        l.a(19, pVar3, mapA2);
        c(b4Var);
        if (this.c.n()) {
            j7 j7Var2 = this.D;
            if ((j7Var2 instanceof u8) && ((s8) j7Var2).k) {
                u8 u8Var = (u8) j7Var2;
                ld ldVar = u8Var.h;
                if (ldVar != null) {
                    ldVar.a();
                    u8Var.h = null;
                }
                u8Var.l = SystemClock.elapsedRealtime();
            }
        } else {
            int iA = y3.a(this.b, this.c, b4Var);
            if (iA == -1) {
                return;
            }
            if (iA == 4) {
                l lVarA3 = l.a();
                p pVar4 = this.c;
                lVarA3.getClass();
                l.a(25, pVar4, null);
            }
        }
        this.B.onAdClick();
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [android.support.v7.app.AppCompatActivity, com.mcto.sspsdk.internal.o7] */
    public final void c(int i) {
        if (!(i == 0 && this.c.L0.D == 1) && this.N.compareAndSet(false, true)) {
            if (h()) {
                l lVarA = l.a();
                p pVar = this.c;
                lVarA.getClass();
                l.a(26, pVar, null);
            }
            HashMap map = new HashMap();
            map.put(QyRewardProperty.VERIFY_TYPE, QyRewardProperty.VERIFY_TYPE_PRE);
            HashMap map2 = this.c.i0;
            map.put(QyRewardProperty.VERIFY_CHECK_INFO, map2 != null ? map2.get(ak.a(14)) : null);
            map.put(QyRewardProperty.VERIFY_IMPRESSIONID, this.c.n0);
            if (this.c.V > 0) {
                map.put(QyRewardProperty.VERIFY_REWARD_AMOUNT, "" + this.c.V);
            }
            if (!TextUtils.isEmpty(this.c.K0)) {
                map.put(QyRewardProperty.VERIFY_REWARD_MESSAGE, this.c.K0);
            }
            map.put(QyRewardProperty.RISK_LEVEL, Integer.valueOf(ug.a().a));
            this.B.a(map);
        }
    }

    public final void d() {
        if (this.x == null || this.Q.get()) {
            return;
        }
        j7 j7Var = this.D;
        if (!(j7Var != null && j7Var.c() && this.D.g() == 1) && this.a) {
            this.x.c();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.S = true;
            this.E = motionEvent.getX();
            this.F = motionEvent.getY();
            this.G = motionEvent.getX();
            this.H = motionEvent.getY();
            this.I = (int) motionEvent.getRawX();
            this.J = (int) motionEvent.getRawY();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void e() {
        try {
            if (this.T) {
                return;
            }
            cd cdVar = this.g;
            if (cdVar != null) {
                cdVar.animate().cancel();
                this.g.clearAnimation();
            }
            if (Build.VERSION.SDK_INT >= 23) {
                TransitionManager.endTransitions(this);
            }
            com.mcto.sspsdk.ssp.reward.a aVar = this.p;
            if (aVar != null) {
                aVar.dismiss();
            }
            gf gfVar = this.n;
            if (gfVar != null) {
                gfVar.b();
            }
            j7 j7Var = this.D;
            if (j7Var != null) {
                j7Var.destroy();
            }
            cd cdVar2 = this.g;
            if (cdVar2 != null) {
                cdVar2.b();
            }
            this.T = true;
        } catch (Exception e) {
            r9.a("ssp_reward", this.c, " destroy error", e);
        }
    }

    public final void f(int i) {
        if (this.Q.get() && i == 0) {
            return;
        }
        ImageView imageView = this.h;
        if (imageView != null && this.R) {
            imageView.setVisibility(i);
        }
        xc xcVar = this.l;
        if (xcVar != null) {
            xcVar.setVisibility(i);
        }
        TextView textView = this.m;
        if (textView != null) {
            textView.setVisibility(i);
        }
    }

    public final int g() {
        if (this.W > 0) {
            return (int) ((SystemClock.elapsedRealtime() - this.W) / 1000);
        }
        return 0;
    }

    public final boolean h() {
        return this.r == this.s;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [android.support.v7.app.AppCompatActivity, com.mcto.sspsdk.internal.o7] */
    /* JADX WARN: Type inference failed for: r3v14, types: [android.support.v7.app.AppCompatActivity, com.mcto.sspsdk.internal.o7] */
    public final void i() {
        if (this.c.L0.E == 1 && !this.P.get() && this.O.compareAndSet(false, true)) {
            HashMap map = new HashMap();
            map.put(QyRewardProperty.VERIFY_TYPE, QyRewardProperty.VERIFY_TYPE_REAL);
            map.put(QyRewardProperty.RISK_LEVEL, Integer.valueOf(ug.a().a));
            map.put(QyRewardProperty.VERIFY_IMPRESSIONID, this.c.n0);
            if (this.c.V > 0) {
                map.put(QyRewardProperty.VERIFY_REWARD_AMOUNT, "" + this.c.V);
            }
            if (!TextUtils.isEmpty(this.c.K0)) {
                map.put(QyRewardProperty.VERIFY_REWARD_MESSAGE, this.c.K0);
            }
            this.B.onRewardVerify(map);
        }
        if (this.c0.compareAndSet(false, true)) {
            int iG = g();
            HashMap map2 = new HashMap();
            StringBuilder sb = new StringBuilder("dur:");
            sb.append(iG).append(";");
            if (this.a0.get()) {
                sb.append("rwd:1;");
            }
            if (this.b0.get()) {
                sb.append("erwd:1;");
            }
            map2.put("extCustom", sb.toString());
            za.d().b(64, this.c, map2);
        }
        this.B.onAdClose();
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [android.support.v7.app.AppCompatActivity, com.mcto.sspsdk.internal.o7] */
    public final void j() {
        if (this.M.compareAndSet(false, true)) {
            this.W = SystemClock.elapsedRealtime();
            HashMap map = new HashMap(4);
            map.put(v5.KEY_VIEW_COORDINATE, gj.a(this));
            map.put(v5.KEY_AD_VIEW_RECT, getWidth() + "_" + getHeight());
            l lVarA = l.a();
            p pVar = this.c;
            lVarA.getClass();
            l.a(12, pVar, map);
            za.d().b(60, this.c, null);
            this.B.onAdShow();
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [android.support.v7.app.AppCompatActivity, com.mcto.sspsdk.internal.o7] */
    public void k() {
        d(0);
        f();
        l lVarA = l.a();
        p pVar = this.c;
        lVarA.getClass();
        l.a(18, pVar, null);
        l lVarA2 = l.a();
        p pVar2 = this.c;
        lVarA2.getClass();
        l.a(17, pVar2, null);
        this.B.onAdComplete();
    }

    public final void l() {
        re reVar;
        zj zjVarA = zj.a();
        p pVar = this.c;
        ke keVar = new ke(this);
        zjVarA.getClass();
        s7 s7Var = (s7) pVar.F.get("rwp");
        ArrayList arrayListB = s7Var != null ? s7Var.b(1, pVar) : null;
        if (arrayListB != null && !arrayListB.isEmpty()) {
            String str = (String) arrayListB.get(0);
            bg bgVar = new bg();
            bgVar.c = TapHttp.METHOD_GET;
            if (str != null) {
                bgVar.b = str;
            }
            bgVar.g = new int[]{5000, 10000, AdBaseConstants.DEFAULT_INSTALL_FINISH_TRY_INTERVAL_MS};
            bgVar.e = new xj(zjVarA, pVar, str, keVar);
            cg cgVar = new cg(bgVar);
            c7 c7VarA = c7.a();
            c7VarA.getClass();
            ih.a.a(new b7(c7VarA, cgVar));
            return;
        }
        p pVar2 = this.c;
        c cVar = this.f.T;
        synchronized (this) {
            reVar = this.C;
            if (reVar == null) {
                reVar = new re(this);
                this.C = reVar;
            }
        }
        m8 m8Var = new m8(this, pVar2, cVar, reVar);
        j7 j7Var = this.D;
        if (j7Var != null) {
            j7Var.destroy();
        }
        this.D = m8Var;
        m8Var.i();
        this.h0 = 5;
        this.g.a(5, this.z);
        fc.a(this.b, "金币下发失败，请点击下方按钮手动领取。", 3000);
        zj.a(68, pVar, "", null, null, "服务端没有下发url");
    }

    public void m() {
        this.R = true;
        f(0);
        j();
        l lVarA = l.a();
        p pVar = this.c;
        lVarA.getClass();
        l.a(13, pVar, null);
    }

    public void n() {
        View viewFindViewById = findViewById(R.id.qy_count_down_desc);
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(this);
        }
        View viewFindViewById2 = findViewById(R.id.qy_count_down_close);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(this);
        }
        View viewFindViewById3 = findViewById(R.id.qy_card_download_btn);
        if (viewFindViewById3 != null) {
            viewFindViewById3.setOnClickListener(this);
        }
        if (this.l != null) {
            setOnTouchListener(this.d0);
            this.g.setOnTouchListener(this.d0);
        } else {
            setOnClickListener(this);
            if (this.e == 1) {
                this.g.setOnClickListener(this);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r7v6, types: [android.support.v7.app.AppCompatActivity, com.mcto.sspsdk.internal.o7] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.L < 500) {
            return;
        }
        this.L = jCurrentTimeMillis;
        int id = view.getId();
        String str = this.Q.get() ? "cmpl_" : "";
        if (id == R.id.qy_trueview_view) {
            if (this.e == 0) {
                a4 a4Var = new a4();
                a4Var.a = view;
                a4Var.b = z3.CLICK_AREA_PLAYER;
                a4Var.c = str.concat("player");
                a4Var.e = gj.a(view);
                b(new b4(a4Var));
                return;
            }
            if (this.c.o()) {
                gf gfVar = this.n;
                if (gfVar.c) {
                    gfVar.c = false;
                    gfVar.a(8);
                    ImageView imageView = gfVar.y;
                    if (imageView != null) {
                        imageView.setVisibility(8);
                    }
                    gfVar.c();
                } else if (gfVar.s != null && (i = gfVar.a) != -1 && i != 0 && i != 1) {
                    gfVar.c = true;
                    ImageView imageView2 = gfVar.y;
                    if (imageView2 != null) {
                        imageView2.setVisibility(0);
                    }
                    gfVar.a();
                }
                this.w = gfVar.c;
                return;
            }
            return;
        }
        if (id == R.id.qy_video_voice_img) {
            if (this.v) {
                this.n.a(false);
                this.h.setImageResource(R.drawable.qy_ic_volume_on_with_bg);
                this.v = false;
                return;
            } else {
                this.n.a(true);
                this.h.setImageResource(R.drawable.qy_ic_volume_off_with_bg);
                this.v = true;
                return;
            }
        }
        if (id == R.id.qy_card_view) {
            if (this.e < 2) {
                a4 a4Var2 = new a4();
                a4Var2.a = view;
                a4Var2.b = z3.GRAPHIC;
                a4Var2.c = str.concat("graphic");
                a4Var2.e = gj.a(view);
                b(new b4(a4Var2));
                return;
            }
            return;
        }
        if (id == R.id.qy_card_download_btn) {
            a4 a4Var3 = new a4();
            a4Var3.a = view;
            a4Var3.b = (this.c.p() || (this.g instanceof gd)) ? z3.DIRECT_ACTION_BTN : z3.BUTTON;
            a4Var3.e = gj.a(view);
            a4Var3.c = str.concat("button");
            b(new b4(a4Var3));
            return;
        }
        if (id != R.id.qy_count_down_desc) {
            if (id == R.id.qy_count_down_close) {
                b(1);
            }
        } else if (this.P.get()) {
            if (h()) {
                b(0);
            } else {
                this.B.onAdSkip();
            }
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        j7 j7Var = this.D;
        if (j7Var == null || !j7Var.c()) {
            return;
        }
        this.D.f();
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            cd cdVar = this.g;
            if ((cdVar != null && cdVar.c()) || "0".equals(this.c.i().optString("canGoBack", "0"))) {
                return true;
            }
            b(1);
            return true;
        }
        if (i == 25) {
            if (((AudioManager) this.b.getSystemService(MediaFormat.KEY_AUDIO)).getStreamVolume(3) - 1 > 0) {
                this.n.a(false);
                this.h.setImageResource(R.drawable.qy_ic_volume_on_with_bg);
                this.v = false;
            } else {
                this.n.a(true);
                this.h.setImageResource(R.drawable.qy_ic_volume_off_with_bg);
                this.v = true;
            }
        } else if (i == 24) {
            this.n.a(false);
            this.h.setImageResource(R.drawable.qy_ic_volume_on_with_bg);
            this.v = false;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.support.constraint.ConstraintLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = this.g0;
        if (i3 == 11 || i3 == 14 || i3 == 1) {
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            if (size <= 0 || size2 <= 0 || size2 / size >= 1.7777777777777777d) {
                return;
            }
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.n.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            this.n.setLayoutParams(layoutParams);
        }
    }

    @Override // com.mcto.sspsdk.internal.sc, android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        j7 j7Var = this.D;
        if (j7Var != null) {
            if (z) {
                j7Var.d();
            } else {
                j7Var.e();
            }
        }
        cd cdVar = this.g;
        if (cdVar != null) {
            if (!z) {
                cdVar.e();
                return;
            }
            if (cdVar == null || !hasWindowFocus()) {
                return;
            }
            j7 j7Var2 = this.D;
            if (j7Var2 == null || !j7Var2.c()) {
                this.g.d();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v21, types: [android.support.v7.app.AppCompatActivity, com.mcto.sspsdk.internal.o7] */
    public final void d(int i) {
        this.P.set(true);
        j4 j4Var = this.i;
        if (j4Var.o <= 1) {
            j4Var.o = 1;
            j4Var.a(j4Var.f, j4Var.e);
        }
        if (!(i == 0 && this.c.L0.D == 1) && this.O.compareAndSet(false, true)) {
            if (this.a0.compareAndSet(false, true)) {
                int iG = g();
                HashMap map = new HashMap();
                StringBuilder sb = new StringBuilder("dur:");
                sb.append(iG).append(";f:");
                sb.append(i).append(";");
                map.put("extCustom", sb.toString());
                za.d().b(62, this.c, map);
            }
            if (this.c.q0 == 1) {
                c(i);
            }
            HashMap map2 = new HashMap();
            map2.put(QyRewardProperty.VERIFY_TYPE, QyRewardProperty.VERIFY_TYPE_REAL);
            map2.put(QyRewardProperty.RISK_LEVEL, Integer.valueOf(ug.a().a));
            map2.put(QyRewardProperty.VERIFY_IMPRESSIONID, this.c.n0);
            if (this.c.q0 == 1) {
                map2.put(QyRewardProperty.VERIFY_VIDEOID, this.q.getVideoId());
                map2.put(QyRewardProperty.VERIFY_ALBUMID, this.q.getAlbumId());
                HashMap map3 = this.c.i0;
                map2.put(QyRewardProperty.VERIFY_CHECK_INFO, map3 != null ? map3.get(ak.a(14)) : null);
            }
            if (this.c.V > 0) {
                map2.put(QyRewardProperty.VERIFY_REWARD_AMOUNT, "" + this.c.V);
            }
            if (!TextUtils.isEmpty(this.c.K0)) {
                map2.put(QyRewardProperty.VERIFY_REWARD_MESSAGE, this.c.K0);
            }
            this.B.onRewardVerify(map2);
        }
    }

    public final void f() {
        int i;
        ConstraintLayout.LayoutParams layoutParams;
        if (this.Q.compareAndSet(false, true)) {
            gf gfVar = this.n;
            if (gfVar != null) {
                gfVar.b();
            }
            f(4);
            this.g.a();
            j7 j7Var = this.D;
            if (j7Var != null) {
                j7Var.destroy();
            }
            a(100, true);
            j4 j4Var = this.i;
            if (j4Var.o != 2) {
                j4Var.o = 2;
                j4Var.a(j4Var.i, j4Var.h);
            }
            switch (j.a(this.g0)) {
                case 0:
                case 5:
                case 10:
                case 11:
                case 13:
                case 14:
                    this.g.setBackgroundColor(-1);
                    ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-1, 0);
                    int i2 = R.id.qy_trueview_view;
                    layoutParams2.topToBottom = i2;
                    layoutParams2.leftToLeft = i2;
                    layoutParams2.rightToRight = i2;
                    layoutParams2.dimensionRatio = "H,375:457";
                    this.g.setLayoutParams(layoutParams2);
                    hk.a(this.g, hk.a(this.b, 0.0f));
                    this.g.getBackground().setAlpha(MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA);
                    this.g.setTranslationX(0.0f);
                    this.g.setTranslationY(0.0f);
                    r0.a(this.g, "translationY", 0.0f, (-((getWidth() / 0.82f) + getContext().getResources().getDisplayMetrics().heightPixels)) / 2.0f, 500L);
                    break;
                case 1:
                    this.g.setBackgroundColor(-1);
                    ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(-1, 0);
                    layoutParams3.topToBottom = R.id.qy_trueview_player;
                    layoutParams3.bottomToBottom = R.id.qy_trueview_view;
                    this.g.setLayoutParams(layoutParams3);
                    ConstraintSet constraintSet = new ConstraintSet();
                    constraintSet.clone(this);
                    constraintSet.clear(R.id.qy_trueview_player);
                    constraintSet.constrainWidth(R.id.qy_trueview_player, this.b.getResources().getDisplayMetrics().widthPixels);
                    constraintSet.constrainHeight(R.id.qy_trueview_player, (this.b.getResources().getDisplayMetrics().widthPixels * 9) / 16);
                    constraintSet.connect(R.id.qy_trueview_player, 3, 0, 3);
                    constraintSet.connect(R.id.qy_trueview_player, 1, 0, 1);
                    constraintSet.connect(R.id.qy_trueview_player, 2, 0, 2);
                    constraintSet.setDimensionRatio(R.id.qy_trueview_player, "H,16:9");
                    constraintSet.applyTo(this);
                    this.g.setAlpha(0.0f);
                    AutoTransition autoTransition = new AutoTransition();
                    autoTransition.setDuration(500L);
                    autoTransition.addTarget(R.id.qy_trueview_player);
                    autoTransition.addListener((Transition.TransitionListener) new oe(this));
                    TransitionManager.beginDelayedTransition(this, autoTransition);
                    break;
                case 2:
                case 3:
                case 15:
                case 16:
                    this.g.setBackgroundColor(-1);
                    ConstraintLayout.LayoutParams layoutParams4 = new ConstraintLayout.LayoutParams(hk.a(this.b, 307.0f), 0);
                    int i3 = R.id.qy_trueview_view;
                    layoutParams4.leftToRight = i3;
                    layoutParams4.topToTop = i3;
                    layoutParams4.bottomToBottom = i3;
                    this.g.getBackground().setAlpha(MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA);
                    this.g.setLayoutParams(layoutParams4);
                    this.g.setTranslationX(0.0f);
                    this.g.setTranslationY(0.0f);
                    r0.a(this.g, "translationX", 0.0f, -hk.a(this.b, 307.0f), 500L);
                    break;
                case 4:
                case 6:
                case 7:
                case 8:
                case 9:
                    this.g.setBackgroundColor(-1);
                    break;
                case 12:
                case 17:
                    this.g.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
                    this.g.setBackgroundColor(ContextCompat.getColor(this.b, R.color.qy_dialog_bg));
                    this.g.setTranslationX(0.0f);
                    break;
                case 18:
                case 19:
                    hk.a(this.g, hk.a(this.b, 0.0f));
                    if (this.d == 2) {
                        layoutParams = new ConstraintLayout.LayoutParams(hk.a(this.b, 351.0f), -1);
                        layoutParams.rightToRight = R.id.qy_trueview_view;
                    } else {
                        layoutParams = new ConstraintLayout.LayoutParams(-1, hk.a(this.b, 330.0f));
                    }
                    int i4 = R.id.qy_trueview_view;
                    layoutParams.topToTop = i4;
                    layoutParams.bottomToBottom = i4;
                    this.g.setLayoutParams(layoutParams);
                    break;
            }
            this.g.a(8, this.g0);
            e(-1);
            if (!h() && (i = this.c.L0.M) > 0) {
                long j = ((long) i) * 1000;
                ne neVar = new ne(this, j, j);
                this.y = neVar;
                synchronized (neVar) {
                    neVar.c();
                }
            }
            this.i.bringToFront();
            ProgressBar progressBar = this.o;
            if (progressBar != null) {
                progressBar.bringToFront();
            }
            TextView textView = this.j;
            if (textView != null) {
                textView.bringToFront();
            }
            a("cmpl");
        }
        j();
    }

    public final void e(int i) {
        int i2;
        re reVar;
        cd cdVar;
        if (i == -1 || (i - this.K >= 2 && !this.P.get())) {
            HashMap map = this.f.K;
            a aVar = map != null ? (a) map.get(Integer.valueOf(i)) : null;
            if (aVar != null) {
                if (i == -1) {
                    i2 = -1;
                } else {
                    int i3 = this.A;
                    i2 = (i3 <= 0 || i < i3) ? 0 : 1;
                }
                j7 j7Var = this.D;
                if (j7Var != null) {
                    j7Var.destroy();
                }
                synchronized (this) {
                    re reVar2 = this.C;
                    if (reVar2 != null) {
                        reVar = reVar2;
                    } else {
                        re reVar3 = new re(this);
                        this.C = reVar3;
                        reVar = reVar3;
                    }
                }
                long j = this.V;
                if (j <= 0) {
                    j = aVar.r;
                }
                int i4 = aVar.a;
                if (i4 == 1) {
                    this.D = new p8(this, this.c, i2, this.q.c(), aVar, reVar);
                } else if (i4 == 3) {
                    this.D = new d9(this, this.c, i2, this.q.c(), aVar, reVar);
                } else if (i4 == 4) {
                    this.D = new u8(this, this.c, j, aVar, reVar);
                } else if (i4 == 5) {
                    this.D = new k8(this, this.c, j, aVar, reVar);
                } else if (i4 == 6) {
                    this.D = new x8(this, this.c, j, aVar, reVar);
                }
                this.K = i;
                this.D.a();
            }
        }
        int iA = this.f.a(i);
        if (iA == 0 || (cdVar = this.g) == null) {
            return;
        }
        cdVar.a(iA);
    }

    public final void c(b4 b4Var) {
        String str;
        HashMap map = new HashMap();
        StringBuilder sb = new StringBuilder("dur:");
        sb.append(g()).append(";");
        long j = b4Var.m / 1000;
        if (j > 0) {
            sb.append("ddur:").append(j).append(";");
        }
        StringBuilder sbAppend = sb.append("cla:");
        if (TextUtils.isEmpty(b4Var.b)) {
            str = b4Var.a.a;
        } else {
            str = b4Var.b;
        }
        sbAppend.append(str).append(";");
        map.put("extCustom", sb.toString());
        za.d().b(61, this.c, map);
    }

    public final void b(int i) {
        if (h()) {
            if (i == 0 && ((this.Q.get() && this.c.L0.C == 1) || (!this.Q.get() && this.P.get() && this.c.L0.B == 1))) {
                a4 a4Var = new a4();
                j4 j4Var = this.i;
                a4Var.a = j4Var;
                a4Var.b = z3.GRAPHIC;
                a4Var.e = gj.a(j4Var);
                b(new b4(a4Var));
                return;
            }
            if (this.O.get()) {
                i();
                return;
            } else if (this.P.get()) {
                d(1);
                i();
                return;
            }
        }
        this.p = new com.mcto.sspsdk.ssp.reward.a(this.b);
        j7 j7Var = this.D;
        if (j7Var != null && j7Var.c() && this.D.b() != null) {
            com.mcto.sspsdk.ssp.reward.a aVar = this.p;
            aVar.c = 4;
            p pVar = this.c;
            d dVarB = this.D.b();
            aVar.b = pVar;
            aVar.h = dVarB;
        } else {
            com.mcto.sspsdk.ssp.reward.a aVar2 = this.p;
            p pVar2 = this.c;
            aVar2.c = ((pVar2.n() ? 0 : pVar2.o0) == 0 || this.e == 2) ? 0 : 1;
            com.mcto.sspsdk.ssp.reward.a aVar3 = this.p;
            p pVar3 = this.c;
            d dVar = this.f.I;
            aVar3.b = pVar3;
            aVar3.h = dVar;
        }
        j7 j7Var2 = this.D;
        if (j7Var2 != null && j7Var2.c()) {
            com.mcto.sspsdk.ssp.reward.a aVar4 = this.p;
            String strH = this.D.h();
            aVar4.getClass();
            if (!TextUtils.isEmpty(strH)) {
                aVar4.i = "edg_" + strH;
            }
        }
        com.mcto.sspsdk.ssp.reward.a aVar5 = this.p;
        if (this.e0 == null) {
            this.e0 = new qe(this);
        }
        aVar5.a = this.e0;
        int i2 = this.r;
        int i3 = this.u;
        aVar5.e = i2;
        aVar5.d = i3;
        aVar5.show();
        a(this.p.i);
    }

    @Override // com.mcto.sspsdk.internal.sc
    public void b() {
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        d();
        ne neVar = this.y;
        if (neVar != null) {
            synchronized (neVar) {
                neVar.c();
            }
        }
        j();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.U;
        long j2 = jElapsedRealtime - j;
        if (j == 0) {
            return;
        }
        this.U = 0L;
        e eVar = this.f;
        if (eVar.U == 1) {
            long j3 = this.V - j2;
            if (j3 < 1000) {
                this.V = 0L;
                if (this.h0 != 3) {
                    this.h0 = 3;
                    this.g.a(3, this.V);
                    l();
                    if (this.b0.compareAndSet(false, true)) {
                        int iG = g();
                        HashMap map = new HashMap();
                        StringBuilder sb = new StringBuilder("dur:");
                        sb.append(iG).append(";f:2;");
                        map.put("extCustom", sb.toString());
                        za.d().b(63, this.c, map);
                    }
                }
                d(2);
                return;
            }
            this.V = j3;
            fc.a(this.b, eVar.Q.replace("%nrt", ((int) Math.ceil(this.V / 1000.0d)) + "秒"), 3000);
            this.g.a(2, this.V);
        }
    }

    public final void a(int i, boolean z) {
        if (this.o == null) {
            return;
        }
        int iMin = Math.min(i, 100);
        if (z) {
            this.o.setSecondaryProgress(iMin);
        } else {
            this.o.setProgress(iMin);
        }
    }

    public void a(j7 j7Var) {
        a(j7Var.h());
    }

    @Override // com.mcto.sspsdk.internal.sc
    public final void a() {
        if (this.U > 0 && SystemClock.elapsedRealtime() - this.U > 3000) {
            this.U = 0L;
        }
        cd cdVar = this.g;
        if (cdVar != null) {
            cdVar.animate().cancel();
            this.g.clearAnimation();
        }
        le leVar = this.x;
        if (leVar != null) {
            leVar.a();
        }
        ne neVar = this.y;
        if (neVar != null) {
            neVar.a();
        }
    }

    public static void a(ve veVar) {
        re reVar;
        p pVar = veVar.c;
        c cVar = veVar.f.T;
        synchronized (veVar) {
            reVar = veVar.C;
            if (reVar == null) {
                reVar = new re(veVar);
                veVar.C = reVar;
            }
        }
        m8 m8Var = new m8(veVar, pVar, cVar, reVar);
        j7 j7Var = veVar.D;
        if (j7Var != null) {
            j7Var.destroy();
        }
        veVar.D = m8Var;
        m8Var.i();
    }

    public final void a(String str) {
        HashMap map = new HashMap();
        StringBuilder sb = new StringBuilder("dur:");
        sb.append(g()).append(";type:");
        sb.append(str).append(";");
        map.put("extCustom", sb.toString());
        za.d().b(69, this.c, map);
    }
}
