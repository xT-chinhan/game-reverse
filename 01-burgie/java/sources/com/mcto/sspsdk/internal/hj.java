package com.mcto.sspsdk.internal;

import android.R;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.content.res.AppCompatResources;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public final class hj extends LayerDrawable {
    public hj(int i, int i2, AppCompatActivity appCompatActivity, boolean z) {
        vj vjVarA = a(i2, R.attr.colorControlHighlight, appCompatActivity, z);
        vj vjVar = new vj(AppCompatResources.getDrawable(appCompatActivity, i));
        vjVar.mutate();
        vjVar.setTintList(ColorStateList.valueOf(0));
        super(new Drawable[]{vjVarA, new ClipDrawable(vjVar, 3, 1), new ClipDrawable(a(i, R.attr.colorControlActivated, appCompatActivity, z), 3, 1)});
        setId(0, R.id.background);
        setId(1, R.id.secondaryProgress);
        setId(2, R.id.progress);
    }

    public final vj a(int i) {
        Drawable drawableFindDrawableByLayerId = findDrawableByLayerId(i);
        if (i == 16908288) {
            return (vj) drawableFindDrawableByLayerId;
        }
        if (i == 16908301 || i == 16908303) {
            ClipDrawable clipDrawable = (ClipDrawable) drawableFindDrawableByLayerId;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 23) {
                return (vj) clipDrawable.getDrawable();
            }
            try {
                Field declaredField = clipDrawable.getClass().getDeclaredField(i2 >= 22 ? "mState" : "mClipState");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(clipDrawable);
                Field declaredField2 = obj.getClass().getDeclaredField("mDrawable");
                declaredField2.setAccessible(true);
                return (vj) declaredField2.get(obj);
            } catch (Exception e) {
                r9.a("StarDrawable", "star drawable:", e);
            }
        }
        throw new RuntimeException();
    }

    public static vj a(int i, int i2, AppCompatActivity appCompatActivity, boolean z) {
        int color;
        if (z) {
            color = -1;
        } else {
            TypedArray typedArrayObtainStyledAttributes = appCompatActivity.obtainStyledAttributes(new int[]{i2});
            try {
                if (Build.VERSION.SDK_INT <= 19) {
                    typedArrayObtainStyledAttributes.recycle();
                    color = -1;
                } else {
                    color = typedArrayObtainStyledAttributes.getColor(0, 0);
                    typedArrayObtainStyledAttributes.recycle();
                }
            } catch (Exception e) {
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        }
        vj vjVar = new vj(AppCompatResources.getDrawable(appCompatActivity, i));
        vjVar.mutate();
        if (color != -1) {
            vjVar.setTintList(ColorStateList.valueOf(color));
        }
        return vjVar;
    }
}
