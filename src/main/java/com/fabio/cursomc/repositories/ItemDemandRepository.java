package com.fabio.cursomc.repositories;

import com.fabio.cursomc.domain.ItemDemand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDemandRepository extends JpaRepository<ItemDemand,Integer> {

}
