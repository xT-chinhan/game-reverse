package com.efs.sdk.base.core.c;

import android.os.Handler;
import android.os.Message;
import com.efs.sdk.base.core.b.h;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.efs.sdk.base.core.util.concurrent.WorkThreadUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends Handler {
    public int a;
    public c b;
    private c c;
    private List<String> d;
    private AtomicInteger e;
    private com.efs.sdk.base.core.b.f f;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        super(com.efs.sdk.base.core.util.concurrent.a.a.getLooper());
        this.a = 5;
        this.d = new ArrayList();
        this.e = new AtomicInteger(0);
        this.b = new com.efs.sdk.base.core.c.a();
        this.c = new com.efs.sdk.base.core.f.e();
        this.f = new h();
    }

    static class a {
        private static final d a = new d(0);
    }

    public static d a() {
        return a.a;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        List<File> listEmptyList;
        int iIncrementAndGet;
        super.handleMessage(message);
        if (!f.a.a.a()) {
            return;
        }
        switch (message.what) {
            case 0:
                String strA = com.efs.sdk.base.core.config.b.a.a.a();
                if (NetworkUtil.NETWORK_CLASS_DENIED.equalsIgnoreCase(strA) || NetworkUtil.NETWORK_CLASS_DISCONNECTED.equalsIgnoreCase(strA)) {
                    Log.i("efs.send_log", "log cann't be send because net status is ".concat(String.valueOf(strA)));
                    sendEmptyMessageDelayed(0, ControllerCenter.getGlobalEnvStruct().getLogSendIntervalMills());
                } else {
                    List<com.efs.sdk.base.core.d.b> listEmptyList2 = Collections.emptyList();
                    try {
                        com.efs.sdk.base.core.b.a aVar = com.efs.sdk.base.core.b.a.b.a;
                        int i = this.a;
                        com.efs.sdk.base.core.b.f fVar = this.f;
                        aVar.a();
                        aVar.a();
                        File fileF = com.efs.sdk.base.core.util.a.f(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
                        if (!fileF.exists()) {
                            listEmptyList = Collections.emptyList();
                        } else {
                            List<File> listD = com.efs.sdk.base.core.util.b.d(fileF);
                            if (aVar.b) {
                                com.efs.sdk.base.core.f.f fVar2 = com.efs.sdk.base.core.f.f.a.a;
                                int size = listD.size();
                                if (fVar2.b != null && ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
                                    com.efs.sdk.base.core.f.b bVar = new com.efs.sdk.base.core.f.b("efs_core", "log_lag", fVar2.a.c);
                                    bVar.put("cnt", Integer.valueOf(size));
                                    fVar2.b.send(bVar);
                                }
                                aVar.b = false;
                            }
                            Collections.sort(listD, aVar.d);
                            ArrayList arrayList = new ArrayList(i);
                            for (int size2 = listD.size() - 1; size2 >= 0 && arrayList.size() < i; size2--) {
                                File file = listD.get(size2);
                                if (file.exists() && (fVar == null || !fVar.a(file))) {
                                    arrayList.add(file);
                                }
                            }
                            listEmptyList = arrayList;
                        }
                        ArrayList arrayList2 = new ArrayList(i);
                        for (File file2 : listEmptyList) {
                            com.efs.sdk.base.core.d.b bVarA = aVar.a(file2);
                            if (bVarA == null) {
                                Log.w("efs.cache", "file upload error, name is " + file2.getName());
                            } else {
                                arrayList2.add(bVarA);
                            }
                            break;
                        }
                        listEmptyList2 = arrayList2;
                    } catch (Throwable th) {
                    }
                    for (com.efs.sdk.base.core.d.b bVar2 : listEmptyList2) {
                        if ("wa".equals(bVar2.a.a) || b.a().a(bVar2.a.a, bVar2.a())) {
                            c cVar = this.b;
                            if ("wa".equals(bVar2.a.a)) {
                                cVar = this.c;
                            }
                            String string = UUID.randomUUID().toString();
                            this.d.add(string);
                            if (WorkThreadUtil.submit(new e(bVar2, cVar, string)) == null) {
                                a(string, -1);
                            }
                        }
                    }
                    if (this.d.size() <= 0) {
                        sendEmptyMessageDelayed(0, ControllerCenter.getGlobalEnvStruct().getLogSendIntervalMills());
                    }
                }
                break;
            case 1:
                Object obj = message.obj;
                if (obj != null) {
                    this.d.remove(obj.toString());
                }
                if (message.arg1 != 0) {
                    iIncrementAndGet = this.e.incrementAndGet();
                } else {
                    iIncrementAndGet = 0;
                }
                if (this.d.isEmpty()) {
                    if (iIncrementAndGet < 5) {
                        sendEmptyMessage(0);
                    } else {
                        this.e.set(0);
                        sendEmptyMessageDelayed(0, ControllerCenter.getGlobalEnvStruct().getLogSendDelayMills());
                        Log.i("efs.send_log", "request error cnt gt 5, next request delay 10s");
                    }
                }
                break;
        }
    }

    final void a(Object obj, int i) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        messageObtain.obj = obj;
        messageObtain.arg1 = i;
        sendMessage(messageObtain);
    }
}
