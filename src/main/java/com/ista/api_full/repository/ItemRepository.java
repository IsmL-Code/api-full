package com.ista.api_full.repository;
import com.ista.api_full.entity.ItemFactura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ItemRepository extends JpaRepository<ItemFactura, Long > {
}
