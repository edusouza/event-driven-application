package br.com.eduardosouza.applicationA.model

import com.google.cloud.spring.data.datastore.core.mapping.Entity
import org.springframework.data.annotation.Id

@Entity
data class Empresa(
    @Id
    val cnpj: String? = "",
    val razaoSocial: String? = "",
    val socios: List<Socio> = emptyList()
)
