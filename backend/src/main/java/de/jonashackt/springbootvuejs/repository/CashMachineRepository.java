package de.jonashackt.springbootvuejs.repository;

import de.jonashackt.springbootvuejs.model.CashMachine;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author aleksandr
 * @date 2019-01-26 22:17
 */

public interface CashMachineRepository extends JpaRepository<CashMachine, Long> {
}
