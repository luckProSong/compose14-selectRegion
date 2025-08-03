package com.example.selectregion

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.selectregion.ui.theme.SelectRegionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var showDialog by remember { mutableStateOf(false) }

            SelectRegionButton{
                showDialog = true
            }

            if (showDialog) {
                val context = LocalContext.current
                SelectRegionPopup { selectRegion ->
                    if(selectRegion.isNotEmpty())
                        Toast.makeText(context, selectRegion, Toast.LENGTH_SHORT).show()
                    showDialog = false
                }
            }
        }
    }
}

@Composable
fun SelectRegionButton(onClick: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize(), Alignment.Center) {
        Button(onClick = {
            onClick.invoke()
        }) {
            Text("지역선택")
        }
    }
}