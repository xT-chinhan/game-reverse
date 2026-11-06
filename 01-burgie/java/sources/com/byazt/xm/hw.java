package com.byazt.xm;

import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.byazt.ca.c;
import com.byazt.ca.yb;
import com.byazt.mg.PluginConstants;
import com.byazt.nzn.g;
import com.byazt.nzn.ho;
import com.byazt.nzn.nt;
import com.byazt.nzn.vk;
import com.byazt.pk.uc;
import com.byazt.sd.a;
import com.byazt.sd.zo;
import com.tapsdk.tapad.internal.runtime.view.ImageViewManager;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1371, 13})
public class hw extends pr {
    public static final ConcurrentLinkedDeque<String> zo = new ConcurrentLinkedDeque<>();
    public long aj;
    public final String vk;
    public String w;

    public hw(com.byazt.mv.pr prVar, String str, String str2, JSONObject jSONObject, String str3, String str4) {
        super(prVar, str, str2, jSONObject, str3, str4);
        this.vk = "index_censorship.json";
    }

    @Override // com.byazt.xm.pr
    public void pr(final String str, final String str2) {
        com.byazt.xk.hw.pr().pr("web_upload_start", new com.byazt.ttf.pr() { // from class: com.byazt.xm.hw.1
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("cid", str);
                    jSONObject2.put("req_id", str2);
                } catch (Exception e) {
                }
                return jSONObject2;
            }
        });
    }

    public void pr(final String str, final String str2, final long j, final String str3, final long j2, final long j3) {
        com.byazt.xk.hw.pr().pr("web_upload_finish", new com.byazt.ttf.pr() { // from class: com.byazt.xm.hw.2
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("cid", str);
                    jSONObject2.put("req_id", str2);
                    jSONObject2.put("duration", System.currentTimeMillis() - j);
                    jSONObject2.put("weburl", str3);
                    jSONObject2.put("size", j2);
                    jSONObject2.put("avail_mem", j3);
                } catch (Exception e) {
                }
                return jSONObject2;
            }
        });
    }

    @Override // com.byazt.xm.pr
    public boolean pr(WebView webView) {
        if (webView == null || zo.contains(this.hw)) {
            return true;
        }
        return (this.c != null && this.c.get()) || this.pr.hw().get() > 0;
    }

    @Override // com.byazt.xm.pr
    public void pr(Context context, String str, com.byazt.mv.hw hwVar, WebResourceResponse webResourceResponse, vk vkVar, Map<String, Object> map) {
        int i;
        if (com.byazt.mv.x.hn()) {
            String string = hwVar.pr().toString();
            String strHw = vkVar.hw();
            if (TextUtils.equals(strHw.toLowerCase(), "javascript")) {
                strHw = "js";
            }
            String str2 = c.hw(string) + "." + strHw;
            if (!TextUtils.isEmpty(strHw)) {
                HashMap<String, byte[]> map2 = this.pr.pr().get(strHw);
                if (map2 == null) {
                    map2 = new HashMap<>();
                    this.pr.pr().put(strHw, map2);
                }
                ArrayList arrayList = new ArrayList();
                byte[] bArr = new byte[1024];
                InputStream data = webResourceResponse.getData();
                while (true) {
                    try {
                        try {
                            i = 0;
                            if (data.read(bArr) == -1) {
                                break;
                            }
                            while (i < 1024) {
                                arrayList.add(Byte.valueOf(bArr[i]));
                                i++;
                            }
                        } catch (IOException e) {
                            return;
                        }
                    } catch (Exception e2) {
                        if (data != null) {
                            data.close();
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        if (data != null) {
                            try {
                                data.close();
                            } catch (IOException e3) {
                            }
                        }
                        throw th;
                    }
                }
                byte[] bArr2 = new byte[arrayList.size()];
                while (i < arrayList.size()) {
                    bArr2[i] = ((Byte) arrayList.get(i)).byteValue();
                    i++;
                }
                if (arrayList.size() <= ((long) a.hw().aa()) * 1048576) {
                    map2.put(str2, bArr2);
                    pr(this.uc, str, vkVar, str2, string, hwVar.hn(), map);
                }
                if (data != null) {
                    data.close();
                }
            }
        }
    }

    @Override // com.byazt.xm.pr
    public void pr(JSONObject jSONObject, String str, vk vkVar, String str2, String str3, Map<String, String> map, Map<String, Object> map2) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt(Common.System.NAME, str2);
            jSONObject2.putOpt(BreakpointSQLiteKey.URL, str3);
            if (map != null) {
                jSONObject2.putOpt("request_headers", new JSONObject(map));
            }
            if (vkVar != null) {
                String lowerCase = vkVar.toString().toLowerCase();
                if (lowerCase.contains(ImageViewManager.NAME)) {
                    pr(jSONObject2, jSONObject, "sub_pic");
                    return;
                }
                if (!lowerCase.contains("js") && !lowerCase.contains("javascript")) {
                    if (lowerCase.contains("css")) {
                        pr(jSONObject2, jSONObject, "css");
                        return;
                    } else {
                        if (lowerCase.contains("html")) {
                            pr(jSONObject2, jSONObject, "html");
                            return;
                        }
                        return;
                    }
                }
                pr(jSONObject2, jSONObject, "js");
                return;
            }
            pr(jSONObject2, jSONObject, "other");
        } catch (JSONException e) {
        }
    }

    private void pr(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray(str);
            if (jSONArrayOptJSONArray == null) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                this.uc.putOpt(str, jSONArray);
            } else {
                jSONArrayOptJSONArray.put(jSONObject);
                this.uc.putOpt(str, jSONArrayOptJSONArray);
            }
        } catch (JSONException e) {
        }
    }

    @Override // com.byazt.xm.pr
    public void pr() {
        try {
            this.uc.putOpt("html", new JSONArray());
            this.uc.putOpt("js", new JSONArray());
            this.uc.putOpt("css", new JSONArray());
            this.uc.putOpt("sub_pic", new JSONArray());
        } catch (JSONException e) {
        }
    }

    @Override // com.byazt.xm.pr
    public boolean pr(vk vkVar) {
        try {
            Set<String> setJw = a.hw().jw();
            String str = vkVar.pr().trim().toLowerCase() + "/" + vkVar.hw().trim().toLowerCase();
            new StringBuilder("contentType======>").append(setJw).append("   ").append(str);
            return setJw.contains(str);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.byazt.xm.pr
    public void pr(String str) {
    }

    @Override // com.byazt.xm.pr
    public void pr(com.byazt.mv.hw hwVar, WebResourceResponse webResourceResponse, vk vkVar, pr.InterfaceC0235pr interfaceC0235pr) {
        interfaceC0235pr.pr(true, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(File file, String str, Context context, long j, long j2) {
        try {
            com.byazt.ej.pr.hw(str);
            if (file != null && file.exists()) {
                file.delete();
            }
            int i = com.byazt.mv.x.pr.get();
            if (i > 0) {
                com.byazt.mv.x.pr.decrementAndGet();
            }
            if (i == 0) {
                com.byazt.ej.pr.hw(com.byazt.mv.x.hw(context));
            }
            pr(this.hw, this.hn, this.aj, this.fw, j, j2);
        } catch (Exception e) {
        }
    }

    private byte[] pr(byte[] bArr, int i) {
        return com.byazt.zp.hn.pr(bArr, i);
    }

    private String pr(Context context) {
        String str = this.w;
        if (str != null) {
            return str;
        }
        try {
            String str2 = com.byazt.mv.x.hw(context) + File.separator + this.hw;
            this.w = str2;
            return str2;
        } catch (Exception e) {
            return File.separator + ".lp_cache" + File.separator + this.hw;
        }
    }

    private boolean hw(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str)) {
                com.byazt.ej.hw.pr(str, str2);
                return true;
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public boolean x() {
        return false;
    }

    @Override // com.byazt.xm.pr
    public void hw(Context context, String str, com.byazt.mv.hw hwVar, WebResourceResponse webResourceResponse, vk vkVar, Map<String, Object> map) {
        try {
            if (com.byazt.mv.x.hn()) {
                String strPr = pr(context);
                String string = hwVar.pr().toString();
                String strHw = vkVar.hw();
                if (TextUtils.equals(strHw.toLowerCase(), "javascript")) {
                    strHw = "js";
                }
                File file = new File(strPr);
                if (!file.exists()) {
                    file.mkdirs();
                }
                String str2 = c.hw(string) + "." + strHw;
                File file2 = new File(strPr, str2);
                if (file2.exists()) {
                    file2.delete();
                    file2.createNewFile();
                }
                file2.getAbsolutePath();
                a.hw().aa();
                if (com.byazt.ej.pr.pr(webResourceResponse.getData(), strPr, str2, a.hw().aa())) {
                    pr(this.uc, str, vkVar, str2, string, hwVar.hn(), map);
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override // com.byazt.xm.pr
    public void hn() {
        if (zo.contains(this.hw)) {
            this.pr.pr(new Runnable() { // from class: com.byazt.xm.hw.3
                @Override // java.lang.Runnable
                public void run() {
                    hw.this.pr(null, com.byazt.mv.x.hw(a.getContext()), a.getContext(), -1L, -1L);
                }
            });
        } else if (this.x.compareAndSet(false, true)) {
            this.pr.pr(new Runnable() { // from class: com.byazt.xm.hw.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        hw.this.c.set(true);
                        hw.this.c();
                        hw.this.x.set(false);
                    } catch (Throwable th) {
                    }
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:83:0x019b A[Catch: Exception -> 0x01b5, LOOP:0: B:83:0x019b->B:85:0x01a3, LOOP_START, TryCatch #4 {Exception -> 0x01b5, blocks: (B:81:0x0197, B:83:0x019b, B:85:0x01a3, B:86:0x01a7, B:88:0x01af), top: B:93:0x0197 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x01a3 A[Catch: Exception -> 0x01b5, LOOP:0: B:83:0x019b->B:85:0x01a3, LOOP_END, TryCatch #4 {Exception -> 0x01b5, blocks: (B:81:0x0197, B:83:0x019b, B:85:0x01a3, B:86:0x01a7, B:88:0x01af), top: B:93:0x0197 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x01af A[Catch: Exception -> 0x01b5, TRY_LEAVE, TryCatch #4 {Exception -> 0x01b5, blocks: (B:81:0x0197, B:83:0x019b, B:85:0x01a3, B:86:0x01a7, B:88:0x01af), top: B:93:0x0197 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x01a7 A[EDGE_INSN: B:98:0x01a7->B:86:0x01a7 BREAK  A[LOOP:0: B:83:0x019b->B:85:0x01a3], SYNTHETIC] */
    public void c() {
        long j;
        ConcurrentLinkedDeque<String> concurrentLinkedDeque;
        this.aj = System.currentTimeMillis();
        Context context = a.getContext();
        String strPr = pr(context);
        if (x()) {
            return;
        }
        if (a.hw().j() == 1 && !yb.x(context)) {
            pr(null, com.byazt.mv.x.hw(context), context, -1L, -1L);
            return;
        }
        if (com.byazt.mv.x.hn()) {
            Runtime runtime = Runtime.getRuntime();
            long jFreeMemory = runtime.freeMemory() + (runtime.maxMemory() - runtime.totalMemory());
            File file = null;
            try {
                byte[] bytes = this.uc.toString().getBytes(StandardCharsets.UTF_8);
                if (a.hw().bh() != 1 && !com.byazt.ej.pr.pr(new ByteArrayInputStream(bytes), strPr, "index_censorship.json", -2147483648L)) {
                    throw new x(false);
                }
                String strHw = com.byazt.mv.x.hw(context);
                File file2 = new File(strHw);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                String str = strHw + File.separator + this.hw + "-compress.zip";
                a.hw().bh();
                File file3 = new File(str);
                try {
                    if (file3.exists()) {
                        file3.delete();
                    }
                    file3.createNewFile();
                    String absolutePath = file3.getAbsolutePath();
                    if (a.hw().bh() == 1) {
                        HashMap<String, byte[]> map = new HashMap<>();
                        map.put("index_censorship.json", bytes);
                        this.pr.pr().put("index_censorship.json", map);
                        if (TextUtils.isEmpty(strPr) || !com.byazt.ej.hw.pr(this.pr.pr(), absolutePath)) {
                            throw new x(false);
                        }
                    } else if (!hw(strPr, absolutePath)) {
                        throw new x(false);
                    }
                    byte[] bArrPr = com.byazt.ej.pr.pr(absolutePath);
                    long length = (int) new File(absolutePath).length();
                    try {
                        long jIy = ((long) a.hw().iy()) * 1048576;
                        a.hw().iy();
                        if (length > jIy) {
                            throw new x(false);
                        }
                        if (length <= jFreeMemory - 1048576) {
                            byte[] bArrPr2 = pr(bArrPr, (int) length);
                            if (bArrPr2 != null && bArrPr2.length <= jIy) {
                                if (pr(bArrPr2, a.hw().cr(), file3) == 200) {
                                    throw new x(true, bArrPr2.length);
                                }
                                throw new x(false, bArrPr2.length);
                            }
                            throw new x(false, true, bArrPr2 == null ? 0L : bArrPr2.length);
                        }
                        throw new x(false);
                    } catch (x e) {
                        e = e;
                        j = length;
                        file = file3;
                        try {
                            if (e.pr) {
                                while (true) {
                                    concurrentLinkedDeque = zo;
                                    if (concurrentLinkedDeque.size() > 0) {
                                        break;
                                    } else {
                                        concurrentLinkedDeque.pollLast();
                                    }
                                }
                                if (!TextUtils.isEmpty(this.hw)) {
                                    concurrentLinkedDeque.push(this.hw);
                                }
                            }
                        } catch (Exception e2) {
                        }
                        pr(file, strPr, context, j, jFreeMemory);
                    } catch (IOException e3) {
                        j = length;
                        file = file3;
                        pr(file, strPr, context, j, jFreeMemory);
                    }
                } catch (x e4) {
                    e = e4;
                    file = file3;
                    j = 0;
                    if (e.pr) {
                        while (true) {
                            concurrentLinkedDeque = zo;
                            if (concurrentLinkedDeque.size() > 0) {
                                break;
                                break;
                            }
                            concurrentLinkedDeque.pollLast();
                        }
                        if (!TextUtils.isEmpty(this.hw)) {
                            concurrentLinkedDeque.push(this.hw);
                        }
                    }
                    pr(file, strPr, context, j, jFreeMemory);
                } catch (IOException e5) {
                    file = file3;
                    j = 0;
                    pr(file, strPr, context, j, jFreeMemory);
                }
            } catch (x e6) {
                e = e6;
            } catch (IOException e7) {
            }
        }
    }

    private int pr(byte[] bArr, int i, File file) {
        try {
            nt ntVarHw = uc.pr().hw().pr().pr(new g.pr().pr(a.hw().qo() + ("?aid=" + zo.nt().ny() + "&device_platform=android&device_type=android&source_type=union")).pr(ho.pr(vk.pr("multipart/form-data"), bArr, "file", file.getName())).hw()).hw();
            if (ntVarHw.hn() == 200) {
                JSONObject jSONObject = new JSONObject(ntVarHw.uc().hw());
                int iOptInt = jSONObject.optInt(PluginConstants.KEY_ERROR_CODE);
                String strOptString = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE);
                if (iOptInt == 0 && TextUtils.equals(TrackAction.SUCCESS, strOptString)) {
                    return 200;
                }
                return hw(bArr, i, file);
            }
            return hw(bArr, i, file);
        } catch (Throwable th) {
            th.getMessage();
            return hw(bArr, i, file);
        }
    }

    private int hw(byte[] bArr, int i, File file) {
        if (i <= 0) {
            return -1;
        }
        return pr(bArr, i - 1, file);
    }
}
