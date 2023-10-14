package uz.ilhomjon.listapp14.utils

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import uz.ilhomjon.listapp14.models.MyContact

object MySharedPreference {
    private const val NAME = "catch_file_name"
    private const val MODE = Context.MODE_PRIVATE

    private lateinit var preferences: SharedPreferences

    fun init(context: Context){
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation:(SharedPreferences.Editor) -> Unit){
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var list:ArrayList<MyContact>
        get() = gsonStringToList( preferences.getString("list_key", "[]")!!)
        set(value) = preferences.edit{
            if (value!=null){
                it.putString("list_key", listToJson(value))
            }
        }

    private fun listToJson(list:ArrayList<MyContact>):String{
        return Gson().toJson(list)
    }

    private fun gsonStringToList(gsonString:String):ArrayList<MyContact>{
        val list = ArrayList<MyContact>()
        val type = object : TypeToken<ArrayList<MyContact>>(){}.type
        list.addAll(Gson().fromJson(gsonString, type))
        return list
    }


}