package com.byazt.cmv;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.anythink.core.common.l.b;
import com.byazt.frl.s;
import com.byazt.ien.l;
import com.byazt.nd.q;
import com.byazt.nd.w;
import com.byazt.tk.k;
import com.byazt.vf.wo;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1686, 19})
public final class n {
    public static final Handler qg = new Handler(Looper.getMainLooper());
    public static final Charset n = Charset.forName("UTF-8");

    public static void n(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void n(RandomAccessFile randomAccessFile) {
        if (randomAccessFile != null) {
            try {
                randomAccessFile.getFD().sync();
                randomAccessFile.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean n(String str) {
        if (str != null) {
            return str.startsWith("http://") || str.startsWith("https://");
        }
        return false;
    }

    public static int n(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static String n(int i, int i2) {
        String strQg = qg(i, i2);
        if (strQg == null) {
            return null;
        }
        return "bytes=" + strQg;
    }

    public static String qg(int i, int i2) {
        if (i >= 0 && i2 > 0) {
            return i + "-" + i2;
        }
        if (i > 0) {
            return i + "-";
        }
        if (i >= 0 || i2 <= 0) {
            return null;
        }
        return "-" + i2;
    }

    public static List<String> n(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (n(str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public static int n() {
        return Math.max(Runtime.getRuntime().availableProcessors(), 1);
    }

    /* JADX INFO: renamed from: com.byazt.cmv.n$1, reason: invalid class name */
    @com.byazt.cp.n(n = {0, 1, 1686, 77})
    static class AnonymousClass1 implements FilenameFilter {
        public Pattern n = Pattern.compile("^cpu[0-9]+$");

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return this.n.matcher(str).matches();
        }
    }

    public static int n(com.byazt.ien.n nVar) {
        int iLastIndexOf;
        if (nVar == null) {
            return -1;
        }
        if (nVar.n() == 200) {
            return n(nVar.n("Content-Length", null), -1);
        }
        if (nVar.n() == 206) {
            String strN = nVar.n("Content-Range", null);
            if (!TextUtils.isEmpty(strN) && (iLastIndexOf = strN.lastIndexOf("/")) >= 0 && iLastIndexOf < strN.length() - 1) {
                return n(strN.substring(iLastIndexOf + 1), -1);
            }
        }
        return -1;
    }

    public static String n(com.byazt.ien.n nVar, boolean z, boolean z2) {
        String strN;
        if (nVar == null) {
            if (q.l) {
                k.qg("TAG_PROXY_Response", "response null");
            }
            return "response null";
        }
        if (!nVar.qg()) {
            if (q.l) {
                k.qg("TAG_PROXY_Response", "response code: " + nVar.n());
            }
            return "response code: " + nVar.n();
        }
        String strN2 = nVar.n(b.g, null);
        if (!qg(strN2)) {
            if (q.l) {
                k.qg("TAG_PROXY_Response", "Content-Type: " + strN2);
            }
            return "Content-Type: " + strN2;
        }
        int iN = n(nVar);
        if (iN <= 0) {
            if (q.l) {
                k.qg("TAG_PROXY_Response", "Content-Length: " + iN);
            }
            return "Content-Length: " + iN;
        }
        if (z && ((strN = nVar.n("Accept-Ranges", null)) == null || !strN.contains("bytes"))) {
            if (q.l) {
                k.qg("TAG_PROXY_Response", "Accept-Ranges: " + strN);
            }
            return "Accept-Ranges: " + strN;
        }
        if (!z2 || nVar.q() != null) {
            return null;
        }
        if (q.l) {
            k.qg("TAG_PROXY_Response", "response body null");
        }
        return "response body null";
    }

    public static boolean qg(String str) {
        if (str != null) {
            return str.startsWith("video/") || "application/octet-stream".equals(str) || "binary/octet-stream".equals(str);
        }
        return false;
    }

    public static boolean qg() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public static void n(Runnable runnable) {
        if (runnable != null) {
            if (qg()) {
                ((wo) com.byazt.qp.q.n("thread_service")).n(runnable);
                boolean z = q.l;
            } else {
                runnable.run();
                boolean z2 = q.l;
            }
        }
    }

    public static void qg(Runnable runnable) {
        if (runnable != null) {
            if (qg()) {
                runnable.run();
            } else {
                qg.post(runnable);
            }
        }
    }

    public static List<w.qg> n(List<w.qg> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        if (q.l) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                list.get(i);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (w.qg qgVar : list) {
            if ("Host".equals(qgVar.n) || "Keep-Alive".equals(qgVar.n) || "Connection".equals(qgVar.n) || "Proxy-Connection".equals(qgVar.n)) {
                arrayList.add(qgVar);
            }
        }
        list.removeAll(arrayList);
        if (q.l) {
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                list.get(i2);
            }
        }
        return list;
    }

    public static List<w.qg> n(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            try {
                Set<Map.Entry<String, String>> setEntrySet = map.entrySet();
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<String, String> entry : setEntrySet) {
                    arrayList.add(new w.qg(entry.getKey(), entry.getValue()));
                }
                return arrayList;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static com.byazt.frl.n n(com.byazt.ien.n nVar, s sVar, String str, int i) {
        String strQg;
        String str2;
        String string;
        com.byazt.frl.n nVarQuery = sVar.query(str, i);
        if (nVarQuery != null) {
            return nVarQuery;
        }
        int iN = n(nVar);
        String strN = nVar.n(b.g, null);
        if (iN <= 0 || TextUtils.isEmpty(strN)) {
            return nVarQuery;
        }
        l lVarL = nVar.l();
        if (lVarL != null) {
            str2 = lVarL.qg;
            strQg = qg(lVarL.l);
        } else {
            strQg = "";
            str2 = strQg;
        }
        String strQg2 = qg(nVar.s());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("requestUrl", str2);
            jSONObject.put("requestHeaders", strQg);
            jSONObject.put("responseHeaders", strQg2);
            string = jSONObject.toString();
        } catch (Throwable unused) {
            string = "";
        }
        com.byazt.frl.n nVar2 = new com.byazt.frl.n(str, strN, iN, i, string);
        sVar.insert(nVar2);
        return nVar2;
    }

    public static String qg(List<w.qg> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            w.qg qgVar = list.get(i);
            if (qgVar != null) {
                sb.append(qgVar.n).append(": ").append(qgVar.qg).append("\r\n");
            }
        }
        return sb.toString();
    }

    public static String qg(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append((Object) entry.getKey()).append(": ").append((Object) entry.getValue()).append("\r\n");
        }
        return sb.toString();
    }
}
