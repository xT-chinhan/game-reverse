package com.kwad.sdk.dexapi.kssupport;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.text.PrecomputedTextCompat;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes3.dex */
public class SAppCompatTextView extends AppCompatTextView {
    public SAppCompatTextView(Context context) {
        super(context);
    }

    public SAppCompatTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SAppCompatTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextSize(int i, float f) {
        super.setTextSize(i, f);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return super.onCreateInputConnection(editorInfo);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setFirstBaselineToTopHeight(int i) {
        super.setFirstBaselineToTopHeight(i);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setLastBaselineToBottomHeight(int i) {
        super.setLastBaselineToBottomHeight(i);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return super.getFirstBaselineToTopHeight();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return super.getLastBaselineToBottomHeight();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setLineHeight(int i) {
        super.setLineHeight(i);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(callback);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView
    public PrecomputedTextCompat.Params getTextMetricsParamsCompat() {
        return super.getTextMetricsParamsCompat();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView
    public void setTextMetricsParamsCompat(PrecomputedTextCompat.Params params) {
        super.setTextMetricsParamsCompat(params);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView
    public void setPrecomputedText(PrecomputedTextCompat precomputedTextCompat) {
        super.setPrecomputedText(precomputedTextCompat);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public CharSequence getText() {
        return super.getText();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView
    public void setTextFuture(Future<PrecomputedTextCompat> future) {
        super.setTextFuture(future);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }
}
