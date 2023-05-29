package com.example.lab_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), OnAnimalClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listOfAnimals = listOf(
            Animal(
                "Білий ведмідь",
                "Великий, білий, Арктика",
                "Білий ведмідь (лат. Ursus maritimus) - це великий хижий ссавець, який зазвичай мешкає в Арктиці. Він відомий своєю білою шерстю, що допомагає йому камуфлюватися серед снігу та льоду. Білі ведмеді мають масивну фізичну будову та сильні лапи, які допомагають їм переміщуватися по льоду. Вони високо спеціалізовані хижаки і полюють на рибу та інших морських ссавців, а також харчуються тюленями і моржами.",
                R.drawable.bear
            ),
            Animal(
                "Леопард",
                "Плямистий хижак, Африка",
                "Леопард (лат. Panthera pardus) - це середнього розміру хижий ссавець з сімейства котових. Характерною особливістю леопарда є його плямиста шкіра, яка надає йому велику перевагу при мимовільному камуфляжі серед різних типів середовища. Леопарди поширені в Африці та певних регіонах Азії, включаючи Індію та Індокитай. Вони є витривалими та спритними мисливцями, здатними пристосуватися до різних умов життя, включаючи ліси, гірські масиви та савани. ",
                R.drawable.leopard
            ),
            Animal(
                "Капібара",
                "Велика, плотна, плазуюча",
                "Капібара (лат. Hydrochoerus hydrochaeris) - це найбільша сучасна гризунова тварина на Землі. Вона має важке тіло, короткі ніжки та велику голову зі щупальцеподібними вусами. Капібари мешкають у вологих місцевостях Південної Америки, таких як болота, річкові долини та лісисті райони. Вони чудово пристосувалися до водного середовища та можуть перебувати під водою протягом тривалого часу.",
                R.drawable.kapibara
            )
        )
        val adapter = AnimalAdapter(listOfAnimals, this)

        findViewById<RecyclerView>(R.id.recyclerView).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            this.adapter = adapter
        }
    }

    override fun onClick(animal: Animal) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(DetailsActivity.CAR_KEY, animal)
        startActivity(intent)
    }
}

interface OnAnimalClickListener {
    fun onClick(animal: Animal)
}