package br.com.eduardosouza.applicationA.controller

import br.com.eduardosouza.applicationA.dto.EmpresaDTO
import br.com.eduardosouza.applicationA.service.EmpresaService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("empresa")
class EmpresaController(private val empresaService: EmpresaService) {

    @PostMapping("")
    fun salvar(@RequestBody empresaDTO: EmpresaDTO) =
        empresaService.salvar(empresaDTO)

    @GetMapping("/{cnpj}")
    fun recuperar(@PathVariable("cnpj") cnpj: String) =
        empresaService.recuperar(cnpj)

    @DeleteMapping("/{cnpj}")
    fun remover(@PathVariable("cnpj") cnpj: String) =
        empresaService.remover(cnpj)
}