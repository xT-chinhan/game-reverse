package com.tapsdk.tapad.internal.runtime.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.view.GravityCompat;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.text.style.ReplacementSpan;
import android.view.View;
import android.widget.TextView;
import com.tapsdk.tapad.R;
import com.tapsdk.tapad.c;
import com.tapsdk.tapad.internal.runtime.DirichletRuntime;
import com.tapsdk.tapad.internal.runtime.image.MechanicalImageLoader;
import com.umeng.analytics.pro.cc;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class TextViewManager extends BaseViewManager<TextView, TextViewProps> {
    public static final String NAME = "text";
    public static final int VIEW_TYPE = 1;
    private final float mDensity;
    private final WeakHashMap<TextView, DrawableLoad> mDrawableLoads = new WeakHashMap<>();
    private final WeakHashMap<TextView, Boolean> mDrawableLifecycle = new WeakHashMap<>();

    public static class CenteredImageSpan extends ImageSpan {
        public CenteredImageSpan(Drawable drawable) {
            super(drawable, 0);
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
            Drawable drawable = getDrawable();
            int iHeight = (i5 - drawable.getBounds().bottom) - (((i5 - i3) - drawable.getBounds().height()) / 2);
            canvas.save();
            canvas.translate(f, iHeight);
            drawable.draw(canvas);
            canvas.restore();
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
            return getDrawable().getBounds().right;
        }
    }

    public static final class DrawableLoad {
        volatile MechanicalImageLoader.Request request;

        private DrawableLoad() {
        }
    }

    public static class SpaceSpan extends ReplacementSpan {
        private final int mWidth;

        public SpaceSpan(int i) {
            this.mWidth = i;
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
            return this.mWidth;
        }
    }

    public TextViewManager(Context context) {
        this.mDensity = context.getResources().getDisplayMetrics().density;
    }

    private void applyEllipsize(TextView textView, String str) {
        if (str == null || str.isEmpty() || "none".equals(str)) {
            textView.setEllipsize(null);
            return;
        }
        switch (str) {
            case "middle":
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                break;
            case "end":
                textView.setEllipsize(TextUtils.TruncateAt.END);
                break;
            case "start":
                textView.setEllipsize(TextUtils.TruncateAt.START);
                break;
            case "marquee":
                textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                break;
            default:
                textView.setEllipsize(TextUtils.TruncateAt.END);
                break;
        }
    }

    private void applyFontStyle(TextView textView, String str) {
        textView.setTypeface(Typeface.DEFAULT, typefaceStyle(textView.getTypeface() != null && textView.getTypeface().isBold(), "italic".equals(str)));
    }

    private void applyFontWeight(TextView textView, String str) {
        boolean z = textView.getTypeface() != null && textView.getTypeface().isItalic();
        if (str == null) {
            str = "normal";
        }
        byte b = -1;
        int iHashCode = str.hashCode();
        if (iHashCode != -1078030475) {
            if (iHashCode != -1039745817) {
                if (iHashCode == 3029637 && str.equals("bold")) {
                    b = 0;
                }
            } else if (str.equals("normal")) {
                b = 2;
            }
        } else if (str.equals("medium")) {
            b = 1;
        }
        if (b == 0) {
            textView.setTypeface(Typeface.DEFAULT, typefaceStyle(true, z));
        } else if (b != 1) {
            textView.setTypeface(Typeface.DEFAULT, typefaceStyle(false, z));
        } else {
            textView.setTypeface(Typeface.create("sans-serif-medium", z ? 2 : 0));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:25:0x0042  */
    private void applyTextAlign(TextView textView, String str) {
        byte b;
        str.getClass();
        switch (str) {
            case "center":
                b = 0;
                break;
            case "end":
                b = 1;
                break;
            case "left":
                b = 2;
                break;
            case "right":
                b = 3;
                break;
            case "start":
                b = 4;
                break;
            default:
                b = -1;
                break;
        }
        int i = GravityCompat.START;
        switch (b) {
            case 0:
                i = 17;
                break;
            case 1:
            case 3:
                i = GravityCompat.END;
                break;
        }
        textView.setGravity(i | 16);
    }

    private void applyTextDecorationLine(TextView textView, String str) {
        int paintFlags = textView.getPaintFlags() & (-25);
        if (str != null) {
            String lowerCase = str.trim().toLowerCase(Locale.US);
            if (!lowerCase.isEmpty() && !"none".equals(lowerCase)) {
                if ("underline line-through".equals(lowerCase) || "underline-line-through".equals(lowerCase)) {
                    paintFlags |= 24;
                } else if (lowerCase.contains("underline")) {
                    paintFlags |= 8;
                }
                if (lowerCase.contains("line-through") || lowerCase.contains("strikethrough")) {
                    paintFlags |= 16;
                }
            }
        }
        textView.setPaintFlags(paintFlags);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelDrawableLoad(TextView textView) {
        DrawableLoad drawableLoadRemove;
        synchronized (this.mDrawableLoads) {
            drawableLoadRemove = this.mDrawableLoads.remove(textView);
        }
        if (drawableLoadRemove == null || drawableLoadRemove.request == null) {
            return;
        }
        drawableLoadRemove.request.cancel();
    }

    private void clearDrawableLeft(TextView textView) {
        cancelDrawableLoad(textView);
        textView.setTag(R.id.tapad_dirichlet_drawable_left_tag, null);
        textView.setTag(R.id.tapad_dirichlet_drawable_left_size_tag, null);
        textView.setTag(R.id.tapad_dirichlet_drawable_left_padding_tag, null);
        CharSequence text = textView.getText();
        if (text == null || text.length() <= 0) {
            return;
        }
        textView.setText(stripDrawablePlaceholders(text));
    }

    private void ensureDrawableLifecycle(TextView textView) {
        synchronized (this.mDrawableLifecycle) {
            if (this.mDrawableLifecycle.containsKey(textView)) {
                return;
            }
            this.mDrawableLifecycle.put(textView, Boolean.TRUE);
            textView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.tapsdk.tapad.internal.runtime.view.TextViewManager.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                    TextViewManager.this.cancelDrawableLoad((TextView) view);
                }
            });
        }
    }

    private void loadDrawableLeft(TextView textView, String str) {
        MechanicalImageLoader.Request requestLoadBitmap;
        cancelDrawableLoad(textView);
        if (str == null || str.isEmpty()) {
            clearDrawableLeft(textView);
            return;
        }
        Float f = (Float) textView.getTag(R.id.tapad_dirichlet_drawable_left_size_tag);
        final int iDp2px = dp2px(f != null ? f.floatValue() : 20.0f, this.mDensity);
        final DrawableLoad drawableLoad = new DrawableLoad();
        synchronized (this.mDrawableLoads) {
            this.mDrawableLoads.put(textView, drawableLoad);
        }
        ensureDrawableLifecycle(textView);
        MechanicalImageLoader.Options optionsBuild = MechanicalImageLoader.Options.builder().targetSize(iDp2px, iDp2px).build();
        final WeakReference weakReference = new WeakReference(textView);
        MechanicalImageLoader.BitmapCallback bitmapCallback = new MechanicalImageLoader.BitmapCallback() { // from class: com.tapsdk.tapad.internal.runtime.view.TextViewManager$$ExternalSyntheticLambda0
            @Override // com.tapsdk.tapad.internal.runtime.image.MechanicalImageLoader.BitmapCallback
            public final void onResult(MechanicalImageLoader.Request request, Bitmap bitmap, Exception exc) {
                this.f$0.m340lambda$loadDrawableLeft$0$comtapsdktapadinternalruntimeviewTextViewManager(weakReference, drawableLoad, iDp2px, request, bitmap, exc);
            }
        };
        if (str.startsWith("asset://")) {
            String strSubstring = str.substring(8);
            byte[] bundleAsset = DirichletRuntime.getInstance().readBundleAsset("core", strSubstring);
            if (bundleAsset == null) {
                synchronized (this.mDrawableLoads) {
                    this.mDrawableLoads.remove(textView);
                }
                textView.setTag(R.id.tapad_dirichlet_drawable_left_tag, null);
                return;
            }
            requestLoadBitmap = MechanicalImageLoader.loadBitmap(textView.getContext(), c.a("bundle:core:", strSubstring), bundleAsset, optionsBuild, bitmapCallback);
        } else {
            requestLoadBitmap = MechanicalImageLoader.loadBitmap(textView.getContext(), str, optionsBuild, bitmapCallback);
        }
        drawableLoad.request = requestLoadBitmap;
        synchronized (this.mDrawableLoads) {
            if (this.mDrawableLoads.get(textView) != drawableLoad) {
                requestLoadBitmap.cancel();
            }
        }
    }

    private void reapplyTextWithDrawable(TextView textView) {
        CharSequence text = textView.getText();
        if (text == null || text.length() == 0) {
            return;
        }
        applyTextWithDrawable(textView, stripDrawablePlaceholders(text));
    }

    private String stripDrawablePlaceholders(CharSequence charSequence) {
        String string = charSequence.toString();
        if (string.length() >= 2 && string.charAt(0) == 8203 && string.charAt(1) == 8203) {
            return string.substring(2);
        }
        return (string.length() <= 0 || string.charAt(0) != 8203) ? string : string.substring(1);
    }

    private int typefaceStyle(boolean z, boolean z2) {
        if (z && z2) {
            return 3;
        }
        if (z) {
            return 1;
        }
        return z2 ? 2 : 0;
    }

    public void applyTextWithDrawable(TextView textView, String str) {
        Drawable drawable = (Drawable) textView.getTag(R.id.tapad_dirichlet_drawable_left_tag);
        if (drawable == null) {
            textView.setText(str);
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) "\u200b");
        spannableStringBuilder.setSpan(new CenteredImageSpan(drawable), 0, 1, 33);
        Float f = (Float) textView.getTag(R.id.tapad_dirichlet_drawable_left_padding_tag);
        int iDp2px = f != null ? dp2px(f.floatValue(), this.mDensity) : dp2px(4.0f, this.mDensity);
        spannableStringBuilder.append((CharSequence) "\u200b");
        spannableStringBuilder.setSpan(new SpaceSpan(iDp2px), 1, 2, 33);
        spannableStringBuilder.append((CharSequence) str);
        textView.setText(spannableStringBuilder);
    }

    @Override // com.tapsdk.tapad.internal.runtime.view.ViewManager
    public String getName() {
        return NAME;
    }

    @Override // com.tapsdk.tapad.internal.runtime.view.ViewManager
    public Class<TextViewProps> getPropsClass() {
        return TextViewProps.class;
    }

    @Override // com.tapsdk.tapad.internal.runtime.view.ViewManager
    public int getViewType() {
        return 1;
    }

    /* JADX INFO: renamed from: lambda$loadDrawableLeft$0$com-tapsdk-tapad-internal-runtime-view-TextViewManager, reason: not valid java name */
    /* synthetic */ void m340lambda$loadDrawableLeft$0$comtapsdktapadinternalruntimeviewTextViewManager(WeakReference weakReference, DrawableLoad drawableLoad, int i, MechanicalImageLoader.Request request, Bitmap bitmap, Exception exc) {
        TextView textView = (TextView) weakReference.get();
        if (textView == null) {
            return;
        }
        synchronized (this.mDrawableLoads) {
            if (this.mDrawableLoads.get(textView) != drawableLoad) {
                return;
            }
            this.mDrawableLoads.remove(textView);
            if (bitmap == null) {
                textView.setTag(R.id.tapad_dirichlet_drawable_left_tag, null);
                return;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(textView.getResources(), bitmap);
            bitmapDrawable.setBounds(0, 0, i, i);
            textView.setTag(R.id.tapad_dirichlet_drawable_left_tag, bitmapDrawable);
            reapplyTextWithDrawable(textView);
        }
    }

    @Override // com.tapsdk.tapad.internal.runtime.view.ViewManager
    public TextView createView(Context context, String str) {
        TextView textView = new TextView(context);
        textView.setGravity(8388627);
        textView.setIncludeFontPadding(false);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setFallbackLineSpacing(true);
        }
        return textView;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.tapsdk.tapad.internal.runtime.view.ViewManager
    public void setStyle(TextView textView, String str, String str2) {
        if (applyBaseStyle(textView, str, str2, this.mDensity)) {
            return;
        }
        str.getClass();
        byte b = -1;
        switch (str.hashCode()) {
            case -1625116241:
                if (str.equals("lineSpacing")) {
                    b = 0;
                }
                break;
            case -1098340447:
                if (str.equals("lineSpacingExtra")) {
                    b = 1;
                }
                break;
            case -1065511464:
                if (str.equals("textAlign")) {
                    b = 2;
                }
                break;
            case -1063571914:
                if (str.equals("textColor")) {
                    b = 3;
                }
                break;
            case -734428249:
                if (str.equals("fontWeight")) {
                    b = 4;
                }
                break;
            case 365601008:
                if (str.equals("fontSize")) {
                    b = 5;
                }
                break;
            case 390232059:
                if (str.equals("maxLines")) {
                    b = 6;
                }
                break;
            case 626202053:
                if (str.equals("drawableLeft")) {
                    b = 7;
                }
                break;
            case 1554823821:
                if (str.equals("ellipsize")) {
                    b = 8;
                }
                break;
            case 1667999372:
                if (str.equals("drawableLeftPadding")) {
                    b = 9;
                }
                break;
            case 1840272557:
                if (str.equals("textShadow")) {
                    b = 10;
                }
                break;
            case 1992294246:
                if (str.equals("drawableLeftSize")) {
                    b = 11;
                }
                break;
            case 2020113146:
                if (str.equals("includeFontPadding")) {
                    b = 12;
                }
                break;
            case 2031616849:
                if (str.equals("textDecorationLine")) {
                    b = cc.k;
                }
                break;
            case 2111078717:
                if (str.equals("letterSpacing")) {
                    b = cc.l;
                }
                break;
        }
        switch (b) {
            case 0:
            case 1:
                textView.setLineSpacing(dp2px(Float.parseFloat(str2), this.mDensity), 1.0f);
                break;
            case 2:
                applyTextAlign(textView, str2);
                break;
            case 3:
                textView.setTextColor(parseColor(str2));
                break;
            case 4:
                applyFontWeight(textView, str2);
                break;
            case 5:
                textView.setTextSize(2, Float.parseFloat(str2));
                break;
            case 6:
                int i = Integer.parseInt(str2);
                if (i > 0) {
                    textView.setMaxLines(i);
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                } else {
                    textView.setSingleLine(false);
                    textView.setMaxLines(Integer.MAX_VALUE);
                    textView.setEllipsize(null);
                }
                break;
            case 7:
                loadDrawableLeft(textView, str2);
                break;
            case 8:
                applyEllipsize(textView, str2);
                break;
            case 9:
                textView.setTag(R.id.tapad_dirichlet_drawable_left_padding_tag, Float.valueOf(Float.parseFloat(str2)));
                break;
            case 10:
                String[] strArrSplit = str2.split(",");
                if (strArrSplit.length >= 4) {
                    textView.setShadowLayer(dp2px(Float.parseFloat(strArrSplit[2].trim()), this.mDensity), dp2px(Float.parseFloat(strArrSplit[0].trim()), this.mDensity), dp2px(Float.parseFloat(strArrSplit[1].trim()), this.mDensity), parseColor(strArrSplit[3].trim()));
                }
                break;
            case 11:
                textView.setTag(R.id.tapad_dirichlet_drawable_left_size_tag, Float.valueOf(Float.parseFloat(str2)));
                break;
            case 12:
                textView.setIncludeFontPadding(Boolean.parseBoolean(str2));
                break;
            case 13:
                applyTextDecorationLine(textView, str2);
                break;
            case 14:
                textView.setLetterSpacing(dp2px(Float.parseFloat(str2), this.mDensity) / Math.max(1.0f, textView.getTextSize()));
                break;
        }
    }

    @Override // com.tapsdk.tapad.internal.runtime.view.ViewManager
    public void updateProps(TextView textView, TextViewProps textViewProps) {
        if (textViewProps == null) {
            return;
        }
        applyBaseProps(textView, textViewProps, this.mDensity);
        String str = textViewProps.text;
        if (str != null) {
            textView.setText(str);
        }
        String str2 = textViewProps.textColor;
        if (str2 != null) {
            textView.setTextColor(parseColor(str2));
        }
        Float f = textViewProps.fontSize;
        if (f != null) {
            textView.setTextSize(2, f.floatValue());
        }
        String str3 = textViewProps.fontWeight;
        if (str3 != null) {
            applyFontWeight(textView, str3);
        }
        String str4 = textViewProps.textAlign;
        if (str4 != null) {
            applyTextAlign(textView, str4);
        }
        Integer num = textViewProps.maxLines;
        if (num != null) {
            textView.setMaxLines(num.intValue());
            textView.setEllipsize(TextUtils.TruncateAt.END);
        }
        String str5 = textViewProps.ellipsize;
        if (str5 != null) {
            applyEllipsize(textView, str5);
        }
        Float f2 = textViewProps.lineSpacing;
        if (f2 != null) {
            textView.setLineSpacing(dp2px(f2.floatValue(), this.mDensity), 1.0f);
        }
        Boolean bool = textViewProps.includeFontPadding;
        if (bool != null) {
            textView.setIncludeFontPadding(bool.booleanValue());
        }
    }
}
