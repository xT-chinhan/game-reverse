package com.byazt.gp;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import com.anythink.core.common.d.i;
import com.anythink.core.common.f.e;
import com.anythink.core.e.d;
import com.byazt.vy.hu;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.gromore.R;
import com.bytedance.msdk.report.plugin.AdnMaterialWindowCopyUtils;
import com.bytedance.pangle.wrapper.PluginActivityWrapper;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 80, 13})
public final class w {
    public static final InterfaceC0184w n = new InterfaceC0184w() { // from class: com.byazt.gp.w.1
        @Override // com.byazt.gp.w.InterfaceC0184w
        public q n(qg qgVar) {
            return w.s(qgVar);
        }
    };
    public static final InterfaceC0184w qg = new InterfaceC0184w() { // from class: com.byazt.gp.w.2
        @Override // com.byazt.gp.w.InterfaceC0184w
        public q n(qg qgVar) {
            return w.q(qgVar);
        }
    };
    public static final l s = new l() { // from class: com.byazt.gp.w.3
        @Override // com.byazt.gp.w.l
        public boolean n() {
            return w.qg();
        }

        @Override // com.byazt.gp.w.l
        public String n(byte[] bArr, String str, String str2, long j) {
            return fs.n().n(bArr, str, str2, j);
        }
    };

    interface l {
        String n(byte[] bArr, String str, String str2, long j);

        boolean n();
    }

    @com.byazt.cp.n(n = {0, 1, 80, 108})
    static final class n {
        public int l;
        public byte[] n;
        public int q;
        public String qg;
        public int s;
    }

    @com.byazt.cp.n(n = {0, 1, 80, AVMDLDataLoader.KeyIsGetVersionInfo})
    static final class q {
        public Bitmap n;
        public boolean q;
        public n qg;
        public String s;
    }

    @com.byazt.cp.n(n = {0, 1, 80, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUX_NONBLOCK_READ})
    static final class qg {
        public AdnMaterialWindowCopyUtils.CopyRequest l;
        public ImageView n;
        public Bitmap q;
        public int qg;
        public int s;
        public long w;
        public boolean x;
    }

    /* JADX INFO: renamed from: com.byazt.gp.w$w, reason: collision with other inner class name */
    interface InterfaceC0184w {
        q n(qg qgVar);
    }

    private static boolean n(int i) {
        return i == 7 || i == 8 || i == 10;
    }

    public static void n(View view) {
        if (view == null) {
            return;
        }
        view.setTag(R.id.tt_mediation_adn_material_root_tag_key, Boolean.TRUE);
    }

    public static List<WeakReference<View>> n(ViewGroup viewGroup) {
        ArrayList arrayList = new ArrayList();
        if (viewGroup == null) {
            return arrayList;
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            arrayList.add(new WeakReference(viewGroup.getChildAt(i)));
        }
        return arrayList;
    }

