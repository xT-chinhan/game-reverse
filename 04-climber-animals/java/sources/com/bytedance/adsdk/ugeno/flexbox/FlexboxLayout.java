package com.bytedance.adsdk.ugeno.flexbox;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.bytedance.adsdk.ugeno.c.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class FlexboxLayout extends ViewGroup implements com.bytedance.adsdk.ugeno.flexbox.ms {
    private Drawable ab;
    private int ah;
    private List<ah> ao;
    private int c;
    private int ch;
    private int d;
    private com.bytedance.adsdk.ugeno.ah h;
    private int hi;
    private int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f353ms;
    private int ny;
    private d.ms qv;
    private int sl;
    private SparseIntArray u;
    private d ub;
    private Drawable x;
    private int xr;
    private int[] zb;

    @Override // com.bytedance.adsdk.ugeno.flexbox.ms
    public int ms(View view) {
        return 0;
    }

    public FlexboxLayout(Context context) {
        super(context, null);
        this.c = -1;
        this.ub = new d(this);
        this.ao = new ArrayList();
        this.qv = new d.ms();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        com.bytedance.adsdk.ugeno.ah ahVar = this.h;
        if (ahVar != null) {
            int[] iArrMs = ahVar.ms(i, i2);
            ms(iArrMs[0], iArrMs[1]);
        } else {
            ms(i, i2);
        }
        com.bytedance.adsdk.ugeno.ah ahVar2 = this.h;
        if (ahVar2 != null) {
            ahVar2.ah();
        }
    }

    private void ms(int i, int i2) {
        if (this.u == null) {
            this.u = new SparseIntArray(getChildCount());
        }
        if (this.ub.xr(this.u)) {
            this.zb = this.ub.ms(this.u);
        }
        int i3 = this.f353ms;
        if (i3 == 0 || i3 == 1) {
            xr(i, i2);
        } else {
            if (i3 == 2 || i3 == 3) {
                ah(i, i2);
                return;
            }
            throw new IllegalStateException("Invalid value for the flex direction is set: " + this.f353ms);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.ms
    public int getFlexItemCount() {
        return getChildCount();
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.ms
    public View ms(int i) {
        return getChildAt(i);
    }

    public View ah(int i) {
        if (i < 0) {
            return null;
        }
        int[] iArr = this.zb;
        if (i >= iArr.length) {
            return null;
        }
        return getChildAt(iArr[i]);
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.ms
    public View xr(int i) {
        return ah(i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.u == null) {
            this.u = new SparseIntArray(getChildCount());
        }
        this.zb = this.ub.ms(view, i, layoutParams, this.u);
        super.addView(view, i, layoutParams);
    }

    private void xr(int i, int i2) {
        this.ao.clear();
        this.qv.ms();
        this.ub.ms(this.qv, i, i2);
        this.ao = this.qv.f357ms;
        this.ub.ms(i, i2);
        if (this.d == 3) {
            for (ah ahVar : this.ao) {
                int iMax = Integer.MIN_VALUE;
                for (int i3 = 0; i3 < ahVar.x; i3++) {
                    View viewAh = ah(ahVar.ub + i3);
                    if (viewAh != null && viewAh.getVisibility() != 8) {
                        ms msVar = (ms) viewAh.getLayoutParams();
                        if (this.xr != 2) {
                            iMax = Math.max(iMax, viewAh.getMeasuredHeight() + Math.max(ahVar.sl - viewAh.getBaseline(), msVar.topMargin) + msVar.bottomMargin);
                        } else {
                            iMax = Math.max(iMax, viewAh.getMeasuredHeight() + msVar.topMargin + Math.max((ahVar.sl - viewAh.getMeasuredHeight()) + viewAh.getBaseline(), msVar.bottomMargin));
                        }
                    }
                }
                ahVar.ab = iMax;
            }
        }
        this.ub.xr(i, i2, getPaddingTop() + getPaddingBottom());
        this.ub.ms();
        ms(this.f353ms, i, i2, this.qv.xr);
    }

    private void ah(int i, int i2) {
        this.ao.clear();
        this.qv.ms();
        this.ub.xr(this.qv, i, i2);
        this.ao = this.qv.f357ms;
        this.ub.ms(i, i2);
        this.ub.xr(i, i2, getPaddingLeft() + getPaddingRight());
        this.ub.ms();
        ms(this.f353ms, i, i2, this.qv.xr);
    }

    private void ms(int i, int i2, int i3, int i4) {
        int sumOfCrossSize;
        int largestMainSize;
        int iResolveSizeAndState;
        int iResolveSizeAndState2;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (i == 0 || i == 1) {
            sumOfCrossSize = getSumOfCrossSize() + getPaddingTop() + getPaddingBottom();
            largestMainSize = getLargestMainSize();
        } else if (i == 2 || i == 3) {
            sumOfCrossSize = getLargestMainSize();
            largestMainSize = getSumOfCrossSize() + getPaddingLeft() + getPaddingRight();
        } else {
            throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(i)));
        }
        if (mode == Integer.MIN_VALUE) {
            if (size < largestMainSize) {
                i4 = View.combineMeasuredStates(i4, 16777216);
            } else {
                size = largestMainSize;
            }
            iResolveSizeAndState = View.resolveSizeAndState(size, i2, i4);
        } else if (mode == 0) {
            iResolveSizeAndState = View.resolveSizeAndState(largestMainSize, i2, i4);
        } else if (mode == 1073741824) {
            if (size < largestMainSize) {
                i4 = View.combineMeasuredStates(i4, 16777216);
            }
            iResolveSizeAndState = View.resolveSizeAndState(size, i2, i4);
        } else {
            throw new IllegalStateException("Unknown width mode is set: ".concat(String.valueOf(mode)));
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (size2 < sumOfCrossSize) {
                i4 = View.combineMeasuredStates(i4, 256);
            } else {
                size2 = sumOfCrossSize;
            }
            iResolveSizeAndState2 = View.resolveSizeAndState(size2, i3, i4);
        } else if (mode2 == 0) {
            iResolveSizeAndState2 = View.resolveSizeAndState(sumOfCrossSize, i3, i4);
        } else if (mode2 == 1073741824) {
            if (size2 < sumOfCrossSize) {
                i4 = View.combineMeasuredStates(i4, 256);
            }
            iResolveSizeAndState2 = View.resolveSizeAndState(size2, i3, i4);
        } else {
            throw new IllegalStateException("Unknown height mode is set: ".concat(String.valueOf(mode2)));
        }
        setMeasuredDimension(iResolveSizeAndState, iResolveSizeAndState2);
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.ms
    public int getLargestMainSize() {
        Iterator<ah> it = this.ao.iterator();
        int iMax = Integer.MIN_VALUE;
        while (it.hasNext()) {
            iMax = Math.max(iMax, it.next().ka);
        }
        return iMax;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.ms
    public int getSumOfCrossSize() {
        int i;
        int i2;
        int size = this.ao.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            ah ahVar = this.ao.get(i4);
            if (d(i4)) {
                if (ms()) {
                    i2 = this.hi;
                } else {
                    i2 = this.sl;
                }
                i3 += i2;
            }
            if (c(i4)) {
                if (ms()) {
                    i = this.hi;
                } else {
                    i = this.sl;
                }
                i3 += i;
            }
            i3 += ahVar.ab;
        }
        return i3;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.ms
    public boolean ms() {
        int i = this.f353ms;
        return i == 0 || i == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        com.bytedance.adsdk.ugeno.ah ahVar = this.h;
        if (ahVar != null) {
            ahVar.d();
        }
        int iMs = ab.ms(this);
        int i5 = this.f353ms;
        if (i5 == 0) {
            ms(iMs == 1, i, i2, i3, i4);
        } else if (i5 == 1) {
            ms(iMs != 1, i, i2, i3, i4);
        } else if (i5 == 2) {
            z2 = iMs == 1;
            ms(this.xr == 2 ? !z2 : z2, false, i, i2, i3, i4);
        } else if (i5 == 3) {
            z2 = iMs == 1;
            ms(this.xr == 2 ? !z2 : z2, true, i, i2, i3, i4);
        } else {
            throw new IllegalStateException("Invalid flex direction is set: " + this.f353ms);
        }
        com.bytedance.adsdk.ugeno.ah ahVar2 = this.h;
        if (ahVar2 != null) {
            ahVar2.ms(i, i2, i3, i4);
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:44:0x00de  */
    /* JADX WARN: Code duplicated, block: B:46:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:48:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:49:0x0105  */
    /* JADX WARN: Code duplicated, block: B:52:0x010e  */
    /* JADX WARN: Code duplicated, block: B:54:0x0116  */
    /* JADX WARN: Code duplicated, block: B:55:0x011b  */
    /* JADX WARN: Code duplicated, block: B:59:0x0124 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:60:0x0126  */
    /* JADX WARN: Code duplicated, block: B:61:0x0157  */
    /* JADX WARN: Code duplicated, block: B:62:0x0181  */
    /* JADX WARN: Code duplicated, block: B:64:0x018e  */
    /* JADX WARN: Code duplicated, block: B:65:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:68:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:69:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:71:0x0200  */
    /* JADX WARN: Code duplicated, block: B:72:0x020b  */
    private void ms(boolean z, int i, int i2, int i3, int i4) {
        float measuredWidth;
        int i5;
        float f;
        float f2;
        float fMax;
        int i6;
        int i7;
        View viewAh;
        int i8;
        int i9;
        int i10;
        char c;
        ms msVar;
        float f3;
        float f4;
        float f5;
        int i11;
        char c2;
        int i12;
        ms msVar2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i13 = i3 - i;
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        int paddingTop = getPaddingTop();
        int size = this.ao.size();
        int i14 = 0;
        while (i14 < size) {
            ah ahVar = this.ao.get(i14);
            if (d(i14)) {
                int i15 = this.hi;
                paddingBottom -= i15;
                paddingTop += i15;
            }
            int i16 = this.ah;
            char c3 = 4;
            int i17 = 1;
            if (i16 != 0) {
                if (i16 == 1) {
                    measuredWidth = (i13 - ahVar.ka) + paddingRight;
                    i5 = ahVar.ka - paddingLeft;
                } else if (i16 == 2) {
                    measuredWidth = paddingLeft + ((i13 - ahVar.ka) / 2.0f);
                    f = (i13 - paddingRight) - ((i13 - ahVar.ka) / 2.0f);
                    f2 = 0.0f;
                } else if (i16 == 3) {
                    measuredWidth = paddingLeft;
                    int iXr = ahVar.xr();
                    f2 = (i13 - ahVar.ka) / (iXr != 1 ? iXr - 1 : 1.0f);
                    f = i13 - paddingRight;
                } else if (i16 == 4) {
                    int iXr2 = ahVar.xr();
                    f2 = iXr2 != 0 ? (i13 - ahVar.ka) / iXr2 : 0.0f;
                    float f6 = f2 / 2.0f;
                    measuredWidth = paddingLeft + f6;
                    f = (i13 - paddingRight) - f6;
                } else if (i16 == 5) {
                    int iXr3 = ahVar.xr();
                    f2 = iXr3 != 0 ? (i13 - ahVar.ka) / (iXr3 + 1) : 0.0f;
                    measuredWidth = paddingLeft + f2;
                    f = (i13 - paddingRight) - f2;
                } else {
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.ah);
                }
                fMax = Math.max(f2, 0.0f);
                i6 = 0;
                while (i6 < ahVar.x) {
                    i7 = ahVar.ub + i6;
                    viewAh = ah(i7);
                    if (viewAh != null) {
                        i8 = paddingLeft;
                        i9 = i17;
                        i10 = i6;
                        c = c3;
                    } else if (viewAh.getVisibility() != 8) {
                        msVar = (ms) viewAh.getLayoutParams();
                        f3 = measuredWidth + msVar.leftMargin;
                        f4 = f - msVar.rightMargin;
                        if (d(i7, i6)) {
                            int i18 = this.sl;
                            float f7 = i18;
                            f3 += f7;
                            i11 = i18;
                            f5 = f4 - f7;
                        } else {
                            f5 = f4;
                            i11 = 0;
                        }
                        if (i6 == ahVar.x - i17) {
                            c2 = 4;
                            i12 = (this.ch & 4) > 0 ? this.sl : 0;
                            if (this.xr == 2) {
                                i8 = paddingLeft;
                                i9 = i17;
                                i10 = i6;
                                msVar2 = msVar;
                                c = c2;
                                if (z) {
                                    this.ub.ms(viewAh, ahVar, Math.round(f5) - viewAh.getMeasuredWidth(), paddingTop, Math.round(f5), paddingTop + viewAh.getMeasuredHeight());
                                } else {
                                    this.ub.ms(viewAh, ahVar, Math.round(f3), paddingTop, Math.round(f3) + viewAh.getMeasuredWidth(), paddingTop + viewAh.getMeasuredHeight());
                                }
                            } else if (z) {
                                i9 = i17;
                                i10 = i6;
                                i8 = paddingLeft;
                                msVar2 = msVar;
                                c = c2;
                                this.ub.ms(viewAh, ahVar, Math.round(f5) - viewAh.getMeasuredWidth(), paddingBottom - viewAh.getMeasuredHeight(), Math.round(f5), paddingBottom);
                            } else {
                                i8 = paddingLeft;
                                i9 = i17;
                                i10 = i6;
                                msVar2 = msVar;
                                c = c2;
                                this.ub.ms(viewAh, ahVar, Math.round(f3), paddingBottom - viewAh.getMeasuredHeight(), Math.round(f3) + viewAh.getMeasuredWidth(), paddingBottom);
                            }
                            measuredWidth = f3 + viewAh.getMeasuredWidth() + fMax + msVar2.rightMargin;
                            float measuredWidth2 = f5 - ((viewAh.getMeasuredWidth() + fMax) + msVar2.leftMargin);
                            if (z) {
                                ahVar.ms(viewAh, i12, 0, i11, 0);
                            } else {
                                ahVar.ms(viewAh, i11, 0, i12, 0);
                            }
                            f = measuredWidth2;
                        } else {
                            c2 = 4;
                        }
                        if (this.xr == 2) {
                            i8 = paddingLeft;
                            i9 = i17;
                            i10 = i6;
                            msVar2 = msVar;
                            c = c2;
                            if (z) {
                                this.ub.ms(viewAh, ahVar, Math.round(f5) - viewAh.getMeasuredWidth(), paddingTop, Math.round(f5), paddingTop + viewAh.getMeasuredHeight());
                            } else {
                                this.ub.ms(viewAh, ahVar, Math.round(f3), paddingTop, Math.round(f3) + viewAh.getMeasuredWidth(), paddingTop + viewAh.getMeasuredHeight());
                            }
                        } else if (z) {
                            i9 = i17;
                            i10 = i6;
                            i8 = paddingLeft;
                            msVar2 = msVar;
                            c = c2;
                            this.ub.ms(viewAh, ahVar, Math.round(f5) - viewAh.getMeasuredWidth(), paddingBottom - viewAh.getMeasuredHeight(), Math.round(f5), paddingBottom);
                        } else {
                            i8 = paddingLeft;
                            i9 = i17;
                            i10 = i6;
                            msVar2 = msVar;
                            c = c2;
                            this.ub.ms(viewAh, ahVar, Math.round(f3), paddingBottom - viewAh.getMeasuredHeight(), Math.round(f3) + viewAh.getMeasuredWidth(), paddingBottom);
                        }
                        measuredWidth = f3 + viewAh.getMeasuredWidth() + fMax + msVar2.rightMargin;
                        float measuredWidth3 = f5 - ((viewAh.getMeasuredWidth() + fMax) + msVar2.leftMargin);
                        if (z) {
                            ahVar.ms(viewAh, i12, 0, i11, 0);
                        } else {
                            ahVar.ms(viewAh, i11, 0, i12, 0);
                        }
                        f = measuredWidth3;
                    } else {
                        i8 = paddingLeft;
                        i9 = i17;
                        i10 = i6;
                        c = 4;
                    }
                    i6 = i10 + 1;
                    paddingLeft = i8;
                    i17 = i9;
                    c3 = c;
                }
                paddingTop += ahVar.ab;
                paddingBottom -= ahVar.ab;
                i14++;
                paddingLeft = paddingLeft;
            } else {
                measuredWidth = paddingLeft;
                i5 = i13 - paddingRight;
            }
            f = i5;
            f2 = 0.0f;
            fMax = Math.max(f2, 0.0f);
            i6 = 0;
            while (i6 < ahVar.x) {
                i7 = ahVar.ub + i6;
                viewAh = ah(i7);
                if (viewAh != null) {
                    i8 = paddingLeft;
                    i9 = i17;
                    i10 = i6;
                    c = c3;
                } else if (viewAh.getVisibility() != 8) {
                    msVar = (ms) viewAh.getLayoutParams();
                    f3 = measuredWidth + msVar.leftMargin;
                    f4 = f - msVar.rightMargin;
                    if (d(i7, i6)) {
                        int i19 = this.sl;
                        float f8 = i19;
                        f3 += f8;
                        i11 = i19;
                        f5 = f4 - f8;
                    } else {
                        f5 = f4;
                        i11 = 0;
                    }
                    if (i6 == ahVar.x - i17) {
                        c2 = 4;
                        if ((this.ch & 4) > 0) {
                        }
                        if (this.xr == 2) {
                            i8 = paddingLeft;
                            i9 = i17;
                            i10 = i6;
                            msVar2 = msVar;
                            c = c2;
                            if (z) {
                                this.ub.ms(viewAh, ahVar, Math.round(f5) - viewAh.getMeasuredWidth(), paddingTop, Math.round(f5), paddingTop + viewAh.getMeasuredHeight());
                            } else {
                                this.ub.ms(viewAh, ahVar, Math.round(f3), paddingTop, Math.round(f3) + viewAh.getMeasuredWidth(), paddingTop + viewAh.getMeasuredHeight());
                            }
                        } else if (z) {
                            i9 = i17;
                            i10 = i6;
                            i8 = paddingLeft;
                            msVar2 = msVar;
                            c = c2;
                            this.ub.ms(viewAh, ahVar, Math.round(f5) - viewAh.getMeasuredWidth(), paddingBottom - viewAh.getMeasuredHeight(), Math.round(f5), paddingBottom);
                        } else {
                            i8 = paddingLeft;
                            i9 = i17;
                            i10 = i6;
                            msVar2 = msVar;
                            c = c2;
                            this.ub.ms(viewAh, ahVar, Math.round(f3), paddingBottom - viewAh.getMeasuredHeight(), Math.round(f3) + viewAh.getMeasuredWidth(), paddingBottom);
                        }
                        measuredWidth = f3 + viewAh.getMeasuredWidth() + fMax + msVar2.rightMargin;
                        float measuredWidth4 = f5 - ((viewAh.getMeasuredWidth() + fMax) + msVar2.leftMargin);
                        if (z) {
                            ahVar.ms(viewAh, i12, 0, i11, 0);
                        } else {
                            ahVar.ms(viewAh, i11, 0, i12, 0);
                        }
                        f = measuredWidth4;
                    } else {
                        c2 = 4;
                    }
                    if (this.xr == 2) {
                        i8 = paddingLeft;
                        i9 = i17;
                        i10 = i6;
                        msVar2 = msVar;
                        c = c2;
                        if (z) {
                            this.ub.ms(viewAh, ahVar, Math.round(f5) - viewAh.getMeasuredWidth(), paddingTop, Math.round(f5), paddingTop + viewAh.getMeasuredHeight());
                        } else {
                            this.ub.ms(viewAh, ahVar, Math.round(f3), paddingTop, Math.round(f3) + viewAh.getMeasuredWidth(), paddingTop + viewAh.getMeasuredHeight());
                        }
                    } else if (z) {
                        i9 = i17;
                        i10 = i6;
                        i8 = paddingLeft;
                        msVar2 = msVar;
                        c = c2;
                        this.ub.ms(viewAh, ahVar, Math.round(f5) - viewAh.getMeasuredWidth(), paddingBottom - viewAh.getMeasuredHeight(), Math.round(f5), paddingBottom);
                    } else {
                        i8 = paddingLeft;
                        i9 = i17;
                        i10 = i6;
                        msVar2 = msVar;
                        c = c2;
                        this.ub.ms(viewAh, ahVar, Math.round(f3), paddingBottom - viewAh.getMeasuredHeight(), Math.round(f3) + viewAh.getMeasuredWidth(), paddingBottom);
                    }
                    measuredWidth = f3 + viewAh.getMeasuredWidth() + fMax + msVar2.rightMargin;
                    float measuredWidth5 = f5 - ((viewAh.getMeasuredWidth() + fMax) + msVar2.leftMargin);
                    if (z) {
                        ahVar.ms(viewAh, i12, 0, i11, 0);
                    } else {
                        ahVar.ms(viewAh, i11, 0, i12, 0);
                    }
                    f = measuredWidth5;
                } else {
                    i8 = paddingLeft;
                    i9 = i17;
                    i10 = i6;
                    c = 4;
                }
                i6 = i10 + 1;
                paddingLeft = i8;
                i17 = i9;
                c3 = c;
            }
            paddingTop += ahVar.ab;
            paddingBottom -= ahVar.ab;
            i14++;
            paddingLeft = paddingLeft;
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:44:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:46:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:48:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:49:0x0105  */
    /* JADX WARN: Code duplicated, block: B:52:0x0111  */
    /* JADX WARN: Code duplicated, block: B:54:0x0119  */
    /* JADX WARN: Code duplicated, block: B:55:0x011e  */
    /* JADX WARN: Code duplicated, block: B:58:0x0124 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:59:0x0126  */
    /* JADX WARN: Code duplicated, block: B:60:0x0155  */
    /* JADX WARN: Code duplicated, block: B:61:0x017d  */
    /* JADX WARN: Code duplicated, block: B:63:0x0187  */
    /* JADX WARN: Code duplicated, block: B:64:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:67:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:68:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:70:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:71:0x0205  */
    private void ms(boolean z, boolean z2, int i, int i2, int i3, int i4) {
        float f;
        int i5;
        float f2;
        float f3;
        float fMax;
        int i6;
        int i7;
        View viewAh;
        int i8;
        boolean z3;
        char c;
        ms msVar;
        float f4;
        float f5;
        float f6;
        float f7;
        int i9;
        char c2;
        int i10;
        ms msVar2;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingRight = getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int i11 = i4 - i2;
        int i12 = (i3 - i) - paddingRight;
        int size = this.ao.size();
        for (int i13 = 0; i13 < size; i13++) {
            ah ahVar = this.ao.get(i13);
            if (d(i13)) {
                int i14 = this.sl;
                paddingLeft += i14;
                i12 -= i14;
            }
            int i15 = this.ah;
            char c3 = 4;
            boolean z4 = true;
            if (i15 != 0) {
                if (i15 == 1) {
                    f = (i11 - ahVar.ka) + paddingBottom;
                    i5 = ahVar.ka - paddingTop;
                } else if (i15 == 2) {
                    f = ((i11 - ahVar.ka) / 2.0f) + paddingTop;
                    f2 = (i11 - paddingBottom) - ((i11 - ahVar.ka) / 2.0f);
                    f3 = 0.0f;
                } else if (i15 == 3) {
                    f = paddingTop;
                    int iXr = ahVar.xr();
                    f3 = (i11 - ahVar.ka) / (iXr != 1 ? iXr - 1 : 1.0f);
                    f2 = i11 - paddingBottom;
                } else if (i15 == 4) {
                    int iXr2 = ahVar.xr();
                    f3 = iXr2 != 0 ? (i11 - ahVar.ka) / iXr2 : 0.0f;
                    float f8 = f3 / 2.0f;
                    f = paddingTop + f8;
                    f2 = (i11 - paddingBottom) - f8;
                } else if (i15 == 5) {
                    int iXr3 = ahVar.xr();
                    f3 = iXr3 != 0 ? (i11 - ahVar.ka) / (iXr3 + 1) : 0.0f;
                    f = paddingTop + f3;
                    f2 = (i11 - paddingBottom) - f3;
                } else {
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.ah);
                }
                fMax = Math.max(f3, 0.0f);
                i6 = 0;
                while (i6 < ahVar.x) {
                    i7 = ahVar.ub + i6;
                    viewAh = ah(i7);
                    if (viewAh != null) {
                        i8 = i6;
                        z3 = z4;
                        c = c3;
                    } else if (viewAh.getVisibility() != 8) {
                        msVar = (ms) viewAh.getLayoutParams();
                        f4 = f + msVar.topMargin;
                        f5 = f2 - msVar.bottomMargin;
                        if (d(i7, i6)) {
                            int i16 = this.hi;
                            float f9 = i16;
                            f6 = f4 + f9;
                            i9 = i16;
                            f7 = f5 - f9;
                        } else {
                            f6 = f4;
                            f7 = f5;
                            i9 = 0;
                        }
                        if (i6 == ahVar.x - 1) {
                            c2 = 4;
                            i10 = (this.ny & 4) > 0 ? this.hi : 0;
                            if (z) {
                                i8 = i6;
                                z3 = true;
                                msVar2 = msVar;
                                c = c2;
                                if (z2) {
                                    this.ub.ms(viewAh, ahVar, false, paddingLeft, Math.round(f7) - viewAh.getMeasuredHeight(), paddingLeft + viewAh.getMeasuredWidth(), Math.round(f7));
                                } else {
                                    this.ub.ms(viewAh, ahVar, false, paddingLeft, Math.round(f6), paddingLeft + viewAh.getMeasuredWidth(), Math.round(f6) + viewAh.getMeasuredHeight());
                                }
                            } else if (z2) {
                                i8 = i6;
                                z3 = true;
                                msVar2 = msVar;
                                c = c2;
                                this.ub.ms(viewAh, ahVar, true, i12 - viewAh.getMeasuredWidth(), Math.round(f7) - viewAh.getMeasuredHeight(), i12, Math.round(f7));
                            } else {
                                i8 = i6;
                                z3 = true;
                                msVar2 = msVar;
                                c = c2;
                                this.ub.ms(viewAh, ahVar, true, i12 - viewAh.getMeasuredWidth(), Math.round(f6), i12, Math.round(f6) + viewAh.getMeasuredHeight());
                            }
                            ms msVar3 = msVar2;
                            float measuredHeight = f6 + viewAh.getMeasuredHeight() + fMax + msVar3.bottomMargin;
                            float measuredHeight2 = f7 - ((viewAh.getMeasuredHeight() + fMax) + msVar3.topMargin);
                            if (z2) {
                                ahVar.ms(viewAh, 0, i10, 0, i9);
                            } else {
                                ahVar.ms(viewAh, 0, i9, 0, i10);
                            }
                            f = measuredHeight;
                            f2 = measuredHeight2;
                        } else {
                            c2 = 4;
                        }
                        if (z) {
                            i8 = i6;
                            z3 = true;
                            msVar2 = msVar;
                            c = c2;
                            if (z2) {
                                this.ub.ms(viewAh, ahVar, false, paddingLeft, Math.round(f7) - viewAh.getMeasuredHeight(), paddingLeft + viewAh.getMeasuredWidth(), Math.round(f7));
                            } else {
                                this.ub.ms(viewAh, ahVar, false, paddingLeft, Math.round(f6), paddingLeft + viewAh.getMeasuredWidth(), Math.round(f6) + viewAh.getMeasuredHeight());
                            }
                        } else if (z2) {
                            i8 = i6;
                            z3 = true;
                            msVar2 = msVar;
                            c = c2;
                            this.ub.ms(viewAh, ahVar, true, i12 - viewAh.getMeasuredWidth(), Math.round(f7) - viewAh.getMeasuredHeight(), i12, Math.round(f7));
                        } else {
                            i8 = i6;
                            z3 = true;
                            msVar2 = msVar;
                            c = c2;
                            this.ub.ms(viewAh, ahVar, true, i12 - viewAh.getMeasuredWidth(), Math.round(f6), i12, Math.round(f6) + viewAh.getMeasuredHeight());
                        }
                        ms msVar4 = msVar2;
                        float measuredHeight3 = f6 + viewAh.getMeasuredHeight() + fMax + msVar4.bottomMargin;
                        float measuredHeight4 = f7 - ((viewAh.getMeasuredHeight() + fMax) + msVar4.topMargin);
                        if (z2) {
                            ahVar.ms(viewAh, 0, i10, 0, i9);
                        } else {
                            ahVar.ms(viewAh, 0, i9, 0, i10);
                        }
                        f = measuredHeight3;
                        f2 = measuredHeight4;
                    } else {
                        i8 = i6;
                        z3 = true;
                        c = 4;
                    }
                    i6 = i8 + 1;
                    z4 = z3;
                    c3 = c;
                }
                paddingLeft += ahVar.ab;
                i12 -= ahVar.ab;
            } else {
                f = paddingTop;
                i5 = i11 - paddingBottom;
            }
            f2 = i5;
            f3 = 0.0f;
            fMax = Math.max(f3, 0.0f);
            i6 = 0;
            while (i6 < ahVar.x) {
                i7 = ahVar.ub + i6;
                viewAh = ah(i7);
                if (viewAh != null) {
                    i8 = i6;
                    z3 = z4;
                    c = c3;
                } else if (viewAh.getVisibility() != 8) {
                    msVar = (ms) viewAh.getLayoutParams();
                    f4 = f + msVar.topMargin;
                    f5 = f2 - msVar.bottomMargin;
                    if (d(i7, i6)) {
                        int i17 = this.hi;
                        float f10 = i17;
                        f6 = f4 + f10;
                        i9 = i17;
                        f7 = f5 - f10;
                    } else {
                        f6 = f4;
                        f7 = f5;
                        i9 = 0;
                    }
                    if (i6 == ahVar.x - 1) {
                        c2 = 4;
                        if ((this.ny & 4) > 0) {
                        }
                        if (z) {
                            i8 = i6;
                            z3 = true;
                            msVar2 = msVar;
                            c = c2;
                            if (z2) {
                                this.ub.ms(viewAh, ahVar, false, paddingLeft, Math.round(f7) - viewAh.getMeasuredHeight(), paddingLeft + viewAh.getMeasuredWidth(), Math.round(f7));
                            } else {
                                this.ub.ms(viewAh, ahVar, false, paddingLeft, Math.round(f6), paddingLeft + viewAh.getMeasuredWidth(), Math.round(f6) + viewAh.getMeasuredHeight());
                            }
                        } else if (z2) {
                            i8 = i6;
                            z3 = true;
                            msVar2 = msVar;
                            c = c2;
                            this.ub.ms(viewAh, ahVar, true, i12 - viewAh.getMeasuredWidth(), Math.round(f7) - viewAh.getMeasuredHeight(), i12, Math.round(f7));
                        } else {
                            i8 = i6;
                            z3 = true;
                            msVar2 = msVar;
                            c = c2;
                            this.ub.ms(viewAh, ahVar, true, i12 - viewAh.getMeasuredWidth(), Math.round(f6), i12, Math.round(f6) + viewAh.getMeasuredHeight());
                        }
                        ms msVar5 = msVar2;
                        float measuredHeight5 = f6 + viewAh.getMeasuredHeight() + fMax + msVar5.bottomMargin;
                        float measuredHeight6 = f7 - ((viewAh.getMeasuredHeight() + fMax) + msVar5.topMargin);
                        if (z2) {
                            ahVar.ms(viewAh, 0, i10, 0, i9);
                        } else {
                            ahVar.ms(viewAh, 0, i9, 0, i10);
                        }
                        f = measuredHeight5;
                        f2 = measuredHeight6;
                    } else {
                        c2 = 4;
                    }
                    if (z) {
                        i8 = i6;
                        z3 = true;
                        msVar2 = msVar;
                        c = c2;
                        if (z2) {
                            this.ub.ms(viewAh, ahVar, false, paddingLeft, Math.round(f7) - viewAh.getMeasuredHeight(), paddingLeft + viewAh.getMeasuredWidth(), Math.round(f7));
                        } else {
                            this.ub.ms(viewAh, ahVar, false, paddingLeft, Math.round(f6), paddingLeft + viewAh.getMeasuredWidth(), Math.round(f6) + viewAh.getMeasuredHeight());
                        }
                    } else if (z2) {
                        i8 = i6;
                        z3 = true;
                        msVar2 = msVar;
                        c = c2;
                        this.ub.ms(viewAh, ahVar, true, i12 - viewAh.getMeasuredWidth(), Math.round(f7) - viewAh.getMeasuredHeight(), i12, Math.round(f7));
                    } else {
                        i8 = i6;
                        z3 = true;
                        msVar2 = msVar;
                        c = c2;
                        this.ub.ms(viewAh, ahVar, true, i12 - viewAh.getMeasuredWidth(), Math.round(f6), i12, Math.round(f6) + viewAh.getMeasuredHeight());
                    }
                    ms msVar6 = msVar2;
                    float measuredHeight7 = f6 + viewAh.getMeasuredHeight() + fMax + msVar6.bottomMargin;
                    float measuredHeight8 = f7 - ((viewAh.getMeasuredHeight() + fMax) + msVar6.topMargin);
                    if (z2) {
                        ahVar.ms(viewAh, 0, i10, 0, i9);
                    } else {
                        ahVar.ms(viewAh, 0, i9, 0, i10);
                    }
                    f = measuredHeight7;
                    f2 = measuredHeight8;
                } else {
                    i8 = i6;
                    z3 = true;
                    c = 4;
                }
                i6 = i8 + 1;
                z4 = z3;
                c3 = c;
            }
            paddingLeft += ahVar.ab;
            i12 -= ahVar.ab;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.x == null && this.ab == null) {
            return;
        }
        if (this.ny == 0 && this.ch == 0) {
            return;
        }
        int iMs = ab.ms(this);
        int i = this.f353ms;
        if (i == 0) {
            ms(canvas, iMs == 1, this.xr == 2);
            return;
        }
        if (i == 1) {
            ms(canvas, iMs != 1, this.xr == 2);
            return;
        }
        if (i == 2) {
            boolean z = iMs == 1;
            if (this.xr == 2) {
                z = !z;
            }
            xr(canvas, z, false);
            return;
        }
        if (i != 3) {
            return;
        }
        boolean z2 = iMs == 1;
        if (this.xr == 2) {
            z2 = !z2;
        }
        xr(canvas, z2, true);
    }

    private void ms(Canvas canvas, boolean z, boolean z2) {
        int i;
        int i2;
        int right;
        int left;
        int paddingLeft = getPaddingLeft();
        int iMax = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.ao.size();
        for (int i3 = 0; i3 < size; i3++) {
            ah ahVar = this.ao.get(i3);
            for (int i4 = 0; i4 < ahVar.x; i4++) {
                int i5 = ahVar.ub + i4;
                View viewAh = ah(i5);
                if (viewAh != null && viewAh.getVisibility() != 8) {
                    ms msVar = (ms) viewAh.getLayoutParams();
                    if (d(i5, i4)) {
                        if (z) {
                            left = viewAh.getRight() + msVar.rightMargin;
                        } else {
                            left = (viewAh.getLeft() - msVar.leftMargin) - this.sl;
                        }
                        ms(canvas, left, ahVar.xr, ahVar.ab);
                    }
                    if (i4 == ahVar.x - 1 && (this.ch & 4) > 0) {
                        if (z) {
                            right = (viewAh.getLeft() - msVar.leftMargin) - this.sl;
                        } else {
                            right = viewAh.getRight() + msVar.rightMargin;
                        }
                        ms(canvas, right, ahVar.xr, ahVar.ab);
                    }
                }
            }
            if (d(i3)) {
                if (z2) {
                    i2 = ahVar.d;
                } else {
                    i2 = ahVar.xr - this.hi;
                }
                xr(canvas, paddingLeft, i2, iMax);
            }
            if (c(i3) && (this.ny & 4) > 0) {
                if (z2) {
                    i = ahVar.xr - this.hi;
                } else {
                    i = ahVar.d;
                }
                xr(canvas, paddingLeft, i, iMax);
            }
        }
    }

    private void xr(Canvas canvas, boolean z, boolean z2) {
        int i;
        int i2;
        int bottom;
        int top;
        int paddingTop = getPaddingTop();
        int iMax = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.ao.size();
        for (int i3 = 0; i3 < size; i3++) {
            ah ahVar = this.ao.get(i3);
            for (int i4 = 0; i4 < ahVar.x; i4++) {
                int i5 = ahVar.ub + i4;
                View viewAh = ah(i5);
                if (viewAh != null && viewAh.getVisibility() != 8) {
                    ms msVar = (ms) viewAh.getLayoutParams();
                    if (d(i5, i4)) {
                        if (z2) {
                            top = viewAh.getBottom() + msVar.bottomMargin;
                        } else {
                            top = (viewAh.getTop() - msVar.topMargin) - this.hi;
                        }
                        xr(canvas, ahVar.f355ms, top, ahVar.ab);
                    }
                    if (i4 == ahVar.x - 1 && (this.ny & 4) > 0) {
                        if (z2) {
                            bottom = (viewAh.getTop() - msVar.topMargin) - this.hi;
                        } else {
                            bottom = viewAh.getBottom() + msVar.bottomMargin;
                        }
                        xr(canvas, ahVar.f355ms, bottom, ahVar.ab);
                    }
                }
            }
            if (d(i3)) {
                if (z) {
                    i2 = ahVar.ah;
                } else {
                    i2 = ahVar.f355ms - this.sl;
                }
                ms(canvas, i2, paddingTop, iMax);
            }
            if (c(i3) && (this.ch & 4) > 0) {
                if (z) {
                    i = ahVar.f355ms - this.sl;
                } else {
                    i = ahVar.ah;
                }
                ms(canvas, i, paddingTop, iMax);
            }
        }
    }

    private void ms(Canvas canvas, int i, int i2, int i3) {
        Drawable drawable = this.x;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i, i2, this.sl + i, i3 + i2);
        this.x.draw(canvas);
    }

    private void xr(Canvas canvas, int i, int i2, int i3) {
        Drawable drawable = this.ab;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i, i2, i3 + i, this.hi + i2);
        this.ab.draw(canvas);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ms;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ms) {
            return new ms((ms) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new ms((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new ms(layoutParams);
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.ms
    public int getFlexDirection() {
        return this.f353ms;
    }

    public void setFlexDirection(int i) {
        if (this.f353ms != i) {
            this.f353ms = i;
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.ms
    public int getFlexWrap() {
        return this.xr;
    }

    public void setFlexWrap(int i) {
        if (this.xr != i) {
            this.xr = i;
            requestLayout();
        }
    }

    public int getJustifyContent() {
        return this.ah;
    }

    public void setJustifyContent(int i) {
        if (this.ah != i) {
            this.ah = i;
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.ms
    public int getAlignItems() {
        return this.d;
    }

    public void setAlignItems(int i) {
        if (this.d != i) {
            this.d = i;
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.ms
    public int getAlignContent() {
        return this.ka;
    }

    public void setAlignContent(int i) {
        if (this.ka != i) {
            this.ka = i;
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.ms
    public int getMaxLine() {
        return this.c;
    }

    public void setMaxLine(int i) {
        if (this.c != i) {
            this.c = i;
            requestLayout();
        }
    }

    public List<ah> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.ao.size());
        for (ah ahVar : this.ao) {
            if (ahVar.xr() != 0) {
                arrayList.add(ahVar);
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.ms
    public int ms(View view, int i, int i2) {
        int i3;
        int i4;
        if (ms()) {
            i3 = d(i, i2) ? 0 + this.sl : 0;
            if ((this.ch & 4) <= 0) {
                return i3;
            }
            i4 = this.sl;
        } else {
            i3 = d(i, i2) ? 0 + this.hi : 0;
            if ((this.ny & 4) <= 0) {
                return i3;
            }
            i4 = this.hi;
        }
        return i3 + i4;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.ms
    public void ms(ah ahVar) {
        if (ms()) {
            if ((this.ch & 4) > 0) {
                ahVar.ka += this.sl;
                ahVar.c += this.sl;
                return;
            }
            return;
        }
        if ((this.ny & 4) > 0) {
            ahVar.ka += this.hi;
            ahVar.c += this.hi;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.ms
    public int ms(int i, int i2, int i3) {
        return getChildMeasureSpec(i, i2, i3);
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.ms
    public int xr(int i, int i2, int i3) {
        return getChildMeasureSpec(i, i2, i3);
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.ms
    public void ms(View view, int i, int i2, ah ahVar) {
        if (d(i, i2)) {
            if (ms()) {
                ahVar.ka += this.sl;
                ahVar.c += this.sl;
            } else {
                ahVar.ka += this.hi;
                ahVar.c += this.hi;
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.ms
    public void setFlexLines(List<ah> list) {
        this.ao = list;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.ms
    public List<ah> getFlexLinesInternal() {
        return this.ao;
    }

    public Drawable getDividerDrawableHorizontal() {
        return this.ab;
    }

    public Drawable getDividerDrawableVertical() {
        return this.x;
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(Drawable drawable) {
        if (drawable == this.ab) {
            return;
        }
        this.ab = drawable;
        if (drawable != null) {
            this.hi = drawable.getIntrinsicHeight();
        } else {
            this.hi = 0;
        }
        xr();
        requestLayout();
    }

    public void setDividerDrawableVertical(Drawable drawable) {
        if (drawable == this.x) {
            return;
        }
        this.x = drawable;
        if (drawable != null) {
            this.sl = drawable.getIntrinsicWidth();
        } else {
            this.sl = 0;
        }
        xr();
        requestLayout();
    }

    public int getShowDividerVertical() {
        return this.ch;
    }

    public int getShowDividerHorizontal() {
        return this.ny;
    }

    public void setShowDivider(int i) {
        setShowDividerVertical(i);
        setShowDividerHorizontal(i);
    }

    public void setShowDividerVertical(int i) {
        if (i != this.ch) {
            this.ch = i;
            requestLayout();
        }
    }

    public void setShowDividerHorizontal(int i) {
        if (i != this.ny) {
            this.ny = i;
            requestLayout();
        }
    }

    private void xr() {
        if (this.ab == null && this.x == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    private boolean d(int i, int i2) {
        if (ka(i, i2)) {
            if (ms()) {
                return (this.ch & 1) != 0;
            }
            return (this.ny & 1) != 0;
        }
        if (ms()) {
            return (this.ch & 2) != 0;
        }
        return (this.ny & 2) != 0;
    }

    private boolean ka(int i, int i2) {
        for (int i3 = 1; i3 <= i2; i3++) {
            View viewAh = ah(i - i3);
            if (viewAh != null && viewAh.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    private boolean d(int i) {
        if (i >= 0 && i < this.ao.size()) {
            if (ka(i)) {
                if (ms()) {
                    return (this.ny & 1) != 0;
                }
                return (this.ch & 1) != 0;
            }
            if (ms()) {
                return (this.ny & 2) != 0;
            }
            if ((this.ch & 2) != 0) {
                return true;
            }
        }
        return false;
    }

    private boolean ka(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (this.ao.get(i2).xr() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean c(int i) {
        if (i >= 0 && i < this.ao.size()) {
            for (int i2 = i + 1; i2 < this.ao.size(); i2++) {
                if (this.ao.get(i2).xr() > 0) {
                    return false;
                }
            }
            if (ms()) {
                return (this.ny & 4) != 0;
            }
            if ((this.ch & 4) != 0) {
                return true;
            }
        }
        return false;
    }

    public static class ms extends ViewGroup.MarginLayoutParams implements xr {
        public static final Parcelable.Creator<ms> CREATOR = new Parcelable.Creator<ms>() { // from class: com.bytedance.adsdk.ugeno.flexbox.FlexboxLayout.ms.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public ms createFromParcel(Parcel parcel) {
                return new ms(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public ms[] newArray(int i) {
                return new ms[i];
            }
        };
        private int ab;
        private float ah;
        private int c;
        private boolean ch;
        private int d;
        private float ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private int f354ms;
        private int ny;
        private int x;
        private float xr;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public ms(ms msVar) {
            super((ViewGroup.MarginLayoutParams) msVar);
            this.f354ms = 1;
            this.xr = 0.0f;
            this.ah = 0.0f;
            this.d = -1;
            this.ka = -1.0f;
            this.c = -1;
            this.ab = -1;
            this.x = ViewCompat.MEASURED_SIZE_MASK;
            this.ny = ViewCompat.MEASURED_SIZE_MASK;
            this.f354ms = msVar.f354ms;
            this.xr = msVar.xr;
            this.ah = msVar.ah;
            this.d = msVar.d;
            this.ka = msVar.ka;
            this.c = msVar.c;
            this.ab = msVar.ab;
            this.x = msVar.x;
            this.ny = msVar.ny;
            this.ch = msVar.ch;
        }

        public ms(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f354ms = 1;
            this.xr = 0.0f;
            this.ah = 0.0f;
            this.d = -1;
            this.ka = -1.0f;
            this.c = -1;
            this.ab = -1;
            this.x = ViewCompat.MEASURED_SIZE_MASK;
            this.ny = ViewCompat.MEASURED_SIZE_MASK;
        }

        public ms(int i, int i2) {
            super(new ViewGroup.LayoutParams(i, i2));
            this.f354ms = 1;
            this.xr = 0.0f;
            this.ah = 0.0f;
            this.d = -1;
            this.ka = -1.0f;
            this.c = -1;
            this.ab = -1;
            this.x = ViewCompat.MEASURED_SIZE_MASK;
            this.ny = ViewCompat.MEASURED_SIZE_MASK;
        }

        public ms(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f354ms = 1;
            this.xr = 0.0f;
            this.ah = 0.0f;
            this.d = -1;
            this.ka = -1.0f;
            this.c = -1;
            this.ab = -1;
            this.x = ViewCompat.MEASURED_SIZE_MASK;
            this.ny = ViewCompat.MEASURED_SIZE_MASK;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.xr
        public int ms() {
            return this.width;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.xr
        public int xr() {
            return this.height;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.xr
        public int ah() {
            return this.f354ms;
        }

        public void ah(int i) {
            this.f354ms = i;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.xr
        public float d() {
            return this.xr;
        }

        public void ms(float f) {
            this.xr = f;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.xr
        public float ka() {
            return this.ah;
        }

        public void xr(float f) {
            this.ah = f;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.xr
        public int c() {
            return this.d;
        }

        public void d(int i) {
            this.d = i;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.xr
        public int ab() {
            return this.c;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.xr
        public void ms(int i) {
            this.c = i;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.xr
        public int x() {
            return this.ab;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.xr
        public void xr(int i) {
            this.ab = i;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.xr
        public int ny() {
            return this.x;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.xr
        public int ch() {
            return this.ny;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.xr
        public boolean hi() {
            return this.ch;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.xr
        public float sl() {
            return this.ka;
        }

        public void ah(float f) {
            this.ka = f;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.xr
        public int zb() {
            return this.leftMargin;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.xr
        public int u() {
            return this.topMargin;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.xr
        public int ub() {
            return this.rightMargin;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.xr
        public int ao() {
            return this.bottomMargin;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f354ms);
            parcel.writeFloat(this.xr);
            parcel.writeFloat(this.ah);
            parcel.writeInt(this.d);
            parcel.writeFloat(this.ka);
            parcel.writeInt(this.c);
            parcel.writeInt(this.ab);
            parcel.writeInt(this.x);
            parcel.writeInt(this.ny);
            parcel.writeByte(this.ch ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.bottomMargin);
            parcel.writeInt(this.leftMargin);
            parcel.writeInt(this.rightMargin);
            parcel.writeInt(this.topMargin);
            parcel.writeInt(this.height);
            parcel.writeInt(this.width);
        }

        protected ms(Parcel parcel) {
            super(0, 0);
            this.f354ms = 1;
            this.xr = 0.0f;
            this.ah = 0.0f;
            this.d = -1;
            this.ka = -1.0f;
            this.c = -1;
            this.ab = -1;
            this.x = ViewCompat.MEASURED_SIZE_MASK;
            this.ny = ViewCompat.MEASURED_SIZE_MASK;
            this.f354ms = parcel.readInt();
            this.xr = parcel.readFloat();
            this.ah = parcel.readFloat();
            this.d = parcel.readInt();
            this.ka = parcel.readFloat();
            this.c = parcel.readInt();
            this.ab = parcel.readInt();
            this.x = parcel.readInt();
            this.ny = parcel.readInt();
            this.ch = parcel.readByte() != 0;
            this.bottomMargin = parcel.readInt();
            this.leftMargin = parcel.readInt();
            this.rightMargin = parcel.readInt();
            this.topMargin = parcel.readInt();
            this.height = parcel.readInt();
            this.width = parcel.readInt();
        }
    }

    public void ms(com.bytedance.adsdk.ugeno.xr.ah ahVar) {
        this.h = ahVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.adsdk.ugeno.ah ahVar = this.h;
        if (ahVar != null) {
            ahVar.ka();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.bytedance.adsdk.ugeno.ah ahVar = this.h;
        if (ahVar != null) {
            ahVar.c();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.bytedance.adsdk.ugeno.ah ahVar = this.h;
        if (ahVar != null) {
            ahVar.ms(z);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        com.bytedance.adsdk.ugeno.ah ahVar = this.h;
        if (ahVar != null) {
            ahVar.xr(i, i2, i3, i4);
        }
    }
}
