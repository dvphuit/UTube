package dvp.app.utube.common

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.DrawModifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.layout.LayoutModifier
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.MeasureResult
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints

@Composable
fun Shimmer(modifier: Modifier) {
    val transition = rememberInfiniteTransition()
    val value by transition.animateFloat(
        initialValue = -.5f,
        targetValue = 1.5f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000),
        )
    )
//
    Box(
        modifier = modifier
            .background(
                Brush.linearGradient(
                    colorStops = arrayOf(
                        value - .5f to Color(0x4cffffff),
                        value to Color(0xFFFFFFFF),
                        value + .5f to Color(0x4cffffff),
                    ),
                )
            )
    )

//    Canvas(modifier = Modifier.fillMaxSize()) {
//        val canvasWidth = size.width
//        val canvasHeight = size.height
//
//
//    }

}

//
//fun Modifier.test():Modifier = composed {
//
//
//}


//class Test:DrawModifier,LayoutModifier{
//    override fun ContentDrawScope.draw() {
//
//    }
//
//    override fun MeasureScope.measure(
//        measurable: Measurable,
//        constraints: Constraints
//    ): MeasureResult {
//
//    }
//
//}

@Preview
@Composable
fun DefaultPreview() {
    Shimmer(modifier = Modifier.fillMaxSize())
}