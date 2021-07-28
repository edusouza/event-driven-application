package br.com.eduardosouza.applicationA.extensions

import br.com.eduardosouza.applicationA.dto.EmpresaDTO
import br.com.eduardosouza.applicationA.dto.SocioDTO
import br.com.eduardosouza.applicationA.model.Empresa
import br.com.eduardosouza.applicationA.model.Socio

fun EmpresaDTO.toModel(): Empresa {
    return Empresa(
        razaoSocial = this.razaoSocial,
        cnpj = this.cnpj,
        socios = this.socios.toListModel()
    )
}

private fun List<SocioDTO>.toListModel() : List<Socio>  {
    return this.map {
        it.toModel()
    }.toList()
}

fun SocioDTO.toModel(): Socio {
    return Socio(
        cpf = this.cpf,
        nome = this.nome
    )
}

fun Empresa.toDTO(): EmpresaDTO {
    return EmpresaDTO(
        razaoSocial = this.razaoSocial,
        cnpj = this.cnpj,
        socios = this.socios.toListDTO()
    )
}

private fun List<Socio>.toListDTO(): List<SocioDTO> {
    return this.map {
        it.toDTO()
    }.toList()
}

fun Socio.toDTO(): SocioDTO {
    return SocioDTO(
        cpf = this.cpf,
        nome = this.nome
    )
}