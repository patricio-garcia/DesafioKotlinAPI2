package cl.serlitoral.desafiokotlinapi2.ui

import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.serlitoral.desafiokotlinapi2.data.mapDB2API
import cl.serlitoral.desafiokotlinapi2.domain.Repo
import kotlinx.coroutines.launch

class PhotoViewModel: ViewModel() {

    private val repo = Repo()

    val photoList = Transformations.map(repo.photoList) { entities ->
        entities.map { mapDB2API(it) }
    }

    init {
        viewModelScope.launch {
            repo.loadFromApi2DB()
        }
    }
}