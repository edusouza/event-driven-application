package br.com.eduardosouza.applicationA.dto

data class CompanyDTO(
    val regNumber: String? = null,
    val corporateName: String? = null,
    val partners: List<PartnerDTO> = emptyList()
)
