package br.com.eduardosouza.applicationA.repository

import br.com.eduardosouza.applicationA.model.Empresa
import com.google.cloud.spring.data.datastore.repository.DatastoreRepository

interface EmpresaRepository : DatastoreRepository<Empresa, String> {
}