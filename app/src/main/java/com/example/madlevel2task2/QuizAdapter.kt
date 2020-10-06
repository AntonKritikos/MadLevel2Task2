package com.example.madlevel2task2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel2task2.databinding.QuestionsBinding

class QuizAdapter(private val questions: List<Quiz>) : RecyclerView.Adapter<QuizAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding = QuestionsBinding.bind(itemView)

        fun bind(question: Quiz) {
            binding.textView3.text = question.question
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.questions, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return questions.size
    }

    override fun onBindViewHolder(holder: QuizAdapter.ViewHolder, position: Int) {
        holder.bind(questions[position])
    }
}