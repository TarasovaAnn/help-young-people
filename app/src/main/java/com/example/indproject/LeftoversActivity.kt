package com.example.indproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LeftoversActivity : AppCompatActivity() {

    private val recipeStates = mutableMapOf<Int, Boolean>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leftovers)
        var button: Button = findViewById(R.id.back_btn7)
        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Рецепты из остатков"

        setupRecipeAccordion()
    }

    private fun setupRecipeAccordion() {
        val recipes = listOf(
            RecipeItem(R.id.headerOmelette, R.id.expandableOmelette, R.id.arrowOmelette),
            RecipeItem(R.id.headerRice, R.id.expandableRice, R.id.arrowRice),
            RecipeItem(R.id.headerCasserole, R.id.expandableCasserole, R.id.arrowCasserole),
            RecipeItem(R.id.headerPizza, R.id.expandablePizza, R.id.arrowPizza),
            RecipeItem(R.id.headerCutlets, R.id.expandableCutlets, R.id.arrowCutlets),
            RecipeItem(R.id.headerPancakes, R.id.expandablePancakes, R.id.arrowPancakes),
            RecipeItem(R.id.headerSoup, R.id.expandableSoup, R.id.arrowSoup)
        )

        recipes.forEach { recipe ->
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
            collapseRecipe(text, arrow)
        } else {
            expandRecipe(text, arrow)
        }

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

    data class RecipeItem(
        val headerId: Int,
        val textId: Int,
        val arrowId: Int
    )

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}