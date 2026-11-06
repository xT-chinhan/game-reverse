package com.bytedance.sdk.component.xr.ms;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final String[] f1594ms;

    public c(String[] strArr) {
        this.f1594ms = strArr;
    }

    c(ms msVar) {
        this.f1594ms = (String[]) msVar.f1595ms.toArray(new String[msVar.f1595ms.size()]);
    }

    public int ms() {
        return this.f1594ms.length / 2;
    }

    public String ms(int i) {
        return this.f1594ms[i * 2];
    }

    public String xr(int i) {
        return this.f1594ms[(i * 2) + 1];
    }

    public Map<String, List<String>> xr() {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int iMs = ms();
        for (int i = 0; i < iMs; i++) {
            String lowerCase = ms(i).toLowerCase(Locale.US);
            List arrayList = (List) treeMap.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
                treeMap.put(lowerCase, arrayList);
            }
            arrayList.add(xr(i));
        }
        return treeMap;
    }

    public static final class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        final List<String> f1595ms = new ArrayList(20);

        public c ms() {
            return new c(this);
        }

        ms ms(String str, String str2) {
            this.f1595ms.add(str);
            this.f1595ms.add(str2.trim());
            return this;
        }

        public ms xr(String str, String str2) {
            try {
                ah(str, str2);
            } catch (Throwable unused) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    try {
                        StringBuilder sb = new StringBuilder();
                        int length = str2.length();
                        for (int i = 0; i < length; i++) {
                            char cCharAt = str2.charAt(i);
                            if ((cCharAt <= 31 && cCharAt != '\t') || cCharAt >= 127) {
                                sb.append(URLEncoder.encode(String.valueOf(cCharAt), "UTF-8"));
                            } else {
                                sb.append(cCharAt);
                            }
                        }
                        str2 = sb.toString();
                    } catch (UnsupportedEncodingException e) {
                        com.bytedance.sdk.component.utils.sl.ms(e);
                        return this;
                    }
                }
                return this;
            }
            return ms(str, str2);
        }

        private void ah(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (str.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            }
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt <= ' ' || cCharAt >= 127) {
                    throw new IllegalArgumentException(com.bytedance.sdk.component.xr.ms.xr.ch.ms("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str));
                }
            }
            if (str2 == null) {
                throw new NullPointerException("value for name " + str + " == null");
            }
            int length2 = str2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                char cCharAt2 = str2.charAt(i2);
                if ((cCharAt2 <= 31 && cCharAt2 != '\t') || cCharAt2 >= 127) {
                    throw new IllegalArgumentException(com.bytedance.sdk.component.xr.ms.xr.ch.ms("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(cCharAt2), Integer.valueOf(i2), str, str2));
                }
            }
        }
    }
}
