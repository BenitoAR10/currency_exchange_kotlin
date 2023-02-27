package arquitectura.software.demo_ce_kotlin.dao.Repository

import arquitectura.software.demo_ce_kotlin.dao.Currency
import org.springframework.data.jpa.repository.JpaRepository


interface CurrencyRepository: JpaRepository<Currency, Long>