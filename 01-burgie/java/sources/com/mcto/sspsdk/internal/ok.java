package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ok {
    public static String a(String str, int i, int i2) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        int iIndexOf = str.indexOf(63);
        int iLastIndexOf = str.lastIndexOf(46, iIndexOf == -1 ? length : iIndexOf);
        StringBuilder sb = new StringBuilder(length + 10);
        if (iLastIndexOf != -1) {
            sb.append((CharSequence) str, 0, iLastIndexOf);
            sb.append('_').append(i).append('_').append(i2);
            sb.append((CharSequence) str, iLastIndexOf, iIndexOf == -1 ? length : iIndexOf);
            if (iIndexOf != -1) {
                sb.append((CharSequence) str, iIndexOf, length);
            }
        } else if (iIndexOf != -1) {
            sb.append((CharSequence) str, 0, iIndexOf);
            sb.append('_').append(i).append('_').append(i2);
            sb.append((CharSequence) str, iIndexOf, length);
        } else {
            sb.append(str);
            sb.append('_').append(i).append('_').append(i2);
        }
        return sb.toString();
    }
}
