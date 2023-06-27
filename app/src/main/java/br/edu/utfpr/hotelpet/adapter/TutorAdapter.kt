package br.edu.utfpr.hotelpet.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.edu.utfpr.hotelpet.databinding.ActivityListaTutorBinding
import br.edu.utfpr.hotelpet.model.Tutor

class TutorAdapter(
    tutores: List<Tutor> = emptyList(),
    private val context: Context,
    var click: (tutor: Tutor) -> Unit = {}
) : RecyclerView.Adapter<TutorAdapter.ViewHolder>(){
    private val tutores = tutores.toMutableList()

    inner class ViewHolder(private val binding: ActivityListaTutorBinding):
        RecyclerView.ViewHolder(binding.root) {
            private lateinit var tutor: Tutor
            init {
                itemView.setOnClickListener {
                    if (::tutor.isInitialized){
                        click(tutor)
                    }
                }
            }

            fun bind(tutor: Tutor){
                this.tutor = tutor
                val nome = binding.nome
                val telefone = binding.telefone
                val cpf = binding.cpf
                val endereco = binding.endereco
                val animal = binding.animal

                nome.text = tutor.nome
                telefone.text = tutor.telefone
                cpf.text = tutor.cpf
                endereco.text = tutor.endereco
                animal.text = tutor.animal
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ActivityListaTutorBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = tutores.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tutor = tutores[position]
        holder.bind(tutor)
    }

    fun refreshAll(tutores: List<Tutor>) {
        this.tutores.clear()
        this.tutores.addAll(tutores)
        notifyDataSetChanged()
    }
}