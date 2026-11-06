package com.anythink.basead.ui.guidetoclickv2;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.SeekBar;
import com.anythink.basead.ui.guidetoclickv2.picverify.TextSeekbar;
import com.anythink.core.common.d.t;
import com.anythink.core.common.res.e;
import com.anythink.core.common.v.g;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class PuzzleV2G2CV2View extends BaseLifecycleG2CV2View {
    ImageView d;
    ImageView e;
    ImageView f;
    ImageView g;
    int h;
    Animation i;
    TextSeekbar j;
    int k;
    boolean l;
    ValueAnimator m;
    int n;
    private boolean o;
    private final int p;
    private final int q;

    static /* synthetic */ int a(int i) {
        if (i < 15) {
            return 0;
        }
        if (i > 85) {
            return 100;
        }
        return (i - 15) * 1;
    }

    private static int d(int i) {
        if (i < 15) {
            return 0;
        }
        if (i > 85) {
            return 100;
        }
        return (i - 15) * 1;
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseLifecycleG2CV2View
    final int e() {
        return 45;
    }

    public PuzzleV2G2CV2View(Context context) {
        super(context);
        this.p = 30;
        this.n = -1;
        this.q = 300;
    }

    public PuzzleV2G2CV2View(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.p = 30;
        this.n = -1;
        this.q = 300;
    }

    public PuzzleV2G2CV2View(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.p = 30;
        this.n = -1;
        this.q = 300;
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    final void a(int i, int i2) {
        LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_g2c_v2_puzzle_v2", "layout"), this);
        setBackgroundColor(Color.parseColor("#80000000"));
        this.d = (ImageView) findViewById(q.a(getContext(), "myoffer_g2c_item_close_iv", "id"));
        this.e = (ImageView) findViewById(q.a(getContext(), "myoffer_g2c_item_lucky_bag_iv", "id"));
        this.f = (ImageView) findViewById(q.a(getContext(), "myoffer_g2c_item_lucky_bag_mask_iv", "id"));
        this.g = (ImageView) findViewById(q.a(getContext(), "myoffer_g2c_item_g2c_finger", "id"));
        if (this.e != null) {
            String strA = g.a().a(com.anythink.core.common.a.b.d.l);
            if (!TextUtils.isEmpty(strA)) {
                com.anythink.core.common.res.b.a(t.b().g()).a(new e(3, strA), new com.anythink.core.common.res.b.a() { // from class: com.anythink.basead.ui.guidetoclickv2.PuzzleV2G2CV2View.1
                    @Override // com.anythink.core.common.res.b.a
                    public final void onFail(String str, String str2) {
                    }

                    @Override // com.anythink.core.common.res.b.a
                    public final void onSuccess(String str, Bitmap bitmap) {
                        if (PuzzleV2G2CV2View.this.e != null) {
                            PuzzleV2G2CV2View.this.e.setImageBitmap(bitmap);
                        }
                    }
                });
            }
        }
        if (this.g != null) {
            String strA2 = g.a().a(com.anythink.core.common.a.b.d.k);
            if (!TextUtils.isEmpty(strA2)) {
                com.anythink.core.common.res.b.a(t.b().g()).a(new e(3, strA2), new com.anythink.core.common.res.b.a() { // from class: com.anythink.basead.ui.guidetoclickv2.PuzzleV2G2CV2View.2
                    @Override // com.anythink.core.common.res.b.a
                    public final void onFail(String str, String str2) {
                    }

                    @Override // com.anythink.core.common.res.b.a
                    public final void onSuccess(String str, Bitmap bitmap) {
                        if (PuzzleV2G2CV2View.this.g != null) {
                            PuzzleV2G2CV2View.this.g.setImageBitmap(bitmap);
                        }
                    }
                });
            }
        }
        this.h = q.a(getContext(), 20.0f);
        this.k = q.a(getContext(), 176.0f);
        TextSeekbar textSeekbar = (TextSeekbar) findViewById(q.a(getContext(), "myoffer_g2c_picvertify_seekbar", "id"));
        this.j = textSeekbar;
        if (textSeekbar != null) {
            textSeekbar.hideAll();
            this.j.setProgressDrawable(null);
            this.j.setThumb(null);
            this.j.setThumbOffset(0);
            this.j.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.anythink.basead.ui.guidetoclickv2.PuzzleV2G2CV2View.3
                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public final void onProgressChanged(SeekBar seekBar, int i3, boolean z) {
                    int iA = PuzzleV2G2CV2View.a(i3);
                    if (z) {
                        if (PuzzleV2G2CV2View.this.l) {
                            PuzzleV2G2CV2View.this.l = false;
                            if (iA > 30) {
                                PuzzleV2G2CV2View.this.o = false;
                            } else {
                                PuzzleV2G2CV2View.this.o = true;
                            }
                        }
                        if (!PuzzleV2G2CV2View.this.o) {
                            seekBar.setProgress(0);
                            return;
                        } else if (iA > 30) {
                            PuzzleV2G2CV2View.a(PuzzleV2G2CV2View.this, i3);
                            return;
                        } else {
                            PuzzleV2G2CV2View.b(PuzzleV2G2CV2View.this, iA);
                            return;
                        }
                    }
                    PuzzleV2G2CV2View.b(PuzzleV2G2CV2View.this, iA);
                    if (iA == 100 && i3 == 100) {
                        PuzzleV2G2CV2View.b(PuzzleV2G2CV2View.this);
                    }
                }

                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public final void onStartTrackingTouch(SeekBar seekBar) {
                    PuzzleV2G2CV2View.this.l = true;
                    if (PuzzleV2G2CV2View.this.g != null) {
                        PuzzleV2G2CV2View.this.g.setVisibility(8);
                    }
                    if (PuzzleV2G2CV2View.this.i != null) {
                        PuzzleV2G2CV2View.this.i.cancel();
                    }
                }

                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public final void onStopTrackingTouch(SeekBar seekBar) {
                    if (PuzzleV2G2CV2View.this.o) {
                        PuzzleV2G2CV2View.b(PuzzleV2G2CV2View.this, 0);
                        if (PuzzleV2G2CV2View.this.g != null) {
                            PuzzleV2G2CV2View.this.g.setVisibility(0);
                        }
                        if (PuzzleV2G2CV2View.this.i != null) {
                            PuzzleV2G2CV2View.this.i.start();
                        }
                    }
                }
            });
        }
        ImageView imageView = this.d;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.guidetoclickv2.PuzzleV2G2CV2View.4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PuzzleV2G2CV2View.this.c();
                }
            });
        }
        if (this.i != null || this.g == null) {
            return;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, this.h, 0.0f, 0.0f);
        this.i = translateAnimation;
        translateAnimation.setDuration(1000L);
        this.i.setRepeatCount(-1);
        this.g.startAnimation(this.i);
    }

    private void f() {
        removeAllViews();
        d();
    }

    private void g() {
        if (this.i != null || this.g == null) {
            return;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, this.h, 0.0f, 0.0f);
        this.i = translateAnimation;
        translateAnimation.setDuration(1000L);
        this.i.setRepeatCount(-1);
        this.g.startAnimation(this.i);
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseLifecycleG2CV2View, com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    protected final void a() {
        super.a();
        Animation animation = this.i;
        if (animation != null) {
            animation.start();
        }
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseLifecycleG2CV2View, com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    protected final void b() {
        super.b();
        Animation animation = this.i;
        if (animation != null) {
            animation.cancel();
        }
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseLifecycleG2CV2View, com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    public void release() {
        super.release();
        Animation animation = this.i;
        if (animation != null) {
            animation.cancel();
        }
    }

    private void b(int i) {
        ImageView imageView = this.e;
        if (imageView != null) {
            imageView.setTranslationX((i * this.k) / 100);
        }
    }

    private void c(int i) {
        TextSeekbar textSeekbar = this.j;
        if (textSeekbar != null) {
            textSeekbar.setClickable(false);
            this.j.setEnabled(false);
            if (this.m == null) {
                ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i, 100);
                this.m = valueAnimatorOfInt;
                valueAnimatorOfInt.addUpdateListener(new AnonymousClass5());
                this.m.setDuration(300L);
                this.m.start();
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.guidetoclickv2.PuzzleV2G2CV2View$5, reason: invalid class name */
    final class AnonymousClass5 implements ValueAnimator.AnimatorUpdateListener {
        AnonymousClass5() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (PuzzleV2G2CV2View.this.n != iIntValue) {
                PuzzleV2G2CV2View.this.n = iIntValue;
                PuzzleV2G2CV2View.this.j.setProgress(iIntValue);
            }
        }
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    public boolean canStartNextAnim() {
        ValueAnimator valueAnimator = this.m;
        return valueAnimator == null || !valueAnimator.isRunning();
    }

    static /* synthetic */ void a(PuzzleV2G2CV2View puzzleV2G2CV2View, int i) {
        TextSeekbar textSeekbar = puzzleV2G2CV2View.j;
        if (textSeekbar != null) {
            textSeekbar.setClickable(false);
            puzzleV2G2CV2View.j.setEnabled(false);
            if (puzzleV2G2CV2View.m == null) {
                ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i, 100);
                puzzleV2G2CV2View.m = valueAnimatorOfInt;
                valueAnimatorOfInt.addUpdateListener(puzzleV2G2CV2View.new AnonymousClass5());
                puzzleV2G2CV2View.m.setDuration(300L);
                puzzleV2G2CV2View.m.start();
            }
        }
    }

    static /* synthetic */ void b(PuzzleV2G2CV2View puzzleV2G2CV2View, int i) {
        ImageView imageView = puzzleV2G2CV2View.e;
        if (imageView != null) {
            imageView.setTranslationX((i * puzzleV2G2CV2View.k) / 100);
        }
    }

    static /* synthetic */ void b(PuzzleV2G2CV2View puzzleV2G2CV2View) {
        puzzleV2G2CV2View.removeAllViews();
        puzzleV2G2CV2View.d();
    }
}
