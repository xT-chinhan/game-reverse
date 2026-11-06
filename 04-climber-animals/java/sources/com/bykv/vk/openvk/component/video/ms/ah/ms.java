package com.bykv.vk.openvk.component.video.ms.ah;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.ms.xr.ka;
import com.bykv.vk.openvk.component.video.ms.xr.ny;
import com.bykv.vk.openvk.component.video.ms.xr.xr.ah;
import com.bytedance.sdk.component.ch.ab;
import com.bytedance.sdk.component.utils.sl;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class ms {
    private static final Handler xr = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final Charset f28ms = Charset.forName("UTF-8");

    public static void ms(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void ms(ServerSocket serverSocket) {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void ms(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void ms(RandomAccessFile randomAccessFile) {
        if (randomAccessFile != null) {
            try {
                randomAccessFile.getFD().sync();
                randomAccessFile.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean ms(String str) {
        if (str != null) {
            return str.startsWith("http://") || str.startsWith("https://");
        }
        return false;
    }

    public static int xr(String str) {
        return ms(str, 0);
    }

    public static int ms(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static String ms(com.bykv.vk.openvk.component.video.ms.xr.ka.ms msVar, int i) {
        int iMs;
        if (msVar == null || !msVar.xr()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(msVar.ka().toUpperCase()).append(' ').append(msVar.ms()).append(' ').append(msVar.c()).append("\r\n");
        if (ka.ah) {
            sl.ms("TAG_PROXY_headers", msVar.ka().toUpperCase() + " " + msVar.ms() + " " + msVar.c());
        }
        List<ny.xr> listMs = ms(msVar.ah());
        boolean z = true;
        if (listMs != null) {
            int size = listMs.size();
            for (int i2 = 0; i2 < size; i2++) {
                ny.xr xrVar = listMs.get(i2);
                if (xrVar != null) {
                    String str = xrVar.f103ms;
                    String str2 = xrVar.xr;
                    sb.append(str).append(": ").append(str2).append("\r\n");
                    if ("Content-Range".equalsIgnoreCase(str) || ("Accept-Ranges".equalsIgnoreCase(str) && "bytes".equalsIgnoreCase(str2))) {
                        z = false;
                    }
                }
            }
        }
        if (z && (iMs = ms(msVar)) > 0) {
            sb.append("Content-Range: bytes ").append(Math.max(i, 0)).append("-").append(iMs - 1).append("/").append(iMs).append("\r\n");
        }
        sb.append("Connection: close\r\n\r\n");
        String string = sb.toString();
        if (ka.ah) {
            sl.ms("TAG_PROXY_WRITE_TO_MP", string);
        }
        return string;
    }

    public static String ms(int i, int i2) {
        String strXr = xr(i, i2);
        if (strXr == null) {
            return null;
        }
        return "bytes=" + strXr;
    }

    public static String xr(int i, int i2) {
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

    public static List<String> ms(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (ms(str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public static String ms(com.bykv.vk.openvk.component.video.ms.xr.xr.ms msVar, int i) {
        StringBuilder sb = new StringBuilder();
        if (i <= 0) {
            sb.append("HTTP/1.1 200 OK\r\n");
        } else {
            sb.append("HTTP/1.1 206 Partial Content\r\n");
        }
        sb.append("Accept-Ranges: bytes\r\nContent-Type: ");
        sb.append(msVar.xr).append("\r\n");
        if (i <= 0) {
            sb.append("Content-Length: ").append(msVar.ah).append("\r\n");
        } else {
            sb.append("Content-Range: bytes ").append(i).append("-").append(msVar.ah - 1).append("/").append(msVar.ah).append("\r\nContent-Length: ");
            sb.append(msVar.ah - i).append("\r\n");
        }
        sb.append("Connection: close\r\n\r\n");
        String string = sb.toString();
        if (ka.ah) {
            sl.ms("TAG_PROXY_WRITE_TO_MP", string);
        }
        return string;
    }

    public static int ms() {
        return Math.max(Runtime.getRuntime().availableProcessors(), 1);
    }

    /* JADX INFO: renamed from: com.bykv.vk.openvk.component.video.ms.ah.ms$1, reason: invalid class name */
    static class AnonymousClass1 implements FilenameFilter {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private Pattern f29ms = Pattern.compile("^cpu[0-9]+$");

        AnonymousClass1() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return this.f29ms.matcher(str).matches();
        }
    }

    public static int ms(com.bykv.vk.openvk.component.video.ms.xr.ka.ms msVar) {
        int iLastIndexOf;
        if (msVar == null) {
            return -1;
        }
        if (msVar.ms() == 200) {
            return ms(msVar.ms("Content-Length", null), -1);
        }
        if (msVar.ms() == 206) {
            String strMs = msVar.ms("Content-Range", null);
            if (!TextUtils.isEmpty(strMs) && (iLastIndexOf = strMs.lastIndexOf("/")) >= 0 && iLastIndexOf < strMs.length() - 1) {
                return ms(strMs.substring(iLastIndexOf + 1), -1);
            }
        }
        return -1;
    }

    public static String ms(com.bykv.vk.openvk.component.video.ms.xr.ka.ms msVar, boolean z, boolean z2) {
        String strMs;
        if (msVar == null) {
            if (ka.ah) {
                sl.d("TAG_PROXY_Response", "response null");
            }
            return "response null";
        }
        if (!msVar.xr()) {
            if (ka.ah) {
                sl.d("TAG_PROXY_Response", "response code: " + msVar.ms());
            }
            return "response code: " + msVar.ms();
        }
        String strMs2 = msVar.ms("Content-Type", null);
        if (!ah(strMs2)) {
            if (ka.ah) {
                sl.d("TAG_PROXY_Response", "Content-Type: " + strMs2);
            }
            return "Content-Type: " + strMs2;
        }
        int iMs = ms(msVar);
        if (iMs <= 0) {
            if (ka.ah) {
                sl.d("TAG_PROXY_Response", "Content-Length: " + iMs);
            }
            return "Content-Length: " + iMs;
        }
        if (z && ((strMs = msVar.ms("Accept-Ranges", null)) == null || !strMs.contains("bytes"))) {
            if (ka.ah) {
                sl.d("TAG_PROXY_Response", "Accept-Ranges: " + strMs);
            }
            return "Accept-Ranges: " + strMs;
        }
        if (!z2 || msVar.d() != null) {
            return null;
        }
        if (ka.ah) {
            sl.d("TAG_PROXY_Response", "response body null");
        }
        return "response body null";
    }

    public static boolean ah(String str) {
        if (str != null) {
            return str.startsWith("video/") || "application/octet-stream".equals(str) || "binary/octet-stream".equals(str);
        }
        return false;
    }

    public static boolean xr() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public static void ms(com.bytedance.sdk.component.ch.ny nyVar) {
        if (nyVar != null) {
            if (xr()) {
                ab.xr(nyVar);
                if (ka.ah) {
                    sl.d("TAG_PROXY_UTIL", "invoke in pool thread");
                    return;
                }
                return;
            }
            nyVar.run();
            if (ka.ah) {
                sl.d("TAG_PROXY_UTIL", "invoke calling thread");
            }
        }
    }

    public static void ms(Runnable runnable) {
        if (runnable != null) {
            if (xr()) {
                runnable.run();
            } else {
                xr.post(runnable);
            }
        }
    }

    public static List<ny.xr> ms(List<ny.xr> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        if (ka.ah) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ny.xr xrVar = list.get(i);
                if (xrVar != null) {
                    sl.ms("TAG_PROXY_PRE_FILTER", xrVar.f103ms + ": " + xrVar.f103ms);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (ny.xr xrVar2 : list) {
            if ("Host".equals(xrVar2.f103ms) || "Keep-Alive".equals(xrVar2.f103ms) || "Connection".equals(xrVar2.f103ms) || "Proxy-Connection".equals(xrVar2.f103ms)) {
                arrayList.add(xrVar2);
            }
        }
        list.removeAll(arrayList);
        if (ka.ah) {
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ny.xr xrVar3 = list.get(i2);
                if (xrVar3 != null) {
                    sl.ms("TAG_PROXY_POST_FILTER", xrVar3.f103ms + ": " + xrVar3.xr);
                }
            }
        }
        return list;
    }

    public static List<ny.xr> ms(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            try {
                Set<Map.Entry<String, String>> setEntrySet = map.entrySet();
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<String, String> entry : setEntrySet) {
                    arrayList.add(new ny.xr(entry.getKey(), entry.getValue()));
                }
                return arrayList;
            } catch (Throwable th) {
                sl.ms(th);
            }
        }
        return null;
    }

    public static com.bykv.vk.openvk.component.video.ms.xr.xr.ms ms(com.bykv.vk.openvk.component.video.ms.xr.ka.ms msVar, ah ahVar, String str, int i) {
        String strXr;
        String str2;
        String string;
        com.bykv.vk.openvk.component.video.ms.xr.xr.ms msVarQuery = ahVar.query(str, i);
        if (msVarQuery != null) {
            return msVarQuery;
        }
        int iMs = ms(msVar);
        String strMs = msVar.ms("Content-Type", null);
        if (iMs <= 0 || TextUtils.isEmpty(strMs)) {
            return msVarQuery;
        }
        com.bykv.vk.openvk.component.video.ms.xr.ka.ka kaVarAb = msVar.ab();
        if (kaVarAb != null) {
            str2 = kaVarAb.xr;
            strXr = xr(kaVarAb.ka);
        } else {
            strXr = "";
            str2 = strXr;
        }
        String strXr2 = xr(msVar.ah());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("requestUrl", str2);
            jSONObject.put("requestHeaders", strXr);
            jSONObject.put("responseHeaders", strXr2);
            string = jSONObject.toString();
        } catch (Throwable unused) {
            string = "";
        }
        com.bykv.vk.openvk.component.video.ms.xr.xr.ms msVar2 = new com.bykv.vk.openvk.component.video.ms.xr.xr.ms(str, strMs, iMs, i, string);
        ahVar.insert(msVar2);
        return msVar2;
    }

    public static String xr(List<ny.xr> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ny.xr xrVar = list.get(0);
            if (xrVar != null) {
                sb.append(xrVar.f103ms).append(": ").append(xrVar.xr).append("\r\n");
            }
        }
        return sb.toString();
    }

    public static String xr(Map<String, String> map) {
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
