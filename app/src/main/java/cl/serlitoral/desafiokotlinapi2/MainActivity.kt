package cl.serlitoral.desafiokotlinapi2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import cl.serlitoral.desafiokotlinapi2.databinding.ActivityMainBinding
import cl.serlitoral.desafiokotlinapi2.ui.PhotoAdapter
import cl.serlitoral.desafiokotlinapi2.ui.PhotoViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: PhotoViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = PhotoAdapter()
        binding.rvPhotos.adapter = adapter

        viewModel.photoList.observe(this, {
            it?.let {
                adapter.update(it)
            }
        })
    }
}