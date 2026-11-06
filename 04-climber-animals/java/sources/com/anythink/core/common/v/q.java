package com.anythink.core.common.v;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.webkit.WebView;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class q {
    public static final String a = "CommonUtils";
    private static char[] b = {'a', 'n', 'd', 'r', 'o', 'i', 'd', 'c', 'o', 'n', 't', 'e', 'n', 't', 'p', 'm', 'g', 'e', 't', 'C', 'o', 'n', 't', 'e', 'x', 't'};
    private static char[] c = {'A', 'p', 'p', 'l', 'i', 'c', 'a', 't', 'i', 'o', 'n', 'I', 'n', 'f', 'o'};
    private static char[] d = {'.', 'X'};
    private static int e = 0;
    private static int f = 1;
    private static int g = 2;
    private static int h = 3;
    private static int i = 0;
    private static int j = 7;
    private static int k = 14;
    private static int l = 19;
    private static int m = 16;
    private static int n = 26;
    private static int o = 8;
    private static int p = 24;
    private static int q = 38;
    private static int r = 54;
    private static char[] s = {'P', 'a', 'c', 'k', 'a', 'g', 'e', 'M', 'a', 'n', 'a', 'g', 'e', 'r'};
    private static char[] t = {'C', 'l', 'i', 'p', 'D', 'a', 't', 'a', 'C', 'l', 'i', 'p', 'b', 'o', 'a', 'r', 'd', 'M', 'a', 'n', 'a', 'g', 'e', 'r', 's', 'e', 't', 'P', 'r', 'i', 'm', 'a', 'r', 'y', 'C', 'l', 'i', 'p', 'g', 'e', 't', 'S', 'y', 's', 't', 'e', 'm', 'S', 'e', 'r', 'v', 'i', 'c', 'e'};
    private static char[] u = {'c', 'l', 'i', 'p', 'b', 'o', 'a', 'r', 'd'};
    private static char[] v = {'n', 'e', 'w', 'P', 'l', 'a', 'i', 'n', 'T', 'e', 'x', 't'};
    private static final Pattern w = Pattern.compile("(?i)((?:http|https|ftp|file)://|(?:inline|data|about|javascript):|(?:.*:.*@))(.*)");
    private static Boolean x = null;

    public static <T extends String> boolean a(T t2) {
        return t2 == null || t2.length() == 0;
    }

    public static <T extends String> boolean b(T t2) {
        return t2 != null && t2.length() > 0;
    }

    public static boolean a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
        } catch (Exception unused) {
        }
    }

    public static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int b(Context context, float f2) {
        float f3 = context.getResources().getDisplayMetrics().density;
        if (f3 <= 0.0f) {
            f3 = 1.0f;
        }
        return (int) ((f2 / f3) + 0.5f);
    }

    public static boolean a(String str, Context context) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static int a(Context context, String str, String str2) {
        if (context == null) {
            context = com.anythink.core.common.d.t.b().g();
        }
        if (context == null) {
            return -1;
        }
        String strConcat = "anythink_".concat(String.valueOf(str));
        String strU = com.anythink.core.common.d.t.b().U();
        int identifier = TextUtils.isEmpty(strU) ? -1 : context.getResources().getIdentifier(strConcat, str2, strU);
        return identifier > 0 ? identifier : context.getResources().getIdentifier(strConcat, str2, context.getPackageName());
    }

    private static int[] c(Context context, String str) {
        try {
            for (Field field : Class.forName(context.getPackageName() + ".R$styleable").getFields()) {
                if (field.getName().equals(str)) {
                    return (int[]) field.get(null);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

    private static int b(Context context, String str, String str2) {
        String str3 = str + "_" + str2;
        try {
            for (Class<?> cls : Class.forName(context.getPackageName() + ".R").getClasses()) {
                if (cls.getSimpleName().equals("styleable")) {
                    for (Field field : cls.getFields()) {
                        if (field.getName().equals(str3)) {
                            return ((Integer) field.get(null)).intValue();
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return 0;
    }

    public static Map<String, Object> c(String str) {
        HashMap map = new HashMap();
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map.put(next, jSONObject.opt(next));
                }
            }
        } catch (Exception unused) {
        }
        return map;
    }

    public static String[] a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        try {
            String[] strArr = new String[jSONArray.length()];
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                strArr[i2] = jSONArray.optString(i2);
            }
            return strArr;
        } catch (Exception unused) {
            return null;
        }
    }

    public static List<String> b(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String strOptString = jSONArray.optString(i2);
                if (strOptString != null) {
                    arrayList.add(strOptString);
                }
            }
            return arrayList;
        } catch (Exception unused) {
            return null;
        }
    }

    private static void a(Activity activity) {
        Window window = activity.getWindow();
        if (window != null) {
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(4870);
            decorView.setOnSystemUiVisibilityChangeListener(new AnonymousClass1(decorView));
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.v.q$1, reason: invalid class name */
    final class AnonymousClass1 implements View.OnSystemUiVisibilityChangeListener {
        final /* synthetic */ View a;

        AnonymousClass1(View view) {
            this.a = view;
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public final void onSystemUiVisibilityChange(int i) {
            if ((i & 2) == 0) {
                q.a(this.a);
            }
        }
    }

    private static View.OnSystemUiVisibilityChangeListener b(View view) {
        return new AnonymousClass1(view);
    }

    static void a(View view) {
        view.setSystemUiVisibility(4870);
    }

    public static int b(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : 0;
        return dimensionPixelSize == 0 ? a(context, 32.0f) : dimensionPixelSize;
    }

    public static boolean a() {
        try {
            return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String a(Object[] objArr) {
        int length;
        if (objArr == null || (length = objArr.length - 1) == -1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (true) {
            sb.append(String.valueOf(objArr[i2]));
            if (i2 == length) {
                return sb.toString();
            }
            sb.append(",");
            i2++;
        }
    }

    public static synchronized boolean a(Context context, String str) {
        boolean z;
        z = false;
        if (context != null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    if (b(str, context) != null) {
                        z = true;
                    }
                } catch (Exception unused) {
                }
            }
        }
        return z;
    }

    private static Object b(String str, Context context) {
        try {
            return Class.forName(String.valueOf(a(e))).getMethod(String.valueOf(a(g)), String.class, Integer.TYPE).invoke(Class.forName(String.valueOf(a(f))).getMethod(String.valueOf(a(h)), new Class[0]).invoke(context, new Object[0]), str, 8192);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static final char[] a(int i2) {
        StringBuilder sb;
        switch (i2) {
            case 0:
                sb = new StringBuilder();
                sb.append(String.valueOf(Arrays.copyOf(b, j))).append(d[i]).append(String.valueOf(Arrays.copyOfRange(b, j, k))).append(d[i]).append(String.valueOf(Arrays.copyOfRange(b, k, m))).append(d[i]).append(String.valueOf(s));
                break;
            case 1:
                sb = new StringBuilder();
                sb.append(String.valueOf(Arrays.copyOf(b, j))).append(d[i]).append(String.valueOf(Arrays.copyOfRange(b, j, k))).append(d[i]).append(String.valueOf(Arrays.copyOfRange(b, l, n)));
                break;
            case 2:
                sb = new StringBuilder();
                sb.append(String.valueOf(Arrays.copyOfRange(b, m, l))).append(String.valueOf(c));
                break;
            case 3:
                sb = new StringBuilder();
                sb.append(String.valueOf(Arrays.copyOfRange(b, m, l))).append(String.valueOf(s));
                break;
            case 4:
                sb = new StringBuilder();
                sb.append(String.valueOf(Arrays.copyOf(b, j))).append(d[i]).append(String.valueOf(Arrays.copyOfRange(b, j, k))).append(d[i]).append(String.valueOf(Arrays.copyOf(t, o)));
                break;
            case 5:
                sb = new StringBuilder();
                sb.append(String.valueOf(Arrays.copyOf(b, j))).append(d[i]).append(String.valueOf(Arrays.copyOfRange(b, j, k))).append(d[i]).append(String.valueOf(Arrays.copyOfRange(t, o, p)));
                break;
            case 6:
                sb = new StringBuilder();
                sb.append(String.valueOf(Arrays.copyOfRange(t, p, q)));
                break;
            case 7:
                sb = new StringBuilder();
                sb.append(String.valueOf(v));
                break;
            case 8:
                sb = new StringBuilder();
                sb.append(String.valueOf(u));
                break;
            case 9:
                sb = new StringBuilder();
                sb.append(String.valueOf(Arrays.copyOfRange(t, q, r)));
                break;
            default:
                sb = null;
                break;
        }
        return sb.toString().toCharArray();
    }

    public static boolean c(Context context) {
        return context != null && context.getResources().getConfiguration().orientation == 2;
    }

    public static boolean d(String str) {
        return w.matcher(str.toLowerCase()).matches();
    }

    public static boolean d(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            return (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || activeNetworkInfo.getType() != 1) ? false : true;
        } catch (Throwable unused) {
        }
    }

    public static boolean b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 256) != null;
        } catch (Throwable unused) {
        }
    }

    public static String a(Map<String, Object> map, String str) {
        return a(map, str, "");
    }

    public static String a(Map<String, Object> map, String str, String str2) {
        return (String) a(map, str, str2);
    }

    private static int c(Map<String, Object> map, String str) {
        return a(map, str, 0);
    }

    public static int a(Map<String, Object> map, String str, int i2) {
        return ((Integer) a(map, str, Integer.valueOf(i2))).intValue();
    }

    private static long d(Map<String, Object> map, String str) {
        return b(map, str);
    }

    public static long b(Map<String, Object> map, String str) {
        return ((Long) a(map, str, 0L)).longValue();
    }

    private static double f(Map<String, Object> map, String str) {
        return ((Double) a(map, str, Double.valueOf(0.0d))).doubleValue();
    }

    private static boolean h(Map<String, Object> map, String str) {
        return ((Boolean) a(map, str, Boolean.FALSE)).booleanValue();
    }

    public static <T> T a(Map<String, Object> map, String str, T t2) {
        T t3;
        try {
            if (TextUtils.isEmpty(str) || map == null || map.size() == 0 || (t3 = (T) map.get(str)) == null) {
                return t2;
            }
            String string = t3.toString();
            if (t2 instanceof String) {
                t3 = (T) string;
            } else if (t2 instanceof Integer) {
                t3 = (T) Integer.valueOf(Integer.parseInt(string));
            } else if (t2 instanceof Long) {
                t3 = (T) Long.valueOf(Long.parseLong(string));
            } else if (t2 instanceof Double) {
                t3 = (T) Double.valueOf(Double.parseDouble(string));
            } else if (t2 instanceof Float) {
                t3 = (T) Float.valueOf(Float.parseFloat(string));
            } else if (t2 instanceof Boolean) {
                t3 = (T) Boolean.valueOf(Boolean.parseBoolean(string));
            }
            new StringBuilder("key = ").append(str).append(" getValueFromMap() >>> result = ").append(t3).append(" defaultValue = ").append(t2);
            return t3;
        } catch (Throwable th) {
            th.getMessage();
            return t2;
        }
    }

    public static String e(String str) {
        return TextUtils.isEmpty(str) ? str : str.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replaceAll("&quot;", "\"");
    }

    public static int e(Context context) {
        if (com.anythink.core.common.d.t.b().c("screen")) {
            return 0;
        }
        try {
            if (!com.anythink.core.common.d.v.a(com.anythink.core.common.d.t.b().g()).b() || context == null) {
                return 0;
            }
            try {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                HashMap mapG = g(context);
                return mapG.get("width") == null ? displayMetrics.widthPixels : ((Integer) mapG.get("width")).intValue();
            } catch (Exception e2) {
                e2.printStackTrace();
                return 0;
            }
        } catch (Exception unused) {
        }
    }

    public static int f(Context context) {
        if (com.anythink.core.common.d.t.b().c("screen")) {
            return 0;
        }
        try {
            if (!com.anythink.core.common.d.v.a(com.anythink.core.common.d.t.b().g()).b() || context == null) {
                return 0;
            }
            try {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                HashMap mapG = g(context);
                return mapG.get("height") == null ? displayMetrics.heightPixels : ((Integer) mapG.get("height")).intValue();
            } catch (Exception e2) {
                e2.printStackTrace();
                return 0;
            }
        } catch (Exception unused) {
        }
    }

    public static HashMap g(Context context) {
        HashMap map = new HashMap();
        if (context == null) {
            return map;
        }
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            map.put("height", Integer.valueOf(displayMetrics.heightPixels));
            map.put("width", Integer.valueOf(displayMetrics.widthPixels));
        } catch (Exception e2) {
            e2.getMessage();
        }
        return map;
    }

    public static float h(Context context) {
        if (context == null) {
            return 2.5f;
        }
        try {
            float f2 = context.getResources().getDisplayMetrics().density;
            if (f2 == 0.0f) {
                return 2.5f;
            }
            return f2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 2.5f;
        }
    }

    public static float i(Context context) {
        if (context == null) {
            return 0.0f;
        }
        try {
            PackageInfo currentWebViewPackage = WebView.getCurrentWebViewPackage();
            return (currentWebViewPackage == null || TextUtils.isEmpty(currentWebViewPackage.versionName) || !currentWebViewPackage.versionName.equals("77.0.3865.92")) ? 1.5f : 5.0f;
        } catch (Exception unused) {
            return 1.5f;
        }
    }

    public static void a(Activity activity, int i2) {
        try {
            Activity.class.getMethod(k.b("c2V0UmVxdWVzdGVkT3JpZW50YXRpb24="), Integer.TYPE).invoke(activity, Integer.valueOf(i2));
        } catch (Throwable unused) {
        }
    }

    public static String f(String str) {
        try {
            if (!TextUtils.isEmpty(str) && URLUtil.isValidUrl(str)) {
                return new URL(str).getHost();
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static String a(String str, String str2) {
        try {
            String strF = f(str);
            return !TextUtils.isEmpty(strF) ? str.replace(strF, str2) : str;
        } catch (Throwable unused) {
            return str;
        }
    }

    public static boolean b() {
        try {
            Boolean bool = x;
            if (bool != null) {
                return bool.booleanValue();
            }
            Boolean boolValueOf = Boolean.valueOf(Locale.getDefault().getLanguage().equals(new Locale("zh").getLanguage()));
            x = boolValueOf;
            return boolValueOf.booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    private static double e(Map<String, Object> map, String str) {
        return ((Double) a(map, str, Double.valueOf(0.0d))).doubleValue();
    }

    private static boolean g(Map<String, Object> map, String str) {
        return ((Boolean) a(map, str, Boolean.FALSE)).booleanValue();
    }
}
