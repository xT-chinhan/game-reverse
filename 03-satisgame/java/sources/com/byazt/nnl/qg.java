package com.byazt.nnl;

import android.app.Dialog;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import com.byazt.fvm.w;
import java.lang.reflect.Field;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 720, 26})
public class qg {
    public final com.byazt.oj.qg n;
    public n qg;

    public interface n {
        void n(w wVar);
    }

    public qg(com.byazt.oj.qg qgVar) {
        this.n = qgVar;
    }

    public void n(w wVar) {
        if (this.n != null && wVar != null) {
            com.byazt.nnl.n.n().n(this.n, wVar);
        }
        n nVar = this.qg;
        if (nVar != null) {
            nVar.n(wVar);
        }
    }

    public static final void n(com.byazt.oj.qg qgVar, Dialog dialog, Integer[] numArr) {
        n(qgVar, dialog, numArr, null);
    }

    public static final void n(com.byazt.oj.qg qgVar, Dialog dialog, Integer[] numArr, n nVar) {
        if (numArr == null || numArr.length <= 0) {
            return;
        }
        qg qgVar2 = new qg(qgVar);
        qgVar2.qg = nVar;
        for (Integer num : numArr) {
            View viewFindViewById = dialog.findViewById(num.intValue());
            if (viewFindViewById instanceof ListView) {
                ListView listView = (ListView) viewFindViewById;
                listView.setOnItemClickListener(new C0267qg(listView.getOnItemClickListener(), qgVar2));
            }
        }
    }

    /* JADX INFO: renamed from: com.byazt.nnl.qg$qg, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 720, 201})
    private static final class C0267qg implements AdapterView.OnItemClickListener {
        public final qg n;
        public final AdapterView.OnItemClickListener qg;

        private C0267qg(AdapterView.OnItemClickListener onItemClickListener, qg qgVar) {
            this.n = qgVar;
            this.qg = onItemClickListener;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Adapter adapter = adapterView.getAdapter();
            if (adapter != null) {
                Object item = adapter.getItem(i);
                if (item instanceof Function) {
                    this.n.n(n(item));
                }
            }
            AdapterView.OnItemClickListener onItemClickListener = this.qg;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(adapterView, view, i, j);
            }
        }

        private com.byazt.oj.s n(Object obj) {
            if (obj == null) {
                return null;
            }
            Field[] declaredFields = obj.getClass().getDeclaredFields();
            for (int i = 0; i < declaredFields.length; i++) {
                try {
                    declaredFields[i].setAccessible(true);
                    Object obj2 = declaredFields[i].get(obj);
                    if (obj2 instanceof w) {
                        return new com.byazt.oj.s(((w) obj2).n(), ((w) obj2).qg());
                    }
                    continue;
                } catch (Exception unused) {
                }
            }
            return null;
        }
    }
}
