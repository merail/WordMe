package merail.life.word.navigation.graph

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import merail.life.word.game.GameContainer
import merail.life.word.navigation.domain.NavigationRoute

@Composable
fun WordMeNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = NavigationRoute.Game,
        modifier = modifier,
    ) {
        composable<NavigationRoute.Game> {
            GameContainer()
        }
    }
}