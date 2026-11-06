package com.byazt.wt;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN})
public class s {
    public static String pr;

    /* JADX WARN: Code duplicated, block: B:62:0x0080 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x0077 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static String pr(String str) {
        BufferedReader bufferedReader;
        StringBuilder sb = new StringBuilder();
        FileReader fileReader = null;
        try {
            File file = new File("data/data/com.union_test.toutiao/" + str);
            if (!file.exists()) {
                return null;
            }
            FileReader fileReader2 = new FileReader(file);
            try {
                bufferedReader = new BufferedReader(fileReader2);
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line);
                    } catch (Exception e) {
                        fileReader = fileReader2;
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (Throwable th) {
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable th2) {
                            }
                        }
                        return sb.toString();
                    } catch (Throwable th3) {
                        th = th3;
                        fileReader = fileReader2;
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (Throwable th4) {
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                                throw th;
                            } catch (Throwable th5) {
                                throw th;
                            }
                        }
                        throw th;
                    }
                }
                String string = sb.toString();
                try {
                    fileReader2.close();
                } catch (Throwable th6) {
                }
                try {
                    bufferedReader.close();
                } catch (Throwable th7) {
                }
                return string;
            } catch (Exception e2) {
                bufferedReader = null;
            } catch (Throwable th8) {
                th = th8;
                bufferedReader = null;
            }
        } catch (Exception e3) {
            bufferedReader = null;
        } catch (Throwable th9) {
            th = th9;
            bufferedReader = null;
        }
        if (fileReader != null) {
            fileReader.close();
        }
        if (bufferedReader != null) {
            bufferedReader.close();
        }
        return sb.toString();
    }

    public static boolean pr() {
        if (!com.byazt.ca.ho.hn()) {
            return false;
        }
        return com.byazt.sd.zo.nt().of();
    }

    public static String pr(String str, String str2) {
        if (str.contains("https://api-access.pangolin-sdk-toutiao.com")) {
            return str.replace("https://api-access.pangolin-sdk-toutiao.com", str2);
        }
        return str;
    }

    public static String hw(String str) {
        try {
            if (!pr()) {
                return str;
            }
            String strR = com.byazt.sd.zo.nt().r();
            if (TextUtils.isEmpty(strR)) {
                return str;
            }
            return Uri.parse(str).buildUpon().appendQueryParameter(hw(), strR).appendQueryParameter("aid", "5001121").toString();
        } catch (Throwable th) {
            return str;
        }
    }

    public static void pr(Map<String, String> map) {
        if (pr()) {
            map.put("x-app-id", "5001121");
            String strR = com.byazt.sd.zo.nt().r();
            if (!TextUtils.isEmpty(strR)) {
                map.put("x-device-id", strR);
            }
        }
    }

    public static String hn(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            String strHn = com.byazt.hb.pr.hn();
            if (!TextUtils.isEmpty(strHn)) {
                strHn = strHn.replaceAll("\\.", "");
            }
            return Uri.parse(str).buildUpon().appendQueryParameter("sdkVersion", strHn).toString();
        } catch (Exception e) {
            return str;
        }
    }

    public static String hw() {
        if (TextUtils.isEmpty(pr)) {
            pr = new String(Base64.decode("ZGV2aWNlX2lk", 0));
        }
        return pr;
    }
}
