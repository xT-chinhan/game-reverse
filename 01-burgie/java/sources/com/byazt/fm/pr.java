package com.byazt.fm;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.byazt.ca.ho;
import com.byazt.nzn.g;
import com.byazt.nzn.k;
import com.byazt.nzn.nt;
import com.byazt.nzn.uc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.efs.sdk.base.Constants;
import com.taptap.sdk.update.download.core.Util;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VIDEO_TIMESTAMP_MONOTONIC, 37})
public class pr extends hn {
    public File hw;
    public File pr;

    public pr(k kVar) {
        super(kVar);
    }

    public void pr(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        this.pr = new File(str, str2);
        this.hw = new File(str, str2 + ".temp");
    }

    @Override // com.byazt.fm.hn
    public void pr(final com.byazt.elv.pr prVar) {
        File file = this.pr;
        if (file == null || this.hw == null) {
            if (prVar != null) {
                prVar.pr(this, new IOException("File info is null, please exec setFileInfo(String dir, String fileName)"));
                return;
            }
            return;
        }
        if (file.exists() && this.pr.length() != 0 && prVar != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.byazt.tf.x xVar = new com.byazt.tf.x(true, 200, "Success", null, null, jCurrentTimeMillis, jCurrentTimeMillis);
            xVar.pr(this.pr);
            prVar.pr(this, xVar);
            return;
        }
        long length = this.hw.length();
        final long j = length >= 0 ? length : 0L;
        g.pr prVar2 = new g.pr();
        prVar2.pr((Object) hw());
        hw(Util.RANGE, "bytes=" + j + "-");
        if (TextUtils.isEmpty(this.uc)) {
            prVar.pr(this, new IOException("Url is Empty"));
            return;
        }
        try {
            prVar2.pr(this.uc);
            pr(prVar2);
            this.hn.pr(prVar2.pr().hw()).pr(new com.byazt.nzn.hn() { // from class: com.byazt.fm.pr.1
                @Override // com.byazt.nzn.hn
                public void onFailure(com.byazt.nzn.hw hwVar, IOException iOException) {
                    com.byazt.elv.pr prVar3 = prVar;
                    if (prVar3 != null) {
                        prVar3.pr(pr.this, iOException);
                    }
                    pr.this.c();
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r11v1 */
                /* JADX WARN: Type inference failed for: r11v2 */
                /* JADX WARN: Type inference failed for: r11v3, types: [com.byazt.tf.x] */
                /* JADX WARN: Type inference failed for: r11v5, types: [java.lang.String] */
                /* JADX WARN: Type inference failed for: r11v6 */
                /* JADX WARN: Type inference failed for: r11v7 */
                /* JADX WARN: Type inference failed for: r11v8 */
                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
                    jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:44:0x013e
                    	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1478)
                    	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
                    	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
                    	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
                    */
                @Override // com.byazt.nzn.hn
                public void onResponse(com.byazt.nzn.hw r21, com.byazt.nzn.nt r22) throws java.io.IOException {
                    /*
                        Method dump skipped, instruction units count: 617
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.byazt.fm.pr.AnonymousClass1.onResponse(com.byazt.nzn.hw, com.byazt.nzn.nt):void");
                }
            });
        } catch (IllegalArgumentException e) {
            prVar.pr(this, new IOException("Url is not a valid HTTP or HTTPS URL"));
        }
    }

    /* JADX WARN: Code duplicated, block: B:232:0x02ec A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:236:0x02d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.byazt.fm.hn
    public com.byazt.tf.x pr() {
        HashMap map;
        RandomAccessFile randomAccessFile;
        long j;
        Throwable th;
        byte[] bArr;
        int i;
        long j2;
        int i2;
        InputStream inputStream;
        boolean z;
        File file = this.pr;
        if (file == null || this.hw == null) {
            boolean z2 = false;
            StringBuilder sbAppend = new StringBuilder("file == null: ").append(this.pr == null ? true : z2).append(" tempFile == null: ");
            if (this.hw == null) {
                z2 = true;
            }
            return new com.byazt.tf.x(false, -10, sbAppend.append(z2).toString(), null, null, 0L, 0L);
        }
        if (file.exists() && this.pr.length() != 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.byazt.tf.x xVar = new com.byazt.tf.x(true, 200, "Success", null, null, jCurrentTimeMillis, jCurrentTimeMillis);
            xVar.pr(this.pr);
            return xVar;
        }
        long length = this.hw.length();
        if (length < 0) {
            length = 0;
        }
        g.pr prVar = new g.pr();
        prVar.pr((Object) hw());
        hw(Util.RANGE, "bytes=" + length + "-");
        if (TextUtils.isEmpty(this.uc)) {
            ho.hw("DownloadExecutor", "execute: Url is Empty");
            return new com.byazt.tf.x(false, -9, "url is Empty", null, null, 0L, 0L);
        }
        try {
            prVar.pr(this.uc);
            pr(prVar);
            try {
                nt ntVarHw = this.hn.pr(prVar.pr().hw()).hw();
                if (ntVarHw == null || !ntVarHw.x()) {
                    return new com.byazt.tf.x(false, ntVarHw == null ? -2 : ntVarHw.hn(), ntVarHw == null ? "ok response is null" : ntVarHw.c(), null, null, 0L, 0L);
                }
                HashMap map2 = new HashMap();
                uc ucVarFw = ntVarHw.fw();
                if (ucVarFw != null) {
                    for (int i3 = 0; i3 < ucVarFw.pr(); i3++) {
                        map2.put(ucVarFw.pr(i3), ucVarFw.hw(i3));
                    }
                }
                com.byazt.tf.x xVar2 = new com.byazt.tf.x(ntVarHw.x(), ntVarHw.hn(), ntVarHw.c(), map2, null, ntVarHw.hw(), ntVarHw.pr());
                long jPr = ntVarHw.uc().pr();
                if (jPr <= 0) {
                    jPr = fw(map2);
                }
                long length2 = this.hw.length();
                boolean zUc = uc(map2);
                if (zUc) {
                    jPr += length2;
                    map = map2;
                    String str = (String) map.get(Util.CONTENT_RANGE);
                    if (!TextUtils.isEmpty(str) && TextUtils.indexOf(str, "bytes " + length2 + "-" + (jPr - 1)) == -1) {
                        c();
                        return new com.byazt.tf.x(false, -7, "realRangeValue failed", null, null, 0L, 0L);
                    }
                } else {
                    map = map2;
                }
                if (jPr > 0 && this.hw.exists() && this.hw.length() == jPr) {
                    if (!this.hw.renameTo(this.pr)) {
                        return new com.byazt.tf.x(false, -6, "rename failed", null, null, 0L, 0L);
                    }
                    xVar2.pr(this.pr);
                    return xVar2;
                }
                InputStream inputStreamHn = null;
                try {
                    try {
                        try {
                            randomAccessFile = new RandomAccessFile(this.hw, "rw");
                            try {
                                if (zUc) {
                                    randomAccessFile.seek(length);
                                    j = length;
                                } else {
                                    randomAccessFile.setLength(0L);
                                    j = 0;
                                }
                                while (true) {
                                    i2 = inputStreamHn.read(bArr, i, 16384 - i);
                                    inputStream = inputStreamHn;
                                    if (i2 == -1) {
                                        break;
                                    }
                                    i += i2;
                                    RandomAccessFile randomAccessFile2 = randomAccessFile;
                                    j2 += (long) i2;
                                    try {
                                        if (j2 % PlaybackStateCompat.ACTION_PREPARE == 0 || j2 == jPr - length) {
                                            randomAccessFile = randomAccessFile2;
                                            try {
                                                randomAccessFile.seek(j);
                                                randomAccessFile.write(bArr, 0, i);
                                                j += (long) i;
                                                i = 0;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                th = th;
                                                inputStreamHn = inputStream;
                                                if (!zUc) {
                                                    try {
                                                        c();
                                                    } finally {
                                                        if (inputStreamHn != null) {
                                                            try {
                                                                inputStreamHn.close();
                                                            } catch (Throwable th3) {
                                                            }
                                                        }
                                                        try {
                                                            randomAccessFile.close();
                                                        } catch (Throwable th4) {
                                                        }
                                                    }
                                                }
                                                return new com.byazt.tf.x(false, -3, "Error occured when FileRequest.parseHttpResponse", null, null, 0L, 0L, th);
                                            }
                                        } else {
                                            randomAccessFile = randomAccessFile2;
                                        }
                                        inputStreamHn = inputStream;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        randomAccessFile = randomAccessFile2;
                                    }
                                }
                            } catch (Throwable th6) {
                                j = 0;
                            }
                        } catch (Throwable th7) {
                            randomAccessFile = null;
                        }
                        bArr = new byte[16384];
                        i = 0;
                        j2 = 0;
                        if (i2 != 0) {
                            randomAccessFile.seek(j);
                            z = false;
                            randomAccessFile.write(bArr, 0, i);
                        } else {
                            z = false;
                        }
                        if (!zUc || length == 0) {
                            jPr = this.hw.length();
                        }
                        if (jPr <= 0 || !this.hw.exists() || this.hw.length() != jPr) {
                            com.byazt.tf.x xVar3 = new com.byazt.tf.x(false, -4, " tempFile.length() == fileSize is" + (this.hw.length() == jPr ? true : z), null, null, 0L, 0L);
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable th8) {
                                }
                            }
                            try {
                                randomAccessFile.close();
                            } catch (Throwable th9) {
                            }
                            return xVar3;
                        }
                        if (this.hw.renameTo(this.pr)) {
                            xVar2.pr(this.pr);
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable th10) {
                                }
                            }
                            try {
                                randomAccessFile.close();
                            } catch (Throwable th11) {
                            }
                            return xVar2;
                        }
                        com.byazt.tf.x xVar4 = new com.byazt.tf.x(false, -5, "rename failed", null, null, 0L, 0L);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable th12) {
                            }
                        }
                        try {
                            randomAccessFile.close();
                        } catch (Throwable th13) {
                        }
                        return xVar4;
                    } catch (Throwable th14) {
                        th = th14;
                        th = th;
                        if (!zUc) {
                            c();
                        }
                        return new com.byazt.tf.x(false, -3, "Error occured when FileRequest.parseHttpResponse", null, null, 0L, 0L, th);
                    }
                    inputStreamHn = ntVarHw.uc().hn();
                    if (zo(map) && !(inputStreamHn instanceof GZIPInputStream)) {
                        inputStreamHn = new GZIPInputStream(inputStreamHn);
                    }
                } catch (Throwable th15) {
                    th = th15;
                }
            } catch (IOException e) {
                c();
                return new com.byazt.tf.x(false, -1, e.getMessage(), null, null, 0L, 0L, e);
            }
        } catch (IllegalArgumentException e2) {
            ho.hw("DownloadExecutor", "Url is not a valid HTTP or HTTPS URL");
            return new com.byazt.tf.x(false, -8, "Url is not a valid HTTP or HTTPS URL", null, null, 0L, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean uc(Map<String, String> map) {
        if (TextUtils.equals(map.get(Util.ACCEPT_RANGES), "bytes") || TextUtils.equals(map.get("accept-ranges"), "bytes")) {
            return true;
        }
        String str = map.get(Util.CONTENT_RANGE);
        if (TextUtils.isEmpty(str)) {
            str = map.get("content-range");
        }
        return str != null && str.startsWith("bytes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long fw(Map<String, String> map) {
        String str;
        if (map.containsKey("content-length")) {
            str = map.get("content-length");
        } else if (!map.containsKey(Util.CONTENT_LENGTH)) {
            str = null;
        } else {
            str = map.get(Util.CONTENT_LENGTH);
        }
        if (TextUtils.isEmpty(str) || str == null) {
            return 0L;
        }
        try {
            return Long.valueOf(str).longValue();
        } catch (Throwable th) {
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zo(Map<String, String> map) {
        return TextUtils.equals(map.get("Content-Encoding"), Constants.CP_GZIP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            this.pr.delete();
        } catch (Throwable th) {
        }
        try {
            this.hw.delete();
        } catch (Throwable th2) {
        }
    }
}
