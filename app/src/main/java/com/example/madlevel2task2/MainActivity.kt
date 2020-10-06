package com.example.madlevel2task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.madlevel2task2.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    val quizVragen = arrayListOf<Quiz>();
    val quizAdapter = QuizAdapter(quizVragen);
    private lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        binding.recyleview.layoutManager = StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL)
        binding.recyleview.adapter = quizAdapter;

        for (i in Quiz.QUIZ_QUESTIONS.indices) {
            quizVragen.add(Quiz(Quiz.QUIZ_QUESTIONS[i],Quiz.QUIZ_ANSWERS[i]))
        }

        itemTouchHelper().attachToRecyclerView(binding.recyleview)
    }

    private fun itemTouchHelper(): ItemTouchHelper {
        val itemTouchHelperCallback =
            object :
                ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return false
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val position = viewHolder.adapterPosition
                    val selectedQuestion: Quiz = quizVragen[position]
                    var selectedAnswer: Boolean = false;

                    if (direction == ItemTouchHelper.RIGHT) {
                        selectedAnswer = true;
                    }
                    quizVragen.removeAt(position)
                    if (selectedQuestion.answer == selectedAnswer) {
                        Snackbar.make(binding.recyleview, getString(R.string.correct), Snackbar.LENGTH_SHORT).show()
                    }
                    else {
                        Snackbar.make(binding.recyleview, getString(R.string.wrong), Snackbar.LENGTH_SHORT).show()
                    }
                    quizAdapter.notifyDataSetChanged()
                }

            }

        return ItemTouchHelper(itemTouchHelperCallback)
    }
}