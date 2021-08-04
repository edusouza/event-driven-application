package br.com.eduardosouza.applicationA.repository

import br.com.eduardosouza.applicationA.model.Company
import com.google.cloud.spring.data.datastore.repository.DatastoreRepository

interface CompanyRepository : DatastoreRepository<Company, String> {
}