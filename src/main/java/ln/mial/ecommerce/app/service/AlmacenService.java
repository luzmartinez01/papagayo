package ln.mial.ecommerce.app.service;

import ln.mial.ecommerce.infraestructure.entity.AlmacenEntity;

import java.util.List;
import ln.mial.ecommerce.app.repository.AlmacenRepository;

public class AlmacenService {
    private final AlmacenRepository warehouseRepository;

    public AlmacenService(AlmacenRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    public List<AlmacenEntity> getWarehouses() {
        return warehouseRepository.getWarehouses();
    }

    public AlmacenEntity getWarehouseById(Integer id) {
        return warehouseRepository.getWarehouseById(id);
    }

    public AlmacenEntity saveWarehouse(AlmacenEntity warehouseEntity) {
        return warehouseRepository.saveWarehouse(warehouseEntity);
    }

    public boolean deleteWarehouseById(Integer id) {
        return warehouseRepository.deleteWarehouseById(id);
    }
}
