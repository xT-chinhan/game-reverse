package com.mar.sdk.permission.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.mar.sdk.utils.ResourceHelper;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PermissionGridAdapter extends BaseAdapter {
    private List<PermissionItemData> dataList;
    private LayoutInflater inflater;

    public PermissionGridAdapter(Context context, List<PermissionItemData> data) {
        this.dataList = data;
        this.inflater = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.dataList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int index) {
        return this.dataList.get(index);
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = this.inflater.inflate(ResourceHelper.getIdentifier(this.inflater.getContext(), "R.layout.mar_permission_grid_item"), parent, false);
            holder = new ViewHolder();
            holder.permissionImg = (ImageView) ResourceHelper.getViewByParent(convertView, "R.id.mar_permission_item_img");
            holder.permissionName = (TextView) ResourceHelper.getViewByParent(convertView, "R.id.mar_permission_item_name");
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        PermissionItemData item = this.dataList.get(position);
        holder.permissionName.setText(item.name);
        holder.permissionImg.setImageResource(ResourceHelper.getIdentifier(this.inflater.getContext(), item.imgID));
        return convertView;
    }

    public class ViewHolder {
        public ImageView permissionImg;
        public TextView permissionName;

        public ViewHolder() {
        }
    }

    public static class PermissionItemData {
        public String imgID;
        public String name;

        public PermissionItemData() {
        }

        public PermissionItemData(String imgID, String name) {
            this.imgID = imgID;
            this.name = name;
        }
    }
}
