package com.contract_manegement.business.management;

import com.contract_manegement.business.management.models.Contracts;
import com.contract_manegement.business.management.repositories.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class ScheduledTasks {

    @Autowired
    private ContractRepository repository;

    @Scheduled(cron = "0 * * * * *")
    public void monitorsContractActivity() {
        for(Contracts contracts : repository.findAll()){
            if (contracts.getStartDate().isBefore(contracts.getEndDate())){
                contracts.setActive(contracts.getEndDate().isAfter(LocalDate.now()));
            }
            repository.save(contracts);
        }
    }
}
