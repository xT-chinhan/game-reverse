package com.anythink.basead.exoplayer.k;

import android.net.Uri;
import android.text.TextUtils;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class ae {
    private static final int a = 4;
    private static final int b = 0;
    private static final int c = 1;
    private static final int d = 2;
    private static final int e = 3;

    private ae() {
    }

    private static String b(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        int[] iArrA = a(str2);
        if (iArrA[0] != -1) {
            sb.append(str2);
            a(sb, iArrA[1], iArrA[2]);
            return sb.toString();
        }
        int[] iArrA2 = a(str);
        if (iArrA[3] == 0) {
            return sb.append((CharSequence) str, 0, iArrA2[3]).append(str2).toString();
        }
        if (iArrA[2] == 0) {
            return sb.append((CharSequence) str, 0, iArrA2[2]).append(str2).toString();
        }
        int i = iArrA[1];
        if (i != 0) {
            int i2 = iArrA2[0] + 1;
            sb.append((CharSequence) str, 0, i2).append(str2);
            return a(sb, iArrA[1] + i2, i2 + iArrA[2]);
        }
        if (str2.charAt(i) == '/') {
            sb.append((CharSequence) str, 0, iArrA2[1]).append(str2);
            int i3 = iArrA2[1];
            return a(sb, i3, iArrA[2] + i3);
        }
        int i4 = iArrA2[0] + 2;
        int i5 = iArrA2[1];
        if (i4 < i5 && i5 == iArrA2[2]) {
            sb.append((CharSequence) str, 0, i5).append('/').append(str2);
            int i6 = iArrA2[1];
            return a(sb, i6, iArrA[2] + i6 + 1);
        }
        int iLastIndexOf = str.lastIndexOf(47, iArrA2[2] - 1);
        int i7 = iLastIndexOf == -1 ? iArrA2[1] : iLastIndexOf + 1;
        sb.append((CharSequence) str, 0, i7).append(str2);
        return a(sb, iArrA2[1], i7 + iArrA[2]);
    }

    private static Uri a(Uri uri, String str) {
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.clearQuery();
        for (String str2 : uri.getQueryParameterNames()) {
            if (!str2.equals(str)) {
                Iterator<String> it = uri.getQueryParameters(str2).iterator();
                while (it.hasNext()) {
                    builderBuildUpon.appendQueryParameter(str2, it.next());
                }
            }
        }
        return builderBuildUpon.build();
    }

    private static String a(StringBuilder sb, int i, int i2) {
        int i3;
        int i4;
        if (i >= i2) {
            return sb.toString();
        }
        if (sb.charAt(i) == '/') {
            i++;
        }
        int i5 = i;
        int iLastIndexOf = i5;
        while (i5 <= i2) {
            if (i5 == i2) {
                i3 = i5;
            } else if (sb.charAt(i5) == '/') {
                i3 = i5 + 1;
            } else {
                i5++;
            }
            int i6 = iLastIndexOf + 1;
            if (i5 == i6 && sb.charAt(iLastIndexOf) == '.') {
                sb.delete(iLastIndexOf, i3);
                i4 = i3 - iLastIndexOf;
            } else {
                if (i5 == iLastIndexOf + 2 && sb.charAt(iLastIndexOf) == '.' && sb.charAt(i6) == '.') {
                    iLastIndexOf = sb.lastIndexOf("/", iLastIndexOf - 2) + 1;
                    int i7 = iLastIndexOf > i ? iLastIndexOf : i;
                    sb.delete(i7, i3);
                    i4 = i3 - i7;
                } else {
                    iLastIndexOf = i5 + 1;
                }
                i5 = iLastIndexOf;
            }
            i2 -= i4;
            i5 = iLastIndexOf;
        }
        return sb.toString();
    }

    private static int[] a(String str) {
        int iIndexOf;
        int[] iArr = new int[4];
        if (TextUtils.isEmpty(str)) {
            iArr[0] = -1;
            return iArr;
        }
        int length = str.length();
        int iIndexOf2 = str.indexOf(35);
        if (iIndexOf2 != -1) {
            length = iIndexOf2;
        }
        int iIndexOf3 = str.indexOf(63);
        if (iIndexOf3 == -1 || iIndexOf3 > length) {
            iIndexOf3 = length;
        }
        int iIndexOf4 = str.indexOf(47);
        if (iIndexOf4 == -1 || iIndexOf4 > iIndexOf3) {
            iIndexOf4 = iIndexOf3;
        }
        int iIndexOf5 = str.indexOf(58);
        if (iIndexOf5 > iIndexOf4) {
            iIndexOf5 = -1;
        }
        int i = iIndexOf5 + 2;
        if (i < iIndexOf3 && str.charAt(iIndexOf5 + 1) == '/' && str.charAt(i) == '/') {
            iIndexOf = str.indexOf(47, iIndexOf5 + 3);
            if (iIndexOf == -1 || iIndexOf > iIndexOf3) {
                iIndexOf = iIndexOf3;
            }
        } else {
            iIndexOf = iIndexOf5 + 1;
        }
        iArr[0] = iIndexOf5;
        iArr[1] = iIndexOf;
        iArr[2] = iIndexOf3;
        iArr[3] = length;
        return iArr;
    }

    private static Uri a(String str, String str2) {
        String strA;
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        int[] iArrA = a(str2);
        if (iArrA[0] != -1) {
            sb.append(str2);
            a(sb, iArrA[1], iArrA[2]);
            strA = sb.toString();
        } else {
            int[] iArrA2 = a(str);
            if (iArrA[3] == 0) {
                strA = sb.append((CharSequence) str, 0, iArrA2[3]).append(str2).toString();
            } else if (iArrA[2] == 0) {
                strA = sb.append((CharSequence) str, 0, iArrA2[2]).append(str2).toString();
            } else {
                int i = iArrA[1];
                if (i != 0) {
                    int i2 = iArrA2[0] + 1;
                    sb.append((CharSequence) str, 0, i2).append(str2);
                    strA = a(sb, iArrA[1] + i2, i2 + iArrA[2]);
                } else if (str2.charAt(i) == '/') {
                    sb.append((CharSequence) str, 0, iArrA2[1]).append(str2);
                    int i3 = iArrA2[1];
                    strA = a(sb, i3, iArrA[2] + i3);
                } else {
                    int i4 = iArrA2[0] + 2;
                    int i5 = iArrA2[1];
                    if (i4 < i5 && i5 == iArrA2[2]) {
                        sb.append((CharSequence) str, 0, i5).append('/').append(str2);
                        int i6 = iArrA2[1];
                        strA = a(sb, i6, iArrA[2] + i6 + 1);
                    } else {
                        int iLastIndexOf = str.lastIndexOf(47, iArrA2[2] - 1);
                        int i7 = iLastIndexOf == -1 ? iArrA2[1] : iLastIndexOf + 1;
                        sb.append((CharSequence) str, 0, i7).append(str2);
                        strA = a(sb, iArrA2[1], i7 + iArrA[2]);
                    }
                }
            }
        }
        return Uri.parse(strA);
    }
}
