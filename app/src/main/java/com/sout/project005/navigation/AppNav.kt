package com.sout.project005.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sout.project005.auth.AuthViewModel
import com.sout.project005.screens.LoginScreen
import com.sout.project005.screens.SplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sout.project005.screens.AuthMode
import com.sout.project005.screens.ProfileScreen
import com.sout.project005.screens.SignInScreen

@Composable
fun AppNav (vm : AuthViewModel = viewModel()) {
    val nav = rememberNavController()
    val state by vm.uiState.collectAsState()

    NavHost(navController = nav, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) {
            SplashScreen(
                onLogin = { nav.navigate(Screen.LoginOptions.route) },
                onSignUp = { nav.navigate(Screen.SignUp.route) },
            )
        }
        composable(Screen.LoginOptions.route) {
            LoginScreen(
                onEmailClick = { nav.navigate(Screen.SignIn.route) },
                onNumberClick = {},
                onGoogleClick = {},
                onSignUpClick = {nav.navigate(Screen.SignUp.route)}
            )}
        composable(Screen.SignIn.route) {
            SignInScreen(
                mode = AuthMode.SignIn,
                onPrimary = { email,pass -> vm.signIn(email,pass) },
                onForgotPassword = {},
                onForgotNumber = {},
                onSwitch = { nav.navigate(Screen.SignUp.route) }
            )
            LaunchedEffect(state.user) {if(state.user !=null) gotoProfile(nav) }
        }


        composable(Screen.SignUp.route) {
            SignInScreen(
                mode = AuthMode.SignUp,
                onPrimary = { email,pass -> vm.signUp(email,pass) },
                onSwitch = { nav.navigate(Screen.SignIn.route) }
            )
            LaunchedEffect(state.user) {if(state.user !=null) gotoProfile(nav) }
        }

        composable (Screen.Profile.route){
            ProfileScreen(
                onNotificaion = {},
                onCalendar = {}, onGallery = {}, onPlaylist = {}, onShare = {},
                onLogout = {
                    vm.signOut()
                    nav.navigate(Screen.Splash.route){
                        popUpTo(Screen.Profile.route){
                            inclusive = true
                        }
                    }
                },

            )
        }



    }
}
private fun gotoProfile(nav: NavHostController){
    nav.navigate(Screen.Profile.route)
    {
        popUpTo(Screen.Splash.route){
            inclusive = true
        }
        launchSingleTop = true
    }
}
