package com.byazt.wt;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 574})
public class nl {
    public String pr;

    public static nl pr() {
        return new nl();
    }

    private nl() {
        hw();
    }

    private void hw() {
        File filePr;
        Context context = com.byazt.sd.a.getContext();
        if (context == null) {
            return;
        }
        try {
            if ("mounted".equals(com.byazt.zp.x.pr()) && (filePr = com.byazt.ca.uc.pr(context, "TTCache", false, null)) != null) {
                filePr.mkdirs();
                this.pr = filePr.getPath();
            }
            if (TextUtils.isEmpty(this.pr)) {
                File file = new File(com.byazt.ca.uc.pr(context, false, null), "TTCache");
                file.mkdirs();
                this.pr = file.getPath();
            }
        } catch (Throwable th) {
        }
    }

    public void pr(Thread thread, Throwable th, String str) {
        boolean zContains = false;
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            String string = stringWriter.toString();
            if (string != null) {
                if (TextUtils.isEmpty(str)) {
                    str = TTAdConstant.class.getPackage().getName();
                }
                zContains = string.contains(str);
            }
            com.byazt.nz.x.pr().pr(thread, th);
        } catch (Throwable th2) {
        }
        if (zContains) {
            pr(thread, th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x00fa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:0x0101 A[Catch: all -> 0x0105, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0105, blocks: (B:55:0x0101, B:69:0x0119), top: B:87:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0119 A[Catch: all -> 0x0105, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0105, blocks: (B:55:0x0101, B:69:0x0119), top: B:87:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:71:0x011d A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:90:0x0112 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.Throwable] */
    private void pr(Thread thread, Throwable th) {
        FileOutputStream fileOutputStream;
        boolean z;
        int i;
        FileInputStream fileInputStream = null;
        fileOutputStream = null;
        fileOutputStream = null;
        FileOutputStream fileOutputStream2 = null;
        FileInputStream fileInputStream2 = null;
        fileInputStream = null;
        try {
            try {
                if (TextUtils.isEmpty(this.pr)) {
                    hw();
                }
                if (TextUtils.isEmpty(this.pr)) {
                    return;
                }
                File file = new File(this.pr, "tt_crash_count.properties");
                if (!file.exists() || !file.isFile() || !file.canRead()) {
                    Properties properties = new Properties();
                    properties.setProperty("crash_count", "1");
                    properties.setProperty("crash_last_time", String.valueOf(System.currentTimeMillis()));
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        properties.store(fileOutputStream, "tt_crash_info");
                        com.byazt.ca.ho.hw("TTCrashHandler", "==first");
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (Throwable th2) {
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            com.byazt.ca.ho.pr("TTCrashHandler", "crash count error", th);
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable th4) {
                                }
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                                return;
                            }
                            return;
                        } catch (Throwable th5) {
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable th6) {
                                }
                            }
                            if (fileOutputStream == null) {
                                throw th5;
                            }
                            try {
                                fileOutputStream.close();
                                throw th5;
                            } catch (Throwable th7) {
                                throw th5;
                            }
                        }
                    }
                }
                Properties properties2 = new Properties();
                FileInputStream fileInputStream3 = new FileInputStream(file);
                try {
                    properties2.load(fileInputStream3);
                    String property = properties2.getProperty("crash_count", "0");
                    String property2 = properties2.getProperty("crash_last_time", "0");
                    int iIntValue = Integer.valueOf(property).intValue();
                    int i2 = 0;
                    boolean z2 = true;
                    if (System.currentTimeMillis() - Long.valueOf(property2).longValue() < 300000) {
                        i = iIntValue + 1;
                        z = false;
                    } else {
                        z = true;
                        i = 1;
                    }
                    if (i < 3) {
                        z2 = false;
                    }
                    if (!z2) {
                        i2 = i;
                    }
                    com.byazt.ca.ho.hw("TTCrashHandler", "==" + i2 + ", " + z2 + ", " + z);
                    if (z2) {
                        try {
                            file.delete();
                        } catch (Throwable th8) {
                        }
                    } else {
                        properties2.setProperty("crash_count", String.valueOf(i2));
                        if (z) {
                            properties2.setProperty("crash_last_time", String.valueOf(System.currentTimeMillis()));
                        }
                        fileOutputStream = new FileOutputStream(file);
                        try {
                            properties2.store(fileOutputStream, "tt_crash_info");
                            fileOutputStream2 = fileOutputStream;
                        } catch (Throwable th9) {
                            th = th9;
                            fileInputStream = fileInputStream3;
                            com.byazt.ca.ho.pr("TTCrashHandler", "crash count error", th);
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                                return;
                            }
                            return;
                        }
                    }
                    if (z2) {
                        hn();
                    }
                    fileOutputStream = fileOutputStream2;
                    fileInputStream2 = fileInputStream3;
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (Throwable th10) {
                    th = th10;
                    fileOutputStream = fileOutputStream2;
                }
            } catch (Throwable th11) {
            }
        } catch (Throwable th12) {
            th = th12;
            fileOutputStream = null;
        }
    }

    private void hn() {
        try {
            com.byazt.ks.pr.pr().hn();
        } catch (Throwable th) {
        }
        try {
            com.byazt.bv.pr.pr().hw();
        } catch (Throwable th2) {
        }
        try {
            com.byazt.is.zo.hw();
        } catch (Throwable th3) {
        }
        try {
            com.byazt.ce.hw.hw();
            com.byazt.hn.hw.hw().uc();
        } catch (Throwable th4) {
        }
        try {
            Function<SparseArray<Object>, Object> functionLs = com.byazt.sd.zo.nt().ls();
            if (functionLs != null) {
                functionLs.apply(com.byazt.xi.hw.pr().pr(7).pr(Void.class).hw());
            }
        } catch (Throwable th5) {
        }
        try {
            com.byazt.mp.hn.pr().w();
            com.byazt.mp.x.pr().lb();
            com.byazt.mp.c.pr().nt();
        } catch (Throwable th6) {
        }
    }
}
