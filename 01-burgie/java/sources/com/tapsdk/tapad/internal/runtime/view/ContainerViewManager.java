package com.tapsdk.tapad.internal.runtime.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.LayoutTransition;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class ContainerViewManager extends BaseViewManager<FrameLayout, ContainerViewProps> {
    private static final int HEIGHT_ANIMATION_DURATION_MS = 300;
    public static final String NAME = "container";
    public static final int VIEW_TYPE = 0;
    private final float mDensity;
    private final WeakHashMap<FrameLayout, HeightAnimationState> mHeightAnimationStates = new WeakHashMap<>();

    public static final class HeightAnimationState {
        ValueAnimator animator;
        int expandedHeight;
        int expandedTopMargin;
        boolean targetCollapsed;

        public HeightAnimationState(int i, int i2) {
            this.expandedHeight = i;
            this.expandedTopMargin = i2;
        }
    }

    public ContainerViewManager(Context context) {
        this.mDensity = context.getResources().getDisplayMetrics().density;
    }

    private void animateHeight(final FrameLayout frameLayout, String str) {
        int i;
        if (str == null || str.isEmpty()) {
            return;
        }
        try {
            float f = Float.parseFloat(str);
            int iDp2px = dp2px(Math.abs(f), this.mDensity);
            boolean z = f < 0.0f;
            ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
            final int height = (layoutParams == null || (i = layoutParams.height) <= 0) ? frameLayout.getHeight() : i;
            if (height <= 0) {
                return;
            }
            final int i2 = layoutParams instanceof FrameLayout.LayoutParams ? ((FrameLayout.LayoutParams) layoutParams).topMargin : 0;
            final HeightAnimationState heightAnimationState = this.mHeightAnimationStates.get(frameLayout);
            if (heightAnimationState == null) {
                heightAnimationState = new HeightAnimationState(height, i2);
                this.mHeightAnimationStates.put(frameLayout, heightAnimationState);
            } else if (z && !heightAnimationState.targetCollapsed && heightAnimationState.animator == null) {
                heightAnimationState.expandedHeight = height;
                heightAnimationState.expandedTopMargin = i2;
            }
            ValueAnimator valueAnimator = heightAnimationState.animator;
            if (valueAnimator != null) {
                heightAnimationState.animator = null;
                valueAnimator.cancel();
            }
            final int iMax = z ? Math.max(0, heightAnimationState.expandedHeight - iDp2px) : heightAnimationState.expandedHeight;
            final int i3 = z ? heightAnimationState.expandedTopMargin + iDp2px : heightAnimationState.expandedTopMargin;
            heightAnimationState.targetCollapsed = z;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat.setDuration(300L);
            valueAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tapsdk.tapad.internal.runtime.view.ContainerViewManager$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    ContainerViewManager.lambda$animateHeight$0(height, iMax, i2, i3, frameLayout, valueAnimator2);
                }
            });
            valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.tapsdk.tapad.internal.runtime.view.ContainerViewManager.1
                private void clearIfCurrent(Animator animator) {
                    HeightAnimationState heightAnimationState2 = heightAnimationState;
                    if (heightAnimationState2.animator == animator) {
                        heightAnimationState2.animator = null;
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    clearIfCurrent(animator);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    clearIfCurrent(animator);
                }
            });
            heightAnimationState.animator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.start();
        } catch (NumberFormatException e) {
        }
    }

    static /* synthetic */ void lambda$animateHeight$0(int i, int i2, int i3, int i4, FrameLayout frameLayout, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        int i5 = (int) (((i2 - i) * fFloatValue) + i);
        int i6 = (int) (((i4 - i3) * fFloatValue) + i3);
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        layoutParams.height = i5;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).topMargin = i6;
        }
        frameLayout.setLayoutParams(layoutParams);
    }

    @Override // com.tapsdk.tapad.internal.runtime.view.ViewManager
    public String getName() {
        return NAME;
    }

    @Override // com.tapsdk.tapad.internal.runtime.view.ViewManager
    public Class<ContainerViewProps> getPropsClass() {
        return ContainerViewProps.class;
    }

    @Override // com.tapsdk.tapad.internal.runtime.view.ViewManager
    public int getViewType() {
        return 0;
    }

    @Override // com.tapsdk.tapad.internal.runtime.view.ViewManager
    public FrameLayout createView(Context context, String str) {
        return new FrameLayout(context);
    }

    @Override // com.tapsdk.tapad.internal.runtime.view.ViewManager
    public void setStyle(FrameLayout frameLayout, String str, String str2) {
        if (applyBaseStyle(frameLayout, str, str2, this.mDensity)) {
            return;
        }
        str.getClass();
        boolean z = true;
        switch (str) {
            case "height_animate":
                animateHeight(frameLayout, str2);
                break;
            case "animateLayoutChanges":
                if (!"true".equals(str2) && !"1".equals(str2)) {
                    frameLayout.setLayoutTransition(null);
                    break;
                } else {
                    frameLayout.setLayoutTransition(new LayoutTransition());
                    break;
                }
                break;
            case "clipChildren":
                if (!"true".equals(str2) && !"1".equals(str2)) {
                    z = false;
                }
                frameLayout.setClipChildren(z);
                frameLayout.setClipToPadding(z);
                break;
        }
    }

    @Override // com.tapsdk.tapad.internal.runtime.view.ViewManager
    public void updateProps(FrameLayout frameLayout, ContainerViewProps containerViewProps) {
        if (containerViewProps == null) {
            return;
        }
        applyBaseProps(frameLayout, containerViewProps, this.mDensity);
        Boolean bool = containerViewProps.clipChildren;
        if (bool != null) {
            frameLayout.setClipChildren(bool.booleanValue());
            frameLayout.setClipToPadding(containerViewProps.clipChildren.booleanValue());
        }
        if (Boolean.TRUE.equals(containerViewProps.animateLayoutChanges)) {
            frameLayout.setLayoutTransition(new LayoutTransition());
        } else if (Boolean.FALSE.equals(containerViewProps.animateLayoutChanges)) {
            frameLayout.setLayoutTransition(null);
        }
        String str = containerViewProps.heightAnimate;
        if (str != null) {
            animateHeight(frameLayout, str);
        }
    }
}
