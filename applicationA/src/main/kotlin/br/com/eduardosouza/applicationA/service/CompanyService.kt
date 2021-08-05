package br.com.eduardosouza.applicationA.service

import br.com.eduardosouza.applicationA.dto.CompanyDTO
import br.com.eduardosouza.applicationA.extensions.toDTO
import br.com.eduardosouza.applicationA.extensions.toModel
import br.com.eduardosouza.applicationA.model.Company
import br.com.eduardosouza.applicationA.repository.CompanyRepository
import org.springframework.stereotype.Service

@Service
class CompanyService(private val companyRepository: CompanyRepository) {

    fun save(companyDTO: CompanyDTO): Company {
        val company = companyDTO.toModel()
        return companyRepository.save(company)
    }

    fun get(regNumber: String) =
        companyRepository.findById(regNumber).orElse(null)?.toDTO()

    fun remove(regNumber: String) =
        companyRepository.deleteById(regNumber)
}