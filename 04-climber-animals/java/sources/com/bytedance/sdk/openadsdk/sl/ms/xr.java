package com.bytedance.sdk.openadsdk.sl.ms;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.browser.trusted.sharing.ShareTarget;
import com.anythink.core.common.d.j;
import com.baidu.mobads.sdk.internal.a;
import com.bytedance.sdk.component.utils.ka;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.xr.ms.ao;
import com.bytedance.sdk.component.xr.ms.ch;
import com.bytedance.sdk.component.xr.ms.ub;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.t.u;
import com.kwad.sdk.api.model.AdnName;
import com.ss.android.download.api.constant.BaseConstants;
import com.taptap.sdk.db.constant.Common;
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
public class xr extends ms {
    private static final ConcurrentLinkedDeque<String> x = new ConcurrentLinkedDeque<>();
    private final String ch;
    private String hi;
    private long ny;

    public boolean d() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.sl.ms.ms
    public void ms(String str) {
    }

    public xr(com.bytedance.sdk.openadsdk.sl.ms msVar, String str, String str2, JSONObject jSONObject, String str3, String str4) {
        super(msVar, str, str2, jSONObject, str3, str4);
        this.ch = "index_censorship.json";
    }

    @Override // com.bytedance.sdk.openadsdk.sl.ms.ms
    public void ms(final String str, final String str2) {
        u.ms().xr(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.sl.ms.xr.1
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("cid", str);
                    jSONObject.put("req_id", str2);
                } catch (Exception e) {
                    sl.ms(e);
                }
                return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("web_upload_start").xr(jSONObject.toString());
            }
        }, "web_upload_start");
    }

    public void ms(final String str, final String str2, final long j, final String str3, final long j2, final long j3) {
        u.ms().xr(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.sl.ms.xr.2
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("cid", str);
                    jSONObject.put("req_id", str2);
                    jSONObject.put("duration", System.currentTimeMillis() - j);
                    jSONObject.put("weburl", str3);
                    jSONObject.put("size", j2);
                    jSONObject.put("avail_mem", j3);
                } catch (Exception e) {
                    sl.ms(e);
                }
                return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("web_upload_finish").xr(jSONObject.toString());
            }
        }, "web_upload_finish");
    }

    @Override // com.bytedance.sdk.openadsdk.sl.ms.ms
    public boolean ms(WebView webView) {
        if (webView == null || x.contains(this.xr)) {
            return true;
        }
        return (this.ka != null && this.ka.get()) || this.f4101ms.xr().get() > 0;
    }

    /* JADX WARN: Code duplicated, block: B:53:0x00df A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.bytedance.sdk.openadsdk.sl.ms.ms
    public void ms(Context context, String str, com.bytedance.sdk.openadsdk.sl.xr xrVar, WebResourceResponse webResourceResponse, ch chVar, Map<String, Object> map) {
        int i;
        if (com.bytedance.sdk.openadsdk.sl.d.ah()) {
            String string = xrVar.ms().toString();
            String strXr = chVar.xr();
            if (TextUtils.equals(strXr.toLowerCase(), "javascript")) {
                strXr = "js";
            }
            String str2 = ka.xr(string) + j.z + strXr;
            if (TextUtils.isEmpty(strXr)) {
                return;
            }
            HashMap<String, byte[]> map2 = this.f4101ms.ms().get(strXr);
            if (map2 == null) {
                map2 = new HashMap<>();
                this.f4101ms.ms().put(strXr, map2);
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
                    } catch (Exception e) {
                        sl.ms(e);
                        if (data != null) {
                            try {
                                data.close();
                                return;
                            } catch (IOException e2) {
                                sl.ms(e2);
                                return;
                            }
                        }
                        return;
                    }
                } catch (Throwable th) {
                    if (data != null) {
                        try {
                            data.close();
                        } catch (IOException e3) {
                            sl.ms(e3);
                        }
                    }
                    throw th;
                }
                if (data != null) {
                    data.close();
                }
                throw th;
            }
            byte[] bArr2 = new byte[arrayList.size()];
            while (i < arrayList.size()) {
                bArr2[i] = ((Byte) arrayList.get(i)).byteValue();
                i++;
            }
            if (arrayList.size() <= ((long) re.xr().fm()) * BaseConstants.MB_VALUE) {
                map2.put(str2, bArr2);
                ms(this.c, str, chVar, str2, string, xrVar.ah(), map);
            }
            if (data != null) {
                try {
                    data.close();
                } catch (IOException e4) {
                    sl.ms(e4);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.sl.ms.ms
    protected void ms(JSONObject jSONObject, String str, ch chVar, String str2, String str3, Map<String, String> map, Map<String, Object> map2) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt(Common.System.NAME, str2);
            jSONObject2.putOpt("url", str3);
            if (map != null) {
                jSONObject2.putOpt("request_headers", new JSONObject(map));
            }
            if (chVar != null) {
                String lowerCase = chVar.toString().toLowerCase();
                if (lowerCase.contains("image")) {
                    ms(jSONObject2, jSONObject, "sub_pic");
                    return;
                }
                if (!lowerCase.contains("js") && !lowerCase.contains("javascript")) {
                    if (lowerCase.contains("css")) {
                        ms(jSONObject2, jSONObject, "css");
                        return;
                    } else {
                        if (lowerCase.contains(a.f)) {
                            ms(jSONObject2, jSONObject, a.f);
                            return;
                        }
                        return;
                    }
                }
                ms(jSONObject2, jSONObject, "js");
                return;
            }
            ms(jSONObject2, jSONObject, AdnName.OTHER);
        } catch (JSONException e) {
            sl.ms(e);
        }
    }

    private void ms(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray(str);
            if (jSONArrayOptJSONArray == null) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                this.c.putOpt(str, jSONArray);
            } else {
                jSONArrayOptJSONArray.put(jSONObject);
                this.c.putOpt(str, jSONArrayOptJSONArray);
            }
        } catch (JSONException e) {
            sl.ms(e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.sl.ms.ms
    public void ms() {
        try {
            this.c.putOpt(a.f, new JSONArray());
            this.c.putOpt("js", new JSONArray());
            this.c.putOpt("css", new JSONArray());
            this.c.putOpt("sub_pic", new JSONArray());
        } catch (JSONException e) {
            sl.ms(e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.sl.ms.ms
    public boolean ms(ch chVar) {
        try {
            Set<String> setK = re.xr().k();
            String str = chVar.ms().trim().toLowerCase() + "/" + chVar.xr().trim().toLowerCase();
            new StringBuilder("contentType======>").append(setK);
            return setK.contains(str);
        } catch (Exception e) {
            sl.ms(e);
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.sl.ms.ms
    public void ms(com.bytedance.sdk.openadsdk.sl.xr xrVar, WebResourceResponse webResourceResponse, ch chVar, ms.InterfaceC0337ms interfaceC0337ms) {
        interfaceC0337ms.ms(true, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(File file, String str, Context context, long j, long j2) {
        try {
            com.bytedance.sdk.openadsdk.sl.xr.ms.xr(str);
            if (file != null && file.exists()) {
                file.delete();
            }
            int i = com.bytedance.sdk.openadsdk.sl.d.f4094ms.get();
            if (i > 0) {
                com.bytedance.sdk.openadsdk.sl.d.f4094ms.decrementAndGet();
            }
            if (i == 0) {
                com.bytedance.sdk.openadsdk.sl.xr.ms.xr(com.bytedance.sdk.openadsdk.sl.d.xr(context));
            }
            ms(this.xr, this.ah, this.ny, this.ab, j, j2);
        } catch (Exception e) {
            sl.ms(e);
        }
    }

    private byte[] ms(byte[] bArr, int i) {
        return com.bytedance.sdk.openadsdk.op.xr.ms(bArr, i);
    }

    private String ms(Context context) {
        String str = this.hi;
        if (str != null) {
            return str;
        }
        try {
            String str2 = com.bytedance.sdk.openadsdk.sl.d.xr(context) + File.separator + this.xr;
            this.hi = str2;
            return str2;
        } catch (Exception e) {
            sl.ms(e);
            return File.separator + ".lp_cache" + File.separator + this.xr;
        }
    }

    private boolean xr(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            com.bytedance.sdk.openadsdk.sl.xr.xr.ms(str, str2);
            return true;
        } catch (Throwable th) {
            sl.ms(th);
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.sl.ms.ms
    public void xr(Context context, String str, com.bytedance.sdk.openadsdk.sl.xr xrVar, WebResourceResponse webResourceResponse, ch chVar, Map<String, Object> map) {
        try {
            if (com.bytedance.sdk.openadsdk.sl.d.ah()) {
                String strMs = ms(context);
                String string = xrVar.ms().toString();
                String strXr = chVar.xr();
                if (TextUtils.equals(strXr.toLowerCase(), "javascript")) {
                    strXr = "js";
                }
                File file = new File(strMs);
                if (!file.exists()) {
                    file.mkdirs();
                }
                String str2 = ka.xr(string) + j.z + strXr;
                File file2 = new File(strMs, str2);
                if (file2.exists()) {
                    file2.delete();
                    file2.createNewFile();
                }
                file2.getAbsolutePath();
                re.xr().fm();
                if (com.bytedance.sdk.openadsdk.sl.xr.ms.ms(webResourceResponse.getData(), strMs, str2, re.xr().fm())) {
                    ms(this.c, str, chVar, str2, string, xrVar.ah(), map);
                }
            }
        } catch (Exception e) {
            sl.ms(e);
            e.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.sl.ms.ms
    public void ah() {
        if (x.contains(this.xr)) {
            this.f4101ms.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.sl.ms.xr.3
                @Override // java.lang.Runnable
                public void run() {
                    xr.this.ms(null, com.bytedance.sdk.openadsdk.sl.d.xr(re.getContext()), re.getContext(), -1L, -1L);
                }
            });
        } else if (this.d.compareAndSet(false, true)) {
            this.f4101ms.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.sl.ms.xr.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        xr.this.ka.set(true);
                        xr.this.ka();
                        xr.this.d.set(false);
                    } catch (Throwable th) {
                        sl.ms(th);
                    }
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:85:0x019f A[Catch: Exception -> 0x01b8, LOOP:0: B:85:0x019f->B:87:0x01a7, LOOP_START, TryCatch #3 {Exception -> 0x01b8, blocks: (B:83:0x019b, B:85:0x019f, B:87:0x01a7, B:88:0x01ab, B:90:0x01b3), top: B:94:0x019b }] */
    /* JADX WARN: Code duplicated, block: B:87:0x01a7 A[Catch: Exception -> 0x01b8, LOOP:0: B:85:0x019f->B:87:0x01a7, LOOP_END, TryCatch #3 {Exception -> 0x01b8, blocks: (B:83:0x019b, B:85:0x019f, B:87:0x01a7, B:88:0x01ab, B:90:0x01b3), top: B:94:0x019b }] */
    /* JADX WARN: Code duplicated, block: B:90:0x01b3 A[Catch: Exception -> 0x01b8, TRY_LEAVE, TryCatch #3 {Exception -> 0x01b8, blocks: (B:83:0x019b, B:85:0x019f, B:87:0x01a7, B:88:0x01ab, B:90:0x01b3), top: B:94:0x019b }] */
    /* JADX WARN: Code duplicated, block: B:99:0x01ab A[EDGE_INSN: B:99:0x01ab->B:88:0x01ab BREAK  A[LOOP:0: B:85:0x019f->B:87:0x01a7], SYNTHETIC] */
    public void ka() {
        long j;
        ConcurrentLinkedDeque<String> concurrentLinkedDeque;
        this.ny = System.currentTimeMillis();
        Context context = re.getContext();
        String strMs = ms(context);
        if (d()) {
            return;
        }
        if (re.xr().qf() == 1 && !com.bytedance.sdk.component.utils.u.d(context)) {
            ms(null, com.bytedance.sdk.openadsdk.sl.d.xr(context), context, -1L, -1L);
            return;
        }
        if (!com.bytedance.sdk.openadsdk.sl.d.ah()) {
            return;
        }
        Runtime runtime = Runtime.getRuntime();
        long jFreeMemory = runtime.freeMemory() + (runtime.maxMemory() - runtime.totalMemory());
        File file = null;
        try {
            byte[] bytes = this.c.toString().getBytes(StandardCharsets.UTF_8);
            if (re.xr().am() != 1 && !com.bytedance.sdk.openadsdk.sl.xr.ms.ms(new ByteArrayInputStream(bytes), strMs, "index_censorship.json", -2147483648L)) {
                throw new d(false);
            }
            String strXr = com.bytedance.sdk.openadsdk.sl.d.xr(context);
            File file2 = new File(strXr);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            String str = strXr + File.separator + this.xr + "-compress.zip";
            re.xr().am();
            File file3 = new File(str);
            try {
                if (file3.exists()) {
                    file3.delete();
                }
                file3.createNewFile();
                String absolutePath = file3.getAbsolutePath();
                if (re.xr().am() == 1) {
                    HashMap<String, byte[]> map = new HashMap<>();
                    map.put("index_censorship.json", bytes);
                    this.f4101ms.ms().put("index_censorship.json", map);
                    if (TextUtils.isEmpty(strMs) || !com.bytedance.sdk.openadsdk.sl.xr.xr.ms(this.f4101ms.ms(), absolutePath)) {
                        throw new d(false);
                    }
                } else if (!xr(strMs, absolutePath)) {
                    throw new d(false);
                }
                byte[] bArrMs = com.bytedance.sdk.openadsdk.sl.xr.ms.ms(absolutePath);
                long length = (int) new File(absolutePath).length();
                try {
                    long jXn = ((long) re.xr().xn()) * BaseConstants.MB_VALUE;
                    re.xr().xn();
                    if (length > jXn) {
                        throw new d(false);
                    }
                    if (length > jFreeMemory - BaseConstants.MB_VALUE) {
                        throw new d(false);
                    }
                    byte[] bArrMs2 = ms(bArrMs, (int) length);
                    if (bArrMs2 != null && bArrMs2.length <= jXn) {
                        if (ms(bArrMs2, re.xr().il(), file3) == 200) {
                            throw new d(true, bArrMs2.length);
                        }
                        throw new d(false, bArrMs2.length);
                    }
                    throw new d(false, true, bArrMs2 == null ? 0L : bArrMs2.length);
                } catch (d e) {
                    e = e;
                    j = length;
                    file = file3;
                    sl.ms(e);
                    try {
                        if (e.f4100ms) {
                            while (true) {
                                concurrentLinkedDeque = x;
                                if (concurrentLinkedDeque.size() > 0) {
                                    break;
                                } else {
                                    concurrentLinkedDeque.pollLast();
                                }
                            }
                            if (!TextUtils.isEmpty(this.xr)) {
                                concurrentLinkedDeque.push(this.xr);
                            }
                        }
                    } catch (Exception unused) {
                    }
                    ms(file, strMs, context, j, jFreeMemory);
                } catch (IOException e2) {
                    e = e2;
                    j = length;
                    file = file3;
                    sl.ms(e);
                    ms(file, strMs, context, j, jFreeMemory);
                }
            } catch (d e3) {
                e = e3;
                file = file3;
                j = 0;
                sl.ms(e);
                if (e.f4100ms) {
                    while (true) {
                        concurrentLinkedDeque = x;
                        if (concurrentLinkedDeque.size() > 0) {
                            break;
                            break;
                        }
                        concurrentLinkedDeque.pollLast();
                    }
                    if (!TextUtils.isEmpty(this.xr)) {
                        concurrentLinkedDeque.push(this.xr);
                    }
                }
                ms(file, strMs, context, j, jFreeMemory);
            } catch (IOException e4) {
                e = e4;
                file = file3;
                j = 0;
                sl.ms(e);
                ms(file, strMs, context, j, jFreeMemory);
            }
        } catch (d e5) {
            e = e5;
        } catch (IOException e6) {
            e = e6;
        }
    }

    private int ms(byte[] bArr, int i, File file) {
        try {
            ao aoVarMs = com.bytedance.sdk.openadsdk.core.re.ka.ms().xr().c().ms(new com.bytedance.sdk.component.xr.ms.u.ms().ms(re.xr().l() + ("?aid=" + com.bytedance.sdk.openadsdk.core.ch.ub().t() + "&device_platform=android&device_type=android&source_type=union")).ms(ub.ms(ch.ms(ShareTarget.ENCODING_TYPE_MULTIPART), bArr, "file", file.getName())).xr()).ms();
            if (aoVarMs.ah() == 200) {
                JSONObject jSONObject = new JSONObject(aoVarMs.c().xr());
                int iOptInt = jSONObject.optInt("code");
                String strOptString = jSONObject.optString("msg");
                if (iOptInt == 0 && TextUtils.equals("success", strOptString)) {
                    return 200;
                }
                return xr(bArr, i, file);
            }
            return xr(bArr, i, file);
        } catch (Throwable th) {
            sl.ms(th);
            th.getMessage();
            return xr(bArr, i, file);
        }
    }

    private int xr(byte[] bArr, int i, File file) {
        if (i <= 0) {
            return -1;
        }
        return ms(bArr, i - 1, file);
    }
}
