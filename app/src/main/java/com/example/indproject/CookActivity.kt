package com.example.indproject

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CookActivity : AppCompatActivity() {
    private val recipeStates = mutableMapOf<Int, Boolean>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cook) // обрати внимание на название файла!

        setupRecipeAccordion()
    }

    private fun setupRecipeAccordion() {
        // Список всех рецептов
        val recipes = listOf(
            RecipeItem(R.id.headerEggs, R.id.expandableEggs, R.id.arrowEggs),
            RecipeItem(R.id.headerPasta, R.id.expandablePasta, R.id.arrowPasta),
            RecipeItem(R.id.headerChicken, R.id.expandableChicken, R.id.arrowChicken),
            RecipeItem(R.id.headerPotato, R.id.expandablePotato, R.id.arrowPotato)
        )

        // Настраиваем клики для каждого рецепта
        recipes.forEach { recipe ->
            // Изначально все рецепты свернуты
            recipeStates[recipe.headerId] = false

            val header = findViewById<View>(recipe.headerId)
            val text = findViewById<TextView>(recipe.textId)
            val arrow = findViewById<ImageView>(recipe.arrowId)

            header.setOnClickListener {
                toggleRecipe(recipe, text, arrow)
            }
        }
    }

    private fun toggleRecipe(recipe: RecipeItem, text: TextView, arrow: ImageView) {
        val isCurrentlyExpanded = recipeStates[recipe.headerId] == true

        if (isCurrentlyExpanded) {
            // Скрываем рецепт с анимацией
            collapseRecipe(text, arrow)
        } else {
            // Показываем рецепт с анимацией
            expandRecipe(text, arrow)
        }

        // Обновляем состояние
        recipeStates[recipe.headerId] = !isCurrentlyExpanded
    }

    private fun expandRecipe(text: TextView, arrow: ImageView) {
        text.visibility = View.VISIBLE
        text.startAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in))
        arrow.animate().rotation(180f).setDuration(300).start()
    }

    private fun collapseRecipe(text: TextView, arrow: ImageView) {
        text.startAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out))
        text.visibility = View.GONE
        arrow.animate().rotation(0f).setDuration(300).start()
    }

    // Data class для хранения информации о рецепте
    data class RecipeItem(
        val headerId: Int,
        val textId: Int,
        val arrowId: Int
    )
}