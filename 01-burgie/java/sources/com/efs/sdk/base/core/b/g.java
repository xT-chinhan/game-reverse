package com.efs.sdk.base.core.b;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Base64;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends Handler implements e {
    private final ConcurrentHashMap<String, a> a;
    private com.efs.sdk.base.core.e.a.d b;
    private com.efs.sdk.base.core.e.a.c c;

    g() {
        super(com.efs.sdk.base.core.util.concurrent.a.a.getLooper());
        this.a = new ConcurrentHashMap<>();
        this.b = new com.efs.sdk.base.core.e.a.d();
        this.c = new com.efs.sdk.base.core.e.a.c();
    }

    @Override // android.os.Handler
    public final void handleMessage(@NonNull Message message) {
        switch (message.what) {
            case 0:
                com.efs.sdk.base.core.d.b bVar = (com.efs.sdk.base.core.d.b) message.obj;
                for (int i = 0; i < 3; i++) {
                    try {
                        a aVarB = b(bVar);
                        if (aVarB == null) {
                            Log.w("efs.cache", "writer is null for type " + bVar.a.a);
                        } else {
                            if (aVarB.getChannel().position() + ((long) bVar.c.length) > 819200) {
                                c(bVar.a.a);
                                aVarB = b(bVar);
                                if (aVarB == null) {
                                    Log.w("efs.cache", "writer is null for type " + bVar.a.a);
                                }
                            }
                            aVarB.write(Base64.encode(bVar.c, 11));
                            aVarB.write("\n".getBytes());
                        }
                    } catch (Throwable th) {
                        Log.e("efs.cache", "cache file error", th);
                    }
                    break;
                }
                break;
            case 1:
                if (message.obj instanceof String) {
                    c(message.obj.toString());
                }
                break;
        }
    }

    @Override // com.efs.sdk.base.core.b.e
    public final void a(com.efs.sdk.base.core.d.b bVar) {
        Message messageObtain = Message.obtain();
        messageObtain.obj = bVar;
        messageObtain.what = 0;
        sendMessage(messageObtain);
    }

    @Override // com.efs.sdk.base.core.b.e
    public final boolean a(File file, com.efs.sdk.base.core.d.b bVar) throws Throwable {
        if (!bVar.b()) {
            a(file);
            return false;
        }
        if (!file.exists()) {
            return false;
        }
        bVar.d = file;
        bVar.c();
        bVar.b(1);
        return true;
    }

    @Override // com.efs.sdk.base.core.b.e
    public final void a(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.obj = str;
        messageObtain.what = 1;
        sendMessage(messageObtain);
    }

    private static long b(String str) {
        Map<String, String> mapC = com.efs.sdk.base.core.config.a.c.a().c();
        String strConcat = "record_accumulation_time_".concat(String.valueOf(str));
        if (!mapC.containsKey(strConcat)) {
            return 60000L;
        }
        String str2 = mapC.get(strConcat);
        if (TextUtils.isEmpty(str2)) {
            return 60000L;
        }
        try {
            return Math.max(Long.parseLong(str2) * 1000, 1000L);
        } catch (Throwable th) {
            Log.e("efs.cache", "get cache interval error", th);
            return 60000L;
        }
    }

    private a b(com.efs.sdk.base.core.d.b bVar) {
        a aVar;
        Throwable th;
        if (this.a.containsKey(bVar.a.a)) {
            return this.a.get(bVar.a.a);
        }
        File file = new File(com.efs.sdk.base.core.util.a.e(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid()), com.efs.sdk.base.core.util.b.a(bVar));
        try {
            aVar = new a(file);
            try {
                a aVarPutIfAbsent = this.a.putIfAbsent(bVar.a.a, aVar);
                if (aVarPutIfAbsent != null) {
                    com.efs.sdk.base.core.util.b.a(aVar);
                    com.efs.sdk.base.core.util.b.b(file);
                    return aVarPutIfAbsent;
                }
                Message messageObtain = Message.obtain();
                messageObtain.obj = bVar.a.a;
                messageObtain.what = 1;
                sendMessageDelayed(messageObtain, b(bVar.a.a));
                if (!"wa".equalsIgnoreCase(bVar.a.a)) {
                    com.efs.sdk.base.core.f.f.a.a.c.b();
                }
                return aVar;
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
            }
        } catch (Throwable th3) {
            aVar = null;
            th = th3;
        }
    }

    private void c(String str) {
        if (this.a.containsKey(str)) {
            a aVar = this.a.get(str);
            try {
                if (aVar == null) {
                    return;
                }
                aVar.flush();
                com.efs.sdk.base.core.util.b.a(aVar);
                a(aVar.b);
            } catch (Throwable th) {
                th.printStackTrace();
            } finally {
                this.a.remove(str);
                if (!"wa".equalsIgnoreCase(str)) {
                    com.efs.sdk.base.core.f.f.a.a.c.c();
                }
            }
        }
    }

    @Override // com.efs.sdk.base.core.b.e
    public final void a(File file) throws Throwable {
        com.efs.sdk.base.core.d.b bVarB = com.efs.sdk.base.core.util.b.b(file.getName());
        if (bVarB == null) {
            com.efs.sdk.base.core.b.a unused = com.efs.sdk.base.core.b.a.b.a;
            com.efs.sdk.base.core.b.a.b(file);
        } else if (!a(bVarB, file) || bVarB.c == null || bVarB.c.length <= 0) {
            com.efs.sdk.base.core.b.a unused2 = com.efs.sdk.base.core.b.a.b.a;
            com.efs.sdk.base.core.b.a.b(file);
        } else {
            com.efs.sdk.base.core.util.b.a(new File(com.efs.sdk.base.core.util.a.f(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid()), com.efs.sdk.base.core.util.b.a(bVarB)), bVarB.c);
            com.efs.sdk.base.core.util.b.b(file);
        }
    }

    private boolean a(com.efs.sdk.base.core.d.b bVar, File file) throws Throwable {
        FileReader fileReader;
        BufferedReader bufferedReader;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader2 = null;
        try {
            fileReader = new FileReader(file);
            try {
                try {
                    bufferedReader = new BufferedReader(fileReader);
                    try {
                        for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                            String strB = com.efs.sdk.base.core.util.b.b.b(line.getBytes());
                            if (!TextUtils.isEmpty(strB)) {
                                sb.append(strB);
                                sb.append("\n");
                            }
                        }
                        bVar.a(sb.toString().getBytes());
                        bVar.c();
                        this.c.a(bVar);
                        bVar.d = file;
                        com.efs.sdk.base.core.util.b.a(bufferedReader);
                        com.efs.sdk.base.core.util.b.a(fileReader);
                        return true;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader2 = bufferedReader;
                        Log.e("efs.cache", "local decode error", th);
                        com.efs.sdk.base.core.util.b.a(bufferedReader2);
                        com.efs.sdk.base.core.util.b.a(fileReader);
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = bufferedReader2;
            }
        } catch (Throwable th4) {
            th = th4;
            fileReader = null;
            bufferedReader = null;
        }
    }

    static class a extends FileOutputStream {
        long a;
        File b;

        a(@NonNull File file) {
            super(file);
            this.b = file;
            this.a = System.currentTimeMillis();
        }
    }
}
