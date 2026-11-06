package com.tapsdk.tapad.internal.ui.views.permissions;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tapsdk.tapad.R;
import com.tapsdk.tapad.model.entities.PermissionContent;
import com.tapsdk.tapad.model.entities.PermissionDetails;
import com.tapsdk.tapad.model.entities.PermissionGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class PermissionGroupAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<b> dataList = new ArrayList();

    static class b<U> {
        protected int a;
        protected U b;

        private b(int i, U u) {
            this.a = i;
            this.b = u;
        }

        public U a() {
            return this.b;
        }

        public int b() {
            return this.a;
        }
    }

    static class c extends b<Pair<String, String>> {
        private c(int i, Pair<String, String> pair) {
            super(i, pair);
        }

        public static c a(PermissionContent permissionContent) {
            return new c(1, Pair.create(permissionContent.title, permissionContent.description));
        }
    }

    static class d extends RecyclerView.ViewHolder {
        private final TextView a;
        private final TextView b;

        public d(View view) {
            super(view);
            this.a = (TextView) view.findViewById(R.id.permissionContentDescriptionTextView);
            this.b = (TextView) view.findViewById(R.id.permissionContentTitleTextView);
        }
    }

    static class e extends b<String> {
        private e(int i, String str) {
            super(i, str);
        }

        public static e a(String str) {
            return new e(0, str);
        }
    }

    private static class f extends RecyclerView.ViewHolder {
        public final TextView a;

        public f(View view) {
            super(view);
            this.a = (TextView) view.findViewById(R.id.permissionSectionTitleTextView);
        }
    }

    public PermissionGroupAdapter(PermissionGroup permissionGroup, PermissionGroup permissionGroup2, Context context) {
        String str;
        String str2;
        String str3;
        String str4;
        if (checkPermissionValid(permissionGroup)) {
            this.dataList.add(e.a(context.getResources().getString(R.string.tapad_sensitive_permission_title)));
            for (PermissionContent permissionContent : permissionGroup.permissionDetails.permissionContentList) {
                if (permissionContent != null && (str3 = permissionContent.title) != null && str3.length() > 0 && (str4 = permissionContent.description) != null && str4.length() > 0) {
                    this.dataList.add(c.a(permissionContent));
                }
            }
        }
        if (checkPermissionValid(permissionGroup2)) {
            this.dataList.add(e.a(context.getResources().getString(R.string.tapad_general_permission_title)));
            for (PermissionContent permissionContent2 : permissionGroup2.permissionDetails.permissionContentList) {
                if (permissionContent2 != null && (str = permissionContent2.title) != null && str.length() > 0 && (str2 = permissionContent2.description) != null && str2.length() > 0) {
                    this.dataList.add(c.a(permissionContent2));
                }
            }
        }
    }

    private boolean checkPermissionValid(PermissionGroup permissionGroup) {
        PermissionDetails permissionDetails;
        List<PermissionContent> list;
        return (permissionGroup == null || (permissionDetails = permissionGroup.permissionDetails) == null || (list = permissionDetails.permissionContentList) == null || list.size() <= 0) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.dataList.get(i).b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        TextView textView;
        Object obj;
        if (getItemViewType(i) == 0) {
            e eVar = (e) this.dataList.get(i);
            textView = ((f) viewHolder).a;
            obj = eVar.b;
        } else {
            c cVar = (c) this.dataList.get(i);
            d dVar = (d) viewHolder;
            dVar.b.setText((CharSequence) ((Pair) cVar.b).first);
            textView = dVar.a;
            obj = ((Pair) cVar.b).second;
        }
        textView.setText((CharSequence) obj);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 0 ? new f(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tapad_itemview_permission_section_title, viewGroup, false)) : new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tapad_itemview_permission_content, viewGroup, false));
    }

    public void reset() {
        this.dataList.clear();
    }
}
