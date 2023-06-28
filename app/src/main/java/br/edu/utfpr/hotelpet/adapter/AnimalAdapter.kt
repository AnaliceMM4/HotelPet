package br.edu.utfpr.hotelpet.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.edu.utfpr.hotelpet.databinding.ActivityListaAnimalBinding;
import br.edu.utfpr.hotelpet.model.Animal

class AnimalAdapter (
    animais: List<Animal> = emptyList(),
    private val context: Context,
    var click: (animal: Animal) -> Unit = {}
    ) : RecyclerView.Adapter<AnimalAdapter.ViewHolder>(){
        private val animais = animais.toMutableList()

        inner class ViewHolder(private val binding:ActivityListaAnimalBinding):
            RecyclerView.ViewHolder(binding.root) {
            private lateinit var animal: Animal
            init {
                itemView.setOnClickListener {
                    if (::animal.isInitialized){
                        click(animal)
                    }
                }
            }

            fun bind(animal: Animal){
                this.animal = animal
                val nome = binding.nome
                val especie = binding.especie
                val porte = binding.porte
                val andarHospedagem = binding.andarHospedagem
                val servicos = binding.servicos

                nome.text = animal.nome
                especie.text = animal.especie
                porte.text = animal.porte
                andarHospedagem.text = animal.andarHopedagem
                servicos.text = animal.servico
            }
        }


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding = ActivityListaAnimalBinding.inflate(LayoutInflater.from(context), parent, false)
            return ViewHolder(binding)
        }

        override fun getItemCount(): Int = animais.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val animal = animais[position]
            holder.bind(animal)
        }

        fun refreshAll(animais: List<Animal>) {
            this.animais.clear()
            this.animais.addAll(animais)
            notifyDataSetChanged()
        }

}