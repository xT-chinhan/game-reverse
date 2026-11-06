package com.bykv.vk.openvk.component.video.ms.xr;

import android.net.Uri;
import android.text.TextUtils;
import com.anythink.basead.b.f;
import com.kuaishou.weapon.p0.t;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public class ny {
    public final ms ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public final ah f100ms;
    public final List<xr> xr;

    public ny(ah ahVar, List<xr> list, ms msVar) {
        this.f100ms = ahVar;
        this.xr = list;
        this.ah = msVar;
    }

    public static ny ms(InputStream inputStream) throws IOException, d {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, com.bykv.vk.openvk.component.video.ms.ah.ms.f28ms));
        ArrayList arrayList = new ArrayList();
        ah ahVarMs = null;
        while (true) {
            String line = bufferedReader.readLine();
            if (TextUtils.isEmpty(line)) {
                break;
            }
            String strTrim = line.trim();
            if (ahVarMs == null) {
                ahVarMs = ah.ms(strTrim);
            } else {
                arrayList.add(xr.ms(strTrim));
            }
        }
        if (ahVarMs == null) {
            throw new d("request line is null");
        }
        return new ny(ahVarMs, arrayList, ms.ms(ahVarMs, arrayList));
    }

    static final class ah {
        final String ah;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        final String f101ms;
        final String xr;

        private ah(String str, String str2, String str3) {
            this.f101ms = str;
            this.xr = str2;
            this.ah = str3;
        }

        static ah ms(String str) throws d {
            int iIndexOf = str.indexOf(32);
            if (iIndexOf == -1) {
                throw new d("request line format error, line: ".concat(String.valueOf(str)));
            }
            int iLastIndexOf = str.lastIndexOf(32);
            if (iLastIndexOf <= iIndexOf) {
                throw new d("request line format error, line: ".concat(String.valueOf(str)));
            }
            String strTrim = str.substring(0, iIndexOf).trim();
            String strTrim2 = str.substring(iIndexOf + 1, iLastIndexOf).trim();
            String strTrim3 = str.substring(iLastIndexOf + 1).trim();
            if (strTrim.length() == 0 || strTrim2.length() == 0 || strTrim3.length() == 0) {
                throw new d("request line format error, line: ".concat(String.valueOf(str)));
            }
            return new ah(strTrim, strTrim2, strTrim3);
        }

        public String toString() {
            return "RequestLine{method='" + this.f101ms + "', path='" + this.xr + "', version='" + this.ah + "'}";
        }
    }

    public static final class xr {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public final String f103ms;
        public final String xr;

        public xr(String str, String str2) {
            this.f103ms = str;
            this.xr = str2;
        }

        static xr ms(String str) throws d {
            int iIndexOf = str.indexOf(":");
            if (iIndexOf == -1) {
                throw new d("request header format error, header: ".concat(String.valueOf(str)));
            }
            String strTrim = str.substring(0, iIndexOf).trim();
            String strTrim2 = str.substring(iIndexOf + 1).trim();
            if (strTrim.length() == 0 || strTrim2.length() == 0) {
                throw new d("request header format error, header: ".concat(String.valueOf(str)));
            }
            return new xr(strTrim, strTrim2);
        }

        public String toString() {
            return "Header{name='" + this.f103ms + "', value='" + this.xr + "'}";
        }
    }

    static final class ms {
        final List<String> ab;
        final String ah;
        final String c;
        final int d;
        final int ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        final int f102ms;
        final String xr;

        private ms(int i, String str, String str2, int i2, int i3, String str3, List<String> list) {
            this.f102ms = i;
            this.xr = str;
            this.ah = str2;
            this.d = i2;
            this.ka = i3;
            this.c = str3;
            this.ab = list;
        }

        static ms ms(ah ahVar, List<xr> list) throws d {
            String str;
            int i;
            int i2;
            int iIndexOf = ahVar.xr.indexOf("?");
            if (iIndexOf == -1) {
                throw new d("path format error, path: " + ahVar.xr);
            }
            ArrayList arrayList = new ArrayList();
            String str2 = null;
            String strDecode = null;
            String strDecode2 = null;
            int i3 = 0;
            for (String str3 : ahVar.xr.substring(iIndexOf + 1).split("&")) {
                String[] strArrSplit = str3.split("=");
                if (strArrSplit.length == 2) {
                    if ("rk".equals(strArrSplit[0])) {
                        strDecode = Uri.decode(strArrSplit[1]);
                    } else if (t.a.equals(strArrSplit[0])) {
                        strDecode2 = Uri.decode(strArrSplit[1]);
                    } else if (strArrSplit[0].startsWith("u")) {
                        arrayList.add(Uri.decode(strArrSplit[1]));
                    } else if (f.a.equals(strArrSplit[0]) && com.bykv.vk.openvk.component.video.ms.ah.ms.xr(strArrSplit[1]) == 1) {
                        i3 = 1;
                    }
                }
            }
            if (TextUtils.isEmpty(strDecode) || TextUtils.isEmpty(strDecode2)) {
                throw new d("rawKey or key is empty, path: " + ahVar.xr);
            }
            if (list != null) {
                i2 = 0;
                int i4 = 0;
                for (xr xrVar : list) {
                    if (xrVar != null && "Range".equalsIgnoreCase(xrVar.f103ms)) {
                        int iIndexOf2 = xrVar.xr.indexOf("=");
                        if (iIndexOf2 == -1) {
                            throw new d("Range format error, Range: " + xrVar.xr);
                        }
                        if (!"bytes".equalsIgnoreCase(xrVar.xr.substring(0, iIndexOf2).trim())) {
                            throw new d("Range format error, Range: " + xrVar.xr);
                        }
                        String strSubstring = xrVar.xr.substring(iIndexOf2 + 1);
                        if (strSubstring.contains(",")) {
                            throw new d("Range format error, Range: " + xrVar.xr);
                        }
                        int iIndexOf3 = strSubstring.indexOf("-");
                        if (iIndexOf3 == -1) {
                            throw new d("Range format error, Range: " + xrVar.xr);
                        }
                        String strTrim = strSubstring.substring(0, iIndexOf3).trim();
                        String strTrim2 = strSubstring.substring(iIndexOf3 + 1).trim();
                        try {
                            if (strTrim.length() > 0) {
                                i2 = Integer.parseInt(strTrim);
                            }
                            if (strTrim2.length() > 0 && i2 > (i4 = Integer.parseInt(strTrim2))) {
                                throw new d("Range format error, Range: " + xrVar.xr);
                            }
                            str2 = xrVar.xr;
                        } catch (NumberFormatException unused) {
                            throw new d("Range format error, Range: " + xrVar.xr);
                        }
                    }
                }
                i = i4;
                str = str2;
            } else {
                str = null;
                i = 0;
                i2 = 0;
            }
            if (arrayList.isEmpty()) {
                throw new d("no url found: path: " + ahVar.xr);
            }
            return new ms(i3, strDecode, strDecode2, i2, i, str, arrayList);
        }

        public String toString() {
            return "Extra{flag=" + this.f102ms + ", rawKey='" + this.xr + "', key='" + this.ah + "', from=" + this.d + ", to=" + this.ka + ", urls=" + this.ab + AbstractJsonLexerKt.END_OBJ;
        }
    }

    static String ms(String str, String str2, List<String> list) {
        StringBuilder sb = new StringBuilder(512);
        String strMs = null;
        do {
            if (strMs != null) {
                if (list.size() == 1) {
                    return null;
                }
                list.remove(list.size() - 1);
            }
            strMs = ms(sb, str, str2, list);
        } while (strMs.length() > 3072);
        return strMs;
    }

    private static String ms(StringBuilder sb, String str, String str2, List<String> list) {
        sb.delete(0, sb.length());
        sb.append("rk=").append(Uri.encode(str));
        sb.append("&k=").append(Uri.encode(str2));
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append("&u").append(i).append("=").append(Uri.encode(list.get(i)));
        }
        return sb.toString();
    }

    public String toString() {
        return "Request{requestLine=" + this.f100ms + ", headers=" + this.xr + ", extra=" + this.ah + AbstractJsonLexerKt.END_OBJ;
    }

    static final class d extends Exception {
        d(String str) {
            super(str);
        }
    }
}
