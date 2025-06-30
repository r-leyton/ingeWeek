package com.example.ingeweek

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.media3.common.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.R.layout
import com.example.ingeweek.R.layout.item_agenda

class AgendaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_agenda, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewAgenda)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = AgendaAdapter(getAgendaData()) // Asegúrate de que getAgendaData() devuelva datos
        return view
    }

    private fun getAgendaData(): List<AgendaItem> {
        val data = listOf(
            AgendaItem("02 Jun", "Inauguración - 9:00 AM", "Auditorio Principal"),
            AgendaItem("03 Jun", "Seminario de Innovación - 10:00 AM", "Sala 1"),
            AgendaItem("02 Jun", "Inauguración - 9:00 AM", "Auditorio Principal"),
            AgendaItem("03 Jun", "Seminario de Innovación - 10:00 AM", "Sala 1"),
            AgendaItem("02 Jun", "Inauguración - 9:00 AM", "Auditorio Principal"),
            AgendaItem("03 Jun", "Seminario de Innovación - 10:00 AM", "Sala 1"),
            AgendaItem("02 Jun", "Inauguración - 9:00 AM", "Auditorio Principal"),
            AgendaItem("03 Jun", "Seminario de Innovación - 10:00 AM", "Sala 1"),
            AgendaItem("02 Jun", "Inauguración - 9:00 AM", "Auditorio Principal"),
            AgendaItem("03 Jun", "Seminario de Innovación - 10:00 AM", "Sala 1"),
            AgendaItem("02 Jun", "Inauguración - 9:00 AM", "Auditorio Principal"),
            AgendaItem("03 Jun", "Seminario de Innovación - 10:00 AM", "Sala 1"),
            AgendaItem("02 Jun", "Inauguración - 9:00 AM", "Auditorio Principal"),
            AgendaItem("03 Jun", "Seminario de Innovación - 10:00 AM", "Sala 1"),
            AgendaItem("02 Jun", "Inauguración - 9:00 AM", "Auditorio Principal"),
            AgendaItem("03 Jun", "Seminario de Innovación - 10:00 AM", "Sala 1"),
            AgendaItem("02 Jun", "Inauguración - 9:00 AM", "Auditorio Principal"),
            AgendaItem("03 Jun", "Seminario de Innovación - 10:00 AM", "Sala 1"),
            AgendaItem("02 Jun", "Inauguración - 9:00 AM", "Auditorio Principal"),
            AgendaItem("03 Jun", "Seminario de Innovación - 10:00 AM", "Sala 1")

        )
        Log.d("AgendaFragment", "Datos cargados: ${data.size} items")
        return data
    }
}

data class AgendaItem(val date: String, val event: String, val location: String)

class AgendaAdapter(private val data: List<AgendaItem>) :
    RecyclerView.Adapter<AgendaAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvDate: TextView = itemView.findViewById(R.id.tvDate)
        private val tvEvent: TextView = itemView.findViewById(R.id.tvEvent)
        private val tvLocation: TextView = itemView.findViewById(R.id.tvLocation)

        fun bind(item: AgendaItem) {
            tvDate.text = item.date
            tvEvent.text = item.event
            tvLocation.text = item.location
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_agenda, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size
}