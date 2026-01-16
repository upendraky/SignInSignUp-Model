package com.sout.project005.navigation

sealed class Screen (val route : String){
    data object Splash : Screen("Splash")
    data object LoginOptions : Screen("login_options")
    data object SignIn : Screen("sign_in")
    data object SignUp : Screen("sign_up")
    data object Profile : Screen("profile")

}