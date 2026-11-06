package com.kwad.sdk.dexapi.kssupport;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class SViewPager extends ViewPager {
    public SViewPager(Context context) {
        super(context);
    }

    public SViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SPagerAdapter getSAdapter() {
        try {
            PagerAdapter adapter = super.getAdapter();
            if (adapter instanceof SPagerAdapter) {
                return (SPagerAdapter) adapter;
            }
            return null;
        } catch (Throwable th) {
            SupportLogger.handleException(th);
            return null;
        }
    }

    public void setSAdapter(SPagerAdapter sPagerAdapter) {
        try {
            super.setAdapter(sPagerAdapter);
        } catch (Throwable th) {
            SupportLogger.handleException(th);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setAdapter(PagerAdapter pagerAdapter) {
        super.setAdapter(pagerAdapter);
        if (BuildConfig.isDevelopEnable.booleanValue()) {
            SupportLogger.handleException(new IllegalAccessException("setAdapter is not allowed, use setSAdapter instead"));
        }
    }

    @Override // androidx.viewpager.widget.ViewPager
    public PagerAdapter getAdapter() {
        return super.getAdapter();
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void addOnAdapterChangeListener(ViewPager.OnAdapterChangeListener onAdapterChangeListener) {
        super.addOnAdapterChangeListener(onAdapterChangeListener);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void removeOnAdapterChangeListener(ViewPager.OnAdapterChangeListener onAdapterChangeListener) {
        super.removeOnAdapterChangeListener(onAdapterChangeListener);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i) {
        super.setCurrentItem(i);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(i, z);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public int getCurrentItem() {
        return super.getCurrentItem();
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        super.setOnPageChangeListener(onPageChangeListener);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void addOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        super.addOnPageChangeListener(onPageChangeListener);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void removeOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        super.removeOnPageChangeListener(onPageChangeListener);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void clearOnPageChangeListeners() {
        super.clearOnPageChangeListeners();
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setPageTransformer(boolean z, ViewPager.PageTransformer pageTransformer) {
        super.setPageTransformer(z, pageTransformer);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setPageTransformer(boolean z, ViewPager.PageTransformer pageTransformer, int i) {
        super.setPageTransformer(z, pageTransformer, i);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        return super.getChildDrawingOrder(i, i2);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public int getOffscreenPageLimit() {
        return super.getOffscreenPageLimit();
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setOffscreenPageLimit(int i) {
        super.setOffscreenPageLimit(i);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setPageMargin(int i) {
        super.setPageMargin(i);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public int getPageMargin() {
        return super.getPageMargin();
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setPageMarginDrawable(Drawable drawable) {
        super.setPageMarginDrawable(drawable);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setPageMarginDrawable(int i) {
        super.setPageMarginDrawable(i);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public Parcelable onSaveInstanceState() {
        return super.onSaveInstanceState();
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(parcelable);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void computeScroll() {
        super.computeScroll();
    }

    @Override // androidx.viewpager.widget.ViewPager
    protected void onPageScrolled(int i, float f, int i2) {
        super.onPageScrolled(i, f, i2);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public boolean beginFakeDrag() {
        return super.beginFakeDrag();
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void endFakeDrag() {
        super.endFakeDrag();
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void fakeDragBy(float f) {
        super.fakeDragBy(f);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public boolean isFakeDragging() {
        return super.isFakeDragging();
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean canScrollHorizontally(int i) {
        return super.canScrollHorizontally(i);
    }

    @Override // androidx.viewpager.widget.ViewPager
    protected boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        return super.canScroll(view, z, i, i2, i3);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public boolean executeKeyEvent(KeyEvent keyEvent) {
        return super.executeKeyEvent(keyEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public boolean arrowScroll(int i) {
        return super.arrowScroll(i);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        super.addFocusables(arrayList, i, i2);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        super.addTouchables(arrayList);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        return super.onRequestFocusInDescendants(i, rect);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return super.generateDefaultLayoutParams();
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.generateLayoutParams(layoutParams);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }
}
