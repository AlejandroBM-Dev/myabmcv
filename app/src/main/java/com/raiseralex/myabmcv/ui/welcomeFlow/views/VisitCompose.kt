package com.raiseralex.myabmcv.ui.welcomeFlow.views

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.raiseralex.myabmcv.ui.shareViews.TypewriterText
import com.raiseralex.myabmcv.ui.welcomeFlow.data.getMockupList
import com.raiseralex.myabmcv.ui.welcomeFlow.views.shareviews.NextButton
import kotlin.math.absoluteValue

@Preview(showBackground = true)
@Composable
private fun Preview() {
    VisitCompose(
        Modifier,
        onNextButton = {},
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VisitCompose(
    modifier: Modifier,
    onNextButton: () -> Unit,
) {
    val listImage = getMockupList()

    val pagerState = rememberPagerState(pageCount = {
        listImage.size
    })
    Column(
        modifier = modifier
            .padding(5.dp)
            .fillMaxHeight(1f)
            .fillMaxWidth(1f),
    ) {
        VisitorPager(
            modifier,
            pagerState,
        )
        Spacer(modifier = modifier.weight(1f))
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.End,
        ) {
            NextButton(modifier = modifier, onNextButton)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VisitorPager(
    modifier: Modifier,
    pagerState: PagerState,
) {
    HorizontalPager(state = pagerState) { page ->
        Card(
            Modifier
                .fillMaxWidth()
                .height(180.dp)
                .graphicsLayer {
                    val pageOffset = (
                        (pagerState.currentPage - page) + pagerState
                            .currentPageOffsetFraction
                        ).absoluteValue

                    alpha = lerp(
                        start = 0.5f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f),
                    )
                },
        ) {
            TypewriterText(texts = stringResource(id = getMockupList()[pagerState.currentPage].title))
            Spacer(modifier = modifier.size(1.dp))
            Image(
                painter = painterResource(id = getMockupList()[pagerState.currentPage].id),
                contentDescription = stringResource(id = getMockupList()[pagerState.currentPage].description),
                contentScale = ContentScale.FillWidth,
                modifier = modifier
                    .fillMaxWidth(),
            )
            // Card content
        }
    }
    PagerIndicator(
        pageCount = pagerState.pageCount,
        currentPage = pagerState.currentPage,
        targetPage = pagerState.targetPage,
        currentPageOffsetFraction = pagerState.currentPageOffsetFraction,
    )
}

@Composable
private fun PagerIndicator(
    pageCount: Int,
    currentPage: Int,
    targetPage: Int,
    currentPageOffsetFraction: Float,
    modifier: Modifier = Modifier,
    indicatorColor: Color = Color.White,
    unselectedIndicatorSize: Dp = 8.dp,
    selectedIndicatorSize: Dp = 10.dp,
    indicatorCornerRadius: Dp = 2.dp,
    indicatorPadding: Dp = 2.dp,
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .height(selectedIndicatorSize + indicatorPadding * 2),
    ) {
        repeat(pageCount) { page ->
            val (color, size) =
                if (currentPage == page || targetPage == page) {
                    val pageOffset =
                        ((currentPage - page) + currentPageOffsetFraction).absoluteValue
                    val offsetPercentage = 1f - pageOffset.coerceIn(0f, 1f)

                    val size =
                        unselectedIndicatorSize + ((selectedIndicatorSize - unselectedIndicatorSize) * offsetPercentage)

                    indicatorColor.copy(
                        alpha = offsetPercentage,
                    ) to size
                } else {
                    indicatorColor.copy(alpha = 0.1f) to unselectedIndicatorSize
                }

            Box(
                modifier = Modifier
                    .padding(
                        horizontal = ((selectedIndicatorSize + indicatorPadding * 2) - size) / 2,
                        vertical = size / 4,
                    )
                    .clip(RoundedCornerShape(indicatorCornerRadius))
                    .background(color)
                    .width(size)
                    .height(size / 2),
            )
        }
    }
}
