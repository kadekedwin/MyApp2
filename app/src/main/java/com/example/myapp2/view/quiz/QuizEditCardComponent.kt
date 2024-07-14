package com.example.myapp2.view.quiz

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapp2.R

@Composable
fun QuizEditCardComponent(title: String, questionCount: Int, icon: Int, color: Color, modifier: Modifier = Modifier) {
    var quizOption by remember { mutableStateOf(false) }

    Surface(
        shape = RoundedCornerShape(24.dp),
        border = BorderStroke(width = 1.dp, color = Color.Gray.copy(alpha = 0.5f)),
        color = Color.White,
        modifier = modifier
            .fillMaxWidth(),
        onClick = {

        }
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Surface(
                    modifier = Modifier
                        .size(70.dp)
                        .align(alignment = Alignment.Center),
                    shape = RoundedCornerShape(50),
                    color = color.copy(alpha = 0.15f)

                ) {
                    Image(
                        painter = painterResource(id = icon),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(10.dp)
                    )
                }
                
                IconButton(modifier = Modifier.align(Alignment.TopEnd).offset(20.dp, -20.dp), onClick = {
                    quizOption = !quizOption
                }) {
                    Icon(Icons.Rounded.MoreVert, contentDescription = null)
                }
                DropdownMenu(
                    expanded = quizOption,
                    onDismissRequest = { quizOption = false },
                    offset = DpOffset(0.dp, -40.dp),
                    modifier = Modifier.background(Color.White),
                ) {
                    DropdownMenuItem(
                        text = {
                            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                                Icon(Icons.Rounded.Edit, contentDescription = null)
                                Text("Edit")
                            }
                        },
                        onClick = { /*TODO*/ }
                    )

                    DropdownMenuItem(
                        text = {
                            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                                Icon(Icons.Rounded.Delete, contentDescription = null)
                                Text("Delete")
                            }
                        },
                        onClick = { /*TODO*/ }
                    )
                }
            }

            Text(text = title, maxLines = 1, overflow = TextOverflow.Ellipsis, fontSize = 20.sp, fontWeight = FontWeight.Medium, modifier = Modifier.padding(top = 16.dp))
            Text(text = "$questionCount Question", modifier = Modifier.padding(top = 8.dp))
        }
    }
}

@Preview
@Composable
fun QuizEditCardComponentPreview() {
    QuizEditCardComponent(title = "Testo for quizo", questionCount = 10, icon = R.drawable.stationery, color = Color.Blue)
}