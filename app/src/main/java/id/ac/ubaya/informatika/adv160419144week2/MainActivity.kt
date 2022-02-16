package id.ac.ubaya.informatika.adv160419144week2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {
    //lateinit -> Late Initialization
    //When a non-null initializer can't be supplied in the constructor.
    //But the dev certain that the variable won't be null when accessing it -> avoiding null checks when referencing it later.
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Below is used to initialize the Navigation Controller and associate it with NavHost Object
        navController = (supportFragmentManager.findFragmentById(R.id.hostFragment) as NavHostFragment).navController
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return super.onSupportNavigateUp()
    }
}