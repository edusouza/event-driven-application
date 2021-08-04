package br.com.eduardosouza.applicationA.model

import com.google.cloud.spring.data.datastore.core.mapping.Entity
import org.springframework.data.annotation.Id

@Entity
data class Company(
    @Id
    val regNumber: String? = "",
    val corporateName: String? = "",
    val partners: List<Partner> = emptyList()
)
