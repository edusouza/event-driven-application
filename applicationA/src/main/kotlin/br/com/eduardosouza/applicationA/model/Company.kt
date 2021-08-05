package br.com.eduardosouza.applicationA.model

import com.google.cloud.spring.data.datastore.core.mapping.Entity
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import java.util.*

@Entity
data class Company(
    @Id
    val regNumber: String? = "",
    val corporateName: String? = "",
    val partners: List<Partner> = emptyList(),
    @LastModifiedDate var lastUpdate: Date? = null
)
