package br.com.artpeak

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class TatuagemAdapter(
    val tatuagens: List<Tatuagem>,
    val onClick: (Tatuagem) -> Unit
): RecyclerView.Adapter<TatuagemAdapter.TatuagemViewHolder>() {

    class TatuagemViewHolder(view: View): RecyclerView.ViewHolder(view){
        val cardNome: TextView
        val cardImage: ImageView
        val cardProgress: ProgressBar
        val cardView: CardView

        init {
            cardNome = view.findViewById(R.id.card_nome)
            cardImage = view.findViewById(R.id.card_image)
            cardProgress = view.findViewById(R.id.card_progress)
            cardView = view.findViewById(R.id.card_tatuagem)
        }

    }

    override fun getItemCount() = this.tatuagens.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TatuagemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_tatuagem, parent, false)
        val holder = TatuagemViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: TatuagemViewHolder, position: Int) {
        val context = holder.itemView.context

        val tatuagem = this.tatuagens[position]

        holder.cardNome.text = tatuagem.estilo
        holder.cardProgress.visibility = View.VISIBLE

        Picasso.with(context).load(tatuagem.imagem).fit().into(holder.cardImage,
            object : com.squareup.picasso.Callback{
                override fun onSuccess() {
                    holder.cardProgress.visibility = View.GONE
                }

                override fun onError() {
                    holder.cardProgress.visibility = View.GONE
                }
            }

        )

        holder.itemView.setOnClickListener {onClick(tatuagem)}

    }
}