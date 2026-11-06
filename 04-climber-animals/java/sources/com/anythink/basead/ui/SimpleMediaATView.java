package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.anythink.core.common.h.w;
import com.anythink.core.common.res.e;
import com.anythink.core.common.v.am;
import com.anythink.core.common.v.h;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class SimpleMediaATView extends FrameLayout {
    ImageView a;
    ImageView b;
    private int c;
    private int d;
    private int e;
    private Bitmap f;

    public SimpleMediaATView(Context context) {
        this(context, null);
    }

    public SimpleMediaATView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SimpleMediaATView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void initView(w wVar) {
        LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_simple_media_ad_view", "layout"), this);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int iMax = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
        this.e = iMax;
        this.c = iMax;
        this.d = iMax;
        this.b = (ImageView) findViewById(q.a(getContext(), "myoffer_simple_background", "id"));
        ImageView imageView = (ImageView) findViewById(q.a(getContext(), "myoffer_simple_main_image", "id"));
        this.a = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        String strB = wVar.B();
        try {
            com.anythink.core.common.res.b.a(getContext()).a(new e(1, strB), new AnonymousClass1(strB));
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.SimpleMediaATView$1, reason: invalid class name */
    final class AnonymousClass1 implements com.anythink.core.common.res.b.a {
        final /* synthetic */ String a;

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(String str, String str2) {
        }

        AnonymousClass1(String str) {
            this.a = str;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(String str, final Bitmap bitmap) {
            if (TextUtils.equals(str, this.a)) {
                SimpleMediaATView.this.post(new Runnable() { // from class: com.anythink.basead.ui.SimpleMediaATView.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        SimpleMediaATView.this.f = bitmap;
                        SimpleMediaATView.this.a(bitmap);
                        SimpleMediaATView.this.a.setImageBitmap(bitmap);
                        SimpleMediaATView.this.a.setVisibility(0);
                        h.a(SimpleMediaATView.this.getContext(), bitmap, new h.a() { // from class: com.anythink.basead.ui.SimpleMediaATView.1.1.1
                            @Override // com.anythink.core.common.v.h.a
                            public final void a() {
                            }

                            @Override // com.anythink.core.common.v.h.a
                            public final void a(Bitmap bitmap2) {
                                SimpleMediaATView.this.b.setImageBitmap(bitmap2);
                                SimpleMediaATView.this.b.setVisibility(0);
                            }
                        });
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap) {
        int i;
        int i2;
        int[] iArrA = am.a(this.c, this.d, bitmap.getWidth() / bitmap.getHeight());
        ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
        layoutParams.width = iArrA[0];
        layoutParams.height = iArrA[1];
        this.a.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
        if (layoutParams2 != null) {
            if (layoutParams2.width == -2) {
                i = iArrA[0];
            } else {
                i = this.c;
            }
            if (layoutParams2.height == -2) {
                i2 = iArrA[1];
            } else {
                i2 = this.d;
            }
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (!childAt.equals(this.a)) {
                    if (childAt != null) {
                        ViewGroup.LayoutParams layoutParams3 = childAt.getLayoutParams();
                        layoutParams3.width = i;
                        childAt.setLayoutParams(layoutParams3);
                    }
                    if (childAt != null) {
                        ViewGroup.LayoutParams layoutParams4 = childAt.getLayoutParams();
                        layoutParams4.height = i2;
                        childAt.setLayoutParams(layoutParams4);
                    }
                }
            }
        }
    }

    private static void a(View view, int i) {
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = i;
            view.setLayoutParams(layoutParams);
        }
    }

    private static void b(View view, int i) {
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = i;
            view.setLayoutParams(layoutParams);
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0034  */
    /* JADX WARN: Code duplicated, block: B:24:0x003d A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:27:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        boolean z;
        Bitmap bitmap;
        super.setLayoutParams(layoutParams);
        boolean z2 = true;
        if (layoutParams.width == -1 || layoutParams.width == -2) {
            this.c = this.e;
        } else {
            if (this.c != layoutParams.width) {
                this.c = layoutParams.width;
                z = true;
            }
            if (layoutParams.height != -1 || layoutParams.height == -2) {
                this.d = this.e;
            } else {
                if (this.d != layoutParams.height) {
                    this.d = layoutParams.height;
                }
                bitmap = this.f;
                if (bitmap == null && z2) {
                    a(bitmap);
                    return;
                }
            }
            z2 = z;
            bitmap = this.f;
            if (bitmap == null) {
            }
        }
        z = false;
        if (layoutParams.height != -1) {
            this.d = this.e;
            z2 = z;
        } else {
            this.d = this.e;
            z2 = z;
        }
        bitmap = this.f;
        if (bitmap == null) {
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        boolean z;
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        Bitmap bitmap = this.f;
        if (bitmap == null) {
            if (size != 0 && size < this.c) {
                this.c = size;
            }
            if (size2 == 0 || size2 >= this.d) {
                return;
            }
            this.d = size2;
            return;
        }
        boolean z2 = true;
        if (size == 0 || size >= this.c) {
            z = false;
        } else {
            this.c = size;
            z = true;
        }
        if (size2 == 0 || size2 >= this.d) {
            z2 = z;
        } else {
            this.d = size2;
        }
        if (z2) {
            a(bitmap);
        }
    }
}
