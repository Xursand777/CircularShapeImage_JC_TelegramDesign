package com.x7.circularshapeimage_jc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           circularshapeimageview()
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun circularshapeimageview() {
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Box(contentAlignment = Alignment.TopStart, modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)) {
            Row() {
                Icon(imageVector = Icons.Default.Menu,
                    contentDescription = "", modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .size(32.dp)
                )
                Spacer(modifier = Modifier.width(15.dp))
                Text(
                    text = "Telegram",
                    fontSize = 28.sp,
                    fontStyle = FontStyle.Italic
                )
            }

            Row(modifier = Modifier.align(Alignment.CenterEnd)
            ) {
                Icon(imageVector = Icons.Default.Search,
                    contentDescription = "",
                    modifier = Modifier
                        .size(32.dp)

                )
                Spacer(modifier = Modifier.width(15.dp))
                Icon(imageVector = Icons.Default.MoreVert,
                    contentDescription = "",
                    modifier = Modifier
                        .size(32.dp)

                )
            }

        }

        val array = arrayOf(
            User(R.drawable.img,"Xursand","Assalomu Aleykum...","21:00"),
            User(R.drawable.img,"Fourcade","Assalomu Aleykum...","11:00"),
            User(R.drawable.img,"Sanjarbek","Assalomu Aleykum...","17:00"),
            User(R.drawable.img,"Davron","Assalomu Aleykum...","18:00"),
            User(
                circlerimage = R.drawable.img,
                name = "Raquel Webster",
                desc = "maximus",
                time = "reprimique"
            ),
            User(circlerimage = R.drawable.img, name = "Staci Franklin", desc = "erat", time = "adhuc"),
            User(circlerimage = R.drawable.img, name = "Kasey Santana", desc = "liber", time = "consequat"),
            User(circlerimage = R.drawable.img, name = "Ramiro Waters", desc = "tale", time = "eu"),
            User(circlerimage = R.drawable.img, name = "Hilda Mercado", desc = "tristique", time = "dicunt"),
            User(circlerimage = R.drawable.img, name = "James Madden", desc = "quas", time = "aliquid")
        )

        LazyColumn(contentPadding = PaddingValues(10.dp)
        ){
            items(array, key = null){
                lazyitem1(it)
            }

        }


    }


}


@Composable
fun lazyitem1(user: User) {

   Column() {
       Card(modifier = Modifier.padding(3.dp)
           .fillMaxWidth()
           .wrapContentHeight(),
           shape = RoundedCornerShape(8.dp),
           elevation = CardDefaults.cardElevation(
               defaultElevation = 5.dp)
       ){
           Row(modifier = Modifier.fillMaxWidth()) {
               Image(
                   painter = painterResource(id = user.circlerimage),
                   contentDescription ="",
                   modifier = Modifier
                       .size(90.dp)
                       .padding(10.dp)
                       //.clip(CircleShape),
                       .clip(RoundedCornerShape(size = 90.dp))
                       .border(
                           width = 1.dp,
                           color = Color.Magenta,
                           shape = RoundedCornerShape(90.dp)
                       ),
                   contentScale = ContentScale.Crop
               )
               Column(modifier = Modifier
                   .align(Alignment.CenterVertically)
               ) {
                   Text(
                       text = user.name,
                       fontSize = 20.sp,
                   )
                   Text(modifier = Modifier, text = user.desc,
                       fontSize = 20.sp,
                   )
               }
               Text(
                   modifier = Modifier
                       .weight(1f)
                       .padding(10.dp),
                   textAlign = TextAlign.End,
                   text = user.time
               )



           }
       }

   }
}

