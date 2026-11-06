package com.byazt.uq;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.byazt.pp.LottieAnimationView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_CHECK_SILENCE_INTERVAL, 18})
public class l {
    public static final n d;
    public static boolean fs = false;
    public static boolean l = false;
    public static volatile List<C0366l> n = null;
    public static final q oa;
    public static boolean q = false;
    public static boolean qg = true;
    public static Method s;
    public static Method w;
    public static boolean x;
    public static final Rect rv = new Rect();
    public static final Rect tj = new Rect();
    public static final Rect cp = new Rect();

    static {
        d = new n();
        oa = new q();
    }

    public static boolean n() {
        List<C0366l> list = n;
        if (list == null || list.isEmpty()) {
            return false;
        }
        for (C0366l c0366l : list) {
            if (c0366l == null || c0366l.qg == null || !c0366l.qg.isAttachedToWindow()) {
                return false;
            }
        }
        return true;
    }

    public static void qg() {
        n = null;
        com.byazt.uq.q.s();
    }

    public static List<C0366l> s() {
        return n;
    }

    public static List<C0366l> q() {
        return n;
    }

    public static qg n(Activity activity) {
        s sVarN;
        qg qgVar = new qg();
        if (activity != null && activity.getWindow() != null) {
            View decorView = activity.getWindow().getDecorView();
            ViewGroup viewGroupN = n(decorView, decorView.getResources().getDisplayMetrics().widthPixels, decorView.getResources().getDisplayMetrics().heightPixels);
            if (viewGroupN != null) {
                qgVar.n = viewGroupN.getClass().getName();
            }
            if (viewGroupN == null) {
                return qgVar;
            }
            List<C0366l> listN = n(viewGroupN);
            qgVar.q = listN;
            int iQg = com.byazt.uq.q.qg();
            if (iQg >= 0 && iQg < listN.size()) {
                sVarN = new s(iQg, 100, "history click");
            } else {
                sVarN = n(listN);
                d.n(sVarN.n, sVarN.qg, sVarN.s);
            }
            qgVar.qg = sVarN.n;
            qgVar.s = sVarN.qg;
            if (qgVar.qg >= 0 && qgVar.qg < listN.size()) {
                qgVar.l = listN.get(qgVar.qg).n();
            }
            if (listN != null && !listN.isEmpty()) {
                com.byazt.uq.q.s();
                qg(viewGroupN, listN);
                com.byazt.uq.q.n(sVarN.n);
                com.byazt.uq.q.n(viewGroupN);
                n = listN;
                d.n(listN.size(), qgVar.l);
            }
        }
        return qgVar;
    }

