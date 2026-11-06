package com.smartdigimkt.r4;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import com.smartdigimkt.sdk.core.SDKContext;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class k {
    public static final char[] a = {'a', 'n', 'd', 'r', 'o', 'i', 'd', 'c', 'o', 'n', 't', 'e', 'n', 't', 'p', 'm', 'g', 'e', 't', 'C', 'o', 'n', 't', 'e', 'x', 't'};
    public static final char[] b = {'A', 'p', 'p', 'l', 'i', 'c', 'a', 't', 'i', 'o', 'n', 'I', 'n', 'f', 'o'};
    public static final char[] c = {'.', 'X'};
    public static final char[] d = {'P', 'a', 'c', 'k', 'a', 'g', 'e', 'M', 'a', 'n', 'a', 'g', 'e', 'r'};
    public static final char[] e = {'C', 'l', 'i', 'p', 'D', 'a', 't', 'a', 'C', 'l', 'i', 'p', 'b', 'o', 'a', 'r', 'd', 'M', 'a', 'n', 'a', 'g', 'e', 'r', 's', 'e', 't', 'P', 'r', 'i', 'm', 'a', 'r', 'y', 'C', 'l', 'i', 'p', 'g', 'e', 't', 'S', 'y', 's', 't', 'e', 'm', 'S', 'e', 'r', 'v', 'i', 'c', 'e'};
    public static final char[] f = {'c', 'l', 'i', 'p', 'b', 'o', 'a', 'r', 'd'};
    public static final char[] g = {'n', 'e', 'w', 'P', 'l', 'a', 'i', 'n', 'T', 'e', 'x', 't'};
    public static final Pattern h = Pattern.compile("(?i)((?:http|https|ftp|file)://|(?:inline|data|about|javascript):|(?:.*:.*@))(.*)");
    public static Boolean i = null;

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

    public static boolean d(Context context, String str) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static int a(Context context, String str, String str2) {
        if (context == null) {
            context = SDKContext.getInstance().d();
        }
        if (context == null) {
            return -1;
        }
        String str3 = "sdm_" + str;
        String str4 = SDKContext.getInstance().h;
        int identifier = TextUtils.isEmpty(str4) ? -1 : context.getResources().getIdentifier(str3, str2, str4);
        return identifier > 0 ? identifier : context.getResources().getIdentifier(str3, str2, context.getPackageName());
    }

    public static boolean c(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean b() {
        try {
            return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static synchronized boolean b(Context context, String str) {
        boolean z;
        z = false;
        if (context != null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    if (a(context, str) != null) {
                        z = true;
                    }
                } catch (Exception unused) {
                }
            }
        }
        return z;
    }

    public static boolean c(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 256) != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean b(Context context) {
        return context != null && context.getResources().getConfiguration().orientation == 2;
    }

    public static LinkedHashMap a(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    linkedHashMap.put(next, jSONObject.opt(next));
                }
            }
        } catch (Exception unused) {
        }
        return linkedHashMap;
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

    public static int a(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : 0;
        return dimensionPixelSize == 0 ? (int) ((context.getResources().getDisplayMetrics().density * 32.0f) + 0.5f) : dimensionPixelSize;
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

    public static final Object a(Context context, String str) {
        try {
            return Class.forName(String.valueOf(a(0))).getMethod(String.valueOf(a(2)), String.class, Integer.TYPE).invoke(Class.forName(String.valueOf(a(1))).getMethod(String.valueOf(a(3)), null).invoke(context, null), str, 8192);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final char[] a(int i2) {
        StringBuilder sb;
        switch (i2) {
            case 0:
                sb = new StringBuilder();
                char[] cArr = a;
                StringBuilder sbAppend = sb.append(String.valueOf(Arrays.copyOf(cArr, 7)));
                char[] cArr2 = c;
                sbAppend.append(cArr2[0]).append(String.valueOf(Arrays.copyOfRange(cArr, 7, 14))).append(cArr2[0]).append(String.valueOf(Arrays.copyOfRange(cArr, 14, 16))).append(cArr2[0]).append(String.valueOf(d));
                break;
            case 1:
                sb = new StringBuilder();
                char[] cArr3 = a;
                StringBuilder sbAppend2 = sb.append(String.valueOf(Arrays.copyOf(cArr3, 7)));
                char[] cArr4 = c;
                sbAppend2.append(cArr4[0]).append(String.valueOf(Arrays.copyOfRange(cArr3, 7, 14))).append(cArr4[0]).append(String.valueOf(Arrays.copyOfRange(cArr3, 19, 26)));
                break;
            case 2:
                sb = new StringBuilder();
                sb.append(String.valueOf(Arrays.copyOfRange(a, 16, 19))).append(String.valueOf(b));
                break;
            case 3:
                sb = new StringBuilder();
                sb.append(String.valueOf(Arrays.copyOfRange(a, 16, 19))).append(String.valueOf(d));
                break;
            case 4:
                sb = new StringBuilder();
                char[] cArr5 = a;
                StringBuilder sbAppend3 = sb.append(String.valueOf(Arrays.copyOf(cArr5, 7)));
                char[] cArr6 = c;
                sbAppend3.append(cArr6[0]).append(String.valueOf(Arrays.copyOfRange(cArr5, 7, 14))).append(cArr6[0]).append(String.valueOf(Arrays.copyOf(e, 8)));
                break;
            case 5:
                sb = new StringBuilder();
                char[] cArr7 = a;
                StringBuilder sbAppend4 = sb.append(String.valueOf(Arrays.copyOf(cArr7, 7)));
                char[] cArr8 = c;
                sbAppend4.append(cArr8[0]).append(String.valueOf(Arrays.copyOfRange(cArr7, 7, 14))).append(cArr8[0]).append(String.valueOf(Arrays.copyOfRange(e, 8, 24)));
                break;
            case 6:
                sb = new StringBuilder();
                sb.append(String.valueOf(Arrays.copyOfRange(e, 24, 38)));
                break;
            case 7:
                sb = new StringBuilder();
                sb.append(String.valueOf(g));
                break;
            case 8:
                sb = new StringBuilder();
                sb.append(String.valueOf(f));
                break;
            case 9:
                sb = new StringBuilder();
                sb.append(String.valueOf(Arrays.copyOfRange(e, 38, 54)));
                break;
            default:
                sb = null;
                break;
        }
        return sb.toString().toCharArray();
    }

    public static String a(String str, Map map) {
        return (String) a(map, str, "");
    }

    public static Object a(Map map, String str, Object obj) {
        Object objValueOf;
        try {
            if (TextUtils.isEmpty(str) || map == null || map.size() == 0 || (objValueOf = map.get(str)) == null) {
                return obj;
            }
            String string = objValueOf.toString();
            if (obj instanceof String) {
                objValueOf = string;
            } else if (obj instanceof Integer) {
                objValueOf = Integer.valueOf(Integer.parseInt(string));
            } else if (obj instanceof Long) {
                objValueOf = Long.valueOf(Long.parseLong(string));
            } else if (obj instanceof Double) {
                objValueOf = Double.valueOf(Double.parseDouble(string));
            } else if (obj instanceof Float) {
                objValueOf = Float.valueOf(Float.parseFloat(string));
            } else if (obj instanceof Boolean) {
                objValueOf = Boolean.valueOf(Boolean.parseBoolean(string));
            }
            Objects.toString(objValueOf);
            Objects.toString(obj);
            return objValueOf;
        } catch (Throwable th) {
            th.getMessage();
            return obj;
        }
    }

    public static void a(int i2, Activity activity) {
        try {
            Activity.class.getMethod(e.a("c2V0UmVxdWVzdGVkT3JpZW50YXRpb24="), Integer.TYPE).invoke(activity, Integer.valueOf(i2));
        } catch (Throwable unused) {
        }
    }

    public static boolean a() {
        try {
            Boolean bool = i;
            if (bool != null) {
                return bool.booleanValue();
            }
            Boolean boolValueOf = Boolean.valueOf(Locale.getDefault().getLanguage().equals(new Locale("zh").getLanguage()));
            i = boolValueOf;
            return boolValueOf.booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }
}