    public static void n(ViewGroup viewGroup, List<WeakReference<View>> list) {
        if (viewGroup == null) {
            return;
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt != null && !n(list, childAt)) {
                n(childAt);
            }
        }
    }

    public static String n(com.byazt.sg.s sVar, View view, Map<String, Object> map, boolean z, boolean z2, boolean z3, int i, String str) {
        if (map == null) {
            return null;
        }
        s sVar2 = new s(1);
        s sVar3 = new s(1);
        ArrayList arrayList = new ArrayList();
        n(sVar, arrayList);
        if (sVar != null) {
            n(sVar.y(), arrayList);
        }
        boolean z4 = (z || z2) && qg();
        boolean z5 = z && z4;
        boolean z6 = z2 && z4;
        x xVarQg = qg(sVar, view, z5, z6, z3, i);
        n(xVarQg, arrayList, z5, sVar2, str);
        n(xVarQg, arrayList, z6, sVar3, str, z3);
        String strN = n(new JSONArray((Collection) arrayList));
        if (n(strN)) {
            return null;
        }
        return strN;
    }

    private static String n(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        try {
            return com.byazt.gp.q.n().n(jSONArray.toString().getBytes());
        } catch (Exception unused) {
            return null;
        }
    }

    private static boolean n(String str) {
        return !TextUtils.isEmpty(str) && str.length() > 512000;
    }

    private static void n(List<Map<String, Object>> list, int i, int i2, String str, String str2) {
        if (list == null || TextUtils.isEmpty(str2)) {
            return;
        }
        HashMap map = new HashMap();
        map.put("source", Integer.valueOf(i));
        map.put(e.a.d, str2);
        map.put("type", Integer.valueOf(i2));
        if (!TextUtils.isEmpty(str)) {
            map.put("result", str);
        }
        list.add(map);
    }

    private static boolean n(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        String lowerCase2 = str2.toLowerCase(Locale.US);
        return (lowerCase2.startsWith("http://") || lowerCase2.startsWith("https://")) && (lowerCase.contains("image") || lowerCase.contains("img") || lowerCase.contains("icon") || lowerCase.contains("pic") || lowerCase.contains(ImagesContract.URL));
    }

    private static void n(com.byazt.sg.s sVar, List<Map<String, Object>> list) {
        if (sVar == null) {
            return;
        }
        n(list, 1, 1, "t", sVar.ca());
        n(list, 1, 1, d.a, sVar.tr());
        n(list, 1, 3, "ic_u", sVar.eq());
        n(list, 1, 3, "im_u", sVar.ox());
        n(list, 1, 4, "v_u", sVar.x());
        n(list, 1, 1, "an", sVar.fl());
        n(list, 1, 1, "p_n", sVar.jh());
        n(list, 1, 1, "b_t", sVar.lg());
        n(list, 1, 1, com.anythink.core.common.b.e.a, sVar.ta());
        n(list, 1, 1, "v_d", sVar.on());
        n(list, 1, 1, "aun", sVar.i());
        n(list, 1, 1, "p_s", sVar.dw());
        n(list, 1, 1, "p_u", sVar.su());
        n(list, 1, 1, "v_n", sVar.g());
        n(list, 1, 1, "d_u", sVar.sh());
        JSONArray jSONArray = new JSONArray();
        List<String> listQh = sVar.qh();
        if (listQh != null && !listQh.isEmpty()) {
            Iterator<String> it = listQh.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            n(list, 1, 5, "image_list", jSONArray.toString());
        }
        n(com.byazt.gp.l.n(sVar.lq(), sVar.rf()), list, 1);
    }

    private static void n(Map<String, Object> map, List<Map<String, Object>> list) {
        if (map == null || map.isEmpty()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry != null && !TextUtils.isEmpty(entry.getKey())) {
                Object value = entry.getValue();
                if ((value instanceof String) || (value instanceof Number) || (value instanceof Boolean)) {
                    try {
                        jSONObject.putOpt(entry.getKey(), String.valueOf(value));
                    } catch (Exception unused) {
                    }
                }
            }
        }
        if (jSONObject.length() > 0) {
            n(list, 3, 5, "", jSONObject.toString());
        }
    }

    private static void n(Map<String, Object> map, List<Map<String, Object>> list, int i) {
        if (map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry != null && !TextUtils.isEmpty(entry.getKey())) {
                Object value = entry.getValue();
                if ((value instanceof String) || (value instanceof Number) || (value instanceof Boolean)) {
                    String strValueOf = String.valueOf(value);
                    n(list, i, n(entry.getKey(), strValueOf) ? 3 : 1, entry.getKey(), strValueOf);
                }
            }
        }
    }

    private static void n(List<Map<String, Object>> list, int i, int i2, String str, double d) {
        if (Double.isNaN(d) || Double.isInfinite(d) || d <= 0.0d) {
            return;
        }
        n(list, i, i2, str, String.valueOf(d));
    }

    private static void n(List<Map<String, Object>> list, int i, int i2, String str, long j) {
        if (j <= 0) {
            return;
        }
        n(list, i, i2, str, String.valueOf(j));
    }

    private static void n(com.byazt.sg.s sVar, x xVar, boolean z, boolean z2, boolean z3, int i) {
        Activity activityW = w();
        if (n(sVar, i, activityW) && activityW.getWindow() != null) {
            n(activityW.getWindow().getDecorView(), xVar, z);
            if (z2) {
                n(activityW.getWindow().getDecorView(), xVar.s, activityW.getWindow(), z3);
                return;
            }
            return;
        }
        qg(sVar, xVar, z, z2, z3, i);
    }

    private static x qg(final com.byazt.sg.s sVar, final View view, final boolean z, final boolean z2, final boolean z3, final int i) {
        if (com.byazt.rb.l.l()) {
            return s(sVar, view, z, z2, z3, i);
        }
        try {
            return (x) com.byazt.rb.l.n(new Callable<x>() { // from class: com.byazt.gp.w.4
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public x call() {
                    return w.s(sVar, view, z, z2, z3, i);
                }
            });
        } catch (Throwable unused) {
            return new x();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static x s(com.byazt.sg.s sVar, View view, boolean z, boolean z2, boolean z3, int i) {
        x xVar = new x();
        n(view, xVar, z, z2, z3);
        if (view == null) {
            n(sVar, xVar, z, z2, z3, i);
        }
        n(xVar.qg);
        return xVar;
    }

    private static void n(View view, x xVar, boolean z, boolean z2, boolean z3) {
        if (view != null && q(view)) {
            List<View> listL = l(view);
            if (listL.isEmpty()) {
                return;
            }
            Iterator<View> it = listL.iterator();
            while (it.hasNext()) {
                n(it.next(), xVar, z);
            }
            if (z2) {
                n(listL, xVar.s, z3);
            }
        }
    }

    private static void n(x xVar, List<Map<String, Object>> list, boolean z, s sVar, String str) {
        if (xVar == null) {
            return;
        }
        Iterator<String> it = xVar.n.iterator();
        while (it.hasNext()) {
            n(list, 2, 1, (String) null, it.next());
        }
        if (xVar.q) {
            n(list, 2, 6, (String) null, "1");
        }
        if (z) {
            Iterator<String> it2 = n(xVar.qg, sVar, str).iterator();
            while (it2.hasNext()) {
                n(list, 2, 7, (String) null, it2.next());
            }
        }
    }

    private static void n(x xVar, List<Map<String, Object>> list, boolean z, s sVar, String str, boolean z2) {
        if (xVar == null || !z) {
            return;
        }
        List<String> listQg = qg(xVar.s, sVar, str);
        int i = z2 ? 5 : 4;
        Iterator<String> it = listQg.iterator();
        while (it.hasNext()) {
            n(list, i, 7, (String) null, it.next());
        }
    }

    private static void n(View view, x xVar, boolean z) {
        if (xVar == null || view == null) {
            return;
        }
        n(view, xVar);
        if (z) {
            n(view, xVar.qg);
        }
    }

    private static void n(View view, x xVar) {
        ArrayList arrayList = new ArrayList();
        n(view, arrayList, xVar);
        Iterator<String> it = s(arrayList).iterator();
        while (it.hasNext()) {
            xVar.n.add(it.next());
        }
    }

    private static void n(View view, List<qg> list, Window window, boolean z) {
        if (view == null || list == null) {
            return;
        }
        list.addAll(n(view, window, z));
    }

    private static void n(List<View> list, List<qg> list2, boolean z) {
        if (list == null || list.isEmpty() || list2 == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (View view : list) {
            if (q(view)) {
                arrayList.add(view);
            }
        }
        Collections.sort(arrayList, new Comparator<View>() { // from class: com.byazt.gp.w.5
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public int compare(View view2, View view3) {
                return Long.compare(w.s(view3), w.s(view2));
            }
        });
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            List<qg> listN = n((View) it.next(), (Window) null, z);
            if (!listN.isEmpty()) {
                list2.addAll(listN);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long s(View view) {
        if (view == null) {
            return 0L;
        }
        return ((long) Math.max(0, view.getWidth())) * ((long) Math.max(0, view.getHeight()));
    }

    private static boolean q(View view) {
        return view != null && view.isAttachedToWindow() && view.getVisibility() == 0 && view.getWindowVisibility() == 0 && view.getAlpha() > 0.0f;
    }

    public static String n(q qVar, String str, l lVar) {
        if (qVar == null || qVar.q || qVar.qg == null || qVar.qg.n == null || qVar.qg.n.length == 0 || qVar.qg.n.length > x() || lVar == null || !lVar.n()) {
            return null;
        }
        return lVar.n(qVar.qg.n, qVar.qg.qg, str, System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean qg() {
        try {
            return !TextUtils.isEmpty(com.byazt.ng.qg.n().n);
        } catch (Throwable unused) {
            return false;
        }
    }

    private static List<View> l(View view) {
        ArrayList arrayList = new ArrayList();
        n(view, arrayList, 0);
        return arrayList;
    }

    private static void n(View view, List<View> list, int i) {
        if (view == null) {
            return;
        }
        if (Boolean.TRUE.equals(view.getTag(R.id.tt_mediation_adn_material_root_tag_key))) {
            list.add(view);
            return;
        }
        if (i < 50 && (view instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                n(viewGroup.getChildAt(i2), list, i + 1);
            }
        }
    }

    private static boolean n(List<WeakReference<View>> list, View view) {
        if (list != null && view != null) {
            for (WeakReference<View> weakReference : list) {
                if (weakReference != null && weakReference.get() == view) {
                    return true;
                }
            }
        }
        return false;
    }

    private static List<View> s() {
        try {
            return q();
        } catch (Throwable unused) {
            return Collections.emptyList();
        }
    }

    private static List<View> q() throws Exception {
        Class<?> cls = Class.forName("android.view.WindowManagerGlobal");
        Object objInvoke = cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        Field declaredField = cls.getDeclaredField("mViews");
        declaredField.setAccessible(true);
        Object obj = declaredField.get(objInvoke);
        ArrayList arrayList = new ArrayList();
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                if (obj2 instanceof View) {
                    arrayList.add((View) obj2);
                }
            }
        }
        return arrayList;
    }

    private static void qg(com.byazt.sg.s sVar, x xVar, boolean z, boolean z2, boolean z3, int i) {
        View viewQg;
        if (n(sVar, i) && (viewQg = qg(sVar.ci())) != null) {
            n(viewQg, xVar, z);
            if (z2) {
                n(viewQg, xVar.s, (Window) null, z3);
            }
        }
    }

    private static boolean n(com.byazt.sg.s sVar, int i) {
        if (sVar == null || sVar.rg()) {
            return false;
        }
        if (i <= 0) {
            i = sVar.ct();
        }
        return n(i);
    }

    private static View qg(String str) {
        View viewN;
        String[] strArrS = s(str);
        View view = null;
        if (strArrS != null && strArrS.length != 0) {
            View viewL = l();
            long j = 0;
            for (View view2 : s()) {
                if (view2 != null && view2 != viewL && q(view2) && (viewN = n(view2, strArrS, 0)) != null && q(viewN)) {
                    long jS = s(viewN);
                    if (view == null || jS > j) {
                        view = viewN;
                        j = jS;
                    }
                }
            }
        }
        return view;
    }

    private static View l() {
        Activity activityW = w();
        if (activityW == null || activityW.getWindow() == null) {
            return null;
        }
        return activityW.getWindow().getDecorView();
    }

    private static String[] s(String str) {
        if (s(str, MediationConstant.ADN_GDT)) {
            return new String[]{"com.qq.e."};
        }
        if (s(str, MediationConstant.ADN_KS)) {
            return new String[]{"com.kwad."};
        }
        if (s(str, "baidu")) {
            return new String[]{"com.baidu.mobads.", "com.baidu.mobad."};
        }
        if (s(str, MediationConstant.ADN_SIGMOB)) {
            return new String[]{"com.sigmob."};
        }
        return null;
    }

    private static View n(View view, String[] strArr, int i) {
        long jS;
        View view2 = null;
        if (view != null && strArr != null && strArr.length != 0) {
            if (n(view.getClass().getName(), strArr)) {
                jS = s(view);
                view2 = view;
            } else {
                jS = 0;
            }
            if (i >= 50) {
                return view2;
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    View viewN = n(viewGroup.getChildAt(i2), strArr, i + 1);
                    if (viewN != null) {
                        long jS2 = s(viewN);
                        if (view2 == null || jS2 > jS) {
                            view2 = viewN;
                            jS = jS2;
                        }
                    }
                }
            }
        }
        return view2;
    }

    private static boolean n(String str, String[] strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null) {
            for (String str2 : strArr) {
                if (!TextUtils.isEmpty(str2) && str.startsWith(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void n(View view, List<String> list, x xVar) {
        n(view, list, xVar, 0);
    }

    private static void n(View view, List<String> list, x xVar, int i) {
        if (view == null) {
            return;
        }
        if ((view instanceof WebView) && xVar != null) {
            xVar.q = true;
        }
        if (view instanceof TextView) {
            CharSequence text = ((TextView) view).getText();
            if (!TextUtils.isEmpty(text)) {
                String strW = w(text.toString());
                if (l(strW)) {
                    list.add(strW);
                }
            }
        }
        if (i < 50 && (view instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                n(viewGroup.getChildAt(i2), list, xVar, i + 1);
            }
        }
    }

    private static boolean n(com.byazt.sg.s sVar, int i, Activity activity) {
        Activity activity2;
        if (sVar != null && !sVar.rg() && activity != null) {
            if (i <= 0) {
                i = sVar.ct();
            }
            if (!n(i)) {
                return false;
            }
            try {
                String name = activity.getClass().getName();
                if (activity.getClass() == PluginActivityWrapper.class && (activity2 = ((PluginActivityWrapper) activity).mOriginActivity) != null) {
                    name = activity2.getClass().getName();
                }
                return qg(sVar.ci(), name);
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private static boolean qg(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !str2.contains("TTTransparentActivity") && !q(str2)) {
            if (s(str, MediationConstant.ADN_GDT)) {
                return str2.startsWith("com.qq.e.");
            }
            if (s(str, MediationConstant.ADN_KS)) {
                return str2.startsWith("com.kwad.");
            }
            if (s(str, "baidu")) {
                return str2.startsWith("com.baidu.mobads.") || str2.startsWith("com.baidu.mobad.");
            }
            if (s(str, MediationConstant.ADN_SIGMOB)) {
                return str2.startsWith("com.sigmob.");
            }
        }
        return false;
    }

    private static boolean s(String str, String str2) {
        if (TextUtils.equals(str, str2)) {
            return true;
        }
        return !TextUtils.isEmpty(str) && str.equalsIgnoreCase(str2);
    }

    private static boolean q(String str) {
        String strN = hu.n();
        return !TextUtils.isEmpty(strN) && str.startsWith(new StringBuilder().append(strN).append(i.E).toString());
    }

    private static Activity w() {
        Object objEl;
        try {
            com.byazt.vyf.s.cy().s();
            objEl = com.byazt.vyf.s.cy().cx();
        } catch (Throwable unused) {
            objEl = null;
        }
        if (!(objEl instanceof Activity)) {
            try {
                objEl = com.byazt.vyf.s.el();
            } catch (Throwable unused2) {
            }
        }
        if (objEl instanceof Activity) {
            Activity activity = (Activity) objEl;
            if (!activity.isFinishing() && !activity.isDestroyed()) {
                return activity;
            }
        }
        return null;
    }

    private static List<String> n(List<qg> list, s sVar, String str) {
        try {
            return n(list, sVar, str, n, s);
        } finally {
            qg(list);
        }
    }

    private static void n(View view, List<qg> list) {
        qg(view, list, 0);
    }

    private static void qg(View view, List<qg> list, int i) {
        qg qgVarN;
        if (view == null) {
            return;
        }
        if ((view instanceof ImageView) && (qgVarN = n((ImageView) view)) != null) {
            list.add(qgVarN);
        }
        if (i < 50 && (view instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                qg(viewGroup.getChildAt(i2), list, i + 1);
            }
        }
    }

    private static qg n(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        if (drawable != null && imageView.getVisibility() == 0 && imageView.getAlpha() > 0.0f) {
            int width = imageView.getWidth();
            int height = imageView.getHeight();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (width <= 0) {
                width = intrinsicWidth;
            }
            if (height <= 0) {
                height = intrinsicHeight;
            }
            if (width > 0 && height > 0) {
                qg qgVar = new qg();
                qgVar.n = imageView;
                qgVar.qg = width;
                qgVar.s = height;
                qgVar.w = ((long) width) * ((long) height);
                return qgVar;
            }
        }
        return null;
    }

    private static void n(List<qg> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Collections.sort(list, new Comparator<qg>() { // from class: com.byazt.gp.w.6
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public int compare(qg qgVar, qg qgVar2) {
                return Long.compare(qgVar2.w, qgVar.w);
            }
        });
        qg qgVar = list.get(0);
        list.clear();
        ImageView imageView = qgVar.n;
        Drawable drawable = imageView == null ? null : imageView.getDrawable();
        if (drawable == null) {
            return;
        }
        try {
            Bitmap bitmapN = n(drawable, imageView);
            if (bitmapN == null || bitmapN.isRecycled()) {
                return;
            }
            qgVar.q = bitmapN;
            qgVar.x = n(drawable, bitmapN);
            qgVar.n = null;
            list.add(qgVar);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static q s(qg qgVar) {
        n nVarS;
        Bitmap bitmap = qgVar == null ? null : qgVar.q;
        if (bitmap == null || bitmap.isRecycled() || qg(bitmap) || (nVarS = s(bitmap)) == null || nVarS.n == null || nVarS.n.length == 0) {
            return null;
        }
        return n(bitmap, nVarS);
    }

    private static List<String> qg(List<qg> list, s sVar, String str) {
        try {
            return s(list, sVar, str);
        } finally {
            qg(list);
        }
    }

    private static List<String> s(List<qg> list, s sVar, String str) {
        return n(list, sVar, str, qg, s);
    }

    public static List<String> n(List<qg> list, s sVar, String str, InterfaceC0184w interfaceC0184w, l lVar) {
        if (list == null || list.isEmpty()) {
            return Collections.emptyList();
        }
        if (sVar == null) {
            return Collections.emptyList();
        }
        if (interfaceC0184w == null || lVar == null || !lVar.n()) {
            return Collections.emptyList();
        }
        Collections.sort(list, new Comparator<qg>() { // from class: com.byazt.gp.w.7
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public int compare(qg qgVar, qg qgVar2) {
                return Long.compare(qgVar2.w, qgVar.w);
            }
        });
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        int size = list.size();
        for (int i = 0; i < size && sVar.n(); i++) {
            try {
                q qVarN = interfaceC0184w.n(list.get(i));
                if (qVarN != null && sVar.n() && !TextUtils.isEmpty(qVarN.s) && !hashSet.contains(qVarN.s)) {
                    String strN = n(qVarN, str, lVar);
                    if (!TextUtils.isEmpty(strN)) {
                        hashSet.add(qVarN.s);
                        arrayList.add(strN);
                        sVar.qg();
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return arrayList;
    }

    private static List<qg> n(View view, Window window, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (z) {
            qg qgVarN = n(view, window);
            if (qgVarN != null) {
                arrayList.add(qgVarN);
            }
            return arrayList;
        }
        qg qgVarW = w(view);
        if (qgVarW != null) {
            arrayList.add(qgVarW);
        }
        return arrayList;
    }

    private static qg n(View view, Window window) {
        if (q(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            try {
                AdnMaterialWindowCopyUtils.CopyRequest copyRequestBuildCopyRequest = AdnMaterialWindowCopyUtils.buildCopyRequest(view, window, 720);
                if (copyRequestBuildCopyRequest == null) {
                    return null;
                }
                qg qgVar = new qg();
                qgVar.w = s(view);
                qgVar.l = copyRequestBuildCopyRequest;
                qgVar.x = true;
                return qgVar;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static qg w(View view) {
        Bitmap bitmapCreateBitmap;
        if (!q(view)) {
            return null;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        if (width > 0 && height > 0) {
            float fMin = Math.min(1.0f, 720.0f / Math.max(width, height));
            try {
                bitmapCreateBitmap = Bitmap.createBitmap(Math.max(1, Math.round(width * fMin)), Math.max(1, Math.round(height * fMin)), Bitmap.Config.ARGB_8888);
                try {
                    Canvas canvas = new Canvas(bitmapCreateBitmap);
                    canvas.drawColor(-1);
                    canvas.scale(fMin, fMin);
                    view.draw(canvas);
                    qg qgVar = new qg();
                    qgVar.w = s(view);
                    qgVar.q = bitmapCreateBitmap;
                    qgVar.x = true;
                    return qgVar;
                } catch (Throwable unused) {
                    n(bitmapCreateBitmap);
                    return null;
                }
            } catch (Throwable unused2) {
                bitmapCreateBitmap = null;
            }
        }
        return null;
    }

    private static Bitmap n(Drawable drawable, ImageView imageView) {
        Bitmap bitmap;
        if ((drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            return (Build.VERSION.SDK_INT < 26 || bitmap.getConfig() != Bitmap.Config.HARDWARE) ? bitmap : bitmap.copy(Bitmap.Config.ARGB_8888, false);
        }
        int iN = n(drawable.getIntrinsicWidth(), imageView.getWidth());
        int iN2 = n(drawable.getIntrinsicHeight(), imageView.getHeight());
        if (iN <= 0 || iN2 <= 0) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iN, iN2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        if (drawable.getConstantState() != null) {
            drawable = drawable.getConstantState().newDrawable();
        }
        drawable.setBounds(0, 0, iN, iN2);
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    private static int n(int i, int i2) {
        if (i <= 0) {
            i = i2;
        }
        if (i <= 0) {
            return 0;
        }
        return Math.min(i, 2048);
    }

    private static boolean n(Drawable drawable, Bitmap bitmap) {
        return ((drawable instanceof BitmapDrawable) && bitmap != null && ((BitmapDrawable) drawable).getBitmap() == bitmap) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static q q(qg qgVar) {
        n nVarS;
        Bitmap bitmapCopy = qgVar == null ? null : qgVar.q;
        if (bitmapCopy == null && qgVar != null && qgVar.l != null) {
            if (com.byazt.rb.l.l()) {
                return null;
            }
            bitmapCopy = AdnMaterialWindowCopyUtils.copy(qgVar.l, 1000L);
            qgVar.q = bitmapCopy;
        }
        if (bitmapCopy == null || bitmapCopy.isRecycled() || qg(bitmapCopy) || (nVarS = s(bitmapCopy)) == null || nVarS.n == null || nVarS.n.length == 0) {
            return null;
        }
        return n(bitmapCopy, nVarS);
    }

    private static q n(Bitmap bitmap, n nVar) {
        q qVar = new q();
        qVar.n = bitmap;
        qVar.qg = nVar;
        qVar.s = n(nVar.n);
        return qVar;
    }

    private static void qg(List<qg> list) {
        if (list == null) {
            return;
        }
        for (qg qgVar : list) {
            if (qgVar != null && qgVar.x) {
                n(qgVar.q);
            }
        }
    }

    private static void n(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        bitmap.recycle();
    }

    private static boolean qg(Bitmap bitmap) {
        Bitmap bitmap2 = bitmap;
        if (bitmap2 == null || bitmap.isRecycled()) {
            return true;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= 0 || height <= 0) {
            return true;
        }
        int i = 0;
        int i2 = 0;
        int iMax = 0;
        int iMin = 255;
        int i3 = 0;
        int iMin2 = 255;
        int iMax2 = 0;
        int iMin3 = 255;
        while (true) {
            if (i >= 8) {
                break;
            }
            int i4 = 16;
            try {
                int iMin4 = Math.min(height - 1, (((i * 2) + 1) * height) / 16);
                int i5 = 0;
                for (int i6 = 8; i5 < i6; i6 = 8) {
                    int pixel = bitmap2.getPixel(Math.min(width - 1, (((i5 * 2) + 1) * width) / 16), iMin4);
                    if (((pixel >>> 24) & 255) >= i4) {
                        int i7 = (pixel >>> 16) & 255;
                        int i8 = (pixel >>> 8) & 255;
                        int i9 = pixel & 255;
                        iMin = Math.min(iMin, i7);
                        iMin2 = Math.min(iMin2, i8);
                        iMin3 = Math.min(iMin3, i9);
                        iMax = Math.max(iMax, i7);
                        int iMax3 = Math.max(i3, i8);
                        i2++;
                        iMax2 = Math.max(iMax2, i9);
                        i3 = iMax3;
                    }
                    i5++;
                    bitmap2 = bitmap;
                    i4 = 16;
                }
                i++;
                bitmap2 = bitmap;
            } catch (Throwable unused) {
                return false;
            }
        }
        if (i2 == 0) {
            return true;
        }
        return iMax - iMin <= 8 && i3 - iMin2 <= 8 && iMax2 - iMin3 <= 8;
    }

    private static n s(Bitmap bitmap) {
        Bitmap bitmapQ = q(bitmap);
        int i = 0;
        boolean z = bitmapQ != bitmap;
        int iX = x();
        while (i <= 8) {
            try {
                n nVarN = n(bitmapQ, iX);
                if (n(nVarN, iX)) {
                    if (z) {
                        n(bitmapQ);
                    }
                    return nVarN;
                }
                if (nVarN == null) {
                    n nVarQg = qg(bitmapQ, iX);
                    if (z) {
                        n(bitmapQ);
                    }
                    return nVarQg;
                }
                if (i >= 8) {
                    if (z) {
                        n(bitmapQ);
                    }
                    return null;
                }
                Bitmap bitmapN = n(bitmapQ, iX, nVarN.n.length);
                if (bitmapN == bitmapQ) {
                    if (z) {
                        n(bitmapQ);
                    }
                    return null;
                }
                if (z) {
                    n(bitmapQ);
                }
                i++;
                z = true;
                bitmapQ = bitmapN;
            } catch (Throwable th) {
                if (z) {
                    n(bitmapQ);
                }
                throw th;
            }
        }
        if (z) {
            n(bitmapQ);
        }
        return null;
    }

    private static n n(Bitmap bitmap, int i) {
        int iMax = 90;
        byte[] bArrN = n(bitmap, Bitmap.CompressFormat.JPEG, 90);
        while (bArrN != null && bArrN.length > i && iMax > 35) {
            iMax = Math.max(35, iMax - 10);
            bArrN = n(bitmap, Bitmap.CompressFormat.JPEG, iMax);
        }
        return n(bitmap, bArrN, "jpeg", iMax);
    }

    private static n qg(Bitmap bitmap, int i) {
        n nVarN = n(bitmap, n(bitmap, Bitmap.CompressFormat.PNG, 100), "png", 100);
        if (n(nVarN, i)) {
            return nVarN;
        }
        return null;
    }

    private static n n(Bitmap bitmap, byte[] bArr, String str, int i) {
        if (bitmap == null || bArr == null || bArr.length == 0) {
            return null;
        }
        n nVar = new n();
        nVar.n = bArr;
        nVar.qg = str;
        nVar.l = i;
        nVar.s = bitmap.getWidth();
        nVar.q = bitmap.getHeight();
        return nVar;
    }

    private static boolean n(n nVar, int i) {
        return nVar != null && nVar.n != null && nVar.n.length > 0 && nVar.n.length <= i;
    }

    private static int x() {
        try {
            int i = com.byazt.ng.qg.n().l;
            if (i > 0) {
                return i;
            }
            return 30720;
        } catch (Throwable unused) {
        }
    }

    private static Bitmap q(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int iMax = Math.max(width, height);
        if (iMax <= 720) {
            return bitmap;
        }
        float f = 720.0f / iMax;
        return Bitmap.createScaledBitmap(bitmap, Math.max(1, Math.round(width * f)), Math.max(1, Math.round(height * f)), true);
    }

    private static Bitmap n(Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (i2 <= i) {
            return bitmap;
        }
        if (width <= 1 && height <= 1) {
            return bitmap;
        }
        double dMin = Math.min(0.9d, Math.sqrt(((double) i) / ((double) i2)) * 0.95d);
        int iMax = Math.max(1, (int) Math.floor(((double) width) * dMin));
        int iMax2 = Math.max(1, (int) Math.floor(((double) height) * dMin));
        return (iMax == width && iMax2 == height) ? bitmap : Bitmap.createScaledBitmap(bitmap, iMax, iMax2, true);
    }

    private static byte[] n(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bitmap.compress(compressFormat, i, byteArrayOutputStream)) {
            return byteArrayOutputStream.toByteArray();
        }
        return null;
    }

    private static String n(byte[] bArr) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(bArr);
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(String.format(Locale.US, "%02x", Byte.valueOf(b)));
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    private static List<String> s(List<String> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str) && !arrayList.contains(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    private static boolean l(String str) {
        return (TextUtils.isEmpty(str) || str.length() > 500 || str.matches("\\d+")) ? false : true;
    }

    private static String w(String str) {
        return str == null ? "" : str.replace("\u200b", "").replace("\ufeff", "").trim();
    }

    @com.byazt.cp.n(n = {0, 1, 80, 1710})
    private static final class x {
        public final List<String> n;
        public boolean q;
        public final List<qg> qg;
        public final List<qg> s;

        private x() {
            this.n = new ArrayList();
            this.qg = new ArrayList();
            this.s = new ArrayList();
        }
    }

    @com.byazt.cp.n(n = {0, 1, 80, MediaPlayer.MEDIA_PLAYER_OPTION_OPT_SUB_FIRST_LOAD_TIME})
    static final class s {
        public final int n;
        public int qg;

        public s(int i) {
            this.n = Math.max(0, i);
        }

        public boolean n() {
            return this.qg < this.n;
        }

        public void qg() {
            this.qg++;
        }
    }
}
