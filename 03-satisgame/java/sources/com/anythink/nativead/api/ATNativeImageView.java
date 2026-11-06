package com.anythink.nativead.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.anythink.core.common.d.s;
import com.anythink.core.common.res.b;
import com.anythink.core.common.res.e;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class ATNativeImageView extends ImageView {
    public static final String TAG = "anythink_native_image";
    private WeakReference<ATNativeImageView> imageViewWeakReference;
    String mImageUrl;
    private int retryCurCount;
    private int retryDelay;
    private int retryMaxCount;
    private Runnable retryRunnable;

    static /* synthetic */ int access$208(ATNativeImageView aTNativeImageView) {
        int i = aTNativeImageView.retryCurCount;
        aTNativeImageView.retryCurCount = i + 1;
        return i;
    }

    private class a implements Runnable {
        int height;
        String url;
        int width;

        public a(String str, int i, int i2) {
            this.url = str;
            this.width = i;
            this.height = i2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                ATNativeImageView.this.loadImage(this.url, this.width, this.height);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public ATNativeImageView(Context context) {
        super(context);
        this.retryMaxCount = 3;
        this.retryCurCount = 0;
        this.retryDelay = 500;
    }

    public ATNativeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.retryMaxCount = 3;
        this.retryCurCount = 0;
        this.retryDelay = 500;
    }

    public ATNativeImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.retryMaxCount = 3;
        this.retryCurCount = 0;
        this.retryDelay = 500;
    }

    public void setRetryMaxCount(int i) {
        printLog("setRetryMaxCount: retryMaxCount=".concat(String.valueOf(i)));
        if (i <= 0) {
            return;
        }
        this.retryMaxCount = i;
    }

    public void setRetryDelay(int i) {
        printLog("setRetryDelay: retryDelay=" + this.retryMaxCount);
        if (this.retryMaxCount <= 200) {
            return;
        }
        this.retryDelay = i;
    }

    public void setImage(String str, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            Log.e(TAG, "load: url is empty!");
            return;
        }
        this.mImageUrl = str;
        this.imageViewWeakReference = new WeakReference<>(this);
        this.retryCurCount = 0;
        loadImage(str, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadImage(String str, final int i, final int i2) {
        b.a(getContext()).a(new e(2, str), i, i2, new b.a() { // from class: com.anythink.nativead.api.ATNativeImageView.1
            @Override // com.anythink.core.common.res.b.a
            public final void onSuccess(String str2, Bitmap bitmap) {
                try {
                    if (ATNativeImageView.this.retryRunnable != null) {
                        s.b();
                        s.c(ATNativeImageView.this.retryRunnable);
                    }
                    ATNativeImageView.this.printLog("curRetryCount=" + ATNativeImageView.this.retryCurCount + ", load success: " + str2);
                    ATNativeImageView aTNativeImageView = (ATNativeImageView) ATNativeImageView.this.imageViewWeakReference.get();
                    if (!TextUtils.equals(ATNativeImageView.this.mImageUrl, str2) || aTNativeImageView == null) {
                        ATNativeImageView.this.printLog("curRetryCount=" + ATNativeImageView.this.retryCurCount + ", failed to set Image to [" + aTNativeImageView + "], url: " + str2);
                    } else {
                        ATNativeImageView.this.printLog("curRetryCount=" + ATNativeImageView.this.retryCurCount + ", set Image to [" + aTNativeImageView + "], url: " + str2);
                        aTNativeImageView.setImageBitmap(bitmap);
                    }
                } catch (Throwable th) {
                    Log.e(ATNativeImageView.TAG, "onSuccess error: ", th);
                }
            }

            @Override // com.anythink.core.common.res.b.a
            public final void onFail(String str2, String str3) {
                Log.e(ATNativeImageView.TAG, "curRetryCount=" + ATNativeImageView.this.retryCurCount + ", load: image load fail:" + str3);
                try {
                    ATNativeImageView.access$208(ATNativeImageView.this);
                    if (ATNativeImageView.this.retryCurCount > ATNativeImageView.this.retryMaxCount) {
                        ATNativeImageView.this.printLog("meet retry count, stop retry: ".concat(String.valueOf(str2)));
                        return;
                    }
                    ATNativeImageView.this.retryRunnable = ATNativeImageView.this.new a(str2, i, i2);
                    s.b();
                    s.a(ATNativeImageView.this.retryRunnable, ATNativeImageView.this.retryDelay);
                } catch (Throwable th) {
                    Log.e(ATNativeImageView.TAG, "onFail error: ", th);
                }
            }
        });
    }

    public void setImage(String str) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            setImage(str, layoutParams.width, layoutParams.height);
        } else {
            setImage(str, -1, -1);
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
        } catch (Throwable unused) {
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void printLog(String str) {
        if (s.b().G()) {
            Log.i(TAG, str);
        }
    }
}
