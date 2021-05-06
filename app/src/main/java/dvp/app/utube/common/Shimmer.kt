package dvp.app.utube.common

import android.util.Log
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.DrawModifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.layout.LayoutModifier
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.MeasureResult
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp

enum class State {
    Start, End
}

@Composable
fun ShimmerWrapper(content: @Composable BoxScope.() -> Unit) {
    val transition = rememberInfiniteTransition()
    val value by transition.animateFloat(
        initialValue = -.5f,
        targetValue = 1.5f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000),
        )
    )
    // UI tree
    

    content(){
        Box(
            modifier = Modifier
                .shimmer(0f, State.Start)
        )
    }
}

fun Modifier.shimmer(value: Float, state: State) = this.then(Shimmer(value, state))

fun Modifier.shimmer(state: State): Modifier = composed {
    val transition = rememberInfiniteTransition()
    val value by transition.animateFloat(
        initialValue = -.5f,
        targetValue = 1.5f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000),
        )
    )
    val ret = remember(value, state) { Shimmer(value, State.Start) }
    ret
}


internal class Shimmer(private val value: Float, private val state: State) : DrawModifier,
    LayoutModifier {

    private val srcPaint = Paint()

    private val dstPaint = Paint().apply {
        isAntiAlias = true
        blendMode = BlendMode.SrcIn
    }

    override fun ContentDrawScope.draw() {
        drawIntoCanvas {
            it.withSaveLayer(Rect(0f, 0f, size.width, size.height), paint = srcPaint) {
                drawContent()
                if (state == State.Start) drawDst(it, size)
            }
        }
    }

    private fun drawDst(canvas: Canvas, size: Size) {
        canvas.drawRect(Rect(0f, 0f, size.width, size.height), dstPaint)
    }

    override fun MeasureScope.measure(
        measurable: Measurable,
        constraints: Constraints
    ): MeasureResult {
        val placeable = measurable.measure(constraints)
        dstPaint.shader = LinearGradientShader(
            from = Offset.Zero,
            to = Offset(placeable.width.toFloat(), placeable.height.toFloat()),
            colors = listOf(Color(0xFFE2E2E2), Color(0xFFFFFFFF), Color(0xFFE2E2E2)),
            colorStops = listOf(value - .3f, value, value + .3f)
        )
        return layout(placeable.width, placeable.height) {
            placeable.place(0, 0)
        }
    }
}


@Composable
private fun Demo(modifier: Modifier) {
    Box(
        modifier = modifier
            .shimmer(State.Start)
    ) {

        Column {
            Box(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()
                    .height(200.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row {
                Box(
                    modifier = Modifier
                        .background(Color.White)
                        .width(50.dp)
                        .height(50.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Box(
                        modifier = Modifier
                            .background(Color.White)
                            .fillMaxWidth()
                            .height(20.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Box(
                        modifier = Modifier
                            .background(Color.White)
                            .width(150.dp)
                            .height(20.dp)
                    )
                }
            }
        }
    }
}

@Preview(device = Devices.DEFAULT, backgroundColor = 0xFFFFFFFF)
@Composable
fun DefaultPreview() {
    Demo(modifier = Modifier.fillMaxSize())
}

