package uz.ilhomjon.listapp14.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import uz.ilhomjon.listapp14.R
import uz.ilhomjon.listapp14.models.MyContact

class MyContactAdapter(context: Context, val list: ArrayList<MyContact>) : ArrayAdapter<MyContact>(context, android.R.layout.simple_list_item_1, list) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var item:View
        if (convertView==null){
            item = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        }else{
            item = convertView
        }
        item.findViewById<TextView>(R.id.tv_name).text = list[position].name
        item.findViewById<TextView>(R.id.tv_number).text = list[position].number
        return item
    }
}