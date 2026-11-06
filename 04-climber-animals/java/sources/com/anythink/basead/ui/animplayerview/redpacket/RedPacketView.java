package com.anythink.basead.ui.animplayerview.redpacket;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.anythink.core.common.v.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public class RedPacketView extends View {
    public static final String TAG = "RedPacketView";
    private static final int e = 400;
    protected double a;
    protected double b;
    protected final List<a> c;
    Random d;
    private final Matrix f;
    private final Map<Integer, Float> g;
    private List<Integer> h;
    private Paint i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private Bitmap o;
    private boolean p;

    public RedPacketView(Context context) {
        this(context, null);
    }

    public RedPacketView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RedPacketView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0.15d;
        this.b = 0.2d;
        this.f = new Matrix();
        this.c = new ArrayList();
        this.g = new HashMap();
        Paint paint = new Paint();
        this.i = paint;
        paint.setFilterBitmap(true);
        this.i.setDither(true);
        this.i.setAntiAlias(true);
        setLayerType(2, null);
        this.d = new Random(System.currentTimeMillis());
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.m = getMeasuredWidth();
        this.n = getMeasuredHeight();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        a next;
        Bitmap bitmapC;
        super.onDraw(canvas);
        Iterator<a> it = this.c.iterator();
        while (it.hasNext() && (bitmapC = (next = it.next()).c()) != null) {
            this.f.setTranslate((-next.b()) >> 1, (-next.a()) >> 1);
            this.f.postRotate(next.e());
            this.f.postTranslate((next.b() >> 1) + next.a, (next.a() >> 1) + next.b);
            canvas.drawBitmap(bitmapC, this.f, this.i);
        }
    }

    public void release() {
        this.p = false;
        try {
            Bitmap bitmap = this.o;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.o.recycle();
            }
            Iterator<a> it = this.c.iterator();
            while (it.hasNext()) {
                it.next().d();
            }
            this.c.clear();
            Map<Integer, Float> map = this.g;
            if (map != null) {
                map.clear();
            }
            List<Integer> list = this.h;
            if (list != null) {
                list.clear();
            }
        } catch (Exception e2) {
            Log.e(TAG, "release failed: " + e2.getMessage());
        }
    }

    private void a() {
        Paint paint = new Paint();
        this.i = paint;
        paint.setFilterBitmap(true);
        this.i.setDither(true);
        this.i.setAntiAlias(true);
        setLayerType(2, null);
        this.d = new Random(System.currentTimeMillis());
    }

    private void a(Canvas canvas) {
        a next;
        Bitmap bitmapC;
        Iterator<a> it = this.c.iterator();
        while (it.hasNext() && (bitmapC = (next = it.next()).c()) != null) {
            this.f.setTranslate((-next.b()) >> 1, (-next.a()) >> 1);
            this.f.postRotate(next.e());
            this.f.postTranslate((next.b() >> 1) + next.a, (next.a() >> 1) + next.b);
            canvas.drawBitmap(bitmapC, this.f, this.i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0028 A[Catch: Exception -> 0x019b, TryCatch #0 {Exception -> 0x019b, blocks: (B:7:0x000e, B:8:0x0024, B:10:0x0028, B:12:0x002e, B:15:0x0056, B:16:0x005c, B:18:0x0060, B:20:0x0078, B:23:0x0080, B:25:0x0084, B:33:0x00a3, B:35:0x00d7, B:37:0x00e7, B:39:0x0104, B:41:0x0108, B:42:0x010f, B:43:0x0118, B:45:0x011f, B:46:0x0125, B:48:0x0130, B:49:0x0139, B:51:0x013f, B:52:0x0144, B:28:0x008c, B:30:0x0094, B:32:0x009d, B:53:0x0154, B:54:0x015d, B:56:0x0161, B:58:0x0167, B:59:0x016d, B:61:0x0173, B:63:0x017f, B:65:0x0187, B:67:0x0191, B:68:0x0194), top: B:75:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:12:0x002e A[Catch: Exception -> 0x019b, TryCatch #0 {Exception -> 0x019b, blocks: (B:7:0x000e, B:8:0x0024, B:10:0x0028, B:12:0x002e, B:15:0x0056, B:16:0x005c, B:18:0x0060, B:20:0x0078, B:23:0x0080, B:25:0x0084, B:33:0x00a3, B:35:0x00d7, B:37:0x00e7, B:39:0x0104, B:41:0x0108, B:42:0x010f, B:43:0x0118, B:45:0x011f, B:46:0x0125, B:48:0x0130, B:49:0x0139, B:51:0x013f, B:52:0x0144, B:28:0x008c, B:30:0x0094, B:32:0x009d, B:53:0x0154, B:54:0x015d, B:56:0x0161, B:58:0x0167, B:59:0x016d, B:61:0x0173, B:63:0x017f, B:65:0x0187, B:67:0x0191, B:68:0x0194), top: B:75:0x000e }] */
    public void initRedPacketList(Bitmap bitmap) {
        Bitmap bitmap2;
        int i;
        Float f;
        this.o = bitmap;
        if (this.p) {
            return;
        }
        this.p = true;
        if (bitmap == null) {
            try {
                this.o = BitmapFactory.decodeResource(getResources(), q.a(getContext(), "myoffer_icon_red_packet", "drawable"));
                bitmap2 = this.o;
                if (bitmap2 == null) {
                    Log.e(TAG, "redPacketBitmap is null, decodeResource failed.");
                    return;
                }
                int height = (int) (((double) this.n) / (((((double) this.m) * this.b) * ((double) bitmap2.getHeight())) / ((double) bitmap2.getWidth())));
                this.l = height;
                this.k = 3;
                i = ((height * 3) * 4) / 9;
                this.j = i;
                if (i > 0 || height <= 0) {
                    return;
                }
                this.c.clear();
                for (int i2 = 0; i2 < this.j; i2++) {
                    a aVar = new a(getContext(), this.o, this.a, this.b, this.m);
                    if (aVar.b() > 0 && aVar.a() > 0) {
                        int i3 = i2 % 4;
                        if (i3 == 0) {
                            i3 = (i2 / 4) * 9;
                        } else if (i3 == 1) {
                            i3 = ((i2 / 4) * 9) + 2;
                        } else if (i3 == 2) {
                            i3 = ((i2 / 4) * 9) + 4;
                        } else if (i3 == 3) {
                            i3 = ((i2 / 4) * 9) + 8;
                        }
                        int i4 = this.k;
                        int i5 = i3 / i4;
                        int i6 = i3 % i4;
                        int i7 = this.m / i4;
                        int i8 = this.n / this.l;
                        int iB = aVar.b();
                        int iA = aVar.a();
                        aVar.a = (i6 * i7) + ((i7 - iB) >> 1);
                        int iNextInt = this.d.nextInt(21) - 10;
                        int iNextInt2 = this.d.nextInt(iA / 3) + (iA / 3);
                        if (i5 > 0 && (f = this.g.get(Integer.valueOf(i3 - this.k))) != null) {
                            aVar.b = f.floatValue() + iNextInt2 + iNextInt;
                            if ((this.n - aVar.b) - b() < iA) {
                                if (this.h == null) {
                                    this.h = new ArrayList();
                                }
                                this.h.add(Integer.valueOf(i2));
                            }
                        }
                        if (aVar.b == 0.0f) {
                            aVar.b = (i5 * i8) + iNextInt2 + iNextInt;
                        }
                        float f2 = iA;
                        float f3 = aVar.b + f2;
                        int i9 = this.n;
                        if (f3 > i9) {
                            aVar.b = (i9 - iA) - b();
                        }
                        if (aVar.b < 0.0f) {
                            aVar.b = iA >> 1;
                        }
                        this.g.put(Integer.valueOf(i3), Float.valueOf(aVar.b + f2));
                    }
                    this.c.add(aVar);
                }
                List<Integer> list = this.h;
                if (list != null && list.size() > 0) {
                    Iterator<Integer> it = this.h.iterator();
                    while (it.hasNext()) {
                        int iIntValue = it.next().intValue();
                        if (iIntValue >= 0 && iIntValue < this.c.size()) {
                            a aVar2 = this.c.get(iIntValue);
                            if (aVar2 != null) {
                                aVar2.d();
                            }
                            this.c.remove(iIntValue);
                        }
                    }
                }
            } catch (Exception e2) {
                Log.e(TAG, "initRedPacketList failed: " + e2.getMessage());
            }
        } else {
            bitmap2 = this.o;
            if (bitmap2 == null) {
                Log.e(TAG, "redPacketBitmap is null, decodeResource failed.");
                return;
            }
            int height2 = (int) (((double) this.n) / (((((double) this.m) * this.b) * ((double) bitmap2.getHeight())) / ((double) bitmap2.getWidth())));
            this.l = height2;
            this.k = 3;
            i = ((height2 * 3) * 4) / 9;
            this.j = i;
            if (i > 0) {
                return;
            } else {
                return;
            }
        }
        invalidate();
    }

    private void a(Bitmap bitmap) {
        int height = (int) (((double) this.n) / (((((double) this.m) * this.b) * ((double) bitmap.getHeight())) / ((double) bitmap.getWidth())));
        this.l = height;
        this.k = 3;
        this.j = ((height * 3) * 4) / 9;
    }

    private a b(Bitmap bitmap) {
        return new a(getContext(), bitmap, this.a, this.b, this.m);
    }

    private static int a(int i) {
        int i2 = i % 4;
        if (i2 == 0) {
            return (i / 4) * 9;
        }
        if (i2 == 1) {
            return ((i / 4) * 9) + 2;
        }
        if (i2 == 2) {
            return ((i / 4) * 9) + 4;
        }
        return i2 == 3 ? ((i / 4) * 9) + 8 : i2;
    }

    private void a(a aVar, int i) {
        Float f;
        if (aVar.b() <= 0 || aVar.a() <= 0) {
            return;
        }
        int i2 = i % 4;
        if (i2 == 0) {
            i2 = (i / 4) * 9;
        } else if (i2 == 1) {
            i2 = ((i / 4) * 9) + 2;
        } else if (i2 == 2) {
            i2 = ((i / 4) * 9) + 4;
        } else if (i2 == 3) {
            i2 = ((i / 4) * 9) + 8;
        }
        int i3 = this.k;
        int i4 = i2 / i3;
        int i5 = i2 % i3;
        int i6 = this.m / i3;
        int i7 = this.n / this.l;
        int iB = aVar.b();
        int iA = aVar.a();
        aVar.a = (i5 * i6) + ((i6 - iB) >> 1);
        int iNextInt = this.d.nextInt(21) - 10;
        int i8 = iA / 3;
        int iNextInt2 = this.d.nextInt(i8) + i8;
        if (i4 > 0 && (f = this.g.get(Integer.valueOf(i2 - this.k))) != null) {
            aVar.b = f.floatValue() + iNextInt2 + iNextInt;
            if ((this.n - aVar.b) - b() < iA) {
                if (this.h == null) {
                    this.h = new ArrayList();
                }
                this.h.add(Integer.valueOf(i));
            }
        }
        if (aVar.b == 0.0f) {
            aVar.b = (i4 * i7) + iNextInt2 + iNextInt;
        }
        float f2 = iA;
        float f3 = aVar.b + f2;
        int i9 = this.n;
        if (f3 > i9) {
            aVar.b = (i9 - iA) - b();
        }
        if (aVar.b < 0.0f) {
            aVar.b = iA >> 1;
        }
        this.g.put(Integer.valueOf(i2), Float.valueOf(aVar.b + f2));
    }

    private int b() {
        return q.a(getContext(), 5.0f);
    }
}
