package br.com.eduardosouza.applicationA.service

import br.com.eduardosouza.applicationA.dto.CompanyDTO
import br.com.eduardosouza.applicationA.dto.PartnerDTO
import br.com.eduardosouza.applicationA.events.listeners.AddCompanyEventListener
import br.com.eduardosouza.applicationA.events.listeners.DeleteCompanyEventListener
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.DatastoreEmulatorContainer
import org.testcontainers.junit.jupiter.Testcontainers
import org.testcontainers.utility.DockerImageName

@SpringBootTest
@Testcontainers
class CompanyServiceTest {

    @Autowired
    lateinit var companyService: CompanyService

    @MockBean
    lateinit var addListener: AddCompanyEventListener

    @MockBean
    lateinit var deleteListener: DeleteCompanyEventListener

    @Test
    fun testAddCompany() {
        val companyDTO = CompanyDTO(
            corporateName = "BLABLA CORPORATION",
            regNumber = "49844202000109",
            partners = listOf(
                PartnerDTO(
                    name = "John Doe",
                    itr = "01115300083"
                )
            )
        )

        val saved = companyService.save(companyDTO)

        Assertions.assertNotNull(saved.lastUpdate)

    }

    @Test
    fun testDeleteCompany() {

        val companyDTO = CompanyDTO(
            corporateName = "BLABLA CORPORATION",
            regNumber = "49844202000109",
            partners = listOf(
                PartnerDTO(
                    name = "John Doe",
                    itr = "01115300083"
                )
            )
        )

        val saved = companyService.save(companyDTO)

        Assertions.assertNotNull(saved.lastUpdate)

        companyService.remove(companyDTO.regNumber!!)

        val get = companyService.get(companyDTO.regNumber!!)

        Assertions.assertNull(get)


    }

    companion object {
        private val emulator = DatastoreEmulatorContainer(
            DockerImageName.parse("gcr.io/google.com/cloudsdktool/cloud-sdk:316.0.0-emulators")
        )

        @DynamicPropertySource
        fun datastoreProperties(registry: DynamicPropertyRegistry){
            registry.add("spring.cloud.gcp.datastore.emulator.enabled") { false }
            registry.add("spring.cloud.gcp.pubsub.emulator-host") { emulator.emulatorEndpoint }
        }
    }
}