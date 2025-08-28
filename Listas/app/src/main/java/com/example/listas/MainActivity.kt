package com.example.listas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.listas.ui.theme.ListasTheme

data class Contact(
    val id: Int,
    val name: String,
    val lastName: String,
    val phone: String,
    val image: Int
)

class DashboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ListasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ContactList(
                        contacts = getContactList(),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ContactItem(contact: Contact, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        // Imagen de perfil circular
        Image(
            painter = painterResource(id = contact.image),
            contentDescription = "Imagen de perfil",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(12.dp))

        // Nombre y teléfono
        Column {
            Text(
                text = "${contact.name} ${contact.lastName}",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = contact.phone,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
    Divider()
}

@Composable
fun ContactList(contacts: List<Contact>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.fillMaxWidth()) {
        items(contacts) { contact ->
            ContactItem(contact = contact)
        }
    }
}

fun getContactList(): List<Contact> {
    return listOf(
        Contact(1, "Ana", "Pérez", "123456789", R.drawable.imagen),
        Contact(2, "Juan", "Gómez", "987654321", R.drawable.imagen),
        Contact(3, "Pedro", "López", "456789123", R.drawable.imagen),
        Contact(4, "María", "García", "789123456", R.drawable.imagen),
        Contact(5, "Luis", "Martínez", "321654987", R.drawable.imagen),
        Contact(6, "Carmen", "Sánchez", "654987321", R.drawable.imagen),
        Contact(7, "Sofía", "Alvarez", "159753486", R.drawable.imagen),
        Contact(8, "Miguel", "Díaz", "258147369", R.drawable.imagen),
        Contact(9, "Lucía", "Hernández", "369258147", R.drawable.imagen),
        Contact(10, "Javier", "Flores", "951357486", R.drawable.imagen),
    )
}

@Preview(showBackground = true)
@Composable
fun ContactItemPreview() {
    ListasTheme {
        ContactItem(
            Contact(1, "Ana", "Pérez", "123456789", R.drawable.imagen)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ContactListPreview() {
    ListasTheme {
        ContactList(contacts = getContactList())
    }
}
