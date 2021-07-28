package br.com.eduardosouza.applicationA.dto

data class EmpresaDTO(
    val cnpj: String? = null,
    val razaoSocial: String? = null,
    val socios: List<SocioDTO> = emptyList()
)
