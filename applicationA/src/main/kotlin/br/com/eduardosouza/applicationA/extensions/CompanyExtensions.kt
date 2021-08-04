package br.com.eduardosouza.applicationA.extensions

import br.com.eduardosouza.applicationA.dto.CompanyDTO
import br.com.eduardosouza.applicationA.dto.PartnerDTO
import br.com.eduardosouza.applicationA.model.Company
import br.com.eduardosouza.applicationA.model.Partner

fun CompanyDTO.toModel(): Company {
    return Company(
        corporateName = this.corporateName,
        regNumber = this.regNumber,
        partners = this.partners.toListModel()
    )
}

private fun List<PartnerDTO>.toListModel() : List<Partner>  {
    return this.map {
        it.toModel()
    }.toList()
}

fun PartnerDTO.toModel(): Partner {
    return Partner(
        itr = this.itr,
        name = this.name
    )
}

fun Company.toDTO(): CompanyDTO {
    return CompanyDTO(
        corporateName = this.corporateName,
        regNumber = this.regNumber,
        partners = this.partners.toListDTO()
    )
}

private fun List<Partner>.toListDTO(): List<PartnerDTO> {
    return this.map {
        it.toDTO()
    }.toList()
}

fun Partner.toDTO(): PartnerDTO {
    return PartnerDTO(
        itr = this.itr,
        name = this.name
    )
}