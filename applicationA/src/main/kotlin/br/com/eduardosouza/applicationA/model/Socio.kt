package br.com.eduardosouza.applicationA.model

import com.google.cloud.spring.data.datastore.core.mapping.Entity

@Entity
data class Socio(
    val nome: String? = "",
    val cpf: String? = ""
)
