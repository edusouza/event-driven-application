package br.com.eduardosouza.applicationA.model

import com.google.cloud.spring.data.datastore.core.mapping.Entity

@Entity
data class Partner(
    val name: String? = "",
    val itr: String? = "" // Individual Taxpayer Registry
)
