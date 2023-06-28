package br.edu.utfpr.hotelpet.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.edu.utfpr.hotelpet.databinding.ActivityListaFichasBinding
import br.edu.utfpr.hotelpet.databinding.ActivityListaTutorBinding
import br.edu.utfpr.hotelpet.model.FichaComportamento
import br.edu.utfpr.hotelpet.model.Tutor

class FichaComportamentoAdapter (
    fichas: List<FichaComportamento> = emptyList(),
    private val context: Context,
    var click: (ficha: FichaComportamento) -> Unit = {}
) : RecyclerView.Adapter<FichaComportamentoAdapter.ViewHolder>(){
    private val fichas = fichas.toMutableList()

    inner class ViewHolder(private val binding: ActivityListaFichasBinding):
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var ficha: FichaComportamento
        init {
            itemView.setOnClickListener {
                if (::ficha.isInitialized){
                    click(ficha)
                }
            }
        }

        fun bind(ficha: FichaComportamento){
            this.ficha = ficha
            val localAnimal = binding.localAnimal
            val alimentacaoAnimal = binding.alimentacaoAnimal
            val comportamentoAnimal = binding.comportamento
            val atividadesRealizadas = binding.atividadeRealizadasAnimal
            val saudeAnimal = binding.saudeAnimal

            localAnimal.text = ficha.hospedadoEm
            alimentacaoAnimal.text = ficha.seAlimentaDe
            comportamentoAnimal.text = ficha.comportamento
            atividadesRealizadas.text = ficha.atividades
            saudeAnimal.text = ficha.saudeDoAnimal
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ActivityListaFichasBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = fichas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ficha = fichas[position]
        holder.bind(ficha)
    }

    fun refreshAll(fichas: List<FichaComportamento>) {
        this.fichas.clear()
        this.fichas.addAll(fichas)
        notifyDataSetChanged()
    }

}