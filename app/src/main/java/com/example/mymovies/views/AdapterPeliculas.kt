package com.example.mymovies.views

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mymovies.R
import com.example.mymovies.core.Constantes
import com.example.mymovies.models.PeliculaModel

class AdapterPeliculas(
    val context : Context,
    var listaPeliculas: List<PeliculaModel>
): RecyclerView.Adapter<AdapterPeliculas.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val cvPelicula = itemView.findViewById(R.id.cvPelicula) as CardView
        val ivPoster = itemView.findViewById(R.id.ivPoster) as ImageView
        val pcIndicador = itemView.findViewById(R.id.circular_progress) as CircularProgressIndicator
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_pelicula,parent,false)
        return ViewHolder(vista)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pelicula = listaPeliculas[position]
        Glide
            .with(context)
            .load("${Constantes.BASE_URL_IMAGEN}${pelicula.poster}")
            .apply (RequestOptions().override(Constantes.IMAGEN_ANCHO,Constantes.IMAGEN_ALTO) )
            .into(holder.ivPoster)

        holder.pcIndicador.maxProgress = Constantes.MAX_CALIFICACION
        holder.pcIndicador.setCurrentProgress(pelicula.votoPromedio.toDouble())
    }

    override fun getItemCount(): Int {
        return listaPeliculas.size
    }
}