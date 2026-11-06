package com.anythink.core.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.bytedance.pangle.LocalBroadcastManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class m {
    static final int a = 1;
    private static final String b = "InnerBroadcastManager";
    private static final boolean c = false;
    private static final Object i = new Object();
    private static m j;
    private final Context d;
    private final HashMap<BroadcastReceiver, ArrayList<b>> e = new HashMap<>();
    private final HashMap<String, ArrayList<b>> f = new HashMap<>();
    private final ArrayList<a> g = new ArrayList<>();
    private final Handler h;

    private static m a(Context context) {
        m mVar;
        synchronized (i) {
            if (j == null) {
                j = new m(context.getApplicationContext());
            }
            mVar = j;
        }
        return mVar;
    }

    private m(Context context) {
        this.d = context;
        this.h = new Handler(context.getMainLooper()) { // from class: com.anythink.core.common.m.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                if (message.what == 1) {
                    m.this.a();
                } else {
                    super.handleMessage(message);
                }
            }
        };
    }

    private void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.e) {
            b bVar = new b(intentFilter, broadcastReceiver);
            ArrayList<b> arrayList = this.e.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.e.put(broadcastReceiver, arrayList);
            }
            arrayList.add(bVar);
            for (int i2 = 0; i2 < intentFilter.countActions(); i2++) {
                String action = intentFilter.getAction(i2);
                ArrayList<b> arrayList2 = this.f.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.f.put(action, arrayList2);
                }
                arrayList2.add(bVar);
            }
        }
    }

    private void a(BroadcastReceiver broadcastReceiver) {
        synchronized (this.e) {
            ArrayList<b> arrayListRemove = this.e.remove(broadcastReceiver);
            if (arrayListRemove != null) {
                for (int size = arrayListRemove.size() - 1; size >= 0; size--) {
                    b bVar = arrayListRemove.get(size);
                    bVar.d = true;
                    for (int i2 = 0; i2 < bVar.a.countActions(); i2++) {
                        String action = bVar.a.getAction(i2);
                        ArrayList<b> arrayList = this.f.get(action);
                        if (arrayList != null) {
                            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                                b bVar2 = arrayList.get(size2);
                                if (bVar2.b == broadcastReceiver) {
                                    bVar2.d = true;
                                    arrayList.remove(size2);
                                }
                            }
                            if (arrayList.size() <= 0) {
                                this.f.remove(action);
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean a(Intent intent) {
        int i2;
        String str;
        ArrayList arrayList;
        ArrayList<b> arrayList2;
        String str2;
        String str3;
        synchronized (this.e) {
            String action = intent.getAction();
            String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.d.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                Log.v(LocalBroadcastManager.TAG, "Resolving type " + strResolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<b> arrayList3 = this.f.get(intent.getAction());
            if (arrayList3 != null) {
                if (z) {
                    Log.v(LocalBroadcastManager.TAG, "Action list: ".concat(String.valueOf(arrayList3)));
                }
                ArrayList arrayList4 = null;
                int i3 = 0;
                while (i3 < arrayList3.size()) {
                    b bVar = arrayList3.get(i3);
                    if (z) {
                        Log.v(LocalBroadcastManager.TAG, "Matching against filter " + bVar.a);
                    }
                    if (bVar.c) {
                        if (z) {
                            Log.v(LocalBroadcastManager.TAG, "  Filter's target already added");
                        }
                        i2 = i3;
                        arrayList2 = arrayList3;
                        str = action;
                        str2 = strResolveTypeIfNeeded;
                        arrayList = arrayList4;
                    } else {
                        i2 = i3;
                        str = action;
                        arrayList = arrayList4;
                        arrayList2 = arrayList3;
                        str2 = strResolveTypeIfNeeded;
                        int iMatch = bVar.a.match(action, strResolveTypeIfNeeded, scheme, data, categories, LocalBroadcastManager.TAG);
                        if (iMatch >= 0) {
                            if (z) {
                                Log.v(LocalBroadcastManager.TAG, "  Filter matched!  match=0x" + Integer.toHexString(iMatch));
                            }
                            arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList4.add(bVar);
                            bVar.c = true;
                        } else if (z) {
                            if (iMatch == -4) {
                                str3 = "category";
                            } else if (iMatch == -3) {
                                str3 = "action";
                            } else if (iMatch != -2) {
                                str3 = iMatch != -1 ? "unknown reason" : "type";
                            } else {
                                str3 = com.anythink.core.common.l.f.R;
                            }
                            Log.v(LocalBroadcastManager.TAG, "  Filter did not match: ".concat(str3));
                        }
                        i3 = i2 + 1;
                        action = str;
                        arrayList3 = arrayList2;
                        strResolveTypeIfNeeded = str2;
                    }
                    arrayList4 = arrayList;
                    i3 = i2 + 1;
                    action = str;
                    arrayList3 = arrayList2;
                    strResolveTypeIfNeeded = str2;
                }
                ArrayList arrayList5 = arrayList4;
                if (arrayList5 != null) {
                    for (int i4 = 0; i4 < arrayList5.size(); i4++) {
                        ((b) arrayList5.get(i4)).c = false;
                    }
                    this.g.add(new a(intent, arrayList5));
                    if (!this.h.hasMessages(1)) {
                        this.h.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    private void b(Intent intent) {
        if (a(intent)) {
            a();
        }
    }

    final void a() {
        int size;
        a[] aVarArr;
        while (true) {
            synchronized (this.e) {
                size = this.g.size();
                if (size <= 0) {
                    return;
                }
                aVarArr = new a[size];
                this.g.toArray(aVarArr);
                this.g.clear();
            }
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = aVarArr[i2];
                int size2 = aVar.b.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    b bVar = aVar.b.get(i3);
                    if (!bVar.d) {
                        bVar.b.onReceive(this.d, aVar.a);
                    }
                }
            }
        }
    }

    private static final class a {
        final Intent a;
        final ArrayList<b> b;

        a(Intent intent, ArrayList<b> arrayList) {
            this.a = intent;
            this.b = arrayList;
        }
    }

    private static final class b {
        final IntentFilter a;
        final BroadcastReceiver b;
        boolean c;
        boolean d;

        b(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.a = intentFilter;
            this.b = broadcastReceiver;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.b);
            sb.append(" filter=");
            sb.append(this.a);
            if (this.d) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }
}
