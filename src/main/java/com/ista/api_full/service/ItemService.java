package com.ista.api_full.service;
import com.ista.api_full.entity.ItemFactura;
import com.ista.api_full.entity.Persona;
import com.ista.api_full.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemFactura postItemFactura(ItemFactura itemfactura){
        return itemRepository.save(itemfactura);
    }

    public List<ItemFactura> getAllItemFactura() {
        return  itemRepository.findAll();
    }

    public ItemFactura getItemFacturaById(Long id) {
        return  itemRepository.findById(id).orElse(null);
    }

    public ItemFactura updateItemFactura(ItemFactura itemfactura) {
        return itemRepository.save(itemfactura);
    }

    public void deletePersona(Long id) {
        itemRepository.deleteById(id);
    }
}
