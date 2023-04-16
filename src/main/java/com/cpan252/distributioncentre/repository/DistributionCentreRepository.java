package com.cpan252.distributioncentre.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cpan252.distributioncentre.model.DistributionCentre;

@Repository
public interface DistributionCentreRepository extends CrudRepository<DistributionCentre, Integer>{
    
}
