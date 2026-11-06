package com.byazt.ua;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bumptech.glide.load.Key;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public static boolean c;
    public static boolean fw;
    public static Method hn;
    public static final pr k;
    public static final x m;
    public static List<C0203c> pr;
    public static Method uc;
    public static boolean x;
    public static boolean zo;
    public static boolean hw = true;
    public static final Rect aj = new Rect();
    public static final Rect vk = new Rect();
    public static final Rect w = new Rect();

    static {
        k = new pr();
        m = new x();
    }

    public static boolean pr() {
        List<C0203c> list = pr;
        if (list == null || list.isEmpty()) {
            return false;
        }
        for (C0203c c0203c : list) {
            if (c0203c == null || c0203c.hw == null || !c0203c.hw.isAttachedToWindow()) {
                return false;
            }
        }
        return true;
    }

    public static void hw() {
        pr = null;
        com.byazt.ua.x.hn();
    }

    public static List<C0203c> hn() {
        return pr;
    }

    public static hw pr(Activity activity) {
        hn hnVarPr;
        hw hwVar = new hw();
        if (activity == null || activity.getWindow() == null) {
            return hwVar;
        }
        View decorView = activity.getWindow().getDecorView();
        ViewGroup viewGroupPr = pr(decorView, decorView.getResources().getDisplayMetrics().widthPixels, decorView.getResources().getDisplayMetrics().heightPixels);
        if (viewGroupPr != null) {
            hwVar.pr = viewGroupPr.getClass().getName();
        }
        if (viewGroupPr == null) {
            return hwVar;
        }
        List<C0203c> listPr = pr(viewGroupPr);
        hwVar.x = listPr;
        int iHw = com.byazt.ua.x.hw();
        if (iHw >= 0 && iHw < listPr.size()) {
            hnVarPr = new hn(iHw, 100, "history click");
        } else {
            hnVarPr = pr(listPr);
            vk.pr(hnVarPr.pr, hnVarPr.hw, hnVarPr.hn);
        }
        hwVar.hw = hnVarPr.pr;
        hwVar.hn = hnVarPr.hw;
        if (hwVar.hw >= 0 && hwVar.hw < listPr.size()) {
            hwVar.c = listPr.get(hwVar.hw).pr();
        }
        if (listPr != null && !listPr.isEmpty()) {
            com.byazt.ua.x.hn();
            hw(viewGroupPr, listPr);
            com.byazt.ua.x.pr(hnVarPr.pr);
            com.byazt.ua.x.pr(viewGroupPr);
            pr = listPr;
            vk.pr(listPr.size(), hwVar.c);
        }
        return hwVar;
    }

    public static int x() {
        List<C0203c> list = pr;
        if (list == null || list.isEmpty()) {
            return -1;
        }
        for (C0203c c0203c : list) {
            if (c0203c == null || c0203c.hw == null || !c0203c.hw.isAttachedToWindow()) {
                return -1;
            }
        }
        hn hnVarPr = pr(list);
        vk.hw(hnVarPr.pr, hnVarPr.hw, hnVarPr.hn);
        return hnVarPr.pr;
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID, 401})
    public static class hw {
        public List<C0203c> x;
        public String pr = "";
        public int hw = -1;
        public int hn = 0;
        public String c = "";

        public String toString() {
            return "Result{bottomBarClassName='" + this.pr + "', selectedIndex=" + this.hw + ", selectedConfidence=" + this.hn + ", tabInfos=" + this.x + ", selectedTabLabel='" + this.c + '\'' + AbstractJsonLexerKt.END_OBJ;
        }
    }

    /* JADX INFO: renamed from: com.byazt.ua.c$c, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID, 1548})
    public static class C0203c {
        public String hn;
        public final View hw;
        public final int pr;
        public final Rect x;

        public C0203c(int i, View view, String str, Rect rect) {
            this.pr = i;
            this.hw = view;
            this.hn = str;
            this.x = rect;
        }

        public String pr() {
            if (!c.hw(this.hn)) {
                return this.hn + "_Tab_" + this.pr;
            }
            View view = this.hw;
            if (view != null && view.isAttachedToWindow() && Thread.currentThread() == Looper.getMainLooper().getThread()) {
                String strHw = c.hw(this.hw);
                if (!c.hw(strHw)) {
                    this.hn = strHw;
                    return strHw + "_Tab_" + this.pr;
                }
            }
            return "Tab_" + this.pr;
        }

        public String toString() {
            return "TabInfo{index=" + this.pr + ", tabRoot=" + this.hw + ", text='" + this.hn + "', rect=" + this.x + AbstractJsonLexerKt.END_OBJ;
        }
    }

    private static ViewGroup pr(View view, int i, int i2) {
        return pr(view, i, i2, true);
    }

    /* JADX WARN: Code duplicated, block: B:60:0x00fb  */
    private static ViewGroup pr(View view, int i, int i2, boolean z) {
        boolean z2;
        boolean z3;
        if (!(view instanceof ViewGroup) || view.getVisibility() != 0) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        boolean zPr = vk.pr();
        ArrayList arrayList = new ArrayList(viewGroup.getChildCount());
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if (childAt != null && childAt.getVisibility() == 0 && childAt.getWidth() > 0 && childAt.getHeight() > 0) {
                arrayList.add(childAt);
            }
        }
        boolean z4 = true;
        if (arrayList.size() >= 3 && arrayList.size() <= 6) {
            Rect rect = aj;
            rect.setEmpty();
            if (viewGroup.getGlobalVisibleRect(rect)) {
                if (rect.width() >= ((double) i) * 0.9d) {
                    double d = i2;
                    if (rect.bottom >= 0.9d * d && rect.height() <= d * 0.2d) {
                        int iWidth = rect.width() / arrayList.size();
                        int i4 = iWidth / 2;
                        Iterator it = arrayList.iterator();
                        int iCenterX = -1;
                        while (true) {
                            if (!it.hasNext()) {
                                z3 = true;
                                break;
                            }
                            View view2 = (View) it.next();
                            Rect rect2 = vk;
                            rect2.setEmpty();
                            view2.getGlobalVisibleRect(rect2);
                            if (iCenterX != -1 && rect2.centerX() <= iCenterX) {
                                z3 = false;
                                break;
                            }
                            iCenterX = rect2.centerX();
                            if (Math.abs(rect2.width() - iWidth) > i4) {
                                rect2.width();
                                z3 = false;
                                break;
                            }
                        }
                        if (z3) {
                            Iterator it2 = arrayList.iterator();
                            do {
                                if (!it2.hasNext()) {
                                    z4 = false;
                                    break;
                                }
                            } while (!(((View) it2.next()) instanceof ViewGroup));
                            if (z4) {
                                return viewGroup;
                            }
                        }
                        if (zPr && !z) {
                            arrayList.size();
                        }
                    } else if (zPr && !z) {
                        arrayList.size();
                        rect.width();
                        int i5 = rect.bottom;
                        rect.height();
                    }
                } else if (zPr) {
                    arrayList.size();
                    rect.width();
                    int i6 = rect.bottom;
                    rect.height();
                }
            }
        } else if (arrayList.size() > 6 && arrayList.size() <= 15) {
            Rect rect3 = aj;
            rect3.setEmpty();
            if (viewGroup.getGlobalVisibleRect(rect3) && rect3.width() >= ((double) i) * 0.9d) {
                double d2 = i2;
                if (rect3.bottom >= 0.9d * d2 && rect3.height() <= d2 * 0.2d) {
                    ArrayList arrayList2 = new ArrayList(arrayList);
                    pr(viewGroup, arrayList2);
                    int size = arrayList2.size();
                    if (size >= 3 && size <= 6) {
                        int iWidth2 = rect3.width();
                        int i7 = iWidth2 / size;
                        int i8 = i7 / 2;
                        int i9 = 0;
                        int iCenterX2 = -1;
                        while (true) {
                            if (i9 >= size) {
                                z2 = true;
                                break;
                            }
                            View view3 = (View) arrayList2.get(i9);
                            Rect rect4 = vk;
                            rect4.setEmpty();
                            view3.getGlobalVisibleRect(rect4);
                            if (iCenterX2 != -1 && rect4.centerX() <= iCenterX2 + (iWidth2 * 0.05f)) {
                                z2 = false;
                                break;
                            }
                            iCenterX2 = rect4.centerX();
                            if (Math.abs(rect4.width() - i7) <= i8) {
                                i9++;
                            } else {
                                z2 = false;
                                break;
                            }
                        }
                        if (z2) {
                            Iterator it3 = arrayList2.iterator();
                            do {
                                if (!it3.hasNext()) {
                                    z4 = false;
                                    break;
                                }
                            } while (!(((View) it3.next()) instanceof ViewGroup));
                            if (z4) {
                                if (zPr) {
                                    arrayList.size();
                                }
                                return viewGroup;
                            }
                        }
                        if (zPr && !z) {
                            arrayList.size();
                        }
                    }
                }
            }
        } else if (zPr && !z) {
            arrayList.size();
            arrayList.size();
        }
        for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
            ViewGroup viewGroupPr = pr(viewGroup.getChildAt(i10), i, i2, false);
            if (viewGroupPr != null) {
                return viewGroupPr;
            }
        }
        return null;
    }

    private static List<C0203c> pr(ViewGroup viewGroup) {
        List<View> listHw = hw(viewGroup);
        if (listHw.size() > 6) {
            pr(viewGroup, listHw);
        }
        ArrayList arrayList = new ArrayList(listHw.size());
        for (int i = 0; i < listHw.size(); i++) {
            View view = listHw.get(i);
            Rect rect = w;
            rect.setEmpty();
            view.getGlobalVisibleRect(rect);
            arrayList.add(new C0203c(i, view, hw(view), new Rect(rect)));
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0082  */
    private static void pr(ViewGroup viewGroup, List<View> list) {
        boolean z;
        if (list == null || list.size() < 3) {
            return;
        }
        Rect rect = aj;
        rect.setEmpty();
        if (viewGroup.getGlobalVisibleRect(rect)) {
            int iWidth = rect.width();
            int iHeight = rect.height();
            if (iWidth == 0 || iHeight == 0) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                View view = list.get(size);
                Rect rect2 = vk;
                rect2.setEmpty();
                view.getGlobalVisibleRect(rect2);
                int iWidth2 = rect2.width();
                int iHeight2 = rect2.height();
                float f = iWidth2;
                float f2 = iWidth;
                if (f >= 0.92f * f2 && iHeight2 >= iHeight * 0.6f) {
                    list.remove(size);
                } else if (f > 0.03f * f2) {
                    float f3 = iHeight2;
                    float f4 = iHeight;
                    if (f3 <= 0.12f * f4) {
                        list.remove(size);
                    } else if (f < f2 * 0.07f || f3 < f4 * 0.35f) {
                        list.remove(size);
                    }
                } else {
                    list.remove(size);
                }
            }
            int size2 = list.size();
            int i = 0;
            while (true) {
                int i2 = size2 - 1;
                if (i >= i2) {
                    break;
                }
                int i3 = 0;
                while (i3 < i2 - i) {
                    View view2 = list.get(i3);
                    Rect rect3 = vk;
                    rect3.setEmpty();
                    view2.getGlobalVisibleRect(rect3);
                    int iCenterX = rect3.centerX();
                    int i4 = i3 + 1;
                    View view3 = list.get(i4);
                    rect3.setEmpty();
                    view3.getGlobalVisibleRect(rect3);
                    if (iCenterX > rect3.centerX()) {
                        list.set(i3, view3);
                        list.set(i4, view2);
                    }
                    i3 = i4;
                }
                i++;
            }
            for (int size3 = list.size() - 1; size3 > 0; size3--) {
                View view4 = list.get(size3);
                int i5 = size3 - 1;
                View view5 = list.get(i5);
                Rect rect4 = new Rect();
                view4.getGlobalVisibleRect(rect4);
                Rect rect5 = new Rect();
                view5.getGlobalVisibleRect(rect5);
                boolean z2 = ((float) Math.abs(rect4.centerX() - rect5.centerX())) <= ((float) iWidth) * 0.06f;
                if (!z2 && Rect.intersects(rect4, rect5)) {
                    Rect rect6 = new Rect(rect4);
                    rect6.intersect(rect5);
                    z = ((float) (rect6.width() * rect6.height())) >= ((float) Math.min(rect4.width() * rect4.height(), rect5.width() * rect5.height())) * 0.35f;
                } else {
                    z = false;
                }
                if (z2 || z) {
                    if (rect4.width() * rect4.height() >= rect5.width() * rect5.height()) {
                        list.remove(i5);
                    } else {
                        list.remove(size3);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String hw(View view) {
        return pr(view, "");
    }

    private static String pr(View view, String str) {
        CharSequence text;
        if (view == null || view.getVisibility() != 0) {
            return str;
        }
        if ((view instanceof TextView) && (text = ((TextView) view).getText()) != null) {
            String strTrim = text.toString().trim();
            if (!strTrim.isEmpty() && strTrim.length() <= 8 && (str.isEmpty() || strTrim.length() < str.length())) {
                str = strTrim;
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                str = pr(viewGroup.getChildAt(i), str);
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hw(String str) {
        return TextUtils.isEmpty(str) || str.trim().length() == 0;
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID, 917})
    private static class hn {
        public String hn;
        public int hw;
        public int pr;

        public hn(int i, int i2, String str) {
            this.pr = i;
            this.hw = i2;
            this.hn = str;
        }
    }

    private static boolean hn(String str) {
        if (str == null) {
            return false;
        }
        if (!str.contains(pr(new byte[]{-36, -82, -80, -33, 125, -121})) && !str.contains(pr(new byte[]{-33, -118, -100, -37, -82, 119})) && !str.contains(pr(new byte[]{-35, -100, -123, -37, 126, -97})) && !str.contains(pr(new byte[]{-34, -85, -112, -33, -120, -89})) && !str.contains(pr(new byte[]{-36, -123, -122, -35, -124, -90})) && !str.contains(pr(new byte[]{-35, -80, -104, -37, -126, 123})) && !str.contains(pr(new byte[]{-36, -86, -79, -37, ByteCompanionObject.MIN_VALUE, -98})) && !str.contains(pr(new byte[]{-38, -79, -79, -37, ByteCompanionObject.MIN_VALUE, -105})) && !str.contains(pr(new byte[]{-34, -85, -112}))) {
            return false;
        }
        return true;
    }

    private static String pr(byte[] bArr) {
        try {
            byte[] bArr2 = new byte[bArr.length];
            for (int i = 0; i < bArr.length; i++) {
                bArr2[i] = (byte) (bArr[i] + 10);
            }
            return new String(bArr2, Key.STRING_CHARSET_NAME);
        } catch (Throwable th) {
            return "";
        }
    }

    private static hn pr(List<C0203c> list) {
        if (list == null || list.isEmpty()) {
            return new hn(-1, 0, "no tabs");
        }
        boolean zPr = vk.pr();
        int size = list.size();
        int[] iArr = new int[size];
        HashMap map = null;
        if (zPr) {
            map = new HashMap(size);
            for (int i = 0; i < size; i++) {
                map.put(Integer.valueOf(i), new ArrayList());
            }
        }
        int[] iArr2 = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr2[i2] = hw(list.get(i2).hw, list.get(i2).hn);
        }
        int iPr = pr(iArr2);
        if (iPr != -1) {
            iArr[iPr] = iArr[iPr] + 5;
            pr(map, iPr, "textColorOdd +5");
        }
        for (int i3 = 0; i3 < size; i3++) {
            C0203c c0203c = list.get(i3);
            boolean zHn = hn(c0203c.hn);
            x xVarHn = hn(c0203c.hw);
            if (xVarHn.pr) {
                int i4 = xVarHn.hw ? 6 : 0;
                if (xVarHn.hn) {
                    i4 += 4;
                }
                if (xVarHn.x) {
                    i4++;
                }
                if (xVarHn.c) {
                    i4 += 2;
                }
                if (xVarHn.uc) {
                    i4++;
                }
                iArr[i3] = iArr[i3] + i4;
                pr(map, i3, "stateHit +".concat(String.valueOf(i4)));
            }
            if (c(c0203c.hw)) {
                if (zHn) {
                    pr(map, i3, "lottie ignored(marketing)");
                } else {
                    iArr[i3] = iArr[i3] + 2;
                    pr(map, i3, "lottieAnimating +2");
                }
            }
        }
        float[] fArr = new float[size];
        for (int i5 = 0; i5 < size; i5++) {
            fArr[i5] = x(list.get(i5).hw);
        }
        int iPr2 = pr(fArr, 0.15f);
        if (iPr2 != -1) {
            if (hn(list.get(iPr2).hn)) {
                pr(map, iPr2, "alphaOdd ignored(marketing)");
            } else {
                iArr[iPr2] = iArr[iPr2] + 2;
                pr(map, iPr2, "alphaOdd +2");
            }
        }
        int iMax = Integer.MIN_VALUE;
        int i6 = Integer.MIN_VALUE;
        int i7 = -1;
        for (int i8 = 0; i8 < size; i8++) {
            int i9 = iArr[i8];
            if (i9 > i6) {
                i7 = i8;
                i6 = i9;
            }
        }
        if (i6 <= 0) {
            return new hn(-1, 0, "no strong signals");
        }
        for (int i10 = 0; i10 < size; i10++) {
            if (i10 != i7) {
                iMax = Math.max(iMax, iArr[i10]);
            }
        }
        return new hn(i7, Math.max(0, i6 - iMax) + i6, (!zPr || map == null) ? "" : String.valueOf(map.get(Integer.valueOf(i7))));
    }

    private static void pr(Map<Integer, List<String>> map, int i, String str) {
        List<String> list;
        if (map != null && (list = map.get(Integer.valueOf(i))) != null) {
            list.add(str);
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID, MediaPlayer.MEDIA_PLAYER_OPTION_ASYNC_INIT_CODEC})
    private static class x {
        public boolean c;
        public boolean hn;
        public boolean hw;
        public boolean pr;
        public boolean uc;
        public boolean x;

        private x() {
        }
    }

    private static x hn(View view) {
        x xVar = m;
        xVar.uc = false;
        xVar.c = false;
        xVar.x = false;
        xVar.hn = false;
        xVar.hw = false;
        xVar.pr = false;
        pr(view, xVar);
        xVar.pr = xVar.hw || xVar.hn || xVar.x || xVar.c || xVar.uc;
        return xVar;
    }

    private static void pr(View view, x xVar) {
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        if (view.isSelected()) {
            xVar.hw = true;
        }
        if (view.isActivated()) {
            xVar.hn = true;
        }
        if (view.isPressed()) {
            xVar.x = true;
        }
        if (view.isFocused()) {
            xVar.c = true;
        }
        if (fw(view)) {
            xVar.uc = true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                pr(viewGroup.getChildAt(i), xVar);
            }
        }
    }

    private static int hw(View view, String str) {
        TextView textView;
        CharSequence text;
        if (view == null || view.getVisibility() != 0) {
            return 0;
        }
        if ((view instanceof TextView) && (text = (textView = (TextView) view).getText()) != null) {
            String strTrim = text.toString().trim();
            if (!strTrim.isEmpty() && (str == null || str.isEmpty() || strTrim.equals(str))) {
                return textView.getCurrentTextColor();
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                int iHw = hw(viewGroup.getChildAt(i), str);
                if (iHw != 0) {
                    return iHw;
                }
            }
        }
        return 0;
    }

    private static int pr(int[] iArr) {
        if (iArr == null || iArr.length < 3) {
            return -1;
        }
        HashMap map = new HashMap();
        for (int i : iArr) {
            if (i != 0) {
                map.put(Integer.valueOf(i), Integer.valueOf(((Integer) map.getOrDefault(Integer.valueOf(i), 0)).intValue() + 1));
            }
        }
        int iIntValue = 0;
        int iIntValue2 = 0;
        for (Map.Entry entry : map.entrySet()) {
            if (((Integer) entry.getValue()).intValue() > iIntValue) {
                iIntValue = ((Integer) entry.getValue()).intValue();
                iIntValue2 = ((Integer) entry.getKey()).intValue();
            }
        }
        if (iIntValue >= iArr.length / 2) {
            int i2 = -1;
            int i3 = 0;
            for (int i4 = 0; i4 < iArr.length; i4++) {
                int i5 = iArr[i4];
                if (i5 != 0 && i5 != iIntValue2) {
                    i3++;
                    i2 = i4;
                }
            }
            if (i3 == 1) {
                return i2;
            }
        }
        return -1;
    }

    private static float x(View view) {
        pr prVar = k;
        prVar.pr = 0.0f;
        prVar.hw = 0;
        pr(view, prVar);
        if (prVar.hw == 0) {
            return 1.0f;
        }
        return prVar.pr / prVar.hw;
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID, 169})
    private static class pr {
        public int hw;
        public float pr;

        private pr() {
        }
    }

    private static void pr(View view, pr prVar) {
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        if (!(view instanceof ViewGroup)) {
            prVar.pr += view.getAlpha();
            prVar.hw++;
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            pr(viewGroup.getChildAt(i), prVar);
        }
    }

    private static int pr(float[] fArr, float f) {
        if (fArr == null || fArr.length < 3) {
            return -1;
        }
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (float f4 : fArr) {
            f3 += f4;
        }
        float length = f3 / fArr.length;
        int i = -1;
        for (int i2 = 0; i2 < fArr.length; i2++) {
            float fAbs = Math.abs(fArr[i2] - length);
            if (fAbs > f2) {
                i = i2;
                f2 = fAbs;
            }
        }
        if (f2 >= f) {
            return i;
        }
        return -1;
    }

    private static boolean c(View view) {
        if (view == null || view.getVisibility() != 0) {
            return false;
        }
        if (uc(view)) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                if (c(viewGroup.getChildAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean uc(View view) {
        if (view == null || !view.getClass().getSimpleName().contains("LottieAnimationView")) {
            return false;
        }
        if (!fw && !zo) {
            try {
                Method method = view.getClass().getMethod("isAnimating", new Class[0]);
                method.setAccessible(true);
                uc = method;
            } catch (Throwable th) {
                try {
                    zo = true;
                    uc = null;
                } catch (Throwable th2) {
                    fw = true;
                    throw th2;
                }
            }
            fw = true;
        }
        Method method2 = uc;
        if (method2 != null && !zo) {
            try {
                Object objInvoke = method2.invoke(view, new Object[0]);
                return (objInvoke instanceof Boolean) && ((Boolean) objInvoke).booleanValue();
            } catch (Throwable th3) {
                zo = true;
                uc = null;
            }
        }
        return false;
    }

    private static boolean fw(View view) {
        if (view == null || view.getVisibility() != 0) {
            return false;
        }
        if (hw) {
            try {
                if (view.isHovered()) {
                    return true;
                }
            } catch (NoSuchMethodError e) {
                hw = false;
            } catch (Throwable th) {
            }
        }
        if (!x && !c) {
            try {
                Method method = View.class.getMethod("isHovered", new Class[0]);
                method.setAccessible(true);
                hn = method;
            } catch (Throwable th2) {
                try {
                    c = true;
                    hn = null;
                } catch (Throwable th3) {
                    x = true;
                    throw th3;
                }
            }
            x = true;
        }
        Method method2 = hn;
        if (method2 != null && !c) {
            try {
                Object objInvoke = method2.invoke(view, new Object[0]);
                return (objInvoke instanceof Boolean) && ((Boolean) objInvoke).booleanValue();
            } catch (Throwable th4) {
                c = true;
                hn = null;
            }
        }
        return false;
    }

    private static void hw(ViewGroup viewGroup, List<C0203c> list) {
        for (C0203c c0203c : list) {
            com.byazt.ua.x.pr(c0203c.hw, c0203c);
        }
    }

    private static List<View> hw(ViewGroup viewGroup) {
        ArrayList arrayList = new ArrayList(viewGroup.getChildCount());
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt != null && childAt.getVisibility() == 0) {
                arrayList.add(childAt);
            }
        }
        return arrayList;
    }
}
