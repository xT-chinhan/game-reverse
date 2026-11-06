package com.anythink.china.c;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.api.ATSDK;
import com.anythink.core.common.d.s;
import com.anythink.core.common.d.t;
import com.anythink.core.common.u.ad;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g {
    private static volatile g a;
    private Context e;
    private final List<Integer> b = new ArrayList(Collections.singletonList(46));
    private final Map<Integer, File> d = new HashMap();
    private final List<com.anythink.core.common.j.d> f = new ArrayList();
    private long g = f.a;
    private final AtomicBoolean c = new AtomicBoolean(true);

    public static g a() {
        if (a == null) {
            synchronized (g.class) {
                if (a == null) {
                    a = new g();
                }
            }
        }
        return a;
    }

    public final Map<Integer, File> b() {
        return this.d;
    }

    private g() {
    }

    private boolean c() {
        return this.c.get();
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0393  */
    /* JADX WARN: Code duplicated, block: B:101:0x0395 A[Catch: all -> 0x03ab, TryCatch #3 {all -> 0x03ab, blocks: (B:66:0x0264, B:70:0x0274, B:74:0x0284, B:76:0x028a, B:78:0x0290, B:79:0x02ad, B:80:0x02df, B:82:0x02e5, B:84:0x02eb, B:86:0x030a, B:87:0x033c, B:89:0x0342, B:90:0x035e, B:94:0x0371, B:98:0x0387, B:102:0x039d, B:101:0x0395, B:97:0x037f, B:93:0x0369, B:69:0x0270), top: B:130:0x0264, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:109:0x03b4 A[Catch: all -> 0x0415, TRY_ENTER, TryCatch #1 {all -> 0x0415, blocks: (B:109:0x03b4, B:112:0x0417, B:113:0x041e), top: B:128:0x03b2, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:112:0x0417 A[Catch: all -> 0x0415, TryCatch #1 {all -> 0x0415, blocks: (B:109:0x03b4, B:112:0x0417, B:113:0x041e), top: B:128:0x03b2, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:119:0x0455 A[Catch: all -> 0x0486, TRY_LEAVE, TryCatch #2 {all -> 0x0486, blocks: (B:3:0x0010, B:5:0x0014, B:6:0x001b, B:8:0x0035, B:9:0x003b, B:10:0x006f, B:13:0x0079, B:15:0x008f, B:18:0x009d, B:20:0x00c3, B:22:0x00cd, B:24:0x00df, B:26:0x00ee, B:31:0x0100, B:32:0x012e, B:36:0x014e, B:35:0x014a, B:37:0x015b, B:39:0x0169, B:40:0x018d, B:41:0x01a8, B:42:0x01c5, B:44:0x01d9, B:46:0x01e6, B:47:0x01f0, B:49:0x01f6, B:56:0x0221, B:58:0x0237, B:59:0x023b, B:63:0x0252, B:62:0x024e, B:55:0x0214, B:64:0x025e, B:114:0x041f, B:118:0x0449, B:117:0x0441, B:119:0x0455, B:106:0x03ac, B:50:0x0209, B:52:0x020f, B:109:0x03b4, B:112:0x0417, B:113:0x041e, B:66:0x0264, B:70:0x0274, B:74:0x0284, B:76:0x028a, B:78:0x0290, B:79:0x02ad, B:80:0x02df, B:82:0x02e5, B:84:0x02eb, B:86:0x030a, B:87:0x033c, B:89:0x0342, B:90:0x035e, B:94:0x0371, B:98:0x0387, B:102:0x039d, B:101:0x0395, B:97:0x037f, B:93:0x0369, B:69:0x0270), top: B:129:0x0010, inners: #0, #1, #3 }] */
    /* JADX WARN: Code duplicated, block: B:130:0x0264 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x0100 A[Catch: all -> 0x0486, TryCatch #2 {all -> 0x0486, blocks: (B:3:0x0010, B:5:0x0014, B:6:0x001b, B:8:0x0035, B:9:0x003b, B:10:0x006f, B:13:0x0079, B:15:0x008f, B:18:0x009d, B:20:0x00c3, B:22:0x00cd, B:24:0x00df, B:26:0x00ee, B:31:0x0100, B:32:0x012e, B:36:0x014e, B:35:0x014a, B:37:0x015b, B:39:0x0169, B:40:0x018d, B:41:0x01a8, B:42:0x01c5, B:44:0x01d9, B:46:0x01e6, B:47:0x01f0, B:49:0x01f6, B:56:0x0221, B:58:0x0237, B:59:0x023b, B:63:0x0252, B:62:0x024e, B:55:0x0214, B:64:0x025e, B:114:0x041f, B:118:0x0449, B:117:0x0441, B:119:0x0455, B:106:0x03ac, B:50:0x0209, B:52:0x020f, B:109:0x03b4, B:112:0x0417, B:113:0x041e, B:66:0x0264, B:70:0x0274, B:74:0x0284, B:76:0x028a, B:78:0x0290, B:79:0x02ad, B:80:0x02df, B:82:0x02e5, B:84:0x02eb, B:86:0x030a, B:87:0x033c, B:89:0x0342, B:90:0x035e, B:94:0x0371, B:98:0x0387, B:102:0x039d, B:101:0x0395, B:97:0x037f, B:93:0x0369, B:69:0x0270), top: B:129:0x0010, inners: #0, #1, #3 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x012e A[Catch: all -> 0x0486, TryCatch #2 {all -> 0x0486, blocks: (B:3:0x0010, B:5:0x0014, B:6:0x001b, B:8:0x0035, B:9:0x003b, B:10:0x006f, B:13:0x0079, B:15:0x008f, B:18:0x009d, B:20:0x00c3, B:22:0x00cd, B:24:0x00df, B:26:0x00ee, B:31:0x0100, B:32:0x012e, B:36:0x014e, B:35:0x014a, B:37:0x015b, B:39:0x0169, B:40:0x018d, B:41:0x01a8, B:42:0x01c5, B:44:0x01d9, B:46:0x01e6, B:47:0x01f0, B:49:0x01f6, B:56:0x0221, B:58:0x0237, B:59:0x023b, B:63:0x0252, B:62:0x024e, B:55:0x0214, B:64:0x025e, B:114:0x041f, B:118:0x0449, B:117:0x0441, B:119:0x0455, B:106:0x03ac, B:50:0x0209, B:52:0x020f, B:109:0x03b4, B:112:0x0417, B:113:0x041e, B:66:0x0264, B:70:0x0274, B:74:0x0284, B:76:0x028a, B:78:0x0290, B:79:0x02ad, B:80:0x02df, B:82:0x02e5, B:84:0x02eb, B:86:0x030a, B:87:0x033c, B:89:0x0342, B:90:0x035e, B:94:0x0371, B:98:0x0387, B:102:0x039d, B:101:0x0395, B:97:0x037f, B:93:0x0369, B:69:0x0270), top: B:129:0x0010, inners: #0, #1, #3 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0149  */
    /* JADX WARN: Code duplicated, block: B:35:0x014a A[Catch: all -> 0x0486, TryCatch #2 {all -> 0x0486, blocks: (B:3:0x0010, B:5:0x0014, B:6:0x001b, B:8:0x0035, B:9:0x003b, B:10:0x006f, B:13:0x0079, B:15:0x008f, B:18:0x009d, B:20:0x00c3, B:22:0x00cd, B:24:0x00df, B:26:0x00ee, B:31:0x0100, B:32:0x012e, B:36:0x014e, B:35:0x014a, B:37:0x015b, B:39:0x0169, B:40:0x018d, B:41:0x01a8, B:42:0x01c5, B:44:0x01d9, B:46:0x01e6, B:47:0x01f0, B:49:0x01f6, B:56:0x0221, B:58:0x0237, B:59:0x023b, B:63:0x0252, B:62:0x024e, B:55:0x0214, B:64:0x025e, B:114:0x041f, B:118:0x0449, B:117:0x0441, B:119:0x0455, B:106:0x03ac, B:50:0x0209, B:52:0x020f, B:109:0x03b4, B:112:0x0417, B:113:0x041e, B:66:0x0264, B:70:0x0274, B:74:0x0284, B:76:0x028a, B:78:0x0290, B:79:0x02ad, B:80:0x02df, B:82:0x02e5, B:84:0x02eb, B:86:0x030a, B:87:0x033c, B:89:0x0342, B:90:0x035e, B:94:0x0371, B:98:0x0387, B:102:0x039d, B:101:0x0395, B:97:0x037f, B:93:0x0369, B:69:0x0270), top: B:129:0x0010, inners: #0, #1, #3 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x026e  */
    /* JADX WARN: Code duplicated, block: B:69:0x0270 A[Catch: all -> 0x03ab, TryCatch #3 {all -> 0x03ab, blocks: (B:66:0x0264, B:70:0x0274, B:74:0x0284, B:76:0x028a, B:78:0x0290, B:79:0x02ad, B:80:0x02df, B:82:0x02e5, B:84:0x02eb, B:86:0x030a, B:87:0x033c, B:89:0x0342, B:90:0x035e, B:94:0x0371, B:98:0x0387, B:102:0x039d, B:101:0x0395, B:97:0x037f, B:93:0x0369, B:69:0x0270), top: B:130:0x0264, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x02df A[Catch: all -> 0x03ab, TryCatch #3 {all -> 0x03ab, blocks: (B:66:0x0264, B:70:0x0274, B:74:0x0284, B:76:0x028a, B:78:0x0290, B:79:0x02ad, B:80:0x02df, B:82:0x02e5, B:84:0x02eb, B:86:0x030a, B:87:0x033c, B:89:0x0342, B:90:0x035e, B:94:0x0371, B:98:0x0387, B:102:0x039d, B:101:0x0395, B:97:0x037f, B:93:0x0369, B:69:0x0270), top: B:130:0x0264, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x02e5 A[Catch: all -> 0x03ab, TryCatch #3 {all -> 0x03ab, blocks: (B:66:0x0264, B:70:0x0274, B:74:0x0284, B:76:0x028a, B:78:0x0290, B:79:0x02ad, B:80:0x02df, B:82:0x02e5, B:84:0x02eb, B:86:0x030a, B:87:0x033c, B:89:0x0342, B:90:0x035e, B:94:0x0371, B:98:0x0387, B:102:0x039d, B:101:0x0395, B:97:0x037f, B:93:0x0369, B:69:0x0270), top: B:130:0x0264, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x0308 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:86:0x030a A[Catch: all -> 0x03ab, TryCatch #3 {all -> 0x03ab, blocks: (B:66:0x0264, B:70:0x0274, B:74:0x0284, B:76:0x028a, B:78:0x0290, B:79:0x02ad, B:80:0x02df, B:82:0x02e5, B:84:0x02eb, B:86:0x030a, B:87:0x033c, B:89:0x0342, B:90:0x035e, B:94:0x0371, B:98:0x0387, B:102:0x039d, B:101:0x0395, B:97:0x037f, B:93:0x0369, B:69:0x0270), top: B:130:0x0264, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x0342 A[Catch: all -> 0x03ab, TryCatch #3 {all -> 0x03ab, blocks: (B:66:0x0264, B:70:0x0274, B:74:0x0284, B:76:0x028a, B:78:0x0290, B:79:0x02ad, B:80:0x02df, B:82:0x02e5, B:84:0x02eb, B:86:0x030a, B:87:0x033c, B:89:0x0342, B:90:0x035e, B:94:0x0371, B:98:0x0387, B:102:0x039d, B:101:0x0395, B:97:0x037f, B:93:0x0369, B:69:0x0270), top: B:130:0x0264, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x035e A[Catch: all -> 0x03ab, TryCatch #3 {all -> 0x03ab, blocks: (B:66:0x0264, B:70:0x0274, B:74:0x0284, B:76:0x028a, B:78:0x0290, B:79:0x02ad, B:80:0x02df, B:82:0x02e5, B:84:0x02eb, B:86:0x030a, B:87:0x033c, B:89:0x0342, B:90:0x035e, B:94:0x0371, B:98:0x0387, B:102:0x039d, B:101:0x0395, B:97:0x037f, B:93:0x0369, B:69:0x0270), top: B:130:0x0264, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x0367  */
    /* JADX WARN: Code duplicated, block: B:93:0x0369 A[Catch: all -> 0x03ab, TryCatch #3 {all -> 0x03ab, blocks: (B:66:0x0264, B:70:0x0274, B:74:0x0284, B:76:0x028a, B:78:0x0290, B:79:0x02ad, B:80:0x02df, B:82:0x02e5, B:84:0x02eb, B:86:0x030a, B:87:0x033c, B:89:0x0342, B:90:0x035e, B:94:0x0371, B:98:0x0387, B:102:0x039d, B:101:0x0395, B:97:0x037f, B:93:0x0369, B:69:0x0270), top: B:130:0x0264, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:96:0x037d  */
    /* JADX WARN: Code duplicated, block: B:97:0x037f A[Catch: all -> 0x03ab, TryCatch #3 {all -> 0x03ab, blocks: (B:66:0x0264, B:70:0x0274, B:74:0x0284, B:76:0x028a, B:78:0x0290, B:79:0x02ad, B:80:0x02df, B:82:0x02e5, B:84:0x02eb, B:86:0x030a, B:87:0x033c, B:89:0x0342, B:90:0x035e, B:94:0x0371, B:98:0x0387, B:102:0x039d, B:101:0x0395, B:97:0x037f, B:93:0x0369, B:69:0x0270), top: B:130:0x0264, outer: #2 }] */
    public final void a(Context context) {
        String name;
        ClassLoader classLoader;
        Context context2;
        ClassLoader classLoader2;
        ClassLoader classLoader3;
        ClassLoader contextClassLoader;
        String name2;
        String name3;
        String name4;
        ClassLoader classLoader4;
        String str;
        File fileA;
        String str2 = "";
        this.e = context;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            if (this.e == null) {
                com.anythink.china.c.c.b("check skip, context null");
            } else {
                char c2 = 0;
                this.c.set(false);
                com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(this.e).b(s.b().p());
                if (bVarB != null) {
                    this.g = bVarB.a();
                }
                com.anythink.china.c.c.a("check start, sdkInt=" + Build.VERSION.SDK_INT + ", refreshInterval=" + this.g + ", debug=" + ATSDK.isNetworkLogDebug());
                Iterator<Integer> it = this.b.iterator();
                while (true) {
                    boolean zHasNext = it.hasNext();
                    name = AbstractJsonLexerKt.NULL;
                    if (!zHasNext) {
                        break;
                    }
                    Integer next = it.next();
                    String strB = com.anythink.china.c.a.b(this.e, String.valueOf(next));
                    if (!TextUtils.isEmpty(strB)) {
                        String[] strArrSplit = strB.replaceAll(".jar", str2).split("-");
                        if (strArrSplit.length == 3) {
                            File fileB = com.anythink.china.c.a.b(this.e, String.valueOf(next), strArrSplit[c2] + "-" + strArrSplit[1]);
                            if (fileB != null) {
                                if (fileB.getName().equals(strB)) {
                                    str = str2;
                                } else {
                                    String[] strArrSplit2 = fileB.getName().replaceAll(".jar", str2).split("-");
                                    str = str2;
                                    if (strArrSplit2.length != 3) {
                                        fileA = null;
                                    } else if (Integer.parseInt(strArrSplit[2]) > Integer.parseInt(strArrSplit2[2])) {
                                        fileA = com.anythink.china.c.a.a(this.e, String.valueOf(next), strB);
                                    }
                                    if (fileA != null) {
                                        com.anythink.china.c.c.a("choose file, networkId=" + next + ", file=" + fileA.getName());
                                        this.d.put(next, fileA);
                                        com.anythink.china.c.a.a(this.e, String.valueOf(next), fileA);
                                    } else {
                                        StringBuilder sbAppend = new StringBuilder("select file null, networkId=").append(next).append(", asset=").append(strB).append(", local=");
                                        if (fileB == null) {
                                            name = fileB.getName();
                                        }
                                        com.anythink.china.c.c.b(sbAppend.append(name).toString());
                                    }
                                }
                                fileA = fileB;
                                if (fileA != null) {
                                    com.anythink.china.c.c.a("choose file, networkId=" + next + ", file=" + fileA.getName());
                                    this.d.put(next, fileA);
                                    com.anythink.china.c.a.a(this.e, String.valueOf(next), fileA);
                                } else {
                                    StringBuilder sbAppend2 = new StringBuilder("select file null, networkId=").append(next).append(", asset=").append(strB).append(", local=");
                                    if (fileB == null) {
                                        name = fileB.getName();
                                    }
                                    com.anythink.china.c.c.b(sbAppend2.append(name).toString());
                                }
                            } else {
                                str = str2;
                                File fileA2 = com.anythink.china.c.a.a(this.e, String.valueOf(next), strB);
                                if (fileA2 != null) {
                                    com.anythink.china.c.c.a("choose file(from assets), networkId=" + next + ", file=" + fileA2.getName());
                                    this.d.put(next, fileA2);
                                } else {
                                    com.anythink.china.c.c.b("copy assets failed, networkId=" + next + ", asset=" + strB);
                                }
                            }
                        } else {
                            str = str2;
                            com.anythink.china.c.c.b("invalid asset name, networkId=" + next + ", asset=" + strB);
                        }
                    } else {
                        str = str2;
                        com.anythink.china.c.c.a("no asset found, networkId=".concat(String.valueOf(next)));
                    }
                    str2 = str;
                    c2 = 0;
                }
                HashMap map = new HashMap();
                if (!this.d.isEmpty()) {
                    for (Map.Entry<Integer, File> entry : this.d.entrySet()) {
                        Integer key = entry.getKey();
                        File value = entry.getValue();
                        try {
                            if (Build.VERSION.SDK_INT >= 34) {
                                value.setReadOnly();
                            }
                        } catch (Throwable th) {
                            com.anythink.china.c.c.b("setReadOnly failed, networkId=".concat(String.valueOf(key)), th);
                        }
                        if (ad.b(this.e, t.b.a, t.a.G.concat(String.valueOf(key)), 2) != 1) {
                            map.put(key, value);
                        } else {
                            com.anythink.china.c.c.a("skip forbid, networkId=" + key + ", file=" + (value == null ? AbstractJsonLexerKt.NULL : value.getName()));
                        }
                    }
                    if (!map.isEmpty()) {
                        try {
                            context2 = this.e;
                            classLoader2 = g.class.getClassLoader();
                            if (context2 == null) {
                                classLoader3 = null;
                            } else {
                                classLoader3 = context2.getClassLoader();
                            }
                            contextClassLoader = Thread.currentThread().getContextClassLoader();
                            if (contextClassLoader == null && contextClassLoader != classLoader3) {
                                if (a(contextClassLoader) && a(contextClassLoader, classLoader2)) {
                                    com.anythink.china.c.c.a("use thread classloader: " + contextClassLoader.getClass().getName());
                                    classLoader4 = contextClassLoader;
                                } else {
                                    com.anythink.china.c.c.a("skip thread classloader: " + contextClassLoader.getClass().getName() + ", injectable=" + a(contextClassLoader) + ", visibleToSdk=" + a(contextClassLoader, classLoader2));
                                    if (!a(classLoader3)) {
                                        if (classLoader3 != null) {
                                            com.anythink.china.c.c.a("skip app classloader: " + classLoader3.getClass().getName() + ", injectable=" + a(classLoader3) + ", visibleToSdk=" + a(classLoader3, classLoader2));
                                        }
                                        if (a(classLoader2)) {
                                            com.anythink.china.c.c.a("use sdk classloader fallback: " + classLoader2.getClass().getName());
                                            classLoader4 = classLoader2;
                                        } else {
                                            StringBuilder sb = new StringBuilder("no injectable classloader, sdk=");
                                            if (classLoader2 == null) {
                                                name2 = AbstractJsonLexerKt.NULL;
                                            } else {
                                                name2 = classLoader2.getClass().getName();
                                            }
                                            StringBuilder sbAppend3 = sb.append(name2).append(", app=");
                                            if (classLoader3 == null) {
                                                name3 = AbstractJsonLexerKt.NULL;
                                            } else {
                                                name3 = classLoader3.getClass().getName();
                                            }
                                            StringBuilder sbAppend4 = sbAppend3.append(name3).append(", thread=");
                                            if (contextClassLoader == null) {
                                                name4 = AbstractJsonLexerKt.NULL;
                                            } else {
                                                name4 = contextClassLoader.getClass().getName();
                                            }
                                            com.anythink.china.c.c.b(sbAppend4.append(name4).toString());
                                            classLoader4 = null;
                                        }
                                    } else {
                                        if (classLoader3 != null) {
                                            com.anythink.china.c.c.a("skip app classloader: " + classLoader3.getClass().getName() + ", injectable=" + a(classLoader3) + ", visibleToSdk=" + a(classLoader3, classLoader2));
                                        }
                                        if (a(classLoader2)) {
                                            com.anythink.china.c.c.a("use sdk classloader fallback: " + classLoader2.getClass().getName());
                                            classLoader4 = classLoader2;
                                        } else {
                                            StringBuilder sb2 = new StringBuilder("no injectable classloader, sdk=");
                                            if (classLoader2 == null) {
                                                name2 = AbstractJsonLexerKt.NULL;
                                            } else {
                                                name2 = classLoader2.getClass().getName();
                                            }
                                            StringBuilder sbAppend5 = sb2.append(name2).append(", app=");
                                            if (classLoader3 == null) {
                                                name3 = AbstractJsonLexerKt.NULL;
                                            } else {
                                                name3 = classLoader3.getClass().getName();
                                            }
                                            StringBuilder sbAppend6 = sbAppend5.append(name3).append(", thread=");
                                            if (contextClassLoader == null) {
                                                name4 = AbstractJsonLexerKt.NULL;
                                            } else {
                                                name4 = contextClassLoader.getClass().getName();
                                            }
                                            com.anythink.china.c.c.b(sbAppend6.append(name4).toString());
                                            classLoader4 = null;
                                        }
                                    }
                                }
                            } else if (!a(classLoader3) && a(classLoader3, classLoader2)) {
                                com.anythink.china.c.c.a("keep app classloader: " + classLoader3.getClass().getName());
                                classLoader4 = classLoader3;
                            } else {
                                if (classLoader3 != null) {
                                    com.anythink.china.c.c.a("skip app classloader: " + classLoader3.getClass().getName() + ", injectable=" + a(classLoader3) + ", visibleToSdk=" + a(classLoader3, classLoader2));
                                }
                                if (a(classLoader2)) {
                                    com.anythink.china.c.c.a("use sdk classloader fallback: " + classLoader2.getClass().getName());
                                    classLoader4 = classLoader2;
                                } else {
                                    StringBuilder sb3 = new StringBuilder("no injectable classloader, sdk=");
                                    if (classLoader2 == null) {
                                        name2 = AbstractJsonLexerKt.NULL;
                                    } else {
                                        name2 = classLoader2.getClass().getName();
                                    }
                                    StringBuilder sbAppend7 = sb3.append(name2).append(", app=");
                                    if (classLoader3 == null) {
                                        name3 = AbstractJsonLexerKt.NULL;
                                    } else {
                                        name3 = classLoader3.getClass().getName();
                                    }
                                    StringBuilder sbAppend8 = sbAppend7.append(name3).append(", thread=");
                                    if (contextClassLoader == null) {
                                        name4 = AbstractJsonLexerKt.NULL;
                                    } else {
                                        name4 = contextClassLoader.getClass().getName();
                                    }
                                    com.anythink.china.c.c.b(sbAppend8.append(name4).toString());
                                    classLoader4 = null;
                                }
                            }
                            classLoader = classLoader4;
                        } catch (Throwable th2) {
                            com.anythink.china.c.c.b("resolve classloader failed", th2);
                            classLoader = null;
                        }
                        try {
                            if (classLoader != null) {
                                throw new IllegalStateException("inject classloader is null");
                            }
                            c.a(classLoader, new ArrayList(map.values()), this.e.getCacheDir());
                            com.anythink.core.common.t.f.a("0", "0", a(map), "1", "", String.valueOf(this.g), jElapsedRealtime);
                            com.anythink.china.c.c.a("load ok, count=" + map.size() + ", costMs=" + (SystemClock.elapsedRealtime() - jElapsedRealtime) + ", classloader=" + classLoader.getClass().getName());
                        } catch (Throwable th3) {
                            com.anythink.core.common.t.f.a("0", "0", a(map), "2", th3.getMessage(), String.valueOf(this.g), jElapsedRealtime);
                            StringBuilder sb4 = new StringBuilder("load failed, classloader=");
                            if (classLoader != null) {
                                name = classLoader.getClass().getName();
                            }
                            com.anythink.china.c.c.b(sb4.append(name).toString(), th3);
                        }
                    } else {
                        com.anythink.core.common.t.f.a("0", "1", a(this.d), "2", "", String.valueOf(this.g), jElapsedRealtime);
                        com.anythink.china.c.c.a("no file to load, candidates=" + this.d.size());
                    }
                } else if (!map.isEmpty()) {
                    context2 = this.e;
                    classLoader2 = g.class.getClassLoader();
                    if (context2 == null) {
                        classLoader3 = null;
                    } else {
                        classLoader3 = context2.getClassLoader();
                    }
                    contextClassLoader = Thread.currentThread().getContextClassLoader();
                    if (contextClassLoader == null) {
                        if (!a(classLoader3)) {
                            if (classLoader3 != null) {
                                com.anythink.china.c.c.a("skip app classloader: " + classLoader3.getClass().getName() + ", injectable=" + a(classLoader3) + ", visibleToSdk=" + a(classLoader3, classLoader2));
                            }
                            if (a(classLoader2)) {
                                com.anythink.china.c.c.a("use sdk classloader fallback: " + classLoader2.getClass().getName());
                                classLoader4 = classLoader2;
                            } else {
                                StringBuilder sb5 = new StringBuilder("no injectable classloader, sdk=");
                                if (classLoader2 == null) {
                                    name2 = AbstractJsonLexerKt.NULL;
                                } else {
                                    name2 = classLoader2.getClass().getName();
                                }
                                StringBuilder sbAppend9 = sb5.append(name2).append(", app=");
                                if (classLoader3 == null) {
                                    name3 = AbstractJsonLexerKt.NULL;
                                } else {
                                    name3 = classLoader3.getClass().getName();
                                }
                                StringBuilder sbAppend10 = sbAppend9.append(name3).append(", thread=");
                                if (contextClassLoader == null) {
                                    name4 = AbstractJsonLexerKt.NULL;
                                } else {
                                    name4 = contextClassLoader.getClass().getName();
                                }
                                com.anythink.china.c.c.b(sbAppend10.append(name4).toString());
                                classLoader4 = null;
                            }
                        } else {
                            if (classLoader3 != null) {
                                com.anythink.china.c.c.a("skip app classloader: " + classLoader3.getClass().getName() + ", injectable=" + a(classLoader3) + ", visibleToSdk=" + a(classLoader3, classLoader2));
                            }
                            if (a(classLoader2)) {
                                com.anythink.china.c.c.a("use sdk classloader fallback: " + classLoader2.getClass().getName());
                                classLoader4 = classLoader2;
                            } else {
                                StringBuilder sb6 = new StringBuilder("no injectable classloader, sdk=");
                                if (classLoader2 == null) {
                                    name2 = AbstractJsonLexerKt.NULL;
                                } else {
                                    name2 = classLoader2.getClass().getName();
                                }
                                StringBuilder sbAppend11 = sb6.append(name2).append(", app=");
                                if (classLoader3 == null) {
                                    name3 = AbstractJsonLexerKt.NULL;
                                } else {
                                    name3 = classLoader3.getClass().getName();
                                }
                                StringBuilder sbAppend12 = sbAppend11.append(name3).append(", thread=");
                                if (contextClassLoader == null) {
                                    name4 = AbstractJsonLexerKt.NULL;
                                } else {
                                    name4 = contextClassLoader.getClass().getName();
                                }
                                com.anythink.china.c.c.b(sbAppend12.append(name4).toString());
                                classLoader4 = null;
                            }
                        }
                    } else if (!a(classLoader3)) {
                        if (classLoader3 != null) {
                            com.anythink.china.c.c.a("skip app classloader: " + classLoader3.getClass().getName() + ", injectable=" + a(classLoader3) + ", visibleToSdk=" + a(classLoader3, classLoader2));
                        }
                        if (a(classLoader2)) {
                            com.anythink.china.c.c.a("use sdk classloader fallback: " + classLoader2.getClass().getName());
                            classLoader4 = classLoader2;
                        } else {
                            StringBuilder sb7 = new StringBuilder("no injectable classloader, sdk=");
                            if (classLoader2 == null) {
                                name2 = AbstractJsonLexerKt.NULL;
                            } else {
                                name2 = classLoader2.getClass().getName();
                            }
                            StringBuilder sbAppend13 = sb7.append(name2).append(", app=");
                            if (classLoader3 == null) {
                                name3 = AbstractJsonLexerKt.NULL;
                            } else {
                                name3 = classLoader3.getClass().getName();
                            }
                            StringBuilder sbAppend14 = sbAppend13.append(name3).append(", thread=");
                            if (contextClassLoader == null) {
                                name4 = AbstractJsonLexerKt.NULL;
                            } else {
                                name4 = contextClassLoader.getClass().getName();
                            }
                            com.anythink.china.c.c.b(sbAppend14.append(name4).toString());
                            classLoader4 = null;
                        }
                    } else {
                        if (classLoader3 != null) {
                            com.anythink.china.c.c.a("skip app classloader: " + classLoader3.getClass().getName() + ", injectable=" + a(classLoader3) + ", visibleToSdk=" + a(classLoader3, classLoader2));
                        }
                        if (a(classLoader2)) {
                            com.anythink.china.c.c.a("use sdk classloader fallback: " + classLoader2.getClass().getName());
                            classLoader4 = classLoader2;
                        } else {
                            StringBuilder sb8 = new StringBuilder("no injectable classloader, sdk=");
                            if (classLoader2 == null) {
                                name2 = AbstractJsonLexerKt.NULL;
                            } else {
                                name2 = classLoader2.getClass().getName();
                            }
                            StringBuilder sbAppend15 = sb8.append(name2).append(", app=");
                            if (classLoader3 == null) {
                                name3 = AbstractJsonLexerKt.NULL;
                            } else {
                                name3 = classLoader3.getClass().getName();
                            }
                            StringBuilder sbAppend16 = sbAppend15.append(name3).append(", thread=");
                            if (contextClassLoader == null) {
                                name4 = AbstractJsonLexerKt.NULL;
                            } else {
                                name4 = contextClassLoader.getClass().getName();
                            }
                            com.anythink.china.c.c.b(sbAppend16.append(name4).toString());
                            classLoader4 = null;
                        }
                    }
                    classLoader = classLoader4;
                    if (classLoader != null) {
                        throw new IllegalStateException("inject classloader is null");
                    }
                    c.a(classLoader, new ArrayList(map.values()), this.e.getCacheDir());
                    com.anythink.core.common.t.f.a("0", "0", a(map), "1", "", String.valueOf(this.g), jElapsedRealtime);
                    com.anythink.china.c.c.a("load ok, count=" + map.size() + ", costMs=" + (SystemClock.elapsedRealtime() - jElapsedRealtime) + ", classloader=" + classLoader.getClass().getName());
                } else {
                    com.anythink.core.common.t.f.a("0", "1", a(this.d), "2", "", String.valueOf(this.g), jElapsedRealtime);
                    com.anythink.china.c.c.a("no file to load, candidates=" + this.d.size());
                }
                this.c.set(true);
                com.anythink.china.c.c.a("check end, costMs=" + (SystemClock.elapsedRealtime() - jElapsedRealtime) + ", loaded=" + this.c.get());
            }
        } catch (Throwable th4) {
            com.anythink.core.common.t.f.a("0", "2", a(this.d), "2", th4.getMessage(), String.valueOf(this.g), jElapsedRealtime);
            com.anythink.china.c.c.b("load unexpected error", th4);
        }
        d();
        f.a().b();
    }

    private void d() {
        try {
            synchronized (this.f) {
                if (!this.f.isEmpty()) {
                    for (int i = 0; i < this.f.size(); i++) {
                        com.anythink.core.common.j.d dVar = this.f.get(i);
                        if (dVar != null) {
                            dVar.a();
                        }
                    }
                    this.f.clear();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x038e  */
    /* JADX WARN: Code duplicated, block: B:102:0x0390 A[Catch: all -> 0x03a6, TryCatch #2 {all -> 0x03a6, blocks: (B:67:0x025f, B:71:0x026f, B:75:0x027f, B:77:0x0285, B:79:0x028b, B:80:0x02a8, B:81:0x02da, B:83:0x02e0, B:85:0x02e6, B:87:0x0305, B:88:0x0337, B:90:0x033d, B:91:0x0359, B:95:0x036c, B:99:0x0382, B:103:0x0398, B:102:0x0390, B:98:0x037a, B:94:0x0364, B:70:0x026b), top: B:128:0x025f, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:110:0x03af A[Catch: all -> 0x0410, TRY_ENTER, TryCatch #0 {all -> 0x0410, blocks: (B:110:0x03af, B:113:0x0412, B:114:0x0419), top: B:126:0x03ad, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:113:0x0412 A[Catch: all -> 0x0410, TryCatch #0 {all -> 0x0410, blocks: (B:110:0x03af, B:113:0x0412, B:114:0x0419), top: B:126:0x03ad, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:120:0x0450 A[Catch: all -> 0x0481, TRY_LEAVE, TryCatch #1 {all -> 0x0481, blocks: (B:3:0x000c, B:5:0x0010, B:7:0x0016, B:9:0x0030, B:10:0x0036, B:11:0x006a, B:14:0x0074, B:16:0x008a, B:19:0x0098, B:21:0x00be, B:23:0x00c8, B:25:0x00da, B:27:0x00e9, B:32:0x00fb, B:33:0x0129, B:37:0x0149, B:36:0x0145, B:38:0x0156, B:40:0x0164, B:41:0x0188, B:42:0x01a3, B:43:0x01c0, B:45:0x01d4, B:47:0x01e1, B:48:0x01eb, B:50:0x01f1, B:57:0x021c, B:59:0x0232, B:60:0x0236, B:64:0x024d, B:63:0x0249, B:56:0x020f, B:65:0x0259, B:115:0x041a, B:119:0x0444, B:118:0x043c, B:120:0x0450, B:107:0x03a7, B:110:0x03af, B:113:0x0412, B:114:0x0419, B:67:0x025f, B:71:0x026f, B:75:0x027f, B:77:0x0285, B:79:0x028b, B:80:0x02a8, B:81:0x02da, B:83:0x02e0, B:85:0x02e6, B:87:0x0305, B:88:0x0337, B:90:0x033d, B:91:0x0359, B:95:0x036c, B:99:0x0382, B:103:0x0398, B:102:0x0390, B:98:0x037a, B:94:0x0364, B:70:0x026b, B:51:0x0204, B:53:0x020a), top: B:127:0x000c, inners: #0, #2, #3 }] */
    /* JADX WARN: Code duplicated, block: B:128:0x025f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:0x00fb A[Catch: all -> 0x0481, TryCatch #1 {all -> 0x0481, blocks: (B:3:0x000c, B:5:0x0010, B:7:0x0016, B:9:0x0030, B:10:0x0036, B:11:0x006a, B:14:0x0074, B:16:0x008a, B:19:0x0098, B:21:0x00be, B:23:0x00c8, B:25:0x00da, B:27:0x00e9, B:32:0x00fb, B:33:0x0129, B:37:0x0149, B:36:0x0145, B:38:0x0156, B:40:0x0164, B:41:0x0188, B:42:0x01a3, B:43:0x01c0, B:45:0x01d4, B:47:0x01e1, B:48:0x01eb, B:50:0x01f1, B:57:0x021c, B:59:0x0232, B:60:0x0236, B:64:0x024d, B:63:0x0249, B:56:0x020f, B:65:0x0259, B:115:0x041a, B:119:0x0444, B:118:0x043c, B:120:0x0450, B:107:0x03a7, B:110:0x03af, B:113:0x0412, B:114:0x0419, B:67:0x025f, B:71:0x026f, B:75:0x027f, B:77:0x0285, B:79:0x028b, B:80:0x02a8, B:81:0x02da, B:83:0x02e0, B:85:0x02e6, B:87:0x0305, B:88:0x0337, B:90:0x033d, B:91:0x0359, B:95:0x036c, B:99:0x0382, B:103:0x0398, B:102:0x0390, B:98:0x037a, B:94:0x0364, B:70:0x026b, B:51:0x0204, B:53:0x020a), top: B:127:0x000c, inners: #0, #2, #3 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0129 A[Catch: all -> 0x0481, TryCatch #1 {all -> 0x0481, blocks: (B:3:0x000c, B:5:0x0010, B:7:0x0016, B:9:0x0030, B:10:0x0036, B:11:0x006a, B:14:0x0074, B:16:0x008a, B:19:0x0098, B:21:0x00be, B:23:0x00c8, B:25:0x00da, B:27:0x00e9, B:32:0x00fb, B:33:0x0129, B:37:0x0149, B:36:0x0145, B:38:0x0156, B:40:0x0164, B:41:0x0188, B:42:0x01a3, B:43:0x01c0, B:45:0x01d4, B:47:0x01e1, B:48:0x01eb, B:50:0x01f1, B:57:0x021c, B:59:0x0232, B:60:0x0236, B:64:0x024d, B:63:0x0249, B:56:0x020f, B:65:0x0259, B:115:0x041a, B:119:0x0444, B:118:0x043c, B:120:0x0450, B:107:0x03a7, B:110:0x03af, B:113:0x0412, B:114:0x0419, B:67:0x025f, B:71:0x026f, B:75:0x027f, B:77:0x0285, B:79:0x028b, B:80:0x02a8, B:81:0x02da, B:83:0x02e0, B:85:0x02e6, B:87:0x0305, B:88:0x0337, B:90:0x033d, B:91:0x0359, B:95:0x036c, B:99:0x0382, B:103:0x0398, B:102:0x0390, B:98:0x037a, B:94:0x0364, B:70:0x026b, B:51:0x0204, B:53:0x020a), top: B:127:0x000c, inners: #0, #2, #3 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x0144  */
    /* JADX WARN: Code duplicated, block: B:36:0x0145 A[Catch: all -> 0x0481, TryCatch #1 {all -> 0x0481, blocks: (B:3:0x000c, B:5:0x0010, B:7:0x0016, B:9:0x0030, B:10:0x0036, B:11:0x006a, B:14:0x0074, B:16:0x008a, B:19:0x0098, B:21:0x00be, B:23:0x00c8, B:25:0x00da, B:27:0x00e9, B:32:0x00fb, B:33:0x0129, B:37:0x0149, B:36:0x0145, B:38:0x0156, B:40:0x0164, B:41:0x0188, B:42:0x01a3, B:43:0x01c0, B:45:0x01d4, B:47:0x01e1, B:48:0x01eb, B:50:0x01f1, B:57:0x021c, B:59:0x0232, B:60:0x0236, B:64:0x024d, B:63:0x0249, B:56:0x020f, B:65:0x0259, B:115:0x041a, B:119:0x0444, B:118:0x043c, B:120:0x0450, B:107:0x03a7, B:110:0x03af, B:113:0x0412, B:114:0x0419, B:67:0x025f, B:71:0x026f, B:75:0x027f, B:77:0x0285, B:79:0x028b, B:80:0x02a8, B:81:0x02da, B:83:0x02e0, B:85:0x02e6, B:87:0x0305, B:88:0x0337, B:90:0x033d, B:91:0x0359, B:95:0x036c, B:99:0x0382, B:103:0x0398, B:102:0x0390, B:98:0x037a, B:94:0x0364, B:70:0x026b, B:51:0x0204, B:53:0x020a), top: B:127:0x000c, inners: #0, #2, #3 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0269  */
    /* JADX WARN: Code duplicated, block: B:70:0x026b A[Catch: all -> 0x03a6, TryCatch #2 {all -> 0x03a6, blocks: (B:67:0x025f, B:71:0x026f, B:75:0x027f, B:77:0x0285, B:79:0x028b, B:80:0x02a8, B:81:0x02da, B:83:0x02e0, B:85:0x02e6, B:87:0x0305, B:88:0x0337, B:90:0x033d, B:91:0x0359, B:95:0x036c, B:99:0x0382, B:103:0x0398, B:102:0x0390, B:98:0x037a, B:94:0x0364, B:70:0x026b), top: B:128:0x025f, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:81:0x02da A[Catch: all -> 0x03a6, TryCatch #2 {all -> 0x03a6, blocks: (B:67:0x025f, B:71:0x026f, B:75:0x027f, B:77:0x0285, B:79:0x028b, B:80:0x02a8, B:81:0x02da, B:83:0x02e0, B:85:0x02e6, B:87:0x0305, B:88:0x0337, B:90:0x033d, B:91:0x0359, B:95:0x036c, B:99:0x0382, B:103:0x0398, B:102:0x0390, B:98:0x037a, B:94:0x0364, B:70:0x026b), top: B:128:0x025f, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:83:0x02e0 A[Catch: all -> 0x03a6, TryCatch #2 {all -> 0x03a6, blocks: (B:67:0x025f, B:71:0x026f, B:75:0x027f, B:77:0x0285, B:79:0x028b, B:80:0x02a8, B:81:0x02da, B:83:0x02e0, B:85:0x02e6, B:87:0x0305, B:88:0x0337, B:90:0x033d, B:91:0x0359, B:95:0x036c, B:99:0x0382, B:103:0x0398, B:102:0x0390, B:98:0x037a, B:94:0x0364, B:70:0x026b), top: B:128:0x025f, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x0303 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:87:0x0305 A[Catch: all -> 0x03a6, TryCatch #2 {all -> 0x03a6, blocks: (B:67:0x025f, B:71:0x026f, B:75:0x027f, B:77:0x0285, B:79:0x028b, B:80:0x02a8, B:81:0x02da, B:83:0x02e0, B:85:0x02e6, B:87:0x0305, B:88:0x0337, B:90:0x033d, B:91:0x0359, B:95:0x036c, B:99:0x0382, B:103:0x0398, B:102:0x0390, B:98:0x037a, B:94:0x0364, B:70:0x026b), top: B:128:0x025f, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x033d A[Catch: all -> 0x03a6, TryCatch #2 {all -> 0x03a6, blocks: (B:67:0x025f, B:71:0x026f, B:75:0x027f, B:77:0x0285, B:79:0x028b, B:80:0x02a8, B:81:0x02da, B:83:0x02e0, B:85:0x02e6, B:87:0x0305, B:88:0x0337, B:90:0x033d, B:91:0x0359, B:95:0x036c, B:99:0x0382, B:103:0x0398, B:102:0x0390, B:98:0x037a, B:94:0x0364, B:70:0x026b), top: B:128:0x025f, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x0359 A[Catch: all -> 0x03a6, TryCatch #2 {all -> 0x03a6, blocks: (B:67:0x025f, B:71:0x026f, B:75:0x027f, B:77:0x0285, B:79:0x028b, B:80:0x02a8, B:81:0x02da, B:83:0x02e0, B:85:0x02e6, B:87:0x0305, B:88:0x0337, B:90:0x033d, B:91:0x0359, B:95:0x036c, B:99:0x0382, B:103:0x0398, B:102:0x0390, B:98:0x037a, B:94:0x0364, B:70:0x026b), top: B:128:0x025f, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x0362  */
    /* JADX WARN: Code duplicated, block: B:94:0x0364 A[Catch: all -> 0x03a6, TryCatch #2 {all -> 0x03a6, blocks: (B:67:0x025f, B:71:0x026f, B:75:0x027f, B:77:0x0285, B:79:0x028b, B:80:0x02a8, B:81:0x02da, B:83:0x02e0, B:85:0x02e6, B:87:0x0305, B:88:0x0337, B:90:0x033d, B:91:0x0359, B:95:0x036c, B:99:0x0382, B:103:0x0398, B:102:0x0390, B:98:0x037a, B:94:0x0364, B:70:0x026b), top: B:128:0x025f, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:97:0x0378  */
    /* JADX WARN: Code duplicated, block: B:98:0x037a A[Catch: all -> 0x03a6, TryCatch #2 {all -> 0x03a6, blocks: (B:67:0x025f, B:71:0x026f, B:75:0x027f, B:77:0x0285, B:79:0x028b, B:80:0x02a8, B:81:0x02da, B:83:0x02e0, B:85:0x02e6, B:87:0x0305, B:88:0x0337, B:90:0x033d, B:91:0x0359, B:95:0x036c, B:99:0x0382, B:103:0x0398, B:102:0x0390, B:98:0x037a, B:94:0x0364, B:70:0x026b), top: B:128:0x025f, outer: #1 }] */
    private void e() {
        String name;
        ClassLoader classLoader;
        Context context;
        ClassLoader classLoader2;
        ClassLoader classLoader3;
        ClassLoader contextClassLoader;
        String name2;
        String name3;
        String name4;
        ClassLoader classLoader4;
        String str;
        File fileA;
        String str2 = "";
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            if (this.e == null) {
                com.anythink.china.c.c.b("check skip, context null");
                return;
            }
            char c2 = 0;
            this.c.set(false);
            com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(this.e).b(s.b().p());
            if (bVarB != null) {
                this.g = bVarB.a();
            }
            com.anythink.china.c.c.a("check start, sdkInt=" + Build.VERSION.SDK_INT + ", refreshInterval=" + this.g + ", debug=" + ATSDK.isNetworkLogDebug());
            Iterator<Integer> it = this.b.iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                name = AbstractJsonLexerKt.NULL;
                if (!zHasNext) {
                    break;
                }
                Integer next = it.next();
                String strB = com.anythink.china.c.a.b(this.e, String.valueOf(next));
                if (!TextUtils.isEmpty(strB)) {
                    String[] strArrSplit = strB.replaceAll(".jar", str2).split("-");
                    if (strArrSplit.length == 3) {
                        File fileB = com.anythink.china.c.a.b(this.e, String.valueOf(next), strArrSplit[c2] + "-" + strArrSplit[1]);
                        if (fileB != null) {
                            if (fileB.getName().equals(strB)) {
                                str = str2;
                            } else {
                                String[] strArrSplit2 = fileB.getName().replaceAll(".jar", str2).split("-");
                                str = str2;
                                if (strArrSplit2.length != 3) {
                                    fileA = null;
                                } else if (Integer.parseInt(strArrSplit[2]) > Integer.parseInt(strArrSplit2[2])) {
                                    fileA = com.anythink.china.c.a.a(this.e, String.valueOf(next), strB);
                                }
                                if (fileA != null) {
                                    com.anythink.china.c.c.a("choose file, networkId=" + next + ", file=" + fileA.getName());
                                    this.d.put(next, fileA);
                                    com.anythink.china.c.a.a(this.e, String.valueOf(next), fileA);
                                } else {
                                    StringBuilder sbAppend = new StringBuilder("select file null, networkId=").append(next).append(", asset=").append(strB).append(", local=");
                                    if (fileB == null) {
                                        name = fileB.getName();
                                    }
                                    com.anythink.china.c.c.b(sbAppend.append(name).toString());
                                }
                            }
                            fileA = fileB;
                            if (fileA != null) {
                                com.anythink.china.c.c.a("choose file, networkId=" + next + ", file=" + fileA.getName());
                                this.d.put(next, fileA);
                                com.anythink.china.c.a.a(this.e, String.valueOf(next), fileA);
                            } else {
                                StringBuilder sbAppend2 = new StringBuilder("select file null, networkId=").append(next).append(", asset=").append(strB).append(", local=");
                                if (fileB == null) {
                                    name = fileB.getName();
                                }
                                com.anythink.china.c.c.b(sbAppend2.append(name).toString());
                            }
                        } else {
                            str = str2;
                            File fileA2 = com.anythink.china.c.a.a(this.e, String.valueOf(next), strB);
                            if (fileA2 != null) {
                                com.anythink.china.c.c.a("choose file(from assets), networkId=" + next + ", file=" + fileA2.getName());
                                this.d.put(next, fileA2);
                            } else {
                                com.anythink.china.c.c.b("copy assets failed, networkId=" + next + ", asset=" + strB);
                            }
                        }
                    } else {
                        str = str2;
                        com.anythink.china.c.c.b("invalid asset name, networkId=" + next + ", asset=" + strB);
                    }
                } else {
                    str = str2;
                    com.anythink.china.c.c.a("no asset found, networkId=".concat(String.valueOf(next)));
                }
                str2 = str;
                c2 = 0;
            }
            HashMap map = new HashMap();
            if (!this.d.isEmpty()) {
                for (Map.Entry<Integer, File> entry : this.d.entrySet()) {
                    Integer key = entry.getKey();
                    File value = entry.getValue();
                    try {
                        if (Build.VERSION.SDK_INT >= 34) {
                            value.setReadOnly();
                        }
                    } catch (Throwable th) {
                        com.anythink.china.c.c.b("setReadOnly failed, networkId=".concat(String.valueOf(key)), th);
                    }
                    if (ad.b(this.e, t.b.a, t.a.G.concat(String.valueOf(key)), 2) != 1) {
                        map.put(key, value);
                    } else {
                        com.anythink.china.c.c.a("skip forbid, networkId=" + key + ", file=" + (value == null ? AbstractJsonLexerKt.NULL : value.getName()));
                    }
                }
                if (!map.isEmpty()) {
                    try {
                        context = this.e;
                        classLoader2 = g.class.getClassLoader();
                        if (context == null) {
                            classLoader3 = null;
                        } else {
                            classLoader3 = context.getClassLoader();
                        }
                        contextClassLoader = Thread.currentThread().getContextClassLoader();
                        if (contextClassLoader == null && contextClassLoader != classLoader3) {
                            if (a(contextClassLoader) && a(contextClassLoader, classLoader2)) {
                                com.anythink.china.c.c.a("use thread classloader: " + contextClassLoader.getClass().getName());
                                classLoader4 = contextClassLoader;
                            } else {
                                com.anythink.china.c.c.a("skip thread classloader: " + contextClassLoader.getClass().getName() + ", injectable=" + a(contextClassLoader) + ", visibleToSdk=" + a(contextClassLoader, classLoader2));
                                if (!a(classLoader3)) {
                                    if (classLoader3 != null) {
                                        com.anythink.china.c.c.a("skip app classloader: " + classLoader3.getClass().getName() + ", injectable=" + a(classLoader3) + ", visibleToSdk=" + a(classLoader3, classLoader2));
                                    }
                                    if (a(classLoader2)) {
                                        com.anythink.china.c.c.a("use sdk classloader fallback: " + classLoader2.getClass().getName());
                                        classLoader4 = classLoader2;
                                    } else {
                                        StringBuilder sb = new StringBuilder("no injectable classloader, sdk=");
                                        if (classLoader2 == null) {
                                            name2 = AbstractJsonLexerKt.NULL;
                                        } else {
                                            name2 = classLoader2.getClass().getName();
                                        }
                                        StringBuilder sbAppend3 = sb.append(name2).append(", app=");
                                        if (classLoader3 == null) {
                                            name3 = AbstractJsonLexerKt.NULL;
                                        } else {
                                            name3 = classLoader3.getClass().getName();
                                        }
                                        StringBuilder sbAppend4 = sbAppend3.append(name3).append(", thread=");
                                        if (contextClassLoader == null) {
                                            name4 = AbstractJsonLexerKt.NULL;
                                        } else {
                                            name4 = contextClassLoader.getClass().getName();
                                        }
                                        com.anythink.china.c.c.b(sbAppend4.append(name4).toString());
                                        classLoader4 = null;
                                    }
                                } else {
                                    if (classLoader3 != null) {
                                        com.anythink.china.c.c.a("skip app classloader: " + classLoader3.getClass().getName() + ", injectable=" + a(classLoader3) + ", visibleToSdk=" + a(classLoader3, classLoader2));
                                    }
                                    if (a(classLoader2)) {
                                        com.anythink.china.c.c.a("use sdk classloader fallback: " + classLoader2.getClass().getName());
                                        classLoader4 = classLoader2;
                                    } else {
                                        StringBuilder sb2 = new StringBuilder("no injectable classloader, sdk=");
                                        if (classLoader2 == null) {
                                            name2 = AbstractJsonLexerKt.NULL;
                                        } else {
                                            name2 = classLoader2.getClass().getName();
                                        }
                                        StringBuilder sbAppend5 = sb2.append(name2).append(", app=");
                                        if (classLoader3 == null) {
                                            name3 = AbstractJsonLexerKt.NULL;
                                        } else {
                                            name3 = classLoader3.getClass().getName();
                                        }
                                        StringBuilder sbAppend6 = sbAppend5.append(name3).append(", thread=");
                                        if (contextClassLoader == null) {
                                            name4 = AbstractJsonLexerKt.NULL;
                                        } else {
                                            name4 = contextClassLoader.getClass().getName();
                                        }
                                        com.anythink.china.c.c.b(sbAppend6.append(name4).toString());
                                        classLoader4 = null;
                                    }
                                }
                            }
                        } else if (!a(classLoader3) && a(classLoader3, classLoader2)) {
                            com.anythink.china.c.c.a("keep app classloader: " + classLoader3.getClass().getName());
                            classLoader4 = classLoader3;
                        } else {
                            if (classLoader3 != null) {
                                com.anythink.china.c.c.a("skip app classloader: " + classLoader3.getClass().getName() + ", injectable=" + a(classLoader3) + ", visibleToSdk=" + a(classLoader3, classLoader2));
                            }
                            if (a(classLoader2)) {
                                com.anythink.china.c.c.a("use sdk classloader fallback: " + classLoader2.getClass().getName());
                                classLoader4 = classLoader2;
                            } else {
                                StringBuilder sb3 = new StringBuilder("no injectable classloader, sdk=");
                                if (classLoader2 == null) {
                                    name2 = AbstractJsonLexerKt.NULL;
                                } else {
                                    name2 = classLoader2.getClass().getName();
                                }
                                StringBuilder sbAppend7 = sb3.append(name2).append(", app=");
                                if (classLoader3 == null) {
                                    name3 = AbstractJsonLexerKt.NULL;
                                } else {
                                    name3 = classLoader3.getClass().getName();
                                }
                                StringBuilder sbAppend8 = sbAppend7.append(name3).append(", thread=");
                                if (contextClassLoader == null) {
                                    name4 = AbstractJsonLexerKt.NULL;
                                } else {
                                    name4 = contextClassLoader.getClass().getName();
                                }
                                com.anythink.china.c.c.b(sbAppend8.append(name4).toString());
                                classLoader4 = null;
                            }
                        }
                        classLoader = classLoader4;
                    } catch (Throwable th2) {
                        com.anythink.china.c.c.b("resolve classloader failed", th2);
                        classLoader = null;
                    }
                    try {
                        if (classLoader != null) {
                            throw new IllegalStateException("inject classloader is null");
                        }
                        c.a(classLoader, new ArrayList(map.values()), this.e.getCacheDir());
                        com.anythink.core.common.t.f.a("0", "0", a(map), "1", "", String.valueOf(this.g), jElapsedRealtime);
                        com.anythink.china.c.c.a("load ok, count=" + map.size() + ", costMs=" + (SystemClock.elapsedRealtime() - jElapsedRealtime) + ", classloader=" + classLoader.getClass().getName());
                    } catch (Throwable th3) {
                        com.anythink.core.common.t.f.a("0", "0", a(map), "2", th3.getMessage(), String.valueOf(this.g), jElapsedRealtime);
                        StringBuilder sb4 = new StringBuilder("load failed, classloader=");
                        if (classLoader != null) {
                            name = classLoader.getClass().getName();
                        }
                        com.anythink.china.c.c.b(sb4.append(name).toString(), th3);
                    }
                } else {
                    com.anythink.core.common.t.f.a("0", "1", a(this.d), "2", "", String.valueOf(this.g), jElapsedRealtime);
                    com.anythink.china.c.c.a("no file to load, candidates=" + this.d.size());
                }
            } else if (!map.isEmpty()) {
                context = this.e;
                classLoader2 = g.class.getClassLoader();
                if (context == null) {
                    classLoader3 = null;
                } else {
                    classLoader3 = context.getClassLoader();
                }
                contextClassLoader = Thread.currentThread().getContextClassLoader();
                if (contextClassLoader == null) {
                    if (!a(classLoader3)) {
                        if (classLoader3 != null) {
                            com.anythink.china.c.c.a("skip app classloader: " + classLoader3.getClass().getName() + ", injectable=" + a(classLoader3) + ", visibleToSdk=" + a(classLoader3, classLoader2));
                        }
                        if (a(classLoader2)) {
                            com.anythink.china.c.c.a("use sdk classloader fallback: " + classLoader2.getClass().getName());
                            classLoader4 = classLoader2;
                        } else {
                            StringBuilder sb5 = new StringBuilder("no injectable classloader, sdk=");
                            if (classLoader2 == null) {
                                name2 = AbstractJsonLexerKt.NULL;
                            } else {
                                name2 = classLoader2.getClass().getName();
                            }
                            StringBuilder sbAppend9 = sb5.append(name2).append(", app=");
                            if (classLoader3 == null) {
                                name3 = AbstractJsonLexerKt.NULL;
                            } else {
                                name3 = classLoader3.getClass().getName();
                            }
                            StringBuilder sbAppend10 = sbAppend9.append(name3).append(", thread=");
                            if (contextClassLoader == null) {
                                name4 = AbstractJsonLexerKt.NULL;
                            } else {
                                name4 = contextClassLoader.getClass().getName();
                            }
                            com.anythink.china.c.c.b(sbAppend10.append(name4).toString());
                            classLoader4 = null;
                        }
                    } else {
                        if (classLoader3 != null) {
                            com.anythink.china.c.c.a("skip app classloader: " + classLoader3.getClass().getName() + ", injectable=" + a(classLoader3) + ", visibleToSdk=" + a(classLoader3, classLoader2));
                        }
                        if (a(classLoader2)) {
                            com.anythink.china.c.c.a("use sdk classloader fallback: " + classLoader2.getClass().getName());
                            classLoader4 = classLoader2;
                        } else {
                            StringBuilder sb6 = new StringBuilder("no injectable classloader, sdk=");
                            if (classLoader2 == null) {
                                name2 = AbstractJsonLexerKt.NULL;
                            } else {
                                name2 = classLoader2.getClass().getName();
                            }
                            StringBuilder sbAppend11 = sb6.append(name2).append(", app=");
                            if (classLoader3 == null) {
                                name3 = AbstractJsonLexerKt.NULL;
                            } else {
                                name3 = classLoader3.getClass().getName();
                            }
                            StringBuilder sbAppend12 = sbAppend11.append(name3).append(", thread=");
                            if (contextClassLoader == null) {
                                name4 = AbstractJsonLexerKt.NULL;
                            } else {
                                name4 = contextClassLoader.getClass().getName();
                            }
                            com.anythink.china.c.c.b(sbAppend12.append(name4).toString());
                            classLoader4 = null;
                        }
                    }
                } else if (!a(classLoader3)) {
                    if (classLoader3 != null) {
                        com.anythink.china.c.c.a("skip app classloader: " + classLoader3.getClass().getName() + ", injectable=" + a(classLoader3) + ", visibleToSdk=" + a(classLoader3, classLoader2));
                    }
                    if (a(classLoader2)) {
                        com.anythink.china.c.c.a("use sdk classloader fallback: " + classLoader2.getClass().getName());
                        classLoader4 = classLoader2;
                    } else {
                        StringBuilder sb7 = new StringBuilder("no injectable classloader, sdk=");
                        if (classLoader2 == null) {
                            name2 = AbstractJsonLexerKt.NULL;
                        } else {
                            name2 = classLoader2.getClass().getName();
                        }
                        StringBuilder sbAppend13 = sb7.append(name2).append(", app=");
                        if (classLoader3 == null) {
                            name3 = AbstractJsonLexerKt.NULL;
                        } else {
                            name3 = classLoader3.getClass().getName();
                        }
                        StringBuilder sbAppend14 = sbAppend13.append(name3).append(", thread=");
                        if (contextClassLoader == null) {
                            name4 = AbstractJsonLexerKt.NULL;
                        } else {
                            name4 = contextClassLoader.getClass().getName();
                        }
                        com.anythink.china.c.c.b(sbAppend14.append(name4).toString());
                        classLoader4 = null;
                    }
                } else {
                    if (classLoader3 != null) {
                        com.anythink.china.c.c.a("skip app classloader: " + classLoader3.getClass().getName() + ", injectable=" + a(classLoader3) + ", visibleToSdk=" + a(classLoader3, classLoader2));
                    }
                    if (a(classLoader2)) {
                        com.anythink.china.c.c.a("use sdk classloader fallback: " + classLoader2.getClass().getName());
                        classLoader4 = classLoader2;
                    } else {
                        StringBuilder sb8 = new StringBuilder("no injectable classloader, sdk=");
                        if (classLoader2 == null) {
                            name2 = AbstractJsonLexerKt.NULL;
                        } else {
                            name2 = classLoader2.getClass().getName();
                        }
                        StringBuilder sbAppend15 = sb8.append(name2).append(", app=");
                        if (classLoader3 == null) {
                            name3 = AbstractJsonLexerKt.NULL;
                        } else {
                            name3 = classLoader3.getClass().getName();
                        }
                        StringBuilder sbAppend16 = sbAppend15.append(name3).append(", thread=");
                        if (contextClassLoader == null) {
                            name4 = AbstractJsonLexerKt.NULL;
                        } else {
                            name4 = contextClassLoader.getClass().getName();
                        }
                        com.anythink.china.c.c.b(sbAppend16.append(name4).toString());
                        classLoader4 = null;
                    }
                }
                classLoader = classLoader4;
                if (classLoader != null) {
                    throw new IllegalStateException("inject classloader is null");
                }
                c.a(classLoader, new ArrayList(map.values()), this.e.getCacheDir());
                com.anythink.core.common.t.f.a("0", "0", a(map), "1", "", String.valueOf(this.g), jElapsedRealtime);
                com.anythink.china.c.c.a("load ok, count=" + map.size() + ", costMs=" + (SystemClock.elapsedRealtime() - jElapsedRealtime) + ", classloader=" + classLoader.getClass().getName());
            } else {
                com.anythink.core.common.t.f.a("0", "1", a(this.d), "2", "", String.valueOf(this.g), jElapsedRealtime);
                com.anythink.china.c.c.a("no file to load, candidates=" + this.d.size());
            }
        } catch (Throwable th4) {
            com.anythink.core.common.t.f.a("0", "2", a(this.d), "2", th4.getMessage(), String.valueOf(this.g), jElapsedRealtime);
            com.anythink.china.c.c.b("load unexpected error", th4);
        }
        this.c.set(true);
        com.anythink.china.c.c.a("check end, costMs=" + (SystemClock.elapsedRealtime() - jElapsedRealtime) + ", loaded=" + this.c.get());
    }

    private static ClassLoader b(Context context) {
        ClassLoader classLoader = g.class.getClassLoader();
        ClassLoader classLoader2 = context == null ? null : context.getClassLoader();
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader != null && contextClassLoader != classLoader2) {
            if (a(contextClassLoader) && a(contextClassLoader, classLoader)) {
                com.anythink.china.c.c.a("use thread classloader: " + contextClassLoader.getClass().getName());
                return contextClassLoader;
            }
            com.anythink.china.c.c.a("skip thread classloader: " + contextClassLoader.getClass().getName() + ", injectable=" + a(contextClassLoader) + ", visibleToSdk=" + a(contextClassLoader, classLoader));
        }
        if (a(classLoader2) && a(classLoader2, classLoader)) {
            com.anythink.china.c.c.a("keep app classloader: " + classLoader2.getClass().getName());
            return classLoader2;
        }
        if (classLoader2 != null) {
            com.anythink.china.c.c.a("skip app classloader: " + classLoader2.getClass().getName() + ", injectable=" + a(classLoader2) + ", visibleToSdk=" + a(classLoader2, classLoader));
        }
        if (a(classLoader)) {
            com.anythink.china.c.c.a("use sdk classloader fallback: " + classLoader.getClass().getName());
            return classLoader;
        }
        StringBuilder sb = new StringBuilder("no injectable classloader, sdk=");
        String name = AbstractJsonLexerKt.NULL;
        StringBuilder sbAppend = sb.append(classLoader == null ? AbstractJsonLexerKt.NULL : classLoader.getClass().getName()).append(", app=").append(classLoader2 == null ? AbstractJsonLexerKt.NULL : classLoader2.getClass().getName()).append(", thread=");
        if (contextClassLoader != null) {
            name = contextClassLoader.getClass().getName();
        }
        com.anythink.china.c.c.b(sbAppend.append(name).toString());
        return null;
    }

    private static boolean a(ClassLoader classLoader, ClassLoader classLoader2) {
        if (classLoader != null && classLoader2 != null) {
            while (classLoader2 != null) {
                if (classLoader2 == classLoader) {
                    return true;
                }
                classLoader2 = classLoader2.getParent();
            }
        }
        return false;
    }

    private static boolean a(ClassLoader classLoader) {
        if (classLoader == null) {
            return false;
        }
        for (Class<?> superclass = classLoader.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            if (BaseDexClassLoader.class.getName().equals(superclass.getName())) {
                return true;
            }
        }
        try {
            d.a(classLoader, "pathList");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final String a(Map<Integer, File> map) {
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry<Integer, File> entry : map.entrySet()) {
                        Integer key = entry.getKey();
                        File value = entry.getValue();
                        JSONObject jSONObject3 = new JSONObject();
                        try {
                            jSONObject3.put("cli_ver", value.getName().replaceAll(".jar", ""));
                            jSONObject3.put("adn_ver", a().a(key));
                            jSONObject3.put("md5", com.anythink.china.c.a.a(value.getAbsolutePath()));
                            jSONObject3.put("dl_ts", value.lastModified());
                            jSONObject3.put("file_size", value.length());
                            Context context = this.e;
                            if (context != null) {
                                jSONObject3.put("forbid", ad.b(context, t.b.a, t.a.G.concat(String.valueOf(key)), 2));
                            }
                            jSONObject2.put(String.valueOf(key), jSONObject3);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    jSONObject.put("hf_items", jSONObject2);
                    return jSONObject.toString();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return "";
    }

    private static void a(ClassLoader classLoader, List<File> list, File file) throws IllegalAccessException, NoSuchFieldException, IOException {
        c.a(classLoader, list, file);
    }

    private String a(Integer num) {
        if (num == null || !this.b.contains(num) || num.intValue() != 46) {
            return "";
        }
        try {
            Class<?> cls = Class.forName("com.bytedance.sdk.openadsdk.TTAdSdk");
            Method method = cls.getMethod("getAdManager", new Class[0]);
            method.setAccessible(true);
            Object objInvoke = method.invoke(cls, new Object[0]);
            if (objInvoke == null) {
                return "";
            }
            Method method2 = objInvoke.getClass().getMethod("getSDKVersion", new Class[0]);
            method2.setAccessible(true);
            return (String) method2.invoke(objInvoke, new Object[0]);
        } catch (Exception unused) {
            return "";
        }
    }

    private static final class c {
        private c() {
        }

        private static void b(ClassLoader classLoader, List<File> list, File file) throws IllegalAccessException, NoSuchFieldException, IOException {
            Object obj = d.a(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            d.a(obj, "dexElements", a(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                if (it.hasNext()) {
                    IOException iOException = (IOException) it.next();
                    com.anythink.china.c.c.a("makePathElements suppressed", iOException);
                    throw iOException;
                }
            }
        }

        private static Object[] a(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) throws NoSuchMethodException {
            Method methodA;
            try {
                methodA = d.a(obj, "makePathElements", (Class<?>[]) new Class[]{List.class, File.class, List.class});
            } catch (NoSuchMethodException e) {
                com.anythink.china.c.c.b("makePathElements(List,File,List) not found", e);
                try {
                    methodA = d.a(obj, "makePathElements", (Class<?>[]) new Class[]{ArrayList.class, File.class, ArrayList.class});
                } catch (NoSuchMethodException e2) {
                    com.anythink.china.c.c.b("makePathElements(ArrayList,File,ArrayList) not found, try v19", e2);
                    try {
                        return b.b(obj, arrayList, file, arrayList2);
                    } catch (NoSuchMethodException e3) {
                        com.anythink.china.c.c.b("makeDexElements fallback also failed", e3);
                        throw e3;
                    }
                }
            }
            return (Object[]) methodA.invoke(obj, arrayList, file, arrayList2);
        }

        static /* synthetic */ void a(ClassLoader classLoader, List list, File file) throws IllegalAccessException, NoSuchFieldException, IOException {
            Object obj = d.a(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            d.a(obj, "dexElements", a(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                if (it.hasNext()) {
                    IOException iOException = (IOException) it.next();
                    com.anythink.china.c.c.a("makePathElements suppressed", iOException);
                    throw iOException;
                }
            }
        }
    }

    private static final class b {
        private b() {
        }

        private static void b(ClassLoader classLoader, List<File> list, File file) throws IllegalAccessException, NoSuchFieldException, IOException {
            Object obj = d.a(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            d.a(obj, "dexElements", b(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                if (it.hasNext()) {
                    IOException iOException = (IOException) it.next();
                    com.anythink.china.c.c.a("makeDexElements suppressed", iOException);
                    throw iOException;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Object[] b(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) throws NoSuchMethodException {
            Method methodA;
            try {
                methodA = d.a(obj, "makeDexElements", (Class<?>[]) new Class[]{ArrayList.class, File.class, ArrayList.class});
            } catch (NoSuchMethodException e) {
                com.anythink.china.c.c.b("makeDexElements(ArrayList,File,ArrayList) not found", e);
                try {
                    methodA = d.a(obj, "makeDexElements", (Class<?>[]) new Class[]{List.class, File.class, List.class});
                } catch (NoSuchMethodException e2) {
                    com.anythink.china.c.c.b("makeDexElements(List,File,List) not found", e2);
                    throw e2;
                }
            }
            return (Object[]) methodA.invoke(obj, arrayList, file, arrayList2);
        }

        static /* synthetic */ void a(ClassLoader classLoader, List list, File file) throws IllegalAccessException, NoSuchFieldException, IOException {
            Object obj = d.a(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            d.a(obj, "dexElements", b(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                if (it.hasNext()) {
                    IOException iOException = (IOException) it.next();
                    com.anythink.china.c.c.a("makeDexElements suppressed", iOException);
                    throw iOException;
                }
            }
        }
    }

    private static final class a {
        private a() {
        }

        private static void b(ClassLoader classLoader, List<File> list, File file) throws IllegalAccessException, NoSuchFieldException {
            Object obj = d.a(classLoader, "pathList").get(classLoader);
            d.a(obj, "dexElements", (Object[]) d.a(obj, "makeDexElements", (Class<?>[]) new Class[]{ArrayList.class, File.class}).invoke(obj, new ArrayList(list), file));
        }

        private static Object[] a(Object obj, ArrayList<File> arrayList, File file) {
            return (Object[]) d.a(obj, "makeDexElements", (Class<?>[]) new Class[]{ArrayList.class, File.class}).invoke(obj, arrayList, file);
        }

        static /* synthetic */ void a(ClassLoader classLoader, List list, File file) throws IllegalAccessException, NoSuchFieldException {
            Object obj = d.a(classLoader, "pathList").get(classLoader);
            d.a(obj, "dexElements", (Object[]) d.a(obj, "makeDexElements", (Class<?>[]) new Class[]{ArrayList.class, File.class}).invoke(obj, new ArrayList(list), file));
        }
    }

    public final void a(com.anythink.core.common.j.d dVar) {
        if (dVar != null) {
            if (this.c.get()) {
                dVar.a();
                return;
            }
            synchronized (this.f) {
                if (!this.f.contains(dVar)) {
                    this.f.add(dVar);
                }
            }
        }
    }
}
