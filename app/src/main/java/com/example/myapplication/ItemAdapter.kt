package com.example.myapplication

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R


class ItemAdapter(val items: ArrayList<ItemModel>): BaseAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var itemView: View
        var viewHolder: ViewHolder

        if (convertView == null) {
            itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.layout_item, parent, false)
            viewHolder = ViewHolder(itemView)
            itemView.tag = viewHolder
        } else {
            itemView = convertView
            viewHolder = itemView.tag as ViewHolder
        }

        viewHolder.name.text = items[position].name
        viewHolder.imageThumb.setImageResource(items[position].imageThumb)
        viewHolder.subject.text = items[position].subject
        viewHolder.time.text = items[position].time
        viewHolder.content.text = items[position].content
        viewHolder.checkSelected.isChecked = items[position].selected

        viewHolder.checkSelected.setOnClickListener {
            items[position].selected = (it as CheckBox).isChecked
            notifyDataSetChanged()
        }

        return itemView
    }

    class ViewHolder(itemView: View) {
        val name: TextView
        val imageThumb: ImageView
        val time: TextView
        val subject: TextView
        val content: TextView
        val checkSelected: CheckBox
        init{
            name = itemView.findViewById(R.id.name)
            imageThumb = itemView.findViewById(R.id.image_thumb)
            time = itemView.findViewById(R.id.time)
            subject = itemView.findViewById(R.id.subject)
            content = itemView.findViewById(R.id.content)
            checkSelected = itemView.findViewById(R.id.check_selected)
        }

    }
}