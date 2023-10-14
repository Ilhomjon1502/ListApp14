package uz.ilhomjon.listapp14

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import uz.ilhomjon.listapp14.databinding.ActivityAddBinding
import uz.ilhomjon.listapp14.models.MyContact
import uz.ilhomjon.listapp14.utils.MySharedPreference

class AddActivity : AppCompatActivity() {
    lateinit var binding:ActivityAddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MySharedPreference.init(this)
        val list = MySharedPreference.list

        binding.apply {
            btnSave.setOnClickListener {
                val myContact = MyContact(edtName.text.toString(), edtNumber.text.toString())
                list.add(myContact)
                MySharedPreference.list = list
                Toast.makeText(this@AddActivity, "Saved", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}