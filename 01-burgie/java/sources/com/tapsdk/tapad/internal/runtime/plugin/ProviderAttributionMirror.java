package com.tapsdk.tapad.internal.runtime.plugin;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class ProviderAttributionMirror {
    private AttributionBitmapInstaller bitmapInstaller;
    private final Map<View, Integer> hiddenSources = new IdentityHashMap();
    private final FrameLayout hostRoot;
    private ProviderTagCapture providerTagCapture;
    private boolean released;
    private final ProviderAttributionSlots slots;

    public final class AttributionBitmapInstaller implements ProviderAttributionSlots.Listener {
        private final Bitmap bitmap;
        private final boolean owned;
        private final View source;
        private final Map<ViewGroup, SlotState> slotStates = new IdentityHashMap();
        private final Map<View, Integer> fallbackVisibility = new IdentityHashMap();

        public AttributionBitmapInstaller(Bitmap bitmap, boolean z, View view) {
            this.bitmap = bitmap;
            this.owned = z;
            this.source = view;
        }

        public boolean hasCurrentMirror() {
            Iterator<ViewGroup> it = ProviderAttributionMirror.this.slots.snapshot().iterator();
            while (it.hasNext()) {
                if (this.slotStates.containsKey(it.next())) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.tapsdk.tapad.internal.runtime.plugin.ProviderAttributionSlots.Listener
        public void onSlotAvailable(ViewGroup viewGroup) {
            if (viewGroup == null || this.bitmap.isRecycled()) {
                return;
            }
            if (!this.slotStates.containsKey(viewGroup)) {
                this.slotStates.put(viewGroup, new SlotState(viewGroup));
            }
            viewGroup.setBackgroundColor(0);
            viewGroup.setPadding(0, 0, 0, 0);
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ProviderAttributionImageView) {
                    viewGroup.removeViewAt(childCount);
                } else {
                    if (!this.fallbackVisibility.containsKey(childAt)) {
                        this.fallbackVisibility.put(childAt, Integer.valueOf(childAt.getVisibility()));
                    }
                    childAt.setVisibility(4);
                }
            }
            ProviderAttributionImageView providerAttributionImageView = new ProviderAttributionImageView(viewGroup.getContext());
            providerAttributionImageView.setImageBitmap(this.bitmap);
            providerAttributionImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            providerAttributionImageView.setAdjustViewBounds(false);
            providerAttributionImageView.setContentDescription("provider attribution");
            viewGroup.addView(providerAttributionImageView, new ViewGroup.LayoutParams(-1, -1));
            ProviderAttributionMirror.this.hideSource(this.source);
        }

        public void release() {
            for (Map.Entry<ViewGroup, SlotState> entry : this.slotStates.entrySet()) {
                ViewGroup key = entry.getKey();
                for (int childCount = key.getChildCount() - 1; childCount >= 0; childCount--) {
                    View childAt = key.getChildAt(childCount);
                    if (childAt instanceof ProviderAttributionImageView) {
                        key.removeViewAt(childCount);
                    } else if (this.fallbackVisibility.containsKey(childAt)) {
                        childAt.setVisibility(this.fallbackVisibility.get(childAt).intValue());
                    }
                }
                entry.getValue().restore(key);
            }
            this.slotStates.clear();
            this.fallbackVisibility.clear();
            if (!this.owned || this.bitmap.isRecycled()) {
                return;
            }
            this.bitmap.recycle();
        }
    }

    public static final class ProviderAttributionImageView extends ImageView {
        public ProviderAttributionImageView(Context context) {
            super(context);
        }
    }

    public final class ProviderTagCapture implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener, Runnable {
        private final View providerTag;
        private boolean registered;
        private boolean stopped;

        public ProviderTagCapture(View view) {
            this.providerTag = view;
        }

        private void captureIfReady() {
            if (this.stopped || this.providerTag.getWidth() <= 0 || this.providerTag.getHeight() <= 0) {
                return;
            }
            try {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.providerTag.getWidth(), this.providerTag.getHeight(), Bitmap.Config.ARGB_8888);
                this.providerTag.draw(new Canvas(bitmapCreateBitmap));
                if (!ProviderAttributionMirror.hasVisiblePixels(bitmapCreateBitmap)) {
                    bitmapCreateBitmap.recycle();
                } else if (ProviderAttributionMirror.this.applyBitmap(bitmapCreateBitmap, true, this.providerTag)) {
                    stop();
                }
            } catch (Throwable th) {
            }
        }

        private void registerPreDraw() {
            if (this.registered || this.stopped) {
                return;
            }
            ViewTreeObserver viewTreeObserver = this.providerTag.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnPreDrawListener(this);
                this.registered = true;
            }
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            captureIfReady();
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            registerPreDraw();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            stop();
        }

        @Override // java.lang.Runnable
        public void run() {
            captureIfReady();
        }

        public void start() {
            this.providerTag.addOnAttachStateChangeListener(this);
            registerPreDraw();
            this.providerTag.post(this);
        }

        public void stop() {
            if (this.stopped) {
                return;
            }
            this.stopped = true;
            this.providerTag.removeCallbacks(this);
            this.providerTag.removeOnAttachStateChangeListener(this);
            ViewTreeObserver viewTreeObserver = this.providerTag.getViewTreeObserver();
            if (this.registered && viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this);
            }
            this.registered = false;
        }
    }

    public static final class SlotState {
        private final Drawable background;
        private final int paddingBottom;
        private final int paddingLeft;
        private final int paddingRight;
        private final int paddingTop;

        public SlotState(ViewGroup viewGroup) {
            Drawable background = viewGroup.getBackground();
            Drawable.ConstantState constantState = background == null ? null : background.getConstantState();
            this.background = constantState != null ? constantState.newDrawable(viewGroup.getResources()).mutate() : background;
            this.paddingLeft = viewGroup.getPaddingLeft();
            this.paddingTop = viewGroup.getPaddingTop();
            this.paddingRight = viewGroup.getPaddingRight();
            this.paddingBottom = viewGroup.getPaddingBottom();
        }

        public void restore(ViewGroup viewGroup) {
            viewGroup.setBackground(this.background);
            viewGroup.setPadding(this.paddingLeft, this.paddingTop, this.paddingRight, this.paddingBottom);
        }
    }

    public ProviderAttributionMirror(FrameLayout frameLayout, ProviderAttributionSlots providerAttributionSlots) {
        if (frameLayout == null) {
            throw new IllegalArgumentException("missing provider attribution host");
        }
        this.hostRoot = frameLayout;
        this.slots = providerAttributionSlots == null ? new ProviderAttributionSlots() : providerAttributionSlots;
    }

    private int dp(int i) {
        return Math.max(1, Math.round(i * this.hostRoot.getResources().getDisplayMetrics().density));
    }

    private View findDirectChild(FrameLayout.LayoutParams layoutParams) {
        ViewGroup.LayoutParams layoutParams2;
        View view = null;
        for (int i = 0; i < this.hostRoot.getChildCount(); i++) {
            View childAt = this.hostRoot.getChildAt(i);
            if ((!(childAt instanceof ViewGroup) || !this.slots.contains((ViewGroup) childAt)) && ((layoutParams2 = childAt.getLayoutParams()) == layoutParams || ((layoutParams2 instanceof FrameLayout.LayoutParams) && sameInitialPlacement((FrameLayout.LayoutParams) layoutParams2, layoutParams)))) {
                view = childAt;
            }
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hasVisiblePixels(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width > 0 && height > 0) {
            int i = width * height;
            int[] iArr = new int[i];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            for (int i2 = 0; i2 < i; i2++) {
                if (Color.alpha(iArr[i2]) != 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideSource(View view) {
        if (view == null) {
            return;
        }
        if (!this.hiddenSources.containsKey(view)) {
            this.hiddenSources.put(view, Integer.valueOf(view.getVisibility()));
        }
        view.setVisibility(4);
    }

    private void replaceInstaller(AttributionBitmapInstaller attributionBitmapInstaller) {
        AttributionBitmapInstaller attributionBitmapInstaller2 = this.bitmapInstaller;
        if (attributionBitmapInstaller2 != null) {
            this.slots.removeListener(attributionBitmapInstaller2);
            attributionBitmapInstaller2.release();
        }
        this.bitmapInstaller = attributionBitmapInstaller;
        if (attributionBitmapInstaller != null) {
            this.slots.addListener(attributionBitmapInstaller);
        }
    }

    private static boolean sameInitialPlacement(FrameLayout.LayoutParams layoutParams, FrameLayout.LayoutParams layoutParams2) {
        return layoutParams.width == layoutParams2.width && layoutParams.height == layoutParams2.height && layoutParams.gravity == layoutParams2.gravity && layoutParams.leftMargin == layoutParams2.leftMargin && layoutParams.topMargin == layoutParams2.topMargin && layoutParams.rightMargin == layoutParams2.rightMargin && layoutParams.bottomMargin == layoutParams2.bottomMargin;
    }

    private void stopCapture() {
        ProviderTagCapture providerTagCapture = this.providerTagCapture;
        if (providerTagCapture != null) {
            providerTagCapture.stop();
            this.providerTagCapture = null;
        }
    }

    public boolean applyBitmap(Bitmap bitmap) {
        return applyBitmap(bitmap, false, null);
    }

    public boolean attachView(FrameLayout.LayoutParams layoutParams) {
        if (this.released || layoutParams == null) {
            return false;
        }
        return attachView(findDirectChild(layoutParams));
    }

    public FrameLayout.LayoutParams createLayoutParams(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dp(Math.max(1, i)), dp(Math.max(1, i2)));
        layoutParams.gravity = 53;
        layoutParams.topMargin = dp(20);
        layoutParams.rightMargin = dp(20);
        return layoutParams;
    }

    public List<ViewGroup> getSlots() {
        return this.slots.snapshot();
    }

    public void release() {
        if (this.released) {
            return;
        }
        this.released = true;
        stopCapture();
        replaceInstaller(null);
        for (Map.Entry<View, Integer> entry : this.hiddenSources.entrySet()) {
            entry.getKey().setVisibility(entry.getValue().intValue());
        }
        this.hiddenSources.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean applyBitmap(Bitmap bitmap, boolean z, View view) {
        if (!this.released && bitmap != null && !bitmap.isRecycled() && hasVisiblePixels(bitmap)) {
            stopCapture();
            replaceInstaller(new AttributionBitmapInstaller(bitmap, z, view));
            return true;
        }
        if (!z || bitmap == null || bitmap.isRecycled()) {
            return false;
        }
        bitmap.recycle();
        return false;
    }

    public boolean attachView(View view) {
        if (this.released || view == null) {
            return false;
        }
        AttributionBitmapInstaller attributionBitmapInstaller = this.bitmapInstaller;
        if (attributionBitmapInstaller != null && attributionBitmapInstaller.hasCurrentMirror()) {
            Iterator<View> it = this.hiddenSources.keySet().iterator();
            while (it.hasNext()) {
                it.next().setVisibility(4);
            }
            hideSource(view);
        }
        stopCapture();
        ProviderTagCapture providerTagCapture = new ProviderTagCapture(view);
        this.providerTagCapture = providerTagCapture;
        providerTagCapture.start();
        return true;
    }
}
