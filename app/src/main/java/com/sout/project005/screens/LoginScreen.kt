package com.sout.project005.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sout.project005.R


@Composable
fun LoginScreen(
    onEmailClick: () -> Unit,
    onNumberClick: () -> Unit,
    onGoogleClick: () -> Unit,
    onSignUpClick: () -> Unit,
    ){
    val emailColor = Color(0xFFFFA500)
    val numberColor = Color(0xFF1B1C1E)
    val googleColor = Color(0xFFFF0000)

Box(
    modifier = Modifier
        .fillMaxSize()
        .padding(horizontal=16.dp)
        .systemBarsPadding()
        .navigationBarsPadding()
){
     Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(24.dp))

            Image(
                painter = painterResource(R.drawable.pic_2),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .padding(8.dp)
            )
            Spacer(Modifier.height(8.dp))

            Text(
                text = "Login For Future",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 24.dp, bottom = 36.dp)
            )
            LoadingIconButton(
                text = "Continue With Email",
                iconRes = R.drawable.email,
                containerColor = emailColor,
                onClick = onEmailClick
            )
            Spacer(Modifier.height(12.dp))

            LoadingIconButton(
                text = "Continue With Number",
                iconRes = R.drawable.phone,
                containerColor = numberColor,
                onClick = onNumberClick
            )
            Spacer(Modifier.height(12.dp))

            LoadingIconButton(
                text = "Continue With Google",
                iconRes = R.drawable.google,
                containerColor = googleColor,
                onClick = onGoogleClick
            )
            Spacer(Modifier.height(24.dp))
            Spacer(Modifier.weight(1f))
        }
        val annotated = buildAnnotatedString {
            append("Don't have an account? ")
            pushStringAnnotation(tag = "signup", annotation = "signup")
            withStyle(
                style = SpanStyle
                    (
                    color = Color(0xffff6a2e),
                    fontWeight = FontWeight.Bold
                )
            )
            {
                append("Sign Up")
            }
            pop()
        }

        ClickableText(
            text = annotated,
            onClick = { offset ->
                annotated.getStringAnnotations(
                    tag = "signup", start = offset, end = offset
                ).firstOrNull()?.let {
                    onSignUpClick()
                }
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp)
        )


}
}

@Composable
private fun LoadingIconButton(
    text: String,
    iconRes: Int,
    containerColor: Color,
    onClick: () -> Unit
){
    Button(
        onClick = onClick,
        shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = Color.White
        ), modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
    )    {
            Row(
                verticalAlignment = Alignment.CenterVertically,
horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    painter = painterResource(iconRes),
                    contentDescription = null,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = text,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold)
            }
        }
}



@Composable
@Preview(showBackground = true, backgroundColor = 0xffffff)
private fun
        LoginScreenPreview(){
    MaterialTheme{
        LoginScreen ({}, {}, {}, {})
    }
        }