    public static int l() {
        List<C0366l> list = n;
        if (list == null || list.isEmpty()) {
            return -1;
        }
        for (C0366l c0366l : list) {
            if (c0366l == null || c0366l.qg == null || !c0366l.qg.isAttachedToWindow()) {
                return -1;
            }
        }
        s sVarN = n(list);
        d.qg(sVarN.n, sVarN.qg, sVarN.s);
        return sVarN.n;
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_CHECK_SILENCE_INTERVAL, 120})
    public static class qg {
        public List<C0366l> q;
        public String n = "";
        public int qg = -1;
        public int s = 0;
        public String l = "";

        public String toString() {
            return "Result{bottomBarClassName='" + this.n + "', selectedIndex=" + this.qg + ", selectedConfidence=" + this.s + ", tabInfos=" + this.q + ", selectedTabLabel='" + this.l + "'}";
        }
    }

    /* JADX INFO: renamed from: com.byazt.uq.l$l, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_CHECK_SILENCE_INTERVAL, 1902})
    public static class C0366l {
        public final int n;
        public final Rect q;
        public final View qg;
        public String s;

        public C0366l(int i, View view, String str, Rect rect) {
            this.n = i;
            this.qg = view;
            this.s = str;
            this.q = rect;
        }

        public String n() {
            if (!l.qg(this.s)) {
                return this.s + "-Tab-" + this.n;
            }
            View view = this.qg;
            if (view != null && view.isAttachedToWindow() && Thread.currentThread() == Looper.getMainLooper().getThread()) {
                String strQg = l.qg(this.qg);
                if (!l.qg(strQg)) {
                    this.s = strQg;
                    return strQg + "-Tab-" + this.n;
                }
            }
            return "Tab-" + this.n;
        }

        public String toString() {
            return "TabInfo{index=" + this.n + ", tabRoot=" + this.qg + ", text='" + this.s + "', rect=" + this.q + AbstractJsonLexerKt.END_OBJ;
        }
    }

    private static ViewGroup n(View view, int i, int i2) {
        return n(view, i, i2, true);
    }

    /* JADX WARN: Code duplicated, block: B:58:0x00f1  */
    private static ViewGroup n(View view, int i, int i2, boolean z) {
        boolean z2;
        boolean z3;
        if (!(view instanceof ViewGroup) || view.getVisibility() != 0) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        boolean zN = d.n();
        ArrayList arrayList = new ArrayList(viewGroup.getChildCount());
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if (childAt != null && childAt.getVisibility() == 0 && childAt.getWidth() > 0 && childAt.getHeight() > 0) {
                arrayList.add(childAt);
            }
        }
        boolean z4 = true;
        if (arrayList.size() >= 3 && arrayList.size() <= 6) {
            Rect rect = rv;
            rect.setEmpty();
            if (viewGroup.getGlobalVisibleRect(rect)) {
                if (rect.width() >= ((double) i) * 0.9d) {
                    double d2 = i2;
                    if (rect.bottom >= 0.9d * d2 && rect.height() <= d2 * 0.2d) {
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
                            Rect rect2 = tj;
                            rect2.setEmpty();
                            view2.getGlobalVisibleRect(rect2);
                            if (iCenterX == -1 || rect2.centerX() > iCenterX) {
                                iCenterX = rect2.centerX();
                                if (Math.abs(rect2.width() - iWidth) > i4) {
                                    rect2.width();
                                }
                            }
                            z3 = false;
                            break;
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
                        if (zN && !z) {
                            arrayList.size();
                        }
                    } else if (zN && !z) {
                        arrayList.size();
                        rect.width();
                        int i5 = rect.bottom;
                        rect.height();
                    }
                } else if (zN) {
                    arrayList.size();
                    rect.width();
                    int i6 = rect.bottom;
                    rect.height();
                }
            }
        } else if (arrayList.size() > 6 && arrayList.size() <= 15) {
            Rect rect3 = rv;
            rect3.setEmpty();
            if (viewGroup.getGlobalVisibleRect(rect3) && rect3.width() >= ((double) i) * 0.9d) {
                double d3 = i2;
                if (rect3.bottom >= 0.9d * d3 && rect3.height() <= d3 * 0.2d) {
                    ArrayList arrayList2 = new ArrayList(arrayList);
                    n(viewGroup, arrayList2);
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
                            Rect rect4 = tj;
                            rect4.setEmpty();
                            view3.getGlobalVisibleRect(rect4);
                            if (iCenterX2 == -1 || rect4.centerX() > iCenterX2 + (iWidth2 * 0.05f)) {
                                iCenterX2 = rect4.centerX();
                                if (Math.abs(rect4.width() - i7) <= i8) {
                                    i9++;
                                }
                            }
                            z2 = false;
                            break;
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
                                if (zN) {
                                    arrayList.size();
                                }
                                return viewGroup;
                            }
                        }
                        if (zN && !z) {
                            arrayList.size();
                        }
                    }
                }
            }
        } else if (zN && !z) {
            arrayList.size();
            arrayList.size();
        }
        for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
            ViewGroup viewGroupN = n(viewGroup.getChildAt(i10), i, i2, false);
            if (viewGroupN != null) {
                return viewGroupN;
            }
        }
        return null;
    }

    private static List<C0366l> n(ViewGroup viewGroup) {
        List<View> listQg = qg(viewGroup);
        if (listQg.size() > 6) {
            n(viewGroup, listQg);
        }
        ArrayList arrayList = new ArrayList(listQg.size());
        for (int i = 0; i < listQg.size(); i++) {
            View view = listQg.get(i);
            Rect rect = cp;
            rect.setEmpty();
            view.getGlobalVisibleRect(rect);
            arrayList.add(new C0366l(i, view, qg(view), new Rect(rect)));
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0082  */
    /* JADX WARN: Code duplicated, block: B:56:0x013f  */
    private static void n(ViewGroup viewGroup, List<View> list) {
        boolean z;
        if (list == null || list.size() < 3) {
            return;
        }
        Rect rect = rv;
        rect.setEmpty();
        if (viewGroup.getGlobalVisibleRect(rect)) {
            int iWidth = rect.width();
            int iHeight = rect.height();
            if (iWidth == 0 || iHeight == 0) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                View view = list.get(size);
                Rect rect2 = tj;
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
                    Rect rect3 = tj;
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
                if (z2 || !Rect.intersects(rect4, rect5)) {
                    z = false;
                } else {
                    Rect rect6 = new Rect(rect4);
                    rect6.intersect(rect5);
                    if (rect6.width() * rect6.height() >= Math.min(rect4.width() * rect4.height(), rect5.width() * rect5.height()) * 0.35f) {
                        z = true;
                    } else {
                        z = false;
                    }
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
    public static String qg(View view) {
        return n(view, "");
    }

    private static String n(View view, String str) {
        CharSequence text;
        if (view != null && view.getVisibility() == 0) {
            if ((view instanceof TextView) && (text = ((TextView) view).getText()) != null) {
                String strTrim = text.toString().trim();
                if (!strTrim.isEmpty() && strTrim.length() <= 8 && (str.isEmpty() || strTrim.length() < str.length())) {
                    str = strTrim;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    str = n(viewGroup.getChildAt(i), str);
                }
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean qg(String str) {
        return TextUtils.isEmpty(str) || str.trim().length() == 0;
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_CHECK_SILENCE_INTERVAL, 1721})
    private static class s {
        public int n;
        public int qg;
        public String s;

        public s(int i, int i2, String str) {
            this.n = i;
            this.qg = i2;
            this.s = str;
        }
    }

    private static boolean s(String str) {
        if (str == null) {
            return false;
        }
        return str.contains(n(new byte[]{-36, -82, -80, -33, 125, -121})) || str.contains(n(new byte[]{-33, -118, -100, -37, -82, 119})) || str.contains(n(new byte[]{-35, -100, -123, -37, 126, -97})) || str.contains(n(new byte[]{-34, -85, -112, -33, -120, -89})) || str.contains(n(new byte[]{-36, -123, -122, -35, -124, -90})) || str.contains(n(new byte[]{-35, -80, -104, -37, -126, 123})) || str.contains(n(new byte[]{-36, -86, -79, -37, -128, -98})) || str.contains(n(new byte[]{-38, -79, -79, -37, -128, -105})) || str.contains(n(new byte[]{-34, -85, -112}));
    }

    private static String n(byte[] bArr) {
        try {
            byte[] bArr2 = new byte[bArr.length];
            for (int i = 0; i < bArr.length; i++) {
                bArr2[i] = (byte) (bArr[i] + 10);
            }
            return new String(bArr2, "UTF-8");
        } catch (Throwable unused) {
            return "";
        }
    }

    private static s n(List<C0366l> list) {
        HashMap map;
        if (list == null || list.isEmpty()) {
            return new s(-1, 0, "no tabs");
        }
        boolean zN = d.n();
        int size = list.size();
        int[] iArr = new int[size];
        if (zN) {
            map = new HashMap(size);
            for (int i = 0; i < size; i++) {
                map.put(Integer.valueOf(i), new ArrayList());
            }
        } else {
            map = null;
        }
        int[] iArr2 = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr2[i2] = qg(list.get(i2).qg, list.get(i2).s);
        }
        int iN = n(iArr2);
        if (iN != -1) {
            iArr[iN] = iArr[iN] + 5;
            n(map, iN, "textColorOdd +5");
        }
        for (int i3 = 0; i3 < size; i3++) {
            C0366l c0366l = list.get(i3);
            boolean zS = s(c0366l.s);
            q qVarS = s(c0366l.qg);
            if (qVarS.n) {
                int i4 = qVarS.qg ? 6 : 0;
                if (qVarS.s) {
                    i4 += 4;
                }
                if (qVarS.q) {
                    i4++;
                }
                if (qVarS.l) {
                    i4 += 2;
                }
                if (qVarS.w) {
                    i4++;
                }
                iArr[i3] = iArr[i3] + i4;
                n(map, i3, "stateHit +".concat(String.valueOf(i4)));
            }
            if (l(c0366l.qg)) {
                if (zS) {
                    n(map, i3, "lottie ignored(marketing)");
                } else {
                    iArr[i3] = iArr[i3] + 2;
                    n(map, i3, "lottieAnimating +2");
                }
            }
        }
        float[] fArr = new float[size];
        for (int i5 = 0; i5 < size; i5++) {
            fArr[i5] = q(list.get(i5).qg);
        }
        int iN2 = n(fArr, 0.15f);
        if (iN2 != -1) {
            if (s(list.get(iN2).s)) {
                n(map, iN2, "alphaOdd ignored(marketing)");
            } else {
                iArr[iN2] = iArr[iN2] + 2;
                n(map, iN2, "alphaOdd +2");
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
            return new s(-1, 0, "no strong signals");
        }
        for (int i10 = 0; i10 < size; i10++) {
            if (i10 != i7) {
                iMax = Math.max(iMax, iArr[i10]);
            }
        }
        return new s(i7, Math.max(0, i6 - iMax) + i6, (!zN || map == null) ? "" : String.valueOf(map.get(Integer.valueOf(i7))));
    }

    private static void n(Map<Integer, List<String>> map, int i, String str) {
        List<String> list;
        if (map == null || (list = map.get(Integer.valueOf(i))) == null) {
            return;
        }
        list.add(str);
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_CHECK_SILENCE_INTERVAL, 1901})
    private static class q {
        public boolean l;
        public boolean n;
        public boolean q;
        public boolean qg;
        public boolean s;
        public boolean w;

        private q() {
        }
    }

    private static q s(View view) {
        q qVar = oa;
        qVar.w = false;
        qVar.l = false;
        qVar.q = false;
        qVar.s = false;
        qVar.qg = false;
        qVar.n = false;
        n(view, qVar);
        qVar.n = qVar.qg || qVar.s || qVar.q || qVar.l || qVar.w;
        return qVar;
    }

    private static void n(View view, q qVar) {
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        if (view.isSelected()) {
            qVar.qg = true;
        }
        if (view.isActivated()) {
            qVar.s = true;
        }
        if (view.isPressed()) {
            qVar.q = true;
        }
        if (view.isFocused()) {
            qVar.l = true;
        }
        if (x(view)) {
            qVar.w = true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                n(viewGroup.getChildAt(i), qVar);
            }
        }
    }

    private static int qg(View view, String str) {
        TextView textView;
        CharSequence text;
        if (view != null && view.getVisibility() == 0) {
            if ((view instanceof TextView) && (text = (textView = (TextView) view).getText()) != null) {
                String strTrim = text.toString().trim();
                if (!strTrim.isEmpty() && (str == null || str.isEmpty() || strTrim.equals(str))) {
                    return textView.getCurrentTextColor();
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    int iQg = qg(viewGroup.getChildAt(i), str);
                    if (iQg != 0) {
                        return iQg;
                    }
                }
            }
        }
        return 0;
    }

    private static int n(int[] iArr) {
        if (iArr != null && iArr.length >= 3) {
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
        }
        return -1;
    }

    private static float q(View view) {
        n nVar = d;
        nVar.n = 0.0f;
        nVar.qg = 0;
        n(view, nVar);
        if (nVar.qg == 0) {
            return 1.0f;
        }
        return nVar.n / nVar.qg;
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_CHECK_SILENCE_INTERVAL, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    private static class n {
        public float n;
        public int qg;

        private n() {
        }
    }

    private static void n(View view, n nVar) {
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        if (!(view instanceof ViewGroup)) {
            nVar.n += view.getAlpha();
            nVar.qg++;
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            n(viewGroup.getChildAt(i), nVar);
        }
    }

    private static int n(float[] fArr, float f) {
        if (fArr != null && fArr.length >= 3) {
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
        }
        return -1;
    }

    private static boolean l(View view) {
        if (view != null && view.getVisibility() == 0) {
            if (w(view)) {
                return true;
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    if (l(viewGroup.getChildAt(i))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean w(View view) {
        if (view == null || !view.getClass().getSimpleName().contains(LottieAnimationView.n)) {
            return false;
        }
        if (!x && !fs) {
            try {
                try {
                    Method method = view.getClass().getMethod("isAnimating", new Class[0]);
                    method.setAccessible(true);
                    w = method;
                } catch (Throwable unused) {
                    fs = true;
                    w = null;
                }
                x = true;
            } catch (Throwable th) {
                x = true;
                throw th;
            }
        }
        Method method2 = w;
        if (method2 != null && !fs) {
            try {
                Object objInvoke = method2.invoke(view, new Object[0]);
                return (objInvoke instanceof Boolean) && ((Boolean) objInvoke).booleanValue();
            } catch (Throwable unused2) {
                fs = true;
                w = null;
            }
        }
        return false;
    }

    private static boolean x(View view) {
        if (view != null && view.getVisibility() == 0) {
            if (qg) {
                try {
                    if (view.isHovered()) {
                        return true;
                    }
                } catch (NoSuchMethodError unused) {
                    qg = false;
                } catch (Throwable unused2) {
                }
            }
            if (!q && !l) {
                try {
                    try {
                        Method method = View.class.getMethod("isHovered", new Class[0]);
                        method.setAccessible(true);
                        s = method;
                    } catch (Throwable unused3) {
                        l = true;
                        s = null;
                    }
                    q = true;
                } catch (Throwable th) {
                    q = true;
                    throw th;
                }
            }
            Method method2 = s;
            if (method2 != null && !l) {
                try {
                    Object objInvoke = method2.invoke(view, new Object[0]);
                    return (objInvoke instanceof Boolean) && ((Boolean) objInvoke).booleanValue();
                } catch (Throwable unused4) {
                    l = true;
                    s = null;
                }
            }
        }
        return false;
    }

    private static void qg(ViewGroup viewGroup, List<C0366l> list) {
        for (C0366l c0366l : list) {
            com.byazt.uq.q.n(c0366l.qg, c0366l);
        }
    }

    private static List<View> qg(ViewGroup viewGroup) {
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
