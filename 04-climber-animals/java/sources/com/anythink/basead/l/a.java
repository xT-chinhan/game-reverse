package com.anythink.basead.l;

import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.x;
import com.anythink.core.common.m.q;
import com.anythink.core.common.v.m;
import com.anythink.core.common.v.p;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.efs.sdk.base.Constants;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.SSLException;
import kotlin.UByte;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: classes.dex */
public class a {
    protected static final String b = "User-Agent";
    protected static final String c = "Accept-Language";
    protected static final String d = "Accept";
    protected static final String e = "application/x-www-form-urlencoded,application/json,text/plain,text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8";
    protected static final String f = "Content-Type";
    protected static final String g = "application/json";
    public static final int h = 5;
    protected boolean i;
    protected String j;
    protected q k;
    private x m;
    final String a = "a";
    int l = 0;

    public a(x xVar) {
        this.m = xVar;
    }

    public final void a(final String str, q qVar) {
        this.k = qVar;
        com.anythink.core.common.v.b.b.a().a(new com.anythink.core.common.v.b.d() { // from class: com.anythink.basead.l.a.1
            final /* synthetic */ int a = AVMDLDataLoader.KeyIsEnableEventInfo;

            /* JADX WARN: Code duplicated, block: B:21:0x004e  */
            /* JADX WARN: Code duplicated, block: B:24:0x0058  */
            /* JADX WARN: Code duplicated, block: B:29:? A[RETURN, SYNTHETIC] */
            @Override // com.anythink.core.common.v.b.d
            public final void a() throws Throwable {
                String message;
                try {
                    if (a.this.k != null) {
                        a.this.k.onLoadStart(this.a);
                    }
                    b(str);
                } catch (Exception e2) {
                    String message2 = e2.getMessage();
                    if (e2.getMessage() != null) {
                        message2 = e2.getMessage();
                    }
                    if (a.this.k != null) {
                        a.this.k.onLoadError(this.a, message2, ErrorCode.getErrorCode(ErrorCode.exception, ErrorCode.exception, e2.getMessage()));
                    }
                } catch (OutOfMemoryError e3) {
                    e = e3;
                    System.gc();
                    message = e.getMessage();
                    if (e.getMessage() != null) {
                        message = e.getMessage();
                    }
                    if (a.this.k != null) {
                        a.this.k.onLoadError(this.a, message, ErrorCode.getErrorCode(ErrorCode.exception, ErrorCode.exception, e.getMessage()));
                    }
                } catch (StackOverflowError e4) {
                    e = e4;
                    System.gc();
                    message = e.getMessage();
                    if (e.getMessage() != null) {
                        message = e.getMessage();
                    }
                    if (a.this.k != null) {
                        a.this.k.onLoadError(this.a, message, ErrorCode.getErrorCode(ErrorCode.exception, ErrorCode.exception, e.getMessage()));
                    }
                }
            }

            /* JADX WARN: Code duplicated, block: B:166:0x0239 A[Catch: all -> 0x0409, TryCatch #77 {all -> 0x0409, blocks: (B:59:0x0132, B:164:0x022c, B:166:0x0239, B:167:0x023d, B:180:0x0266, B:182:0x0276, B:183:0x027a, B:196:0x02a3, B:198:0x02b0, B:199:0x02b4, B:212:0x02dd, B:214:0x02ea, B:215:0x02ee, B:228:0x0316, B:241:0x0337, B:254:0x0362, B:267:0x038d, B:280:0x03b8, B:293:0x03e3), top: B:407:0x0003 }] */
            /* JADX WARN: Code duplicated, block: B:175:0x025d  */
            /* JADX WARN: Code duplicated, block: B:182:0x0276 A[Catch: all -> 0x0409, TryCatch #77 {all -> 0x0409, blocks: (B:59:0x0132, B:164:0x022c, B:166:0x0239, B:167:0x023d, B:180:0x0266, B:182:0x0276, B:183:0x027a, B:196:0x02a3, B:198:0x02b0, B:199:0x02b4, B:212:0x02dd, B:214:0x02ea, B:215:0x02ee, B:228:0x0316, B:241:0x0337, B:254:0x0362, B:267:0x038d, B:280:0x03b8, B:293:0x03e3), top: B:407:0x0003 }] */
            /* JADX WARN: Code duplicated, block: B:191:0x029a  */
            /* JADX WARN: Code duplicated, block: B:198:0x02b0 A[Catch: all -> 0x0409, TryCatch #77 {all -> 0x0409, blocks: (B:59:0x0132, B:164:0x022c, B:166:0x0239, B:167:0x023d, B:180:0x0266, B:182:0x0276, B:183:0x027a, B:196:0x02a3, B:198:0x02b0, B:199:0x02b4, B:212:0x02dd, B:214:0x02ea, B:215:0x02ee, B:228:0x0316, B:241:0x0337, B:254:0x0362, B:267:0x038d, B:280:0x03b8, B:293:0x03e3), top: B:407:0x0003 }] */
            /* JADX WARN: Code duplicated, block: B:207:0x02d4  */
            /* JADX WARN: Code duplicated, block: B:214:0x02ea A[Catch: all -> 0x0409, TryCatch #77 {all -> 0x0409, blocks: (B:59:0x0132, B:164:0x022c, B:166:0x0239, B:167:0x023d, B:180:0x0266, B:182:0x0276, B:183:0x027a, B:196:0x02a3, B:198:0x02b0, B:199:0x02b4, B:212:0x02dd, B:214:0x02ea, B:215:0x02ee, B:228:0x0316, B:241:0x0337, B:254:0x0362, B:267:0x038d, B:280:0x03b8, B:293:0x03e3), top: B:407:0x0003 }] */
            /* JADX WARN: Code duplicated, block: B:223:0x030e  */
            /* JADX WARN: Code duplicated, block: B:236:0x032e  */
            /* JADX WARN: Code duplicated, block: B:249:0x0359  */
            /* JADX WARN: Code duplicated, block: B:262:0x0384  */
            /* JADX WARN: Code duplicated, block: B:275:0x03af  */
            /* JADX WARN: Code duplicated, block: B:288:0x03da  */
            /* JADX WARN: Code duplicated, block: B:301:0x0405  */
            /* JADX WARN: Code duplicated, block: B:311:0x041b  */
            /* JADX WARN: Code duplicated, block: B:349:0x031f A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:351:0x03a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:353:0x0324 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:355:0x03a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:357:0x0329 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:359:0x03aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:361:0x02c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:363:0x034a A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:365:0x02ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:367:0x03cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:369:0x024e A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:371:0x034f A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:373:0x02cf A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:375:0x03d0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:377:0x0253 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:379:0x0354 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:381:0x03d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:385:0x0258 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:391:0x0375 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:393:0x03f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:395:0x037a A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:397:0x03fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:399:0x037f A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:401:0x02ff A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:403:0x0400 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:405:0x0304 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:408:0x0309 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:410:0x028b A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:412:0x040c A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:414:0x0290 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:416:0x0411 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:418:0x0295 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:420:0x0416 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:438:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:439:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:440:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:441:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:442:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:443:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:444:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:445:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:446:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:447:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:448:? A[SYNTHETIC] */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.String] */
            /* JADX WARN: Type inference failed for: r11v1 */
            /* JADX WARN: Type inference failed for: r11v10 */
            /* JADX WARN: Type inference failed for: r11v11 */
            /* JADX WARN: Type inference failed for: r11v12 */
            /* JADX WARN: Type inference failed for: r11v13 */
            /* JADX WARN: Type inference failed for: r11v14 */
            /* JADX WARN: Type inference failed for: r11v15 */
            /* JADX WARN: Type inference failed for: r11v16 */
            /* JADX WARN: Type inference failed for: r11v17 */
            /* JADX WARN: Type inference failed for: r11v18 */
            /* JADX WARN: Type inference failed for: r11v19 */
            /* JADX WARN: Type inference failed for: r11v2 */
            /* JADX WARN: Type inference failed for: r11v20 */
            /* JADX WARN: Type inference failed for: r11v21 */
            /* JADX WARN: Type inference failed for: r11v22 */
            /* JADX WARN: Type inference failed for: r11v23, types: [java.net.HttpURLConnection] */
            /* JADX WARN: Type inference failed for: r11v24, types: [java.net.HttpURLConnection] */
            /* JADX WARN: Type inference failed for: r11v25, types: [java.net.HttpURLConnection] */
            /* JADX WARN: Type inference failed for: r11v26, types: [java.net.HttpURLConnection] */
            /* JADX WARN: Type inference failed for: r11v27, types: [java.net.HttpURLConnection] */
            /* JADX WARN: Type inference failed for: r11v28, types: [java.net.HttpURLConnection] */
            /* JADX WARN: Type inference failed for: r11v29, types: [java.net.HttpURLConnection] */
            /* JADX WARN: Type inference failed for: r11v3 */
            /* JADX WARN: Type inference failed for: r11v30, types: [java.net.HttpURLConnection] */
            /* JADX WARN: Type inference failed for: r11v31, types: [java.net.HttpURLConnection] */
            /* JADX WARN: Type inference failed for: r11v32, types: [java.net.HttpURLConnection] */
            /* JADX WARN: Type inference failed for: r11v33, types: [java.net.HttpURLConnection] */
            /* JADX WARN: Type inference failed for: r11v35, types: [java.net.HttpURLConnection] */
            /* JADX WARN: Type inference failed for: r11v36 */
            /* JADX WARN: Type inference failed for: r11v37 */
            /* JADX WARN: Type inference failed for: r11v38 */
            /* JADX WARN: Type inference failed for: r11v39 */
            /* JADX WARN: Type inference failed for: r11v4 */
            /* JADX WARN: Type inference failed for: r11v40 */
            /* JADX WARN: Type inference failed for: r11v41 */
            /* JADX WARN: Type inference failed for: r11v42 */
            /* JADX WARN: Type inference failed for: r11v43 */
            /* JADX WARN: Type inference failed for: r11v44 */
            /* JADX WARN: Type inference failed for: r11v45 */
            /* JADX WARN: Type inference failed for: r11v46 */
            /* JADX WARN: Type inference failed for: r11v5 */
            /* JADX WARN: Type inference failed for: r11v6 */
            /* JADX WARN: Type inference failed for: r11v7 */
            /* JADX WARN: Type inference failed for: r11v8 */
            /* JADX WARN: Type inference failed for: r11v9 */
            /* JADX WARN: Type inference failed for: r2v1 */
            /* JADX WARN: Type inference failed for: r2v13 */
            /* JADX WARN: Type inference failed for: r2v14 */
            /* JADX WARN: Type inference failed for: r2v16 */
            /* JADX WARN: Type inference failed for: r2v18 */
            /* JADX WARN: Type inference failed for: r2v20 */
            /* JADX WARN: Type inference failed for: r2v22 */
            /* JADX WARN: Type inference failed for: r2v24 */
            /* JADX WARN: Type inference failed for: r2v26 */
            /* JADX WARN: Type inference failed for: r2v28 */
            /* JADX WARN: Type inference failed for: r2v30 */
            /* JADX WARN: Type inference failed for: r2v31, types: [java.io.InputStream] */
            /* JADX WARN: Type inference failed for: r2v32, types: [java.io.InputStream] */
            /* JADX WARN: Type inference failed for: r2v33, types: [java.io.InputStream] */
            /* JADX WARN: Type inference failed for: r2v34, types: [java.io.InputStream] */
            /* JADX WARN: Type inference failed for: r2v35, types: [java.io.InputStream] */
            /* JADX WARN: Type inference failed for: r2v36, types: [java.io.InputStream] */
            /* JADX WARN: Type inference failed for: r2v37, types: [java.io.InputStream] */
            /* JADX WARN: Type inference failed for: r2v38, types: [java.io.InputStream] */
            /* JADX WARN: Type inference failed for: r2v39, types: [java.io.InputStream] */
            /* JADX WARN: Type inference failed for: r2v40, types: [java.io.InputStream] */
            /* JADX WARN: Type inference failed for: r2v41, types: [java.io.InputStream] */
            /* JADX WARN: Type inference failed for: r2v47 */
            /* JADX WARN: Type inference failed for: r2v65, types: [java.io.InputStream] */
            /* JADX WARN: Type inference failed for: r2v77 */
            /* JADX WARN: Type inference failed for: r2v78 */
            /* JADX WARN: Type inference failed for: r2v79 */
            /* JADX WARN: Type inference failed for: r3v0 */
            /* JADX WARN: Type inference failed for: r3v1 */
            /* JADX WARN: Type inference failed for: r3v10 */
            /* JADX WARN: Type inference failed for: r3v11 */
            /* JADX WARN: Type inference failed for: r3v12 */
            /* JADX WARN: Type inference failed for: r3v13 */
            /* JADX WARN: Type inference failed for: r3v14 */
            /* JADX WARN: Type inference failed for: r3v15 */
            /* JADX WARN: Type inference failed for: r3v16 */
            /* JADX WARN: Type inference failed for: r3v17 */
            /* JADX WARN: Type inference failed for: r3v18 */
            /* JADX WARN: Type inference failed for: r3v19 */
            /* JADX WARN: Type inference failed for: r3v2 */
            /* JADX WARN: Type inference failed for: r3v20, types: [java.io.InputStreamReader] */
            /* JADX WARN: Type inference failed for: r3v21, types: [java.io.InputStreamReader] */
            /* JADX WARN: Type inference failed for: r3v22, types: [java.io.InputStreamReader] */
            /* JADX WARN: Type inference failed for: r3v23, types: [java.io.InputStreamReader] */
            /* JADX WARN: Type inference failed for: r3v24, types: [java.io.InputStreamReader] */
            /* JADX WARN: Type inference failed for: r3v25, types: [java.io.InputStreamReader] */
            /* JADX WARN: Type inference failed for: r3v26, types: [java.io.InputStreamReader] */
            /* JADX WARN: Type inference failed for: r3v27, types: [java.io.InputStreamReader] */
            /* JADX WARN: Type inference failed for: r3v28, types: [java.io.InputStreamReader] */
            /* JADX WARN: Type inference failed for: r3v29, types: [java.io.InputStreamReader] */
            /* JADX WARN: Type inference failed for: r3v3 */
            /* JADX WARN: Type inference failed for: r3v30, types: [java.io.InputStreamReader] */
            /* JADX WARN: Type inference failed for: r3v31 */
            /* JADX WARN: Type inference failed for: r3v32 */
            /* JADX WARN: Type inference failed for: r3v33 */
            /* JADX WARN: Type inference failed for: r3v34 */
            /* JADX WARN: Type inference failed for: r3v35 */
            /* JADX WARN: Type inference failed for: r3v36 */
            /* JADX WARN: Type inference failed for: r3v37 */
            /* JADX WARN: Type inference failed for: r3v38 */
            /* JADX WARN: Type inference failed for: r3v39 */
            /* JADX WARN: Type inference failed for: r3v4 */
            /* JADX WARN: Type inference failed for: r3v43 */
            /* JADX WARN: Type inference failed for: r3v45 */
            /* JADX WARN: Type inference failed for: r3v46 */
            /* JADX WARN: Type inference failed for: r3v48 */
            /* JADX WARN: Type inference failed for: r3v5 */
            /* JADX WARN: Type inference failed for: r3v50 */
            /* JADX WARN: Type inference failed for: r3v52 */
            /* JADX WARN: Type inference failed for: r3v54 */
            /* JADX WARN: Type inference failed for: r3v56 */
            /* JADX WARN: Type inference failed for: r3v58 */
            /* JADX WARN: Type inference failed for: r3v6 */
            /* JADX WARN: Type inference failed for: r3v60 */
            /* JADX WARN: Type inference failed for: r3v62 */
            /* JADX WARN: Type inference failed for: r3v63, types: [java.io.InputStreamReader, java.io.Reader] */
            /* JADX WARN: Type inference failed for: r3v7 */
            /* JADX WARN: Type inference failed for: r3v8 */
            /* JADX WARN: Type inference failed for: r3v83 */
            /* JADX WARN: Type inference failed for: r3v9 */
            private void b(String str2) throws Throwable {
                Object obj;
                ?? A;
                ?? inputStreamReader;
                ?? r3;
                Exception e2;
                SSLException e3;
                UnknownHostException e4;
                SocketTimeoutException e5;
                SocketException e6;
                ConnectException e7;
                Error e8;
                StackOverflowError e9;
                OutOfMemoryError e10;
                ?? r2;
                String message;
                String message2;
                String message3;
                String message4;
                BufferedReader bufferedReader = null;
                try {
                    try {
                        a.this.j = str2;
                        str2 = (HttpURLConnection) new URL(str2).openConnection();
                        try {
                            str2.setInstanceFollowRedirects(false);
                            Map<String, String> mapA = a.a();
                            if (mapA.size() > 0) {
                                for (String str3 : mapA.keySet()) {
                                    str2.addRequestProperty(str3, mapA.get(str3));
                                }
                            }
                            if (a.this.i) {
                                a.this.a(this.a);
                                if (str2 != 0) {
                                    str2.disconnect();
                                    return;
                                }
                                return;
                            }
                            if (t.b().c("ua")) {
                                str2.addRequestProperty("User-Agent", p.a());
                            }
                            str2.setConnectTimeout(60000);
                            str2.setReadTimeout(60000);
                            str2.connect();
                            int responseCode = str2.getResponseCode();
                            if (responseCode != 200) {
                                if (responseCode != 302 && responseCode != 301 && responseCode != 307) {
                                    a.this.a(this.a, "Http respond status code is ".concat(String.valueOf(responseCode)), ErrorCode.getErrorCode(ErrorCode.httpStatuException, String.valueOf(responseCode), str2.getResponseMessage()));
                                    if (str2 != 0) {
                                        str2.disconnect();
                                        return;
                                    }
                                    return;
                                }
                                if (a.this.i) {
                                    a.this.a(this.a);
                                } else {
                                    if (a.this.l >= 5) {
                                        a.this.a(this.a, "Http respond status code is ".concat(String.valueOf(responseCode)), ErrorCode.getErrorCode(ErrorCode.httpStatuException, String.valueOf(responseCode), "over 5 MAX_REDIRECTS_COUNT," + str2.getResponseMessage()));
                                        if (str2 != 0) {
                                            str2.disconnect();
                                            return;
                                        }
                                        return;
                                    }
                                    a.this.l++;
                                    String headerField = str2.getHeaderField("Location");
                                    if (headerField != null && headerField.toLowerCase().startsWith("http")) {
                                        b(headerField);
                                    }
                                }
                                if (str2 != 0) {
                                    str2.disconnect();
                                    return;
                                }
                                return;
                            }
                            if (a.this.i) {
                                a.this.a(this.a);
                                if (str2 != 0) {
                                    str2.disconnect();
                                    return;
                                }
                                return;
                            }
                            A = a.a((HttpURLConnection) str2);
                            try {
                                inputStreamReader = new InputStreamReader(A);
                                try {
                                    BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                                    try {
                                        StringBuilder sb = new StringBuilder();
                                        while (true) {
                                            String line = bufferedReader2.readLine();
                                            if (line == null) {
                                                break;
                                            } else {
                                                sb.append(line);
                                            }
                                        }
                                        a.this.a(this.a, sb.toString().trim());
                                        try {
                                            bufferedReader2.close();
                                        } catch (Throwable unused) {
                                        }
                                        try {
                                            inputStreamReader.close();
                                        } catch (Throwable unused2) {
                                        }
                                        if (A != 0) {
                                            try {
                                                A.close();
                                            } catch (Throwable unused3) {
                                            }
                                        }
                                        if (str2 != 0) {
                                            str2.disconnect();
                                        }
                                    } catch (OutOfMemoryError e11) {
                                        e10 = e11;
                                        bufferedReader = bufferedReader2;
                                        System.gc();
                                        message4 = e10.getMessage();
                                        if (e10.getMessage() != null) {
                                            message4 = e10.getMessage();
                                        }
                                        a.this.a(this.a, message4, ErrorCode.getErrorCode(ErrorCode.exception, ErrorCode.exception, e10.getMessage()));
                                        if (bufferedReader != null) {
                                            try {
                                                bufferedReader.close();
                                            } catch (Throwable unused4) {
                                            }
                                        }
                                        if (inputStreamReader != 0) {
                                            try {
                                                inputStreamReader.close();
                                            } catch (Throwable unused5) {
                                            }
                                        }
                                        if (A != 0) {
                                            try {
                                                A.close();
                                            } catch (Throwable unused6) {
                                            }
                                        }
                                        if (str2 != 0) {
                                            str2.disconnect();
                                        }
                                    } catch (StackOverflowError e12) {
                                        e9 = e12;
                                        bufferedReader = bufferedReader2;
                                        System.gc();
                                        message3 = e9.getMessage();
                                        if (e9.getMessage() != null) {
                                            message3 = e9.getMessage();
                                        }
                                        a.this.a(this.a, message3, ErrorCode.getErrorCode(ErrorCode.exception, ErrorCode.exception, e9.getMessage()));
                                        if (bufferedReader != null) {
                                            try {
                                                bufferedReader.close();
                                            } catch (Throwable unused7) {
                                            }
                                        }
                                        if (inputStreamReader != 0) {
                                            try {
                                                inputStreamReader.close();
                                            } catch (Throwable unused8) {
                                            }
                                        }
                                        if (A != 0) {
                                            try {
                                                A.close();
                                            } catch (Throwable unused9) {
                                            }
                                        }
                                        if (str2 != 0) {
                                            str2.disconnect();
                                        }
                                    } catch (Error e13) {
                                        e8 = e13;
                                        bufferedReader = bufferedReader2;
                                        e8.getMessage();
                                        System.gc();
                                        message2 = e8.getMessage();
                                        if (e8.getMessage() != null) {
                                            message2 = e8.getMessage();
                                        }
                                        a.this.a(this.a, message2, ErrorCode.getErrorCode(ErrorCode.exception, ErrorCode.exception, e8.getMessage()));
                                        if (bufferedReader != null) {
                                            try {
                                                bufferedReader.close();
                                            } catch (Throwable unused10) {
                                            }
                                        }
                                        if (inputStreamReader != 0) {
                                            try {
                                                inputStreamReader.close();
                                            } catch (Throwable unused11) {
                                            }
                                        }
                                        if (A != 0) {
                                            try {
                                                A.close();
                                            } catch (Throwable unused12) {
                                            }
                                        }
                                        if (str2 != 0) {
                                            str2.disconnect();
                                        }
                                    } catch (ConnectException e14) {
                                        e7 = e14;
                                        bufferedReader = bufferedReader2;
                                        a.this.a(this.a, "Connect error.", ErrorCode.getErrorCode(ErrorCode.exception, ErrorCode.exception, e7.getMessage()));
                                        if (bufferedReader != null) {
                                            try {
                                                bufferedReader.close();
                                            } catch (Throwable unused13) {
                                            }
                                        }
                                        if (inputStreamReader != 0) {
                                            try {
                                                inputStreamReader.close();
                                            } catch (Throwable unused14) {
                                            }
                                        }
                                        if (A != 0) {
                                            try {
                                                A.close();
                                            } catch (Throwable unused15) {
                                            }
                                        }
                                        if (str2 != 0) {
                                            str2.disconnect();
                                        }
                                    } catch (SocketException e15) {
                                        e6 = e15;
                                        bufferedReader = bufferedReader2;
                                        a.this.a(this.a, "connect socket failed.", ErrorCode.getErrorCode(ErrorCode.exception, ErrorCode.exception, e6.getMessage()));
                                        if (bufferedReader != null) {
                                            try {
                                                bufferedReader.close();
                                            } catch (Throwable unused16) {
                                            }
                                        }
                                        if (inputStreamReader != 0) {
                                            try {
                                                inputStreamReader.close();
                                            } catch (Throwable unused17) {
                                            }
                                        }
                                        if (A != 0) {
                                            try {
                                                A.close();
                                            } catch (Throwable unused18) {
                                            }
                                        }
                                        if (str2 != 0) {
                                            str2.disconnect();
                                        }
                                    } catch (SocketTimeoutException e16) {
                                        e5 = e16;
                                        bufferedReader = bufferedReader2;
                                        a.this.a(this.a, "Connect timeout.", ErrorCode.getErrorCode(ErrorCode.exception, ErrorCode.exception, e5.getMessage()));
                                        if (bufferedReader != null) {
                                            try {
                                                bufferedReader.close();
                                            } catch (Throwable unused19) {
                                            }
                                        }
                                        if (inputStreamReader != 0) {
                                            try {
                                                inputStreamReader.close();
                                            } catch (Throwable unused20) {
                                            }
                                        }
                                        if (A != 0) {
                                            try {
                                                A.close();
                                            } catch (Throwable unused21) {
                                            }
                                        }
                                        if (str2 != 0) {
                                            str2.disconnect();
                                        }
                                    } catch (UnknownHostException e17) {
                                        e4 = e17;
                                        bufferedReader = bufferedReader2;
                                        a.this.a(this.a, "UnknownHostException", ErrorCode.getErrorCode(ErrorCode.exception, ErrorCode.exception, e4.getMessage()));
                                        if (bufferedReader != null) {
                                            try {
                                                bufferedReader.close();
                                            } catch (Throwable unused22) {
                                            }
                                        }
                                        if (inputStreamReader != 0) {
                                            try {
                                                inputStreamReader.close();
                                            } catch (Throwable unused23) {
                                            }
                                        }
                                        if (A != 0) {
                                            try {
                                                A.close();
                                            } catch (Throwable unused24) {
                                            }
                                        }
                                        if (str2 != 0) {
                                            str2.disconnect();
                                        }
                                    } catch (SSLException e18) {
                                        e3 = e18;
                                        bufferedReader = bufferedReader2;
                                        a.this.a(this.a, "connect ssl failed.", ErrorCode.getErrorCode(ErrorCode.exception, ErrorCode.exception, e3.getMessage()));
                                        if (bufferedReader != null) {
                                            try {
                                                bufferedReader.close();
                                            } catch (Throwable unused25) {
                                            }
                                        }
                                        if (inputStreamReader != 0) {
                                            try {
                                                inputStreamReader.close();
                                            } catch (Throwable unused26) {
                                            }
                                        }
                                        if (A != 0) {
                                            try {
                                                A.close();
                                            } catch (Throwable unused27) {
                                            }
                                        }
                                        if (str2 != 0) {
                                            str2.disconnect();
                                        }
                                    } catch (ConnectTimeoutException e19) {
                                        e = e19;
                                        bufferedReader = bufferedReader2;
                                        a.this.a(this.a, e);
                                        if (bufferedReader != null) {
                                            try {
                                                bufferedReader.close();
                                            } catch (Throwable unused28) {
                                            }
                                        }
                                        if (inputStreamReader != 0) {
                                            try {
                                                inputStreamReader.close();
                                            } catch (Throwable unused29) {
                                            }
                                        }
                                        if (A != 0) {
                                            try {
                                                A.close();
                                            } catch (Throwable unused30) {
                                            }
                                        }
                                        if (str2 != 0) {
                                            str2.disconnect();
                                        }
                                    } catch (Exception e20) {
                                        e2 = e20;
                                        bufferedReader = bufferedReader2;
                                        e2.getMessage();
                                        message = e2.getMessage();
                                        if (e2.getMessage() != null) {
                                            message = e2.getMessage();
                                        }
                                        a.this.a(this.a, message, ErrorCode.getErrorCode(ErrorCode.exception, ErrorCode.exception, e2.getMessage()));
                                        if (bufferedReader != null) {
                                            try {
                                                bufferedReader.close();
                                            } catch (Throwable unused31) {
                                            }
                                        }
                                        if (inputStreamReader != 0) {
                                            try {
                                                inputStreamReader.close();
                                            } catch (Throwable unused32) {
                                            }
                                        }
                                        if (A != 0) {
                                            try {
                                                A.close();
                                            } catch (Throwable unused33) {
                                            }
                                        }
                                        if (str2 != 0) {
                                            str2.disconnect();
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        bufferedReader = bufferedReader2;
                                        r2 = A;
                                        r3 = inputStreamReader;
                                        if (bufferedReader != null) {
                                            try {
                                                bufferedReader.close();
                                            } catch (Throwable unused34) {
                                            }
                                        }
                                        if (r3 != 0) {
                                            try {
                                                r3.close();
                                            } catch (Throwable unused35) {
                                            }
                                        }
                                        if (r2 != 0) {
                                            try {
                                                r2.close();
                                            } catch (Throwable unused36) {
                                            }
                                        }
                                        if (str2 != 0) {
                                            throw th;
                                        }
                                        str2.disconnect();
                                        throw th;
                                    }
                                } catch (OutOfMemoryError e21) {
                                    e10 = e21;
                                } catch (StackOverflowError e22) {
                                    e9 = e22;
                                } catch (Error e23) {
                                    e8 = e23;
                                } catch (ConnectException e24) {
                                    e7 = e24;
                                } catch (SocketException e25) {
                                    e6 = e25;
                                } catch (SocketTimeoutException e26) {
                                    e5 = e26;
                                } catch (UnknownHostException e27) {
                                    e4 = e27;
                                } catch (SSLException e28) {
                                    e3 = e28;
                                } catch (ConnectTimeoutException e29) {
                                    e = e29;
                                } catch (Exception e30) {
                                    e2 = e30;
                                }
                            } catch (OutOfMemoryError e31) {
                                e10 = e31;
                                inputStreamReader = 0;
                            } catch (StackOverflowError e32) {
                                e9 = e32;
                                inputStreamReader = 0;
                            } catch (Error e33) {
                                e8 = e33;
                                inputStreamReader = 0;
                            } catch (ConnectException e34) {
                                e7 = e34;
                                inputStreamReader = 0;
                            } catch (SocketException e35) {
                                e6 = e35;
                                inputStreamReader = 0;
                            } catch (SocketTimeoutException e36) {
                                e5 = e36;
                                inputStreamReader = 0;
                            } catch (UnknownHostException e37) {
                                e4 = e37;
                                inputStreamReader = 0;
                            } catch (SSLException e38) {
                                e3 = e38;
                                inputStreamReader = 0;
                            } catch (ConnectTimeoutException e39) {
                                e = e39;
                                inputStreamReader = 0;
                            } catch (Exception e40) {
                                e2 = e40;
                                inputStreamReader = 0;
                            } catch (Throwable th2) {
                                th = th2;
                                r3 = 0;
                                r2 = A;
                            }
                        } catch (OutOfMemoryError e41) {
                            e = e41;
                            inputStreamReader = 0;
                            str2 = str2;
                            e10 = e;
                            A = inputStreamReader;
                            System.gc();
                            message4 = e10.getMessage();
                            if (e10.getMessage() != null) {
                                message4 = e10.getMessage();
                            }
                            a.this.a(this.a, message4, ErrorCode.getErrorCode(ErrorCode.exception, ErrorCode.exception, e10.getMessage()));
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (inputStreamReader != 0) {
                                inputStreamReader.close();
                            }
                            if (A != 0) {
                                A.close();
                            }
                            if (str2 != 0) {
                                str2.disconnect();
                            }
                        } catch (StackOverflowError e42) {
                            e = e42;
                            inputStreamReader = 0;
                            str2 = str2;
                            e9 = e;
                            A = inputStreamReader;
                            System.gc();
                            message3 = e9.getMessage();
                            if (e9.getMessage() != null) {
                                message3 = e9.getMessage();
                            }
                            a.this.a(this.a, message3, ErrorCode.getErrorCode(ErrorCode.exception, ErrorCode.exception, e9.getMessage()));
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (inputStreamReader != 0) {
                                inputStreamReader.close();
                            }
                            if (A != 0) {
                                A.close();
                            }
                            if (str2 != 0) {
                                str2.disconnect();
                            }
                        } catch (Error e43) {
                            e = e43;
                            inputStreamReader = 0;
                            str2 = str2;
                            e8 = e;
                            A = inputStreamReader;
                            e8.getMessage();
                            System.gc();
                            message2 = e8.getMessage();
                            if (e8.getMessage() != null) {
                                message2 = e8.getMessage();
                            }
                            a.this.a(this.a, message2, ErrorCode.getErrorCode(ErrorCode.exception, ErrorCode.exception, e8.getMessage()));
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (inputStreamReader != 0) {
                                inputStreamReader.close();
                            }
                            if (A != 0) {
                                A.close();
                            }
                            if (str2 != 0) {
                                str2.disconnect();
                            }
                        } catch (ConnectException e44) {
                            e = e44;
                            inputStreamReader = 0;
                            str2 = str2;
                            e7 = e;
                            A = inputStreamReader;
                            a.this.a(this.a, "Connect error.", ErrorCode.getErrorCode(ErrorCode.exception, ErrorCode.exception, e7.getMessage()));
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (inputStreamReader != 0) {
                                inputStreamReader.close();
                            }
                            if (A != 0) {
                                A.close();
                            }
                            if (str2 != 0) {
                                str2.disconnect();
                            }
                        } catch (SocketException e45) {
                            e = e45;
                            inputStreamReader = 0;
                            str2 = str2;
                            e6 = e;
                            A = inputStreamReader;
                            a.this.a(this.a, "connect socket failed.", ErrorCode.getErrorCode(ErrorCode.exception, ErrorCode.exception, e6.getMessage()));
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (inputStreamReader != 0) {
                                inputStreamReader.close();
                            }
                            if (A != 0) {
                                A.close();
                            }
                            if (str2 != 0) {
                                str2.disconnect();
                            }
                        } catch (SocketTimeoutException e46) {
                            e = e46;
                            inputStreamReader = 0;
                            str2 = str2;
                            e5 = e;
                            A = inputStreamReader;
                            a.this.a(this.a, "Connect timeout.", ErrorCode.getErrorCode(ErrorCode.exception, ErrorCode.exception, e5.getMessage()));
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (inputStreamReader != 0) {
                                inputStreamReader.close();
                            }
                            if (A != 0) {
                                A.close();
                            }
                            if (str2 != 0) {
                                str2.disconnect();
                            }
                        } catch (UnknownHostException e47) {
                            e = e47;
                            inputStreamReader = 0;
                            str2 = str2;
                            e4 = e;
                            A = inputStreamReader;
                            a.this.a(this.a, "UnknownHostException", ErrorCode.getErrorCode(ErrorCode.exception, ErrorCode.exception, e4.getMessage()));
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (inputStreamReader != 0) {
                                inputStreamReader.close();
                            }
                            if (A != 0) {
                                A.close();
                            }
                            if (str2 != 0) {
                                str2.disconnect();
                            }
                        } catch (SSLException e48) {
                            e = e48;
                            inputStreamReader = 0;
                            str2 = str2;
                            e3 = e;
                            A = inputStreamReader;
                            a.this.a(this.a, "connect ssl failed.", ErrorCode.getErrorCode(ErrorCode.exception, ErrorCode.exception, e3.getMessage()));
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (inputStreamReader != 0) {
                                inputStreamReader.close();
                            }
                            if (A != 0) {
                                A.close();
                            }
                            if (str2 != 0) {
                                str2.disconnect();
                            }
                        } catch (ConnectTimeoutException e49) {
                            e = e49;
                            A = 0;
                            str2 = str2;
                            inputStreamReader = A;
                            a.this.a(this.a, e);
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (inputStreamReader != 0) {
                                inputStreamReader.close();
                            }
                            if (A != 0) {
                                A.close();
                            }
                            if (str2 != 0) {
                                str2.disconnect();
                            }
                        } catch (Exception e50) {
                            e = e50;
                            inputStreamReader = 0;
                            str2 = str2;
                            e2 = e;
                            A = inputStreamReader;
                            e2.getMessage();
                            message = e2.getMessage();
                            if (e2.getMessage() != null) {
                                message = e2.getMessage();
                            }
                            a.this.a(this.a, message, ErrorCode.getErrorCode(ErrorCode.exception, ErrorCode.exception, e2.getMessage()));
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (inputStreamReader != 0) {
                                inputStreamReader.close();
                            }
                            if (A != 0) {
                                A.close();
                            }
                            if (str2 != 0) {
                                str2.disconnect();
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            obj = null;
                            str2 = str2;
                            r3 = obj;
                            r2 = obj;
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (r3 != 0) {
                                r3.close();
                            }
                            if (r2 != 0) {
                                r2.close();
                            }
                            if (str2 != 0) {
                                throw th;
                            }
                            str2.disconnect();
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } catch (Exception e51) {
                    e = e51;
                    str2 = 0;
                    inputStreamReader = 0;
                } catch (OutOfMemoryError e52) {
                    e = e52;
                    str2 = 0;
                    inputStreamReader = 0;
                } catch (StackOverflowError e53) {
                    e = e53;
                    str2 = 0;
                    inputStreamReader = 0;
                } catch (Error e54) {
                    e = e54;
                    str2 = 0;
                    inputStreamReader = 0;
                } catch (ConnectException e55) {
                    e = e55;
                    str2 = 0;
                    inputStreamReader = 0;
                } catch (SocketException e56) {
                    e = e56;
                    str2 = 0;
                    inputStreamReader = 0;
                } catch (SocketTimeoutException e57) {
                    e = e57;
                    str2 = 0;
                    inputStreamReader = 0;
                } catch (UnknownHostException e58) {
                    e = e58;
                    str2 = 0;
                    inputStreamReader = 0;
                } catch (SSLException e59) {
                    e = e59;
                    str2 = 0;
                    inputStreamReader = 0;
                } catch (ConnectTimeoutException e60) {
                    e = e60;
                    str2 = 0;
                    A = 0;
                } catch (Throwable th5) {
                    th = th5;
                    str2 = 0;
                    obj = null;
                }
            }
        }, 10);
    }

    protected static Map<String, String> a() {
        HashMap map = new HashMap();
        map.put("Content-Encoding", Constants.CP_GZIP);
        map.put("User-Agent", m.i());
        map.put(c, Locale.getDefault().toString());
        map.put(d, e);
        map.put("Content-Type", "application/json");
        return map;
    }

    public static InputStream a(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        if (httpURLConnection == null) {
            return null;
        }
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (Exception unused) {
        }
        if (!Constants.CP_GZIP.equalsIgnoreCase(httpURLConnection.getHeaderField("Content-Encoding"))) {
            return inputStream;
        }
        try {
            byte[] bArr = new byte[2];
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedInputStream.mark(2);
            int i = bufferedInputStream.read(bArr);
            bufferedInputStream.reset();
            return (i == -1 || (((bArr[1] & UByte.MAX_VALUE) << 8) | (bArr[0] & UByte.MAX_VALUE)) != 35615) ? bufferedInputStream : new GZIPInputStream(bufferedInputStream);
        } catch (Exception unused2) {
            return inputStream;
        }
    }

    protected final void a(int i, Object obj) {
        q qVar = this.k;
        if (qVar != null) {
            qVar.onLoadFinish(i, obj);
        }
    }

    protected final void a(int i) {
        q qVar = this.k;
        if (qVar != null) {
            qVar.onLoadCanceled(i);
        }
    }

    protected final void a(int i, String str, AdError adError) {
        q qVar = this.k;
        if (qVar != null) {
            qVar.onLoadError(i, str, adError);
        }
    }

    protected final void a(int i, ConnectTimeoutException connectTimeoutException) {
        AdError errorCode = ErrorCode.getErrorCode(ErrorCode.exception, ErrorCode.exception, connectTimeoutException.getMessage());
        q qVar = this.k;
        if (qVar != null) {
            qVar.onLoadError(i, "Connect timeout.", errorCode);
        }
    }

    protected final void b() {
        this.i = true;
    }
}
