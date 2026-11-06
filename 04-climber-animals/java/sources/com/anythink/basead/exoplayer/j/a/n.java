package com.anythink.basead.exoplayer.j.a;

import com.anythink.basead.exoplayer.k.af;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
final class n extends e {
    private static final String g = ".v3.exo";
    private static final Pattern h = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", 32);
    private static final Pattern i = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", 32);
    private static final Pattern j = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", 32);

    public static File a(File file, int i2, long j2, long j3) {
        return new File(file, i2 + com.anythink.core.common.d.j.z + j2 + com.anythink.core.common.d.j.z + j3 + g);
    }

    public static n a(String str, long j2) {
        return new n(str, j2, -1L, -9223372036854775807L, null);
    }

    public static n b(String str, long j2) {
        return new n(str, j2, -1L, -9223372036854775807L, null);
    }

    public static n a(String str, long j2, long j3) {
        return new n(str, j2, j3, -9223372036854775807L, null);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0066 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:18:0x0067  */
    public static n a(File file, h hVar) {
        File file2;
        String strGroup;
        File fileA;
        String name = file.getName();
        if (name.endsWith(g)) {
            file2 = file;
        } else {
            String name2 = file.getName();
            Matcher matcher = i.matcher(name2);
            if (matcher.matches()) {
                strGroup = af.h(matcher.group(1));
                if (strGroup != null) {
                    fileA = a(file.getParentFile(), hVar.c(strGroup), Long.parseLong(matcher.group(2)), Long.parseLong(matcher.group(3)));
                    if (!file.renameTo(fileA)) {
                    }
                }
                if (fileA == null) {
                    return null;
                }
                file2 = fileA;
                name = fileA.getName();
            } else {
                matcher = h.matcher(name2);
                if (matcher.matches()) {
                    strGroup = matcher.group(1);
                    fileA = a(file.getParentFile(), hVar.c(strGroup), Long.parseLong(matcher.group(2)), Long.parseLong(matcher.group(3)));
                    if (!file.renameTo(fileA)) {
                    }
                }
                if (fileA == null) {
                    return null;
                }
                file2 = fileA;
                name = fileA.getName();
            }
            fileA = null;
            if (fileA == null) {
                return null;
            }
            file2 = fileA;
            name = fileA.getName();
        }
        Matcher matcher2 = j.matcher(name);
        if (!matcher2.matches()) {
            return null;
        }
        long length = file2.length();
        String strA = hVar.a(Integer.parseInt(matcher2.group(1)));
        if (strA == null) {
            return null;
        }
        return new n(strA, Long.parseLong(matcher2.group(2)), length, Long.parseLong(matcher2.group(3)), file2);
    }

    private static File b(File file, h hVar) {
        String strGroup;
        String name = file.getName();
        Matcher matcher = i.matcher(name);
        if (matcher.matches()) {
            strGroup = af.h(matcher.group(1));
            if (strGroup == null) {
                return null;
            }
        } else {
            matcher = h.matcher(name);
            if (!matcher.matches()) {
                return null;
            }
            strGroup = matcher.group(1);
        }
        File fileA = a(file.getParentFile(), hVar.c(strGroup), Long.parseLong(matcher.group(2)), Long.parseLong(matcher.group(3)));
        if (file.renameTo(fileA)) {
            return fileA;
        }
        return null;
    }

    private n(String str, long j2, long j3, long j4, File file) {
        super(str, j2, j3, j4, file);
    }

    public final n a(int i2) {
        com.anythink.basead.exoplayer.k.a.b(this.d);
        long jCurrentTimeMillis = System.currentTimeMillis();
        return new n(this.a, this.b, this.c, jCurrentTimeMillis, a(this.e.getParentFile(), i2, this.b, jCurrentTimeMillis));
    }
}
