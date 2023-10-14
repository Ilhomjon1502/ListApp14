package uz.ilhomjon.listapp14

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.ilhomjon.listapp14.adapter.MyContactAdapter
import uz.ilhomjon.listapp14.databinding.ActivityShowBinding
import uz.ilhomjon.listapp14.utils.MySharedPreference

class ShowActivity : AppCompatActivity() {
    lateinit var binding: ActivityShowBinding
    lateinit var myContactAdapter: MyContactAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MySharedPreference.init(this)
    }

    override fun onResume() {
        super.onResume()
        val list = MySharedPreference.list
        myContactAdapter = MyContactAdapter(this, list)
        binding.listView.adapter = myContactAdapter
        binding.listView.setOnItemClickListener { parent, view, position, id ->
            val number = list[position].number
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$number")
            startActivity(intent)
        }
    }
}