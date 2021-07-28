package br.com.eduardosouza.applicationA.service

import br.com.eduardosouza.applicationA.dto.EmpresaDTO
import br.com.eduardosouza.applicationA.extensions.toDTO
import br.com.eduardosouza.applicationA.extensions.toModel
import br.com.eduardosouza.applicationA.repository.EmpresaRepository
import org.springframework.stereotype.Service

@Service
class EmpresaService(private val empresaRepository: EmpresaRepository) {

    fun salvar(empresaDTO: EmpresaDTO) {
        val empresa = empresaDTO.toModel()
        empresaRepository.save(empresa)
    }

    fun recuperar(cnpj: String) =
        empresaRepository.findById(cnpj).orElse(null)?.toDTO()

    fun remover(cnpj: String) =
        empresaRepository.deleteById(cnpj)
}