package com.byazt.a;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.byazt.aj.c;
import com.byazt.ca.ho;
import com.byazt.d.hn;
import com.byazt.i.x;
import com.byazt.vkw.qi;
import com.byazt.zs.uc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.update.download.core.Util;
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
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_NOTIFY_ALL_SEI_THRESHOLD, 37})
public final class pr {
    public static final Handler hw = new Handler(Looper.getMainLooper());
    public static final Charset pr = Charset.forName(Key.STRING_CHARSET_NAME);

    public static void pr(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
            }
        }
    }

    public static void pr(RandomAccessFile randomAccessFile) {
        if (randomAccessFile != null) {
            try {
                randomAccessFile.getFD().sync();
                randomAccessFile.close();
            } catch (Throwable th) {
            }
        }
    }

    public static boolean pr(String str) {
        if (str != null) {
            return str.startsWith("http://") || str.startsWith("https://");
        }
        return false;
    }

    public static int pr(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return i;
        }
    }

    public static String pr(int i, int i2) {
        String strHw = hw(i, i2);
        if (strHw == null) {
            return null;
        }
        return "bytes=" + strHw;
    }

    public static String hw(int i, int i2) {
        if (i >= 0 && i2 > 0) {
            return i + "-" + i2;
        }
        if (i > 0) {
            return i + "-";
        }
        if (i < 0 && i2 > 0) {
            return "-" + i2;
        }
        return null;
    }

    public static List<String> pr(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (pr(str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public static int pr() {
        File[] fileArrListFiles;
        if (Build.VERSION.SDK_INT >= 17) {
            return Math.max(Runtime.getRuntime().availableProcessors(), 1);
        }
        try {
            File file = new File("/sys/devices/system/cpu/");
            if (!file.exists() || (fileArrListFiles = file.listFiles(new FilenameFilter() { // from class: com.byazt.a.pr.1
                public Pattern pr = Pattern.compile("^cpu[0-9]+$");

                @Override // java.io.FilenameFilter
                public boolean accept(File file2, String str) {
                    return this.pr.matcher(str).matches();
                }
            })) == null) {
                return 1;
            }
            return Math.max(fileArrListFiles.length, 1);
        } catch (Throwable th) {
        }
        return 1;
    }

    public static int pr(com.byazt.aj.pr prVar) {
        int iLastIndexOf;
        if (prVar == null) {
            return -1;
        }
        if (prVar.pr() == 200) {
            return pr(prVar.pr(Util.CONTENT_LENGTH, null), -1);
        }
        if (prVar.pr() == 206) {
            String strPr = prVar.pr(Util.CONTENT_RANGE, null);
            if (!TextUtils.isEmpty(strPr) && (iLastIndexOf = strPr.lastIndexOf("/")) >= 0 && iLastIndexOf < strPr.length() - 1) {
                return pr(strPr.substring(iLastIndexOf + 1), -1);
            }
        }
        return -1;
    }

    public static String pr(com.byazt.aj.pr prVar, boolean z, boolean z2) {
        String strPr;
        if (prVar == null) {
            if (x.c) {
                ho.hw("TAG_PROXY_Response", "response null");
            }
            return "response null";
        }
        if (!prVar.hw()) {
            if (x.c) {
                ho.hw("TAG_PROXY_Response", "response code: " + prVar.pr());
            }
            return "response code: " + prVar.pr();
        }
        String strPr2 = prVar.pr("Content-Type", null);
        if (!hw(strPr2)) {
            if (x.c) {
                ho.hw("TAG_PROXY_Response", "Content-Type: " + strPr2);
            }
            return "Content-Type: " + strPr2;
        }
        int iPr = pr(prVar);
        if (iPr <= 0) {
            if (x.c) {
                ho.hw("TAG_PROXY_Response", "Content-Length: " + iPr);
            }
            return "Content-Length: " + iPr;
        }
        if (z && ((strPr = prVar.pr(Util.ACCEPT_RANGES, null)) == null || !strPr.contains("bytes"))) {
            if (x.c) {
                ho.hw("TAG_PROXY_Response", "Accept-Ranges: " + strPr);
            }
            return "Accept-Ranges: " + strPr;
        }
        if (!z2 || prVar.x() != null) {
            return null;
        }
        if (x.c) {
            ho.hw("TAG_PROXY_Response", "response body null");
        }
        return "response body null";
    }

    public static boolean hw(String str) {
        if (str != null) {
            return str.startsWith("video/") || "application/octet-stream".equals(str) || "binary/octet-stream".equals(str);
        }
        return false;
    }

    public static boolean hw() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public static void pr(Runnable runnable) {
        if (runnable != null) {
            if (hw()) {
                ((qi) uc.pr("thread_service")).pr(runnable);
                boolean z = x.c;
            } else {
                runnable.run();
                boolean z2 = x.c;
            }
        }
    }

    public static void hw(Runnable runnable) {
        if (runnable != null) {
            if (hw()) {
                runnable.run();
            } else {
                hw.post(runnable);
            }
        }
    }

    public static List<com.byazt.i.uc.hw> pr(List<com.byazt.i.uc.hw> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        if (x.c) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                list.get(i);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (com.byazt.i.uc.hw hwVar : list) {
            if ("Host".equals(hwVar.pr) || "Keep-Alive".equals(hwVar.pr) || "Connection".equals(hwVar.pr) || "Proxy-Connection".equals(hwVar.pr)) {
                arrayList.add(hwVar);
            }
        }
        list.removeAll(arrayList);
        if (x.c) {
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                list.get(i2);
            }
        }
        return list;
    }

    public static List<com.byazt.i.uc.hw> pr(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        try {
            Set<Map.Entry<String, String>> setEntrySet = map.entrySet();
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, String> entry : setEntrySet) {
                arrayList.add(new com.byazt.i.uc.hw(entry.getKey(), entry.getValue()));
            }
            return arrayList;
        } catch (Throwable th) {
            return null;
        }
    }

    public static com.byazt.d.pr pr(com.byazt.aj.pr prVar, hn hnVar, String str, int i) {
        String strHw;
        String str2;
        String string;
        com.byazt.d.pr prVarQuery = hnVar.query(str, i);
        if (prVarQuery == null) {
            int iPr = pr(prVar);
            String strPr = prVar.pr("Content-Type", null);
            if (iPr > 0 && !TextUtils.isEmpty(strPr)) {
                c cVarC = prVar.c();
                if (cVarC == null) {
                    strHw = "";
                    str2 = strHw;
                } else {
                    str2 = cVarC.hw;
                    strHw = hw(cVarC.c);
                }
                String strHw2 = hw(prVar.hn());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("requestUrl", str2);
                    jSONObject.put("requestHeaders", strHw);
                    jSONObject.put("responseHeaders", strHw2);
                    string = jSONObject.toString();
                } catch (Throwable th) {
                    string = "";
                }
                com.byazt.d.pr prVar2 = new com.byazt.d.pr(str, strPr, iPr, i, string);
                hnVar.insert(prVar2);
                return prVar2;
            }
            return prVarQuery;
        }
        return prVarQuery;
    }

    public static String hw(List<com.byazt.i.uc.hw> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            com.byazt.i.uc.hw hwVar = list.get(i);
            if (hwVar != null) {
                sb.append(hwVar.pr).append(": ").append(hwVar.hw).append("\r\n");
            }
        }
        return sb.toString();
    }

    public static String hw(Map<String, String> map) {
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
