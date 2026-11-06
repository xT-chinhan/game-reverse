package com.bytedance.sdk.component.ab.ah;

import com.bytedance.sdk.component.utils.sl;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ka implements com.bytedance.sdk.component.ab.ms, com.bytedance.sdk.component.ab.xr {
    private static boolean ah = false;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static Method f743ms;
    private static Method xr;
    private final com.bytedance.sdk.component.d.ms.ms d;
    private final boolean ka;

    static {
        try {
            Class<?> cls = Class.forName("com.android.internal.util.XmlUtils");
            f743ms = cls.getDeclaredMethod("readMapXml", InputStream.class);
            xr = cls.getDeclaredMethod("writeMapXml", Map.class, OutputStream.class);
            f743ms.setAccessible(true);
            xr.setAccessible(true);
            ah = true;
        } catch (Exception unused) {
            ah = false;
        }
    }

    public static boolean ms() {
        return ah;
    }

    public ka(com.bytedance.sdk.component.d.ms.ms msVar) {
        this.d = msVar;
        this.ka = false;
    }

    public ka(com.bytedance.sdk.component.d.ms.ms msVar, boolean z) {
        this.d = msVar;
        this.ka = z;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.bytedance.sdk.component.ab.ms
    public Map<String, Object> ms(File file) throws Throwable {
        Exception e;
        BufferedInputStream bufferedInputStream;
        if (ah && file.exists()) {
            BufferedInputStream bufferedInputStream2 = null;
            if (!file.canRead()) {
                sl.xr("PropReaderWriter", "can't read file ".concat(String.valueOf(file)));
                return null;
            }
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 49152);
                try {
                    try {
                        Map<String, Object> mapMs = new com.bytedance.sdk.component.ab.ms.xr().ms((Map) f743ms.invoke(null, bufferedInputStream), this.d, this.ka);
                        try {
                            bufferedInputStream.close();
                        } catch (IOException unused) {
                        }
                        return mapMs;
                    } catch (Exception e2) {
                        e = e2;
                        sl.xr("XmlReader", "read file exception: ".concat(String.valueOf(file)), e);
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        return Collections.emptyMap();
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream2 = bufferedInputStream;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                bufferedInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                }
                throw th;
            }
        }
        return Collections.emptyMap();
    }

    @Override // com.bytedance.sdk.component.ab.xr
    public void ms(Map<String, Object> map, File file) throws Throwable {
        if (!ah || file == null) {
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        if (file.exists()) {
            file.delete();
        } else {
            file.getParentFile().mkdirs();
        }
        file.createNewFile();
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    xr.invoke(null, new com.bytedance.sdk.component.ab.ms.xr().ms(map, this.d, this.ka), fileOutputStream2);
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused) {
                    }
                } catch (Exception e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    sl.xr("XmlReader", "write: to file exception: ".concat(String.valueOf(file)), e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
