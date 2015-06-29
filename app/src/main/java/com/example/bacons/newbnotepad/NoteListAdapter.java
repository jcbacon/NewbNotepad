package com.example.bacons.newbnotepad;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NoteListAdapter extends ArrayAdapter<NoteItem>{

    Context context;
    int layoutResourceId;
    NoteItem data[] = null;

    public NoteListAdapter(Context context, int layoutResourceId, NoteItem[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        NoteHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new NoteHolder();
            holder.imgIcon = (ImageView)row.findViewById(R.id.actionEdit);
            holder.txtTitle = (TextView)row.findViewById(R.id.textViewTitle);

            row.setTag(holder);
        }
        else
        {
            holder = (NoteHolder)row.getTag();
        }

        NoteItem note = data[position];
        holder.txtTitle.setText(note.title);
        holder.imgIcon.setImageResource(note.icon);

        return row;
    }

    static class NoteHolder
    {
        ImageView imgIcon;
        TextView txtTitle;
    }
}

