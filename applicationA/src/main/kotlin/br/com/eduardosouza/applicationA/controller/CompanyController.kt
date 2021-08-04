package br.com.eduardosouza.applicationA.controller

import br.com.eduardosouza.applicationA.dto.CompanyDTO
import br.com.eduardosouza.applicationA.service.CompanyService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("company")
class CompanyController(private val companyService: CompanyService) {

    @PostMapping("")
    fun save(@RequestBody companyDTO: CompanyDTO) =
        companyService.save(companyDTO)

    @GetMapping("/{regNumber}")
    fun get(@PathVariable("regNumber") regNumber: String) =
        companyService.get(regNumber)

    @DeleteMapping("/{regNumber}")
    fun remove(@PathVariable("regNumber") regNumber: String) =
        companyService.remove(regNumber)
}